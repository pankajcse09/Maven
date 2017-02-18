<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.sql.*"%>
<%@page import="com.myapp.struts.Dataconnectivity"%>
<%@page import="com.myapp.struts.Common"%>

<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css"  href="/Exam/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="/Exam/menu1.css">
         <link rel="stylesheet" type="text/css"  href="/Exam/menu.css">
         <link rel="stylesheet" type="text/css"  href="/Exam/mystyle1.css">
         <script language="javascript" src="/Exam/menu.js"></SCRIPT>          
         <script language="javascript" src="/Exam/resolution.js"></script>
</head>   
<body onload="window.history.forward(1)">

<table width="100%" cellpadding="0" cellspacing="0" bgcolor="#455A8B"><tr><td>
<table width="100%" ><tr>
<td><%//@include file="/toplook.jsp"%></td>
</tr>
</table>
<table border="0"  bgcolor="#EEEEEE" cellpadding=0 cellspacing =0 width="100%"  height="350">

<tr><td valign="top">

  <%! Connection frgtcon=null;
       Statement st=null;
       ResultSet rs=null;
   %>

<%

try {
           
      Dataconnectivity dc1=new Dataconnectivity();
       frgtcon=(Connection)dc1.Dataconnect();
       
    } catch (Exception e) {
      
       e.printStackTrace();
          }


String pwd="";
String answer = request.getParameter("answer");
String loginid = request.getParameter("loginid");
String sa = request.getParameter("sa");

String qr= "select password from loginn where username='"+loginid+"'";
       st= frgtcon.createStatement();
       rs= st.executeQuery(qr);
      
       if(!sa.equals(answer)){
out.println("enter correct answer");      
      %>
   <html:link action="/forgetanswer"><font color="blue" size=1> <b><u>Back</b></u></font></html:link>     
<%
        } 
       
       else if(rs.next()){
       
                  pwd= rs.getString("password");                  
                  pwd=pwd.trim();
            Common comLogin = new Common();
      String spasswd = (String)comLogin.decrypt(pwd);
               spasswd=spasswd.trim();           
      
%>

                  Your Password is&nbsp;<%=spasswd%><br>
                  <a href="<%=request.getContextPath()%>/index.jsp"><font color="blue" size="1"> <b><u>Continue</b></u> </font></a>
      


<%  
       
       
       
       
       } 

%>


    
  </td></tr></table>

<tr><td valign="top">
<table width="100%" bgcolor="#5663C7"><tr><td><%//@include file="/btmnavi.jsp"%></td></tr></table>
</td></tr>

</td></tr></table>

   
   </table>
    
    </body>
</html>
