package com.model;

/**
 * Countrylist entity. @author MyEclipse Persistence Tools
 */

public class Countrylist implements java.io.Serializable {

	// Fields

	private Integer countryid;
	private String countryname;

	// Constructors

	/** default constructor */
	public Countrylist() {
	}

	/** full constructor */
	public Countrylist(String countryname) {
		this.countryname = countryname;
	}

	// Property accessors

	public Integer getCountryid() {
		return this.countryid;
	}

	public void setCountryid(Integer countryid) {
		this.countryid = countryid;
	}

	public String getCountryname() {
		return this.countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}

}