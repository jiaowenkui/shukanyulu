package com.studio216.fbs.DaoImpl;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.studio216.fbs.Config.HttpConfig;
import com.studio216.fbs.Dao.OtherDao;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;


/**
 * Created by Book on 2015/1/13.
 */
public class OtherDaoImpl implements OtherDao {
    private String result;
    private Handler handler;

    public OtherDaoImpl(Handler handler) {
        this.handler = handler;
    }

    /**
     * 通过条形码Id获取资料类型 0表示Book 1表示Magazine 2表示InternalData
     *
     * @return
     */
    @Override
    public void getTypeBy1Code(final String code) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                String url = HttpConfig.HOST + "Other/getTypeByCode?code={code}";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                result = restTemplate.getForObject(url, String.class, code);
                Bundle bundle = new Bundle();
                bundle.putString("type", result);
                bundle.putString("code", code);
                Message message = handler.obtainMessage(1, bundle);
                handler.sendMessage(message);
            }
        };
        thread.start();
    }

    @Override
    public void getTypeByISBN(final String code) {   Thread thread = new Thread() {
        @Override
        public void run() {
            String url = HttpConfig.HOST + "Other/getTypeByBarCode?barCode={code}";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
            result = restTemplate.getForObject(url, String.class, code);
            Bundle bundle = new Bundle();
            bundle.putString("type", result);
            bundle.putString("code", code);
            Message message = handler.obtainMessage(1, bundle);
            handler.sendMessage(message);
        }
    };
        thread.start();
    }
}
