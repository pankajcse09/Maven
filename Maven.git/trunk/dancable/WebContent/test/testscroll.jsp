<%-- 
    Document   : testscroll
    Created on : Jul 10, 2014, 6:10:27 PM
    Author     : kapil
--%>

<%@page import="java.util.Random"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danceables</title>
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="jquery.mCustomScrollbar.css" />
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="jquery.mCustomScrollbar.concat.min.js"></script>
        
    </head>
    <body>
        <h1>Hello World!</h1>
        <div class="content" style="width:400px;height: 200px">
           

        
        <script>
    (function($){
        $(window).load(function(){
            $.mCustomScrollbar.defaults.scrollButtons.enable=true; //enable scrolling buttons by default
            $.mCustomScrollbar.defaults.axis="yx"; //enable 2 axis scrollbars by default
           
        
    $(".content").mCustomScrollbar({theme:"light-thick"});
				
				
				$(".all-themes-switch a").click(function(e){
					e.preventDefault();
					var $this=$(this),
						rel=$this.attr("rel"),
						el=$(".content");
					switch(rel){
						case "toggle-content":
							el.toggleClass("expanded-content");
							break;
					}
				});
				
			});
		})(jQuery);
</script>

<%
    Random randomGenerator = new Random();
    SimpleDateFormat sdf=new SimpleDateFormat("yyMMddHHmmss");
    java.util.Date dt=new java.util.Date();
    out.println(sdf.format(dt)+randomGenerator.nextInt(1000));
    %>
    </body>
</html>
