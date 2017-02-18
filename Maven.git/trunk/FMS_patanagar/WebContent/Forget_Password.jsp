<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.sql.*"%>
<%@page import="com.myapp.struts.Dataconnectivity"%>

   <%! 
       Connection frgtcon=null;
       Statement st=null;
       ResultSet rs=null;
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
         
        <title>Forget Password</title>
        <script language="javascript">
             function validate(f1){
if(document.f2.answer.value=="")
{
alert("please enter Answer");
document.f2.answer.focus();
return (false);
}
return (true);
}
</script>

    </head>
    <body onload="window.history.forward(1)" >
    
<table width="100%" align="center" cellpadding="0" cellspacing="0" bgcolor="#455A8B"><tr><td width="100%" align="center">
<tr><td align="center"><font color="Yellow" style="font-family:Comic Sans MS" size="5">Fee Management System</font></td></tr> 
<tr><td align="center"><font color="Yellow" style="font-family:Times New Roman" size="5"> College</font></td></tr>
<tr><td width="100%" align="center">
<table border="0"  bgcolor="#EEEEEE" cellpadding=0 cellspacing =0 width="100%"  height="350">

<tr><td valign="top">
<table width="100%"><tr><td width="100%" align="right"><a href="<%=request.getContextPath()%>/index.jsp"><font color="#000080">Home</font></a></td></tr></table>     
<br><br><br><br><br><br><br>
      <center> <table align="center" border="0" cellspacing="1" cellpadding="1">
            <thead>
                <tr>
                    <th></th>
                </tr>
            </thead>
            <tbody>
              <form  name="f1"  method="post" action="Forget_Password.jsp">
                  <tr>
                    <td>Enter Your User ID: <input type ="text" size=30  name ="usrsq"> </td>
                </tr>
                <tr>
                    <td align="center"><input type ="submit" size=30  value= "submit"> </td>
                </tr>
                </form> 
               
            </tbody>
        </table></center>
   <%

try {
           
      Dataconnectivity dc1=new Dataconnectivity();
       frgtcon=(Connection)dc1.Dataconnect();

    } catch (Exception e) {
      
       e.printStackTrace();
          }
  
try {
                  
          String usnme="";
           String sq="";
            String sa="";
         String pwd="";
      String usrsq= request.getParameter("usrsq");
      String qu="select * from loginn where username='"+usrsq+"'";
      
      
      st= frgtcon.createStatement();
       rs= st.executeQuery(qu);
       
      if(rs.next())
      {
              usnme= rs.getString("username");
             sq= rs.getString("secret_question");
             sa= rs.getString("answer"); 
               pwd=rs.getString("password");
      } 
       
      
       if(!usrsq.equals(usnme))
       
       {
   
      out.println("<center>Enter Correct UserID..</center> ") ;
              
     }
         
      if(usrsq=="" ) 
      { 
         out.println("<center> UserId Should Not Be Empty..</center>"); 
       
           }    
              
  else if (usrsq.equals(usnme))
        {
  
           
%> 
     
  
    
<form name="f2" method="post" action="answer.jsp" onSubmit="return validate(this.form)">
 <table align="center">
   <tr><td> Your Secret Question is .....<%=sq %></td></tr>
   <tr><td><input type=hidden name="loginid" value=<%= usnme %> ></td></tr>
   <tr><td><input type=hidden name="sa" value=<%= sa %> ></td></tr>
   <tr><td>Enter Answer <input type="text" name="answer"> </td></tr>   
   <tr><td><input type="submit" value=ok> </td></tr>   
      </table>
     </form>
  
<%   

      }
    
       

}catch(Exception e){}

%>

    </td></tr></table>

<tr><td valign="top">
<table width="100%" bgcolor="#5663C7"><tr><td><%@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr>

</td></tr></table>
  </body>
</html>

    
      
     
    
  
