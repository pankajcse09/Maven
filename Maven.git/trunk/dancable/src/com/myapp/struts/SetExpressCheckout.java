package com.myapp.struts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
public class SetExpressCheckout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public SetExpressCheckout() {
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
		session.setAttribute(
				"relatedUrl",
				"<ul><li><a href='EC/SetExpressCheckout'>SetExpressCheckout</a></li>" +
                        "<li><a href='EC/GetExpressCheckout'>GetExpressCheckout</a></li>" +
                        "<li><a href='EC/DoExpressCheckout'>DoExpressCheckout</a></li></ul>");
		out.println(request.getRequestURI());
             response.setContentType("text/html");
                
                try {
			PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService(this
					.getClass().getResourceAsStream("/sdk_config.properties"));
                        
			if (request.getRequestURI().contains("SetExpressCheckout")) {
				SetExpressCheckoutRequestType setExpressCheckoutReq = new SetExpressCheckoutRequestType();
				SetExpressCheckoutRequestDetailsType details = new SetExpressCheckoutRequestDetailsType();

				StringBuffer url = new StringBuffer();
				url.append("http://");
				url.append(request.getServerName());
				url.append(":");
				url.append(request.getServerPort());
				url.append(request.getContextPath());
                                out.println(url);
                                String returnURL = url.toString() + "/getcheckout.do";
				String cancelURL = url.toString() + "/index.html";

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
				String qtyItems = request.getParameter("itemQuantity");
				String names = request.getParameter("itemName");

				List<PaymentDetailsItemType> lineItems = new ArrayList<PaymentDetailsItemType>();

				PaymentDetailsItemType item = new PaymentDetailsItemType();
				BasicAmountType amt = new BasicAmountType();
				amt.setCurrencyID(CurrencyCodeType.fromValue(request
						.getParameter("currencyCode")));
				amt.setValue(amountItems);
				item.setQuantity(new Integer(qtyItems));
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
				
				itemTotal += Double.parseDouble(qtyItems) * Double.parseDouble(amountItems);
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
                                out.println(details);
                                SetExpressCheckoutReq expressCheckoutReq = new SetExpressCheckoutReq();
				expressCheckoutReq.setSetExpressCheckoutRequest(setExpressCheckoutReq);
                                out.println(url);
                               try{        
			       SetExpressCheckoutResponseType setExpressCheckoutResponse = service.setExpressCheckout(expressCheckoutReq);
                            if (setExpressCheckoutResponse.getAck().toString().equalsIgnoreCase("SUCCESS"))
                            {
                                    out.println("seesion"+setExpressCheckoutResponse.getAck().toString());
                                      out.println("token"+setExpressCheckoutResponse.getToken().toString());
                                      
                                         session.setAttribute("lastReq", service.getLastRequest());
					 session.setAttribute("lastResp", service.getLastResponse());
                                        Map<Object, Object> map = new LinkedHashMap<Object, Object>();
						map.put("Ack", setExpressCheckoutResponse.getAck());
						map.put("Token", setExpressCheckoutResponse.getToken());
						map.put("Redirect URL",
								"<a href=https://www.sandbox.paypal.com/cgi-bin/webscr?cmd=_express-checkout&token="
										+ setExpressCheckoutResponse.getToken()
										+ ">Redirect To PayPal</a>");
						session.setAttribute("map", map);
                                        response.sendRedirect("http://localhost:8080/alessio/Response.jsp");
                                    
                            }
                            }
                               catch(Exception e){
                                   
                                   out.println(e.getMessage());
                                   
                               }
                               out.println("seesion");
                               out.println("seesion");
                                out.println(url);     
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
                                
                        }}catch(Exception E)
                        {}
                
		
}
}