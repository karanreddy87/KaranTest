package com.model;

/**
 * Logintable entity. @author MyEclipse Persistence Tools
 */

public class Logintable implements java.io.Serializable {

	// Fields

	private Integer loginid;
	private String loignname;
	private String loginpassword;
	private String countyid;
	private String filepath;
	// Constructors

	/** default constructor */
	public Logintable() {
	}

	/** full constructor */
	public Logintable(String loignname, String loginpassword) {
		this.loignname = loignname;
		this.loginpassword = loginpassword;
	}

	// Property accessors

	public Integer getLoginid() {
		return this.loginid;
	}

	public void setLoginid(Integer loginid) {
		this.loginid = loginid;
	}

	public String getLoignname() {
		return this.loignname;
	}

	public void setLoignname(String loignname) {
		this.loignname = loignname;
	}

	public String getLoginpassword() {
		return this.loginpassword;
	}

	public void setLoginpassword(String loginpassword) {
		this.loginpassword = loginpassword;
	}

	public String getCountyid() {
		return countyid;
	}

	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	
}