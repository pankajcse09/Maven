<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     
    </head>
    <body>

    <table  class="navbar" width=100% align="center" bgcolor="#696969" border="0" cellpadding="0" cellspacing="0">
     <tr> 
     
     <td  valign="top" class="menuNormal" width="80" onmouseover="expand(this);" 
      onmouseout="collapse(this);">
      <table><tr><td width="80" height="15" align="center"><font color="#f5f5f5" style="TimesRoman" size="2"><b><center>Registration</center></b></font></td></tr></table>
    
        <div class="menuNormal" width="150">
          <table class="menu" width="150">
               <tr><td height="1"></td></tr>
          
             <tr><td class="menuNormal">
             <html:link action="/set" styleClass="menuitem" target="_top">Set SR.Number</html:link>
            </td></tr>
                <tr><td height="1"></td></tr>
            <tr><td class="menuNormal">
             <html:link action="/streg" styleClass="menuitem" target="_top">Student Registration</html:link>
            </td></tr>
            <tr><td class="menuNormal">
             <html:link action="/sacad" styleClass="menuitem" target="_top">Enter Student Academic Detail</html:link>
            </td></tr>
            
            <tr><td class="menuNormal">
             <html:link action="/ecd" styleClass="menuitem" target="_top">Edit Academic Detail</html:link>
            </td></tr>
             <tr><td class="menuNormal">
             <html:link action="/asnf" styleClass="menuitem" target="_top">Assign Fee Book</html:link>
            </td></tr>
            
             <tr><td class="menuNormal">
             <html:link action="/esrec" styleClass="menuitem" target="_top">Edit Student Record</html:link>
            </td></tr>
             
                <tr><td height="1"></td></tr>
            <tr><td class="menuNormal">
              <html:link action="/usr" styleClass="menuitem" target="_top">Promote Student</html:link> 
            </td></tr>
             <tr><td class="menuNormal">
              <html:link action="/list" styleClass="menuitem" target="_top">Student's Detail</html:link> 
            </td></tr>
            <tr><td class="menuNormal">
              <html:link action="/xsu" styleClass="menuitem" target="_top">EX Student's Detail</html:link> 
            </td></tr>
                <tr><td height="1"></td></tr>
                  
            </table>
        </div>
      </td>  
      
      <td width="1"><table align="center"><tr><td><img src="./image/sep.gif" width="1" height="14"></td></tr></table></td>
      
      <td  valign="top" class="menuNormal" width="130" onmouseover="expand(this);" 
      onmouseout="collapse(this);">
      <table><tr><td width="130" height="15" align="center"><font color="#f5f5f5" style="TimesRoman" size="2"><b>Expenses Detail</b></font></td></tr></table>
    
        <div class="menuNormal" width="150">
          <table class="menu" width="150">
            <tr><td class="menuNormal">
             <html:link action="/Enter_All_Expenses.do" styleClass="menuitem" target="_top">Enter Expenses</html:link>
            </td></tr>
             <tr><td class="menuNormal">
              <html:link action="/Report1" styleClass="menuitem" target="_top">Expenses Report</html:link> 
            </td></tr>
                  
            </table>
        </div>
      </td>  
    
        
    <td width="1"><table align="center"><tr><td><img src="./image/sep.gif" width="1" height="14"></td></tr></table></td>
    
     <td  valign="top" class="menuNormal" width="130" onmouseover="expand(this);" 
      onmouseout="collapse(this);">
      <table><tr><td width="130" height="15" align="center"><font color="#f5f5f5" style="TimesRoman" size="2"><b>Concession</b></font></td></tr></table>
    
        <div class="menuNormal" width="160">
          <table class="menu" width="160">
              <tr><td class="menuNormal">
             <html:link action="/concs.do" styleClass="menuitem" target="_top">Enter Concession</html:link>
            </td></tr>
            
            </table>
        </div>
      </td>  
      
      <td width="1"><table><tr><td><img src="./image/sep.gif" width="1" height="14"></td></tr></table></td>
      
