<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@page import ="Main_category.item_bean"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.*"%>
<%@page import="java.sql.Timestamp"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>T Salon</title>
    </head>
    <body>
    <table align="left">
        <tr><td valign="top">         
     <%
    
             if((ArrayList)request.getAttribute("cart_list")!=null)
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
   double total=0.0;
          item_bean itembe=new item_bean();
          ArrayList itemlist=new ArrayList();
          String frodate="";
       String todate="";
    itemlist=(ArrayList)request.getAttribute("cart_list");
   
   String username= (String)session.getAttribute("loginid");
   
    frodate=(String)request.getAttribute("fd");
    todate=(String)request.getAttribute("td");
    
  //  out.println("frodate"+frodate);
    //out.println("todate"+todate);
    out.println("Welcome-"+username);


 
    
     %>
        <%java.util.Date Dates=null;
      SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy"); %>  
     <table width="100%" border="1" bgcolor="white" cellspacing="0" cellpadding="0">     
   <form method="post" action="update_status.do?method=update_Status">
 <tr><td>S.no.</td><td>Date</td><td>Customer Name</td><td>pic</td><td>price</td><td>quantity</td><td>subtotal</td><td>update status</td></tr>
     <%
    for(int t=0;t<itemlist.size();t++)
    {
  itembe=(item_bean)itemlist.get(t);
  
 price=itembe.getPrice();
 filename=itembe.getFilename();   
 image=request.getContextPath()+"/Imge/"+filename;
 
    
     %>
     <tr>
<td><%=t+1%></td>
<td><%=sdf.format(itembe.getCartdate())%></td>
<td><%=itembe.getUsername()%></td>
<td width="50"><img  border="0" src="<%=image%>" width="50" height="70"></td>
   
       <td width="10%"><%=price%></td>
       
           <td><%=itembe.getQuantity()%></td>
            <td><%=itembe.getSubtotal()%></td>
          
        <td><select name="status<%=t%>">
            <%if(!itembe.getStatus().equals("")){%>
 <option value="<%=itembe.getStatus()%>"><%=itembe.getStatus()%></option>      
<%}if(!itembe.getStatus().equals("NOT DELIVERED")){%>
           <option value="NOT DELIVERED">NOT DELIVERED</option>   
 <%}if(!itembe.getStatus().equals("DELIVERED")){%>     
             <option value="DELIVERED">DELIVERED</option>           
              <%}%>
        </select>
        </td>
           
      </tr>
      <input type="hidden" name="orderid<%=t%>" value="<%=itembe.getOrder_id()%>">
   <%
    total=total+itembe.getSubtotal();
    }
     
      
   %>
   <tr><td colspan="6" align="right">Total(RS)</td><td><%=total%></td></tr>
   <%
      
   %>
   <input type="hidden" name="frodate" value="<%=frodate%>">  <input type="hidden" name="todate" value="<%=todate%>">
     
    <tr><td colspan="6" align="right"><input type="submit" name="" value="Update Status"></td></tr>
   <%
     }%>    
     </form>
 </table>
 
  </td></tr>
  </table>
 </body>
 </html>