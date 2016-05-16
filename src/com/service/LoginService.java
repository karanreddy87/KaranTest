package com.service;

import java.util.List;

import com.form.LoginForm;
import com.model.Countrylist;

public interface LoginService {
public void insertLoginForm(LoginForm  loginForm);

public List<Countrylist> loadCountryList();
	
}
