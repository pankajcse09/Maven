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
<%@page import="EO.SchoolEO"%>
<html>
    <head>
         <title>School Management System</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/mymenu1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/fee/resolution.js"></script>
   <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/menu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/fee/menu.js"></script>
    </head>
    <body>
    
    
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#FFB76F" align="center">
<tr><td><jsp:include page="/fee/ftoplook.jsp"/></td></tr>
<tr><td>
<table border="0"  bgcolor="#FFB76F" cellpadding=0 cellspacing =0 width="100%"  height="330">
<tr><td width="100%"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>   
<tr><td valign="top">
 <table height=450 align="center" width="100%" border="0"><tr><td valign="top">
   <table align="center"><tr><td><center><font color="#34282C" size="4"><u>Student's Fee Record</u></font></center></td></tr></table>    
    </td></tr>
    <tr><td height=20></td></tr>
    <tr><td valign="top" align="center">
      <%  if((String)request.getAttribute("sub")!=null)
    out.println("<font color='red'><b>"+(String)request.getAttribute("sub")+"</b></font>"); %>  <%  
    %>
    </td></tr>
    <tr><td valign="top">
    <%
          
    if(request.getAttribute("arr")!=null)
    {
      Double amount=(Double)request.getAttribute("amount"); 
      Double fine=(Double)request.getAttribute("fine"); 
     
    //  HashSet hs=(HashSet)request.getAttribute("hs");
    //  Iterator ir=(Iterator)hs.iterator(); 
   
         %>
      
<% 
try
{
ArrayList arr1=(ArrayList)request.getAttribute("arr");
 

SchoolEO seo=null;
  %>

  <% if(request.getAttribute("arr")!=null)
 {%>           
   
   <% for(int i=0;i<arr1.size();i++)
   { seo=(SchoolEO)arr1.get(i);
%>

  <table width="90%" cellpadding="0" cellspacing="0"  align="center" height=450>
       <tr><td valign="top">     
            <table width="100%" cellpadding="1" cellspacing="0"  align="center">
 
<tr><td><b>Session:</b></td><td><%=seo.getSyear()%>-<%=seo.getEyear()%></td></tr>
<tr><td><b>Registration Number:</b></td><td><%=seo.getSrnum()%></td></tr>
<tr><td><b>Student Name:</b></td><td><%=seo.getSname()%></td></tr>
<tr><td><b>Class:</b></td><td><%=seo.getClasses()%></td></tr>
<tr><td><b>Months:</b></td><td>
<% try{
ArrayList mon=(ArrayList)request.getAttribute("mon");   
 
SchoolEO seo1=null;
  %>

  <% if(request.getAttribute("mon")!=null)
 {%>           
   
   <% for(int j=0;j<mon.size();j++)
   { seo1=(SchoolEO)mon.get(j);
   %>
<b><%=seo1.getMonth()%></b>(<%=seo1.getFeesubdate()%>),
<%}} }catch(Exception e){e.printStackTrace();}%>
</td></tr>
<tr><td><b>Total Amount Paid:</b></td><td><%=amount%></td></tr>
<tr><td><b>Total Fine Paid:</b></td><td><%=fine%></td></tr>
  
</table>
       </td></tr></table>
       <%
   } }
   }catch(Exception e)
       {}
    }%>
       </td></tr></table> 
</form>   
  </td></tr></table>
  
     <tr><td bgcolor=#455A8B height=20><%@include file="/btmnavi.jsp"%></td></tr>
     </table>    
    
    </body>
</html>
