package com.studio216.service.entity;

/**
 * Booktype entity. @author MyEclipse Persistence Tools
 */

public class Booktype implements java.io.Serializable {

	// Fields

	private Integer booktypeId;
	private String booktypename;

	// Constructors

	/** default constructor */
	public Booktype() {
	}

	/** full constructor */
	public Booktype(Integer booktypeId, String booktypename) {
		this.booktypeId = booktypeId;
		this.booktypename = booktypename;
	}

	// Property accessors

	public Integer getBooktypeId() {
		return this.booktypeId;
	}

	public void setBooktypeId(Integer booktypeId) {
		this.booktypeId = booktypeId;
	}

	public String getBooktypename() {
		return this.booktypename;
	}

	public void setBooktypename(String booktypename) {
		this.booktypename = booktypename;
	}

}