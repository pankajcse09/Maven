/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author kapil
 */
public class Dataconnectivity {
    Connection cn =null;
    Properties ps=new Properties();
    private static Properties prop;
    static InputStream input = null;
    
    public Connection Dataconnect()
    {
        Properties ps1=getProp();
        ps.put("charSet","UTF-8");
        ps.put("user",ps1.getProperty("dbUser"));
        ps.put("password",ps1.getProperty("dbPassword"));
    
//    ps.put("user","root");
//    ps.put("password","intelmind5944");
//    ps.put("password","int05944");
    
//    ps.put("user","dance7_admin");
//    ps.put("password","int05944");
        try
        {
            Class.forName(ps1.getProperty("driver"));
        }catch(ClassNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("Database is not Connected"); 
        }
        
        try{
//            cn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/dance", ps);
            cn=(Connection)DriverManager.getConnection(ps1.getProperty("dbURL"), ps);
//            cn=(Connection)DriverManager.getConnection("jdbc:mysql://198.38.82.101:3306/dance7_web", ps);
//            System.out.println(cn);
        }catch(Exception e)
        {
            e.getMessage();
        }
        return(cn);
    }
    
    
    static{
        try {
            if(prop==null)
                {
                input = Dataconnectivity.class.getResourceAsStream("ApplicationProperties.properties");
//                input = Dataconnectivity.class.getClass().getResourceAsStream("/com/myapp/struts/ApplicationProperties.properties");

		// load a properties file
                prop=new Properties();
		prop.load(input);
// System.out.println("properties: "+prop);
		// get the property value and print it out
//		System.out.println(prop.getProperty("dbUser"));

            }
	} catch (IOException ex) {           
//		ex.printStackTrace();
                
	} finally {
		if (input != null) {
			try {	
			input.close();
			} catch (IOException e) {
//				e.printStackTrace();
			}
		}
	}
    }
    public static Properties getProp(){
        return prop;
    }
  public static void main(String ar[])
  {
      Dataconnectivity dc=new Dataconnectivity();
     System.out.println(dc.Dataconnect());
  }
}
