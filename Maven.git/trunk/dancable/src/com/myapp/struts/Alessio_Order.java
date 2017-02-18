package com.myapp.struts;

import Main_category.item_bean;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import urn.ebay.api.PayPalAPI.DoExpressCheckoutPaymentReq;
import urn.ebay.api.PayPalAPI.DoExpressCheckoutPaymentRequestType;
import urn.ebay.api.PayPalAPI.DoExpressCheckoutPaymentResponseType;
import urn.ebay.api.PayPalAPI.DoUATPExpressCheckoutPaymentReq;
import urn.ebay.api.PayPalAPI.DoUATPExpressCheckoutPaymentRequestType;
import urn.ebay.api.PayPalAPI.DoUATPExpressCheckoutPaymentResponseType;
import urn.ebay.api.PayPalAPI.ExecuteCheckoutOperationsReq;
import urn.ebay.api.PayPalAPI.ExecuteCheckoutOperationsRequestType;
import urn.ebay.api.PayPalAPI.ExecuteCheckoutOperationsResponseType;
import urn.ebay.api.PayPalAPI.ExternalRememberMeOptOutReq;
import urn.ebay.api.PayPalAPI.ExternalRememberMeOptOutRequestType;
import urn.ebay.api.PayPalAPI.ExternalRememberMeOptOutResponseType;
import urn.ebay.api.PayPalAPI.GetExpressCheckoutDetailsReq;
import urn.ebay.api.PayPalAPI.GetExpressCheckoutDetailsRequestType;
import urn.ebay.api.PayPalAPI.GetExpressCheckoutDetailsResponseType;
import urn.ebay.api.PayPalAPI.PayPalAPIInterfaceServiceService;
import urn.ebay.api.PayPalAPI.SetExpressCheckoutReq;
import urn.ebay.api.PayPalAPI.SetExpressCheckoutRequestType;
import urn.ebay.api.PayPalAPI.SetExpressCheckoutResponseType;
import urn.ebay.apis.CoreComponentTypes.BasicAmountType;
import urn.ebay.apis.eBLBaseComponents.AddressType;
import urn.ebay.apis.eBLBaseComponents.ApprovalSubTypeType;
import urn.ebay.apis.eBLBaseComponents.ApprovalTypeType;
import urn.ebay.apis.eBLBaseComponents.AuthorizationRequestType;
import urn.ebay.apis.eBLBaseComponents.BillingAgreementDetailsType;
import urn.ebay.apis.eBLBaseComponents.BillingApprovalDetailsType;
import urn.ebay.apis.eBLBaseComponents.BillingCodeType;
import urn.ebay.apis.eBLBaseComponents.BuyerDetailType;
import urn.ebay.apis.eBLBaseComponents.CountryCodeType;
import urn.ebay.apis.eBLBaseComponents.CurrencyCodeType;
import urn.ebay.apis.eBLBaseComponents.DoExpressCheckoutPaymentRequestDetailsType;
import urn.ebay.apis.eBLBaseComponents.ExecuteCheckoutOperationsRequestDetailsType;
import urn.ebay.apis.eBLBaseComponents.ExternalRememberMeOwnerDetailsType;
import urn.ebay.apis.eBLBaseComponents.IdentificationInfoType;
import urn.ebay.apis.eBLBaseComponents.InfoSharingDirectivesType;
import urn.ebay.apis.eBLBaseComponents.ItemCategoryType;
import urn.ebay.apis.eBLBaseComponents.MerchantPullPaymentCodeType;
import urn.ebay.apis.eBLBaseComponents.MobileIDInfoType;
import urn.ebay.apis.eBLBaseComponents.OrderDetailsType;
import urn.ebay.apis.eBLBaseComponents.PaymentActionCodeType;
import urn.ebay.apis.eBLBaseComponents.PaymentDetailsItemType;
import urn.ebay.apis.eBLBaseComponents.PaymentDetailsType;
import urn.ebay.apis.eBLBaseComponents.PaymentDirectivesType;
import urn.ebay.apis.eBLBaseComponents.PaymentInfoType;
import urn.ebay.apis.eBLBaseComponents.RememberMeIDInfoType;
import urn.ebay.apis.eBLBaseComponents.SetDataRequestType;
import urn.ebay.apis.eBLBaseComponents.SetExpressCheckoutRequestDetailsType;

