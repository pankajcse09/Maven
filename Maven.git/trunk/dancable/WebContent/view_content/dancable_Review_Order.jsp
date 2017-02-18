<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@page import ="Main_category.item_bean"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.*"%>
<%@page import="java.sql.Timestamp"%>
<%@ page import="java.util.Random" %>
<%@ page import="javax.crypto.Mac" %>
<%@ page import="javax.crypto.SecretKey" %>
<%@ page import="javax.crypto.spec.SecretKeySpec" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dancable</title>
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/change.css" />
        <script language="javascript" src="<%=request.getContextPath()%>/css/menu.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/css_js/resolution.js"></script>
                <script language="javascript">
            
            
            function validate()
            {
                if(document.forms[0].x_email.value==""){    
    alert("Enter Email Id for receiving confermation mail.");
    document.forms[0].x_email.focus();
    return false;        
    } 
    return true;
            }
            
            function item_orderbyCard()
            {
            
       document.forms[0].method="POST";
       document.forms[0].action="Tea_Order"
       document.forms[0].submit();

            }
            
            </script>
            <script language="javascript">
            
            
            
            </script>
</head>
<body>

    <%
       NumberFormat formatter = new DecimalFormat("#0.00");
    int tot_quantity=0;
double tot_amount=0.0;
String orderId="";
if(request.getAttribute("orderId")!=null){
             orderId=(String)request.getAttribute("orderId");
         }
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

<%if(request.getAttribute("tot_amount")!=null){
    try{
    tot_amount=Double.parseDouble(request.getAttribute("tot_amount").toString());
     } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }  
   // out.println(tot_amount);
}
%>

<% item_bean ship_bill=new item_bean();
List ar2=new ArrayList();
        Map hm1=new HashMap();
        Map hm2=new HashMap();
        Map hm3=new HashMap();       
         Map hm4=new HashMap(); 
          Map hm5=new HashMap(); 
%>
    <%if(request.getAttribute("ship_bill")!=null){
    ship_bill=(item_bean)request.getAttribute("ship_bill");
    //out.println(ship_bill);
    
    }%>
     <%if(request.getAttribute("ar2")!=null){
    ar2=(ArrayList)request.getAttribute("ar2");
    //out.println(ar2);
    
    }%>
    <%if(request.getAttribute("hm1")!=null){
    hm1=(HashMap)request.getAttribute("hm1");
   // out.println(hm1);
    
    }%>
    <%if(request.getAttribute("hm2")!=null){
    hm2=(HashMap)request.getAttribute("hm2");
   // out.println(hm2);
    
    }%>
    <%if(request.getAttribute("hm3")!=null){
    hm3=(HashMap)request.getAttribute("hm3");
  //  out.println(hm3);
    
    }%>
    <%if(request.getAttribute("hm4")!=null){
    hm4=(HashMap)request.getAttribute("hm4");
  //  out.println(hm4);
    }
    
    if(request.getAttribute("hm5")!=null){
    hm5=(HashMap)request.getAttribute("hm5");
    
    }
     
         double shipping_charge=0.0;
         if(request.getAttribute("shipping_charge")!=null){
             shipping_charge=Double.parseDouble((String)request.getAttribute("shipping_charge"));
         }
         ArrayList all=new ArrayList();
         all=(ArrayList)session.getAttribute("cart_list");
         //out.println(all);
        String e_id="";
        if(session.getAttribute("loginid")!=null)
        {
         e_id=(String)session.getAttribute("loginid");
                 }
     %>
<%
// x_login and transactionKey should be taken from Payment Page settings
String x_login        = "HCO-AZANS-438"; // aka Payment Page ID
String transactionKey = "U6BnGncKJoJnWhPxTw2g"; // aka Transaction Key
String x_amount       = Double.toString(tot_amount+shipping_charge);

// Generate a random sequence number
Random generator = new Random();
int x_fp_sequence = generator.nextInt(100000);

// Generate the timestamp
// Make sure this will be in UTC
long x_fp_timestamp = System.currentTimeMillis()/1000;

// Use Java Cryptography functions to generate the x_fp_hash value
// generate secret key for HMAC-SHA1 using the transaction key
SecretKey key = new SecretKeySpec(transactionKey.getBytes(), "HmacMD5");

// Get instance of Mac object implementing HMAC-SHA1, and
// Initialize it with the above secret key
Mac mac = Mac.getInstance("HmacMD5");
mac.init(key);

// process the input string
String inputstring = x_login + "^" + x_fp_sequence + "^" +
x_fp_timestamp + "^" + x_amount + "^";
byte[] result = mac.doFinal(inputstring.getBytes());

// convert the result from byte[] to hexadecimal format
StringBuffer strbuf = new StringBuffer(result.length * 2);
for(int i=0; i< result.length; i++)
   {
       if(((int) result[i] & 0xff) < 0x10)
           strbuf.append("0");
       strbuf.append(Long.toString((int) result[i] & 0xff, 16));
   }
