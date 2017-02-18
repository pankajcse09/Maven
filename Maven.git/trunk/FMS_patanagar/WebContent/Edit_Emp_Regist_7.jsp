<%@page import="com.myapp.struts.Dataconnectivity,java.util.*"%>
<%@page import="java.sql.*,ActionClass.JBeanEmp"%>
<%@ page language="java"%>
<!DOCTYPE html>
<%    
int rid=0;
String eid="";
ArrayList ar=new ArrayList();
JBeanEmp jb=new JBeanEmp();
JBeanEmp jb1=new JBeanEmp();
if(request.getAttribute("arr")!=null){
ar=(ArrayList)request.getAttribute("arr");    
}
if(request.getAttribute("jbean")!=null){
jb=(JBeanEmp)request.getAttribute("jbean");  
}
%>
<html>
  <head>
  <title>Employee Registration Form</title>
  <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<meta http-equiv="Content-Language" content="en-us">
<script language="javascript" src="<%=request.getContextPath()%>/calendarDateInput.js"></script> 
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>          
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
  <script language="javascript">
function validate(){
if(document.f1.empid.value==""){
alert("Enter Employee ID");
document.f1.empid.focus();
return (false);
}
if(document.f1.loginid.value==""){
alert("Enter Login ID");
document.f1.loginid.focus();
return (false);
}
if(document.f1.password.value==""){
alert("Enter Password");
document.f1.password.focus();
return (false);
}
 var passwstr=document.f1.password.value;
 if(passwstr.length<6) {
 alert("Password should not less than 6 characters"); 
 document.f1.password.focus();
 return (false);}
 if(passwstr.length>16){
 alert("Password should not greater than 16 characters"); 
 document.f1.password.focus();
 return (false);
 }
  if(document.f1.password1.value!=document.f1.password.value){
  alert("Password Mismatch");
  document.f1.password1.focus();
  return (false);
  }
if(document.f1.question.value==""){
alert("Enter Question");
document.f1.question.focus();
return (false);
}
 var secqu=document.f1.question.value;
 if(secqu.length>70){
  alert("Secret Question should not greater than 70 characters"); 
 document.f1.question.focus();
 return (false);
 }
 var secans=document.f1.answer.value;
 if(secans.length>70){
 alert("Secret Answer should not greater than 70 characters"); 
 document.f1.answer.focus();
 return (false);
 }
if(document.f1.answer.value==""){
alert("Enter Answer");
document.f1.answer.focus();
return (false);
}
return (true);
}
  </script>  
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
<tr><td align="center" width="100%" style="padding-top:50px" height="100"><%@include file="/fee/toplook_1.jsp"%></td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
 <tr><td align="left"  valign="top" style="padding-left: 5px;" align="left"><font color="green" style="font-family:Times New Roman" size="4"><strong>Registration/Student Utilities</strong></font></td>
     <td width="2" bgcolor="#000000"></td>
            </tr>
            <tr><td align="left" valign="top" style="padding-left: 5px;" width="200">            
            <%@include file="/fee/regist.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left">
<table width="100%" bgcolor="#A89263">
    <tr><td width="100%" align="right"><a href="<%=request.getContextPath()%>/EditEmployee.do"><font color="#000080"><u>Edit Employee Utilities</u></font></a></td></tr>
</table>       
<form name="f2" method="post" action="<%=request.getContextPath()%>/Emp7.do?method=eDetail7">
<table align="center" width="100%" bgcolor="#A89263" style="padding-left: 50px">
<tr><td align="left">Select Employee ID
<select name="empid">
<%if(jb.getEmpId().equals("")){%>    
<option value="">Select</option>   
<%}else{%>
<option value="<%=jb.getEmpId()%>"><%=jb.getEmpId()%></option> 
<%}
for(int i=0;i<ar.size();i++){
jb1=(JBeanEmp)ar.get(i); 
if(jb1.getEmpId().equals(jb.getEmpId())){continue;}
%>
<option value="<%=jb1.getEmpId()%>"><%=jb1.getEmpId()%></option> 
<%}%>
</select>
<input type="submit" value="Submit"></td></tr>
</table>
</form>

<%if(request.getAttribute("msg")!=null){%>
<table width="100%" style="padding-left: 50px"><tr><td width="100%" align="center"><font color="red" size="3"><b><%=request.getAttribute("msg")%></b></font></td></tr></table>  
<%}%>  
<form name="f1" method="post" action="<%=request.getContextPath()%>/Emp7.do?method=updateEmpAction7" onSubmit="return validate();" >
<table align="center" width="100%" style="padding-left: 50px"><tr><td align="left"></td><td><font color="red"><b>(*field is mandatory)</b></font></td></tr></table>
<hr color="maroon">
<table align="center" width="100%" border="0" style="padding-left: 20px"><tr><td align="left" valign="middle"><font size="2" color="maroon"><b>LOGIN INFORMATION</b></font></td></tr></table>
<hr color="maroon">
<table align="center" width="100%" style="padding-left: 50px"><tr><td align="left" class="tdcolor">Employee ID:&nbsp;<font size="3" color="maroon"><b><%=jb.getEmpId()%></b></font><input type="hidden" name="empid" value="<%=jb.getEmpId()%>"></td></tr></table>
<table align="center" width="100%" border="0" style="padding-left: 50px">      
  <tr><td align="left" class="tdcolor">*LoginID</td><td align="left" colspan="3"><input type="text" name="loginid" value="<%=jb.getLoginId()%>"></td></tr>
  <tr><td align="left" class="tdcolor" colspan="4"><font size="1" color="red"><% if((String)request.getAttribute("exist")!=null) out.println("<font color='red'><b>"+(String)request.getAttribute("exist")+"</b></font>");%>ID may consist of a-z, underscores and a single dot (.)</font></td></tr>
  <tr><td align="left" class="tdcolor">*Password</td>
<td align="left"><input type="password" name="password" value="<%=jb.getPassword()%>"></td>
<td align="left" class="tdcolor">*Reenter Password</td>
<td align="left"><input type="password" name="password1" value="<%=jb.getPassword()%>"></td></tr>
  <tr><td align="left" class="tdcolor" colspan="4"><font size="1" color="red">Six characters and more ; capitalization matters</font></td></tr>
  <tr><td align="left" class="tdcolor" width="20%">Secret Question</td>
<td align="left" width="30%"><input type="text" name="question" value="<%=jb.getQuestion()%>" size="30"></td>
<td align="left" width="20%" class="tdcolor">Secret Answer</td><td align="left" width="30%"><input type="text" name="answer" value="<%=jb.getAnswer()%>"></td></tr>
  <tr><td align="center" class="tdcolor" colspan="4"></td></tr>
  <tr><td align="center" class="tdcolor" colspan="4"><input type="submit" value="Edit"></td></tr>
  </table>
  </form>
             </td></tr>
 </table></td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