import com.paypal.exception.ClientActionRequiredException;
import com.paypal.exception.HttpErrorException;
import com.paypal.exception.InvalidCredentialException;
import com.paypal.exception.InvalidResponseDataException;
import com.paypal.exception.MissingCredentialException;
import com.paypal.exception.SSLConfigurationException;
import com.paypal.sdk.exceptions.OAuthException;

/**
 * Servlet implementation class CheckoutServlet
 */
public class Alessio_Order extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Alessio_Order() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
               PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
		session.setAttribute("url", request.getRequestURI());
//		session.setAttribute(
//				"relatedUrl",
//				"<ul><li><a href='EC/SetExpressCheckout'>SetExpressCheckout</a></li>" +
//                        "<li><a href='EC/GetExpressCheckout'>GetExpressCheckout</a></li>" +
//                        "<li><a href='EC/DoExpressCheckout'>DoExpressCheckout</a></li></ul>");
//		out.println(request.getRequestURI());
             response.setContentType("text/html");
                List ar1=new ArrayList();
        List ar2=new ArrayList();
        Map hm1=new HashMap();
        Map hm2=new HashMap();
        Map hm3=new HashMap();       
         Map hm4=new HashMap();   
      Enumeration en=(Enumeration)request.getParameterNames();     
        ArrayList cart_list=new ArrayList();
        while(en.hasMoreElements()){
         String pname=(String)en.nextElement();
         out.println(pname);
         if(pname.substring(0,4).equals("pric")){
        ar1.add(pname);
         }
        }
        
        for(int i=0;i<ar1.size();i++){
        if(request.getParameter("cartid"+i)!=null || !request.getParameter("cartid"+i).equals("")){
         ar2.add(request.getParameter("cartid"+i));    
        hm1.put(request.getParameter("cartid"+i),request.getParameter("pric"+i));
        hm2.put(request.getParameter("cartid"+i),request.getParameter("quantity"+i));
        hm3.put(request.getParameter("cartid"+i),request.getParameter("subtotal"+i));
        hm4.put(request.getParameter("cartid"+i),request.getParameter("filena"+i));
      
        }   
        }
                
        String ship_f_name="";
  String ship_l_name="";
   String ship_street="";
   String ship_city="";
   String ship_state="";
   String ship_zip="";
   String ship_country="";
  String ship_phone="";
   String ship_a_phone="";
   String ship_method="";
  
   String bill_f_name="";
   String bill_l_name="";
   String bill_street="";
   String bill_city="";
   String bill_state="";
   String bill_zip="";
   String bill_country="";
   String bill_phone="";
   String bill_a_phone="";
   String bill_method="";
  item_bean ship_bill=new item_bean();
        ship_f_name=(String)request.getParameter("ship_f_name");  
     ship_l_name=(String)request.getParameter("ship_l_name");  
    ship_street=(String)request.getParameter("ship_street");  
    ship_city=(String)request.getParameter("ship_city");  
    ship_state=(String)request.getParameter("ship_state");  
    ship_zip=(String)request.getParameter("ship_zip");  
    ship_country=(String)request.getParameter("ship_country");  
   ship_phone=(String)request.getParameter("ship_phone");  
    ship_a_phone=(String)request.getParameter("ship_a_phone");  
    ship_method=(String)request.getParameter("ship_method");      
     bill_f_name=(String)request.getParameter("bill_f_name");  
     bill_l_name=(String)request.getParameter("bill_l_name");  
    bill_street=(String)request.getParameter("bill_street");  
    bill_city=(String)request.getParameter("bill_city");  
    bill_state=(String)request.getParameter("bill_state");  
    bill_zip=(String)request.getParameter("bill_zip");  
    bill_country=(String)request.getParameter("bill_country");  
    bill_phone=(String)request.getParameter("bill_phone");  
    bill_a_phone=(String)request.getParameter("bill_a_phone");  
    bill_method=(String)request.getParameter("bill_method");  
         ship_bill.setShip_f_name(ship_f_name);
    ship_bill.setShip_l_name(ship_l_name);
    ship_bill.setShip_street(ship_street);
    ship_bill.setShip_city(ship_city);
    ship_bill.setShip_state(ship_state);
    ship_bill.setShip_zip(ship_zip);
    ship_bill.setShip_country(ship_country);
    ship_bill.setShip_phone(ship_phone);
    ship_bill.setShip_a_phone(ship_a_phone);
    ship_bill.setShip_method(ship_method);
    
    ship_bill.setBill_f_name(bill_f_name);
    ship_bill.setBill_l_name(bill_l_name);
    ship_bill.setBill_street(bill_street);
    ship_bill.setBill_city(bill_city);
    ship_bill.setBill_state(bill_state);
    ship_bill.setBill_zip(bill_zip);
    ship_bill.setBill_country(bill_country);
    ship_bill.setBill_phone(bill_phone);
    ship_bill.setBill_a_phone(bill_a_phone);
    ship_bill.setBill_method(bill_method);
        
        
                try {
			PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService(this
					.getClass().getResourceAsStream("/sdk_config.properties"));
                        
			
				SetExpressCheckoutRequestType setExpressCheckoutReq = new SetExpressCheckoutRequestType();
				SetExpressCheckoutRequestDetailsType details = new SetExpressCheckoutRequestDetailsType();

				StringBuffer url = new StringBuffer();
				url.append("http://");
				url.append(request.getServerName());
				url.append(":");
				url.append(request.getServerPort());
				url.append(request.getContextPath());
                                out.println(url);
                                String returnURL = url.toString() + "/getreview_checkout.do";
				String cancelURL = url.toString() + "/create_cart.do?method=create_cart";

				details.setReturnURL(returnURL + "?currencyCodeType="
						+ request.getParameter("currencyCode"));

				details.setCancelURL(cancelURL);
                                
                                details.setBuyerEmail(request.getParameter("buyerMail"));

				request.getSession().setAttribute("paymentType",
						request.getParameter("paymentType"));

				double itemTotal = 0.00;
				double orderTotal = 0.00;
				// populate line item details
				String amountItems = request.getParameter("itemAmount");
				//String qtyItems = request.getParameter("itemQuantity");
				String names = request.getParameter("itemName");
                                String qt="1";

				List<PaymentDetailsItemType> lineItems = new ArrayList<PaymentDetailsItemType>();

				PaymentDetailsItemType item = new PaymentDetailsItemType();
				BasicAmountType amt = new BasicAmountType();
				amt.setCurrencyID(CurrencyCodeType.fromValue(request
						.getParameter("currencyCode")));
				amt.setValue(amountItems);
				//item.setQuantity(new Integer(qtyItems));
                               //item.setQuantity(new Integer(qt));
				item.setName(names);
				item.setAmount(amt);
				item.setItemCategory(ItemCategoryType.fromValue(request
						.getParameter("itemCategory")));
				item.setDescription(request.getParameter("itemDescription"));
                                
				lineItems.add(item);

                                if (request.getParameter("salesTax") != "") {
					item.setTax(new BasicAmountType(CurrencyCodeType
							.fromValue(request.getParameter("currencyCode")),
							request.getParameter("salesTax")));					
				}
				
				//itemTotal += Double.parseDouble(qtyItems) * Double.parseDouble(amountItems);
                                itemTotal +=Double.parseDouble(amountItems);
				orderTotal += itemTotal;
				
				List<PaymentDetailsType> payDetails = new ArrayList<PaymentDetailsType>();
				PaymentDetailsType paydtl = new PaymentDetailsType();
				paydtl.setPaymentAction(PaymentActionCodeType.fromValue(request
						.getParameter("paymentType")));
				if (request.getParameter("shippingTotal") != "") {
					BasicAmountType shippingTotal = new BasicAmountType();
					shippingTotal.setValue(request
							.getParameter("shippingTotal"));
					shippingTotal.setCurrencyID(CurrencyCodeType
							.fromValue(request.getParameter("currencyCode")));
					orderTotal += Double.parseDouble(request
							.getParameter("shippingTotal"));
					paydtl.setShippingTotal(shippingTotal);
				}
                                if (request.getParameter("insuranceTotal") != "") {
					paydtl.setInsuranceTotal(new BasicAmountType(
							CurrencyCodeType.fromValue(request
									.getParameter("currencyCode")), request
									.getParameter("insuranceTotal")));
					paydtl.setInsuranceOptionOffered("true");
					orderTotal += Double.parseDouble(request
							.getParameter("insuranceTotal"));
				}
				if (request.getParameter("handlingTotal") != "") {
					paydtl.setHandlingTotal(new BasicAmountType(
							CurrencyCodeType.fromValue(request
									.getParameter("currencyCode")), request
									.getParameter("handlingTotal")));
					orderTotal += Double.parseDouble(request
							.getParameter("handlingTotal"));
				}
				if (request.getParameter("taxTotal") != "") {
					paydtl.setTaxTotal(new BasicAmountType(CurrencyCodeType
							.fromValue(request.getParameter("currencyCode")),
							request.getParameter("taxTotal")));
					orderTotal += Double.parseDouble(request
							.getParameter("taxTotal"));
				}
				if (request.getParameter("orderDescription") != "") {
					paydtl.setOrderDescription(request
							.getParameter("orderDescription"));
				}
                                
                                BasicAmountType itemsTotal = new BasicAmountType();
				itemsTotal.setValue(Double.toString(itemTotal));
				itemsTotal.setCurrencyID(CurrencyCodeType.fromValue(request
						.getParameter("currencyCode")));
				paydtl.setOrderTotal(new BasicAmountType(CurrencyCodeType
						.fromValue(request.getParameter("currencyCode")),
						Double.toString(orderTotal)));
				paydtl.setPaymentDetailsItem(lineItems);

				paydtl.setItemTotal(itemsTotal);
				paydtl.setNotifyURL(request.getParameter("notifyURL"));
				payDetails.add(paydtl);
				details.setPaymentDetails(payDetails);
				if (request.getParameter("billingAgreementText") != "") {
					BillingAgreementDetailsType billingAgreement = new BillingAgreementDetailsType(
							BillingCodeType.fromValue(request
									.getParameter("billingType")));
					billingAgreement.setBillingAgreementDescription(request
							.getParameter("billingAgreementText"));
					List<BillingAgreementDetailsType> billList = new ArrayList<BillingAgreementDetailsType>();
					billList.add(billingAgreement);
					details.setBillingAgreementDetails(billList);
				}
                                out.println(url);
                                details.setReqConfirmShipping(request.getParameter("reqConfirmShipping"));
				details.setAddressOverride(request.getParameter("addressoverride"));
				AddressType shipToAddress=new AddressType();
				shipToAddress.setName(request.getParameter("name"));
				shipToAddress.setStreet1(request.getParameter("street1"));
				shipToAddress.setStreet2(request.getParameter("street2"));
				shipToAddress.setCityName(request.getParameter("city"));
				shipToAddress.setStateOrProvince(request.getParameter("state"));
				shipToAddress.setPostalCode(request.getParameter("postalCode"));
				shipToAddress.setCountry(CountryCodeType.fromValue(request.getParameter("countryCode")));
				details.setAddress(shipToAddress);
				out.println(url);
				// shipping display options
				details.setNoShipping(request.getParameter("noShipping"));
				
				// PayPal page styling attributes
				details.setBrandName(request.getParameter("brandName"));
				details.setCustom(request.getParameter("pageStyle"));
				details.setCppHeaderImage(request.getParameter("cppheaderimage"));
				details.setCppHeaderBorderColor(request.getParameter("cppheaderbordercolor"));
				details.setCppHeaderBackColor(request.getParameter("cppheaderbackcolor"));
				details.setCppPayflowColor(request.getParameter("cpppayflowcolor"));
				details.setAllowNote(request.getParameter("allowNote"));

				setExpressCheckoutReq.setSetExpressCheckoutRequestDetails(details);
                              //  out.println(details);
                                SetExpressCheckoutReq expressCheckoutReq = new SetExpressCheckoutReq();
				expressCheckoutReq.setSetExpressCheckoutRequest(setExpressCheckoutReq);
                              //  out.println(url);
                               try{        
			       SetExpressCheckoutResponseType setExpressCheckoutResponse = service.setExpressCheckout(expressCheckoutReq);
                            if (setExpressCheckoutResponse.getAck().toString().equalsIgnoreCase("SUCCESS"))
                            {
                                   // out.println("seesion"+setExpressCheckoutResponse.getAck().toString());
                                   //   out.println("token"+setExpressCheckoutResponse.getToken().toString());
                                      
                                         session.setAttribute("lastReq", service.getLastRequest());
					 session.setAttribute("lastResp", service.getLastResponse());
                                        Map<Object, Object> map = new LinkedHashMap<Object, Object>();
						map.put("Ack", setExpressCheckoutResponse.getAck());
						map.put("Token", setExpressCheckoutResponse.getToken());
//						map.put("Redirect URL",
//								"<a href=https://www.sandbox.paypal.com/cgi-bin/webscr?cmd=_express-checkout&token="
//										+ setExpressCheckoutResponse.getToken()
//										+ ">Redirect To PayPal</a>");
						session.setAttribute("map", map);
                                                session.setAttribute("ar2",ar2);
                                                 session.setAttribute("hm1",hm1);
                                                 session.setAttribute("hm2",hm2);
                                                 session.setAttribute("hm3",hm3);
                                                session.setAttribute("hm4",hm4);
                                                session.setAttribute("ship_bill",ship_bill);
                                             response.sendRedirect("https://www.paypal.com/cgi-bin/webscr?cmd=_express-checkout&token="+setExpressCheckoutResponse.getToken());
										
                                       // response.sendRedirect("http://localhost:8080/alessio/Response.jsp");
                                    
                            }
                            }
                               catch(Exception e){
                                   
                                   out.println(e.getMessage());
                                   
                               }
                            //   out.println("seesion");
                             //  out.println("seesion");
                            //    out.println(url);     
//                                if(setExpressCheckoutResponse != null) {
//                                    
//                                    
//					session.setAttribute("lastReq", service.getLastRequest());
//					session.setAttribute("lastResp", service.getLastResponse());
//                                       out.println("seesion"+service.getLastRequest());
//                                        
//					if (setExpressCheckoutResponse.getAck().toString()
//							.equalsIgnoreCase("SUCCESS")) {
//                                            
//                                            
//                                            
//						Map<Object, Object> map = new LinkedHashMap<Object, Object>();
//						map.put("Ack", setExpressCheckoutResponse.getAck());
//						map.put("Token", setExpressCheckoutResponse.getToken());
//						map.put("Redirect URL",
//								"<a href=https://www.sandbox.paypal.com/cgi-bin/webscr?cmd=_express-checkout&token="
//										+ setExpressCheckoutResponse.getToken()
//										+ ">Redirect To PayPal</a>");
//						session.setAttribute("map", map);
//						response.sendRedirect("/Response.jsp");
//					} else {
//
//						session.setAttribute("Error",
//								setExpressCheckoutResponse.getErrors());
//						//response.sendRedirect(this.getServletContext().getContextPath()+"/Error.jsp");
//                                                response.sendRedirect("/Error.jsp");
//					}
//				}
                                
                        }catch(Exception E)
                        {}
                
		
}
}