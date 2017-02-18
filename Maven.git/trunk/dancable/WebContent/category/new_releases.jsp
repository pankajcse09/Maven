<%-- 
    Document   : new_releases
    Created on : Aug 26, 2013, 1:34:56 PM
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
        <title>New Releases</title>
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
document.f1.action="<%=request.getContextPath()%>/getCat.do?method=categories";
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
               document.forms[1].subcat_id.value=document.forms[0].sub_cat.value;
               document.forms[0].method="POST";
               document.forms[0].action="getScItem.do?method=subcategories";
               document.forms[0].submit();
           }     
function upload_i(a)
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
<style>
    input[type=text],select
      {
         height: 30px;
     }
        </style>  
   <table border="1" style="border-collapse:collapse">
       
 <form name="exampleform" action="Add_attribute.do?method=addAttribute" enctype="multipart/form-data" method="post"> 
  <tr><td colspan="2" align="left" width="100%"><input type="submit"  value="save"></td>
      <td colspan="13"><span style="color: #840B2A;padding-left: 200px;">  (Enter the Product Id of the related items in the related items fields.
              Use comma ( , ) to separate more than one product id. )</span></td>
  </tr>
<tr style="color: #3C4937;font-weight: bold">
    <td>Edit</td><td>status</td><td>name</td><td>Measure</td><td>size</td>
    <td>market price</td><td>discount</td><td>discount detail</td>
    <td>price</td><td>detail</td>
    <td>prod_id</td>
    <td>Related Items</td>
<td>upload image</td><td>upload audio</td>
<td>create_time</td><td>modified_time</td>
       
   </tr>
      
     
      <tr>
 <td></td> 
<td><select name="status">
                <option value="">status</option>
                 <option value="online">online</option>
                  <option value="offline">offline</option>
            </select></td>

    <td><input type="text" name="brand" size="8"  onclick="edit('brand')"></td>
 <td><input type="text" name="size" size="3" onclick="edit('size')"></td>
 <td><select name="unit">
             <option value="NA">NA</option>
                 <option value="S">S</option>
                  <option value="M">M</option>
                    <option value="L">L</option>
                  <option value="XL">XL</option>
                  <option value="XXL">XXL</option>
                  <option value="XXXL">XXXL</option>
                
                    
                
            </select></td>   
 
  <td><input type="text" name="marketprice" class="ts" size="3" value="0"></td>   
   <td><input type="text" name="discount"class="ts" size="3" value="0"></td>  
 <td><select name="discountdetail" onblur="get_discount()">
                  <option value="">select</option>
                 <option value="dollar">$</option>
                  <option value="percent">%</option>
                   
            </select></td>   
            <td><input type="text" name="price" size="3"></td>
   <td><textarea name="detail" class="ts" cols="28" rows="3"></textarea></td>   
  <td><input type="text" name="prod_id" size="3" onclick="edit('prod_id')"></td>
    <td><input type="text" name="related_items" size="10"></td>
   <td ><input type="file" name="uploads[0]"  size="5" /></td>
   <td ><!--<input type="file" name="samples[0]"  size="5" />-->
       <textarea style="visibility: hidden" disabled></textarea>
   </td>
   <td><%=time%></td><td></td>
      
      </tr>
  <%//="kapil: "+subcatid%>  
       <input type="hidden" name="subcat_id" value="<%=subcatid%>">
       <input type="hidden" name="item_id" value="<%=item_id%>">
       <input type="hidden" name="mainCat" value="<%=mc%>">
       <input type="hidden" name="catName" value="<%=catname%>">
       <input type="hidden" name="subCatName" value="<%=subcatname%>">
  </form>
   <%
   if(!subcatid.equals("")){
  //out.println("saini: "+subcatid);
%>
  <form name="formb">
  
  
             <%// view from table

                 ArrayList view_item=(ArrayList)col.newRlitem_desc((Integer.parseInt(subcatid)));
                 if(view_item!=null)
                 {
                   
                 //out.println(view_item);
            
                 for(int v=0;v<view_item.size();v++)
                 {
             
                  pro_view=(mc_prop)view_item.get(v);
                  item_id=pro_view.getItem_id();
           
                 
                     %>
                     
                     <tr>  
<td><!--<input type="checkbox" name="abc<%=v%>" value="<%=item_id%>">-->
    <a href="Edit_item.do?method=Edit_item&item_id=<%=item_id%>">Edit</a>/&nbsp<a href="deletes_item.do?method=Delete_item&did=<%=item_id%>">Delete</a>
    </td> 
    <td><%=pro_view.getStatus()%></td>
 <td><%=pro_view.getBrand()%></td>
 <td><%=pro_view.getSize()%></td> 
 <td><%=pro_view.getUnit()%></td>  
 <td><%=pro_view.getMarketprice()%></td>   
  <td><%=pro_view.getDiscount()%></td>  
 <td><%=pro_view.getDiscountdetail()%></td>   
  <td><%=pro_view.getPrice()%></td>
   
      <td><%=pro_view.getDetail()%></td>  
<td><%=pro_view.getProd_id()%></td>
<td><%=pro_view.getRelated_items()%></td>
<td><img src="./music_image/<%=pro_view.getFilename()%>" width="80" height="40">
<br>
<a href="./item_more_image.do?galid=<%=pro_view.getItem_id()%>&scid=<%=subcatid%>" class="ts"><font size="1px">Add More Images</font></a>
<a href="./itemimage_view.do?galid=<%=pro_view.getItem_id()%>&scid=<%=subcatid%>" class="ts"><font size="1px">View More Images</font></a>
</td>

<td><%=pro_view.getTitle()%>
<br>
<a href="./item_more_samples.do?galid=<%=pro_view.getItem_id()%>&scid=<%=subcatid%>" class="ts"><font size="1px">Add More Samples</font></a>
<a href="./itemsamples_view.do?method=viewSamples&galid=<%=pro_view.getItem_id()%>&scid=<%=subcatid%>" class="ts"><font size="1px">View More Samples</font></a>
<br>
<a href="#" class="ts" onclick="upload_i('./item_up_music.do?galid=<%=pro_view.getItem_id()%>&scid=<%=subcatid%>')"><font size="1px">Upload music album</font></a>
<a href="./itemUpMusic_view.do?method=viewDwMusic&galid=<%=pro_view.getItem_id()%>&scid=<%=subcatid%>" class="ts"><font size="1px">View music album</font></a>
</td>


 <td><%=pro_view.getT()%></td><td><%=pro_view.getMt()%></td>
 
                    
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
