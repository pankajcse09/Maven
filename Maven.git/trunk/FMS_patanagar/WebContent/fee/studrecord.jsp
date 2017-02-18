<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*,ActionClass.*,java.util.*,Beans.JavaBean"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="AO.*"%>
<%@page import="EO.SchoolEO"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/mymenu.css">
         <script language="javascript" src="<%=request.getContextPath()%>/fee/resolution.js"></script>
 <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/menu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/fee/menu.js"></script>      
      <title>School Management System</title>
    </head>
    <body>

   <form action="<%=request.getContextPath()%>/studdetail.do" method="post" name="feest">
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#FFB76F" align="center">
<tr><td><jsp:include page="/fee/ftoplook.jsp"/></td></tr>
<tr><td>
<table border="0"  bgcolor="#FFB76F" cellpadding=0 cellspacing =0 width="100%"  height="330">
<tr><td width="100%"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>   
<tr><td valign="top">
  <table align="center"><tr><td><center><font color="#34282C" size="4"><u>Student Record</u></font></center></td></tr></table>   
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
<table align="center" width="100%" cellpadding="0" cellspacing="0">          
 
    </td></tr>
    <tr><td valign="top">
<table align="center" width="40%" cellpadding="2" cellspacing="0"  border=1> 
<tr><td><img src="<%=request.getRealPath("/image")%>\\0.jpg" height="100" width="85"></td></tr>
<tr><td><b>Scholars Number:</b></td><td><%=seo.getSrnum()%>&nbsp;</td></tr>
<tr><td><b>Student Name:</b></td><td><%=seo.getSname()%>&nbsp;</td></tr>
<tr><td><b>Date Of Admission:</b></td><td><%=seo.getDateofadd()%>&nbsp;</td></tr>
<tr><td><b>Taken Admission in Class:</b></td><td><%=seo.getSeekadd()%>-<%=seo.getSection()%>&nbsp;</td></tr>
<tr><td><b>Currently Studying:</b></td><td><%=seo.getClasses()%>-<%=seo.getStatus()%>&nbsp;</td></tr>
<tr><td><b>Gender:</b></td><td><%=seo.getGender()%>&nbsp;</td></tr>
<tr><td><b>Date of Birth:</b></td><td><%=seo.getDob()%>&nbsp;</td></tr>
<tr><td><b>Father's Name:</b></td><td><%=seo.getFname()%>&nbsp;</td></tr>
<tr><td><b>Mother's Name:</b></td><td><%=seo.getMname()%>&nbsp;</td></tr>
<tr><td><b>Address:</b></td><td><%=seo.getAddress()%>&nbsp;</td></tr>
<tr><td><b>Residence Number:</b></td><td><%=seo.getRnum()%>&nbsp;<td></tr>
<tr><td><b>Mobile Number:</b></td><td><%=seo.getMobile()%>&nbsp;</td></tr>
</table>

       <%
   } }
   }catch(Exception e)
       {}%>   
      </td></tr></table>    
   </form> 
   </td></tr></table>
   
     <tr><td bgcolor=#455A8B height=20><%@include file="/btmnavi.jsp"%></td></tr>
     </table>    
    </body>
</html>
