package com.studio216.service.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 内部资料 Created by Book on 2015/1/13.
 */
public class InternalData implements Serializable {
	private String inter1DCode;// 内部资料二维码ID
	private String interISBN;// 内部资料ISBN
	private String interName;
	private String interAuthors;
	private String interPublic;
	private Date interPublicDate;
	private String interContent;
	private String interIsBorrow;
	private String interPlace;
	private String interImage;

	public InternalData() {
		super();
	}

	public InternalData(String inter1DCode, String interISBN, String interName,
			String interAuthors, String interPublic, Date interPublicDate,
			String interContent, String interIsBorrow, String interPlace,
			String interImage) {
		this.inter1DCode = inter1DCode;
		this.interISBN = interISBN;
		this.interName = interName;
		this.interAuthors = interAuthors;
		this.interPublic = interPublic;
		this.interPublicDate = interPublicDate;
		this.interContent = interContent;
		this.interIsBorrow = interIsBorrow;
		this.interPlace = interPlace;
		this.interImage = interImage;
	}

	public String getInter1DCode() {
		return inter1DCode;
	}

	public void setInter1DCode(String inter1DCode) {
		this.inter1DCode = inter1DCode;
	}

	public String getInterISBN() {
		return interISBN;
	}

	public void setInterISBN(String interISBN) {
		this.interISBN = interISBN;
	}

	public String getInterName() {
		return interName;
	}

	public void setInterName(String interName) {
		this.interName = interName;
	}

	public String getInterAuthors() {
		return interAuthors;
	}

	public void setInterAuthors(String interAuthors) {
		this.interAuthors = interAuthors;
	}

	public String getInterPublic() {
		return interPublic;
	}

	public void setInterPublic(String interPublic) {
		this.interPublic = interPublic;
	}

	public Date getInterPublicDate() {
		return interPublicDate;
	}

	public void setInterPublicDate(Date interPublicDate) {
		this.interPublicDate = interPublicDate;
	}

	public String getInterContent() {
		return interContent;
	}

	public void setInterContent(String interContent) {
		this.interContent = interContent;
	}

	public String getInterIsBorrow() {
		return interIsBorrow;
	}

	public void setInterIsBorrow(String interIsBorrow) {
		this.interIsBorrow = interIsBorrow;
	}

	public String getInterPlace() {
		return interPlace;
	}

	public void setInterPlace(String interPlace) {
		this.interPlace = interPlace;
	}

	public String getInterImage() {
		return interImage;
	}

	public void setInterImage(String interImage) {
		this.interImage = interImage;
	}
}
