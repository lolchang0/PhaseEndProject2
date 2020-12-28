<%@page import="com.dao.UserDao"%>
<jsp:useBean id="user" class="com.model.User" scope="session"/>
<jsp:setProperty name="user" property="*"/>
 
<%
String result=UserDao.loginCheck(user);
 
if(result.equals("true")){
	session.setAttribute("email",user.getEmail());
	response.sendRedirect("home.jsp");
}
 
if(result.equals("false")){
	response.sendRedirect("loginError.html");
}
 
if(result.equals("error")){
    response.sendRedirect("loginError.html");
}
 
%>