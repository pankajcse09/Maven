package schedule;

import java.sql.*;
import com.myapp.struts.Dataconnectivity;
import java.util.*;

public class MyMethods {   
     
    static Connection con=null;
    static PreparedStatement psmt=null;     
    static PreparedStatement psmt1=null;  
    static PreparedStatement psmt2=null;  
    static PreparedStatement psmt3=null; 
    static PreparedStatement psmt4=null;  
    static PreparedStatement psmt5=null;  
    static ResultSet rs=null;
    static ResultSet rs1=null;
    static ResultSet rs2=null;
    static ResultSet rs3=null;
    static ResultSet rs4=null;
    static ResultSet rs5=null;
    
    /** Creates a new instance of MyMethods */
    public MyMethods() {
    }
    
    public String retriveStudName(String srno){
          try{
    Dataconnectivity dc=new  Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    } 
    catch(Exception e){} 
     String sname="";     
     try{
     String qr1="select sname from studacaddetail where srnum='"+srno+"'"; 
     psmt1=con.prepareStatement(qr1);
     rs1=psmt1.executeQuery();   
     if(rs1.next()){
     sname=rs1.getString("sname");  
     }
     }
     catch(SQLException se){}  
     finally{
     try{
       if(rs1!=null){rs1.close();}
       if(psmt1!=null){psmt1.close();}
       if(con!=null){con.close();}
     }   
     catch(SQLException se){}
     }  
     return sname;
    }
    
    public int unitTestPass(String ssn,String clas,String sec,String extyp,String sub){ 
      int pas=0;
        try{
    Dataconnectivity dc=new  Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    } 
    catch(Exception e){}   
       try{
     String qr1="select count(*) as cnt from unittest where sessions='"+ssn+"' and classes='"+clas+"' and section='"+sec+"' and subject='"+sub+"' and examtype='"+extyp+"' and status='ACTIVE' and marks>=9"; 
     psmt1=con.prepareStatement(qr1);
     rs1=psmt1.executeQuery();   
     rs1.next();
     pas=rs1.getInt("cnt");     
     }
     catch(SQLException se){}  
     finally{
     try{
       if(rs1!=null){rs1.close();}
       if(psmt1!=null){psmt1.close();}
       if(con!=null){con.close();}
     }   
     catch(SQLException se){}
     }   
     return pas;    
    }
    
    public int unitTestFail(String ssn,String clas,String sec,String extyp,String sub){ 
      int fail=0;
        try{
    Dataconnectivity dc=new  Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    } 
    catch(Exception e){}   
       try{
     String qr1="select count(*) as cnt from unittest where sessions='"+ssn+"' and classes='"+clas+"' and section='"+sec+"' and subject='"+sub+"' and examtype='"+extyp+"' and status='ACTIVE' and marks<9"; 
     psmt1=con.prepareStatement(qr1);
     rs1=psmt1.executeQuery();   
     rs1.next();
     fail=rs1.getInt("cnt");     
     }
     catch(SQLException se){}  
     finally{
     try{
       if(rs1!=null){rs1.close();}
       if(psmt1!=null){psmt1.close();}
       if(con!=null){con.close();}
     }   
     catch(SQLException se){}
     }   
     return fail;    
    }
    
    public int appeared(String ssn,String clas,String sec,String extyp,String sub){
        int app=0;
        try{
    Dataconnectivity dc=new  Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    } 
    catch(Exception e){}   
       try{
     String qr1="select count(*) as cnt from examattendence where sessions='"+ssn+"' and classes='"+clas+"' and section='"+sec+"' and subject='"+sub+"' and examtype='"+extyp+"'"; 
     psmt1=con.prepareStatement(qr1);
     rs1=psmt1.executeQuery();   
     rs1.next();
     app=rs1.getInt("cnt");     
     }
     catch(SQLException se){}  
     finally{
     try{
       if(rs1!=null){rs1.close();}
       if(psmt1!=null){psmt1.close();}
       if(con!=null){con.close();}
     }   
     catch(SQLException se){}
     }   
     return app;    
    }
    
    public String unitTest(String marks){ 
    String st="";    
        try {
            if(Double.parseDouble(marks)>=9){
            st="P";    
            }else{
            st="F";   
            }
        } 
        catch(NumberFormatException ex) {
           st="Ab";
        }
    return st;
    }  
    
    public String halfFinal(String marks){ 
    String st="";    
        try {
            if(Double.parseDouble(marks)>=33){
            st="P";    
            }else{
            st="F";   
            }
        } 
        catch(NumberFormatException ex) {
           st="Ab";
        }
    return st;
    }
      
