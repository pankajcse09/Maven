<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
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
         <script type="text/javascript" src="calendarDateInput.js"></script>  
          <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
          <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
          <script language="javascript" src="<%=request.getContextPath()%>/validation.js"></script>
        <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>          
   </head>
    <body>
    
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#A89263" align="center">
<tr><td><jsp:include page="/fee/toplook.jsp"/></td></tr>
<tr><td>
<table border="0"  bgcolor="#A89263" cellpadding=0 cellspacing =0 width="100%"  height="330">
<tr><td width="100%"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>   
<tr><td valign="top">
<table align="center"><tr><td><center><font color="darkblue" size="4"><u>Display Fee Record</u></font></center></td></tr></table>
    <form  method="post" action="dispfeerec.do">
  
<table width="100%" cellpadding="0" cellspacing="0" height=200><tr><td valign="top"><table>
    <%  if((String)request.getAttribute("sub")!=null)
    out.println("<font color='red'><b>"+(String)request.getAttribute("sub")+"</b></font>"); %>  
<tr><td><font color="yellow" size="2">Please enter the Scholars Number</font></td></tr>

<tr><td class="tdcolor">Sr. Number:<input type="text" size="20" name="srnum" value=""></td></tr>
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
<td><input type="submit" value="Display"></td>
</tr>
 
</table></td></tr>
    </form>

  <form name="formfee" >

<tr><td valign="top">       
       <%  
       if(request.getAttribute("arr")!=null)
       {
      Double amount=(Double)request.getAttribute("amount");
      Double fine=(Double)request.getAttribute("fine");   
   //   HashSet hs=(HashSet)request.getAttribute("hs"); out.println(hs);
   //   Iterator ir=(Iterator)hs.iterator(); 
        %>
     
<% 
try
{
ArrayList arr1=(ArrayList)request.getAttribute("arr");   
 
SchoolEO seo=null;
  %>

  <% if(request.getAttribute("arr")!=null)
 {%>           
   
   <% for(int i=0;i<arr1.size();i++)
   { seo=(SchoolEO)arr1.get(i);
     
%>

  <table width="90%" cellpadding="0" cellspacing="0" border="1" align="center">
       <tr><td valign="top">     
            <table width="100%" cellpadding="1" cellspacing="0"  align="center">
 
<tr><td><b>Session:</b></td><td><%=seo.getSyear()%>-<%=seo.getEyear()%></td></tr>
<tr><td><b>Registration Number:</b></td><td><%=seo.getSrnum()%></td></tr>
<tr><td><b>Student Name:</b></td><td><%=seo.getSname()%></td></tr><input type="hidden" name="sname" value="<%=seo.getSname()%>">
<tr><td><b>Class:</b></td><td><%=seo.getClasses()%>-<%=seo.getSection()%></td></tr><input type="hidden" name="classes" value="<%=seo.getClasses()%>">
<tr><td><b>Months:</b></td><td>
<% try{
ArrayList mon=(ArrayList)request.getAttribute("mon");   
 
SchoolEO seo1=null;
  %>

  <% if(request.getAttribute("mon")!=null)
 {%>           
   
   <% for(int j=0;j<mon.size();j++)
   { seo1=(SchoolEO)mon.get(j);
   %>
<b><%=seo1.getMonth()%></b>(<%=seo1.getFeesubdate()%>),
<%}} }catch(Exception e){e.printStackTrace();}%>
</td></tr>
<tr><td><b>Total Amount Paid:</b></td><td><%=amount%></td></tr><input type="hidden" value="<%=amount%>">
<tr><td><b>Total Fine Paid:</b></td><td><%=fine%></td></tr><input type="hidden" value="<%=fine%>">
  
  </table>
       </td></tr></table>
       <%
   } }
   }catch(Exception e)
       {}
       }%>
 
</form>   
  </td></tr></table>
    <tr><td valign="top">
<table width="100%" bgcolor="#A89263"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
    </body>
</html>
