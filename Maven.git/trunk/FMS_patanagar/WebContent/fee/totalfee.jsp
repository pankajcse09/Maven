<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,ActionClass.*,java.util.*,Beans.JavaBean"%>
<%@page import="com.myapp.struts.DataConnection"%>

<html>
    <head>
         <title>School Management System</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
  <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>
    </head>
    <body>

 <table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center">
<tr><td><jsp:include page="/ftoplook.jsp"/></td></tr>
<tr><td>
<table border="0"  bgcolor="#EEEEEE" cellpadding=0 cellspacing =0 width="100%"  height="330">
<tr><td width="100%"><jsp:include page="/feeHomeLink.jsp"/></td></tr>   
<tr><td valign="top">
<table align="center"><tr><td><center><font color="#34282C" size="4"><u>Display Fee Record</u></font></center></td></tr></table>
    <form  method="post" name="feerec">
<table cellpadding="0" cellspacing="0" width="100%" height=350><tr><td valign="top">  
<table cellpadding="0" cellspacing="0" align="center">
    
    <%
    Connection cn=null;
    Statement stmt=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    String Syear="";
    int amount=0;
    
    
          try
         {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
  
    try
    {
        String sql1="select year(current_date) as year";
         stmt=cn.createStatement();
         rs=stmt.executeQuery(sql1);
         rs.next();
           Syear=(String)rs.getString("year");   
          stmt=null;
          rs=null;
          
    String sm="select sum(amountpaid)as amount from feerecord where Syear='"+Syear+"' or Eyear='"+Syear+"' ";
            
            pstmt=cn.prepareStatement(sm);
            rs=pstmt.executeQuery();
            rs.next();
            
             amount=rs.getInt("amount");
           
  
    %>
    <tr><td>Total fee :</td><td><%=amount%></td></tr>
    <%
    }catch(SQLException e)
    {}
    %>
</table>
</td></tr></table>
  </td></tr></table>
    </body>
</html>