    public String semester(int in){
     String st=""; 
     if(in%2==0){
      st="II";    
     }
     else{
     st="I";    
     }
     return st;   
    }
    public String inRoman(int in){
     String st=""; 
     switch(in){
     case 1:
     st="I"; 
     break;
     case 2:
     st="II";
     break;
     case 3:
     st="III";
     break;
     case 4:
     st="IV";    
     break;
     case 5:
     st="V";    
     break;
     case 6:
     st="VI";    
     break;
     case 7:
     st="VII";    
     break;
     case 8:
     st="VIII";  
     break;
     case 9:
     st="IX";    
     break;
     case 10:
     st="X";
     break;
     default:
     st="";        
     }
     return st;   
    }
    public String inWords(int in){
     String st="";      
     switch(in){
     case 1:
     st="FIRST"; 
     break;
     case 2:
     st="SECOND";
     break;
     case 3:
     st="THIRD";
     break;
     case 4:
     st="FOURTH";    
     break;
     case 5:
     st="FIFTH";    
     break;
     case 6:
     st="SIXTH";    
     break;
     case 7:
     st="SEVENTH";    
     break;
     case 8:
     st="EIGHTH";  
     break;
     case 9:
     st="NINTH";    
     break;
     case 10:
     st="TENTH";
     break;
     default:
     st="";        
     }
     return st;  
    }
    
    public ArrayList allSessions(){
    ArrayList ar=new ArrayList();
    String ssn="";
      for(int i=1990;i<=2100;i++){
      ssn=i+"-"+(i+1);
      ar.add(ssn);
      }
    return ar;
    }
    
     public String generateno(String studid){     
        try{
     Dataconnectivity dc=new Dataconnectivity();
     con=(Connection)dc.Dataconnect();
     }
     catch(Exception e){}      
    String stid=studid;
    String comt="";    
    String ct="";
    int in=0;
    String qry="select distinct max(TO_NUMBER(substr(sessions,6,4))) as cyear from studinfo where studid='"+stid+"' and currentyr='5' and status='P'";
    try{
    psmt=con.prepareStatement(qry);
    rs=psmt.executeQuery();
    if(rs.next()){
    comt=rs.getString("cyear");    
    }  
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
    try{  
    in=Integer.parseInt(comt)+1;
    }
    catch(NumberFormatException ne){}
    ct=comt+"-"+in;
    return ct;
   }
     
   public String precesion(String st,int n){
   String pno="";
   int d=0;
   int in1=0;
   int in2=0;
   String st1="";
   String st2="";    
   if(st.indexOf(".")!=-1){
   in1=st.indexOf(".");
   in2=st.length();
   st1=st.substring(0,in1);
   st2="."+st.substring(in1+1,in2);
   try{
   d=(int)(Double.parseDouble(st2)*pow(10,n));  
     } 
   catch(NumberFormatException ne){}
   if(d==0){
   pno=st1+"."+"00";    
   }
   else{
   if(d<pow(10,n-1)){
   pno=st;    
   }
   else{
    pno=st1+"."+d;     
   }    
   } 
   }
   else{pno=st;}  
   return pno;    
   }    
   
   public String precesion1(String st,int n){
   String pno="";
   int d=0;
   int in1=0;
   int in2=0;
   String st1="";
   String st2="";    
   if(st.indexOf(".")!=-1){
   in1=st.indexOf(".");
   in2=st.length();
   st1=st.substring(0,in1);
   st2="."+st.substring(in1+1,in2);
   try{
   d=(int)(Double.parseDouble(st2)*pow(10,n));  
     } 
   catch(NumberFormatException ne){}
   if(d==0){
   pno=st1+"."+"000";    
   }
   else{
   if(d<pow(10,n-1)){
   pno=st;    
   }
   else{
    pno=st1+"."+d;     
   }    
   } 
   }
   else{pno=st;}  
   return pno;    
   }    
 
   public int pow(int no,int p){
   int np=1;    
   for(int i=1;i<=p;i++){
   np=np*no;    
   }    
   return np;
   }
   
   public ArrayList allClasses(){
    ArrayList ar=new ArrayList();
    try{
    Dataconnectivity dc=new  Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    } 
    catch(Exception e){}
    String qr="select distinct class from classes";
    try{
     psmt=con.prepareStatement(qr);
     rs=psmt.executeQuery();
     while(rs.next()){
     ar.add(rs.getString("class"));    
     }     
     }
    catch(SQLException se){}   
    finally{
     try{
       if(rs!=null){rs.close();}
       if(psmt!=null){psmt.close();}
       if(con!=null){con.close();}
     }   
     catch(SQLException se){}
    }
    return ar;
    }  
   }
    

    

