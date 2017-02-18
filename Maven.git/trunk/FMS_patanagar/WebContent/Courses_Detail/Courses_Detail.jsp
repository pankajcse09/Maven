<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page language="java"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@ page import="java.sql.*"%>
<%@page import="com.myapp.struts.Dataconnectivity"%>
   <%!
   Connection con=null;
   PreparedStatement psmt=null;
   PreparedStatement psmt1=null;
   PreparedStatement psmt2=null;
   PreparedStatement psmt3=null;
   ResultSet rs=null;
   ResultSet rs1=null;
   ResultSet rs2=null;
   ResultSet rs3=null;
   %>
   <%response.setHeader("Cache-Control","no-cache");%>
  <%      
     ArrayList ar1=new ArrayList();
     ArrayList ar=new ArrayList();
     HashMap hm1=new HashMap();
     HashMap hm2=new HashMap();   
     HashMap hm3=new HashMap();
     String dg="";
     String sn="1";
     String ssn="";
      if(request.getParameter("session")!=null){
      ssn=(String)request.getParameter("session");   
      } 
     if(request.getParameter("class")!=null){
      dg=(String)request.getParameter("class");   
      }    
      if(request.getParameter("s")!=null){
      sn=(String)request.getParameter("s");   
      }      
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();  
    }
 catch(Exception e){
  out.println(e.getMessage());   
 }   
 try{
  String qr="select cid,subject,theory,practical,mcq from ex_course_detail where class='"+dg+"' and exist='y' and sessions='"+ssn+"'";
  psmt1=con.prepareStatement(qr);
  rs1=psmt1.executeQuery();
  while(rs1.next()){
   ar.add(rs1.getString("subject")); 
   hm1.put(rs1.getString("subject"),rs1.getString("theory"));
   hm2.put(rs1.getString("subject"),rs1.getString("practical"));    
   hm3.put(rs1.getString("subject"),rs1.getString("mcq")); 
  }     
 }   
 catch(SQLException se){
   out.println(se.getMessage());   
 }
   finally{
      try{
      if(rs1!=null){rs1.close();}
      if(rs2!=null){rs2.close();}
      if(rs3!=null){rs3.close();}
      if(psmt1!=null){psmt1.close();}   
      if(psmt2!=null){psmt2.close();}
      if(psmt3!=null){psmt3.close();}
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
 <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
         <script language="javascript">
       function validate(){
       for(i=0;i<document.f1.elements.length;i++){    
       if(document.f1.elements[i].value==""){
       alert("Select Value or Insert Text");
       document.f1.elements[i].focus();
       return false;
       }  
       }       
       return true;
       } 
       
     function check(){     
     var th=document.f1.theory.value;
     var pr=document.f1.practical.value;
     var mcq=document.f1.mcq.value;
     var utest=document.f1.unittest.value;
     
     for(i=0;i<th.length;i++){
     if(th.charCodeAt(i)<48 || th.charCodeAt(i)>57){
     alert("Insert Number");  
     document.f1.theory.value="";
     document.f1.theory.focus();
     }
     }
     }
         </script>
<title>Add New Course</title>        
</head>      
<body bgcolor="white">    
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center"><tr><td valign="top">
<table width="100%"><tr><td valign="top"><jsp:include page="/toplook.jsp"/></td></tr></table>
<table border="0" bgcolor="#EEEEEE" cellpadding="0" cellspacing="0" width="100%" height="330"> 
<tr><td width="100%"><%@include file="/HomeLink.jsp"%></td></tr>    
<tr><td valign="top">  
<table width="100%" align="center"><tr><td width="100%" align="right"><a href="<%=request.getContextPath()%>/MainPage.jsp"><font color="#000080" font-style="TimesRoman" size="2"><b>Home</b></font></a></td></tr></table>        
    <table width="100%" border="1" valign="top" class="t"><tr><td width="35%" valign="top">
    <center><font color="#000080" size="2"><b>Please Enter the following Course Details</b></font></center><br>
    <form name="f1" method="post" action="<%=request.getContextPath()%>/Master_Course?p=a" onsubmit="return validate();">        
    <table align="center"><tr><td height="20"></td></tr>
    <tr><td height="23"></td></tr>
    <%
    if(request.getAttribute("msg")!=null){ 
     %>  
 <tr><td colspan="2">     
<font color="red"><%=request.getAttribute("msg")%></font>
 </td></tr>
 <%}%> 
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
     </td></tr>
            <tr><td>Class</td><td>
            <%   
             try{
                String qry="select class from classes";   
                psmt=con.prepareStatement(qry);
                rs=psmt.executeQuery();
            %>
            <select name="class">
             <%if(dg!=null && !dg.equals("")){%>
            <option value="<%=dg%>"><%=dg%></option>
            <%}else{%>
            <option value="">Select</option>
            <%}   
                while(rs.next()){ 
                String dn=rs.getString("class");
                if(dn.equals(dg)){
                continue;    
                }    
            %>
           <option value="<%=dn%>"><%=dn%></option>
            <%}%>
            </select>            
            <%}
             catch(SQLException se){
             out.println(se.getMessage());   
             }
           finally{
               try{
                 if(rs!=null){rs.close();}
                 if(psmt!=null){psmt.close();}
                 if(con!=null){con.close();}
               }
               catch(SQLException se){
               out.println(se.getMessage());
               }
             }
            %>           
            </td></tr></table>    
  <table align="center"><tr><td><font color="red" font-style="TimesRoman" size="2"><b>
 <%
if(request.getAttribute("course_success")!=null){ 
out.println(request.getAttribute("course_success"));
request.removeAttribute("course_success");
}%>             
    </b></font></td></tr></table>  
            <table align="center">
            <tr><td>Subject:</td><td><input type="text" name="subject" size="10"></td></tr>    
            <tr><td>Theory:</td><td><input type="text" name="theory" value="100" size="10" onkeyup="check()"></td></tr>
            <tr><td>Practical:</td><td><input type="text" name="practical" value="0" size="10"></td></tr>
            <tr><td>MCQ:</td><td><input type="text" name="mcq" value="0" size="10"></td></tr>  
            <tr><td>Unit Test:</td><td><input type="text" name="unittest" value="25" size="10"></td></tr>     
            <tr><td colspan="2" align="center"><input type="submit" value="submit"><input type="reset" value="reset">
             </td></tr></table>        
    </form></td>
    <td width="65%" valign="top">
    <table width="100%"><tr><td width="100%" valign="top" colspan="10"><b>Select Class</b></td></tr><tr>
    <%
      for(int j=1;j<=10;j++){
    %>      
    <td width="10%" valign="top"><a href="#" onclick="call('<%=j%>')"><font color="blue"><u><%=j%></u></font></a></td>
    <%}%>
    </tr></table>
    <table width="100%" valign="top" border="1" class="t">
    <tr><td width="100%" colspan="4" align="center"><b>Course Added for <%=dg%></b></td></tr>
    <tr><td valign="top" width="30%" align="center">Subject</td><td valign="top" width="25%" align="center">Theory</td><td valign="top" width="25%" align="center">Practical</td><td valign="top" width="20%" align="center">MCQ</td></tr>
    <%
    String cd="";
    for(int i=0;i<ar.size();i++){ 
    cd=(String)ar.get(i);     
    %>
    <tr><td align="center"><%=cd%></td><td align="center"><%=hm1.get(cd)%></td><td align="center"><%=hm2.get(cd)%></td><td align="center"><%=hm3.get(cd)%></td></tr>
    <%      
    }
    %>
    </table>         
    </td></tr></table>
    
     </td></tr></table>
<table width="100%"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr></table>
    </body>
</html>
