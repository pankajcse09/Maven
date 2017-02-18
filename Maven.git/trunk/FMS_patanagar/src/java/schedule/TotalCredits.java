package schedule;

import java.sql.*;
import com.myapp.struts.Dataconnectivity;
import java.io.*;
        
public class TotalCredits{
    public static Connection con=null; 
    public TotalCredits() {        
    }
    public int credits(String st1,String cst,String y,String sn) throws IOException{                
      PreparedStatement psm1=null;        
      ResultSet r1=null;   
          try{
     Dataconnectivity dc=new Dataconnectivity();
     con=(Connection)dc.Dataconnect();
     }
     catch(Exception e){
     System.out.println(e.getMessage());    
     }
int tct=0;
String cid1="";
String tc1="";
String en_id=st1;
String cit=cst;  
Round rr=new Round();   
String cid=""; 
String yr=y;
String ssn=sn;
int yr1=0;
int yr2=0;
if(!yr.equals("") && yr!=null){
yr2=Integer.parseInt(yr)*2;
 yr1=yr2-1; 
}           
 try{ 
   try{            
cid="select id,totalcredit from ex_course_detail where sessions='"+ssn+"' and (semester='"+yr1+"' or semester='"+yr2+"') and title='"+cit+"'";
        psm1=con.prepareStatement(cid); 
        r1=psm1.executeQuery();                  
        while(r1.next()){  
        cid1=r1.getString("id");        
        tc1=r1.getString("totalcredit"); 
        tct=tct+Integer.parseInt(tc1); 
}     
}
catch(Exception e){
    System.out.println(e.getMessage());
}
finally{
 try{     
  if(r1!=null){r1.close();}                  
  if(psm1!=null){psm1.close();}  
  if(con!=null){con.close();}
 }  
 catch(SQLException se){
     System.out.println(se.getMessage());
 }
}        
  }
        catch(NullPointerException ne){}  
        return tct;
    }   
}

