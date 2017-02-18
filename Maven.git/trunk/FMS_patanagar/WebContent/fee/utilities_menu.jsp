<%-- 
    Document   : utilities_menu
    Created on : Mar 22, 2013, 7:38:59 PM
    Author     : kapil
--%>

     <%@page import="User_Role.User_role_bean"%>
<%
User_role_bean urb=(User_role_bean)session.getAttribute("user_auth");
String s="yes";
%>
              <!--tab2--><table width="130" class="t" rules="column" border="0">
                 <!--<tr><td><a href="<%=request.getContextPath()%>/Cc_Entry.do"><input type="button" value="Enter CC Data" style="width:192px"></a></td></tr>
                  <tr><td><a href="<%=request.getContextPath()%>/Tc_Entry.do"><input type="button" value="Enter TC Data" style="width:192px"></a></td></tr>
                  <tr><td><a href="<%=request.getContextPath()%>/Cc_Update.do"><input type="button" value="Update CC Data" style="width:192px"></a></td></tr>
                  <tr><td><a href="<%=request.getContextPath()%>/Tc_Update.do"><input type="button" value="Update TC Data" style="width:192px"></a></td></tr>
                  <tr><td><a href="<%=request.getContextPath()%>/upload.do"><input type="button" value="Upload Student Pic" style="width:192px"></a></td></tr>-->
                  <%if(urb.getUr_create().equals(s)){%>
                  <tr><td><a href="<%=request.getContextPath()%>/college.do">
                              <input type="button" value="Add College" style="width:220px"></a></td></tr>
                  <tr><td><a href="<%=request.getContextPath()%>/hostel.do">
                              <input type="button" value="Add Hostel" style="width:220px"></a></td></tr>
                  <%}%>
                  <tr><td><a href="<%=request.getContextPath()%>/deg.do?method=Branchpage">
                              <input type="button" value="Add/Delete/View Degree" style="width:220px"></a></td></tr>
                  <!--<tr><td><a href="<%=request.getContextPath()%>/createbranch.do?method=Branchpage"><input type="button" value="Create Branches" style="width:192px"></a></td></tr>
                  <tr><td><a href="<%=request.getContextPath()%>/delbranch.do"><input type="button" value="Delete Branches" style="width:192px"></a></td></tr>
                  <tr><td><a href="<%=request.getContextPath()%>/Add_Subject.do"><input type="button" value="Add Course Subject" style="width:192px"></a></td></tr>
                  <tr><td><a href="<%=request.getContextPath()%>/view_Subject.do"><input type="button" value="View  Course Subject" style="width:192px"></a></td></tr>-->
                  <%if(urb.getUr_create().equals(s)){%>
                  <tr><td><a href="<%=request.getContextPath()%>/EnterFeeHeads.do?method=Branchpage">
                              <input type="button" value="Add Course Fee Head" style="width:220px"></a></td></tr>
                  <tr><td><a href="<%=request.getContextPath()%>/Add_Class_Fee.do?method=Branchpage">
                              <input type="button" value="Add Course Fee" style="width:220px"></a></td></tr>
                  <tr><td><a href="<%=request.getContextPath()%>/lastdate_entry.do">
                              <input type="button" value="Add Last Date Fee Submission" style="width:220px"></a></td></tr>
                  <tr><td><a href="<%=request.getContextPath()%>/newbeni.do?method=NewBeniDetail">
                              <input type="button" value="Add New Beni Details" style="width:220px"></a></td></tr>
                  <%}%>
                   <tr><td><a href="<%=request.getContextPath()%>/viewCollege.do?method=viewCollege">
                              <input type="button" value="View/Edit College" style="width:220px"></a></td></tr>
                  <tr><td><a href="<%=request.getContextPath()%>/viewHostel.do?method=viewHostel">
                              <input type="button" value="View/Edit Hostel" style="width:220px"></a></td></tr>
                  <tr><td><a href="<%=request.getContextPath()%>/disphd.do">
                              <input type="button" value="Display Course Fee Heads" style="width:220px"></a></td></tr>
                  <tr><td><a href="<%=request.getContextPath()%>/Edit_Class_Fee.do?method=Branchpage">
                              <input type="button" value="View/Edit Course Fee" style="width:220px"></a></td></tr>
                <!--<tr><td><a href="<%=request.getContextPath()%>/EnterClasses.do?method=Branchpage"><input type="button" value="Enter Semester" style="width:192px"></a></td></tr>
                  <tr><td><a href="<%=request.getContextPath()%>/delclass.do"><input type="button" value="Delete Semester" style="width:192px"></a></td></tr>-->
                  
                  <tr><td><a href="<%=request.getContextPath()%>/lastdate.do?method=get_lastdates">
                              <input type="button" value="View/Edit Last Date Fee Submission" style="width:220px"></a></td></tr>
                 
                  <!--<tr><td><a href="<%=request.getContextPath()%>/addTrp_route.do?method=trnsRt"><input type="button" value="Add Transportation Route" style="width:192px"></a></td></tr>
                  <tr><td><a href="<%=request.getContextPath()%>/editTrp_route.do?method=editTrp"><input type="button" value="Display Transportation Route" style="width:192px"></a></td></tr>-->
                  <tr><td><a href="<%=request.getContextPath()%>/enterBank.do?method=bankAct">
                              <input type="button" value="Enter/Delete/View Bank Name" style="width:220px"></a></td></tr>
                  <!--<tr><td><a href="<%=request.getContextPath()%>/Add_Subject.do"><input type="button" value="Update Subject" style="width:192px"></a></td></tr>-->
                  
                  <tr><td><a href="<%=request.getContextPath()%>/programmefee.do?method=programme_fee">
                              <input type="button" value="Enter/Delete/View Programme Fee" style="width:220px"></a></td></tr>
         <!--           
             <tr><td class="menuNormal" bgcolor="" valign="middle">
            <html:link action="/Cc_Entry.do" styleClass="menuitem" target="_top">Enter CC Data</html:link>
            </td></tr> 
             <tr><td class="menuNormal" bgcolor="" valign="middle">
            <html:link action="/Tc_Entry.do" styleClass="menuitem" target="_top">Enter TC Data</html:link>
            </td></tr> 
            
              <tr><td class="menuNormal" bgcolor="" valign="middle">
            <html:link action="/Cc_Update.do" styleClass="menuitem" target="_top">Update CC Data</html:link>
            </td></tr> 
             <tr><td class="menuNormal" bgcolor="" valign="middle">
            <html:link action="/Tc_Update.do" styleClass="menuitem" target="_top">Update TC Data</html:link>
            </td></tr> 
            
            <tr><td class="menuNormal" bgcolor="" valign="middle">
            <html:link action="/upload.do" styleClass="menuitem" target="_top">Upload Student Pic</html:link>
            </td></tr>      
            
              <tr><td class="menuNormal" bgcolor="" valign="middle">
             <html:link action="/createbranch.do?method=Branchpage" styleClass="menuitem" target="_top">Create Courses</html:link>
            </td></tr> 
            
             <tr><td class="menuNormal" bgcolor="" valign="middle">
              <html:link action="/delbranch.do" styleClass="menuitem" target="_top">Delete Courses</html:link>
            </td></tr> 
             <tr><td class="menuNormal" bgcolor="" valign="middle">
             <html:link action="/Add_Subject.do" styleClass="menuitem" target="_top">Add Course Subject</html:link>
            </td></tr>   
             
             <tr><td class="menuNormal" bgcolor="" valign="middle">
             <html:link action="/view_Subject.do" styleClass="menuitem" target="_top">View  Course Subject</html:link>
            </td></tr>   
            -->
             
            
            
            
            <!--<tr><td class="menuNormal" bgcolor="" valign="middle">
             <html:link action="/Add_Class_Type.do" styleClass="menuitem" target="_top">Add Class Type</html:link>
            </td></tr> -->
             
             
             
          <!--   
             <tr><td class="menuNormal" bgcolor="" valign="middle">
             <html:link action="/Add_Class_Fee.do" styleClass="menuitem" target="_top">Add Course Fee</html:link>
            </td></tr> 
               <tr><td class="menuNormal" bgcolor="" valign="middle">
             <html:link action="/Edit_Class_Fee.do" styleClass="menuitem" target="_top">Edit Course Fee</html:link>
            </td></tr>
            <tr><td class="menuNormal" valign="middle">
            <html:link action="/EnterFeeHeads" styleClass="menuitem" target="_top">Add Course Fee Head</html:link>
            </td></tr>
            <tr><td class="menuNormal" valign="middle">
            <html:link action="/disphd" styleClass="menuitem" target="_top">Display Course Fee Heads</html:link>
            </td></tr> 
          
             <tr><td class="menuNormal" bgcolor="" valign="middle">
             <html:link action="/EnterClasses.do" styleClass="menuitem" target="_top">Enter Class</html:link>
            </td></tr> 
             <tr><td class="menuNormal" bgcolor="" valign="middle">
              <html:link action="/delclass.do" styleClass="menuitem" target="_top">Delete Class</html:link>
            </td></tr> 
   
           <tr><td class="menuNormal" bgcolor="" valign="middle">
             <html:link action="/Add_Subject.do" styleClass="menuitem" target="_top">Update Subject</html:link>
            </td></tr>   
            -->
            
            
             
             <!-- <tr><td class="menuNormal" bgcolor="#EEEEEE" valign="middle">
             <html:link action="/sr.do" styleClass="menuitem" target="_top">Set Receipt No.</html:link>
            </td></tr>--> 
            </table>
        
