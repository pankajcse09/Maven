<%-- 
    Document   : audioList
    Created on : Dec 27, 2013, 3:29:51 PM
    Author     : kapil
--%>

<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8 />

<!-- Website Design By: www.happyworm.com -->
<title>Demo : jPlayer as an audio playlist player</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link href="<%=request.getContextPath()%>/skin/pink.flag/jplayer.pink.flag.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="http://radiosmasher.com/js/main.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.jplayer.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jplayer.playlist.min.js"></script>
<script type="text/javascript">
//<![CDATA[
$(document).ready(function(){

	new jPlayerPlaylist({
		jPlayer: "#jquery_jplayer_1",
		cssSelectorAncestor: "#jp_container_1"
	}, [
		{
			title:"Cro Magnon Man",
			mp3:"http://www.vizualrecords.com/wordpress/wp-content/audio/VIZLP1-01_128.mp3"
		},
		{
			title:"Your Face",
			mp3:"http://www.vizualrecords.com/wordpress/wp-content/audio/VIZLP1-10_128.mp3"
		},
		{
			title:"Cyber Sonnet",
			mp3:"http://www.jplayer.org/audio/mp3/TSP-07-Cybersonnet.mp3"
		},
		{
			title:"Tempered Song",
			mp3:"http://www.jplayer.org/audio/mp3/Miaow-01-Tempered-song.mp3"
		},
		{
			title:"Hidden",
			mp3:"http://www.jplayer.org/audio/mp3/Miaow-02-Hidden.mp3"
		},
		{
			title:"Lentement",
			free:true,
			mp3:"http://www.jplayer.org/audio/mp3/Miaow-03-Lentement.mp3"
		},
		{
			title:"Lismore",
			mp3:"http://www.jplayer.org/audio/mp3/Miaow-04-Lismore.mp3"
		},
		{
			title:"The Separation",
			mp3:"http://www.jplayer.org/audio/mp3/Miaow-05-The-separation.mp3"
		},
		{
			title:"Beside Me",
			mp3:"http://www.jplayer.org/audio/mp3/Miaow-06-Beside-me.mp3"
		},
		{
			title:"Bubble",
			free:true,
			mp3:"http://www.jplayer.org/audio/mp3/Miaow-07-Bubble.mp3"
		},
		{
			title:"Stirring of a Fool",
			mp3:"http://www.jplayer.org/audio/mp3/Miaow-08-Stirring-of-a-fool.mp3"
		},
		{
			title:"Partir",
			free: true,
			mp3:"http://www.jplayer.org/audio/mp3/Miaow-09-Partir.mp3"
		},
		{
			title:"Thin Ice",
			mp3:"http://www.jplayer.org/audio/mp3/Miaow-10-Thin-ice.mp3"
		}
	], {
		swfPath: "/js",
		supplied: "mp3",
		wmode: "window",
		smoothPlayBar: true,
		keyEnabled: true
	});
});
//]]>
</script>
</head>
<body>

		<div id="jquery_jplayer_1" class="jp-jplayer"></div>

		<div id="jp_container_1" class="jp-audio">
			<div class="jp-type-playlist">
				<div class="jp-gui jp-interface">
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
					<div class="jp-progress">
						<div class="jp-seek-bar">
							<div class="jp-play-bar"></div>

						</div>
					</div>
					<div class="jp-volume-bar">
						<div class="jp-volume-bar-value"></div>
					</div>
					<div class="jp-current-time"></div>
					<div class="jp-duration"></div>
					<ul class="jp-toggles">
						<li><a href="javascript:;" class="jp-shuffle" tabindex="1" title="shuffle">shuffle</a></li>
						<li><a href="javascript:;" class="jp-shuffle-off" tabindex="1" title="shuffle off">shuffle off</a></li>
						<li><a href="javascript:;" class="jp-repeat" tabindex="1" title="repeat">repeat</a></li>
						<li><a href="javascript:;" class="jp-repeat-off" tabindex="1" title="repeat off">repeat off</a></li>
					</ul>
				</div>
				<div class="jp-playlist">
					<ul>
						<li></li>
					</ul>
				</div>
				<div class="jp-no-solution">
					<span>Update Required</span>
					To play the media you will need to either update your browser to a recent version or update your <a href="http://get.adobe.com/flashplayer/" target="_blank">Flash plugin</a>.
				</div>
			</div>
		</div>
                
                <div>
                    <object type="application/x-shockwave-flash"
data="http://musicplayer.sourceforge.net/button/musicplayer_f6.swf?&song_url=http://www.inttrack.com/dancables/everyday_stream/073357enncvg7vpp0klcomriu9o7san_2-Tendu-from-1st.mp3&b_bgcolor=cccccc&b_fgcolor=666666&b_colors=ff0000,0000ff,00ff00,000000&buttons=loading_icon.swf,play_icon.swf,stop_icon.swf,error_icon.swf&" 
width="17" height="17">
<param name="movie" 
value="http://musicplayer.sourceforge.net/button/musicplayer_f6.swf?&song_url=http://www.inttrack.com/dancables/everyday_stream/073357enncvg7vpp0klcomriu9o7san_2-Tendu-from-1st.mp3&b_bgcolor=cccccc&b_fgcolor=666666&b_colors=ff0000,0000ff,00ff00,000000&buttons=loading_icon.swf,play_icon.swf,stop_icon.swf,error_icon.swf&" />
<img src="noflash.gif" 
width="17" height="17" alt="" />
</object>

                </div>
</body>

</html>
