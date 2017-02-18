 <% 
 if(session.getAttribute("loginid")!=null && session.getAttribute("password")!=null){
 %>
<table width="100%" align="center"><tr><td width="100%" align="right" valign="top"><a href="<%=request.getContextPath()%>/fee/FeeMainPage.jsp"><font color="darkblue" font-style="TimesRoman" size="2"><b><u>Home</u></b></font></a></td></tr></table>
<%}else{%>
<jsp:forward page="/logout.jsp"/>
<%}%>