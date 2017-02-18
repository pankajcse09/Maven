<%-- 
    Document   : AddTransport_route
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
         
         <script language="javascript">
             function addIn_temp(){
                 document.forms[0].method="post";
                 document.forms[0].action="<%=request.getContextPath()%>/adding_rt.do?method=adding_rt";
                 document.forms[0].submit();
             }
             
             function validate(){
                if(document.f1.elements["route"].value==""){
                    alert("Please Enter Route");
                    document.f1.elements["route"].focus();
                    return false;
                    }
                if(document.f1.elements["place"].value==""){
                    alert("Please Enter Place");
                    document.f1.elements["place"].focus();
                    return false;
                    }
                if(document.f1.elements["fare"].value==""){
                    alert("Please Enter Fare Per Semester");
                    document.f1.elements["fare"].focus();
                    return false;
                }
                addIn_temp();
             }
         </script>
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
         String ok="";
         
         if(request.getAttribute("rt_list")!=null)
                         {
             al=(ArrayList)request.getAttribute("rt_list");
         }
         
         if(request.getAttribute("added")!=null)
                         {
             ok=(String)request.getAttribute("added");
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
<table style="padding-left: 250px" align="center">
<tr><td  valign="top" colspan="100%" align="center"><font style="font-size:18;font-weight:bold;color:darkblue">Add Route</font></td></tr>
</table></td></tr>
  <tr><td style="padding-left: 200px">  
          <form name="f1" action="<%=request.getContextPath()%>/add_rt.do?method=add_rt" method="post">
              <table  align="center" border="1" style="border-collapse:collapse" width="500">
                  <% if(!ok.equals("")){%>
                  <tr><td colspan="2" align="center"><font color="red"><%=ok%></font></td></tr>
                  <%}%>
                  <tr><td><font style="font-size:12;color:black"><b>Route</b></font></td><td><input type="text" name="route"></td></tr>
                    <tr><td><font style="font-size:12;color:black"><b>Place</b></font></td><td><input type="text" name="place"></td></tr>
                  <tr><td><font style="font-size:12;color:black"><b>Fare/Semester</b></font></td><td><input type="text" name="fare" onblur="validate()"></td></tr>
                  
              </table>
              <%if(al.size()!=0)
                  {%>
              <table align="center" border="1" style="border-collapse: collapse; padding-top: 20px" width="600">
                  <tr><td><b>Route</b></td><td><b>Place</b></td><td><b>Fare</b></td></tr>
                  <% for(int i=0;i<al.size();i++)
                  {
                    rtb=(Rt_bean)al.get(i); 
%>
                    <tr><td><font color="white"><%=rtb.getRoute()%></font></td><td><font color="white"><%=rtb.getPlace()%></font></td>
                        <td><font color="white"><%=rtb.getFare()%></font></td></tr>
                    <%}%>
                    <tr><td colspan="3" align="center"><input type="submit" value="Add All Details"></td></tr>
              </table>
              <%}%>
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
