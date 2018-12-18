package com.studio216.fbs.database;

import net.tsz.afinal.annotation.sqlite.Id;

import java.io.Serializable;

/**
 * Created by Book on 2015/2/5.
 */
public class CheckItem implements Serializable {
    @Id
    private int id;
    private String code;
    private String dataName;
    private String checkName;
    private String place;
    private String status;

    public CheckItem() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        super.equals(o);
        CheckItem checkItem = (CheckItem) o;
        if (checkItem.getCode().equals(this.getCode())) {
            return true;
        } else {
            return false;
        }
    }
}
