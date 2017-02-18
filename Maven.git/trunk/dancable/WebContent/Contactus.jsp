


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
                 <table class="cel1" style="padding-left: 0px" border="0" align="center">
               <tr> 
                   <td valign="top"><table height="500" border="0"><tr>
                   <td valign="top"><table  align="left" border="0">
                           <tr><td class="chng1" align="center">
                                   <a class="b" href="fm_home.do?name=contactus">CONTACT US</a></td>
                               <td style="padding-left: 30px"><font color="#3EAAAA" size="4" style="font-weight: bold; font-family: arial">Steven V Mitchell</font></td>
                           </tr>
                           <tr>
                               <td style="padding-top: 10px;"><img src="<%=request.getContextPath()%>/images/steven-image.png" width="200"></td>
                               <td style="padding-left: 30px;padding-top: 20px;" valign="top">
                                   <span style="font-size: 16px; font-family: arial; color: #747474">CONTACT INFO:<br>
                                       P O BOX 230185<br>
                                           New York, NY 10023<br> 
                                               Tel: 917-656-5290<br><br><br>
                                                           E-MAIL<br>
                                                               danceables@hotmail.com</span>
                               </td>
                           </tr>        
                       </table></td>
                   <td valign="top" style="padding-left:30px"><table  align="right" border="0" valign="top">
    <html:errors/>
    <html:form action="myfeedback">
        <tr><td colspan="2" height="10" align="center">
<%if(request.getAttribute("fedup")!=null)
{
   out.println("<font color='#996600'>");
   out.println((String)request.getAttribute("fedup"));
   out.println("</font>");
   }
%></td></tr>
        
          <tr><td colspan="2" height="10" align="center"><br><font color="red" size="2">*</font> 
          <font color="black" size="1"> Fields are Manatory</font></td></tr>
     
         <tr><td width="155"><font color="red" size="1">*</font> <font color="black" size="3">Your Name:</td><td align="left"><html:text property="name" size="40"/></td></tr>
         <tr><td width="155" valign="top"><font color="red" size="1">*</font> <font color="black" size="3">Your Email Address:</td><td align="left"><html:text property="emailid" size="40"/><br>
       <FONT STYLE="font-weight:bold;color:grey;font-size:10px;line-height:2;font-family: Arial, Helvetica, sans-serif;"> Please enter the e-mail address associated with your dancables.com account</font></td></tr>
        <tr><td width="125"><font color="red" size="1">*</font><font color="black" size="3">Phone Number:</td><td align="left"><html:text property="contactno" size="40"/></td></tr>
       
        <tr><td width="117"><font color="red" size="1">*</font><font color="black" size="3">Subject:</font></td>
<td align="left"><html:select property="sub" style="width:263px">
    <html:option value="Order Inquiry">Order Inquiry</html:option>
    <html:option value="Shiping Inquiry">Shiping Inquiry</html:option>
    <html:option value="Return and Exchange">Return and Exchange</html:option>
      <html:option value="Payment Inquiry">Payment Inquiry</html:option>
         <html:option value="Account Inquiry">Account Inquiry</html:option>
       <html:option value="Product Information and Availbility">Product Information and Availbility</html:option>
          <html:option value="General Feedback">General Feedback</html:option>
        </html:select>
        </td></tr>
        
        <tr><td width="127"><font color="red" size="1">*</font><font color="black" size="3">Message:</font></td><td align="left"><html:textarea property="msg" rows="6 " cols="30"/></td></tr>
<tr><td width="100"></td><td align="left"><html:submit /></td></tr>

           </html:form>  
  </table>   
 </td>
                           </tr></table></td>
               </tr>
   <tr>
          <td><%@include file="/footer.jsp"%></td>
                        </tr>  
    
  </table>   
      </td>
               </tr>
   
</table>
    
    </body>
</html>

