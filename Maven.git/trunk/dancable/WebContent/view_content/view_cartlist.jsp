
<%@page import="Main_category.CountryBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@page import ="Main_category.item_bean"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.*"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="ActionClass.JavaBean1"%>

<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danceables</title>
       <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/change.css" />
        <script language="javascript" src="<%=request.getContextPath()%>/css/menu.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/css_js/resolution.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/css_js/jquery.min.js"></script>
         <script type="text/javascript">
            function load(){
            field = document.getElementById('cat');
        if (field) {
     if (field.value !=='shipping request') document.getElementById('shipping').style.display='none';
   field.onchange=function() {
    if (this.value === 'shipping request') {
                    document.getElementById('shipping').style.display = '';
                  }
                  };
               }
            }       
            </script>

         <script>
            
//<![CDATA[ 
$(function(){
$('#kind2').on('click', function(e){
    $('#dwn_shp').html('');
    var c=$('#shipping').html();
    if(c===''){
    $('#shipping').html($('#shipping_space').html());
    $('#shipping_space').html();
}
});
$('#kind1').on('click', function(e){
var c=$('#shipping').html();
    if(c!==''){
    var sh=document.f1.elements["ship_method"].value;
    $('#shipping_space').html($('#shipping').html());
    $('#shipping').html('');
    $('#dwn_shp').append("<input type='hidden' name='ship_method' value='"+sh+"'>");
    }
});
});//]]>  

        </script>
 <script language=javascript>
        function validate(){ 
 
    if(document.f1.bill_f_name.value===""){    
    alert("Enter First Name");
    document.f1.bill_f_name.focus();
    return false;        
    } 
    
     if(document.f1.bill_l_name.value===""){    
    alert("Enter Last Name");
    document.f1.bill_l_name.focus();
    return false;        
    } 
    if(document.f1.bill_street.value===""){    
    alert("Enter Street");
    document.f1.bill_street.focus();
    return false;        
    } 
    
    if(document.f1.bill_city.value===""){    
    alert("Enter City");
    document.f1.bill_city.focus();
    return false;        
    } 
    if(document.f1.bill_state.value===""){    
    alert("Enter State");
    document.f1.bill_state.focus();
    return false;        
    } 
    if(document.f1.bill_zip.value===""){    
    alert("Enter Zip");
    document.f1.bill_zip.focus();
    return false;        
    } 
    if(document.f1.bill_country.value===""){    
    alert("Enter Country");
    document.f1.bill_country.focus();
    return false;        
    }
    if(document.f1.bill_phone.value===""){    
    alert("Enter Phone");
    document.f1.bill_phone.focus();
    return false;        
    } 
    if(document.f1.bill_email.value===""){    
    alert("Enter Your email id to get your order details.");
    document.f1.bill_email.focus();
    return false;        
    }
    /*
    if(document.f1.ship_f_name.value==""){    
    alert("Enter First Name");
    document.f1.ship_f_name.focus();
    return false;        
    } 
    
     if(document.f1.ship_l_name.value==""){    
    alert("Enter Last Name");
    document.f1.ship_l_name.focus();
    return false;        
    } 
    if(document.f1.ship_street.value==""){    
    alert("Enter Street");
    document.f1.ship_street.focus();
    return false;        
    } 
    
    if(document.f1.ship_city.value==""){    
    alert("Enter City");
    document.f1.ship_city.focus();
    return false;        
    } 
    if(document.f1.ship_state.value==""){    
    alert("Enter State");
    document.f1.ship_state.focus();
    return false;        
    } 
    if(document.f1.ship_zip.value==""){    
    alert("Enter Zip");
    document.f1.ship_zip.focus();
    return false;        
    } 
    if(document.f1.ship_country.value==""){    
    alert("Enter Country");
    document.f1.ship_country.focus();
    return false;        
    }
    if(document.f1.ship_phone.value==""){    
    alert("Enter Phone");
    document.f1.ship_phone.focus();
    return false;        
    } 
     
    */
     
    gotoplaceorder();
    }
    </script>

        <script language=javascript>
