<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*,com.myapp.struts.Dataconnectivity,java.util.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <%!
      Connection con=null;
      PreparedStatement psmt1=null;
      PreparedStatement psmt2=null;
      ResultSet rs1=null;
      ResultSet rs2=null;
   %>
   <% 
           String dg=""; 
           String bh=""; 
           String yr=""; 
           String sm=""; 
           String ssn=""; 
            try {
         Dataconnectivity dc1=new Dataconnectivity();
         con=(Connection)dc1.Dataconnect();
          } 
          catch (Exception e) {
          out.println("<h4>Database Connection Problem.</h4>");
          out.println("<h5>" + e.getMessage() + "</h5>");
          } 
          try{          
           String qr2="select sdntdeg,sentyear from ex_studnt_reg where stid='003'";
           psmt1=con.prepareStatement(qr2);
           rs1=psmt1.executeQuery();
           while(rs1.next()){
           dg=(String)rs1.getString(1);   
           String eyr=(String)rs1.getString(2);
           int in1=eyr.lastIndexOf("/");
           int in2=eyr.length();
           bh=eyr.substring(in1+1,in2);
           }
          }   
          catch(SQLException se){
              out.println(se.getMessage());              
          }  
      finally{
          try{
           if(rs1!=null){rs1.close();}
           if(psmt1!=null){psmt1.close();}          
           if(con!=null){con.close();}
          }
          catch(SQLException se){
              out.println(se.getMessage());
          }
      }
   %>
  <%=dg%>

   
 
   