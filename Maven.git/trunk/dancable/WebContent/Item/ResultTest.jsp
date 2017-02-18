<%@page import="javax.mail.Transport"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="ActionClass.Common"%>
<%@page import="javax.mail.PasswordAuthentication"%>
<%@page import="javax.mail.Authenticator"%>
<%@page import="javax.mail.Session"%>
<%@page import="javax.mail.internet.MimeMessage"%>
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
<title>Response Test Page</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/change.css" />
        <script language="javascript" src="<%=request.getContextPath()%>/css/menu.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/css_js/resolution.js"></script>
         
                 
</head>
<body>
    <% //out.println("saini: "+request.getParameter("name1"));
  //  System.out.println("saini: "+request.getParameter("name1"));
    String loginid=request.getParameter("user_id");
 //   System.out.println("loginid: "+loginid);
 //   System.out.println("Shipping: "+request.getParameter("shp"));
       double shp=Double.parseDouble(request.getParameter("shp"));
       String mail=request.getParameter("email1");
   ArrayList user_cart=new ArrayList();
   item_bean itb=new item_bean();
   function_int_foodmart fun=new function_int_foodmart();
    

if(!loginid.equals("guest"))
{
    fun.det_user_cart(loginid);
 }

session.removeAttribute("cart_list");
   String order_id=request.getParameter("oid");
   session.removeAttribute("e_email");
   SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
   SimpleDateFormat sde=new SimpleDateFormat("yyyy-MM-dd");
   java.util.Date order_date=new java.util.Date();
   
   
   itb.setBill_f_name(request.getParameter("bilfname"));
   itb.setBill_l_name(request.getParameter("billname"));
     itb.setBill_phone(request.getParameter("phone1"));
     itb.setBill_street(request.getParameter("baddr11"));
     itb.setBill_city(request.getParameter("bcity1"));
     itb.setBill_state(request.getParameter("bstate1"));
     itb.setBill_country(request.getParameter("bcountry1"));
     itb.setBill_zip(request.getParameter("bzip1"));
     
     itb.setShip_f_name(request.getParameter("shipfname"));
     itb.setShip_l_name(request.getParameter("shiplname"));
     itb.setShip_phone(request.getParameter("shphone2"));
     itb.setShip_street(request.getParameter("saddr12"));
     itb.setShip_city(request.getParameter("scity2"));
     itb.setShip_state(request.getParameter("sstate2"));
     itb.setShip_country(request.getParameter("scountry2"));
     itb.setShip_zip(request.getParameter("szip2"));
     itb.setKind(request.getParameter("kind"));
     itb.setShipmentTo(request.getParameter("shipTo"));
     
int sz=Integer.parseInt(request.getParameter("sz"));
item_bean itbm;
for(int i=0;i<sz;i++){
    itbm=new item_bean();
    itbm.setUser_id(request.getParameter("user_id"));
    itbm.setFilename(request.getParameter("filename"+i));
    itbm.setPrice(Double.parseDouble(request.getParameter("price"+i)));
    itbm.setQuantity(Integer.parseInt(request.getParameter("quan"+i)));
    itbm.setSubtotal(Double.parseDouble(request.getParameter("subtot"+i)));
    itbm.setItem_id(Integer.parseInt(request.getParameter("itemid"+i)));
    itbm.setSubcat_id(Integer.parseInt(request.getParameter("subcatid"+i)));
    itbm.setCart_id(Integer.parseInt(request.getParameter("cartid"+i)));
    if(request.getParameter("cartdate"+i)!=null){
       itbm.setCartdate(sde.parse(request.getParameter("cartdate"+i)));
                }
    else{
        itbm.setCartdate(null);
    }
    itbm.setProd_id(request.getParameter("prodid"+i));
    itbm.setBrand(request.getParameter("brand"+i));
    user_cart.add(itbm);
}


