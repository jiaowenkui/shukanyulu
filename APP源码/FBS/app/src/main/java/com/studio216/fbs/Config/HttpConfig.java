package com.studio216.fbs.Config;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.studio216.fbs.MainActivity;

/**
 * Created by Book on 2015/1/19.
 */
public class HttpConfig {
    public static String HTTP_ERROR_TIP = "网络错误,请检查网络连接";
    public static MainActivity activity;
    public static String URL;
    public static String IMAGE;
    public static String HOST;

    public static void showHttpError(Context context) {
        Toast.makeText(context, HTTP_ERROR_TIP, Toast.LENGTH_SHORT).show();
    }

    public static void setActivity(MainActivity activity) {
        HttpConfig.activity = activity;
        URL = "http://" + activity.getIp()+":8080";
        IMAGE = URL + "/service/";
        HOST = URL + "/service/webapi/";
    }
}
