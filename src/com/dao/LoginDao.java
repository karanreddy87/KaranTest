package com.dao;

import java.util.List;

import com.model.Countrylist;
import com.model.Logintable;

public interface LoginDao {
	public void insertLoginForm(Logintable  loginForm);

	public List<Countrylist> loadCountryList();
}
