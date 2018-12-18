package com.studio216.fbs;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.studio216.fbs.database.CheckItem;

import net.tsz.afinal.FinalDb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class SummaryActivity extends Activity {
    private ListView listView;
    private ActionBar actionBar;
    private List<HashMap<String, Object>> list;
    private List<CheckItem> allCheckItem;
    private List<CheckItem> localAllCheckItem;
    private HashMap<String, List<CheckItem>> checkItemHashMapList;
    private List<String> placeList;
    private SharedPreferences sharedPreferences;
    private SimpleAdapter simpleAdapter;
    private String checkName;
    private final String[] from = {"place", "info"};
    private final int[] to = {R.id.item_activity_summary_list_view_text_view_place_name,
            R.id.item_activity_summary_list_view_text_view_lack_info};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        init();
    }

    private void init() {
        actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        sharedPreferences = getSharedPreferences("checkName",
                Context.MODE_PRIVATE);
        checkName = sharedPreferences.getString("checkName", null);
        listView = (ListView) findViewById(R.id.activity_summary_list_view);
        list = new ArrayList<HashMap<String, Object>>();
        allCheckItem = (List<CheckItem>) getIntent().getExtras().getSerializable("allCheckItem");
        checkItemHashMapList = new HashMap<String, List<CheckItem>>();
        placeList = new ArrayList<String>();
        getAllCheckItemFormSqlLite();
        allCheckItem.removeAll(localAllCheckItem);
        for (CheckItem checkItem : allCheckItem) {
            if (!placeList.contains(checkItem.getPlace())) {
                placeList.add(checkItem.getPlace());
                List<CheckItem> checkItems = new ArrayList<CheckItem>();
                checkItems.add(checkItem);
                checkItemHashMapList.put(checkItem.getPlace(), checkItems);
            } else {
                List<CheckItem> checkItems = checkItemHashMapList.get(checkItem.getPlace());
                checkItems.add(checkItem);
            }
        }
        Iterator<String> iterator = checkItemHashMapList.keySet().iterator();
        while (iterator.hasNext()) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            String place = iterator.next();
            map.put(from[0], "位置: " + place);
            map.put(from[1], "未入库书刊数量:" + checkItemHashMapList.get(place).size());
            list.add(map);
        }
        simpleAdapter = new SimpleAdapter(this, list, R.layout.item_activity_summary_list_view, from, to);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                HashMap<String, Object> map = list.get(i);
                String[] s = map.get(from[0]).toString().split(" ");
                String place = s[1];
                List<CheckItem> surplusList = checkItemHashMapList.get(place);
                Intent intent = new Intent(SummaryActivity.this, SurplusActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("surplusList", (Serializable) surplusList);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private void getAllCheckItemFormSqlLite() {
        FinalDb finalDb = FinalDb.create(this);
        localAllCheckItem = finalDb.findAllByWhere(CheckItem.class, "checkName=\"" + checkName + "\"");
    }    @Override
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
