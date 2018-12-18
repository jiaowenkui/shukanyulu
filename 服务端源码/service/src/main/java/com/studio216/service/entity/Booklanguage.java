package com.studio216.service.entity;

/**
 * Booklanguage entity. @author MyEclipse Persistence Tools
 */

public class Booklanguage implements java.io.Serializable {

	// Fields

	private Integer booklanguageId;
	private String booklanguagename;

	// Constructors

	/** default constructor */
	public Booklanguage() {
	}

	/** minimal constructor */
	public Booklanguage(Integer booklanguageId) {
		this.booklanguageId = booklanguageId;
	}

	/** full constructor */
	public Booklanguage(Integer booklanguageId, String booklanguagename) {
		this.booklanguageId = booklanguageId;
		this.booklanguagename = booklanguagename;
	}

	// Property accessors

	public Integer getBooklanguageId() {
		return this.booklanguageId;
	}

	public void setBooklanguageId(Integer booklanguageId) {
		this.booklanguageId = booklanguageId;
	}

	public String getBooklanguagename() {
		return this.booklanguagename;
	}

	public void setBooklanguagename(String booklanguagename) {
		this.booklanguagename = booklanguagename;
	}

}