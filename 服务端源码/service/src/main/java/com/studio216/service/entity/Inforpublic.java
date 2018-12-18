package com.studio216.service.entity;

/**
 * Inforpublic entity. @author MyEclipse Persistence Tools
 */

public class Inforpublic implements java.io.Serializable {

	// Fields

	private Integer inforpublicId;
	private String inforpublicname;

	// Constructors

	/** default constructor */
	public Inforpublic() {
	}

	/** minimal constructor */
	public Inforpublic(Integer inforpublicId) {
		this.inforpublicId = inforpublicId;
	}

	/** full constructor */
	public Inforpublic(Integer inforpublicId, String inforpublicname) {
		this.inforpublicId = inforpublicId;
		this.inforpublicname = inforpublicname;
	}

	// Property accessors

	public Integer getInforpublicId() {
		return this.inforpublicId;
	}

	public void setInforpublicId(Integer inforpublicId) {
		this.inforpublicId = inforpublicId;
	}

	public String getInforpublicname() {
		return this.inforpublicname;
	}

	public void setInforpublicname(String inforpublicname) {
		this.inforpublicname = inforpublicname;
	}

}