package com.studio216.service.entity;

/**
 * MagazineImageInfo entity. @author MyEclipse Persistence Tools
 */

public class MagazineImageInfo implements java.io.Serializable {

	// Fields

	private Integer magaImageId;
	private String magaCode;
	private String images;

	// Constructors

	/** default constructor */
	public MagazineImageInfo() {
	}

	/** minimal constructor */
	public MagazineImageInfo(Integer magaImageId) {
		this.magaImageId = magaImageId;
	}

	/** full constructor */
	public MagazineImageInfo(Integer magaImageId, String magaCode, String images) {
		this.magaImageId = magaImageId;
		this.magaCode = magaCode;
		this.images = images;
	}

	// Property accessors

	public Integer getMagaImageId() {
		return this.magaImageId;
	}

	public void setMagaImageId(Integer magaImageId) {
		this.magaImageId = magaImageId;
	}

	public String getMagaCode() {
		return this.magaCode;
	}

	public void setMagaCode(String magaCode) {
		this.magaCode = magaCode;
	}

	public String getImages() {
		return this.images;
	}

	public void setImages(String images) {
		this.images = images;
	}

}