<%-- 
    Document   : view_user_profile
    Created on : Mar 21, 2013, 1:12:03 PM
    Author     : kapil
--%>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<%@page language="java"%>
<%@page import ="Main_category.item_bean"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@page import="java.sql.Timestamp"%>
<%@page import ="ActionClass.JavaBean1"%>
<%@page import ="Main_category.item_bean"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danceables Management</title>
        
       <script language="javascript" src="<%=request.getContextPath()%>/css_js/resolution.js"></script>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/change.css" />
        <script language="javascript" src="<%=request.getContextPath()%>/css/menu.js"></script>
    <script language="javascript" src="<%=request.getContextPath()%>/view_content/calendarDateInput.js"></script>
    
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
    <body style="margin-left:80;margin-right:80;">
        <%
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy"); 
         ArrayList ar=new ArrayList();
        
  String name="";
  String emailid="";
  String fdate="";
  String tdate="";
  emailid=(String)session.getAttribute("loginid");
  
 
    JavaBean1 jb=new JavaBean1();
if(request.getAttribute("fdate")!=null){
fdate=(String)request.getAttribute("fdate");    
}
    if(request.getAttribute("tdate")!=null){
tdate=(String)request.getAttribute("tdate");    
}
    if(request.getAttribute("jbean")!=null){
jb=(JavaBean1)request.getAttribute("jbean");    
}
    
    int curpage=1;
          int noOfPages=1;
          if(request.getAttribute("currentPage")!=null)
          {
              curpage=Integer.parseInt(request.getAttribute("currentPage").toString());
          }
          if(request.getAttribute("noOfPages")!=null)
          {
              noOfPages=Integer.parseInt(request.getAttribute("noOfPages").toString());
          }
          //out.println("curpage: "+curpage);
          //out.println("noOfPages: "+noOfPages);
     %>
     <div id="conta" align="center">
         <table width="100%" border="0" style="border-collapse:collapse" cellspacing="0" cellpadding="0" valign="top"> 
          <TR><TD valign="top"><%@ include file="/Registration/top_design_1.jsp" %></TD></TR>
          <tr><td height="450" valign="top" align="left">
       <table border="1" width="100%"  ALIGN="CENTER" bgcolor="#ffffff" valign="top">
                <tr>

<td VALIGN="TOP" width="25%">
                   <%@ include file="/jsp/admin_left_menu.jsp" %> 
                </td>


<td valign="top"  width="100%" bgcolor="#ffffff">
      <table width="100%"> 
<%
ArrayList orderlist=null;
if(request.getAttribute("orderlist")!=null)
{
orderlist=(ArrayList)request.getAttribute("orderlist");
}
%>
   
<tr><td>
<table align="center" height="30" valign="top">
<tr><td valign="top"><font color="darkblue" size="3" style="text-decoration: underline"><b>Invoice</b></font></td></tr>
  </table> 
        <table align="center">
      <form name="" action="orderli.do?method=OrderList" method="post">
      
         
<tr>
<td><FONT STYLE="font-weight:bold;color:black;font-size:15px">Fro Date:</font> 
 &nbsp;&nbsp; <script>DateInput('frodate', true, 'dd/mm/yyyy')</script></td>

      <td> <FONT STYLE="font-weight:bold;color:black;font-size:15px">To Date:</font><script>DateInput('todate', true, 'dd/mm/yyyy')</script></td>
    

    
      </tr>
      <tr><td><input type="submit" value="submit"></td></tr>
      </form>
  </table></td></tr>
  
