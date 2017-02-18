function checkNumeric()
    {
   // Get ASCII value of key that user pressed
   var key = window.event.keyCode;
   // Was key that was pressed a numeric character (0-9)?
   if ( key > 47 && key < 58 )
      return; // if so, do nothing
      else
      window.event.returnValue = null; // otherwise, 
	                               // discard character
 }     

function checkNumericDot()
    {
   // Get ASCII value of key that user pressed
   var key = window.event.keyCode;
   // Was key that was pressed a numeric character (0-9)?
   if ( (key > 47 && key < 58) || key==46){      
      return; // if so, do nothing
     }
      else{
      window.event.returnValue = null; // otherwise, 
	                               // discard character
     }
 }