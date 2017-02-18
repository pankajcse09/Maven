<%-- 
    Document   : CustomerWelcome
    Created on : Jun 14, 2013, 1:00:55 PM
    Author     : kapil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        String loginid="";
        if(session.getAttribute("loginid")!=null){
            loginid=(String)session.getAttribute("loginid");
        }
        if(loginid.equals("")||loginid.equals("guest"))
        {
            String msg="Your Session is expired. Please Login again!!!";
            RequestDispatcher rd1=request.getRequestDispatcher("/Registration/Customer_Regis_Form_1.jsp?msg="+msg); 
            rd1.forward(request,response);
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
                <td background="<%=request.getContextPath()%>/images/homepage/bottom grey.png" width="100%" height="100%" valign="top">
                    <TABLE border="0" width="75%" align="center">
                 <tr>
<td STYLE="PADDING-TOP:20PX">
    <table>
        <tr><td style="color:grey"><b>Useful Links</b></td></tr><br>
        <tr><td><a href="Customer_ViewRegistration.do?method=viewCustomerRegist" style="text-decoration:none;color:grey">View Profile</a></font></td></tr>
        <tr><td><a href="Customer_EditRegistration.do?method=editCustomerRegist" style="text-decoration:none;color:grey">Update Profile</a></font></td></tr>
       <tr><td><a href="customer_order_range.do" style="text-decoration:none;color:grey">View Order</a></font></td></tr>
       <tr><td><a href="<%=request.getContextPath()%>/customer_logout.do?method=customer_logout" style="text-decoration:none;color:grey">Logout</a></font></td></tr>
       <tr><td height="200"></td></tr>
       
    </table>
</td>
<td VALIGN="TOP">
                 
                 <TABLE  align="center" border="0" VALIGN="TOP">
   <tr><td STYLE="font-weight:bold;color:black;font-size:14px" align="center">Hi, <%=loginid%></td></tr>

 
<tr><td STYLE="font-weight:normal;color:black;font-size:12px">Here is everything you need  and much more..</td></tr>

   </td></tr>
  </table>   </td></tr>
  
  
  
 
            <tr>
                            <td colspan="3"><table align="center"><tr>
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
                         </TABLE></td>
            </tr>
        </table>
    </body>
</html>
