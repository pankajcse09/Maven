
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page language="java"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="java.sql.*"%>
<%@page import="com.myapp.struts.Dataconnectivity"%>

<%  
response.setHeader("Cache-Control","no-cache");
response.setHeader("pragma","no-cache");
response.setHeader("Expires","0");
response.setHeader("Cache-Control","no-store");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<meta http-equiv="Content-Language" content="en-us">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>

 <title>Home</title>
<base target="_parent">
<meta name="" content="">
</head>
<body onload="window.history.forward(0);" bgcolor="#999933">
<table width="100%" cellpadding="0" cellspacing="0" align="center">

<tr><td align="center" style="padding-top:0px">
<table border="0" align="center" bgcolor="#FFFFCC" width="100%" height="100%"> 
    
   <!-- <tr><td align="center"><font color="#666600" style="font-family:Times New Roman" size="5">Surajmal Laxmi Devi Sawarthia Educational Trusts </font></td></tr>
 <tr><td align="center"><font color="#666600" style="font-family:Times New Roman" size="5">Group of Instiutions </font></td></tr>
 <tr><td align="center"><font color="#666600" style="font-family:Times New Roman" size="5">(Surajmal college of Engineering & Management , kichha) </font></td></tr>
-->
<tr><td align="center" height="100" colspan="2"><font color="#99990" style="font-family:Comic Sans MS; font-weight: bold" size="5">Admission/Fee Management System</font></td></tr> 



<tr><td width="60%" align="center">
<table cellpadding=0 cellspacing =0 width="100%" bgcolor="#A89263" border="1" bordercolor="#A89263" height="440">

<tr><td align="center" valign="middle">
<table align="center"><tr><td align="center" height="50"><b><font size="3"><u>OFFICE LOGIN</u></font></b></td></tr></table>
<table align="center"><tr><td><font color="#512800" size="3"><b>Enter User Id & Password</b></font></td></tr></table>
<form  action="<%=request.getContextPath()%>/UserLog.do?method=authenticate" method="post"> 
<table align="center">
<% if((String)request.getAttribute("msg")!=null){%>
<tr><td colspan="2"><font color="red" size="2"><b><%=request.getAttribute("msg")%></b></font></td></tr>
<%}%>
<tr><td align="right"><b><font size="2">LoginID</font></b></td><td><input type="text" name="loginid" style="width:150"></td></tr>
<tr><td align="right"><b><font size="2">Password</font></b></td><td><input type="password" name="password" style="width:150"></td></tr>
<tr><td colspan="2" align="center"><input type=submit value="Login"></td></tr>
</table>    
</form>
<table align="center"><tr><td><html:link action="/fgtpasswd"><font color="#512800"><b>Forget password</b></font></html:link></td></tr></table>
</td></tr></table>
</td>

<td width="40%" align="center">
<table cellpadding=0 cellspacing =0 width="100%" bgcolor="#A89263" border="1" bordercolor="#A89263" height="440">
<tr><td align="center" valign="middle"><font color="#512800" size="3"><b>Online Fee Payment</b></font>


<table align="center">

<tr><td align="right"><b><font size="2">Students click on payment button to pay their fee.</font></b></td></tr>

<tr><td align="center"><a href="<%=request.getContextPath()%>/payment.do">
                        <input type="button" value="Payment" style="width:185px"></a></td></tr>
</table>    

</td></tr></table>
</td>

</tr></table></td></tr>
<tr><td valign="bottom"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
