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
<html>
<body style="margin-left:20;margin-right:20">
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
if(request.getAttribute("contentlist")!=null)
{

contentlist=(ArrayList)request.getAttribute("contentlist");
//out.println(homelist);
}


%>
<table width="100%" height="450" border="0">
     <TR>
        <TD vAlign=top align=left colSpan=2 height=165><%@include file="../header.jsp"%></TD>
        </TR>
<tr><td colspan="2" height="25%"><%@include file="/menu.jsp"%></td></tr>  
  
<tr><td width="20%" height="75%" valign="top"><%@include file="/leftmenu.jsp"%></td>
<td width="80%" height="75%" valign="top" >
<table border="0" width="100%"  cellspacing="0" cellpadding="0" >


   <%for(int i=0;i<contentlist.size();i++){%>
   <tr>
   <%                   
       imgbe=(img_bean)contentlist.get(i);
     page_id=new Integer(imgbe.getPage_id()).toString();
     
if(!imgbe.getFilename().equals(""))
{
  fn1=request.getContextPath()+"/Detail_Imge/"+imgbe.getFilename();  
%>

 <td width="100%" height="46" align="left" valign="top">
<table>
<tr><td>
<img src="<%=fn1%>" width="100" height="80" />
</td>                         
<%}%>


</tr></table>
 </td>
   
   
   </tr>
                  
                  
                  
                  
<tr><td><b><%=imgbe.getHead()%></b></tr>

<tr><td><%=imgbe.getDesc()%></td></tr>






                  
                  
   
                      <%}%>
                      </table>
                      

</td></tr>

</table>
</body>


</html>