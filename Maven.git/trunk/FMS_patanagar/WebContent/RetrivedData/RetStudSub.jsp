<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.util.*"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="EO.*,ActionClass.*"%>
<% 
SchoolEO seo=new SchoolEO();   
String cls=request.getParameter("cls"); 
seo.setSeekadd(cls);
MyMeth mm=new MyMeth();   
ArrayList ar=(ArrayList)mm.subList(seo);  
String st="";
for(int i=0;i<ar.size();i++){
st=st+":"+ar.get(i);
}
out.println(st);
%>


