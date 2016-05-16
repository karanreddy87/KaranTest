package com.form;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.model.Countrylist;

public class LoginForm {
	@NotEmpty
	private String loginName;
	@NotEmpty
	private String loginPassword;
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	List<Countrylist> counrtyList;
	public List<Countrylist> getCounrtyList() {
		return counrtyList;
	}
	public void setCounrtyList(List<Countrylist> counrtyList) {
		this.counrtyList = counrtyList;
	}
	public	String COUNTRYID;
	public String getCOUNTRYID() {
		return COUNTRYID;
	}
	public void setCOUNTRYID(String cOUNTRYID) {
		COUNTRYID = cOUNTRYID;
	}
	
	CommonsMultipartFile fileName;
	public CommonsMultipartFile getFileName() {
		return fileName;
	}
	public void setFileName(CommonsMultipartFile fileName) {
		this.fileName = fileName;
	}
	
	private String uploadPath;
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	
}
