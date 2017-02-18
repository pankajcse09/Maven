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
if(request.getParameter("id")!=null){
     mainid=request.getParameter("id");
    }%>


<html:form action="add_subcat" method="post">
<table>
    <tr><td>Enter sub_category:</td><td><html:text property="subcat" size="15"></html:text></td></tr>
    <html:hidden property="cat_id" value="<%=mainid%>"/>
    <tr><td><html:submit value="save"></html:submit></td></tr>
    <%if(request.getAttribute("msg")!=null){%>
    <tr><td align="center"><font style="font-size:14;font-weight:bold;color:red"><%=request.getAttribute("msg")%></font></td></tr>   
    <%}%>  
    </table>
    
</html:form>
    </body>
</html>
