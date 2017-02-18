/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var jToolkit = java.awt.Toolkit.getDefaultToolkit();
 var jScreenSize = jToolkit.getScreenSize();
  
 
 if(jScreenSize.width==1024)
	 {

      

	 	document.write("<link rel='stylesheet' type='text/css' href='css_js/lay.css' />"); 
                
                  
	 }
 else if(jScreenSize.width==1280)
  	{
  
	    document.write("<link rel='stylesheet' type='text/css' href='css_js/lay_1.css' />"); 
	}

else if(jScreenSize.width==1360)
  	{

	    document.write("<link rel='stylesheet' type='text/css' href='css_js/lay_2.css' />"); 
	}
else 
{ 
 
document.write("<link rel='stylesheet' type='text/css' href='css_js/lay_2.css' />"); 
}
