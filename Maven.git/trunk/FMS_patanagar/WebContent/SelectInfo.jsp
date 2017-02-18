<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*,com.myapp.struts.Dataconnectivity,java.util.*,schedule.MyMethods"%>
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
      ArrayList ar1=new ArrayList();     
      ArrayList ar4=new ArrayList();
      MyMethods mm=new MyMethods();
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
           String qr1="select distinct sessions from studinfo order by convert(substring(sessions,1,4),unsigned) desc";
           psmt1=con.prepareStatement(qr1);
           rs1=psmt1.executeQuery();
           while(rs1.next()){
            yr.add(rs1.getString("sessions"));
            count++;
            if(count==2){break;}
           }            
           String qr2="select class from classes";
           psmt2=con.prepareStatement(qr2);
           rs2=psmt2.executeQuery();
           while(rs2.next()){              
            ar4.add(rs2.getString("class"));             
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
 <style type="text/css">.t{border-collapse:collapse}</style>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<meta http-equiv="Content-Language" content="en-us">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
         <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>         
         <script language="javascript" src="<%=request.getContextPath()%>/resolution.js"></script>         
 <title>Home</title>
<base target="_parent">
<meta name="Microsoft Border" content="tlb, default">
        <title>Select</title>
        <script language="javascript">
       function validate(){
       for(i=0;i<document.f1.elements.length;i++){    
       if(document.f1.elements[i].value==""){
       alert("Select Value");
       document.f1.elements[i].focus();
       return false;
       }  
       }       
       return true;
       }   
         function changetype(){
         var cls=document.f1.classes.value;
         var obj='';
         var str='';
         if(cls=="10" || cls=="12"){
         str+='<select name=\"examtype\"><option value=\"MOCK TEST ONE\">MOCK TEST ONE</option>';
         str+='<option value=\"MOCK TEST TWO\">MOCK TEST TWO</option><option value=\"MOCK TEST THREE\">MOCK TEST THREE</option>';
         str+='<option value=\"FIRST PREBOARD\">FIRST PREBOARD</option><option value=\"SECOND PREBOARD\">SECOND PREBOARD</option></select>';
         } 
         else{
         str+='<select name=\"examtype\"><option value=\"UNIT TEST ONE\">UNIT TEST ONE</option>';
         str+='<option value=\"HALF YEARLY\">HALF YEARLY</option><option value=\"UNIT TEST TWO\">UNIT TEST TWO</option>';
         str+='<option value=\"FINAL\">FINAL</option></select>';
        }
        obj=document.getElementById('typ');
        obj.innerHTML=str;        
         }            
        </script>
        </head>        
<body bgcolor="white" onload="semester()">    
<table width="800" cellpadding="0" cellspacing="0" bgcolor="#455A8B" align="center">
<tr><td><%@include file="/toplook.jsp"%></td></tr>
<tr><td>
<table border="0"  bgcolor="#EEEEEE" cellpadding=0 cellspacing =0 width="100%" height="330">
<tr><td width="100%"><%@include file="/HomeLink.jsp"%></td></tr>     
<tr><td valign="top">    
    <table width="100" height="10"><tr><td></td></tr></table>
    <form name="f1" method="post" action="<%=request.getContextPath()%>/SelectInfoAct.do?method=selectInfoAction" onsubmit="return validate();">      
        <center><font color="#000080" size="3"><b>Enter Marks</b></font></center><br>
        <table align="center" border="1" class="t">  
      <tr><td>Session:</td><td colspan="3"><select name="sessions"> 
       <option value="">Select</option> 
       <%for(int i=2000;i<=2020;i++){%>   
       <option value="<%=i%>-<%=i+1%>"><%=i%>-<%=i+1%></option>    
      <%}%>
     </select>
     </td></tr>
     <tr><td>Class</td><td><select name="classes" onchange="changetype()">
                <% 
                   for(int i=0;i<ar4.size();i++){
                %>                  
                <option value="<%=ar4.get(i)%>"><%=ar4.get(i)%>
                <%}%>
            </select></td><td>Section</td><td><select name="section">
                <% 
                   for(int i=65;i<=74;i++){
                %>                  
                <option value="<%=(char)i%>"><%=(char)i%>
                <%}%>
            </select></td></tr>           
            <tr><td>Exam Type</td><td align="left" colspan="3"><div id="typ"><select name="examtype">                 
                  <option value="UNIT TEST ONE">UNIT TEST ONE</option>
                  <option value="HALF YEARLY">HALF YEARLY</option>    
                  <option value="UNIT TEST TWO">UNIT TEST TWO</option>
                  <option value="FINAL">FINAL</option>
            </select></div></td></tr>
           <tr><td colspan="4">&nbsp;</td></tr>
            <tr><td align="center" colspan="4"><input type="submit" value="submit"></td></tr></table>           
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
