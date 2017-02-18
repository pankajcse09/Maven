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
        <title>T Salon Management</title>
        <script type="text/javascript" src="jquery.min.js"></script>
     
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
document.f1.action="<%=request.getContextPath()%>/getCateg.do?method=categories";
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
               //document.forms[1].subcat_id.value=document.forms[0].sub_cat.value;
               document.forms[0].method="POST";
               document.forms[0].action="getSubcItem.do?method=subcategories";
               document.forms[0].submit();
           } 
           
        function applyToAll()
        {
            var i=document.getElementById("totalCount").value;
            for(var j=0;j<i;j++)
            {
                document.formb.elements["promo_code_"+j].value=document.getElementById('code').innerHTML;
            }
        }
        
  function validatePromo(j,k,i)
  {
      var a=j;
      var b=i;
      if(document.formb.elements["promo_code_"+j].value=="")
      {
          alert("Enter the promotional code for product id "+k);
          document.formb.elements["promo_code_"+j].focus();
          return false;
      }
      if(document.formb.elements["promo_discount_"+j].value=="")
      {
          alert("Enter the promotional discount for product id "+k);
          document.formb.elements["promo_discount_"+j].focus();
          return false;
      }
      savePromo(a,b);
  }
        
         function savePromo(j,i){ 
     var en=document.formb.elements["promo_code_"+j].value;
     var cn=document.formb.elements["promo_discount_"+j].value;
     var fta=document.formb.elements["discount_in_"+j].value;
     document.getElementById("replace_"+j).innerHTML="<font style='color:red;'>Please wait...</font>";
     document.getElementById("replace1_"+j).innerHTML="<font style='color:red;'>Please wait...</font>";
     document.getElementById("replace2_"+j).innerHTML="<font style='color:red;'>Please wait...</font>";
     var url="<%=request.getContextPath()%>/promo/savePromoCodeForProd.jsp";
url=url+"?en="+en+"&cn="+cn+"&fta="+fta+"&it="+i;
$.get( url, function( response ) {
    var data=response; // server response
    var strar=data.split(":");
    //alert(response);
    if(strar.length>1){
        document.getElementById("replace_"+j).innerHTML=strar[1];
         document.getElementById("replace1_"+j).innerHTML=strar[2];
         document.getElementById("replace2_"+j).innerHTML=strar[3];
        }
});
//location.reload();
}   

