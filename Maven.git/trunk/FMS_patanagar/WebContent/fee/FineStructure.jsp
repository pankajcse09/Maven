<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.sql.*"%>
<%@page language="java"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="java.util.*"%>
<%@page import="AO.*"%>
<%@page import="EO.SchoolEO"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/mymenu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/fee/resolution.js"></script>
        <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/menu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/fee/menu.js"></script>           
        <title>School Management System</title>   
    </head>
    <body>   
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#34689A" align="center">
<tr><td><jsp:include page="/fee/ftoplook.jsp"/></td></tr>
<tr><td>
<table border="0"  bgcolor="#FFB76F" cellpadding=0 cellspacing =0 width="100%"  height="330">
<tr><td width="100%"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>   
<tr><td valign="top">
  <table height=450 align="center" width="60%" border="0"><tr><td valign="top">
  <% if((String)request.getAttribute("mess")!=null)
               out.println("<font color='red'><b>"+(String)request.getAttribute("mess")+"</b></font>");
   %> 
  <form action="<%=request.getContextPath()%>/finestr.do?updatefine=updatefine" method="post">
      
 <table width="100%" align="center"><tr><td align="center"><h3><font color="#34282C">Define Fine Structure</font></h3></td>
 <td height="20"></td></tr></table>    
 
<table width="100%" cellpadding="0" cellspacing="0" align="center">     
<% 
try
{
ArrayList arr1=(ArrayList)request.getAttribute("array");

%>

  <% if(request.getAttribute("array")!=null)
 {%>      
   <% 
%>

      <% //int j=0;
//for(j=0;j<14;j++)
//{
for(int j=0;j<arr1.size();j++)
   { 
    SchoolEO seo=new SchoolEO();
     seo=(SchoolEO)arr1.get(j);
%>
<tr><td height="10"></td></tr>
    
          <tr><td><b>Last Date:</b></td><td><input type="text" name="lastdate" value="<%=seo.getLastdate()%>"></td></tr></tr>
           <tr><td><b>Fine:</b></td><td><input type="text" name="fine" value="<%=seo.getFine()%>"></td></tr></tr>
          <td align="left"><a href="<%=request.getContextPath()%>/fee/updatefinestr.jsp"><font color="#34282C">Update</font></a>

         <%  }   %>

    <%
}
  else
  {
    %>
  
          <tr><td>Last Date:</td><td><input type="text" name="lastdate"></td></tr>
          <tr><td>Fine:</td><td><input type="text" name="fine"></td></tr>
          
   <%  }
   }catch(Exception e)
       {}%> 
       </table>
      
       <table align="center"><tr><td align="center" valign="top"><input type="submit" value="Submit"></td></tr></table>
        </td></tr></table>
  </form>
  
          </td></tr></table>
          
    <tr><td valign="top">
<table width="100%" bgcolor="#34689A"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr>
     </table>    
    </body>
</html>
