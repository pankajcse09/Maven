<%@taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<html>
    <head>
    <style type="text/css">.t{border-collapse:collapse;border-color:lightblue}</style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">     
         <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu1.css">
      <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/menu.css">
           <link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/mystyle1.css">
          <script language="javascript" src="<%=request.getContextPath()%>/menu.js"></script>
      </head>      
    <body>
    <table class="navbar" width="100%" bgcolor="#B0C4DE">
     <tr>    
<td width="50" height="18" valign="middle"><a href="<%=request.getContextPath()%>/MainPage.jsp"><font color="#000080" style="font-family:TimesNewRoman" size="2"><b>Home</b></font></a></td>
<td height="18" align="center" valign="middle"><table><tr><td><img src="./image/sep.gif" width="1" height="18"></td></tr></table></td>
<td valign="bottom"  class="menuNormal" width="50" onmouseover="expand(this);" 
      onmouseout="collapse(this);">
      <table><tr><td width="50" height="18" valign="middle"><font color="#000080" style="font-family:TimesNewRoman" size="2"><b>Add</b></font></td></tr></table>    
        <div class="menuNormal" width="100">
          <table width="90" border="1" class="t" rules="rows">      
            <tr><td class="menuNormal" valign="middle">
              <a href="./list_teacher.do" class="menuitem">Assign(Teacher-subject)</a>
            </td></tr> 
             <tr><td class="menuNormal" valign="middle">
              <a href="./view_teachertab.do" class="menuitem">View(Teacher-table)</a>
            </td></tr>             
             <tr><td class="menuNormal" valign="middle">
              <a href="./teacher_exam.do" class="menuitem">(Teacher-Exam)</a>
            </td></tr>             
             <tr><td class="menuNormal" valign="middle">
              <a href="./student_sub.do" class="menuitem">(Student_subject)</a>
            </td></tr>
             <tr><td class="menuNormal" valign="middle">
              <a href="./exam_sch.do" class="menuitem">(Exam_schedule)</a>
            </td></tr>   
            <tr><td class="menuNormal" valign="middle">
              <a href="./class_time_table.do" class="menuitem">class-time table</a>
            </td></tr>  
            </table>
        </div>
       </td>  
        <td height="18" align="center" valign="middle"><table><tr><td><img src="./image/sep.gif" width="1" height="18"></td></tr></table></td>  
<td valign="middle" class="menuNormal" width="100" onmouseover="expand(this);" 
      onmouseout="collapse(this);">
      <table><tr><td width="100" height="18"  valign="middle"><font color="#000080" size="2"><b>Attendence</b></font></td></tr></table>
            <div class="menuNormal" width="100">
          <table width="135" border="1" class="t" rules="rows">
             <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
              <a href="<%=request.getContextPath()%>/DailyAttendence.jsp" class="menuitem">Daily Attendence</a>
            </td></tr> 
             <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
              <a href="<%=request.getContextPath()%>/ExamAttendence.do" class="menuitem" >Exam Attendence</a>
            </td></tr>        
            </table>
        </div>
       </td>     
  <td height="18" align="center" valign="middle"><table><tr><td><img src="./image/sep.gif" width="1" height="18"></td></tr></table></td>  
<td  valign="bottom" class="menuNormal" width="110" onmouseover="expand(this);" 
      onmouseout="collapse(this);">
      <table><tr><td width="100" height="10"><font color="#000080" style="font-family:TimesNewRoman" size="2"><b>Course Utility</b></font></td></tr></table>
          <div class="menuNormal" width="100">
          <table width="128" border="1" class="t" rules="rows">
            <tr><td class="menuNormal" bgcolor="#B0C4DE" valign="middle">
             <a href="<%=request.getContextPath()%>/Courses_Detail/Courses_Detail.jsp"  class="menuitem">Course Detail</a>
            </td></tr>
            <!--<tr><td class="menuNormal" valign="middle">
              <a href="<%=request.getContextPath()%>/Courses_Detail/CourseMarks.jsp" class="menuitem">Enter Marks for Course</a>
            </td></tr>-->
            <tr><td class="menuNormal" valign="middle">
             <a href="<%=request.getContextPath()%>/Courses_Detail/EditCourse.jsp" class="menuitem">Edit Course Detail</a>
            </td></tr>
            <tr><td class="menuNormal" valign="middle">
             <a href="<%=request.getContextPath()%>/Courses_Detail/RemoveCourse.jsp"  class="menuitem">Remove Course</a>
            </td></tr>            
            </table>
        </div>
      </td>  
  <td height="18" align="center" valign="middle"><table><tr><td><img src="./image/sep.gif" width="1" height="18"></td></tr></table></td>  
  <td valign="middle" class="menuNormal" width="110" onmouseover="expand(this);" 
      onmouseout="collapse(this);">
      <table><tr><td height="18" align="center" valign="middle"><font color="#000080" style="font-family:TimesNewRoman" size="2"><b>Sched Exam</b></font></td></tr></table>    
        <div class="menuNormal" width="100">
          <table width="170" border="1" class="t" rules="rows">
              <tr><td class="menuNormal" valign="middle">
              <a href="<%=request.getContextPath()%>/ScheduleHolidays.jsp" class="menuitem">Set Holidays</a>
            </td></tr>
          </table>
        </div>
      </td>  
