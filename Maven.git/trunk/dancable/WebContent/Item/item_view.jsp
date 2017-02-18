<%-- 
    Document   : item_view
    Created on : May 29, 2013, 3:38:42 PM
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
        <title>Danceables</title>
       <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/change.css" />
        <script language="javascript" src="<%=request.getContextPath()%>/css/menu.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/css_js/resolution.js"></script>
         
         
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
     
     <script language="javascript">
             "undefined"==typeof gigya&&(gigya={});"undefined"==typeof gigya.global&&(gigya.global={});"undefined"==typeof gigya.browser&&(gigya.browser={});"undefined"==typeof gigya.utils&&(gigya.utils={});"undefined"==typeof gigya.utils.DOM&&(gigya.utils.DOM={});
(function(){var a=navigator.userAgent.toLowerCase(),b=gigya,c=new Date,d=document.location.href.toString().split("?")[0].split("#")[0].split("/")[2].split(":")[0],e=a.indexOf("win")!=-1,g=a.indexOf("msie")!=-1,h=a.indexOf("msie 6.")!=-1,i=a.indexOf("msie 7.")!=-1,j=a.indexOf("msie 8.")!=-1,k=a.indexOf("msie 9.")!=-1,l=a.indexOf("chrome")!=-1,m=a.indexOf("firefox")!=-1,n=a.indexOf("opera")!=-1,o=navigator.appVersion&&navigator.appVersion.toLowerCase().indexOf("safari")!=-1&&navigator.appVersion.toLowerCase().indexOf("chrome")==
-1,p=navigator.appVersion&&navigator.appVersion.toLowerCase().indexOf("mac")!=-1?true:false,q=window.postMessage!=null&&a.indexOf("msie")==-1,r=window.localStorage!=null,s=document.compatMode=="BackCompat"&&a.indexOf("msie")!=-1,t=document.compatMode=="BackCompat",f;a:{f=["iphone","android","ipad","midp","240x320","blackberry","netfront","nokia","panasonic","portalmmm","sharp","sie-","sonyericsson","symbian","windows ce","benq","mda","mot-","opera mini","philips","pocket pc","sagem","samsung"];for(var u in f)if(a.indexOf(f[u])!=
-1){f=true;break a}f=false}b.localInfo={initTime:c,version:0,pageDomain:d,userAgent:a,isWin:e,isIE:g,isIE6:h,isIE7:i,isIE8:j,isIE9:k,isChrome:l,isFF:m,isOpera:n,isSafari:o,isMAC:p,supportsPostMessage:q,supportsLocalStorage:r,quirksMode:s,backCompat:t,isMobile:f}})();gigya.utils.keyValue={deserialize:function(a,b){var c={};b||(b="&");for(var d=a.split(b),e=0;e<d.length;e++){var g=d[e],h=g.indexOf("=");c[g.substr(0,h)]=decodeURIComponent(g.substr(h+1))}return c}};
gigya.utils.DOM.appendToBody=function(a){document.body&&(document.body.insertBefore&&document.body.firstChild?document.body.insertBefore(a,document.body.firstChild):document.body.appendChild(a))};
"undefined"==typeof gigya.utils.localStorage&&(gigya.utils.localStorage=gigya.localInfo.supportsLocalStorage?{_getAllItems:function(){return window.localStorage},setItem:function(a,b){window.localStorage[a]=b},getItem:function(a){return window.localStorage[a]},removeItem:function(a){window.localStorage.removeItem(a)},implementation:"standard HTML5 window.localStorage"}:gigya.localInfo.isIE6||gigya.localInfo.isIE7?{_start:function(){if(!gigya.utils.localStorage.el){gigya.utils.localStorage.el=document.createElement("div");
gigya.utils.localStorage.el.addBehavior("#default#userData");gigya.utils.DOM.appendToBody(gigya.utils.localStorage.el)}},_getAllItems:function(){this._load();for(var a={},b=this.el.XMLDocument.firstChild.attributes,c=0;c<b.length;c++)a[b[c].name]=b[c].value;return a},_save:function(){try{this._start();this.el.save("gigya_ud")}catch(a){}},_load:function(){try{this._start();this.el.load("gigya_ud")}catch(a){}},setItem:function(a,b){this._load();this.el.setAttribute(a,b);this._save()},getItem:function(a){this._load();
return this.el.getAttribute(a)},removeItem:function(a){this._load();this.el.removeAttribute(a);this._save()},implementation:"userData behavior (IE6/IE7)"}:gigya.localInfo.isFF?{setItem:function(a,b){globalStorage[location.hostname][a]=b},getItem:function(a){return globalStorage[location.hostname][a]},removeItem:function(a){delete globalStorage[location.hostname][a]},implementation:"userData behavior (FF 3.0 upto but not includig 3.5)"}:{setItem:function(){},getItem:function(){},removeItem:function(){},
implementation:"not supported"});
"undefined"==typeof gigya.sso&&(gigya.sso={currentFragment:null,mode:null,requestDomain:null,lid:null,isDomainValid:function(a){var a=a.split("://")[1].split(":")[0],b=_validDomains.split(",");b.push("gigya.com");b.push("localhost");for(var c=0;c<b.length;c++){var d=b[c],e=a.indexOf(d);if(e>=0&&e==a.length-d.length)return true}return false},logout:function(){var a=this.getLogoutURLs();this.removeToken();gigya.sso.invokeCallback({logoutURLs:a})},removeToken:function(){gigya.utils.localStorage.removeItem(this.storageKey);gigya.utils.localStorage.removeItem(this.storageKey+
"_visited");document.cookie=this.storageKey+"_session=0"},getToken:function(){var a=0,b=gigya.utils.localStorage.getItem(this.storageKey),c=parseInt(gigya.utils.localStorage.getItem(this.storageKey+"_exp")),d=document.cookie.indexOf(this.storageKey+"_session=1")!=-1;if(c!=NaN&&(c==0&&!d||c>0&&(new Date).getTime()>c)){this.removeToken();b=null}b?this.markSiteVisited():a=403005;a={errorCode:a,login_token:b};if(c!=null&&!isNaN(c))a.expires_in=c==0?0:(c-(new Date).getTime())/1E3;return a},invokeCallback:function(a){var b=
"",c;for(c in a)a[c]!=null&&(b=b+escape(c+"="+encodeURIComponent(a[c])+"&"));if(gigya.localInfo.supportsPostMessage)window.parent.postMessage(this.callbackID+"="+b,this.requestDomain);else{var b=b+escape("&id="+this.callbackID),d=document.createElement("div"),a=(new Date).getTime(),e=['<object data="https://cdns.gigya.com/GS/swf/eventsBroadcaster2.swf" classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" id="eventsBroadcaster_'+a+'" name="aa_'+a+'" ','codebase="https://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,0,0"width="1" height="1">',
'<param name="FlashVars" value="eventName=loginComplete&action=send&id='+this.lid+"&oEvent="+b+"&domain="+this.requestDomain+'" />','<param name="allowScriptAccess" value="always" /><param name="movie" value="https://cdns.gigya.com/GS/swf/eventsBroadcaster2.swf" /></object>'].join("");window.setTimeout(function(){d.innerHTML=e;document.body.appendChild(d)},500)}},setToken:function(a,b){a!=null&&gigya.utils.localStorage.setItem(this.storageKey,a);b!=null&&gigya.utils.localStorage.setItem(this.storageKey+
"_exp",b);if(b==0)document.cookie=this.storageKey+"_session=1";a&&this.markSiteVisited()},markSiteVisited:function(){var a=gigya.utils.localStorage.getItem(this.storageKey+"_visited");a||(a="");a=a+(","+this.siteAPIKey);gigya.utils.localStorage.setItem(this.storageKey+"_visited",a)},getLogoutURLs:function(){var a=gigya.utils.localStorage.getItem(this.storageKey+"_visited");if(!a)return[];var b=[],c;for(c in _logoutURLs)a.indexOf(","+c)!=-1&&b.push(_logoutURLs[c]);return b.join(",")},start:function(a,
b){this.mode=a.m;this.requestDomain=a.d;this.lid=a.lid;this.callbackID=a.callbackID;this.siteAPIKey=a.sAPIKey;this.APIKey=b.APIKey;this.storageKey="gig_loginToken_"+this.APIKey;if(window.parent&&this.isDomainValid(this.requestDomain)){var c,d=false;switch(this.mode){case "logout":this.logout();d=true;break;case "removeToken":c=this.removeToken();break;case "getToken":c=this.getToken();break;case "setToken":c=this.setToken(a.lt,a.expiration)}d||this.invokeCallback(c)}},checkFragment:function(){var a=
document.location.href,b;if(a.indexOf("#")!=-1){var c=a.split("?")[1].split("#")[0];b=a.split("#")[1];b!=gigya.sso.currentFragment&&gigya.sso.start(gigya.utils.keyValue.deserialize(b),gigya.utils.keyValue.deserialize(c))}gigya.sso.currentFragment=b;window.setTimeout(gigya.sso.checkFragment,200)}});
!document.readyState&&document.body||"interactive"==document.readyState||"loaded"==document.readyState||"complete"==document.readyState?gigya.sso.checkFragment():window.attachEvent?window.attachEvent("onload",gigya.sso.checkFragment):window.addEventListener&&window.addEventListener("load",gigya.sso.checkFragment,!1);

         </script>
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
                             <td>
                                <table border="0" width="100%">
                        <tr>
                            <td valign="top" width="20%" style="padding-left: 50px">
                    <table>
                        <tr>
                <td class="chng" onclick="chang(this)" align="center">
                    <a class="b" href="<%=request.getContextPath()%>/subcatdet.do?id=1&pa=a&pr=1&method=view_ItemDetail"><img src="images/homepage/cd-for-ballet-normal.png" width="200"></a>
                </td>
            </tr>
             <tr>
                <td align="center" id="cl">
                    <a class="b" href="<%=request.getContextPath()%>/subcatdett.do?id=2&pa=a&pr=1&method=view_ItemDetail"><img src="images/homepage/cd-for-pre-ballet-hover.png" width="200"></a>
                </td>
            </tr>
                    </table> 
                </td>
                
                <td style="padding-left: 40px" width="80%">
                    <table border="0" celpadding="0" cellspacing="0" width="88%" align="left">
                      <tr><td colspan="4"><img src="images/homepage/cd-for-pre-ballet-image.png" width="100%"></td></tr> 
                      <tr><td colspan="4" style=" font-size: 20px; color:green; background-color: yellow; font-weight: bold;"><marquee scrolldelay="200" width="">Special Discount on Downloads. Please See!</marquee> </td></tr>
                      
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
             <font style="color:black; font-family: Arial;font-size:12px; font-weight: 600;"><%=itembe.getBrand()%><br>
             <a href="detail_item.do?id=<%=itembe.getItem_id()%>&cl=b">
<IMG SRC="./music_image/<%=itembe.getFilename()%>" width="120" height="120" border="0"></a><br>

<font style="color:olivedrab; font-family: Arial;font-size:11px; font-weight: 600;">Code:&nbsp<%=itembe.getProd_id()%></font><br>
<font style="color:black; font-family: Arial;font-size:11px; font-weight: 600;">Shipment: &nbsp$<%=rf.round_toTwo(itembe.getPrice())%></font><br>
<font style="color:black; font-family: Arial;font-size:11px; font-weight: 600;">Download: &nbsp$<%=rf.round_toTwo(itembe.getDown_price())%></font><br>
  <!--<font style="color:black;font-size:12px; font-weight: 600;">Quantity in Basket:&nbsp<br>--> 
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
