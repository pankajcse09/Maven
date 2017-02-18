<%-- 
    Document   : home
    Created on : May 25, 2013, 1:33:50 PM
    Author     : kapil
--%>
<%@page import="mc_bean.mc_prop"%>
<%@page import="java.util.HashMap"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page import="java.util.ArrayList"%>
<%@page import="moreimg.img_bean"%>
<%@page import="moreimg.function_int_foodmart"%>
<%@page import="java.io.*"%>
<%@page import="Main_category.item_bean"%>
<%@ page language="java"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=1024">
        <title>Danceables</title>
        <script language="javascript" src="css_js/resolution.js"></script>
        <link rel="stylesheet" type="text/css" href="css/change.css" />
        <script language="javascript" src="css/menu.js"></script>
        
<link href="<%=request.getContextPath()%>/skin/pink.flag/jplayer.pink.flag.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.jplayer.min.js"></script>
<script type="text/javascript" src="js/jplayer.playlist.min.js"></script>
<script type="text/javascript" src="js/jquery.jplayer.inspector.js"></script>
<script type="text/javascript">

.container {
   /* Optional - You can set a  min-height : whatever px; for reserving some space*/
   height: 300px; /* Fix a height here */
   overflow: auto; /* Optionally you can also use overflow: scroll; */
}

//<![CDATA[
$(document).ready(function(){
var jsonobj = [];

/*Loop through a given list and push it into a JSon array*/
jQuery('div.RadioList input').each(function (index) {
       var mp3 = jsonobj.push({ mp3: jQuery(this).attr('value') });
       var title = [];
       title.push(jQuery(this).attr('title'));
      
       jsonobj[mp3 - 1]['title'] = title;
});

var cssSelector = {
       jPlayer: "#jquery_jplayer_1",
       cssSelectorAncestor: "#jp_container_1"
};
/*An Empty Playlist*/
var playlist = []; 
   var options = {
      swfPath: "js/Jplayer.swf",
       supplied: "mp3",
                wmode: "window",
		smoothPlayBar: true,
		keyEnabled: true,
		audioFullScreen: true

};

var myPlaylist = new jPlayerPlaylist(cssSelector, playlist, options);
/*Loop through the JSon array and add it to the playlist*/ 
for (i = 0; i < jsonobj.length; i++) {
     myPlaylist.add(jsonobj[i]);
}
});
//]]>
</script>
 <script language="JavaScript">    
 function showRelItem(en){ 
     var url="<%=request.getContextPath()%>/Item/newReleaseItem.jsp";
url=url+"?pr="+en;
$.get( url, function( response ) {
    document.getElementById("replace").innerHTML=response; // server response
});
}    

</script>
  
        <script language="javascript">
            function play(i)
            {
                //alert("hello");
                var count=document.getElementById("count").value;
                
                //alert(count);
                if(count==1){
                    document.getElementById("ply").value=document.getElementById("player_"+i).innerHTML;
                    document.getElementById("plycnt").value=i;
              
                var inr=document.getElementById('innr').innerHTML;
                document.getElementById("player_"+i).innerHTML=inr;
                }
                else{
                    var j=document.getElementById("plycnt").value;
                   
                    document.getElementById("player_"+j).innerHTML=document.getElementById("ply").value;
                    document.getElementById("ply").value=document.getElementById("player_"+i).innerHTML;
                    
                    var inr=document.getElementById('innr').innerHTML;
                document.getElementById("player_"+i).innerHTML=inr;
                
                document.getElementById("plycnt").value=i;
                }
                document.getElementById("count").value=parseInt(count)+1;
            }
        </script>
    </head>
    
    <body>
            <%   String page_name="";
   ArrayList homelist=new ArrayList();
img_bean imgbe=new img_bean();

ArrayList discountlist=new ArrayList();
img_bean picbe=new img_bean();
String fn1="";
String fn2="";
String fn3="";
String fn4="";
ArrayList qualitylist=new ArrayList();
String  page_id="";
 function_int_foodmart fd=new function_int_foodmart();
 ArrayList gwm=new ArrayList();
 ArrayList news=new ArrayList();
  ArrayList contactus=new ArrayList();
 ArrayList evdstrm=new ArrayList();
if(request.getAttribute("homelist")!=null)
{
homelist=(ArrayList)request.getAttribute("homelist");
//out.println(homelist);
}
 
if(request.getAttribute("evdstrm")!=null)
{
evdstrm=(ArrayList)request.getAttribute("evdstrm");
//out.println(homelist);
}
 if(request.getAttribute("page_name")!=null)
{
page_name=(String)request.getAttribute("page_name");
//out.println(homelist);
}
%>

