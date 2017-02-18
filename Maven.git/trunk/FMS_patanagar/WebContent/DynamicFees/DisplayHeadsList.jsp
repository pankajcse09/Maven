<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page language="java"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="java.sql.*,schedule.MyMethods"%>
<%@page import="com.myapp.struts.Dataconnectivity"%>
<%!  
 Connection con=null; 
 PreparedStatement stmt1=null; 
 PreparedStatement stmt2=null;
 ResultSet rs1=null;
 ResultSet rs2=null;
 String cid="";
 String ct="";
 String sn="";
%>
<%response.setHeader("Cache-Control","no-cache");%>
 <%
   MyMethods mm=new MyMethods();   

   ArrayList ar1=new ArrayList(); 
   String ssn="";
   String cls="";
   String sroman="";
   int sint=0;
  
   try
   {
    Dataconnectivity dc=new  Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    } 
    catch(Exception e) 
       {      
       out.println(e.getMessage());
          } 
// String qr1="select distinct sessions from ex_course_detail where convert(substring(sessions,1,4),unsigned)>=(select distinct max(convert(substring(sessions,1,4),unsigned)) from studinfo) order by convert(substring(sessions,1,4),unsigned)";        
    try{
   

      String qry="select rowid heads from feeheads where order by heads";
      stmt1=con.prepareStatement(qry);
      rs1=stmt1.executeQuery();   
      while(rs1.next()){      
      ar1.add(rs1.getString("heads"));
      }  

    }
    catch(SQLException se){
    out.println(se.getMessage());
    }
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
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">  
    <head>
<style type="text/css">.t{border-collapse:collapse}</style>
<script language="javascript" src="<%=request.getContextPath()%>/UnitTest/printData.js"></script>
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>          
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
        <title>Exam Management System</title>
        <script language="javascript">
        function getCourse(){
        document.f1.method="post";
        document.f1.action="<%=request.getContextPath()%>/DynamicFees/DisplayHeadsList.jsp";
        document.f1.submit();          
         }         
       function validate(){        
       if(document.f1.session.value==""){
       alert("Select Session");
       document.f1.session.focus();
       return false;
       }  
       if(document.f1.classes.value==""){
       alert("Select Class");
       document.f1.classes.focus();
       return false;
       }        
       return true;
       } 
        </script> 
    </head>
    <body>   
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center">
<tr><td valign="top"><jsp:include page="/toplook.jsp"/></td></tr>
<tr><td valign="top">
<table border="0" bgcolor="#EEEEEE" cellpadding=0 cellspacing=0 width="100%" height="350">
<tr><td width="100%" align="right"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>
<tr><td width="100%"><table align="left" width="100%"><tr><td width="100%" align="left" valign="top"><a href="javascript:Clickheretoprint('printit')"><font color="blue" size="2"><u><b>Click here to print</b></u></font></a></td></tr></table></td></tr>       
<tr><td valign="top">  
  <center><h4><font color="#000080">Display Heads</font></h4></center>
      <hr color="blue">
   <div id="printit">
     <table width="100%" align="center" border="0"><tr><td align="center"><table align="center"><tr><td align="left"><b>Session:&nbsp;<%=ssn%></b></td><td>|</td><td align="left"><b>Class:&nbsp;<%=sroman%></b></td></tr></table></td></tr></table>
     <table width="40%" align="center" border="1" style="border-collapse:collapse">
     <tr><td width="10%" align="center"><b>SNo.</b></td><td width="70%"><b>Heads</b></td><td width="20%"></td></tr>    
     <%
     int k=0;   
     for(int i=0;i<ar1.size();i++){
     %>      
     <tr><td align="center"><%=++k%></td><td><%=ar1.get(i)%></td>
     <td width="20%"><a href="#"><font color="blue"><b>Update</b></font></a>&nbsp;</b></font></a></td></tr>
     <%}%>
    </table>   
    </div>  
  </td></tr></table>
  </td></tr>
  <tr><td valign="bottom"><%@include file="/footer.jsp"%></td></tr>
  </table>
  </body>
</html>