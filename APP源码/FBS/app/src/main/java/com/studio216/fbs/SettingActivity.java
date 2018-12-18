package com.studio216.fbs;


import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SettingActivity extends Activity {
    private ActionBar actionBar;
    private ListView listView;
    private String[] stringArraySettingItem;
    private SharedPreferences sharedPreferences;
    private SimpleAdapter simpleAdapter;
    private List<HashMap<String, Object>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        init();
    }

    private String getIp() {
        sharedPreferences = getSharedPreferences("checkName",
                Context.MODE_PRIVATE);
        String ip = sharedPreferences.getString("serviceIp", "192.168.0.1");
        return ip;
    }

    /**
     * 初始化控件
     */
    private void init() {
        actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        stringArraySettingItem = new String[]{"清空缓存数据", "关于我们", "设置服务器IP(当前IP:" + getIp() + ")"};
        listView = (ListView) findViewById(R.id.activity_setting_list_view);
        list = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < stringArraySettingItem.length; i++) {
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            hashMap.put("itemText", stringArraySettingItem[i]);
            list.add(hashMap);
        }
        simpleAdapter = new SimpleAdapter(SettingActivity.this,
                list, R.layout.item_activity_setting_list_view,
                new String[]{"itemText"},
                new int[]{R.id.item_activity_setting_list_view_text_view});
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        Toast.makeText(SettingActivity.this, "缓存清空成功", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        AlertDialog.Builder builder = new AlertDialog.Builder(SettingActivity.this);
                        builder.setMessage("216工作是出品,联系方式:15620695505");
                        builder.setTitle("关于");
                        builder.setPositiveButton("确定", null);
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                        break;
                    case 2:
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(SettingActivity.this);
                        final EditText editText = new EditText(SettingActivity.this);
                        builder1.setTitle("请输入服务器IP地址");
                        builder1.setView(editText);
                        builder1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                if (editText.getText().toString().trim().equals("")) {
                                    Toast.makeText(SettingActivity.this, "ip地址不能为空", Toast.LENGTH_SHORT).show();
                                } else {
                                    sharedPreferences = getSharedPreferences("checkName",
                                            Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.putString("serviceIp", editText.getText().toString().trim());
                                    editor.commit();
                                    stringArraySettingItem = new String[]{"清空缓存数据", "关于我们", "设置服务器IP(当前IP:" + getIp() + ")"};
                                    list.clear();
                                    for (int j = 0; j < stringArraySettingItem.length; j++) {
                                        HashMap<String, Object> hashMap = new HashMap<String, Object>();
                                        hashMap.put("itemText", stringArraySettingItem[j]);
                                        list.add(hashMap);
                                    }
                                    simpleAdapter.notifyDataSetChanged();
                                }
                            }
                        });
                        builder1.setNegativeButton("取消", null);
                        AlertDialog alertDialog1 = builder1.create();
                        alertDialog1.show();
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
