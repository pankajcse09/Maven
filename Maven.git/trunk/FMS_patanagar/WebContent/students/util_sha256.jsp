<%-- 
    Document   : util_sha256
    Created on : Jan 17, 2015, 12:04:01 PM
    Author     : kapil
--%>

<%@ page import="java.util.*" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="java.security.*" %>

<%!
public boolean empty(String s)
	{
		if(s== null || s.trim().equals(""))
			return true;
		else
			return false;
	}
%>
<%!
String testKey="gtKFFx";
String testSalt="eCwWELxi";

String liveKey="jLgSJY";
String liveSalt="uuzv2ehl";
	public String hashCal(String type,String str){
		byte[] hashseq=str.getBytes();
		StringBuffer hexString = new StringBuffer();
		try{
		MessageDigest algorithm = MessageDigest.getInstance(type);
		//algorithm.reset();
		algorithm.update(hashseq);
		byte messageDigest[] = algorithm.digest();
            
		

		for (int i=0;i<messageDigest.length;i++) {
			String hex=Integer.toHexString(0xFF & messageDigest[i]);
			if(hex.length()==1) hexString.append("0");
			hexString.append(hex);
		}
			
		}catch(NoSuchAlgorithmException nsae){ }
		
		return hexString.toString();


	}
        public String getTestKey(){
            return testKey;
        }
        public String getTestSalt(){
            return testSalt;
        }

        public String getLiveKey(){
            return liveKey;
        }
        public String getLiveSalt(){
            return liveSalt;
        }
%>
<%
//out.print(hashCal("SHA-512","C0Dr8m|12345|10|Shopping|Test|test@test.com||abc||15|||||||3sf0jURk"));
//out.print("<br>");
//out.print(hashCal("SHA-512","gtKFFx|TR1501172050384342|4415.0|Kapil-45835|Kapil|kapilsaini0506@gmail.com|45835|2014-2015|II||||||||eCwWELxi"));
%>


