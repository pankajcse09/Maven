<%-- 
    Document   : editTransport_route
    Created on : May 2, 2013, 12:30:02 PM
    Author     : kapil
--%>

<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.util.*" %>
<%@page import="java.sql.*,schedule.*"%>
<%@page import="com.myapp.struts.Dataconnectivity"%>
<%@page import="Transport.Rt_bean"%>
<!DOCTYPE html>
<html>
   <head>
<style type="text/css">.t{border-collapse:collapse}</style>
<script language="javascript" src="<%=request.getContextPath()%>/UnitTest/printData.js"></script>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
</head>
<body bgcolor="#999933">
    <style>
             input[type=button] {
                 cursor: pointer;
    
    background-color: #A89263;
    color: #333333;
    padding: 2px 6px 2px 6px;
    border-top: 1px solid #CCCCCC;
    border-right: 1px solid #333333;
    border-bottom: 1px solid #333333;
    border-left: 1px solid #CCCCCC;
   }
   
   input[type=button]:hover {
       background-color: #EEEEEE;
   }
   
   input[type=button]:visited {
       background-color: green;
   }
   
   .vr {
    width:2px;
    background-color:#000;
    position:absolute;
    top:151px;
    height: 664px;
    left:300px;
}
         </style> 
         <% 
         ArrayList al=new ArrayList();
         Rt_bean rtb=new Rt_bean();
         Rt_bean rtb1=new Rt_bean();
         int id=0;
         
         try{
            if(request.getAttribute("id")!=null)
            {
                id=Integer.parseInt(request.getAttribute("id").toString());
            }
        }catch(NumberFormatException e){System.out.println(e);}
         
         if(request.getAttribute("rt_list")!=null)
                         {
             al=(ArrayList)request.getAttribute("rt_list");
         }
         
         if(request.getAttribute("rt")!=null)
                         {
             rtb1=(Rt_bean)request.getAttribute("rt");
         }
         %>
         
<table width="100%" class="res" cellpadding="0" cellspacing="0" align="center">
<tr><td align="center" width="100%" style="padding-top:50px" height="100"><%@include file="/fee/toplook_1.jsp"%></td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
 <tr><td valign="top" style="padding-left: 5px;" align="left"><font color="green" style="font-family:Times New Roman" size="4"><strong>Utilities</strong></font></td>
     <td width="2" bgcolor="#000000"></td>
            </tr>
          <tr><td valign="top" style="padding-left: 5px" width="200">            
            <%@include file="/fee/utilities_menu.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left"><table>

                  <tr><td>
<table style="padding-left: 350px">
<tr><td  valign="top" colspan="100%" align="center"><font style="font-size:18;font-weight:bold;color:darkblue">Edit Route</font></td></tr>
</table></td></tr>
                <tr><td style="padding-left: 200px">  
                        <form action="<%=request.getContextPath()%>/update_rt.do?method=update_rt" method="post">
       <table  align="center" border="1" style="border-collapse:collapse" width="500" bgcolor="#FFFFCC">
 <%if(request.getAttribute("msg")!=null){%>
 <tr><td colspan="5" align="center"><font color='red'><b><%=request.getAttribute("msg")%></b></font></td></tr>
<%}%>
     <tr><td class="tdcolor1"><b>Sr no.</b></td>
         <td class="tdcolor1" align="center"><b>Route</b></td><td class="tdcolor1" align="center"><b>Place</b></td>
         <td class="tdcolor1" align="center"><b>Fare/Semester</b></td>
         <td class="tdcolor1"></td>
     </tr>    
<%for(int i=0;i<al.size();i++){
rtb=(Rt_bean)al.get(i);

if(rtb.getId()==id)
          {
%>
<tr><td colspan="1"><%=i+1%></td>
    <td colspan="4">
        <table border="0" align="center">
            <tr><td><b>Route:</b></td><td><%=rtb.getRoute()%><input type="hidden" name="route" value="<%=rtb.getRoute()%>"></td></tr>
                <tr><td><b>Place:</b></td><td><input type="text" name="place" value="<%=rtb.getPlace()%>"></td></tr>
                <tr><td><b>Fare/Semester:</b></td><td><input type="text" name="fare" value="<%=rtb.getFare()%>"></td></tr>
                <input type="hidden" name="id" value="<%=rtb.getId()%>">
                <tr><td colspan="2" align="center"><input type="submit" value="update"></td></tr>
         </table>
    </td></tr>
<%}else{%>
<tr>
<td><%=i+1%></td>
<td align="center"><%=rtb.getRoute()%></td>
<td align="center"><%=rtb.getPlace()%></td>
<td align="center"><%=rtb.getFare()%></td>
<td align="center"><a href="<%=request.getContextPath()%>/editTrp_route.do?method=editTrp&id=<%=rtb.getId()%>"><font style="font-size:12;color:blue"><b>Edit</b></font></a>&nbsp;&nbsp;&nbsp;
<a href="<%=request.getContextPath()%>/del_rt.do?method=del_rt&id=<%=rtb.getId()%>"><font style="font-size:12;color:blue"><b>Delete</b></font></a></td>
</tr>
<%}}%>
</table>   
   </form>
                </td></tr>
            </table>
</td></tr> 
</table></td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
    </body>
</html>
