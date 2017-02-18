


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
   <title>ALESSIO</title>
    <LINK REL="SHORTCUT ICON" HREF="<%=request.getContextPath()%>/aless/Alessio.ico">
      <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/pro_drop_1/laycss.css" />
            <script language="javascript" src="kk/resolution.js">
                
</script>
<script type="text/javascript" language="javascript"> 
   

 var newwindow = ''
function popitup(url) {
window.open(url,'jewelry','width=433,height=450,menubar=no,scrollbars=yes,resizable=1');
    
}




 

</script> 

    </head>
      

    <body>
   <%
    
         ArrayList ar=new ArrayList();
        
  String name="";
  String emailid="";
  
  emailid=(String)session.getAttribute("loginid").toString();
  
 
    
    
    
     %>
     
      <div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/all.js#xfbml=1";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
   <div id="conta">
	
         
           <div id="header" align="center">
               
                <div class="logo_img">
              <a href="<%=request.getContextPath()%>/fm_home.do?name=home"><img  src="./aless/Alessio-logo.png" border="0"></a></img>
             
             </div> 
              <div class="items">
                  <%@include file="/top_items.jsp" %>
              </div>
              <div class="searc">
                   <%@include file="/search_item.jsp" %>     
             </div>
            </div>
       
           <div id="headerb">
             
         
            <%@include file="/headmenu.jsp"%>
       
           
	</div>  
	  
        <div class="clear"></div>
       
 
<div id="body">
             <div class="bodyfull"> 
                <table border="0" width="100%" ALIGN="CENTER" bgcolor="#ffffff" height="350">
                 <tr>
<td VALIGN="TOP" width="20%" STYLE="PADDING-TOP:20PX">
    <table>
        <tr><td>Useful Links</td></tr>
        <tr><td><a href="Customer_ViewRegistration.do?method=viewCustomerRegist" style="text-decoration:none;color:grey">View Profile</a></td></tr>
        <tr><td><a href="Customer_EditRegistration.do?method=editCustomerRegist" style="text-decoration:none;color:grey">Update Profile</a></td></tr>
       <tr><td><a href="customer_order_range.do" style="text-decoration:none;color:grey">View Order</a></td></tr>
       <tr><td><a href="<%=request.getContextPath()%>/customer_logout.do?method=customer_logout" style="text-decoration:none;color:grey">Logout</a></td></tr>
       
    </table>
</td>
<td VALIGN="TOP">
                 
                 <TABLE  align="center" border="0" VALIGN="TOP">
   <tr><td STYLE="font-weight:bold;color:black;font-size:14px" align="center" height="40">Welcome&nbsp;'<%=emailid%>'</td></tr>

 <tr><td><table>
     
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
    itemlist=(ArrayList)request.getAttribute("cart_list");
  String username= (String)session.getAttribute("loginid");
 


 
    
     %>
        <%java.util.Date Dates=null;
      SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy"); %>  
     <table width="100%" border="1" bgcolor="white" cellspacing="0" cellpadding="0">        
 <tr><td><FONT STYLE="font-weight:bold;color:blue;font-size:15px">S.no.</font></td>
<td><FONT STYLE="font-weight:bold;color:blue;font-size:15px">Date</font></td>
<td><FONT STYLE="font-weight:bold;color:blue;font-size:15px">Customer Name</font></td>
<td><FONT STYLE="font-weight:bold;color:blue;font-size:15px">Pic</font></td>
<td><FONT STYLE="font-weight:bold;color:blue;font-size:15px">Size</font></td>
<td><FONT STYLE="font-weight:bold;color:blue;font-size:15px">Product ID</font></td>

