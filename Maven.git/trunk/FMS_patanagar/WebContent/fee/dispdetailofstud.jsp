<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page language="java"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="AO.*"%>
<%@page import="EO.SchoolEO"%>

  
<html>
    <head>
     <title>School Management System</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>      

    </head>
    <body>
   
<table width="800" class="res" cellpadding="0" cellspacing="0" align="center" bgcolor="#A89263">
  <tr><td><%@include file="/fee/toplook.jsp"%></td></tr>

<tr><td width="100%"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>  
  <tr><td valign="top">  
 <table height="330" align="center" width="100%" border="0">
<tr><td width="100%"></td></tr> 
<tr><td valign="top">
<table width="100%" align="center"><tr><td width="100%" align="center"><font color="#34282C" size="4"><b>Detail Of Students</b></font></td></tr></table>
   <form  method="post" action="detailofstud.do">
<table cellpadding="0" cellspacing="0" width="100%" height=450><tr><td valign="top">  
<table>
    <%  if((String)request.getAttribute("sub")!=null)
    out.println("<font color='red'><b>"+(String)request.getAttribute("sub")+"</b></font>"); %>  
<tr><td><font color="blue" size="4">Please enter the following detail</font></td></tr>
 <%
    Connection cn=null;
    Statement stmt=null;
    ResultSet rs=null;
    String Syear1="";
    int Syr=0;
    int Eyr=0;    
try{
                        
             DataConnection dc1=new DataConnection();
             cn=(Connection)dc1.Dataconnect();
         
           String sql="select DATE_FORMAT(current_date,'%Y')as year";
             
             stmt=cn.createStatement();
             rs=stmt.executeQuery(sql);
         
        rs.next();
          Syear1=(String)rs.getString("year"); 
          Syr=Integer.parseInt(Syear1);  
             Eyr=Syr+1;
         
       
} catch(Exception e){}%> 
<tr><td class="tdcolor">Class:<select name="cls">
    <option value="">-Select-</option>      
              <%
String cls="";  
Statement stmt2=null;
ResultSet rs2=null;

try{
                   
             DataConnection dc1=new DataConnection();
             cn=(Connection)dc1.Dataconnect();
         String sq="select class from classes";
             stmt2=cn.createStatement();
             rs2=stmt2.executeQuery(sq);
             while(rs2.next())
             {
             cls=(String)rs2.getString("class"); 
%>
<option value="<%=cls%>"><%=cls%></option>
<%}}catch(SQLException e){}
stmt2=null;
rs2=null;
%>
</select></td>
     
<td class="tdcolor">Sec:<select name="section">
                        <option value="">-Select-</option>
                        <option value="A">A</option>
                        <option value="B">B</option>
                        <option value="C">C</option>
                        <option value="D">D</option>
                        <option value="E">E</option>
                        <option value="F">F</option>
                        <option value="G">G</option>
                        <option value="H">H</option>
                        <option value="I">I</option>
                        <option value="J">J</option>
                        <option value="K">K</option>
</td>                 
</tr>

</tr>
            <tr>  <td class="tdcolor">Session:<select name="Syear">
 
         <option value="<%=Syr%>"><%=Syr%></option>
           
       <%for(int i=2000;i<=2020;i++){%>   
       <option value="<%=i%>"><%=i%></option>    
      <%}%>
     </select> -
     <select name="Eyear">
 
        <option value="<%=Eyr%>"><%=Eyr%></option>
       <%for(int i=2000;i<=2020;i++){%>   
       <option value="<%=i%>"><%=i%></option>    
      <%}%>
     </select></td>
  </td><td><input type="submit" value="Display"></td></tr>    
<tr><td height=10></td></tr>

           
            
 



</table>
    </form>

  <form name="formfine" >

    
<% 
try
{
ArrayList arr1=(ArrayList)request.getAttribute("arr");
 SchoolEO seo=null;
  %>

  <% if(request.getAttribute("arr")!=null)
 {%>           
  <table border="1" width="80%" align="center"> 
 <tr>
<td><font size="2"><b>Scholars Number</b></font></td>
<td><font size="2"><b>Student Name</b></font></td>
<td><font size="2"><b>Class</b></font></td>
<td><font size="2"><b>Status</b></font></td>
<td><font size="2"><b>Session</b></font></td>
</tr>
   <% for(int i=0;i<arr1.size();i++)
   { seo=(SchoolEO)arr1.get(i);
%>

<tr>
<td><%=seo.getSrnum()%></td>
<td><%=seo.getSname()%></td>
<td><%=seo.getClasses()%>-<%=seo.getSection()%></td>
<td><%=seo.getAdmstatus()%></td>
<td><%=seo.getSyear()%>-<%=seo.getEyear()%></td>
<td><a href="studfee.do?srnum=<%=seo.getSrnum()%>&Syear=<%=seo.getSyear()%>&Eyear=<%=seo.getEyear()%>"><font color="maroon"><b>Fee record</b></font></a></td>
<td><a href="studrec.do?srnum=<%=seo.getSrnum()%>&classes=<%=seo.getClasses()%>&section=<%=seo.getSection()%>"><font color="maroon"><b>Student Detail</b></font></a></td>
</tr>
       
       <%
   } }%>
</table>

       <%
   }catch(Exception e)
       {}%>
  </td></tr></table> 
</form>  
 <tr><td valign="top">
<table width="100%" bgcolor="#34689A"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
  </td></tr></table>
    
    </body>
</html>
