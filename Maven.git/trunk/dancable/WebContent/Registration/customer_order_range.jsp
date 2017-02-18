<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@page import ="Main_category.item_bean"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@page import="java.sql.Timestamp"%>

   <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danceables</title>
        <script language="javascript" src="css_js/resolution.js"></script>
        <link rel="stylesheet" type="text/css" href="css/change.css" />
        <script language="javascript" src="css/menu.js"></script>
    <script language="javascript" src="<%=request.getContextPath()%>/view_content/calendarDateInput.js"></script>
   
    </head>
      

    <body>

  <%String username= (String)session.getAttribute("loginid");%>
  
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
                    <table background="<%=request.getContextPath()%>/images/CD for ballet/grey-bar.png" width="100%" border="0">
                        <tr valign="top">
                            <td class="cel" width="253" align="right">
                               <img src="<%=request.getContextPath()%>/images/homepage/logo_03.png" width="253">
                            </td>
                            <td class="cel1" width="750" align="left"><%@include file="/top_menu.jsp"%></td>
                         </tr>
                    </table>
                </td>
            </tr>
            
        <tr><td background="<%=request.getContextPath()%>/images/homepage/bottom grey.png" width="100%" height="100%" valign="top">
                <table border="0" width="75%" ALIGN="CENTER" height="350">
                   
 <tr align="left">
<td VALIGN="TOP" width="20%" STYLE="PADDING-TOP:20PX">
  <table>
        <tr><td>Useful Links</td></tr>
        <tr><td><a href="Customer_ViewRegistration.do?method=viewCustomerRegist" style="text-decoration:none;color:grey">View Profile</a></td></tr>
        <tr><td><a href="Customer_EditRegistration.do?method=editCustomerRegist" style="text-decoration:none;color:grey">Update Profile</a></td></tr>
       <tr><td><a href="customer_order_range.do" style="text-decoration:none;color:grey">View Order</a></td></tr>
       <tr><td><a href="<%=request.getContextPath()%>/customer_logout.do?method=customer_logout" style="text-decoration:none;color:grey">Logout</a></td></tr>
      </table>
</td>

<td VALIGN="TOP"><table VALIGN="TOP">
<tr><td><table  border="0" VALIGN="TOP">
    <tr><td STYLE="font-weight:bold;color:black;font-size:14px" align="center" height="40">Welcome&nbsp;'<%=username%>'</td></tr>

