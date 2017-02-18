<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu1.css">
        <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></SCRIPT>
        <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></SCRIPT>
        

    
    </head>
    <body bgcolor="white">
<table class="res" bgcolor="white"><tr><td height="10"></td></tr></table>
    <table cellpadding="0" cellspacing="0"  class=res bgcolor="#D3D3D3" align="center" >

<tr><td>
<table class=res bgcolor="#696969" height="25">
<tr><td class="dd" align="center" class=res ><font color="#F5F5F5">Stock Management System</font></td></tr>
 <tr><td><hr></td></tr>
 <tr>     
 <td bgcolor="#696969" align="left" >
 <html:link action="/mp.do" styleClass="menuitem" target="_top" ><font color="#f5f5f5" style="TimesRoman" size="2"><b>Home</b></font></html:link>
 </td></tr>
</table></td></tr>


</table>
    
    </body>
</html>
