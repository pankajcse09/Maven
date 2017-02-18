


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
<%@page import ="mc_bean.mc_prop"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>T Salon</title>
   
      <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/pro_drop_1/laycss.css" />
         <link rel="stylesheet" type="text/css" href="prop_drop/pro_drop.css" />
            
        
            <script language="javascript" src="kk/resolution.js">
                
</script>
<script type="text/javascript" language="javascript"> 
   

 var newwindow = ''
function popitup(url) {
window.open(url,'jewelry','width=433,height=450,menubar=no,scrollbars=yes,resizable=1');
    
}




 

</script> 

    </head>
      

    <body>
   <%
    
         ArrayList ar=new ArrayList();
         HashMap hm=new HashMap();
  HashSet hs=new HashSet();
  String ft="";
  String pre="";
  String nxt="";
  String stindex="";
  int k=0;  
  
  int id=0;
   if(request.getAttribute("id")!=null){
  try {
 id=Integer.parseInt((String)request.getAttribute("id"));
  } catch (NumberFormatException ex) {
         ex.printStackTrace();
      }
 }
   String pa="";
    if(request.getAttribute("pa")!=null){
   pa=(String)request.getAttribute("pa");
    }
  if(request.getAttribute("hmap")!=null){
  hm=(HashMap)request.getAttribute("hmap");  
  //out.println("arjun"+hm);
  ar=(ArrayList)hm.get("arr");  
  ft=(String)hm.get("fromto");
  pre=(String)hm.get("previous");
  nxt=(String)hm.get("next");  
  //out.println(nxt);
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
      String nav="";
 
    
     %>
 <div id="container" align="center">
    <div id="cont_1">
 <%@include file="/head.jsp"%>
    </div>
     <div style="clear: both" ></div>
   <div bgcolor="#ffffff">
       <table id="tbl" width="100%" align="center">
            <tr><td align="center">
                <%@include file="/Top_menu.jsp"%>
            </td></tr>
        </table> 
    </div>
        <div class="clear"></div>
       <div style="margin: 50px 0px 50px 0px"> 
 <table bgcolor="#F9F7FF" align="center" width="100%"><tr><td>
<div id="body_1">
             <div class="ringimage_1"> 
                  <table border="0" width="520">
                       
                      <tr><td align="center"><table border="0" celpadding="0" cellspacing="0">
                          
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
     
         <td><A HREF="javascript:popitup('http://198.38.92.30:9090/alessio/getitemmoreimage.do?id=<%=itembe.getItem_id()%>')">
<IMG SRC="./Tea_image/<%=itembe.getFilename()%>" class="ringimg" border="0"></a><br>
   <font style="color:#996600;font-size:9px;"> 
       
<%=itembe.getBrand()%><br>
<a href="detail_item.do?id=<%=itembe.getItem_id()%>"><img  src="./aless/bb.png" border="0" width="117" height="34"></a></font>

         </td>
             
        <% 
        count++;
          count1++;
         if(count>4){break;}
          
      
         }
         
     %>
     </tr>
     <%
        
       }
     
    %>    
      
            <tr><td colspan="5" align="right"><font style="font-size:12"><b>Displaying Records:&nbsp;<%=ft%></b></font>
    <%if(!pre.equals("")){%>
    <a href="retailstoredet.do?method=Retail_Store_Detail&pr=<%=pre%>"><font size='1' color='black'>Previous</font></a>
    <%}
    if(!nxt.equals("")){%>
   <a href="retailstoredet.do?method=Retail_Store_Detail&pr=<%=nxt%>"><font size='1' color='black'>Next</font></a>
   <%}%>
   </td></tr>          
   </table></td></tr>
  </table>
   </div>
   
 </div>  </td></tr></table></div>
 <div class="clear"></div>
           
 <div>
<%@include file="/foot.jsp"%>
  </div>
        
</div>
    
    
    </body>
</html>

