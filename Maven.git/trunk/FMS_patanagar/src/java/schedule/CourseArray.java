package schedule;

import java.sql.*;
import com.myapp.struts.Dataconnectivity;
import java.util.*;

public class CourseArray {    
    /** Creates a new instance of CourseArray */
    static Connection con=null;
    static PreparedStatement psmt=null;     
    static ResultSet rs=null;
    static PreparedStatement psmt1=null;
    static ResultSet rs1=null;
    static PreparedStatement psmt3=null;
    static ResultSet rs3=null; 
    static PreparedStatement psmt4=null;
    static ResultSet rs4=null;   
    static PreparedStatement psmt5=null;
    static ResultSet rs5=null;
    public static Round rr=new Round(); 
    public CourseArray() {     
    }       
    public ArrayList course(String tit,String sem1,String sem2,String ssn){       
     try{
     Dataconnectivity dc=new Dataconnectivity();
     con=(Connection)dc.Dataconnect();
     }
     catch(Exception e){
     //System.out.println(e.getMessage());    
     }        
     String ti=tit;  
     String sm1=sem1;
     String sm2=sem2;      
     ArrayList arr=new ArrayList();     
     String qr1="select distinct id from ex_course_detail where title='"+ti+"' and sessions='"+ssn+"' and (semester='"+sm1+"' or semester='"+sm2+"')";
     try{
     psmt1=con.prepareStatement(qr1);
     rs1=psmt1.executeQuery();
     while(rs1.next()){
     arr.add(rs1.getString("id"));        
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
     return arr; 
    }     
    public String courseNo(ArrayList ar1,String enid){  
     ArrayList ar=new ArrayList();
     ar=ar1;
     String stid=enid;      
     int in1=0,in2=0;
     String n="";
     String nn="";
     String c=",";      
     for(int i=0;i<ar.size();i++){
     if(i==0){
     n=ar.get(i).toString();   
     continue;
     }      
     nn=ar.get(i).toString();
     in1=nn.indexOf("-");     
     nn=nn.substring(in1+1);     
     n=n.concat(c).concat(nn);      
     }     
     return n;
     }    
   public String creditHours(ArrayList ar1,String sem1,String sem2,String ssn){     
     try{
     Dataconnectivity dc1=new Dataconnectivity();
     con=(Connection)dc1.Dataconnect();
     }
     catch(Exception e){
     System.out.println(e.getMessage());    
     }
     int tc1=0; 
     String tc="";
     String sm1=sem1;
     String sm2=sem2;
     String qr2="";     
     ArrayList ar=new ArrayList();
     ar=ar1; 
     try{
     for(int i=0;i<ar.size();i++){
     qr2="select totalcredit from ex_course_detail where sessions='"+ssn+"' and id='"+ar.get(i)+"' and (semester='"+sm1+"' or semester='"+sm2+"')";
     psmt3=con.prepareStatement(qr2);
     rs3=psmt3.executeQuery();
     while(rs3.next()){
      if(tc.equals("")){   
      tc=tc+rs3.getString("totalcredit");       
      }
      else{
       tc=tc+"+"+rs3.getString("totalcredit");  
      }
      tc1=tc1+Integer.parseInt(rs3.getString("totalcredit"));
     }     
     }    
     if(tc.indexOf("+")!=-1){
     tc=tc+"="+tc1;
     }
     }
     catch(SQLException se){
     System.out.println(se.getMessage());    
     }
     finally{
         try{
          if(rs3!=null){rs3.close();}
          if(psmt3!=null){psmt3.close();}
          if(con!=null){con.close();}
         }
         catch(SQLException se){
         System.out.println(se.getMessage());   
         }     
     }
     return tc;
   } 
   public double pointsEarned(String stid,ArrayList ar1,String sem1,String sem2,String deg,String sn,HashMap hm1){    
      try{
     Dataconnectivity dc1=new Dataconnectivity();
     con=(Connection)dc1.Dataconnect();
     }
     catch(Exception e){
     System.out.println(e.getMessage());    
     }
    String std=stid;
    ArrayList ar=new ArrayList();
    ar=ar1;
    HashMap hm=hm1;
    String sm1=sem1;
    String sm2=sem2;
    String dg=deg;
    String ssn=sn;
    String qr1="";
    String qr2="";
    String qr3="";
    String qr4="";
    double tt1=0.0;
    double tt2=0.0;
    double md=0.0;
    double ed=0.0;
    double inp=0.0;
    double extra=0.0;
    double ext=0.0;
    double exp=0.0;
    double comp=0.0;
    int cc=0;
    double tt=0.0;
    double ps=0.0;
    double pe=0.0;  
    try{
    for(int i=0;i<ar.size();i++){
    qr1="select midterm,endterm,intpractical,extra from addmarks where course_id='"+ar.get(i).toString()+"' and studid='"+std+"' and years='"+ssn+"' and (semester='"+sem1+"' or semester='"+sem2+"') and degree='"+dg+"'";
    psmt4=con.prepareStatement(qr1);
    rs4=psmt4.executeQuery();    
    if(rs4.next()==true){
    if(rs4.getDouble("midterm")!=-1.0){
    md=rs4.getDouble("midterm");
    }
    else{
    md=0.0;    
    }
    if(rs4.getDouble("endterm")!=-1.0){
    ed=rs4.getDouble("endterm");
    }
    else{
    ed=0.0;    
    }
    if(rs4.getDouble("intpractical")!=-1.0){
    inp=rs4.getDouble("intpractical");
    }
    else{
    inp=0.0;    
    }
    }
    if(rs4.getDouble("extra")!=-1.0){
    extra=rs4.getDouble("extra");    
    }
    else{
    extra=0.0;    
    }
    qr2="select external from extmarks where course_id='"+ar.get(i).toString()+"' and studid='"+std+"' and years='"+ssn+"' and (semester='"+sem1+"' or semester='"+sem2+"') and degree='"+dg+"'";
    psmt5=con.prepareStatement(qr2);
    rs5=psmt5.executeQuery();
    if(rs5.next()){
    if(rs5.getDouble("external")!=-1.0){
    ext=rs5.getDouble("external");
    }
    else{
    ext=0.0;    
    }}
    qr4="select extpractical from extprmarks where course_id='"+ar.get(i).toString()+"' and studid='"+std+"' and years='"+ssn+"' and (semester='"+sem1+"' or semester='"+sem2+"') and degree='"+dg+"'";
    psmt1=con.prepareStatement(qr4);
    rs1=psmt1.executeQuery();
    if(rs1.next()){
    if(rs1.getDouble("extpractical")!=-1.0){
    exp=rs1.getDouble("extpractical");
    }
    else{
    exp=0.0;    
    }
    }    
    tt1=Math.ceil(md+ed+inp+ext+exp+extra);
    if(tt1>=50.0){   
    tt=((double)Math.ceil(md+ed+inp+ext+exp+extra))/10;
    cc=Integer.parseInt(hm.get(ar.get(i)).toString());
    ps=cc*tt;
    pe=rr.roundoff(pe+ps);
    }
    else{
    qr3="select compartment from compmarks where course_id='"+ar.get(i).toString()+"' and studid='"+std+"' and years='"+ssn+"' and (semester='"+sem1+"' or semester='"+sem2+"') and degree='"+dg+"'";    
    psmt3=con.prepareStatement(qr3);
    rs3=psmt3.executeQuery();     
    if(rs3.next()){
    if(rs3.getDouble("compartment")!=-1.0){
    comp=rs3.getDouble("compartment");    
              }        
            }
    tt2=Math.ceil(md+ed+inp+comp+exp);        
    tt=((double)Math.ceil(md+ed+inp+comp+exp))/10;
    cc=Integer.parseInt(hm.get(ar.get(i)).toString());
    ps=cc*tt;
    pe=rr.roundoff(pe+ps);    
         }
       }   
     }
    catch(SQLException se){
    System.out.println(se.getMessage());    
    }
      finally{
         try{
          if(rs1!=null){rs1.close();}   
          if(rs3!=null){rs3.close();}   
          if(rs4!=null){rs4.close();}
          if(rs5!=null){rs5.close();}
          if(psmt1!=null){psmt1.close();}
          if(psmt3!=null){psmt3.close();}
          if(psmt4!=null){psmt4.close();}
          if(psmt5!=null){psmt5.close();}
          if(con!=null){con.close();}
         }
         catch(SQLException se){
         System.out.println(se.getMessage());   
         }     
     }
     return pe;
    //return tt1;
   }
   public String sessions(String studid,String cyear){            
      try{
     Dataconnectivity dc1=new Dataconnectivity();
     con=(Connection)dc1.Dataconnect();
     }
     catch(Exception e){
     System.out.println(e.getMessage());    
     }
            String stid=studid;
            String cyr=cyear;
            String ssn="";
            String ssns="";           
           String qr2="select count(distinct sessions) as cds from studinfo where studid='"+stid+"' and currentyr='"+cyr+"'";
           try{
           psmt4=con.prepareStatement(qr2);
           rs4=psmt4.executeQuery();
           rs4.next();
           int cons=rs4.getInt("cds");
           String qr1="select distinct sessions from studinfo where studid='"+stid+"' and currentyr='"+cyr+"' and (status='P' or status='F') order by TO_NUMBER(substr(sessions,1,4))";
           psmt5=con.prepareStatement(qr1);
           rs5=psmt5.executeQuery();
           int cons1=0;
           while(rs5.next()){  
           cons1++;
           ssn=(String)rs5.getString("sessions");
           if(ssns.equals("")){ 
            if(cons1==cons){   
            ssns=ssns+ssn+" (Pass)";
            }
            else{
            ssns=ssns+ssn+" (Fail) ";    
            }
            }
           else{
             if(cons1==cons){   
            ssns=ssns+","+ssn+"(Pass)";
            }
            else{
            ssns=ssns+","+ssn+" (Fail)";    
            }               
           }           
           }    
           }
           catch(SQLException se){
           System.out.println(se.getMessage());    
           }
               finally{
         try{
          if(rs4!=null){rs4.close();}
          if(rs5!=null){rs5.close();}
          if(psmt4!=null){psmt4.close();}
          if(psmt5!=null){psmt5.close();}
          if(con!=null){con.close();}
         }
         catch(SQLException se){
         System.out.println(se.getMessage());   
         }     
     }
          return ssns; 
   }
   public ArrayList selectId(String yr,String ssn){
     ArrayList ar=new ArrayList();    
        
      try{
     Dataconnectivity dc=new Dataconnectivity();
     con=(Connection)dc.Dataconnect();
     }
     catch(Exception e){
     System.out.println(e.getMessage());    
     } 
     int s2=Integer.parseInt(yr)*2;
     int s1=s2-1;        
      String qr4="select id from ex_course_detail where sessions='"+ssn+"' and (semester='"+s1+"' or semester='"+s2+"') order by title";
      try{
      psmt4=con.prepareStatement(qr4);
      rs4=psmt4.executeQuery();
      while(rs4.next()){               
      ar.add(rs4.getString("id"));    
       }     
      }
      catch(SQLException se){
      System.out.println(se.getMessage());    
      }
      finally{
          try{
          if(rs4!=null){rs4.close();}          
          if(psmt4!=null){psmt4.close();}          
          if(con!=null){con.close();}   
          }
          catch(SQLException se){
          System.out.println(se.getMessage());    
          }
      }
    return ar;
   }
   public ArrayList selectTitle(String yr,String ssn){
   //HashSet hs=new HashSet(); 
   ArrayList hs=new ArrayList();
     try{
     Dataconnectivity dc=new Dataconnectivity();
     con=(Connection)dc.Dataconnect();
     }
     catch(Exception e){
     System.out.println(e.getMessage());    
     } 
     int s2=Integer.parseInt(yr)*2;
     int s1=s2-1;        
      String qr4="select distinct substr(id,1,3),title from ex_course_detail where sessions='"+ssn+"' and (semester='"+s1+"' or semester='"+s2+"') order by substr(id,1,3)";
      try{
      psmt4=con.prepareStatement(qr4);
      rs4=psmt4.executeQuery();
      while(rs4.next()){    
      hs.add(rs4.getString("title"));      
         }            
       }
      catch(SQLException se){
      System.out.println(se.getMessage());    
      }
         finally{
          try{
          if(rs4!=null){rs4.close();}          
          if(psmt4!=null){psmt4.close();}          
          if(con!=null){con.close();}   
          }
          catch(SQLException se){
          System.out.println(se.getMessage());    
          }
      }
   return hs;
   }
   public HashMap idTitle(String yr,String ssn){
   HashMap hm1=new HashMap();     
      try{
     Dataconnectivity dc=new Dataconnectivity();
     con=(Connection)dc.Dataconnect();
     }
     catch(Exception e){
     System.out.println(e.getMessage());    
     } 
     int s2=Integer.parseInt(yr)*2;
     int s1=s2-1;        
      String qr4="select id,title,totalcredit from ex_course_detail where sessions='"+ssn+"' and (semester='"+s1+"' or semester='"+s2+"') order by title";
      try{
      psmt4=con.prepareStatement(qr4);
      rs4=psmt4.executeQuery();
      while(rs4.next()){        
      hm1.put(rs4.getString("id"),rs4.getString("title"));          
        } 
       }
      catch(SQLException se){
      System.out.println(se.getMessage());    
      }
            finally{
          try{
          if(rs4!=null){rs4.close();}          
          if(psmt4!=null){psmt4.close();}          
          if(con!=null){con.close();}   
          }
          catch(SQLException se){
          System.out.println(se.getMessage());    
          }
      }   
   return hm1;
   }
   public HashMap idCredit(String yr,String ssn){
   HashMap hm2=new HashMap();        
      try{
     Dataconnectivity dc=new Dataconnectivity();
     con=(Connection)dc.Dataconnect();
     }
     catch(Exception e){
     System.out.println(e.getMessage());    
     } 
     int s2=Integer.parseInt(yr)*2;
     int s1=s2-1;        
      String qr4="select id,title,totalcredit from ex_course_detail where sessions='"+ssn+"' and (semester='"+s1+"' or semester='"+s2+"') order by title";
      try{
      psmt4=con.prepareStatement(qr4);
      rs4=psmt4.executeQuery();
      while(rs4.next()){        
      hm2.put(rs4.getString("id"),rs4.getString("totalcredit"));      
           } 
       }
      catch(SQLException se){
      System.out.println(se.getMessage());    
      }
         finally{
          try{
          if(rs4!=null){rs4.close();}          
          if(psmt4!=null){psmt4.close();}          
          if(con!=null){con.close();}   
          }
          catch(SQLException se){
          System.out.println(se.getMessage());    
          }
      }   
   return hm2;    
   }
   public int totCredit(String yr,String ssn){
     int crd=0;     
      try{
     Dataconnectivity dc=new Dataconnectivity();
     con=(Connection)dc.Dataconnect();
     }
     catch(Exception e){
     System.out.println(e.getMessage());    
     } 
     int s2=Integer.parseInt(yr)*2;
     int s1=s2-1;        
      String qr4="select totalcredit from ex_course_detail where sessions='"+ssn+"' and (semester='"+s1+"' or semester='"+s2+"') order by title";
      try{
      psmt4=con.prepareStatement(qr4);
      rs4=psmt4.executeQuery();
      while(rs4.next()){        
      crd=crd+Integer.parseInt(rs4.getString("totalcredit"));
           } 
       }
      catch(SQLException se){
      System.out.println(se.getMessage());    
      }
            finally{
          try{
          if(rs4!=null){rs4.close();}          
          if(psmt4!=null){psmt4.close();}          
          if(con!=null){con.close();}   
          }
          catch(SQLException se){
          System.out.println(se.getMessage());    
          }
      }   
   return crd;    
   }    
   public String maxSession(String stid,String yrs){
     String std=stid;
     String yr=yrs;
     String msn="";      
      try{
     Dataconnectivity dc=new Dataconnectivity();
     con=(Connection)dc.Dataconnect();
     }
     catch(Exception e){
     System.out.println(e.getMessage());    
     }  
     String qr1="select distinct sessions from studinfo where studid='"+stid+"' and currentyr='"+yr+"' and TO_NUMBER(substr(sessions,1,4))=(select max(TO_NUMBER(substr(sessions,1,4))) from studinfo where studid='"+stid+"' and currentyr='"+yr+"')";
     try{
      psmt4=con.prepareStatement(qr1);
      rs4=psmt4.executeQuery();
      while(rs4.next()){        
      msn=rs4.getString("sessions");
           } 
       }
      catch(SQLException se){
      System.out.println(se.getMessage());    
      }
            finally{
          try{
          if(rs4!=null){rs4.close();}          
          if(psmt4!=null){psmt4.close();}          
          if(con!=null){con.close();}   
          }
          catch(SQLException se){
          System.out.println(se.getMessage());    
          }
      }   
     return msn;
   }    
   public String toWords(int m1){
    int m=m1;  
    String wrd="";
    switch(m){
     case 1: {
     wrd="FIRST";
     break;
     }
     case 2:{
     wrd="SECOND";
     break;
     }
     case 3:{
     wrd="THIRD";
     break;
     }
     case 4:{
     wrd="FOURTH";
     break;
     }
     case 5:{
     wrd="FIFTH";       
     break;
     }
    }
    return wrd;
   }  
   public String completed(String studid,String bch){     
        try{
     Dataconnectivity dc=new Dataconnectivity();
     con=(Connection)dc.Dataconnect();
     }
     catch(Exception e){
     //System.out.println(e.getMessage());    
     }      
    String stid=studid;
    String comt="";
    String bh=bch;
    String ct="";
    int in1=0;
    String bm="";  
    if(bh!=null && !bh.equals("")){
    in1=bh.indexOf(",");
    bm=bh.substring(0,in1);  
    }
    String qry="select distinct max(TO_NUMBER(substr(sessions,6,4))) as cyear from studinfo where studid='"+stid+"' and currentyr='5' and status='P'";
    try{
    psmt=con.prepareStatement(qry);
    rs=psmt.executeQuery();
    while(rs.next()){
    comt=rs.getString("cyear");    
    }
    ct=bm+","+comt;
    }
    catch(SQLException se){
   // System.out.println(se.getMessage());    
    }
      finally{
          try{
          if(rs!=null){rs.close();}          
          if(psmt!=null){psmt.close();}          
          if(con!=null){con.close();}   
          }
          catch(SQLException se){
          System.out.println(se.getMessage());    
          }
      }
    return ct;
   }     
   
   public String result(double av){
   double avg=av*10;
   String re="";
   String pw1="PASSED With ";
   String pw="";
  if(avg<50){
  re="FAIL";    
  }
  else if(avg>=50.00 && avg<=50.99){
  re="PASS";     
  }
  else if(avg>=60.00 && avg<=67.49){
  re="SECOND DIVISION";     
  }
   if(avg>=67.49 && avg<=77.49){
   re="FIRST DIVISION";    
   }
   if(avg>=77.50){
   re="DISTINCTION";    
   }
   if(re.equalsIgnoreCase("FAIL") || re.equalsIgnoreCase("PASS")){
   pw=re;    
   }
   else{
   pw=pw1+re;
   }
   return pw;
   }
   public String conduct(double av){
    double avg=av*10;
   String re="";
  if(avg<50){
  re="Very Bad";    
  }
  else if(avg>=50.00 && avg<=50.99){
  re="Bad";     
  }
  else if(avg>=60.00 && avg<=67.49){
  re="Satisfactory";     
  }
   if(avg>=67.49 && avg<=77.49){
   re="Good";    
   }
   if(avg>=77.50){
   re="Excellent";    
   }   
   return re;    
   }
   
   public String internship(String enid){
       String str="";
       String fd="";
       String td="";
       String rmk="";
       String stid=enid;
       try{
     Dataconnectivity dc=new Dataconnectivity();
     con=(Connection)dc.Dataconnect();
     }
     catch(Exception e){
     System.out.println(e.getMessage());    
     } 
    String qr1="select fromdate,todate from internshipdate where TO_NUMBER(substr(sessions,1,4))=(select max(TO_NUMBER(substr(sessions,1,4))) from studinfo where studid='"+stid+"' and status='P' and sem='10')";
    try{
    psmt=con.prepareStatement(qr1);
    rs=psmt.executeQuery();
     while(rs.next()){
     fd=rs.getString("fromdate");
     td=rs.getString("todate");
    }
    String qr2="select remarks from internship where studid='"+stid+"' and TO_NUMBER(substr(sessions,1,4))=(select max(TO_NUMBER(substr(sessions,1,4))) from studinfo where studid='"+stid+"' and status='P' and sem='10')";
    psmt1=con.prepareStatement(qr2);
    rs1=psmt1.executeQuery();
    while(rs1.next()){
     rmk=rs1.getString("remarks");    
    }
    str="Internship (from "+fd+" to "+td+") "+rmk;
    }
    catch(SQLException se){
     System.out.println(se.getMessage());   
    }
    return str;
   }
   
}
