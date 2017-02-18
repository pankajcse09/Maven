<%@taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<html>
    <head>
    <style type="text/css">.t{border-collapse:collapse;border-color:lightblue}</style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">     
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
      <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
           <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
          <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>
      </head>      
    <body>
    <table class="navbar" width="100%" bgcolor="#B0C4DE">
     <tr>    
<td width="50" height="18" valign="middle"><a href="<%=request.getContextPath()%>/fee/FeeMainPage.jsp"><font color="#000080" style="font-family:TimesNewRoman" size="2"><b>Home</b></font></a></td>
<td height="18" align="center" valign="middle"><table><tr><td><img src="./image/sep.gif" width="1" height="18"></td></tr></table></td>
<td valign="bottom"  class="menuNormal" width="50" onmouseover="expand(this);" 
      onmouseout="collapse(this);">
      <table><tr><td width="120" height="18" valign="middle"><font color="#000080" style="font-family:TimesNewRoman" size="2"><b>Add</b></font></td></tr></table>    
        <div class="menuNormal" width="100">
          <table width="150" border="1" class="t" rules="rows">      
            <tr><td class="menuNormal" valign="middle">
              <html:link action="/sacad" styleClass="menuitem" target="_top">Enter Student Academic Detail</html:link>
            </td></tr> 
             <tr><td class="menuNormal" valign="middle">
              <html:link action="/ecd" styleClass="menuitem" target="_top">Edit Academic Detail</html:link>
            </td></tr>             
             <tr><td class="menuNormal" valign="middle">
               <html:link action="/usr" styleClass="menuitem" target="_top">Promote Student</html:link> 
            </td></tr>             
            
            </table>
        </div>
       </td>  
      
        <td height="18" align="center" valign="middle"><table><tr><td><img src="./image/sep.gif" width="1" height="18"></td></tr></table></td>  
<td valign="middle" class="menuNormal" width="100" onmouseover="expand(this);" 
      onmouseout="collapse(this);">
      <table><tr><td width="100" height="18"  valign="middle"><font color="#000080" size="2"><b>Utilities</b></font></td></tr></table>
            <div class="menuNormal" width="100">
          <table width="135" border="1" class="t" rules="rows">
             <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
             <html:link action="/EnterClasses.do" styleClass="menuitem" target="_top">Enter Class</html:link>
            </td></tr> 
             <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
              <html:link action="/delclass.do" styleClass="menuitem" target="_top">Delete Class</html:link>
            </td></tr>    
            <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
             <html:link action="/concs.do" styleClass="menuitem" target="_top">Enter Concession</html:link>
            </td></tr> 
             <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
              <html:link action="/asnf" styleClass="menuitem" target="_top">Assign Fee Book</html:link>
            </td></tr>     
            <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
              <html:link action="/efeesb.do" styleClass="menuitem" target="_top">Enter Fee Structure</html:link>
            </td></tr> 
             <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
              <html:link action="/dfst.do?dispfee=dispfee" styleClass="menuitem" target="_top">Edit Fee Structure</html:link>
            </td></tr>     
            <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
              <html:link action="/finestr.do?dispfine=dispfine" styleClass="menuitem" target="_top">Enter Fine Structure</html:link>
            </td></tr> 
             <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
              <html:link action="/efch.do?dispfee=dispfee" styleClass="menuitem" target="_top">Enter Fee Chart</html:link>
            </td></tr>     
            <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
              <html:link action="/dufch.do" styleClass="menuitem" target="_top">Edit Fee Chart</html:link>
            </td></tr> 
             <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
              <html:link action="/etr.do" styleClass="menuitem" target="_top">Enter Bus Fee</html:link>
            </td></tr>  
           <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
            <html:link action="/dutf.do?dispfee=dispfee" styleClass="menuitem" target="_top">Edit Bus Fee</html:link>
           </td></tr>  
            <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
            <html:link action="/fnexm" styleClass="menuitem" target="_top">Exempt Fine</html:link>
           </td></tr>  
          </table>
        </div>
       </td>     

