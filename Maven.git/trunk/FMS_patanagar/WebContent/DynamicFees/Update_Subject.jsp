<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page language="java"%>
<%@page import="java.sql.*,java.util.*,java.text.*"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="AO.*,EO.*"%>
<%@page import="Beans.JavaBean"%>

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
   
    try{                   
     DataConnection dc=new DataConnection();
     cn=(Connection)dc.Dataconnect();
    }catch(Exception e){}   
ArrayList ar2=new ArrayList();
try{
    String sq="select class from classes";
    stmt2=cn.createStatement();
    rs2=stmt2.executeQuery(sq);
    while(rs2.next()){
    ar2.add(rs2.getString("class")); 
 }
}catch(SQLException e){}
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
           <script language="javascript">
               
               function retBlock(){
  document.forms[0].method="post";
  document.forms[0].action="<%=request.getContextPath()%>/RetBranch.do?method=retBranch";
  document.forms[0].submit();
  }
  </script>
  
    <title>JSP Page</title>
    </head>
    <body bgcolor="#999933">
    <%
    
    JavaBean jb=new JavaBean();
     JavaBean deg=new JavaBean();
   ArrayList BranchList=new ArrayList();
    if(request.getAttribute("degreebean")!=null){
    deg=(JavaBean)request.getAttribute("degreebean");
    }

   if(request.getAttribute("branchlist")!=null)
   {
   BranchList=(ArrayList)request.getAttribute("branchlist");
    }
%>
         


    <!--1--><table width="800" class="res" cellpadding="0" cellspacing="0" align="center" bgcolor="#A89263">
 <tr><td><%@include file="/fee/toplook.jsp"%></td></tr>
           <tr><td valign="top" height="240" bgcolor="">  
               <!--2--> <table height="" align="center" width="100%" border="0">
<tr><td valign="top">

    <table width="100%" align="center"><tr><td width="100%" align="center"><font style="font-size:16;color:darkblue"><b>Add Subject</b></font></td></tr></table>
    <form name="f1" method="post" action="<%=request.getContextPath()%>/Add_Sub.do?method=addSub_Semester">
    <table width="40%" align="center" border="1" style="border-collapse:collapse">
         
    
    <tr><td><font style="font-size:12;color:white"><b>Select Degree</b></font></td><td>
<select name="degree" onBlur="retBlock();">
    <%if(deg.getDegree().equals("")){%>  
    <option value="select one">select one</option>
    <%}%>
    <%if(!deg.getDegree().equals("")){%>    
<option value="<%=deg.getDegree()%>"><%=deg.getDegree()%></option> 
<%}%>
<option value="MBA">MBA</option>
<option value="BTECH">BTECH</option>



</select>   
</td></tr>    


<tr><td><font style="font-size:12;color:white"><b>Select Branch</b></font></td><td>
<select name="branch">
    <option value="select one">select one</option>
    <%for(int i=0;i<BranchList.size();i++){
jb=(JavaBean)BranchList.get(i);
%>
<option value="<%=jb.getBranch()%>"><%=jb.getBranch()%></option>
<%}%>
    


</select>   
</td></tr>    

<tr><td><font style="font-size:12;color:white"><b>Semster</b></font></td><td>
<select name="semester">

<option value="I Semester">I Semester</option>
<option value="II Semester">II Semester</option>
<option value="III Semester">III Semester</option>
<option value="IV Semester">IV Semester</option>
<option value="V Semester">V Semester</option>
<option value="VI Semester">VI Semester</option>
<option value="VII Semester">VII Semester</option>
<option value="VIII Semester">VIII Semester</option>
<option value="IX Semester">IX Semester</option>
<option value="X Semester">X Semester</option>


</select>   
</td></tr>    
<tr><td><font style="font-size:12;color:white"><b>Subject Code</b></font>

<input type="text" name="sub_code" value="" size="15"></td>
    <td><font style="font-size:12;color:white"><b>Subject Name</b></font>

<input type="text" name="sub_name" value="" size="15"></td>
    
    </tr> 
    <tr><td><font style="font-size:12;color:white"><b>Practical</b></font></td><td>
    <select name="prac">
     <option value="YES">YES</option>   
     <option value="NO">NO</option>  
    </select>    
    </td></tr> 
    <tr><td colspan="2" align="center"><input type="submit" value="Submit"></td></tr>
    </table> 
    </form>
    
</td></tr></table></td></tr> 
<tr><td valign="bottom"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
