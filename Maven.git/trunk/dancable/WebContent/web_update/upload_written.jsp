<%-- 
    Document   : upload_written
    Created on : Apr 8, 2014, 2:00:01 PM
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
        <title>Upload Written</title>
    </head>

    <script language="javascript">
         function delete_item()
    {
     alert('arjun');
   document.formb.method="POST";
document.formb.action="<%=request.getContextPath()%>/deletes_item.do?method=Delete_item";
document.formb.submit();
} 

function getCat()
{
document.f1.method="POST";
document.f1.action="<%=request.getContextPath()%>/uploadWritten.do?method=main_categories";
document.f1.submit();   
}
function getSubCat()
{
document.f1.method="POST";
document.f1.action="<%=request.getContextPath()%>/getSubCat.do?method=subcategories";
document.f1.submit();   
}
</script>
      <script language="javascript">
      var thedata;
var newwin;
var thenumber;
function edit(textarea) 
{

if (textarea =='brand')
{

thedata = document.exampleform.brand.value
thenumber = 0

}
 if (textarea =='size')
{ 
thedata = document.exampleform.size.value
thenumber = 1
}

if (textarea =="price")
{ 
thedata = document.exampleform.price.value
thenumber = 2
}
if (textarea =="prod_id")
{ 
thedata = document.exampleform.prod_id.value
thenumber = 3
}

newwin = window.open("n.jsp","","width=300,height=200,resizable")
}  
        
    


 

<!--function add_item()
    {
alert("arjun");
   document.forms[0].method="POST"
  document.forms[0].enctype="multipart/form-data"
document.forms[0].action="Add_attrr.do";
document.forms[0].submit();


function edit_item(itemid)
    {
   alert(itemid);
   document.forms[0].method="POST";
document.forms[0].action="Edit_item.do?method=Edit_item&item_id="+itemid;
document.forms[0].submit();
} 


function il(list)
    {
   
    
   parent.fk.location.href="itemlist.do?list="+list;
} 
} -->
       </script>
       
       <script language="javascript">
           function roundNumber(myNum,numOfDec){ 
var decimal = 1; 
for(i=1; i<=numOfDec;i++){ 
decimal = decimal *10;
}
var myFormattedNum = (Math.round(myNum * decimal)/decimal).toFixed(numOfDec); 
return myFormattedNum; 
}
           function get_discount()
           
           {
           var mes="";
           var disrs="";
           var finalrs;
           var c;
             mes=document.forms[1].discountdetail.value;
          
           if(mes=="dollar")
           {    
          
        mes=parseFloat(document.forms[1].marketprice.value)-parseFloat(document.forms[1].discount.value); 
          finalrs=roundNumber(mes,2);
          document.forms[1].price.value=finalrs;
           }
           
        if(mes=="percent")        
           {           
       c=(parseFloat(document.forms[1].discount.value)/100)*parseFloat(document.forms[1].marketprice.value);
         disrs=parseFloat(document.forms[1].marketprice.value)-parseFloat(c)
           finalrs=roundNumber(disrs,2);
           document.forms[1].price.value=finalrs;
           }
           
           }
      function setScId()
           {
               //alert(document.forms[0].sub_cat.value);
               document.forms[0].method="POST";
               document.forms[0].action="uploadWritten.do?method=sub_categories";
               document.forms[0].submit();
           }     
function upload_i(a)
{
    var w=screen.width-100;
    var h=screen.height-100;
    window.open(a,"_blank",'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=yes, resizable=yes, width='+w+' ,height='+h+' ,left=50');
}  
function upload_s(a)
{
    var w=screen.width-100;
    var h=screen.height-100;
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
<form name="f1"> 
 <table class="it" border="0"><TR>
<TD valign="top">Root Category: <select name="mc" onchange="getCat()">
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
Main Categories: <select name="cat" onchange="getCat()">
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
Sub-Categories: <select name="sub_cat" onblur="setScId()">
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
     </TR>
     <tr><td colspan="3"><hr></td></tr></table>
<input type="hidden" name="mnc" value="<%=mc%>">
       <input type="hidden" name="catnm" value="<%=catname%>">
</form>
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
<td>Image</td><td>Upload Written File</td>
      
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

<td><img src="./music_image/<%=pro_view.getFilename()%>" width="80" height="40">
<br>
<!--<a href="./item_more_image.do?galid=<%//=pro_view.getItem_id()%>&scid=<%//=subcatid%>" class="ts"><font size="1px">Add More Images</font></a>
<a href="./itemimage_view.do?galid=<%//=pro_view.getItem_id()%>&scid=<%//=subcatid%>" class="ts"><font size="1px">View More Images</font></a>-->
</td>

<td><%=pro_view.getTitle()%>
<br>
<a href="#" onclick="upload_s('./item_up_wrtn.do?galid=<%=pro_view.getItem_id()%>&scid=<%=subcatid%>&tp=sm')" class="ts"><font size="1px">Add Samples</font></a>
<a href="./itemsamples_viewWrtn.do?method=viewWrtnSamples&galid=<%=pro_view.getItem_id()%>&scid=<%=subcatid%>" class="ts"><font size="1px">View Samples</font></a>
<br>
<a href="#" class="ts" onclick="upload_i('./item_up_wrtn.do?galid=<%=pro_view.getItem_id()%>&scid=<%=subcatid%>&tp=nsm')"><font size="1px">Upload music album</font></a>
<a href="./itemWrtnUpMusic_view.do?method=viewDwMusic&galid=<%=pro_view.getItem_id()%>&scid=<%=subcatid%>" class="ts"><font size="1px">View music album</font></a>
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

