<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="moreimg.img_bean"%>
<%@page import="moreimg.function_int_foodmart"%>
<%@page language="java"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Main_category.item_bean"%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      
<script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
         <title>Horticulture Produce Management Institute</title>
    </head>
    <body style="margin-left:80;margin-right:80;margin-top:5">
<%ArrayList contentlist=new ArrayList();
img_bean be=new img_bean();
%>
  <%if(request.getAttribute("contentlist")!=null){
   be=(img_bean)request.getAttribute("contentlist");
  %>
  <table width="100%"  border="0" bordercolor="black" >
      <TR><TD valign=top ><%@ include file="../Registration/top_design_1.jsp" %></TD></TR>

<tr><td align="center"  bgcolor="" valign="top" height="300" >
<!--2nd table-->

<TABLE WIDTH=100%>
<!--text-->



</td></tr>
<tr><td valign="top">  
  <table>
      <form action="update_head_more.do?method=update_head_more" method="post">
          <tr><td><textarea  rows="5" cols="80"name="head"><%=be.getHead()%></textarea></td></tr>
          <input type="hidden" name="headid" value="<%=be.getHead_id()%>" >
            <input type="hidden" name="pagename" value="<%=be.getPage_name()%>">
          <tr><td><input type="submit"  align="center" value="update"></td></tr>
          </form>
      </table>
  <%
    %>
   <%}%>
</table>
   
</TR>
</TD>
 <TR><TD vAlign=top colspan="2" ><%@ include file="../jsp/hrms_footer.jsp" %></TD></TR>
</TABLE><!--main table close-->

</HTML>
