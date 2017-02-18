package com.myapp.struts;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataMethods {
    
    /** Creates a new instance of DataMethods */
    static Connection con=null;
    static PreparedStatement pstmt=null;
    static ResultSet rs=null;
    
    public DataMethods(){}
   
   public ArrayList updateData(String stud,String session,String course){  
   try{    
   Dataconnectivity dcc=new Dataconnectivity();
   con=(Connection)dcc.Dataconnect();
   }
   catch(Exception e){}    
    ArrayList arr=new ArrayList();    
        try{             
           String st="select * from extmarks where studid='"+stud+"' and years='"+session+"' and course_id='"+course+"'";
           //in(select id from ex_course_detail where title='"+course+"')";         
           pstmt=con.prepareStatement(st);           
           rs=pstmt.executeQuery();
            while(rs.next()){   
              examEO obj=new examEO();
              obj.setStudid((String)rs.getString("studid"));
              obj.setSession((String)rs.getString("years"));
              obj.setSemester((String)rs.getString("semester"));
              obj.setDegree((String)rs.getString("degree"));
              obj.setCourseid((String)rs.getString("course_id"));
              obj.setExternal(rs.getDouble("external"));
              arr.add(obj);                  
           }           
           }
           catch(SQLException rr){}
       finally{
           try{
            if(rs!=null){rs.close();}
            if(pstmt!=null){pstmt.close();}
            if(con!=null){con.close();}
            }
           catch(SQLException se){}
       }
      return arr; 
    }
   
   public static void main(String a[]){
    ArrayList ar=new ArrayList();
    DataMethods dm=new DataMethods();
    ar=(ArrayList)dm.updateData("VAN-111","2003-2004","30037");
    System.out.println(ar);
   }
}
