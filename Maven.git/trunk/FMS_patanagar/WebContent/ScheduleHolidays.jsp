<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@page language="java" %>
<%@page import="java.util.*" %>
<%@ page import="java.sql.*"%>
<%@page import="com.myapp.struts.Dataconnectivity"%>
<%!  
 Connection con=null; 
 PreparedStatement stmt1=null;
 PreparedStatement stmt2=null;
 ResultSet rs1=null;
 ResultSet rs2=null;
%>
 <%
    List ar1=new ArrayList();
    String dg="";
    String yr="";
    String eo="";
    String et=""; 
    if(request.getParameter("degree")!=null){dg=request.getParameter("degree");}
    if(request.getParameter("yrs")!=null){yr=request.getParameter("yrs");}
    if(request.getParameter("evod")!=null){eo=request.getParameter("evod");}
    if(request.getParameter("exmtyp")!=null){et=request.getParameter("exmtyp");}
    String sem="";
    if(eo.equals("odd")){
    sem="1";    
    }
    else{
    sem="2";    
    }
  try
  {
    Dataconnectivity newsdc=new  Dataconnectivity();
    con=(Connection)newsdc.Dataconnect();
    } 
    catch(Exception e) 
       {
       out.println("<h4>Database Connection Problem.</h4>");
       e.printStackTrace();
       }
    try{
      String qr1="select deg_name from degree_details";
      stmt1=con.prepareStatement(qr1);
      rs1=stmt1.executeQuery();
      while(rs1.next()){
       ar1.add(rs1.getString(1));   
      }
    }
    catch(SQLException se){
      out.println(se.getMessage());  
    }
%>       
<html>
  <head>
   <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
   <meta http-equiv="Content-Language" content="en-us">
   <script language="javascript" src="<%=request.getContextPath()%>/calendarDateInput.js"></script> 
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>          
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>         
    <script language="javascript">
       function validate(){        
       if(document.f1.session.value==""){
       alert("Select Session");
       document.f1.session.focus();
       return false;
       }  
       if(document.f1.holiday.value==""){
       alert("Enter Holiday Name");
       document.f1.holiday.focus();
       return false;
       }             
       return true;
       }    
      </script> 
</head> 
<body  onload="window.history.forward(0)">
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center">
<tr><td valign="top"><jsp:include page="/toplook.jsp"/></td></tr>
<tr><td valign="top">
<table border="0" bgcolor="#EEEEEE" cellpadding=0 cellspacing=0 width="100%" height="350">
<tr><td width="100%"><%@include file="/HomeLink.jsp"%></td></tr>     
<tr><td valign="top">
<table width="100%" valign="top"><tr><td height="45"></td></tr>
<tr><td valign="top"><center><h4><font color="#000080">Schedule Holiday</font></h4></center></td></tr></table>
<table width="100%" valign="top"><tr><td width="100%" valign="top">
<form name="f1" method="post" action="SchedHolidays" onsubmit="return validate();">
<table align="center">
<tr><td align="left">Session:</td><td align="left">   
 <select name="session">
    <script language="javascript">
     var dt=new Date();
     var yr=dt.getYear();
     var yr1=yr+1;
     var yr2=yr-1;
     document.write('<option value=\"'+yr2+'-'+yr+'\">'+yr2+'-'+yr);
     document.write('<option value=\"'+yr+'-'+yr1+'\">'+yr+'-'+yr1);     
    </script>
 </select></td></tr></table>
</td></tr></table> 
 <%       
    if((String)request.getAttribute("result")!=null){
out.println("<center><font color='red'><b>"+(String)request.getAttribute("result")+"</b></font></center>");
    }
%>
  <table width="100%"><tr><td width="100%" height="20"></td></tr>
  <tr><td>
 <table width="40%" align="center">
 <tr><td width="50%" align="left"><font size="3" color="#000080">Available Date List:</font></td>
 <td width="50%" align="left"><script>DateInput('dated',true,'dd/mm/yyyy')</script></td></tr>
 <tr><td width="50%" align="left"><font size="3" color="#000080">Occasion:</font></td>
 <td width="50%" align="left"><input type="text" name="holiday" size="20"></td></tr>
 <tr><td colspan="2" align="center"><input type="submit" value="Submit"></td></tr> 
 </table>
 </form>
  </td></tr></table>     
  </td></tr></table>

<tr><td valign="top">
<table width="100%" bgcolor="#5663C7"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr>

</td></tr></table>

  </body>
  </html>