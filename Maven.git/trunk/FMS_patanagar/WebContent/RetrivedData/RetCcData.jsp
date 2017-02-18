<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@page import="java.sql.*,java.util.*"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="AO.*"%>
<% 
    Connection con=null;
    PreparedStatement psmt=null;
    ResultSet rs=null;
    
    response.setHeader("Cache-Control","no-cache");
    response.setContentType("text/html");
    
    String en=request.getParameter("en");
    //String en="1";
    String st="";
try{                        
    DataConnection dc1=new DataConnection();
    con=(Connection)dc1.Dataconnect();
   }catch(Exception e){}
   try{
    String qr1="select * from cc_data where adminno='"+en+"'";    
    psmt=con.prepareStatement(qr1);
    rs=psmt.executeQuery();
    if(rs.next()){
    st=st+":"+rs.getString("adminno");
    st=st+":"+rs.getString("name");
    st=st+":"+rs.getString("classes");
    st=st+":"+rs.getString("fname");
    st=st+":"+rs.getString("from_sesn");    
    st=st+":"+rs.getString("to_sesn")+":";
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