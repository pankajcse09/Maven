<%-- 
    Document   : fund_transfer
    Created on : Jun 3, 2014, 5:50:23 PM
    Author     : kapil
--%>

<%@page import="Reports.Reports_DB"%>
<%@page import="EO.SchoolEO"%>
<%
String b=request.getParameter("b");
String c=request.getParameter("c");
String d=request.getParameter("d");
String e=request.getParameter("e");
SchoolEO seo=new SchoolEO();
seo.setHeads_cat(b);
seo.setSession(c);
seo.setSession_sem(d);
seo.setTotalFee(Double.parseDouble(e));
Reports_DB rdb=new Reports_DB();
rdb.transfer_fund(seo);
out.println("TRANSFERED");
%>