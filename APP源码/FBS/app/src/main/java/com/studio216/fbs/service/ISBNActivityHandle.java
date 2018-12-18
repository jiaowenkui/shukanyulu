package com.studio216.fbs.service;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.studio216.fbs.BookActivity;
import com.studio216.fbs.Config.HttpConfig;
import com.studio216.fbs.Dao.BookDao;
import com.studio216.fbs.Dao.InternalDataDao;
import com.studio216.fbs.Dao.MagazineDao;
import com.studio216.fbs.DaoImpl.BookDaoImpl;
import com.studio216.fbs.DaoImpl.InternalDataDaoImpl;
import com.studio216.fbs.DaoImpl.MagazineDaoImpl;
import com.studio216.fbs.ISBNActivity;
import com.studio216.fbs.InternalDataActivity;
import com.studio216.fbs.MagazineActivity;
import com.studio216.fbs.bean.Book;
import com.studio216.fbs.bean.InternalData;
import com.studio216.fbs.bean.Magazine;

/**
 * Created by Book on 2015/2/16.
 */
public class ISBNActivityHandle extends Handler {
    private Context context;
    private ISBNActivity activity;

    public ISBNActivityHandle(Context context, ISBNActivity activity) {
        this.context = context;
        this.activity = activity;
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        Bundle bundle;
        Bundle bundle1;
        Intent intent;
        ProgressDialog progressDialog = activity.getProgressDialog();
        switch (msg.what) {
            case 1:
                bundle = (Bundle) msg.obj;
                String type = bundle.getString("type");
                if (type.equals("1")) {
                    Toast.makeText(activity,bundle.getString("code"),Toast.LENGTH_LONG).show();
                    BookDao bookDao = new BookDaoImpl(this);
                    bookDao.getBookBy1DCode(bundle.getString("code"));
                } else if (type.equals("2")) {
                    MagazineDao magazineDao = new MagazineDaoImpl(this);
                    magazineDao.getMagazineDaoBy1DCode(bundle.getString("code"));

                } else if (type.equals("3")) {
                    InternalDataDao internalDataDao = new InternalDataDaoImpl(this);
                    internalDataDao.getInternalDataBy1DCode(bundle.getString("code"));

                } else if (type.equals("0")) {
                    Toast.makeText(context, "不存在该书刊", Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                } else {
                    Toast.makeText(context, HttpConfig.HTTP_ERROR_TIP, Toast.LENGTH_LONG).show();
                }
                break;
            case BookDaoImpl.BOOK_DAO_MESSAGE_WHAT:
                bundle = (Bundle) msg.obj;
                Book book = (Book) bundle.getSerializable("book");
                bundle.putSerializable("book", book);
                Toast.makeText(activity,book.toString(),Toast.LENGTH_LONG).show();
                intent = new Intent(context, BookActivity.class);
                intent.putExtra("from", "search");
                intent.putExtras(bundle);
                progressDialog.dismiss();
                context.startActivity(intent);
                break;
            case MagazineDaoImpl.MAGAZINE_DAO_MESSAGE_WHAT:
                bundle = (Bundle) msg.obj;
                Magazine magazine = (Magazine) bundle.getSerializable("magazine");
                bundle.putSerializable("magazine", magazine);
                intent = new Intent(context, MagazineActivity.class);
                intent.putExtra("from", "search");
                intent.putExtras(bundle);
                progressDialog.dismiss();
                context.startActivity(intent);
                break;
            case InternalDataDaoImpl.INTERNAL_DATA_DAO_MESSAGE_WHAT:
                bundle = (Bundle) msg.obj;
                InternalData internalData = (InternalData) bundle.getSerializable("internalData");
                bundle.putSerializable("internalData", internalData);
                intent = new Intent(context, InternalDataActivity.class);
                intent.putExtra("from", "search");
                intent.putExtras(bundle);
                progressDialog.dismiss();
                context.startActivity(intent);
                break;
            default:
                break;
        }
    }
}
