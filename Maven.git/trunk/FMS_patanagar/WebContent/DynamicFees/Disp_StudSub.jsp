<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.text.*,java.util.*,ActionClass.*,EO.*"%>
<!DOCTYPE html>
<%
 MyMeth mm=new MyMeth();  
 SchoolEO seo=new SchoolEO();  
 SchoolEO seo2=new SchoolEO();  
 ArrayList ar2=new ArrayList();
 double fee=0.0;
 ArrayList ar=(ArrayList)mm.retriveAllClass(); 
 if(request.getAttribute("jbean")!=null){
 seo=(SchoolEO)request.getAttribute("jbean");    
 } 
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
    Date dt=new Date();
    String Styear=sdf.format(dt);
    int Syear=Integer.parseInt(Styear);  
    int Eyear=Syear+1;
    String prev=(Syear-1)+"-"+Syear;
    String next=Syear+"-"+(Syear+1); 
    
 ArrayList ar1=(ArrayList)seo.getDataArray();  
 
%>
<html>
    <head>
    <style type="text/css">
     .font{font-size:10;font-weight:bold}   
    </style>
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
 <tr><td valign="top" style="padding-left: 5px;" align="left"><font color="green" style="font-family:Times New Roman" size="4"><strong>Reports/Display Student Subject</strong></font></td>
     <td width="2" bgcolor="#000000"></td>
            </tr>
            <tr><td valign="top" style="padding-left: 5px" width="210">            
            <%@include file="/fee/reports.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="left">
   
    <form  method="post" name="ent" action="<%=request.getContextPath()%>/List_Stud_Sub.do?method=studListAct2" onsubmit="return validate()">
<table width="60%" align="center">
<%if(request.getAttribute("sub")!=null){%>
<tr><td width="100%" align="center"><font style="font-size:12;color:darkblue"><b><%=request.getAttribute("sub")%></b></font></td></tr>
<%}%>  
<tr><td width="100%" align="center"><font style="font-size:14;color:darkblue"><b><u>Select Following Details</u></b></font></td></tr>
<tr><td width="100%" align="center"><font color="white"><b>Class:<select name="classes">
<%if(seo.getClasses().equals("")){%> 
<option value="">SELECT</option>     
<%}else{%>  
<option value="<%=seo.getClasses()%>"><%=seo.getClasses()%></option>   
<%}for(int i=0;i<ar.size();i++){
if(ar.get(i).equals(seo.getClasses())){continue;}
%>
<option value="<%=ar.get(i)%>"><%=ar.get(i)%></option>
<%}%>
</select>
<font color="white"><b>Session:<select name="session">    
<option value="<%=prev%>"><%=prev%></option>
<option value="<%=next%>"><%=next%></option>
</select>                       
<input type="submit" value="Display"></td></tr>
</table>
</form>
<table width="70%" align="center" bgcolor="lightyellow" border="1" bordercolor="blue" style="border-collapse:collapse">
<tr><td width="10%" align="center"><font style="font-size:11;color:darkblue"><b>SNO.</b></font></td>
<td width="20%"><font style="font-size:11;color:darkblue"><b>ADMIN_NO</b></font></td>
<td width="35%"><font style="font-size:11;color:darkblue"><b>NAME</b></font></td>
<td width="35%"><font style="font-size:11;color:darkblue"><b>CLASS</b></font></td>
<td width="35%"><font style="font-size:11;color:darkblue"><b>GENDER</b></font></td>
<td width="35%"><font style="font-size:11;color:darkblue"><b>FEES</b></font></td></tr>     
    <%for(int i=0;i<ar1.size();i++){
    fee=0.0;
    seo2=(SchoolEO)ar1.get(i); 
    fee=mm.retTotalFee(seo,seo2); 
    ar2=(ArrayList)mm.retStudSub(seo,seo2.getSrnum());
    %>     
<tr><td align="center"><font class="font"><%=i+1%></font></td>
<td><font class="font"><%=seo2.getSrnum()%></font></td>
<td><font class="font"><%=seo2.getSname().toUpperCase()%></font></td>
<td><font class="font"><%=seo.getClasses()%></font></td>
<td><font class="font"><%=seo2.getGender()%></font></td>
<td><font class="font"><%=fee%></font></td></tr> 
   <tr><td colspan="6">
   <table width="100%" border="1" bordercolor="blue" style="border-collapse:collapse">
   <tr><td width="15%"><font style="font-size:11;color:darkblue"><b>SUBJECT:</b></font></td>
   <%for(int j=0;j<ar2.size();j++){%>
   <td><font class="font"><%=ar2.get(j)%></font></td> 
   <%}%>
   </tr></table>
    <%ar2.clear();
    }%>
   </td></tr></table>
</td></tr> 
</table></td></tr>       


<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
