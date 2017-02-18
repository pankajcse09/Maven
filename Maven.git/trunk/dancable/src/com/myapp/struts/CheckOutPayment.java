package com.myapp.struts;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.net.URLDecoder;

import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CheckOutPayment extends HttpServlet {
    protected static String API_URL = "https://api-3t.sandbox.paypal.com/nvp";

     protected static String API_USERNAME = "arjuns_1355991663_biz_api1.gmail.com";
	protected static String API_PASSWORD = "1355991682";
	protected static String API_SIGNATURE ="AuyqreR3.dLoui1im852szQ9zTkHAMM1EtyHK76wlFt5kBlGLLfBs0Zy";
	//protected static String API_URL = "https://api-3t.sandbox.paypal.com/nvp";
        protected static String REDIRECT_URL = "https://www.sandbox.paypal.com/webscr?cmd=_express-checkout";
	
	//protected static String REDIRECT_URL = "https://www.sandbox.paypal.com/webscr?cmd=_xclick";
	
	/** User will return to this page after the sale is successful */
	protected static String RETURN_URL = "http://localhost:8080/alessio/paypalResponse.jsp";
	
	/** User will return here if they hit the cancel button during purchase */
	protected static String CANCEL_URL = "http://127.0.0.1:8080/alessio/paypalResponseCancel.jsp";

	//protected final static Logger log = Logger.getLogger(CheckOutPayment.class.getName());
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        String userId="arjunp_1355991544_per@gmail.com";
        int itemId=2;
       String itemName="jewelry";
       String itemDescription="item for sale";
       String itemPriceDollars="20.0";
       
       String data ="METHOD=SetExpressCheckout" +
			getAuthenticationData() +
			"&REQCONFIRMSHIPPING =1" +
			"&NOSHIPPING =0" +
			"&ALLOWNOTE = 0" +
			"&PAYMENTREQUEST_0_PAYMENTACTION=Sale" +
			"&PAYMENTREQUEST_0_CURRENCYCODE=USD" + 
			getPurchaseData(userId,itemId,itemName,itemDescription,itemPriceDollars) + 
			"&RETURNURL=" + RETURN_URL + 
			"&CANCELURL=" + CANCEL_URL +
			"";

       HashMap<String, String> results = doServerCall(data);

       String res="";
  try {
     
//      URL postURL = new URL(API_URL);
//			HttpURLConnection conn = (HttpURLConnection)postURL.openConnection();
//			conn.setDoInput(true);
//			conn.setDoOutput(true);
//			conn.setConnectTimeout(3000);
//			conn.setReadTimeout(7000);
//			conn.setRequestMethod("POST");
//			
//			DataOutputStream output = new DataOutputStream(conn.getOutputStream());
//			output.writeBytes(data);
//			output.flush();
//			output.close();
//
//			// Read input from the input stream.
//			int responseCode = conn.getResponseCode();
//			if (responseCode != HttpURLConnection.HTTP_OK) {
//				throw new RuntimeException("Error " + responseCode + ": " + conn.getResponseMessage());
//			}
//			
//			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//			String line = null;
//			while(((line = reader.readLine()) !=null)) {
//				res = res + line;
//			}
//			reader.close();

			String token = results.get("TOKEN");
			String redirectUrl = response.encodeRedirectURL(REDIRECT_URL +"&token="+token);

			
			response.sendRedirect(redirectUrl);
                        
                   // String payerId = validateDetails(token, userId, itemId);

		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to open PayPal link: " + e.getMessage());
		}

       
       
       
     
       
       
       
       
       
       
       

}
//    public static String validateDetails(String token,String userId, int itemId)
//	{
//		String data = 
//			"METHOD=GetExpressCheckoutDetails" +
//			getAuthenticationData() +
//			"&TOKEN=" + encodeValue(token) +
//			"";
//	
//		HashMap<String, String> results = doServerCall(data);
//
//		String resultsUserId =results.get("PAYMENTREQUEST_0_CUSTOM");
//		if (results.equals(userId)) {
//			throw new RuntimeException("UserId does not match.");
//		}
//		
//		int resultsItemId = Integer.parseInt(results.get("PAYMENTREQUEST_0_INVNUM"));
//		if (resultsItemId != itemId) {
//			throw new RuntimeException("ItemId does not match.");
//		}
//		
//		String payerId = results.get("PAYERID");
//		if (payerId == null || payerId.trim().length() == 0) {
//			throw new RuntimeException("Payment has not been initiated by the user.");
//		}
//		
//		return payerId;
//	}
//	

    
    
    protected static String getPurchaseData(String userId, int itemId, String itemName,String itemDescription, String itemPriceDollars)
	{
		return 
			"&PAYMENTREQUEST_0_AMT=" + itemPriceDollars + 
			"&PAYMENTREQUEST_0_ITEMAMT=" + itemPriceDollars + 
			"&PAYMENTREQUEST_0_DESC=" + itemDescription + 
			"&PAYMENTREQUEST_0_CUSTOM="+userId+ 
			"&PAYMENTREQUEST_0_INVNUM=" + itemId + 
			"&L_PAYMENTREQUEST_0_NAME0=" + itemName + 
			"&L_PAYMENTREQUEST_0_DESC0=" + itemDescription + 
			"&L_PAYMENTREQUEST_0_AMT0=" + itemPriceDollars + 
			"&L_PAYMENTREQUEST_0_QTY0=" + 1 + 
			"&L_PAYMENTREQUEST_0_ITEMCATEGORY0=Digital" +
			"";
	}

    protected static String getAuthenticationData()
	{
		return 
			"&VERSION=69.0"+"&USER="+API_USERNAME+"&PWD="+API_PASSWORD+"&SIGNATURE="+API_SIGNATURE+"";
	}

