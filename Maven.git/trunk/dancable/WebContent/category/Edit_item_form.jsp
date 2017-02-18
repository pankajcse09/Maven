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
<%@page import=" java.util.Enumeration"%>
<%@page import ="java.util.HashMap"%>
 <%@page import=" java.util.Set"%>
 <%@page import=" java.util.Iterator"%>
 <%@page import ="java.util.Map"%>
 <%@page import ="java.sql.Timestamp"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>cms1</title>
        
    </head>
      <script language="javascript">
           function roundNumber(myNum,numOfDec){ 
var decimal = 1 
for(i=1; i<=numOfDec;i++){ 
decimal = decimal *10;
}
var myFormattedNum = (Math.round(myNum * decimal)/decimal).toFixed(numOfDec) 
return myFormattedNum; 
}
           function get_discount()
           
           {
           var mes="";
           var disrs="";
           var finalrs;
           var c;
             mes=document.forms[0].discountdetail.value;
          
           if(mes=="rs")
           {    
       
        mes=parseFloat(document.forms[0].marketprice.value)-parseFloat(document.forms[0].discount.value); 
          finalrs=roundNumber(mes,2);
          document.forms[0].price.value=finalrs;
           }
           
        if(mes=="percent")        
           {           
       c=(parseFloat(document.forms[0].discount.value)/100)*parseFloat(document.forms[0].marketprice.value);
         disrs=parseFloat(document.forms[0].marketprice.value)-parseFloat(c)
           finalrs=roundNumber(disrs,2);
           document.forms[0].price.value=finalrs;
           }
           
           }
           
           
           </script>
    <script language="javascript">
        function edit(type,itemid){
    mywindow=window.open("./update.do?type="+type+"&id="+itemid,"Supplier");
            mywindow.moveTo(200,100);
          
}
    
        </script>
        <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
    <body bgcolor="#dcdcdc">
<style>
                input[type=text],select
                {
                   height: 30px;
                }
        </style>
<table><tr>
                <td><% if(request.getAttribute("msg")!=null){%>
                <%=request.getAttribute("msg")%>
                <%}%>
                </td>
            </tr></table>
<table width='100%'><tr>
    <td width='100%' align='center'><span style="color: #840B2A;padding-left:0px;">  (Enter the Product Id of the related items in the related items fields.
              Use comma ( , ) to separate more than one product id. )</span>
                </td>
            </tr></table>
    <table border="1">
<form name="" method="post" action="save_update_item.do?method=save_update_item">
<tr>
      
       <td>status</td><td>name</td><td>size</td><td>unit</td><td>market price</td><td>discount</td><td>discount detail</td><td>price</td><td>detail</td>

<td>prod_id</td>
<td>Related Items</td>
<td>upload image</td>
<td>create_time</td><td>modified_time</td>
       
   </tr>
   
   <%ArrayList itemlist=new ArrayList();
   Mc_funct mc=new Mc_funct();
        mc_prop item=new mc_prop();
        String filename="";
         Timestamp time=new Timestamp(System.currentTimeMillis());
%>
    <%if(request.getAttribute("item")!=null){

item=(mc_prop)request.getAttribute("item");
filename=request.getContextPath()+"/music_image/"+item.getFilename();
%>
   
  <tr><td><select name="status"><option value="<%=item.getStatus()%>"><%=item.getStatus()%></option>
   <%if(item.getStatus().equals("ofline")){%>
  <option value="online">online</option>
  <%}%>
  <%if(item.getStatus().equals("online")){%>
   <option value="ofline">ofline</option>
   <%}%>
  </select>
  </td><td><input type="text" name="brand" value="<%=item.getBrand()%>"></td><td><input type="text" name="size" value="<%=item.getSize()%>" size="3"></td>

 <td><select name="unit">
              <option value="<%=item.getUnit()%>"><%=item.getUnit()%></option>
               
                  
                  <%if(item.getUnit().equals("kg")){%>
 

                  <option value="meter">meter</option>
                    <option value="litre">litre</option>
                
                    <option value="single">single</option>
                  <%}%><%if(item.getUnit().equals("meter")){%>
 

                  <option value="kg">kg</option>
                    <option value="litre">litre</option>
                
                    <option value="single">single</option>
                  <%}%><%if(item.getUnit().equals("litre")){%>
 

                  <option value="meter">meter</option>
                    <option value="kg">kg</option>
                
                    <option value="single">single</option>
                  <%}%><%if(item.getUnit().equals("single")){%>
 

                  <option value="meter">meter</option>
                    <option value="litre">litre</option>
                
                    <option value="kg">kg</option>
                  <%}%>
                  
            </select></td>   
  
  <td><input type="text" name="marketprice" value="<%=item.getMarketprice()%>" size="3"></td>
  

<td><input type="text" name="discount" value="<%=item.getDiscount()%>" size="3"></td>

<td><select name="discountdetail" onchange="get_discount()" >
<%if(item.getDiscountdetail().equals("percent")){%>
 <option value="<%=item.getDiscountdetail()%>">%</option>

<%}else{%>
 <option value="<%=item.getDiscountdetail()%>"><%=item.getDiscountdetail()%></option>
 <%}%>
 </option>

<%if(item.getDiscountdetail().equals("rs")){%>
  <option value="percent">%</option>
  <%}%>
  <%if(item.getDiscountdetail().equals("percent")){%>
   <option value="rs">rs</option>
   <%}%>
   
   </select></td>
  
  <td><input type="text" name="price" value="<%=item.getPrice()%>" size="3"></td>
<td><textarea name="detail" class="ts" rows="3"><%=item.getDetail()%></textarea></td>

<td><input type="text" name="prodid" value="<%=item.getProd_id()%>" size="3"></td>
<td><input type="text" name="related_items" value="<%=item.getRelated_items()%>"></td>
  
  <td><img src="<%=filename%>" width="80" height="40"></td><td><%=item.getT()%></td><td><%=time%></td>
  <td><input type="hidden" name="itemid" value="<%=item.getItem_id()%>"></td>

  </tr>
  <tr><td colspan="8" align="center"><input type="submit" value="Update Changes"></td></tr>
    <%}%>
    </form>
     </table>
    </body>
</html>
