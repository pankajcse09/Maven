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
<table class="navbar" width="100%" bgcolor="#B0C4DE"><tr>    
<td height="18" valign="middle"><a href="<%=request.getContextPath()%>/fee/FeeMainPage.jsp"><font color="#000080" style="font-family:TimesNewRoman" size="2"><b><center>Home</center></b></font></a></td>
<td height="18" align="center" valign="middle"><table><tr><td><img src="./image/sep.gif" width="1" height="18"></td></tr></table></td>
<td height="18" valign="middle"><a href="<%=request.getContextPath()%>/regis.jsp"><font color="#000080" style="font-family:TimesNewRoman" size="2"><b><center>Registration</center></b></font></a></td>
<!--<td height="18" align="center" valign="middle"><table><tr><td><img src="./image/sep.gif" width="1" height="18"></td></tr></table></td>
<td valign="bottom"  class="menuNormal" width="120" onmouseover="expand(this);" onmouseout="collapse(this);">
      <table><tr><td width="120" height="18" valign="middle"><font color="#000080" style="font-family:TimesNewRoman" size="2"><b><center>Fee Structure</center></b></font></td></tr></table>    
        <div class="menuNormal" width="100">
          <table width="150" border="1" class="t" rules="rows">      
            <tr><td class="menuNormal" valign="middle">
            <html:link action="/EnterFeeHeads" styleClass="menuitem" target="_top">Add Fee Head</html:link>
            </td></tr>
            <tr><td class="menuNormal" valign="middle">
            <html:link action="/DisplayHeadsList" styleClass="menuitem" target="_top">Display Fee Heads</html:link>
            </td></tr> 
              
        <!--    <tr><td class="menuNormal" valign="middle">
            <html:link action="/DefineConcessions" styleClass="menuitem" target="_top">Define Concessions</html:link>
            </td></tr> 
           </table>
        </div>
       </td>-->
 <!--    <td height="18" align="center" valign="middle"><table><tr><td><img src="./image/sep.gif" width="1" height="18"></td></tr></table></td>
<td valign="bottom"  class="menuNormal" width="120" onmouseover="expand(this);" 
      onmouseout="collapse(this);">
      <table><tr><td width="120" height="18" valign="middle"><font color="#000080" style="font-family:TimesNewRoman" size="2"><b><center>Student Utility</center></b></font></td></tr></table>    
        <div class="menuNormal" width="100">
          <table width="150" class="t" rules="rows">      
          <!--  <tr><td class="menuNormal" valign="middle">
              <html:link action="/sacad" styleClass="menuitem" target="_top">Enter Student Academic Detail</html:link>
            </td></tr> -->
           <!--  <tr><td class="menuNormal" valign="middle">
              <html:link action="/ecd" styleClass="menuitem" target="_top">Enter/Edit Academic Detail</html:link>
            </td></tr>      -->        
           <!--  <tr><td class="menuNormal" valign="middle">
               <html:link action="/usr" styleClass="menuitem" target="_top">Promote Student</html:link> 
            </td></tr>            -->
        <!--     </table>
        </div>
       </td>  -->
      
        <td height="18" align="center" valign="middle"><table><tr><td><img src="./image/sep.gif" width="1" height="18"></td></tr></table></td>  
