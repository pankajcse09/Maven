


        <%
        String username= (String)session.getAttribute("loginid");
        %>
        <%
       
if(username!=null&&session.getAttribute("loginid")!="guest"){%>
<font  style="text-decoration: none; color: #919188; font-size: 12px">Added to</font> <a href="<%=request.getContextPath()%>/mywishlist.do?method=retrieve_wishlist" style="color: brown; font-size: 12px">Wishlist</a>
        <%}
               else{%>
               <b><font style=" color: brown; font-size: 12px"><a href="<%=request.getContextPath()%>/customer_reg_form.do" style="color: brown; font-size: 12px">Please Login/Sign Up!</a> </font></b>
               <!--<a href="./customer_reg_form.do" style="text-decoration: none; color: brown; font-size: 12px">Sign In</a>-->
               <!--<table><tr><td><input typr="text" placeholder="email id"></td><td><input type="text" placeholder="password"></td></tr>
                   <tr><td><input type="button" value="login"></td></tr></table>-->
               <%}%>

   