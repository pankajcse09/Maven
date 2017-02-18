<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>

<%@page import="ActionClass.JavaBean1"%>
<html>
<title>Danceables</title>
 <script language="javascript" src="<%=request.getContextPath()%>/css_js/resolution.js"></script>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/change.css" />
        <script language="javascript" src="<%=request.getContextPath()%>/css/menu.js"></script>
         
         </head>
 <body>

<% 
JavaBean1 jb=new JavaBean1();
if(request.getAttribute("jbean")!=null){
jb=(JavaBean1)request.getAttribute("jbean");    
}
%>
<div id="conta">
	
         
          
              
               
<table width="100%" border="0" style="border-collapse:collapse" cellspacing="0" cellpadding="0">
    
 <TR><TD valign="top"><%@ include file="./top_design_1.jsp" %></TD></TR> 
  

  
<tr>
<td valign="top" height="450">


<form name="f1" method="post" action="<%=request.getContextPath()%>/EditUserRegist.do?method=editUserAction">      
<table align="center" bgcolor="white" border="0" width="100%" style="padding-left: 20px">
<%if(request.getAttribute("msg")!=null){%>
<tr><td colspan="4"><font color="red"><b><%=request.getAttribute("msg")%></b></font></td></tr>   
<%}%>     
 

  <tr><td colspan="4" height="4"><FONT STYLE="font-weight:bold;color:red;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">Welcome-<%=username%> &nbsp;</font> </td></tr>

 <tr><td colspan="4" height="4"><FONT STYLE="font-weight:bold;color:blue;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">Edit Your Profile Here.... </font></td></tr>  
  
 

<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">Name</td><td><input type="text" name="name"  style="width:140" value="<%=jb.getName()%>"></td>
 <td><FONT STYLE="font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">Last Name</td><td><input type="text" name="last_name" style="width:140" value="<%=jb.getLast_name()%>"></td>
</tr> 

<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">Login ID</td><td  colspan="3" style="width:140"><%=jb.getLoginid()%></td> </tr>
<input type="hidden" name="loginid" value="<%=jb.getLoginid()%>">

<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">Password</td><td><input type="password" name="password" value="<%=jb.getPassword()%>" style="width:140"></td>

<td><FONT STYLE="font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">Confirm  Password</td><td><input type="password" name="cpassword" value="" style="width:140"></td></tr>

<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">Secret   Question</td><td><input type="text" name="secretques" value="<%=jb.getSecretques()%>" style="width:140"></td>

<td><FONT STYLE="font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">Secret   Answer</td><td><input type="text" name="secretans" value="<%=jb.getSecretans()%>" style="width:140"></td></tr>

<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">Home Address Line 1</td><td><input type="text" name="homeaddress"  value="<%=jb.getHomeaddress()%>" style="width:140"></td>
<td><FONT STYLE="font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">Home Address Line 2</td><td><input type="text" name="homeaddress2" style="width:140" value="<%=jb.getHomeaddress2()%>"></td>
</tr> 

<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">city</td><td><input type="text" name="city" style="width:140" value="<%=jb.getCity()%>"></td>
<td><FONT STYLE="font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">state</td><td><input type="text" name="state" style="width:140" value="<%=jb.getState()%>"></td>
</tr> 

<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">pincode</td><td><input type="text" name="pincode" style="width:140" value="<%=jb.getPincode()%>"></td>
<td><FONT STYLE="font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">country</td><td><input type="text" name="country" style="width:140" value="<%=jb.getCountry()%>"></td>
</tr> 


<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">Telephone No.</td><td><input type="text" name="telno" style="width:140" value="<%=jb.getTelno()%>"></td>
<td><FONT STYLE="font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">Mobile No.</td><td><input type="text" name="mobileno" style="width:140" value="<%=jb.getMobileno()%>"></td>
</tr> 





<tr><td colspan="4" align="center"><input type="submit" value="Submit"></td></tr>
</table>   


</form> 

</td></tr></table>



<TR><TD vAlign=top ><%@ include file="/jsp/hrms_footer.jsp" %></td></tr>
  </div>
</body>


</html>