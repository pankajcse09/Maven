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
  <title>Danceables Management</title>
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=windows-1251">
     
<script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
</HEAD>
<body style="margin-left:80;margin-right:80;margin-top:5">

<%ArrayList contentlist=new ArrayList();
img_bean imgbe=new img_bean();
item_bean itembe=new item_bean();
ArrayList discountlist=new ArrayList();
img_bean picbe=new img_bean();
String fn1="";
String fn2="";
String fn3="";
String fn4="";
ArrayList qualitylist=new ArrayList();
String  page_id="";
 function_int_foodmart fd=new function_int_foodmart();
 int contentid=0;
if(request.getAttribute("contentlist")!=null)
{

contentlist=(ArrayList)request.getAttribute("contentlist");
//out.println(homelist);
}
if(request.getAttribute("contentid")!=null)
{

contentid=Integer.parseInt((String)request.getAttribute("contentid"));
//out.println(contentid);
}

     
%>
<!--maintable-->
<table width="100%" height="100%"  border="0" bordercolor="black" >
<TR><TD valign=top ><%@ include file="../Registration/top_design_1.jsp" %></TD></TR>


  
<TR>
		<TD  valign="top">
                <table width=100% BORDER="0" BORDERCOLOR="" bgcolor="" cellpadding=0 cellspecing=0 align=left style="MARGIN:5px 0in 0px; TEXT-ALIGN:justify">
                 

 
   <%for(int i=0;i<contentlist.size();i++)

                      {

   %>
    <tr>
   <%
      imgbe=(img_bean)contentlist.get(i);
     page_id=new Integer(imgbe.getPage_id()).toString();
      if(!imgbe.getFilename().equals(""))
{
  fn1=request.getContextPath()+"/web_images/"+imgbe.getFilename();  
%>
<td width="107" height="46" align="left" valign="top">
<table><tr>
<td><img src="<%=fn1%>" width="60%"/></td>

</tr></table>
</td>                          
<%}%>
</tr>  
<tr><td style="border:1px solid black"><b><%=imgbe.getHead()%></b><a href="edit_head_more.do?method=Edit_HeadDetail_Content&id=<%=imgbe.getDetail_id()%>">Edit</a></td></tr>

<tr><td bgcolor="lightyellow"><%=imgbe.getDesc()%><a href="edit_desc_more.do?method=Edit_DescDetail_Content&id=<%=imgbe.getDetail_id()%>">Edit</a></td></tr>

<tr><td><a href="delete_read_more.do?method=DeleteContent_ReadMore&id=<%=imgbe.getDetail_id()%>&contentid=<%=contentid%>">
<font style="color:red">Delete</font></a></td></tr>



<%}%>
</table>
</TD></TR>

<TR><TD vAlign=top colspan="2" ><%@ include file="../jsp/hrms_footer.jsp" %></TD></TR>
</TABLE>


</BODY>
</HTML>