<%-- 
    Document   : rave_reviews
    Created on : Dec 30, 2013, 2:36:01 PM
    Author     : kapil
--%>



<%@page import="moreimg.img_bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@page import ="Main_category.item_bean"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.*"%>
<%@page import="java.sql.Timestamp"%>
<%@page import ="mc_bean.mc_prop"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danceables</title>
        <meta name="viewport" content="width=device-width">
       <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/change.css" />
        <script language="javascript" src="<%=request.getContextPath()%>/css/menu.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/css_js/resolution.js"></script>
</head>
      

    <body>
<%
ArrayList homelist=new ArrayList();
img_bean imgbe=new img_bean();
if(request.getAttribute("homelist")!=null)
{
homelist=(ArrayList)request.getAttribute("homelist");
//out.println(homelist);
}%>
     
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
     
     <tr><td background="<%=request.getContextPath()%>/images/homepage/bottom grey.png" width="100%" valign="top" style="background-repeat: no-repeat" border="">
                 <table class="cel1" style="padding-left: 0px;width:80%" border="0" align="center">
                     <tr><td width="80%">
                             <div style="width:95%">
                             <div class="chng1">
                                 <div class="rave"><a class="b" href="<%=request.getContextPath()%>/fm_home.do?name=ravereviews">
                                         <span>RAVE REVIEWS</span></a></div></div>
                    <div style="padding-top: 20px;overflow:hidden;">
                        <div class="raveblock">
                        <div class="raveimg"><img src="<%=request.getContextPath()%>/images/rave_image.png"></div>   
                        <div>
                            
          <%for(int i=0;i<homelist.size();i++)
            {
        %>
    <p>
   <%
       imgbe=(img_bean)homelist.get(i);
%>  
<font class="fnt3"><%=imgbe.getDesc()%></font>
<p><%=imgbe.getHead()%></p>
</p>
<p>&nbsp;</p>
<%}%>
                            
                            
                        </div>
                        </div>
                       </div>  
                             </div>
                         </td></tr>
   <tr>
          <td><%@include file="/footer.jsp"%></td>
                        </tr>  
    
  </table>   
      </td>
               </tr>
   
</table>
    
    </body>
</html>


