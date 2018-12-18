package com.studio216.fbs;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.studio216.fbs.Dao.OtherDao;
import com.studio216.fbs.DaoImpl.OtherDaoImpl;
import com.studio216.fbs.service.ISBNActivityHandle;


public class ISBNActivity extends Activity {
    private ActionBar actionBar;
    private BootstrapEditText bootstrapEditText;
    private BootstrapButton bootstrapButton;
    private ProgressDialog progressDialog;
    private OtherDao otherDao;
    private ISBNActivityHandle isbnActivityHandle;
    private String tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isbn);
        init();
        search();
    }

    private void search() {
        bootstrapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t = bootstrapEditText.getText().toString().trim();
                if (t.equals("") || t == null) {
                    Toast.makeText(ISBNActivity.this, "ISBN号不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    progressDialog.show();
                    if (tag.equals("isbn"))
                        otherDao.getTypeByISBN(t);
                    else
                        otherDao.getTypeBy1Code(t);
                }
            }
        });
    }

    private void init() {
        actionBar = getActionBar();
        bootstrapEditText = (BootstrapEditText) findViewById(R.id.activity_isbn_edit_text);
        actionBar.setDisplayHomeAsUpEnabled(true);
        tag = getIntent().getStringExtra("tag");
        if (tag.equals("isbn")) {
            actionBar.setTitle("ISBN条码枪查询");
        } else {
            actionBar.setTitle("条形码条码枪查询");
            bootstrapEditText.setHint("条形码号");
        }
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("正在加载数据...");
        bootstrapButton = (BootstrapButton) findViewById(R.id.activity_isbn_button);
        isbnActivityHandle = new ISBNActivityHandle(this, this);
        otherDao = new OtherDaoImpl(isbnActivityHandle);
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

    public BootstrapButton getBootstrapButton() {
        return bootstrapButton;
    }

    public void setBootstrapButton(BootstrapButton bootstrapButton) {
        this.bootstrapButton = bootstrapButton;
    }

    public ProgressDialog getProgressDialog() {
        return progressDialog;
    }

    public void setProgressDialog(ProgressDialog progressDialog) {
        this.progressDialog = progressDialog;
    }
}
