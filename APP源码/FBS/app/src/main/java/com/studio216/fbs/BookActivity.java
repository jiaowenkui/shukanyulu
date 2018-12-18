package com.studio216.fbs;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.studio216.fbs.Config.HttpConfig;
import com.studio216.fbs.bean.Book;
import com.studio216.fbs.database.CheckItem;

import net.tsz.afinal.FinalBitmap;
import net.tsz.afinal.FinalDb;

import java.util.List;

public class BookActivity extends Activity {
    private ActionBar actionBar;
    private ImageView bookImage;
    private TextView bookInfo;
    private TextView bookName;
    private BootstrapButton bootstrapButtonCheckBook;
    private BootstrapButton bootstrapButtonBorrowBook;
    private BootstrapButton bootstrapButtonBackBook;
    private SharedPreferences sharedPreferences;
    private Book book;
    private String from;
    private String checkName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        init();
        setButtonListener();
    }

    private void setButtonListener() {
        bootstrapButtonCheckBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((from.equals("check") || from.equals("checkContent")) && !bootstrapButtonCheckBook.getText().equals("已入库")) {
                    if (checkName != null) {
                        FinalDb finalDb = FinalDb.create(BookActivity.this);
                        CheckItem checkItem = new CheckItem();
                        checkItem.setDataName(book.getBookname());
                        checkItem.setCode(book.getBook1DCode());
                        checkItem.setCheckName(checkName);
                        checkItem.setPlace(book.getBookplace());
                        checkItem.setStatus(book.getBookIsBorrow());
                        finalDb.save(checkItem);
                        bootstrapButtonCheckBook.setText("已入库");
                    } else {
                        Toast.makeText(BookActivity.this, "系统错误", Toast.LENGTH_SHORT).show();
                    }
                }
                if (from.equals("search")) {
                    Toast.makeText(BookActivity.this, "请返回主菜单点击'盘库'进行入库操作", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bootstrapButtonBorrowBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookActivity.this, BorrowBookActivity.class);
                startActivity(intent);
            }
        });
        bootstrapButtonBackBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BookActivity.this, "为保证信息完整,请到网页版进行还书操作", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        bookImage = (ImageView) findViewById(R.id.activity_book_image_view);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;
        ViewGroup.LayoutParams para;
        para = bookImage.getLayoutParams();
        para.width = width / 2;
        para.height = width / 2;
        bookImage.setLayoutParams(para);
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
        book = (Book) getIntent().getExtras().getSerializable("book");
        bookInfo = (TextView) findViewById(R.id.activity_book_text_view2);
        bookInfo.setText(book.toString());
        bookImage = (ImageView) findViewById(R.id.activity_book_image_view);
        FinalBitmap finalBitmap = FinalBitmap.create(this);
        Log.d("test", HttpConfig.IMAGE + book.getBookImage());
        finalBitmap.display(bookImage, HttpConfig.IMAGE + book.getBookImage());
        bookName = (TextView) findViewById(R.id.activity_book_text_view1);
        bookName.setText(book.getBookname());
        bootstrapButtonCheckBook = (BootstrapButton) findViewById(R.id.activity_book_button_check_book);
        bootstrapButtonBorrowBook = (BootstrapButton) findViewById(R.id.activity_book_button_borrow_book);
        bootstrapButtonBackBook = (BootstrapButton) findViewById(R.id.activity_book_button_back_book);
        FinalDb finalDb = FinalDb.create(BookActivity.this);
        List<CheckItem> list = finalDb.findAllByWhere(CheckItem.class, "code=\"" + book.getBook1DCode() + "\" and checkName=\"" + checkName + "\"");
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
