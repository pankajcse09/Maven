<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@page import="java.io.*"%>


<html>
 <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HPMI</title>

<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/outline.css">
<script language="javascript" src="<%=request.getContextPath()%>/outline.js"></script>

    </head>
<%  
response.setHeader("Cache-Control","no-cache");
%>
<body style="margin-left:80;margin-right:80;margin-top:5">


<table width="100%" border="0" style="border-collapse:collapse">
    <TR><TD vAlign=top ><%//@include file="/jsp/header.jsp" %></TD></TR>  
  
<tr>
<td width="100%" height="85%" valign="top" bgcolor="lightyellow">

<table width="100%" align="center" height="425" cellpadding="0" cellspacing="0"><tr><td>
<table border="0" cellpadding=0 cellspacing =0 width="100%">
<tr><td valign="center">
<form name="f1" method="post" action="<%=request.getContextPath()%>/UserLog.do?method=authenticate"> 
    
    
 <table align="center">
<tr><td colspan="2"><b><font size="2" color="red">Enter the LoginID and Password!</font></b></td></tr>
<tr><td><b><font size="2">LoginID</font></b></td><td><input type="text" name="loginid"  style="width:120"></td></tr>
<tr><td><b><font size="2">Password</font></b></td><td><input type="password" name="password" style="width:120" ></td></tr>
<tr><td colspan="2" align="center"><input type="submit" value="Login"></td></tr>
</table>    
</form>
<% if(request.getAttribute("msg")!=null){%>
<center><font color="red" size="2"><b><%=request.getAttribute("msg")%></b></font></center>
<%}%>
<table align="center"><tr>
<td><!--<a href="<%=request.getContextPath()%>/newuser.do"><font color="darkblue">New User</font></a>--></td>
</tr></table>
</td></tr></table>
</td></tr></table>


</td></tr>

<TR><TD vAlign=top ><%//@ include file="/jsp/hrms_footer.jsp" %></td></tr>
</table>
</body>


</html>