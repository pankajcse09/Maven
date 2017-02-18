<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.text.*,java.util.*"%>
<%@page import="AO.*,EO.*,ActionClass.*"%>
<%
  SchoolEO seo=new SchoolEO();  
  MyMeth mm=new MyMeth();     
  String ssn=request.getParameter("ssn");
  String rn="";
  if(request.getParameter("rn")!=null){
  rn=request.getParameter("rn");    
  }        
  seo.setSession(ssn);
  seo.setRegistNo(rn);
  try{
  seo=(SchoolEO)mm.retEnrolledData(seo);  
  }catch(NullPointerException ne){}  
  String path="";
  if(!rn.equals("")){
  path=request.getContextPath()+"/StudPics/"+seo.getSession()+"/"+seo.getRegistNo()+"/"+seo.getRegistNo()+".jpg"; 
  }
  //mm.retrivePic(seo,path);    
  try{
%>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script language="javascript" src="<%=request.getContextPath()%>/printData.js"></script>
    <style type="text/css">
    .tab{background-repeat:no-repeat;background-position:center}
    </style>
    <title>Id Card</title>
    </head>
    <body onLoad="self.print();" style="margin-left:0;margin-right:0;margin-top:0;margin-bottom:0">
    <div id="printit"> 
    <table width="750" height="220" align="left" border="0"  cellspacing="0" cellpading="0">
    
    <tr><td colspan="3"><font style="font-size:14"><b> College, Haldwani (Nainital)</b></font></td></tr>           
    <tr><td colspan="3"><font style="font-size:12"><b>Session:</b></font>&nbsp;<font style="font-size:12"><%=seo.getSession()%></font></td></tr>    
    <tr>
<td width="15%" align="left" valign="top"><img src="<%=path%>" height="120" width="90"></td>
    <td width="45%" align="left"><table width="98%" align="center" background="<%=request.getContextPath()%>/image/HLD_LOGO2.jpg" class="tab" border="0" bordercolor="green" style="border-collapse:collapse" rules="none">
        
 <!--background="<%=request.getContextPath()%>/image/BgImage.jpg"-->
 
   <tr><td colspan="2"><font style="font-size:12"><b>Admin.No:</b></font>&nbsp;<font style="font-size:12"><%=seo.getRegistNo()%></font></td></tr>
    <tr><td colspan="2"><font style="font-size:12"><b>Fee Receipt No.</b></font>&nbsp;<font style="font-size:12"><%=seo.getFeeReceipt()%></font></td></tr>
    <tr><td colspan="2"><font style="font-size:12"><b>Name:</b></font>&nbsp;<font style="font-size:12"><%=seo.getSname().toUpperCase()%></font></td></tr>
    <tr><td colspan="2"><font style="font-size:12"><b>Father's Name:</b></font>&nbsp;<font style="font-size:12"><%=seo.getFname().toUpperCase()%></font></td></tr>
    <tr><td colspan="2"><font style="font-size:12"><b>Class:</b></font>&nbsp;<font style="font-size:12"><%=seo.getClasses().toUpperCase()%></font>&nbsp;&nbsp;&nbsp;<font style="font-size:12"><b>Group:</b></font>&nbsp;<font style="font-size:12"><%=seo.getType()%></font></td></tr>
    <tr><td colspan="2"><font style="font-size:12"><b>D.O.B:</b></font>&nbsp;<font style="font-size:12"><%=seo.getDob()%></font>&nbsp;&nbsp;&nbsp;<font style="font-size:12"><b>Phone No.</b></font>&nbsp;<font style="font-size:12"><%=seo.getMobile()%></font></td></tr>
    <tr><td colspan="2"></td></tr>
    <tr><td width="2%" height="40" valign="bottom" ><font style="font-size:12"><b>Sign. Procter</b></font></td><td width="3%" height="40"  valign="bottom"><font style="font-size:12"><b>Dated...............</b></font></td></tr>
    </table>
    </td>
    <td valign="top" width="40%">
    <table>
        <tr><td colspan="4">Allocated Subjects</td></tr>
        <tr>
        <%ArrayList sub=new ArrayList();
         sub=(ArrayList)seo.getSub(); 
       
         for(int k=0;k<sub.size();k++){
         %>
         <td><font style="font-size:12"><%=sub.get(k)%></font></td>
         <%}%>
  </tr></table>
    </td>
    
    
    </tr></table>
    </div>
    </body>
</html>
<%}catch(Exception e){}%>
