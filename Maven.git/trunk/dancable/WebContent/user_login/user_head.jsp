<%-- 
    Document   : user_head
    Created on : Aug 24, 2013, 12:15:01 PM
    Author     : kapil
--%>
<%@page import="ActionClass.LoginDataObject"%>
<%@page import="moreimg.function_int_foodmart"%>
<%@page import="Main_category.item_bean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DecimalFormat"%>
<%
    NumberFormat formattr = new DecimalFormat("#0.00");

  
   String usernm="";
     if(session.getAttribute("loginid")!=null)
     {
         usernm=(String)session.getAttribute("loginid");
     }
 //out.println("Check Login Session: "+usernm);    
     ArrayList cartDt=new ArrayList();
     item_bean itmbe=new item_bean();
     function_int_foodmart fu=new function_int_foodmart(); 
        LoginDataObject lb=new LoginDataObject();
     double ttamnt=0.0;
     int ttqnt=0;
     
       if( session.getAttribute("cart_list")!=null )
         {
             cartDt=(ArrayList)session.getAttribute("cart_list");    
                     
          }else{
               if(request.getAttribute("cart_list")!=null){
                    cartDt=(ArrayList)request.getAttribute("cart_list");    
               }
               else if(!usernm.equals("guest")&&!usernm.equals(""))
               {
                   cartDt=(ArrayList)fu.get_cart_despatch(usernm);
                   //out.println(usernm);
               }
            }
  if(cartDt.size()!=0)
    {
   for(int t=0;t<cartDt.size();t++)
    {
  itmbe=(item_bean)cartDt.get(t);
  ttamnt=ttamnt+itmbe.getSubtotal();
    ttqnt=ttqnt+itmbe.getQuantity();
    }
    }
   %> 
<div id="av">
    <div class="wishshop">
        
       <div class="shopping">
                  <div class="shp_txt">
                    <!--<span class="inner1_2 txt"><a href="<%=request.getContextPath()%>/chekout_cart.do?method=checkout_cart" class="lnkk"> SHOPPING CART</a></span>-->
                    <span id="cartmg"><a href="<%=request.getContextPath()%>/chekout_cart.do?method=checkout_cart">
                            <img src="<%=request.getContextPath()%>/images/shop_cart.png" width="30" height="25" style="border: 0"></a></span>
                    <span class="cartdt"><a href="<%=request.getContextPath()%>/chekout_cart.do?method=checkout_cart" class="shp_item">Items: 
                            <span id="items"><%=ttqnt%></span> &nbsp;$<%=formattr.format(ttamnt)%></a>
                    </span>
              </div>
                    <div id="shp_cart" class="shp">
    <%
     if(ttqnt!=0){
%>
<span class="sh"><u><font style="color: green;">Welcome to our shopping cart.</font></u>
                            <br>You have in your shopping bag- <font style="color: #3C2C2F;"><%=ttqnt%></font> items<br>
                        Total Amount- $<%=formattr.format(ttamnt)%>
                        </span>
       <%}else{%>      
       <span class="sh">You have no items in your shopping cart.</span>
       <%}%>
                        </div>
       </div>
    <% if(!usernm.equals("")&&!usernm.equals("guest")){
                    %>
    <div class="wishlist">
        <a href="<%=request.getContextPath()%>/mywishlist.do?method=retrieve_wishlist" class="lnkk">Wishlist</a>&nbsp;|&nbsp; 
    </div>
    <%}%>                    
    </div>                 
                  </div>
       
<% 
String email="";
     if(session.getAttribute("loginid")!=null)
     {
         email=(String)session.getAttribute("loginid");
     }
     %>
     
     <div class="login">
         <div class="wishshop">
         <div style="float: right;">
         <%
if(!email.equals("")&&!email.equals("guest"))
{
    
%>
<a href="<%=request.getContextPath()%>/customer_logout.do?method=customer_logout" style="text-decoration:none;color:white">&nbsp;Logout</a>
         </div>
         <div style="float: right;">
             <%
    out.print(email);
    out.print("  |  ");
    }%>
         </div>
         </div>
</div>