<td><FONT STYLE="font-weight:bold;color:blue;font-size:15px">Price</font></td>
<td><FONT STYLE="font-weight:bold;color:blue;font-size:15px">Quantity</font></td>
<td><FONT STYLE="font-weight:bold;color:blue;font-size:15px">Subtotal</font></td>
 
 </tr>
     <%
    for(int t=0;t<itemlist.size();t++)
    {
  itembe=(item_bean)itemlist.get(t);
  
 price=itembe.getPrice();
 filename=itembe.getFilename();   
 image="http://198.38.92.30:9090/alessio/jewelry/"+filename;
    
     %>

     <tr>
<td><FONT STYLE="font-weight:bold;color:black;font-size:12px"><%=t+1%></td>
<td><FONT STYLE="font-weight:bold;color:black;font-size:12px"><%=sdf.format(itembe.getCartdate())%></td>
<td><FONT STYLE="font-weight:bold;color:black;font-size:12px"><%=itembe.getUsername()%></td>
<td width="50"><img  border="0" src="<%=image%>" width="50" height="70"></td>
      <td><FONT STYLE="font-weight:bold;color:black;font-size:12px"><%=itembe.getSize()%></td>
           <td><FONT STYLE="font-weight:bold;color:black;font-size:12px"><%=itembe.getProd_id()%></td>
        
    
       <td width="10%"><FONT STYLE="font-weight:bold;color:black;font-size:12px"><%=price%></td>
       
           <td><FONT STYLE="font-weight:bold;color:black;font-size:12px"><%=itembe.getQuantity()%></td>
            <td><FONT STYLE="font-weight:bold;color:black;font-size:12px"><%=itembe.getSubtotal()%></td>
          
        
           
      </tr>
      
   <%
    total=total+itembe.getSubtotal();
    }
     
      
   %>
   <tr><td colspan="8" align="right"><FONT STYLE="font-weight:bold;color:red;font-size:15px">Total($)</font></td><td><FONT STYLE="font-weight:bold;color:red;font-size:15px"><%=total%></font></td></tr>
   <%
     }%>    
     
 </table>
  </td></tr>
 </table></td></tr>

   
  </table>   </td></tr>
  
  
  
  </TABLE>
   </div>
   
   
 <div class="clear"></div>
        <div id="footerone" align="center"></div>
        <div class="clear"></div>
        
        <div id="footer">
         
            <table  border="0" align="center" style="padding-right:30px;"> 
     
         
       <tr><td>  <table class="tablefoot">
<tr><td> 
 <A href="./Faq.jsp" STYLE="TEXT-DECORATION: NONE"><font color="grey">FAQ </a>
| <A href="./Sitemap.jsp" STYLE="TEXT-DECORATION: NONE"><font color="grey">SITEMAP </a>
    
   |<A href="./fm_home.do?name=gb" STYLE="TEXT-DECORATION: NONE"><font color="grey">GIVING BACK </a>
| <A href="#" STYLE="TEXT-DECORATION: NONE"><font color="grey">SHIPPING </a>
    
 |<A href="./fm_home.do?name=career" STYLE="TEXT-DECORATION: NONE"><font color="grey">CAREERS </a>
| <A href="./Term.jsp" STYLE="TEXT-DECORATION: NONE"><font color="grey">TERM </a>
  |<A href="./privacy.jsp" STYLE="TEXT-DECORATION: NONE"><font color="grey">PRIVACY</a>
| <A href="./Copyright.jsp" STYLE="TEXT-DECORATION: NONE"><font color="grey">COPYRIGHT </a>&nbsp;
  <div class="fb-like" data-href="http://www.facebook.com/alessiobrands" data-send="false" data-width="206" data-show-faces="false" data-font="verdana" data-colorscheme="dark"></div>
    <a href="http://www.facebook.com/alessiobrands" target="_blank"><img src="./aless//facebook.gif" height="21px" style="border-style:none;" alt="Share on Facebook" /></a>&nbsp;&nbsp;
  <a href="http://twitter.com/share?url=www.alessiobrands.com&text=Imagine walking into any room feeling confident beautiful & fabulous %0ALive a more exciting life live an ALESSIO life.%0Awww.alessiobrands.com" target="_blank">
 <img src="./aless/twitter.gif" height="21px" style="border-style:none;" alt="Share on Twitter" /></a>
       
  </td></tr>  
            <tr><td align="center"> </td></tr> 
       
       </table>             
</td></tr>
                
       </table>
	</div>
        
</div>
    
    
    </body>
</html>
