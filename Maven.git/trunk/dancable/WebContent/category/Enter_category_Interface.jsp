<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page import="com.myapp.struts.Im_Projects_DataHold"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.myapp.struts.Display_Data_hold"%>
<%@page import="moreimg.img_bean"%>
<%@page import="moreimg.function_int_foodmart"%>
<%@page language="java"%>
<%@page import="java.io.*"%>
<%@page import="Main_category.item_bean"%>
<html>
<body style="margin-left:20;margin-right:20">


<table width="100%" height="550" border="0">
    <TR><TD vAlign=top align=left colSpan=2 height="155"><%@include file="/header.jsp"%></TD></TR>  

<tr><td width="100%" height="75%" valign="top">
<table>
   
<b>Enter MainCategory</b>
    <html:form action="imc" method="post">
    <table>
      <tr><td>  Enter MainCategory:</td><td><html:text property="mc" ></html:text></td></tr>
      <tr><td><html:submit value="save" property="save" />
    </td></tr>
    
    <%if(request.getAttribute("msg")!=null){%>
    <tr><td><font color="red"><%=(String)request.getAttribute("msg")%></font></td></tr>
    <%}%>
        </table>
       
    </html:form>

 </table>
</td></tr></table>
</body>


</html>