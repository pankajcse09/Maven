<%-- 
    Document   : dancable_Review_Order_connect2
    Created on : Oct 28, 2014, 2:28:39 PM
    Author     : kapil
--%>

<%@page import="java.util.Random"%>
<%@ include file="fdgg-util_sha2.jsp" %>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<HTML> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
        <title>Danceables Review Order</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/change.css" />
 <script language="javascript" src="<%=request.getContextPath()%>/css/menu.js"></script>
 <script language="javascript" src="<%=request.getContextPath()%>/css_js/resolution.js"></script>
 <script language="javascript" src="<%=request.getContextPath()%>/css_js/jquery.min.js"></script>
 <script>
$(document).ready(function(){
  $("#button").click(function(){
      var r;
    $.ajax({url:"<%=request.getContextPath()%>/Item/abc.jsp",success:function(result){
            r=result;
            //alert(r);
            if($.trim(r)=='eop'){
          window.location.href="<%=request.getContextPath()%>/er.do?vc=cs";
      }
      else{
      $("#vid_cdh").html(result);
      document.mainform.action="<%=request.getContextPath()%>/result.do"; 
      document.mainform.method="post";
      document.mainform.submit(); 
     }}});  
  });
});
</script>
    </head> 
     <body>
                 <%
       NumberFormat formatter = new DecimalFormat("#0.00");
    int tot_quantity=0;
double tot_amount=0.0;

//if(request.getAttribute("orderId")!=null){
             //orderId=(String)request.getAttribute("orderId");
         //}
Random randomGenerator = new Random();
    SimpleDateFormat sdf=new SimpleDateFormat("yyMMddHHmmss");
    java.util.Date dt=new java.util.Date();
    String orderId="";
    StringBuffer sb=new StringBuffer("OD");
    try{
    sb=sb.append(sdf.format(dt));
    sb=sb.append(Integer.toString(randomGenerator.nextInt(10000)));
    }catch(Exception e){
        int randomInt = randomGenerator.nextInt(1000);
      sb=sb.append(Integer.toString(randomInt));
      randomInt = randomGenerator.nextInt(1000);
      sb=sb.append(Integer.toString(randomInt));
      randomInt = randomGenerator.nextInt(1000);
      sb=sb.append(Integer.toString(randomInt));
      randomInt = randomGenerator.nextInt(1000);
      sb=sb.append(Integer.toString(randomInt));
    }
    orderId=sb.toString();
session.setAttribute("order_id", orderId);
session.setAttribute("e_email", request.getParameter("bill_email"));
//out.println("order_id: "+session.getAttribute("order_id"));
%>

<%if(request.getAttribute("tot_quantity")!=null)
{
    try{
    tot_quantity=Integer.parseInt(request.getAttribute("tot_quantity").toString());
     } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }  
    //out.println(tot_quantity);
}
%>


<% item_bean ship_bill=new item_bean();
if(request.getAttribute("ship_bill")!=null){
    ship_bill=(item_bean)request.getAttribute("ship_bill");
    //out.println(ship_bill);
    }
     
         double shipping_charge=0.0;
         if(request.getAttribute("shipping_charge")!=null){
             shipping_charge=Double.parseDouble((String)request.getAttribute("shipping_charge"));
         }
ArrayList itemlist=new ArrayList();
if( session.getAttribute("cart_list")!=null )
  {
      itemlist=(ArrayList)session.getAttribute("cart_list");    
  }else{
      itemlist=(ArrayList)request.getAttribute("cart_list");    
  }
        
  String shp_req="";
  if(request.getAttribute("shp_req")!=null){
      shp_req=(String)request.getAttribute("shp_req");
  }
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
                         <tr><td>

		 <form method="post" action="https://connect.firstdataglobalgateway.com/IPGConnect/gateway/processing" name="mainform">
                
			<table width="70%" border="0" align="center">
    
      <!-- connect 2.0 -->
      
            
  
          <%
          //out.println("ship_bill.getBill_method(): "+ship_bill.getBill_method());
          if(ship_bill.getBill_method().equals("Authorized")){
          session.setAttribute("txn_type", "sale");
          %>
                <input type="hidden" name="txntype" value="sale">  
                <input type="hidden" name="mode" value="payonly">
            <%}else if(ship_bill.getBill_method().equals("flatzone:USPS Media Mail")||ship_bill.getBill_method().equals("shipprod:Worldwide")||ship_bill.getBill_method().equals("sortship:Free Ground Shipping"))
            {
            session.setAttribute("txn_type", "sale");
            %>
                <input type="hidden" name="txntype" value="sale"> 
                <input type="hidden" name="mode" value="payonly">
                <%}else{
                if(!ship_bill.getKind().equals("download request")){
                RequestDispatcher  rd  = request.getRequestDispatcher("/er.do");
                request.setAttribute("vc", "You can only choose shipping method. You are not authorized to change the value of shipping method");
      rd.forward(request,response);
                }}%>
    <%if(ship_bill.getKind().equals("download request"))
    {
        session.setAttribute("txn_type", "sale");
    %>
        <input type="hidden" name="txntype" value="sale">
        <input type="hidden" name="mode" value="payonly">
    <%}%>
