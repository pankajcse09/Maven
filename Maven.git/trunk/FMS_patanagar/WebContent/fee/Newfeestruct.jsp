<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
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

    
<%     
  int k=0;
  SchoolEO seo=null;

    if(request.getAttribute("sbean")!=null){
    seo=(SchoolEO)request.getAttribute("sbean");
    }
    ArrayList ar1=new ArrayList();
    ar1=(ArrayList)seo.getClassList();
    try
{
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
<table width="60%" align="center"><tr><td align="center"><h3><font color="#34282C" >Fee Structure</font></h3></td></tr></table>  

<form action="<%=request.getContextPath()%>/dfst.do?dispfee=dispfee" method="post" name="feest" onsubmit="return chkvalidate()">


  <table width="90%" cellpadding="0" cellspacing="0" align="center" border="0"> 
  <tr><td valign="top">
  <%  if((String)request.getAttribute("msg")!=null){
    out.println("<font color='red'><b>"+(String)request.getAttribute("msg")+"</b></font>");} %>
  <table width="90%" cellpadding="0" cellspacing="2" align="center" border="0"> 

  <% if(ar1!=null)
 {%>       
      <tr><td valign="top">
<table width="100%" cellpadding="0" cellspacing="0" align="center"> 
<tr><td width="100%"><table cellpadding="4" cellspacing="4" border="0" width="100%"><tr>
<tr><td><table cellpadding="4" cellspacing="3" border="2" bordercolor="#34689A" width="100%" style="border-collapse:collapse">
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
<% 
HashMap hm1=(HashMap)seo.getClassFee();
for(int j=0;j<ar1.size();j++){ 
HashMap hm2=(HashMap)hm1.get(ar1.get(j)); 
%>
          <tr><td align="center" bgcolor="#DCDCDC"><%=ar1.get(j)%></td>
          <td align="center" bgcolor="#F5F5F5"><%if(hm2.get("January")!=null){%><%=hm2.get("January")%><%}else{%>NA<%}%></td>
          <td align="center" bgcolor="#DCDCDC"><%if(hm2.get("February")!=null){%><%=hm2.get("February")%><%}else{%>NA<%}%></td>
          <td align="center" bgcolor="#F5F5F5"><%if(hm2.get("March")!=null){%><%=hm2.get("March")%><%}else{%>NA<%}%></td>
          <td align="center" bgcolor="#DCDCDC"><%if(hm2.get("April")!=null){%><%=hm2.get("April")%><%}else{%>NA<%}%></td>
          <td align="center" bgcolor="#F5F5F5"><%if(hm2.get("May")!=null){%><%=hm2.get("May")%><%}else{%>NA<%}%></td>
          <td align="center" bgcolor="#DCDCDC"><%if(hm2.get("June")!=null){%><%=hm2.get("June")%><%}else{%>NA<%}%></td>
          <td align="center" bgcolor="#F5F5F5"><%if(hm2.get("July")!=null){%><%=hm2.get("July")%><%}else{%>NA<%}%></td>
          <td align="center" bgcolor="#DCDCDC"><%if(hm2.get("August")!=null){%><%=hm2.get("August")%><%}else{%>NA<%}%></td>
          <td align="center" bgcolor="#F5F5F5"><%if(hm2.get("September")!=null){%><%=hm2.get("September")%><%}else{%>NA<%}%></td>
          <td align="center" bgcolor="#DCDCDC"><%if(hm2.get("October")!=null){%><%=hm2.get("October")%><%}else{%>NA<%}%></td>
          <td align="center" bgcolor="#F5F5F5"><%if(hm2.get("November")!=null){%><%=hm2.get("November")%><%}else{%>NA<%}%></td>
          <td align="center" bgcolor="#DCDCDC"><%if(hm2.get("December")!=null){%><%=hm2.get("December")%><%}else{%>NA<%}%></td>
          </tr>   
      <%}%>
      <tr><td colspan="13" align="left">(NA&nbsp;-&nbsp;Not Available)</td></tr>
    <tr><table border=1 align="center">
   <!-- <tr> <td align="center"><a href="<%=request.getContextPath()%>/fee/updatefeestr.jsp"><font color="#34282C"><b>Update Fee Structure</b></font></a></td>
    <td><table align=center><tr><td><a href="<%=request.getContextPath()%>/fee/delfeestruct.jsp"><font color="#34282C"><b>Delete</b></font></a></td></tr></table></td></tr>
    </table></tr> -->
    </table></td></tr></table></td></tr>
   <%}}catch(Exception e){} %>  
         </td></tr></table>
   </td></tr></table>
  </form>
</td></tr></table>

    <tr><td valign="top">
<table width="100%" bgcolor="34689A"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr>
     </table>    
    </body>
</html>