function validatechk(chk){
  if(chk.checked == 1){
   
document.f1.elements["ship_f_name"].value=document.f1.elements["bill_f_name"].value;
document.f1.elements["ship_l_name"].value=document.f1.elements["bill_l_name"].value;
document.getElementById("ship_street").value=document.getElementById("bill_street").value;
document.f1.elements["ship_city"].value=document.f1.elements["bill_city"].value;
document.f1.elements["ship_state"].value=document.f1.elements["bill_state"].value;
document.f1.elements["ship_country"].value=document.f1.elements["bill_country"].value;
document.f1.elements["ship_zip"].value=document.f1.elements["bill_zip"].value;
document.f1.elements["ship_phone"].value=document.f1.elements["bill_phone"].value;
document.f1.elements["ship_a_phone"].value=document.f1.elements["bill_a_phone"].value;
//document.f1.elements["bill_method"].value=document.f1.elements["ship_method"].value;

//document.getElementById("bill_country").value=document.getElementById("ship_country").value;
//document.f1.elements["bill_country"].value=document.f1.elements["ship_country"].value;

//var e = document.f1.elements["ship_country"];
    //var strSel =e.options[e.selectedIndex].value;   
//var f = document.f1.elements["bill_country"];
//f.options[f.selectedIndex].value=strSel;
//f.options[f.selectedIndex].text=strSel;
  }
  else{
      document.f1.elements["ship_f_name"].value="";
document.f1.elements["ship_l_name"].value="";
document.getElementById("ship_street").value="";
document.f1.elements["ship_city"].value="";
document.f1.elements["ship_state"].value="";
document.f1.elements["ship_country"].value="";
document.f1.elements["ship_zip"].value="";
document.f1.elements["ship_phone"].value="";
document.f1.elements["ship_a_phone"].value="";
  }
}

