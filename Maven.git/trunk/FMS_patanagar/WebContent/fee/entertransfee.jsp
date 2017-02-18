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
<script language="javascript" src="<%=request.getContextPath()%>/fee/validation.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/fee/calendarDateInput.js"></script>  
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/menu.css">
<script language="javascript" src="<%=request.getContextPath()%>/fee/menu.js"></script>    
    <script language="javascript">
     
  function chkvalidate()
{

if(document.feest.route.value=="")
{
alert("Please enter Route");
document.feest.route.focus();
return (false);
} 
if(document.feest.busfee.value==""){
          alert("Please Enter Busfee ");
          document.feest.busfee.focus();
          return false;
          }
          else{
          var k=validint(1);
          if(k==false){return false;}
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
<table width="60%" align="center"><tr><td align="center"><h3><font color="#34282C" >Enter Transport Fee</font></h3></td></tr></table>  

<form action="<%=request.getContextPath()%>/etransrut.do" method="post" name="feest" onsubmit="return chkvalidate()">


  <table width="100%" cellpadding="0" cellspacing="0" align="center" border="0"> 
  <tr><td valign="top">
  <table width="35%" cellpadding="4" cellspacing="3" align="center" border="0"> 
<%  if((String)request.getAttribute("msg")!=null)
    out.println("<font color='red'><b>"+(String)request.getAttribute("msg")+"</b></font>"); %>

  <TR><TD HEIGHT=10></TD></TR>
    <tr><td><b>Route</b></td><td><input type="text" name="route"></td></tr>   
    <tr><td><b>Bus Fee</b></td><td><input type="text" name="busfee"></td></tr>   
    <tr><td><input type="submit" value="Submit"></td></tr>
  </table></td></tr></table>
  </form>
</td></tr></table>

     <tr><td bgcolor="#34689A" height=20><%@include file="/btmnavi.jsp"%></td></tr>
     </table>    
    </body>
</html>