<%-- 
    Document   : home
    Created on : May 25, 2013, 1:33:50 PM
    Author     : kapil
--%>
<%@page import="mc_operat.round_funct"%>
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
        <meta name="viewport" content="width=device-width">
        <title>Danceables</title>
        <script language="javascript" src="css_js/resolution.js"></script>
        <link rel="stylesheet" type="text/css" href="css/change.css" />
        <link href="css/tutorsty.css" rel="stylesheet" type="text/css">
<link href="css/flexcrollstyles.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/flexcroll.js"></script>
        <!--<link rel="stylesheet" type="text/css" href="css/jquery.jscrollpane.css" />-->
        <script language="javascript" src="css/menu.js"></script>
        
<link href="<%=request.getContextPath()%>/skin/pink.flag/jplayer.pink.flag.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.jplayer.min.js"></script>
<script type="text/javascript" src="js/jplayer.playlist.min.js"></script>
<script type="text/javascript" src="js/jquery.jplayer.inspector.js"></script>

<!--<script type="text/javascript" src="js/jquery.mousewheel.js"></script>
<script type="text/javascript" src="js/jquery.jscrollpane.min.js"></script>-->


<style type="text/css">.flexcroll-hide-default {overflow: hidden !important;}</style>

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
      swfPath: "/js",
       supplied: "mp3",
                wmode: "window",
		smoothPlayBar: true,
		keyEnabled: true

};

var myPlaylist = new jPlayerPlaylist(cssSelector, playlist, options);
/*Loop through the JSon array and add it to the playlist*/ 
for (i = 0; i < jsonobj.length; i++) {
     myPlaylist.add(jsonobj[i]);
}
/*
if (!$.browser.webkit) {
              $('.scrol').jScrollPane();
          }
          */
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
        <style>
 /*           .jspTrack
{
    background: #b46868; /* changed from #dde 
    position: relative;
}
 
.jspDrag
{
    background: rgba(0,0,0,0.2); /* changed from #bbd 
    position: relative;
    top: 0;
    left: 0;
    cursor: pointer;
}*/
        </style>
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
                 
                <td style="background:#CFD2D3">
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
                <td background="<%=request.getContextPath()%>/images/homepage/bottom grey.png" width="100%" height="800" valign="top" style="background-repeat: no-repeat">
                    <table border="0" width="75%" align="center" valign="top">
                        <tr align="left" valign="top">
                            <td>
                                <table>
                                    <tr>
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
                                            <b style="font-size: 15px;">Pianist Steven Mitchell with music in Recording and in Print. Music for Dance and Pianists.  </b>
                                            <p class="fnt1"><%=imgbe.getHead()%></p>
                                            <p style="line-height: 22px; text-align: justify;"><%=imgbe.getDesc()%></p>
                                            
<%
boolean tr=false;
tr=(boolean)fd.Read_More(imgbe.getPage_id());
if(tr==true)
{%>
<a href="view_details.do?method=Content_Detail_Data&id=<%=imgbe.getPage_id()%>">

<font style="font-size:10; color:blue; font-weight:bold;">Read More</font></a>
<%}%>
                                        </td>
                                    </tr>
                                    <%}%>
                                </table>
