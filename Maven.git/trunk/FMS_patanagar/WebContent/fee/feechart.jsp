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
<%@page import="AO.*,ActionClass.FeeMethod"%>

   <%!  
    PreparedStatement psmt2=null;   
    PreparedStatement psmt3=null; 
    Statement stmt=null;
    ResultSet rs=null;
    Statement stmt1=null;
    ResultSet rs1=null;
    ResultSet rs2=null;
    ResultSet rs3=null;
   %>
   <% 
      Connection con=null;
      try{        
          DataConnection dc1=new DataConnection();
          con=(Connection)dc1.Dataconnect();
         }
      catch(Exception e){}
      FeeMethod fm=new FeeMethod();
         ArrayList ar1=new ArrayList();
         ArrayList ar2=new ArrayList();
         
         String mth="";
         if(request.getParameter("month")!=null){
         mth=(String)request.getParameter("month");    
         }
       
             String qr1="select distinct class from classes ";
             psmt2=con.prepareStatement(qr1);
             rs2=psmt2.executeQuery();
             while(rs2.next()){
             ar1.add(rs2.getString("class"));   
             }
             String qr2="select distinct heads from feeheads order by heads";   
             psmt3=con.prepareStatement(qr2);
             rs3=psmt3.executeQuery();
             while(rs3.next()){
             ar2.add(rs3.getString("heads"));     
             }  
           String month="";  
           if(request.getAttribute("mnt")!=null){  
           month=(String)request.getAttribute("mnt"); 
           }
%>

<html>
    <head>
     <title>School Management System</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/mymenu.css">
<script language="javascript" src="<%=request.getContextPath()%>/fee/resolution.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/fee/calendarDateInput.js"></script>  
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/menu.css">
<script language="javascript" src="<%=request.getContextPath()%>/fee/menu.js"></script>    
    <script language="javascript">
        
 function submon()
{
document.feest.method="POST";
document.feest.action="<%=request.getContextPath()%>/fee/feechart.jsp";
document.feest.submit();
}
        
     
  function chkvalidate()
{

if(document.feest.status.value=="")
{
alert("Please enter status");
document.feest.status.focus();
return (false);
} 
}
    </script>
    <title>JSP Page</title>
    </head>
    <body>
     
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#34689A" align="center">
<tr><td><jsp:include page="/fee/ftoplook.jsp"/></td></tr>
<tr><td>
<table border="0"  bgcolor="#FFB76F" cellpadding=0 cellspacing =0 width="100%"  height="330">
<tr><td width="100%"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>   
<tr><td valign="top">
<table width="60%" align="center"><tr><td align="center"><h3><font color="#34282C" >Fee Chart</font></h3></td></tr></table>  
<form name="feest"  method="post" onsubmit="return chkvalidate()">
  <table width="40%" cellpadding="0" cellspacing="0" align="center" border="0"> 
  <%if(request.getAttribute("msg1")!=null){%>  
  <tr><td></td><td valign="top"><font color="red"><b><%=request.getAttribute("msg1")%></b></font></td></tr>
  <%}%>
  <tr><td valign="top">
 <b>Enter Month:</b></td><td><select name="month" onchange="submon()">
     <%if(mth.equals("")){%>
      <option value="">Select</option>
      <%}else{%>
      <option value="<%=mth%>"><%=mth%></option>
      <option value=""></option>
      <%}if(!mth.equals("January")){%>
      <option value="January">January</option>
      <%}if(!mth.equals("February")){%>
      <option value="February">February</option>
      <%}if(!mth.equals("March")){%>
      <option value="March">March</option>
      <%}if(!mth.equals("April")){%>
      <option value="April">April</option>
      <%}if(!mth.equals("May")){%>
      <option value="May">May</option>
      <%}if(!mth.equals("June")){%>
      <option value="June">June</option>
      <%}if(!mth.equals("July")){%>
      <option value="July">July</option>
      <%}if(!mth.equals("August")){%>
      <option value="August">August</option>
      <%}if(!mth.equals("September")){%>
      <option value="September">September</option>
      <%}if(!mth.equals("October")){%>
      <option value="October">October</option>
      <%}if(!mth.equals("November")){%>
      <option value="November">November</option>
      <%}if(!mth.equals("December")){%>
      <option value="December">December</option>  
      <%}%>
  </select></td>
</tr> 
  </table>
</form>
<form>
     <table width="100%" cellpadding="0" cellspacing="0" align="center" border="0"> 
  <tr><td valign="top">
  <table><tr><td><a href="<%=request.getContextPath()%>/fee/delfeechart.jsp?month=<%=mth%>"><u><font color="blue"><b>Delete Monthly Chart</b></font></u></a></td>
<td>&nbsp;|&nbsp;</td>
<td align="center"><a href="<%=request.getContextPath()%>/fee/updatefeechart.jsp?month=<%=mth%>"><u><font color="blue"><b>Enter/Update Fee</b></font></u></a></td></tr></table></td></tr></table></td></tr>     
</td></tr><tr><td valign="top">
  <table width="100%" cellpadding="4" cellspacing="3" align="center" border="0"> 
<%  if((String)request.getAttribute("msg")!=null)
    out.println("<font color='red'><b>"+(String)request.getAttribute("msg")+"</b></font>"); %>
   <%
    
    int k=0;
try
{               
 ArrayList arr1=(ArrayList)request.getAttribute("array"); 

  %>
  <tr><td valign="top">
  <table width="100%" cellpadding="0" cellspacing="0" align="center"> 

<tr><td width="80%"><table cellpadding="0" cellspacing="0" border="0" width="100%"><tr></tr></table></td></tr>
<tr><td>
<table border="2" bordercolor="#34689A" style="border-collapse:collapse">
<tr><td width="9%" align="center"><b>Classes</b></td>
<%for(int i=0;i<ar2.size();i++){%>
<td width="9%" align="center"><b><%=ar2.get(i)%></b></td>
<%}%>
</tr>
<%for(int j=0;j<ar1.size();j++){%>
<tr><td width="9%" align="center"><input type="hidden" size="9" name="classes<%=j%>" value="<%=ar1.get(j)%>">
<b><%=ar1.get(j)%></b></td>
<%for(int i=0;i<ar2.size();i++){%>
<td width="9%" align="center"><input type="hidden" size="9" name="classes<%=j%>_<%=ar2.get(i)%>" value="<%=fm.retriveFees(mth,ar1.get(j),ar2.get(i))%>">
<b><%=fm.retriveFees(mth,ar1.get(j),ar2.get(i))%></b></td>
<%}%>
</tr>
<%}%>
</table>
<%}catch(Exception e){}%>
   </td></tr></table>
   </td></tr></table>
  </form>
  </td></tr></table>

 <tr><td bgcolor="#34689A" height=20><%@include file="/btmnavi.jsp"%></td></tr>
  </table> 
    </body>
</html>
