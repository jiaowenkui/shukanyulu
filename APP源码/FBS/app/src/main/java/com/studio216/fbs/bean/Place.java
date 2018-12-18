package com.studio216.fbs.bean;

import java.io.Serializable;

/**
 * 书架bean
 * Created by Book on 2015/1/14.
 */
public class Place implements Serializable {

    private String place;
    private String mark;

    public Place() {
        super();
    }

    public Place(String place, String mark) {
        this.place = place;
        this.mark = mark;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
