<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css"  href="/Exam/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="/Exam/mymenu.css">
         <link rel="stylesheet" type="text/css"  href="/Exam/menu1.css">
         <link rel="stylesheet" type="text/css"  href="/Exam/menu.css">
         <link rel="stylesheet" type="text/css"  href="/Exam/mystyle1.css">
         <script language="javascript" src="/Exam/menu.js"></SCRIPT>          
         <script language="javascript" src="/Exam/resolution.js"></script>
        <title>JSP Page</title>
    </head>
    <body>

 
    <table align="center" cellspacing="1" cellpadding="0" height=20 bgcolor="#B0C4DE" width=100%><tr><td>
  <table width="90%" align="center"><tr> 
              <td class="menuNormal">
              <a href="<%=request.getContextPath()%>/ExamSched.jsp" class="menuitem">Schedule</a>
              </td>
                  <td width="1"><table><tr><td><img src="./image/sep.gif" width="1" height="18"></td></tr></table></td>    
              <td class="menuNormal"  >
              <a href="<%=request.getContextPath()%>/Reports/ProgressReport.jsp"  class="menuitem"  >Progress Report</a>
              </td>
                  <td width="1"><table><tr><td><img src="./image/sep.gif" width="1" height="18"></td></tr></table></td>    
              <td class="menuNormal">
              <a href="<%=request.getContextPath()%>/Reports/AnnualReport.jsp" class="menuitem">Annual Report</a>
              </td>
                  
                  <td width="1"><table><tr><td><img src="./image/sep.gif" width="1" height="18"></td></tr></table></td>    
              <td class="menuNormal">
              <a href="<%=request.getContextPath()%>/Reports/AnnualCompartment.jsp" class="menuitem">Annual Report after Compartment</a>
              </td>
                  <td width="1"><table><tr><td><img src="./image/sep.gif" width="1" height="18"></td></tr></table></td>    

             <td class="menuNormal">
             <a href="<%=request.getContextPath()%>/MainPage.jsp" class="menuitem">Home</a>
             </td>
                 <td width="1"><table><tr><td><img src="./image/sep.gif" width="1" height="18"></td></tr></table></td>    
             <td class="menuNormal">
             <a href="<%=request.getContextPath()%>/logout.jsp" class="menuitem">Logout</a>
             </td>
  </tr></table>
 </td></tr></table>
    
    </body>
</html>
