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

if(document.feest.month.value=="")
{
alert("Please enter month");
document.feest.month.focus();
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
<table width="60%" align="center"><tr><td align="center"><h3><font color="#34282C" >Fee Chart</font></h3></td></tr></table>  

<form action="<%=request.getContextPath()%>/feech.do?sub=sub" method="post" name="feest" onsubmit="return chkvalidate()">


  <table width="100%" cellpadding="0" cellspacing="0" align="center" border="1"> 
  <tr><td valign="top">
  <table width="100%" cellpadding="4" cellspacing="3" align="center" border="1"> 
<%  if((String)request.getAttribute("msg")!=null)
    out.println("<font color='red'><b>"+(String)request.getAttribute("msg")+"</b></font>"); %>
<table width="30%" cellpadding="0" cellspacing="0" align="center">        
  <tr><td>Months:</td><td><select name="month">
      <option value="">-Select-</option>
      <option value="January">January</option>
      <option value="February">February</option>
      <option value="March">March</option>
      <option value="April">April</option>
      <option value="May">May</option>
      <option value="June">June</option>
      <option value="July">July</option>
      <option value="August">August</option>
      <option value="September">September</option>
      <option value="October">October</option>
      <option value="November">November</option>
      <option value="December">December</option>      
  </select></td></tr>  
</table></td></tr>
  <tr><td valign="top">
  <table width="80%" cellpadding="0" cellspacing="0" align="center" border="0"> 
<tr><td width="100%"><table cellpadding="0" cellspacing="2" border="1" width="100%"><tr>
<tr>
<td width="10%" align="center"><b>Classes</b></td>
<td width="10%" align="center"><b>Admission</b></td>
<td width="10%" align="center"><b>Welfare</b></td>
<td width="10%" align="center"><b>Tution</b></td>
<td width="10%" align="center"><b>Computer</b></td>
<td width="10%" align="center"><b>Games</b></td>
<td width="10%" align="center"><b>Library</b></td>
<td width="10%" align="center"><b>Science</b></td>
<td width="10%" align="center"><b>Examination</b></td>
<td width="10%" align="center"><b>Re-Adm</b></td>
<td width="10%" align="center"><b>Other</b></td>
</tr>

    <%
    
   SchoolEO seo2=new SchoolEO();
   ArrayList arr3=new ArrayList(); 
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
             int cid=rs.getInt("num");      
             
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
  <input type="hidden" size="9" name="classes<%=i%>" value="<%=arr3.get(i)%>">

          <td align="center"  bgcolor="#DCDCDC"><%=arr3.get(i)%></td>
          <td align="center" bgcolor="#F5F5F5"><input type="text" value="0" size="5" name="adm<%=i%>"></td>
          <td align="center" bgcolor="#DCDCDC"><input type="text" value="0" size="5" name="welfare<%=i%>"></td>
          <td align="center" bgcolor="#F5F5F5"><input type="text" value="0" size="5" name="tution<%=i%>"></td>
          <td align="center" bgcolor="#DCDCDC"><input type="text" value="0" size="5" name="comp<%=i%>"></td>
          <td align="center" bgcolor="#F5F5F5"><input type="text" value="0" size="5" name="games<%=i%>"></td>
          <td align="center" bgcolor="#DCDCDC"><input type="text" value="0" size="5" name="lib<%=i%>"></td>
          <td align="center" bgcolor="#F5F5F5"><input type="text" value="0" size="5" name="sci<%=i%>"></td>
          <td align="center" bgcolor="#DCDCDC"><input type="text" value="0" size="5" name="exam<%=i%>"></td>
          <td align="center" bgcolor="#DCDCDC"><input type="text" value="0" size="5" name="redm<%=i%>"></td>
          <td align="center" bgcolor="#DCDCDC"><input type="text" value="0" size="5" name="other<%=i%>"></td>
          
</tr> 
<%}%>
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