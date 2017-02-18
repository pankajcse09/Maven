<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page language="java"%>
<%@page import="com.myapp.struts.*"%>
<%@page import="AO.*"%>


   <!-- Developed by : Sonal Sharma
          Company      : IntelMind     -->
  
<html>
    <head>
     <title>School Management System</title>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <script type="text/javascript" src="calendarDateInput.js"></script>  
      <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
      <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
      <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>
  <script language="javascript">
   
  function validate(profile)
{
if(document.profile.name.value=="")
{
alert("Please enter the name of employee");
document.profile.name.focus();
return (false);
}

if(document.profile.gender.value=="")
{
alert("Please enter gender");
document.profile.gender.focus();
return (false);
}

if(document.profile.address.value=="")
{
alert("Please enter Personal Address");
document.profile.address.focus();
return (false);
}
if(document.profile.phone.value=="")
{
alert("Please enter Phone Number");
document.profile.phone.focus();
return (false);
}

if(document.profile.qualification.value=="")
{
alert("Please enter qualification");
document.profile.qualification.focus();
return (false);
}
if(document.profile.designation.value=="")
{
alert("Please enter designation of employee");
document.profile.designation.focus();
return (false);
}
return (true);
}
 </script>
<title>Employee Profile</title>

    </head>
    <body >
                
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center">
<tr><td><jsp:include page="/fee/ftoplook.jsp"/></td></tr>
<tr><td>
<table border="0"  bgcolor="#EEEEEE" cellpadding=0 cellspacing =0 width="100%"  height="330">
<tr><td width="100%"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>   
<tr><td valign="top">
 <table height=450 align="center" width="100%" border="0"><tr><td valign="top">
    <table width="100%" align="center"><tr><td width="100%" align="center"><font color="#34282C" size="4"><b>Employee Information</b></font></td></tr></table>
 </td></tr>
    
     <form action="PProfile.do" onsubmit="return validate(this.form)" name="profile">
    
   <%
  String name=request.getParameter("name");
   %>
  

<tr>
<td>
<table width="100%" height="30">
 <%       
     if((String)request.getAttribute("exist")!=null)
   out.println("<font color='red'><b>"+(String)request.getAttribute("exist")+"</b></font>"); %>
  
  <% if((String)request.getAttribute("message")!=null)
               out.println("<font color='red'><b>"+(String)request.getAttribute("message")+"</b></font>");
   %> 
</table>
</td></tr>
<tr><td height="20"></td></tr>
<tr><td>
<table width="50%" align="center">
<tr>
<td>Name:</td><td><input type="text" name="name" value="" size="20"></td> 

</tr>   
 
<tr> 
<td>Gender</td><td><select name="gender">    
                 <option value=""></option>
                 <option value="male">male</option>
                 <option value="female"> Female</option>
</select></td>
</tr>

<tr>
<td>DOB:</td><td align="left"><script>DateInput('dob', true, 'dd/mm/yyyy')</script></td> 
</tr>

<tr>
<td>Personal Address:</td><td><textarea cols="20" rows="5" name="address" value=""></textarea></td>
</tr> 

<tr>
<td>Phone:</td><td><input type="text" name="phone" value="" size="20"></td>
</tr>
 
<tr>
<td>Date Of Join:</td><td align="left"><script>DateInput('doj', true, 'dd/mm/yyyy')</script></td>
</tr>
<tr> 
<td>Qualification:</td><td><textarea cols="20" rows="5" name="qualification" value=""></textarea></td>
</tr>
<tr>
<td>Designation:</td><td><input type="text" name="designation" value="" size="20"></td>
</tr>

</table>
</td>
</tr><tr><td>
<table height="70" align="center">
    <tr><td valign="bottom" align="center">
   
      <input type="submit" value="Submit" align="center">
      
       </td></tr>
</table></td></tr>
      
     </form>
</td></tr></table>
</td></tr></table>

    </body>
     </html>

