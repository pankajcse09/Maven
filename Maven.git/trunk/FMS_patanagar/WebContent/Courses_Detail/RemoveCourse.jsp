<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page language="java"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="java.sql.*"%>
<%@page import="com.myapp.struts.Dataconnectivity,schedule.MyMethods"%>
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
   ArrayList ar1=new ArrayList(); 
   String ssn="";
   String clas="";
   if(request.getParameter("session")!=null){
   ssn=(String)request.getParameter("session");    
   }
   if(request.getParameter("class")!=null){
   clas=(String)request.getParameter("class");    
   }
   try
  {
    Dataconnectivity dc=new  Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    } 
    catch(Exception e) 
       {      
       out.println(e.getMessage());
       } 
   ArrayList ar4=new ArrayList();
   MyMethods mm=new MyMethods();
   ar4=(ArrayList)mm.allClasses();
 String qr1="select distinct sessions from ex_course_detail";        
 try{
 stmt2=con.prepareStatement(qr1);
 rs2=stmt2.executeQuery();
 while(rs2.next()){
 ar1.add(rs2.getString("sessions"));    
 }
 }
 catch(SQLException se){
 out.println(se.getMessage());    
 }
%> 
<html>
<head>
<style type="text/css">.t{border-collapse:collapse}</style>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<meta http-equiv="Content-Language" content="en-us">
         <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
        <base target="_parent">
        <title>Exam Management System</title>
        <script language="javascript">
        function getCourse(){
        document.f1.method="post";
        document.f1.action="<%=request.getContextPath()%>/Courses_Detail/RemoveCourse.jsp";
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
    <form name="f1" method="post" action="<%=request.getContextPath()%>/RemoveCours">    
    <table align="center" border="1" class="t"><tr><td>     
    Session:</td><td><select name="session" onchange="getCourse()">  
    <%
      if(ssn.equals("")){ 
    %>  
    <option value="">select</option> 
    <%}
    else{
    %>
    <option value="<%=ssn%>"><%=ssn%></option> 
    <%
     }      
    for(int i=0;i<ar1.size();i++){  
     if(ar1.get(i).equals(ssn.toString())){
     continue;    
     }
    %>    
    <option value="<%=ar1.get(i)%>"><%=ar1.get(i)%></option>       
    <%}%>
    </select></td></tr>
    <tr><td>Class:</td><td><select name="class" onchange="getCourse()">  
    <%
      if(clas.equals("")){ 
    %>  
    <option value="">select</option> 
    <%}
    else{
    %>
    <option value="<%=clas%>"><%=clas%></option> 
    <%
     }      
    for(int i=0;i<ar4.size();i++){  
     if(ar4.get(i).equals(clas.toString())){
     continue;    
     }
    %>    
    <option value="<%=ar4.get(i)%>"><%=ar4.get(i)%></option>       
    <%}%>
    </select></td></tr>
    <%      
    try{
       String qry="select distinct subject from ex_course_detail where sessions='"+ssn+"' and class='"+clas+"'";       
       stmt1=con.prepareStatement(qry);
       rs1=stmt1.executeQuery();
    %>    
    <tr><td>Subject:</td><td><select name="subject">    
    <%
       while(rs1.next()){
      cid=(String)rs1.getString("subject");   
      //ct=(String)rs1.getString("title");
   %>    
    <option value="<%=cid%>"><%=cid%></option>
   <%}%>
</select></td></tr>
    <tr><td align="right" colspan="2"><input type="submit" value="Remove Course"></td></tr></table>  
    <%}
catch(SQLException se){
    out.println(se.getMessage());
}
   finally{
       try{
         if(rs1!=null){
             rs1.close();
         }  
         if(rs2!=null){
             rs2.close();
         }  
         if(stmt1!=null){
             stmt1.close();
         }
            if(stmt2!=null){
             stmt2.close();
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
    </form>
 <table align="center"><tr><td><font color=red font-style="TimesRoman" size="2"><b>    
 <%
if(request.getAttribute("course_success")!=null){
out.println(request.getAttribute("course_success"));
}%> 
</b></font>
</td></tr></table>            
</td></tr></table>

<table width="100%"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>

</td></tr></table>    
    </body>
</html>