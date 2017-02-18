


<%@page import="mc_operat.round_funct"%>
<%@page import="mc_bean.mc_prop"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.DecimalFormat"%>
<!DOCTYPE html>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page import="com.myapp.struts.Im_Projects_DataHold"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.myapp.struts.Display_Data_hold"%>
<%@page import="moreimg.img_bean"%>
<%@page import="moreimg.function_int_foodmart"%>
<%@page language="java"%>
<%@page import="java.io.*"%>
<%@page import="Main_category.item_bean"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>Danceables</title>
         <META content=" At DANCABLEs, our collection consists of CDs, DVDs and Printed music.">
<META name=keywords content="dancables,steven,CDs,DVDs,Printed music and books">
   <LINK REL="SHORTCUT ICON" HREF="<%=request.getContextPath()%>/.ico">
      <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/pro_drop_1/laycss.css" />
      <link href="css/flexcrollstyles.css" rel="stylesheet" type="text/css">
      <link href="css/tutorsty.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/flexcroll.js"></script>
   <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/change.css" />
        <script language="javascript" src="<%=request.getContextPath()%>/css/menu.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/css_js/resolution.js"></script>
        <script src="<%=request.getContextPath()%>/magiczoom/magiczoom.js" type="text/javascript"></script>
        <link href="<%=request.getContextPath()%>/skin/pink.flag/jplayer.pink.flag.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.jplayer.min.js"></script>
<script type="text/javascript" src="js/jplayer.playlist.min.js"></script>
<script type="text/javascript" src="js/jquery.jplayer.inspector.js"></script>

<script type="text/javascript">
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
<script language=javascript>
            function roundNumber(myNum,numOfDec){ 
var decimal = 1 
for(i=1; i<=numOfDec;i++){ 
decimal = decimal *10;
}
var myFormattedNum = (Math.round(myNum * decimal)/decimal).toFixed(numOfDec) 
return myFormattedNum; 
}

          function get_total()
            {
             var q='';
           q=parseFloat(document.forms[0].quantity.value);
           document.forms[0].total.value=roundNumber((parseFloat(document.forms[0].amount.value)*parseFloat(q)),2);
              }
        </script>		
 <script language="javascript">
             
          function get_peritem(itemid,scid)
           {
          document.f1.method="post";
          document.f1.action='<%=request.getContextPath()%>/get_peritem.do?method=get_perItem&itemid='+itemid+"&scid="+scid;
          document.f1.submit();
          }
          
          function add_to_wis(itemid)
           {
          document.f1.method="post";
          document.f1.action='<%=request.getContextPath()%>/addTo_mywishlist.do?method=get_perItem&itemid='+itemid;
          document.f1.submit();
          }
          
          function addToCart()
          {
              document.ab.method="post";
              document.ab.action="<%=request.getContextPath()%>/create_cart.do?method=create_cart";
              document.ab.submit();
          }
          
          function printpage()
   {
   window.print()
   }
   
   function callprint(){ 
self.focus() 
self.print() 
} 
        </script>
          <script language=javascript>
              function validate(srt){
                  if(document.f1.eid.value==""){    
    alert("Enter First Name");
    document.f1.eid.focus();
    return false;        
    } 
    email_your_friend(srt)
              }
            </script>
          <script>
              function add_to_wishlist(itemid,price,detail,brand,size,filename,product){
                var url="<%=request.getContextPath()%>/addTo_mywishlist.do";
url=url+"?method=add_to_mywishlist&itemid="+itemid+"&pc="+price+"&detail="+detail+"&brand="+brand+"&size="+size+"&filename="+filename+"&prod_id="+product;
$.get( url, function( response ) {
    document.getElementById("wish").innerHTML=response; // server response
});

            }
            
  function email_your_friend(path){
                var str=document.getElementById("eid").value;
                 var xmlhttp;
                if(str=="")
  {
  document.getElementById("frnd_email").innerHTML="";
  document.getElementById("frnd_email").innerHTML="Please Enter Your Email Id First!";
  return;
  }
  else{
      document.getElementById("frnd_email").innerHTML="Please wait...";
  }
               
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
      document.getElementById("frnd_email").innerHTML=xmlhttp.responseText;
    }
  }
xmlhttp.open("POST","<%=request.getContextPath()%>/send_email.do?fr_email="+str+"&path="+path,true);
xmlhttp.send();
            }
          </script>


            <script language="javascript" src="kk/resolution.js"></script>
<script type="text/javascript" language="javascript"> 
   

 var newwindow = ''
