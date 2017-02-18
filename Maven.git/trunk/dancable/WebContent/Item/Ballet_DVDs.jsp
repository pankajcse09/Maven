<%-- 
    Document   : Ballet_DVDs
    Created on : Jun 3, 2013, 12:26:25 PM
    Author     : kapil
--%>

<%@page import="mc_operat.round_funct"%>
<%@page import="mc_bean.mc_prop"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ballet DVDs</title>
       <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/change.css" />
        <script language="javascript" src="<%=request.getContextPath()%>/css/menu.js"></script>
        <script language="javascript" src="<%=request.getContextPath()%>/css_js/resolution.js"></script>
        <link href="./skin/blue.monday/jplayer.blue.monday.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
<script type="text/javascript" src="./js/jquery.jplayer.min.js"></script>
<script type="text/javascript">
//<![CDATA[
$(document).ready(function(){

	$("#jquery_jplayer_1").jPlayer({
		ready: function () {
			$(this).jPlayer("setMedia", {
				webmv: "./Item/On-Your-Mark-Trailermov.webm",
                                poster: "./Item/mqdefault.jpg"
			});
		},
		swfPath: "js",
		supplied: "webmv, ogv, m4v",
		size: {
			cssClass: "jp-video-270p"
		},
		smoothPlayBar: true,
		keyEnabled: true
	});

});
//]]>
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
  if(request.getAttribute("nav")!=null)
{

nav=(String)request.getAttribute("nav");
//out.println(homelist);
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
                 <tr>
                <td background="<%=request.getContextPath()%>/images/homepage/bottom grey.png" width="100%" valign="top" style="background-repeat: no-repeat">
                    <table class="cel1" style="padding-left: 0px" width="100%">
                         <tr>
                            <td><table border="0" width="100%">
                        <tr>
                            <td valign="top" width="28%" style="padding-left: 50px">
                    <table>
                        <tr>
                <td align="center" valign="top" style="padding-top: 15px;">
                    <a class="b" href="<%=request.getContextPath()%>/dvd.do?id=3&pa=a&pr=1&method=view_ItemDetail"><img src="images/homepage/ballet-dvds-normal.png" width="200"</a>
                </td>
                </tr>
                    </table> 
                </td>
                <td valign="top">
                    <table>
                        <tr><td style="padding-left: 30px" align="center">
                                <div>
                   <!--<iframe title="YouTube video player" width="420" height="250" style="border: solid 1px black; " src="http://www.youtube.com/embed/eoOah-TjYCo" frameborder="0" allowfullscreen=""></iframe>-->
                   
                   
                   <div id="jp_container_1" class="jp-video jp-video-270p">
			<div class="jp-type-single">
				<div id="jquery_jplayer_1" class="jp-jplayer"></div>
				<div class="jp-gui">
					<div class="jp-video-play">
						<a href="javascript:;" class="jp-video-play-icon" tabindex="1">play</a>
					</div>
					<div class="jp-interface">
						<div class="jp-progress">
							<div class="jp-seek-bar">
								<div class="jp-play-bar"></div>
							</div>
						</div>
						<div class="jp-current-time"></div>
						<div class="jp-duration"></div>
						<div class="jp-controls-holder">
							<ul class="jp-controls">
								<li><a href="javascript:;" class="jp-play" tabindex="1">play</a></li>
								<li><a href="javascript:;" class="jp-pause" tabindex="1">pause</a></li>
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
								<li><a href="javascript:;" class="jp-repeat" tabindex="1" title="repeat">repeat</a></li>
								<li><a href="javascript:;" class="jp-repeat-off" tabindex="1" title="repeat off">repeat off</a></li>
							</ul>
						</div>
						<div class="jp-title">
							<ul>
								<li>On Your Mark</li>
							</ul>
						</div>
					</div>
				</div>
				<div class="jp-no-solution">
					<span>Update Required</span>
					To play the media you will need to either update your browser to a recent version or update your <a href="http://get.adobe.com/flashplayer/" target="_blank">Flash plugin</a>.
				</div>
			</div>
		</div>
                   </div>
                            </td>    
                        </tr>
                        <tr><td>&nbsp;</td></tr>
             
                        <tr>     
                <td style="padding-top: 50px" width="750" height="500" valign="top">
                    <table border="0" celpadding="0" cellspacing="0">
                          
 <%
 String idforcat=(String)session.getAttribute("scid");
   // out.println(idforcat);
    round_funct rf=new round_funct();
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
     
         <td style="padding-bottom: 30px" width="22%" align="center">
             <font style="color:black;font-family: Arial;font-size:12px; font-weight: 600;"><%=itembe.getBrand()%><br>
          <a href="detail_item.do?id=<%=itembe.getItem_id()%>&cl=b">
<IMG SRC="./music_image/<%=itembe.getFilename()%>" width="160" height="200" border="0"></a><br>

<font style="color:olivedrab; font-family: Arial;font-size:11px; font-weight: 600;">Code:&nbsp<%=itembe.getProd_id()%></font><br>
<font style="color:black;font-family: Arial;font-size:11px; font-weight: 600;">Shipment: &nbsp$<%=rf.round_toTwo(itembe.getPrice())%></font><br>
<!--<font style="color:black;font-family: Arial;font-size:11px; font-weight: 600;">Download: &nbsp$<%=rf.round_toTwo(itembe.getDown_price())%></font><br>-->
   <!-- <font style="color:black;font-size:12px; font-weight: 600;">Quantity in Basket:&nbsp<br>--> 
<a href="detail_item.do?id=<%=itembe.getItem_id()%>&cl=b"><img  src="<%=request.getContextPath()%>/images/more.png" border="0" width="90"></a></font>

         </td>
         <!--<td width="55"></td>-->
             
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
      
             <tr><td colspan="5" align="right"><font style="font-size:12px;color:black"><b>Displaying Records:&nbsp;<%=ft%></b></font>
    <%if(!pre.equals("")){%>
    <!--<a href="subcatdet.do?method=view_ItemDetail&pr=<%=pre%>&id=<%=id%>"><font size='1' color='black'>Previous</font></a> -->
    <a href="subcatdet.do?method=view_ItemDetail&pr=<%=pre%>&id=<%=id%>&pa=<%=pa%>"><font size='1' color='black'>Previous</font></a>
    <%}
    if(!nxt.equals("")){%>
   <!--<a href="subcatdet.do?method=view_ItemDetail&pr=<%=nxt%>&id=<%=id%>"><font size='1' color='black'>Next</font></a> -->
   <a href="subcatdet.do?method=view_ItemDetail&pr=<%=nxt%>&id=<%=id%>&pa=<%=pa%>"><font size='1' color='black'>Next</font></a>
   <%}%>
   </td></tr>          
   </table>
                </td></tr></table>
                </td>
                </tr>
                </table></td></tr>
                          <tr>
          <td><%@include file="/footer.jsp"%></td>
                        </tr>  
                    </table>
                </td>
            </tr>
                  
        </table>
    </body>
</html>