<input type="hidden" name="oid" value="<%=orderId%>">  
<%if(ship_bill.getKind().equals("download request")&&shp_req.equals("yes")){%>
<tr><td colspan="2"><font style="font-size:15px;color:#575351">You are making downloading request but printed music files will be shipped. So make sure your billing address is shipping address.</font></td></tr>
<%}%>
 
<tr><td align="left" valign="top" width="40%">	
<table align="center" bgcolor="white"  border="1" style="border-collapse: collapse" width="100%">
      <tr><td>S.no</td><td width="90">Pic</td><td>Price</td><td>Quantity</td><td>Subtotal</td></tr>
      <%for(int i=0;i<itemlist.size();i++)
      {
          item_bean ib=(item_bean)itemlist.get(i);
          tot_amount=tot_amount+ib.getSubtotal();
      %>
      <tr><td><%=i+1%></td><td width="90"><img src="./music_image/<%=ib.getFilename()%>" width="90" height="80"/>
      </td>
      <td><%=formatter.format(ib.getPrice())%></td>
      <td><%=ib.getQuantity()%></td>
      <td><%=formatter.format(ib.getSubtotal())%></td>
      </tr>
     <%}
     %>
     <%if(shp_req.equals("yes")){%>
      <tr><td colspan="4" align="right">Shipping Charge:</td><td><%=formatter.format(shipping_charge)%></td></tr>
      <%}%>
      <tr><td colspan="4" align="right">Total Amount:</td><td><%=formatter.format(tot_amount+shipping_charge)%></td></tr>
  </table>
  
  <% 
        String x_amount=Double.toString(tot_amount+shipping_charge);
        String storename = getStoreName(); 
        String calculatedHash = createHash(x_amount); 
        String txnDateTime = getFormattedSysDate(); 
        String timeZone = getTimeZone(); %>
            <input type="hidden" name="storename" value="<%=storename%>">
            <input type="hidden" name="chargetotal" value="<%=x_amount%>">
            
            <input type="hidden" name="trxOrigin" value="ECI">    
            <input type="hidden" name="subtotal" value="<%=tot_amount%>">
            <input type="hidden" name="shipping" value="<%=shipping_charge%>">
            <input type="hidden" name="timezone" value="<%=timeZone%>"/>
            <input size="50" type="hidden" name="txndatetime" value="<%=txnDateTime%>" /> 
            <input size="50" type="hidden" name="hash" value="<%=calculatedHash%>" />
            <input type="hidden" name="identifier" value="true" />                                   
    </td>
					
<td valign="top" width="60%">
    <table border="0" width="100%"><tr>
      <%if(!ship_bill.getKind().equals("download request")){%>
      <td valign="top"><table>
            <tr><td align="left"><FONT STYLE="font-weight:bold;color:#221100;font-size:15px">Shipping Details</font></td></tr>
        <tr><td align="left"><FONT STYLE="font-weight:bold;color:#AE1E04;font-size:12px">Name:</font></td>
<td align="left"><FONT STYLE="font-weight:bold;color:#221100;font-size:10px"><%=ship_bill.getShip_f_name()%>&nbsp;<%=ship_bill.getShip_l_name()%></td></tr>
        <tr><td align="left"><FONT STYLE="font-weight:bold;color:#AE1E04;font-size:12px">Street Address:</font></td>
<td align="left"><FONT STYLE="font-weight:bold;color:#221100;font-size:10px"><%=ship_bill.getShip_street()%></td></tr>
        <tr><td align="left"><FONT STYLE="font-weight:bold;color:#AE1E04;font-size:12px">City</font></td>
<td align="left"><FONT STYLE="font-weight:bold;color:#221100;font-size:10px"><%=ship_bill.getShip_city()%></td></tr>
     <tr><td align="left"><FONT STYLE="font-weight:bold;color:#AE1E04;font-size:12px">State</font></td>
<td align="left"><FONT STYLE="font-weight:bold;color:#221100;font-size:10px"><%=ship_bill.getShip_state()%></td></tr>
     <tr><td align="left"><FONT STYLE="font-weight:bold;color:#AE1E04;font-size:12px">Zipcode</font></td>
<td align="left"><FONT STYLE="font-weight:bold;color:#221100;font-size:10px"><%=ship_bill.getShip_zip()%></td></tr> 
<tr><td align="left"><FONT STYLE="font-weight:bold;color:#AE1E04;font-size:12px">Country</font></td>
<td align="left"><FONT STYLE="font-weight:bold;color:#221100;font-size:10px"><%=ship_bill.getShip_country()%></td></tr>
 <tr><td align="left"><FONT STYLE="font-weight:bold;color:#AE1E04;font-size:12px">Phone</font></td>
<td align="left"><FONT STYLE="font-weight:bold;color:#221100;font-size:10px">&nbsp;<%=ship_bill.getShip_phone()%></td></tr>
        <tr><td align="left"><FONT STYLE="font-weight:bold;color:#AE1E04;font-size:12px">Shipping Method:</font></td>
<td align="left"><FONT STYLE="font-weight:bold;color:#221100;font-size:10px"><%=ship_bill.getShip_method()%></td></tr>
     </table></td>
     <%}%>
    <td valign="top"><table>
                    <tr><td align="left"><FONT STYLE="font-weight:bold;color:#221100;font-size:15px">Billing Address</font></td></tr>
        <tr><td align="left"><FONT STYLE="font-weight:bold;color:#AE1E04;font-size:12px">Name:</font></td>
