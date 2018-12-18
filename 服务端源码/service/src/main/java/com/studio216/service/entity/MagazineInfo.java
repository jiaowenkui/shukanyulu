package com.studio216.service.entity;

import java.sql.Timestamp;

/**
 * MagazineInfo entity. @author MyEclipse Persistence Tools
 */

public class MagazineInfo implements java.io.Serializable {

	// Fields

	private String magaCode;
	private String magaBarCode;
	private String maganame;
	private String magapublicId;
	private Double magaprice;
	private Integer magalanguageId;
	private String magapublicyear;
	private String sumperiod;
	private Integer longId;
	private String volume;
	private String sint;
	private String magaplace;
	private String lastreader;
	private Timestamp yytime;
	private Timestamp lasttime;
	private Integer islend;
	private Integer mark;

	// Constructors

	/** default constructor */
	public MagazineInfo() {
	}

	/** minimal constructor */
	public MagazineInfo(String magaCode) {
		this.magaCode = magaCode;
	}

	/** full constructor */
	public MagazineInfo(String magaCode, String magaBarCode, String maganame,
			String magapublicId, Double magaprice, Integer magalanguageId,
			String magapublicyear, String sumperiod, Integer longId,
			String volume, String sint, String magaplace, String lastreader,
			Timestamp yytime, Timestamp lasttime, Integer islend, Integer mark) {
		this.magaCode = magaCode;
		this.magaBarCode = magaBarCode;
		this.maganame = maganame;
		this.magapublicId = magapublicId;
		this.magaprice = magaprice;
		this.magalanguageId = magalanguageId;
		this.magapublicyear = magapublicyear;
		this.sumperiod = sumperiod;
		this.longId = longId;
		this.volume = volume;
		this.sint = sint;
		this.magaplace = magaplace;
		this.lastreader = lastreader;
		this.yytime = yytime;
		this.lasttime = lasttime;
		this.islend = islend;
		this.mark = mark;
	}

	// Property accessors

	public String getMagaCode() {
		return this.magaCode;
	}

	public void setMagaCode(String magaCode) {
		this.magaCode = magaCode;
	}

	public String getMagaBarCode() {
		return this.magaBarCode;
	}

	public void setMagaBarCode(String magaBarCode) {
		this.magaBarCode = magaBarCode;
	}

	public String getMaganame() {
		return this.maganame;
	}

	public void setMaganame(String maganame) {
		this.maganame = maganame;
	}

	public String getMagapublicId() {
		return this.magapublicId;
	}

	public void setMagapublicId(String magapublicId) {
		this.magapublicId = magapublicId;
	}

	public Double getMagaprice() {
		return this.magaprice;
	}

	public void setMagaprice(Double magaprice) {
		this.magaprice = magaprice;
	}

	public Integer getMagalanguageId() {
		return this.magalanguageId;
	}

	public void setMagalanguageId(Integer magalanguageId) {
		this.magalanguageId = magalanguageId;
	}

	public String getMagapublicyear() {
		return this.magapublicyear;
	}

	public void setMagapublicyear(String magapublicyear) {
		this.magapublicyear = magapublicyear;
	}

	public String getSumperiod() {
		return this.sumperiod;
	}

	public void setSumperiod(String sumperiod) {
		this.sumperiod = sumperiod;
	}

	public Integer getLongId() {
		return this.longId;
	}

	public void setLongId(Integer longId) {
		this.longId = longId;
	}

	public String getVolume() {
		return this.volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getSint() {
		return this.sint;
	}

	public void setSint(String sint) {
		this.sint = sint;
	}

	public String getMagaplace() {
		return this.magaplace;
	}

	public void setMagaplace(String magaplace) {
		this.magaplace = magaplace;
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