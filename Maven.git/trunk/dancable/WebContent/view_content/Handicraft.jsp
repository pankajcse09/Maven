


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
         <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/prop_drop/pro_drop.css" />
              <script language="javascript" src="<%=request.getContextPath()%>/kk/resolution.js"></script>
            

<script language="javascript">
    function showList(s)
    {
        var td = s;
        var e=td.getElementsByTagName("div").item(0); 
        e.className= "mouseovr";
    }
    function hideList(s)
    {
        var td = s;
       var e1=td.getElementsByTagName("div").item(0); 
        e1.className= "mouseot";
    }
   
</script>
<style>
    .mouseovr{
        display: block;
    }
    .mouseot
    {
        display: none;
    }
    .cl
    {
        color: black;
        text-decoration: none;
    }
</style>
<script type="text/javascript" language="javascript"> 
   

 var newwindow = ''
function popitup(url) {
if (newwindow.location && !newwindow.closed) {
    newwindow.location.href = url;
    newwindow.focus(); }
else {

    newwindow=window.open(url,'htmlname','width=450,height=316,resizable=1');
 
    newWindow.document.writeln("<html>");
    newWindow.document.writeln("<body style='margin: 0 0 0 0;'>");
    newWindow.document.writeln("<table><tr><td align='center'>");
    newWindow.document.writeln("<a href='javascript:window.close();'>");
    newWindow.document.writeln("<img src='" + url + 
       "' alt='Click to close' id='bigImage'/>");
    newWindow.document.writeln("</a>");
    newWindow.document.writeln("</td></tr></table>");
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
    String desc="";
    if(request.getAttribute("desc")!=null){
   desc=(String)request.getAttribute("desc");
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
 
     String sizeto="";
    
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
  if(request.getAttribute("nav")!=null)
{

nav=(String)request.getAttribute("nav");
//out.println(homelist);
}
    
     %>
     
     <div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/all.js#xfbml=1";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
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
              <div style="margin: 70px 0px 50px 0px">
        <table bgcolor="#ffffff" align="center" width="100%">
<tr>
<td valign="top"><table>
    <tr><td bgcolor= "white" onmouseover="showList(this)" onmouseout="hideList(this)">
 <table><tr><td><font size="2" color="black" style="text-decoration: none">&nbsp;<b>BLACK TEA</b></font></td></tr></table>
<div class="mouseot">
         <table>
              <tr><td><a href="./subcatdet.do?id=4&pa=b&pr=1&method=view_ItemDetail" style="text-decoration: none"><font size="2" color="black"></font>Assam</a></td></tr>
               <tr><td><a href="./subcatdet.do?id=5&pa=b&pr=1&method=view_ItemDetail" style="text-decoration: none"><font size="2" color="black"></font>Black Teas</a></td></tr>
             <tr><td><a href="./subcatdet.do?id=6&pa=b&pr=1&method=view_ItemDetail" style="text-decoration: none"><font size="2" color="black"></font>Chinese Black Tea</a></td></tr>
           
              </table>
         </div>
     </td></tr>
     
     <tr><td bgcolor= "white" onmouseover="showList(this)" onmouseout="hideList(this)">
 <table><tr><td><a href="./subcatdet.do?id=14&pa=b&pr=1&method=view_ItemDetail" style="text-decoration: none"><font size="2" color="black">&nbsp;CHAITEA BLENDS</a></font></td></tr></table>
<div class="mouseot">
         <table>
                </table>
         </div>
     </td></tr>
     
     <tr><td bgcolor= "white" onmouseover="showList(this)" onmouseout="hideList(this)">
 <table><tr><td><a href="./subcatdet.do?id=15&pa=b&pr=1&method=view_ItemDetail" style="text-decoration: none"><font size="2" color="black">&nbsp;DARJEELING TEA</a></font></td></tr></table>
<div class="mouseot">
         <table>
                </table>
         </div>
     </td></tr>
     <tr><td bgcolor= "white" onmouseover="showList(this)" onmouseout="hideList(this)">
 <table><tr><td><a href="#" style="text-decoration: none"><font size="2" color="black">&nbsp;GREEN TEA</font></a></td></tr></table>
<div class="mouseot">
         <table>
              <tr><td><a href="subcatdet.do?id=7&pa=b&pr=1&method=view_ItemDetail" style="text-decoration: none"><font size="2" color="black"></font>Chinese Green Tea</a></td></tr>
              <tr><td><a href="subcatdet.do?id=8&pa=b&pr=1&method=view_ItemDetail" style="text-decoration: none"><font size="2" color="black"></font>Japanese Green Tea</a></td></tr>
              <tr><td><a href="subcatdet.do?id=9&pa=b&pr=1&method=view_ItemDetail" style="text-decoration: none"><font size="2" color="black"></font>Jasmine Tea</a></td></tr>
              <tr><td><a href="subcatdet.do?id=10&pa=b&pr=1&method=view_ItemDetail" style="text-decoration: none"><font size="2" color="black"></font>Sencha Blended Tea</a></td></tr>
            
         
         
         </table>
         </div>
     </td></tr>
     
      <tr><td bgcolor= "white" onmouseover="showList(this)" onmouseout="hideList(this)">
 <table><tr><td><a href="subcatdet.do?id=17&pa=b&pr=1&method=view_ItemDetail" style="text-decoration: none"><font size="2" color="black">&nbsp;EARL GREY BLENDS</font></a></td></tr></table>
<div class="mouseot">
         <table>
             
         
         
         </table>
         </div>
     </td></tr>
     
      <tr><td bgcolor= "white" onmouseover="showList(this)" onmouseout="hideList(this)">
 <table><tr><td><a href="subcatdet.do?id=18&pa=b&pr=1&method=view_ItemDetail" style="text-decoration: none"><font size="2" color="black">&nbsp;FRUIT BLENDS</font></a></td></tr></table>
<div class="mouseot">
         <table>
             
         
         
         </table>
         </div>
     </td></tr>
     
      <tr><td bgcolor= "white" onmouseover="showList(this)" onmouseout="hideList(this)">
 <table><tr><td><a href="subcatdethandicraft.do?id=19&pa=b&pr=1&method=view_ItemDetail_Handicraft" style="text-decoration: none"><font size="2" color="black">&nbsp;HANDCRAFTED & EXOTIC</font></a></td></tr></table>
<div class="mouseot">
         <table>
             
         
         
         </table>
         </div>
     </td></tr>
     
     
      <tr><td bgcolor= "white" onmouseover="showList(this)" onmouseout="hideList(this)">
 <table><tr><td><a href="subcatdet.do?id=20&pa=b&pr=1&method=view_ItemDetail" style="text-decoration: none"><font size="2" color="black">&nbsp;OOLONG TEA</font></a></td></tr></table>
<div class="mouseot">
         <table>
             
         
         
         </table>
         </div>
     </td></tr>
     
     
      <tr><td bgcolor= "white" onmouseover="showList(this)" onmouseout="hideList(this)">
 <table><tr><td><a href="subcatdet.do?id=21&pa=b&pr=1&method=view_ItemDetail" style="text-decoration: none"><font size="2" color="black">&nbsp;HERBAL</font></a></td></tr></table>
<div class="mouseot">
         <table>
             
         
         
         </table>
         </div>
     </td></tr>
     
     
      <tr><td bgcolor= "white" onmouseover="showList(this)" onmouseout="hideList(this)">
 <table><tr><td><a href="subcatdet.do?id=22&pa=b&pr=1&method=view_ItemDetail" style="text-decoration: none"><font size="2" color="black">&nbsp;ORGANIC TEA</font></a></td></tr></table>
<div class="mouseot">
         <table>
             
         
         
         </table>
         </div>
     </td></tr>
     
      <tr><td bgcolor= "white" onmouseover="showList(this)" onmouseout="hideList(this)">
 <table><tr><td><a href="subcatdet.do?id=23&pa=b&pr=1&method=view_ItemDetail" style="text-decoration: none"><font size="2" color="black">&nbsp;RED TEA</font></a></td></tr></table>
<div class="mouseot">
         <table>
             
         
         
         </table>
         </div>
     </td></tr>
     
     
      <tr><td bgcolor= "white" onmouseover="showList(this)" onmouseout="hideList(this)">
 <table><tr><td><a href="subcatdet.do?id=24&pa=b&pr=1&method=view_ItemDetail" style="text-decoration: none"><font size="2" color="black">&nbsp;WELLNESS TEA</font></a></td></tr></table>
<div class="mouseot">
         <table>
             
         
         
         </table>
         </div>
     </td></tr>
     
      <tr><td bgcolor= "white" onmouseover="showList(this)" onmouseout="hideList(this)">
 <table><tr><td><a href="subcatdet.do?id=25&pa=b&pr=1&method=view_ItemDetail" style="text-decoration: none"><font size="2" color="black">&nbsp;YERBA MATE</font></a></td></tr></table>
<div class="mouseot">
         <table>
             
         
         
         </table>
         </div>
     </td></tr>
     
      <tr><td bgcolor= "white" onmouseover="showList(this)" onmouseout="hideList(this)">
 <table><tr><td><a href="subcatdet.do?id=26&pa=b&pr=1&method=view_ItemDetail" style="text-decoration: none"><font size="2" color="black">&nbsp;WHITE TEA</font></a></td></tr></table>
<div class="mouseot">
         <table>
             
         
         
         </table>
         </div>
     </td></tr>
     
      <tr><td bgcolor= "white" onmouseover="showList(this)" onmouseout="hideList(this)">
 <table><tr><td><a href="subcatdet.do?id=27&pa=b&pr=1&method=view_ItemDetail" style="text-decoration: none"><font size="2" color="black">&nbsp;NEW TEAS</font></a></td></tr></table>
<div class="mouseot">
         <table>
             
         
         
         </table>
         </div>
     </td></tr>
  </table></td>
<td valign="top">
<div id="body_1">
             <div class="ringimage_1"> 
                  <table border="0" width="520" align="left">
                        <tr><td style="color:black;font-weight:bold"><%=nav%></td></tr>
                        <tr><td align="left" style="color:brown;font-weight:bold"><%=desc%></td></tr>
                        
                               <tr><td><table>
                          <form name="a" method="post" action="<%=request.getContextPath()%>/subcatdetsizehandy.do?id=<%=id%>&pa=b&pr=1&method=sizehandy_view_ItemDetail">
                          <tr><td><font style="font-weight:bold;font-size:12px">Select Size</font>
<select name="sizeto"  onchange="get_size_item()">
  <%  if(request.getAttribute("sizeto")==null)
{

sizeto=(String)request.getAttribute("sizeto");%>
     <option value="select one">select one</option>
  <%}%>
      <%
if(request.getAttribute("sizeto")!=null)
{

sizeto=(String)request.getAttribute("sizeto");
                          %>
                      <option value="<%=sizeto%>"><%=sizeto%></option>   
                           

<%}
                          %>
                            <option value="3.5oz">3.5oz</option>
                             <option value="3pieces">3pieces</option>
                          </select>
                         

<input type="submit" value="view"></td></tr>
                          </form>
                      </table>
                      </td></tr>
                      <tr><td><table border="0" celpadding="0" cellspacing="0">
                          
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
     
         <td><font style="color:black;font-size:10px;width:16px"><b><%=itembe.getBrand()%></b></font><br><A HREF="javascript:popitup('./Tea_image/<%=itembe.getFilename()%>')">
<IMG SRC="./Tea_image/<%=itembe.getFilename()%>" width="145" height="145" border="0"></a><br>
     <font style="color:black;font-size:10px;"> Size &nbsp<%=itembe.getUnit()%></font></br>
   <font style="color:black;font-size:11px;">Price &nbsp$<%=itembe.getPrice()%><br>
<a href="detail_item.do?id=<%=itembe.getItem_id()%>"><img  src="./aless/bb.png" border="0" width="119" height="34"></a></font>

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
      
             <tr><td colspan="5" align="right"><font style="font-size:12;color:black"><b>Displaying Records:&nbsp;<%=ft%></b></font>
    <%if(!pre.equals("")){%>
    <!--<a href="subcatdet.do?method=view_ItemDetail&pr=<%=pre%>&id=<%=id%>"><font size='1' color='black'>Previous</font></a> -->
    <a href="subcatdet.do?method=view_ItemDetail&pr=<%=pre%>&id=<%=id%>&pa=<%=pa%>"><font size='1' color='black'>Previous</font></a>
    <%}
    if(!nxt.equals("")){%>
   <!--<a href="subcatdet.do?method=view_ItemDetail&pr=<%=nxt%>&id=<%=id%>"><font size='1' color='black'>Next</font></a> -->
   <a href="subcatdet.do?method=view_ItemDetail&pr=<%=nxt%>&id=<%=id%>&pa=<%=pa%>"><font size='1' color='black'>Next</font></a>
   <%}%>
   </td></tr>          
   </table></td></tr>
  </table>
   </div>
 
</div></td></tr></table>
              </div>    
      <div class="clear"></div>  
	<div id="footerone_1" align="center"></div>
	<div>
<%@include file="/foot.jsp"%>
  </div>
     
        
</div>
    
    
    </body>
</html>