<td align="left"><FONT STYLE="font-weight:bold;color:#221100;font-size:10px"><%=ship_bill.getBill_f_name()%>&nbsp;<%=ship_bill.getBill_l_name()%></td></tr>
        <tr><td align="left"><FONT STYLE="font-weight:bold;color:#AE1E04;font-size:12px">Street Address:</font></td>
<td align="left"><FONT STYLE="font-weight:bold;color:#221100;font-size:10px"><%=ship_bill.getBill_street()%></td></tr>
        <tr><td align="left"><FONT STYLE="font-weight:bold;color:#AE1E04;font-size:12px">City</font></td>
<td align="left"><FONT STYLE="font-weight:bold;color:#221100;font-size:10px"><%=ship_bill.getBill_city()%></td></tr>
     <tr><td align="left"><FONT STYLE="font-weight:bold;color:#AE1E04;font-size:12px">State</font></td>
<td align="left"><FONT STYLE="font-weight:bold;color:#221100;font-size:10px">
  <%if(ship_bill.getBill_state().equals("52"))
  {
      out.println(ship_bill.getBill_state2());
}else{
      out.println(ship_bill.getBill_state());
}%>  
</td></tr>
     <tr><td align="left"><FONT STYLE="font-weight:bold;color:#AE1E04;font-size:12px">Zipcode</font></td>
<td align="left"><FONT STYLE="font-weight:bold;color:#221100;font-size:10px"><%=ship_bill.getBill_zip()%></td></tr>
     <tr><td align="left"><FONT STYLE="font-weight:bold;color:#AE1E04;font-size:12px">Country</font></td>
<td align="left"><FONT STYLE="font-weight:bold;color:#221100;font-size:10px">
    <%if(ship_bill.getBill_country().equals("United States")||ship_bill.getBill_country().equals("Canada"))
    {
        out.println(ship_bill.getBill_country());
}else{
        out.println(ship_bill.getBill_country2());
}
%>
</td></tr>
     <tr><td align="left"><FONT STYLE="font-weight:bold;color:#AE1E04;font-size:12px">Phone</font></td>
<td align="left"><FONT STYLE="font-weight:bold;color:#221100;font-size:10px">&nbsp;<%=ship_bill.getBill_phone()%></td></tr>
     <%if(!ship_bill.getKind().equals("download request")){%>                
        <tr><td align="left"><FONT STYLE="font-weight:bold;color:#AE1E04;font-size:12px">Shipping Method:</font></td>
<td align="left"><FONT STYLE="font-weight:bold;color:#221100;font-size:10px"><%=ship_bill.getBill_method()%></td></tr>
                    <%}%>
       <tr><td align="left"><FONT STYLE="font-weight:bold;color:#AE1E04;font-size:12px">Email</font></td>
<td align="left"><FONT STYLE="font-weight:bold;color:#221100;font-size:10px">&nbsp;<%=session.getAttribute("e_email")%></td></tr>             
     </table></td>
       <div id="vid_cdh"></div>
        </tr>
        
    <!--<tr><td><img src="./img/paypal-checkout.png" onclick="item_order()"/></td></tr>-->
    
                                        </table></td></tr>
                                        
                                        <tr><td colspan="2">
                                            <table>

                                                                                                                                          
                                 <tr><td colspan="2"><input type="button" value="Continue to Secure Payment Form" id="button">
                                     </td></tr>
               
                                            </table>
                                        </td>
                                        </tr>
                                        
                                            </table>
     </form>
					</td>	
					
					</tr>
                     		
				
	</table>
        
                             </td></tr>  
                         <tr><td>
<%@include file="/footer.jsp"%>
  </td>
               </tr>
   
</table>
</body>
</html>