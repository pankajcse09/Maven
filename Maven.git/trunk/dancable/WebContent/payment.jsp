<%-- 
    Document   : payment
    Created on : Jan 6, 2014, 4:29:56 PM
    Author     : kapil
--%>

<!--
Sample JSP code for Payment Pages
Calculating the x_fp_hash with SHA-1
Tested on Tomcat5/Mac OS X 10.5
-->
<html>
<head>
 <title>Sample JSP Payment Form with SHA-1</title>
 <style type="text/css">
   label {
      display: block;
      margin: 5px 0px;
      color: #AAA;
   }
   input {
      display: block;
   }
   input[type=submit] {
      margin-top: 20px;
   }

 </style>

</head>
<body>

<%@ page import="java.util.Random" %>
<%@ page import="javax.crypto.Mac" %>
<%@ page import="javax.crypto.SecretKey" %>
<%@ page import="javax.crypto.spec.SecretKeySpec" %>

<%
// x_login and transactionKey should be taken from Payment Page settings
String x_login        = "###-###-##-##"; // aka Payment Page ID
String transactionKey = "#############"; // aka Transaction Key
String x_amount       = "19.99";

// Generate a random sequence number
Random generator = new Random();
int x_fp_sequence = generator.nextInt(1000);

// Generate the timestamp
// Make sure this will be in UTC
long x_fp_timestamp = System.currentTimeMillis()/1000;

// Use Java Cryptography functions to generate the x_fp_hash value
// generate secret key for HMAC-SHA1 using the transaction key
SecretKey key = new SecretKeySpec(transactionKey.getBytes(), "HmacSHA1");

// Get instance of Mac object implementing HMAC-SHA1, and
// Initialize it with the above secret key
Mac mac = Mac.getInstance("HmacSHA1");
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
<form action="https://checkout.globalgatewaye4.firstdata.com/payment" method="post">
<label>x_login</label>
 <input name="x_login" value="<%= x_login %>" />
 <label>x_fp_sequence</label>
 <input name="x_fp_sequence" value="<%= x_fp_sequence %>" />
 <label>x_fp_timestamp</label>
 <input name="x_fp_timestamp" value="<%= x_fp_timestamp %>" />
 <label>x_amount</label>
 <input name="x_amount" value="<%= x_amount %>" />
 <label>x_fp_hash (with SHA-1)</label>
 <input name="x_fp_hash" value="<%= x_fp_hash %>" size="40"/>
 <input name="x_show_form" value="PAYMENT_FORM" type="hidden" />
 <input type="submit" value="Checkout" />
</form>
 
 
 <!--<form action="https://demo.globalgatewaye4.firstdata.com/payment" method="post"> 
  <input name="x_login" value="WSP�EXA�001�01" type="hidden"> 
  <input name="x_amount" value="558.49" type="hidden"> 
  <input name="x_fp_sequence" value="123456" type="hidden"> 
  <input name="x_fp_timestamp" value="1191600622" type="hidden"> 
  <input name="x_fp_hash" value="4b04d15ccd9007658c2dadc679899ec4" type="hidden"> 
  <input name="x_show_form" value="PAYMENT_FORM" type="hidden"> 
  <input value="Checkout" type="submit"> 
  <input name="x_tax" value="26.59" type="hidden"> 
  <input name="x_freight" value="45.0" type="hidden"> 
  <input name="x_line_item" value="10<|>1999 Cabernet Sauvignon, 0.7 l<|>1999 Cabernet Sauvignon, 0.7 l <|>10<|>19.95<|>YES" type="hidden">  
 <input name="x_line_item" value="12<|>2003 Merlot, 0.7 l<|>2003 Merlot, 0.7 l<|>12<|>23.95<|>YES" type="hidden"> 
</form>-->

</body>
</html>
