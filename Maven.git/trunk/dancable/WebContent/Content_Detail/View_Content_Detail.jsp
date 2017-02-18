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
        <meta name="viewport" content="width=device-width">
        <title>Danceables</title>
        <script language="javascript" src="css_js/resolution.js"></script>
        <link rel="stylesheet" type="text/css" href="css/change.css" />
        <script language="javascript" src="css/menu.js"></script>

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
    <body>
<table width="100%" cellspacing="0" cellpadding="0">
            <tr>
                <td>
                    <div id="topdesign">
                       <div class="header1">
                           <img src="<%=request.getContextPath()%>/images/homepage/logo_03.png" width="253">
                               </div>
                            <div class="header2">
                                <div class="user"><%@include file="/user_login/user_head.jsp"%></div>
                                <div class="header2_2"><%@include file="/top_menu.jsp"%></div>
                            </div>

                        </div>
                </td>
            </tr>
  <tr><td background="<%=request.getContextPath()%>/images/homepage/bottom grey.png" width="100%" valign="top" style="background-repeat: no-repeat" border="">
                 <table class="cel1" style="padding-left: 0px" border="0" align="center">
               <tr>      
                   <td>        
 <TABLE   border="0" align="center">

   
        <TR><td align="left">
            
        <table border="0" width="80%" align="center">
        
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
//  fn1=request.getContextPath()+"/Detail_Imge/"+imgbe.getFilename();  
%>
<td valign="top">
    <div style="float: left;margin: 15px 10px"><img src="<%=fn1%>" width="200"/></div>
    <div style="margin: 15px 10px"><font><b class="tdhead"><%=imgbe.getHead()%></b></font>
        <br>
        <%=imgbe.getDesc()%>
    </div>
</td>                          
<%}%>
</tr>  

<%}%>
      
            
            </table>
        
        
        </td></TR>
       
       </TABLE>  
		
                 </td>
        </tr>
   <tr>
          <td><%@include file="/footer.jsp"%></td>
                        </tr>  
    
  </table>   
      </td>
               </tr>
   
</table>
    
    </body>
</html>
