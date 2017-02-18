<%-- 
    Document   : myWishlist
    Created on : Mar 14, 2013, 10:18:18 PM
    Author     : kapil
--%>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page import="com.myapp.struts.Im_Projects_DataHold"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.myapp.struts.Display_Data_hold"%>
<%@page import="moreimg.img_bean"%>
<%@page import="moreimg.function_int_foodmart"%>
<%@page language="java"%>
<%@page import="java.io.*"%>
<%@page import="Main_category.item_bean"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Dancables</title>
         <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/change.css" />
        <script language="javascript" src="<%=request.getContextPath()%>/css/menu.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/css_js/resolution.js"></script>
    </head>
    <body>
      

<%
ArrayList list=new ArrayList();
if(request.getAttribute("wishlist")!=null){
    list=(ArrayList)request.getAttribute("wishlist");
}
item_bean itembe=new item_bean();
double rate=0.0;
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
                    <table border="0" align="center" valign="top">
                        <tr>
                            <td width="950" valign="top" height="280"><table border="0" width="100%" valign="top"> 
                            <tr><font style="color: brown; font-weight: bold; font-size: 15px">My Wishlist</font>(<%=list.size()%> Items)</tr>  
                <%if(list.size()!=0){
                    for(int i=0;i<list.size();i++){
                        itembe=(item_bean)list.get(i);
                        
                %> 
                
                <tr><td><hr></td></tr>   
                <tr><td valign="top"><table width="50%" border="0">
                            <tr><td valign="top" width="25%"><img src="./music_image/<%=itembe.getFilename()%>" width="120" height="140"></td>
                                <td valign="top"  width="75%"><table valign="top" border="0" width="100%">
     
     <!-- <tr><td width="20%">Product ID:</td><td><%=itembe.getProd_id()%></td></tr>-->
   
    <tr><td width="30%" valign="top">Product:</td><td style="padding-left: 0px"><%=itembe.getBrand()%></td></tr>
    
    <tr><td width="20%">Code:</td><td style="padding-left: 0px"><%=itembe.getProd_id()%></td></tr>
   <!--  <tr><td width="20%">Size:</td><td><%=itembe.getUnit()%></td></tr> -->
    <tr><td width="20%" valign="top">Description:</td><td style="padding-left: 0px"><%=itembe.getDetail()%></td></tr>
    <!-- <tr><td width="20%">Market Price.:</td><td><%=itembe.getMarketprice()%></td></tr> 
      <tr><td width="20%">Discount Offer:</td><td><%=itembe.getDiscount()%>&nbsp;<%=itembe.getDiscountdetail()%></td></tr>-->
   <tr><td width="20%">Web Price:</td><td style="padding-left: 0px">$<%=itembe.getPrice()%></td></tr>
   <tr><td></td><td style="padding-left: 0px"><a href="detail_item.do?id=<%=itembe.getItem_id()%>"><img  src="./images/click-here-button.png" border="0" width="90"></a></td></tr>
                                    </table></td></tr>
                            <tr><td><a href="<%=request.getContextPath()%>/remove.do?id=<%=itembe.getItem_id()%>&method=remove">Remove</a></td></tr>
    </table></td></tr>
   <%    }
                }
else{%>
<tr><td>You have no item in your wishlist</td></tr>
<%}%>
</table></td></tr>

  <tr>
          <td><%@include file="/footer.jsp"%></td>
                        </tr>                      
                    </table></td></tr>
                  
        </table>
    </body>
</html>