<%-- 
    Document   : totalAmount
    Created on : Oct 12, 2013, 1:28:39 PM
    Author     : kapil
--%>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<%@page language="java"%>
<%@page import ="Main_category.item_bean"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@page import="java.sql.Timestamp"%>
<%@page import ="ActionClass.JavaBean1"%>
<%@page import ="Main_category.item_bean"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danceable</title>
        
       <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/pro_drop_1/laycss.css" />
            <script language="javascript" src="kk/resolution.js">
</script>
    <script language="javascript" src="<%=request.getContextPath()%>/view_content/calendarDateInput.js"></script>
    
    <script language="javascript">
            function printit()
            {
                var content_value=document.getElementById("clickHereToPrint").innerHTML;
                var disp_setting="toolbar=yes,location=no,directories=yes,menubar=yes,"; 
                disp_setting+="scrollbars=yes,width=900, height=600, left=100, top=25"; 
                
                var docprint=window.open("","",disp_setting); 
   docprint.document.open(); 
   docprint.document.write('<html><head><title></title>'); 
   docprint.document.write('</head><body onLoad="self.print(); window.close();"><center>');          
   docprint.document.write(content_value);          
   docprint.document.write('</center></body></html>'); 
   docprint.document.close(); 
   docprint.focus(); 
            }
        </script>
    
    </head>
    <body style="margin-left:80;margin-right:80;margin-top:5">
        <%
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy"); 
         ArrayList ar=new ArrayList();
        
  String name="";
  String emailid="";
  String fdate="";
  String tdate="";
  if(request.getAttribute("fdate")!=null){
fdate=(String)request.getAttribute("fdate");    
}
    if(request.getAttribute("tdate")!=null){
tdate=(String)request.getAttribute("tdate");    
}
  emailid=(String)session.getAttribute("loginid");
   %>
     <div id="conta" align="center">
         <table width="100%" border="0" style="border-collapse:collapse" cellspacing="0" cellpadding="0" valign="top"> 
          <TR><TD valign="top"><%@ include file="/Registration/top_design_1.jsp" %></TD></TR>
          <tr><td height="450" valign="top" align="left">
       <table border="1" width="100%"  ALIGN="CENTER" bgcolor="#ffffff" valign="top">
                <tr>

<td VALIGN="TOP" width="25%">
                    <table>
       <tr><td>Useful Links</td></tr>
     <tr><td style="font-size:18px;font-color:orange">Admin Links</td></tr>

 <tr><td><a href="emp_reg_form.do" style="text-decoration:none;font-size:15px;color:#7D0E0E">Employee Registration Form</a></td></tr> 

     <tr> <td><a href="EditRegistration.do?method=editRegist" style="text-decoration:none;font-size:15px;color:#7D0E0E">View/Edit Profile</a></td></tr> 

      <tr><td><a href="view_users.do" style="text-decoration:none;font-size:15px;color:#7D0E0E">Users</a></td></tr>

<tr>  <td><a href="view_feedback.do" style="text-decoration:none;font-size:15px;color:#7D0E0E"> View Feedback</a></td></tr>

<tr>  <td><a href="view_newsemail.do" style="text-decoration:none;font-size:15px;color:#7D0E0E"> Newsletter Email</a></td></tr>

     <tr><td><a href="user_view_order.do?pr=1" style="text-decoration:none;font-size:15px;color:#7D0E0E">Today Registerd User Orders</a></td></tr>    

 <tr><td><a href="all_order.do?pr=1" style="text-decoration:none;font-size:15px;color:#7D0E0E">Today Guest Orders</a></td></tr>

       <tr><td><a href="view_range_order.do" style="text-decoration:none;font-size:15px;color:#7D0E0E">Registerd User Order Date Wise </a></td></tr> 

<tr><td><a href="guest_datewise.do" style="text-decoration:none;font-size:15px;color:#7D0E0E">Guest User Order Date Wise</a></td></tr> 

<tr><td><a href="get_invoice.do" style="text-decoration:none;font-size:15px;color:#7D0E0E">Invoice</a></td></tr>

<tr><td><a href="recd_am.do" style="text-decoration:none;font-size:15px;color:#7D0E0E">Total Amount</a></td></tr>

 <tr><td><a href="update_web.do" style="text-decoration:none;font-size:15px;color:#7D0E0E">Update Website</a></td></tr> 
    
    <!--<tr><td><a href="gotocms.do" style="text-decoration:none;font-size:15px;color:#7D0E0E">Content Management System</a></td></tr>-->
 
    </table>
                </td>


<td valign="top"  width="100%" bgcolor="#ffffff">
<table width="100%" cellspacing="0" cellpadding="0"> 
<tr><td>
         <form name="" action="cal_am.do?method=calAm" method="post">
        <table align="center">
     <tr>
<td><FONT STYLE="font-weight:bold;color:black;font-size:15px">Fro Date:</font> 
 &nbsp;&nbsp; <script>DateInput('frodate', true, 'dd/mm/yyyy')</script></td>
<td> <FONT STYLE="font-weight:bold;color:black;font-size:15px">To Date:</font><script>DateInput('todate', true, 'dd/mm/yyyy')</script></td>
    </tr>
      <tr><td><input type="submit" value="submit"></td></tr>
     
  </table>
          </form>
         </td></tr>
  
<tr><td><hr></td></tr>
<tr>
    <td valign="top">
        <table width="80%" border="0" cellspacing="0" cellpadding="0">
            <tr><td><center><h2 style="color: green"><u>Amount Received</u></h2></center></td></tr>
        <% if(request.getAttribute("amount")!=null&&!request.getAttribute("amount").equals("")){%>
        <tr><td><u><span style="color: red; font-size: 20px">From date</span> <span style="color: #837C80; font-size: 16px"><%=fdate%></span> 
            <span style="color: red; font-size: 20px">to</span> <span style="color: #837C80; font-size: 16px"><%=tdate%></span></u>
                <br><br>
                <span style="color: #000; font-size: 20px">Total Collection: </span><span style="color: #726B6F; font-size: 18px">$<%=request.getAttribute("amount")%></span>
            </td></tr>
        <%}%>
        </table>
    </td>
</tr>

    </table>
  
    
</td>
                
                
                
                </tr>
                </table>
              </td></tr></table>
<TR><TD vAlign=top ><%@ include file="/jsp/hrms_footer.jsp" %></td></tr>
     </div>

    </body>
</html>
