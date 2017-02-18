<%-- 
    Document   : monthly_food
    Created on : May 12, 2014, 12:38:30 PM
    Author     : kapil
--%>
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
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
    java.util.Date dt=new java.util.Date();
    String Styear=sdf.format(dt);
    int Syear=Integer.parseInt(Styear);    
    String prev=(Syear-1)+"-"+Syear;
    String next=Syear+"-"+(Syear+1);
    String ss[]={"January","February","March","April","May","June","July","August","September","October","November","December"};
MyMeth mm=new MyMeth();
SchoolEO seo=new SchoolEO();  
if(request.getAttribute("jbean")!=null){
seo=(SchoolEO)request.getAttribute("jbean");   
}
 SimpleDateFormat sde=new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date dt1=new java.util.Date();
    String ddate="";
try{
    ddate=(String)sde.format(dt1);
    DecimalFormat df = new DecimalFormat("0.00");
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
<title>Student Monthly Food</title>
<script language="JavaScript">     
function validate(){
if(document.f1.elements["famount"].value==""){
alert("Enter Amount");
document.f1.elements["famount"].focus();
return false;
 }
if(document.f1.elements["stud_id"].value==""){
alert("Enter Student Id");
document.f1.elements["stud_id"].focus();
return false;
 }
return true;
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
         
         <% 
         double regis_fee=0.0;
          
         %>
          <table width="100%" class="res" cellpadding="0" cellspacing="0" align="center">
<tr><td align="center" width="100%" style="padding-top:0px" height="100">
        <% if(loginfor.equals("hostel")){     %>
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
<form name="f1" method="post" action="<%=request.getContextPath()%>/subm_fam.do?method=submit_food_b" onsubmit="return validate()">
    <table width="100%" align="center" valign="top"><tr><td colspan="2" align="center" valign="top">
                <font color="darkred" size="3">Monthly Food</font></td></tr>
    <tr><td colspan="2" height="10"></td></tr>
    </table>
    <%if(request.getAttribute("msg")!=null){%>
    <table width="100%" align="center" valign="top"><tr><td colspan="2" align="center" valign="top">
                <font color="yellow" size="2"><%=request.getAttribute("msg")%></font></td></tr>
    </table>
    <%}%>
<table width="35%" align="center">
    <tr><td valign="top"><font style="font-size:12;color:white"><b>Session</b></font></td>
        <td><select name="session">
<%if(!seo.getSession().equals("")){%>   
<option value="<%=seo.getSession()%>"><%=seo.getSession()%></option>
<%}if(!seo.getSession().equals(next)){%> 
<option value="<%=next%>"><%=next%></option>
<%}if(!seo.getSession().equals(prev)){%> 
<option value="<%=prev%>"><%=prev%></option>
<%}%>
</select></td></tr>
    <tr><td valign="top"><font style="font-size:12;color:white"><b>Month</b></font></td>
        <td>
            <select name="month">
                <%
                if(!seo.getMonth().equals("")){ %>
                <option value="<%=seo.getMonth()%>"><%=seo.getMonth()%></option>
                <%}%>
                <%for(int i=0;i<ss.length;i++)
                {
                    if(!seo.getMonth().equals(ss[i])){   
                %>
                <option value="<%=ss[i]%>"><%=ss[i]%></option>
                <%}}%>
             </select> 
        </td></tr>
    <tr><td valign="top"><font style="font-size:12;color:white"><b>Student Id</b></font></td>
        <td><input type="text" name="stud_id" value="<%=seo.getStud_id()%>"></td></tr>
    <tr><td valign="top"><font style="font-size:12;color:white"><b>Amount</b></font></td>
        <td><input type="text" name="famount"></td></tr>
    
    <tr><td align="left" style="padding-right: 20px"><font style="font-size:12" color="white"><b>Date Of Bill</b></font></td>
            <td><script>DateInput('date1',true,'dd/mm/yyyy')</script></td></tr>
    <tr><td></td><td><input type="submit" value="Generate"></td></tr>    
</table>  
</form>
    <hr color="maroon">
   </td></tr></table>
           </td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
<%}catch(Exception e){
}%>
