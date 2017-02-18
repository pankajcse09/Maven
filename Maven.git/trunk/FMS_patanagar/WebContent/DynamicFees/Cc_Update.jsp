<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/JSF/ajaxxml.js"></script>
          <script language="JavaScript">    
 function showCcData(en){ 
 xmlHttp=getXmlHttpObject();
 if (xmlHttp==null){
 alert ("Browser does not support HTTP Request");
 return;
 }
var url="<%=request.getContextPath()%>/RetrivedData/RetCcData.jsp";
url=url+"?en="+en;
xmlHttp.onreadystatechange=stateChanged;
xmlHttp.open("POST",url,true);
xmlHttp.send(null);
}     

function stateChanged(){ 
if (xmlHttp.readyState==4 || xmlHttp.readyState=="complete"){ 	
    var showdata = xmlHttp.responseText;  
    var strar = showdata.split(":");
    if(strar.length>1){
    document.getElementById("name").value=strar[2];
    document.getElementById("classes").value=strar[3];
    document.getElementById("fname").value=strar[4];
    document.getElementById("from").value=strar[5];
    document.getElementById("to").value=strar[6];
    }else{
    document.getElementById("name").value="";
    document.getElementById("classes").value="";
    document.getElementById("fname").value="";
    document.getElementById("from").value="";
    document.getElementById("to").value="";
   }
 } 
}  
</script>
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
 <tr><td valign="top" style="padding-left: 5px;" align="left"><font color="green" style="font-family:Times New Roman" size="4"><strong>Utilities</strong></font></td>
     <td width="2" bgcolor="#000000"></td>
            </tr>
           <tr><td valign="top" style="padding-left: 5px" width="200">            
            <%@include file="/fee/utilities_menu.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left"><table>
                <tr><td>
<table style="padding-left: 400px">
<tr><td width="100%" align="center"><font style="font-size:14;font-weight:bold;color:blue">Update CC Data</font></td></tr>    
</table></td></tr>
                <tr><td style="padding-left: 200px">
<form name="f1" method="post" action="<%=request.getContextPath()%>/Up_Cc_Data.do?method=ccUpAct">
<table  align="center" border="1" style="border-collapse:collapse" width="500">
<%if(request.getAttribute("msg")!=null){%>
<tr><td colspan="2" align="center"><font style="font-size:12;font-weight:bold;color:red"><%=request.getAttribute("msg")%></font></td></tr>
<%}%>    
<tr><td width="40%"><font style="font-size:12;font-weight:bold">Admin No.</font></td><td width="60%"><input type="text" name="adminno" id="adminno" value="" onblur="showCcData(this.value);"></td></tr>    
<tr><td width="40%"><font style="font-size:12;font-weight:bold">Name</font></td><td width="60%"><input type="text" name="name" id="name" value=""></td></tr>  
<tr><td width="40%"><font style="font-size:12;font-weight:bold">Class</font></td><td width="60%"><input type="text" name="classes" id="classes" value=""></td></tr>  
<tr><td width="40%"><font style="font-size:12;font-weight:bold">Father Name</font></td><td width="60%"><input type="text" name="fname" id="fname" value=""></td></tr>  
<tr><td width="40%"><font style="font-size:12;font-weight:bold">Session From</font></td><td width="60%"><input type="text" name="from" id="from" value=""></td></tr>  
<tr><td width="40%"><font style="font-size:12;font-weight:bold">Session To</font></td><td width="60%"><input type="text" name="to" id="to" value=""></td></tr> 
<tr><td colspan="2" align="center"><input type="submit" value="Submit"></td></tr>  
</table>    
</form></td></tr>
            </table>
</td></tr> 
</table></td></tr>    
 
<tr><td valign="bottom"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
