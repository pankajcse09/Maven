package schedule;

import java.sql.*;
import com.myapp.struts.Dataconnectivity;

public class External{    
    /** Creates a new instance of CourseArray */
    public static Connection con=null;
    public static Round rr=new Round(); 
    public External(){ }       
    public String checkStatus(String dg,String yr,String sm,String std,String cs,double m1){  
       String stt="";
       String deg=dg;
       String yrs=yr;
       int sem=Integer.parseInt(sm);
       int sem1=sem-1;
       String stid=std;
       String crs=cs;
       double ex=0.0;
       double ep=m1; 
       if(ep==-1){
        ep=0;    
       }
       double mid=0.0;
       double end=0.0;
       double intp=0.0;       
       double total=0.0;
       PreparedStatement psmt1=null;
       PreparedStatement psmt2=null;
       ResultSet rs1=null; 
        ResultSet rs2=null; 
       String tt="";
     try{
     Dataconnectivity dc=new Dataconnectivity();
     con=(Connection)dc.Dataconnect();
     }
     catch(Exception e){
     System.out.println(e.getMessage());    
     }     
     String qr="select midterm,endterm,intpractical from addmarks where studid='"+stid+"' and course_id='"+crs+"' and degree='"+deg+"' and years='"+yrs+"' and (semester='"+sem+"' or semester='"+sem1+"')";  
     try{
      psmt1=con.prepareStatement(qr);
      rs1=psmt1.executeQuery();
      while(rs1.next()){
       mid=rs1.getInt("midterm");
       if(mid==-1){
       mid=0;    
       }
       end=rs1.getInt("endterm");
       if(end==-1){
       end=0.0;    
       }       
       intp=rs1.getInt("intpractical");  
       if(intp==-1){
        intp=0.0;   
       }
      }
      String qr1="select external from extmarks where studid='"+stid+"' and course_id='"+crs+"' and degree='"+deg+"' and years='"+yrs+"' and (semester='"+sem+"' or semester='"+sem1+"')";  
      psmt2=con.prepareStatement(qr1);
      rs2=psmt2.executeQuery();
         while(rs2.next()){
       ex=rs2.getInt("external");
       if(ex==-1){
       ex=0.0;    
       }
      }
      total=mid+end+intp+ex+ep;
      tt=new Double(total).toString();
      if(total>=50){
       stt="P";   
      }
      else{
       stt="F";   
      }    
     }
     catch(SQLException se){
         System.out.println(se.getMessage());
     }  
      finally {
      try {
          if(rs1!=null){rs1.close();}
          if(rs2!=null){rs2.close();}
          if(psmt1!=null){psmt1.close();}
          if(psmt2!=null){psmt2.close();}
          if(con!=null){con.close();}
      } 
      catch (SQLException se){
        se.printStackTrace();
      }
    }
     return stt;
    } 
    }