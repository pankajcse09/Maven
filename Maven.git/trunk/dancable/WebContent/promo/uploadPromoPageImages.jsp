<%-- 
    Document   : uploadPromoPageImages
    Created on : Jan 23, 2014, 6:35:18 PM
    Author     : kapil
--%>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@page import="mc_bean.mc_prop"%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>cms</title>
    </head>
    <body>
 <% String maincat="";
 String mainid="";
mc_prop subcat_prop= new mc_prop();

%>

    <%if(request.getAttribute("subcat_detail")!=null){
    subcat_prop=(mc_prop)request.getAttribute("subcat_detail");
    maincat=subcat_prop.getSub_cat();
    mainid=new Integer(subcat_prop.getC_id()).toString();
    }%>
    <%
       if(request.getParameter("cat")!=null){
maincat=request.getParameter("cat");
       }
       else if(request.getAttribute("cat")!=null)
       {
           maincat=(String)request.getAttribute("cat");
       }
if(request.getParameter("id")!=null){
     mainid=request.getParameter("id");
    }%>
<h1><%=maincat%></h1>
<%if(request.getAttribute("uploaded")!=null)
{%>
<div style="color:#357D31"><%=request.getAttribute("uploaded")%></div>
<%}%>
<html:messages id="err_name" property="common.file.err">
<div style="color:red">
	<bean:write name="err_name" />
</div>
        </html:messages>
<html:form action="upload_promoImages.do?method=uploadpromoImages" method="post" enctype="multipart/form-data">
<table>
    <tr><td>Page Link Image:</td><td><html:file property="link_image" size="50" /></td></tr>
    <tr><td>Page Header Image:</td><td><html:file property="header_image" size="50" /></td></tr>
    <tr><td>Page Description:</td><td><html:textarea property="page_desc" rows="10" cols="40" /></td></tr>
    <tr><td>Thank You Message:</td><td><html:textarea property="thanks_msg" rows="5" cols="40" /></td></tr>
    <html:hidden property="subcat_id" value="<%=mainid%>"/>
    <html:hidden property="sub_cat" value="<%=maincat%>"/>
    <tr><td><html:submit value="save"></html:submit></td></tr>
    <%if(request.getAttribute("msg")!=null){%>
    <tr><td align="center"><font style="font-size:14;font-weight:bold;color:red"><%=request.getAttribute("msg")%></font></td></tr>   
    <%}%>  
    </table>
    
</html:form>
    </body>
</html>
