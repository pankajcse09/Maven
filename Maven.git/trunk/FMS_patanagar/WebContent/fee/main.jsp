<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>




<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/mymenu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/fee/resolution.js"></script>
 <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/menu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/fee/menu.js"></script>
         <title>School Management System</title>
    </head>
    <body>
<% 
	//String sessionid = session.getId();
	String  uid=(String)session.getAttribute("username");
        String  ut=(String)session.getAttribute("usertype");
	
	if(uid == null)
	{
		response.sendRedirect("logout.jsp");
		return;
	}

     session.putValue("uid",uid);
%>
<table cellpadding="0" cellspacing="0" bgcolor="#DCDCDC" class="res" align="center">
    
<tr><td valign="top">
<table cellpadding="0" cellspacing="0"><tr><td><%@include file="topmain.jsp"%></td></tr></table></td></tr>
   <tr><td valign="top">
<table width=100% cellpadding="0" cellspacing="0"><tr><td valign=top><%@include file="schooldropmenu.jsp"%></td></tr></table>
   </td></tr>
   <tr><td><table  class="res" align="center" height=350 cellpadding="0" cellspacing="0"><tr><td></td></tr></table></td></tr>
    
</table>
    </body>
</html>
