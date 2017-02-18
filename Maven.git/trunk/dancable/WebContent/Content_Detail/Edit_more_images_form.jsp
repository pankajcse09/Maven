<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<%@page import="moreimg.img_bean"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page language="java"%>

<html>
    <head>
        <title>AKSFASHIONNEWS</title>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=windows-1251">
     
<script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
</HEAD>
<body style="margin-left:80;margin-right:80;margin-top:5">
    
    </head>
    <body>
<table width="100%" height="100%" id="main1" border="0" bordercolor="black" >
<tr><td align="center"  bgcolor="" valign="top">
<!--2nd table-->
<TABLE WIDTH="940" height="8" CELLPADDING=0 CELLSPACING=0 bgcolor="" border="0" bordercolor="red" align="center" style="border-collapse:collapse">
<TR><TD valign=top ><%@ include file="./Registration/top_design.jsp" %></TD></TR>
<TR>
<TD >
<!--2nd table-->
<TABLE WIDTH=100% BORDER="0" CELLPADDING=0 CELLSPACING=0 height="100%" bordercolor="blue">
<TR>
<TD WIDTH=100% HEIGHT=100%>
<!--3rd table-->
<TABLE WIDTH=100% BORDER="0" CELLPADDING=0 CELLSPACING=0 height="50%" bordercolor="black">

 <tr><td>    
<font color="#1C6BA6"><b>Your Image upload here..</font>
</td></tr>  
<tr><td>
<TABLE WIDTH=100% BORDER="0" CELLPADDING=0 CELLSPACING=0 height="50%" bordercolor="black">
        
        <%
      String id=(String)request.getParameter("id");
%>
       
    <form  action="update_more_image.do?method=Edit_more_Images" enctype="multipart/form-data" method="post">
 
    
   <tr> 
      <td>Image</td> 
      <td ><input type="file" name="uploads[0]" size="40" /></td> 
   </tr> 
  
   
   <tr> 
   <input type="hidden" name="id" value="<%=id%>">
   <td> 
   <input type="submit" name="save" value="save">
 
   </td> 
   </tr>   
     
  
</form>   
</table>
   
</TR></TABLE>
</TD>
<!--important for design-->

</TR>

<!--footer close-->  
</TABLE><!--main table close-->
</td></tr></table>
</td></tr></table>

<!-- End ImageReady Slices -->
</BODY>
</HTML>