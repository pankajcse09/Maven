<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%
  String fn=""; 
  if(session.getAttribute("loginid")!=null){
  fn=(String)session.getAttribute("loginid");
  } 
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
          <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></SCRIPT>
    </head>
    <body>

     
    <table width="100%" bgcolor="#34689A" border="0">
    <tr><td>
            <table width="100%" align="left" border="0">
                        <tr><td>
                                <table  width="100%">
                                                <tr><td>
                                                 <table width="100%" height="30" align="center">
                                                                                     <tr><td align="center" valign="middle"><font style="font-size:20;color:yellow"><b>SARDAR BHAGAT SINGH P.G. COLLEGE</b></font></td></tr>
                                                                                        
                                                         </table> 
                                                                                                                   
                                                                            </td></tr>
                                </table>
                        </td>
                        
            </table>
    <tr><td>
           
    </td></tr>
  <tr><td>
        <table width="100%"><tr>
                            <td align="left" width="40%"><font color="#FAFAD2" size="2"><b>Developed By: IntelMind Information Technology Pvt.Ltd</b></font></td>

 <%if(session.getAttribute("loginid")!=null){
 %>   
                            <td width="100%" align="right"><font color="yellow">Logged by:</font>&nbsp;<font color="white"><u><%=fn%></u></font></td></tr>
        </table></td></tr>  
 <%}%>  
     </td></tr>
    </table>    
</body>
</html>
