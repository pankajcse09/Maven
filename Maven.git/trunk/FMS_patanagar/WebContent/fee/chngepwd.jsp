<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="aliceblue">

    <html>
    <head> <title>School Management System</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/mymenu.css">
         <script language="javascript" src="<%=request.getContextPath()%>/fee/resolution.js"></script>
        <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/menu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/fee/menu.js"></script>        
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
     <table class="res" cellpadding="0" cellspacing="0" align="center" bgcolor="DCDCDC">
<tr><td><% if(ut.equals("Admin")){%>
<%@include file="topmain.jsp"%>

<%} else if(ut.equals("Super")){%>
<%@include file="Supertopmain.jsp"%>
<%}%>
</td></tr>
 <table width=100% cellpadding="0" cellspacing="0"><tr><td valign=top>
<% if(ut.equals("Admin")){%>
<%@include file="schooldropmenu.jsp"%>

<%} else if(ut.equals("Super")){%>
<%@include file="Superschooldrop.jsp"%>
<%}%>
</td></tr></table>
   </td></tr>
 <tr><td valign="top"> 
    <table align="center"><tr><td align="center"><h2><font color="#34282C" size="4"><u>Change Password</u></font></h2></td></tr></table>
    <% if((String)request.getAttribute("existuser")!=null)
   out.println("<font color='red'><b>"+(String)request.getAttribute("existuser")+"</b></font>");%>    
     <form name="chng" action="changepass" method="post">
 <table width="" align="center" border="1">
     <tr><td>Old Password :</td><td><input type="password" name="opass" value=""></td></tr>
     <tr><td>New Password :</td><td><input type="password" name="npass" value=""></td></tr>
      <tr><td>Secret Question :</td><td><input type="text" name="sq" value=""></td></tr>
       <tr><td>Answere :</td><td><input type="text" name="ans" value=""></td></tr>
       <tr><td height="20"></td></tr>
   <tr><td align="right"><input type="submit" value="Change Password"></td></tr>
 </table>
   </form>
   </td></tr></table>     
    </body>    
</html>
