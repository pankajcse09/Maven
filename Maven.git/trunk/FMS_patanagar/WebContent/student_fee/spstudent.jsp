<%-- 
    Document   : spstudent
    Created on : Jun 18, 2014, 11:02:57 AM
    Author     : kapil
--%>

<%@page import="Fee.FeeMath"%>
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
    SimpleDateFormat sde=new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date dt=new java.util.Date();
    String Styear=sdf.format(dt);
    int Syear=Integer.parseInt(Styear);    
    String prev=(Syear-1)+"-"+Syear;
    String next=Syear+"-"+(Syear+1);
FeeMath fm=new FeeMath();
SchoolEO seo=new SchoolEO();  
ArrayList list=new ArrayList();
ArrayList banklist=new ArrayList();
if(request.getAttribute("list")!=null){
list=(ArrayList)request.getAttribute("list");   
}
if(request.getAttribute("jbean")!=null){
seo=(SchoolEO)request.getAttribute("jbean");   
}
else if(request.getParameter("stud_id")!=null)
       {
    seo.setStud_id(request.getParameter("stud_id"));
    seo=fm.getStudentDetails(seo);
    list=fm.retSponsoredAmount(seo.getStud_id());
}
banklist=fm.bankList();
try{
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
         <script language="javascript" src="<%=request.getContextPath()%>/calendarDateInput.js"></script>
<title>NRI Student Fee</title>
<script language="javascript">
 function focusField(a){
 document.f1.elements[a].focus();
 }
 
function validate()
{
    
        if(document.f1.elements["stud_id"].value=="")
        {
            alert("Please Enter Student ID");
           document.f1.elements["stud_id"].focus();
            return false;
        }
        return true;
}

function validate1()
{
       if(document.f2.elements["amount"].value=="")
        {
            alert("Please Enter Amount.");
           document.f2.elements["amount"].focus();
            return false;
        }
        if(document.f2.elements["bnk_name"].value=="")
        {
            alert("Please choose bank name.");
           document.f2.elements["bnk_name"].focus();
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
         
         
         
 <table width="100%" class="res" cellpadding="0" cellspacing="0" align="center">
<tr><td align="center" width="100%" style="padding-top:0px" height="100"><%@include file="/fee/toplook_1.jsp"%></td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
<tr><td valign="top" style="padding-left: 5px" width="160">            
            <%@include file="/fee/fees.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left">  
<form name="f1" method="post" action="<%=request.getContextPath()%>/student_fee/spstudent.jsp" onsubmit="return validate()">
    <table width="35%" align="center" valign="top"><tr><td colspan="2" align="left" valign="top">
                <font color="darkred" size="3">Institution Fee Of NRI Student</font></td></tr></table>
<table width="35%" align="center">
 <tr>
<td valign="top"><font style="font-size:12;color:white"><b>Student Id</b></font>
<input type="text" name="stud_id" size="10">
<input type="submit" value="Show"></td></tr>    
</table>  
</form>
<hr color="maroon">

<table width="80%" ><tr>
                         <td align="center"><font color="yellow" size="4">
                             <% if(request.getAttribute("msg")!=null){%>
                             <%=request.getAttribute("msg")%></font>
                         <%}%></td>
                     </tr></table>
<form name="f2" method="post" action="<%=request.getContextPath()%>/spstudent.do?method=enSpStudent" onsubmit="return validate1()">
<% if(request.getParameter("stud_id")!=null)
       {
    
%>

<table border="1" style="border-collapse: collapse" align="center" width="70%">
    <%if(!seo.getStud_id().equals("")){%>
    <tr><td>
<table>
    <tr><td colspan="4"><font style="font-size: 16px"><b>Student Details</b></font></td>
    <tr><td colspan="1"><b>Student Id:</b></td><td colspan="2"><%=seo.getStud_id()%></td></tr><input type="hidden" name="stud_id" value="<%=seo.getStud_id()%>">
    <tr><td colspan="1"><b>Student Name:</b></td><td colspan="2"><%=seo.getSname()%></td></tr>
    <tr><td colspan="1"><b>Father Name:</b></td><td colspan="2"><%=seo.getFname()%></td></tr>
    <tr><td colspan="1"><b>Programme:</b></td><td colspan="2"><%=seo.getDegree()%></td></tr>
    <tr><td colspan="5"></td></tr>
    <tr><td colspan="5"></td></tr>
    <tr><td valign="top"><b>Session</b></td>
        <td><select name="session">
            <option value="<%=next%>"><%=next%></option>
            <option value="<%=prev%>"><%=prev%></option>
        </select>
        <select name="session_sem">
            <option value="I">I</option>
            <option value="II">II</option>
        </select>
     </td></tr>
    <tr><td><font color="darkred">*</font><b>Amount</b></td><td><input type="text" name="amount"></td></tr>
    <tr><td valign="top"><b>Receipt No</b></td>
       <td><input type="text" name="receipt_no" value="" size="20"></td></tr>
    <tr><td align="left"><font color="darkred">*</font><b>Bank</b></td>
        <td> <select name="bnk_name">
                <option value="">select</option>
                <% for(int i=0;i<banklist.size();i++){%>
               <option value="<%=banklist.get(i)%>"><%=banklist.get(i)%></option>
               <%}%>
            </select></td></tr>
     <tr><td align="left"><b>Deposit Date</b></td>
                <td align="left"><script>DateInput('date1',true,'dd/mm/yyyy')</script></td></tr>
  </table>  
        </td></tr>
    
    <tr><td align="center"><input type="submit" value="Submit"></td></tr>
    <%}else{%>
        <tr><td align="center"><font color="yellow" size="4">Student details is not found</font></td></tr>
    <%}%>
</table>
<%}%>
</form>
<%
double tt=0;
if(list.size()!=0){%>
<table border="1" style="border-collapse: collapse" align="center" width="70%">
    <tr><td><b>Sr. No.</b></td><td><b>Session</b></td><td><b>Receipt No</b></td><td><b>Bank</b></td>
        <td><b>Submit Date</b></td><td align="right"><b>Amount</b></td></tr>
    <%for(int i=0;i<list.size();i++)
               {
        seo=(SchoolEO)list.get(i);
        if(seo.getAmountpaid()!=0){
            tt=tt+seo.getAmountpaid();
    %>
    <tr>
        <td><%=i+1%></td>
        <td><%=seo.getSession()%> -<%=seo.getSession_sem()%></td>
        <td><%=seo.getRecnum()%></td><td><%=seo.getBankname()%></td>
        <td><%=sde.format(seo.getDeposite_date())%> </td>
        <td align="right"><%=df.format(seo.getAmountpaid())%> </td>
    </tr>
    <%}}%>
    <tr><td colspan="5" align="right"><b>Total</b></td><td align="right"><b><%=df.format(tt)%> </b></td></tr>
  </table> 
<%}%>
</td></tr></table>
           </td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
<%}catch(Exception e){}%>



