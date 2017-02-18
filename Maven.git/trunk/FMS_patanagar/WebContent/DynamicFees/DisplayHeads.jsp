<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.util.*" %>
<%@page import="java.sql.*,schedule.*"%>
<%@page import="com.myapp.struts.Dataconnectivity"%>
<!DOCTYPE html>
<%!  
 Connection con=null; 
 PreparedStatement stmt1=null; 
 PreparedStatement stmt2=null;
 ResultSet rs1=null;
 ResultSet rs2=null; 
%>
<%
response.setHeader("Cache-Control","no-cache"); 

  JavaBeanExam jbe=new JavaBeanExam();
  ArrayList ar=new ArrayList();
   try
   {
    Dataconnectivity dc=new  Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    } 
    catch(Exception e){} 
// String qr1="select distinct sessions from ex_course_detail where convert(substring(sessions,1,4),unsigned)>=(select distinct max(convert(substring(sessions,1,4),unsigned)) from studinfo) order by convert(substring(sessions,1,4),unsigned)";        

    try{
      String qry="select heads,head_type,head_ac,rowid,fee_type from feeheads";
      stmt1=con.prepareStatement(qry);
      rs1=stmt1.executeQuery();   
      while(rs1.next()){    
      JavaBeanExam jbe2=new JavaBeanExam();    
      jbe2.setFeeHead(rs1.getString("heads"));
      jbe2.setHeadType(rs1.getString("head_type"));
      jbe2.setHeadAc(rs1.getString("head_ac"));
      jbe2.setRowid(rs1.getString("rowid"));
      jbe2.setFeeType(rs1.getString("fee_type"));
      ar.add(jbe2);
      }  
    }catch(SQLException se){}
   finally{
       try{
         if(rs1!=null){rs1.close();}  
         if(stmt1!=null){stmt1.close();}
         if(con!=null){con.close();}
       }
       catch(SQLException se){}
       }
 %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">  
<head>
<style type="text/css">.t{border-collapse:collapse}</style>
<script language="javascript" src="<%=request.getContextPath()%>/UnitTest/printData.js"></script>
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
   
   input[type=button]:visited {
       background-color: green;
   }
   
   .vr {
    width:2px;
    background-color:#000;
    position:absolute;
    top:151px;
    height: 664px;
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
<table style="padding-left: 350px">
<tr><td  valign="top" colspan="100%" align="center"><font style="font-size:18;font-weight:bold;color:darkblue">Display Heads</font></td></tr>
</table></td></tr>
                <tr><td style="padding-left: 100px"> 
   <form>
       <table  align="center" border="1" style="border-collapse:collapse" width="700" bgcolor="#FFFFCC">
 <%if(request.getAttribute("mess")!=null){%>
 <tr><td colspan="4" align="center"><font color='red'><b><%=request.getAttribute("mess")%></b></font></td></tr>
<%}%>
     <tr><td class="tdcolor1" width="5%"><b>Sr no.</b></td><td width="25%" class="tdcolor1"><b>Fee Type</b></td><td width="35%" class="tdcolor1"><b>Heads</b></td><td width="10%" class="tdcolor1"><b>Head Type</b></td><td width="15%" class="tdcolor1" colspan="1"><b>Head A/c No.</b></td><td width="15%" class="tdcolor1"></td></tr>    
<%for(int i=0;i<ar.size();i++){
jbe=(JavaBeanExam)ar.get(i);
%>     
<tr><td><%=i+1%></td>
    <td><%=jbe.getFeeType().toUpperCase()%></td>
    <td><%=jbe.getFeeHead().toUpperCase()%></td>
<td><%=jbe.getHeadType()%></td>
<td><%=jbe.getHeadAc()%></td>
<td>
    <!--<a href="<%//=request.getContextPath()%>/fee/updatehead.jsp?rowid=<%//=jbe.getRowid()%>">
        <font style="font-size:12;color:blue"><b>Update</b></font></a>-->
</td></tr>
<%}%>
</table>   
   </form> 
</td></tr>
            </table>
</td></tr> 
</table></td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>