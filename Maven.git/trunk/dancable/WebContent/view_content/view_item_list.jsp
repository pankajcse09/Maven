 

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@page import ="Main_category.item_bean"%>

<%@page import="java.util.ArrayList" %>
<%@page import="java.util.*"%>
<%@page import="java.sql.Timestamp"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danceables</title>
    </head>
    <body>
    <table align="left">
         
        <tr><td valign="top">
      
    
     <%
    
             if((ArrayList)request.getAttribute("itemlist")!=null)
    {
    
     String unit="";
  String status="";
   String brand="";
    String prod_id="";
   double price=0.0;
   String size="";    
   int subcat_id=0;
   String filename="";  
     String detail="";
    double marketprice=0.0;
      double discount=0.0;
       String discountdetail="";
      String image="";
   int itemid=0;
          item_bean itembe=new item_bean();
          ArrayList itemlist=new ArrayList();
    itemlist=(ArrayList)request.getAttribute("itemlist");

    //out.println(sellist);
    
     %>
     <table width="100%" border="1" bgcolor="white" cellspacing="0" cellpadding="0">
 
     <%
    for(int t=0;t<itemlist.size();t++)
    {
  itembe=(item_bean)itemlist.get(t);
  
   price=itembe.getPrice();
   filename=itembe.getFilename();
   unit=itembe.getUnit();
 marketprice=itembe.getMarketprice();
   //out.println(filename);
 image=request.getContextPath()+"/Imge/"+filename;
 subcat_id=itembe.getSubcat_id();
    //out.println(image);
     // out.println(config.getServletContext()+"/Imge/"+filename);
     %>




     <tr><td width="50"><img  border="0" src="<%=image%>" width="50" height="70"></td>
   
       <td width="10%">Price <%=price%>/<%=unit%> </td>
         <td width="10%">Market Price <%=marketprice%>/<%=unit%> </td>
           
           <td><a href="<%=request.getContextPath()%>/get_peritem.do?method=get_perItem&scid=<%=new Integer(subcat_id).toString()%>&itemid=<%=new Integer(itembe.getItem_id()).toString()%>" target="_top"><b>Add</b></a></td>
 
           
      </tr>
      
   <%}
     
     }%>    
      
       
 </table>
  </td></tr>
  </table>
 </body>
 </html>