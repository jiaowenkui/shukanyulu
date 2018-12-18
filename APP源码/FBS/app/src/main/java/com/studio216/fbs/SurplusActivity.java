package com.studio216.fbs;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.studio216.fbs.Dao.OtherDao;
import com.studio216.fbs.DaoImpl.OtherDaoImpl;
import com.studio216.fbs.database.CheckItem;
import com.studio216.fbs.service.SurplusActivityHandle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class SurplusActivity extends Activity {
    private ListView listView;
    private List<CheckItem> surplusList;
    private List<HashMap<String, Object>> list;
    private SimpleAdapter simpleAdapter;
    private SurplusActivityHandle surplusActivityHandle;
    private OtherDao otherDao;
    private ProgressDialog progressDialog;
    private final String[] from = {"dataName", "code"};
    private final int[] to = {R.id.item_activity_surplus_list_view_text_view_data_name, R.id.item_activity_surplus_list_view_text_view_code};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surplus);
        init();
    }

    private void init() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("正在加载数据...");
        surplusList = (List<CheckItem>) getIntent().getExtras().getSerializable("surplusList");
        listView = (ListView) findViewById(R.id.activity_surplus_list_view);
        list = new ArrayList<HashMap<String, Object>>();
        simpleAdapter = new SimpleAdapter(this, list, R.layout.item_activity_surplus_list_view, from, to);
        for (CheckItem checkItem : surplusList) {
            HashMap hashMap = new HashMap();
            hashMap.put(from[0], checkItem.getDataName() + "(" + checkItem.getStatus().trim() + ")");
            hashMap.put(from[1], checkItem.getCode());
            list.add(hashMap);
        }
        surplusActivityHandle = new SurplusActivityHandle(this, this);
        otherDao = new OtherDaoImpl(surplusActivityHandle);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                progressDialog.show();
                otherDao.getTypeBy1Code(list.get(i).get(from[1]).toString());
            }
        });
    }

    public ProgressDialog getProgressDialog() {
        return progressDialog;
    }

    public void setProgressDialog(ProgressDialog progressDialog) {
        this.progressDialog = progressDialog;
    }
}
