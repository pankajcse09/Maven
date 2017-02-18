<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>

<%@page import="moreimg.img_bean"%>
<%@page import="moreimg.function_int_foodmart"%>
<%@page language="java"%>
<%@page import="java.io.*"%>
<%@page import="Main_category.item_bean"%>
<!DOCTYPE html>
<html>
<HEAD>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>Danceables</title>
 <script language="javascript" src="<%=request.getContextPath()%>/css_js/resolution.js"></script>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/change.css" />
        <script language="javascript" src="<%=request.getContextPath()%>/css/menu.js"></script>
 </HEAD>
<body>


    
             
<table width="100%" border="0" style="border-collapse:collapse" cellspacing="0" cellpadding="0">
    
   <TR><TD valign="top"><%@ include file="./top_design_1.jsp" %></TD></TR>
  
  

<tr>
<td width="100%" height="450" valign="top" align="left" style="padding-top:20px" >
<%@ include file="/jsp/admin_left_menu.jsp" %> 
</td>


</tr></table>


  <TR><TD vAlign=top ><%//@ include file="/jsp/hrms_footer.jsp" %></td></tr>

</body>


</html>