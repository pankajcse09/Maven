<%@page import="javax.mail.Transport"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="ActionClass.Common"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.mail.PasswordAuthentication"%>
<%@page import="javax.mail.Session"%>
<%@page import="javax.mail.Authenticator"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ page import="moreimg.function_int_foodmart"%>
<%@page import ="Main_category.item_bean"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Response Page</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/pro_drop_1/laycss.css" />
         <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/prop_drop/pro_drop.css" />
         
                 
</head>
<body>
    <script language="javascript">
   if(screen.width==1024)
	 {
            document.write("<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/css_js/lay.css' />"); 
          }
 else if(screen.width==1280)
  	{
            document.write("<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/css_js/lay_1.css' />"); 
	}

else if(screen.width==1360)
  	{
            document.write("<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/css_js/lay_2.css' />"); 
	}
else 
{ 
    document.write("<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/css_js/lay_2.css' />"); 
}
document.write("<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/css/change.css' />");

</script>
        <% 
        out.println("saini: "+request.getParameter("bname"));
       double shp=0.0;
       String mail="";
   ArrayList user_cart=new ArrayList();
   item_bean itb=new item_bean();
   function_int_foodmart fun=new function_int_foodmart();
   String loginid=(String)session.getAttribute("loginid");
   //out.println("loginid: "+loginid);
   if(session.getAttribute("user_address")!=null)
   {
       itb=(item_bean)session.getAttribute("user_address");
   }
   if(session.getAttribute("shipping_charge")!=null)
   {
       shp=Double.parseDouble(session.getAttribute("shipping_charge").toString());
   }
   //out.println(session.getAttribute("loginid")+"  "+shp);
if(!loginid.equals("guest"))
{
    user_cart=(ArrayList)session.getAttribute("reg_user_cart_list");
    mail=(String)session.getAttribute("e_email");
    //fun.det_user_cart(session.getAttribute("loginid").toString());
    //fun.insert_imd_cart_order(user_cart);
    //out.println(user_cart+" "+user_cart.size());
}
else if(loginid.equals("guest"))
{
    user_cart=(ArrayList)session.getAttribute("cart_list");
    mail=(String)session.getAttribute("e_email");
    
    //session.removeAttribute("cart_list");
    //out.println(user_cart+" "+user_cart.size());
}
   String order_id=(String)session.getAttribute("order_id");
   session.removeAttribute("e_email");
   session.removeAttribute("order_id");
   //out.println("status: "+request.getParameter("status"));
   %>  
   
 <% //if(request.getParameter("status").equals("APPROVED")) { 
if(!loginid.equals("guest"))
{
    fun.det_user_cart(loginid);
}
else if(loginid.equals("guest"))
{
    session.removeAttribute("cart_list");
}
//}
 SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
   java.util.Date order_date=new java.util.Date();
   String kd=itb.getKind();
   //mail="kapilsaini2009@gmail.com";
 %>   
 
 
 
<table width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td>
                    <div id="topdesign">
                       <div class="header1">
                           <img src="<%=request.getContextPath()%>/images/homepage/logo_03.png" width="253">
                               </div>
                            <div class="header2">
                                <div class="user"><%@include file="/user_login/user_head.jsp"%></div>
                                <div class="header2_2"><%@include file="/top_menu.jsp"%></div>
                            </div>

                        </div>
                </td>
            </tr>
            <tr><td>
        <div style="margin: 70px 0px 50px 0px">
         <%if(loginid.equals("guest"))
            {
                //session.removeAttribute("cart_list");
%>
            <table width="80%"><tr><td align="right"><%="Welcome: "+loginid%></td></tr></table>
            <%}%>
 <div>
     <% 
