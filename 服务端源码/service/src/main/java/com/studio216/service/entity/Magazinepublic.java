package com.studio216.service.entity;

/**
 * Magazinepublic entity. @author MyEclipse Persistence Tools
 */

public class Magazinepublic implements java.io.Serializable {

	// Fields

	private Integer magapublicId;
	private String magapublicname;

	// Constructors

	/** default constructor */
	public Magazinepublic() {
	}

	/** minimal constructor */
	public Magazinepublic(Integer magapublicId) {
		this.magapublicId = magapublicId;
	}

	/** full constructor */
	public Magazinepublic(Integer magapublicId, String magapublicname) {
		this.magapublicId = magapublicId;
		this.magapublicname = magapublicname;
	}

	// Property accessors

	public Integer getMagapublicId() {
		return this.magapublicId;
	}

	public void setMagapublicId(Integer magapublicId) {
		this.magapublicId = magapublicId;
	}

	public String getMagapublicname() {
		return this.magapublicname;
	}

	public void setMagapublicname(String magapublicname) {
		this.magapublicname = magapublicname;
	}

}