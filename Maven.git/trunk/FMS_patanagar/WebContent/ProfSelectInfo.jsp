<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,com.myapp.struts.Dataconnectivity,java.util.*"%>
   <%!
      Connection con=null;
      PreparedStatement psmt1=null;
      PreparedStatement psmt2=null;
      Statement stmt=null;
      ResultSet rs1=null;
      ResultSet rs2=null;
      ResultSet rs=null;
      %>
   <% 
      ArrayList yr=new ArrayList();
      String ext="";
      String mx="";
      String pth="";
      String p=request.getParameter("pn");     
      if(p.equals("a")){
      pth="AdminMarksEnter.jsp";        
      }
      else{
      pth="MarksByProf.jsp";  
      }
      ArrayList ar1=new ArrayList();     
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
           int count=0;   
           String qr1="select distinct sessions from studinfo order by TO_NUMBER(substr(sessions,1,4)) desc";
           psmt1=con.prepareStatement(qr1);
           rs1=psmt1.executeQuery();
           while(rs1.next()){
            yr.add(rs1.getString("sessions"));
            count++;
            if(count==2){break;}
           }            
           String qr2="select deg_name from degree_details";
           psmt2=con.prepareStatement(qr2);
           rs2=psmt2.executeQuery();
           while(rs2.next()){              
            ar4.add(rs2.getString("deg_name"));             
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
         <link rel="stylesheet" type="text/css"  href="/Exam/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="/Exam/menu1.css">
         <link rel="stylesheet" type="text/css"  href="/Exam/menu.css">
         <link rel="stylesheet" type="text/css"  href="/Exam/mystyle1.css">
         <script language="javascript" src="/Exam/menu.js"></script>          
         <script language="javascript" src="/Exam/resolution.js"></script>
         
 <title>Home</title>
<base target="_parent">
<meta name="Microsoft Border" content="tlb, default">

        <title>Select</title>
        <script language="javascript"></script>
        </head>        
    <body bgcolor="white" onload="semester()">
    
<table width="100%" cellpadding="0" cellspacing="0" bgcolor="#455A8B"><tr><td>
<table width="100%" ><tr>
<td><%@include file="/toplook.jsp"%></td>
</tr>
</table>
<table border="0"  bgcolor="#EEEEEE" cellpadding=0 cellspacing =0 width="100%"  height="350">
 <tr><td valign=top><jsp:include page="/CommonLinks.jsp"/></td></tr>
<tr><td valign="top">    
    <table width="100" height="10"><tr><td></td></tr></table>
    <form name="f1" method="post" action="<%=request.getContextPath()%>/<%=pth%>?pr=1">
      
        <center><font color="#000080" size="3"><b>Enter Marks</b></font></center><br>
        <table align="center" border="1" >               
            <tr><td>Year</td><td align="left"><select name="yrs"> 
                <% 
                   for(int i=0;i<yr.size();i++){
                %>              
                <option value="<%=yr.get(i)%>"><%=yr.get(i)%></option>
               <%}%>
            </select></td></tr> 
              <tr><td>Semester</td><td align="left"><select name="sem">
                <% 
                   for(int i=1;i<=10;i++){
                %>                  
                <option value="<%=i%>"><%=i%>
                <%}%>
            </select></td></tr>
              <tr><td>Exam Type</td><td align="left"><select name="emxtyp">                 
                  <option value="INTERNAL">INTERNAL</option>
                  <option value="EXTERNAL">EXTERNAL</option>                  
                  <option value="COMPARTMENT">COMPARTMENT</option>
            </select></td></tr>
                <tr><td>Degree</td><td align="left"><select name="deg">
                <% 
                   for(int i=0;i<ar4.size();i++){
                %>                  
                <option value="<%=ar4.get(i)%>"><%=ar4.get(i)%>
                <%}%>
            </select></td></tr> 
           <tr><td height="20"></td></tr>
            <tr><td align="center" colspan="2"><input type="reset" value="reset">
            <input type="submit" value="submit"></td></tr></table>           
       <table align="center"><tr><td><font color=red size="2"><b>
 <%
if((String)request.getAttribute("msg")!=null)
{ %>
<%=(String)request.getAttribute("msg")%>
<%}%>
</b></font>
     </td></tr></table>        
    </form>
   
            </td></tr></table>

<tr><td valign="top">
<table width="100%" bgcolor="#5663C7"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr>

</td></tr></table>
           
    </body>
</html>
