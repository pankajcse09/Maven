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

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
        <title>School Management System</title>
    </head>
    
    
         
    <body>
<table class="res" cellpadding="0" cellspacing="0" align="center" bgcolor="#D3D3D3">
   <tr><td>
<img src="<%=request.getContextPath()%>/image/sms.jpg" wmode="transparent" width="100%" height="80">
</td></tr>
<tr><td valign="top">
   <table width="100%" cellpadding="0" cellspacing="0" height=29 bgcolor="#D3D3D3"><tr>
<td>

<td><img src="./image/sep.gif" width="1" height="18"></td>
<td> 
<div align="right"><html:link action="/login"><font size=3 color="maroon">Login</font></html:link></div>
</td></tr>
   </table></td></tr>

  <tr><td bgcolor="#A52A2A"><table width="100%" cellpadding="0" cellspacing="0" bgcolor="#A52A2A" height=28><tr><td bgcolor="#A52A2A">
<table width="50%" cellpadding="0" cellspacing="0" bgcolor="#A52A2A" align="right"><tr>

</tr>
</table></td></tr></table></td></tr>
 <tr><td bgcolor="#A52A2A">
<table  width="100%" cellpadding="0" cellspacing="0" align="left" bgcolor="#A52A2A">
<tr>  
<td align="left" bgcolor="#CCCCCC"  width="570"><img src="<%=request.getContextPath()%>/image/cap.jpg" height="250" width="600"></td>

<td> <marquee direction="up" scrolldelay="300">
    <font size="4"><b><i>Fee Management System</i></b></font>
</marquee></td> 

</tr><tr>
<td>
<table  width="100%" cellpadding="0" cellspacing="0" align="left" bgcolor="#F5F5F5">
<tr><td valign="top" width="210" bgcolor="#DCDCDC"><table bgcolor="#DCDCDC"><tr><td bgcolor="#A52A2A" align=left height="22"></td></tr>
<tr><td bgcolor="#DCDCDC"><img src="<%=request.getContextPath()%>/image/pic2.jpg" height="110" width="130"></td></tr>
<tr><td bgcolor="#DCDCDC" align="center" width="210"> </td></tr></table></td>
<td valign="top" bgcolor="#CCCCCC"><table bgcolor="#CCCCCC"><tr><td bgcolor="#A52A2A" align=left height="22"></td></tr>
<tr><td bgcolor="#CCCCCC" width="210" height=60><img src="<%=request.getContextPath()%>/image/pic3.png" height="110" width="130"></td></tr>
<tr><td bgcolor="#CCCCCC" align="left">
</td></tr></table></td>
<td valign="top" bgcolor="#DCDCDC"><table bgcolor="#DCDCDC"><tr><td bgcolor="#A52A2A" align=left height="22"></td></tr>
<tr><td bgcolor="#DCDCDC" width="210"><img src="<%=request.getContextPath()%>/image/pic4.jpg" height="110" width="130"></td></tr>
<tr><td bgcolor="#DCDCDC" align="left"></td></tr></table></td>
<td valign="top" bgcolor="#CCCCCC"><table bgcolor="#CCCCCC"><tr><td bgcolor="#A52A2A" align=left height="22"></td></tr>
<tr><td bgcolor="#CCCCCC" width=210><img src="<%=request.getContextPath()%>/image/pic7.jpg" height="110" width="130"></td></tr>
<tr><td bgcolor="#CCCCCC" align="left"></td></tr></table></td>
</tr>
</table></td></tr>

  </table>
    </body>
</html>
