<%-- 
    Document   : chkout
    Created on : Jun 24, 2013, 10:59:03 AM
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
                <td background="<%=request.getContextPath()%>/images/homepage/bottom grey.png" width="100%" valign="top" style="background-repeat: no-repeat">
                    <table class="cel1" style="padding-left: 0px" width="100%">
                         <tr>
                            <td><table border="0" width="100%">
                        <tr>
                            <td valign="top" align="right">
                                <form name="f1">
                                <table align="right">
                                    <tr><td class="bx" colspan="2"><a href="./chekout_cart.do?method=checkout_cart" class="ln">Place Order Without Account</a></td></tr>
                                    <tr><td colspan="2" height="10"></td></tr>
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
                                    <input type="hidden" name="check" value="checkout">
                                    <tr><td><input type="checkbox" name="remember">&nbsp;&nbsp;Remember me on this computer</td>
                                        <td align="right" class="btn" onclick="login()"></td></tr>
                                    <tr><td style="padding-top: 80px" colspan="2">Forgot your password? <a href="#">Click here to reset it</a></td></tr>
                                </table>
                                </form>
                            </td>
                            <td style="padding-left: 70px" align="left" valign="top">
                                <img src="<%=request.getContextPath()%>/images/check-out-image.png" width="475">
                            </td>
                        </tr>
                        </table></td></tr>
                          <tr>
          <td><%@include file="/footer.jsp"%></td>
                        </tr>  
                    </table>
                </td>
            </tr>
                  
        </table>
    </body>
</html>