<%-- 
    Document   : Employee_Regis_Form
    Created on : Oct 20, 2014, 6:11:22 PM
    Author     : kapil
--%>


<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="ActionClass.JavaBean1"%>
<%
JavaBean1 jb=new JavaBean1();
if(request.getAttribute("jbean")!=null){
jb=(JavaBean1)request.getAttribute("jbean");    
}

%>

<html>
<head>
    <script language="javascript" src="<%=request.getContextPath()%>/JSF/CheckNumericData.js"></script> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/JSF/printData.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/JSF/jquery.min.js"></script>
         <script>
             $(document).ready(function(){
$('#regisFor').on("change",function() {
  var type=$('#regisFor').val();
  if(type=='college'||type=='hostel'){
  var url="./Registration/type.jsp";
url=url+"?type="+type;
//alert(url);
$.get( url, function( response ) {
    document.getElementById("replace1").innerHTML="<font color='red'>*</font><font id='type' STYLE='font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;'>"+type+"</font>";
    document.getElementById("replace2").innerHTML=response; // server response
});
  }
  else{
      document.getElementById("replace1").innerHTML="";
    document.getElementById("replace2").innerHTML="";
  }
});

            });
          
         </script>
         <script language="javascript">
             function validate(){
                 if(document.f1.user_type.value==""){
                     alert("Please select user.");
                     document.f1.user_type.focus();
                     return false;
                 }
                 if(document.f1.login_for.value==""){
                     alert("Please select registration for.");
                     document.f1.login_for.focus();
                     return false;
                 }
                 if(document.f1.loginfor_name!=null){
                 if(document.f1.loginfor_name.value==""){
                     alert("Please select "+document.getElementById("type").innerHTML+".");
                     document.f1.loginfor_name.focus();
                     return false;
                 }}
                 if(document.f1.loginid.value==""){
                     alert("Please enter loginid.");
                     document.f1.loginid.focus();
                     return false;
                 }
                 if(document.f1.password.value==""){
                     alert("Please enter password.");
                     document.f1.password.focus();
                     return false;
                 }
                 if(document.f1.cpassword.value==""){
                     alert("Please enter confirmation password.");
                     document.f1.cpassword.focus();
                     return false;
                 }
                 if(document.f1.cpassword.value!=document.f1.password.value){
                     alert("Confirmation password is not matching with the original password.");
                     document.f1.cpassword.focus();
                     return false;
                 }
                 if(document.f1.name.value==""){
                   alert("Please enter the name.");
                     document.f1.name.focus();
                     return false;
                 }
             }
         </script>
<title>Employee/User Registration</title>
</head>
<body bgcolor="#999933">
    <style>
             input[type=button] {
                 cursor: pointer;
    
    background-color: #A89263;
    color: #333333;
    padding: 2px 6px 2px 6px;
    border-top: 1px solid #CCCCCC;
    border-right: 1px solid #333333;
    border-bottom: 1px solid #333333;
    border-left: 1px solid #CCCCCC;
   }
   
   input[type=button]:hover {
       background-color: #EEEEEE;
   }
   
   .vr {
    width:2px;
    background-color:#000;
    position:absolute;
    top:151px;
    height: 447px;
    left:300px;
}
         </style>  

 <table width="100%" class="res" cellpadding="0" cellspacing="0" align="center">
<tr><td align="center" width="100%" style="padding-top:0px" height="100"><%@include file="/fee/toplook_1.jsp"%></td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
 <tr><td valign="top" style="padding-left: 5px" width="160">            
            <%@include file="/utility/rolesmenu.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left">  
                 <table width="60%" align="center">
                     <tr><td height="40" ></td></tr>
                     <tr><td align="left"><font color="yellow" size="3"><b>
                                 <%if(request.getAttribute("msg")!=null){%><%=request.getAttribute("msg")%><%}%>  </b></font></td></tr>
                     <tr><td width="100%" valign="middle" align="center" bgcolor="white" height="40" >
    <font style="font-size:15;color:black;font-weight:bold">Employee/User Registration</font></td></tr>
                 </table>
<form name="f1" method="post" action="<%=request.getContextPath()%>/UserRegist_emp.do?method=registUserAction_Emp" onsubmit="return validate();">
<table width="70%" align="center" bgcolor="lightyellow" border="0">
<tr><td><font color="red">*</font>
        <FONT STYLE="font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">Select User</td>
<td>
<select name="user_type">
<option value="">Select One</option>    
<option value="Normal">Normal User</option>
<option value="Employee">Employee</option>
<option value="Manager">Manager</option>
</select>
</td>
<td><font color="red">*</font>
    <FONT STYLE="font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">Registration for</td>
<td>
<select id="regisFor" name="login_for">
<option value="">Select One</option>    
<option value="office">office</option>
<option value="college">college</option>
<option value="hostel">hostel</option>
</select>
</td>
</tr> 


<tr><td><font color="red">*</font>
        <FONT STYLE="font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">Login ID</td>
    <td><input type="text" name="loginid" style="width:120"  value="<%=jb.getLoginid()%>"></td>
<td id="replace1"></td>
    <td id="replace2"></td>
</tr>  
<tr><td><font color="red">*</font>
        <FONT STYLE="font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">Password</td>
    <td><input type="password" name="password" value="<%=jb.getPassword()%>" style="width:120"></td>
<td><font color="red">*</font>
    <FONT STYLE="font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">Confirm Password</td>
<td><input type="password" name="cpassword" value="" style="width:120"></td></tr>



<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">Secret Question</td><td><input type="text" name="secretques" style="width:120" value="<%=jb.getSecretques()%>"></td>
<td><FONT STYLE="font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">Secret Answer</td><td><input type="text" name="secretans" style="width:120" value="<%=jb.getSecretans()%>"></td></tr>


<tr><td> <font color="red">*</font><FONT STYLE="font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">Name</td><td><input type="text" name="name" style="width:120" value="<%=jb.getName()%>"></td>

</tr> 

<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">Home Address Line 1</td><td><input type="text" name="homeaddress" style="width:120" value="<%=jb.getHomeaddress()%>"></td>
<td><FONT STYLE="font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">Home Address Line 2</td><td><input type="text" name="homeaddress2" style="width:120" value="<%=jb.getHomeaddress2()%>"></td>
</tr> 

<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">city</td><td><input type="text" name="city" style="width:120" value="<%=jb.getCity()%>"></td>
<td><FONT STYLE="font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">state</td><td><input type="text" name="state" style="width:120" value="<%=jb.getState()%>"></td>
</tr> 

<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">pincode</td><td><input type="text" name="pincode" style="width:120" value="<%=jb.getPincode()%>"></td>
<td><FONT STYLE="font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">country</td><td><input type="text" name="country" style="width:120" value="<%=jb.getCountry()%>"></td>
</tr> 


<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">Telephone No.</td><td><input type="text" name="telno" style="width:120" value="<%=jb.getTelno()%>"></td>
<td><FONT STYLE="font-weight:bold;color:black;font-size:13;line-height:2;font-family: Arial, Helvetica, sans-serif;">Mobile No.</td><td><input type="text" name="mobileno" style="width:120" value="<%=jb.getMobileno()%>"></td>
</tr> 





<tr><td colspan="4" align="center" width="100%"><input type="submit" value="Submit"></td></tr>
</table>   


</form> 
<table>
   <tr><td height="20"></td></tr> 
</table>
</td></tr></table>
           </td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
