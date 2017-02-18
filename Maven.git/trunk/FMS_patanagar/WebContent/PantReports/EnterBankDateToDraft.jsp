<%-- 
    Document   : EnterBankDateToDraft
    Created on : Sep 5, 2014, 6:08:59 PM
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
 

 ArrayList al=new ArrayList();
 
 if(request.getAttribute("list")!=null)
         {
     al=(ArrayList)request.getAttribute("list");
 }
  int curpage=1;
 int noOfPages=1;
 int offset=0;
          if(request.getAttribute("currentPage")!=null)
          {
              curpage=Integer.parseInt(request.getAttribute("currentPage").toString());
          }
          if(request.getAttribute("noOfPages")!=null)
          {
              noOfPages=Integer.parseInt(request.getAttribute("noOfPages").toString());
          }
        if(request.getAttribute("offset")!=null)
          {
              offset=Integer.parseInt(request.getAttribute("offset").toString());
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
<title>Enter Processing Date & Bank</title>

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
        if(!document.f1.draft.checked){
var radios = document.getElementsByName("draft");
    var formValid = false;
    var i = 0;
    while (!formValid && i < radios.length) {
        if (radios[i].checked) formValid = true;
        i++;        
    }

    if (!formValid)
        {alert("Please choose one from advance draft and fee draft!");
    return formValid;
        }
     }
     
     var slot=document.f1.slot.value;
     var draft_no=document.f1.draftno.value;
     if(slot!=""&&draft_no!="")
         {
             alert("Please enter slot no. or draft no. or keep blank to both.");
             return false;
         }
     
     return true;
}

