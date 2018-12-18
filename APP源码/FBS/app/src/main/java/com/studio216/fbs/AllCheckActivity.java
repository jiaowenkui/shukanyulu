package com.studio216.fbs;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.studio216.fbs.database.CheckInfo;
import com.studio216.fbs.database.CheckItem;

import net.tsz.afinal.FinalDb;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class AllCheckActivity extends Activity {
    private ActionBar actionBar;
    private ListView listView;
    private SimpleAdapter simpleAdapter;
    private FinalDb finalDb;
    private List<HashMap<String, Object>> list;
    private List<CheckInfo> dbList;
    private TextView textView;
    private final String[] from = {"checkName", "checkTime"};
    private final int[] to = {R.id.item_activity_setting_list_view_text_view_check_name,
            R.id.item_activity_setting_list_view_text_view_check_time};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_check);
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        finalDb = FinalDb.create(AllCheckActivity.this);
        textView = (TextView) findViewById(R.id.activity_all_check_text_view_label);
        listView = (ListView) findViewById(R.id.activity_all_check_list_view);
        dbList = finalDb.findAll(CheckInfo.class);
        list = new ArrayList<HashMap<String, Object>>();
        simpleAdapter = new SimpleAdapter(this, list, R.layout.item_activity_all_check_list_view, from, to);
        if (dbList.size() == 0) {
            textView.setVisibility(View.VISIBLE);
        } else {
            setAllCheckInfoFormSqlLite();
            textView.setVisibility(View.GONE);
        }
        listView.setAdapter(simpleAdapter);
        setListListener();
        registerForContextMenu(listView);
    }

    private void init() {
        actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_all_check, menu);
        return true;
    }


    private void setAllCheckInfoFormSqlLite() {
        HashMap<String, Object> map;
        list.clear();
        for (int i = 0; i < dbList.size(); i++) {
            map = new HashMap<String, Object>();
            map.put(from[0], dbList.get(i).getCheckName());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm");
            map.put(from[1], simpleDateFormat.format(dbList.get(i).getCheckTime()));
            list.add(map);
        }
    }

    private void getAllCheckInfoFormSqlLite() {
        dbList = finalDb.findAll(CheckInfo.class);
    }

    private void setListListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(AllCheckActivity.this, CheckActivity.class);
                HashMap<String, Object> hashMap = list.get(i);
                intent.putExtra("checkName", hashMap.get("checkName").toString());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu_all_check_activity, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item
                .getMenuInfo();
        switch (item.getItemId()) {
            case R.id.action_delete:
                deleteFromSqlLite(list.get((int) info.id).get(from[0]).toString());
                this.onResume();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void deleteFromSqlLite(String s) {
        finalDb.deleteById(CheckInfo.class, s);
        finalDb.deleteByWhere(CheckItem.class, "checkName=\"" + s + "\"");
        this.onResume();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_new_check:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                final EditText editText = new EditText(this);
                editText.setHint("如:2015年盘库");
                builder.setTitle("请输入盘库名称");
                builder.setView(editText);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (editText.getText().toString().trim().equals("")) {
                            Toast.makeText(AllCheckActivity.this, "名称不能为空", Toast.LENGTH_SHORT).show();
                        } else {
                            CheckInfo checkInfo = new CheckInfo(editText.getText().toString());
                            finalDb.save(checkInfo);
                            getAllCheckInfoFormSqlLite();
                            setAllCheckInfoFormSqlLite();
                            simpleAdapter.notifyDataSetChanged();
                            textView.setVisibility(View.GONE);
                        }
                    }
                });
                builder.setNegativeButton("取消", null);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
