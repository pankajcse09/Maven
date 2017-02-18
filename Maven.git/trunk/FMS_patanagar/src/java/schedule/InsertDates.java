
package schedule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.myapp.struts.Dataconnectivity;
import java.util.*;
import java.text.*;
import schedule.dateDiff.*;

public class InsertDates {
    
    /** Creates a new instance of InsertDates */
    public InsertDates() {
    }
    public void insert(int j1,ArrayList ar1,String yr1,String extp1,String eo1,String dg1){
        int j=j1;
        ArrayList ar=ar1;
        String yr=yr1;
        String extp=extp1;
        String eo=eo1;
        String dg=dg1;
        String sd="";
        String qry2="";        
      Connection con=null;
       PreparedStatement stmt=null; 
       PreparedStatement stmt1=null;
       PreparedStatement stmt2=null;
       PreparedStatement stmt3=null;       
       ResultSet rs=null; 
       SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
       
       String tb="scheduleexam"+j;
             try {
         Dataconnectivity dc1=new Dataconnectivity();
         con=(Connection)dc1.Dataconnect();
          } 
               catch (Exception e) {
      System.out.println("<h4>Database Connection Problem.</h4>");
      System.out.println("<h5>" + e.getMessage() + "</h5>");
         }         
        try{
        for(int i=0;i<ar.size();i++){            
        sd=(String)sdf.format(ar.get(i));        
        qry2="insert into "+tb+"(dated,isholiday,cours_id,yrs,exam,evenodd,degree)values(?,?,?,?,?,?,?)";       
        stmt = con.prepareStatement(qry2);                
        stmt.setString(1,sd);
        stmt.setString(2,"N");
        stmt.setString(3,"n");
        stmt.setString(4,yr);
        stmt.setString(5,extp);
        stmt.setString(6,eo);
        stmt.setString(7,dg);
        stmt.executeUpdate();    
        }
       String s1="";
       String s2="";  
       String q2="";
       String q1="select dated,TO_CHAR(TO_DATE(dated,'dd-mm-yyyy'),'day') as dat from "+tb;
       stmt1=con.prepareStatement(q1);
       rs=stmt1.executeQuery();
       while(rs.next()){
       s1=(String)rs.getString("dated");
       s2=(String)rs.getString("dat"); 
       s2=s2.trim();
       if(s2.equals("sunday")){
       q2="update "+tb+" set isholiday=?,days=? where dated='"+s1+"'";   
       stmt2=con.prepareStatement(q2); 
       stmt2.setString(1,"Y");
       stmt2.setString(2,s2);       
       stmt2.executeUpdate();
       }
       else{
       q2="update "+tb+" set days=? where dated='"+s1+"'";       
       stmt2=con.prepareStatement(q2);                
       stmt2.setString(1,s2);       
       stmt2.executeUpdate(); 
       }
       }
        }
        catch(SQLException se){
        System.out.println(se.getMessage());    
        }
          finally {
      try {
          if(rs!=null){
          rs.close();    
          }
           if(stmt1!=null){
       stmt1.close();
          }
            if(stmt2!=null){
       stmt2.close();
          }
            if(stmt3!=null){
       stmt3.close();
          }
          if(stmt!=null){
       stmt.close();
          }
          if(con!=null){
       con.close();
          }
      } 
      catch (SQLException e) {
        e.printStackTrace();
      }
    }
    }
    
}
