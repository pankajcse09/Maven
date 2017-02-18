package schedule;
/**
 *
 * @author kanchan
 */
import java.sql.*;
import com.myapp.struts.Dataconnectivity;
import java.util.*;

public class InfoUpdate {    
    /**Creates a new instance of InfoUpdate */
    public static Connection con=null;
    static Statement stmt=null;
    static PreparedStatement psmt2=null;  
    static ResultSet rs1=null;      
    static ResultSet rs2=null; 
    public InfoUpdate() {
    }
   public HashMap update(String deg,String sid,String sem,String cyr,String ssn){
      HashMap hm=new HashMap();   
      String dg=deg;
      String sd=sid;
      String sm=sem;
      String cy="";
      String sn=ssn;  
      String yy="";      
      int in1=sn.indexOf("-");
      int in2=sn.length();
       int y1=Integer.parseInt(sn.substring(0,in1))+1;
       int y2=Integer.parseInt(sn.substring(in1+1,in2))+1; 
       Integer s=new Integer(Integer.parseInt(sm)+1);  
     
       Integer s1=new Integer(Integer.parseInt(sm)-1); 
       
      int cnt=0;
      int rc=0;
          
        try{
     Dataconnectivity dc=new Dataconnectivity();
     con=(Connection)dc.Dataconnect();
     }
     catch(Exception e){
     System.out.println(e.getMessage());    
     }   
    if(Integer.parseInt(sm)%2==0){      
     try{
     String qr2="select count(studid) as rcnt from extprmarks where studid='"+sd+"' and years='"+sn+"' and degree='"+dg+"'";        
     psmt2=con.prepareStatement(qr2);
     rs2=psmt2.executeQuery();
     if(rs2.next()==true){
     rc=rs2.getInt("rcnt");  
     }
     String qr1="select count(status) as cont from extprmarks where status='F' and studid='"+sd+"' and years='"+sn+"' and degree='"+dg+"'"; 
     stmt=con.createStatement();
     rs1=stmt.executeQuery(qr1);
     if(rs1.next()==true){        
     cnt=rs1.getInt("cont");
     }
     }
     catch(SQLException se){
     System.out.println(se.getMessage());    
     }
  finally{
  try{        
  if(rs1!=null){rs1.close();}                
  if(stmt!=null){stmt.close();} 
  if(con!=null){con.close();}
 }  
 catch(SQLException se){
     System.out.println(se.getMessage());
 }
}     
     yy=y1+"-"+y2;    
     cy=(new Integer(Integer.parseInt(cyr)+1)).toString();  
     if(rc>0)
     {         
     if(cnt<=0){
     hm.put("semes",s);    
     hm.put("crntyr",cy);
     hm.put("sesn",yy);
     hm.put("status","P");
     }
     else{
     if(cnt>0 && cnt<3){
     hm.put("semes",sm);    
     hm.put("crntyr",cyr);
     hm.put("sesn",sn);  
     hm.put("status","C");
     }
   
     else{
     hm.put("semes",s1);    
     hm.put("crntyr",cyr);
     hm.put("sesn",yy);   
     hm.put("status","F");
     } 
     }
     }       
     else{        
     hm.put("semes",s1);    
     hm.put("crntyr",cyr);
     hm.put("sesn",yy);       
     hm.put("status","D");
      }    
    }      
    else{
     hm.put("semes",s);    
     hm.put("crntyr",cyr);
     hm.put("sesn",sn);   
     hm.put("status","P");      
    }  
     return hm; 
   } 
   
  public HashMap upCompart(String deg,String sid,String sem,String cyr,String ssn){      
      String dg=deg;
      String sd=sid;
      String sm=sem;
      String cy="";
      String sn=ssn;  
      String yy="";      
      int in1=sn.indexOf("-");
      int in2=sn.length();
       int y1=Integer.parseInt(sn.substring(0,in1))+1;
       int y2=Integer.parseInt(sn.substring(in1+1,in2))+1; 
       Integer s=new Integer(Integer.parseInt(sm)+1);  
       Integer s1=new Integer(Integer.parseInt(sm)-1);
      int cnt=0;
      HashMap hm=new HashMap();     
        try{
     Dataconnectivity dc=new Dataconnectivity();
     con=(Connection)dc.Dataconnect();
     }
     catch(Exception e){
     System.out.println(e.getMessage());    
     }     
     try{
     String qr1="select count(status) as cont from compmarks where status='F' and studid='"+sd+"' and years='"+sn+"' and degree='"+dg+"'";     
     stmt=con.createStatement();
     rs1=stmt.executeQuery(qr1);
     rs1.next();
     cnt=rs1.getInt("cont"); 
     }
     catch(SQLException se){
     System.out.println(se.getMessage());    
     }
  finally{
  try{        
  if(rs1!=null){rs1.close();}                
  if(stmt!=null){stmt.close();} 
  if(con!=null){con.close();}
 }  
 catch(SQLException se){
     System.out.println(se.getMessage());
 }
}   
     yy=y1+"-"+y2;    
     cy=(new Integer(Integer.parseInt(cyr)+1)).toString();  
     if(cnt<=0){
     hm.put("semes",s);    
     hm.put("crntyr",cy);
     hm.put("sesn",yy);
     hm.put("status","P");
     }
     else{   
     hm.put("semes",s1);    
     hm.put("crntyr",cyr);
     hm.put("sesn",yy);   
     hm.put("status","F");         
      }
     return hm;          
  }
}
