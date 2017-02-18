 
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page import="java.util.ArrayList"%>
<%@page import="moreimg.img_bean"%>
<%@page import="moreimg.function_int_foodmart"%>
<%@page import="java.io.*"%>
<%@page import="Main_category.item_bean"%>
<%@ page language="java"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
   <head>
      <STYLE type="text/css">
BODY {
	background-repeat:no-repeat;
        BACKGROUND-COLOR: #000000; TEXT-ALIGN: center
}

</STYLE>
 <script type="text/javascript" language="javascript"> 
   

 var newwindow = ''
function popitup(url) {
if (newwindow.location && !newwindow.closed) {
    newwindow.location.href = url;
    newwindow.focus(); }
else {

    newwindow=window.open(url,'htmlname','width=404,height=316,resizable=1');
 
    newWindow.document.writeln("<html>");
    newWindow.document.writeln("<body style='margin: 0 0 0 0;'>");
    newWindow.document.writeln("<a href='javascript:window.close();'>");
    newWindow.document.writeln("<img src='" + url + 
       "' alt='Click to close' id='bigImage'/>");
    newWindow.document.writeln("</a>");
    newWindow.document.writeln("</body></html>");
    newWindow.document.close();

  
    newwindow.resizeTo(400,500);
newwindow.moveTo(800,200);
  
}
    
}

function tidy() {
if (newwindow.location && !newwindow.closed) {
   newwindow.close(); }
}
   


 

</script> 
</head>
    <body onUnload="tidy()">
   <%   String page_name="";
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
 ArrayList gwm=new ArrayList();
 ArrayList news=new ArrayList();
  ArrayList contactus=new ArrayList();
if(request.getAttribute("homelist")!=null)
{
homelist=(ArrayList)request.getAttribute("homelist");
//out.println(homelist);
}
 

 if(request.getAttribute("page_name")!=null)
{
page_name=(String)request.getAttribute("page_name");
//out.println(homelist);
}
%>
       
<table width="100%" height="550" border="0">
   
    <tr>
<td colspan="2" align=left valign="top" width="100%"  height="78">
     <table valign="top" cellpadding="0" cellspacing="0" border="0" width="100%">
<tr><td valign="top" align="left">
      <%@include file="./Top_menu.jsp"%></td></tr>
       </table>
       
       </td></tr>
<tr><td width="20%"  valign="top"><%@include file="/view_content/Browse_item.jsp"%></td>
<td width="80%"  valign="top">
<table width="100%" border="0">


 <tr><td valign="top"  BACKGROUND="./fashion_img/bg.jpg">
      
    <table border="0" cellpadding="0" cellspacing="0" style="border-collapse: collapse"  width="100%">
               
 
   <%for(int i=0;i<homelist.size();i++)

                      {

   %>
    
   <%
       imgbe=(img_bean)homelist.get(i);
      page_id=new Integer(imgbe.getPage_id()).toString();
      ArrayList moreimglist=new ArrayList();
        moreimglist=(ArrayList)fd.select_moreimg("ourproduct",Integer.parseInt(page_id));
        
             
%>
<tr>
<td width="100%" align="center" valign="top">
<table border="0" width="90%">
<tr><td  height="40"  style="padding-left:8px;" colspan="<%=1+moreimglist.size()%>">

<p align="justify"><font style="font-size:1.3em;font-weight:bold;color:#330000;line-height:1.3em"><%=imgbe.getHead()%></font>

</td></tr>
</table>
</td></tr>

<tr>
<td width="100%" align="center" valign="top">
<table border="0" width="90%"><tr>
<%
if(!imgbe.getFilename().equals("")){
           // out.println("a"+picbe.getFilename());
           //  fn1=request.getContextPath()+"/Imge/"+imgbe.getFilename();  
fn1="http://www.aksfashionnews.com/data_image/"+imgbe.getFilename();

%>
<td  align="left" style="padding-top:20px"><A HREF="javascript:popitup('<%=fn1%>')">
<img src="<%=fn1%>" border="0" width="220" height="250" /></a></td>
<%}%>
<%for(int k=0;k<moreimglist.size();k++){
picbe=(img_bean)moreimglist.get(k);
if(!picbe.getFilename().equals("")){
fn3="http://www.aksfashionnews.com/data_image/"+picbe.getFilename();  
//  fn3=request.getContextPath()+"/Imge/"+picbe.getFilename();  
    
    
    
%>
<td align="left" style="padding-top:20px"><A HREF="javascript:popitup('<%=fn3%>')">
<img src="<%=fn3%>" border="0" width="220" height="250" /></a></td>                          
<%}}%>
</tr></table>
</td>                          

</tr>  

<tr> 

<td align="center" style="padding-left:8px;" colspan="<%=1+moreimglist.size()%>">

<p align="justify"><font style="font-weight:bold;color:#FFFFCC;line-height:1.3em"><%=imgbe.getDesc()%></p>

<%
boolean tr=false;
tr=(boolean)fd.Read_More(imgbe.getPage_id());
if(tr==true)
{%>
<a href="view_details.do?method=Content_Detail_Data&id=<%=imgbe.getPage_id()%>">

<font style="font-size:10;color:blue;font-weight:bold">Read More</font></a>
<%}%>
</td>

</tr>

<%}%>

</table> 
            
     
  </td></tr>
  
  
  </table></td></tr>
  </table>
 </body>
 </html>