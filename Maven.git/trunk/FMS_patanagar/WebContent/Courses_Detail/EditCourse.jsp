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
   ArrayList ar3=new ArrayList();
   ArrayList ar4=new ArrayList();
   MyMethods mm=new MyMethods();
   String clas="";
    try{
    Dataconnectivity dc=new  Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    } 
    catch(Exception e){out.println(e.getMessage());}
   ar4=(ArrayList)mm.allClasses();
   ar3=(ArrayList)mm.allSessions();  
   ArrayList ar2=new ArrayList(); 
   String ssn="";
   if(request.getParameter("session")!=null){
   ssn=(String)request.getParameter("session"); 
   } 
   if(request.getParameter("class")!=null){
   clas=(String)request.getParameter("class"); 
   }
    ArrayList ar1=new ArrayList();
    HashMap hm1=new HashMap();
    HashSet hs=new HashSet();    
     try
   {
    Dataconnectivity dc=new  Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    } 
    catch(Exception e) 
       {      
       out.println(e.getMessage());
          } 
 String qr1="select distinct sessions from ex_course_detail where convert(substring(sessions,1,4),SIGNED)>=(select distinct max(convert(substring(sessions,1,4),SIGNED)) from studinfo) order by convert(substring(sessions,1,4),SIGNED)";        
    try{
 stmt2=con.prepareStatement(qr1);
 rs2=stmt2.executeQuery();
 while(rs2.next()){
 ar2.add(rs2.getString("sessions"));    
 }    
 if(request.getParameter("session")!=null && request.getParameter("class")!=null){
      String qry="select distinct subject from ex_course_detail where sessions='"+ssn+"' and class='"+clas+"' order by convert(class,SIGNED)";
      stmt1=con.prepareStatement(qry);
      rs1=stmt1.executeQuery();   
      while(rs1.next()){
      ar1.add(rs1.getString("subject"));   
      }  
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
       <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<meta http-equiv="Content-Language" content="en-us">
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>          
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
<base target="_parent">
<meta base target="_para name=Microsoft Theme" content="journal 1111, default">
<meta name="Microsoft Border" content="tlb, default">
        <title>Exam Management System</title>
        <script language="javascript">
        function getCourse(){
        document.f1.method="post";
        document.f1.action="<%=request.getContextPath()%>/Courses_Detail/EditCourse.jsp";
        document.f1.submit();          
         }
        </script> 
    </head>
    <body>   
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center"><tr><td valign="top">
<table width="100%"><tr><td valign="top"><jsp:include page="/toplook.jsp"/></td></tr></table>
<table border="0" bgcolor="#EEEEEE" cellpadding=0 cellspacing=0 width="100%" height="350">
<tr><td width="100%"><%@include file="/HomeLink.jsp"%></td></tr> 
<tr><td valign="top">  
  <center><h4><font color="#000080">Edit Course</font></h4></center>
    <form name="f1" action="<%=request.getContextPath()%>/Courses_Detail/EditCourseDetail.jsp">  
    <table align="center" border="1" valign="top" class="t">  
      <tr><td>Session:</td>
      <td><select name="session" onchange="getCourse()">   
      <%if(!ssn.equals("")){%>
      <option value="<%=ssn%>"><%=ssn%></option> 
       <%
      }
      else{
       %>
       <option value="">Select</option> 
       <%
         }       
       for(int i=0;i<ar3.size();i++){
       %>   
     <option value="<%=ar3.get(i)%>"><%=ar3.get(i)%></option>    
     <%}%>
     </select>
     </td></tr> 
     <tr><td>Class:</td><td><select name="class" onchange="getCourse()">    
      <%if(!clas.equals("")){%>
      <option value="<%=clas%>"><%=clas%></option> 
       <%
        }
      else{
       %>
       <option value="">Select</option> 
       <%
        } 
     for(int i=0;i<ar4.size();i++){
     %>
    <option value="<%=ar4.get(i)%>"><%=ar4.get(i)%></option>
    <%}%>
    </select>
    </td></tr>
    <tr><td>Subject:</td><td><select name="subject">    
     <%
     for(int i=0;i<ar1.size();i++){
     %>
    <option value="<%=ar1.get(i)%>"><%=ar1.get(i)%></option>
    <%}%>
    </select>
    </td></tr>
    <tr><td colspan="2" align="right"><input type="submit" value="Edit Course"></td></tr></table>     
    </form>   
    <table align="center"><tr><td><font color="red" size="2"><b>    
  <%
     if(application.getAttribute("course_success")!=null){ 
     out.println(application.getAttribute("course_success"));
     application.removeAttribute("course_success");
     }%>  
</b></font></td></tr></table>
  </td></tr></table>
<table width="100%"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr></table>
    </body>
</html>