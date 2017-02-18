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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <title>School Management System</title>
          <script type="text/javascript" src="calendarDateInput.js"></script>  
          <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/mymenu.css">
          <script language="javascript" src="<%=request.getContextPath()%>/fee/resolution.js"></script>
          <script language="javascript" src="<%=request.getContextPath()%>/fee/validation.js"></script>
        <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/menu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/fee/menu.js"></script>          
 <script language="javascript">
         
      function validate()
          {
if(document.mulchk.checknumber.value==""){
          alert("Please Enter Check Number ");
          document.mulchk.checknumber.focus();
          return false;
          }
          }
          function chkvalidate()
          {
          if(document.chkb.penalty.value==""){
          alert("Please Enter Penalty Amount ");
          document.chkb.penalty.focus();
          return false;
          }
          else{
          var k=validint(23);
          if(k==false){return false;}
          }
          }
</script>
    </head>
    <body>
  
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#34689A" align="center">
<tr><td><jsp:include page="/fee/ftoplook.jsp"/></td></tr>
<tr><td>
<table border="0"  bgcolor="#FFB76F" cellpadding=0 cellspacing =0 width="100%"  height="330">
<tr><td width="100%"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>   
<tr><td valign="top">

  <table align="center"><tr><td><center><font color="#34282C" size="4"><u>Delete  School Fee Record</u></font></center></td></tr></table> 
<form  method="post" action="deldisp.do?disp=disp" name="mulchk" onsubmit="return validate()">
<table width="100%">
<%  if((String)request.getAttribute("sub")!=null)
    out.println("<font color='red'><b>"+(String)request.getAttribute("sub")+"</b></font>"); 

if((String)request.getAttribute("msg")!=null)
    out.println("<font color='red'><b>"+(String)request.getAttribute("msg")+"</b></font>"); %>  
<tr><td><font color="red" size="2">This utility will delete the fee record which is submitted currently</font></td></tr>
<tr>
 
<td>Scholars Number:<input type="text" size="20" name="srnum" value="">
<table>
    <tr><td height="5"></td></tr>

  <tr><td height="5"></td></tr>
<tr><td>
<input type="submit" value="Display">
</td></tr>
  
</table>

</tr>  
</table>
</form>   
   
   
   <form action="delufee.do?delf=delf" method="post" name="chkb" onsubmit="return chkvalidate()">

    <% 
    String srnum= (String)request.getParameter("srnum");  %>
      <input type="hidden" name="srn" value="<%=srnum%>">
  
     <%
      
    Connection cn=null;
    Statement stmt=null;
    ResultSet rs=null;
    String cdate="";
    
try{
                        
             DataConnection dc1=new DataConnection();
             cn=(Connection)dc1.Dataconnect();
         
           String sql="select DATE_FORMAT(current_date,'%d/%m/%Y')as date";
             
             stmt=cn.createStatement();
             rs=stmt.executeQuery(sql);
    
                 
        while(rs.next())
        {
            cdate=(String)rs.getString("date"); 
        }  
} catch(Exception e){}%>        
  <input type="hidden" name="cdate" value="<%=cdate%>">
<table border="1" align="center" bordercolor="#34689A"> 
  <tr>
<td align="center"><font size="2"><b>Sr.No</b></font></td>
<td align="center"><font size="2"><b>Name</b></font></td>
<td align="center"><font size="2"><b>Class</b></font></td>
<td align="center"><font size="2"><b>Sec</b></font></td>
<td align="center"><font size="2"><b>Status</b></font></td>
<td align="center"><font size="2"><b>Fee</b></font></td>
<td align="center"><font size="2"><b>fine</b></font></td>
<td align="center"><font size="2"><b>Total Amount Paid</b></font></td>
<td align="center"><font size="2"><b>Fee Paid on</b></font></td>
<td align="center"><font size="2"><b>ToDate</b></font></td>
<td align="center"><font size="2"><b>FromDate</b></font></td>
<td align="center"><font size="2"><b>DD No.</b></font></td>
<td align="center"><font size="2"><b>Dated</b></font></td>
<td align="center"><font size="2"><b>Bank</b></font></td>
<td align="center"><font size="2"><b>Extra</b></font></td>
<td align="center"><font size="2"><b>Due</b></font></td>
<td align="center"><font size="2"><b><b>Draft Amount</b></font></td>
</tr>
  
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

<input type="hidden" name="srnum" value="<%=seo.getSrnum()%>">
<input type="hidden" name="srno" value="<%=seo.getSrnum()%>">
<input type="hidden" name="Syear" value="<%=seo.getSyear()%>">
<input type="hidden" name="Eyear" value="<%=seo.getEyear()%>">
 
<tr>
<td><%=seo.getSrnum()%></td>
<td><%=seo.getSname()%></td><input type="hidden" name="sname" size="12" value="<%=seo.getSname()%>">
<td><%=seo.getClasses()%></td><input type="hidden" name="classes" size="5" value="<%=seo.getClasses()%>">
<td><%=seo.getSection()%></td><input type="hidden" name="section" size="3" value="<%=seo.getSection()%>">
<td><%=seo.getStatus()%></td><input type="hidden" name="status" size="12" value="<%=seo.getStatus()%>">
<td><%=seo.getFee()%></td><input type="hidden" name="fee" size="5" value="<%=seo.getFee()%>" >
<td><%=seo.getCurfine()%></td><input type="hidden" name="fine" size="5" value="<%=seo.getCurfine()%>" >
<td><%=seo.getPaying()%></td><input type="hidden" name="tfee" size="5" value="<%=seo.getPaying()%>" >
<td><%=seo.getFeesubdate()%></td><input type="hidden" name="fsubdate" size="10" value="<%=seo.getFeesubdate()%>" >
<td><%=seo.getTodate()%></td><input type="hidden" name="todate" size="10" value="<%=seo.getTodate()%>">
<td><%=seo.getFromdate()%></td><input type="hidden" name="fromdate" size="8" value="<%=seo.getFromdate()%>">
<td><%=seo.getDname()%></td><input type="hidden" name="dnum" size="8" value="<%=seo.getDname()%>">
<td><%=seo.getDdate()%></td><input type="hidden" name="ddate" size="10" value="<%=seo.getDdate()%>">
<td><%=seo.getBankname()%></td><input type="hidden" name="bankname" size="8" value="<%=seo.getBankname()%>">
<td><%=seo.getEamount()%></td><input type="hidden" name="eamount" size="5" value="<%=seo.getEamount()%>" >
<td><%=seo.getPamount()%></td><input type="hidden" name="pamount" size="5" value="<%=seo.getPamount()%>">
<td><%=seo.getChkamount()%></td><input type="hidden" name="damount" size="5"  value="<%=seo.getChkamount()%>">

</tr>

<input type="hidden" name="rid" value="<%=seo.getRowid()%>">

       
       <%
       } }%>
       </table>
       <%
   }catch(Exception e)
       {
   e.printStackTrace();}%>
    <table> 

<tr><td></td><td><input type="submit" value="Delete Record"></td></tr>
</table>   

   </form> 
</td></tr></table>
<tr><td valign="top">
<table width="100%" bgcolor="#34689A"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr></table>
    </body>
</html>
