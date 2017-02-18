<%-- 
    Document   : video_test
    Created on : Jun 13, 2013, 2:13:02 PM
    Author     : kapil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danceables</title>
    </head>
    <body>
        <div>
            <object classid="clsid:d27cdb6e-ae6d-11cf-96b8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/
cabs/flash/swflash.cab#version=7,0,0,0" width="400" height="300" 
id="flashvideoplayer.swf" align="middle">
         <param name="allowScriptAccess" value="sameDomain">
         <param name="movie" 
                  value="<%=request.getContextPath()%>/test/BannerSnack-ad-336x280.swf?
                  flv=<%=request.getContextPath()%>/test/Dance india dance season 2 dharmesh (19th dec 2009).flv">
         <param name="quality" value="high">
         <param name="bgcolor" value="#ffffff">
<embed src="<%=request.getContextPath()%>/test/BannerSnack-ad-336x280.swf
                  flv=<%=request.getContextPath()%>/test/Dance india dance season 2 dharmesh (19th dec 2009).flv" quality="high" bgcolor="#ffffff" width="400" height="300" name="BannerSnack-ad-336x280.swf" 
align="middle" allowScriptAccess="sameDomain" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer">
</object>
        </div>
    </body>
</html>