<td valign="middle" class="menuNormal" width="100" onmouseover="expand(this);" onmouseout="collapse(this);">
      <table><tr><td height="18" valign="middle"><font color="#000080" size="2"><b><center>Utilities</center></b></font></td></tr></table>
            <div class="menuNormal">       
          <table width="135" class="t" rules="rows">
            <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">            
             <html:link action="/Add_Subject.do" styleClass="menuitem" target="_top">Add Subject</html:link>
            </td></tr>    
            <!--<tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">            
             <html:link action="/Add_Class_Type.do" styleClass="menuitem" target="_top">Add Class Type</html:link>
            </td></tr>--> 
             <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
             <html:link action="/Add_Class_Fee.do" styleClass="menuitem" target="_top">Add Class Fee</html:link>
            </td></tr> 
               <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
             <html:link action="/Edit_Class_Fee.do" styleClass="menuitem" target="_top">Edit Class Fee</html:link>
            </td></tr>
             <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
             <html:link action="/EnterClasses.do" styleClass="menuitem" target="_top">Enter Class</html:link>
            </td></tr> 
             <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
              <html:link action="/delclass.do" styleClass="menuitem" target="_top">Delete Class</html:link>
            </td></tr>    
             <tr><td class="menuNormal" valign="middle">
            <html:link action="/EnterFeeHeads" styleClass="menuitem" target="_top">Add Fee Head</html:link>
            </td></tr>
            <tr><td class="menuNormal" valign="middle">
            <html:link action="/disphd" styleClass="menuitem" target="_top">Display Fee Heads</html:link>
            </td></tr> 
            <!--<tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
             <html:link action="/sr.do" styleClass="menuitem" target="_top">Set Receipt No.</html:link>
            </td></tr> 
           <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
             <html:link action="/concs.do" styleClass="menuitem" target="_top">Enter Concession</html:link>
            </td></tr> 
             <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
              <html:link action="/asnf" styleClass="menuitem" target="_top">Assign Fee Book</html:link>
            </td></tr>     
            <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
              <html:link action="/efeesb.do" styleClass="menuitem" target="_top">Enter Fee Structure</html:link>
            </td></tr> -->              
            <!--<tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
              <html:link action="/finestr.do?dispfine=dispfine" styleClass="menuitem" target="_top">Enter Fine Structure</html:link>
            </td></tr>-->
         <!-- <tr><td class="menuNormal" valign="middle">
            <html:link action="/enterfeechartDyn" styleClass="menuitem" target="_top">Enter Fee Chart</html:link>
            </td></tr> 
             <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
              <html:link action="/efch.do?dispfee=dispfee" styleClass="menuitem" target="_top">Enter Fee Chart</html:link>
            </td></tr>   
            <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
              <html:link action="/dufch.do" styleClass="menuitem" target="_top">Enter/Edit Fee Chart</html:link>
            </td></tr> 
            <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
              <html:link action="/dfst.do?dispfee=dispfee" styleClass="menuitem" target="_top">Fee Structure</html:link>
            </td></tr>    
            <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
              <html:link action="/etr.do" styleClass="menuitem" target="_top">Enter Bus Fee</html:link>
            </td></tr>  
           <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
            <html:link action="/dutf.do?dispfee=dispfee" styleClass="menuitem" target="_top">Edit Bus Fee</html:link>
           </td></tr>-->  
           <!-- <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
            <html:link action="/fnexm" styleClass="menuitem" target="_top">Exempt Fine</html:link>
           </td></tr>  -->
          </table>
        </div>
       </td>     
