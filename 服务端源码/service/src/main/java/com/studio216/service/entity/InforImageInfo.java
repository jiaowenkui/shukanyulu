package com.studio216.service.entity;

/**
 * InforImageInfo entity. @author MyEclipse Persistence Tools
 */

public class InforImageInfo implements java.io.Serializable {

	// Fields

	private Integer inforImageId;
	private String inforCode;
	private String images;

	// Constructors

	/** default constructor */
	public InforImageInfo() {
	}

	/** minimal constructor */
	public InforImageInfo(Integer inforImageId) {
		this.inforImageId = inforImageId;
	}

	/** full constructor */
	public InforImageInfo(Integer inforImageId, String inforCode, String images) {
		this.inforImageId = inforImageId;
		this.inforCode = inforCode;
		this.images = images;
	}

	// Property accessors

	public Integer getInforImageId() {
		return this.inforImageId;
	}

	public void setInforImageId(Integer inforImageId) {
		this.inforImageId = inforImageId;
	}

	public String getInforCode() {
		return this.inforCode;
	}

	public void setInforCode(String inforCode) {
		this.inforCode = inforCode;
	}

	public String getImages() {
		return this.images;
	}

	public void setImages(String images) {
		this.images = images;
	}

}