</table></td></tr>
                    
                    
                    
                    
                    <tr><td valign="top">         
     <%
    
             if((item_bean)request.getAttribute("item_list")!=null)
    {
    NumberFormat formatter = new DecimalFormat("#0.00");
     String unit="";
  String status="";
   String brand="";
    String prod_id="";
   double price=0.0;
   String size="";    
   int subcat_id=0;
   String filename="";  
     String detail="";
    double marketprice=0.0;
      double discount=0.0;
       String discountdetail="";
      String image="";
   int itemid=0;
   double total=0.0;
   item_bean itmb=new item_bean();
          item_bean itembe=new item_bean();
          item_bean itb=new item_bean();
          ArrayList itemlist=new ArrayList();
          ArrayList address=new ArrayList();
          ArrayList user_cart=new ArrayList();
    itmb=(item_bean)request.getAttribute("item_list");
    itemlist=itmb.getDataArray();
    user_cart=itmb.getDataArray();
    address=itmb.getDataArray1();
  String usernam= (String)session.getAttribute("loginid");
 
 %>
        <%java.util.Date Dates=null;
      SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy"); %>  
 
 
 
 
  <table width="100%" border="0">
                    <tr><td width="10%" align="left"><img src="<%=request.getContextPath()%>/images/homepage/logo_03.png" width="100%"></td>
<td valign="top" align="left">Contact Us: 917-656-5290 || danceables@hotmail.com  <br>
P O Box 230185, New York, NY 10023
</td>
</tr>
<tr><td colspan="2"><hr></td></tr>
    <% if(address.size()!=0){
    itb=(item_bean)address.get(0);
%>
<tr><td colspan="2" width="100%">
    <table width="100%">
        <tr align="left">
            <td valign="top" width="40%"><table>
                <tr><td><b>User ID:</b> <%=request.getParameter("userid")%></td></tr>
<tr><td><b>Order ID:</b> <%=itb.getOrder_id()%></td></tr>
<tr><td><b>Order Date:</b> <%=sdf.format(itb.getOrder_date())%></td></tr>
            </table></td>
            <!--<td valign="top" width="33%"><table>
<tr><td><b>Billing Address</b></td></tr>
<tr><td>
    <%=itb.getBill_f_name()+" "+itb.getBill_l_name()%><br>
    <%=itb.getBill_street()+", "%><%=itb.getBill_city()+","%><br>
    <%=itb.getBill_zip()+", "%><%=itb.getBill_state()+","%><br>
    <%=itb.getBill_country()%><br>
    Phone: <%=itb.getBill_phone()%><br>
</td></tr>
            </table></td>-->
            <td valign="top"><table>
<tr><td><b>Shipping Address</b></td></tr>
<tr><td>
    <%=itb.getShip_f_name()+" "+itb.getShip_l_name()%><br>
    <%=itb.getShip_street()+", "%><%=itb.getShip_city()+","%>
    <%=itb.getShip_zip()+", "%><%=itb.getShip_state()+","%>
    <%=itb.getShip_country()%><br>
    Phone: <%=itb.getShip_phone()%><br>
</td></tr>
            </table></td>
            
        </tr>
    </table>
</td></tr>
        <%}%>
<tr><td colspan="2"><hr></td></tr>

<tr><td colspan="2" width="100%">
    <table width="100%" border="1" style="border-collapse: collapse">

<tr><td><b>Product</b></td><td><b>Pic</b></td><td><b>Product Id</b></td><td align="right"><b>Size</b></td>
    <td align="right"><b>Quantity</b></td><td align="right"><b>Price</b></td><td align="right"><b>Total</b></td></tr>

<%
int itm=0;
double pr=0.00;
double prt=0.00;
double shp=0.00;
if(user_cart.size()!=0){
                    for(int k=0;k<user_cart.size();k++)
                    {
                    item_bean itbm=(item_bean)user_cart.get(k);
                    itm=itm+itbm.getQuantity();
                    shp=itbm.getShip_charge();
                    pr=pr+itbm.getPrice();
                    prt=prt+itbm.getSubtotal();
                    filename=itbm.getFilename();   
 image="./Tea_image/"+filename;
%>
<tr><td><%=itbm.getBrand()%></td>
<td><img src="<%=image%>" width="70" height="70"></td>
<td><%=itbm.getProd_id()%></td>
<td align="right"><%=itbm.getSize()%></td>
<td align="right"><%=itbm.getQuantity()%></td>
<td align="right"><%=formatter.format(itbm.getPrice())%></td>
<td align="right"><%=formatter.format(itbm.getSubtotal())%></td>
    </tr>
   
    <%}}%>
    <tr><td align="right" colspan="4"><b>Total</b></td><td align="right"><b><%=itm%></b></td><td align="right"><b><%=formatter.format(pr)%></b></td><td align="right"><b><%=formatter.format(prt)%></b></td></tr>
   
    <tr><td colspan="6" align="right"><b>Shipping Charge</b></td><td align="right"><b><%=formatter.format(shp)%></b></td></tr>
    <tr><td colspan="6" align="right"><b>Grand Total</b></td><td align="right"><b><%=formatter.format(prt+shp)%></b></td></tr>
    
    </table>
</td></tr>
                </table>
      <%}%>
  </td></tr>
                  

                   
</table></td></tr>


 <tr><td colspan="2"><%@include file="/footer.jsp"%></td></tr>
               </table></td></tr>
        </table>
    </body>
</html>