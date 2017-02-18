<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="moreimg.img_bean"%>
<%@page import="moreimg.function_int_foodmart"%>
<%@page language="java"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Main_category.item_bean"%>
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
        <title>Danceables Management</title>
    </head>
    <body>
<%ArrayList contentlist=new ArrayList();
img_bean be=new img_bean();
%>
  <%if(request.getAttribute("contentlist")!=null){
   be=(img_bean)request.getAttribute("contentlist");
  %>
  <table>
      <form action="update_desc_content.do?method=update_desc_content" method="post">
          <tr><td><textarea  rows="5" cols="80" name="desc"><%=be.getDesc()%></textarea></td></tr>
          <input type="hidden" name="headid" value="<%=be.getHead_id()%>" >
            <input type="hidden" name="pagename" value="<%=be.getPage_name()%>">
          <tr><td><input type="submit"  align="center" value="update"></td></tr>
          </form>
      </table>
  <%
    %>
   <%}%>
    </body>
</html>
