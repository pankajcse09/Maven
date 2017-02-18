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
<%@page import ="Main_category.item_bean"%>

   <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Danceables</title>
       
      <script language="javascript" src="<%=request.getContextPath()%>/css_js/resolution.js"></script>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/change.css" />
        <script language="javascript" src="<%=request.getContextPath()%>/css/menu.js"></script>
    <script language="javascript" src="<%=request.getContextPath()%>/view_content/calendarDateInput.js"></script>
   
    </head>
      

    <body style="margin-left:80;margin-right:80;margin-top:5">
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
  <%String usernam= (String)session.getAttribute("loginid");%>
   <div id="conta">
	
         
       <table width="100%" border="0" style="border-collapse:collapse" cellspacing="0" cellpadding="0">
    
 <TR><TD valign="top"><%@ include file="/Registration/top_design_1.jsp" %></TD></TR>     
	  
 <tr><td height="450" valign="top" width="100%">
  <table bgcolor="#ffffff" width="100%" valign="top" border="1" style="border-collapse: collapse">
                   
 <tr>
<td valign="top" width="25%" align="left">
    
 <%@ include file="/jsp/admin_left_menu.jsp" %> 
</td>

<td valign="top" width="75%"><table align="center" width="100%">
                    <tr><td align="center"><table align="center">
                        <tr><td>
 <table align="center" height="30" valign="top">
<tr><td valign="top"><font color="darkblue" size="3" style="text-decoration: underline"><b>List Of Guest's Order Between Date</b></font></td></tr>
  </table>
  <table align="center">
      <form name="" action="guest_item_range.do?method=guest_datewiseCustomerList" method="post">
      
          <input type="hidden" name="emailid" value="<%=usernam%>">
<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:15px">Fro Date:</font>  &nbsp;&nbsp; <script>DateInput('frodate', true, 'dd/mm/yyyy')</script></td>

      <td> <FONT STYLE="font-weight:bold;color:black;font-size:15px">To Date:</font><script>DateInput('todate', true, 'dd/mm/yyyy')</script></td>
      </tr>
      <tr><td><input type="submit" value="submit"></td></tr>
      </form>
  </table>
  </td></tr>
  
  
                    </table></td></tr>
                    
                    <tr><td><hr></td></tr>                   
                    <tr><td align="center">
<%
String fdate="";
   String tdate="";
   int sz=-1;
if((ArrayList)request.getAttribute("customer")!=null)
  {
   customerlist=(ArrayList)request.getAttribute("customer");
   fdate=(String)request.getAttribute("fdate");
   tdate=(String)request.getAttribute("tdate");
   sz=customerlist.size();
  }
  // out.println(customerlist);
   //out.println("tdate"+tdate);
    if(sz>0)
    {
%>
<table width="100%" border="1" bgcolor="white" cellspacing="0" cellpadding="0">      
 <tr><td colspan="5">From: <%=fdate%>&nbsp;&nbsp;To: <%=tdate%></td></tr>
 <tr><td><FONT STYLE="font-weight:bold;color:blue;font-size:15px">S.no.</font></td>
<td><FONT STYLE="font-weight:bold;color:blue;font-size:15px">LoginID</font></td>
<td><FONT STYLE="font-weight:bold;color:blue;font-size:15px">Order Id</font></td>
<td><FONT STYLE="font-weight:bold;color:blue;font-size:15px">Order Date</font></td>
<td><FONT STYLE="font-weight:bold;color:blue;font-size:15px">View Order</font></td></tr>
     <%
    for(int t=0;t<sz;t++)
    {
  jb=(JavaBean1)customerlist.get(t);
  
    
     %>

     <tr>
<td><FONT STYLE="font-weight:normal;color:black;font-size:14px"><%=t+1%></font></td>
<td><FONT STYLE="font-weight:normal;color:black;font-size:14px"><%=jb.getLoginid()%></font></td>
<td><FONT STYLE="font-weight:normal;color:black;font-size:14px"><%=jb.getOrder_id()%></font></td>
<td><FONT STYLE="font-weight:normal;color:black;font-size:14px"><%=sdf.format(jb.getOrder_date())%></font></td>

<td><a href="<%=request.getContextPath()%>/gue_get_item_date.do?userid=<%=jb.getLoginid()%>&odid=<%=jb.getOrder_id()%>&fd=<%=fdate%>
&td=<%=tdate%>&method=gues_get_item_daterange" target="_blank">view order</a></td>
</tr>
<%}%>    
</table> 
<% }else if(sz==0){%>
No record found!!!
<%}%>
</td> </tr>
</table></td></tr>

</table>
     </td></tr>
        
       </table>
       
	<TR><TD vAlign=top ><%@ include file="/jsp/hrms_footer.jsp" %></td></tr> 
</div>
    
    
    </body>
</html>

