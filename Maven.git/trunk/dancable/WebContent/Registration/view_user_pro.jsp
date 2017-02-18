<%-- 
    Document   : view_user_profile
    Created on : Mar 21, 2013, 1:12:03 PM
    Author     : kapil
--%>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>

<%@page import="ActionClass.JavaBean1"%>
<!DOCTYPE html>
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
    
         ArrayList ar=new ArrayList();
        
  String name="";
  String emailid="";
  
  emailid=(String)session.getAttribute("loginid");
  
 
    JavaBean1 jb=new JavaBean1();
if(request.getAttribute("jbean")!=null){
jb=(JavaBean1)request.getAttribute("jbean");    
}
    
    
     %>
     <div id="conta" align="center">
         <table width="100%" border="0" style="border-collapse:collapse" cellspacing="0" cellpadding="0" valign="top"> 
          <TR><TD valign="top"><%@ include file="/Registration/top_design_1.jsp" %></TD></TR>
          <tr><td height="450" valign="top" align="left">
       <table border="1" width="100%"  ALIGN="CENTER" bgcolor="#ffffff" valign="top">
                <tr><td VALIGN="TOP" width="25%">
                    <table>
       <tr><td>Useful Links</td></tr>
       <tr><td><a href="emp_reg_form.do" style="text-decoration:none;font-size:15px;color:#7D0E0E">Employee Registration Form</a></td></tr> 
     <tr> <td><a href="EditRegistration.do?method=editRegist" style="text-decoration:none;font-size:15px;color:#7D0E0E">View/Edit Profile</a></td></tr> 
      <tr><td><a href="view_users.do" style="text-decoration:none;font-size:15px;color:#7D0E0E">Users</a></td></tr>
    <!-- <tr>  <td><a href="view_feedback.do"> View Feedback</a></td></tr>-->
     <tr><td><a href="user_view_order.do?pr=1" style="text-decoration:none;font-size:15px;color:#7D0E0E">Today Registerd User Orders</a></td></tr>    
 <tr><td><a href="all_order.do?pr=1" style="text-decoration:none;font-size:15px;color:#7D0E0E">Today Guest Orders</a></td></tr>
       <tr><td><a href="view_range_order.do" style="text-decoration:none;font-size:15px;color:#7D0E0E">Registerd User Order Date Wise </a></td></tr> 
<tr><td><a href="guest_datewise.do" style="text-decoration:none;font-size:15px;color:#7D0E0E">Guest User Order Date Wise</a></td></tr> 
<tr><td><a href="get_invoice.do" style="text-decoration:none;font-size:15px;color:#7D0E0E">Invoice</a></td></tr>
 <tr><td><a href="update_web.do" style="text-decoration:none;font-size:15px;color:#7D0E0E">Update Website</a></td></tr> 
    
    <!--<tr><td><a href="gotocms.do" style="text-decoration:none;font-size:15px;color:#7D0E0E">Content Management System</a></td></tr>-->
       
    </table>
                </td>


<td valign="top"  width="75%" bgcolor="#ffffff">
      
    <table align="left">
        <tr><td align="right" style="padding-left: 500px"><font color="maroon" size="2">Welcome&nbsp;</font><font color="darkblue" 
          size="4">'<%=emailid%>'</font></td>
                        <!--<td align="right" style="padding-left: 10px"><font color="maroon" size="2"><a href="<%=request.getContextPath()%>/logout.do?method=logout">Logout&nbsp;</a></font></td>-->
                        </tr>
                        <tr><td><table>
        
       <tr><td> <FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Your First Name</td>
        <td><%=jb.getName()%></td></TR>
        <tr><td> <FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Last Name</td>
        <td><%=jb.getLast_name()%></td></TR>
        
<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Email Address</td>
<td><%=jb.getEmail_id()%></td></tr> 
          
<!--<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Password</td>
<td><%=jb.getPassword()%></td></tr>-->
 <tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Phone Number</td>
<td><%=jb.getMobileno()%></td></tr> 
<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Address</td>
<td><%=jb.getHomeaddress()%></td></tr> 
<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">City</td>
<td><%=jb.getCity()%></td></tr> 
<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">State</td>
<td><%=jb.getState()%></td></tr> 

<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Zip/Postal</td>
<td><%=jb.getPincode()%></td></tr> 
<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Country/Region</td>
<td><%=jb.getCountry()%></td></tr> 

                                </table></td></tr>
    </table>
    </form> 
</td></tr>
                </table>
              </td></tr></table>
<TR><TD vAlign=top ><%@ include file="/jsp/hrms_footer.jsp" %></td></tr>
     </div>

    </body>
</html>
