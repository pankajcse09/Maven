/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author kapil
 */
public class Dataconnectivity_old {
    Connection cn =null;
    Properties ps=new Properties();
    private static Properties prop;
    
    public Connection Dataconnect()
    {
        ps.put("charSet","UTF-8");       
         ps.put("user","root");
        ps.put("password","");
//    ps.put("user","root");
//    ps.put("password","intelmind5944");
//    ps.put("password","int05944");
    
//    ps.put("user","dance7_admin");
//    ps.put("password","int05944");
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("Database is not Connected"); 
        }
        
        try{
            cn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/dance", ps);
//            cn=(Connection)DriverManager.getConnection("jdbc:mysql://198.38.82.101:3306/dance7_web", ps);
//            System.out.println(cn);
        }catch(Exception e)
        {
            e.getMessage();
        }
        return(cn);
    }

  public static void main(String ar[])
  {
      Dataconnectivity_old dc=new Dataconnectivity_old();
      System.out.println(dc.Dataconnect());
  }
}
