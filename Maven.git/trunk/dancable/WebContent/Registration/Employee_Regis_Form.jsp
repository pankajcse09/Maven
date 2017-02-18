<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page import="java.util.ArrayList"%>


<%@page language="java"%>
<%@page import="java.io.*"%>

<%@page contentType="text/html"%>


  <!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Danceables</title>
 <script language="javascript" src="<%=request.getContextPath()%>/css_js/resolution.js"></script>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/change.css" />
        <script language="javascript" src="<%=request.getContextPath()%>/css/menu.js"></script>

    </head>
      

    <body>


    
             
<table width="100%" border="0" style="border-collapse:collapse" cellspacing="0" cellpadding="0">
    
   <TR><TD valign="top"><%@ include file="./top_design_1.jsp" %></TD></TR>
   <tr><td height="450" valign="top">  
        
                
             <table border="0" width="100%"  bgcolor="#ffffff">
                <tr><td VALIGN="TOP" width="50%">
                    <table>
                        <tr><td colspan="2">SIGN IN</td></tr>
                        <tr><td> <FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Login ID</td>
        <td><input type="text" name="name" style="width:120" value=""></td></TR>
<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Password</td>
<td><input type="text" name="loginid" style="width:120"  value=""></td></tr> 
<tr><td align="center" colspan="2" class="SubmitB"><input type="submit" name="regBtn" id="regBtn" value="LOGIN" /></td></tr>

                    </table>
                </td>


<td valign="top" width="50%" bgcolor="#ffffff">
    <table>
        <tr><td colspan="2">NEW CUSTOMER</td></tr>
       <tr><td> <FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Your First Name</td>
        <td><input type="text" name="name" style="width:120" value=""></td></TR>
        <tr><td> <FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Last Name</td>
        <td><input type="text" name="last_name" style="width:120" value=""></td></TR>
        
<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Email Address</td>
<td><input type="text" name="emailid" style="width:120"  value=""></td></tr> 
             <tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Login ID</td>
<td><input type="text" name="loginid" style="width:120"  value=""></td></tr>  
<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Password</td>
<td><input type="password" name="password" value="" style="width:120"></td></tr>
<td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Confirm Password</td>
<td><input type="password" name="cpassword" value="" style="width:120"></td></tr>
 <tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Phone Number</td>
<td><input type="text" name="mobileno" style="width:120"  value=""></td></tr> 
<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Address</td>
<td><input type="text" name="homeaddress" style="width:120"  value=""></td></tr> 
<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">City</td>
<td><input type="text" name="city" style="width:120"  value=""></td></tr> 
<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">State</td>
<td><input type="text" name="state" style="width:120"  value=""></td></tr> 

<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Zip/Postal</td>
<td><input type="text" name="pincode" style="width:120"  value=""></td></tr> 
<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Country/Region</td>
<td><input type="text" name="country" style="width:120"  value=""></td></tr> 

<tr><td class="SubmitB"><input type="submit" name="regBtn" id="regBtn" value="REGISTER" /></td></tr>
    </table>
</td></tr>
                </table>
               
       </td></tr>
        
</table>
   <tr><td vAlign=top ><%@ include file="/jsp/hrms_footer.jsp" %></td></tr> 
</div>
   
    
    </body>
</html>

