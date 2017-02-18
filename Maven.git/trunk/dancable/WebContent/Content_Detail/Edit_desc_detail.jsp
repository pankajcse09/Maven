<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="moreimg.img_bean"%>
<%@page import="moreimg.function_int_foodmart"%>
<%@page language="java"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Main_category.item_bean"%>
<HTML>
<HEAD>
<TITLE>Impart</TITLE>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=windows-1251">
 
<script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
</HEAD>
<BODY style="margin-left:80;margin-right:80;margin-top:5">
<%ArrayList contentlist=new ArrayList();
img_bean be=new img_bean();
%>
  <%if(request.getAttribute("contentlist")!=null){
   be=(img_bean)request.getAttribute("contentlist");
  %>
  <!--maintable-->
<table width="100%" height="100%" >
    <TR><TD valign=top ><%@ include file="../Registration/top_design_1.jsp" %></TD></TR>

<tr><td align="center"  bgcolor="" valign="top">
<!--2nd table-->
<TABLE WIDTH="100%">
   

  

      <form action="update_descdetail_content.do?method=update_descdetail_content" method="post">
          <tr><td><textarea  rows="25" cols="100" name="desc"><%=be.getDesc()%></textarea></td></tr>
         
          <input type="hidden" name="headid" value="<%=be.getHead_id()%>" >
         
            <input type="hidden" name="pagename" value="<%=be.getPage_name()%>">
          <tr><td><input type="submit"  align="center" value="update"></td></tr>
          </form>
      </table>
  <%
    %>
   <%}%>
</TD></TR></TABLE>

</BODY>
</HTML>