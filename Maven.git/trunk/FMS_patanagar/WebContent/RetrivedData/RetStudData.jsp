<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.util.*"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="AO.*"%>
<% 
    Connection con=null;
    PreparedStatement psmt=null;
    ResultSet rs=null;
    
    response.setHeader("Cache-Control","no-cache");
    response.setContentType("text/html");
    
    //String en=request.getParameter("en");
    String en="20";
    String st="";
    try{                        
    DataConnection dc1=new DataConnection();
    con=(Connection)dc1.Dataconnect();
    }catch(Exception e){}
    try{
    String qr1="select * from studentregis where enroll_no='"+en+"'";    
    psmt=con.prepareStatement(qr1);
    rs=psmt.executeQuery();
    if(rs.next()){
    st=st+":"+rs.getString("session");
    st=st+":"+rs.getString("srnum");
    st=st+":"+rs.getString("studname");
    st=st+":"+rs.getString("dob");
    st=st+":"+rs.getString("doj");
    st=st+":"+rs.getString("gender");
    st=st+":"+rs.getString("nationality");
    st=st+":"+rs.getString("fname");
    st=st+":"+rs.getString("seekadd");
    st=st+":"+rs.getString("highper");
    st=st+":"+rs.getString("interper");
    st=st+":"+rs.getString("category");
    st=st+":"+rs.getString("year_regist");
    st=st+":"+rs.getString("class_regist");
    st=st+":"+rs.getString("standard");
    st=st+":"+rs.getString("pphone"); 
    st=st+":"+rs.getString("pmobile"); 
    st=st+":"+rs.getString("paddress"); 
    }
   }catch(SQLException se){}   
    finally{
    try{
    if(rs!=null){rs.close();}    
    if(psmt!=null){psmt.close();}   
    if(con!=null){con.close();}   
    }catch(SQLException se){}    
    }
out.println(st);
%>