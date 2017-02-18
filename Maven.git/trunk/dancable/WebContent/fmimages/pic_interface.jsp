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
<HTML>
<HEAD>
<TITLE>Danceables Management</TITLE>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=windows-1251">
    
<script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
</HEAD>
<body>

  <!--maintable-->
<table width="100%"   border="0" bordercolor="black" >
<tr><td align="center"  bgcolor="" valign="top">
<!--2nd table-->
<TABLE WIDTH="940" CELLPADDING=0>
 <TR><TD vAlign=top colspan="2" ><%@ include file="../Registration/top_design_1.jsp" %></TD></TR>
   
<TR>		
<TD>
<!--3nd table-->
<TABLE WIDTH=100% BORDER="0" CELLPADDING=0 CELLSPACING=0 >
<TR>
<TD WIDTH=100% ALIGN="center">
<!--4rd table-->

<TABLE WIDTH=98% BORDER="0" CELLPADDING=0 CELLSPACING=0 height="400" bordercolor="black">

    

<tr>
<td width="79%" valign="top">
<table width="100%" border="0" cellpadding="0" cellspacing="5" align="center">
   <tr><td COLSPAN=7>  <h3>Your Image upload here..</h3></td></tr>        
        <%
       img_bean be=new img_bean();
       
       String page_name="";
       int page_id=0;
        if(request.getAttribute("pgdetail")!=null){
        
        be=(img_bean)request.getAttribute("pgdetail");
page_name=be.getPage_name();
page_id=be.getPage_id();
//out.println(page_name);
%>
        <%}%>
    <form  action="morepic.do" enctype="multipart/form-data" method="post">
 
    
   <tr> 
      <td >Image</td> 
      <td ><input type="file" name="uploads[0]" size="40" /></td> 
   </tr> 
  
   
   
   <tr> 
   <td> 
   <input type="submit" name="save" value="save">

  <input type="hidden" name="page_name" value="<%=page_name%>">
  
   <input type="hidden" name="page_id" value="<%=new Integer(page_id).toString()%>">  
   </td> 
   </tr>   
     
  
</form>   

</table>

</td></tr></table>
</td></tr></table>
</TD>
<!-- 3 td-->
</TR>

<!--footer close-->  
</TABLE><!--main table close-->
</td></tr></table>
</td></tr></table>
</td></tr>
  <TR><TD vAlign=top ><%@ include file="../jsp/hrms_footer.jsp" %></TD></TR>
   
</table>
<!-- End ImageReady Slices -->
</BODY>
</HTML>