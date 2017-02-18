<%-- 
    Document   : stu_regis_detail
    Created on : Apr 13, 2013, 3:19:14 PM
    Author     : kapil
--%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page language="java"%>
<%@page import="java.sql.*,java.util.*,java.text.*"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="AO.*,EO.*"%>
<%@page import="Beans.JavaBean"%>
<!DOCTYPE html>
<% 
    Connection cn=null;
    Statement stmt=null;
    ResultSet rs=null;
    Statement stmt1=null;
    ResultSet rs1=null;
    Statement stmt2=null;
    ResultSet rs2=null;
    Statement stmt3=null;
    ResultSet rs3=null;
    
    int srnum=0;
    int srnum1=0;
    String classes="";
    String Eyear="";
    int Syear=0;
    String sesdate="";
    String prev="";
    String next="";
    SchoolEO seo=new SchoolEO();   
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat sdf2=new SimpleDateFormat("yyyy");
    java.util.Date dt=new java.util.Date();
    String dat=sdf.format(dt);
    String Styear=sdf2.format(dt);
    Syear=Integer.parseInt(Styear);    
    Eyear=new Integer(Syear+1).toString(); 
    prev=(Syear-1)+"-"+Syear;
    next=Syear+"-"+(Syear+1);
    seo.setSyear(Styear);
    seo.setEyear(Eyear);
    
    try{                   
     DataConnection dc=new DataConnection();
     cn=(Connection)dc.Dataconnect();
    }catch(Exception e){}
  
         try{           
             String qry="Select * from setsrnum";        
             stmt3=cn.createStatement();
             rs3=stmt3.executeQuery(qry);
             while(rs3.next())
             {
              srnum=rs3.getInt("srnum");
              // srnum=srnum1+1;                 
             }             
  } catch(SQLException e){}    
 
   ArrayList ar2=new ArrayList();
try{
           String sq="select class from classes";
             stmt2=cn.createStatement();
             rs2=stmt2.executeQuery(sq);
             while(rs2.next()){
             ar2.add(rs2.getString("class")); 
 }
}catch(SQLException e){}
 
if(request.getAttribute("jbean")!=null){
seo=(SchoolEO)request.getAttribute("jbean");   
}
ArrayList ar=(ArrayList)seo.getDataArray();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <script type="text/javascript" src="calendarDateInput.js"></script>
          <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script> 
    <script language="javascript" src="<%=request.getContextPath()%>/JSF/printData.js"></script>
 <title>School Management System</title>
    </head>
  <body bgcolor="#999933">
      <% ArrayList reg_dtl=new ArrayList();
      SchoolEO seo1=new SchoolEO();
      
        if(request.getAttribute("allist")!=null){
            reg_dtl=(ArrayList)request.getAttribute("allist");
        }
      %>
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
 <tr><td valign="top" style="padding-left: 5px;" align="left"><font color="green" style="font-family:Times New Roman" size="4"><strong>Registration/Student Utilities</strong></font></td>
     <td width="2" bgcolor="#000000"></td>
            </tr>
            <tr><td align="left"  valign="top" style="padding-left: 5px" width="200">            
            <%@include file="/fee/regist.jsp" %>
        </td>
        <td width="2" bgcolor="#000000"></td>
             <td valign="top" align="center"><table>
        
             <tr><td align="center"><a href="javascript:printRegis('printit')"><font color="blue" size="2"><u><b>PRINT</b></u></font></a></td> <td align="right"><a href="<%=request.getContextPath()%>/streg.do">New Registration</a></td></tr>
             <tr><td align="center" >
         <%if(request.getAttribute("existnum")!=null)
   out.println("<font color='red'><b>"+request.getAttribute("existnum")+"</b></font>");  
  if(request.getAttribute("msg")!=null)
   out.println("<font color='red'><b>"+request.getAttribute("msg")+"</b></font>");
   %> 
            </td> </tr>
           
             <tr><td style="padding-left: 50px">
         <div id="printit">
         <table border="0"  width="100%" bgcolor="#A89263" cellpadding="0" cellspacing="20">
             
            <% for(int i=0;i<reg_dtl.size();i++)
                 {
                seo=(SchoolEO)reg_dtl.get(i);
                %>
                <tr>
                    <td><font style="font-size:12" color="black"><b>Session:</b></font></td><td><%=seo.getSession()%></td>
                    <td><font style="font-size:12" color="black"><b>Admission Form No:</b></font></td><td><%=seo.getSrnum()%></td>
                </tr>
                <tr><td><font style="font-size:12" color="black"><b>Student Name:</b></font></td><td><%=seo.getSname()%></td></tr>
                <tr><td><font style="font-size:12" color="black"><b>Father Name:</b></font></td><td><%=seo.getFname()%></td></tr>
                 <tr><td><font style="font-size:12" color="black"><b>Degree:</b></font></td><td><%=seo.getDegree()%></td></tr>
                  <tr><td><font style="font-size:12" color="black"><b>Branch:</b></font></td><td><%=seo.getBranch()%></td></tr>
                   <tr><td><font style="font-size:12" color="black"><b>Facility:</b></font></td><td><%=seo.getFacility()%></td></tr>
                    <tr><td><font style="font-size:12" color="black"><b>Contact No.:</b></font></td><td><%=seo.getPhone()%></td></tr>
                     <tr><td><font style="font-size:12" color="black"><b>Registration Fee:</b></font></td><td><%=seo.getRegist_fee()%></td></tr>
            <%}%>
                    
         </table>
         </div>
          </td></tr>       
         
    </table>
</td></tr> 
</table></td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html> 