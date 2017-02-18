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

   ArrayList ar2=new ArrayList(); 
   String ssn="";
   String cls="";
   String sroman="";
   int sint=0;
   if(request.getParameter("session")!=null){
   ssn=(String)request.getParameter("session");    
   }
   if(request.getParameter("classes")!=null){
   cls=(String)request.getParameter("classes");  
   sint=Integer.parseInt(cls);
   sroman=mm.inRoman(sint);
   } 
    ArrayList ar1=new ArrayList();
    HashMap hm1=new HashMap();
    HashMap hm2=new HashMap();
    HashMap hm3=new HashMap();
    HashMap hm4=new HashMap();
    HashMap hm5=new HashMap();
    HashMap hm6=new HashMap();
    HashMap hm7=new HashMap();  
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
// String qr1="select distinct sessions from ex_course_detail where convert(substring(sessions,1,4),unsigned)>=(select distinct max(convert(substring(sessions,1,4),unsigned)) from studinfo) order by convert(substring(sessions,1,4),unsigned)";        
    try{
 //stmt2=con.prepareStatement(qr1);
 //rs2=stmt2.executeQuery();
// while(rs2.next()){
// ar2.add(rs2.getString("sessions"));    
// }    
 if(request.getParameter("session")!=null && request.getParameter("classes")!=null){
      String qry="select cid,subject,theory,practical,mcq,unittest,groups,optional from ex_course_detail where sessions='"+ssn+"' and class='"+cls+"' order by cid";
      stmt1=con.prepareStatement(qry);
      rs1=stmt1.executeQuery();   
      while(rs1.next()){
      ar1.add(rs1.getString("cid"));   
      hm1.put(rs1.getString("cid"),rs1.getString("subject"));
      hm2.put(rs1.getString("cid"),rs1.getString("theory"));
      hm3.put(rs1.getString("cid"),rs1.getString("practical"));
      hm4.put(rs1.getString("cid"),rs1.getString("mcq"));
      hm5.put(rs1.getString("cid"),rs1.getString("unittest"));
      hm6.put(rs1.getString("cid"),rs1.getString("groups"));
      hm7.put(rs1.getString("cid"),rs1.getString("optional"));      
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
        document.f1.action="<%=request.getContextPath()%>/Courses_Detail/DisplayCourses.jsp";
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
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center"><tr><td valign="top">
<table width="100%"><tr><td valign="top"><jsp:include page="/toplook.jsp"/></td></tr></table>
<table border="0" bgcolor="#EEEEEE" cellpadding=0 cellspacing=0 width="100%" height="350">
<tr><td valign="top" height="5%"><%@include file="/HomeLink.jsp"%></td></tr> 
<tr><td width="100%"><table align="left" width="100%"><tr><td width="100%" align="left" valign="top"><a href="javascript:Clickheretoprint('printit')"><font color="blue" size="2"><u><b>Click here to print</b></u></font></a></td></tr></table></td></tr>       
<tr><td valign="top">  
  <center><h4><font color="#000080">Display Courses</font></h4></center>
    <form name="f1" action="<%=request.getContextPath()%>/Courses_Detail/DisplayCourses.jsp" onsubmit="return validate();">  
    <table align="center" border="1" valign="top" class="t">  
      <tr><td>Session:</td><td><select name="session"> <!--onchange="callsubmit()"onchange="callsubmit()"onchange="getSession()"-->
      <%if(!ssn.equals("")){%>
      <option value="<%=ssn%>"><%=ssn%></option> 
       <%
      }
      else{
       %>
       <option value="">Select</option> 
       <%}for(int i=2000;i<=2020;i++){%>   
       <option value="<%=i%>-<%=i+1%>"><%=i%>-<%=i+1%></option>    
      <%}%>
     </select>
     </td>
     <td>Class<select name="classes">   
      <%if(!cls.equals("")){%>
      <option value="<%=cls%>"><%=cls%></option> 
       <%
      }
      else{
       %>
       <option value="">Select</option> 
       <%
         } 
       try{
       for(int i=1;i<=12;i++){
       if(!cls.equals("")){    
       if(i==Integer.parseInt(cls)){continue;}
       }
       %>   
       <option value="<%=i%>"><%=i%></option>    
      <%}}
      catch(NumberFormatException ne){}
      %>
      </select>    
 </td><td colspan="2" align="left"><input type="submit" value="Submit"></td></tr></table>    
     </form>  
   <hr color="blue">
   <div id="printit">
     <table width="100%" align="center"><tr><td><table><tr><td align="left"><b>Session:&nbsp;<%=ssn%></b></td><td>|</td><td align="left"><b>Class:&nbsp;<%=sroman%></b></td></tr></table></td></tr></table>
     <table width="100%" align="center" border="1" style="border-collapse:collapse">
     <tr><td width="5%"><b>SNo.</b></td><td width="30%"><b>Subject</b></td><td width="10%"><b>Theory</b></td><td width="12%"><b>Practical</b></td><td width="10%"><b>MCQ</b></td><td width="10%"><b>Unit Test</b></td><td width="11%"><b>Group</b></td><td width="12%"><b>Optional</b></td></tr>    
     <%
     int k=0;   
     for(int i=0;i<ar1.size();i++){
     %>      
    <tr><td><%=++k%></td><td><%=hm1.get(ar1.get(i))%></td><td><%=hm2.get(ar1.get(i))%></td><td><%=hm3.get(ar1.get(i))%></td><td><%=hm4.get(ar1.get(i))%></td><td><%=hm5.get(ar1.get(i))%></td><td><%=hm6.get(ar1.get(i))%></td><td><%=hm7.get(ar1.get(i))%></td></tr>
     <%}%>
    </table>   
    </div>  
  </td></tr></table>
<table width="100%"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr></table>
    </body>
</html>