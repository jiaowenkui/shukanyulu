package com.studio216.fbs;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.studio216.fbs.Config.HttpConfig;
import com.studio216.fbs.bean.Magazine;
import com.studio216.fbs.database.CheckItem;

import net.tsz.afinal.FinalBitmap;
import net.tsz.afinal.FinalDb;

import java.util.List;


public class MagazineActivity extends Activity {
    private ActionBar actionBar;
    private ImageView magazineImage;
    private TextView magazineInfo;
    private TextView magazineName;
    private BootstrapButton bootstrapButtonCheckBook;
    private BootstrapButton bootstrapButtonBorrowBook;
    private BootstrapButton bootstrapButtonBackBook;
    private Magazine magazine;
    private String from;
    private SharedPreferences sharedPreferences;
    private String checkName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magazine);
        init();
        setButtonListener();
    }

    private void setButtonListener() {
        bootstrapButtonCheckBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (from.equals("check") && !bootstrapButtonCheckBook.getText().equals("已入库")) {
                    if (checkName != null) {
                        FinalDb finalDb = FinalDb.create(MagazineActivity.this);
                        CheckItem checkItem = new CheckItem();
                        checkItem.setDataName(magazine.getMagazineName());
                        checkItem.setCode(magazine.getMagazine1DCode());
                        checkItem.setCheckName(checkName);
                        checkItem.setPlace(magazine.getMagazinePlace());
                        checkItem.setStatus(magazine.getMagazineIsBorrow());
                        finalDb.save(checkItem);
                        bootstrapButtonCheckBook.setText("已入库");
                    } else {
                        Toast.makeText(MagazineActivity.this, "系统错误", Toast.LENGTH_SHORT).show();
                    }
                } else if (from.equals("search")) {
                    Toast.makeText(MagazineActivity.this, "请返回主菜单点击'盘库'进行入库操作", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bootstrapButtonBorrowBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MagazineActivity.this, BorrowBookActivity.class);
                startActivity(intent);
            }
        });
        bootstrapButtonBackBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MagazineActivity.this, "为保证信息完整,请到网页版进行还书操作", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        magazineImage = (ImageView) findViewById(R.id.activity_magazine_image_view);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;
        ViewGroup.LayoutParams para;
        para = magazineImage.getLayoutParams();
        para.width = width / 2;
        para.height = width / 2;
        magazineImage.setLayoutParams(para);
    }

    /**
     * 初始化控件
     */
    private void init() {
        from = getIntent().getStringExtra("from");
        sharedPreferences = getSharedPreferences("checkName",
                Context.MODE_PRIVATE);
        checkName = sharedPreferences.getString("checkName", null);
        if (from == null) {
            Toast.makeText(this, "系统错误", Toast.LENGTH_SHORT).show();
        }
        actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        magazine = (Magazine) getIntent().getExtras().getSerializable("magazine");
        magazineInfo = (TextView) findViewById(R.id.activity_magazine_text_view2);
        magazineInfo.setText(magazine.toString());
        magazineName = (TextView) findViewById(R.id.activity_magazine_text_view1);
        magazineName.setText(magazine.getMagazineName());
        bootstrapButtonCheckBook = (BootstrapButton) findViewById(R.id.activity_magazine_button_check_book);
        bootstrapButtonBorrowBook = (BootstrapButton) findViewById(R.id.activity_magazine_button_borrow_book);
        bootstrapButtonBackBook = (BootstrapButton) findViewById(R.id.activity_magazine_button_back_book);
        magazineImage = (ImageView) findViewById(R.id.activity_magazine_image_view);
        FinalBitmap finalBitmap = FinalBitmap.create(this);
//        finalBitmap.display(magazineImage, HttpConfig.IMAGE + magazine.getMagazineImage());
        finalBitmap.display(magazineImage, HttpConfig.IMAGE + magazine.getMagazineImage());
        FinalDb finalDb = FinalDb.create(MagazineActivity.this);
        List<CheckItem> list = finalDb.findAllByWhere(CheckItem.class, "code=\"" + magazine.getMagazine1DCode() + "\" and checkName=\"" + checkName + "\"");
        if (list.size() > 0) {
            bootstrapButtonCheckBook.setText("已入库");
        }
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
