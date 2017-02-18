<%-- 
    Document   : myaccount
    Created on : Jun 4, 2013, 3:41:22 PM
    Author     : kapil
--%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danceables</title>
       <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/change.css" />
        <script language="javascript" src="<%=request.getContextPath()%>/css/menu.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/css_js/resolution.js"></script>
         <script src="<%=request.getContextPath()%>/includes/swfobject.js" type="text/javascript"></script>
         <script language="javascript">
             function login()
             {
                 document.f1.method="post";
                document.f1.action="<%=request.getContextPath()%>/customerUserLog.do?method=customer_Authenticate";
              document.f1.submit();
             }
         </script>
    </head>
    <body>
        <%
        String msg="";
        if(request.getAttribute("msg")!=null){
            msg=(String)request.getAttribute("msg");
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
                <td background="<%=request.getContextPath()%>/images/homepage/bottom grey.png" style="background-repeat: no-repeat" width="100%" valign="top">
                    <table class="cel1" align="center">
                        <tr>
                            <td valign="top" align="left">
                                <form name="f1">
                                <table align="left">
                                    <tr><td class="bx" colspan="2"><a href="<%=request.getContextPath()%>/customer_reg_form.do" class="ln">Create New Account</a></td></tr>
                                    <% if(!msg.equals("")){%>
                                    <tr><td style="padding-top: 30px" colspan="2">
                                            <%=msg%>
                                        </td></tr>
                                    <tr><td colspan="2">
                                            <input type="text" name="emailid" class="tx" value="Username Or Email" onfocus="if(this.value=='Username Or Email') this.value=''" onblur="if(this.value=='') this.value='Username Or Email'">
                                        </td></tr>
                                    <%}else{%>
                                    <tr><td style="padding-top: 30px" colspan="2">
                                            <input type="text" name="emailid" class="tx" value="Username Or Email" onfocus="if(this.value=='Username Or Email') this.value=''" onblur="if(this.value=='') this.value='Username Or Email'">
                                        </td></tr>
                                    <%}%>
                                    <tr><td style="padding-top: 10px" colspan="2">
                                            <input type="password" name="password" class="tx" value="********" onfocus="if(this.value=='********') this.value=''" onblur="if(this.value=='') this.value='********'">
                                        </td></tr>
                                    <input type="hidden" name="check" value="login">
                                    <tr><td><input type="checkbox" name="remember">&nbsp;&nbsp;Remember me on this computer</td>
                                        <td align="right" class="btn" onclick="login()"></td></tr>
                                    <tr><td style="padding-top: 80px" colspan="2">Forgot your password? <a href="#">Click here to reset it</a></td></tr>
                                </table>
                                </form>
                            </td>
                            <td style="padding-left: 70px" align="right">
                                <img src="<%=request.getContextPath()%>/images/acnt-img.png" width="475">
                            </td>
                        </tr>
                    </table></td>
            </tr>
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
        </table>
    </body>
</html>
