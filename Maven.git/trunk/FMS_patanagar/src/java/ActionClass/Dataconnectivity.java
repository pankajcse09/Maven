package ActionClass;
import java.sql.*;
import javax.sql.DataSource;
//import javax.naming.Context;
//import javax.naming.NamingException;
//import javax.naming.*;
//import java.io.*;


public class Dataconnectivity  {
  
 public Connection Dataconnect()
 {
 Connection sd=null;
 DataSource d=null;
 String msg=null;
//        String username ="root";    
//        String password="int05944";
        String username ="root";    
        String password="root";
//        String password="intelmind5944";
 
  try{
      Class.forName("com.mysql.jdbc.Driver");
      
      
           // Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();

// Context c= new InitialContext();
// d= (DataSource)c.lookup("jdbc/portal");
 }catch(Exception ne){
 
 
//  {
//   System.out.println(ne);
//  ne.getCause();
//  ne.getExplanation();
 
 }
try{
//sd= d.getConnection();
  sd=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/fms_pantnagar",username,password);
//    sd=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/collegec_fms",username,password);    
}catch(SQLException se){}  
 return sd; 
 } 
public static void main(String ashish[])
{ 
Dataconnectivity t= new Dataconnectivity();
try{ 
Connection c=(Connection)t.Dataconnect();
System.out.println(c);
}catch(Exception e){ System.out.println(e.getMessage());}

} 
}
