<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>

<%@page import="ActionClass.JavaBean1"%>


   <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danceables</title>
        <script language="javascript" src="css_js/resolution.js"></script>
        <link rel="stylesheet" type="text/css" href="css/change.css" />
        <script language="javascript" src="css/menu.js"></script>
    </head>
      

    <body>
<% 
JavaBean1 jb=new JavaBean1();
if(request.getAttribute("jbean")!=null){
jb=(JavaBean1)request.getAttribute("jbean");    
}
%>
<%
    
         ArrayList ar=new ArrayList();
        
  String name="";
  String emailid="";
  
  emailid=(String)session.getAttribute("loginid").toString();
  
 
    
    
    
     %>
     
     <div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/all.js#xfbml=1";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
<table width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td>
                    <div id="topdesign">
                       <div class="header1">
                           <img src="<%=request.getContextPath()%>/images/homepage/logo_03.png" width="253">
                               </div>
                            <div class="header2">
                                <div class="user"><%@include file="/user_login/user_head.jsp"%></div>
                                <div class="header2_2"><%@include file="/top_menu.jsp"%></div>
                            </div>

                        </div>
                </td>
            </tr>
            
        <tr><td background="<%=request.getContextPath()%>/images/homepage/bottom grey.png" width="100%" height="100%" valign="top">
             <table border="0" width="75%"  ALIGN="CENTER">
                <tr align="left"><td VALIGN="TOP" width="20%" STYLE="PADDING-TOP:20PX">
                    <table>
                        <tr><td>Useful Links</td></tr>
        <tr><td><a href="Customer_ViewRegistration.do?method=viewCustomerRegist" style="text-decoration:none;color:grey">View Profile</a></td></tr>
        <tr><td><a href="Customer_EditRegistration.do?method=editCustomerRegist" style="text-decoration:none;color:grey">Update Profile</a></td></tr>
     <tr><td><a href="customer_order_range.do" style="text-decoration:none;color:grey">View Order</a></td></tr>
      <tr><td><a href="<%=request.getContextPath()%>/customer_logout.do?method=customer_logout" style="text-decoration:none;color:grey">Logout</a></td></tr>
                        
                    </table>
                </td>


<td valign="top"  width="80%">
      
    <table align="left">
        <tr><td colspan="2" STYLE="font-weight:bold;color:black;font-size:14px" align="center" height="40">Hi, <%=emailid%></td></tr>

        <%if(request.getAttribute("msg")!=null){%>
<tr><td colspan="2"><font color="black" size="2"><b><%=request.getAttribute("msg")%></b></font></td></tr>   
<%}%>     
        <tr><td colspan="2" height="20" style="color:grey">View Profile Details...</td></tr>
       <tr><td> <FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Your First Name</td>
        <td style="color:grey"><%=jb.getName()%></td></TR>
        <tr><td> <FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Last Name</td>
        <td style="color:grey"><%=jb.getLast_name()%></td></TR>
        
<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Email Address</td>
<td style="color:grey"><%=jb.getEmail_id()%></td></tr> 
          
<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Password</td>
<td style="color:grey"><%=jb.getPassword()%></td></tr>
 <tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Phone Number</td>
<td style="color:grey"><%=jb.getMobileno()%></td></tr> 
<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Address</td>
<td style="color:grey"><%=jb.getHomeaddress()%></td></tr> 
<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">City</td>
<td style="color:grey"><%=jb.getCity()%></td></tr> 
<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">State</td>
<td style="color:grey"><%=jb.getState()%></td></tr> 

<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Zip/Postal</td>
<td style="color:grey"><%=jb.getPincode()%></td></tr> 
<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Country/Region</td>
<td style="color:grey"><%=jb.getCountry()%></td></tr> 


    </table>
    </form> 
</td></tr>
              
            <tr><td colspan="3"><table align="center"><tr>
                            <td width="660" height="" valign="top" style="padding-top: 20px">
                                <table background="<%=request.getContextPath()%>/images/homepage/bottom grey.png" class="tbl" border="0">
                                    <tr valign="top">
                                        <td colspan="2" class="fnt2">
                                            <a href="" style="text-decoration: none"><font color="#3EAAAA">Click here to read our</font></a> <br>
                                            Rave Review
                                        </td>
                                        <td class="fnt2" style="padding-left: 20px">
                                            <a href=""><img src="<%=request.getContextPath()%>/images/homepage/Order form icon.png" border="0" width="150"></a><br>
                                            Download our printable order <br> form to order by mail or fax.
                                        </td>
                                    </tr>
                                    <tr height="60">
                                        <td valign="top" colspan="2">
                                            <table>
                                                <tr><td class="fnt2">Our Distribution</td></tr>
                                                <tr><td>
                                            <img src="<%=request.getContextPath()%>/images/homepage/logo 3.png" border="0" width="170" height="35">
                                                    </td>
                                                    <td style="padding-left: 30px"><img src="<%=request.getContextPath()%>/images/homepage/logo 2.png" border="0" width="150" height="40"></td>
                                                </tr>
                                            </table></td>
                                        <td style="padding-left: 20px; padding-top: 20px"><img src="<%=request.getContextPath()%>/images/homepage/Logo 1.png" border="0" width="150"></td>
                                    </tr>
                                    <tr valign="top"><td colspan="2" style="padding-bottom: 10px">
                                            <a class="a" style="text-decoration: none" href="http://www.danceclassmusic.com/bio-stevenmitchell.html"><font style="font-size: 14px">http://www.danceclassmusic.com/bio-stevenmitchell.html</font></a></td>
                                        <td style="padding-left: 20px;padding-bottom: 10px">
                                            <a class="a" style="text-decoration: none" href="http://www.cdbaby.com/Artist/StevenMitchell"><font style="font-size: 14px">http://www.cdbaby.com/Artist/StevenMitchell</font></a></td>
                                    </tr>
                                </table>
                            </td>
                            <td class="pad1" width="320" valign="top">
                                <table class="tbl1" border="0">
                                    <tr><td><a class="b" href="#">Shipping Notes</a></td></tr>
                                    <tr><td><a class="b" href="#">Terms & Conditions</a></td></tr>
                                    <tr><td><a class="b" href="#">Privacy policy</a></td></tr>
                                    <tr><td><a class="b" href="#">Sitemap</a></td></tr>
                                    <tr><td><a class="b" href="#">Contact Us</a></td></tr>
                                    <tr><td><img src="<%=request.getContextPath()%>/images/homepage/Facebook Icon.png" width="170" height="40"></td></tr>
                                </table>
                            </td>
                                    </tr></table></td>
                        </tr>
               </table></td></tr>
        </table>
    </body>
</html>