<%
    
         ArrayList ar=new ArrayList();
         HashMap hm=new HashMap();
         mc_prop  itembe=new mc_prop();
  String ft="";
  String pre="";
  String nxt="";
  String stindex="";
  int k=0;  
  

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
 %>
        <table width="100%" cellspacing="0" cellpadding="0">
         <!--<table align="center">-->
            <tr>
               <!-- <img class="image" src="<%=request.getContextPath()%>/images/homepage/Homepage background.png" width="100%" height="700">-->
                 
                <td>
                    <div id="header">
                    <div class="tb">
                        <div id="headdesign">
                       <div class="header1">
                           <img src="<%=request.getContextPath()%>/images/homepage/logo_03.png" class="logoimg">
                               </div>
                            <div class="header2">
                                <div class="user"><%@include file="/user_login/user_head.jsp"%></div>
                                <div class="header2_2"><%@include file="/top_menu.jsp"%></div>
                            </div>

                        </div>
                    </div>
                    </div>
                    </td>
               
                
            </tr>
            
            <tr>
                <td background="<%=request.getContextPath()%>/images/homepage/bottom grey.png" width="100%" height="900" valign="top">
                    <table border="0" width="75%" align="center" valign="top">
                        <tr align="left" valign="top">
                            <td style="padding-top: 30px" width="34%">
                                <table>
                                    <%for(int i=0;i<homelist.size();i++)

                      {

   %>
    
   <%
       imgbe=(img_bean)homelist.get(i);
      page_id=new Integer(imgbe.getPage_id()).toString();
      ArrayList moreimglist=new ArrayList();
        moreimglist=(ArrayList)fd.select_moreimg("aboutus",Integer.parseInt(page_id));
        

%>
                                    <tr>
                                        <td>
                                            <b>Pianist Steven Mitchell with music in Recording and in Print. Music for Dance and Pianists.  </b>
                                            <p class="fnt1"><%=imgbe.getHead()%></p>
                                            <%=imgbe.getDesc()%>
                                            
<%
boolean tr=false;
tr=(boolean)fd.Read_More(imgbe.getPage_id());
if(tr==true)
{%>
<a href="view_details.do?method=Content_Detail_Data&id=<%=imgbe.getPage_id()%>">

<font style="font-size:10;color:blue;font-weight:bold">Read More</font></a>
<%}%>
                                        </td>
                                    </tr>
                                    <%}%>
                                </table>
                            </td>
                            

                            
                            
                            
                            
                            
<div  >     
 <table width="75%" align="center"><tr><td>
     <p><b>Policies, Terms and Conditions:</b>Your use and/or placement of any order indicate your acceptance of the following Conditions.</p>



<b>Privacy: </b>
<br>

Company ABC keeps your personal information private and secure. When you make a purchase from our site, 
you provide your name, contact information, credit card information, and a password. We use this 
information to process your orders, to keep you updated on your orders and to personalize your shopping 
experience. We absolutely do not share your information with third parties.

<br><br>
<b>Order Acceptance Policy</b>
<br>


Your receipt of an order confirmation does not signify our acceptance of your order, nor does 
it constitute confirmation of our offer to sell. Company ABC reserves the right at any time to 
accept or decline your order for any reason or to supply less than the quantity you ordered of any item.

<br><br>
<b>Methods of Payment</b>
<br>

Company ABC accepts credit cards, money orders, cashier’s checks, and company checks in U.S. Dollars 
for wholesale orders only. Orders are processed upon receipt of a money order or cashier’s check. 
For company checks, please allow up to 10 banking days after receipt for clearance of funds before 
the order is processed. We cannot guarantee the availability of a product by the time funds clear or 
payment is received. We will charge a $25 fee on all returned checks. Retail orders must be paid by credit card only.

<br><br>
<b>Shipping Policy</b>
<br>
Orders are shipped Monday through Friday until 5pm.

Please read Shipping notes for more informations. Click 
<a href="JavaScript: popjack()" onMouseOver="window.status='TEXT TEXT TEXT TEXT ';return true" onMouseOut="window.status=''; return true" style="text-decoration: none;">Shipping Notes</a>

<br><br>
<b>Out-of-Stock Products</b>
<br>
We will keep you informed of any products you have ordered that are out-of-stock and unavailable for 
immediate shipment. Products will ship as they become available. You may cancel your order at any time prior to shipping.


<br><br>
<b>Taxes</b>
<br>
Company ABC shall automatically charge applicable sales tax for retail orders to be delivered to addresses within NY.

<br><br>
<b>Returns</b>
<br>
We will gladly accept the return of products that are deemed defective due to manufacturing 
for 10 days from the date of purchase. Fulfillment mistakes resulting in the shipment of incorrect 
product will also be accepted for return 10 days from the date of purchase.

<br><br>
<b>Copyright and Trademark Notice</b>
<br>
This site is owned and operated by Company ABC. Unless otherwise specified, 
all materials appearing on this site, including the text, site design, logos, graphics, 
icons, and images, as well as the selection, assembly and arrangement thereof, are the sole 
property of the Company ABC. You may use the content of this site only for the purpose of shopping 
on this site or placing an order on this site and for no other purpose. No materials from this 
site may be copied, reproduced, modified, republished, uploaded, posted, transmitted, or distributed 
in any form or by any means without Company ABC’s prior written permission. All rights not expressly granted 
herein are reserved. Any unauthorized use of the materials appearing on this site may violate copyright,
 trademark and other applicable laws and could result in criminal or civil penalties.
</td></tr></table>
              
            
                
        </div>  
                 
            
            
           
         <div style="clear: both" ></div>
          <div width="100%">                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                         
                        </tr>
                      <tr><td colspan="3"><%@include file="/footer.jsp"%></td></tr>
                    </table>
                </td>
            </tr>
        </table>
    </body>
</html>
