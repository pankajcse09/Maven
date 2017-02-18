<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.util.*"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="AO.*"%>
<% 
    response.setHeader("Cache-Control","no-cache");
    response.setContentType("text/html");
    
    Connection con=null;
    PreparedStatement psmt1=null;
    ResultSet rs1=null;
    ArrayList ar=new ArrayList();
    try{
    DataConnection dc=new DataConnection();
    con=(Connection)dc.Dataconnect();
    }catch(Exception e){}    
    String ssn=request.getParameter("session");
    String by=request.getParameter("by");
    String cls=request.getParameter("cls");
    //String by="SUBJECT";
    //String cls="ALL";    
    String st="";
    if(by.equals("CATEGORY")){
    ar.add("ALL");
    ar.add("GENERAL");
    ar.add("SC");
    ar.add("ST");
    ar.add("OBC");
    }
    if(by.equals("GENDER")){
    ar.add("ALL");
    ar.add("MALE");
    ar.add("FEMALE");
    }   
    if(by.equals("SUBJECT")){
    String qr="";
    if(cls.equals("ALL")){    
    qr="select distinct subject from class_sub";    
    }else{
    qr="select distinct subject from class_sub where class='"+cls+"'";      
    }
    psmt1=con.prepareStatement(qr);
    rs1=psmt1.executeQuery();
    while(rs1.next()){   
    ar.add(rs1.getString("subject"));    
    }
    }
%>