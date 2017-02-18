<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="com.myapp.struts.JavaBean,java.util.*"%>
 <!DOCTYPE html>
  <%
  JavaBean jb=new JavaBean();  
  HashMap hm=new HashMap();
  ArrayList ar=new ArrayList();
  HashSet hs=new HashSet();
  String ft="";
  String pre="";
  String nxt="";
  String stindex="";
  int k=0;   
  String dt1="";
  String dt2=""; 
  if(request.getAttribute("hmap")!=null){
  hm=(HashMap)request.getAttribute("hmap");  
  ar=(ArrayList)hm.get("arr");  
  ft=(String)hm.get("fromto");
  pre=(String)hm.get("previous");
  nxt=(String)hm.get("next");  
  dt1=(String)hm.get("dated1"); ;
  dt2=(String)hm.get("dated2"); 
  stindex=hm.get("stindex").toString(); 
  }
  if(request.getParameter("dated1")!=null){
  dt1=(String)request.getParameter("dated1");    
  }
  if(request.getParameter("dated2")!=null){
  dt2=(String)request.getParameter("dated2");        
  }
  try{
   k=Integer.parseInt(stindex);   
  }
  catch(NumberFormatException ne){}
%>
<html>
    <head>
    <style type="text/css">.t{border-collapse:collapse}</style>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
         <script language="javascript" src="<%=request.getContextPath()%>/JSF/calendarDateInput.js"></script>
         <script language="javascript">        
             function prevnext(a){
             document.f2.method="POST";
             document.f2.action="UpdateAllExp1.do?method=updateAllExp1&pr="+a;
             document.f2.submit();
             }             
             function update(a){
             document.f2.method="POST";
             document.f2.action="UpdateAllExp2.do?method=updateAllExp2&pid="+a;
             document.f2.submit();
             }        
             function delet(a){
             document.f2.method="POST";
             document.f2.action="DeleteAllExpense.do?method=delAllExpense&pr=1&pid="+a;
             document.f2.submit();
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
    
 <table width="100%" class="res" cellpadding="0" cellspacing="0" align="center">
<tr><td align="center" width="100%" style="padding-top:50px" height="100"><%@include file="/fee/toplook_1.jsp"%></td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
 <tr><td valign="top" style="padding-left: 5px;" align="left"><font color="green" style="font-family:Times New Roman" size="4"><strong>Expenses/Update Expenses</strong></font></td>
     <td width="2" bgcolor="#000000"></td>
            </tr>
            <tr><td valign="top" style="padding-left: 5px" width="210">            
            <%@include file="/fee/expenses.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left"> 
<center><h2><font color="darkblue" size="3"><u><b>Update All Expenses</b></u></font></h2></center>              

<form name="f1" method="post" action="UpdateAllExp1.do?method=updateAllExp1&pr=1">
<table width="40%" align="center">
<tr><td width="50%" class="tdcolor"><b>From Date</b><br><script>DateInput('dated1',true,'dd/mm/yyyy')</script></td>
<td width="50%" class="tdcolor"><b>To Date</b><br><script>DateInput('dated2',true,'dd/mm/yyyy')</script></td>
<td><input type="submit" value="Submit"></td></tr>
</table>
</form> 

<hr color="maroon">

<table width="80%" align="center" height="140" cellpadding="0" cellspacing="0"><tr><td valign="top">
<form name="f2" method="post">
 <center><b><%=dt1%>-<%=dt2%></b></center>
 <input type="hidden" name="dated1" value="<%=dt1%>">
 <input type="hidden" name="dated2" value="<%=dt2%>">    
 <table  width="80%" align="center" class="t" border="0"> 
 <%if(request.getAttribute("msg")!=null){%>
 <tr><td colspan="5" valign="top"><font color="red" style="font-size:12"><b><%=request.getAttribute("msg")%></b></font></td></tr>  
<%}%>  
    <tr><td colspan="5" class="tdcolor"><b>Displaying Records:&nbsp;<%=ft%></b></font>
    <%if(!pre.equals("")){%>
    <a href="#" onclick="prevnext('<%=pre%>')"><font color="blue" style="font-size:12">Previous</font></a>
    <%}
    if(!nxt.equals("")){%>
   <a href="#" onclick="prevnext('<%=nxt%>')"><font color="blue" style="font-size:12">Next</font></a>
   <%}%>
   </td></tr>
  <tr><td width="20%" class="tdcolor1"><b>Date</b></font></td>
  <td width="20%" class="tdcolor1"><b>Details</b></font></td>
  <td width="20%" class="tdcolor1"><b>Amount</b></font></td>
  <td width="20%" class="tdcolor1"><b>Paid By</b></font></td>
  <td width="20%" class="tdcolor1"></td></tr>   
  <%for(int i=0;i<ar.size();i++){
  jb=(JavaBean)ar.get(i);
  %>     
  <tr><td><font style="font-size:12"><%=jb.getDated()%></font></td>
<td><font style="font-size:12"><%=jb.getDetails()%></font></td>
<td><font style="font-size:12"><%=jb.getAmount()%></font></td>
<td><font style="font-size:12"><%=jb.getEmpname()%></font></td>
  <td><a href="#" onclick="update('<%=jb.getId()%>')"><font color="blue" style="font-size:12"><u>Update</u></font></a><b>|</b><a href="#" onclick="delet('<%=jb.getId()%>')"><font color="blue" style="font-size:12"><u>Delete</u></font></a></td></tr>    
    <%}%>
    <tr><td colspan="5" class="tdcolor1"><b>Displaying Records:&nbsp;<%=ft%></b></font>
    <%if(!pre.equals("")){%>
    <a href="#" onclick="prevnext('<%=pre%>')"><font color="blue" style="font-size:12">Previous</font></a>
    <%}
    if(!nxt.equals("")){%>
   <a href="#" onclick="prevnext('<%=nxt%>')"><font color="blue" style="font-size:12">Next</font></a>
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


