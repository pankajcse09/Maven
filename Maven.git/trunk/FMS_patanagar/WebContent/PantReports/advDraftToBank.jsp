<%-- 
    Document   : dateWiseAmount
    Created on : Jul 8, 2013, 12:22:38 PM
    Author     : kapil
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.math.BigDecimal"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@page import="java.util.*,ActionClass.*,EO.*"%>
 <!DOCTYPE html>
<% 
SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
    
    java.util.Date dt=new java.util.Date();
    String Styear=sdf.format(dt);
    int Syear=Integer.parseInt(Styear);    
    String prev=(Syear-1)+"-"+Syear;
    String next=Syear+"-"+(Syear+1);
BigDecimal bd = new BigDecimal(0.00);
SimpleDateFormat sdf1=new SimpleDateFormat("dd/MM/yyyy");
  ReportsEO reo1=null;
 
 int k=0;
 ArrayList al=new ArrayList();
 
 if(request.getAttribute("list")!=null)
         {
     al=(ArrayList)request.getAttribute("list");
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
<script language="javascript" src="<%=request.getContextPath()%>/JSF/calendarDateInput.js"></script>
<title>Update Advance Draft</title>

<script language="javascript">
//function updateAdvDraft(bnk)
//{
//  document.f2.method="get";
// document.f2.action="<%=request.getContextPath()%>/updateAdvDr.do?method=updAdvDr&bnk_name="+bnk;
// document.f2.submit();
//}

function validate()
{
    
        if(document.f1.elements["bnk_name"].value=="")
        {
            alert("Please Enter Bank name");
           document.f1.elements["bnk_name"].focus();
            return false;
        }
        return true;
}


</script>

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
    <% 
    double tot=0.0;
    String bnk="";
    String slot=new String("");
    if(request.getAttribute("bnk")!=null)
               {
        bnk=(String)request.getAttribute("bnk");
    }
    if(request.getAttribute("slot")!=null)
               {
        slot=(String)request.getAttribute("slot");
    }
    ArrayList banklist=new ArrayList();
    if(request.getAttribute("bnklist")!=null)
               {
        banklist=(ArrayList)request.getAttribute("bnklist");
    }
    %>
 <table width="100%" class="res" cellpadding="0" cellspacing="0" align="center">
<tr><td align="center" width="100%" style="padding-top:50px" height="100"><%@include file="/fee/toplook_1.jsp"%></td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
 <tr><td valign="top" style="padding-left: 5px;" align="left"><font color="green" style="font-family:Times New Roman" size="4">
         <strong>Reports/Fee Reports</strong></font></td>
     <td width="2" bgcolor="#000000"></td>
            </tr>
            <tr><td valign="top" style="padding-left: 5px" width="210">            
            <%@include file="/fee/reports.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left">
<table>
    <tr><td style="padding-left: 390px"><h2><font color="darkblue" size="3"><u><b>Advance Draft List</b></u></font></h2></td></tr> 
</table>
 
<form name="f1" method="post" action="<%=request.getContextPath()%>/retAdvDraftToBn.do?method=checkAdvDraft" onsubmit="return validate()">
<table width="25%" align="center"><tr><td width="100%" align="center">
            <tr>
                <td align="left"><font style="font-size:12" color="white"><b>Session</b></font><br>
                    <select name="session">
                <option value="<%=next%>"><%=next%></option>
               <option value="<%=prev%>"><%=prev%></option>
            </select></td>
                <td align="left"><font style="font-size:12" color="white"><b>Bank</b></font><br>
                    <select name="bnk_name">
                <option value="">select</option>
               <% for(int i=0;i<banklist.size();i++){%>
               <option value="<%=banklist.get(i)%>"><%=banklist.get(i)%></option>
               <%}%>
            </select></td>
                
                <td><br><input type="submit" value="Submit"></td>
            </tr>   
</table>    
</form> 
<hr color="maroon">
<table width="70%" align="center"><tr><td width="100%" align="right"><a href="javascript:Clickheretoprint('printit')"><font color="yellow" size="2"><u><b>PRINT</b></u></font></a></td></tr></table>
<% if(request.getAttribute("msg")!=null){%>
<table width="70%" align="center"><tr>
        <td width="100%" align="center"><font style="font-size: 16px; color: yellow"><%=request.getAttribute("msg")%></font></td></tr></table>
<%}%>
<form name="f2" action="<%=request.getContextPath()%>/updateAdvDr.do?method=updAdvDr" method="post">
<div id="printit">
    <table width="70%" align="center" cellpadding="0" cellspacing="0">
    <tr><td style="padding-left: 0px" align="center"><h2><font color="darkblue" size="3"><u><b>Update Advance Draft</b></u></font></h2></td></tr> 
</table>
    <% DecimalFormat df = new DecimalFormat("#.00");
        %>
<table width="70%" cellpadding="0" cellspacing="0" align="center" border="1" bordercolor="black" style="border-collapse:collapse; padding-bottom: 20px">
<tr><td colspan="8">
   <font style="font-size:12;font-weight:bold">Session:</font>&nbsp;&nbsp;
   <%if(request.getParameter("session")!=null) out.println(request.getParameter("session"));%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   <font style="font-size:12;font-weight:bold">Bank:</font>&nbsp;&nbsp;<%=bnk%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <font style="font-size:12;font-weight:bold">Slot:</font>&nbsp;&nbsp;<%=slot%></td></tr>

<tr><td><font style="font-size:12;font-weight:bold">Sr No.</font></td>
    <td><font style="font-size:12;font-weight:bold">NAME</font></td>
<td><font style="font-size:12;font-weight:bold">ROLL NO.</font></td>
<td><font style="font-size:12;font-weight:bold">STUDENT ID</font></td>
    <td><font style="font-size:12;font-weight:bold">DRAFT</font></td>
    <td><font style="font-size:12;font-weight:bold">DATE</font></td>
<td><font style="font-size:12;font-weight:bold">BANK</font></td>
<td><font style="font-size:12;font-weight:bold">AMOUNT</font></td></tr> 
 

<% if(al.size()!=0){%>
<% 

for(int i=0;i<al.size();i++)
       {
    reo1=(ReportsEO)al.get(i);
%>
<tr><td><%=++k%></td>
    <td><%=reo1.getSname()%></td>
<td><%=reo1.getSrnum()%></td>
<% if(reo1.getStud_id()!=null&&!reo1.getStud_id().equals("")){%>
<td><%=reo1.getStud_id()%></td>
<%} else{%>
<td>NA</td>
<%}%>
<td><%=reo1.getNumber()%></td>
<td><%=reo1.getDate()%></td>
<td><%=reo1.getBank()%></td>
<td align="right"><%=df.format(reo1.getAmount())%></td></tr>
<input type="hidden" name="draft<%=i%>" value="<%=reo1.getNumber()%>">
<input type="hidden" name="rwid_<%=i%>" value="<%=reo1.getRwid()%>">
   <%
tot=tot+reo1.getAmount();
}
bd=new BigDecimal(tot);
bd=bd.setScale(2, BigDecimal.ROUND_HALF_UP);
%>
<input type="hidden" name="sz" value="<%=al.size()%>">
<input type="hidden" name="session" value="<%=request.getParameter("session")%>">
<tr><td colspan="7" align="right"><font style="font-size:14px;font-weight:bold">TOTAL</font></td><td align="right"><b><%=bd%></b></td></tr>
</table>
</div>
<input type="hidden" name="bnk_name" value="<%=bnk%>">
<input type="hidden" name="slot" value="<%=slot%>">
<table width="70%" align="center"><tr><td align="center"><input type="submit" value="Update"></td></tr></table>
</form>
<%}%>
<%}catch(Exception e){}%>
</td></tr> 
</table></td></tr>       


<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
