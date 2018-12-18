package com.studio216.fbs;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.dtr.zxing.activity.CaptureActivity;
import com.studio216.fbs.Config.HttpConfig;
import com.studio216.fbs.Dao.OtherDao;
import com.studio216.fbs.DaoImpl.OtherDaoImpl;
import com.studio216.fbs.Utils.JsonUtils;
import com.studio216.fbs.database.CheckItem;
import com.studio216.fbs.service.CheckContentActivityHandle;

import net.tsz.afinal.FinalDb;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CheckContentActivity extends Activity {
    private ActionBar actionBar;
    private String placeString;
    private List<CheckItem> dbList;
    private ListView listView;
    private SharedPreferences sharedPreferences;
    private List<HashMap<String, Object>> list;
    private SimpleAdapter simpleAdapter;
    private OtherDao otherDao;
    private ProgressDialog progressDialog;
    private CheckContentActivityHandle checkContentActivityHandle;
    private List<CheckItem> surplusList;
    private final String[] from = {"dataName", "code"};
    private final int[] to = {R.id.item_activity_check_content_list_view_text_view_data_name,
            R.id.item_activity_check_content_list_view_text_view_code};
    private String checkName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_content);
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        FinalDb finalDb = FinalDb.create(this);
        dbList = finalDb.findAllByWhere(CheckItem.class, "checkName=\"" + checkName + "\"" + " and place=\"" + placeString + "\"");

        if (dbList.size() == 0) {
            findViewById(R.id.activity_check_content_text_view).setVisibility(View.VISIBLE);
            if (simpleAdapter != null && list != null) {
                list.clear();
                simpleAdapter.notifyDataSetChanged();
            }
        } else {
            findViewById(R.id.activity_check_content_text_view).setVisibility(View.GONE);
            if (list != null) {
                list.clear();
            } else {
                list = new ArrayList<HashMap<String, Object>>();
            }
            HashMap<String, Object> hashMap;
            for (int i = 0; i < dbList.size(); i++) {
                hashMap = new HashMap<String, Object>();
                hashMap.put(from[0], dbList.get(i).getDataName());
                hashMap.put(from[1], dbList.get(i).getCode());
                list.add(hashMap);
            }
            if (simpleAdapter == null) {
                simpleAdapter = new SimpleAdapter(this, list, R.layout.item_activity_check_content_list_view, from, to);
                listView.setAdapter(simpleAdapter);
            } else {
                simpleAdapter.notifyDataSetChanged();
            }
        }
    }

    private void init() {
        sharedPreferences = getSharedPreferences("checkName",
                Context.MODE_PRIVATE);
        checkName = sharedPreferences.getString("checkName", null);

        Intent intent = getIntent();
        placeString = intent.getStringExtra("place");
        actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("正在加载数据...");
        checkContentActivityHandle = new CheckContentActivityHandle(this, this);
        listView = (ListView) findViewById(R.id.activity_check_content_list_view);
        registerForContextMenu(listView);
        otherDao = new OtherDaoImpl(checkContentActivityHandle);
        if (placeString != null) {
            actionBar.setTitle("盘库位置:" + placeString);
        } else {
            Toast.makeText(this, "系统错误", Toast.LENGTH_SHORT).show();
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                progressDialog.show();
                otherDao.getTypeBy1Code(list.get(i).get(from[1]).toString());
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_check_content, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        switch (id) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_check:
                Intent intent = new Intent(CheckContentActivity.this, CaptureActivity.class);
                intent.putExtra("from", "checkConentActivity");
                intent.putExtra("place", placeString);
                startActivity(intent);
                return true;
            case R.id.action_tip:
                final ProgressDialog progressDialog1 = new ProgressDialog(CheckContentActivity.this);
                progressDialog1.setMessage("正在加载数据...");
                progressDialog1.show();
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        String url = HttpConfig.HOST + "Other/getCheckItemByPlace?place={placeString}";
                        RestTemplate restTemplate = new RestTemplate();
                        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
                        restTemplate.getMessageConverters().add(stringHttpMessageConverter);
                        String result;
                        result = restTemplate.getForObject(url, String.class, placeString);
                        try {
                            result = new String(result.getBytes("ISO-8859-1"), "utf-8");
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        ObjectMapper objectMapper = new ObjectMapper();
                        try {
                            List<CheckItem> allList;
                            allList = (List<CheckItem>) objectMapper.readValue(result, new JsonUtils(objectMapper)
                                    .getCollectionType(ArrayList.class, CheckItem.class));
                            allList.removeAll(dbList);
                            surplusList = allList;
                            Intent intent = new Intent(CheckContentActivity.this, SurplusActivity.class);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("surplusList", (Serializable) surplusList);
                            intent.putExtras(bundle);
                            progressDialog1.dismiss();
                            startActivity(intent);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public ProgressDialog getProgressDialog() {
        return progressDialog;
    }

    public void setProgressDialog(ProgressDialog progressDialog) {
        this.progressDialog = progressDialog;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu_check_content_activity, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item
                .getMenuInfo();
        switch (item.getItemId()) {
            case R.id.action_delete:
                deleteOneFromSqlLite(dbList.get((int) info.id));
                this.onResume();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void deleteOneFromSqlLite(CheckItem checkItem) {
        FinalDb finalDb = FinalDb.create(CheckContentActivity.this);
        finalDb.deleteByWhere(CheckItem.class, "code=\"" + checkItem.getCode() + "\" and checkName=\"" + checkItem.getCheckName() + "\"");
    }
}
