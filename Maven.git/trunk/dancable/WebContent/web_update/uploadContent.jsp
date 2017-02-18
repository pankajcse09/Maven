<%-- 
    Document   : uploadContent
    Created on : May 19, 2014, 6:18:07 PM
    Author     : kapil
--%>

<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@page import ="mc_bean.mc_prop"%>
<%@page import="mc_operat.Mc_funct"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.*"%>
<%@page import="java.sql.Timestamp"%>

<%response.setHeader("Cache-Control","no-cache");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload Content</title>
    </head>

    <script language="javascript">
 
function getCat()
{
document.f1.method="POST";
document.f1.action="<%=request.getContextPath()%>/addContent.do?method=categories";
document.f1.submit();   
}
function getSubCat()
{
document.f1.method="POST";
document.f1.action="<%=request.getContextPath()%>/addContent.do?method=subcategories";
document.f1.submit();   
}
</script>

       
       <script language="javascript">
          
      function setScId()
           {
               //alert(document.forms[0].sub_cat.value);
               //document.forms[1].subcat_id.value=document.forms[0].sub_cat.value;
               document.forms[0].method="POST";
               document.forms[0].action="addContent.do?method=subcategories";
               document.forms[0].submit();
           }     
function upload_s(a)
{
    var w=screen.width-600;
    var h=screen.height-400;
    window.open(a,"_blank",'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=yes, resizable=yes, width='+w+' ,height='+h+' ,left=50');
}  
           </script>
       
    <body bgcolor="#dcdcdc">
   
   
     <%
         String mc="";
         String cat="";
         String catname="";
         String subcatid="";
     String subcat="";
     
     if(request.getAttribute("mc")!=null)
     {
         mc=(String)request.getAttribute("mc");
     }
     
     if(request.getAttribute("cat")!=null)
     {
         cat=(String)request.getAttribute("cat");
     }
     
     if(request.getAttribute("catname")!=null)
     {
         catname=(String)request.getAttribute("catname");
     }
     
     mc_prop  mcp= new mc_prop();
     mc_prop  mcpp= new mc_prop();
   ArrayList mclist = new ArrayList();
   ArrayList catlist = new ArrayList();
   ArrayList subcatlist = new ArrayList();
   if(request.getAttribute("mclist")!=null)
   {
       mclist=(ArrayList)request.getAttribute("mclist");
   }
   if(request.getAttribute("catlist")!=null)
   {
       catlist=(ArrayList)request.getAttribute("catlist");
   }
   if(request.getAttribute("subcatlist")!=null)
   {
       subcatlist=(ArrayList)request.getAttribute("subcatlist");
   }
   String subcatname="";
   if(request.getParameter("subCatName")!=null)
  {
    subcatname=request.getParameter("subCatName");
  }
   if(request.getParameter("sub_cat")!=null&&request.getParameter("sub_cat")!="")
  {
     subcatid=request.getParameter("sub_cat"); 
     subcatname=subcatid.substring(subcatid.indexOf("/")+1, subcatid.length());
   subcatid=subcatid.substring(0,subcatid.indexOf("/"));
  }
   else if(request.getParameter("subcat_id")!=null)
  {
    subcatid=request.getParameter("subcat_id");
  }
    %>
             
    <table class="it" border="0" width="100%"><TR><TD valign="top"><%@ include file="/Registration/top_design_1.jsp"%></TD></TR></table>
   
   <%
     Mc_funct col=new Mc_funct();
   mc_prop  pro_view= new mc_prop();
   ArrayList col_list = new ArrayList();
  col_list=(ArrayList)col.sel_col();
   int item_id=0;
  //out.println(col_list);
         Timestamp time=new Timestamp(System.currentTimeMillis());
       
   %>
   <table class="it" border="0" width="100%"><TR><TD valign="top" align="center">Upload Music Content</TD></TR></table>
<form name="f1"> 
 <table class="it" border="0"><TR>
<TD valign="top">Main Category: <select name="mc" onchange="getCat()">
<%if(mc.equals(""))
{%>
<option value="">Select</option>
<%}
else{%>
<option value="<%=mc%>"><%=mc%></option>
<%}%>
<%if(mclist.size()!=0)
{
 for(int i=0;i<mclist.size();i++)
  {
    mcp=(mc_prop)mclist.get(i);
    if(!mc.equals(mcp.getMc())){
    %>
      <option value="<%=mcp.getMc()%>"><%=mcp.getMc()%></option>
 <%}}}%>
</select></TD>

