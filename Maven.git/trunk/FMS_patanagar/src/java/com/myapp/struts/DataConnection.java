package com.myapp.struts;

import java.sql.*;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.*;
import java.io.*;

public class DataConnection {
    
    /** Creates a new instance of DataConnectivity */
    public Connection Dataconnect() 
    {
        Connection cn=null;
//    String username ="root";    
//        String password="int05944";
        String username ="root";    
        String password="root";
//        String password="intelmind5944";
//        
        try{
           // Class.forName("com.sun.sql.jdbc.oracle.OracleDriver");
         //  Class.forName("oracle.jdbc.driver.OracleDriver");
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e)
        {
            e.printStackTrace();
         }
        try{
          //  cn=(Connection)DriverManager.getConnection("jdbc:sun:oracle://localhost:1521;SID=d12a ",username,password);
           // cn=(Connection)DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:p12b",username,password);
            cn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/fms_pantnagar",username,password);
//            cn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/collegec_fms",username,password);
        }catch(Exception e){}
       return(cn);
    }  
    
    public static void main(String d[])
{
 
DataConnection t= new DataConnection();
try{ 
Connection c= t.Dataconnect();
System.out.println(c);

}catch(Exception e){}
}
}