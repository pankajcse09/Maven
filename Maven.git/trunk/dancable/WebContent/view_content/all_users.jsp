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
        <title>Danceables</title>
 <script language="javascript" src="<%=request.getContextPath()%>/css_js/resolution.js"></script>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/change.css" />
        <script language="javascript" src="<%=request.getContextPath()%>/css/menu.js"></script>
    <script language="javascript" src="<%=request.getContextPath()%>/view_content/calendarDateInput.js"></script>
   
    </head>
      

    <body>
 <%
    item_bean itembe=new item_bean(); 
    ArrayList cart_list=new ArrayList();
  ArrayList customerlist=new ArrayList();
   JavaBean1 jb=new  JavaBean1();
   java.util.Date Dates=null;
   HashMap hm=new HashMap();
 ArrayList hs=new ArrayList();
  String ft="";
  String pre="";
  String nxt="";
  String stindex="";
  int k=0;
  JavaBean1 rb= new  JavaBean1();
      SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy"); 
 
      double total=0.0;
        double price=0.0;
            
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
<td valign="top" width="25%" align="left">
    
 <table>
        <tr><td>Useful Links</td></tr>
      <tr><td><a href="emp_reg_form.do" style="text-decoration:none;font-size:15px;color:#7D0E0E">Employee Registration Form</a></td></tr> 
     <tr> <td><a href="EditRegistration.do?method=editRegist" style="text-decoration:none;font-size:15px;color:#7D0E0E">View/Edit Profile</a></td></tr> 
      <tr><td><a href="view_users.do" style="text-decoration:none;font-size:15px;color:#7D0E0E">Users</a></td></tr>
    <!-- <tr>  <td><a href="view_feedback.do"> View Feedback</a></td></tr>-->
     <tr><td><a href="user_view_order.do?pr=1" style="text-decoration:none;font-size:15px;color:#7D0E0E">Today Registerd User Orders</a></td></tr>    
 <tr><td><a href="all_order.do?pr=1" style="text-decoration:none;font-size:15px;color:#7D0E0E">Today Guest Orders</a></td></tr>
       <tr><td><a href="view_range_order.do" style="text-decoration:none;font-size:15px;color:#7D0E0E">Registerd User Order Date Wise </a></td></tr> 
<tr><td><a href="guest_datewise.do" style="text-decoration:none;font-size:15px;color:#7D0E0E">Guest User Order Date Wise</a></td></tr> 
<tr><td><a href="get_invoice.do" style="text-decoration:none;font-size:15px;color:#7D0E0E">Invoice</a></td></tr>
 <tr><td><a href="update_web.do" style="text-decoration:none;font-size:15px;color:#7D0E0E">Update Website</a></td></tr> 
    
    <!--<tr><td><a href="gotocms.do" style="text-decoration:none;font-size:15px;color:#7D0E0E">Content Management System</a></td></tr>-->
    </table>
</td>

<td valign="top" width="75%"><table align="center" width="100%">

                        <tr><td align="right"><font color="maroon" size="2">Welcome&nbsp;</font><font color="darkblue" 
          size="4">'<%=usernam%>'</font></td>
                        <!--<td align="right" style="padding-left: 10px"><font color="maroon" size="2"><a href="<%=request.getContextPath()%>/logout.do?method=logout">Logout&nbsp;</a></font></td>-->
                        </tr>


                    
                    
                    <tr><td align="center"><table align="center">
                        <tr><td>
<form name="" action="<%=request.getContextPath()%>/view_user_profile.do?method=search_user" method="post">
  <table align="center">
       <input type="hidden" name="emailid" value="<%=usernam%>">
       <tr><td>Search user by user's email id</td></tr>
<tr><td>Email id:&nbsp;&nbsp;<input type="text" name="userid"></td>

      <td> <input type="submit" value="Search"></td>
      </tr>
      
   </table>
</form>
  </td></tr>
  
  
                    </table></td></tr>
                    <tr><td height="450" valign="top">      
                <table width="100%" border="0" cellpadding="0" >
        
 <tr><td colspan="0" width="50%" bgcolor="#ffffff">
