<%-- 
    Document   : Hostel_PostedFoodBill
    Created on : Mar 8, 2015, 11:13:56 AM
    Author     : kapil
--%>

<%@page import="pant.common.UtilityDB"%>
<%
String loginfor="";
if(session.getAttribute("loginfor")!=null){
    loginfor=(String)session.getAttribute("loginfor");
}
%>
<%@page import="Beans.JavaBean"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.text.*,java.util.*,java.sql.*"%>
<%@page import="AO.*,EO.*,ActionClass.*"%>
<!DOCTYPE html>
<%     
SchoolEO seo=null;  
if(request.getAttribute("jbean")!=null){
seo=(SchoolEO)request.getAttribute("jbean");   
}
SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
java.util.Date dt=new java.util.Date();
    String Styear=sdf.format(dt);
    int Syear=Integer.parseInt(Styear);    
    String prev=(Syear-1)+"-"+Syear;
    String next=Syear+"-"+(Syear+1);
ArrayList al=new ArrayList();
 if(request.getAttribute("list")!=null){
     al=(ArrayList)request.getAttribute("list");
 }
 SimpleDateFormat sdf1=new SimpleDateFormat("dd/MM/yyyy");
 DecimalFormat df = new DecimalFormat("0.00");
 
try{                 
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
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/JSF/printData.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/JSF/calendarDateInput.js"></script>
<title>Student Food Bill</title>
<script language="JavaScript">     
function validate(){
if(document.f1.elements["stud_id"].value==""){
alert("Enter Student Id");
document.f1.elements["stud_id"].focus();
return false;
 }
return true;
}

function deleteFoodAmount(a){
document.f2.elements["id"].value=a;
var form=document.getElementById("deleteForm");
form.action="<%=request.getContextPath()%>/deleteMonthlyFood.do?method=deleteMonthlyFood";
form.method="post";
form.submit();
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
<tr><td align="center" width="100%" style="padding-top:0px" height="100">
 <%if(loginfor.equals("hostel")){%>
     <%@include file="/hostel/HostelToplook.jsp"%>   
  <%}else{%>
  <%@include file="/fee/toplook_1.jsp"%>
  <%}%>
    </td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
<tr><td valign="top" style="padding-left: 5px" width="160">            
          <% if(loginfor.equals("hostel")){     %>
     <%@include file="/hostel/Hostel_sidemenu.jsp"%>   
  <%}else{%>
  <%@include file="/fee/fees.jsp" %>
  <%}%>
        </td>
        <td width="2" bgcolor="#000000"></td>
  <td valign="top" align="left"> 
 <form name="f1" method="post" action="<%=request.getContextPath()%>/checkFooBill.do?method=studentFoodBill" onsubmit="return validate()">
    <table width="100%" align="center" valign="top"><tr><td colspan="2" align="center" valign="top">
                <font color="darkred" size="3">Student Food Bill</font></td></tr>
    <tr><td colspan="2" height="10"></td></tr>
    </table>
    
<table width="35%" align="center">
<tr>
    <td valign="top"><font style="font-size:12;color:white"><b>Session</b></font></td>
        <td><select name="session">
                <option value="<%=next%>"><%=next%></option>
                <option value="<%=prev%>"><%=prev%></option>
            </select></td>
    <td valign="top"><font style="font-size:12;color:white"><b>Student Id</b></font></td>
        <td><input type="text" name="stud_id" size="10"><input type="submit" name="submit" value="Check"></td></tr>
    <tr><td></td><td></td></tr> 
</table>  
</form>
    <hr color="maroon">
    <%if(request.getAttribute("msg")!=null){%>
    <table width="100%" align="center" valign="top"><tr><td colspan="2" align="center" valign="top">
                <font color="yellow" size="2"><%=request.getAttribute("msg")%></font></td></tr>
    </table>
    <%}%>    
<%if(seo!=null){%> 
<form name="f2" method="" action="" id="deleteForm">
    <table width="100%" align="center" valign="top"><tr><td colspan="2" align="center" valign="top">
                <input type="hidden" name="stud_id" value="<%=seo.getStud_id()%>">
                <input type="hidden" name="session" value="<%=seo.getSession()%>">
                <input type="hidden" name="id" value="">
</table>  
</form>
<table width="35%" align="center" style="padding-top: 20px">
    <tr><td colspan="4" align="center" style="font-size: 14px"><b>Student Food Bill</b></td></tr>
    <tr><td><b>Student Name: </b></td><td><%=seo.getSname()%></td>
        <td><b>Student Id: </b></td><td><%=seo.getStud_id()%></td></tr><input type="hidden" name="stud_id" value="<%=seo.getStud_id()%>">
        <tr><td><b>Programme: </b></td><td><%=seo.getDegree()%></td>
        <td><b>Batch: </b></td><td><%=seo.getBatch()%></td></tr>
        <tr><td><b>College: </b></td><td><%=seo.getCollege()%></td></tr>
        <% HostelBean hb=seo.getHostelBean();
            if(hb.getHostelCode()!=null){%>
        <tr><td><b>Assigned Hostel: </b></td>
            <td><%=hb.getHostelName()%></td></tr>
        <%}%>               
</table>  
<table width="60%" align="center" border="1" bordercolor="black" style="border-collapse:collapse">
<tr><td><font style="font-size:12;font-weight:bold">Sr No.</font></td>  
<td><font style="font-size:12;font-weight:bold">Month</font></td> 
<td><font style="font-size:12;font-weight:bold">Bill Genration_Date</font></td>
<td><font style="font-size:12;font-weight:bold">Submission_Date</font></td> 
<td align="right"><font style="font-size:12;font-weight:bold">Amount</font></td>
<td align="right"><font style="font-size:12;font-weight:bold">Delete</font></td>
</tr>
<% 
double tt=0;
int k=0;
for(int i=0;i<al.size();i++)
       {
    seo=(SchoolEO)al.get(i);
    tt=tt+seo.getMonthlyFood();
%>
<tr><td><%=++k%></td>
<td><%=seo.getMonth()%></td>
<td><%=sdf1.format(seo.getDate())%></td>
<td><%=sdf1.format(seo.getSubm_date())%></td>
<td align="right"><%=df.format(seo.getMonthlyFood())%></td>
<td align="center"><a href="#" onclick="deleteFoodAmount('<%=seo.getRwid()%>')">delete</a></td>
<%}%>
<tr><td colspan="4" align="right"><font style="font-size:14px;font-weight:bold">TOTAL</font></td>
    <td align="right"><b><%=df.format(tt)%></b></td><td></td></tr>
</table>
    <%}%>
   </td></tr></table>
           </td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
<%}catch(Exception e){
}%>