<td height="18" align="center" valign="middle"><table><tr><td><img src="./image/sep.gif" width="1" height="18"></td></tr></table></td>   
<td  valign="middle" class="menuNormal" width="100" onmouseover="expand(this);" onmouseout="collapse(this);">
      <table><tr><td height="18" valign="middle"><font color="#000080" style="font-family:TimesNewRoman" size="2"><b><center>Fee</center></b></font></td></tr></table>
         <div class="menuNormal">
          <table width="135" class="t" rules="rows">
           <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
          <html:link action="/DisplayFeeStruct.do" styleClass="menuitem" target="_top">Display Fee Struct.</html:link>
          </td></tr>
          <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
          <html:link action="/FeeReceipt_ToPay.do" styleClass="menuitem" target="_top">Generate Fee Receipt</html:link>
          </td></tr>    
          <!--<tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
            <html:link action="/adnf.do" styleClass="menuitem" target="_top">Enter Additional Fee</html:link>
            </td></tr>
            <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
            <html:link action="/sfdisp" styleClass="menuitem" target="_top">Submit School Fee</html:link>
            </td></tr>      
            <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
            <html:link action="/cancel" styleClass="menuitem" target="_top">Cancel Bounced Check</html:link>
            </td></tr> 
           <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
           <html:link action="/delsfrec" styleClass="menuitem" target="_top"><font color="darkblue"><b>Delete School Fee Record</b></font></html:link>
           </td></tr>       
           <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
            <html:link action="/tfdisp" styleClass="menuitem" target="_top">Submit Transport Fee</html:link>
            </td></tr>-->    
       </table>
        </div>
       </td>       
       <td height="18" align="center" valign="middle"><table><tr><td><img src="./image/sep.gif" width="1" height="18"></td></tr></table></td>   
      <td valign="middle" class="menuNormal" width="100" onmouseover="expand(this);" onmouseout="collapse(this);">
      <table><tr><td height="18"  valign="middle"><font color="#000080" style="font-family:TimesNewRoman" size="2"><b><center>Expenses</center></b></font></td></tr></table>
         <div class="menuNormal" width="100">
          <table width="135" class="t" rules="rows">           
            <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
            <html:link action="/Enter_All_Expenses.do" styleClass="menuitem" target="_top">Enter Expenses</html:link>
            </td></tr>      
            <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
            <html:link action="/UpdateAllExpense1.do" styleClass="menuitem" target="_top">Update Expenses</html:link>
            </td></tr> 
           <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
           <html:link action="/Report2.do" styleClass="menuitem" target="_top"><font color="darkblue"><b>Expenses Report</b></font></html:link>
           </td></tr>       
       </table>
        </div>
       </td>        
      <td height="18" align="center" valign="middle"><table><tr><td height="18" align="center" valign="middle"><img src="./image/sep.gif" width="1" height="18"></td></tr></table></td>  
      <td valign="bottom"  class="menuNormal" width="70" onmouseover="expand(this);" onmouseout="collapse(this);">
      <table><tr><td height="18" valign="middle"><font color="#000080" style="font-family:TimesNewRoman" size="2"><b><center>Reports</center></b></font></td></tr></table>    
        <div class="menuNormal" width="100">
          <table width="128" class="t" rules="rows">
              <tr><td class="menuNormal" valign="middle">
              <html:link action="/DispFeeHeadwise"  styleClass="menuitem" target="_top">Display Fee Headwise</html:link> 
              </td></tr>
              <tr><td class="menuNormal" valign="middle">
              <html:link action="/clsd"  styleClass="menuitem" target="_top">Classwise Stud. Detail</html:link> 
              </td></tr>  
              <tr><td class="menuNormal" valign="middle">
              <html:link action="/CcFormat"  styleClass="menuitem" target="_top">Character Certificate</html:link> 
            </td></tr>
              <tr><td class="menuNormal" valign="middle">
              <html:link action="/TcFormat"  styleClass="menuitem" target="_top">Transfer Certificate</html:link> 
            </td></tr>
             <!-- <tr><td class="menuNormal" valign="middle">
              <html:link action="/dfee" styleClass="menuitem" target="_top">Display Fee Record</html:link> 
            </td></tr>  
            <tr><td class="menuNormal" valign="middle">
              <html:link action="/dos" styleClass="menuitem" target="_top">Display Detail of Student</html:link> 
            </td></tr>  
             <tr><td class="menuNormal" valign="middle">
              <html:link action="/pob" styleClass="menuitem" target="_top">Print Old Receipt</html:link> 
            </td></tr>  
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
            </td></tr>   -->
            </table>
        </div>
      </td>   
<td height="18" align="center" valign="middle"><img src="./image/sep.gif" width="1" height="18"></td>
<td height="18" align="center" valign="middle"><a href="<%=request.getContextPath()%>/Logout.do?method=logout">
<font color="#000080" style="font-family:TimesNewRoman" size="2"><b>Logout</b></font></a></td></tr>
</table>    
</body>
</html>
