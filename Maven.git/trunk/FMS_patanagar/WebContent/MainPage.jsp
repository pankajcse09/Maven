<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<html>
    <head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<meta http-equiv="Content-Language" content="en-us">

<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>          
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
 <title>Home</title>
<base target="_parent">
<meta name="Microsoft Border" content="tlb, default">
        <title>Add New Course</title>
        <script language="javascript"></script>
        </head> 
    <body>
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#34689A" align="center"><tr><td valign="top">
<table width="100%"><tr><td valign="top"><jsp:include page="/toplook.jsp"/></td></tr></table>
<table border="0" bgcolor="#EEEEEE" cellpadding=0 cellspacing=0 width="100%" height="350">
 <tr><td valign="top" height="5%"><jsp:include page="/CommonLinks.jsp"/></td></tr> 
<tr><td valign="top">
<table width="100%" align="left" bgcolor="lightblue" border="1" style="border-collapse:collapse">
<tr><td valign="middle"><a href="<%=request.getContextPath()%>/regis.jsp"><font color="blue" style="font-family:TimesNewRoman" size="2"><b>Registration</b></font></a></td></tr>
<tr><td valign="top" align="left" height="5%">
<a href="<%=request.getContextPath()%>/Courses_Detail/UpCourseSession.jsp"><font color="blue"><b>Update Course for Next Session</b></font></a> 
</td></tr>
<tr><td valign="top" align="left" height="5%">
<a href="<%=request.getContextPath()%>/StudentStatusReport.jsp"><font color="blue"><b>Student Status Report</b></font></a> 
</td></tr></table>
</td></tr></table></td></tr>
<tr><td valign="top">
<table width="100%" bgcolor="#5663C7"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr></table>
</body>
</html>