int itm=0;
double pr=0.00;
double prt=0.00;
//if(request.getParameter("status").equals("APPROVED")) {
%>        
<%
    try{
        NumberFormat formatter = new DecimalFormat("#0.00");
        
  
   //out.println(session.getAttribute("loginid"));

%>                
                
                

	<table width="80%" border="0" align="center">
            
            <tr><td colspan="2" align="center"><p>
     Your payment was processed successfully.
     Here is your order receipt.
   </p>
  <% //if(request.getParameter("exact_issname") != null) { %>
     <!--<p>
       Issuer:     <%//=request.getParameter("exact_issname")%><br/>
       Confirmation Number:     <%//=request.getParameter("exact_issconf")%>
     </p>-->
   <% //} %>       
                </td></tr>
            <!--<tr><td colspan="2" width="100%" align="center"><h2><%//=request.getParameter("x_response_reason_text")%></h2></td></tr>-->
                    <tr><td width="10%"><img src="<%=request.getContextPath()%>/images/homepage/logo_03.png" width="100%"></td>
<td valign="top" align="left">Contact Us: 917-656-5290 || danceables@hotmail.com  <br>
P O BOX 230185, New York, NY 10023
</td>
</tr>
<tr><td colspan="2"><hr></td></tr>
<tr><td colspan="2" width="100%">
    <table width="100%">
        <tr>
            <td valign="top" width="33%"><table>
<tr><td><b>Order ID:</b> <%=order_id%></td></tr>
<tr><td><b>Order Date:</b> <%=sdf.format(order_date)%></td></tr>
<tr><td><b>Email:</b> <%=mail%></td></tr>
            </table></td>
            <td valign="top" width="33%"><table>
<tr><td><b>Billing Address</b></td></tr>
<tr><td>
    <%=itb.getBill_f_name()+" "+itb.getBill_l_name()%><br>
    <%=itb.getBill_street()+", "%><%=itb.getBill_city()+","%><br>
    <%=itb.getBill_zip()+", "%><%=itb.getBill_state()+","%><br>
    <%=itb.getBill_country()%><br>
    Phone: <%=itb.getBill_phone()%><br>
</td></tr>
            </table></td>
     <%if(!itb.getKind().equals("download request")){%>       
            <td valign="top"><table>
<tr><td><b>Shipping Address</b></td></tr>
<tr><td>
    <%=itb.getShip_f_name()+" "+itb.getShip_l_name()%><br>
    <%=itb.getShip_street()+", "%><%=itb.getShip_city()+","%><br>
    <%=itb.getShip_zip()+", "%><%=itb.getShip_state()+","%><br>
    <%=itb.getShip_country()%><br>
    Phone: <%=itb.getShip_phone()%><br>
</td></tr>
            </table></td>
    <%}%>        
        </tr>
    </table>
</td></tr>
<tr><td colspan="2"><hr></td></tr>

<tr><td colspan="2" width="100%">
    <table width="100%">

<tr><td><b>Product</b></td><td><b>Product Code</b></td><td align="right"><b>Quantity</b></td><td align="right"><b>Price</b></td><td align="right"><b>Total</b></td></tr>
<tr><td colspan="5"><hr></td></tr>
<%
if(user_cart.size()!=0){
                    for(int k=0;k<user_cart.size();k++){
                    item_bean itbm=(item_bean)user_cart.get(k);
                    itm=itm+itbm.getQuantity();
                    pr=pr+itbm.getPrice();
                    prt=prt+itbm.getSubtotal();
%>
<tr><td><%=itbm.getBrand()%></td>
    <td><%=itbm.getProd_id()%></td>
<td align="right"><%=itbm.getQuantity()%></td>
<td align="right"><%=formatter.format(itbm.getPrice())%></td>
<td align="right"><%=formatter.format(itbm.getSubtotal())%></td>
    </tr>
    <tr><td colspan="5"><hr></td></tr>
    <%}}%>
    <tr><td align="right" colspan="2"><b>Total</b></td><td align="right"><b><%=itm%></b></td>
        <td align="right"><b><%=formatter.format(pr)%></b></td><td align="right"><b><%=formatter.format(prt)%></b></td></tr>
    <tr><td colspan="5"><hr></td></tr>
    <%if(!itb.getKind().equals("download request")){%>
    <tr><td colspan="4" align="right"><b>Shipping Charge</b></td><td align="right"><b><%=formatter.format(shp)%></b></td></tr>
    <%}%>
    <tr><td colspan="4" align="right"><b>Grand Total</b></td><td align="right"><b><%=formatter.format(prt+shp)%></b></td></tr>
    <tr><td colspan="5"><hr></td></tr>
    </table>
</td></tr>
                </table>
                
<%

if(!loginid.equals("guest"))
{
    //fun.det_user_cart(session.getAttribute("loginid").toString());
    fun.insert_imd_cart_order(user_cart,itb,order_id,shp);
     session.removeAttribute("reg_user_cart_list");
}
   if(loginid.equals("guest"))
{
    fun.insert_imd_cart_order_guest(user_cart,mail,itb,order_id,shp);
    //session.removeAttribute("cart_list");
//    session.removeAttribute("guest_mail");
    //out.println(user_cart+" "+user_cart.size());
}
session.removeAttribute("shipping_charge");
session.removeAttribute("user_address");
%>                
                
<%                
  try{
       Properties props=new Properties();
       props.put("mail.transport.protocol","smtp");
       props.put("mail.smtp.host","mail.saveafemale.com");
       props.put("mail.smtp.auth", "true");
       props.put("mail.stmp.port","25");
           
            //Session sess = Session.getInstance(props);
            Session sess=Session.getInstance(props,new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("sales@saveafemale.com","dance123"); // username and the password
                }
 });
               //order_id="10320938545";
       MimeMessage msg1=new MimeMessage(sess);     
       Common comLogin = new Common();
       //String user=comLogin.jumbleData(mail);
       String user=mail;
       String dt=comLogin.jumbleData(order_id);
       
       StringBuffer msg=new StringBuffer("<table><tr><td>***** Please DO NOT REPLY to this automated message. *****<br><br>");
       msg=msg.append("<b>Your Order No.: </b>"+order_id+"<br>");
       msg=msg.append("<b>Total Quantity: </b>"+itm+"<br>");
       msg=msg.append("<b>Sub Total: </b>$"+prt+"<br>");
       msg=msg.append("<b>Shipping: </b>$"+shp+"<br>");
       msg=msg.append("<b>Total: </b>$"+(shp+prt)+"<br><br>");
       if(kd.equals("download request")){
       msg=msg.append("Please click on the following link to download your files. If you not able to download after click on the link then copying and pasting the following URL into your browser.<br>");
       msg=msg.append("<b>This is one time download link.</b><br>");
       msg=msg.append("<a target=\"_blank\" href='http://"+request.getServerName()+":"+request.getServerPort()+""+request.getContextPath()+"/download.do?method=downloadfiles&key="+user+"&dt="+dt+"'>");
       msg=msg.append("http://"+request.getServerName()+":"+request.getServerPort()+""+request.getContextPath()+"/download.do?method=downloadfiles&key="+user+"&dt="+dt+"</a></td></tr></table>");
       }
       msg1.setFrom(new InternetAddress("sales@saveafemale.com"));
       //out.println("mail: "+mail);
       InternetAddress[] addre = {new InternetAddress(mail)};
            msg1.setRecipients(Message.RecipientType.TO, addre);
            msg1.setSubject("Your Order Details");
            msg1.setSentDate(new Date());
            msg1.setContent(msg.toString(), "text/html; charset=utf-8");
            Transport.send(msg1,msg1.getAllRecipients());
       
  }  catch(Exception e)
  {
      out.println("ERROR SENDING EMAIL:"+e); 
  }
%>       
<%}
catch(Exception e){
%>
<table width="100%">
    <tr><td align="center"><font style="font-size: 20px" color="#E44129">Your Order Is Already Placed.</font></td></tr>
</table>     
<%
}
%>       
 <table width="80%" align="center">
     
    <tr><td align="center"><font style="font-size: 20px" color="#E44129">We are in gratitude and very excited that you have chosen Danceables to be on your shelf. 
Thank you for visiting us. I hope to see you real soon and don’t forget to tell a friend.
</font><br>
    <font size="5" style="font-family:mistral;font-weight:bold;color:black;">Steven Mitchell</font>, Founder</td></tr>
</table> 
 <%//}
 
 
 %>
 
            </div>
        </div>
                </td></tr>
</table>
</body>
</html>

