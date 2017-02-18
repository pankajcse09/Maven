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
<%@ page import="java.text.*"%>
<%@page import="java.sql.Timestamp"%>
<%@page import ="ActionClass.JavaBean1"%>

   <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danceables</title>
        <script language="javascript" src="css_js/resolution.js"></script>
        <link rel="stylesheet" type="text/css" href="css/change.css" />
        <script language="javascript" src="css/menu.js"></script>
    <script language="javascript" src="<%=request.getContextPath()%>/view_content/calendarDateInput.js"></script>
   
    </head>
      

    <body>

  <%String username= (String)session.getAttribute("loginid");%>
  
   <div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/all.js#xfbml=1";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
  
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
            
        <tr><td background="<%=request.getContextPath()%>/images/homepage/bottom grey.png" width="100%" height="100%" valign="top">
                <table border="0" width="75%" ALIGN="CENTER" height="500">
                   
 <tr align="left">
<td VALIGN="TOP" width="20%" STYLE="PADDING-TOP:20PX">
    
 <table>
        <tr><td>Useful Links</td></tr>
        <tr><td><a href="Customer_ViewRegistration.do?method=viewCustomerRegist" style="text-decoration:none;color:grey">View Profile</a></td></tr>
        <tr><td><a href="Customer_EditRegistration.do?method=editCustomerRegist" style="text-decoration:none;color:grey">Update Profile</a></td></tr>
       <tr><td><a href="customer_order_range.do" style="text-decoration:none;color:grey">View Order</a></td></tr>
       <tr><td><a href="<%=request.getContextPath()%>/customer_logout.do?method=customer_logout" style="text-decoration:none;color:grey">Logout</a></td></tr>
       
       
    </table>
</td>

<td VALIGN="TOP" width="80%"><table VALIGN="TOP" width="100%">
<tr><td><table  border="0" VALIGN="TOP">
    <tr><td STYLE="font-weight:bold;color:black;font-size:14px" align="center" height="40">Welcome&nbsp;'<%=username%>'</td></tr>

</table></td></tr>
                    
                    
                    <tr><td align="center"><table align="center">
                        <tr><td>
  <table align="center">
      <form name="" action="get_cust_order.do?method=get_orderList" method="post">
      
          <input type="hidden" name="emailid" value="<%=username%>">
<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:15px">Form Date:</font>  &nbsp;&nbsp; <script>DateInput('frodate', true, 'dd/mm/yyyy')</script></td>

      <td> <FONT STYLE="font-weight:bold;color:black;font-size:15px">To Date:</font><script>DateInput('todate', true, 'dd/mm/yyyy')</script></td>
      </tr>
      <tr><td ><input type="submit" value="submit"></td></tr>
      </form>
       </table>
  </td></tr>
  
  
                    </table></td></tr>
                    <tr><td><hr></td></tr>
                    <tr><td valign="top" width="100%"> 
                        <%
     SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
  HashMap hm=new HashMap();
 ArrayList hs=new ArrayList();
  ArrayList al=new ArrayList();
 String frdate="";
 String todate="";
 if(request.getAttribute("fdate")!=null)
 {
     frdate=(String)request.getAttribute("fdate");
 }
 if(request.getAttribute("tdate")!=null)
 {
     todate=(String)request.getAttribute("tdate");
 }
 if(request.getAttribute("al")!=null)
 {
     al=(ArrayList)request.getAttribute("al");
 }
  String ft="";
  String pre="";
  String nxt="";
  String stindex="";
  int k=0;
  JavaBean1 rb= new  JavaBean1();
  if(request.getAttribute("hmap")!=null){
  hm=(HashMap)request.getAttribute("hmap");  
  hs=(ArrayList)hm.get("hset");  
  ft=(String)hm.get("fromto");
  pre=(String)hm.get("previous");
  nxt=(String)hm.get("next");  
  stindex=hm.get("stindex").toString(); 
  }
  try{
   k=Integer.parseInt(stindex);   
  }
  catch(NumberFormatException ne){}
  %>
  <%
  String usernam= (String)session.getAttribute("loginid");
   %>
   <%
    if(al.size()!=0){
       
     %>
     <table  width="100%" align="center" cellpadding="0" cellspacing="0" border="0">
    <tr><td valign="top" align="left"><FONT STYLE="font-weight:bold;color:blue;font-size:15px">From: <%=frdate%> To: <%=todate%></b></font></td></tr></table> 
    <table  width="100%" align="center" cellpadding="0" cellspacing="0" border="1">
    <tr><td valign="top" align="center"><FONT STYLE="font-weight:bold;color:blue;font-size:15px">SNo.</b></font></td>
<td><FONT STYLE="font-weight:bold;color:blue;font-size:17px">Email ID:</b></font></td>
<td><FONT STYLE="font-weight:bold;color:blue;font-size:17px">Name</font></td>
<!--<td><FONT STYLE="font-weight:bold;color:blue;font-size:17px">Address</font></td>
<td><FONT STYLE="font-weight:bold;color:blue;font-size:17px">City</font></td>
<td><FONT STYLE="font-weight:bold;color:blue;font-size:17px">State</font></td>
<td><FONT STYLE="font-weight:bold;color:blue;font-size:17px">Country</font></td>-->

    <td><FONT STYLE="font-weight:bold;color:red;font-size:17px">View Today Order</font></td>
    </tr>    
     <%
     for(int m=0;m<al.size();m++){
       k=m;
       rb=(JavaBean1)al.get(m);
     %>    
    <tr><td align="center"><FONT STYLE="font-weight:normal;color:black;font-size:15px"><%=k+1%></font></td>
<td><FONT STYLE="font-weight:normal;color:black;font-size:15px"><%=rb.getEmail_id()%></font></td>
<td><FONT STYLE="font-weight:normal;color:black;font-size:15px"><%=rb.getName()%>&nbsp; <%=rb.getLast_name()%></font></td>
<!--<td><FONT STYLE="font-weight:normal;color:black;font-size:15px"><%=rb.getHomeaddress()%></font></td>
<td><FONT STYLE="font-weight:normal;color:black;font-size:15px"><%=rb.getCity()%></font></td>
<td><FONT STYLE="font-weight:normal;color:black;font-size:15px"><%=rb.getState()%></font></td>
<td><FONT STYLE="font-weight:normal;color:black;font-size:15px"><%=rb.getCountry()%></font></td>-->



    
    <td width="20%"><font style="font-size:12">
<a href="get_customer_order.do?userid=<%=rb.getEmail_id()%>&odid=<%=rb.getOrder_id()%>&method=get_orderCustomerList">view</a></font></td>
    </tr>

     <%}%>
                   </table>     </td></tr>      
               <%}
    else{
            if(!frdate.equals("")&&!todate.equals(""))
            {
               %>     
       <table  width="60%" align="left" cellpadding="0" cellspacing="0" border="0">
    <tr><td valign="top" align="left"><FONT STYLE="font-weight:bold;color:blue;font-size:15px">From: <%=frdate%> To: <%=todate%></font></td>
        <td align="left"><FONT STYLE="font-weight:bold;color:blue;font-size:15px">No order placed.</b></font></td>
    </tr></table>
                    
                    <%}}%>
 </table>
    
  </td></tr>
 <tr><td colspan="2"><%@include file="/footer.jsp"%></td>
                        </tr>
               </table></td></tr>
        </table>
    </body>
</html>


