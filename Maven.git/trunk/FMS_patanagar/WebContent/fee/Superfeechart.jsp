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

   <%! 
    Connection cn=null;
    Statement stmt=null;
    ResultSet rs=null;
    Statement stmt1=null;
    ResultSet rs1=null;
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
     
   <% //String cv=request.getParameter("cv");
	//String sessionid = session.getId();
	String  uid=(String)session.getAttribute("username"); //out.println(uid);
        String  ut=(String)session.getAttribute("usertype");
	
	if(uid == null)
	{
		response.sendRedirect("logout.jsp");
		return;
	}

    // session.putValue("uid",uid);
%>
<table class="res" cellpadding="0" cellspacing="0" align="center" bgcolor="DCDCDC">

<tr><td><% if(ut.equals("Admin")){%>
<%@include file="topmain.jsp"%>

<%} else if(ut.equals("Super")){%>
<%@include file="Supertopmain.jsp"%>
<%}%>
</td></tr>
  <tr><td>
<table width=100% cellpadding="0" cellspacing="0"><tr><td valign=top>
<% if(ut.equals("Admin")){%>
<%@include file="schooldropmenu.jsp"%>

<%} else if(ut.equals("Super")){%>
<%@include file="Superschooldrop.jsp"%>
<%}%>
</td></tr></table>
   </td></tr>

 <tr><td valign="top">     
<table width="60%" align="center"><tr><td align="center"><h3><font color="#34282C" >Fee Chart</font></h3></td></tr></table>  

<form action="feech.do?sub=sub" method="post" name="feest" onsubmit="return chkvalidate()">


  <table width="100%" cellpadding="0" cellspacing="0" align="center" border="1"> 
  <tr><td valign="top">
 


   <%
     ArrayList arr=new ArrayList(); 
    int k=0;
    int du=0;
            try{        
            DataConnection dc1=new DataConnection();
            cn=(Connection)dc1.Dataconnect();
      }
      catch(Exception e){}
 
ArrayList arr1=(ArrayList)request.getAttribute("arrays"); 

%>

  <% if(arr1.size()!=0)
 {%>      
 
<table cellpadding="4" cellspacing="3" border=1 width="100%" align="center">
<tr><td width="9%" align="center"><b>Class</b></td>
<td width="6%" align="center"><b>Regis</b></td>
<td width="6%" align="center"><b>Admission</b></td>
<td width="6%" align="center"><b>Tution</b></td>
<td width="5%" align="center"><b>Activity</b></td>
<td width="6%" align="center"><b>Building</b></td>
<td width="6%" align="center"><b>Exam</b></td>
<td width="6%" align="center"><b>Lib.</b></td>
<td width="5%" align="center"><b>Others</b></td>
<td width="12%" align="center"><b>Status</b></td></tr>

<% 
for(int j=0;j<arr1.size();j++)
   { 
    SchoolEO seo=new SchoolEO();
     seo=(SchoolEO)arr1.get(j);
%>
<input type="hidden" size="9" name="classes<%=j%>" value="<%=seo.getClasses()%>">
<input type="hidden" size="5" name="reg<%=j%>" value="<%=seo.getRegistrationfee()%>" >
<input type="hidden" size="5" name="admis<%=j%>" value="<%=seo.getAdmission()%>">
<input type="hidden" size="5" name="tution<%=j%>" value="<%=seo.getTution()%>" >
<input type="hidden" size="5" name="activity<%=j%>" value="<%=seo.getActivity()%>" >
<input type="hidden" size="5" name="building<%=j%>" value="<%=seo.getBuilding()%>" >
<input type="hidden" size="5" name="exam<%=j%>" value="<%=seo.getExam()%>" >
<input type="hidden" size="5" name="lib<%=j%>" value="<%=seo.getLib()%>" >
<input type="hidden" size="5" name="other<%=j%>" value="<%=seo.getOther()%>" >
<input type="hidden" size="14" name="status<%=j%>" value="<%=seo.getStatus()%>" >
          <tr><td align="center" bgcolor="#DCDCDC"><%=seo.getClasses()%></td>
          <td align="center" bgcolor="#F5F5F5"><%=seo.getRegistrationfee()%></td>
          <td align="center" bgcolor="#DCDCDC"><%=seo.getAdmission()%></td>
          <td align="center" bgcolor="#F5F5F5"><%=seo.getTution()%></td>
          <td align="center" bgcolor="#DCDCDC"><%=seo.getActivity()%></td>
          <td align="center" bgcolor="#F5F5F5"><%=seo.getBuilding()%></td>
          <td align="center" bgcolor="#DCDCDC"><%=seo.getExam()%></td>
          <td align="center" bgcolor="#F5F5F5"><%=seo.getLib()%></td>
          <td align="center" bgcolor="#DCDCDC"><%=seo.getOther()%></td>
       <td align="center" bgcolor="#F5F5F5"><%=seo.getStatus()%></td>
          
<input type="hidden" name="rowid<%=j%>" value="<%=seo.getRowid()%>">

          </tr> 
 
    <%  }
  }

    %>
   
   </td></tr></table>
      </td></tr></table>
  </form>
</table>
    </body>
</html>