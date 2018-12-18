package com.studio216.fbs.bean;

import java.io.Serializable;

/**
 * Created by Book on 2015/2/14.
 */
public class Summary implements Serializable {
    private String place;
    private int summaryNum;
    private int isBorrowedNum;

    public Summary() {
        super();
        this.summaryNum = 0;
        this.isBorrowedNum = 0;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getSummaryNum() {
        return summaryNum;
    }

    public void setSummaryNum(int summaryNum) {
        this.summaryNum = summaryNum;
    }

    public int getIsBorrowedNum() {
        return isBorrowedNum;
    }

    public void setIsBorrowedNum(int isBorrowedNum) {
        this.isBorrowedNum = isBorrowedNum;
    }

    public boolean isEqualsPlace(String place) {
        return place.equals(this.place) ? true : false;
    }
}
