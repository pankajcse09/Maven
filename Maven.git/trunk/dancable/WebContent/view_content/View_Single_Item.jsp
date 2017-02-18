  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

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
        <title>T Salon</title>
         
         
         <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/pro_drop_1/laycss.css" />
         <link rel="stylesheet" type="text/css" href="prop_drop/pro_drop.css" />
          <script language="javascript" src="kk/resolution.js">   
  </script>
      <script langyage="javascript">
              function roundNumber(myNum,numOfDec){ 
var decimal = 1 
for(i=1; i<=numOfDec;i++){ 
decimal = decimal *10;
}
var myFormattedNum = (Math.round(myNum * decimal)/decimal).toFixed(numOfDec) 
return myFormattedNum; 
}
            function get_total()
            {
            document.forms[0].total.value=roundNumber((parseFloat(document.forms[0].price.value)*parseFloat(document.forms[0].quantity.value)),2);
            }
        </script>
    </head>
    <body>
         <div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/all.js#xfbml=1";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
   
	<div id="container" align="center">
    <div id="cont_1">
 <%@include file="/head.jsp"%>
    </div>
     <div style="clear: both" ></div>
   <div bgcolor="#ffffff">
       <table id="tbl" width="100%" align="center">
            <tr><td align="center">
                <%@include file="/Top_menu.jsp"%>
            </td></tr>
        </table> 
    </div>
        <div class="clear"></div>
        <div style="margin: 70px 0px 50px 0px">
        <table bgcolor="white" align="center" width="100%"><tr><td>
<div id="body_1">
        
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
    
<tr>

<td width="80%" height="75%" valign="top"> 
     <%
       int starta=0;
       int enda=0;
          if(request.getAttribute("starta")!=null)
    {
          starta=Integer.parseInt((String)request.getAttribute("starta").toString());
          
          }
            if(request.getAttribute("enda")!=null)
    {
           enda=Integer.parseInt((String)request.getAttribute("enda").toString());
           
            }
          
    
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
   int avail=0;
          item_bean itembe=new item_bean();
          ArrayList itemlist=new ArrayList();
    itemlist=(ArrayList)request.getAttribute("itemlist");
   
    String username="";
  username= (String)session.getAttribute("loginid");
    //out.println("Welcome-"+username);


    //out.println(sellist);
    try{
      if(request.getAttribute("avail")!=null){
          avail=Integer.parseInt((String)request.getAttribute("avail"));
      }
  }
  catch(Exception e){}

     %>
     <table width="100%" border="0" bgcolor="white" cellspacing="0" cellpadding="0" align="center">
         <form method="post" action="create_cart.do?method=create_cart">

     <%
    for(int t=0;t<itemlist.size();t++)
    {
  itembe=(item_bean)itemlist.get(t);
  
   price=itembe.getPrice();
   filename=itembe.getFilename();
   unit=itembe.getUnit();
 marketprice=itembe.getMarketprice();
   //out.println(filename);
// image=request.getContextPath()+"/Imge/"+filename;
 subcat_id=itembe.getSubcat_id();
    //out.println(image);
     // out.println(config.getServletContext()+"/Imge/"+filename);
     %>


     <tr>
<td align="left" width="30%">
    <table height="300" border="0" width="100%">
<tr>
<td style="padding-left:100px" align="left">
<img  border="0" src="./Tea_image/<%=itembe.getFilename()%>" width="225" height="265"></td></tr></table>
</td>

<td valign="top" width="50%" style="padding-left: 0px">
           <table border="0" width="100%">
               <tr><td valign="top" style="padding-left: 180px"><table><tr><td>Welcome-<%=""+username%>
                               <%if(!username.equalsIgnoreCase("guest")){%>
                               <a href="<%=request.getContextPath()%>/customer_logout.do?method=customer_logout">Logout</a></td>
                               <%}%>
                           </tr></table></td></tr>  
 
               <tr><td valign="top" style="padding-top: 40px;"><table cellpadding="5" cellspacing="3" border="0" 
    style=" FONT-FAMILY: Avenir-Heavy, Helvetica,SALFrutiger-Medium, FrutigerLTStd-Bold,SALFrutiger-Medium,Helvetica,Candara,AvantGarde Bk BT, Arial, sans-serif, Verdana;font-weight: normal;
    LETTER-SPACING: 1px;TEXT-ALIGN: justify;;font-size: .7em;color:black;border-collapse:collapse;border:0px solid white">
           <tr><td valign="top">Product ID:</td><td valign="top" align="left"><%=itembe.getProd_id()%></td></tr>
    <tr><td  valign="top">Description:</td><td valign="top" align="left" width="200"><%=itembe.getDetail()%></td></tr>
    <tr><td valign="top" width="110">Size:</td><td valign="top" align="left"><%=itembe.getUnit()%></td></tr>
    
              <input type="hidden" name="size" value="<%=itembe.getUnit()%>">
    
    
                <tr><td valign="top">Quantity: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><input type="text" name="quantity" size="8"  onblur="get_total()"></td></tr>
                <tr><td valign="top">Price: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><input type="text" name="total" size="8" readonly></td></tr>
                
          
           
           <!--<tr>
             <td><input type="text" name="quantity" size="15"  onblur="get_total()"></td>
           
           <td><input type="text" name="total" size="15" readonly></td>
           
            <td><select name="size" >
                <%for(int l=starta;l<=enda;l++){%>
                <option value="<%=l%>"><%=l%></option>
                <%}%>
            </select></td>
            <% if(avail!=0){%>
            <td style="padding-left: 5px"><font color="green">In Stock</font></td>
            <%}
            else{%>
            <td style="padding-left: 5px"><font color="red">Out Of Stock</font></td>
            <%}%>

               </tr>-->
           <input type="hidden" name="itemid" value=<%=new Integer(itembe.getItem_id()).toString()%>>
           <input type="hidden" name="scid" value=<%=new Integer(itembe.getSubcat_id()).toString()%>>
            <input type="hidden" name="username" value=<%=username%>>
          <input type="hidden" name="brand" value=<%=itembe.getBrand()%>>
           <input type="hidden" name="filename" value=<%=filename%>>
           <input type="hidden" name="price" value="<%=price%>">
           <input type="hidden" name="size" value="<%=itembe.getUnit()%>">
           <input type="hidden" name="prod_id" value="<%=itembe.getProd_id()%>">
 
           
           
      
                       </table></td></tr></table></td>
           
  </tr>
           
           <tr><td colspan="2" valign="top"><table bgcolor="white" width="100%" border="0"><tr>
               <td colspan="0" height="70" style="padding-left: 350px;color:black"> </td>
               <td ></td>
               
           
               <td  align="center" colspan="0" height="40" style="padding-right:400px"><input type="submit" value="Add to Cart"></td></tr>
     
      </table></td></tr>
   <%}
     
     }%>    
         
       </form>
 </table>
  </td></tr>
       </table>
                   </div></td></tr></table>
        </div>
       <div class="clear"></div>
        <div>
<%@include file="/foot.jsp"%>
  </div>
       
      </div>   
 </body>
           
 </html>