<td  valign="top" class="menuNormal" width="110" onmouseover="expand(this);" 
      onmouseout="collapse(this);">
      <table align="center"><tr><td width="110" height="15" align="center"><font color="#f5f5f5" style="TimesRoman" size="2"><b><center>Fee Utilities</center></b></font></td></tr></table>
    
        <div class="menuNormal" width="150">
          <table class="menu" width="150">
             <tr><td class="menuNormal">
             <html:link action="/EnterClasses.do" styleClass="menuitem" target="_top">Enter Class</html:link>
            </td></tr>
            <tr><td class="menuNormal">
             <html:link action="/delclass.do" styleClass="menuitem" target="_top">Delete Class</html:link>
            </td></tr>
           <tr><td class="menuNormal">
             <html:link action="/adnf.do" styleClass="menuitem" target="_top">Enter Additional Fee</html:link>
            </td></tr>
             <tr><td class="menuNormal">
             <html:link action="/efeesb.do" styleClass="menuitem" target="_top">Enter Fee Structure</html:link>
            </td></tr>
             <tr><td class="menuNormal">
             <html:link action="/dfst.do?dispfee=dispfee" styleClass="menuitem" target="_top">Display/Update Fee Structure</html:link>
            </td></tr>
             <tr><td class="menuNormal">
             <html:link action="/dfest.do?dispfee=dispfee" styleClass="menuitem" target="_top">Display Fee Structure</html:link>
            </td></tr>
            <tr><td class="menuNormal">
             <html:link action="/finestr.do?dispfine=dispfine" styleClass="menuitem" target="_top">Fine Structure</html:link>
            </td></tr>
             <tr><td class="menuNormal">
             <html:link action="/efch.do?dispfee=dispfee" styleClass="menuitem" target="_top">Enter Fee Chart</html:link>
            </td></tr>
             <tr><td class="menuNormal">
             <html:link action="/dufch.do" styleClass="menuitem" target="_top">Display/Update Fee Chart</html:link>
            </td></tr>
            <tr><td class="menuNormal">
             <html:link action="/etr.do" styleClass="menuitem" target="_top">Enter Bus Fee</html:link>
            </td></tr>
            <tr><td class="menuNormal">
             <html:link action="/dutf.do?dispfee=dispfee" styleClass="menuitem" target="_top">Display/Update Bus Fee</html:link>
            </td></tr>
            
             <tr><td class="menuNormal">
             <html:link action="/sfdisp" styleClass="menuitem" target="_top">Submit School Fee</html:link>
            </td></tr>
            
            <tr><td class="menuNormal">
             <html:link action="/tfdisp" styleClass="menuitem" target="_top">Submit Transport Fee</html:link>
            </td></tr>
            
            <tr><td class="menuNormal">
             <html:link action="/fnexm" styleClass="menuitem" target="_top">Exempt Fine</html:link>
            </td></tr>
            <tr><td class="menuNormal">
             <html:link action="/dfee" styleClass="menuitem" target="_top">Display Fee Records of Student</html:link>
            </td></tr>
            <tr><td class="menuNormal">
              <html:link action="/dfine" styleClass="menuitem" target="_top">Display Fine Record</html:link> 
            </td></tr>
            <tr><td class="menuNormal">
              <html:link action="/totfee" styleClass="menuitem" target="_top">Display Fee Record Per Year</html:link> 
            </td></tr>
            <tr><td class="menuNormal">
              <html:link action="/notsub" styleClass="menuitem" target="_top">Pending Fees</html:link> 
            </td></tr>
                       
            </table>
        </div>
      </td>  
      
      <td width="1"><table align="center"><tr><td><img src="./image/sep.gif" width="1" height="14"></td></tr></table></td>
    
     <td  valign="top" class="menuNormal" width="130" onmouseover="expand(this);" 
      onmouseout="collapse(this);">
      <table><tr><td width="130" height="15" align="center"><font color="#f5f5f5" style="TimesRoman" size="2"><b>Reports</b></font></td></tr></table>
    
        <div class="menuNormal" width="160">
          <table class="menu" width="160">
              <tr><td class="menuNormal">
             <html:link action="/sfr.do" styleClass="menuitem" target="_top">School Fee Report</html:link>
            </td></tr>
             <tr><td class="menuNormal">
              <html:link action="/rwsr" styleClass="menuitem" target="_top">RouteWise Report</html:link> 
            </td></tr>
            
             <tr><td class="menuNormal">
              <html:link action="/hwsr" styleClass="menuitem" target="_top">HouseWise Report</html:link> 
            </td></tr>
             <tr><td class="menuNormal">
              <html:link action="/pdsr" styleClass="menuitem" target="_top">Per Day School Fee report</html:link> 
            </td></tr>
            <tr><td class="menuNormal">
              <html:link action="/pdtr" styleClass="menuitem" target="_top">Per Day Transport Fee report</html:link> 
            </td></tr>
               <tr><td class="menuNormal">
              <html:link action="/cwsfr" styleClass="menuitem" target="_top">ClassWise School Fee Report</html:link> 
            </td></tr>
             <tr><td class="menuNormal">
              <html:link action="/dbk" styleClass="menuitem" target="_top">Day Book</html:link> 
            </td></tr>
            <tr><td class="menuNormal">
              <html:link action="/tdbk" styleClass="menuitem" target="_top">Transport Day Book</html:link> 
            </td></tr>
            </table>
        </div>
      </td>  
   
     </tr>
</table>
    
    </body>
</html>
