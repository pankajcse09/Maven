
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

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
    
    <head>
        
         <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/aless/magiczoom.css" />
            <script language="javascript" src="<%=request.getContextPath()%>/aless/magiczoom.js">
                
</script>
    <script language="javascript">
             
          function get_peritem(itemid,scid)
           {
          document.f1.method="post";
          document.f1.action='<%=request.getContextPath()%>/get_peritem.do?method=get_perItem&itemid='+itemid+"&scid="+scid;
          document.f1.submit();
          }
          </script>
</head>
<body style="margin-left:20;margin-right:20">
<%ArrayList contentlist=new ArrayList();
img_bean imgbe=new img_bean();
item_bean itembe=new item_bean();
ArrayList detail=new ArrayList();
img_bean picbe=new img_bean();
String fn1="";
String fn2="";
String fn3="";
String fn4="";
ArrayList qualitylist=new ArrayList();
String  page_id="";
 function_int_foodmart fd=new function_int_foodmart();
if(request.getAttribute("detail")!=null)
{

detail=(ArrayList)request.getAttribute("detail");
//out.println(homelist);
}

%>
<table width="100%" height="550"    border="0" cellpadding="0" cellspacing="0"  BACKGROUND="./fashion_img/bg.jpg">
   

<tr><td width="13%" valign="top">
    <table cellpadding="0" cellspacing="0">
<tr><td>
<%@include file="/view_content/Browse_item.jsp"%>
</td></tr>
  
    
    </table>
</td>
<td width="47%" valign="top" >
<table valign="top" width="100%" cellpadding="0" cellspacing="0" >

<tr><td height="50"></td></tr>
   <%for(int i=0;i<detail.size();i++)

                      {

   %>
    <tr>
   <%
      itembe=(item_bean)detail.get(i);
         if(!itembe.getFilename().equals(""))
{
         
//  fn1=request.getContextPath()+"/Imge/"+itembe.getFilename();
  
    fn1="http://www.theminorsofrichmond.com/jewelry/"+itembe.getFilename();
%>
<td width="100%" height="400" align="center" valign="top">
<table width="100%" align="center" ><tr>
<td align="center"><img src="<%=fn1%>"/></td>

</tr></table>
</td>
<%}%>
</tr>
<tr><td style="padding-left:60px"align="center" bgcolor="" width="50">
<table width="50%">
<tr><td><font style="color:black"><b>Market Price Rs...<%=itembe.getMarketprice()%></b></font></td></tr>
<tr><td><font style="color:black"><b>Offer Price Rs...<%=itembe.getPrice()%></b></font></td></tr>

<tr><td><font style="color:black"><%=itembe.getDetail()%></font></td></tr>

</table></td></tr>
<%}%>

</table>
</td>

<td width="40%" valign="top" style="padding-top:60px">
<table border="1" align="center" valign="middle" bgcolor="" width="100%" style="font-weight:bold;border-collapse:collapse;border:1px solid black">
     <tr><td height="55"></td></tr>
      <tr><td width="20%">Product ID:</td><td><%=itembe.getProd_id()%></td></tr>
   
    <tr><td width="20%">Product Name:</td><td><%=itembe.getBrand()%></td></tr>
    
    <tr><td width="20%">Measure:</td><td><%=itembe.getSize()%></td></tr>
    <tr><td width="20%">size:</td><td><%=itembe.getUnit()%></td></tr>
    <tr><td width="20%">color Desc.:</td><td><%=itembe.getDetail()%></td></tr>
    <tr><td width="20%">Market Price.:</td><td><%=itembe.getMarketprice()%></td></tr>
      <tr><td width="20%">Discount Offer</td><td><%=itembe.getDiscount()%>&nbsp;<%=itembe.getDiscountdetail()%></td></tr>
   <tr><td width="20%">Our Price</td><td><%=itembe.getPrice()%></td></tr>
  
    <form name="f1">
    <tr><td height="100" colspan="2" align="center">

<img src="<%=request.getContextPath()%>/images/add.gif" onclick="get_peritem('<%=itembe.getItem_id()%>',<%=itembe.getSubcat_id()%>)"></td></tr>
    </form>
    
    
</table>
    
</td>

</tr>

</table>
</body>


</html>