<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page language="java"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="EO.SchoolEO,AO.FeesChart"%>
<%@page import="java.util.*,java.sql.*,schedule.MyMethods"%>
<%@page import="com.myapp.struts.Dataconnectivity"%>

   <%! 
    Connection con=null;
    PreparedStatement psmt1=null;    
    PreparedStatement psmt2=null;
    ResultSet rs1=null;
    ResultSet rs2=null;
   %>
 <%  
   ArrayList ar1=new ArrayList(); 
   try
   {
    Dataconnectivity dc=new Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    } 
    catch(Exception e) 
       {      
       out.println(e.getMessage());
          } 
   SchoolEO seo2=new SchoolEO();
   ArrayList arr3=new ArrayList(); 
 try
  {            
    String qr1="Select class from classes where type='BelowGraduate'";
    
             psmt1=con.prepareStatement(qr1);
             rs1=psmt1.executeQuery();
             while(rs1.next()) {             
             arr3.add(rs1.getString("class")); 
             } 
      String qr2="select heads from feeheads order by heads";
      psmt2=con.prepareStatement(qr2);
      rs2=psmt2.executeQuery();   
      while(rs2.next()){      
      ar1.add(rs2.getString("heads"));
      }   
    }
    catch(SQLException se){
    out.println(se.getMessage());
    }
   finally{
       try{
         if(rs1!=null){rs1.close();}  
         if(rs2!=null){rs2.close();}  
         if(psmt1!=null){psmt1.close();}
         if(psmt2!=null){psmt2.close();}
         if(con!=null){con.close();}
       }
      catch(SQLException se){
      out.println(se.getMessage());
     }
   }   
%>
<html>
<head>
<title>School Management System</title>
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/mymenu.css">
<script language="javascript" src="<%=request.getContextPath()%>/fee/resolution.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/fee/calendarDateInput.js"></script>  
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/fee/menu.css">
<script language="javascript" src="<%=request.getContextPath()%>/fee/menu.js"></script>    
    <script language="javascript">
     
  function chkvalidate()
{

if(document.feest.month.value=="")
{
alert("Please enter month");
document.feest.month.focus();
return (false);
} 
}
    </script>
    </head>
    <body>
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center">
<tr><td><jsp:include page="/fee/ftoplook.jsp"/></td></tr>
<tr><td width="100%" align="center">
<table border="0"  bgcolor="#EEEEEE" cellpadding="0" cellspacing ="0" width="100%" align="center"  height="330">
<tr><td width="100%"><jsp:include page="/fee/feeHomeLink.jsp"/></td></tr>   
<tr><td valign="top">    
<table width="60%" align="center"><tr><td align="center"><h3><font color="#34282C" >Fee Chart</font></h3></td></tr></table> 
<form name="feest" method="post" action="<%=request.getContextPath()%>/feech.do?sub=sub" onsubmit="return chkvalidate()">
<%if((String)request.getAttribute("msg")!=null)
    out.println("<font color='red'><b>"+(String)request.getAttribute("msg")+"</b></font>");%>
   <table width="30%" cellpadding="0" cellspacing="0" align="center">        
   <tr><td>Months:</td><td><select name="month">
      <option value="">-Select-</option>
      <option value="January">January</option>
      <option value="February">February</option>
      <option value="March">March</option>
      <option value="April">April</option>
      <option value="May">May</option>
      <option value="June">June</option>
      <option value="July">July</option>
      <option value="August">August</option>
      <option value="September">September</option>
      <option value="October">October</option>
      <option value="November">November</option>
      <option value="December">December</option>      
</select></td></tr>  
</table></td></tr>
<tr><td valign="top">

<table width="80%" align="center" border="0"> 
<tr><td width="100%">
<table border="1" width="100%" style="border-collapse:collapse">
<tr><td align="center" bgcolor="#DCDCDC"><b>Class</b></td>
<%for(int i=0;i<ar1.size();i++){%> 
<td align="center" bgcolor="#DCDCDC"><input type="hidden" name="heads" value="<%=ar1.get(i)%>"><b><%=ar1.get(i)%></b></td> 
<%}%>
</tr>
<%for(int j=0;j<arr3.size();j++){%>
<tr><td align="center"><input type="hidden" name="classes<%=j%>" value="<%=arr3.get(j)%>"><%=arr3.get(j)%></td> 
<%for(int i=0;i<ar1.size();i++){%>           
<td align="center" bgcolor="#DCDCDC"><input type="text" size="6" name="classes<%=j%>_<%=ar1.get(i)%>"></td>
<%}%>
</tr>
<%}%> 
</table>
</td></tr>
<tr><td align="center"><input type="submit" value="Submit"></td></tr>
</table>

</form>
</td></tr></table>
</td></tr>
<tr><td valign="bottom"><%@include file="/footer.jsp"%></td></tr>
</table>    
</body>
</html>