<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@page import="java.util.*,ActionClass.*,EO.*"%>
 <!DOCTYPE html>
<% 
 int k=0;
 MyMeth mm=new MyMeth();
 ArrayList ar2=(ArrayList)mm.retriveAllClass();
 SchoolEO seo=new SchoolEO();
 if(request.getAttribute("seo")!=null){
 seo=(SchoolEO)request.getAttribute("seo");    
 }
 try{
 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
<script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
<script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/JSF/printData.js"></script>
<title>JSP Page</title>
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
 <tr><td valign="top" style="padding-left: 5px;" align="left"><font color="green" style="font-family:Times New Roman" size="4"><strong>Reports/Classwise Subject List</strong></font></td>
     <td width="2" bgcolor="#000000"></td>
            </tr>
            <tr><td valign="top" style="padding-left: 5px" width="210">            
            <%@include file="/fee/reports.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left">
<table>
    <tr><td style="padding-left: 390px"><h2><font color="darkblue" size="3"><u><b>Subject List</b></u></font></h2></td></tr> 
</table>
 
<form name="f1" method="post" action="<%=request.getContextPath()%>/RetClassSub.do?method=retClassSubAct">
<table width="30%" align="center"><tr><td width="100%" align="center">
<tr><td><font style="font-size:12"><b>Class:</b></font>
<select name="classes">
<%if(seo.getClasses().equals("")){%>
<option value="">SELECT</option>     
<%}else{%>
<option value="<%=seo.getClasses()%>"><%=seo.getClasses()%></option>     
<%}for(int i=0;i<ar2.size();i++){
if(seo.getClasses().equals(ar2.get(i))){continue;}
%>
<option value="<%=ar2.get(i)%>"><%=ar2.get(i)%></option>
<%}%>
</select>
<input type="submit" value="Submit"></td></tr></table>    
</form> 
<table width="70%" align="center"><tr><td width="100%" align="right"><a href="javascript:Clickheretoprint('printit')"><font color="yellow" size="2"><u><b>PRINT</b></u></font></a></td></tr></table>   
<div id="printit">
<table width="70%" align="center" border="1" bordercolor="black" style="border-collapse:collapse">
<tr><td colspan="4" align="center"><font style="font-size:14;font-weight:bold">Class&nbsp;:&nbsp;<%=seo.getClasses()%></font></td></tr>    
<tr><td><font style="font-size:12;font-weight:bold">SNO.</font></td>
<td><font style="font-size:12;font-weight:bold">CLASS</font></td>
<td><font style="font-size:12;font-weight:bold">SUBJECT</font></td>
<td><font style="font-size:12;font-weight:bold">PRACTICAL</font></td></tr>    
<logic:iterate id="data" name="arr">
<tr><td><%=++k%></td>
<td><bean:write name="data" property="classes"/></td>
<td><bean:write name="data" property="subject"/></td>
<td><bean:write name="data" property="practical"/></td></tr> 
</logic:iterate>    
</table>
</div>
<%}catch(Exception e){}%>
</td></tr> 
</table></td></tr>       


<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>