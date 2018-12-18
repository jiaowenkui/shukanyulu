package com.studio216.fbs;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.studio216.fbs.Config.HttpConfig;
import com.studio216.fbs.Dao.PlaceDao;
import com.studio216.fbs.DaoImpl.PlaceDaoImpl;
import com.studio216.fbs.Utils.JsonUtils;
import com.studio216.fbs.database.CheckItem;
import com.studio216.fbs.service.CheckActivityHandle;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class CheckActivity extends Activity {
    private ActionBar actionBar;
    private BootstrapButton bootstrapButton1;
    private BootstrapButton bootstrapButton2;
    private CheckActivityHandle checkActivityHandle;
    private PlaceDao placeDao;
    private String[] placeNamesArray;
    private ProgressDialog progressDialog;
    private AlertDialog.Builder builder;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String checkName;

    public CheckActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        init();
        setButtonListener();
    }

    private void setButtonListener() {
        bootstrapButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (placeNamesArray != null) {
                    builder.show();
                } else {
                    Toast.makeText(CheckActivity.this, "数据尚未加载完成", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        bootstrapButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bootstrapButton1.getText().equals("选择书架") || bootstrapButton1.getTag() == null) {
                    Toast.makeText(CheckActivity.this, "请先选择书架", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(CheckActivity.this, CheckContentActivity.class);
                    intent.putExtra("place", bootstrapButton1.getTag().toString());
                    startActivity(intent);
                }
            }
        });
    }

    /**
     * 初始化控件
     */
    private void init() {
        checkName = getIntent().getStringExtra("checkName");
        sharedPreferences = getSharedPreferences("checkName",
                Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("checkName", checkName);
        editor.commit();
        actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        bootstrapButton1 = (BootstrapButton) findViewById(R.id.activity_check_button1);
        bootstrapButton2 = (BootstrapButton) findViewById(R.id.activity_check_button2);
        checkActivityHandle = new CheckActivityHandle(this, this);
        placeDao = new PlaceDaoImpl(checkActivityHandle);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("正在加载数据...");
        progressDialog.show();
        builder = new AlertDialog.Builder(CheckActivity.this);
        placeDao.getAllPlaceNames();
    }


    public String[] getPlaceNamesArray() {
        return placeNamesArray;
    }

    public void setPlaceNamesArray(String[] placeNamesArray) {
        this.placeNamesArray = placeNamesArray;
    }

    public ProgressDialog getProgressDialog() {
        return progressDialog;
    }

    public void setProgressDialog(ProgressDialog progressDialog) {
        this.progressDialog = progressDialog;
    }

    public AlertDialog.Builder getBuilder() {
        return builder;
    }

    public void setBuilder(AlertDialog.Builder builder) {
        this.builder = builder;
    }

    public BootstrapButton getBootstrapButton1() {
        return bootstrapButton1;
    }

    public void setBootstrapButton1(BootstrapButton bootstrapButton1) {
        this.bootstrapButton1 = bootstrapButton1;
    }

    public BootstrapButton getBootstrapButton2() {
        return bootstrapButton2;
    }

    public void setBootstrapButton2(BootstrapButton bootstrapButton2) {
        this.bootstrapButton2 = bootstrapButton2;
    }

    public CheckActivityHandle getCheckActivityHandle() {
        return checkActivityHandle;
    }

    public void setCheckActivityHandle(CheckActivityHandle checkActivityHandle) {
        this.checkActivityHandle = checkActivityHandle;
    }

    public PlaceDao getPlaceDao() {
        return placeDao;
    }

    public void setPlaceDao(PlaceDao placeDao) {
        this.placeDao = placeDao;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_check, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_huizonhg:
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        String url = HttpConfig.HOST + "Other/getCheckItemByPlace?place={placeString}";
                        RestTemplate restTemplate = new RestTemplate();
                        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
                        restTemplate.getMessageConverters().add(stringHttpMessageConverter);
                        String result;
                        result = restTemplate.getForObject(url, String.class, "*");
                        try {
                            result = new String(result.getBytes("ISO-8859-1"), "utf-8");
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        ObjectMapper objectMapper = new ObjectMapper();
                        try {
                            List<CheckItem> allCheckItem;
                            allCheckItem = (List<CheckItem>) objectMapper.readValue(result, new JsonUtils(objectMapper)
                                    .getCollectionType(ArrayList.class, CheckItem.class));
                            Intent intent = new Intent(CheckActivity.this, SummaryActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("allCheckItem", (Serializable) allCheckItem);
                            intent.putExtras(bundle);
                            startActivity(intent);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        progressDialog.dismiss();
                    }
                };
                progressDialog.show();
                thread.start();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
