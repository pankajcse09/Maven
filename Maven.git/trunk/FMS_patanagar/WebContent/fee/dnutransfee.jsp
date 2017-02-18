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
     
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#34689A" align="center">
<tr><td><jsp:include page="/fee/ftoplook.jsp"/></td></tr>
<tr><td>
<table border="0"  bgcolor="#FFB76F" cellpadding=0 cellspacing =0 width="100%"  height="330">
<tr><td width="100%"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>   
<tr><td valign="top">  
<table width="60%" align="center"><tr><td align="center"><h3><font color="#34282C" >Transport Fee</font></h3></td></tr></table>  

<form action="<%=request.getContextPath()%>/dtfee.do" method="post" name="feest" onsubmit="return chkvalidate()">


  <table width="80%" cellpadding="0" cellspacing="0" align="center" border="0"> 
  <tr><td valign="top">
  <table width="80%" cellpadding="0" cellspacing="2" align="center" border="0"> 

<%  if((String)request.getAttribute("msg")!=null)
    out.println("<font color='red'><b>"+(String)request.getAttribute("msg")+"</b></font>"); %>
    
   <% 
    
    int k=0;
try
{
          

ArrayList arr1=(ArrayList)request.getAttribute("array");  

%>

  <% if(arr1.size()!=0)
 {%>      
 
      <tr><td valign="top">
  <table width="100%" cellpadding="0" cellspacing="0" align="center"> 


<tr><td width="100%"><table cellpadding="4" cellspacing="4" border="0" width="100%"><tr>


<tr><td><table cellpadding="4" cellspacing="3" border=1 width="100%" align="center">
 <td width="10%" align="center"><b>S.No.</b></td>   
<td width="70%" align="center"><b>Route</b></td>
<td width="20%" align="center"><b>Bus Fee</b></td>

<% //int j=0;
//for(j=0;j<14;j++)
//{
for(int j=0;j<arr1.size();j++)
   { 
    SchoolEO seo=new SchoolEO();
     seo=(SchoolEO)arr1.get(j);
%>

<input type="hidden" size="5" name="route<%=j%>" value="<%=seo.getRoute()%>">
<input type="hidden" size="5" name="busfee<%=j%>" value="<%=seo.getBusfee()%>">

          <tr>
          <td><center><%=++k%></center></td>
          <td align="left" ><%=seo.getRoute()%></td>
          <td align="center"><%=seo.getBusfee()%></td>
         
 <td><a href="<%=request.getContextPath()%>/fee/delroute.jsp?rowid=<%=seo.getRowid()%>"><font color="maroon">Delete</font></a></td>        
          </tr>   
  
    <%  }%>
    <tr><table border=1 align="center">
    <tr> <td align="center"><a href="<%=request.getContextPath()%>/fee/updatetransfee.jsp"><font color="#34282C"><b>Update Transport Fee </b></font></a></td>
    
    </table></tr>
    </table></td></tr></table></td></tr>
   <%}}catch(Exception e){} %>
    
     

   
         </td></tr></table>
   </td></tr></table>
  </form>
</td></tr></table>

   <tr><td valign="top">
<table width="100%" bgcolor="#34689A"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr>
     </table>    
    </body>
</html>