package com.myapp.struts;

import java.sql.*;
//import javax.sql.DataSource;
//import javax.naming.*;


public  class Dataconnectivity  {
  
  public Connection Dataconnect() throws Exception  {
        Connection conn=null;
//      String username ="root";    
//        String password="int05944";
        String username ="root";    
        String password="root";
//        String password="intelmind5944";
        
//  try{
//    Context ctx = new InitialContext(); 
//    DataSource ds = (DataSource)ctx.lookup("java:/OracleDS"); 
//    conn = ds.getConnection();  
//     }
//  catch(Exception e){}
//   return conn;            
        
        try{                
//          Class.forName("com.sun.sql.jdbc.oracle.OracleDriver");           
          //  Class.forName("oracle.jdbc.driver.OracleDriver");
          Class.forName("com.mysql.jdbc.Driver");   
        }
        catch(ClassNotFoundException e) {
         e.printStackTrace();
        }
        
      try{
         //conn=(Connection)DriverManager.getConnection("jdbc:sun:oracle://localhost:1521;SID=p12a",username,password);             
         // "jdbc:sun:oracle://localhost:1521;SID=p12a",username,password); 
         //conn=(Connection)DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:exam",username,password);
       conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/fms_pantnagar",username,password);
        // conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/collegec_hld",username,password);
      } 
      catch(Exception e){}       
      return conn;   
  }  
 
public static void main(String a[])
{
 Connection c=null;   
try{ 
Dataconnectivity t= new Dataconnectivity();
c= t.Dataconnect();
 System.out.println(c);
 }
catch(Exception e){}
 try{
String qry="select * from loginn";
Statement st= c.createStatement();
 ResultSet rs=  st.executeQuery(qry);
  while(rs.next())
  {
   System.out.println(rs.getString("username"));
  } 
 }
 catch(Exception e){}  
}
 
}
