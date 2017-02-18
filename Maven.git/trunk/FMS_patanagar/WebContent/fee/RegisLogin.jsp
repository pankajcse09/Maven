<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page language="java"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="AO.*"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>School Management System</title>
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/mymenu.css">
         <script language="javascript" src="<%=request.getContextPath()%>/fee/resolution.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/fee/validation.js"></script>
        <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/menu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/fee/menu.js"></script>      
<script type="text/javascript" src="<%=request.getContextPath()%>/fee/calendarDateInput.js"></script>         
<script language="javascript">     
  function validate(reg){
if(document.reg.userid.value=="")
{
alert("Please enter userid");
document.reg.userid.focus();
return (false);
}        

if(document.reg.password.value=="")
{
alert("Please enter password");
document.reg.password.focus();
return (false);
}    
if(document.reg.secretquestion.value=="")
{
alert("Please enter secretquestion");
document.reg.secretquestion.focus();
return (false);
}    
if(document.reg.answere.value=="")
{
alert("Please enter answere");
document.reg.answere.focus();
return (false);
}    

if(document.reg.gender.value=="")
{
alert("Please enter gender");
document.reg.gender.focus();
return (false);
}
if(document.reg.desig.value=="")
{
alert("Please enter designation");
document.reg.desig.focus();
return (false);
}   

if(document.reg.contactno.value=="")
{
alert("Please enter contact number");
document.reg.contactno.focus();
return (false);
}
if(document.reg.address.value=="")
{
alert("Please enter address");
document.reg.address.focus();
return (false);
}
if(document.reg.email.value=="")
{
alert("Please enter email");
document.reg.email.focus();
return (false);
}
return (true);
}

 </script>  

    </head>
     <body >
   
   <table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center">
<tr><td><jsp:include page="/fee/ftoplook.jsp"/></td></tr>
<tr><td>
<table border="0"  bgcolor="#EEEEEE" cellpadding=0 cellspacing =0 width="100%"  height="330">
<tr><td width="100%"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>   
<tr><td valign="top">
<table align="center" width="100%" cellpadding="2" cellspacing="0" height=450>         
    </td></tr>
    <tr><td valign="top" align="center"> 
    <table align="center"><tr><td><center><font color="#34282C" size="4"><u>Register to Login</u></font></center></td></tr></table>
   
    <form name="reg" action="loginregis.do" method="post" onSubmit="return validate(this.form)" > 
<table border="0" cellspacing="0" width="50%" align="center" cellpadding="0">

     <% if((String)request.getAttribute("existuser")!=null)
   out.println("<font color='red'><b>"+(String)request.getAttribute("existuser")+"</b></font>");%>
   
    <% if((String)request.getAttribute("existboth")!=null)
   out.println("<font color='red'><b>"+(String)request.getAttribute("existboth")+"</b></font>");%>    
  

<tr><td>Userid:</td><td><input type=text size="20" name="userid" value=""></td></tr> 
<tr><td>Password:</td><td><input type=password size="22" name="password" value=""></td></tr> 
<tr><td>Usertype</td><td><select name="usertype"><option value=""></option><option value="Admin">Admin<option value="Super">Super User</select></td></tr>
<tr><td>Secret Question </td><td><input type="text" name="secretquestion" value=""></td></tr>
<tr><td>Answere </td><td><input type="text" name="answere" value=""></td></tr>
<tr><td>Name</td><td><input type="text" name="name" value=""></tr>
<tr><td>Gender</td><td><select name="gender"><option value=""></option><option value="Male">Male<option value="Female">Female</select></td></tr>
<tr><td>Date of Birth</td><td><script>DateInput('dob', true, 'dd/mm/yyyy')</script></td></tr>
<tr><td>Designation:</td><td><input type="text" name="desig" value=""></tr>
<tr><td>Contact No.</td><td><input type="text" name="contactno" value=""></td></tr>
<tr><td>Address</td><td><textarea cols="17" rows="3" name="address"></textarea></td></tr>
<tr><td>Email</td><td><input type="text" name="email" value=""></td></tr>
   </table>    
   <table height="70" bgcolor="" width="10%" align="center">
                <tr>
                    <td></td>
                    <td valign="bottom"><input type="submit" value="submit"></td>
                </tr>
 </table>

    </form>
</td></tr></table>
</td></tr></table>
    </body>
</html>

