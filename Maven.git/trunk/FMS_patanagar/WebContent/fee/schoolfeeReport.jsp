<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*,ActionClass.*,java.util.*,Beans.JavaBean"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="org.apache.struts.action.DynaActionForm"%>
<%@page import="AO.*"%>
<%@page import="EO.SchoolEO"%>

<%! Connection cn=null;
Statement stmt2=null;
ResultSet rs2=null;%>

<html>
    <head>
     <title>School Management System</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/mymenu.css">
         <script language="javascript" src="<%=request.getContextPath()%>/fee/resolution.js"></script>
 <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/menu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/fee/menu.js"></script>
<script language="javascript">
       
 function chkvalidate()
{
if(document.formfine.ate.value==""){
          alert("Enter the Amount to be Exempted ");
          document.formfine.ate.focus();
          return false;
          }
        
}

  function calfee()
               {
               var ate=document.formfine.ate.value;
               var due=document.formfine.due.value;
           
               var remain=(parseInt(due)-parseInt(ate));
               document.formfine.remaindue.value=parseInt(remain); 
               }
   </script>
    
    </head>
    <body>
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center">
<tr><td><jsp:include page="/fee/ftoplook.jsp"/></td></tr>
<tr><td>
<table border="0"  bgcolor="#EEEEEE" cellpadding=0 cellspacing =0 width="100%"  height="330">
<tr><td width="100%"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>   
<tr><td valign="top"> 
<table align="center"><tr><td><center><font color="#34282C" size="4"><u>School Fee Report</u></font></center></td></tr></table>
   
<form  method="post" action="<%=request.getContextPath()%>/sfrep.do?disp=disp">
<table cellpadding="0" cellspacing="0" width="100%" height=400><tr><td valign="top">  
<table>

<tr><td>Enter Session:<input type="text" name="syear" size="15" value="">
-<input type="text" name="eyear" size="15" value=""></td></tr>
<tr><td>Class:<select name="classes">
     <option value="">-select-</option>
     <option value="All">All</option>

<% String classes="";  
 try
       {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
try
{
String sqw="select class from classes";
             stmt2=cn.createStatement();
             rs2=stmt2.executeQuery(sqw);
             while(rs2.next())
             {
             classes=(String)rs2.getString("class"); 
%>
<option value="<%=classes%>"><%=classes%></option>
<%}
}catch(SQLException e)
{}%>
</select></td></tr>

</td><td><input type="submit" value="Display"></td></tr> 
</table>
<hr>
</form>
<form name="formfine">
<table border="1" width="100%" align="center">
<tr><td>
<table><tr>
<td>No.</td>
 <td>SR.NO.</td>
 <td>NAME</td>
</tr></table></td>

<% int k=0;
try
{
   String qry2="Select distinct(month) from feedetailreport";        
          
          stmt2=cn.createStatement();
          rs2=stmt2.executeQuery(qry2);  
          while(rs2.next())
          {
          month=rs2.getString("month");
%>
<td><table border=1><tr><td align=center><b><%=seo.getMonth()%></b></td></tr>
<tr><td><b>AMOUNT</b></td><td><b>DATE</b></td></tr>
</table></td>

<%
   } }%>
<%
  }catch(Exception e)
  {}%>
</tr>
<tr><td>
<% 
try
{
ArrayList arrs=(ArrayList)request.getAttribute("arrs");

%>
<table><tr>
<%
 SchoolEO se=null;
%>
<% if(request.getAttribute("arrs")!=null)
 {%>           
<% for(int i=0;i<arrs.size();i++) 
{ se=(SchoolEO)arrs.get(i);
%>
<table><tr>
<td><%=++k%></td>
 <td><%=se.getSrnum()%></td>
 <td><%=se.getSname()%></td>
</tr></table>
 <%}}%>
</tr></table></td>
<td>

<%
   
ArrayList arr2=(ArrayList)request.getAttribute("arr");  
 SchoolEO seo1=null;
%>
<% if(request.getAttribute("arr")!=null)
 {%>           
<% for(int i=0;i<arr2.size();i++)
{ seo1=(SchoolEO)arr2.get(i);
%>
<table><tr> 
<td><%=seo1.getAmountpaid()%></td><td><%=seo1.getFeesubdate()%></td>
</tr></table>

<%
   } }%>
</td></tr></table>
<%
  }catch(Exception e)
  {}%>


</form>   
  </td></tr></table> 
    </td></tr></table> 
  
     <tr><td bgcolor=#455A8B height=20><%@include file="/btmnavi.jsp"%></td></tr>
     </table>      
    </body>
</html>
