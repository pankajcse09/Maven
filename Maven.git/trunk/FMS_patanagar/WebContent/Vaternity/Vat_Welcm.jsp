<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page language="java"%>
<%@page import ="java.sql.* "%>
<%   
     if(session.getAttribute("backto1")!=null){
    session.removeAttribute("backto1");
   }
 if(session.getAttribute("backto")!=null){
      session.removeAttribute("backto");
   }
   session.setAttribute("backto","Vat_Welcm.do?para=Vatern"); 
   %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<meta http-equiv="Content-Language" content="en-us">
 <title>Home1</title>
<base target="_parent"><link rel="stylesheet" type="text/css" href="/Exam/mystyle1.css">
<met<base target="_para name="Microsoft Theme" content="journal 1111, default">
<meta name="Microsoft Border" content="tlb, default">
<link rel="stylesheet"  href="/Exam/menu.css">
<script language="javascript" src="/Exam/menu.js">
</SCRIPT>
<script language="javascript" src="/Exam/resolution.js">
</script>
</head>
<body>
<table width="100%" bgcolor="green"><tr><td valign="top" align="center">
<font color="white" size="5"><b>Exam Management System</b></font>
</td></tr></table>
<table width="100%"><tr><td width="100%"><%@include file="Topnavi.jsp"%></td></tr></table>
<table width="100%" height="500" valign="top" bgcolor="lightyellow"><tr><td valign="top">
<table dir="ltr" border="0" width="100%" height="300" cellpadding="0" cellspacing="0" class="hh"><tr><td valign="top" height="300">
<table border="1" width="165" height="300" cellpadding="0" cellspacing =0 style="border-collapse: collapse; border-color: #FFFFFF" bordercolor="#111111" id="AutoNumber1" bordercolorlight="#000000"  bordercolordark="#000000" background="/Exam/image/leftnav.jpg" class="tt">
  <tr height="0">
    <td width="152" align="center" height="0" valign="top"><html:link action="/Aus">About 
Us</html:link></td>
  </tr>  
  <!--<tr  height="0">
  <td width="152" align="center" height="0" valign="top"><html:link 
action="/recmsg">recivemsg</html:link></td>
  </tr>-->
  <tr  height="0">
    <td width="152" align="center" height="0" valign="top"><html:link 
action="/usmsg.do?pr=1">Inbox</html:link></td>
  </tr>
  
  <tr height="0">
    <td width="152" align="center"  height="0" valign="top"><html:link 
action="/Lib">Library</html:link></td>
  </tr>
  <tr height="0">
   
    <td width="152" align="center" height="0" valign="top"><html:link action="/prof">My Profile</html:link></td>
  </tr>
  <tr height="0">
    <td width="152" align="center" height="0" valign="top"><html:link 
action="/Res">Research</html:link></td>
  </tr>
  <tr height="0">
    <td width="152" align="center" height="0" valign="top"><html:link action="/Camp">Campus 
Community</html:link></td>
  </tr>
  <tr height="0">
    <td width="152" align="center" height="0" valign="top"><html:link 
action="/ExCm">Extension Education</html:link></td>
  </tr>
  <tr height="0">
    <td width="152" align="center" height="0" valign="top"><html:link 
action="/Alum">Alumni</html:link></td>
  </tr>
  <tr height="0">
    <td width="152" align="center" height="0" valign="top"><html:link 
action="/Comm">Communication</html:link></td>
  </tr>
  <tr height="0">
    <td width="152" align="center" height="0" valign="top" ><html:link 
action="/gbw">Working at GBPUAT</html:link></td>
  </tr>
   <tr height="0">
    <td width="152" align="center" height="0" valign="top" ><html:link 
action="/vst">Visitors</html:link></td>
  </tr>
   <td width="152" align="center" height="0" valign="top" ><html:link 
action="/search_name.do?pr=1">ComposeMail</html:link></td>
  </tr>
   <tr>
   <td width="152" align="center" height="0" valign="top" ><html:link 
action="/CalMsgInbox.do?pr=1">Meeting Scheduling</html:link></td>
  </tr>
   <tr>
   <td width="152" align="center" height="0" valign="top" ><html:link 
action="/MyCalendar.do">My Calendar</html:link></td>
  </tr>
<!--<td width="152" align="center" height="0" valign="top" ><html:link 
action="/dep_fetch.do">search</html:link></td>-->
</table>
</td>
<td valign="top" height="300" bgcolor="lightblue">
<table border="0" cellpadding="0" cellspacing =0 style="border-collapse: collapse; 
border-color: #FFFFFF" bordercolor="#111111" height="300" width="400" id="AutoNumber1" 
bordercolorlight="#000000"  bordercolordark="#000000" valign="top"><tr><td valign="top">
<img src="/Exam/image/collvet1.jpg" height="300" class="ff1">
</td></tr></table></td>
<td valign="top" align="right" height="300" class="ff1" bgcolor="lightblue">
 <table height="300" align="right">   
<tr><td><b><font size="2" color="#993333">Message from HOD</td></tr>
<tr><td><b><font size="2" color="#993333">Message from Advisor</td></tr>
<tr><td><a href ="asign.do?pr=1"><font size="2" color="#993333"><b> Assignments</b></font></td></tr>
<tr><td><b><font size="2" color="#993333">Current Courses</td></tr>
<tr><td><a href ="res_cour.do?pr=1"><font size="2" color="#993333"><b>Reserve a Course</b></font></a></td></tr>
<tr><td><b><font size="2" color="#993333">Credits</b></td></tr>    
<tr><td><b><font size="2" color="#993333">Overall Performance</td></tr>
<tr><td><b><font size="2" color="#993333">Upcoming Test/Exams</td></tr>    
<tr><td><a href ="<%=request.getContextPath()%>/shareproj.do?pr=1"><font size="2" color="#993333"><b> Share the project</b></font></a></td></tr>
<tr><td><a href ="<%=request.getContextPath()%>/add_course.do?para=1"><font size="2" color="#993333"><b>Add Courses Details</b></font></a></td></tr>
<tr><td><b><font size="2" color="#993333">Vocational Courses</font></b></td></tr>
<tr><td><a href ="<%=request.getContextPath()%>/Cors_assign_teach.do?pr=1"><font size="2" color="#993333"><b>Courses Assign To Teacher</b></font></a></td></tr>
<tr><td><a href ="<%=request.getContextPath()%>/View_Cors_assign_teach.do?pr=1"><font size="2" color="#993333"><b>View Assign Courses</b></font></a></td></tr>
</table></td></tr></table>
</td></tr></table>
<jsp:include page="/footer.jsp"/>
</body>
</html>