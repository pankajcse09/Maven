<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@page import ="Main_category.item_bean"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.*"%>
<%@page import="java.sql.Timestamp"%>
<%@page import ="ActionClass.JavaBean1"%>

<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
      
         <script language="javascript" src="<%=request.getContextPath()%>/view_content/calendarDateInput.js"></script>
     <title>Home</title>
<base target="_parent">
<meta name="Microsoft Border" content="tlb, default">
</head>
<body bgcolor="">      
  <%
  ArrayList customerlist=new ArrayList();
   JavaBean1 jb=new  JavaBean1();
   java.util.Date Dates=null;
      SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy"); 
 
      double total=0.0;
        double price=0.0;
           item_bean itembe=new item_bean();
          
            String image="";
   int itemid=0;
   String filename="";
  %>
  <!--1--><TABLE borderColor=#000000 cellSpacing=0 cellPadding=0 width=200 align=center border="1">
        <TBODY>
        <TR><TD vAlign=top align=left height=230>
<!--2--><TABLE height=733 cellSpacing=0 cellPadding=0 width=876 align=center border="0" bordercolor="blue">
        <TBODY>
        
        <TR>
 <!--text start from here-->   
<%String username= (String)session.getAttribute("loginid");%>
<td  align="left" valign="top">       
<table width="100%" border="0" cellpadding="0" cellspacing="5">
<tr><td align="right"><font color="maroon" size="4">Welcome&nbsp;</font><font color="darkblue" size="4">'<%=username%>'</font></td></tr>
<tr><td colspan="0" width="50%">
<table width="100%" border="0" cellpadding="0" cellspacing="5" align="center">
      <tr></td>
  <table align="center">
      <form name="" action="get_item_range.do?method=CustomerList" method="post">
      
          
<tr><td>Form Date:  &nbsp;&nbsp; <script>DateInput('frodate', true, 'dd/mm/yyyy')</script></td>

      <td> To Date:<script>DateInput('todate', true, 'dd/mm/yyyy')</script></td>
      </tr>
      <tr><td><input type="submit" value="submit"></td></tr>
      </form>
  </table>
  </td></tr>
  
  
  
  </table>
  
  <%
      if((ArrayList)request.getAttribute("customer")!=null)
  {
   customerlist=(ArrayList)request.getAttribute("customer");
   String fdate=(String)request.getAttribute("fdate");
   String tdate=(String)request.getAttribute("tdate");
  
   //out.println("fdate"+fdate);
   //out.println("tdate"+tdate);
    if(!customerlist.isEmpty())
    {
%>
   
     <table width="100%" border="1" bgcolor="white" cellspacing="0" cellpadding="0">        
 <tr><td>S.no.</td><td>LoginID</td><td>Customer Name</td><td>View Order</td></tr>
     <%
    for(int t=0;t<customerlist.size();t++)
    {
  jb=(JavaBean1)customerlist.get(t);
  
    
     %>

     <tr>
<td><%=t+1%></td>
<td><%=jb.getLoginid()%></td>
<td><%=jb.getName()%></td>
<td><a href="<%=request.getContextPath()%>/get_item_date.do?userid=<%=jb.getLoginid()%>&fd=<%=fdate%>&td=<%=tdate%>&method=get_item_daterange">view order</a></td>
    
          
        
           
      </tr>
      
  
   
   <%
     }%>    
     
 </table> 
        
 <% }%>

<%}%>

  <!--text end from here-->  
 </tr>
       </TBODY></TABLE></TD></TR></TBODY></TABLE>