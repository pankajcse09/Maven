<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.sql.*,ActionClass.*,java.util.*,Beans.JavaBean"%>
<!DOCTYPE html>
<%
   
  JavaBean jb=new JavaBean(); 
  MyMeth mm=new MyMeth();   
  ArrayList ar1=new ArrayList();    
  try{
  ar1=(ArrayList)mm.retriveBranchesId(); 
  }
  catch(NullPointerException ne){}

%>
<html>
    <head>
     <title>School Management System</title>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>    
    </head>
    <body bgcolor="#999933">
        <style>
             input[type=button] {
                 cursor: pointer;
    
    background-color: #A89263;
    color: #333333;
    padding: 2px 6px 2px 6px;
    border-top: 1px solid #CCCCCC;
    border-right: 1px solid #333333;
    border-bottom: 1px solid #333333;
    border-left: 1px solid #CCCCCC;
   }
   
   input[type=button]:hover {
       background-color: #EEEEEE;
   }
   
   .vr {
    width:2px;
    background-color:#000;
    position:absolute;
    top:151px;
    height: 447px;
    left:300px;
}
         </style> 
       
<table width="100%" class="res" cellpadding="0" cellspacing="0" align="center">
<tr><td align="center" width="100%" style="padding-top:50px" height="100"><%@include file="/fee/toplook_1.jsp"%></td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
 <tr><td valign="top" style="padding-left: 5px;" align="left"><font color="green" style="font-family:Times New Roman" size="4"><strong>Utilities</strong></font></td>
     <td width="2" bgcolor="#000000"></td>
            </tr>
            <tr><td valign="top" style="padding-left: 5px" width="200">            
            <%@include file="/fee/utilities_menu.jsp" %>
        </td>
        <td align="left" width="2" bgcolor="#000000"></td>
             <td valign="top" align="left"><table>
                     
                <tr><td>
    <table style="padding-left: 400px">
        <tr><td align="center"><h2><font color="darkblue" size="4"><u>Delete Branches</u></font></h2></td></tr>
    </table></td></tr>
                <tr><td style="padding-left: 200px" valign="top" align="center">
    <form method="post">
     <table  align="center" border="0" style="border-collapse:collapse" width="500" bgcolor="#FFFFCC" valign="top"> 
     <%if(request.getAttribute("msg")!=null){%>
     <tr><td colspan="2"><font color="red"><b><%=request.getAttribute("msg")%></b></font></td></tr>   
     <%}%>     
     <tr><td class="tdcolor1"><font style="font-size:12;font-weight:bold">Branches</font></td>
         <td class="tdcolor1" ><font style="font-size:12;font-weight:bold">Duration</font></td><td class="tdcolor1"></td></tr>     
     <%for(int i=0;i<ar1.size();i++){
     jb=(JavaBean)ar1.get(i);  
     %>
     <tr><td><%=jb.getClas()%></td>

     <td><%=jb.getDuration()%></td>

<td><a href="<%=request.getContextPath()%>/DeleteBranches.do?para=<%=jb.getId()%>&method=deleteBranchAction"><font color="blue">Delete</font></a></td></tr>     
     <%}%>
     </td></tr></table>
    </form>
    </td></tr>
            </table>
</td></tr> 
</table></td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
