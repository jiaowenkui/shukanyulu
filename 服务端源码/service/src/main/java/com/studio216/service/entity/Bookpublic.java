package com.studio216.service.entity;

/**
 * Bookpublic entity. @author MyEclipse Persistence Tools
 */

public class Bookpublic implements java.io.Serializable {

	// Fields

	private Integer bookpublicId;
	private String bookpublicname;

	// Constructors

	/** default constructor */
	public Bookpublic() {
	}

	/** minimal constructor */
	public Bookpublic(Integer bookpublicId) {
		this.bookpublicId = bookpublicId;
	}

	/** full constructor */
	public Bookpublic(Integer bookpublicId, String bookpublicname) {
		this.bookpublicId = bookpublicId;
		this.bookpublicname = bookpublicname;
	}

	// Property accessors

	public Integer getBookpublicId() {
		return this.bookpublicId;
	}

	public void setBookpublicId(Integer bookpublicId) {
		this.bookpublicId = bookpublicId;
	}

	public String getBookpublicname() {
		return this.bookpublicname;
	}

	public void setBookpublicname(String bookpublicname) {
		this.bookpublicname = bookpublicname;
	}

}