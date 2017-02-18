<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@page import="java.io.*"%>
<html>
    <head>
        <title>Danceables Management</title>

<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/outline.css">
<script language="javascript" src="<%=request.getContextPath()%>/outline.js"></script>

    </head>
    <body style="margin-left:80;margin-right:80;margin-top:5">
        <div id="conta">
 <table align="center" width="100%" border="0" style="border-collapse:collapse"  >
 <TR><TD vAlign=top colspan="3" ><%//@ include file="./top_design_1.jsp" %></TD></TR>


  
<tr><td VALIGN="TOP">
<table border="1">  

     
  <tr><td height="30" ALIGN="CENTER"  valign="middle" BGCOLOR="WHITE" VALIGN="TOP">
<font style="font-size:22;font-weight:bold;color:BLACK">
    Enter Content </FONT></td></tr>
    
    
        
 <tr><td bgcolor="white"><font style="font-size:22;font-weight:bold;color:Blue">Home</td></tr> 
 <tr><td bgcolor= "white"><a href="./p_cr.do?page_name=home"><font size="3" color="black"><b>*</b></font>&nbsp;Home</a></td></tr>
<tr><td bgcolor= "white"><a href="./p_cr.do?page_name=ravereviews"><font size="3" color="black"><b>*</b></font>&nbsp;Rave Reviews</a></td></tr>
 
 

     
     
 
    
  
    
    
 </table>

</td>
<td  valign="top">
<table border="1">
     <tr><td height="30" ALIGN="CENTER"  valign="middle" BGCOLOR="WHITE" VALIGN="TOP"><font style="font-size:22;font-weight:bold;color:BLACK">
    Enter Detail of  Content </FONT></td></tr>
            
 <tr><td bgcolor="white"><font style="font-size:22;font-weight:bold;color:Blue">Home</td></tr>  
   <tr><td bgcolor= "white"><a href="./fm_home_detail.do?name=home"><font size="3" color="black"><b>*</b></font>&nbsp;Home</a></td></tr>   
   <tr><td bgcolor= "white"><a href="./fm_home_detail.do?name=ravereviews"><font size="3" color="black"><b>*</b></font>&nbsp;Rave Reviews</a></td></tr>  






    </table>
</td>

<td  valign="top">
<table border="1">
 <tr><td height="30" ALIGN="CENTER"  valign="middle" BGCOLOR="WHITE" VALIGN="TOP"><font style="font-size:22;font-weight:bold;color:BLACK">
    Update  Content </FONT></td></tr>
     <tr><td bgcolor="white"><font style="font-size:22;font-weight:bold;color:Blue">Home</td></tr> 
          <tr><td bgcolor= "white"><a href="./fm_home_edit.do?name=home"><font size="3" color="black"><b>*</b></font>&nbsp;Home</a></td></tr>   
          <tr><td bgcolor= "white"><a href="./fm_home_edit.do?name=ravereviews"><font size="3" color="black"><b>*</b></font>&nbsp;Rave Reviews</a></td></tr>  
 


    </table>
</td>
</tr>
</table>
        </div>
    
    </body>
</html>
