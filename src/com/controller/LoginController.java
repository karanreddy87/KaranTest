package com.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.form.LoginForm;
import com.model.Countrylist;
import com.service.LoginService;

@Controller
@RequestMapping("loginController")
public class LoginController {

	private static final Logger LOG=Logger.getLogger(LoginController.class);
	
	LoginService loginService;
	
	@Autowired
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@RequestMapping(method=RequestMethod.GET)
	public String showLoginPage(Map<String, Object> model){
		LOG.info("in LoginController showLoginPage");
		LoginForm loginForm=new LoginForm();
		
		List<Countrylist> countrylist=loginService.loadCountryList();
		loginForm.setCounrtyList(countrylist);
		model.put("loginForm", loginForm);
		return "showLogin";
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String processLoginPage(Map<String, Object> model,LoginForm loginForm,HttpServletRequest request){
		LOG.info("in LoginController processLoginPage");
		String target="showLoginsuccess";
		LOG.info("loginname::"+loginForm.getLoginName());
		LOG.info("loginpassword::"+loginForm.getLoginPassword());
		
		
		CommonsMultipartFile commonsMultipartFile=loginForm.getFileName();
		
		saveFile(loginForm,request);
		loginService.insertLoginForm(loginForm);
		/*
		 * Exception handling example
		 * loginForm=null;
		LOG.info("exception loginname::"+loginForm.getLoginName());*/
		model.put("loginForm", loginForm);
		return target;
		
	}
	private void saveFile(LoginForm loginForm,
			HttpServletRequest request) {
		 String uploadPath=null;
		try{
			CommonsMultipartFile commonsMultipartFile=loginForm.getFileName();
			 String fileNameNew = commonsMultipartFile.getOriginalFilename();
			 uploadPath=request.getSession().getServletContext().getRealPath("/")+"upload";
				System.out.println("uploadPath:"+uploadPath);
				File folder = new File(uploadPath);
			    if(!folder.exists()){
			    	folder.mkdir();
			    }
			    LOG.info("uploadPath::::"+uploadPath);
			    if(!("").equals(fileNameNew)){  
		 
			        System.out.println("Server path:" +uploadPath);
			        File newFile = new File(uploadPath, fileNameNew);
		 
			        if(!newFile.exists()){
			          FileOutputStream fos = new FileOutputStream(newFile);
			          fos.write(commonsMultipartFile.getFileItem().get());
			          fos.flush();
			          fos.close();
			        }  
		 
			    }
				if (commonsMultipartFile != null) {
					String fileName = commonsMultipartFile.getOriginalFilename();
					 FileOutputStream outputStream = null;
			            String filePath = System.getProperty("java.io.tmpdir") + "/" + fileName;
			            try {
			                outputStream = new FileOutputStream(new File(filePath));
			                outputStream.write(commonsMultipartFile.getFileItem().get());
			                outputStream.close();
			            } catch (Exception e) {
			                System.out.println("Error while saving file");
			            }
					// do whatever you want
				}
				
				loginForm.setUploadPath(uploadPath);
				
		}catch(Exception e){
			
		}
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {
		ModelAndView modelAndView = new ModelAndView("error/generic_error");
		modelAndView.addObject("errMsg", "this is Exception.class");//error message name
		return modelAndView;

	}
	@ExceptionHandler(IOException.class)
	public ModelAndView handleAllException1(Exception ex) {
		ModelAndView modelAndView = new ModelAndView("error/generic_error1");
		modelAndView.addObject("errMsg", "this is Exception.class");//error message name
		return modelAndView;

	}
}
