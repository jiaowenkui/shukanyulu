package com.studio216.fbs.DaoImpl;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.studio216.fbs.Config.HttpConfig;
import com.studio216.fbs.Dao.BookDao;
import com.studio216.fbs.bean.Book;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by Book on 2015/1/13.
 */
public class BookDaoImpl implements BookDao {
    private Handler handler;
    public static final int BOOK_DAO_MESSAGE_WHAT = 4;

    public BookDaoImpl(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void getBookBy1DCode(final String code) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                String url = HttpConfig.HOST + "Book/getBookByBookCode?bookCode={bookCode}";
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
                Book book = null;
                try {
                    book = new ObjectMapper().readValue(result, Book.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                bundle.putSerializable("book", book);
                Message message = handler.obtainMessage(BOOK_DAO_MESSAGE_WHAT, bundle);

                handler.sendMessage(message);
            }
        };
        thread.start();
    }

    @Override
    public void getBookByISBN(final String code) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                String url = HttpConfig.HOST + "Book/getBookByBookBarCode?bookBarCode={bookCode}";
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
                Book book = null;
                try {
                    book = new ObjectMapper().readValue(result, Book.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                bundle.putSerializable("book", book);
                Message message = handler.obtainMessage(BOOK_DAO_MESSAGE_WHAT, bundle);
                handler.sendMessage(message);
            }
        };
        thread.start();
    }

}
