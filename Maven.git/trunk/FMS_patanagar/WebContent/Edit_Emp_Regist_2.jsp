<%@page import="com.myapp.struts.Dataconnectivity,java.util.*"%>
<%@page import="java.sql.*,ActionClass.JBeanEmp"%>
<%@ page language="java"%>
<!DOCTYPE html>
<%    
int rid=0;
String eid="";
ArrayList ar=new ArrayList();
ArrayList ar1=new ArrayList();
HashMap hm1=new HashMap();
HashMap hm2=new HashMap();
HashMap hm3=new HashMap();
HashMap hm4=new HashMap();
HashMap hm5=new HashMap();
JBeanEmp jb=new JBeanEmp();
JBeanEmp jb1=new JBeanEmp();
if(request.getAttribute("arr")!=null){
ar=(ArrayList)request.getAttribute("arr");    
}
if(request.getAttribute("jbean")!=null){
jb=(JBeanEmp)request.getAttribute("jbean");  
}
ar1=(ArrayList)jb.getExamPassed();
hm1=(HashMap)jb.getBoardUnv();
hm2=(HashMap)jb.getSubOffered();
hm3=(HashMap)jb.getExamYear();
hm4=(HashMap)jb.getExamPercent();
hm5=(HashMap)jb.getExamRemark();
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
  <script language="javascript"></script>  
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
<form name="f2" method="post" action="<%=request.getContextPath()%>/Emp2.do?method=eDetail2">
<table align="center" width="100%">
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
<table width="100%"><tr><td width="100%" align="center"><font color="red" size="3"><b><%=request.getAttribute("msg")%></b></font></td></tr></table>  
<%}%> 
<form method="post" onSubmit="return validate(this.form)" action="<%=request.getContextPath()%>/Emp2.do?method=updateEmpAction2">
<hr color="maroon">
 <table align="center" width="100%" border="0"><tr><td align="left" valign="middle"><font size="2" color="maroon"><b>Details of Educational Professional Qualification</b></font></td></tr></table>
 <hr color="maroon"> 
 <table align="center" width="100%"><tr><td align="left">Employee ID:&nbsp;<font size="3"><b><%=jb.getEmpId()%></b></font><input type="hidden" name="empid" value="<%=jb.getEmpId()%>"></td></tr></table>
<table align="center" width="100%" border="0" bgcolor="#FFFFCC">
<tr><td align="center" class="tdcolor1">Examination<br>Passed</td>
<td align="center" class="tdcolor1">Board/<br>University</td>
<td align="center" class="tdcolor1">Subject<br>Offered</td>
<td align="center" class="tdcolor1">Year</td>
<td align="center" class="tdcolor1">Percentage of Marks<br>& Division</td>
<td align="center" class="tdcolor1">Remark about Distinction earned<br>and area Specialization if any</td></tr> 
<%for(int j=0;j<ar1.size();j++){%>
<tr><td align="center"><%=ar1.get(j)%><input type="hidden" name="exampass" value="<%=ar1.get(j)%>"></td><td><input type="text" name="board" value="<%=hm1.get(ar1.get(j))%>"></td><td><input type="text" name="subject" value="<%=hm2.get(ar1.get(j))%>"></td><td><input type="text" name="year" value="<%=hm3.get(ar1.get(j))%>"></td><td><input type="text" name="percent" value="<%=hm4.get(ar1.get(j))%>"></td><td><input type="text" name="remark" value="<%=hm5.get(ar1.get(j))%>"></td></tr> 
<%}%>
</table>
<table align="center" width="100%" border="0"><tr><td width="100%" align="center"><input type="submit" value="Edit"></td></tr></table> 
</form>
             </td></tr>
 </table></td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
