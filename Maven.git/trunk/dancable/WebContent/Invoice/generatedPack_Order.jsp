<%-- 
    Document   : generatedInvoice
    Created on : Jan 21, 2014, 7:01:46 PM
    Author     : kapil
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="Main_category.item_bean"%>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danceable Management</title>
        
       <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/pro_drop_1/laycss.css" />
            <script language="javascript" src="kk/resolution.js"></script>
            <script language="javascript">
            function printit()
            {
                var content_value=document.getElementById("clickHereToPrint").innerHTML;
                var disp_setting="toolbar=yes,location=no,directories=yes,menubar=yes,"; 
                disp_setting+="scrollbars=yes,width=900, height=600, left=100, top=25"; 
                
                var docprint=window.open("","",disp_setting); 
   docprint.document.open(); 
   docprint.document.write('<html><head><title></title>'); 
   docprint.document.write('</head><body onLoad="self.print(); window.close();"><center>');          
   docprint.document.write(content_value);          
   docprint.document.write('</center></body></html>'); 
   docprint.document.close(); 
   docprint.focus(); 
            }
        </script>
    </head>
    <body>
        <table width="80%" align="center">
            <tr><td width="100%">
               <table width="100%">
                   <tr><td align="right" style="font-size:16px;"><a href="#" onclick="printit()">Print</a></td></tr>
                      <tr><td valign="top" width="100%">         
     <%
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy"); 
             if((item_bean)request.getAttribute("item_list")!=null)
    {
    NumberFormat formatter = new DecimalFormat("#0.00");
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
   item_bean itmb=new item_bean();
          item_bean itembe=new item_bean();
          item_bean itb=new item_bean();
          ArrayList itemlist=new ArrayList();
          ArrayList address=new ArrayList();
          ArrayList user_cart=new ArrayList();
    itmb=(item_bean)request.getAttribute("item_list");
    itemlist=itmb.getDataArray();
    user_cart=itmb.getDataArray();
    address=itmb.getDataArray1();
  String usernam= (String)session.getAttribute("loginid");
 
String invoice="";
if(request.getAttribute("invoiceno")!=null)
{
 invoice=(String)request.getAttribute("invoiceno");
}  
     %>
        <%java.util.Date Dates=null;
      %>  
 
 
 
 <div id="clickHereToPrint">
 <table width="100%" border="0">
                    <tr><td width="10%"><img src="<%=request.getContextPath()%>/images/homepage/logo_03.png" width="70%"></td>
<td valign="top" align="left">Contact Us: 917-656-5290 || danceables@hotmail.com   <br>
P O BOX 230185, New York, NY 10023
</td>
</tr>
<tr><td colspan="2"><hr></td></tr>
    <% if(address.size()!=0){
    itb=(item_bean)address.get(0);
%>
<tr><td colspan="2" width="100%">
    <table width="100%">
        <tr align="left">
            <%-- <td valign="top" width="33%"><table>
<tr><td><b>Order ID:</b> <%=itb.getOrder_id()%></td></tr>
<tr><td><b>Invoice No:</b> <%=itb.getInvoice_no()%></td></tr>
<tr><td><b>Order Date:</b> <%=sdf.format(itb.getOrder_date())%></td></tr>
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
            </table></td>--%>
            <td valign="top"><table>
<tr><td><b>Shipping Address</b></td></tr>
<tr><td>
 <%if(!itb.getShip_f_name().equals("NA")){%>        
    <%=itb.getShip_f_name()+" "+itb.getShip_l_name()%><br>
    <%=itb.getShip_street()+", "%><%=itb.getShip_city()+","%><br>
    <%=itb.getShip_zip()+", "%><%=itb.getShip_state()+","%><br>
    <%=itb.getShip_country()%><br>
    Phone: <%=itb.getShip_phone()%><br>
 <%}else{%>
    <%=itb.getBill_f_name()+" "+itb.getBill_l_name()%><br>
    <%=itb.getBill_street()+", "%><%=itb.getBill_city()+","%><br>
    <%=itb.getBill_zip()+", "%><%=itb.getBill_state()+","%><br>
    <%=itb.getBill_country()%><br>
    Phone: <%=itb.getBill_phone()%><br>
  <%}%>
</td></tr>
            </table></td>
            
        </tr>
    </table>
</td></tr>
        <%}%>


<tr><td colspan="2" width="100%">
    <table width="100%" cellpadding="0" cellspacing="0">

<!--<tr><td><b>Product</b></td><td><b>Pic</b></td><td><b>Product Id</b></td><td align="right"><b>Quantity</b></td><td align="right"><b>Price</b></td><td align="right"><b>Total</b></td></tr>
<tr><td colspan="7"><hr></td></tr>-->
<%
int itm=0;
double pr=0.00;
double prt=0.00;
double shp=0.00;
if(user_cart.size()!=0){
                    for(int k=0;k<user_cart.size();k++){
                    item_bean itbm=(item_bean)user_cart.get(k);
                    itm=itm+itbm.getQuantity();
                    shp=itbm.getShip_charge();
                    pr=pr+itbm.getPrice();
                    prt=prt+itbm.getSubtotal();
                    filename=itbm.getFilename();   
 image="./music_image/"+filename;
%>
<%--<tr><td><%=itbm.getBrand()%></td>
<td><img src="<%=image%>" width="50" height="50"></td>
<td><%=itbm.getProd_id()%></td>
<td align="right"><%=itbm.getQuantity()%></td>
<td align="right"><%=formatter.format(itbm.getPrice())%></td>
<td align="right"><%=formatter.format(itbm.getSubtotal())%></td>
    </tr>--%>
  
    <%}}%>
    
    <tr><td colspan="6"><hr></td></tr>
    <tr><td colspan="5" align="right"><b>Total</b></td><td align="right"><b><%=formatter.format(prt)%></b></td></tr>
    <tr><td colspan="5" align="right"><b>Shipping Charge</b></td><td align="right"><b><%=formatter.format(shp)%></b></td></tr>
    <tr><td colspan="5" align="right"><b>Grand Total</b></td><td align="right"><b><%=formatter.format(prt+shp)%></b></td></tr>
     <tr><td colspan="5" align="right"><b>Quantity Inside</b></td><td align="right"><b><%=itm%></b></td></tr>
    <tr><td colspan="6"><hr></td></tr>
    </table>
</td></tr>
                </table>
           <table width="100%">
    <tr><td align="left"><font style="font-size: 20px" color="#E44129">We are in gratitude and very excited that you have chosen T Salon to be on your shelf. 
Thank you for buying our produts. I hope to see you real soon and don't forget to tell a friend.
</font><br>
    <font size="5" style="font-family:mistral;font-weight:bold;color:black;">Steven Mitchell</font>, Founder</td></tr>
</table>
 </div>
  </td></tr>
  <%}%>
               </table>
           </td></tr>
        </table>
    </body>
</html>
