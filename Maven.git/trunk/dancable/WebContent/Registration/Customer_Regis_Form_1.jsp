<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page import="java.util.ArrayList"%>


<%@page language="java"%>
<%@page import="java.io.*"%>

<%@page contentType="text/html"%>


   <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Danceables</title>
        
       <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/pro_drop_1/laycss.css" />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/change.css" />
        <script language="javascript" src="<%=request.getContextPath()%>/css/menu.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/css_js/resolution.js"></script>
</head>
<body>
        <%
String wish="";
if(request.getAttribute("wish")!=null){
    wish=(String)request.getAttribute("wish");
} 
else{
    wish=(String)request.getParameter("msg");
}
        %>

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
<tr>
   <td background="<%=request.getContextPath()%>/images/homepage/bottom grey.png" style="background-repeat: no-repeat" width="100%" valign="top" height="520">
                 
             <table class="cel1" align="center">
                 <tr><td align="center" valign="=top">
                         <% if(wish.equals("wish")){%>
                         <font color="red">Your wishlist is empty. To create your wishlist either Sign In or Sign Up.</font>
                         <%}else{%>
                         <font color="red"><%=wish%></font>
                         <%}%>
                         </td></tr>
                        <tr>
                            <td VALIGN="TOP" width="50%">
                         <form name="f" method="post" action="<%=request.getContextPath()%>/customerUserlog.do?method=customer_Authenticate">
                             <div class="eft">
                    <table>
                        
   <%if(request.getAttribute("msg")!=null){%>
<tr><td colspan="2"><font color="black" size="2"><b><%=request.getAttribute("msg")%></b></font></td></tr>   
<%}%>  
               
                        <tr><td colspan="2">SIGN IN</td></tr>
                        <tr><td> <FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Login ID</td>
        <td><input type="text" name="emailid" style="width:120" value=""></td></TR>
<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Password</td>
<td><input type="password" name="password" style="width:120"  value=""></td></tr> 
<tr><td align="center" colspan="2" class="SubmitB"><input type="submit" name="regBtn" id="regBtn" value="LOGIN" /></td></tr>
                            
                    </table> </div>
                         </form>
                </td>
                            <td valign="top" width="50%">
  <form name="f1" method="post" action="<%=request.getContextPath()%>/UserRegist_customer.do?method=registUserAction_Customer">
       <div class="ight">
    <table>
        <%if(request.getAttribute("msg")!=null){%>
<tr><td colspan="2"><font color="black" size="2"><b><%=request.getAttribute("msg")%></b></font></td></tr>   
<%}%>     
        <tr><td colspan="2">NEW CUSTOMER</td></tr>
       <tr><td> <FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Your First Name</td>
        <td><input type="text" name="name" style="width:120" value=""></td></TR>
        <tr><td> <FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Last Name</td>
        <td><input type="text" name="last_name" style="width:120" value=""></td></TR>
        
<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Email Address</td>
<td><input type="text" name="emailid" style="width:120"  value=""></td></tr> 
          
<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Password</td>
<td><input type="password" name="password" value="" style="width:120"></td></tr>
<td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Confirm Password</td>
<td><input type="password" name="cpassword" value="" style="width:120"></td></tr>
 <tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Phone Number</td>
<td><input type="text" name="mobileno" style="width:120"  value=""></td></tr> 
<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Address</td>
<td><input type="text" name="homeaddress" style="width:120"  value=""></td></tr> 
<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">City</td>
<td><input type="text" name="city" style="width:120"  value=""></td></tr> 
<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">State</td>
<td><input type="text" name="state" style="width:120"  value="">
    <!--<select name="state" value="">
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
                      </select>-->
    </td></tr> 

<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Zip/Postal</td>
<td><input type="text" name="pincode" style="width:120"  value=""></td></tr> 
<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px;line-height:2;font-family: Arial, Helvetica, sans-serif;">Country/Region</td>
<td><input type="text" name="country" style="width:120"  value="">
    <!--<select name="country">
            
           <option value="United States">United States</option>
           <option value="Canada">Canada</option>
           
    </select--></td></tr> 

<tr><td class="SubmitB"><input type="submit" name="regBtn" id="regBtn" value="REGISTER" /></td></tr>

    </table></div>
    </form> 
</td>
                        </tr>
                <tr> <td colspan="2"><%@include file="/footer.jsp"%></td></tr>  
                    </table></td>
            </tr>
                         
                
              </table>         
            </body>
</html>
