package com.studio216.service.entity;

/**
 * Long entity. @author MyEclipse Persistence Tools
 */

public class Long implements java.io.Serializable {

	// Fields

	private Integer longId;
	private String longname;

	// Constructors

	/** default constructor */
	public Long() {
	}

	/** minimal constructor */
	public Long(Integer longId) {
		this.longId = longId;
	}

	/** full constructor */
	public Long(Integer longId, String longname) {
		this.longId = longId;
		this.longname = longname;
	}

	// Property accessors

	public Integer getLongId() {
		return this.longId;
	}

	public void setLongId(Integer longId) {
		this.longId = longId;
	}

	public String getLongname() {
		return this.longname;
	}

	public void setLongname(String longname) {
		this.longname = longname;
	}

}