function validate1()
{
    
        if(document.f2.elements["proc_bank"].value=="")
        {
            alert("Please Enter Processing Bank Name For Draft.");
           document.f2.elements["proc_bank"].focus();
            return false;
        }
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
    String draftno="";
    if(request.getAttribute("bnk")!=null)
               {
        bnk=(String)request.getAttribute("bnk");
    }
    if(request.getParameter("slot")!=null) 
        slot=request.getParameter("slot");
    if(request.getParameter("draftno")!=null) 
        draftno=request.getParameter("draftno");
    
    String draft="";
    if(request.getAttribute("draft")!=null)
            draft=(String)request.getAttribute("draft");
    
    ArrayList banklist=new ArrayList();
    if(request.getAttribute("bnklist")!=null)
               {
        banklist=(ArrayList)request.getAttribute("bnklist");
    }
    
    String ssn=request.getParameter("session");
    

    %>
 <table width="100%" class="res" cellpadding="0" cellspacing="0" align="center">
<tr><td align="center" width="100%" style="padding-top:0px" height="100"><%@include file="/fee/toplook_1.jsp"%></td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
 <tr><td valign="top" style="padding-left: 5px" width="210">            
            <%@include file="/fee/fees.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left">
<table>
    <tr><td style="padding-left: 450px"><font color="darkblue" size="3"><u><b>Draft Processing Date</b></u></font></td></tr> 
</table>
 
<form name="f1" method="post" action="./enterDate.do?method=dateForDraft" onsubmit="return validate()">
<table width="40%" align="center">
        <tr>
                <td align="left"><font style="font-size:12" color="white"><b>Session</b></font>
                    <select name="session">
                <option value="<%=next%>"><%=next%></option>
               <option value="<%=prev%>"><%=prev%></option>
            </select></td>
                <td align="left"><font style="font-size:12" color="white"><b>Bank</b></font>
                    <select name="bnk_name">
                <option value="">select</option>
               <% for(int i=0;i<banklist.size();i++){%>
               <option value="<%=banklist.get(i)%>"><%=banklist.get(i)%></option>
               <%}%>
            </select></td>
            </tr>
        <tr><td align="left"><font style="font-size:12" color="white"><b>Advance Draft</b></font>
                <input type="radio" name="draft" value="Advance"></td>
                <td align="left"><font style="font-size:12" color="white"><b>Fee Draft</b></font>
                    <input type="radio" name="draft" value="Fee"></td>
            </tr>   
               
            <tr><td align="left"><font style="font-size:12" color="white"><b>Slot No.</b></font>
                <input type="text" name="slot" size="10"></td>
                <td align="left"><font style="font-size:12" color="white"><b>Draft No.</b></font>
                    <input type="text" name="draftno" size="10"></td>
            </tr> 
            <tr><td colspan="2"><hr></td></tr>
            <tr><td colspan="2" align="center"><input type="submit" name="submit" value="Retrieve"></td></tr>
</table>    
</form> 
<hr color="maroon">
<table width="70%" align="center"><tr><td width="100%" align="right"><a href="javascript:Clickheretoprint('printit')"><font color="yellow" size="2"><u><b>PRINT</b></u></font></a></td></tr></table>
<% if(request.getAttribute("msg")!=null){%>
<table width="70%" align="center"><tr>
        <td width="100%" align="center"><font style="font-size: 16px; color: yellow"><%=request.getAttribute("msg")%></font></td></tr></table>
<%}%>
<form name="f2" action="<%=request.getContextPath()%>/updateDraft.do?method=updDraft" method="post" onsubmit="return validate1()">
<div id="printit">
    <table width="70%" align="center" cellpadding="0" cellspacing="0">
    <tr><td style="padding-left: 0px" align="center" colspan="3">
    <font color="darkblue" size="3"><u><b>Enter <%=draft%> Draft Processing Date</b></u></font>
    </td></tr> 
   <tr><td align="left"><font style="font-size:14px" color="white"><b>Processing Date </b></font></td>
       <td valign="middle"><script>DateInput('date1',true,'dd/mm/yyyy')</script>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
       <td align="left"><font style="font-size:14px" color="white"><b>Processing Bank </b></font>
           <select name="proc_bank">
                <option value="">select</option>
               <% for(int i=0;i<banklist.size();i++){%>
               <option value="<%=banklist.get(i)%>"><%=banklist.get(i)%></option>
               <%}%>
            </select>
       </td></tr>
    </table>
    <% DecimalFormat df = new DecimalFormat("#.00");
        %>
<table width="70%" cellpadding="0" cellspacing="0" align="center" border="1" bordercolor="black" style="border-collapse:collapse; padding-bottom: 20px">
<tr><td colspan="9">
   <font style="font-size:12;font-weight:bold">Session:</font>&nbsp;&nbsp;
   <%if(request.getParameter("session")!=null) out.println(request.getParameter("session"));%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   <font style="font-size:12;font-weight:bold">Draft Bank:</font>&nbsp;&nbsp;<%=bnk%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <font style="font-size:12;font-weight:bold">Slot:</font>&nbsp;&nbsp;
    <%=slot%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <font style="font-size:12;font-weight:bold">Draft No:</font>&nbsp;&nbsp;
    <%=draftno%></td></tr>

<tr><td><font style="font-size:12;font-weight:bold">Sr No.</font></td>
    <td><font style="font-size:12;font-weight:bold">NAME</font></td>
<td><font style="font-size:12;font-weight:bold">ROLL NO.</font></td>
<td><font style="font-size:12;font-weight:bold">STUDENT ID</font></td>
    <td><font style="font-size:12;font-weight:bold">DRAFT</font></td>
    <td><font style="font-size:12;font-weight:bold">DATE</font></td>
<td><font style="font-size:12;font-weight:bold">PROCESSING BANK</font></td>
<td><font style="font-size:12;font-weight:bold">PROCESSING DATE</font></td>
<td><font style="font-size:12;font-weight:bold">AMOUNT</font></td></tr> 
 

<% if(al.size()!=0){%>
<% 

for(int i=0;i<al.size();i++)
       {
    reo1=(ReportsEO)al.get(i);
%>
<tr><td><%=++offset%></td>
    <td><%=reo1.getSname()%></td>
<td><%=reo1.getSrnum()%></td>
<% if(reo1.getStud_id()!=null&&!reo1.getStud_id().equals("")){%>
<td><%=reo1.getStud_id()%></td>
<%} else{%>
<td>NA</td>
<%}%>
<td><%=reo1.getNumber()%></td>
<td><%=reo1.getDate()%></td>
<td>
    <%if(reo1.getBank()!=null){%>
        <%=reo1.getBank()%>
    <%}else{%>
        NA
    <%}%>
</td>
<% if(reo1.getDate1()!=null){%>
<td><%=sdf1.format(reo1.getDate1())%></td>
<%} else{%>
<td>NA</td>
<%}%>
<td align="right"><%=df.format(reo1.getAmount())%></td></tr>
<input type="hidden" name="draftno_<%=i%>" value="<%=reo1.getNumber()%>">
<input type="hidden" name="rwid_<%=i%>" value="<%=reo1.getRwid()%>">
   <%
tot=tot+reo1.getAmount();
}
bd=new BigDecimal(tot);
bd=bd.setScale(2, BigDecimal.ROUND_HALF_UP);
%>
<tr><td colspan="8" align="right"><font style="font-size:14px;font-weight:bold">TOTAL</font></td><td align="right"><b><%=bd%></b></td></tr>
</table>
</div>
<input type="hidden" name="sz" value="<%=al.size()%>">
<input type="hidden" name="session" value="<%=ssn%>">
<input type="hidden" name="bnk_name" value="<%=bnk%>">
<input type="hidden" name="slot" value="<%=slot%>">
<input type="hidden" name="draftno" value="<%=draftno%>">
<input type="hidden" name="draft" value="<%=draft%>">
<input type="hidden" name="pg" value="<%=curpage%>">
<table width="70%" align="center"><tr><td align="center"><input type="submit" value="Update"></td></tr></table>
</form>
<%}%>
<table width="70%" align="center">
    <tr><td colspan="2" height="10"></td></tr>
    <tr>
           <%if(noOfPages>=1){%>
           <td width="50%" align="left">
              <%if(curpage<noOfPages){%>
                <a href="./enterDate.do?method=dateForDraft&page=<%=curpage+1%>&session=<%=ssn%>&bnk_name=<%=bnk%>&draft=<%=draft%>&slot=<%=slot%>">
                     <strong>Older</strong>
                          </a>
                 <%}%>
        </td>
        <td width="50%" align="right">
            <%if(curpage>1){%>
                <a href="./enterDate.do?method=dateForDraft&page=<%=curpage-1%>&session=<%=ssn%>&bnk_name=<%=bnk%>&draft=<%=draft%>&slot=<%=slot%>">
                     <strong>Newer</strong>
                     </a>
                 <%}%>
        </td>
        
                 <%}%>
            </tr></table>
</td></tr> 
</table></td></tr>       

<%}catch(Exception e){out.println("kapil: "+e.getMessage());}%>
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
