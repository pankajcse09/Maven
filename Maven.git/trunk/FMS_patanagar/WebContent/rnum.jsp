<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page language="java"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="AO.*"%>


<%! Connection cn=null;
    Statement stmt=null;
    ResultSet rs=null;%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <script type="text/javascript" src="calendarDateInput.js"></script>
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/validation.js"></script>
        <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>        
 <title>JPS</title>
        <script language="JavaScript">
function chkvalidate()
{
if(document.set.invoice.value==""){
      alert("Please Set Invoice Number ");
          document.set.invoice.focus();
          return false;
          }
          else{
          var k=validint(0);
          if(k==false){return false;}
          }

}
     </script>
     
     <table width="800" class="res" cellpadding="0" cellspacing="0" align="center" bgcolor="#A89263">
 <tr><td><%@include file="/toplook.jsp"%></td></tr>
 <tr><td valign="top">  
<tr><td width="100%"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>  
 <tr><td valign="top">
 <table height="250" align="center" width="100%" border="0">
<tr><td width="100%"></td></tr> 
<tr><td valign="top">

     <table width="100%" align="center"><tr><td width="100%" align="center"><font color="darkblue" size="4"><b>Set Receipt No.</b></font></td></tr></table>

 <form name="set" action="setr.do" method="post" onsubmit="return chkvalidate();">
      <%
        int rnum=0;
     
        try
       {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
        try
        {
     String qry="Select * from setrnum";
        
             stmt=cn.createStatement();
             rs=stmt.executeQuery(qry);
             while(rs.next())
             {
                 rnum=rs.getInt("rnum");
                 
             }
             
        }catch(SQLException e)
        {}
%>
  <%  if((String)request.getAttribute("msg")!=null)
    out.println("<font color='red'><b>"+(String)request.getAttribute("msg")+"</b></font>"); %> 
<table width="50%" cellpadding="2" cellspacing="0" align="center" >
    <tr><td class="tdcolor" align="right">Receipt Number:</td><td><input type="text" name="rnum" value="<%=rnum%>"></td></tr>
</table>
</td></tr>
 <tr><td valign="top">
  <table align="center"> 
<tr><td valign="top"><table align="center" width="30%"> <tr>
<td  align="center"><input type=submit value="Update" name="update"></td>
<td align="center" valign="top"><input type=submit value="Set Receipt Number" name=enter></td></tr>
  
</form>
</table>
</td></tr></table> </td></tr> 
</td></tr></table>  
 
     <tr><td valign="top">
<table width="100%" bgcolor="#A89263"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr>
     </table>   
     </body>
</html>