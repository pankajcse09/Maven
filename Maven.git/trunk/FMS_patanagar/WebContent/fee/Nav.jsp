<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic" %>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>




<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>JSP Page</title>
    </head>
    <body>

      <table  bgcolor="#A52A2A" valign="top" class="st">
       
  
<tr> <td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'" > 
<div align="left"><html:link action="/streg"><font size=3 color="white">Student Registration</font></html:link></div>
</td></tr>

      <tr> <td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'" > 
<div align="left"><html:link action="feesb.do?dispfee=dispfee"><font size=3 color="white">Fee Structure</font></html:link></div>
</td></tr>

<tr> <td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<html:link action="fine.do?dispfine=dispfine"><font size=3 color="white">Fine Structure</font></html:link></div>
</td></tr>
        
    <tr> <td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/osr"><font size=3 color="white">Old Student Registration</font></html:link></div>
</td></tr>
 <tr> <td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/usr"><font size=3 color="white">Update Student Record</font></html:link></div>
</td></tr>
   
<tr> <td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/fdisp"><font size=3 color="white">Submit Fee</font></html:link></div>
</td></tr>
<tr> <td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/onespay"><font size=3 color="white">One Check Payement</font></html:link></div>
</td></tr>
<tr> <td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/mulfee"><font size=3 color="white">Submit Multiple Student's Fee</font></html:link></div>
</td></tr>
<tr> <td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left">
</td></tr>
<tr> <td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/cancel"><font size=3 color="white">Cancel Bounced Check</font></html:link></div>
</td></tr>
<tr> <td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/mulcancel"><font size=3 color="white">Cancel Multiple Bounced Check</font></html:link></div>
</td></tr>
<tr> <td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/frameschedule.do"><font size=3 color="white">Schedule Exams</font></html:link></div>
</td></tr>
<tr><td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/delschedule.do"><font size=3 color="white">Delete Schedule</font></html:link></div>
</td></tr>

<tr> <td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/EnterClasses.do"><font size=3 color="white">Enter Classes</font></html:link></div>
</td></tr>

<tr> <td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/delclass.do"><font size=3 color="white">Delete Classes</font></html:link></div>
</td></tr>

<tr> <td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/eprofile.do"><font size=3 color="white">Enter Employee Profile</font></html:link></div>
</td></tr>
<tr> <td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/AllotSection"><font size=3 color="white">Allot Section</font></html:link></div>
</td></tr>
<tr> <td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/DailyAttendence.do"><font size=3 color="white">Daily Attendence</font></html:link></div>
</td></tr>
<tr> <td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/OfficialHoliday.do"><font size=3 color="white">Enter Official Holidays</font></html:link></div>
</td></tr>
<tr><td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/EnterNewSub.do"><font size=3 color="white">Enter Subjects</font></html:link></div>
</td></tr>
<tr><td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/EnterMarks.do"><font size=3 color="white">Enter Student Marks</font></html:link></div>
</td></tr>
<tr><td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/DisplayMarks.do"><font size=3 color="white">Display Student Marks</font></html:link></div>
</td></tr>
<tr><td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/Enter_All_Expenses.do"><font size=3 color="white">Enter Expenses</font></html:link></div>
</td></tr>    
<tr><td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/UpdateAllExp1.do?method=updateAllExp1"><font size=3 color="white">Update All Expenses</font></html:link></div>
</td></tr> 
<tr><td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/entawd.do"><font size=3 color="white">Enter Awards</font></html:link></div>
</td></tr>
<tr><td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><a href="meetmin.jsp"><font size=3 color="white">Meeting Minutes</font></a></div>
</td></tr>
<tr><td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/asctnt?content=adsetup"><font size=3 color="white">Enter Administrative Setup</font></html:link></div>
</td></tr>

<tr><td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/asctnt?content=struct"><font size=3 color="white">Enter School Structure</font></html:link></div>
</td></tr>
<tr><td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/asctnt?content=contactus"><font size=3 color="white">Enter Contactus Detail</font></html:link></div>
</td></tr>
<tr><td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/asctnt?content=reminder"><font size=3 color="white">Enter Important Reminders</font></html:link></div>
</td></tr>
<tr><td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/bmsg"><font size=3 color="white">Broadcast Message</font></html:link></div>
</td></tr>
<tr><td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/pmsg"><font size=3 color="white">Principle Message</font></html:link></div>
</td></tr>
<tr><td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/notice"><font size=3 color="white">Notice</font></html:link></div>
</td></tr>
<tr><td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/abt"><font size=3 color="white">About Us</font></html:link></div>
</td></tr>

        <tr><td bgcolor="#f5f5f5" height="25"> 
<div align="left"><font color="#A52A2A"><font size=4><b>Reports</b></font></div>
</td></tr>
    <tr> <td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/DisplaySchedule.do"><font size=3 color="white" >Display Exam Schedule</font></html:link></div>
</td></tr>  
<tr><td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><a href="totalfee.jsp"><font size=3 color="white">Display Fee Record Per Year</font></a></div>
</td></tr> 
        <tr><td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/dfee"><font size=3 color="white">Display Fee Records of Student</font></html:link></div>
</td></tr>
<tr> <td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/dfine"><font size=3 color="white">Display Fine Records</font></html:link></div>
</td></tr>
<tr> <td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/list"><font size=3 color="white">List Of Student And Detail</font></html:link></div>
</td></tr>
<tr><td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/Report1"><font size=3 color="white">All Expenses Report</font></html:link></div>
</td></tr>    
<tr><td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/dawd"><font size=3 color="white">Awards Record</font></html:link></div>
</td></tr>   
<tr><td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/dispholiday"><font size=3 color="white">Display Holiday</font></html:link></div>
</td></tr>   
<tr><td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/duprofile"><font size=3 color="white">Display/Update Employee Profile</font></html:link></div>
</td></tr>   
<tr><td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><a href="dispmeetingmin.jsp"><font size=3 color="white">Display Meeting Minutes</font></a></div>
</td></tr>   
<tr><td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><a href="meetingrecords.jsp"><font size=3 color="white">Meeting Records</font></a></div>
</td></tr>   
<tr><td class="btnav" onmouseover="style.backgroundColor='#696969';"
onmouseout="style.backgroundColor='#A52A2A'"> 
<div align="left"><html:link action="/fnscw"><font size=3 color="white">Fee Not Submitted</font></html:link></div>
</td></tr>
    </table>
    
    </body>
</html>
