<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page language="java"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="EO.SchoolEO"%>
<%@page import="AO.*"%>

<%!
    Connection cn=null;
    Statement stmt=null;
    ResultSet rs=null;
    Statement stmt1=null;
    ResultSet rs1=null;
%>
<html>
    <head>
     <title>School Management System</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/mymenu.css">
<script language="javascript" src="<%=request.getContextPath()%>/fee/resolution.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/fee/calendarDateInput.js"></script>  
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/menu.css">
<script language="javascript" src="<%=request.getContextPath()%>/fee/menu.js"></script>  


<script language="javascript" src="<%=request.getContextPath()%>/JSF/CheckNumericData.js"></script> 
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
<script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>          
<script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
      <script language="javascript">
     
  function chkvalidate()
{

if(document.feest.status.value=="")
{
alert("Please enter status");
document.feest.status.focus();
return (false);
} 
}
    </script>
        <title>JSP Page</title>
    </head>
    <body>
     
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center">
<tr><td><jsp:include page="/fee/toplook_1.jsp"/></td></tr>
<tr><td>
<table border="0"  bgcolor="#EEEEEE" cellpadding=0 cellspacing =0 width="100%"  height="330">
<tr><td width="100%"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>   
<tr><td valign="top">   
<table width="60%" align="center"><tr><td align="center"><h3><font color="#34282C" >Define Fee Structure</font></h3></td></tr></table>  

<form action="<%=request.getContextPath()%>/dfst.do?dispfee=dispfee" method="post" name="feest" onsubmit="return chkvalidate()">


  <table width="70%" cellpadding="0" cellspacing="0" align="center" border="0"> 
  <tr><td valign="top">
  <table width="60%" cellpadding="0" cellspacing="2" align="center" border="0"> 

<%  if((String)request.getAttribute("msg")!=null)
    out.println("<font color='red'><b>"+(String)request.getAttribute("msg")+"</b></font>"); %>
    
   <% 
    
    int k=0;
try
{
  
ArrayList arr1=(ArrayList)request.getAttribute("array"); 
ArrayList arrtotal=(ArrayList)request.getAttribute("arrtotal"); 

%>

  <% if(arr1!=null)
 {%>      
 
      <tr><td valign="top">
  <table width="100%" cellpadding="0" cellspacing="0" align="center"> 


<tr><td width="100%"><table cellpadding="4" cellspacing="4" border="0" width="100%"><tr>


<tr><td><table cellpadding="4" cellspacing="3" border=1 width="100%">
<td width="10%" align="center"><b>Class</b></td>
<td width="7%" align="center"><b>Jan</b></td>
<td width="7%" align="center"><b>Feb</b></td>
<td width="7%" align="center"><b>March</b></td>
<td width="7%" align="center"><b>April</b></td>
<td width="7%" align="center"><b>May</b></td>
<td width="7%" align="center"><b>June</b></td>
<td width="7%" align="center"><b>July</b></td>
<td width="7%" align="center"><b>August</b></td>
<td width="7%" align="center"><b>Sept.</b></td>
<td width="7%" align="center"><b>Oct.</b></td>
<td width="7%" align="center"><b>Nov.</b></td>
<td width="7%" align="center"><b>Dec.</b></td>
<% //int j=0;
//for(j=0;j<14;j++)
//{
for(int j=0;j<arr1.size();j++)
   { 
    SchoolEO seo=new SchoolEO();
     seo=(SchoolEO)arr1.get(j);
%>
<input type="hidden" size="9" name="classes<%=j%>" value="<%=seo.getClasses()%>">
<input type="hidden" size="5" name="jan<%=j%>" value="<%=seo.getApr()%>">
<input type="hidden" size="5" name="feb<%=j%>" value="<%=seo.getMay()%>">
<input type="hidden" size="5" name="mar<%=j%>" value="<%=seo.getJune()%> ">
<input type="hidden" size="5" name="apr<%=j%>" value="<%=seo.getJuly()%>">
<input type="hidden" size="5" name="may<%=j%>" value="<%=seo.getAugust()%>">
<input type="hidden" size="5" name="june<%=j%>" value="<%=seo.getSept()%>">
<input type="hidden" size="5" name="july<%=j%>" value="<%=seo.getOct()%>">
<input type="hidden" size="5" name="aug<%=j%>" value="<%=seo.getNov()%>">
<input type="hidden" size="5" name="sept<%=j%>" value="<%=seo.getDec()%>">
<input type="hidden" size="5" name="oct<%=j%>" value="<%=seo.getJan()%>">
<input type="hidden" size="5" name="nov<%=j%>" value="<%=seo.getFeb()%>">
<input type="hidden" size="5" name="dec<%=j%>" value="<%=seo.getMar()%>">

          <tr><td align="center" bgcolor="#DCDCDC"><%=seo.getClasses()%></td>
          <td align="center" bgcolor="#F5F5F5"><%=seo.getJan()%></td>
          <td align="center" bgcolor="#DCDCDC"><%=seo.getMay()%></td>
          <td align="center" bgcolor="#F5F5F5"><%=seo.getMar()%></td>
          <td align="center" bgcolor="#DCDCDC"><%=seo.getApr()%></td>
          <td align="center" bgcolor="#F5F5F5"><%=seo.getMay()%></td>
          <td align="center" bgcolor="#DCDCDC"><%=seo.getJune()%></td>
          <td align="center" bgcolor="#F5F5F5"><%=seo.getJuly()%></td>
          <td align="center" bgcolor="#DCDCDC"><%=seo.getAugust()%></td>
          <td align="center" bgcolor="#F5F5F5"><%=seo.getSept()%></td>
          <td align="center" bgcolor="#DCDCDC"><%=seo.getOct()%></td>
          <td align="center" bgcolor="#F5F5F5"><%=seo.getNov()%></td>
          <td align="center" bgcolor="#DCDCDC"><%=seo.getDec()%></td>
       
          <input type="hidden" name="rowid<%=j%>" value="<%=seo.getRowid()%>">

          </tr>   
  
    <%  }%>
    <tr><table border=1 align="center">
    <tr> <td align="center"><a href="<%=request.getContextPath()%>/fee/updatefeestr.jsp"><font color="#34282C"><b>Update Fee Structure</b></font></a></td>
    <td><table align=center><tr><td><a href="<%=request.getContextPath()%>/fee/delfeestruct.jsp"><font color="#34282C"><b>Delete</b></font></a></td></tr></table></td></tr>
    </table></tr>
    </table></td></tr></table></td></tr>
   <%}}catch(Exception e){} %>
    
     

   
         </td></tr></table>
   </td></tr></table>
  </form>
</td></tr></table>

   <tr><td valign="top">
<table width="100%" bgcolor="#5663C7"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr>
     </table>    
    </body>
</html>