<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@page import ="Main_category.item_bean"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.*"%>
<%@page import="java.sql.Timestamp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PayPal SDK - SetExpressCheckout</title>
 <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/pro_drop_1/laycss.css" />
         <link rel="stylesheet" type="text/css" href="prop_drop/pro_drop.css" />
            <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/kk/ts.css" />
                 <script language="javascript" src="kk/resolution.js">
                </script>
                <script language="javascript">
            function item_order()
            {
            
       document.forms[0].method="POST";
       document.forms[0].action="Alessio_Order"
       document.forms[0].submit();

            }
            
            
            </script>
            <script language="javascript">
            function item_orderbyCard()
            {
            
       document.forms[0].method="POST";
       document.forms[0].action="Alessio_Order_byCard"
       document.forms[0].submit();

            }
            
            
            </script>
</head>
<body>

    <%
       
    int tot_quantity=0;
double tot_amount=0.0;

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
     
         double shipping_charge=0.0;
         if(request.getAttribute("shipping_charge")!=null){
             shipping_charge=Double.parseDouble((String)request.getAttribute("shipping_charge"));
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

<div id="container" align="center">
    <div id="cont_1">
 <%@include file="/head.jsp"%>
    </div>
     <div style="clear: both" ></div>
   <div bgcolor="#ffffff">
       <table id="tbl" width="100%" align="center">
            <tr><td align="center">
                <%@include file="/Top_menu.jsp"%>
            </td></tr>
        </table> 
    </div>  
        <div class="clear"></div>
		<form method="POST" action="Alessio_Order">
			<table>
				
						
					
				<input type="hidden" name="noShipping"
							value="0"  />
					
                                       
                                                
                                                
				
				
						<input type="hidden" name="shippingTotal" id="shippingTotal" value="<%=shipping_charge%>" />
					
				
				
						<input type="hidden"  name="insuranceTotal" id="insuranceTotal" value="" />
					
				
                              
						<input type="hidden"  name="handlingTotal" id="handlingTotal" value="" />
					
				 
                                
				
						<input type="hidden" name="taxTotal" id="taxTotal" value="" />
					
                                        <input type="hidden" name="orderDescription" id="orderDescription" value="" />
					
				
				
					
						<input type="hidden" name="currencyCode" value="USD" /></td></tr>
							
					<input type="hidden" name="paymentType" value="Sale" /><td></tr>
				
					
				
				
				

					

					
								<input type="hidden" name="itemName" id="itemName"
									value="Jewelry" />
						

						
								<input type="hidden" name="itemAmount" id="itemAmount"
									value="<%=tot_amount%>" />
							

						
								<input type="hidden" name="itemQuantity" id="itemQuantity"
									value="<%=tot_quantity%>" />
							

						
								<input type="hidden" name="hidden" id="salesTax" value="" />
							
<input type="hidden" name="itemCategory"  value="Physical" />
							
						

						
								<input type="hidden" name="itemDescription" id="itemDescription"
									value="" />
							
					
                                        
					

					<tr><td align=center valign="top">	

<table align="center" bgcolor="white"  border="1">
      <tr><td>S.no</td><td>Pic</td><td>Price</td><td>Quantity</td><td>Subtotal</td><td></td></tr>
      <%for(int i=0;i<ar2.size();i++){%>
      
      <tr><td><%=i+1%></td><td><img src="./Tea_image/<%=hm4.get(ar2.get(i))%>" width="50" height="70"/>
      </td>
      <td><%=hm1.get(ar2.get(i))%></td>
      <td><%=hm2.get(ar2.get(i))%></td>
      <td><%=hm3.get(ar2.get(i))%></td>
      
      </tr>
      
             
    <input type="hidden" name="filena<%=i%>" value="<%=hm4.get(ar2.get(i))%>" ></td>     
    <input type="hidden" name="pric<%=i%>" value="<%=hm1.get(ar2.get(i))%>" ></td>     
    <input type="hidden" name="quantity<%=i%>" value="<%=hm2.get(ar2.get(i))%>" ></td>     
    <input type="hidden" name="subtotal<%=i%>" value="<%=hm3.get(ar2.get(i))%>" ></td>     
      <input type="hidden" name="cartid<%=i%>" value="<%=ar2.get(i)%>" ></td>     
       
    
    
      <%}%>
      <tr><td colspan="4" align="right">Total Amount:</td><td><%=tot_amount%></td></tr>
  </table>
                                        
                                        
				</td>
					
					<td valign="top">
                                            <table><tr><td><table>
            <tr><td><FONT STYLE="font-weight:bold;color:#221100;font-size:15px">Shipping Details</font></td></tr>
        <tr><td><FONT STYLE="font-weight:bold;color:orange;font-size:12px">Name:</font></td>
<td><FONT STYLE="font-weight:bold;color:#221100;font-size:10px"><%=ship_bill.getShip_f_name()%>&nbsp;<%=ship_bill.getShip_l_name()%></td></tr>
        <tr><td><FONT STYLE="font-weight:bold;color:orange;font-size:12px">Street Address:</font></td>
<td><FONT STYLE="font-weight:bold;color:#221100;font-size:10px"><%=ship_bill.getShip_street()%></td></tr>
        <tr><td><FONT STYLE="font-weight:bold;color:orange;font-size:12px">City</font></td>
<td><FONT STYLE="font-weight:bold;color:#221100;font-size:10px"><%=ship_bill.getShip_city()%></td></tr>
     <tr><td><FONT STYLE="font-weight:bold;color:orange;font-size:12px">State</font></td>
<td><FONT STYLE="font-weight:bold;color:#221100;font-size:10px"><%=ship_bill.getShip_state()%></td></tr>
     <tr><td><FONT STYLE="font-weight:bold;color:orange;font-size:12px">Zipcode</font></td>
<td><FONT STYLE="font-weight:bold;color:#221100;font-size:10px"><%=ship_bill.getShip_zip()%></td></tr> 
<tr><td><FONT STYLE="font-weight:bold;color:orange;font-size:12px">Country</font></td>
<td><FONT STYLE="font-weight:bold;color:#221100;font-size:10px"><%=ship_bill.getShip_country()%></td></tr>
 <tr><td><FONT STYLE="font-weight:bold;color:orange;font-size:12px">Phone</font></td>
<td><FONT STYLE="font-weight:bold;color:#221100;font-size:10px">&nbsp;<%=ship_bill.getShip_phone()%></td></tr>
        <tr><td><FONT STYLE="font-weight:bold;color:orange;font-size:12px">Shipping Method:</font></td>
<td><FONT STYLE="font-weight:bold;color:#221100;font-size:10px"><%=ship_bill.getShip_method()%></td></tr>
     </table></td>
        </tr>
               <tr><td><table>
                    <tr><td><FONT STYLE="font-weight:bold;color:#221100;font-size:15px">Billing Address</font></td></tr>
        <tr><td><FONT STYLE="font-weight:bold;color:orange;font-size:12px">Name:</font></td>
<td><FONT STYLE="font-weight:bold;color:#221100;font-size:10px"><%=ship_bill.getBill_f_name()%>&nbsp;<%=ship_bill.getBill_l_name()%></td></tr>
        <tr><td><FONT STYLE="font-weight:bold;color:orange;font-size:12px">Street Address:</font></td>
<td><FONT STYLE="font-weight:bold;color:#221100;font-size:10px"><%=ship_bill.getBill_street()%></td></tr>
        <tr><td><FONT STYLE="font-weight:bold;color:orange;font-size:12px">City</font></td>
<td><FONT STYLE="font-weight:bold;color:#221100;font-size:10px"><%=ship_bill.getBill_city()%></td></tr>
     <tr><td><FONT STYLE="font-weight:bold;color:orange;font-size:12px">State</font></td>
<td><FONT STYLE="font-weight:bold;color:#221100;font-size:10px"><%=ship_bill.getBill_state()%></td></tr>
     <tr><td><FONT STYLE="font-weight:bold;color:orange;font-size:12px">Zipcode</font></td>
<td><FONT STYLE="font-weight:bold;color:#221100;font-size:10px"><%=ship_bill.getBill_zip()%></td></tr>
     <tr><td><FONT STYLE="font-weight:bold;color:orange;font-size:12px">Country</font></td>
<td><FONT STYLE="font-weight:bold;color:#221100;font-size:10px"><%=ship_bill.getBill_country()%></td></tr>
     <tr><td><FONT STYLE="font-weight:bold;color:orange;font-size:12px">Phone</font></td>
<td><FONT STYLE="font-weight:bold;color:#221100;font-size:10px">&nbsp;<%=ship_bill.getBill_phone()%></td></tr>
        <tr><td><FONT STYLE="font-weight:bold;color:orange;font-size:12px">Shipping Method:</font></td>
<td><FONT STYLE="font-weight:bold;color:#221100;font-size:10px"><%=ship_bill.getBill_method()%></td></tr>
     </table></td>
        </tr> 
        
        
        
        <input type="hidden" name="ship_f_name" value="<%=ship_bill.getShip_f_name()%>">
        <input type="hidden" name="ship_l_name" value="<%=ship_bill.getShip_l_name()%>">
        <input type="hidden" name="ship_street" value="<%=ship_bill.getShip_street()%>">
        <input type="hidden" name="ship_city" value="<%=ship_bill.getShip_city()%>">
        <input type="hidden" name="ship_state" value="<%=ship_bill.getShip_state()%>">
        <input type="hidden" name="ship_zip" value="<%=ship_bill.getShip_zip()%>">
        <input type="hidden" name="ship_country" value="<%=ship_bill.getShip_country()%>">
        <input type="hidden" name="ship_phone" value="<%=ship_bill.getShip_phone()%>">
        <input type="hidden" name="ship_a_phone" value="<%=ship_bill.getShip_a_phone()%>">
        <input type="hidden" name="ship_method" value="<%=ship_bill.getShip_method()%>">
        
       
         <input type="hidden" name="bill_f_name" value="<%=ship_bill.getBill_f_name()%>">
        <input type="hidden" name="bill_l_name" value="<%=ship_bill.getBill_l_name()%>">
        <input type="hidden" name="bill_street" value="<%=ship_bill.getBill_street()%>">
        <input type="hidden" name="bill_city" value="<%=ship_bill.getBill_city()%>">
        <input type="hidden" name="bill_state" value="<%=ship_bill.getBill_state()%>">
        <input type="hidden" name="bill_zip" value="<%=ship_bill.getBill_zip()%>">
        <input type="hidden" name="bill_country" value="<%=ship_bill.getBill_country()%>">
        <input type="hidden" name="bill_phone" value="<%=ship_bill.getBill_phone()%>">
        <input type="hidden" name="bill_a_phone" value="<%=ship_bill.getBill_a_phone()%>">
        <input type="hidden" name="bill_method" value="<%=ship_bill.getBill_method()%>">
        
        
        
        
        
        
        
        
        
                             <tr><td><table>
                                <tr><td><FONT STYLE="font-weight:bold;color:#orange;font-size:15px"> Email ID:</font><input type="text" name="buyerMail"
							value="" size="40" /></td></tr>
                                              <tr><td> <input type="checkbox" name="sames" onClick="validatechk(sames)"> I wish to receive emails from T Salon </td></tr>
    <tr><td><img src="./img/paypal-checkout.png" onclick="item_order()"/></td></tr>
    
                                        </table></td></tr>
                                        
                                        <tr><td>
                                            <table>
                                                <tr><td colspan="2"><FONT STYLE="font-weight:bold;color:#ffffff;font-size:15px">Card Details</font></td></tr>
                   
                  <tr><td><FONT STYLE="font-weight:bold;color:orange;font-size:12px">Card Type</font></td>
                 <td> <select name="creditCardType">
							<option value=Visa selected>Visa</option>
							<option value=MasterCard>MasterCard</option>
							<option value=Discover>Discover</option>
							<option value=Amex>American Express</option>
						</select>
                                               </td> </tr>
                                               
                        <tr><td><FONT STYLE="font-weight:bold;color:orange;font-size:12px">Card Number</font></td>
                  <td><input type="text" name="creditCardNumber"></td></tr>
                                         
                                               
                  <tr><td><FONT STYLE="font-weight:bold;color:orange;font-size:12px">Expiry Date</font></td>
                  <td>
         <select name="expDateMonth">
             <option value="">month</option>
                      <%for(int m=1;m<13;m++){%>
          <option value="<%=m%>"><%=m%></option>
            <%}%>      
                  </select>
                  
                  <select name="expDateYear">
                       <option value="1412">1412</option>
                      
                       <option value="">year</option>
                      <%for(int m=2000;m<2020;m++){%>
<option value="<%=m%>"><%=m%></option>
            <%}%>      
                  </select>
                  
                  
                  
                  
                  </td></tr>
                 <tr><td><FONT STYLE="font-weight:bold;color:orange;font-size:12px">CVV No.</font></td>
                  <td><input type="text" name="cvv2Number"></td></tr>
                                                                                                                                          
                                 <tr><td colspan="2"><img src="./img/paypal-checkout.png" onclick="item_orderbyCard()"/></td></tr>
               
                                            </table>
                                        </td>
                                        </tr>
                                        
                                            </table>
					</td>	
					
					</tr>
                                        
                                        
                                
                                
                                
                                
				
					
					
						<input type=hidden size="50"  name="notifyURL" value="">
					
				
				
				<input type=hidden   name="reqConfirmShipping" value="0">
					
				
	        <input type=hidden   name="addressoverride" value="">
				
                     
	            
					
				
					
						<input type="hidden" name="name" value="<%=ship_bill.getShip_f_name()%>" size="50"
							maxlength="260" />
						
				
						<input type="hidden" name="street1" value="<%=ship_bill.getShip_street()%>" size="50"
							maxlength="260" />
					
				
						<input type="hidden" name="street2" value="<%=ship_bill.getShip_street()%>" size="50"
							maxlength="260" />
					
				
					
					
						<input type="hidden" name="city" value="Austin" size="50"
							maxlength="260" />
					

				
				
					
						<input type="hidden" name="state" value="<%=ship_bill.getShip_state()%>" size="50"
							maxlength="260" />
					
					
						<input type="hidden" name="postalCode" value="<%=ship_bill.getShip_zip()%>" size="50"
							maxlength="260" />
					

				
						<input type="hidden" name="countryCode" value="US" size="50"
							maxlength="260" />
                                                        
                                                        
                                                        
					<input type="hidden" name="billingAgreementText" value="" size="50"
							maxlength="260" />
                                                        
                                                        <input type="hidden" name="billingType" value="None" size="50"
							maxlength="260" />
                                                        
				
				
				
				
				
				
                                
				
                                <input type="hidden" name="brandName" id="brandName" value="T Salon" />
                                <input type="hidden" name="pageStyle" id="pageStyle" value="" />
                                <input type="hidden" name="cppheaderimage" id="cppheaderimage"
						value="" />
                                <input type="hidden" name="cppheaderbordercolor"
						id="cppheaderbordercolor" value="" />
				<input type="hidden" name="cppheaderbackcolor"
						id="cppheaderbackcolor" value="" />
					<input type="hidden" name="cpppayflowcolor" id="cpppayflowcolor"
						value="" />
				



				
                                        <input type="hidden" name="allowNote" value="0" />
                                                
				
				
				
					
				
		</form>
                
                 <div class="clear"></div>
        <div id="footerone" align="center"></div>
	<div>
<%@include file="/foot.jsp"%>
  </div>
     
            
                
                
                
                </div>
</table>
		
</body>
</html>