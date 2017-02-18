<%-- 
    Document   : type
    Created on : Mar 1, 2015, 5:32:58 PM
    Author     : kapil
--%>

<%@page import="EO.HostelBean"%>
<%@page import="EO.CollegeBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pant.common.UtilityDB"%>
<%
String type=request.getParameter("type");
UtilityDB udb=new UtilityDB();
if(type.equalsIgnoreCase("college")){
    ArrayList al=udb.collegeList();
    CollegeBean cb=null;
    %>
    <select name="loginfor_name">
            <option value="">Select One</option>
     <%       
    for(int i=0;i<al.size();i++){
                cb=(CollegeBean)al.get(i);
            %>
            <option value="<%=cb.getCollegeCode()%>"><%=cb.getCollegeName()%></option>
            <%}%>
    </select>
<%}
else if(type.equalsIgnoreCase("hostel")){
    ArrayList al=udb.hostelList();
    HostelBean hb=null;
    %>
    <select name="loginfor_name">
            <option value="">Select One</option>
    <%for(int i=0;i<al.size();i++){
                hb=(HostelBean)al.get(i);
            %>
            <option value="<%=hb.getHostelCode()%>"><%=hb.getHostelName()%></option>
            <%}%>
    </select>
<%}
%>