package com.studio216.fbs.database;

import net.tsz.afinal.annotation.sqlite.Id;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Book on 2015/2/2.
 */
public class CheckInfo implements Serializable {
    @Id(column = "checkName")
    private String checkName;
    private Date checkTime;

    public CheckInfo() {
        super();
    }

    public CheckInfo(String checkName) {
        this(checkName, new Date());
    }

    public CheckInfo(String checkName, Date checkTime) {
        this.checkName = checkName;
        this.checkTime = checkTime;
    }

    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }
}
