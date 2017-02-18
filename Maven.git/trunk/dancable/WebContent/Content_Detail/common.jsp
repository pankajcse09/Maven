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

<%   
   ArrayList homelist=new ArrayList();
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
String pagename="";
 function_int_foodmart fd=new function_int_foodmart();
 ArrayList advert=new ArrayList();
 ArrayList blog=new ArrayList();
if(request.getAttribute("homelist")!=null)
{

homelist=(ArrayList)request.getAttribute("homelist");
//out.println(homelist);
}

if(request.getAttribute("pagename")!=null)
{

pagename=(String)request.getAttribute("pagename");
//out.println(homelist);
}%>


  <!--maintable-->
<table width="100%" height="100%"  border="0" align="center" border="1" >
     <TR><TD vAlign=top colspan="2" ><%@ include file="../Registration/top_design_1.jsp" %></TD></TR>
   
<tr><td align="center"  bgcolor="" valign="top">
<!--2nd table-->
<TABLE WIDTH="100%"  align="center" style="border-collapse:collapse">

<TR>		
<TD>
<!--3nd table-->
<TABLE WIDTH=100% BORDER="0" CELLPADDING=0 CELLSPACING=0  >
<TR>
<TD WIDTH=100% HEIGHT=100% ALIGN="center" valign="top">
   

<TABLE WIDTH=98% BORDER="1" CELLPADDING=0 CELLSPACING=0 height="100%" bordercolor="black">

  
<TR>
		<TD align="justify" COLSPAN=7 bgcolor="" background="" WIDTH=978 HEIGHT=104 class="tops" valign="top">
                <table width=100% BORDER="0" BORDERCOLOR="" bgcolor="" cellpadding=0 cellspecing=0 align=left style="MARGIN:5px 0in 0px; TEXT-ALIGN:justify">
                 

 
   <%for(int i=0;i<homelist.size();i++)

                      {
   %>
    <tr>
   <%
       imgbe=(img_bean)homelist.get(i);
      page_id=new Integer(imgbe.getPage_id()).toString();
      ArrayList moreimglist=new ArrayList();
        moreimglist=(ArrayList)fd.select_moreimg(pagename,Integer.parseInt(page_id));
        

%>
<td width="107" height="46" align="left" valign="top">
<table><tr>
<%if(!imgbe.getFilename().equals("")){
//fn1=request.getContextPath()+"/Imge/"+imgbe.getFilename();
fn1=request.getContextPath()+"/web_images/"+imgbe.getFilename();
%>
<td><img src="<%=fn1%>" width="140" height="100" /></td>
<%}%>
<%for(int k=0;k<moreimglist.size();k++){
picbe=(img_bean)moreimglist.get(k);
if(!picbe.getFilename().equals("")){
    fn3=request.getContextPath()+"/web_images/"+picbe.getFilename();
//fn3=request.getContextPath()+"/Imge/"+picbe.getFilename();  
%>
<td><img src="<%=fn3%>" width="100" height="100" /></td>                          
<%}}%>
</tr></table>
</td>                          

</tr>  
<tr><td style="border:1px solid black;" colspan="<%=1+moreimglist.size()%>"><b><%=imgbe.getHead()%></b></td></tr>
<tr><td bgcolor="lightyellow" colspan="<%=1+moreimglist.size()%>"><%=imgbe.getDesc()%>
<!--<a href="more_images.do?method=More_Images&id=<%=imgbe.getPage_id()%>">Add More Image</a>-->
</br>
<a href="content_Detail.do?id=<%=imgbe.getPage_id()%>">Add Detail</a></font>
</td></tr>
<tr><td colspan="<%=1+moreimglist.size()%>">
<a href="delete_content.do?pagename=<%=pagename%>&id=<%=imgbe.getPage_id()%>&method=DeleteContent"><font style="color:red">Delete</font></a></font>
</td></tr>
<%}%>
 </table>
</TD>
</TR>
<!--text end-->
<!--advertisment-->

 
</table> 
</td>

<!-- 3 td-->
</TR></TABLE></td>

<!--important for design-->

</TR>

<!--footer close-->  
</TABLE><!--main table close-->
</td></tr></table>
</td></tr></table>
<!-- End ImageReady Slices -->
</BODY>
</HTML>