function genNewCode()
        {
            var url="<%=request.getContextPath()%>/promo/genPromoCode.jsp";

$.get( url, function( response ) {
    document.getElementById("replacing").innerHTML=response; // server response
});
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
     
     String subcatname="";
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
   if(request.getParameter("sub_cat")!=null&&request.getParameter("sub_cat")!="")
  {
     subcatid=request.getParameter("sub_cat"); 
     subcatname=subcatid.substring(subcatid.indexOf("/")+1, subcatid.length());
   subcatid=subcatid.substring(0,subcatid.indexOf("/"));
  }
   //out.println("kapil: "+subcatname+"<br>");
   //out.println("Saini: "+subcatid);
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
     </TR></table>
<input type="hidden" name="mnc" value="<%=mc%>">
       <input type="hidden" name="catnm" value="<%=catname%>">
</form>
<%
   if(!subcatid.equals("")){
  //out.println("saini: "+subcatid);
       Random randomGenerator = new Random();
    StringBuffer sb=new StringBuffer("1000");
      int randomInt = randomGenerator.nextInt(1000);
      sb=sb.append(Integer.toString(randomInt));
      randomInt = randomGenerator.nextInt(1000);
      sb=sb.append(Integer.toString(randomInt));
      randomInt = randomGenerator.nextInt(1000);
      sb=sb.append(Integer.toString(randomInt));
      randomInt = randomGenerator.nextInt(1000);
      sb=sb.append(Integer.toString(randomInt));
%>
   <table class="it" border="1" style="border-collapse: collapse" align="center">
       
 <form name="exampleform" action="Add_attribute.do?method=addAttribute" enctype="multipart/form-data" method="post"> 
     <tr style="line-height: 35px"><td colspan="2" align="left"><font style="color: green"><%=mc+"/"+catname+"/"+subcatname%></font></td>
         <td colspan="5">
             <div id="replacing">
             <b>New Promotional Code: 
                 <span onclick="applyToAll()" style="cursor: pointer;color:red" id="code"><%=sb%></span>
             </b></div><input type="button" value="generate new code" onclick="genNewCode()"></td>
             
         <td align="right"><!--<input type="button"  value="save">--></td></tr>
     <tr><td><b>change promotional</b></td>
    <td> <b>Product name</b></td><td><b>prod_id</b></td><td><b>price</b></td><td><b>Promotional Code</b></td>
    <td><b>Promotional discount</b></td><td><b>Discount detail</b></td><td><b>Save</b></td>


       
   </tr>
      
     
      
  <%//="kapil: "+subcatid%>  
       <input type="hidden" name="subcat_id" value="<%=subcatid%>">
       <input type="hidden" name="item_id" value="<%=item_id%>">
       <input type="hidden" name="mainCat" value="<%=mc%>">
       <input type="hidden" name="catName" value="<%=catname%>">
    
  </form>
   
  <form name="formb">
  
  
             <%// view from table

                 ArrayList view_item=(ArrayList)col.item_desc((Integer.parseInt(subcatid)));
                 if(view_item!=null)
                 {
                   
                 //out.println(view_item);
            
                 for(int v=0;v<view_item.size();v++)
                 {
             
                  pro_view=(mc_prop)view_item.get(v);
                  item_id=pro_view.getItem_id();
           
                 
                     %>
                     
                     <tr style="line-height: 30px;">  
<td>
 <!--<a href="Edit_item.do?method=Edit_item&item_id=<%=item_id%>">Edit</a>/<a href="deletes_item.do?method=Delete_item&did=<%=item_id%>">Delete</a>-->
   </td> 

 <td><%=pro_view.getBrand()%></td>
  
 <td><%=pro_view.getProd_id()%></td>
  <td><%=pro_view.getPrice()%></td>
  <td> <div id="replace_<%=v%>">
  <%if(pro_view.getPromo()!=null&&!pro_view.getPromo().equals("")){%>
        <%=pro_view.getPromo()%>
      <%}else{%>
  <input type="text" name="promo_code_<%=v%>" value="" style="height: 30px">
  <%}%>
  </div></td>
  
  <td align="center">
      <div id="replace1_<%=v%>">
  <%if(pro_view.getPromo_discount()!=0){%>
  
          <%=pro_view.getPromo_discount()%>
     
  <%}else{%>
  <input type="text" name="promo_discount_<%=v%>" size="10" style="height: 30px">
    <%}%>
     </div>
  </td>
  
  <td>
      <div id="replace2_<%=v%>">
  <%if(pro_view.getPromo_discountdetail()!=null&&!pro_view.getPromo_discountdetail().equals("")){%> 
  
          <%=pro_view.getPromo_discountdetail()%>
      
<%}else{%>
          <select name="discount_in_<%=v%>">
                  <option value="percent">%</option>
                  <option value="dollar">$</option>
      </select>
     <%}%>             
                  </div>
  </td>
      <td align="center">
          <div id="replace3_<%=v%>">
            <%if(pro_view.getPromo()!=null&&!pro_view.getPromo().equals("")){%>
          saved
          <%}else{%>
          <input type="button" value="save" onclick="return validatePromo('<%=v%>','<%=pro_view.getProd_id()%>','<%=pro_view.getItem_id()%>')">
          <%}%>
          </div>
      </td>

  
 </tr> 
                     
                     
               <%}%>
               <input type="hidden" id="totalCount" name="tt" value="<%=view_item.size()%>">        
                 
              <%}%>
              
              
             
         
    
 
              
              
    
          
       
        <% if(request.getParameter("subcat_id")!=null)
             {%>
            
           
            
            
             
             <%}%>

  
    
<%
       //mc=request.getParameter("mnc");
       //catname=request.getParameter("catnm");
       %>
   &nbsp;&nbsp;&nbsp;  
     
    
    
      
    </table>
   <%}%>
    </body>
</html>