protected static HashMap<String, String> doServerCall (String data)
	{
		//log.info("Sending data to paypal: " + data);
	
		String response = "";
		try {
			URL postURL = new URL(API_URL);
			HttpURLConnection conn = (HttpURLConnection)postURL.openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setConnectTimeout(3000);
			conn.setReadTimeout(7000);
			conn.setRequestMethod("POST");
			
			DataOutputStream output = new DataOutputStream(conn.getOutputStream());
			output.writeBytes(data);
			output.flush();
			output.close();

			// Read input from the input stream.
			int responseCode = conn.getResponseCode();
			if (responseCode != HttpURLConnection.HTTP_OK) {
				throw new RuntimeException("Error " + responseCode + ": " + conn.getResponseMessage());
			}
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = null;
			while(((line = reader.readLine()) !=null)) {
				response = response + line;
			}
			reader.close();
		} catch(IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}

		//log.info("Got response from paypal: " + response);
		if(response.length() <= 0) {
			throw new RuntimeException("Received empty response");
		}
		HashMap<String, String> results = parsePaypalResponse(response);
		
		// first check for the new version (PAYMENTINFO_0_ACK)
		String ackString = results.get("PAYMENTINFO_0_ACK");
		if (ackString == null || !(ackString.equalsIgnoreCase("Success") || ackString.equalsIgnoreCase("SuccessWithWarning"))) {
			String errorCode = results.get("PAYMENTINFO_0_ERRORCODE");
			String errorLongMsg = results.get("PAYMENTINFO_0_LONGMESSAGE");
			if (errorCode != null && errorCode.trim().length() > 0) {
				throw new RuntimeException("Purchase Failed (code " + errorCode + "): " + errorLongMsg);
			}
			
			// sometimes API returns old version ACK instead of PAYMENTINFO_0_ACK
			ackString = results.get("ACK");
			if (ackString == null || !(ackString.equalsIgnoreCase("Success") || ackString.equalsIgnoreCase("SuccessWithWarning"))) {
				errorCode = results.get("L_ERRORCODE0");
				errorLongMsg = results.get("L_LONGMESSAGE0");
				throw new RuntimeException("Purchase Failed (code " + errorCode + "): " + errorLongMsg);
			}
		}
		
		return results;
	}
	
protected static HashMap<String, String> parsePaypalResponse (String data)
	{
		HashMap<String, String> results = new HashMap<String, String>();
		StringTokenizer tokenizer = new StringTokenizer(data, "&");
		while (tokenizer.hasMoreTokens()) {
			StringTokenizer tokenizer2 = new StringTokenizer(tokenizer.nextToken(), "=");
			if (tokenizer2.countTokens() != 2) {
				continue;
			}
			String key = decodeValue(tokenizer2.nextToken());
			String value = decodeValue(tokenizer2.nextToken());
			results.put(key.toUpperCase(), value);
		}
		return results;
	}
	
protected static String encodeValue(String value)
	{
		try {
			return URLEncoder.encode(value, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
protected static String decodeValue(String value)
	{
		try {
			return URLDecoder.decode(value, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

}