<table width="100%" border="0" cellpadding="0" cellspacing="5" align="center">
   
    
    <tr><td  bgcolor="">  
    <table width="100%" align="center"><tr><td width="100%" align="center"><font color="darkblue" size="3"><b>List Of All Registered Users</b></font></td></tr></table>
    <table  width="100%" align="center" height="330" cellpadding="0" cellspacing="0"><tr><td valign="top">   
    <table  width="100%" align="center" cellpadding="0" cellspacing="0" border="1" class="t">
    <tr><td colspan="8"><font style="font-size:12"><b>Displaying Records:&nbsp;<%=ft%></b></font>
    <%if(!pre.equals("")){%>
    <a href="CompaniesPagewise.do?method=companiesList&pr=<%=pre%>"><font style="font-size:12;color:blue">Previous</font></a>
    <%}
    if(!nxt.equals("")){
    %>
   <a href="CompaniesPagewise.do?method=companiesList&pr=<%=nxt%>"><font style="font-size:12;color:blue">Next</font></a>
   <%}%>
   </td></tr>     
    <tr><td valign="top" align="center"><FONT STYLE="font-weight:bold;color:blue;font-size:15px">SNo.</b></font></td>
<td><FONT STYLE="font-weight:bold;color:blue;font-size:17px">Email ID:</b></font></td>
<td><FONT STYLE="font-weight:bold;color:blue;font-size:17px">Name</font></td>
<!--<td><FONT STYLE="font-weight:bold;color:blue;font-size:17px">Address</font></td>
<td><FONT STYLE="font-weight:bold;color:blue;font-size:17px">City</font></td>
<td><FONT STYLE="font-weight:bold;color:blue;font-size:17px">State</font></td>
<td><FONT STYLE="font-weight:bold;color:blue;font-size:17px">Country</font></td>-->
    <td><FONT STYLE="font-weight:bold;color:red;font-size:17px">View Profile</FONT></td>
    </tr>    
     <%
     for(int m=0;m<hs.size();m++){  
       rb=(JavaBean1)hs.get(m);
     %>    
    <tr><td align="center"><FONT STYLE="font-weight:normal;color:black;font-size:15px"><%=k++%></font></td>
<td><FONT STYLE="font-weight:normal;color:black;font-size:15px"><%=rb.getEmail_id()%></font></td>
<td><FONT STYLE="font-weight:normal;color:black;font-size:15px"><%=rb.getName()%>&nbsp; <%=rb.getLast_name()%></font></td>
<!--<td><FONT STYLE="font-weight:normal;color:black;font-size:15px"><%=rb.getHomeaddress()%></font></td>
<td><FONT STYLE="font-weight:normal;color:black;font-size:15px"><%=rb.getCity()%></font></td>
<td><FONT STYLE="font-weight:normal;color:black;font-size:15px"><%=rb.getState()%></font></td>
<td><FONT STYLE="font-weight:normal;color:black;font-size:15px"><%=rb.getCountry()%></font></td>-->



    
    <td width="20%"><font style="font-size:12"><a href="<%=request.getContextPath()%>/view_user_profile.do?method=search_user&userid=<%=rb.getEmail_id()%>">view profile</a></font></td>
    </tr>
    <%}%> 
    <tr><td colspan="2"><font style="font-size:12"><b>Displaying Records:&nbsp;<%=ft%></b></font>
    <%if(!pre.equals("")){%>
    <a href="CompaniesPagewise.do?method=companiesList&pr=<%=pre%>"><font style="font-size:12;color:blue">Previous</font></a>
    <%}
    if(!nxt.equals("")){
    %>
   <a href="CompaniesPagewise.do?method=companiesList&pr=<%=nxt%>"><font style="font-size:12;color:blue">Next</font></a>
   <%}%>
   </td></tr> 
   </tr>
</table></td>
  <!--text end from here-->  
 </tr>
 </table></td>
 </tr>
  </table>
     </td></tr>
                    

     
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


