package com.studio216.service.entity;

/**
 * Booksize entity. @author MyEclipse Persistence Tools
 */

public class Booksize implements java.io.Serializable {

	// Fields

	private Integer booksizeId;
	private String booksizename;

	// Constructors

	/** default constructor */
	public Booksize() {
	}

	/** minimal constructor */
	public Booksize(Integer booksizeId) {
		this.booksizeId = booksizeId;
	}

	/** full constructor */
	public Booksize(Integer booksizeId, String booksizename) {
		this.booksizeId = booksizeId;
		this.booksizename = booksizename;
	}

	// Property accessors

	public Integer getBooksizeId() {
		return this.booksizeId;
	}

	public void setBooksizeId(Integer booksizeId) {
		this.booksizeId = booksizeId;
	}

	public String getBooksizename() {
		return this.booksizename;
	}

	public void setBooksizename(String booksizename) {
		this.booksizename = booksizename;
	}

}