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

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/mymenu.css">
<script language="javascript" src="<%=request.getContextPath()%>/fee/resolution.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/fee/calendarDateInput.js"></script>  
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/menu.css">
<script language="javascript" src="<%=request.getContextPath()%>/fee/menu.js"></script>        
     <title>School Management System</title>
    </head>
    <body>
    
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center">
<tr><td><jsp:include page="/fee/ftoplook.jsp"/></td></tr>
<tr><td>
<table border="0"  bgcolor="#EEEEEE" cellpadding=0 cellspacing =0 width="100%"  height="330">
<tr><td width="100%"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>   
<tr><td valign="top">
<table width="100%" align="center"><tr><td align="center"><h3><font color="#34282C" >Fee Structure</font></h3></td></tr></table>  

<form action="<%=request.getContextPath()%>/feer.do?update=update" method="post" name="feest">


   <% 
    Connection cn=null;
    Statement stmt=null;
    ResultSet rs=null;
    int k=0;
      try{        
            DataConnection dc1=new DataConnection();
            cn=(Connection)dc1.Dataconnect();
      }
      catch(Exception e){}
try
{
    String qry1="Select cid from classes order by cid desc";
     
             stmt=cn.createStatement();
             rs=stmt.executeQuery(qry1);
             rs.next();
             int cid=rs.getInt("cid");                 

ArrayList arr1=(ArrayList)request.getAttribute("array"); 

%>

  <% if(request.getAttribute("array")!=null)
 {%>      
 
<table cellpadding="4" cellspacing="3" width="100%" border=1>
    <td width="8%" align="center"><b>Class</b></td>
<td width="6%" align="center"><b>April</b></td>
<td width="6%" align="center"><b>May</b></td>
<td width="6%" align="center"><b>June</b></td>
<td width="5%" align="center"><b>July</b></td>
<td width="6%" align="center"><b>August</b></td>
<td width="6%" align="center"><b>Sept.</b></td>
<td width="6%" align="center"><b>Oct.</b></td>
<td width="5%" align="center"><b>Nov.</b></td>
<td width="6%" align="center"><b>Dec.</b></td>
<td width="6%" align="center"><b>Jan.</b></td>
<td width="6%" align="center"><b>Feb.</b></td>
<td width="6%" align="center"><b>March</b></td>
<td width="11%"align="center"><b>Status</b></td>
<% //int j=0;
//for(j=0;j<14;j++)
//{
for(int j=0;j<cid*3;j++)
   { 
    SchoolEO seo=new SchoolEO();
     seo=(SchoolEO)arr1.get(j);
%>
          <input type="hidden" size="9" name="classes<%=j%>" value="<%=seo.getClasses()%>">
<input type="hidden" size="5" name="apr<%=j%>" value="<%=seo.getApr()%>">
<input type="hidden" size="5" name="may<%=j%>" value="<%=seo.getMay()%>">
<input type="hidden" size="5" name="june<%=j%>" value="<%=seo.getJune()%> ">
<input type="hidden" size="5" name="july<%=j%>" value="<%=seo.getJuly()%>">
<input type="hidden" size="5" name="aug<%=j%>" value="<%=seo.getAugust()%>">
<input type="hidden" size="5" name="sept<%=j%>" value="<%=seo.getSept()%>">
<input type="hidden" size="5" name="oct<%=j%>" value="<%=seo.getOct()%>">
<input type="hidden" size="5" name="nov<%=j%>" value="<%=seo.getNov()%>">
<input type="hidden" size="5" name="dec<%=j%>" value="<%=seo.getDec()%>">
<input type="hidden" size="5" name="jan<%=j%>" value="<%=seo.getJan()%>">
<input type="hidden" size="5" name="feb<%=j%>" value="<%=seo.getFeb()%>">
<input type="hidden" size="5" name="mar<%=j%>" value="<%=seo.getMar()%>">
<input type="hidden" size="14" name="status<%=j%>" value="<%=seo.getStatus()%>">
          <tr><td align="center" bgcolor="#DCDCDC"><%=seo.getClasses()%></td>
          <td align="center" bgcolor="#F5F5F5"><%=seo.getApr()%></td>
          <td align="center" bgcolor="#DCDCDC"><%=seo.getMay()%></td>
          <td align="center" bgcolor="#F5F5F5"><%=seo.getJune()%></td>
          <td align="center" bgcolor="#DCDCDC"><%=seo.getJuly()%></td>
          <td align="center" bgcolor="#F5F5F5"><%=seo.getAugust()%></td>
          <td align="center" bgcolor="#DCDCDC"><%=seo.getSept()%></td>
          <td align="center" bgcolor="#F5F5F5"><%=seo.getOct()%></td>
          <td align="center" bgcolor="#DCDCDC"><%=seo.getNov()%></td>
          <td align="center" bgcolor="#F5F5F5"><%=seo.getDec()%></td>
          <td align="center" bgcolor="#DCDCDC"><%=seo.getJan()%></td>
          <td align="center" bgcolor="#F5F5F5"><%=seo.getFeb()%></td>
          <td align="center" bgcolor="#DCDCDC"><%=seo.getMar()%></td>
          <td align="center" bgcolor="#F5F5F5"><%=seo.getStatus()%></td>
          <input type="hidden" name="rowid<%=j%>" value="<%=seo.getRowid()%>">

          </tr>   
  
    <%  }
  }
     }catch(SQLException r)
     {}%>
  </table></td></tr>

   
        
  </form>
</table>
    </body>
</html>