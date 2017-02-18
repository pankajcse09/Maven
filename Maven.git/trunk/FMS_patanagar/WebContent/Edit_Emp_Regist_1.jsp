<%@page import="com.myapp.struts.Dataconnectivity,java.util.*"%>
<%@page import="java.sql.*,ActionClass.JBeanEmp"%>
<%@ page language="java"%>
<!DOCTYPE html>
<%    
int rid=0;
String eid="";
String role="";
ArrayList ar=new ArrayList();
JBeanEmp jb=new JBeanEmp();
JBeanEmp jb1=new JBeanEmp();
if(request.getAttribute("arr")!=null){
ar=(ArrayList)request.getAttribute("arr");    
}
if(request.getAttribute("jbean")!=null){
jb=(JBeanEmp)request.getAttribute("jbean");  

//if(jb.getRole().equals("examadmin")){
//role="Exam Admin";    
//}
//if(jb.getRole().equals("feeadmin")){
//role="Fee Admin";    
//}
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
if(document.f1.role.value==""){
alert("select Role");
document.f1.role.focus();
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
<form name="f2" method="post" action="<%=request.getContextPath()%>/Emp1.do?method=eDetail1">
<table align="center" width="100%" style="padding-left: 50px">
<tr><td align="left" class="tdcolor">Select Employee ID
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
<form name="f1" method="post" action="<%=request.getContextPath()%>/Emp1.do?method=updateEmpAction1" onSubmit="return validate();" >
<table align="center" width="100%" style="padding-left: 50px"><tr><td align="left"></td><td><font color="red"><b>(*field is mandatory)</b></font></td></tr></table>
  <hr color="maroon">
  <table align="center" width="100%" border="0" style="padding-left: 20px"><tr><td align="left" valign="middle"><font size="2" color="maroon" ><b>PERSONAL INFORMATION</b></font></td></tr></table>
  <hr color="maroon">
  <table align="center" width="100%" style="padding-left: 50px" style="padding-left: 50px"><tr><td align="left" class="tdcolor">Employee ID:&nbsp;<font size="3"><b><%=jb.getEmpId()%></b></font><input type="hidden" name="empid" value="<%=jb.getEmpId()%>"></td></tr></table>
  <table align="center" width="100%" border="0" style="padding-left: 50px">  
  <tr><td align="left" class="tdcolor">*Name</td><td align="left" colspan="3"><input type="text" name="empname" value="<%=jb.getEmpName()%>" size="50"></td></tr>
 <tr><td align="left" class="tdcolor">*Designation</td><td align="left"><input type="text" name="designation" value="<%=jb.getDesignation()%>"></td>
 <td align="left" class="tdcolor">*Gender</td>
 <td align="left"><select name="gender">
 <option value="Male">Male</option>
 <option value="Female">Female</option>
 </select></td></tr>
<tr><td align="left" class="tdcolor">*Date of Birth</td><td><input type="text" name="dob" value="<%=jb.getDob()%>"></td>
<td align="left" class="tdcolor">Place of Birth</td><td align="left"><input type="text" name="pob" value="<%=jb.getPob()%>"></td></tr>
<tr><td align="left" valign="top" colspan="2"><font size="1" color="red">eg: (dd/mm/yyyy)</font></td><td align="left" valign="top" colspan="2"></td></tr>
<tr><td width="50%" colspan="2"><table width="100%" align="center"><tr><td align="center" class="tdcolor"><b>Present Address</b></td></tr>
<tr><td align="center"><textarea name="present" rows="4" cols="30"><%=jb.getPresent()%></textarea></td></tr></table></td>
<td width="50%" colspan="2"><table width="100%"><tr><td align="center" class="tdcolor"><b>Permanent Address</b></td></tr>
<tr><td align="center"><textarea name="permanent" rows="4" cols="30"><%=jb.getPermanent()%></textarea></td></tr></table></td></tr>
<tr><td align="left" class="tdcolor">Nationality</td><td align="left"><input type="text" name="nationality" value="<%=jb.getNationality()%>"></td><td align="left" class="tdcolor">Father's Name</td>
<td align="left"><input type="text" name="fname" value="<%=jb.getFname()%>"></td></tr>
<tr><td align="left" class="tdcolor" >Father's/Husband's Occupation</td><td align="left"><input type="text" name="occupation" value="<%=jb.getFoccupation()%>"></td>
<td align="left" class="tdcolor">Marital Status</td><td align="left"><select name="marital">
 <%if(!jb.getMstatus().equals("")){%>   
 <option value="<%=jb.getMstatus()%> "><%=jb.getMstatus()%></option>
 <%}%>
<%if(!jb.getMstatus().equals("Single")){%>   
<option value="Single">Single</option>  
<%}if(!jb.getMstatus().equals("Married")){%>   
<option value="Married">Married</option> 
<%}%>
</select></td></tr>
</table>
<table align="center" width="100%" border="0"><tr><td width="100%" align="center"><input type="submit" value="Edit"></td></tr></table> 
 </form>
 
             </td></tr>
 </table></td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
