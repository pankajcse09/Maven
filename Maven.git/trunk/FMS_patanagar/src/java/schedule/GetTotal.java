package schedule;

import java.sql.*;
import com.myapp.struts.Dataconnectivity;
import java.io.*;

        
public class GetTotal{
    public static Connection con=null;
    public static PreparedStatement psmt1=null; 
    public static PreparedStatement psmt2=null; 
    public static PreparedStatement psm1=null;
    public static PreparedStatement psmt3=null;
    public static PreparedStatement psmt4=null;
    public static PreparedStatement psmt5=null;
    public static PreparedStatement psmt6=null;   
    public static PreparedStatement psmt7=null;
    public static ResultSet rs1=null; 
    public static ResultSet rs2=null;
    public static ResultSet r1=null;   
    public static ResultSet rs3=null;
    public static ResultSet rs4=null;
    public static ResultSet rs5=null;
    public static ResultSet rs6=null;  
    public static ResultSet rs7=null;
    public GetTotal() {       
    }
    public double points(String st1,String cst,String y,String sn) throws IOException{         
        try{
     Dataconnectivity dc=new Dataconnectivity();
     con=(Connection)dc.Dataconnect();
     }
     catch(Exception e){
     System.out.println(e.getMessage());    
     } 
      String ssn=sn;
      String qr5="";     
      String qr6="";
      String qr7="";
      String yr=y;
      int yr1=0;
      int yr2=0;
       if(!yr.equals("") && yr!=null){
       yr2=Integer.parseInt(yr)*2;
       yr1=yr2-1; 
       }
int tct=0;
double mie=0.0;
double inp=0.0;
double extn=0.0;
double extp=0.0;
double extra=0.0;
double me=0.0;   
double tt=0;
double gd=0;
double ps=0;
double ps1=0;
String cid1="";
String tc1="";
double dd=0.0;
      String en_id=st1;
      String cit=cst;  
          Round rr=new Round();   
           String cid="";
           String sm1="";                      
          try{ 
              try{            
cid="select id,totalcredit from ex_course_detail where (semester='"+yr1+"' or semester='"+yr2+"') and title='"+cit+"' and sessions='"+ssn+"'";
        psm1=con.prepareStatement(cid); 
        r1=psm1.executeQuery();                  
        while(r1.next()){  
        cid1=r1.getString("id");        
        tc1=r1.getString("totalcredit"); 
        tct=tct+Integer.parseInt(tc1);   
qr5="select midterm,endterm,intpractical,extra from addmarks where studid='"+en_id+"' and course_id='"+cid1+"' and years='"+ssn+"' and (semester='"+yr1+"' or semester='"+yr2+"') and degree='B.V.Sc. and A.H. Degree Programme'";           
psmt5=con.prepareStatement(qr5);
rs5=psmt5.executeQuery();
while(rs5.next())
{
 if(rs5.getDouble("midterm")!=-1 && rs5.getDouble("endterm")!=-1){   
mie=rs5.getDouble("midterm")+rs5.getDouble("endterm"); 
}
else{
mie=0.0;    
}
if(rs5.getDouble("intpractical")!=-1){
inp=rs5.getDouble("intpractical");
}
else{
inp=0.0; 
} 
if(rs5.getDouble("extra")!=-1){
extra=rs5.getDouble("extra");
}
else{
extra=0.0;
}
if(rs5.getDouble("extra")==-1){ 
qr6="select external from extmarks where studid='"+en_id+"' and course_id='"+cid1+"' and years='"+ssn+"' and (semester='"+yr1+"' or semester='"+yr2+"') and degree='B.V.Sc. and A.H. Degree Programme'";           
psmt6=con.prepareStatement(qr6);
rs6=psmt6.executeQuery();
 while(rs6.next()){
 if(rs6.getDouble("external")!=-1){   
 extn=rs6.getDouble("external");  
 }
 else{
 extn=0.0;
 }
qr7="select extpractical from extprmarks where studid='"+en_id+"' and course_id='"+cid1+"' and years='"+ssn+"' and (semester='"+yr1+"' or semester='"+yr2+"') and degree='B.V.Sc. and A.H. Degree Programme'";           
psmt7=con.prepareStatement(qr7);
rs7=psmt7.executeQuery();
 while(rs7.next()){
 if(rs7.getDouble("extpractical")!=-1){
 extp=rs7.getDouble("extpractical");  
 }
 else{
 extp=0.0;
 }
 tt=Math.ceil(mie+inp+extn+extp);   
 gd=((double)tt)/10;
 ps=gd*Integer.parseInt(tc1);
 ps1=rr.roundoff(ps1+ps);
}
}
}
else{
tt=Math.ceil(extra); 
gd=((double)tt)/10;
ps=gd*Double.parseDouble(tc1);
ps1=ps1+ps;
}
}
}     
}
catch(Exception e){
    System.out.println(e.getMessage());
}
finally{
 try{      
  if(r1!=null){r1.close();}    
  if(rs5!=null){rs5.close();}   
  if(rs6!=null){rs6.close();}  
  if(rs7!=null){rs7.close();} 
  if(psm1!=null){psm1.close();}  
  if(psmt5!=null){psmt5.close();} 
  if(psmt6!=null){psmt6.close();} 
  if(psmt7!=null){psmt7.close();} 
 }  
 catch(SQLException se){
     System.out.println(se.getMessage());
 }
}        
  }
        catch(NullPointerException ne){}  
        return ps1;
    }   
    
