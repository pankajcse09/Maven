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

String status=request.getParameter("status");
String failreason=request.getParameter("failReason");
String loginid=request.getParameter("user_id");
session.setAttribute("loginid",loginid);
%>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Response Error Page</title>
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/pro_drop_1/laycss.css" />
         <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/prop_drop/pro_drop.css" />
            
              
   
                 
</head>
<body>

           <script language="javascript">
   if(screen.width==1024)
	 {
            document.write("<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/css_js/lay.css' />"); 
          }
 else if(screen.width==1280)
  	{
            document.write("<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/css_js/lay_1.css' />"); 
	}

else if(screen.width==1360)
  	{
            document.write("<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/css_js/lay_2.css' />"); 
	}
else 
{ 
    document.write("<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/css_js/lay_2.css' />"); 
}
document.write("<link rel='stylesheet' type='text/css' href='<%=request.getContextPath()%>/css/change.css' />");

</script>
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
                <table width="100%" height="300">
                <tr><td width="100%" align="center">
                        <p><font style="font-size: 20px" color="#E44129">Sory, we can not process your order <%//=status%></font></p>
                        <p><font style="font-size: 16px" color="#E44129">Thank you for visiting our store, but we are unable to process your order at this time. Please try different payment method.<%//=failreason%></font></p>
                    </td></tr>
            </table>
                </td></tr>                   
       <tr><td><%@include file="/footer.jsp"%></td></tr>
   
</table>
</body>
</html>