<td height="18" align="center" valign="middle"><table><tr><td><img src="./image/sep.gif" width="1" height="18"></td></tr></table></td>   
<td  valign="middle" class="menuNormal" width="100" onmouseover="expand(this);" 
      onmouseout="collapse(this);">
      <table><tr><td width="100" height="18"  valign="middle"><font color="#000080" style="font-family:TimesNewRoman" size="2"><b>Submit Fee</b></font></td></tr></table>
         <div class="menuNormal" width="100">
          <table width="135" border="1" class="t" rules="rows">
            <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
            <html:link action="/adnf.do" styleClass="menuitem" target="_top">Enter Additional Fee</html:link>
            </td></tr>
            <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
            <html:link action="/sfdisp" styleClass="menuitem" target="_top">Submit School Fee</html:link>
            </td></tr>      
            <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
            <html:link action="/tfdisp" styleClass="menuitem" target="_top">Submit Transport Fee</html:link>
            </td></tr>      
            </table>
        </div>
       </td>  

       
           <td height="18" align="center" valign="middle"><table><tr><td height="18" align="center" valign="middle"><img src="./image/sep.gif" width="1" height="18"></td></tr></table></td>  
<td valign="bottom"  class="menuNormal" width="70" onmouseover="expand(this);" 
      onmouseout="collapse(this);">
      <table><tr><td width="100" height="18" valign="middle"><font color="#000080" style="font-family:TimesNewRoman" size="2"><b>Expenses</b></font></td></tr></table>    
        <div class="menuNormal" width="100">
          <table width="128" border="1" class="t" rules="rows">
             <tr><td class="menuNormal" valign="middle">
              <a href="<%=request.getContextPath()%>/unit_test.do" class="menuitem">Enter Expenses</a>
            </td></tr>            
             <tr><td class="menuNormal" valign="middle">
              <a href="<%=request.getContextPath()%>/unit_test_record.do" class="menuitem">Update Expenses</a>
            </td></tr>
            <tr><td class="menuNormal" valign="middle">
              <a href="<%=request.getContextPath()%>/semster_exam.do" class="menuitem">Expenses Report</a>
            </td></tr>           
            </table>
        </div>
      </td> 
       
       
       
       
       
      <td height="18" align="center" valign="middle"><table><tr><td height="18" align="center" valign="middle"><img src="./image/sep.gif" width="1" height="18"></td></tr></table></td>  
<td valign="bottom"  class="menuNormal" width="70" onmouseover="expand(this);" 
      onmouseout="collapse(this);">
      <table><tr><td width="100" height="18" valign="middle"><font color="#000080" style="font-family:TimesNewRoman" size="2"><b>Reports</b></font></td></tr></table>    
        <div class="menuNormal" width="100">
          <table width="128" border="1" class="t" rules="rows">
             <tr><td class="menuNormal" valign="middle">
              <html:link action="/rwsr" styleClass="menuitem" target="_top">RouteWise Report</html:link> 
            </td></tr>            
             <tr><td class="menuNormal" valign="middle">
              <html:link action="/hwsr" styleClass="menuitem" target="_top">HouseWise Report</html:link> 
            </td></tr>
            <tr><td class="menuNormal" valign="middle">
              <html:link action="/pdsr" styleClass="menuitem" target="_top">Per Day School Fee report</html:link> 
            </td></tr>   
        <tr><td class="menuNormal" valign="middle">
              <html:link action="/pdtr" styleClass="menuitem" target="_top">Per Day Transport Fee report</html:link> 
            </td></tr>   
            <tr><td class="menuNormal" valign="middle">
              <html:link action="/dbk" styleClass="menuitem" target="_top">Day Book</html:link> 
            </td></tr>   
            <tr><td class="menuNormal" valign="middle">
              <html:link action="/tdbk" styleClass="menuitem" target="_top">Transport Day Book</html:link> 
            </td></tr>   
            <tr><td class="menuNormal" valign="middle">
              <html:link action="/cwsfr" styleClass="menuitem" target="_top">ClassWise School Fee Report</html:link> 
            </td></tr>   
            
            </table>
        </div>
      </td>   
        <td height="18" align="center" valign="middle"><img src="./image/sep.gif" width="1" height="18"></td>
      <td width="50" height="18" align="center" valign="middle"><a href="<%=request.getContextPath()%>/Logout.do?method=logout">
<font color="#000080" style="font-family:TimesNewRoman" size="2"><b>Logout</b></font></a></td></tr>
</table>    
</body>
</html>
