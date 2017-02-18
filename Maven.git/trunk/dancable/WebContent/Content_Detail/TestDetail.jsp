<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<%@page import="java.util.ArrayList"%>

<%@page import="moreimg.img_bean"%>
<%@page import="moreimg.function_int_foodmart"%>
<%@page language="java"%>
<%@page import="java.io.*"%>
<%@page import="Main_category.item_bean"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danceables</title>
     
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/pro_drop_1/laycss.css" />
            <script language="javascript" src="kk/resolution.js">
</script>
    </head>
    <%   
ArrayList contentlist=new ArrayList();
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
if(request.getAttribute("contentlist")!=null)
{

contentlist=(ArrayList)request.getAttribute("contentlist");
//out.println(homelist);
}
%>
   <body background="<%=request.getContextPath()%>/Diamond/bgb.png" width="100%" height="100%" 
 style="background-repeat: no-repeat; background-position: center top;">
   
<div id="masterdiv">
      <div class="appointment">
              <a href="#"><img class="img" src="./Diamond/appointment.png" border="0"></a></img>
             
             </div>
             
             <div class="searc">
              <a href="#"><img class="img" src="./Diamond/Search.png" border="0"></a></img>
             
             </div>
     <div class="pno">
              <a href="#"><img class="img" src="./Diamond/pno.png" border="0"></a></img>
             
             </div>
    
    
        <div class="logo_img">
              <a href="<%=request.getContextPath()%>/fm_home.do?name=home"><img class="img" src="./Diamond/Logo.png" border="0"></a></img>
             
             </div>
             
           <div class="top_menu">
             <%@include file="./headmenu.jsp"%>
             </div>
             
            <DIV class=clear></DIV>
           
              <div id="cntwidthreadmore" > 
              

 <TABLE   border="0" align="center">

        <TR><td class="tbreadmore" align="left">
            
        <table border="0" width="80%">
        
<%for(int i=0;i<contentlist.size();i++)

                      {

   %>
    <tr>
   <%
      imgbe=(img_bean)contentlist.get(i);
     page_id=new Integer(imgbe.getPage_id()).toString();
      if(!imgbe.getFilename().equals(""))
{
         fn1="http:///www.aksfashionnews.com/data_image/"+imgbe.getFilename(); 
//  fn1=request.getContextPath()+"/Detail_Imge/"+imgbe.getFilename();  
%>
<td width="107" height="46" align="left" valign="top">
<table><tr>
<td><img src="<%=fn1%>" width="200" height="150" /></td>

</tr></table>
</td>                          
<%}%>
</tr>  
<tr><td class="tdhead">
<b><%=imgbe.getHead()%></b></td></tr>

<tr><td><%=imgbe.getDesc()%></td></tr>



<%}%>
      
            
            </table>
        
        
        </td></TR>
       
       </TABLE> 
  
       <TABLE class="fo"  border="0" >
        <tr><td><img class="imgstrip" src="./Diamond/bottomstrip.png"></td></tr>
          <tr><td align="center">  SITEMAP | STORES | PRIVACY POLICY  | TERMS & CONDITIONS | ABOUTUS  </td></tr>   
            <tr><td ALIGN="CENTER">  MINORS OF RICHMOND 2012. ALL RIGHTS RESERVED  </td></tr>               

        
        
       </TABLE> 



 </div> 

 
 
    </div>
    </body>
</html>
