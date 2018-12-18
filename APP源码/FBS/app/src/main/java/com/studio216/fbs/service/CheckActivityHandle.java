package com.studio216.fbs.service;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.studio216.fbs.CheckActivity;
import com.studio216.fbs.DaoImpl.PlaceDaoImpl;
import com.studio216.fbs.bean.Place;

import java.util.List;

/**
 * Created by Book on 2015/1/26.
 */
public class CheckActivityHandle extends Handler {
    private Context context;
    private CheckActivity activity;
    private String[] placeNamesArray;

    public CheckActivityHandle(Context context, CheckActivity activity) {
        this.context = context;
        this.activity = activity;
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        Bundle bundle;
        switch (msg.what) {
            case PlaceDaoImpl.PLACE_DAO_GET_ALL_PLACE_NAME:
                AlertDialog.Builder builder = activity.getBuilder();
                bundle = (Bundle) msg.obj;
                List<Place> list = (List<Place>) bundle.getSerializable("places");
                placeNamesArray = new String[list.size()];
                int i = 0;
                for (Place place : list) {
                    placeNamesArray[i] = place.getPlace();
                    i++;
                }
                activity.setPlaceNamesArray(placeNamesArray);

                builder.setItems(placeNamesArray, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        activity.getBootstrapButton1().setText("已选择:" + placeNamesArray[i]);
                        activity.getBootstrapButton1().setTag(placeNamesArray[i]);
                    }
                });
                activity.getProgressDialog().dismiss();
                break;
            default:
                break;
        }
    }
}
