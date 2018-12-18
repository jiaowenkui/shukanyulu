package com.studio216.fbs.DaoImpl;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.studio216.fbs.Config.HttpConfig;
import com.studio216.fbs.Dao.MagazineDao;
import com.studio216.fbs.bean.Magazine;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by Book on 2015/1/13.
 */
public class MagazineDaoImpl implements MagazineDao {
    private Handler handler;
    public static final int MAGAZINE_DAO_MESSAGE_WHAT = 5;

    public MagazineDaoImpl(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void getMagazineDaoBy1DCode(final String code) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                String url = HttpConfig.HOST + "Magazine/getMagazineByMagaCode?magaCode={magaCode}";
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
                Magazine magazine = null;
                try {
                    magazine = new ObjectMapper().readValue(result, Magazine.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                bundle.putSerializable("magazine", magazine);
                Message message = handler.obtainMessage(MAGAZINE_DAO_MESSAGE_WHAT, bundle);
                handler.sendMessage(message);
            }
        };
        thread.start();
    }

    @Override
    public void getMagazineDaoByISBN(final String code) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                String url = HttpConfig.HOST + "Magazine/getMagazineByMagaBarCode?magaBarCode={magaCode}";
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
                Magazine magazine = null;
                try {
                    magazine = new ObjectMapper().readValue(result, Magazine.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                bundle.putSerializable("magazine", magazine);
                Message message = handler.obtainMessage(MAGAZINE_DAO_MESSAGE_WHAT, bundle);
                handler.sendMessage(message);
            }
        };
        thread.start();
    }
}
