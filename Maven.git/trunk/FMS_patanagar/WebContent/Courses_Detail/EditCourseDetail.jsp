<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page language="java"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="java.sql.*"%>
<%@page import="com.myapp.struts.*"%>
<%!  
 Connection con=null; 
 PreparedStatement stmt1=null; 
 PreparedStatement psmt3=null;
 ResultSet rs1=null; 
 ResultSet rs3=null;
%>
<%response.setHeader("Cache-Control","no-cache");%>
 <%
    String cid="";
    String ssn="";
    String clas="";
    String sub="";
    String th="";
    String prac="";
    String mcq="";
    String unit="";
    
    ssn=(String)request.getParameter("session");
    clas=(String)request.getParameter("class");
    sub=(String)request.getParameter("subject");
    
   try
  {
    Dataconnectivity dc=new  Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    } 
    catch(Exception e) 
       {      
       out.println(e.getMessage());
          }     
    try{
        /**
        String qr2="select distinct sessions from ex_course_detail where TO_NUMBER(substr(sessions,1,4))=(select max(TO_NUMBER(substr(sessions,1,4))) from ex_course_detail)";   
        psmt3=con.prepareStatement(qr2);
        rs3=psmt3.executeQuery();
        while(rs3.next()){ 
        ssn=rs3.getString("sessions");
        break;
         }
 **/
           String qry="select * from ex_course_detail where sessions='"+ssn+"' and class='"+clas+"' and subject='"+sub+"' and exist='y'";  
           stmt1=con.prepareStatement(qry);
           rs1=stmt1.executeQuery();
           while(rs1.next()){
           th=(String)rs1.getString("theory");
           prac=(String)rs1.getString("practical");
           mcq=(String)rs1.getString("mcq");
           unit=(String)rs1.getString("unittest");
           }}
           catch(SQLException se){
               out.println(se.getMessage());
           }
           finally{
               try{
                   if(rs1!=null){rs1.close();}                  
                   if(stmt1!=null){stmt1.close();} 
                   if(con!=null){con.close();} 
                 }
               catch(SQLException se){
               out.println(se.getMessage());
               }
           }           
%>    
<html>
    <head>
     <style type="text/css">.t{border-collapse:collapse}</style>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<meta http-equiv="Content-Language" content="en-us">
 <title>Home</title>
<base target="_parent"><link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/mystyle1.css">
<met base target="_para name="Microsoft Theme" content="journal 1111, default">
<meta name="Microsoft Border" content="tlb,default">
<link rel="stylesheet"  href="<%=request.getContextPath()%>/menu.css">
<script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script> 
<script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>        
        <script language="javascript">
           function changeclg(){
           function tchange(){
           document.course.c_credit.value=parseInt(document.course.c_tut.value)+parseInt(document.course.c_per.value);
           document.course.c_per.focus();
           }
           function pchange(){
           document.course.c_credit.value=parseInt(document.course.c_tut.value)+parseInt(document.course.c_per.value);
           document.course.c_sem.focus();
            }            
            }    
           function validate(){            
           if(document.course.c_title.value=="")
            {
           alert("please enter Course Title field");
           document.course.c_title.focus();
           return false;               
             } 
          if(document.course.c_credit.value=="")
            {
           alert("please enter Total Credits");
           document.course.c_credit.focus();
           return false;               
             }
          if(document.course.sem.value=="")
            {
           alert("Select Semester");
           document.course.sem.focus();
           return false;               
             } 
            }
        </script>        
        <title>Edit Course Details</title>
        </head>        
    <body bgcolor="white">
   <table width="100%" ><tr><td><%@include file="/toplook.jsp"%></td></tr></table>
   <table border="0"  bgcolor="#EEEEEE" cellpadding=0 cellspacing =0 width="100%"  height="350">       
   <tr><td width="100%"><%@include file="/HomeLink.jsp"%></td></tr> 
   <tr><td>
    <table align="right"><tr><td align="right"><a href="<%=request.getContextPath()%>/Courses_Detail/EditCourse.jsp"><font color="blue"><u><b>Back</b></u></font></a></td></tr></table>
    <br>   
    <table width="100" height="50"><tr><td></td></tr></table>    
    <form name="course" method="post" action="<%=request.getContextPath()%>/Edit_Course_Detail" onsubmit="return validate()">
        <center><font color="blue" size="3"><b>Edit Course Details</b></font></center><br>
        <table align="center" border="1" class="t"> 
        <tr><td colspan="2">
<%
if(request.getAttribute("msg")!=null){ 
     %>       
<font color="red"><%=request.getAttribute("msg")%></font>
<%}%> 
 </td></tr>    
            <tr><td>Session:</td><td><%=ssn%><input type="hidden" name="session" value="<%=ssn%>"> </td></tr>    
            <tr><td>Class:</td><td><%=clas%><input type="hidden" name="class" value="<%=clas%>"></td></tr>  
            <tr><td>Subject:</td><td><%=sub%><input type="hidden" name="subject" value="<%=sub%>"></td></tr>
            <tr><td>Theory:</td><td><input type="text" name="theory" size="10" value="<%=th%>"></td></tr>
            <tr><td>Practical:</td><td><input type="text" name="practical" size="10" value="<%=prac%>"></td></tr>
            <tr><td>MCQ:</td><td><input type="text" name="mcq" size="10" value="<%=mcq%>"></td></tr>   
            <tr><td>Unit Test:</td><td><input type="text" name="unittest" size="10" value="<%=unit%>"></td></tr>  
            <tr><td colspan="2" align="center"><input type="submit" value="submit"></td></tr>
            </table>          
            </form> 
  <table width="100%"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>         
  </td></tr></table>
  </body>
</html>
