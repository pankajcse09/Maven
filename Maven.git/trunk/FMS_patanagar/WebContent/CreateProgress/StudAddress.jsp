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
           String fn="";   
           String mn="";
           String ln="";
           String ha1="";
           String ha2="";
           String ct="";
           String stat="";
           String cn="";
      try {
         Dataconnectivity dc1=new Dataconnectivity();
         con=(Connection)dc1.Dataconnect();
          } 
          catch (Exception e) {
          out.println("<h4>Database Connection Problem.</h4>");
          out.println("<h5>" + e.getMessage() + "</h5>");
          } 
          try{          
           String qr2="select sfname,smname,slname,shomeadd1,stdhomead2,scty,stustate,stdcoun from ex_studnt_reg where stid='003'";
           psmt1=con.prepareStatement(qr2);
           rs1=psmt1.executeQuery();
           while(rs1.next()){
           fn=(String)rs1.getString(1);   
           mn=(String)rs1.getString(2);
           if(mn==null){
           mn="";
           }
           ln=(String)rs1.getString(3);
           ha1=(String)rs1.getString(4);
           ha2=(String)rs1.getString(5);
            if(ha2==null){
           ha2="";
           }
           ct=(String)rs1.getString(6);
           stat=(String)rs1.getString(7);
           cn=(String)rs1.getString(8);
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
 To,<BR>
 &nbsp;&nbsp;&nbsp;<%=fn%>&nbsp;<%=mn%>&nbsp;<%=ln%><br>
 &nbsp;&nbsp;&nbsp;<%=ha1%>,<%=ha2%><%=ct%><br>
 &nbsp;&nbsp;&nbsp;<%=stat%>,<%=cn%><br>
   
 
   