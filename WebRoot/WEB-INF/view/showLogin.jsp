<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="f" uri="/WEB-INF/spring-form.tld"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    This is my JSP page. <br>
    <h1>SpringMVCLoginApp Login page</h1>
    <form:form action="./loginController" commandName="loginForm" enctype="multipart/form-data">
		LoginName:<form:input path="loginName"/> <FONT color="red"><form:errors
				path="loginName" /></FONT><br>
		LoginPassword:<form:input path="loginPassword"/>   <FONT color="red"><form:errors
				path="loginPassword" /></FONT><br>
		Select Country:	<form:select path="COUNTRYID" id="COUNTRYID">
		
			<form:option value="-1">Please select</form:option>
			<form:options items="${loginForm.counrtyList}" itemLabel="countryname" itemValue="countryid"/>  
        	</form:select><br>
        	fileName:<input type="file" name="fileName"><br>
		<input type="submit" value="Save">
		
    </form:form>
    
    
    
  </body>
</html>
