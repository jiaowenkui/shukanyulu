package com.studio216.service.entity;

import java.sql.Timestamp;

/**
 * Infordata entity. @author MyEclipse Persistence Tools
 */

public class Infordata implements java.io.Serializable {

	// Fields

	private String inforCode;
	private String inforBarCode;
	private String inforname;
	private String inforauthors;
	private Integer inforpublicId;
	private Timestamp publicdate;
	private String inforcontent;
	private String inforplace;
	private String lastreader;
	private Timestamp yytime;
	private Timestamp lasttime;
	private Integer islend;
	private Integer mark;

	// Constructors

	/** default constructor */
	public Infordata() {
	}

	/** minimal constructor */
	public Infordata(String inforCode) {
		this.inforCode = inforCode;
	}

	/** full constructor */
	public Infordata(String inforCode, String inforBarCode, String inforname,
			String inforauthors, Integer inforpublicId, Timestamp publicdate,
			String inforcontent, String inforplace, String lastreader,
			Timestamp yytime, Timestamp lasttime, Integer islend, Integer mark) {
		this.inforCode = inforCode;
		this.inforBarCode = inforBarCode;
		this.inforname = inforname;
		this.inforauthors = inforauthors;
		this.inforpublicId = inforpublicId;
		this.publicdate = publicdate;
		this.inforcontent = inforcontent;
		this.inforplace = inforplace;
		this.lastreader = lastreader;
		this.yytime = yytime;
		this.lasttime = lasttime;
		this.islend = islend;
		this.mark = mark;
	}

	// Property accessors

	public String getInforCode() {
		return this.inforCode;
	}

	public void setInforCode(String inforCode) {
		this.inforCode = inforCode;
	}

	public String getInforBarCode() {
		return this.inforBarCode;
	}

	public void setInforBarCode(String inforBarCode) {
		this.inforBarCode = inforBarCode;
	}

	public String getInforname() {
		return this.inforname;
	}

	public void setInforname(String inforname) {
		this.inforname = inforname;
	}

	public String getInforauthors() {
		return this.inforauthors;
	}

	public void setInforauthors(String inforauthors) {
		this.inforauthors = inforauthors;
	}

	public Integer getInforpublicId() {
		return this.inforpublicId;
	}

	public void setInforpublicId(Integer inforpublicId) {
		this.inforpublicId = inforpublicId;
	}

	public Timestamp getPublicdate() {
		return this.publicdate;
	}

	public void setPublicdate(Timestamp publicdate) {
		this.publicdate = publicdate;
	}

	public String getInforcontent() {
		return this.inforcontent;
	}

	public void setInforcontent(String inforcontent) {
		this.inforcontent = inforcontent;
	}

	public String getInforplace() {
		return this.inforplace;
	}

	public void setInforplace(String inforplace) {
		this.inforplace = inforplace;
	}

	public String getLastreader() {
		return this.lastreader;
	}

	public void setLastreader(String lastreader) {
		this.lastreader = lastreader;
	}

	public Timestamp getYytime() {
		return this.yytime;
	}

	public void setYytime(Timestamp yytime) {
		this.yytime = yytime;
	}

	public Timestamp getLasttime() {
		return this.lasttime;
	}

	public void setLasttime(Timestamp lasttime) {
		this.lasttime = lasttime;
	}

	public Integer getIslend() {
		return this.islend;
	}

	public void setIslend(Integer islend) {
		this.islend = islend;
	}

	public Integer getMark() {
		return this.mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

}