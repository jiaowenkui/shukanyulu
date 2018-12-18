package com.studio216.service.entity;

/**
 * BookImageInfo entity. @author MyEclipse Persistence Tools
 */

public class BookImageInfo implements java.io.Serializable {

	// Fields

	private Integer bookImageId;
	private String bookCode;
	private String images;

	// Constructors

	/** default constructor */
	public BookImageInfo() {
	}

	/** minimal constructor */
	public BookImageInfo(Integer bookImageId, String images) {
		this.bookImageId = bookImageId;
		this.images = images;
	}

	/** full constructor */
	public BookImageInfo(Integer bookImageId, String bookCode, String images) {
		this.bookImageId = bookImageId;
		this.bookCode = bookCode;
		this.images = images;
	}

	// Property accessors

	public Integer getBookImageId() {
		return this.bookImageId;
	}

	public void setBookImageId(Integer bookImageId) {
		this.bookImageId = bookImageId;
	}

	public String getBookCode() {
		return this.bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public String getImages() {
		return this.images;
	}

	public void setImages(String images) {
		this.images = images;
	}

}