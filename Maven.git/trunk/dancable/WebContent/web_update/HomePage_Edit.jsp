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

<script language="javascript">

    function edit_image(id,pagename)
    {

  document.forms[0].method="POST";
  document.forms[0].action="<%=request.getContextPath()%>/edit_images.do?pagename="+pagename+"&id="+id;
 document.forms[0].submit(); 
    }    
     function edit_more_image(id,pagename)
    {
  document.forms[0].method="POST";
  document.forms[0].action="<%=request.getContextPath()%>/edit_more_images.do?pagename="+pagename+"&id="+id;
 document.forms[0].submit();   

    }
    </script></head>
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
 function_int_foodmart fd=new function_int_foodmart();
 ArrayList advert=new ArrayList();
 ArrayList blog=new ArrayList();
 String pagename="";
if(request.getAttribute("homelist")!=null)
{

homelist=(ArrayList)request.getAttribute("homelist");
//out.println(homelist);
}
if(request.getAttribute("advert")!=null)
{

advert=(ArrayList)request.getAttribute("advert");
//out.println(homelist);
}
if(request.getAttribute("blog")!=null)
{

blog=(ArrayList)request.getAttribute("blog");
//out.println(homelist);
}
 if(request.getAttribute("pagename")!=null)
{

pagename=(String)request.getAttribute("pagename");
//out.println(pagename);
}%>

<body>

<!--maintable-->
<table width="100%" height="100%"  border="0" >
      <TR><TD valign=top ><%@ include file="../Registration/top_design_1.jsp" %></TD></TR>

<TR>
<TD WIDTH=100% HEIGHT=100%>
<!--3rd table-->
     <table width=100% BORDER="0" >
                 
<form>
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
fn1="http://www.aksfashionnews.com/data_image/"+imgbe.getFilename();


%>


<td><img src="<%=fn1%>" width="100" height="80" onclick="edit_image('<%=imgbe.getPage_id()%>','<%=imgbe.getPage_name()%>')" /></td>
<%}%>
<%for(int k=0;k<moreimglist.size();k++){
picbe=(img_bean)moreimglist.get(k);
if(!picbe.getFilename().equals("")){
//fn3=request.getContextPath()+"/Imge/"+picbe.getFilename();  

fn3="http://www.aksfashionnews.com/data_image/"+picbe.getFilename();
%>
<td><img src="<%=fn3%>" width="100" height="80" onclick="edit_more_image('<%=picbe.getPage_id()%>','<%=picbe.getPage_name()%>')" /></td>                          
<%}}%>
</tr></table>
</td>                          

</tr>  
<tr><td  style="border:1px solid black"colspan="<%=1+moreimglist.size()%>"><font face="bold 12px/74px Verdana, Arial, Helvetica, sans-serif" size="4" align="justify" color="#1C6BA6">
<b><%=imgbe.getHead()%></b>
<a href="edit_details.do?method=Edit_Head_Content&id=<%=imgbe.getPage_id()%>">
<font style="color:blue" size="2">Edit</font></a></td></tr>
<tr><td bgcolor="lightyellow"colspan="<%=1+moreimglist.size()%>">
 <font align="justify" color="#5678B0" face="arial" size="2"><%=imgbe.getDesc()%><a href="edit_desc_details.do?method=Edit_Desc_Content&id=<%=imgbe.getPage_id()%>"><font 
style="color:blue">Edit</font></a></td></tr>
<tr><td><a href="edit_view_details.do?method=Content_More_Data&id=<%=imgbe.getPage_id()%>"><font style="color:blue" size="2">Read More</font></a></td></tr>


<%}%>
 </table>
 </form>
</TD>
</TR>
<!--text end-->
</table> 


</BODY>
</HTML>