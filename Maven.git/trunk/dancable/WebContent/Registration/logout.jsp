<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@page session="true"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>logout</title>    
    </head>
    <body onload ="window.history.forward(1);document.frm.submit();">  
<%
 if(session.getAttribute("password")!=null){    
 session.removeAttribute("password");     
 }
 if(session.getAttribute("loginid")!=null){  
 session.removeAttribute("loginid");   
 }
 session.invalidate(); 
%>   
    <form name="frm" method="post" action="<%=request.getContextPath()%>/Registration/UserLogin.jsp" target="_parent">
    </form>
    </body>    
</html>
