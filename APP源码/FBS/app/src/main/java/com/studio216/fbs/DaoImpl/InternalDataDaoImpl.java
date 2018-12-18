package com.studio216.fbs.DaoImpl;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.studio216.fbs.Config.HttpConfig;
import com.studio216.fbs.Dao.InternalDataDao;
import com.studio216.fbs.bean.InternalData;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by Book on 2015/1/13.
 */
public class InternalDataDaoImpl implements InternalDataDao {
    private Handler handler;
    public static final int INTERNAL_DATA_DAO_MESSAGE_WHAT = 6;

    public InternalDataDaoImpl(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void getInternalDataBy1DCode(final String code) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                String url = HttpConfig.HOST + "InternalData/getInternalDataByInforCode?inforCode={inforCode}";
                RestTemplate restTemplate = new RestTemplate();
                StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
                restTemplate.getMessageConverters().add(stringHttpMessageConverter);
                String result;
                result = restTemplate.getForObject(url, String.class, code);
                try {
                    result = new String(result.getBytes("ISO-8859-1"), "utf-8");
                } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                }
                Bundle bundle = new Bundle();
                InternalData internalData = null;
                try {
                    internalData = new ObjectMapper().readValue(result, InternalData.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                bundle.putSerializable("internalData", internalData);
                Message message = handler.obtainMessage(INTERNAL_DATA_DAO_MESSAGE_WHAT, bundle);
                handler.sendMessage(message);
            }
        };
        thread.start();
    }

    @Override
    public void getInternalDataByISBN(final String code) {  Thread thread = new Thread() {
        @Override
        public void run() {
            String url = HttpConfig.HOST + "InternalData/getInternalDataByInforBarCode?inforBarCode={inforBarCode}";
            RestTemplate restTemplate = new RestTemplate();
            StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
            restTemplate.getMessageConverters().add(stringHttpMessageConverter);
            String result;
            result = restTemplate.getForObject(url, String.class, code);
            try {
                result = new String(result.getBytes("ISO-8859-1"), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            Bundle bundle = new Bundle();
            InternalData internalData = null;
            try {
                internalData = new ObjectMapper().readValue(result, InternalData.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            bundle.putSerializable("internalData", internalData);
            Message message = handler.obtainMessage(INTERNAL_DATA_DAO_MESSAGE_WHAT, bundle);
            handler.sendMessage(message);
        }
    };
        thread.start();
    }
}
