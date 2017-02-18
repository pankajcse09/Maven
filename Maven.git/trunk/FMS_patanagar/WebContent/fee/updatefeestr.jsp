<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page language="java"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="EO.SchoolEO"%>
<%@page import="AO.*"%>

   <!-- Developed by : Sonal Sharma
        Company      : IntelMind -->

<html>
    <head>
         <title>School Management System</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/mymenu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/fee/resolution.js"></script>
        <script language="javascript" src="<%=request.getContextPath()%>/fee/validation.js"></script>
  <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/menu.css">
        <script language="javascript" src="<%=request.getContextPath()%>/fee/menu.js"></script>      
  <script type="text/javascript" src="<%=request.getContextPath()%>/fee/calendarDateInput.js"></script>  
        <script language="JavaScript">

function chkvalidate()
{
 if(document.form5.intfee.value==""){
          alert("Please Enter Internal Fee ");
          document.form5.intfee.focus();
          return false;
          }
          else{
          var k=validint(2);
          if(k==false){return false;}
          }

if(document.form5.extfee.value==""){
          alert("Please Enter External Fee ");
          document.form5.extfee.focus();
          return false;
          }
          else{
          var k=validint(3);
          if(k==false){return false;}
          }

if(document.form5.empkidfee.value==""){
          alert("Please Enter Employee's son/daughter Fee ");
          document.form5.empkidfee.focus();
          return false;
          }
          else{
          var k=validint(4);
          if(k==false){return false;}
          }
}
</script>
    </head>
    <body>
 <table width="800" cellpadding="0" cellspacing="0" bgcolor="#34689A" align="center">
<tr><td><jsp:include page="/fee/ftoplook.jsp"/></td></tr>
<tr><td>
<table border="0"  bgcolor="#FFB76F" cellpadding=0 cellspacing =0 width="100%"  height="330">
<tr><td width="100%"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>   
<tr><td valign="top">
 <table height=450 align="center" width="100%" border="0"><tr><td valign="top">
 
    <form name="form5" action="<%=request.getContextPath()%>/upstr.do" method="post" onsubmit="return chkvalidate()">
    
  <table align="center"><tr><td><center><font color="#34282C" size="4"><u>Update Fee Structure</u></font></center></td></tr>
    <tr><td height=10></td></tr></table>
<table cellpadding="0" cellspacing="0" border="1" width="100%" align="center" >

</table>
 </td><tr>
 <tr><td valign="top">
<table cellpadding="0" cellspacing="2" border="2" width="60%" align="center">

<tr>
<td width="10%" align="center"><b>Class</b></td>
<td width="7%" align="center"><b>Jan</b></td>
<td width="7%" align="center"><b>Feb</b></td>
<td width="7%" align="center"><b>March</b></td>
<td width="7%" align="center"><b>April</b></td>
<td width="7%" align="center"><b>May</b></td>
<td width="7%" align="center"><b>June</b></td>
<td width="7%" align="center"><b>July</b></td>
<td width="7%" align="center"><b>August</b></td>
<td width="7%" align="center"><b>Sept.</b></td>
<td width="7%" align="center"><b>Oct.</b></td>
<td width="7%" align="center"><b>Nov.</b></td>
<td width="7%" align="center"><b>Dec.</b></td>
</tr>
         
         <%!
            Connection cn=null;
            Statement stmt1=null;
            Statement stmt=null;
            ResultSet rs=null;
            ResultSet rs1=null;
            
               ArrayList arr1=new ArrayList(); 
               ArrayList arr2=new ArrayList(); 
               ArrayList arr3=new ArrayList(); 
               ArrayList arr4=new ArrayList(); 
               ArrayList arr5=new ArrayList(); 
               ArrayList arr6=new ArrayList(); 
               ArrayList arr7=new ArrayList(); 
               ArrayList arr8=new ArrayList(); 
               ArrayList arr9=new ArrayList(); 
               ArrayList arr10=new ArrayList(); 
               ArrayList arr11=new ArrayList(); 
               ArrayList arr12=new ArrayList(); 
               ArrayList arr13=new ArrayList(); 
               
          %>   
   
           <% 
             String status=request.getParameter("ward"); 
              
           try{
          DataConnection dc1=new DataConnection();
            cn=(Connection)dc1.Dataconnect();

            }
               catch(Exception e){}
            try{
               
             String id="select * from feestructure  "; 
            stmt=cn.createStatement();
             rs=stmt.executeQuery(id);
                     
        while(rs.next())
        {
             arr1.add(rs.getString("class"));
             arr2.add(rs.getString("January"));
             arr3.add(rs.getString("February"));
             arr4.add(rs.getString("March"));
             arr5.add(rs.getString("April"));
             arr6.add(rs.getString("May"));
             arr7.add(rs.getString("June"));
             arr8.add(rs.getString("July"));
             arr9.add(rs.getString("August"));
             arr10.add(rs.getString("September"));
             arr11.add(rs.getString("October"));
             arr12.add(rs.getString("November"));
             arr13.add(rs.getString("December"));
           
         }
            
         %> 
<%
     int i=0;
for(i=0;i<arr3.size();i++){  
%>           
    <tr><input type=hidden size="6" name="classes<%=i%>" value="<%=arr1.get(i)%>" >
    <td><%=arr1.get(i)%></td>   
    <td><input type=text size="4" name="jan<%=i%>" value="<%=arr2.get(i)%>"></td>     
    <td><input type=text size="4" name="feb<%=i%>" value="<%=arr3.get(i)%>"></td>     
    <td><input type=text size="4" name="march<%=i%>" value="<%=arr4.get(i)%>"></td>     
    <td><input type=text size="4" name="april<%=i%>" value="<%=arr5.get(i)%>"></td>     
    <td><input type=text size="4" name="may<%=i%>" value="<%=arr6.get(i)%>"></td>     
    <td><input type=text size="4" name="june<%=i%>" value="<%=arr7.get(i)%>"></td>     
    <td><input type=text size="4" name="july<%=i%>" value="<%=arr8.get(i)%>"></td>     
    <td><input type=text size="4" name="august<%=i%>" value="<%=arr9.get(i)%>"></td>     
    <td><input type=text size="4" name="sep<%=i%>" value="<%=arr10.get(i)%>"></td>
     <td><input type=text size="4" name="oct<%=i%>" value="<%=arr11.get(i)%>"></td>
     <td><input type=text size="4" name="nov<%=i%>" value="<%=arr12.get(i)%>"></td>
     <td><input type=text size="4" name="dec<%=i%>" value="<%=arr13.get(i)%>"></td>
 
    </tr>
       
<%}%>

<%  
   arr1.clear();
   arr2.clear();
   arr3.clear();
   arr4.clear();
   arr5.clear();
   arr6.clear();
   arr7.clear();
   arr8.clear();
   arr9.clear();
   arr10.clear();
   arr11.clear();
   arr12.clear();
   arr13.clear();
   
   
 }catch(SQLException e)
            {}
       %>   <tr><td align="center"> <input type="submit" value="Update"></td></tr>
     </table>
     </td></tr></table>   
    </form>
  </td></tr></table>   
   
     <tr><td bgcolor=#34689A height=20><%@include file="/btmnavi.jsp"%></td></tr>
     </table>     
    </body>
</html>
    
    
    














