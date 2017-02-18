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
<table width="100%" height="100%"  border="0" >
<tr><td align="center"  bgcolor="" valign="top">
<!--2nd table-->
<TABLE WIDTH="940" height="8" CELLPADDING=0 CELLSPACING=0 bgcolor="" border="0" bordercolor="red" align="center" style="border-collapse:collapse">

<TR>		
<TD>
<!--3nd table-->
<TABLE WIDTH=100% BORDER="0" CELLPADDING=0 CELLSPACING=0 height="100%"  bgcolor="lightyellow"  >
<TR>
<TD WIDTH=100% HEIGHT=100% ALIGN="center">
<!--4rd table-->
 <!--text start from here-->   

<TABLE WIDTH=98% BORDER="0" CELLPADDING=0 CELLSPACING=0 height="100%" bordercolor="black">
  <TR><TD vAlign=top><%@ include file="../Registration/top_design_1.jsp" %></TD></TR>
   
<tr>
<td width="79%" valign="top">
<!--5rd table-->
<table width="100%" border="0" cellpadding="0" cellspacing="5" align="center">
    <tr><td><h3>Add Details here for Content</h3></td></tr>
     <%if(request.getAttribute("msg")!=null)
        {
          
        %>
    <tr><td><font style="font-size:12;font-weight:bold;color:red"><%=request.getAttribute("msg")%>
</td></tr>
    
      
      
       <%}%>
 <tr><td>
 <!--6rd table-->
<table align="center" border="0">
         <tr><td colspan="2"><font color="red">* These Fields Are Mandatory</font></td></tr>
        <html:errors/>
    <html:form action="content_insert?method=content_insert" enctype="multipart/form-data" onsubmit="return validate();" method="post">
        <%
        String page_name="";
        if(request.getParameter("id")!=null){
        page_name=(String)request.getParameter("id");
//out.println("id="+page_name);
%>
        <%}%>
        <%
         if(request.getAttribute("suc")!=null){
        page_name=(String)request.getAttribute("suc");%>
        <%}%>

<tr><td><font color="red">*</font>Heading</td><td>
  
       <html:textarea property="location" rows="3" cols="70" ></html:textarea>
        </td></tr>  
     
        <tr><td><font color="red">*</font>Description</td><td> <html:textarea property="desc" rows="15" cols="70"></html:textarea>    </td></tr> 

<tr><td>Select the Image Upload</td><td><html:file property="prop_file" size="70"/></td></tr>
<tr><td align="center" colspan="2"><html:submit value="save" property="save"></html:submit></td></tr>
<input type="hidden" name="id" value="<%=page_name%>">
</html:form> 

    </table><!--6rd table-->
</td></tr>
<!--important for design-->
</table><!--5rd table-->
</td></tr>
</td></tr></table>
</td></tr></table>

<!--footer close-->  
</TABLE><!--main table close-->
</td></tr>
 <TR><TD vAlign=top colspan="2" ><%@ include file="../jsp/hrms_footer.jsp" %></TD></TR>
   </table>

<!-- End ImageReady Slices -->
</BODY>
</HTML>