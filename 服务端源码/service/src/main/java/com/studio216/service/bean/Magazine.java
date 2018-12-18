package com.studio216.service.bean;

import java.io.Serializable;

/**
 * 杂志 Created by Book on 2015/1/13.
 */
public class Magazine implements Serializable {
	private String magazine1DCode;// 杂志条形码ID
	private String magazineISBN;// 杂志ISBN
	private String magazineName;// 杂志名称
	private String magazinePublic;// 杂志出版社
	private Double magazinePrice;// 杂志价格
	private String magazineLanguage;// 杂志语言
	private String magazinePublicYear;// 杂志出版年份
	private String magazinePeriod;// 杂志出版月
	private String magazineLong;// 每期杂志时长
	private String magazineVolume;// 杂志卷书;
	private String magazineSint;//
	private String magazinePlace;// 杂志位置
	private String magazineIsBorrow;// 杂志是否被借阅
	private String magazineImage;// 杂志图片

	public Magazine() {
		super();
	}

	public Magazine(String magazine1dCode, String magazineISBN,
			String magazineName, String magazinePublic, Double magazinePrice,
			String magazineLanguage, String magazinePublicYear,
			String magazinePeriod, String magazineLong, String magazineVolume,
			String magazineSint, String magazinePlace, String magazineIsBorrow,
			String magazineImage) {
		super();
		magazine1DCode = magazine1dCode;
		this.magazineISBN = magazineISBN;
		this.magazineName = magazineName;
		this.magazinePublic = magazinePublic;
		this.magazinePrice = magazinePrice;
		this.magazineLanguage = magazineLanguage;
		this.magazinePublicYear = magazinePublicYear;
		this.magazinePeriod = magazinePeriod;
		this.magazineLong = magazineLong;
		this.magazineVolume = magazineVolume;
		this.magazineSint = magazineSint;
		this.magazinePlace = magazinePlace;
		this.magazineIsBorrow = magazineIsBorrow;
		this.magazineImage = magazineImage;
	}

	public String getMagazine1DCode() {
		return magazine1DCode;
	}

	public void setMagazine1DCode(String magazine1dCode) {
		magazine1DCode = magazine1dCode;
	}

	public String getMagazineISBN() {
		return magazineISBN;
	}

	public void setMagazineISBN(String magazineISBN) {
		this.magazineISBN = magazineISBN;
	}

	public String getMagazineName() {
		return magazineName;
	}

	public void setMagazineName(String magazineName) {
		this.magazineName = magazineName;
	}

	public String getMagazinePublic() {
		return magazinePublic;
	}

	public void setMagazinePublic(String magazinePublic) {
		this.magazinePublic = magazinePublic;
	}

	public Double getMagazinePrice() {
		return magazinePrice;
	}

	public void setMagazinePrice(Double magazinePrice) {
		this.magazinePrice = magazinePrice;
	}

	public String getMagazineLanguage() {
		return magazineLanguage;
	}

	public void setMagazineLanguage(String magazineLanguage) {
		this.magazineLanguage = magazineLanguage;
	}

	public String getMagazinePublicYear() {
		return magazinePublicYear;
	}

	public void setMagazinePublicYear(String magazinePublicYear) {
		this.magazinePublicYear = magazinePublicYear;
	}

	public String getMagazinePeriod() {
		return magazinePeriod;
	}

	public void setMagazinePeriod(String magazinePeriod) {
		this.magazinePeriod = magazinePeriod;
	}

	public String getMagazineLong() {
		return magazineLong;
	}

	public void setMagazineLong(String magazineLong) {
		this.magazineLong = magazineLong;
	}

	public String getMagazineVolume() {
		return magazineVolume;
	}

	public void setMagazineVolume(String magazineVolume) {
		this.magazineVolume = magazineVolume;
	}

	public String getMagazineSint() {
		return magazineSint;
	}

	public void setMagazineSint(String magazineSint) {
		this.magazineSint = magazineSint;
	}

	public String getMagazinePlace() {
		return magazinePlace;
	}

	public void setMagazinePlace(String magazinePlace) {
		this.magazinePlace = magazinePlace;
	}

	public String getMagazineIsBorrow() {
		return magazineIsBorrow;
	}

	public void setMagazineIsBorrow(String magazineIsBorrow) {
		this.magazineIsBorrow = magazineIsBorrow;
	}

	public String getMagazineImage() {
		return magazineImage;
	}

	public void setMagazineImage(String magazineImage) {
		this.magazineImage = magazineImage;
	}

}
