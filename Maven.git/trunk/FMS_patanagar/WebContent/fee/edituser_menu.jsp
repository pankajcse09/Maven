<%-- 
    Document   : utilities_menu
    Created on : Mar 22, 2013, 7:38:59 PM
    Author     : kapil
--%>
<%
String loginid=(String)session.getAttribute("loginid");
%>
  
             <table width="130" class="t" rules="column" border="0">
                 <tr><td><a href="<%=request.getContextPath()%>/edit_prof.do?method=Edit_user_prof&loginid=<%=loginid%>">
                              <input type="button" value="Edit Profile" style="width:220px"></a></td></tr>

                  <tr><td><a href="<%=request.getContextPath()%>/edit_user_pass.do">
                              <input type="button" value="Change Password" style="width:220px"></a></td></tr>
                                  
            </table>
        
