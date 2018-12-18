package com.studio216.fbs.service;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

import com.dtr.zxing.activity.CaptureActivity;
import com.studio216.fbs.BookActivity;
import com.studio216.fbs.Config.HttpConfig;
import com.studio216.fbs.Dao.BookDao;
import com.studio216.fbs.Dao.InternalDataDao;
import com.studio216.fbs.Dao.MagazineDao;
import com.studio216.fbs.DaoImpl.BookDaoImpl;
import com.studio216.fbs.DaoImpl.InternalDataDaoImpl;
import com.studio216.fbs.DaoImpl.MagazineDaoImpl;
import com.studio216.fbs.InternalDataActivity;
import com.studio216.fbs.MagazineActivity;
import com.studio216.fbs.bean.Book;
import com.studio216.fbs.bean.InternalData;
import com.studio216.fbs.bean.Magazine;

/**
 * Created by Book on 2015/1/22.
 */
public class CaptureActivityHandle extends Handler {
    private Context context;
    private CaptureActivity activity;

    public CaptureActivityHandle(Context context, CaptureActivity activity) {
        this.context = context;
        this.activity = activity;
    }

    @Override
    public void handleMessage(Message msg) {
        Bundle bundle;
        Intent intent;
        ProgressDialog progressDialog = activity.getProgressDialog();
        switch (msg.what) {
            case 1:
                bundle = (Bundle) msg.obj;
                String type = bundle.getString("type");
                if (type.equals("1")) {
                    BookDao bookDao = new BookDaoImpl(this);
                    bookDao.getBookBy1DCode(bundle.getString("code"));
                } else if (type.equals("2")) {
                    MagazineDao magazineDao = new MagazineDaoImpl(this);
                    magazineDao.getMagazineDaoBy1DCode(bundle.getString("code"));

                } else if (type.equals("3")) {
                    InternalDataDao internalDataDao = new InternalDataDaoImpl(this);
                    internalDataDao.getInternalDataBy1DCode(bundle.getString("code"));

                } else if (type.equals("0")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("条码无效");
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            activity.myOnResume();
                        }
                    });
                    progressDialog.dismiss();
                    builder.show();
                } else {
                    Toast.makeText(context, HttpConfig.HTTP_ERROR_TIP, Toast.LENGTH_LONG).show();
                    activity.myOnResume();
                }
                break;
            case BookDaoImpl.BOOK_DAO_MESSAGE_WHAT:
                bundle = (Bundle) msg.obj;
                Book book = (Book) bundle.getSerializable("book");
                if (book.getBookplace()!=null&&(!book.getBookplace().equals(activity.getActionBar().getTitle())) && activity.getFrom().equals("checkConentActivity")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("该书刊位置为:" + book.getBookplace() + ",不属于当前盘库位置");
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            activity.finish();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
                        @Override
                        public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                            if (keyCode == KeyEvent.KEYCODE_SEARCH) {
                                return true;
                            } else {
                                return false; //默认返回 false
                            }
                        }
                    });
                    alertDialog.setCancelable(false);
                    progressDialog.dismiss();
                    alertDialog.show();
                } else if (activity.getFrom().equals("MainActivity")) {
                    bundle.putSerializable("book", book);
                    intent = new Intent(context, BookActivity.class);
                    intent.putExtra("from", "search");
                    intent.putExtras(bundle);
                    progressDialog.dismiss();
                    context.startActivity(intent);
                } else {
                    bundle.putSerializable("book", book);
                    intent = new Intent(context, BookActivity.class);
                    intent.putExtra("from", "check");
                    intent.putExtras(bundle);
                    progressDialog.dismiss();
                    context.startActivity(intent);
                }
                break;
            case MagazineDaoImpl.MAGAZINE_DAO_MESSAGE_WHAT:
                bundle = (Bundle) msg.obj;
                Magazine magazine = (Magazine) bundle.getSerializable("magazine");
                if (magazine.getMagazinePlace()!=null&&(!magazine.getMagazinePlace().equals(activity.getActionBar().getTitle())) && activity.getFrom().equals("checkConentActivity")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("该书刊位置为:" + magazine.getMagazinePlace() + ",不属于当前盘库位置");
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            activity.finish();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
                        @Override
                        public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                            if (keyCode == KeyEvent.KEYCODE_SEARCH) {
                                return true;
                            } else {
                                return false; //默认返回 false
                            }
                        }
                    });
                    alertDialog.setCancelable(false);
                    progressDialog.dismiss();
                    alertDialog.show();
                } else if (activity.getFrom() == "MainActivity") {
                    bundle.putSerializable("magazine", magazine);
                    intent = new Intent(context, MagazineActivity.class);
                    intent.putExtra("from", "search");
                    intent.putExtras(bundle);
                    progressDialog.dismiss();
                    context.startActivity(intent);
                } else {
                    bundle.putSerializable("magazine", magazine);
                    intent = new Intent(context, MagazineActivity.class);
                    intent.putExtra("from", "check");
                    intent.putExtras(bundle);
                    progressDialog.dismiss();
                    context.startActivity(intent);
                }
                break;
            case InternalDataDaoImpl.INTERNAL_DATA_DAO_MESSAGE_WHAT:
                bundle = (Bundle) msg.obj;
                InternalData internalData = (InternalData) bundle.getSerializable("internalData");
                if (internalData.getInterPlace()!=null&&(!internalData.getInterPlace().equals(activity.getActionBar().getTitle())) && activity.getFrom().equals("checkConentActivity")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setMessage("该书刊位置为:" + internalData.getInterPlace() + ",不属于当前盘库位置");
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            activity.finish();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
                        @Override
                        public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                            if (keyCode == KeyEvent.KEYCODE_SEARCH) {
                                return true;
                            } else {
                                return false; //默认返回 false
                            }
                        }
                    });
                    alertDialog.setCancelable(false);
                    progressDialog.dismiss();
                    alertDialog.show();
                } else if (activity.getFrom() == "MainActivity") {
                    bundle.putSerializable("internalData", internalData);
                    intent = new Intent(context, InternalDataActivity.class);
                    intent.putExtra("from", "search");
                    intent.putExtras(bundle);
                    progressDialog.dismiss();
                    context.startActivity(intent);
                } else {
                    bundle.putSerializable("internalData", internalData);
                    intent = new Intent(context, InternalDataActivity.class);
                    intent.putExtra("from", "check");
                    intent.putExtras(bundle);
                    progressDialog.dismiss();
                    context.startActivity(intent);
                }
                break;
            default:
                break;
        }
    }
}
