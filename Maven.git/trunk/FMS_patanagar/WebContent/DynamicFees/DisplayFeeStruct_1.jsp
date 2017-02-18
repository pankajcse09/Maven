<%-- 
    Document   : DisplayFeeStruct_1
    Created on : Apr 25, 2013, 2:19:14 PM
    Author     : kapil
--%>

<%@page import="ActionClass.MyMeth"%>
<%@page import="Beans.JavaBean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page language="java"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="EO.SchoolEO,java.text.SimpleDateFormat"%>
<%@page import="AO.*,ActionClass.FeeMethod,ActionClass.DataObj"%>
<!DOCTYPE html>
   <% 
  
      Date dat=new Date();
      SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
      String dt=sdf.format(dat);
      int cur=Integer.parseInt(dt);
      String prev=(cur-1)+"-"+cur;
      String next=cur+"-"+(cur+1);   
      String ssn="";
       String stud_type="Hosteller";
         if(request.getParameter("stud_type")!=null){
      stud_type=request.getParameter("stud_type");
      }
      if(request.getParameter("session")!=null){
      ssn=request.getParameter("session");
      }
      String deg="";
      if(request.getParameter("degree")!=null){
      deg=request.getParameter("degree");
      }
      String bran="";
      if(request.getParameter("branch")!=null){
      bran=request.getParameter("branch");
      }
      FeeMethod fm=new FeeMethod();
      try{
         ArrayList ar1=(ArrayList)fm.allClasses();         
         ArrayList ar3=(ArrayList)fm.fee_Heads(stud_type); 
         ArrayList ar4=(ArrayList)fm.feeTypes(stud_type);
         ArrayList ar2=new ArrayList();
         ar2.add("NON PRAC");
         ar2.add("ONE PRAC");
         ar2.add("TWO PRAC");
         ar2.add("THREE PRAC");
         
         ArrayList BranchList=new ArrayList();
          DataObj fun=new DataObj();
           BranchList=(ArrayList)fun.getBranch(deg);
           JavaBean jbb=new JavaBean();
           JavaBean jbb1=new JavaBean();
     %>
<html>
<head>
<title>College Management System</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/mymenu.css">
<script language="javascript" src="<%=request.getContextPath()%>/fee/resolution.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/fee/calendarDateInput.js"></script>  
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/menu.css">
<script language="javascript" src="<%=request.getContextPath()%>/fee/menu.js"></script>   
 
<script language="javascript" src="<%=request.getContextPath()%>/JSF/CheckNumericData.js"></script> 
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
<script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>          
<script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
<script language="javascript">        
function retFee(){
document.f1.method="GET";
document.f1.action="<%=request.getContextPath()%>/DynamicFees/DisplayFeeStruct_1.jsp";
document.f1.submit();
}
function retFees(){
document.f1.method="POST";
document.f1.action="<%=request.getContextPath()%>/DisplayFeeStr.do?method=Rc";
document.f1.submit();
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
         
         <% 
        
                 if(request.getAttribute("stud_type")!=null)
                         {
             stud_type=(String)request.getAttribute("stud_type");
         }
         
         if(request.getAttribute("branchlist")!=null)
                         {
             BranchList=(ArrayList)request.getAttribute("branchlist");
         }
         
           String select="";
           if(request.getAttribute("select")!=null)
                         {
             select=(String)request.getAttribute("select");
         }
           JavaBean de=new JavaBean();
   ArrayList degreelist=new ArrayList();
    MyMeth fn=new MyMeth();
    if(request.getAttribute("degreelist")!=null)
   {
   degreelist=(ArrayList)request.getAttribute("degreelist");
    }
       else{
  degreelist=(ArrayList)fn.Degree_list();
   }
     %>
         
 <table width="100%" class="res" cellpadding="0" cellspacing="0" border="0">
<tr><td align="left" width="100%" style="padding-top:50px" height="100"><%@include file="/fee/topdesign.jsp"%></td></tr>
 <tr><td align="center" width="100%">  
<table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="0">
 <tr><td valign="top" style="padding-left: 5px;" align="left" width="500"><font color="green" style="font-family:Times New Roman" size="4">
         <strong>Display Fee Structure</strong></font></td>
     <td valign="top" align="left"><font color="Maroon" size="4">FEE REGISTER</td>
            </tr>
            <tr>
                <td valign="top" align="left" colspan="2"> 
 
<form name="f1" method="get"> 
<table width="100%" border="0"><tr>
        
        <!--<td width="200"><font style="font-size:12;color:darkblue;font-weight:bold">Degree</font>
            <select name="degree" onchange="retFees()">
                <%if(deg.equals("")){%>
                <option value="">Select</option>
                <%}else{%>
                <option value="<%=deg%>"><%=deg%></option>
               <%}%>
               <%for(int i=0;i<degreelist.size();i++){
de=(JavaBean)degreelist.get(i);
if(!de.getDegree().equals(deg)){
%>
<option value="<%=de.getDegree()%>"><%=de.getDegree()%></option>
<%}}%>
                
            </select>
        </td> 
       
        <td width="210"><font style="font-size:12;color:darkblue;font-weight:bold">Branch</font>
            <select name="branch" style="width: 150px" onchange="retFee();">
                <% if(bran.equals("")){%>
    <option value="">select one</option>
    <%}
        for(int i=0;i<BranchList.size();i++){
            jbb=(JavaBean)BranchList.get(i);
            if(bran.equals(jbb.getBranch())){
    %>
    <option value="<%=bran%>"><%=bran%></option>
    <%}}%>
     
    <%for(int i=0;i<BranchList.size();i++){
jbb=(JavaBean)BranchList.get(i);
if(!bran.equals(jbb.getBranch())){
%>
<option value="<%=jbb.getBranch()%>"><%=jbb.getBranch()%></option>
<%}}%>
</select>
        </td>-->

<td width="180">
<font style="font-size:12;color:darkblue;font-weight:bold">Session</font>
<select name="session" onchange="retFee();">  
<%if(ssn!=null && !ssn.equals("")){%>    
<option value="<%=ssn%>"><%=ssn%></option>  
<%}if(!prev.equals(ssn)){%> 
<option value="<%=prev%>"><%=prev%></option>  
<%}if(!next.equals(ssn)){%> 
<option value="<%=next%>"><%=next%></option>  
<%}%>
</select>
</td>
<td width="200">
<font style="font-size:12;color:darkblue;font-weight:bold">Student Type</font>
<select name="stud_type" onchange="retFee();">
    <% if(!stud_type.equals("")){%>
        <option value="<%=stud_type%>"><%=stud_type%></option>
        <%}%>
        
    <option value="Hosteller">Hosteller</option>
     <option value="Day Scholar">Day Scholar</option>
               
</select>
</td>
<td>
<%if(!deg.equals("")||!bran.equals("")){%>
<%=deg%>/<%=bran%>/<%=stud_type%>/<%=ssn%>  
<%}%></td>
    </tr></table>    
<table width="100%" cellpadding="0" cellspacing="0" align="center" border="0"><tr><td valign="top">
 <%if(request.getAttribute("msg")!=null){
 out.println("<font color='red'><b>"+request.getAttribute("msg")+"</b></font>");} %>
</td></tr></table>    
<table bgcolor="lightyellow" bordercolor="#A89263" border="1" style="border-collapse:collapse">
    
    <tr><td colspan="2" bgcolor="yellow"></td>
        <% if(ar4.size()!=0){
                for(int i=0;i<ar4.size();i++)
                     {
                    jbb1=(JavaBean)ar4.get(i);
        %>
        <td colspan="<%=jbb1.getCount()%>" align="center" bgcolor="yellow"><b><%=jbb1.getFeeType()%></b></td>
        <%}}%>
    </tr>
<tr><td width="9%" align="center" class="tdcolor1"><b>Semester</b></font></td>
<td width="9%" align="center" class="tdcolor1"><b>Gender</b></font></td>
<%for(int i=0;i<ar3.size();i++){%>
<td width="9%" align="center" class="tdcolor1"><b><%=ar3.get(i).toString().toUpperCase()%></b></font></td>
<%}%>
<td width="9%" align="center" class="tdcolor1"><b>TOTAL</b></font></td>
</tr>
<%for(int i=0;i<ar1.size();i++){
//ar2=(ArrayList)fm.typeByClass(ar1.get(i));
%>
<tr><td width="9%" align="center" class="tdcolor1"><b><%=ar1.get(i)%><br><%//=ar2.get(j)%></b></font></td>
<td width="9%" align="center"><b>Common</b></font></td>
<%for(int k=0;k<ar3.size();k++){%>
<td width="9%" align="center" class="tdcolor2"><b><%=fm.retriveFees(ar1.get(i),ar3.get(k),"MALE",ssn)%></b></font></td>
<%}%>
<td width="9%" align="center" class="tdcolor1"><b><%=fm.retTotalFees(ar1.get(i),ar3,"MALE",ssn)%></b></font></td>
</tr>

<%--<tr>
<td width="9%" align="center" class="tdcolor1"><b><%=ar1.get(i)%><br><%//=ar2.get(j)%></b></font></td>
<td width="9%" align="center" bgcolor="pink"><b>FEMALE</b></font></td>
<%for(int k=0;k<ar3.size();k++){%>
<td width="9%" align="center" bgcolor="pink" class="tdcolor2"><b><%=fm.retriveFees(ar1.get(i),ar3.get(k),"FEMALE",ssn)%></b></font></td>
<%}%>
<td width="9%" align="center" bgcolor="pink" class="tdcolor1"><b><%=fm.retTotalFees(ar1.get(i),ar3,"FEMALE",ssn)%></b></font></td>
</tr>--%>
<%
//ar2.clear();
}%>
</table>
</form>
</td></tr></table>
           </td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>

<%}catch(Exception e){}
finally{
fm.closeCon();    
}      
%>