String kd=itb.getKind();
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
    try{
        NumberFormat formatter = new DecimalFormat("#0.00");
        
   
   //out.println(session.getAttribute("loginid"));

%>
              
                
                

	<table width="80%" border="0" align="center">
            <%
  StringBuffer sbb=new StringBuffer();
  sbb=sbb.append("<tr><td width='11%'><img src='http://www.danceables.com/images/homepage/logo_03.png' width='100%'></td>");
  sbb=sbb.append("<td valign='top' align='left'>Contact Us: 917-656-5290 || danceables@hotmail.com  <br>P O BOX 230185, New York, NY 10023</td></tr>");
  sbb=sbb.append("<tr><td colspan='2'><hr></td></tr>");
  sbb=sbb.append("<tr><td colspan='2' width='100%'><table width='100%'>");
  sbb=sbb.append("<tr><td colspan='5' width='100%'><table width='100%'>");
  sbb=sbb.append("<tr><td width='33%'><table>");
  sbb=sbb.append("<tr><td><b>Order ID:</b> "+order_id+"</td></tr>");
  sbb=sbb.append("<tr><td><b>Order Date:</b> "+sdf.format(order_date)+"</td></tr>");
  sbb=sbb.append("<tr><td><b>Test Email:</b>"+mail+"</td></tr></table></td>");
  sbb=sbb.append("<td valign='top' width='33%'><table>");
  sbb=sbb.append("<tr><td><b>Billing Address</b></td></tr>");
  sbb=sbb.append("<tr><td>"+itb.getBill_f_name()+" "+itb.getBill_l_name()+"<br>");
  sbb=sbb.append(itb.getBill_street()+", "+itb.getBill_city()+",<br>");
  sbb=sbb.append(itb.getBill_zip()+", "+itb.getBill_state()+",<br>");
  sbb=sbb.append(itb.getBill_country()+"<br>");
  sbb=sbb.append("Phone: "+itb.getBill_phone()+"<br>");
  sbb=sbb.append("</td></tr></table></td>");
  if(!itb.getKind().equals("download request")){
      sbb=sbb.append("<td valign='top'><table>");
      sbb=sbb.append("<tr><td><b>Shipping Address</b></td></tr>");
      sbb=sbb.append("<tr><td>"+itb.getShip_f_name()+" "+itb.getShip_l_name()+"<br>");
      sbb=sbb.append(itb.getShip_street()+", "+itb.getShip_city()+",<br>");
      sbb=sbb.append(itb.getShip_zip()+", "+itb.getShip_state()+",<br>");
      sbb=sbb.append(itb.getShip_country()+"<br>");
      sbb=sbb.append("Phone: "+itb.getShip_phone()+"<br>");
      sbb=sbb.append("</td></tr></table></td>");
  }
  sbb=sbb.append("</tr></table></td></tr>");
 sbb=sbb.append("<tr><td colspan='5'><hr></td></tr>");
 
 sbb=sbb.append("<tr><td><b>Product</b></td><td><b>Product Code</b></td><td align='right'><b>Quantity</b></td><td align='right'><b>Price</b></td>"
          + "<td align='right'><b>Total</b></td></tr>");
  sbb=sbb.append("<tr><td colspan='5'><hr></td></tr>");
  if(user_cart.size()!=0){
     for(int k=0;k<user_cart.size();k++){
         itbm=(item_bean)user_cart.get(k);
         itm=itm+itbm.getQuantity();
         pr=pr+itbm.getPrice();
         prt=prt+itbm.getSubtotal();
         sbb=sbb.append("<tr><td>"+itbm.getBrand()+"</td><td>"+itbm.getProd_id()+"</td><td align='right'>"+itbm.getQuantity()+"</td>");
         sbb=sbb.append("<td align='right'>"+formatter.format(itbm.getPrice())+"</td><td align='right'>"+formatter.format(itbm.getSubtotal())+"</td></tr>");
         sbb=sbb.append("<tr><td colspan='5'><hr></td></tr>");
     }
  }
  sbb=sbb.append("<tr><td align='right' colspan='2'><b>Total</b></td><td align='right'><b>"+itm+"</b></td><td align='right'><b>"+formatter.format(pr)+ "</b></td><td align='right'><b>"+formatter.format(prt)+"</b></td></tr>");
  sbb=sbb.append("<tr><td colspan='5'><hr></td></tr>");
  if(!itb.getKind().equals("download request")){
      sbb=sbb.append("<tr><td colspan='4' align='right'><b>Shipping Charge</b></td><td align='right'><b>"+formatter.format(shp)+"</b></td></tr>");
    }
  sbb=sbb.append("<tr><td colspan='4' align='right'><b>Grand Total</b></td><td align='right'><b>"+formatter.format(prt+shp)+"</b></td></tr>");
  sbb=sbb.append("<tr><td colspan='5'><hr></td></tr>");
  sbb=sbb.append("</table></td></tr>");
  
  out.println(sbb);
  %>
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
   // session.removeAttribute("cart_list");
    session.removeAttribute("guest_mail");
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
               
       MimeMessage msg1=new MimeMessage(sess);     
       Common comLogin = new Common();
       String user=comLogin.jumbleData(mail);
       //String dt="";
       String dt=comLogin.jumbleData(order_id);
       
        StringBuffer msg=new StringBuffer("<table width='100%'><tr><td colspan='2'>***** Please DO NOT REPLY to this automated message. *****<br><br></td></tr>");
       //msg=msg.append("<b>Your Order No.: </b>"+order_id+"<br>");
       //msg=msg.append("<b>Total Quantity: </b>"+itm+"<br>");
       //msg=msg.append("<b>Sub Total: </b>"+prt+"<br>");
       //msg=msg.append("<b>Shipping: </b>"+shp+"<br>");
       //msg=msg.append("<b>Total: </b>"+(shp+prt)+"<br><br>");
        msg=msg.append(sbb.toString());
       if(kd.equals("download request")){
       msg=msg.append("<tr><td colspan='2'>Please click on the following link to download your files. If you not able to download after click on the link then copying and pasting the following URL into your browser.<br>");
       msg=msg.append("<b>This is one time download link.</b><br>");
       msg=msg.append("<a target=\"_blank\" href='http://"+request.getServerName()+":"+request.getServerPort()+""+request.getContextPath()+"/download.do?method=downloadfiles&key="+user+"&dt="+dt+"'>");
       msg=msg.append("http://"+request.getServerName()+":"+request.getServerPort()+""+request.getContextPath()+"/download.do?method=downloadfiles&key="+user+"&dt="+dt+"</a></td></tr></table>");
       }
       msg1.setFrom(new InternetAddress("sales@saveafemale.com"));
       //out.println("mail: "+mail);
       InternetAddress[] addre = {new InternetAddress(mail)};
            msg1.setRecipients(Message.RecipientType.TO, addre);
            msg1.setSubject("Order Details");
            msg1.setSentDate(new Date());
            msg1.setContent(msg.toString(), "text/html; charset=utf-8");
            Transport.send(msg1,msg1.getAllRecipients());
       
  }  catch(Exception e){out.println("ERROR SENDING EMAIL:"+e.getMessage()); }
  
   
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
Thank you for visiting us. I hope to see you real soon and do not forget to tell a friend.
</font><br>
    <font size="5" style="font-family:mistral;font-weight:bold;color:black;">Steven Mitchell</font>,A Founder</td></tr>
</table> 
 
            </div>
        </div>
                </td></tr>
</table>

</body>
</html>

