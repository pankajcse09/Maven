<%-- 
    Document   : rolesmenu
    Created on : Oct 20, 2014, 12:18:50 PM
    Author     : kapil
--%>

<table class="t" rules="column"> 
<tr><td valign="top" style="padding-left: 5px;" align="left">
    <font color="green" style="font-family:Times New Roman" size="4"><strong>User Roles</strong></font></td></tr>
<tr><td><a href="<%=request.getContextPath()%>/user_role.do">
            <input type="button" value="Define Role" style="width:180px"></a></td></tr>
<tr><td><a href="<%=request.getContextPath()%>/view_role.do?method=view_Role">
            <input type="button" value="View Role" style="width:180px"></a></td></tr>
<tr><td><a href="<%=request.getContextPath()%>/update_role.do?method=update_role">
            <input type="button" value="Update Role" style="width:180px"></a></td></tr>
<tr><td><a href="<%=request.getContextPath()%>/emp_reg_form.do">
            <input type="button" value="Employees Registration" style="width:180px"></a></td></tr>
<tr><td><a href="<%=request.getContextPath()%>/edit_emp_reg.do?method=allLoginIdAction">
            <input type="button" value="Edit Employees Registration" style="width:180px"></a></td></tr>
<tr><td><a href="<%=request.getContextPath()%>/showWindows.do?method=showWindowData">
            <input type="button" value="Open Online Window" style="width:180px"></a></td></tr>
          </table>