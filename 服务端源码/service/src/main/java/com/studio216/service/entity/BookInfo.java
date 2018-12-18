package com.studio216.service.entity;

import java.sql.Timestamp;

/**
 * BookInfo entity. @author MyEclipse Persistence Tools
 */

public class BookInfo implements java.io.Serializable {

	// Fields

	private String bookCode;
	private String bookBarCode;
	private String bookname;
	private Integer booktypeId;
	private String bookauthors;
	private Integer booklanguageId;
	private String bookcontent;
	private Integer bookpublicId;
	private String bookedition;
	private Timestamp publicdate;
	private Integer booksizeId;
	private String printedsheets;
	private String booknumber;
	private String impression;
	private String printednumber;
	private Double bookprice;
	private String appurtenances;
	private String bookplace;
	private String lastreader;
	private Timestamp yytime;
	private Timestamp lasttime;
	private Integer islend;
	private Integer mark;

	// Constructors

	/** default constructor */
	public BookInfo() {
	}

	/** minimal constructor */
	public BookInfo(String bookCode) {
		this.bookCode = bookCode;
	}

	/** full constructor */
	public BookInfo(String bookCode, String bookBarCode, String bookname,
			Integer booktypeId, String bookauthors, Integer booklanguageId,
			String bookcontent, Integer bookpublicId, String bookedition,
			Timestamp publicdate, Integer booksizeId, String printedsheets,
			String booknumber, String impression, String printednumber,
			Double bookprice, String appurtenances, String bookplace,
			String lastreader, Timestamp yytime, Timestamp lasttime,
			Integer islend, Integer mark) {
		this.bookCode = bookCode;
		this.bookBarCode = bookBarCode;
		this.bookname = bookname;
		this.booktypeId = booktypeId;
		this.bookauthors = bookauthors;
		this.booklanguageId = booklanguageId;
		this.bookcontent = bookcontent;
		this.bookpublicId = bookpublicId;
		this.bookedition = bookedition;
		this.publicdate = publicdate;
		this.booksizeId = booksizeId;
		this.printedsheets = printedsheets;
		this.booknumber = booknumber;
		this.impression = impression;
		this.printednumber = printednumber;
		this.bookprice = bookprice;
		this.appurtenances = appurtenances;
		this.bookplace = bookplace;
		this.lastreader = lastreader;
		this.yytime = yytime;
		this.lasttime = lasttime;
		this.islend = islend;
		this.mark = mark;
	}

	// Property accessors

	public String getBookCode() {
		return this.bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookBarCode() {
		return this.bookBarCode;
	}

	public void setBookBarCode(String bookBarCode) {
		this.bookBarCode = bookBarCode;
	}

	public String getBookname() {
		return this.bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public Integer getBooktypeId() {
		return this.booktypeId;
	}

	public void setBooktypeId(Integer booktypeId) {
		this.booktypeId = booktypeId;
	}

	public String getBookauthors() {
		return this.bookauthors;
	}

	public void setBookauthors(String bookauthors) {
		this.bookauthors = bookauthors;
	}

	public Integer getBooklanguageId() {
		return this.booklanguageId;
	}

	public void setBooklanguageId(Integer booklanguageId) {
		this.booklanguageId = booklanguageId;
	}

	public String getBookcontent() {
		return this.bookcontent;
	}

	public void setBookcontent(String bookcontent) {
		this.bookcontent = bookcontent;
	}

	public Integer getBookpublicId() {
		return this.bookpublicId;
	}

	public void setBookpublicId(Integer bookpublicId) {
		this.bookpublicId = bookpublicId;
	}

	public String getBookedition() {
		return this.bookedition;
	}

	public void setBookedition(String bookedition) {
		this.bookedition = bookedition;
	}

	public Timestamp getPublicdate() {
		return this.publicdate;
	}

	public void setPublicdate(Timestamp publicdate) {
		this.publicdate = publicdate;
	}

	public Integer getBooksizeId() {
		return this.booksizeId;
	}

	public void setBooksizeId(Integer booksizeId) {
		this.booksizeId = booksizeId;
	}

	public String getPrintedsheets() {
		return this.printedsheets;
	}

	public void setPrintedsheets(String printedsheets) {
		this.printedsheets = printedsheets;
	}

	public String getBooknumber() {
		return this.booknumber;
	}

	public void setBooknumber(String booknumber) {
		this.booknumber = booknumber;
	}

	public String getImpression() {
		return this.impression;
	}

	public void setImpression(String impression) {
		this.impression = impression;
	}

	public String getPrintednumber() {
		return this.printednumber;
	}

	public void setPrintednumber(String printednumber) {
		this.printednumber = printednumber;
	}

	public Double getBookprice() {
		return this.bookprice;
	}

	public void setBookprice(Double bookprice) {
		this.bookprice = bookprice;
	}

	public String getAppurtenances() {
		return this.appurtenances;
	}

	public void setAppurtenances(String appurtenances) {
		this.appurtenances = appurtenances;
	}

	public String getBookplace() {
		return this.bookplace;
	}

	public void setBookplace(String bookplace) {
		this.bookplace = bookplace;
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