<td height="18" align="center" valign="middle"><table><tr><td><img src="./image/sep.gif" width="1" height="18"></td></tr></table></td>   
<td  valign="middle" class="menuNormal" width="100" onmouseover="expand(this);" 
      onmouseout="collapse(this);">
      <table><tr><td width="100" height="18"  valign="middle"><font color="#000080" style="font-family:TimesNewRoman" size="2"><b>Marks Utility</b></font></td></tr></table>
         <div class="menuNormal" width="100">
          <table width="135" border="1" class="t" rules="rows">
            <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
            <a href="<%=request.getContextPath()%>/SelectInfo.jsp?pn=p"  class="menuitem" >Enter Marks</a>
            </td></tr>
            <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
            <a href="<%=request.getContextPath()%>/SelectInfo_1.jsp?pn=p"  class="menuitem" >Update Marks</a>
            </td></tr>        
            </table>
        </div>
       </td>  
      <td height="18" align="center" valign="middle"><table><tr><td valign="middle"><img src="./image/sep.gif" width="1" height="18"></td></tr></table></td> 

<td  valign="middle" class="menuNormal" width="70" onmouseover="expand(this);" 
      onmouseout="collapse(this);">
      <table><tr><td width="100" height="18" align="center" valign="middle"><font color="#000080" style="font-family:TimesNewRoman" size="2"><b>Update</b></font></td></tr></table>
        <!-- <div class="menuNormal" width="100">
          <table width="135" border="1" class="t" rules="rows">
            <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
              <a href="<%=request.getContextPath()%>/UpdateStudInfo.jsp"  class="menuitem" >Academic Information</a>
            </td></tr>
            <tr><td class="menuNormal" valign="middle">
              <a href="<%=request.getContextPath()%>/UpdateCompartStud.jsp" class="menuitem">Academic Information of Compartments</a>
            </td></tr>
            </table>
        </div>-->
      </td>  
      <td height="18" align="center" valign="middle"><table><tr><td height="18" align="center" valign="middle"><img src="./image/sep.gif" width="1" height="18"></td></tr></table></td>  
<td valign="bottom"  class="menuNormal" width="70" onmouseover="expand(this);" 
      onmouseout="collapse(this);">
      <table><tr><td width="100" height="18" valign="middle"><font color="#000080" style="font-family:TimesNewRoman" size="2"><b>Reports</b></font></td></tr></table>    
        <div class="menuNormal" width="100">
          <table width="128" border="1" class="t" rules="rows">
             <tr><td class="menuNormal" valign="middle">
              <a href="<%=request.getContextPath()%>/unit_test.do" class="menuitem">Unit Test Master Chart</a>
            </td></tr>            
             <tr><td class="menuNormal" valign="middle">
              <a href="<%=request.getContextPath()%>/unit_test_record.do" class="menuitem">Unit Test Record</a>
            </td></tr>
            <tr><td class="menuNormal" valign="middle">
              <a href="<%=request.getContextPath()%>/semster_exam.do" class="menuitem">Semster Exam</a>
            </td></tr>           
            </table>
        </div>
      </td>  
 
      
       <td height="18" align="center" valign="middle"><table><tr><td height="18" align="center" valign="middle"><img src="./image/sep.gif" width="1" height="18"></td></tr></table></td>  
<td valign="bottom"  class="menuNormal" width="70" onmouseover="expand(this);" 
      onmouseout="collapse(this);">
      <table><tr><td width="100" height="18" valign="middle"><font color="#000080" style="font-family:TimesNewRoman" size="2"><b>Expenses</b></font></td></tr></table>    
        <div class="menuNormal" width="100">
          <table width="128" border="1" class="t" rules="rows">
             <tr><td class="menuNormal" valign="middle">
              <a href="<%=request.getContextPath()%>/unit_test.do" class="menuitem">Enter Expenses</a>
            </td></tr>            
             <tr><td class="menuNormal" valign="middle">
              <a href="<%=request.getContextPath()%>/unit_test_record.do" class="menuitem">Update Expenses</a>
            </td></tr>
            <tr><td class="menuNormal" valign="middle">
              <a href="<%=request.getContextPath()%>/semster_exam.do" class="menuitem">Expenses Report</a>
            </td></tr>           
            </table>
        </div>
      </td>  
        <td height="18" align="center" valign="middle"><img src="./image/sep.gif" width="1" height="18"></td>
      <td width="50" height="18" align="center" valign="middle"><a href="<%=request.getContextPath()%>/Logout.do?method=logout">
<font color="#000080" style="font-family:TimesNewRoman" size="2"><b>Logout</b></font></a></td></tr>

    </table>    
</body>
</html>
