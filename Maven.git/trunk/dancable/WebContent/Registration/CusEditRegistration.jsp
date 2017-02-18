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
                         
                        <tr><td align="left">Useful Links</td></tr>
        <tr><td align="left"><a href="Customer_ViewRegistration.do?method=viewCustomerRegist" style="text-decoration:none;color:grey">View Profile</a></td></tr>
        <tr><td align="left"><a href="Customer_EditRegistration.do?method=editCustomerRegist" style="text-decoration:none;color:grey">Update Profile</a></td></tr>
        <tr><td align="left"><a href="customer_order_range.do" style="text-decoration:none;color:grey">View Order</a></td></tr>
        <tr><td align="left"><a href="<%=request.getContextPath()%>/customer_logout.do?method=customer_logout" style="text-decoration:none;color:grey">Logout</a></td></tr>
     
                        
                    </table>
                </td>


<td valign="top"  width="80%">
  <form name="f1" method="post" action="<%=request.getContextPath()%>/CustomerRegist_update.do?method=registUpdate_Customer">
      
    <table align="left">
        <tr><td colspan="2" STYLE="font-weight:bold;color:black;font-size:14px" align="center" height="40">Hi, <%=emailid%></td></tr>

        <%if(request.getAttribute("msg")!=null){%>
<tr><td colspan="2"><font color="black" size="2"><b><%=request.getAttribute("msg")%></b></font></td></tr>   
<%}%>     
        <tr><td colspan="2" STYLE="font-weight:bold;color:black;font-size:14px" align="left" height="20">Profile Details...</td></tr>
       <tr><td> <FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Your First Name</td>
        <td><input type="text" name="name" size="29" value="<%=jb.getName()%>"></td></TR>
        <tr><td> <FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Last Name</td>
        <td><input type="text" name="last_name" size="29" value="<%=jb.getLast_name()%>"></td></TR>
        
<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Email Address</td>
<td><input type="text" name="emailid" size="29"  value="<%=jb.getEmail_id()%>" disabled></td></tr> 
       <input type="hidden" name="email"  value="<%=jb.getEmail_id()%>">   
<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Password</td>
<td><input type="password" name="password" value="<%=jb.getPassword()%>" size="29"></td></tr>
<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Confirm Password</td>
<td><input type="password" name="cpassword" value="" size="29"></td></tr>
 <tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Phone Number</td>
<td><input type="text" name="mobileno" size="29"  value="<%=jb.getMobileno()%>"></td></tr> 
<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Address</td>
<td><input type="text" name="homeaddress" size="29"  value="<%=jb.getHomeaddress()%>"></td></tr> 
<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">City</td>
<td><input type="text" name="city"  size="29"  value="<%=jb.getCity()%>"></td></tr> 
<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">State</td>
<td><select name="state">
     <option value="<%=jb.getState()%>"><%=jb.getState()%></option> 
                      <option value="AA - Military">AA - Military</option>                          
                      <option value="AE - Military">AE - Military</option>
                      <option value="AP - Military">AP - Military</option>
                      <option value="Alabama">Alabama</option>
                      <option value="Alaska">Alaska</option>
                      <option value="Arizona">Arizona</option>
                      <option value="Arkansas">Arkansas</option>
                      <option value="California">California</option>
                      <option value="Colorado">Colorado</option>
                      <option value="Connecticut">Connecticut</option>
                      <option value="District of Columbia">District of Columbia</option>
                      <option value="Delaware">Delaware</option>
                      <option value="Florida">Florida</option>
                      <option value="Georgia">Georgia</option>
                      <option value="Hawaii">Hawaii</option>
                      <option value="Idaho">Idaho</option>
                      <option value="Illinois">Illinois</option>
                      <option value="Indiana">Indiana</option>
                      <option value="Iowa">Iowa</option>
                      <option value="Kansas">Kansas</option>
                      <option value="Kentucky">Kentucky</option>
                      <option value="Louisiana">Louisiana</option>
                      <option value="Maine">Maine</option>
                      <option value="Maryland">Maryland</option>
                      <option value="Massachusetts">Massachusetts</option>
                      <option value="Michigan">Michigan</option>
                      <option value="Minnesota">Minnesota</option>
                      <option value="Mississippi">Mississippi</option>
                      <option value="Missouri">Missouri</option>
                      <option value="Montana">Montana</option>
                      <option value="Nebraska">Nebraska</option>
                      <option value="Nevada">Nevada</option>
                      <option value="New Hampshire">New Hampshire</option>
                      <option value="New Jersey">New Jersey</option>
                      <option value="New Mexico">New Mexico</option>
                      <option value="New York">New York</option>
                      <option value="North Carolina">North Carolina</option>
                      <option value="North Dakota">North Dakota</option>
                      <option value="Ohio">Ohio</option>
                      <option value="Oklahoma">Oklahoma</option>
                      <option value="Oregon">Oregon</option>
                      <option value="Pennsylvania">Pennsylvania</option>
                      <option value="Puerto Rico">Puerto Rico</option>
                      <option value="Rhode Island">Rhode Island</option>
                      <option value="South Carolina">South Carolina</option>
                      <option value="South Dakota">South Dakota</option>
                      <option value="Tennessee">Tennessee</option>
                      <option value="Texas">Texas</option>
                      <option value="Utah">Utah</option>
                      <option value="Vermont">Vermont</option>
                      <option value="Virginia">Virginia</option>
                      <option value="Washington">Washington</option>
                      <option value="West Virginia">West Virginia</option>
                      <option value="Wisconsin">Wisconsin</option>
                      <option value="Wyoming">Wyoming</option>
                      <option value="CA-Alberta">CA-Alberta</option>
                      <option value="CA-British Columbia">CA-British Columbia</option>
                      <option value="CA-Manitoba">CA-Manitoba</option>
                      <option value="CA-New Brunswick">CA-New Brunswick</option>
                      <option value="CA-Newfoundland and Labrador">CA-Newfoundland and Labrador</option>
                      <option value="CA-Northwest Territories">CA-Northwest Territories</option>
                      <option value="CA-Nova Scotia">CA-Nova Scotia</option>
                      <option value="CA-Nunavut">CA-Nunavut</option>
                      <option value="CA-Ontario">CA-Ontario</option>
                      <option value="CA-Prince Edward Island">CA-Prince Edward Island</option>
                      <option value="CA-Quebec">CA-Quebec</option>
                      <option value="CA-Saskatchewan">CA-Saskatchewan</option>
                      <option value="CA-Yukon">CA-Yukon</option>
                      </select></td></tr> 

<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Zip/Postal</td>
<td><input type="text" name="pincode" size="29"  value="<%=jb.getPincode()%>"></td></tr> 
<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Country/Region</td>
<td><select name="country">
           <option value="<%=jb.getCountry()%>"><%=jb.getCountry()%></option>
           
           <option value="United States">United States</option>
           <option value="Canada">Canada</option>
           
       </select></td></tr> 

<tr><td class="SubmitB"><input type="submit" name="regBtn" id="regBtn" value="UPDATE" /></td></tr>

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