String x_fp_hash = strbuf.toString();
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

		 <!--<form method="post" action="https://demo.globalgatewaye4.firstdata.com/payment" onsubmit="return validate()">-->
                 <form method="post" action="<%=request.getContextPath()%>/result.do" onsubmit="return validate()">
			<table width="70%" border="0" align="center">

  <input name="x_login" value="<%= x_login %>" type="hidden"> 
  <input name="x_amount" value="<%= x_amount %>" type="hidden"> 
  <input name="x_fp_sequence" value="<%= x_fp_sequence %>" type="hidden"> 
  <input name="x_fp_timestamp" value="<%= x_fp_timestamp %>" type="hidden"> 
  <input name="x_fp_hash" value="<%= x_fp_hash %>" type="hidden"> 
  <input name="x_show_form" value="PAYMENT_FORM" type="hidden"> 
      
   
 <!-- <input name="x_tax" value="0.00" type="hidden"> -->
  <input name="x_freight" value="<%= shipping_charge %>" type="hidden"> 
      <input type="hidden" name="x_gateway_id" value="AE1327-05">
          <%if(ship_bill.getBill_method().equals("Authorized")){%>
	<input type="hidden" name="x_type" value="AUTH_ONLY">	
            <%}else if(ship_bill.getBill_method().equals("flatzone:USPS Media Mail")||ship_bill.getBill_method().equals("shipprod:Worldwide")||ship_bill.getBill_method().equals("sortship:Free Ground Shipping")){%>
            <input type="hidden" name="x_type" value="AUTH_CAPTURE">
                <%}else{
                if(!ship_bill.getKind().equals("download request")){
                RequestDispatcher  rd  = request.getRequestDispatcher("/er.do");
                request.setAttribute("msg", "You can only choose shipping method. You are not authorized to change the value of shipping method");
      rd.forward(request,response);
                }}%>
       <input type="hidden" name="x_test_request" value="TRUE">                                 
	<input type="hidden" name="x_currency_code" value="USD">    
    <!--  <input type="hidden" name="transaction_type" value="01"> -->
   <!--     <input type="hidden" name="Ecommerce_flag" value="ECI Indicator – Secure Electronic Commerce Transaction">  -->  
  <!-- <input type="hidden" name="x_merchant_email" value="kapilsaini2009@gmail.com"> 
       <input type="hidden" name="x_email_customer" value="TRUE"> -->
    
<input type="hidden" name="x_cust_id" value="<%=orderId%>">
    <input type="hidden" name="x_invoice_num" value="<%=orderId%>">
         <input type="hidden" name="x_po_num" value="<%=orderId%>"> 
      <input type="hidden" name="x_logo_url" value="http://www.inttrack.com/dancables/images/homepage/logo_03.png">   
    
 <!--    <input type="hidden" name="x_relay_response" value="TRUE"> 
     <input type="hidden" name="x_relay_url" value="http://www.inttrack.com/dancables/fm_home.do?name=home">     -->
         
    
					<tr><td align="left" valign="top" width="40%">	

