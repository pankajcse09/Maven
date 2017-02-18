<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<style type="text/css">.t{border-collapse:collapse;border-color:lightblue}</style>
</head>      
<body>
<table border="0" bgcolor="darkblue" width="100%">       
<tr><td align="center"><font color="Yellow" style="font-family:Comic Sans MS" size="5">Fee Management System</font></td></tr> 
<tr><td align="center"><font color="Yellow" style="font-family:Times New Roman" size="5"> College</font></td></tr>
<tr><td valign="top">        
<table class="navbar" width="50%" bgcolor="" border="0" bordercolor="" valign="top"><tr>    
<td><a href="<%=request.getContextPath()%>/fee/FeeMainPage.jsp"><font color="White" style="font-family:Comic Sans MS" size="4">Home</font></a></td>

<td><a href="<%=request.getContextPath()%>/fee/regis.jsp"><font color="white" style="font-family:Comic Sans MS" size="4">Registration</font></a></td>
<td valign="middle" class="menuNormal" width="" onmouseover="expand(this);" onmouseout="collapse(this);" bgcolor="">
      <!--tab1--><table border="0"  width="100%" bgcolor="">
            <tr><td valign="top"><font color="white" style="font-family:Comic Sans MS" size="4">Utilities</font></td>
            </tr><tr>
            <td valign="top">            
            <div class="menuNormal" width="100">            
              <!--tab2--><table width="130" class="t" rules="column" border="1">
            <tr><td class="menuNormal" bgcolor="" valign="middle">
            <html:link action="/Cc_Entry.do" styleClass="menuitem" target="_top">Enter CC Data</html:link>
            </td></tr> 
             <tr><td class="menuNormal" bgcolor="" valign="middle">
            <html:link action="/Tc_Entry.do" styleClass="menuitem" target="_top">Enter TC Data</html:link>
            </td></tr>     
              <tr><td class="menuNormal" bgcolor="" valign="middle">
             <html:link action="/upload.do" styleClass="menuitem" target="_top">Upload Student Pic</html:link>
            </td></tr>      
             <tr><td class="menuNormal" bgcolor="" valign="middle">
             <html:link action="/Add_Subject.do" styleClass="menuitem" target="_top">Add Subject</html:link>
            </td></tr>                
            <!--<tr><td class="menuNormal" bgcolor="" valign="middle">
             <html:link action="/Add_Class_Type.do" styleClass="menuitem" target="_top">Add Class Type</html:link>
            </td></tr> -->
             <tr><td class="menuNormal" bgcolor="" valign="middle">
             <html:link action="/Add_Class_Fee.do" styleClass="menuitem" target="_top">Add Class Fee</html:link>
            </td></tr> 
               <tr><td class="menuNormal" bgcolor="" valign="middle">
             <html:link action="/Edit_Class_Fee.do" styleClass="menuitem" target="_top">Edit Class Fee</html:link>
            </td></tr>
             <tr><td class="menuNormal" bgcolor="" valign="middle">
             <html:link action="/EnterClasses.do" styleClass="menuitem" target="_top">Enter Class</html:link>
            </td></tr> 
             <tr><td class="menuNormal" bgcolor="" valign="middle">
              <html:link action="/delclass.do" styleClass="menuitem" target="_top">Delete Class</html:link>
            </td></tr>    
             <tr><td class="menuNormal" valign="middle">
            <html:link action="/EnterFeeHeads" styleClass="menuitem" target="_top">Add Fee Head</html:link>
            </td></tr>
            <tr><td class="menuNormal" valign="middle">
            <html:link action="/disphd" styleClass="menuitem" target="_top">Display Fee Heads</html:link>
            </td></tr> 
             <!-- <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
             <html:link action="/sr.do" styleClass="menuitem" target="_top">Set Receipt No.</html:link>
            </td></tr>--> 
            </table>
        </div>
        </td></tr></table>
       </td>   
  
<td valign="middle" class="menuNormal" width="" onmouseover="expand(this);" onmouseout="collapse(this);" bgcolor="">
      <!--tab1--><table border="0"  width="100%" bgcolor="">
        <tr><td valign="top" width="100"><font color="white" style="font-family:Comic Sans MS" size="4">Fee</font></td>
        </tr><tr>
        <td valign="top">        
         <div class="menuNormal" width="100"> 
           <table width="150" class="t" rules="column" border="1">
           <tr><td class="menuNormal" bgcolor="" valign="middle">
          <html:link action="/DisplayFeeStruct.do" styleClass="menuitem" target="_top">Display Fee Struct.</html:link>
          </td></tr>
          <tr><td class="menuNormal" bgcolor="" valign="middle">
          <html:link action="/FeeReceipt_ToPay.do" styleClass="menuitem" target="_top">Generate Fee Receipt</html:link>
          </td></tr>    
       </table>
        </div>
        </td></tr></table>
       </td> 

<td valign="middle" class="menuNormal" width="" onmouseover="expand(this);" onmouseout="collapse(this);" bgcolor="">
      <!--tab1--><table border="0"  width="100%" bgcolor="">
                <tr>
                <td valign="top" width="100" height="18"><font color="white" style="font-family:Comic Sans MS" size="4">Expenses</font></td>
                </tr><tr>
                <td valign="top">
              <div class="menuNormal" width="100">
       <table width="130" class="t" rules="column" border="1">                  
            <tr><td class="menuNormal" bgcolor="" valign="middle">
            <html:link action="/Enter_All_Expenses.do" styleClass="menuitem" target="_top">Enter Expenses</html:link>
            </td></tr>      
            <tr><td class="menuNormal" bgcolor="" valign="middle">
            <html:link action="/UpdateAllExpense1.do" styleClass="menuitem" target="_top">Update Expenses</html:link>
            </td></tr> 
           <tr><td class="menuNormal" bgcolor="" valign="middle">
           <html:link action="/Report2.do" styleClass="menuitem" target="_top">Expenses Report</html:link>
           </td></tr>      
        </table>
        </div>
        </td></tr></table>
       </td> 

<td valign="top" class="menuNormal" width="" onmouseover="expand(this);" onmouseout="collapse(this);" bgcolor="">
     <!--tab1--><table border="0"  width="100%" bgcolor="" >
        <tr>
        <td valign="top" width="100" height="18"><font color="white" style="font-family:Comic Sans MS" size="4">Reports</font></td></tr>
        <tr><td valign="top">   
        <div class="menuNormal" width="100">
         <table width="180" class="t" rules="column" border="1">
            <tr><td class="menuNormal" valign="middle">
            <html:link action="/Sub_List_Classwise" styleClass="menuitem" target="_top">Classwise Subject List</html:link> 
            </td></tr>   
            <tr><td class="menuNormal" valign="middle">
            <html:link action="/Disp_StudSub"  styleClass="menuitem" target="_top">Display Student Subject</html:link> 
            </td></tr>
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
            </table>
        </div>
        </td></tr></table> 
      </td> 
</tr>
</table> 
</td></tr>
<tr><td align="right"><a href="<%=request.getContextPath()%>/Logout.do?method=logout">
<font color="white" style="font-family:TimesNewRoman" size="2"><b>Logout</b></font></a></td>
</tr>
</td></tr></table>
</body>
</html>
