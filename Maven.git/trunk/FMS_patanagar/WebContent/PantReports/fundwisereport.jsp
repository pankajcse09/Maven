<%-- 
    Document   : fundwisereport
    Created on : May 27, 2014, 3:56:12 PM
    Author     : kapil
--%>

<%@page import="Fee.FeeMath"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.text.*,java.util.*,java.sql.*"%>
<%@page import="com.myapp.struts.Dataconnectivity"%>
<%@page import="AO.*,EO.*"%>
<!DOCTYPE html>

<%!  
 Connection con=null; 
 PreparedStatement psmt1=null; 
 PreparedStatement psmt2=null;
 ResultSet rs1=null;
 ResultSet rs2=null;
%>
<% 
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
    java.util.Date dt=new java.util.Date();
    String Styear=sdf.format(dt);
    int Syear=Integer.parseInt(Styear);    
    String prev=(Syear-1)+"-"+Syear;
    String next=Syear+"-"+(Syear+1);
    ArrayList ar=new ArrayList();
    ArrayList ar2=new ArrayList();
    ArrayList ar3=new ArrayList();
    ArrayList ar4=new ArrayList();
    ar4.add("Both");
    ar4.add("I");
    ar4.add("II");
    
    try{
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    } 
    catch(Exception e){} 
   try{   
      String qry="select rowid,heads,field_name from feeheads order by heads";
      psmt1=con.prepareStatement(qry);
      rs1=psmt1.executeQuery();   
      while(rs1.next()){      
      ar.add(rs1.getString("heads"));
      ar2.add(rs1.getString("field_name"));
      } 
   
   }catch(SQLException se){}
   finally{
       try{
         if(rs1!=null){rs1.close();}  
         if(rs2!=null){rs2.close();}  
         if(psmt1!=null){psmt1.close();}
         if(psmt2!=null){psmt2.close();}
         if(con!=null){con.close();}
       }
       catch(SQLException se){}
       }
   ar3.add("ANY");
   ar3.add("UNIVERSITY DUES");
   ar3.add("STUDENT WELFARE DUES");
   ar3.add("COLLEGE OF AGRIBUSINESS DUES");
   ar3.add("FOOD SERVICE");
   ArrayList ar5=new ArrayList();
   ar5.add("UNIV. DUES");
   ar5.add("SWF DUES");
   ar5.add("FOOD SERVICE");
   ar5.add("CAB DUES");
   
