package com.studio216.service.entity;

/**
 * Place entity. @author MyEclipse Persistence Tools
 */

public class Place implements java.io.Serializable {

	// Fields

	private String place;
	private String mark;

	// Constructors

	/** default constructor */
	public Place() {
	}

	/** minimal constructor */
	public Place(String place) {
		this.place = place;
	}

	/** full constructor */
	public Place(String place, String mark) {
		this.place = place;
		this.mark = mark;
	}

	// Property accessors

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

}