<td>
Categories: <select name="cat" onchange="getCat()">
    <%if(cat.equals(""))
{%>
<option value="">Select</option>
<%}
else{%>
<option value="<%=cat%>"><%=catname%></option>
<%}%>   
<%if(catlist.size()!=0)
{
 for(int i=0;i<catlist.size();i++)
  {
    mcpp=(mc_prop)catlist.get(i);
    if(!catname.equals(mcpp.getCat())){
    %>
      <option value="<%=mcpp.getCat()+"/"+mcpp.getC_id()%>"><%=mcpp.getCat()%></option>
 <%}}}%>
</select>   
</td>
<td>
Sub-Categories: <select name="sub_cat" onchange="setScId()">
    <option value="">Select</option>
   <%if(subcatlist.size()!=0)
{
 for(int i=0;i<subcatlist.size();i++)
  {
    mcp=(mc_prop)subcatlist.get(i);
    %>
      <option value="<%=mcp.getSubcat_id()+"/"+mcp.getSub_cat()%>"><%=mcp.getSub_cat()%></option>
 <%}}%>   
</select>   
</td>
     </TR></table>
<input type="hidden" name="mnc" value="<%=mc%>">
       <input type="hidden" name="catnm" value="<%=catname%>">
</form>
   <table class="it" border="0" width="100%"><TR><TD valign="top" align="center"><hr></TD></TR></table>
<style>
    input[type=text],select
      {
         height: 30px;
     }
        </style>  
   <table class="it" border="1" style="border-collapse:collapse">
    <tr style="color: #3C4937;font-weight: bold"><td>Status</td>
      <td>Name</td><td>Market Price</td><td>Discount</td><td>Discount detail</td><td>Price</td><td>Detail</td>

<td>Prod_id</td>
<td>Image</td><td>Upload Content File</td>
      
   </tr> 
       

   <%
   if(!subcatid.equals("")){
  //out.println("saini: "+subcatid);
%>
  <form name="formb">
  
  
             <%// view from table

                 ArrayList view_item=(ArrayList)col.item_desc_All((Integer.parseInt(subcatid)));
                 if(view_item!=null)
                 {
                   
                 //out.println(view_item);
            
                 for(int v=0;v<view_item.size();v++)
                 {
             
                  pro_view=(mc_prop)view_item.get(v);
                  item_id=pro_view.getItem_id();
           
                 
                     %>
                     
                     <tr>  
<td><%=pro_view.getStatus()%></td>
 <td><%=pro_view.getBrand()%></td>
 <td><%=pro_view.getMarketprice()%></td>   
  <td><%=pro_view.getDiscount()%></td>  
 <td><%=pro_view.getDiscountdetail()%></td>   
  <td><%=pro_view.getPrice()%></td>
   
      <td><%=pro_view.getDetail()%></td>  
<td><%=pro_view.getProd_id()%></td>

<td><img src="./music_image/<%=pro_view.getFilename()%>" width="80" height="40"></td>

<td>
    <%if(!pro_view.getCover_content().equals("")){%>
    <span title='<%=pro_view.getCover_content()%>'>
        <a href='<%=request.getContextPath()%>/viewfile?fl=<%=pro_view.getCover_content()%>' target="_blank">
            <img src='<%=request.getContextPath()%>/images/Pdf_ic.png' width='20'></a>
    </span>
        <%=pro_view.getCover_content()%>
<br>
<%}%>
<%if(pro_view.getCover_content().equals("")){%>
<a href="#" onclick="upload_s('./contentfile_up.do?galid=<%=pro_view.getItem_id()%>&scid=<%=subcatid%>&prod_id=<%=pro_view.getProd_id()%>')" class="ts">
    <font size="1px">Add Content</font></a>
    <%}%>
<a href="./view_contetnfile.do?method=viewcontetnfile&galid=<%=pro_view.getItem_id()%>&scid=<%=subcatid%>" class="ts"><font size="1px">View Content</font></a>
</td>

 
                    
                     </tr> 
                     
                     
               <%  }
                 
                 }

              %>
              
             
         
    
 
              
              
    
          
       
        <% if(request.getParameter("subcat_id")!=null)
             {%>
            
           
            
            
             
             <%}%>
            
  
   
  
   
    
  
       
     <!--  <input type="button" value="Update"  onclick="edit_item('<%=item_id%>');"> 
<input type="button" value="Delete"  onclick="delete_item();"> 
-->
 
  
  
   <%//=subcatid%>
    
<%
       //mc=request.getParameter("mnc");
       //catname=request.getParameter("catnm");
       %>
   &nbsp;&nbsp;&nbsp;<font style="color: green"><%=mc+"/"+catname+"/"+subcatname%></font>  
     
    <%}%>
    
      
    </table>
    </body>
</html>

