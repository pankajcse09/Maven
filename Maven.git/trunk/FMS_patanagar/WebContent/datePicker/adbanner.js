var ddcurpageurl=window.location.toString() //current page url
var bnum=new Number(Math.floor(99999999 * Math.random())+1); //Hostway random num
var showincontentheader=0

var randban=new Array()
randban[0]='<scr'+'ipt language=javascript src="http://a.tribalfusion.com/j.ad?site=DynamicDrive&adSpace=ros&size=468x60&type=horiz&noAd=1&requestID='+((new Date()).getTime() % 2147483648) + Math.random()+'"></scr'+'ipt>'
randban[1]='<a href="http://www.codearena.com/cgi-bin/serve/banners.pl?region=ddtop&mode=CLICK&name=openbanner"><img src="http://www.codingforums.com/opencube.gif" border="0" alt="OpenCube DHTML and CSS menus"></a>'
randban[2]='<iframe src="http://media.fastclick.net/w/get.media?sid=6286&m=1&d=f&v=1.0c&t=s&pageid=1" width=468 height=60 hspace=0 vspace=0 frameborder=0 marginheight=0 marginwidth=0 scrolling=no><a href="http://media.fastclick.net/w/click.here?sid=6286&m=1&pageid=1" target="_top"><img width=468 height=60 src="http://media.fastclick.net/w/get.media?sid=6286&m=1&d=s&v=1.0c&pageid=1" border=0></a></iframe>'
randban[3]='<a href="http://ad.doubleclick.net/jump/N3579.DynamicDrive/B1423445;sz=468x60;ord='+bnum+'?"><img src="http://ad.doubleclick.net/ad/N3579.DynamicDrive/B1423445;sz=468x60;ord='+bnum+'?" border=0 width=468 height=60><br>Hostway- Click here for FREE setup!</a>'
randban[4]='<a href="http://www.dynamicdrive.com/partners.php?id=hs"><img src="http://www.codingforums.com/sponsors/hs.gif" border=0></a>'
randban[5]=''

var bweight=new Array()

bweight[0]=3
bweight[1]=2
bweight[2]=3 //fastclick
bweight[3]=1
bweight[4]=1 //hs
bweight[5]=2


var banner_num=0
var stepbystep=totalweight=bweight[0]

for (ct=1;ct<bweight.length;ct++)
totalweight+=bweight[ct]

var revised_ranban=new Array()
var ran_num=Math.floor(Math.random()*totalweight)

while (banner_num<randban.length){
for (ct=0;ct<bweight[banner_num];ct++)
revised_ranban[revised_ranban.length]=randban[banner_num]
banner_num++
}

if (typeof isfrontpage !="undefined") //if frontpage
document.write('<div id="topbanner" align="center"><scr'+'ipt language=javascript src="http://a.tribalfusion.com/j.ad?site=DynamicDrive&adSpace=ros&size=468x60&type=horiz&pop=0&noAd=1&requestID='+((new Date()).getTime() % 2147483648) + Math.random()+'"></scr'+'ipt></div>');
else if (typeof ismenucategory!="undefined") //if Menu Category page
ismenucategory=1 //do nothing
else if (revised_ranban[ran_num].indexOf("tribal")!=-1 || ddcurpageurl.indexOf("dynamicindex")==-1) //if TF or non script page
document.write('<div id="topbanner" align="center">'+revised_ranban[ran_num]+'</div>')
else
showincontentheader=1

/////Highlight Current Category/////

var testre=/dynamicindex(\d+)/i

if (ddcurpageurl.match && ddcurpageurl.match(testre)!=null){
var catid="#c"+ddcurpageurl.match(testre)[1]
document.write('<style type="text/css">')
document.write(catid+" a{ color: #000;	background: #D7FBBC; text-decoration: none; }\n")
document.write(catid+" a{ color: black; background: #D7FBBC}")
document.write('<\/style>')
}

/////Highlight textarea stuff/////

function highlight(x){
var x=x+1
document.forms[x].elements[0].select()
}