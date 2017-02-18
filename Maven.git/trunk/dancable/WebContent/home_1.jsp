<%-- 
    Document   : home
    Created on : May 25, 2013, 1:33:50 PM
    Author     : kapil
--%>
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
        <title>Danceables</title>
        <script language="javascript" src="css_js/resolution.js"></script>
        <link rel="stylesheet" type="text/css" href="css/change.css" />
        <script language="javascript" src="css/menu.js"></script>
        <script src="<%=request.getContextPath()%>/everyday_stream/swfobject.js" type="text/javascript"></script>
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
item_bean itembe=new item_bean();
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
        <table width="100%" cellspacing="0" cellpadding="0">
         <!--<table align="center">-->
            <tr>
               <!-- <img class="image" src="<%=request.getContextPath()%>/images/homepage/Homepage background.png" width="100%" height="700">-->
                 
                <td>
                    <div id="header">
                    <div class="tb">
                        <div id="headdesign">
                       <div class="header1">
                           <img src="<%=request.getContextPath()%>/images/homepage/logo_03.png" width="253">
                               </div>
                            <div class="header2">
                                <div class="user"><%//@include file="/user_login/user_head.jsp"%></div>
                                <div class="header2_2"><%@include file="/top_menu.jsp"%></div>
                            </div>
                             <!--<td align="left" class="cel"><img class="imag" src="<%=request.getContextPath()%>/images/homepage/menu-strip.png" width="750"></td>-->
                        </div>
                    </div>
                    </div>
                    <!--<img class="image1" src="<%=request.getContextPath()%>/images/homepage/logo_03.png">--></td>
                <!--<td><img class="imag" src="<%=request.getContextPath()%>/images/homepage/menu-strip.png"></td>-->
                     <!--<td><%@include file="/top_menu.jsp"%></td>-->
                
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
                            <td class="pad" width="34%">
                                <table class="shadow" align="center">
                                    <tr><td class="fnt"><font color="#3EAAAA" size="2">LIVE</font> <font size="2">EVERYDAY STREAMING</font></td></tr>
                                     <tr><td bgcolor="white" id="player_0"><span onclick="play('<%=0%>')" style="cursor: pointer">I'll Be Seeing You</span></td></tr>
                                    <div id="innr" style="display: none">
                                    <div id="mp3player"></div>
<script type="text/javascript">
	var so = new SWFObject("mpw_player.swf", "swfplayer", "300", "27", "9", "#FFFFFF");
	so.addVariable("mp3", "<%=request.getContextPath()%>/includes/02 Plie and a Jump and a Stretch.mp3");
	so.addVariable("autoplay","true");
	so.addVariable("effect","false");
	so.addVariable("backcolor","b54645");
	so.addVariable("frontcolor","ffffff");
	so.addVariable("fullscreen","false");
	so.addParam("allowFullScreen","true");
so.addParam("song_title","hello");
	so.write("mp3player");
</script>  
</div>
                                    <tr><td bgcolor="white" id="player_1"><span onclick="play('<%=1%>')" style="cursor: pointer">Just Jumps</span></td></tr>
                                    <tr><td bgcolor="white" id="player_2"><span onclick="play('<%=2%>')" style="cursor: pointer">City Class</span></td></tr>
                                    <tr><td bgcolor="white" id="player_3"><span onclick="play('<%=3%>')" style="cursor: pointer">Pointe to Pointe</span></td></tr>
                                    <input type="hidden" name="counter" value="<%=1%>" id="count">
                                    <input type="hidden" name="ply" value="" id="ply">
                                    <input type="hidden" name="plycnt" value="" id="plycnt">
                                </table>
                        <div>
                                    <table style="padding-top: 20px" cellspacing="0" cellpadding="0">
                                        <tr><td><img src="<%=request.getContextPath()%>/images/homepage/new release.png"</td></tr>
                                        <tr>
                                            <td>
                                                <img src="<%=request.getContextPath()%>/images/homepage/image-4.png" width="100" height="110">
                                                <br>Your Price<br><font color="#BD2828" style="font-weight: bold">$25</font>
                                            </td>
                                            <td>
                                                <img src="<%=request.getContextPath()%>/images/homepage/image-5.png" width="100" height="110">
                                                <br>Your Price<br><font color="#BD2828" style="font-weight: bold">$25</font>
                                            </td>
                                        </tr>
                                    </table>
                        </div>
                            </td>
                            <td class="pad" width="32%">
                                <table border="0">
                                    <tr><td colspan="2">
                                <img src="<%=request.getContextPath()%>/images/homepage/browse.png">
                                </td></tr>
                                    
                                    <tr><td width="110">
                                <img src="<%=request.getContextPath()%>/images/homepage/image-1.png" width="100" height="110">
                                </td>
                                <td class="fnt2"><font color="#3EAAAA">Ballet Class Music</font><br>
                                    <font class="fnt3"><a href="<%=request.getContextPath()%>/prmusic.do?id=4&id1=5&pa=a&pr=1&pr1=1&method=view_Item_Detail" class="a">click here for cd ballet</a></font>
                                </td></tr>
                                    
                                    <tr><td>
                                <img src="<%=request.getContextPath()%>/images/homepage/image-2.png" width="100" height="110">
                                </td>
                                <td class="fnt2"><font color="#3EAAAA">Written Ballet Music</font><br>
                                    <font class="fnt3"><a href="<%=request.getContextPath()%>/subcatdet.do?id=1&pa=a&pr=1&method=view_ItemDetail" class="a">click here for written ballet cd</a></font>
                                </td></tr></tr>
                                    
                                    <tr><td>
                                <img src="<%=request.getContextPath()%>/images/homepage/image-3.png" width="100" height="110">
                                </td><td class="fnt2"><font color="#3EAAAA">Music for Pre-Ballet class</font><br>
                                    <font class="fnt3"><a href="<%=request.getContextPath()%>/subcatdett.do?id=2&pa=a&pr=1&method=view_ItemDetail" class="a">click here for cd for pre-ballet</a></font>
                                </td></tr></tr>
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
