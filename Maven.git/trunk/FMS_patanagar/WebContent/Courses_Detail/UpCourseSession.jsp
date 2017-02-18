<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page language="java"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="java.sql.*"%>
<%@page import="com.myapp.struts.Dataconnectivity"%>
<%!  
 Connection con=null; 
 PreparedStatement stmt1=null; 
 PreparedStatement stmt2=null;
 ResultSet rs1=null;
 ResultSet rs2=null;
 String cid="";
 String ct="";
%>
<%response.setHeader("Cache-Control","no-cache");%>
 <%
   String sn=""; 
   ArrayList ar1=new ArrayList(); 
   HashMap hm1=new HashMap();
   ArrayList hs=new ArrayList();
   String sm="";
   if(request.getParameter("sem")!=null){
    sm=(String)request.getParameter("sem");  
   }
   try
  {
    Dataconnectivity dc=new  Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    } 
    catch(Exception e){out.println(e.getMessage());}     
       try{           
       String qry="select distinct sessions from ex_course_detail where convert(substring(sessions,1,4),UNSIGNED)=(select max(convert(substring(sessions,1,4),UNSIGNED)) from ex_course_detail)";
       stmt1=con.prepareStatement(qry);
       rs1=stmt1.executeQuery();
      if(rs1.next()){
      sn=rs1.getString("sessions");
      }
  }
catch(SQLException se){out.println(se.getMessage());}
   finally{
       try{
         if(rs1!=null){
             rs1.close();
         }  
         if(stmt1!=null){
             stmt1.close();
         }
         if(con!=null){
             con.close();
         }
       }
       catch(SQLException se){
     out.println(se.getMessage());
     }
   }
%> 
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<meta http-equiv="Content-Language" content="en-us">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/mymenu.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/menu1.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/menu.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/mystyle1.css">
<script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>          
<script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
         
 <title>Home</title>
<base target="_parent">
<meta base target="_para name=Microsoft Theme" content="journal 1111, default">
<meta name="Microsoft Border" content="tlb, default">
<title>Exam Management System</title>
</head>
<body>
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center"><tr><td align="center" valign="top">
<table width="100%"><tr><td valign="top"><%@include file="/toplook.jsp"%></td></tr></table>
<table border="0"  bgcolor="#EEEEEE" cellpadding=0 cellspacing =0 width="100%"  height="330">
<tr><td width="100%" valign="top"><%@include file="/HomeLink.jsp"%></td></tr>   
<tr><td valign="top">   
   <center><h4><font color="#000080">Update Course Availability for Next Session</font></h4></center>
    <form name="f1" method="post" action="<%=request.getContextPath()%>/UpdateAvailability">
    <table align="center" border="0" valign="top">
    <tr><td>Current Session:<%=sn%><input type="hidden" name="session" value="<%=sn%>"></td></tr>    
    <tr><td><input type="submit" value="Update Subject Availability"></td></tr>
    </table>  
    </form>
    <table align="center"><tr><td><font color=red font-style="TimesRoman" size="2"><b>    
  <%
     if(application.getAttribute("msg")!=null){ 
     out.println(application.getAttribute("msg"));
     application.removeAttribute("msg");
     }%>  
 </b></font>
</td></tr></table>
</td></tr></table>
<table width="100%"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr></table>
    </body>
</html>