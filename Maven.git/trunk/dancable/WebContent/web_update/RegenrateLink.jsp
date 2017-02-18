<%-- 
    Document   : RegenrateLink
    Created on : Apr 9, 2014, 6:18:05 PM
    Author     : kapil
--%>

<%@page import="ActionClass.Common"%>
<%@page import="streams.ToDBFile"%>
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
        <title>Danceables</title>
        
       <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/pro_drop_1/laycss.css" />
            <script language="javascript" src="<%=request.getContextPath()%>/css_js/resolution.js"></script>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/change.css" />
        <script language="javascript" src="<%=request.getContextPath()%>/css/menu.js"></script>
    </head>
    <body style="margin-left:80;margin-right:80;margin-top:5">
        <%
        item_bean itmb=null;
        String order_id="";
        ToDBFile tdb=new ToDBFile();
        if(request.getParameter("order_id")!=null)
        {
            order_id=(String)request.getParameter("order_id");
            itmb=tdb.search_order(order_id.trim());
        }
        
        
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
     %>
     <div id="conta" align="center">
         <table width="100%" border="0" style="border-collapse:collapse" cellspacing="0" cellpadding="0" valign="top"> 
          <TR><TD valign="top"><%@ include file="/Registration/top_design_1.jsp" %></TD></TR>
          <tr><td height="450" valign="top" align="left">
       <table bgcolor="#ffffff" width="100%" valign="top" border="1" style="border-collapse: collapse">
                <tr>

<td VALIGN="TOP" width="25%">
                    <%@ include file="/jsp/admin_left_menu.jsp" %> 
                </td>
<td valign="top"  width="100%" bgcolor="#ffffff">
      <table width="100%">
<%
ArrayList orderlist=new ArrayList();
if(request.getAttribute("orderlist")!=null)
{
orderlist=(ArrayList)request.getAttribute("orderlist");
}
%>
   
<tr><td><table align="center">
    
  </table></td></tr>
  
  
  <tr><td align="center" valign="top">
        <font style="font-weight: bold;color:#726C7B;font-size:18px;text-decoration:underline;line-height:25px">Regenerate Link</font></td>
</tr>    
           
           <tr><td width="100%">
               <table width="100%">
                   <tr><td align="center">
                           <form name="f1" action="<%=request.getContextPath()%>/regen.do">
                               Order Id: <input type="text" name="order_id">&nbsp;&nbsp;<input type="submit" value="Check Order">
                           </form>
                       </td></tr> 
                   <tr><td><hr></td></tr>
                      <tr><td valign="top" width="100%">         
     <%
    
             if(itmb!=null)
    {
    NumberFormat formatter = new DecimalFormat("#0.00");
     String user="";
     String order="";
   String filename="";  
     String image="";
   
   
          item_bean itb=new item_bean();
          ArrayList address=new ArrayList();
          ArrayList user_cart=new ArrayList();
    
    user_cart=itmb.getDataArray();
    address=itmb.getDataArray1();
  String usernam= (String)session.getAttribute("loginid");
 


 
    
     %>
        <%java.util.Date Dates=null;
      %>  
 
 
 

 <table width="95%" border="0" align="center">

    <% if(address.size()!=0){
    itb=(item_bean)address.get(0);
    user=itb.getUser_id();
    order=itb.getOrder_id();
%>
<tr><td colspan="2" width="100%">
    <table width="100%">
        <tr align="left">
            <td valign="top" width="33%"><table>
                <tr><td><b>User ID:</b> <%=itb.getUser_id()%></td></tr>
<tr><td><b>Order ID:</b> <%=itb.getOrder_id()%></td>
    <td>&nbsp;&nbsp;&nbsp;<b>Order Date:</b> <%=sdf.format(itb.getOrder_date())%></td></tr>
            </table></td>

            
        </tr>
    </table>
</td></tr>
        <%}%>
<tr><td colspan="2"><hr></td></tr>

<tr><td colspan="2" width="100%">
    <table width="100%" border="0" style="border-collapse: collapse" cellspacing="0" cellpadding="0">

<tr><td><b>Product</b></td><td><b>Pic</b></td><td><b>Product Id</b></td><td align="right"><b>Quantity</b></td>
    <td align="right"><b>Price</b></td><td align="right"><b>Total</b></td></tr>
<tr><td colspan="6"><hr></td></tr>
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
<tr><td><%=itbm.getBrand()%></td>
<td><img src="<%=image%>" width="50" height="50"></td>
<td><%=itbm.getProd_id()%></td>
<td align="right"><%=itbm.getQuantity()%></td>
<td align="right"><%=formatter.format(itbm.getPrice())%></td>
<td align="right"><%=formatter.format(itbm.getSubtotal())%></td>
    </tr>
   
    <tr><td colspan="6"><hr></td></tr>
    <%}}%>
    <tr><td align="right" colspan="3"><b>Total</b></td><td align="right"><b><%=itm%></b></td><td align="right"><b><%=formatter.format(pr)%></b></td><td align="right"><b><%=formatter.format(prt)%></b></td></tr>
   <tr><td colspan="6"><hr></td></tr>
    <tr><td colspan="5" align="right"><b>Shipping Charge</b></td><td align="right"><b><%=formatter.format(shp)%></b></td></tr>
    <tr><td colspan="5" align="right"><b>Grand Total</b></td><td align="right"><b><%=formatter.format(prt+shp)%></b></td></tr>
    <tr><td colspan="6"><hr></td></tr>
    </table>
</td></tr>
                </table>

  </td></tr>
                      <tr><td height="20"></td></tr>
                      
                        <%  
         int count=tdb.chekResendlink(user, order);
       Common comLogin = new Common();
       //user=comLogin.jumbleData(user);
       String od=comLogin.jumbleData(order);
String link="http://"+request.getServerName()+":"+request.getServerPort()+""+request.getContextPath()+"/download.do?method=downloadfiles&key="+user+"&dt="+od;
if(request.getAttribute("msg")!=null)
{%>
<tr><td><font style="color: darkred"><%=request.getAttribute("msg")%></font></td></tr>
<%}else{
 if(request.getAttribute("msg1")!=null)
{%>
<tr><td><font style="color: darkred"><%=request.getAttribute("msg1")%></font></td></tr>
<%}else{
if(count==1)
{
%> 
<tr><td><font style="color: darkred">You have already resend this link.</font></td></tr>
<%} else if(count>1){%>
<tr><td><font style="color: darkred">You have resend this link <%=count%> times.</font></td></tr>
<%}}%>

<tr><td>
   <font style="color:#726C7B;font-weight: bold"><%=link%></font><td></tr>
<tr><td>
        <form name="f2" action="<%=request.getContextPath()%>/resendLink.do?method=resendDnlink" method="post"><table><tr><td>
                        <input type="hidden" value="<%=order%>" name="order_id">
                        <!--<input type="hidden" value="<%//=comLogin.unJumbleData(user)%>" name="user">-->
                        <input type="hidden" value="<%=user%>" name="user">
            <input type="hidden" value="<%=link%>" name="link">
             <input type="submit" value="resend">
                    </td></tr></table></form>
       </td></tr>
  <%}%>
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
