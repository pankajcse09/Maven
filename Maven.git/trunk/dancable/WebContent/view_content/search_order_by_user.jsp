<%-- 
    Document   : search_order_by_user
    Created on : Mar 20, 2013, 6:51:09 PM
    Author     : kapil
--%>



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
<%@page import ="ActionClass.JavaBean1"%>
<%@page import ="Main_category.item_bean"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>T Salon</title>
        
       <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/pro_drop_1/laycss.css" />
            <script language="javascript" src="kk/resolution.js">
</script>
    <script language="javascript" src="<%=request.getContextPath()%>/view_content/calendarDateInput.js"></script>
   
    </head>
      

    <body style="margin-left:80;margin-right:80;margin-top:5">
 <%
    item_bean itembe=new item_bean(); 
    ArrayList cart_list=new ArrayList();
  ArrayList customerlist=new ArrayList();
   JavaBean1 jb=new  JavaBean1();
   java.util.Date Dates=null;
      SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy"); 
 
      double total=0.0;
        double price=0.0;
            
          
            String image="";
   int itemid=0;
   String filename="";
  %>
  <%String usernam= (String)session.getAttribute("loginid");%>
   <div id="conta">
	
         
       <table width="100%" border="0" style="border-collapse:collapse" cellspacing="0" cellpadding="0">
    
 <TR><TD valign="top"><%@ include file="/Registration/top_design_1.jsp" %></TD></TR>     
	  
 <tr><td height="450" valign="top" width="100%">
                <table bgcolor="#ffffff" width="100%" valign="top">
                   
 <tr>
<td valign="top" width="25%">
    
 <table>
        <tr><td>Useful Links</td></tr>
        <tr><td><a href="emp_reg_form.do">Employee Registration Form</a></td></tr> 
     <tr> <td><a href="EditRegistration.do?method=editRegist">View/Edit Profile</a></td></tr> 
      <tr><td><a href="view_users.do">View Users</a></td></tr>
     <!--<tr>  <td><a href="view_feedback.do"> View Feedback</a></td></tr>-->
      <tr><td><a href="user_order_search.do">Search Order</a></td></tr>
 <tr><td><a href="user_view_order.do?pr=1">View Today Orders</a></td></tr>    
    <tr><td><a href="view_range_order.do">Search Date Wise Order</a></td></tr> 
 <tr><td><a href="update_web.do">Update Website</a></td></tr> 
    
    <tr><td><a href="gotocms.do">Content Management System</a></td></tr>  
    </table>
</td>

<td valign="top" width="75%"><table align="center" width="100%">

                        <tr><td align="right"><font color="maroon" size="2">Welcome&nbsp;</font><font color="darkblue" 
          size="4">'<%=usernam%>'</font></td>
                        <!--<td align="right" style="padding-left: 10px"><font color="maroon" size="2"><a href="<%=request.getContextPath()%>/logout.do?method=logout">Logout&nbsp;</a></font></td>-->
                        </tr>


                    
                    
                    <tr><td align="center"><table align="center">
                        <tr><td>
 <form name="" action="get_user_order.do?method=search_by_user" method="post">
  <table align="center">
       <input type="hidden" name="emailid" value="<%=usernam%>">
<tr><td>Email id:&nbsp;&nbsp;<input type="text" name="search_user"></td>

      <td> <input type="submit" value="Search"></td>
      </tr>
      
   </table>
</form>
  </td></tr>
  
  
                    </table></td></tr>
                    
<%
   if(request.getAttribute("cart_list")!=null){
    cart_list=(ArrayList)request.getAttribute("cart_list");
       }
  
    if(cart_list.size()!=0){
       
        %>
        
                    <tr><td align="center">
                           
     <table width="100%" border="1" bgcolor="white" cellspacing="0" cellpadding="0">        
 <tr><td><FONT STYLE="font-weight:bold;color:blue;font-size:15px">S.no.</font></td>
<td><FONT STYLE="font-weight:bold;color:blue;font-size:15px">Date</font></td>
<td><FONT STYLE="font-weight:bold;color:blue;font-size:15px">Customer Name</font></td>

<td><FONT STYLE="font-weight:bold;color:blue;font-size:15px">Pic</font></td>
<td><FONT STYLE="font-weight:bold;color:blue;font-size:15px">Product ID</font></td>
<td><FONT STYLE="font-weight:bold;color:blue;font-size:15px">Size</font></td>

<td><FONT STYLE="font-weight:bold;color:blue;font-size:15px">Price</font></td>
<td><FONT STYLE="font-weight:bold;color:blue;font-size:15px">Quantity</font></td>
<td><FONT STYLE="font-weight:bold;color:blue;font-size:15px">Subtotal</font></td>
 
 </tr>
       <%
     for(int i=0;i<cart_list.size();i++){
            itembe=(item_bean)cart_list.get(i);
  
 price=itembe.getPrice();
 filename=itembe.getFilename();   
 image="./Tea_image/"+filename;
 
    
     %>
     <tr>
<td><FONT STYLE="font-weight:normal;color:black;font-size:14px"><%=i+1%></td>
<td><FONT STYLE="font-weight:normal;color:black;font-size:14px"><%=sdf.format(itembe.getCartdate())%></td>
<td><FONT STYLE="font-weight:normal;color:black;font-size:14px"><%=itembe.getUsername()%></td>
<td width="50"><img  border="0" src="<%=image%>" width="50" height="70"></td>
     <td><FONT STYLE="font-weight:normal;color:black;font-size:14px"><%=itembe.getSize()%></td>
           <td><FONT STYLE="font-weight:normal;color:black;font-size:14px"><%=itembe.getProd_id()%></td>
         
       <td width="10%"><FONT STYLE="font-weight:normal;color:black;font-size:14px"><%=price%></td>
       
           
           
           <td><FONT STYLE="font-weight:normal;color:black;font-size:14px"><%=itembe.getQuantity()%></td>
            <td><FONT STYLE="font-weight:normal;color:black;font-size:14px"><%=itembe.getSubtotal()%></td>
          
        
           
      </tr>
      <input type="hidden" name="orderid<%=i%>" value="<%=itembe.getOrder_id()%>">
   <%
    total=total+itembe.getSubtotal();
    }%>
     <tr><td colspan="8" align="right"><FONT STYLE="font-weight:normal;color:red;font-size:15px">Total($)</font></td>
<td><FONT STYLE="font-weight:normal;color:red;font-size:15px"><%=total%></font></td></tr>
           <% }
      
   %>
     
 </table> 
   
        
 
                        </td> </tr>
</table></td></tr>

</table>
     </td></tr>
        
       </table>
       
	<TR><TD vAlign=top ><%@ include file="/jsp/hrms_footer.jsp" %></td></tr> 
</div>
    
    
    </body>
</html>


