<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page language="java"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="EO.SchoolEO"%>
<%@page import="AO.*"%>

   <!-- Developed by : Sonal Sharma
        Company      : IntelMind -->

<html>
    <head>
         <title>School Management System</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/mymenu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/fee/resolution.js"></script>
        <script language="javascript" src="<%=request.getContextPath()%>/fee/validation.js"></script>
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/menu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/fee/menu.js"></script>          
<script type="text/javascript" src="calendarDateInput.js"></script>  
       
    </head>
    <body>
    
 <table width="800" cellpadding="0" cellspacing="0" bgcolor="#34689A" align="center">
<tr><td><jsp:include page="/fee/ftoplook.jsp"/></td></tr>
<tr><td>
<table border="0"  bgcolor="#FFB76F" cellpadding=0 cellspacing =0 width="100%"  height="330">
<tr><td width="100%"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>   
<tr><td valign="top">
   <%    String month=request.getParameter("month");%>

 <table height=450 align="center" width="100%" border="0"><tr><td valign="top">
 <table align="center"><tr><td><center><font color="#34282C" size="4"><u>Update Transportation Fee</u></font></center></td></tr></table>
    <form name="form5" action="<%=request.getContextPath()%>/upbsf.do" method="post" onsubmit="return chkvalidate()">
        
<table cellpadding="0" cellspacing="0" border="0" width="30%" align="left">
</table>
 </td><tr>
 <tr><td valign="top">
<table cellpadding="0" cellspacing="2" border="2" width="60%" align="center">

<tr>
<td width="10%" align="center"><b>S.No.</b></td>   
<td width="70%" align="center"><b>Route</b></td>
<td width="20%" align="center"><b>Bus Fee</b></td>
</tr>
         
         <%!
            Connection cn=null;
            Statement stmt=null;
            ResultSet rs=null;
                     
               ArrayList arr1=new ArrayList(); 
               ArrayList arr2=new ArrayList(); 
             
          %>   
   
           <% 
           int k=0;
           try{
          DataConnection dc1=new DataConnection();
            cn=(Connection)dc1.Dataconnect();

            }
          catch(Exception e){}
            try{
               
             String id="select * from transportfee"; 
            
             stmt=cn.createStatement();
             rs=stmt.executeQuery(id);
                     
        while(rs.next())
        {   
             arr1.add(rs.getString("route"));
             arr2.add(rs.getString("busfee"));
         }
            
         %> 
<%
     int i=0;
for(i=0;i<arr1.size();i++){  
%>           
    <td align=center><%=++k%></td>
    <td align=center><input type=text size="25" name="route<%=i%>" value="<%=arr1.get(i)%>"></td>     
    <td align=center><input type=text size="15" name="busfee<%=i%>" value="<%=arr2.get(i)%>"></td>     

    </tr>
        
<%}%>

<%  
   arr1.clear();
   arr2.clear();
 
 }catch(SQLException e)
            {}
       %>   <tr><td align="center"> <input type="submit" value="Update"></td></tr>
     </table>
     </td></tr></table>   
    </form>
  </td></tr></table></td></tr>       
     <tr><td bgcolor=#34689A height=20><%@include file="/btmnavi.jsp"%></td></tr>
     </table>      
    </body>
</html>
    
    
    