   public String starId(String cd,String sn){
     PreparedStatement psmt1=null; 
     ResultSet rs1=null; 
         try{
     Dataconnectivity dc=new Dataconnectivity();
     con=(Connection)dc.Dataconnect();
     }
     catch(Exception e){
     System.out.println(e.getMessage());    
     }
     String cs=cd; 
     String s="";
     String th="";
     String pr="";
     String qr="select course_id,theory,practical from coursemarks where sessions='"+sn+"' and course_id='"+cs+"' order by updatedate desc";
     try{
     psmt1=con.prepareStatement(qr);
     rs1=psmt1.executeQuery();
     if(rs1.next()==true){
     th=rs1.getString("theory");
     pr=rs1.getString("practical");
     }
     if(th.equals("50") && pr.equals("NA")){
      s=cs+"*";   
     }
     else{
     if(th.equals("NA") && pr.equals("50")){
     s=cs+"**";    
     }
     else{
      s=cs;   
     }
     }
     }
     catch(SQLException se){
     System.out.println(se.getMessage());    
     }
     finally{
 try{        
  if(rs1!=null){rs1.close();}                
  if(psmt1!=null){psmt1.close();} 
  if(con!=null){con.close();}
 }  
 catch(SQLException se){
     System.out.println(se.getMessage());
 }
}
     return s;
   } 
   public String result(String id,String y,String sn){
     String rst=""; 
     int sem=Integer.parseInt(y)*2; 
     PreparedStatement psmt1=null; 
     PreparedStatement psmt2=null; 
     ResultSet rs1=null; 
     ResultSet rs2=null; 
         try{
     Dataconnectivity dc=new Dataconnectivity();
     con=(Connection)dc.Dataconnect();
     }
     catch(Exception e){
     System.out.println(e.getMessage());    
     }       
     try{
         int in=0;
         int inr=0;
      String st1="select count(studid) as rcnt from extprmarks where studid='"+id+"' and years='"+sn+"' and semester='"+sem+"'";      
      psmt2=con.prepareStatement(st1);
      rs2=psmt2.executeQuery();   
      if(rs2.next()==true){
      inr=rs2.getInt("rcnt");
      }
      String st="select count(status) as cnt from extprmarks where studid='"+id+"' and years='"+sn+"' and semester='"+sem+"' and status='F'";   
      psmt1=con.prepareStatement(st);
      rs1=psmt1.executeQuery();
      if(rs1.next()==true){      
      in=rs1.getInt("cnt");
      }
      if(inr>0){
      if(in<=0){
       rst="Pass with Grade Point Average(GPA):";   
      }
      else if(in>0 && in<3){      
       rst="Compartment:";   
      }
      else{
       rst="Fail:";   
      } 
      }
      else{
      rst="Dropped:";    
      }
     }
    catch(SQLException se){
     System.out.println(se.getMessage());    
     }
     finally{
 try{        
  if(rs2!=null){rs2.close();}   
  if(rs1!=null){rs1.close();}
  if(psmt2!=null){psmt2.close();} 
  if(psmt1!=null){psmt1.close();}
  if(con!=null){con.close();}
 }  
 catch(SQLException se){
     System.out.println(se.getMessage());
 }
     }
   return rst;  
  }   
   public String result1(String id,String y,String sn){
     String rst=""; 
     int sem=Integer.parseInt(y)*2;       
         try{
     Dataconnectivity dc=new Dataconnectivity();
     con=(Connection)dc.Dataconnect();
     }
     catch(Exception e){
     System.out.println(e.getMessage());    
     }       
     try{
         int in=0;
         int inr=0;
      String st1="select count(studid) as rcnt from compmarks where studid='"+id+"' and years='"+sn+"' and semester='"+sem+"'";      
      psmt2=con.prepareStatement(st1);
      rs2=psmt2.executeQuery();   
      if(rs2.next()==true){
      inr=rs2.getInt("rcnt");
      }
      String st="select count(status) as cnt from compmarks where studid='"+id+"' and years='"+sn+"' and semester='"+sem+"' and status='F'";   
      psmt1=con.prepareStatement(st);
      rs1=psmt1.executeQuery();
      if(rs1.next()==true){      
      in=rs1.getInt("cnt");
      }
      if(inr>0){
      if(in<=0){
       rst="Pass with Grade Point Average(GPA):";   
      }
      else{
       rst="Fail:";   
      } 
      }
      else{      
         int in1=0;
         int inr1=0;
      String st2="select count(studid) as rcnt from extprmarks where studid='"+id+"' and years='"+sn+"' and semester='"+sem+"'";      
      psmt3=con.prepareStatement(st2);
      rs3=psmt3.executeQuery();   
      if(rs3.next()==true){
      inr1=rs3.getInt("rcnt");
      }
      String st3="select count(status) as cnt from extprmarks where studid='"+id+"' and years='"+sn+"' and semester='"+sem+"' and status='F'";   
      psmt4=con.prepareStatement(st3);
      rs4=psmt4.executeQuery();
      if(rs4.next()==true){      
      in=rs4.getInt("cnt");
      }
      if(inr1>0){
      if(in1<=0){
       rst="Pass with Grade Point Average(GPA):";   
      }
      else{
       rst="Fail:";   
      } 
      }
      else{
      rst="Dropped:";    
      }       
      }
     }
    catch(SQLException se){
     System.out.println(se.getMessage());    
     }
     finally{
 try{        
  if(rs2!=null){rs2.close();}   
  if(rs1!=null){rs1.close();}
  if(rs3!=null){rs3.close();}
  if(rs4!=null){rs4.close();}
  if(psmt2!=null){psmt2.close();} 
  if(psmt1!=null){psmt1.close();}
  if(psmt3!=null){psmt3.close();}
  if(psmt4!=null){psmt4.close();}
  if(con!=null){con.close();}
 }  
 catch(SQLException se){
     System.out.println(se.getMessage());
 }
     }
   return rst;  
  }
}   