function checkCountry(a,b){
    //if(document.getElementById("domastic").checked==false){
    var vmc=document.f1.elements["vmccaa"].value;
    if(vmc==='1'||vmc==='2'){
    if(vmc===a){
    var s=document.getElementById("shp_state").innerHTML;
    var s1=document.getElementById("shp_state1").innerHTML;
    var c=document.getElementById("shp_country").innerHTML;
    var c1=document.getElementById("shp_country1").innerHTML;
    var shpmthd=document.getElementById("shp_mthd").innerHTML;
    var shpmthd1=document.getElementById("shp_mthd1").innerHTML;
   document.getElementById("shp_state").innerHTML=s1;
   document.getElementById("shp_state1").innerHTML=s;
   document.getElementById("shp_country").innerHTML=c1;
   document.getElementById("shp_country1").innerHTML=c;
   document.getElementById("shp_mthd").innerHTML=shpmthd1;
   document.getElementById("shp_mthd1").innerHTML=shpmthd;
   
   var s=document.getElementById("bill_state").innerHTML;
    var s1=document.getElementById("bill_state1").innerHTML;
    var c=document.getElementById("bill_country").innerHTML;
    var c1=document.getElementById("bill_country1").innerHTML;
   document.getElementById("bill_state").innerHTML=s1;
   document.getElementById("bill_state1").innerHTML=s;
   document.getElementById("bill_country").innerHTML=c1;
   document.getElementById("bill_country1").innerHTML=c;
   
        //var cs=document.getElementById("bill_st").style.cssText;
        //$('#bill_st').toggle();
        //$('#shp_st').toggle();
        //$('#bill_state').toggle();
       // $('#shp_state').toggle();
       document.f1.elements["vmccaa"].value=b;
       }
       }else{
        alert("Please do not change parameter");
       }
    //}
}
</script>

  <script language="javascript">
       function calcSubTotal(a,b){ 
      var objj='';
       var obj='';
       var quta='';
        var qt='0';
   var qs;
   var qams='0.0';
   var qam='0.0';
   var qt;
       document.f1.elements["subtot"+a].value=parseFloat(document.f1.elements["price"+a].value)
*parseFloat(document.f1.elements["quantity"+a].value);       
       obj=document.getElementById("subtotal"+a);
       obj.innerHTML=parseFloat(document.f1.elements["price"+a].value)*parseFloat(document.f1.elements
["quantity"+a].value);   
   
   
      for(i=0; i<b;i++)
{ 

    qs=document.f1.elements["quantity"+i].value;
    qt=parseInt(qt)+parseInt(qs);
  
 qams=parseFloat(qams)+parseFloat(document.getElementById("subtotal"+i).innerHTML);
 

}
 document.f1.elements["qutas"].value=qt;
document.f1.elements["qamas"].value=qams;  


       }
      </script> 
        <script language="javascript">
            function gotocontinue()
            {            
       document.forms[0].method="POST";
       document.forms[0].action="<%=request.getContextPath()%>/fm_home.do?name=home";
       
       document.forms[0].submit();
            }
            
            
           
              function gotoplaceorder()
            {
            
       document.forms[0].method="POST";
       document.forms[0].action="<%=request.getContextPath()%>/gotoReview.do?method=gotoReview";
       document.forms[0].submit();

            }
            
   function saveUpdate()
            {            
       document.forms[0].method="POST";
       document.forms[0].action="<%=request.getContextPath()%>/SaveUpdates.do?method=saveUpdateAct";
       document.forms[0].submit();
            }
      
         function delete_shop_item(itemid)
            {            
       document.forms[0].method="POST";
       document.forms[0].action="<%=request.getContextPath()%>/delete_shop_item.do?id="+itemid+"&method=removeShopitem";
       
       document.forms[0].submit();
            }
  </script>     
    </head>
      <body onload="load()">
       
     <%
        CountryBean cb=null;
        ArrayList shplist=new ArrayList();
       if( request.getAttribute("shplist")!=null )
            {
              shplist=(ArrayList)request.getAttribute("shplist");    
             }
                       JavaBean1 jb=new JavaBean1();
                if((JavaBean1)request.getAttribute("addressdetail")!=null)
                 {
                 jb=(JavaBean1)request.getAttribute("addressdetail");
              
                 }
                 
                ArrayList itemlist=new ArrayList();
                     if( session.getAttribute("cart_list")!=null )
                     {
                     itemlist=(ArrayList)session.getAttribute("cart_list");    
                     session.setAttribute("cart_list",itemlist);
                   
                     }else{
                   itemlist=(ArrayList)request.getAttribute("cart_list");    
                     }
     ArrayList stlist=new ArrayList();        
     function_int_foodmart fd=new function_int_foodmart();
     stlist=fd.retCountryStates();
     
     String unit="";
  String status="";
   String brand="";
    String prod_id="";
   double price=0.0;
   String size="";    
   int subcat_id=0;
   String filename="";  
     String detail="";
    double marketprice=0.0;
      double discount=0.0;
      double promo_value=0.0;
      double promo=0.0;
       String discountdetail="";
      String image="";
   int itemid=0;
          item_bean itembe=new item_bean();
         
    String username="";
  username= (String)session.getAttribute("loginid");
    //out.println("Welcome-"+username);
double total=0.0;
int totalquantity=0;
NumberFormat formatter = new DecimalFormat("#0.00");
    //out.println(sellist);
    if(request.getAttribute("promo_value")!=null){
        promo_value=Double.parseDouble((String)request.getAttribute("promo_value"));
    }
if( session.getAttribute("promo_val")!=null )
     {
        promo=Double.parseDouble((String)session.getAttribute("promo_val"));    
      }
String promo_cd="";
if( session.getAttribute("promo_c")!=null )
     {
        promo_cd=(String)session.getAttribute("promo_c");    
      }
String shpStatus="";
if(request.getAttribute("shpStatus")!=null){
    shpStatus=(String)request.getAttribute("shpStatus");
}   
     %>
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
               <tr> <td>   
        <table  align="center" width="100%"><tr><td>
      <div id="body_1" align="center">
             <div class="cart" align="center">
