<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<%@page import="AO.*,java.sql.*,java.util.*"%>
<%@page language="java"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="EO.SchoolEO"%>
<!DOCTYPE html>
       <%!
            Connection cn=null;
            Statement stmt=null;
            ResultSet rs=null;
          %>  
 <%
 String rowid="";
 if(request.getParameter("rowid")!=null){
 rowid=request.getParameter("rowid");
 }
           try{
          DataConnection dc1=new DataConnection();
          cn=(Connection)dc1.Dataconnect();
            }catch(Exception e){}
           try{               
           String id="select heads,head_type,head_ac from feeheads where rowid='"+rowid+"'";             
           stmt=cn.createStatement();
           rs=stmt.executeQuery(id);
           String heads="";   
           String htype="";
           String hac="";
           if(rs.next()){
           heads=rs.getString("heads");
           htype=rs.getString("head_type");
           hac=rs.getString("head_ac");
           }           
         %>  
<html>
    <head>
         <title>School Management System</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
           <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>
        <script language="javascript" src="<%=request.getContextPath()%>/validation.js"></script>         
<script type="text/javascript" src="calendarDateInput.js"></script>         
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
    <tr><td><center><font style="font-size:18;font-weight:bold;color:darkblue"><u>Update Head</u></font></center></td></tr>
</table></td></tr>
                <tr><td style="padding-left: 200px"> 
<form name="form5" action="<%=request.getContextPath()%>/uphd.do" method="post" onsubmit="return chkvalidate()">
<table  align="center" border="0" style="border-collapse:collapse" width="500">   
<tr><td width="30%"><b>Heads:</b></td><td><input type=text size="25" name="heads" value="<%=heads%>"></td></tr>
<tr><td width="30%"><b>Head Type:</b></td>
<td><select name="head_type">
<%if(!htype.equals("")){%>
<option value="<%=htype%>"><%=htype%></option> 
<%}if(!htype.equals("GENERAL")){%>   
<option value="GENERAL">GENERAL</option>  
<%}if(!htype.equals("TREASURY")){%> 
<option value="TREASURY">TREASURY</option> 
<%}%>  
</select></td></tr>
<tr><td width="30%">Head A/c No.</td><td><input type="text" name="head_ac" value="<%=hac%>"></td></tr>
<tr><td colspan="2" align="center"><input type="submit" value="Update"></td></tr> 
<%    
 }catch(SQLException e){}
       %> 
     </table>
    <input type="hidden" size="25" name="rowid" value="<%=rowid%>"> 
    </form>
  </td></tr>
            </table>
</td></tr> 
</table></td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
    
    
    