SchoolEO seo=new SchoolEO();  
if(request.getAttribute("jbean")!=null){
seo=(SchoolEO)request.getAttribute("jbean");   
}
//ArrayList ar3=(ArrayList)seo.getDataArray();
String hd="";
if(request.getAttribute("hd")!=null){
hd=(String)request.getAttribute("hd");   
}
try{
    DecimalFormat df = new DecimalFormat("0.00");

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
         <script type="text/javascript" src="<%=request.getContextPath()%>/JSF/jquery.min.js"></script>
<title>Fundwise Amount</title>
<script language="javascript">
    function fund_transfer(a,b,c,d,e)
        {
            var url="<%=request.getContextPath()%>/PantReports/fund_transfer.jsp";
             url=url+"?b="+b+"&c="+c+"&d="+d+"&e="+e;   
            $.get( url, function( response ) {
                document.getElementById(a).innerHTML="<font style='color:red'>"+response+"</font>"; // server response
            });
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

.bt{background-color: green;
    color: #333333;}
         </style> 
    
 <table width="100%" class="res" cellpadding="0" cellspacing="0" align="center">
<tr><td align="center" width="100%" style="padding-top:0px" height="100"><%@include file="/fee/toplook_1.jsp"%></td></tr>
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
    <tr><td style="padding-left: 390px"><font color="darkblue" size="3"><u><b>Funds/Heads Amount Report</b></u></font></td></tr> 
</table>
<form name="f1" method="post" action="<%=request.getContextPath()%>/DispTotalHeadFee.do?method=totalHeadFee">
<table width="95%" align="center" border="1" style="border-collapse:collapse">
<tr><td width="20%"><font style="font-size:12;font-weight:bold">Session</font><br>
<select name="session">
<%if(!seo.getSession().equals("")){%>   
<option value="<%=seo.getSession()%>"><%=seo.getSession()%></option>
<%}if(!seo.getSession().equals(next)){%> 
<option value="<%=next%>"><%=next%></option>
<%}if(!seo.getSession().equals(prev)){%> 
<option value="<%=prev%>"><%=prev%></option>
<%}%>
</select>
<select name="session_sem">
<%if(!seo.getSession().equals("")){%>   
<option value="<%=seo.getSession_sem()%>"><%=seo.getSession_sem()%></option>
<%}%> 
<%for(int i=0;i<ar4.size();i++){
if(ar4.get(i).equals(seo.getSession_sem())){continue;}
%>    
<option value="<%=ar4.get(i)%>"><%=ar4.get(i)%></option>    
<%}%>
</select>
    </td>      
<td ><font style="font-size:12;font-weight:bold">Funds</font><br>
<select name="heads_cat">
<%if(!seo.getHeads_cat().equals("")){%>
<option value="<%=seo.getHeads_cat()%>"><%=seo.getHeads_cat()%></option>
<%}%>  

<%for(int i=0;i<ar3.size();i++){
if(ar3.get(i).equals(seo.getHeads_cat())){continue;}
%>    
<option value="<%=ar3.get(i)%>"><%=ar3.get(i)%></option>    
<%}%>
</select></td>
<td ><font style="font-size:12;font-weight:bold">Heads</font><br>
<select name="heads">
<%if(!seo.getHeads().equals("")){%>
<option value="<%=hd%>"><%=seo.getHeads()%></option>
<%}%>  
<option value="ALL/">ALL</option>
<%for(int i=0;i<ar.size();i++){
if(ar.get(i).equals(seo.getHeads())){continue;}
%>    
<option value="<%=ar.get(i)%>/<%=ar2.get(i)%>"><%=ar.get(i)%></option>    
<%}%>
</select>
<input type="submit" value="Submit"></td></tr></table>
</form>
<table width="95%" align="center" border="1" style="border-collapse:collapse" style="padding-top: 20px">
<tr><td width="20%"><font style="font-size:15;color:darkblue"><b>Session</b></font></td>
<td><font style="font-size:12"><b><%=seo.getSession()%> -<%=seo.getSession_sem()%></b></font></td></tr>
<tr><td width="20%"><font style="font-size:15;color:darkblue"><b>Funds</b></font></td>
<td><font style="font-size:12"><b><%=seo.getHeads_cat()%></b></font></td></tr>
<tr><td width="20%"><font style="font-size:15;color:darkblue"><b>Head</b></font></td>
<td><font style="font-size:12"><b><%=seo.getHeads()%></b></font></td></tr>
<tr><td width="20%"><font style="font-size:15;color:darkblue"><b>Total Fee(in Rs.)</b></font></td>
<td><font style="font-size:12"><b><%=df.format(seo.getFeeTotal())%></b></font></td></tr>  
</table>
<%
ArrayList heads_cat=seo.getDataArray2();
ArrayList heads_count=seo.getDataArray1();
ArrayList heads=seo.getDataArray3();
HashMap hm=seo.getDataMap3();
HashMap hm2=seo.getDataMap2();
//HashMap ftrn=seo.getDataMap4();
double tt1=0,tt2=0,tt3=0,tt4=0;
//out.println(ftrn);
%>
<%if(heads_cat.size()!=0&&hm.size()!=0){%>
<table width="100%" align="center">
    <tr><td align="right"><a href="javascript:printFeeReceipt('printit')"><font color="yellow" size="2"><u><b>PRINT</b></u></font></a></td>
    </tr></table>
    <div id="printit">
<table width="99%" align="center">
    <tr><td align="center"><b>FEE SUMMARY FOR THE SESSION <%=seo.getSession()%> -<%=seo.getSession_sem()%></b></td>
    </tr></table>
<table width="95%" border="1" style="border-collapse: collapse" align="center">
    <tr>
        <td><b>PARTICULARS</b></td>
        <%
        int i=0;
        for(i=0;i<heads_cat.size();i++){%>
        <td><b><%=ar5.get(i)%> </b></td>
        <%}%>
        <td><b>TOTAL</b></td>
    </tr>
    <%for(int j=0;j<heads.size();j++)
    {%>
    <tr><td style="font-size: 13px;"><%=heads.get(j)%></td>
        <%if(hm2.get(heads.get(j)).toString().equals("UNIVERSITY DUES"))
        {
            tt1=tt1+Double.parseDouble(hm.get(heads.get(j)).toString()); 
        %>
            <td align="right" style="font-size: 13px;"><%=hm.get(heads.get(j))%> </td><td></td><td></td><td></td>
        <%}else if(hm2.get(heads.get(j)).toString().equals("STUDENT WELFARE DUES")){
            tt2=tt2+Double.parseDouble(hm.get(heads.get(j)).toString()); 
        %>
            <td> </td><td align="right" style="font-size: 13px;"><%=hm.get(heads.get(j))%></td><td></td><td></td>
        <%}else if(hm2.get(heads.get(j)).toString().equals("FOOD SERVICE")){
            tt3=tt3+Double.parseDouble(hm.get(heads.get(j)).toString()); 
        %>
            <td></td><td></td><td align="right" style="font-size: 13px;"><%=hm.get(heads.get(j))%> </td><td></td>
        <%}else if(hm2.get(heads.get(j)).toString().equals("COLLEGE OF AGRIBUSINESS DUES")){
            tt4=tt4+Double.parseDouble(hm.get(heads.get(j)).toString()); 
        %>
        <td></td><td></td><td> </td><td align="right" style="font-size: 12px;"><%=hm.get(heads.get(j))%></td>
        <%}%>
        <td align="right" style="font-size: 13px;"><%=hm.get(heads.get(j))%></td></tr>
    <%}%>
    <tr><td><b>TOTAL</b></td>
        <td align="right"><b><%=df.format(tt1)%></b></td>
        <td align="right"><b><%=df.format(tt2)%></b></td>
        <td align="right"><b><%=df.format(tt3)%></b></td>
        <td align="right"><b><%=df.format(tt4)%></b></td>
        <td align="right"><b><%=df.format(tt1+tt2+tt3+tt4)%></b></td>
    </tr>
    
</table>
<%}%>
    </div>
</td></tr> 
</table></td></tr>       


<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
<%}catch(Exception e)
{
    //System.out.println("kp: "+e.getMessage());
}%>