<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page language="java"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="AO.*"%>


   
   <!-- Developed by : Sonal Sharma
        Company      : IntelMind -->

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/mymenu.css">
         <script language="javascript" src="<%=request.getContextPath()%>/fee/resolution.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/fee/validation.js"></script>
        
         <title>School Management System</title>
     
    </head>
    <body>
    <table class="res" cellpadding="0" cellspacing="0" align="center" bgcolor="DCDCDC">
<tr><td><%@include file="topmainuser.jsp"%></td></tr>
<tr><td valign="top">
<table align="center" width="100%" cellpadding="2" cellspacing="0" height=350>         
    </td></tr>
    <tr><td valign="middle"> 
   <form name=f1 action="log.do" method="post"> 

  <table align="center" border="0" cellspacing="1" cellpadding="4">
   
<tr><td  align="center">Userid:</td>
   <td ><input type=text size="20" name="userid"></td><% if((String)request.getAttribute("check")!=null)
   out.println("<font color='red'><b>"+(String)request.getAttribute("check")+"</b></font>");%>   
</tr>
<tr><td align="center">Password:</td><td ><input type=password size="22" name="password"></td></tr>   
<tr><td align="center"><input type="submit" value=Submit ></td></tr>

  
      
    </table>
 
    </form>
    </td></tr></table>
    </td></tr></table>  
    </body>
</html>
