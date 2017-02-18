<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,com.myapp.struts.Dataconnectivity,java.util.*"%>

   <%!
      Connection con=null;
      PreparedStatement psmt1=null;
      PreparedStatement psmt2=null;
      ResultSet rs1=null;
      ResultSet rs2=null;
   %>
   <% 
      ArrayList ar1=new ArrayList();
      ArrayList ar2=new ArrayList();
      ArrayList ar3=new ArrayList();
      ArrayList ar4=new ArrayList();
             try {
         Dataconnectivity dc1=new Dataconnectivity();
         con=(Connection)dc1.Dataconnect();
          } 
               catch (Exception e) {
      out.println("<h4>Database Connection Problem.</h4>");
      out.println("<h5>" + e.getMessage() + "</h5>");
          } 
          try{
           String qr1="select";
           psmt1=con.prepareStatement(qr1);
           rs1=psmt1.executeQuery();
           while(rs1.next()){
            ar1.add(rs1.getString("years"));
            ar2.add(rs1.getString("semester"));
            ar3.add(rs1.getString("examtype"));
           }
           String qr2="select deg_name from degree_details";
           psmt1=con.prepareStatement(qr2);
           rs1=psmt1.executeQuery();
           while(rs1.next()){
            ar4.add(rs1.getString("deg_name"));           
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
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<meta http-equiv="Content-Language" content="en-us">
 <title>Home</title>
<base target="_parent"><link rel="stylesheet" type="text/css" href="/Exam/mystyle1.css">
<meta name="Microsoft Border" content="tlb, default">
<link rel="stylesheet"  href="/Exam/menu.css">
<script language="javascript" src="/Exam/menu.js"></script>
<script language="javascript" src="/Exam/resolution.js"></script>
        <title>Select</title>
        <script language="javascript"></script>
        </head>        
    <body bgcolor="white" onload="semester()">
    <table width="800" align="center"><tr><td valign="top" align="center">
    <table width="100%"><tr><td valign="top" align="center">
    <font color="white" size="5"><b>Exam Management System</b></font></td></tr></table>
    <table align="right"><tr><td align="right"><a href="<%=request.getContextPath()%>/SetExamDate.jsp"><font color="blue"><u><b>Back</b></u></font></a></td></tr></table>
    <table width="100" height="50"><tr><td></td></tr></table>
    <form name="f1" method="post" action="<%=request.getContextPath()%>/SelectCourse.jsp">
        <center><font color="green" size="3"><b>Select</b></font></center><br>
        <table align="center" border="1">               
            <tr><td>Year</td><td align="right"><select name="yrs">
                <% 
                   for(int i=0;i<ar1.size();i++){
                %>                  
                <option value="<%=ar1.get(i)%>"><%=ar1.get(i)%>
                <%}%>
            </select></td></tr> 
              <tr><td>Semester</td><td align="right"><select name="sem">
                <% 
                   for(int i=0;i<ar2.size();i++){
                %>                  
                <option value="<%=ar2.get(i)%>"><%=ar2.get(i)%>
                <%}%>
            </select></td></tr>
              <tr><td>Exam Type</td><td align="right"><select name="exmtyp">
                <% 
                   for(int i=0;i<ar3.size();i++){
                %>                  
                <option value="<%=ar3.get(i)%>"><%=ar3.get(i)%>
                <%}%>
            </select></td></tr>
                <tr><td>Degree</td><td align="right"><select name="deg">
                <% 
                   for(int i=0;i<ar4.size();i++){
                %>                  
                <option value="<%=ar4.get(i)%>"><%=ar4.get(i)%>
                <%}%>
            </select></td></tr>
            <tr><td>Course</td><td align="right"><select name="cors"></select></td></tr>
            <tr><td align="right" colspan="2"><input type="reset" value="reset">
            <input type="submit" value="submit"></td></tr></table>           
       <table align="center"><tr><td><font color="red" size="2"><b>
 <%
if((String)request.getAttribute("msg")!=null)
{ %>
<%=(String)request.getAttribute("msg")%>
<%}%>  
</b></font>           
     </td></tr></table>        
    </form> 
  </td></tr></table>
    </body>
</html>
