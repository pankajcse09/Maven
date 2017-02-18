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
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center">
<tr><td><jsp:include page="/fee/ftoplook.jsp"/></td></tr>
<tr><td>
<table border="0"  bgcolor="#EEEEEE" cellpadding=0 cellspacing =0 width="100%"  height="330">
<tr><td width="100%"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>   
<tr><td valign="top">  
<table width="60%" align="center"><tr><td align="center"><h3><font color="#34282C" >Define Fee Structure</font></h3></td></tr></table>  

<form action="<%=request.getContextPath()%>/efeestr.do?update=update" method="post" name="feest" onsubmit="return chkvalidate()">


  <table width="70%" cellpadding="0" cellspacing="0" align="center" border="0"> 
  <tr><td valign="top">
  <table width="60%" cellpadding="0" cellspacing="2" align="center" border="1"> 

<%  if((String)request.getAttribute("msg")!=null)
    out.println("<font color='red'><b>"+(String)request.getAttribute("msg")+"</b></font>"); %>
    
  
 
      <tr><td valign="top">
  <table width="100%" cellpadding="0" cellspacing="0" align="center"> 

<tr><td width="100%">
   <table width="30%" cellpadding="0" cellspacing="0" align="center"> 
   
</table></td></tr>
  <tr><td valign="top">
  <table width="100%" cellpadding="0" cellspacing="0" align="center"> 
<tr><td width="100%"><table cellpadding="0" cellspacing="2" border="2" width="100%"><tr>
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

</tr>
    <%
    
   SchoolEO seo2=new SchoolEO();
   ArrayList arr3=new ArrayList(); 
   int cid=0;
  try{        
            DataConnection dc1=new DataConnection();
            cn=(Connection)dc1.Dataconnect();
      }
      catch(Exception e){}
 try
  { 
     String qry1="Select count(*) as num from classes";
    // out.println(qry1);
             stmt=cn.createStatement();
             rs=stmt.executeQuery(qry1);
             rs.next();
             cid=rs.getInt("num");      
             
    String qry="Select class from classes ";
    
             stmt1=cn.createStatement();
             rs1=stmt1.executeQuery(qry);
             while(rs1.next()) {             
             arr3.add(rs1.getString("class")); 
   }

%>

<%
     int i=0;
for(i=0;i<cid;i++){  
%>           
<tr>
<input type="hidden" size="9" name="classes<%=i%>" value="<%=arr3.get(i)%>" >
<td align="center"  bgcolor="#DCDCDC"><%=arr3.get(i)%></td>
          <td align="center" bgcolor="#F5F5F5"><input type="text" size="5" name="jan<%=i%>"></td>
          <td align="center" bgcolor="#DCDCDC"><input type="text" size="5" name="feb<%=i%>"></td>
          <td align="center" bgcolor="#F5F5F5"><input type="text" size="5" name="march<%=i%>"></td>
          <td align="center" bgcolor="#DCDCDC"><input type="text" size="5" name="april<%=i%>"></td>
          <td align="center" bgcolor="#F5F5F5"><input type="text" size="5" name="may<%=i%>"></td>
          <td align="center" bgcolor="#DCDCDC"><input type="text" size="5" name="june<%=i%>"></td>
          <td align="center" bgcolor="#F5F5F5"><input type="text" size="5" name="july<%=i%>"></td>
          <td align="center" bgcolor="#DCDCDC"><input type="text" size="5" name="aug<%=i%>"></td>
          <td align="center" bgcolor="#F5F5F5"><input type="text" size="5" name="sept<%=i%>"></td>
          <td align="center" bgcolor="#F5F5F5"><input type="text" size="5" name="oct<%=i%>"></td>
          <td align="center" bgcolor="#DCDCDC"><input type="text" size="5" name="nov<%=i%>"></td>
          <td align="center" bgcolor="#F5F5F5"><input type="text" size="5" name="dec<%=i%>"></td>
</tr> 
<%  }
%>
</tr></table></td></tr>
 <tr><td height="10"></td></tr>
       <tr><td align="center"><input type="submit" value="Submit"></td></tr>
  </table></td></tr>
       
  <%
 }
catch(SQLException e){} 
  %> 
         </td></tr></table>
   </td></tr></table>
  </form>
</td></tr></table>

     <tr><td bgcolor=#455A8B height=20><%@include file="/btmnavi.jsp"%></td></tr>
     </table>    
    </body>
</html>