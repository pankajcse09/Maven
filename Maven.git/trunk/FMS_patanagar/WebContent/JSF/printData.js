function Clickheretoprint(a)
{ 
  var disp_setting='toolbar=yes,location=no,directories=yes,menubar=yes,'; 
  disp_setting+='scrollbars=yes,width=800, height=512, left=25, top=25'; 
  var content_vlue = document.getElementById(a).innerHTML; 
  
   var docprint=window.open("","",disp_setting); 
   docprint.document.open(); 
   docprint.document.write('<html>'); 
   docprint.document.write('<body onLoad="self.print();window.close();"><center>');          
   docprint.document.write(content_vlue);          
   docprint.document.write('</center></body></html>'); 
   docprint.document.close(); 
   docprint.focus(); 
}

function Clicktoprint(a)
{ 
    winWidth = 800; // sets a default width for browsers who do not understand screen.width below
winheight = 512; // ditto for height

if (screen){ // weeds out older browsers who do not understand screen.width/screen.height
   winWidth = screen.width;
   winHeight = screen.height;
}
  var disp_setting='toolbar=yes,location=no,directories=yes,menubar=yes,'; 
  disp_setting+='scrollbars=yes,width='+winWidth+',height='+winHeight+', left=25, top=25'; 
  var content_vlue = document.getElementById(a).innerHTML; 
  
   var docprint=window.open("","",disp_setting); 
   docprint.document.open(); 
   docprint.document.write('<html>'); 
   docprint.document.write('<body onLoad="self.print();window.close();"><center>');          
   docprint.document.write(content_vlue);          
   docprint.document.write('</center></body></html>'); 
   docprint.document.close(); 
   docprint.focus(); 
}


function printIdCard(a){
  var disp_setting="toolbar=yes,location=no,directories=yes,menubar=yes,";
  disp_setting+="width='700', height='400',scrollbars=yes,left=0, top=0";
  var content_vlue = document.getElementById(a).innerHTML;
   var docprint=window.open("","",disp_setting);
   docprint.document.open();
   docprint.document.write('<html>');
   docprint.document.write('<body onLoad="self.print();window.close();"><center>');
   docprint.document.write(content_vlue);
   docprint.document.write('</center></body></html>');
   docprint.document.close();
   docprint.focus();
}
function printFeeReceipt(a){
   winWidth = 800; // sets a default width for browsers who do not understand screen.width below
winheight = 512; // ditto for height

if (screen){ // weeds out older browsers who do not understand screen.width/screen.height
   winWidth = screen.width;
   winHeight = screen.height;
}
  var disp_setting='toolbar=yes,location=no,directories=yes,menubar=yes,'; 
  disp_setting+='scrollbars=yes,width='+winWidth+',height='+winHeight+', left=0, top=0'; 
  var content_vlue = document.getElementById(a).innerHTML;
   var docprint=window.open("","",disp_setting);
   docprint.document.open();
   docprint.document.write('<html>');
   docprint.document.write('<body onLoad="self.print();window.close();" width="100%">');
   docprint.document.write(content_vlue);
   docprint.document.write('</body></html>');
   docprint.document.close();
   docprint.focus();
}

function printStudLadder(a){
   winWidth = 800; // sets a default width for browsers who do not understand screen.width below
winheight = 512; // ditto for height

if (screen){ // weeds out older browsers who do not understand screen.width/screen.height
   winWidth = screen.width;
   winHeight = screen.height;
}
  var disp_setting='toolbar=yes,location=no,directories=yes,menubar=yes,'; 
  disp_setting+='scrollbars=yes,width='+winWidth+',height='+winHeight+', left=0, top=0'; 
  var content_vlue = document.getElementById(a).innerHTML;
   var docprint=window.open("","",disp_setting);
   docprint.document.open();
   docprint.document.write('<html>');
   docprint.document.write('<body onLoad="self.print()" width="100%">');
   docprint.document.write(content_vlue);
   docprint.document.write('</body></html>');
   docprint.document.close();
   docprint.focus();
}

function printTcCc(a){
  var disp_setting="toolbar=yes,location=no,directories=yes,menubar=yes,";
  disp_setting+="scrollbars=yes,width='460', height='600', left=0, top=0";
  var content_vlue = document.getElementById(a).innerHTML;
   var docprint=window.open("","",disp_setting);
   docprint.document.open();
   docprint.document.write('<html>');
   docprint.document.write('<body onLoad="self.print();window.close();"><center>');
   docprint.document.write(content_vlue);
   docprint.document.write('</center></body></html>');
   docprint.document.close();
   docprint.focus();
}


function printRegis(a){
  var disp_setting="toolbar=yes,location=no,directories=yes,menubar=yes,";
  disp_setting+="width='700', height='400',scrollbars=yes,left=0, top=0";
  var content_vlue = document.getElementById(a).innerHTML;
   var docprint=window.open("","",disp_setting);
   docprint.document.open();
   docprint.document.write('<html>');
   docprint.document.write('<body onLoad="self.print();window.close();"><center>');
   docprint.document.write('<table align="center" width="100%" cellspacing="5" cellpadding="5" bgcolor="#A89263" style="border-collapse:collapse;border:2px solid black"><tr><td>');
   docprint.document.write('<table align="center" width="100%" border="1" style="border-collapse:collapse;border:1px solid black">');
   docprint.document.write('<tr><td align="center" style="border-collapse:collapse;border:1px solid black">');
   docprint.document.write('<font style="font-size:15"><b>Surajmal Laxmi Devi Sawarthia Educational Trusts Group of Instiutions </b></font>');
   docprint.document.write('</td></tr>');
   docprint.document.write('<tr><td align="center" style="border-collapse:collapse;border:1px solid black">');
   docprint.document.write('<font style="font-size:12"><b>ISO CERTIFIED INSTIUTE</b></font>');
   docprint.document.write('</td></tr>');
   docprint.document.write('<tr><td align="center" style="border-collapse:collapse;border:1px solid black">');
   docprint.document.write('<font style="font-size:12"><b>SIROLLY ,KICHHA,DISTT.-U.S.NAGAR, UTTRAKHAND-263148</b></font>');
   docprint.document.write('</td></tr>');
   docprint.document.write('<tr><td align="center" style="border-collapse:collapse;border:1px solid black">');
   docprint.document.write('<font style="font-size:14"><b>Tel/Fax:-05944-263022,263024,Mob:9410334141.Website:www.surajmalkichha.com Email:slsetgroup@gmail.com</b></font>');
   docprint.document.write('</td></tr>');
   docprint.document.write('</table>');
   docprint.document.write('</td></tr>');
   docprint.document.write('<tr><td>');
   docprint.document.write(content_vlue);
    docprint.document.write('</td></tr>');
   docprint.document.write('</table>');
   docprint.document.write('</center></body></html>');
   docprint.document.close();
   docprint.focus();
}