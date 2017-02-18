<%-- 
    Document   : errorOnPage
    Created on : Mar 29, 2014, 1:54:36 PM
    Author     : kapil
--%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width">
        <title>Danceables</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/change.css" />
        <script language="javascript" src="<%=request.getContextPath()%>/css/menu.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/css_js/resolution.js"></script>
    </head>
    <body>
        <table width="100%" cellspacing="0" cellpadding="0">
         <!--<table align="center">-->
            <tr>
               <!-- <img class="image" src="<%=request.getContextPath()%>/images/homepage/Homepage background.png" width="100%" height="700">-->
                 
                <td style="background:#CFD2D3">
                    <div id="header">
                    <div class="tb">
                        <div id="headdesign">
                       <div class="header1">
                           <img src="<%=request.getContextPath()%>/images/homepage/logo_03.png" class="logoimg">
                        </div>
                            <div class="header2">
                                <div class="user"><%@include file="/user_login/user_head.jsp"%></div>
                                <div class="header2_2"><%@include file="/top_menu.jsp"%></div>
                            </div>

                        </div>
                    </div>
                    </div>
                    </td>
               
                
            </tr>
            
            <%
            String msg="";
            if(request.getParameter("vc")!=null){
                msg="Time out. Please try again.";
                out.print(msg);
            }
            else if(request.getAttribute("vc")!=null){
                msg=(String)request.getAttribute("vc");
            }
            %>
                <tr>
                <td background="<%=request.getContextPath()%>/images/homepage/bottom grey.png" width="100%" valign="top" style="background-repeat: no-repeat">
                    <table border="0" width="75%" align="center" valign="top">
                        <tr align="left" valign="top">
                            <td class="pad" width="50%">
                                <table class="shadow" align="center">
                                    <tr><td class="fnt" align="center"><font color="#3EAAAA" size="3">ERROR MESSAGE</font> </td></tr>
                                     <tr><td align="center" valign="top">
                                             <font style="color:#333;font-size: 14px;">
                                             <html:errors/><br>
                                            
                                             <%=msg%> 
                                             </font>
                                         </td></tr></table>
                        
                            </td>
                        </tr>
                      <tr><td colspan="3"><%@include file="/footer.jsp"%></td></tr>
                    </table>
                </td>
            </tr>
        </table>
    </body>
</html>