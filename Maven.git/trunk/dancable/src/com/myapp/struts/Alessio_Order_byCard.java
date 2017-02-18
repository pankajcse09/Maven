package com.myapp.struts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import urn.ebay.api.PayPalAPI.DoDirectPaymentReq;
import urn.ebay.api.PayPalAPI.DoDirectPaymentRequestType;
import urn.ebay.api.PayPalAPI.DoDirectPaymentResponseType;
import urn.ebay.api.PayPalAPI.PayPalAPIInterfaceServiceService;
import urn.ebay.apis.CoreComponentTypes.BasicAmountType;
import urn.ebay.apis.eBLBaseComponents.AddressType;
import urn.ebay.apis.eBLBaseComponents.CountryCodeType;
import urn.ebay.apis.eBLBaseComponents.CreditCardDetailsType;
import urn.ebay.apis.eBLBaseComponents.CreditCardTypeType;
import urn.ebay.apis.eBLBaseComponents.CurrencyCodeType;
import urn.ebay.apis.eBLBaseComponents.DoDirectPaymentRequestDetailsType;
import urn.ebay.apis.eBLBaseComponents.PayerInfoType;
import urn.ebay.apis.eBLBaseComponents.PaymentActionCodeType;
import urn.ebay.apis.eBLBaseComponents.PaymentDetailsType;
import urn.ebay.apis.eBLBaseComponents.PersonNameType;

import com.paypal.exception.ClientActionRequiredException;
import com.paypal.exception.HttpErrorException;
import com.paypal.exception.InvalidCredentialException;
import com.paypal.exception.InvalidResponseDataException;
import com.paypal.exception.MissingCredentialException;
import com.paypal.exception.SSLConfigurationException;
import com.paypal.sdk.exceptions.OAuthException;

public class Alessio_Order_byCard extends HttpServlet {

	private static final long serialVersionUID = 12345456723541232L;

	
	

	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
                PrintWriter ou=res.getWriter();

		HttpSession session = req.getSession();
		session.setAttribute("url", req.getRequestURI());
		DoDirectPaymentReq doPaymentReq = new DoDirectPaymentReq();
		DoDirectPaymentRequestType pprequest = new DoDirectPaymentRequestType();
		DoDirectPaymentRequestDetailsType details = new DoDirectPaymentRequestDetailsType();
		PaymentDetailsType paymentDetails = new PaymentDetailsType();

		BasicAmountType amount = new BasicAmountType();
		amount.setValue(req.getParameter("itemAmount"));
                ou.println(amount);
                ou.println("itemAmount"+req.getParameter("itemAmount"));
		amount.setCurrencyID(CurrencyCodeType.fromValue(req.getParameter("currencyCode")));
                  ou.println("currencyCode"+req.getParameter("currencyCode"));
                ou.println(amount);
		paymentDetails.setOrderTotal(amount);

		AddressType shipTo = new AddressType();
		shipTo.setName(req.getParameter("name") + " "
				+ req.getParameter("ship_l_name"));
                 ou.println("name"+req.getParameter("name"));
                   ou.println("ship_l_name"+req.getParameter("ship_l_name"));
		shipTo.setStreet1(req.getParameter("street1"));
                 ou.println("street1"+req.getParameter("street1"));
		//shipTo.setStreet2(req.getParameter("address2"));
		shipTo.setCityName(req.getParameter("city"));
                ou.println("city"+req.getParameter("city"));
		shipTo.setStateOrProvince("AK");
                ou.println("state"+req.getParameter("state"));
		shipTo.setCountry(CountryCodeType.fromValue(req.getParameter("countryCode")));
                ou.println("countryCode"+req.getParameter("countryCode"));
		//shipTo.setPostalCode(req.getParameter("postalCode"));
                shipTo.setPostalCode("95131");
                
                ou.println("postalCode"+req.getParameter("postalCode"));
		paymentDetails.setShipToAddress(shipTo);
		//paymentDetails.setNotifyURL(req.getParameter("notifyURL"));
		details.setPaymentDetails(paymentDetails);

		CreditCardDetailsType cardDetails = new CreditCardDetailsType();
		cardDetails.setCreditCardType(CreditCardTypeType.fromValue(req
				.getParameter("creditCardType")));
                
                ou.println(req.getParameter("creditCardType"));
		cardDetails.setCreditCardNumber(req.getParameter("creditCardNumber"));
                ou.println(req.getParameter("creditCardNumber"));
		cardDetails.setExpMonth(Integer.parseInt(req.getParameter("expDateMonth")));
                ou.println(req.getParameter("expDateMonth"));
                
		cardDetails.setExpYear(Integer.parseInt(req.getParameter("expDateYear")));
                ou.println(req.getParameter("expDateYear"));
                
		cardDetails.setCVV2(req.getParameter("cvv2Number"));
                ou.println("cvv2Number"+req.getParameter("cvv2Number"));
                
		PayerInfoType payer = new PayerInfoType();
		PersonNameType name = new PersonNameType();
		name.setFirstName(req.getParameter("bill_f_name"));
                
                  ou.println("bill_f_name"+req.getParameter("bill_f_name"));
                
		
		name.setLastName(req.getParameter("bill_l_name"));
                ou.println("bill_l_name"+req.getParameter("bill_l_name"));
                
		payer.setPayerName(name);
		payer.setPayerCountry(CountryCodeType.fromValue(req.getParameter("countryCode")));
		payer.setAddress(shipTo);

		cardDetails.setCardOwner(payer);

		details.setCreditCard(cardDetails);

		details.setIPAddress("127.0.0.1");
		details.setPaymentAction(PaymentActionCodeType.fromValue(req.getParameter("paymentType")));

		pprequest.setDoDirectPaymentRequestDetails(details);
		doPaymentReq.setDoDirectPaymentRequest(pprequest);
ou.println(req.getParameter("paymentType"));
		try {
			PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService(this
					.getClass().getResourceAsStream("/sdk_config.properties"));
			DoDirectPaymentResponseType ddresponse = service
					.doDirectPayment(doPaymentReq);	
                        ou.println(ddresponse);
                        res.setContentType("text/html");
                                          ou.println(ddresponse.getAck().toString());
			if (ddresponse != null) {
				session.setAttribute("lastReq", service.getLastRequest());
				session.setAttribute("lastResp", service.getLastResponse());
                                ou.println(ddresponse.getAck().toString());
				if (ddresponse.getAck().toString().equalsIgnoreCase("SUCCESS")) {
					Map<Object, Object> map = new LinkedHashMap<Object, Object>();
					map.put("Ack", ddresponse.getAck());
                                        ou.println(ddresponse.getAck());
					map.put("Transaction ID", ddresponse.getTransactionID());
					map.put("Amount", ddresponse.getAmount().getValue() + " "
							+ ddresponse.getAmount().getCurrencyID());
					map.put("Payment Status", ddresponse.getPaymentStatus());
					session.setAttribute("map", map);
					res.sendRedirect(req.getContextPath()+"/Response.jsp");
				} else {
					session.setAttribute("Error", ddresponse.getErrors());
					res.sendRedirect(req.getContextPath()+"/Error.jsp");
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SSLConfigurationException e) {
			e.printStackTrace();
		} catch (InvalidCredentialException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (HttpErrorException e) {
			e.printStackTrace();
		} catch (InvalidResponseDataException e) {
			e.printStackTrace();
		} catch (ClientActionRequiredException e) {
			e.printStackTrace();
		} catch (MissingCredentialException e) {
			e.printStackTrace();
		} catch (OAuthException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