<table><tr>
    <p style="font-size: 16px;font-weight: bold;color: red;">AUDIO now available for DOWNLOAD!!!!!</p>
      </tr></table>
                            </td>
                            <td class="pad" width="34%">
                                <table class="shadow" align="center">
                                    <tr><td><img src="<%=request.getContextPath()%>/images/homepage/second-image.png" width="270"></td></tr>
                                    
                                   <!--<tr><td class="fnt"><font color="#3EAAAA" size="2">LIVE</font> <font size="2">EVERYDAY STREAMING</font></td></tr>
                                     <tr><td>
                      <div id="jp_container_1" class="jp-video jp-video-270p">
			<div class="jp-type-playlist">
				<div id="jquery_jplayer_1" class="jp-jplayer"></div>
				<div class="jp-gui">
					<!--<div class="jp-video-play">
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
                 <% if(evdstrm.size()<=6)
                                    {%>  
                        <div class="jp-playlist">
					<ul>
						<!-- The method Playlist.displayPlaylist() uses this unordered list
						<li></li>
					</ul>
				</div>            
                   <%}else{%>                 
                         <div id="mycustomscroll" class="flexcroll">       
			<div class="jp-playlist">
					<ul>
						<!-- The method Playlist.displayPlaylist() uses this unordered list 
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
            <% if(evdstrm.size()!=0)
                                    {
                                        for(int i=0;i<evdstrm.size();i++)
                                        {
                                          imgbe=(img_bean)evdstrm.get(i);
                                          %>
            <input type="hidden" value="<%=request.getContextPath()%>/everyday_stream/<%=imgbe.getSampleFileName()%>" title="<%=imgbe.getSampleTitle()%>" class="">
            
            <%}}%>
        </div>
    </div>
                                         </td></tr>-->
            
                                
                                </table>   
        
                            </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2"><img src="<%=request.getContextPath()%>/images/homepage/outdoor-image.png" width="695" height="400"></td>
                                    </tr>
                                </table>
                            </td>
                            <td class="pad" width="32%">
                                <table border="0">
                                    <tr><td colspan="2">
                                <img src="<%=request.getContextPath()%>/images/homepage/browse.png">
                                </td></tr>
                                    
                                    <tr><td width="110">
                                <img src="<%=request.getContextPath()%>/images/homepage/image-1.png" width="100" height="110">
                                </td>
                                <td class="fnt2"><!--<font color="#3EAAAA">Ballet Class Music</font><br>-->
                                    <font class="fnt3"><a href="<%=request.getContextPath()%>/subcatdet.do?id=1&pa=a&pr=1&method=view_ItemDetail" class="a">click here for CDs</a></font>
                                </td></tr>
                                    
                                    <tr><td>
                                <img src="<%=request.getContextPath()%>/images/homepage/written-ballet-music.png" width="100" height="110">
                                </td>
                                <td class="fnt2"><!--<font color="#3EAAAA">Written Ballet Music</font><br>-->
                                    <font class="fnt3"><a href="<%=request.getContextPath()%>/prmusic.do?id=4&id1=5&pa=a&pr=1&pr1=1&method=view_Item_Detail" class="a">click here for written ballet Music</a></font>
                                </td></tr>
                                    
                                    <tr><td>
                                <img src="<%=request.getContextPath()%>/images/homepage/OnYourMark-100 (1).jpg" width="100" height="110">
                                </td><td class="fnt2"><!--<font color="#3EAAAA">Music for Pre-Ballet class</font><br>-->
                                <font class="fnt3"><a href="<%=request.getContextPath()%>/subcatdett.do?id=2&pa=a&pr=1&method=view_ItemDetail" class="a">click here for DVDs</a></font>
                                </td></tr>
                                    <tr><td colspan="2"><div id="replace">
                                    <table width="100%" style="padding-top: 20px" cellspacing="0" cellpadding="0" border="0">
                                        <tr><td colspan="2"><img src="<%=request.getContextPath()%>/images/homepage/new release.png"></td></tr>
                                        
                                                                                             
 <%
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
     
         <td style="padding-bottom: 30px" width="50%" align="center">
             <font style="color:black;font-size:10px; font-weight: 600;"><%=itembe.getBrand()%><br>
            
<IMG SRC="./music_image/<%=itembe.getFilename()%>" width="120" height="120" border="0"><br>

<!--<font style="color:black;font-size:12px; font-weight: 600;">Code:&nbsp<%=itembe.getProd_id()%></font><br>-->
<font style="color:black;font-size:12px; font-weight: 600;">Your Price:<br/> &nbsp$<%=rf.round_toTwo(itembe.getPrice())%></font><br>
<a href="detailItem.do?id=<%=itembe.getItem_id()%>&ch=nr"><img  src="<%=request.getContextPath()%>/images/more.png" border="0" width="90"></a></font>

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
      
             <tr><td colspan="2" align="right"><font style="font-size:12px;color:black"><b>Displaying Records:&nbsp;<%=ft%></b></font>
    <%if(!pre.equals("")){%>
    <span onclick="showRelItem('<%=pre%>')" style="cursor: pointer"><font size='1' color='black'>Previous</font></span>
    <%}
    if(!nxt.equals("")){%>
   <span onclick="showRelItem('<%=nxt%>')" style="cursor: pointer"><font size='1' color='black'>Next</font></span>
   <%}%>
   </td></tr>
    </table>
   
                        </div></td></tr>
                                </table>
                            </td>
                        </tr>
                        
                      <tr><td colspan="3"><%@include file="/footer.jsp"%></td></tr>
                    </table>
                </td>
            </tr>
        </table>
    </body>
</html>
