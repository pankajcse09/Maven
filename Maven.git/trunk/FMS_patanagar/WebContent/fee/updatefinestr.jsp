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
<script language="JavaScript">

function chkvalidate()
{
if(document.form5.lastdate.value==""){
          alert("Please Enter the Last date of submitting the fee ");
          document.form5.lastdate.focus();
          return false;
          }
          else{
          var k=validint(1);
          if(k==false){return false;}
          }
 if(document.form5.fine.value==""){
          alert("Please Enter Fine ");
          document.form5.fine.focus();
          return false;
          }
          else{
          var k=validint(1);
          if(k==false){return false;}
          }

}
</script>
    </head>
    <body>
   
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#34689A " align="center">
<tr><td><jsp:include page="/fee/ftoplook.jsp"/></td></tr>
<tr><td>
<table border="0"  bgcolor="#FFB76F" cellpadding=0 cellspacing =0 width="100%"  height="330">
<tr><td width="100%"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>   
<tr><td valign="top">
     <table height=450 align="center" width="100%" border="0"><tr><td valign="top">
     <table align="center"><tr><td><center><font color="#34282C" size="4"><u>Update Fine Structure</u></font></center></td></tr></table>
    
    <form name="form5" action="<%=request.getContextPath()%>/upfine.do" method="post" onsubmit="return chkvalidate()">
         
         <%!
            Connection cn=null;
            Statement stmt1=null;
            Statement stmt=null;
            ResultSet rs=null;
            ResultSet rs1=null;
            String classes="";
            String lastdate="";
            int fine=0;
          
         %>   
   
           <% 
             
           try{
          DataConnection dc1=new DataConnection();
            cn=(Connection)dc1.Dataconnect();

            }
               catch(Exception e){
             
            }
            try{
               
             String id="select lastdate,fine from finestructure "; 
            stmt=cn.createStatement();
             rs=stmt.executeQuery(id);
                     
        rs.next();
             lastdate=(String)rs.getString("lastdate");   
             fine=rs.getInt("fine"); 
            
            }catch(SQLException e)
            {}
       
         %>
         
        <table width="50%" align="center">

        
        <tr>
        <td><b>Last Date:</b></td><td><input type=text name="lastdate" value="<%=lastdate%>"></td>       
        </tr>
        
        <tr>
        <td><b>Fine:</b></td><td><input type=text name="fine" value="<%=fine%>"></td>
        </tr>
        <tr>
        
           <tr><td align="center">
<input type="submit" value="Update"></td></tr>
      
     </table>
 </td></tr></table>     
    </form>
</td></tr></table>   

     <tr><td bgcolor="#34689A"  height=20><%@include file="/btmnavi.jsp"%></td></tr>
     </table>     
    </body>
</html>
    
    
    














