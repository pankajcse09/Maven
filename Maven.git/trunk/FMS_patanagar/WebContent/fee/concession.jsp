<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page language="java"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="AO.*"%>

   <!-- Developed by : Sonal Sharma
        Company      : IntelMind -->

<html>
    <head>
         <title>School Management System</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/mymenu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/fee/resolution.js"></script>
        <script language="javascript" src="<%=request.getContextPath()%>/fee/validation.js"></script>
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/menu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/fee/menu.js"></script>          
<script type="text/javascript" src="calendarDateInput.js"></script>  
  
       <script language="javascript">
   
  function chkvalidate()
{
if(document.con.type.value=="")
{
alert("Enter Apply Concession on field");
document.con.type.focus();
return (false);
}

if(document.con.tutfee.value=="")
{
alert("Enter Tutuion Fee concession field");
document.con.tutfee.focus();
return (false);
}

if(document.con.transfee.value=="")
{
alert("Enter Transport Fee concession field");
document.con.transfee.focus();
return (false);
}

return (true);
}
 </script>
    </head>
    <body>
  
 <table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center">
<tr><td><jsp:include page="/fee/ftoplook.jsp"/></td></tr>
<tr><td>
<table border="0"  bgcolor="#EEEEEE" cellpadding=0 cellspacing =0 width="100%"  height="330">
<tr><td width="100%"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>   
<tr><td valign="top">
 <table height=400 align="center" width="100%" border="0"><tr><td valign="top">
 <table align="center"><tr><td><center><font color="#34282C" size="4"><u>Enter Concession </u></font></center></td></tr></table>
    <form name="con" action="<%=request.getContextPath()%>/econc.do" method="post" onsubmit="return chkvalidate()">
<%  if((String)request.getAttribute("msg")!=null)
    out.println("<font color='red'><b>"+(String)request.getAttribute("msg")+"</b></font>"); %>          

<table cellpadding="0" cellspacing="2" border="2" width="50%" align="center">
<tr><td>Apply Concession on:</td><td><select name="type">
                                     <option value="">-Select-</opion>
                                     <option value="NoConcession">No Concession</opion>
                                     <option value="SchoolWard">School Ward</opion>
                                     <option value="Siblings">Siblings</opion>
                                     </select>
</td></tr>
<tr><td>Tution Fee Concession:</td><td><select name="tutfee">
                                     <option value="">-Select-</opion>
                                     <option value="Full">Full Fee</opion>
                                     <option value="Half">Half Fee</opion>
                                     </select></td></tr>   
<tr><td>Transport Fee Concession:</td><td><select name="transfee">
                                     <option value="">-Select-</opion>
                                     <option value="Full">Full Fee</opion>
                                     <option value="Nofee">No Fee</opion>
                                     </select></td></tr>

<tr><td align="center"> <input type="submit" value="Save"></td></tr>
     </table>
     </td></tr></table>   
    </form>
  </td></tr></table>  
 
   <tr><td valign="top">
<table width="100%" bgcolor="#5663C7"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr>
     </table>    
    </body>
</html>


