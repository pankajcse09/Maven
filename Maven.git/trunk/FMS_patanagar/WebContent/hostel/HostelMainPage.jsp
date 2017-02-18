<%-- 
    Document   : HostelMainPage
    Created on : Mar 1, 2015, 7:29:04 PM
    Author     : kapil
--%>

<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
        </head> 
    <body bgcolor="#999933" onload="popupWin()">
<table width="100%"  cellpadding="0" cellspacing="0"  align="center">

<tr><td align="center" width="100%" style="padding-top:0px" height="100"><%@include file="/hostel/HostelToplook.jsp"%></td></tr>
<tr><td align="center" width="100%">
<table border="0" bgcolor="#FFFFCC"  cellpadding=0 cellspacing=0 width="100%" height="240">  
<tr>
    <!--<td valign="top" width="10%">
<table border="0" bordercolor="" bgcolor="#A89263" cellpadding=0 cellspacing=0 width="100%" height="340">
<tr>
<td align="left" width="100%" valign="top"><%//@include file="/fee/main_menu.jsp"%></td>  
</tr>
</table>
</td>-->
    <td valign="top" width="90%">
<table border="0" bordercolor="" bgcolor="#A89263" cellpadding=0 cellspacing=0 width="100%" height="340">
<tr>
<td align="center" width="100%"><font color="Yellow" style="font-family:Comic Sans MS" size="5">Welcome To Hostel FMS</font></td>  
</tr>
</table>
</td></tr></table></td></tr>
<tr><td valign="bottom"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>

