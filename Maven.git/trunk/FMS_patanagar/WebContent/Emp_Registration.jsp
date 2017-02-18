<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.myapp.struts.Dataconnectivity"%>
<%@page import="java.sql.SQLException,ActionClass.JBeanEmp"%>
<%@ page language="java"%>
<!DOCTYPE html>
<%    
Connection con=null;
PreparedStatement psmt=null;
ResultSet rs=null;
int rid=0;
String eid="";
JBeanEmp jb=new JBeanEmp();
try      
{  
 Dataconnectivity dc=new  Dataconnectivity();
 con=(Connection)dc.Dataconnect();
}
catch(Exception e){}
try{
 String qr="select convert(substring(emp_id,2,4),unsigned) as emp_id from loginn where rowid=(select max(rowid) from loginn)"; 
 psmt=con.prepareStatement(qr);
 rs=psmt.executeQuery();
 if(rs.next()){
 rid=rs.getInt("emp_id");    
 }
 }
catch(SQLException se){out.println(se.getMessage());}
finally{
 try{
 if(rs!=null){rs.close();}
 if(psmt!=null){psmt.close();}
 if(con!=null){con.close();}
 }   
 catch(SQLException se){}
}
eid="E"+(rid+1);
if(request.getAttribute("jbean")!=null){
jb=(JBeanEmp)request.getAttribute("jbean");  
eid=jb.getEmpId();
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
if(document.f1.role.value==""){
alert("select Role");
document.f1.role.focus();
return (false);
}
if(document.f1.empname.value==""){
alert("Enter Employee Name");
document.f1.empname.focus();
return (false);
}
if(document.f1.designation.value==""){
alert("Enter Designation");
document.f1.designation.focus();
return (false);
}
if(document.f1.gender.value==""){
alert("Select Gender");
document.f1.gender.focus();
return (false);
}
if(document.f1.dob.value==""){
alert("Select Date of Birth");
document.f1.dob.focus();
return (false);
}
return (true);
}

 function validate1(){
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
if(document.f1.pob.value==""){
alert("Enter Place of Birth");
document.f1.pob.focus();
return (false);
}
if(document.f1.present.value==""){
alert("Enter Present Address");
document.f1.present.focus();
return (false);
}
if(document.f1.permanent.value==""){
alert("Enter Permanent Address");
document.f1.permanent.focus();
return (false);
}
if(document.f1.nationality.value==""){
alert("Enter Nationality");
document.f1.nationality.focus();
return (false);
}
if(document.f1.fname.value==""){
alert("Enter Father's Name");
document.f1.fname.focus();
return (false);
}
if(document.f1.occupation.value==""){
alert("Enter Occupation");
document.f1.occupation.focus();
return (false);
}
if(document.f1.marital.value==""){
alert("Enter Marital Status");
document.f1.marital.focus();
return (false);
}
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
             <td valign="top" align="left"><table>
                <tr><td>
<table style="padding-left: 0px">
    <tr><td align="left"><a href="<%=request.getContextPath()%>/Emp_Registration.jsp"><font color="maroon" size="2"><b>New</b></font></a></td><td align="center" style="padding-left: 300px"><a href="<%=request.getContextPath()%>/Emp_Registration_1.jsp?status=old"><font color="blue" size="2"><b>Education Details</b></font></a><font size="3" color="black"><b>|</b></font><a href="<%=request.getContextPath()%>/Emp_Registration_2.jsp?status=old"><font color="blue" size="2"><b>Employment & Proficiency</b></font></a><font size="3" color="black"><b>|</b></font><a href="<%=request.getContextPath()%>/Emp_Registration_3.jsp?status=old"><font color="blue" size="2"><b>Extra-curricular & References</b></font></a></td></tr>
</table></td></tr>
                <tr><td style="padding-left: 50px">
      
<%if(request.getAttribute("msg")!=null){%>
<table width="100%"><tr><td width="100%" align="center"><font color="red" size="3"><b><%=request.getAttribute("msg")%></b></font></td></tr></table>  
<%}%>  
<form name="f1" method="post" action="<%=request.getContextPath()%>/UserRegist.do?method=registUserAction1" onSubmit="return validate();" >
    <table align="center" width="100%"><tr><td align="left" colspan="3"></td><td><font color="red"><b>(*field is mandatory)</b></font></td></tr></table>
<table align="center" width="100%"><tr><td align="left" class="tdcolor">Unique Employee ID for Registration<input type="text" name="empid" value="<%=eid%>"></td></tr></table>
<hr color="maroon">
<table align="center" width="100%" border="0"><tr><td align="left" valign="middle"><font size="2" color="maroon"><b>LOGIN INFORMATION</b></font></td></tr></table>
<hr color="maroon">
<table align="center" width="100%" border="0">      
  <tr><td align="left" class="tdcolor">LoginID</td><td align="left" colspan="3"><input type="text" name="loginid" value=""></td></tr>
  <tr><td align="left" colspan="4"><font size="1" color="red"><% if((String)request.getAttribute("exist")!=null) out.println("<font color='red'><b>"+(String)request.getAttribute("exist")+"</b></font>");%>ID may consist of a-z, underscores and a single dot (.)</font></td></tr>
  <tr><td align="left" class="tdcolor">Password</td><td align="left"><input type="password" name="password" value=""></td><td align="left" class="tdcolor">Reenter Password</td><td align="left"><input type="password" name="password1" value=""></td></tr>
  <tr><td align="left" colspan="4"><font size="1" color="red" >Six characters and more ; capitalization matters</font></td></tr>
  <tr><td align="left" width="20%" class="tdcolor">Secret Question</td><td align="left" width="30%"><input type="text" name="question" value="" size="30"></td><td align="left" width="20%" class="tdcolor">Secret Answer</td><td align="left" width="30%"><input type="text" name="answer" value=""></td></tr>
 <tr><td align="left" class="tdcolor">*Employee Role</td><td align="left" colspan="3"><select name="role">
 <option value="">Select</option>
 <option value="examadmin" >Exam Admin</option>
 <option value="feeadmin" >Fee Admin</option>
 </select></td></tr> 
  </table>
  <hr color="maroon">
  <table align="center" width="100%" border="0"><tr><td align="left" valign="middle"><font size="2" color="maroon"><b>PERSONAL INFORMATION</b></font></td></tr></table>
  <hr color="maroon">
  <table align="center" width="100%" border="0">  
  <tr><td align="left" class="tdcolor">*Name</td><td align="left" colspan="3"><input type="text" name="empname" value="" size="50"></td></tr>
 <tr><td align="left" class="tdcolor">*Designation</td><td align="left"><input type="text" name="designation" value=""></td>
 <td align="left" class="tdcolor">*Gender</td>
 <td align="left"><select name="gender">
 <option value="Male">Male</option>
 <option value="Female">Female</option>
 </select></td></tr> 
<tr><td align="left" class="tdcolor">*Date of Birth</td><td><script>DateInput('dob',true,'dd/mm/yyyy')</script></td>
<td align="left" class="tdcolor">Place of Birth</td><td align="left"><input type="text" name="pob" value=""></td></tr>
<tr><td align="left" valign="top" colspan="2"><font size="1" color="red">eg: (dd/mm/yyyy)</font></td><td align="left" valign="top" colspan="2"></td></tr>
<tr><td width="50%" colspan="2"><table width="100%" align="center"><tr><td align="center" class="tdcolor"><b>Present Address</b></td></tr>
<tr><td align="center"><textarea name="present" rows="4" cols="30"></textarea></td></tr></table></td>
<td width="50%" colspan="2"><table width="100%"><tr><td align="center" class="tdcolor"><b>Permanent Address</b></td></tr>
<tr><td align="center"><textarea name="permanent" rows="4" cols="30"></textarea></td></tr></table></td></tr>
<tr><td align="left" class="tdcolor">Nationality</td><td align="left"><input type="text" name="nationality" value=""></td>
<td align="left" class="tdcolor">Father's Name</td><td align="left"><input type="text" name="fname" value=""></td></tr>
<tr><td align="left" class="tdcolor">Father's/Husband's Occupation</td><td align="left"><input type="text" name="occupation" value=""></td>
<td align="left" class="tdcolor">Marital Status</td><td align="left"><select name="marital">
<option value="Single">Single</option>   
<option value="Married">Married</option> 
</select></td></tr>
</table>
<table align="center" width="100%" border="0"><tr><td width="33%"></td><td align="center" width="34%"><input type="submit" value="Submit"></td><td align="right" width="33%"><a href="<%=request.getContextPath()%>/Emp_Registration_1.jsp?eid=<%=eid%>"><font color="blue" size="2"><b>Next >>></b></font></a></td></tr></table>    
 </form>
 </td></tr>
            </table>
</td></tr> 
</table></td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