<tr><td><hr></td></tr> 
<%if(request.getAttribute("msg")!=null)
{%>
<tr><td><%=request.getAttribute("msg")%></td></tr> 
<%}%>
      <tr><td>
              <%if(orderlist!=null&&orderlist.size()!=0)
              {%>
      <FONT STYLE="font-weight:bold;color:black;font-size:15px">Purchase orders from date <%=fdate%> to <%=tdate%></font>
<form method="post" action="get_ordersdetails.do?method=order_Det">
     <table border="1" style="border-collapse: collapse">
         <tr>
             <td><b>User Name</b></td><td><b>User Id</b></td><td><b>Order id</b></td><td><b>Order Date</b></td>
             <td><b>Invoice no</b></td><td><b>Invoice Date</b></td><td><b>Shipping Status</b></td><td><b>Generate Invoice</b></td><td><b>Package List</b></td>
         </tr>
         <% item_bean det=new item_bean(); 
      for(int i=0;i<orderlist.size();i++){
      det=(item_bean)orderlist.get(i);%>
      <tr>
          <td><%=det.getUsername()%></td><td><%=det.getUser_id()%></td><td><%=det.getOrder_id()%></td><td><%=det.getOrder_date()%></td>
          <%if(det.getInvoice_no()!=null&&!det.getInvoice_no().equals("")){%>
          <td><%=det.getInvoice_no()%></td>
          <%}else if(det.getStatus().equals("Not Required")){%>
          <td>Not Required</td>
          <%}else{%>
          <td>NA</td>
          <%}%>
          
          <%if(det.getInvoice_date()!=null&&!det.getInvoice_date().equals("")){%>
          <td><%=det.getInvoice_date()%></td>
          <%}else if(det.getStatus().equals("Not Required")){%>
          <td>Not Required</td>
          <%}else{%>
          <td>NA</td>
          <%}%>
          
          <td><%=det.getStatus()%></td>
          <%if(det.getStatus().equals("NO")){%>
          <td><a href="<%=request.getContextPath()%>/get_ordersdetails.do?method=order_Det&orderid=<%=det.getOrder_id()%>" target="_blank">Generate</a></td>
          <%}else if(det.getStatus().equals("Not Required")){%>
          <td>Not Required</td>
          <%}else{%>
          <td><a href="<%=request.getContextPath()%>/get_ordersdetails.do?method=order_Det&orderid=<%=det.getOrder_id()%>" target="_blank">Generated</a></td>

          <%}%> 
          
          <%if(det.getStatus().equals("NO")|| det.getStatus().equals("Shipped")){%>
          <td><a href="<%=request.getContextPath()%>/get_ordersdeta.do?method=packSlip&orderid=<%=det.getOrder_id()%>" target="_blank">pack_order</a></td>
         <%}%>
          
      </tr>
      <%}%>
      </table>
    </form>  
      <FONT STYLE="font-weight:bold;color:#CF8F18;font-size:15px">
      <div style="width: 100px;float: left;height: 25px;">
            <%if(noOfPages>=1){%>
                 <%if(curpage<noOfPages){%>
                 <a class="tuc main_cl" href="./orderli.do?method=OrderList&page=<%=curpage+1%>&frodate=<%=fdate%>&todate=<%=tdate%>">
                     <strong style="color:#CF8F18;">Older....</strong>
                   </a>
                 <%}%></div>
                 <div style="width: 100px;float: left;height: 25px;">
                 <%if(curpage>1){%>
                 <a class="tuc main_cl" href="./orderli.do?method=OrderList&page=<%=curpage-1%>&frodate=<%=fdate%>&todate=<%=tdate%>">
                     <strong style="color:#CF8F18;">Newer....</strong>
                   </a>
                 <%}%></div>
                 <%}%>
        </font>
       <%}else if(orderlist!=null){%>
       <FONT STYLE="font-weight:bold;color:black;font-size:15px">Purchase orders are not placed from date <%=fdate%> to <%=tdate%>.</font>
       <%}%>
      </td></tr>
           
           <tr><td width="100%">
               <table width="100%">
                          
     <%
    
             if((item_bean)request.getAttribute("item_list")!=null)
    {%>
 <tr><td align="right" style="font-size:16px;"><a href="#" onclick="printit()">Print</a></td></tr>
 <tr><td valign="top" width="100%">  
   <% NumberFormat formatter = new DecimalFormat("#0.00");
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
 


 
    
     %>
        <%java.util.Date Dates=null;
      %>  
 
 
 
 <div id="clickHereToPrint">
 <table width="100%" border="0">
                    <tr><td width="10%"><img src="<%=request.getContextPath()%>/images/homepage/logo.png" width="70%"></td>
<td valign="top" align="left">Contact Us: 212-358-0506 || tsalonsales@gmail.com  <br>
230 Fifth Ave, Suite 1511, New York, NY 10001
</td>
</tr>
<tr><td colspan="2"><hr></td></tr>
    <% if(address.size()!=0){
    itb=(item_bean)address.get(0);
%>
<tr><td colspan="2" width="100%">
    <table width="100%">
        <tr align="left">
            <td valign="top" width="33%"><table>
<tr><td><b>Order ID:</b> <%=itb.getOrder_id()%></td></tr>
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
            </table></td>
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
            
        </tr>
    </table>
</td></tr>
        <%}%>
<tr><td colspan="2"><hr></td></tr>

<tr><td colspan="2" width="100%">
    <table width="100%" cellpadding="0" cellspacing="0">

<tr><td><b>Product</b></td><td><b>Pic</b></td><td><b>Product Id</b></td><td><b>Size</b></td><td align="right"><b>Quantity</b></td><td align="right"><b>Price</b></td><td align="right"><b>Total</b></td></tr>
<tr><td colspan="7"><hr></td></tr>
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
 image="./Tea_image/"+filename;
%>
<tr><td><%=itbm.getBrand()%></td>
<td><img src="<%=image%>" width="50" height="50"></td>
<td><%=itbm.getProd_id()%></td>
<td><%=itbm.getSize()%></td>
<td align="right"><%=itbm.getQuantity()%></td>
<td align="right"><%=formatter.format(itbm.getPrice())%></td>
<td align="right"><%=formatter.format(itbm.getSubtotal())%></td>
    </tr>
    <tr><td colspan="7"><hr></td></tr>
    <%}}%>
    <tr><td align="right" colspan="4"><b>Total</b></td><td align="right"><b><%=itm%></b></td><td align="right"><b><%=formatter.format(pr)%></b></td><td align="right"><b><%=formatter.format(prt)%></b></td></tr>
    <tr><td colspan="7"><hr></td></tr>
    <tr><td colspan="6" align="right"><b>Shipping Charge</b></td><td align="right"><b><%=formatter.format(shp)%></b></td></tr>
    <tr><td colspan="6" align="right"><b>Grand Total</b></td><td align="right"><b><%=formatter.format(prt+shp)%></b></td></tr>
    <tr><td colspan="7"><hr></td></tr>
    </table>
</td></tr>
                </table>
           <table width="100%">
    <tr><td align="left"><font style="font-size: 20px" color="#E44129">We are in gratitude and very excited that you have chosen T Salon to be on your shelf. 
Thank you for buying our produts. I hope to see you real soon and don't forget to tell a friend.
</font><br>
    <font size="5" style="font-family:mistral;font-weight:bold;color:black;">Miriam Novalle</font>, Founder</td></tr>
</table>
 </div>
  </td></tr>
  <%}%>
               </table>
           </td></tr>
   
    </table>
  
    
</td>
                
                
                
                </tr>
                </table>
              </td></tr></table>
<TR><TD vAlign=top ><%@ include file="/jsp/hrms_footer.jsp" %></td></tr>
     </div>

    </body>
</html>