<table align="center" bgcolor="white"  border="1" style="border-collapse: collapse" width="100%">
      <tr><td>S.no</td><td width="90">Pic</td><td>Price</td><td>Quantity</td><td>Subtotal</td></tr>
      <%for(int i=0;i<ar2.size();i++){%>
      
      <tr><td><%=i+1%></td><td width="90"><img src="./music_image/<%=hm4.get(ar2.get(i))%>" width="90" height="80"/>
      </td>
      <td><%=formatter.format(Double.parseDouble(hm1.get(ar2.get(i)).toString()))%></td>
      <td><%=hm2.get(ar2.get(i))%></td>
      <td><%=formatter.format(Double.parseDouble(hm3.get(ar2.get(i)).toString()))%></td>
      
      </tr>
      
             
                   
       
    <input name="x_line_item" value="<%=hm2.get(ar2.get(i))%><|><%=hm5.get(ar2.get(i))%><|><%=hm5.get(ar2.get(i))%><|><%=hm2.get(ar2.get(i))%><|><%=hm1.get(ar2.get(i))%><|>YES" type="hidden">  
    
      <%}%>
       <%if(!ship_bill.getKind().equals("download request")){%>
      <tr><td colspan="4" align="right">Shipping Charge:</td><td><%=formatter.format(shipping_charge)%></td></tr>
      <%}%>
      <tr><td colspan="4" align="right">Total Amount:</td><td><%=formatter.format(tot_amount+shipping_charge)%></td></tr>
  </table>
                                        
                                        
				</td>
					
					<td valign="top" width="60%">
                                            <table border="0" width="100%"><tr>
                                                    <%if(!ship_bill.getKind().equals("download request")){%>
                                                    <td><table>
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
    <td><table>
                    <tr><td align="left"><FONT STYLE="font-weight:bold;color:#221100;font-size:15px">Billing Address</font></td></tr>
        <tr><td align="left"><FONT STYLE="font-weight:bold;color:#AE1E04;font-size:12px">Name:</font></td>
<td align="left"><FONT STYLE="font-weight:bold;color:#221100;font-size:10px"><%=ship_bill.getBill_f_name()%>&nbsp;<%=ship_bill.getBill_l_name()%></td></tr>
        <tr><td align="left"><FONT STYLE="font-weight:bold;color:#AE1E04;font-size:12px">Street Address:</font></td>
<td align="left"><FONT STYLE="font-weight:bold;color:#221100;font-size:10px"><%=ship_bill.getBill_street()%></td></tr>
        <tr><td align="left"><FONT STYLE="font-weight:bold;color:#AE1E04;font-size:12px">City</font></td>
<td align="left"><FONT STYLE="font-weight:bold;color:#221100;font-size:10px"><%=ship_bill.getBill_city()%></td></tr>
     <tr><td align="left"><FONT STYLE="font-weight:bold;color:#AE1E04;font-size:12px">State</font></td>
<td align="left"><FONT STYLE="font-weight:bold;color:#221100;font-size:10px"><%=ship_bill.getBill_state()%></td></tr>
     <tr><td align="left"><FONT STYLE="font-weight:bold;color:#AE1E04;font-size:12px">Zipcode</font></td>
<td align="left"><FONT STYLE="font-weight:bold;color:#221100;font-size:10px"><%=ship_bill.getBill_zip()%></td></tr>
     <tr><td align="left"><FONT STYLE="font-weight:bold;color:#AE1E04;font-size:12px">Country</font></td>
<td align="left"><FONT STYLE="font-weight:bold;color:#221100;font-size:10px"><%=ship_bill.getBill_country()%></td></tr>
     <tr><td align="left"><FONT STYLE="font-weight:bold;color:#AE1E04;font-size:12px">Phone</font></td>
<td align="left"><FONT STYLE="font-weight:bold;color:#221100;font-size:10px">&nbsp;<%=ship_bill.getBill_phone()%></td></tr>
     <%if(!ship_bill.getKind().equals("download request")){%>                
        <tr><td align="left"><FONT STYLE="font-weight:bold;color:#AE1E04;font-size:12px">Shipping Method:</font></td>
<td align="left"><FONT STYLE="font-weight:bold;color:#221100;font-size:10px"><%=ship_bill.getBill_method()%></td></tr>
                    <%}%>
     </table></td>
        </tr>
               
        
        
    <%if(!ship_bill.getBill_method().equals("Pre Authorized")){%>    
      <input type="hidden" name="x_ship_to_first_name" value="<%=ship_bill.getShip_f_name()%>">
        <input type="hidden" name="x_ship_to_last_name" value="<%=ship_bill.getShip_l_name()%>">
        <input type="hidden" name="x_ship_to_address" value="<%=ship_bill.getShip_street()%>">
        <input type="hidden" name="x_ship_to_city" value="<%=ship_bill.getShip_city()%>">
        <input type="hidden" name="x_ship_to_state" value="<%=ship_bill.getShip_state()%>">
        <input type="hidden" name="x_ship_to_zip" value="<%=ship_bill.getShip_zip()%>">
        <input type="hidden" name="x_ship_to_country" value="<%=ship_bill.getShip_country()%>">
        <%}%>
        
       <!-- Billing Address -->
         <input type="hidden" name="x_first_name" value="<%=ship_bill.getBill_f_name()%>">
        <input type="hidden" name="x_last_name" value="<%=ship_bill.getBill_l_name()%>">
<input type="hidden" name="x_address" value="<%=ship_bill.getBill_street()%>">
<input type="hidden" name="x_city" value="<%=ship_bill.getBill_city()%>">
<input type="hidden" name="x_state" value="<%=ship_bill.getBill_state()%>">
<input type="hidden" name="x_zip" value="<%=ship_bill.getBill_zip()%>">
<input type="hidden" name="x_country" value="<%=ship_bill.getBill_country()%>">
<input type="hidden" name="x_phone" value="<%=ship_bill.getBill_phone()%>">
       
     
        
        
        
        
        
        
        
        
        
                             <tr><td colspan="2"><table>
 <%if(!e_id.equals("guest")){
 %>
<input type="hidden" name="x_email" value="<%=e_id%>" size="40" />
 <%}else{
 %>
                                <tr><td><FONT STYLE="font-weight:bold;color:#orange;font-size:15px"> 
Email ID:</font><input type="text" name="x_email" value="" size="40" /></td></tr>
             <%}%>                            
    <!--<tr><td><img src="./img/paypal-checkout.png" onclick="item_order()"/></td></tr>-->
    
                                        </table></td></tr>
                                        
                                        <tr><td colspan="2">
                                            <table>

                                                                                                                                          
                                 <tr><td colspan="2"><input value="Checkout" type="submit"></td></tr>
               
                                            </table>
                                        </td>
                                        </tr>
                                        
                                            </table>
					</td>	
					
					</tr>
                     		
				
	</table>
        </form>
                             </td></tr>  
                         <tr><td>
<%@include file="/footer.jsp"%>
  </td>
               </tr>
   
</table>
</body>
</html>