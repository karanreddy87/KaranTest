package com.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dao.LoginDao;
import com.form.LoginForm;
import com.model.Countrylist;
import com.model.Logintable;
@Component
public class LoginServiceImpl implements LoginService {

	Logger LOG=Logger.getLogger(LoginServiceImpl.class);
	
	LoginDao loginDao;
	
	
	@Autowired
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}



	@Override
	@Transactional
	public void insertLoginForm(LoginForm loginForm) {
		LOG.info("in LoginServiceImpl insertLoginForm"+loginForm.getLoginName());
		
		Logintable logintable=new Logintable();
		logintable.setLoignname(loginForm.getLoginName());
		logintable.setLoginpassword(loginForm.getLoginPassword());
		logintable.setCountyid(loginForm.getCOUNTRYID());
		logintable.setFilepath(loginForm.getUploadPath());
		loginDao.insertLoginForm(logintable);
		
	}



	@Override
	public List<Countrylist> loadCountryList() {
		return loginDao.loadCountryList();
	}

}
