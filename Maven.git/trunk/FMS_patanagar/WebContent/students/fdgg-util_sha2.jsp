<%-- 
    Document   : fdgg-util_sha2
    Created on : Oct 6, 2014, 12:16:12 PM
    Author     : kapil
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" 
         import="java.util.Date, java.util.TimeZone, java.security.MessageDigest, java.text.SimpleDateFormat" %>
<%! 
String storeName="1909143507"; // Replace with your Storenumber here Test
String sharedSecret = "31373738353035303837313634363533373734363234363533343039353531323239363132393830353234313537303633353732313235303530383034303038";

//String storeName="1001233599"; // Replace with your Storenumber here Live
//String sharedSecret = "39313539393430343135303230323133373835303331323533323432303035353435393634343233323433363630363737373632313638363334363732313132"; //Replace with your Shared Secret here 
/* --- */ 
private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy:MM:dd-HH:mm:ss"); 
String fmtDate; String timeZone; 
public String createHash(String charge) { 
/* If you Don't want to set the Default TimeZone, 
then you have to do the following changes to set your server timeZone: 
Example: If your server is in PST timezone, here are the changes: 
//TimeZone.setDefault(TimeZone.getTimeZone("Asia/Calcutta")); // Comment this line 
timeZone = "PST"; // change to your server timeZone */ 
    
TimeZone.setDefault(TimeZone.getTimeZone("Asia/Calcutta"));
timeZone = "IST"; 
    //System.out.println("timezone1: "+timeZone);
    //System.out.println("timezone2: "+TimeZone.getAvailableIDs());
//TimeZone.setDefault(TimeZone.getTimeZone("America/New_York"));
    
    
//timeZone = "EST";   

//TimeZone.setDefault(TimeZone.getTimeZone("America/Los_Angeles"));
//timeZone = "PST";    

/* --- */
 Date now = new java.util.Date(System.currentTimeMillis()); 
fmtDate = dateFormat.format(now); 
String stringToHash = storeName + fmtDate + charge + sharedSecret; 
return calculateHashFromHex(new StringBuffer(stringToHash)); 
} 
private String calculateHashFromHex(StringBuffer buffer) 
{ 
String algorithm = "SHA-256"; 
MessageDigest messageDigest = null; 
try { 
    messageDigest = MessageDigest.getInstance(algorithm); 
} catch (Exception e) { 
throw new IllegalArgumentException("Algorithm '" + algorithm + "' not supported");
 } 
StringBuffer result = new StringBuffer(); 
StringBuffer sb = new StringBuffer(); 
byte[] bytes = buffer.toString().getBytes();
int byteLen = bytes.length;
for (int i = 0; i < byteLen; i++) 
{ 
    byte b = bytes[i];
    sb.append(Character.forDigit((b & 240) >> 4, 16));
    sb.append(Character.forDigit((b & 15), 16)); 
} 
buffer = new StringBuffer(sb.toString()); 
messageDigest.update(buffer.toString().getBytes()); 
byte[] message = messageDigest.digest(); 
int messageLen = message.length; 
for (int j = 0; j < messageLen; j++) 
{ 
    byte b = message[j];
    String apps = Integer.toHexString(b & 0xff); 
    if (apps.length() == 1) 
    { 
        apps = "0" + apps; 
    } 
    result.append(apps); 
} 
return result.toString(); 
} 
public String getTimeZone() 
{ 
    return timeZone;
 } 
public String getStoreName() 
{ 
    return storeName;
 } 
public String getFormattedSysDate() { 
    return fmtDate;
} %>
