package com.studio216.fbs;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;


public class BorrowBookActivity extends Activity {
    private BootstrapEditText bootstrapEditText;
    private BootstrapButton bootstrapButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrow_book);
        init();
    }

    private void init() {
        bootstrapEditText = (BootstrapEditText) findViewById(R.id.activity_borrow_book_edit_text_reader_name);
        bootstrapButton = (BootstrapButton) findViewById(R.id.activity_borrow_button);
        bootstrapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BorrowBookActivity.this, "该读者不存在", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
