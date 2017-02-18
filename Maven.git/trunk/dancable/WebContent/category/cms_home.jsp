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

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danceables</title>
    </head>
     <body style="margin-left:80;margin-right:80;margin-top:5">
         <div id="conta">
<table width="100%" border="0" style="border-collapse:collapse" cellspacing="0" cellpadding="0">
    <TR><TD valign="top"><%@ include file="/Registration/top_design_1.jsp"%></TD></TR>
    <tr><td valign="top"><table cellspacing="0" cellpadding="0" width="100%">
                <tr align="center"><td width="200" height="70"><a href="create_mc.do">Create Main Category</a></td>
    

    <td width="200"><a href="fwd.do">Content Management System</a></td>
    <td width="100"><a href="newRelease.do?method=mainCategories">New Release</a></td>
    <td width="200"><a href="uploadWritten.do?method=mainCategories">Upload Written Music</a></td>
    <td width="200"><a href="addContent.do?method=mainCategories">Add Music Content</a></td>
    <td width="100"><a href="evd_strm.do">Everyday Stream</a></td>
    <td width="200"><a href="promoProductDetail.do?method=mainCategories">Promotions For Products</a></td>
 <!--<td  height="70"><a href="edit_cm.do">Browse Items</a></td></tr>     
   
        
   <tr><td><a href="user_view_order.do?pr=1">View Order</a></td>   
  <td><a href="view_range_order.do">View Date Wise Order</a></td>-->
    </tr></table></td></tr>
</table>
    </div>
    </body>
</html>
