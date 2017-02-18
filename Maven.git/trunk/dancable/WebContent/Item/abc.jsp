<%-- 
    Document   : abc
    Created on : Oct 27, 2014, 3:07:49 PM
    Author     : kapil
--%>

<%@page import="moreimg.function_int_foodmart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Main_category.item_bean"%>
<%
    HttpSession sesn=request.getSession(false);
    String mail="";
   ArrayList user_cart=new ArrayList();
    item_bean itb=new item_bean();   
   String loginid=(String)sesn.getAttribute("loginid");
   if(loginid==null)
        {
            out.print("eop");
        }
   else{
       try{
           int chkOd=0;
           double shp=0;
         if(sesn.getAttribute("shipping_charge")!=null)
            {
                shp=Double.parseDouble(sesn.getAttribute("shipping_charge").toString());
            }
    if(sesn.getAttribute("user_address")!=null)
   {
       itb=(item_bean)sesn.getAttribute("user_address");
   }
if(!loginid.equals("guest"))
{
    user_cart=(ArrayList)sesn.getAttribute("reg_user_cart_list");
    mail=(String)sesn.getAttribute("e_email");
    if(user_cart!=null)
    out.println("<input type='hidden' name='user_id' value='"+loginid+"'>");
}
else if(loginid.equals("guest"))
{
    user_cart=(ArrayList)sesn.getAttribute("cart_list");
    mail=(String)sesn.getAttribute("e_email");
    if(user_cart!=null){
        function_int_foodmart fn=new function_int_foodmart();
        String order_id=(String)sesn.getAttribute("order_id");
        chkOd=fn.checkQuestOrderIdInTemp("imd_cart",order_id);
        if(chkOd==0){
            fn.insert_imd_cart_guest_temp(user_cart, mail, itb, order_id, shp);
            out.println("<input type='hidden' name='user_id' value='guest'>");
        }
    }
}

    if(chkOd==0){
        
        String txn_type=(String)sesn.getAttribute("txn_type");
         int sz=user_cart.size();
    %>
  
<%if(txn_type.equals("preauth")){%>
<!--   Billing/Shipping details for first data   --> 
       <input type="hidden" name="bname" value="<%=itb.getBill_f_name()%> <%=itb.getBill_l_name()%>">    
        <input type="hidden" name="baddr1" value="<%=itb.getBill_street()%>">  
        <input type="hidden" name="baddr2" value="">  
        <input type="hidden" name="bcity" value="<%=itb.getBill_city()%>">  
        <%if(itb.getBill_state().equals("52")){%>
        <input type="hidden" name="bstate" value="<%=itb.getBill_state()%>">  
        <input type="hidden" name="bstate2" value="<%=itb.getBill_state2()%>"> 
        <input type="hidden" name="bstate1" value="<%=itb.getBill_state2()%>"><!--   Billing/Shipping details for website   --> 
        <%}else{%>
            <input type="hidden" name="bstate" value="<%=itb.getBill_state()%>"> 
            <input type="hidden" name="bstate1" value="<%=itb.getBill_state()%>"><!--   Billing/Shipping details for website   --> 
        <%}%>
        <%if(itb.getBill_country().equals("United States")||itb.getBill_country().equals("Canada")){%>
            <input type="hidden" name="bcountry" value="<%=itb.getBill_country()%>">  
            <input type="hidden" name="bcountry1" value="<%=itb.getBill_country()%>">  
        <%}else{%>
            <input type="hidden" name="bcountry" value="<%=itb.getBill_country()%>"> 
            <input type="hidden" name="bcountry1" value="<%=itb.getBill_country2()%>">  
        <%}%>
        <input type="hidden" name="bzip" value="<%=itb.getBill_zip()%>">  
        <input type="hidden" name="phone" value="<%=itb.getBill_phone()%>">  
        <input type="hidden" name="email" value="<%=mail%>">
        
       <!-- <input type="hidden" name="sname" value="">    
        <input type="hidden" name="saddr1" value="">  
        <input type="hidden" name="scity" value="">  
        <input type="hidden" name="sstate" value="">  
        <input type="hidden" name="scountry" value="">  
        <input type="hidden" name="szip" value="">  
        <input type="hidden" name="shphone" value="> -->
 <%}%>
<!--   Billing/Shipping details for website   --> 
        <input type="hidden" name="name1" value="<%=itb.getBill_f_name()%> <%=itb.getBill_l_name()%>">    
        <input type="hidden" name="baddr11" value="<%=itb.getBill_street()%>">  
        <input type="hidden" name="bcity1" value="<%=itb.getBill_city()%>">  
      <%if(txn_type.equals("sale")&&itb.getKind().equals("shipping request")&&itb.getShipmentTo().equals("international")){%>
        <input type="hidden" name="bstate1" value="<%=itb.getBill_state2()%>">
        <input type="hidden" name="bcountry1" value="<%=itb.getBill_country2()%>">  
      <%}
        else if(txn_type.equals("sale")&&itb.getKind().equals("shipping request")&&itb.getShipmentTo().equals("domastic")){%>
        <input type="hidden" name="bstate1" value="<%=itb.getBill_state()%>">
        <input type="hidden" name="bcountry1" value="<%=itb.getBill_country()%>">  
        <%}
        else if(txn_type.equals("sale")&&itb.getKind().equals("download request")&&itb.getShipmentTo().equals("international"))
{%>
        <input type="hidden" name="bstate1" value="<%=itb.getBill_state2()%>">
        <input type="hidden" name="bcountry1" value="<%=itb.getBill_country2()%>">  
      <%}else if(txn_type.equals("sale")&&itb.getKind().equals("download request")&&itb.getShipmentTo().equals("domastic")){%>
        <input type="hidden" name="bstate1" value="<%=itb.getBill_state()%>">
        <input type="hidden" name="bcountry1" value="<%=itb.getBill_country()%>"> 
      <%}%>
        <input type="hidden" name="bzip1" value="<%=itb.getBill_zip()%>">  
        <input type="hidden" name="phone1" value="<%=itb.getBill_phone()%>">  
        <input type="hidden" name="email1" value="<%=mail%>">
        
        <input type="hidden" name="name2" value="<%=itb.getShip_f_name()%> <%=itb.getShip_l_name()%>">    
        <input type="hidden" name="saddr12" value="<%=itb.getShip_street()%>">  
        <input type="hidden" name="scity2" value="<%=itb.getShip_city()%>">  
        <input type="hidden" name="sstate22" value="<%=itb.getShip_state()%>">  
        <input type="hidden" name="scountry2" value="<%=itb.getShip_country()%>">  
        <input type="hidden" name="szip2" value="<%=itb.getShip_zip()%>">  
        <input type="hidden" name="shphone2" value="<%=itb.getShip_phone()%>"> 
        
        <input type="hidden" name="shipTo" value="<%=itb.getShipmentTo()%>"> 
        <input type="hidden" name="kind" value="<%=itb.getKind()%>"> 
        <input type="hidden" name="sz" value="<%=sz%>">
        <input type="hidden" name="bilfname" value="<%=itb.getBill_f_name()%>">    
        <input type="hidden" name="billname" value="<%=itb.getBill_l_name()%>">    
        <input type="hidden" name="shipfname" value="<%=itb.getShip_f_name()%>">    
        <input type="hidden" name="shiplname" value="<%=itb.getShip_l_name()%>">  
<input type="hidden" name="shp" value="<%=shp%>">      
<input type="hidden" name="txn_type" value="<%=txn_type%>">         
        <%for(int i=0;i<sz;i++){
             itb=(item_bean)user_cart.get(i);
                    %>
            <input type="hidden" name="filename<%=i%>" value="<%=itb.getFilename()%>">          
            <input type="hidden" name="price<%=i%>" value="<%=itb.getPrice()%>">   
            <input type="hidden" name="quan<%=i%>" value="<%=itb.getQuantity()%>">   
            <input type="hidden" name="subtot<%=i%>" value="<%=itb.getSubtotal()%>">   
            <input type="hidden" name="itemid<%=i%>" value="<%=itb.getItem_id()%>">   
            <input type="hidden" name="subcatid<%=i%>" value="<%=itb.getSubcat_id()%>">   
            <input type="hidden" name="catid<%=i%>" value="<%=itb.getCat_id()%>"> 
            <input type="hidden" name="cartid<%=i%>" value="<%=itb.getCart_id()%>">   
            <%if(itb.getCartdate()!=null){%>
                <input type="hidden" name="cartdate<%=i%>" value="<%=itb.getCartdate()%>">   
            <%}%>
            <input type="hidden" name="prodid<%=i%>" value="<%=itb.getProd_id()%>">   
            <input type="hidden" name="brand<%=i%>" value="<%=itb.getBrand()%>">   
       <%}}
    else{
        out.print("eop");
    }
}catch(Exception e){out.print("eop");}
}%>          
       
       