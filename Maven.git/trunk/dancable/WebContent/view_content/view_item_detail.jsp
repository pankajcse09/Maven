 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page language="java"%>
<%@page import ="Main_category.item_bean"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.*"%>
<%@page import="java.sql.Timestamp"%>

<html>
   <head>
       <title>AKSFASHIONNEWS</title>
      <STYLE type="text/css">BODY {
	background-repeat:no-repeat;
        BACKGROUND-COLOR: #000000; TEXT-ALIGN: center
}
</STYLE>
</head>
    <body>
   
       
<table width="100%" height="550" border="0">
  <tr>
<td align=left valign="top" width="100%"  height="78" colspan="2">
     <table valign="top" cellpadding="0" cellspacing="0" border="0" width="100%">
<tr><td valign="top" align="left">
      <%@include file="./Top_menu.jsp"%></td></tr>
       </table>
       
       </td></tr>  
  
<tr><td width="20%"  valign="top"><%@include file="/view_content/Browse_item.jsp"%></td>
<td width="80%"  valign="top">
<table width="100%">


 <tr><td valign="top">
      
    
     <%
    
         ArrayList ar=new ArrayList();
         HashMap hm=new HashMap();
  HashSet hs=new HashSet();
  String ft="";
  String pre="";
  String nxt="";
  String stindex="";
  int k=0;  
  if(request.getAttribute("hmap")!=null){
  hm=(HashMap)request.getAttribute("hmap");  
  ar=(ArrayList)hm.get("arr");  
  ft=(String)hm.get("fromto");
  pre=(String)hm.get("previous");
  nxt=(String)hm.get("next");  
  stindex=hm.get("stindex").toString(); 
  }
  try{
   k=Integer.parseInt(stindex);   
  }
  catch(NumberFormatException ne){}
 
   
    
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
       String discountdetail="";
      String image="";
   int itemid=0;
     mc_prop  itembe=new mc_prop();
      ArrayList itemlist=new ArrayList();
 
    
     %>
     <table width="100%" border="0" cellspacing="0" cellpadding="2">
 
     <%
      int count1=0;
       for (int c=0; c<ar.size(); c++)
       {    
     %>
     <tr>
     <% int count=0;
         for (int m=count1; m<ar.size(); m++)
       {
            
         itembe=(mc_prop)ar.get(m);
     %>
     
         <td><IMG SRC="http://www.aksfashionnews.com/data_image/<%=itembe.getFilename()%>" width="180" height="200"><br>
<font style="font-size:18;color:black;font-weight:bold">Rs &nbsp;<%=itembe.getPrice()%></font><br>
    <font style="font-size:18;color:red;font-weight:bold">ID &nbsp;
<a href="detail_item.do?id=<%=itembe.getItem_id()%>"><%=itembe.getProd_id()%></a></font><br>

         
         </td>
             
        <% 
        count++;
          count1++;
         if(count>3){break;}
      
         }
         
     %>
     </tr>
     <%
        
       }
     
    %>    
      <tr><td ><font style="font-size:12;color:#ffffff"><b>Displaying Records:&nbsp;<%=ft%></b></font>
    <%if(!pre.equals("")){%>
    <a href="subcatdet.do?method=view_ItemDetail&pr=<%=pre%>"><font size='1' color='black'>Previous</font></a>
    <%}
    if(!nxt.equals("")){%>
   <a href="subcatdet.do?method=view_ItemDetail&pr=<%=nxt%>"><font size='1' color='black'>Next</font></a>
   <%}%>
   </td></tr>
       
 </table>
  </td></tr>
  
  
  </table></td></tr>
  </table>
 </body>
 </html>