<%-- 
    Document   : genPromoCode
    Created on : Jan 25, 2014, 6:59:02 PM
    Author     : kapil
--%>

<%@page import="java.util.Random"%>
<%
    response.setHeader("Cache-Control","no-cache");
    response.setContentType("text/html");
    
    Random randomGenerator = new Random();
    StringBuffer sb=new StringBuffer("1000");
      int randomInt = randomGenerator.nextInt(1000);
      sb=sb.append(Integer.toString(randomInt));
      randomInt = randomGenerator.nextInt(1000);
      sb=sb.append(Integer.toString(randomInt));
      randomInt = randomGenerator.nextInt(1000);
      sb=sb.append(Integer.toString(randomInt));
      randomInt = randomGenerator.nextInt(1000);
      sb=sb.append(Integer.toString(randomInt));
      //out.println(sb);
      %>
<b>New Promotional Code: 
                 <span onclick="applyToAll()" style="cursor: pointer;color:red" id="code"><%=sb%></span>
             </b>