<form name="f1">
<% if(itemlist.size()!=0)
    { %>  
         
     <table width="100%" align="center" style="padding-left:10px">         
         <%if(username.equalsIgnoreCase("guest")){%>
         <tr><td colspan="3" align="left"><font style="color:black">Welcome-<%=username%></font></td></tr>
        <%}%>
               
     <tr>
         <td valign="top" width="60%">
             <table border="0" cellspacing="0" cellpadding="0" align="center" valign="top"><tr>
<td valign="top">              
 <table  border="1" BORDERCOLOR="GREY" bgcolor="white" cellspacing="0" cellpadding="0">     
       
<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px">Remove</font></td>
<td width="90" align="center"><FONT STYLE="font-weight:bold;color:black;font-size:12px">Image</font></td>

<td><FONT STYLE="font-weight:bold;color:black;font-size:12px">Product ID</font></td>
<td><FONT STYLE="font-weight:bold;color:black;font-size:12px">Price</font></td>
<td><FONT STYLE="font-weight:bold;color:black;font-size:12px">Quantity</font></td>
<td><FONT STYLE="font-weight:bold;color:black;font-size:12px">Subtotal</font></td>
</tr>
     <%
        int ab=itemlist.size();
    for(int t=0;t<ab;t++)
    {
  itembe=(item_bean)itemlist.get(t);
  
 price=itembe.getPrice();
 filename=itembe.getFilename();   
 
    
     %>




     <tr><input type="hidden" name="kinds" id="cat" value="<%=session.getAttribute("cat")%>">
         <%if(username!=null&&!username.equals("guest")&&!username.equals("")){%>
<td><span id="a" onclick="delete_shop_item('<%=itembe.getCart_id()%>');">
        <img src="./images/delete.png" style="padding-left: 10px"/></span></td>
        <% }
 else{%>
    <td><span id="a" onclick="delete_shop_item('<%=itembe.getItem_id()%>');">
        <img src="./images/delete.png" style="padding-left: 10px"/></span></td>
        <%}%>
<td width="50" align="center">
<img  border="0" src="./music_image/<%=filename%>" width="50" height="70"></td>

  
    <td><FONT STYLE="font-weight:bold;color:black;font-size:12px"><%=itembe.getProd_id()%></font></td>
      
    
      
       <td width="10%" STYLE="font-weight:normal;color:black;font-size:12px"><%=formatter.format(price)%><input type="hidden" name="price<%=t%>" value="<%=price%>"></td>
       
           <td><input type="text" name="quantity<%=t%>" value="<%=itembe.getQuantity()%>" onkeyup="calcSubTotal('<%=t%>','<%=ab%>')" style="width: 80px"></td>
            <td STYLE="font-weight:normal;color:black;font-size:12px"><span id="subtotal<%=t%>"><%=formatter.format(itembe.getSubtotal())%></span>
           
           </td>
            
            <input type="hidden" name="itemid<%=t%>" value="<%=itembe.getItem_id()%>">
            <input type="hidden" name="cartid<%=t%>" value="<%=itembe.getCart_id()%>" >        
                    <input type="hidden" name="filena<%=t%>" value="<%=filename%>" >              
                    <input type="hidden" name="subtot<%=t%>" value="<%=formatter.format(itembe.getSubtotal())%>">              
   <input type="hidden" name="brand<%=t%>" value="<%=itembe.getBrand()%>" > 
     
     </tr>      
   <%
    total=total+itembe.getSubtotal();
    if(t==itemlist.size()-1){
    total=total-promo;}
    totalquantity=totalquantity+itembe.getQuantity();
   
    }%>
    <input type="hidden" name="tot_quantity" value="<%=totalquantity%>">           
    <input type="hidden" name="tot_amount" value="<%=formatter.format(total)%>">              

<!--<tr><td colspan="4" align="center" STYLE="font-weight:normal;color:black;font-size:12px"><b>Promotional Code:</b></td>
            <% if(promo_cd.equals("")){%>
             <td STYLE="font-weight:normal;color:black;font-size:12px">NA</td>
             <%} else{%>
            <td STYLE="font-weight:normal;color:black;font-size:12px"><%=promo_cd%></td>
            <%}%>
            <td colspan="0" align="center" STYLE="font-weight:normal;color:black;font-size:12px"><b>Amount:</b></td>
            <td colspan="0" STYLE="font-weight:normal;color:black;font-size:12px"><%=promo%></td></tr>  -->
    
<tr><td colspan="3" align="center" STYLE="font-weight:normal;color:black;font-size:12px"><b>Total Quantity:<b></td>
<td STYLE="font-weight:normal;color:black;font-size:12px"><input type="text" name="qutas" value="<%=totalquantity%>" readonly style="width: 30px">
</b></td>
<td colspan="0" align="center" STYLE="font-weight:normal;color:black;font-size:12px"><b>Total Amount</b></td>
<td colspan="0" STYLE="font-weight:normal;color:black;font-size:12px"><input type="text" name="qamas" value="<%=formatter.format(total)%>" style="width: 40px"></td></tr>

      
     
    </table>
</td></tr>
&nbsp;&nbsp;&nbsp;&nbsp;
<tr><td style="padding-top: 10px">
        <table align="center" width="70%" border="0" cellspacing="0" cellpadding="0">          
<tr><td colspan="2" align="right"><input type="button" value="Place Order"  onclick="return validate();"  
style="width:150;font-size:12px"></td>  
<td align="center"><input type="button" value="Continue Shopping" onclick="gotocontinue()" style="width:150;font-size:12px"></td>
<td width="20%" colspan="2" align="left"><input type="button" value="Save Update" onclick="saveUpdate()" style="width:120;font-size:12px"></td></tr>
      
     
 
  </table></td></tr>
             </table></td>
<input type="hidden" name="vmccaa" value="2">
     <td valign="top" STYLE="font-weight:normal;color:black;font-size:12px" width="20%">
         <table>
          <tr><td COLSPAN="4"><font color="black">BILLING ADDRESS( <font color="red">*</font> these fields are mandatory)</font></td></tr>
            <tr><td COLSPAN="4"><input type="radio" name="shpwhr" id="domastic" value="domastic" checked onclick="checkCountry('1','2')">Domestic</input>&nbsp;&nbsp;
                     <input type="radio" name="shpwhr" id="international" value="international" onclick="checkCountry('2','1')">International</input>
                 </td></tr>
          
             <tr><td><font color="red">*</font><font color="black">First Name:</font></td>
                 <td><input type="text" name="bill_f_name" value="<%=jb.getName()%>" style="width: 200px"></td></tr>
             <tr><td><font color="red">*</font><font color="black">Last Name:</font></td>
                 <td><input type="text" name="bill_l_name" value="<%=jb.getLast_name()%>" style="width: 200px"></td></tr>
              <tr><td valign="middle"><font color="red">*</font><font color="black">street address</font></td>
                  <td colspan="3"><textarea id="bill_street" rows="3" cols="26" value="<%=jb.getHomeaddress()%>" name="bill_street"><%=jb.getHomeaddress()%></textarea></td></tr>
              <tr><td><font color="red">*</font><font color="black">City (no abbreviations):</font></td>
                  <td><input type="text" name="bill_city" value="<%=jb.getCity()%>" style="width: 200px"></td></tr>
              <tr id="bill_state"><td><font color="red">*</font><font color="black">State/Province:</font></td>
                  <td><select name="bill_state" style="width: 205px">
                          <%if(username!=null&&!username.equals("guest")&&!username.equals("")){%>
                          <option value="<%=jb.getState()%>"><%=jb.getState()%></option>
                          <%}
                          else{%>
                          <option value="">Select State</option>
                          <%}%>
                          <%if(stlist.size()!=0){
               for(int i=0;i<stlist.size();i++)
               {
                   cb=(CountryBean)stlist.get(i);
                   %>
                    <option value="<%=cb.getCode()%>"><%=cb.getState()%></option>
                   <%
               }
           }%>
                      </select></td></tr>
         <tr id="bill_st" style="display:none;"><td><font color="red">*</font><font color="black">State:</font></td>
             <td><input type="text" name="bill_st" id="bill_st" value="" style="width: 200px"></td></tr>
           <tr><td><font color="red">*</font><font color="black">zip/postal code:</font></td>
               <td><input type="text" name="bill_zip" value="<%=jb.getPincode()%>" style="width: 200px"></td></tr>
           <tr id="bill_country"><td><font color="red">*</font><font color="black">Country:</font></td>
               <td><select name="bill_country" style="width: 205px">
                       <%if(username!=null&&!username.equals("guest")&&!username.equals("")){%>
                          <option value="<%=jb.getCountry()%>"><%=jb.getCountry()%></option>
                          <%} else{%>  
            <option value="">Select Country</option>
           <%}%>
           <option value="United States">United States</option>
           <option value="Canada">Canada</option>
           
       </select></td></tr> 
           <tr><td><font color="red">*</font><font color="black">Daytime phone # :</font></td>
           <td><input type="text" name="bill_phone" value="<%=jb.getMobileno()%>" style="width: 200px"></td></tr>
          <% if(username.equals("guest"))
{%>
           <tr><td><font color="red">*</font><font color="black">Email Id :</font></td>
               <td><input type="text" name="bill_email" value="" style="width: 200px"></td></tr>
               <%}else{%>
               <tr><td><font color="red">*</font><font color="black">Email Id :</font></td>
               <td><input type="text" name="bill_email" value="<%=username%>" style="width: 200px"></td></tr>
               <%}%>
           

                 </table></td> 
           
<td valign="top" id="shipping" STYLE="font-weight:normal;color:black;font-size:12px" width="20%"><table>
         <tr><td COLSPAN="4"><font color="black">SHIPMENT INFORMATION( <font color="red">*</font> these fields are mandatory)</font></td></tr>
        <tr><td colspan="3"><table><tr><td>
        <input type="checkbox" name="sames" onClick="return validatechk(sames)">use my billing Address</td></tr></table></td></tr>
             <tr><td><font color="red">*</font><font color="black">First Name:</font></td>
                 <td><input type="text" name="ship_f_name" value="" style="width: 200px"></td></tr>
             <tr><td><font color="red">*</font><font color="black">Last Name:</font></td>
                 <td><input type="text" name="ship_l_name" value="" style="width: 200px"></td></tr>
              <tr><td valign="middle"><font color="red">*</font><font color="black">street address:</font></td>
                  <td colspan="3"><textarea id="ship_street" rows="3" cols="26" value="" name="ship_street"></textarea></td></tr>
              <tr><td><font color="red">*</font><font color="black">City (no abbreviations):</font></td>
                  <td><input type="text" name="ship_city" value="" style="width: 200px"></td></tr>
              <tr id="shp_state"><td><font color="red">*</font><font color="black">State/Province:</font></td>
                  <td><select name="ship_state" style="width: 205px">
                          <option value="">Select State</option>
                          <%if(stlist.size()!=0){
               for(int i=0;i<stlist.size();i++)
               {
                   cb=(CountryBean)stlist.get(i);
                   %>
                    <option value="<%=cb.getCode()%>"><%=cb.getState()%></option>
                   <%
               }
           }%>
                      </select></td></tr>
         <tr id="shp_st" style="display:none;"><td><font color="red">*</font><font color="black">State:</font></td>
             <td><input type="text" name="shp_st" id="shp_st" value="" style="width: 200px"></td></tr>
            <tr><td><font color="red">*</font><font color="black">zip/postal code:</font></td>
                <td><input type="text" name="ship_zip" value="" style="width: 200px"></td></tr>
            <tr id="shp_country"><td><font color="red">*</font><font color="black">Country:</font></td>
                <td><select style="width: 205px" name="ship_country">
              <option value="">Select Country</option>
           <option value="United States">United States</option>
           <option value="Canada">Canada</option>
           
           
       </select></td></tr>
            <tr><td><font color="red">*</font><font color="black">Daytime phone # :</font></td>
                <td><input type="text" name="ship_phone" value="" style="width: 200px"></td></tr>
            <!--<tr><td><font color="black">Alternate phone # :</font></td>
            <td><input type="text" name="ship_a_phone" value="" style="width: 224px"></td></tr>-->
           <tr id="shp_mthd"><td><font color="red">*</font><font color="black">Choose a shipping method:</font></td>
               <td><select  name="ship_method" style="width: 205px;">
                       <%if(shpStatus.equals("no")){%>
                            <option value="sortship:Free Ground Shipping">Free Ground Shipping ($0.00)</option>
                       <%}else{%>
                        <option value="flatzone:USPS Media Mail">USPS Media Mail ($5.00)</option>
                       <%}%>
                   </select>
</td></tr>

        
         </table>
             </td>
                   <div id="dwn_shp" style="display:none"></div>
     </tr>
     
 
 
<tr><td>
  

   

  </td></tr>
    </table>     
        
            <%}
           else{
            %>
            <table width="904" align="center" style="padding-left:150px">
         <tr><td colspan="3"><font style="color:black">Welcome-<%=username%>
         <%if(username!=null&&!username.equals("guest")&&!username.equals("")){%>
         <a href="<%=request.getContextPath()%>/customer_logout.do?method=customer_logout"><font style="color:black;font-weight:bold;font-size:15"><b>Logout</b></font></a>
<%}%>
         </font></td></tr>
            <tr>
         <td valign="top" width="904" height="400" align="center">
             <table  cellspacing="0" cellpadding="0" align="center" width="904"><tr><td>
 <!--<table  border="1" BORDERCOLOR="GREY" bgcolor="white" cellspacing="0" cellpadding="0" align="center" width="904">     
       
<tr><td><FONT STYLE="font-weight:bold;color:black;font-size:12px">Remove</font></td>
<td width="90" align="center"><FONT STYLE="font-weight:bold;color:black;font-size:12px">Image</font></td>
<td><FONT STYLE="font-weight:bold;color:black;font-size:12px">Size</font></td>
<td><FONT STYLE="font-weight:bold;color:black;font-size:12px">Product ID</font></td>
<td><FONT STYLE="font-weight:bold;color:black;font-size:12px">Price</font></td>
<td><FONT STYLE="font-weight:bold;color:black;font-size:12px">Quantity</font></td>
<td><FONT STYLE="font-weight:bold;color:black;font-size:12px">Subtotal</font></td>
</tr>
     <tr><td colspan="7" align="center">There are currently no items in your shopping cart.</td></tr>
 </table>-->
 <center>There are currently no items in your shopping cart.</center></td></tr>
             <tr><td align="right" style="padding-right: 360px; padding-top: 10px"><input type="button" value="Shop now our products" onclick="gotocontinue()" style="width:150;font-size:12px"></td></tr>
             </table>
                     </td></tr>
         
            </table>
         <%}%>
         </form>
             </div>
     </div></td></tr></table>
         <div style="display:none">
             <tr id="shp_state1" style="display:none">
                 <td><font color="red">*</font><font color="black">State/Province:</font></td>
                 <td><!--<input type="text" name="ship_state" value="" style="width: 200px"></input>-->
                <input type="text" name="ship_state" id="bill_st" value="" style="width: 200px">
                 </td>
             </tr>
             <tr id="shp_country1" style="display:none">
                 <td><font color="red">*</font><font color="black">Country:</font></td>
                 <td><select style="width: 205px" name="ship_country">
              <option value="">Select Country</option>
           <%if(shplist.size()!=0){
               for(int i=0;i<shplist.size();i++)
               {
                   cb=(CountryBean)shplist.get(i);
                   %>
                    <option value="<%=cb.getCode()%>"><%=cb.getCountry()%></option>
                   <%
               }
           }%>
            </select></td>
             </tr>
             <tr id="bill_state1" style="display:none">
                 <td><font color="red">*</font><font color="black">State/Province:</font></td>
                 <td><!--<input type="text" name="bill_state" value="<%=jb.getState()%>" style="width: 200px"></input>-->
                   <input type="text" name="bill_state" id="shp_st" value="" style="width: 200px">
                   </td>
             </tr>
             <tr id="bill_country1" style="display:none">
                 <td><font color="red">*</font><font color="black">Country:</font></td>
                 <td><select name="bill_country" style="width: 205px">
                       <%if(username!=null&&!username.equals("guest")&&!username.equals("")){%>
                          <option value="<%=jb.getCountry()%>"><%=jb.getCountry()%></option>
                          <%} else{%>  
            <option value="">Select Country</option>
           <%}%>
           <%
           if(shplist.size()!=0){
               for(int i=0;i<shplist.size();i++)
               {
                   cb=(CountryBean)shplist.get(i);
                   %>
                    <option value="<%=cb.getCode()%>"><%=cb.getCountry()%></option>
                   <%
               }
           }%>
       </select></td>
             </tr>
             <tr  id="shp_mthd1" style="display:none">
             <td><font color="red">*</font><font color="black">Choose a shipping method:</font></td>
             <td><input type="text" name="ship_method" value="Authorized" style="width: 200px" readonly></td>
             </tr>
             <tr style="display:none"><td id="shipping_space"></td></tr>
         </div>
    </td>
               </tr>
   <tr>
          <td><table align="center"><tr>
                            <td width="660" height="" valign="top" style="padding-top: 20px">
                                <table class="tbl" border="0">
                                    <tr valign="top">
                                        <td colspan="2" class="fnt2">
                                            <a href="" style="text-decoration: none"><font color="#3EAAAA">Click here to read our</font></a> <br>
                                            Rave Review
                                        </td>
                                        <td class="fnt2" style="padding-left: 20px">
                                            <a href=""><img src="<%=request.getContextPath()%>/images/homepage/Order form icon.png" border="0" width="150"></a><br>
                                            Download our printable order <br> form to order by mail or fax.
                                        </td>
                                    </tr>
                                    <tr height="60">
                                        <td valign="top" colspan="2">
                                            <table>
                                                <tr><td class="fnt2">Our Distribution</td></tr>
                                                <tr><td>
                                            <img src="<%=request.getContextPath()%>/images/homepage/logo 3.png" border="0" width="170" height="35">
                                                    </td>
                                                    <td style="padding-left: 30px"><img src="<%=request.getContextPath()%>/images/homepage/logo 2.png" border="0" width="150" height="40"></td>
                                                </tr>
                                            </table></td>
                                        <td style="padding-left: 20px; padding-top: 20px"><img src="<%=request.getContextPath()%>/images/homepage/Logo 1.png" border="0" width="150"></td>
                                    </tr>
                                    <tr valign="top"><td colspan="2" style="padding-bottom: 10px">
                                            <a class="a" style="text-decoration: none" href="http://www.danceclassmusic.com/bio-stevenmitchell.html"><font style="font-size: 14px">http://www.danceclassmusic.com/bio-stevenmitchell.html</font></a></td>
                                        <td style="padding-left: 20px;padding-bottom: 10px">
                                            <a class="a" style="text-decoration: none" href="http://www.cdbaby.com/Artist/StevenMitchell"><font style="font-size: 14px">http://www.cdbaby.com/Artist/StevenMitchell</font></a></td>
                                    </tr>
                                </table>
                            </td>
                            <td class="pad1" width="320" valign="top">
                                <table class="tbl1" border="0">
                                    <tr><td><a class="b" href="">Shipping Notes</a></td></tr>
                                    <tr><td><a class="b" href="">Terms & Conditions</a></td></tr>
                                    <tr><td><a class="b" href="">Privacy policy</a></td></tr>
                                    <tr><td><a class="b" href="">Sitemap</a></td></tr>
                                    <tr><td><a class="b" href="">Contact Us</a></td></tr>
                                    <tr><td><img src="<%=request.getContextPath()%>/images/homepage/Facebook Icon.png" width="170" height="40"></td></tr>
                                </table>
                            </td>
                                    </tr></table></td>
                        </tr>  
    
  </table>   
      </td>
               </tr>
   
</table>
    
    </body>
</html>

