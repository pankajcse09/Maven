<%-- 
  
    Created on : Mar 14, 2013, 6:19:05 PM
    Author     : kapil
--%>


                
                
                <% if(session.getAttribute("loginid")!=null&&session.getAttribute("loginid")!="guest"){
                    %>
                    <font color="white"><%=session.getAttribute("loginid")%>
                    |</font>
                    <a href="<%=request.getContextPath()%>/customer_logout.do?method=customer_logout" style="text-decoration: none; color: #EEF3F6">Logout</a>
                <%}%>
            
