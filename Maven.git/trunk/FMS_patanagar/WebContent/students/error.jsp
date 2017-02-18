<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
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
<%
String stud_email=request.getParameter("email");
String stud_id=request.getParameter("udf1");
String ssn=request.getParameter("udf2");
String session_sem=request.getParameter("udf3");
String status=request.getParameter("status");
String error=request.getParameter("Error");
String gatewayKey=request.getParameter("key");
String amount=request.getParameter("amount");
String fname=request.getParameter("firstname");
String lname=request.getParameter("lastname");
String mobile=request.getParameter("phone");
String hash=request.getParameter("hash");
if(session.getAttribute("payment_id")!=null){
    session.removeAttribute("payment_id");
}
if(session.getAttribute("seobean")!=null){
    session.removeAttribute("seobean");   
}
%>
<html>
    <head>
<title>Response Error Page</title>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
        <script language="javascript" src="<%=request.getContextPath()%>/JSF/CheckNumericData.js"></script> 
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>    
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
   
   .vr {
    width:2px;
    background-color:#000;
    position:absolute;
    top:151px;
    height: 447px;
    left:300px;
}
         </style>  

 <table width="100%" class="res" cellpadding="0" cellspacing="0" align="center">
<tr><td bgcolor="#FFFFCC" align="center" width="100%" style="padding-top:0px" height="100"><%@include file="/fee/toplook_payment.jsp"%></td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
 <tr><td valign="top" style="padding-left: 5px" width="160">            
           
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left"> 
                 <table width="100%" align="center">
                    <tr><td width="100%" valign="middle" align="center" bgcolor="white" height="40" >
    <font style="font-size:15;color:black;font-weight:bold">Response Error page</font></td>
                         <td align="right" valign="bottom"><a href="<%=request.getContextPath()%>/index.jsp">Home</a></td>
                     </tr>
                 </table>
                <table width="100%" height="200">
                <tr><td width="100%" align="center"><table>
                        <tr><td width="100%" align="center">
                        <font style="font-size: 20px" color="#AF2916">Sory, we can not process your fee <%=status%></font><br>
                        </td></tr> 
                        <tr><td width="100%" align="center">
                        <font style="font-size: 20px" color="#AF2916">Status </font> <%=status%><br>
                        <font style="font-size: 20px" color="#AF2916">Reason </font> <%=error%><br>
                        </td></tr> 
                        
                        <tr><td width="100%" align="center">
                        <font style="font-size: 16px" color="#AF2916">Thank you for visiting here, but we are unable to process your fee at this time. 
                                Please try again.<br></font>
                        </td></tr>
                        </table></td></tr>
                
            </table>
                    <table width="100%" align="center">
                <tr><td width="80%" align="center">
                        <table>
                        <tr><td width="100%" align="center"><font style="font-size: 20px" color="#E44129">Return To payment page</font>
                        </td></tr>    
                        <tr><td width="100%" align="center">
                        <a href="<%=request.getContextPath()%>/payment.do"><input type="button" value="Payment" style="width:185px"></a>
                        </td></tr>
                        </table></td></tr>
            </table>
                </td></tr>   
</table></td></tr>
       <tr><td><%@include file="/footer.jsp"%></td></tr>
   
</table>
</body>
</html>

