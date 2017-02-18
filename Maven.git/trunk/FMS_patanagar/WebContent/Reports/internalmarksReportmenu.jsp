<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Internal Marks Report</title>
    </head>    
    <body>
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center"><tr><td valign="top">
<table width="100%"><tr><td valign="top"><jsp:include page="/toplook.jsp"/></td></tr></table>
<table border="0" bgcolor="#EEEEEE" cellpadding=0 cellspacing=0 width="100%" height="350">
 <tr><td valign="top" height="5%"><jsp:include page="/CommonLinks.jsp"/></td></tr> 
 <tr><td valign="top" align="center">
    <h1>Internal Marks Report</h1>
    <form  action="<%=request.getContextPath()%>/disp" method="post">
        <table>
            <tr><td align="left">Enter Course ID</td><td align="left"><input type="text" name="course"></td></tr>
            <tr><td align="left">Enter Session</td><td align="left"><input type="text" name="session"><br>
            <font color="red" size="1">(yyyy-zzzz)</font></td></tr>
            <tr><td align="left">Enter Student ID</td><td align="left"><input type="text" name="stud"></td></tr>
            <tr><td colspan="2" align="right"><input type="submit" value="Submit"></td></tr>
        </table>
    </form> 
     </td></tr></table> 
     <table width="100%"><tr><td valign="top"><%@include file="/btmnavi.jsp"%></td></tr></table>
     </td></tr></table>     
    </body>
</html>
