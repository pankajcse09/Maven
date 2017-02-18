<%-- 
    Document   : savePromoCodeForProd
    Created on : Jan 25, 2014, 6:02:32 PM
    Author     : kapil
--%>

<%@page import="mc_operat.Mc_funct"%>
<%@page import="mc_bean.mc_prop"%>
<%
    response.setHeader("Cache-Control","no-cache");
    response.setContentType("text/html");
    
    String en=request.getParameter("en");
    String cn=request.getParameter("cn");
    String fta=request.getParameter("fta");
    String id=request.getParameter("it");
    mc_prop mc=new mc_prop();
    
    mc.setItem_id(Integer.parseInt(id));
    mc.setPromo(en);
    mc.setPromo_discount(Double.parseDouble(cn));
    mc.setPromo_discountdetail(fta);
    
    Mc_funct mct=new Mc_funct();
    mct.upadatePromoOfItem(mc);
    
    StringBuffer sb=new StringBuffer(":");
    sb=sb.append(en);
    sb=sb.append(":");
    sb=sb.append(cn);
    sb=sb.append(":");
    sb=sb.append(fta);
    sb=sb.append(":");
    sb=sb.append(id);
    sb=sb.append(":");
out.println(sb);  
    %>
