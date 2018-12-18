package com.studio216.fbs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapCircleThumbnail;
import com.dtr.zxing.activity.CaptureActivity;
import com.studio216.fbs.Config.HttpConfig;

/**
 * 主界面Activity
 */
public class MainActivity extends Activity implements View.OnClickListener {
    private BootstrapCircleThumbnail bootstrapCircleThumbnails[];
    private int[] idOfBootstrapCircleThumbnails;
    private SharedPreferences sharedPreferences;
    private String tag = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        HttpConfig.setActivity(this);
    }

    /**
     * 初始化控件，设置BootstrapCircleThumbnail监听器
     */
    private void init() {
        bootstrapCircleThumbnails = new BootstrapCircleThumbnail[6];
        idOfBootstrapCircleThumbnails = new int[]{R.id.activity_main_bootstrap_circle_thumbnail1,
                R.id.activity_main_bootstrap_circle_thumbnail2,
                R.id.activity_main_bootstrap_circle_thumbnail3,
                R.id.activity_main_bootstrap_circle_thumbnail4,
                R.id.activity_main_bootstrap_circle_thumbnail5,
                R.id.activity_main_bootstrap_circle_thumbnail6,
        };
        for (int i = 0; i < idOfBootstrapCircleThumbnails.length; i++) {
            bootstrapCircleThumbnails[i] = (BootstrapCircleThumbnail) findViewById(idOfBootstrapCircleThumbnails[i]);
            bootstrapCircleThumbnails[i].setTag(i);
            bootstrapCircleThumbnails[i].setOnClickListener(this);
        }
    }

    /**
     * 监听器借口方法
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        BootstrapCircleThumbnail bootstrapCircleThumbnail = (BootstrapCircleThumbnail) view;
        int i = Integer.valueOf((Integer) bootstrapCircleThumbnail.getTag());
        Intent intent;
        switch (i) {
            case 0:
                intent = new Intent();
                intent.putExtra("from", "MainActivity");
                intent.setClass(MainActivity.this, CaptureActivity.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent();
                intent.setClass(MainActivity.this, AllCheckActivity.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent();
                intent.putExtra("from", "MainActivity");
                intent.setClass(MainActivity.this, CaptureActivity.class);
                startActivity(intent);
                break;
            case 3:
                intent = new Intent();
                intent.putExtra("from", "MainActivity");
                intent.setClass(MainActivity.this, CaptureActivity.class);
                startActivity(intent);
                break;
            case 4:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setItems(new String[]{"扫描条形码", "扫描ISBN"}, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i) {
                            case 0:
                                tag = "bar";
                                Intent intent;
                                intent = new Intent(MainActivity.this, ISBNActivity.class);
                                intent.putExtra("tag", tag);
                                startActivity(intent);
                                break;
                            case 1:
                                tag = "isbn";
                                intent = new Intent(MainActivity.this, ISBNActivity.class);
                                intent.putExtra("tag", tag);
                                startActivity(intent);
                                break;
                            default:
                                break;
                        }
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                break;
            case 5:
                intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    /**
     * 按下返回键
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            exit();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    /**
     * 提示对话框确认是否退出
     */

    private void exit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("确定退出?");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton("取消", null);
        builder.show();
    }

    public String getIp() {
        sharedPreferences = getSharedPreferences("checkName",
                Context.MODE_PRIVATE);
        String ip = sharedPreferences.getString("serviceIp", "192.168.0.1");
        return ip;
    }
}
