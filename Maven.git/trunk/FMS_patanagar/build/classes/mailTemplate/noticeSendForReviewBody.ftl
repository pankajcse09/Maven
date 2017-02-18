<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Language" content="en-us" />
    <style type="text/css" media="screen">
      /*  common--------------------------------------------------*/
      body { margin: 0px; padding: 0px; font-family: Helvetica, Arial, sans-serif; }
      #Content , #Helpful, #mailTop, #Tertiary { width: 100%; text-align: center;  align: center;}
      /*  Tables--------------------------------------------------*/
      #mailTop { padding: 10px 0px; background:  #1E90FF}
      #mailTop table { color: #fff; background: #1E90FF; margin: 0px auto; }
      #mailTop h1, #mailTop p { margin: 0px auto; padding: 0px 0px; text-align: left; }
      #mailTop p { font-size: 14px; }
      #mailTop h1 { font-family: Helvetica, Arial, sans-serif; font-size: 16px; color: #fff;  }
      #Content table {  margin: 0px auto; }
      #Primary { font-size: 11px; text-align: left;}
      #Primary td#label { font-size: 12px; font-weight: bold; color: #002f80; }
      #Primary a:link, #Primary a:visited,  #Secondary a:link, #Secondary a:visited { color: #000; background: #fff; }
      #Secondary { font-size: 10px; border: 1px solid #000070;}
      #Secondary td#label { font-size: 12px; font-weight: bold; color: #002f80; }
      #Actions { font-size: 10px; border: 1px solid #000070;}
	  #Actions th { font-size: 12px; font-weight: bold; color: #ffffff; border: 1px solid; background: #1E90FF }
	  #Actions td { border: 1px solid }
	  
	  #Actions1 { font-size: 12px; border: 1px solid #ffffff;}
	  #Actions1 th { font-size: 12px; font-weight: bold; color: #ffffff; border: 1px solid; }
	  #Actions1 td { border: 1px solid #ffffff; }
	
	  #isNot { font-size: 10px; border: 1px solid #000070;}
	  #isNot th { font-size: 12px; font-weight: bold; color: #ffffff; border: 1px solid; background: #1E90FF }
	  #isNot td {border: 1px solid }	  
      #cont { font-size: 10px; border: 1px solid #000070;}
      #cont th { font-size: 12px; font-weight: bold; color: #000000; border: 1px solid; background: #1E90FF }
      #cont td { border: 1px solid }
      #prior { font-size: 10px; border: 1px solid #000070;}
      #prior th { font-size: 12px; font-weight: bold; color: #000000; border: 1px solid; background: #002f80 }
      #prior td { border: 1px solid }
      #Tertiary { font-size: 12px; padding: 10px 0px; background:  #FFA500;}
	  #Tertiary table { background: #FFA500; margin: 0px auto; }
	  #Tertiary td#label1 { font-size: 12px; font-weight: bold; color: #fff; background: #FFA500; text-align: left; }
	  #Tertiary a:link, 
	  #Tertiary a:visited { color: #fff;}
	  #Tertiary a:active { color: #000; background: #FFA500; text-decoration: none; }      
      #Helpful table { color: #c2c2c2; background: #fff; margin: 0px auto; }
      #Helpful p {margin: 0px auto; padding: 0px 0px; text-align: left; font-size: 12px; }
      #Helpful a:link, #Helpful a:visited { color: #c2c2c2;  }
    </style>
  </style>
    </head>
  <body>
    <table cellpadding="10" cellspacing="0" width="100%">
      <tbody>
        <tr>
           <td id="mailTop">
            <table cellpadding="0" cellspacing="0" width="800" >
              <tbody>
              <tr><td><h1>Dears,</h1></td> </tr>
                <tr>
                  <td>
                  <h1>The PCN ${internalId} is Sent for Review. You can click on the direct link below for review proces. You have no action to perform.</h1>
                    
                    <br/>
                    <table  border = "1" width="100%" id="Actions1">
						<tr>
							<td nowrap="nowrap" id="label" width="174">PCN :</td>
							<td width="412">
								${internalId}
      						</td> 
                  		</tr>
		                <tr>
		                  	<td valign="top" id="label" width="174">Status :</td>
		                  	<td width="412">
		                  		${internalId}
							</td>
						</tr>
						<tr>
							<td valign="top" id="label" width="174">Originator :</td>
							<td width="412">
								${userName}
							</td>
						</tr>						                  			
                    </table>
                  </td>
                </tr>
              </tbody>
            </table>
            </td>
        </tr>
        </html>
      	<table id="Primary" width="800"  text-align= "center" align="center">
      		<tbody>
    			<!--Main Content Start Here 
				<#include "mailBody.ftl"> -->
			</tbody>
		</table>
			