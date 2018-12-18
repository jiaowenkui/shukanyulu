package com.studio216.fbs.DaoImpl;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.studio216.fbs.Config.HttpConfig;
import com.studio216.fbs.Dao.PlaceDao;
import com.studio216.fbs.Utils.JsonUtils;
import com.studio216.fbs.bean.Place;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Book on 2015/1/14.
 */
public class PlaceDaoImpl implements PlaceDao {
    private String result;
    private Handler handler;
    public static final int PLACE_DAO_GET_ALL_PLACE_NAME = 001;

    public PlaceDaoImpl(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void getAllPlaceNames() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                List<Place> list = null;
                String url = HttpConfig.HOST + "Place/getAllPlaces";
                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                result = restTemplate.getForObject(url, String.class);
                Bundle bundle = new Bundle();
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    list = (List<Place>) objectMapper.readValue(result, new JsonUtils(objectMapper).getCollectionType(ArrayList.class, Place.class));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                bundle.putSerializable("places", (Serializable) list);
                Message message = handler.obtainMessage(PLACE_DAO_GET_ALL_PLACE_NAME, bundle);
                handler.sendMessage(message);
            }
        });
        thread.start();
    }
}
