 
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
      <STYLE type="text/css">BODY {
	background-repeat:no-repeat;
        BACKGROUND-COLOR: #181c1c; TEXT-ALIGN: center
}
</STYLE>
 <script type="text/javascript" language="javascript"> 
   

 var newwindow = ''
function popitup(url) {
if (newwindow.location && !newwindow.closed) {
    newwindow.location.href = url;
    newwindow.focus(); }
else {

    newwindow=window.open(url,'htmlname','width=404,height=316,resizable=1');
 
    newWindow.document.writeln("<html>");
    newWindow.document.writeln("<body style='margin: 0 0 0 0;'>");
    newWindow.document.writeln("<a href='javascript:window.close();'>");
    newWindow.document.writeln("<img src='" + url + 
       "' alt='Click to close' id='bigImage'/>");
    newWindow.document.writeln("</a>");
    newWindow.document.writeln("</body></html>");
    newWindow.document.close();

  
    newwindow.resizeTo(400,500);
newwindow.moveTo(800,200);
  
}
    
}

function tidy() {
if (newwindow.location && !newwindow.closed) {
   newwindow.close(); }
}
   


 

</script> 
</head>
   <body  onUnload="tidy()">
   
       
<table width="100%" height="550" border="0">
   
  
<tr><td width="20%"  valign="top"><%@include file="/view_content/Collection_item.jsp"%></td>
<td width="80%"  valign="top">
<table width="100%">


 <tr><td valign="top"  BACKGROUND="./fashion_img/bg.jpg">
      
    
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
 <tr>
<td align=left valign="top" width="100%"  height="78">
     <table valign="top" cellpadding="0" cellspacing="0" border="0" width="100%">
<tr><td valign="top" align="left">
      <%@include file="./Top_menu.jsp"%></td></tr>
       </table>
       
       </td></tr>
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
     
         <td><A HREF="javascript:popitup('http://www.aksfashionnews.com/data_image/<%=itembe.getFilename()%>')"><IMG SRC="http://www.aksfashionnews.com/data_image/<%=itembe.getFilename()%>" width="180" height="200"></a><br>
     
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
      <tr><td ><font style="font-size:12"><b>Displaying Records:&nbsp;<%=ft%></b></font>
    <%if(!pre.equals("")){%>
    <a href="subcatdet_col.do?method=Collection_ItemDetail&pr=<%=pre%>"><font size='1' color='black'>Previous</font></a>
    <%}
    if(!nxt.equals("")){%>
   <a href="subcatdet_col.do?method=Collection_ItemDetail&pr=<%=nxt%>"><font size='1' color='black'>Next</font></a>
   <%}%>
   </td></tr>
       
 </table>
  </td></tr>
  
  
  </table></td></tr>
  </table>
 </body>
 </html>