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
  document.forms[0].action="<%=request.getContextPath()%>/Ra.do?method=Ra";
  document.forms[0].submit();
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
    
    JavaBean jb=new JavaBean();
     JavaBean deg=new JavaBean();
     JavaBean be=new JavaBean();
     SchoolEO so=new SchoolEO();
        ArrayList BranchList=new ArrayList();

   ArrayList SubList=new ArrayList();
    if(request.getAttribute("degreebean")!=null){
    deg=(JavaBean)request.getAttribute("degreebean");
    }


   if(request.getAttribute("branchlist")!=null)
   {
   BranchList=(ArrayList)request.getAttribute("branchlist");
    }
   
   if(request.getAttribute("sublist")!=null)
   {
   SubList=(ArrayList)request.getAttribute("sublist");
 //  out.println(SubList);
    }
   if(request.getAttribute("jb")!=null){
    deg=(JavaBean)request.getAttribute("jb");
    }

%>
         
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
<table style="padding-left: 400px">
        <tr><td width="100%" align="center"><font style="font-size:16;color:darkblue"><b>View Subject Semester Wise</b></font></td></tr>
    </table></td></tr>
                <tr><td style="padding-left: 200px">
    <form name="f1" method="post" action="<%=request.getContextPath()%>/Rb.do?method=Rb">
    <table  align="center" border="1" style="border-collapse:collapse" width="500">
         
    
    <tr><td><font style="font-size:12;color:black"><b>Select Degree</b></font></td><td>
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


<tr><td><font style="font-size:12;color:black"><b>Select Branch</b></font></td><td>
<select name="branch">
    <option value="select one">select one</option>
    <%for(int i=0;i<BranchList.size();i++){
jb=(JavaBean)BranchList.get(i);
%>
<option value="<%=jb.getBranch()%>"><%=jb.getBranch()%></option>
<%}%>
    


</select>   
</td></tr>    

<tr><td><font style="font-size:12;color:black"><b>Semster</b></font></td><td>
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
    
    
    <tr><td colspan="2" align="center"><input type="submit" value="Submit"></td></tr>
    </table> 
    </form>
    
    
    
</td></tr>
              <tr><td style="padding-left: 200px"><table width="100%">
                  <tr><td><font style="font-size:16;color:darkblue;font-weight:bold">S.no.</font></td>
                 <td><font style="font-size:16;color:darkblue;font-weight:bold">Subject Code/Name</font></td>
               <td><font style="font-size:16;color:darkblue;font-weight:bold">Practical Status</font></td>
               <td><font style="font-size:16;color:darkblue;font-weight:bold">Update</font></td>
                  
                  </tr>
                <%for(int i=0;i<SubList.size();i++){
so=(SchoolEO)SubList.get(i);
%>
<tr><td><font style="font-size:16;color:white;font-weight:bold"><%=i+1%></font></td>
<td><font style="font-size:16;color:white;font-weight:bold"><%=so.getSub_code()%>-<%=so.getSub_name()%></font></td>
<td><font style="font-size:16;color:white;font-weight:bold"><%=so.getPrac()%></font></td>
<td><a href="">Update Subject</a></td>

</tr>
<%}%>
              </table></td></tr> 
               </table>
</td></tr> 
</table></td></tr>       
<tr><td valign="bottom" colspan="3"><%@include file="/footer.jsp"%></td></tr>
</table>
</body>
</html>
