function Clickheretoprint(a)
{ 
  var disp_setting="toolbar=yes,location=no,directories=yes,menubar=yes,"; 
  disp_setting+="scrollbars=yes,width='800', height='512', left=25, top=25"; 
  var content_vlue = document.getElementById(a).innerHTML; 
  
   var docprint=window.open("","",disp_setting); 
   docprint.document.open(); 
   docprint.document.write('<html>'); 
   docprint.document.write('<body onLoad="self.print()"><center>');          
   docprint.document.write(content_vlue);          
   docprint.document.write('</center></body></html>'); 
   docprint.document.close(); 
   docprint.focus(); 
}

function printIdCard(a){
  var disp_setting="toolbar=yes,location=no,directories=yes,menubar=yes,";
disp_setting+="scrollbars=yes,width=800, height=700, left=10, top=0";

  var content_vlue = document.getElementById(a).innerHTML;
   var docprint=window.open("","",disp_setting);
   docprint.document.open();
   docprint.document.write('<html>');
   docprint.document.write('<body onLoad="self.print()"><center>');
   docprint.document.write(content_vlue);
   docprint.document.write('</center></body></html>');
   docprint.document.close();
   docprint.focus();
}

function printTcCc(a){
  var disp_setting="toolbar=yes,location=no,directories=yes,menubar=yes,";
  disp_setting+="scrollbars=yes,width='450', height='500', left=0, top=0";
  var content_vlue = document.getElementById(a).innerHTML;
   var docprint=window.open("","",disp_setting);
   docprint.document.open();
   docprint.document.write('<html>');
   docprint.document.write('<body onLoad="self.print()"><center>');
   docprint.document.write(content_vlue);
   docprint.document.write('</center></body></html>');
   docprint.document.close();
   docprint.focus();
}