function popitup(url) {
window.open(url,'jewelry','width=433,height=450,menubar=no,scrollbars=yes,resizable=1');
    
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
   <%
      NumberFormat formatter = new DecimalFormat("#0.00");
      String username="";
  username= (String)session.getAttribute("loginid");
       ArrayList contentlist=new ArrayList();
img_bean imgbe=new img_bean();
item_bean itembe=new item_bean();
Im_Projects_DataHold smplfile= new Im_Projects_DataHold();
ArrayList detail=new ArrayList();
img_bean picbe=new img_bean();
String fn1="";
String fn2="";
String fn3="";
String fn4="";
ArrayList qualitylist=new ArrayList();
String  page_id="";
 function_int_foodmart fd=new function_int_foodmart();
if(request.getAttribute("detail")!=null)
{
    detail=(ArrayList)request.getAttribute("detail");
}
String brand="";
if(request.getAttribute("brand")!=null)
{
    brand=(String)request.getAttribute("brand");
}
ArrayList itmstrm=new ArrayList();
ArrayList relatedItems=new ArrayList();
ArrayList wrtnsample=new ArrayList();
if(request.getAttribute("itmstrm")!=null)
{
    itmstrm=(ArrayList)request.getAttribute("itmstrm");
}
if(request.getAttribute("relatedItems")!=null)
{
    relatedItems=(ArrayList)request.getAttribute("relatedItems");
}
if(request.getAttribute("wrtnsample")!=null)
{
    wrtnsample=(ArrayList)request.getAttribute("wrtnsample");
}

int check=0;
try{
    if(request.getAttribute("check")!=null)
        {
            check=Integer.parseInt(request.getAttribute("check").toString());
        }
}catch(NumberFormatException nfe){}
try{
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
           
  <tr>
                <td background="<%=request.getContextPath()%>/images/homepage/bottom grey.png" width="100%" valign="top" style="background-repeat: no-repeat">
                    <table class="cel1" style="padding-left: 0px" border="0" align="center" width="100%">
                        <tr>
                            <!--<td valign="top" width="20%">
                    <table>
                        <tr>
                <td class="chang" onclick="chang(this)" align="center">
                    <a class="b" href="subcatdet.do?id=1&pa=a&pr=1&method=view_ItemDetail">CDs FOR BALLET</a>
                </td>
            </tr>
             <tr>
                <td class="chng" align="center" id="cl">
                    <a class="b" href="subcatdett.do?id=2&pa=a&pr=1&method=view_ItemDetail">CDs FOR PRE-BALLET</a>
                </td>
            </tr>
                    </table> 
                </td>-->
                
                <td style="padding-left: 20px" width="63%" align="center" valign="top">
   <form name="ab" method="post" action="create_cart.do?method=create_cart">
                    <table valign="top" width="70%" cellpadding="0" cellspacing="0" border="0" align="right">


   <%
round_funct rf=new round_funct();
       //out.println("size: "+detail.size());
       for(int i=0;i<detail.size();i++)

                      {

   %>
    <tr>
   <%
      itembe=(item_bean)detail.get(i);
         if(!itembe.getFilename().equals(""))
{
         
//  fn1=request.getContextPath()+"/Imge/"+itembe.getFilename();
  
    fn1="./music_image/"+itembe.getFilename();
}
%>
<td width="100%" height="400" align="center" valign="top">
<table width="100%" align="center" border="0" >
<tr>

<td width="50%">
<!-- define Magic Zoom -->
<span title="<%=itembe.getBrand()%>"><img src="<%=fn1%>" width="300" border="0"/></span><br/>

        <!-- selector without title and with own zoom window size -->
    </td>
            <%if(request.getAttribute("brand")!=null){%>
     <input type="hidden" name="brand" value="<%=brand%>">
        <% }else{%>

<input type="hidden" name="brand" value="<%=itembe.getBrand()%>"><%}%>
    
 <td width="50%" valign="bottom" style="padding-left: 10px" align="left">
     <table border="0"><tr><td valign="top"><font style="color:black;font-size:14px; font-weight: 600;">Product</font></td>
             <td><font style="color:black;font-size:14px; font-weight: 600;"><%=itembe.getBrand()%></font></td></tr>
             <tr valign="top"><td><font style="color:black;font-size:14px; font-weight: 600;">Code:</font></td>
                 <td><font style="color:black;font-size:14px; font-weight: 600;"><%=itembe.getProd_id()%></font></td></tr>
                 <tr><td valign="top"><font style="color:black;font-size:14px; font-weight: 600;">Price:</font></td>
                     <td><input type="text" name="total"  size="5" value="<%=formatter.format(itembe.getPrice())%>" readonly></td></tr>
                     <tr><td valign="top"><font style="color:black;font-size:14px; font-weight: 600;">Quantity in Basket:&nbsp</font></td>
                         <td><input type="text" name="quantity" value="1" size="5" onblur="get_total()"></td></tr>
                     
 <input type="hidden" name="amount" value="<%=itembe.getPrice()%>"> 
     <input type="hidden" name="itemid" value=<%=new Integer(itembe.getItem_id()).toString()%>>
           <input type="hidden" name="scid" value=<%=new Integer(itembe.getSubcat_id()).toString()%>>
            <input type="hidden" name="username" value=<%=username%>>
         
           <input type="hidden" name="filename" value=<%=itembe.getFilename()%>>
           <input type="hidden" name="price" value="<%=itembe.getPrice()%>">
           
           <input type="hidden" name="prod_id" value="<%=itembe.getProd_id()%>">
 </table>
           <table border="0" width="100%"><tr><td colspan="2" onclick="addToCart()" style="cursor: pointer">
        <img  src="<%=request.getContextPath()%>/images/CD for ballet/add-to-cart.png" border="0" width="100"></td>
        <td><div id="wish">
                <% if(check==0){%>
                    <input style="cursor: pointer" type="button" size="12" value="Add to My WishList" onclick="add_to_wishlist('<%=itembe.getItem_id()%>','<%=itembe.getPrice()%>','<%=itembe.getDetail()%>','<%=itembe.getBrand()%>','<%=itembe.getSize()%>','<%=itembe.getFilename()%>','<%=itembe.getProd_id()%>')"></input>
                    <%}else{%>
                    <font  style="text-decoration: none; color: #919188; font-size: 12px">Added to</font> 
                    <a href="<%=request.getContextPath()%>/mywishlist.do?method=retrieve_wishlist" style="color: brown; font-size: 12px">Wishlist</a>
                    <%}%>
                </div></td>    
               </tr></table>
 </td>
</tr>

 <tr align="left">
     <td colspan="2">
         <font style="color:#3EAAAA;font-size:17px;">Description: </font><%=itembe.getDetail()%><br>
         <%if(itembe.getCover_content()!=null&&!itembe.getCover_content().equals("")){%>
         <a href='<%=request.getContextPath()%>/viewfile?fl=<%=itembe.getCover_content()%>' target="_blank" style="text-decoration: none">Click here to see Contents</a>
         <br>
         <%}%>
         <br>
         <% if(wrtnsample.size()!=0)
{%>
<table>
  <%  for(int j=0;j<wrtnsample.size();j++)
    {
        Im_Projects_DataHold prodetail=(Im_Projects_DataHold)wrtnsample.get(j);
    
%>
<tr><td colspan="2" valign="center">
   <a href="<%=request.getContextPath()%>/moremusic_samples/<%=prodetail.getFilename()%>" target="_blank" style="text-decoration: none">
      <span title="<%=prodetail.getTitle()%>"><img src="<%=request.getContextPath()%>/images/Pdf_ic.png"/><font style="color: #547068">Sample</font></span>
   </a></td></tr>
<%}%>
</table>
<%}%>
<%      //out.println(itmstrm.size());
         if(itmstrm.size()!=0)
                                    {%>
             <font style="color:black;font-size:14px; font-weight: 600;">See below for audio sample from this collection</font>
             <table class="shadow" align="center">
                                    <tr><td class="fnt"><font size="2">SAMPLE STREAMING</font></td></tr>
                                    <tr><td>
                                            <div id="jp_container_1" class="jp-video jp-video-270p">
			<div class="jp-type-playlist">
				<div id="jquery_jplayer_1" class="jp-jplayer"></div>
				<div class="jp-gui">
					<!--<div class="jp-video-play">
						<a href="javascript:;" class="jp-video-play-icon" tabindex="1">play</a>
					</div>-->
					<div class="jp-interface">
						<div class="jp-progress">
							<div class="jp-seek-bar">
								<div class="jp-play-bar"></div>
							</div>
						</div>
						<div class="jp-current-time"></div>
						<div class="jp-duration"></div>
						<div class="jp-title">
							<ul>
								<li></li>
							</ul>
						</div>
						<div class="jp-controls-holder">
							<ul class="jp-controls">
								<li><a href="javascript:;" class="jp-previous" tabindex="1">previous</a></li>
								<li><a href="javascript:;" class="jp-play" tabindex="1">play</a></li>
								<li><a href="javascript:;" class="jp-pause" tabindex="1">pause</a></li>
								<li><a href="javascript:;" class="jp-next" tabindex="1">next</a></li>
								<li><a href="javascript:;" class="jp-stop" tabindex="1">stop</a></li>
								<li><a href="javascript:;" class="jp-mute" tabindex="1" title="mute">mute</a></li>
								<li><a href="javascript:;" class="jp-unmute" tabindex="1" title="unmute">unmute</a></li>
								<li><a href="javascript:;" class="jp-volume-max" tabindex="1" title="max volume">max volume</a></li>
							</ul>
							<div class="jp-volume-bar">
								<div class="jp-volume-bar-value"></div>
							</div>
							<ul class="jp-toggles">
								<li><a href="javascript:;" class="jp-full-screen" tabindex="1" title="full screen">full screen</a></li>
								<li><a href="javascript:;" class="jp-restore-screen" tabindex="1" title="restore screen">restore screen</a></li>
								<li><a href="javascript:;" class="jp-shuffle" tabindex="1" title="shuffle">shuffle</a></li>
								<li><a href="javascript:;" class="jp-shuffle-off" tabindex="1" title="shuffle off">shuffle off</a></li>
								<li><a href="javascript:;" class="jp-repeat" tabindex="1" title="repeat">repeat</a></li>
								<li><a href="javascript:;" class="jp-repeat-off" tabindex="1" title="repeat off">repeat off</a></li>
							</ul>
						</div>
					</div>
				</div>
				<% if(itmstrm.size()<=6)
                                    {%>  
                        <div class="jp-playlist">
					<ul>
						<!-- The method Playlist.displayPlaylist() uses this unordered list-->
						<li></li>
					</ul>
				</div>            
                   <%}else{%>                 
                         <div id="mycustomscroll" class="flexcroll">          
			<div class="jp-playlist">
					<ul>
						<!-- The method Playlist.displayPlaylist() uses this unordered list -->
						<li></li>
					</ul>
				</div>
                         </div>
                         <%}%>
				<div class="jp-no-solution">
					<span>Update Required</span>
					To play the media you will need to either update your browser to a recent version or update your <a href="http://get.adobe.com/flashplayer/" target="_blank">Flash plugin</a>.
				</div>
			</div>
		</div>
         <div id="lit">
        <div class="RadioList">
            <%try{if(itembe.getSampleFileName()!=null&&!itembe.getSampleFileName().equals("")){%>
            <input type="hidden" value="<%=request.getContextPath()%>/audio_sample/<%=itembe.getSampleFileName()%>" title="<%=itembe.getSampleTitle()%>" class="">
            <%}}catch(Exception e){}
            
                                        for(int j=0;j<itmstrm.size();j++)
                                        {
                                          smplfile=(Im_Projects_DataHold)itmstrm.get(j);
                                          %>
            <input type="hidden" value="<%=request.getContextPath()%>/moremusic_samples/<%=smplfile.getFilename()%>" title="<%=smplfile.getTitle()%>" class="">
            
            <%}%>
        </div>
    </div>
                                        </td></tr>
                                </table>
        <%}%>
     </td>
 </tr>


</table>
</td>

</tr>

<%}%>

</table>     
</form>
                </td>
<td width="37%" valign="top">
    <div class="related">
      <% 
      if(relatedItems.size()!=0)
      {%>
      <div class="rel_label">RELATED ITEMS</div>
   <%}       
     for(int i=0;i<relatedItems.size();i++)
      {
        mc_prop item=(mc_prop)relatedItems.get(i);
        %>
        <div style="overflow:hidden;">
        <div class="rel_items">
            <div class="itmimg"><img src="<%=request.getContextPath()%>/music_image/<%=item.getFilename()%>" class="rel_itemImg"></div>
            <div class="rel_itemDetail">
                <div><b><u><%=item.getBrand()%></u></b></div>
                <div><b>Code: <%=item.getProd_id()%></b></div>
                <div><b>Price: <%=rf.round_toTwo(itembe.getPrice())%></b></div>
                <div><a href="detail_item.do?id=<%=item.getItem_id()%>">
                        <img  src="<%=request.getContextPath()%>/images/click-here-button.png" border="0" width="80"></a></div>
            </div>
            <div style="clear: both;"></div>
        </div>
        </div>     
      <%}%>
      </div>
    
</td>
                        </tr>

<tr><td colspan="2"><%@include file="/footer.jsp"%></td>

                    </table>
                </td>
            </tr>                       
                  
        </table>
<%}catch(Exception e)
{
    
}%>
    
    </body>
</html>

