package ActionClassAttend;

import java.util.*;
import Beans.JavaBean;
import java.sql.*;
import com.myapp.struts.Dataconnectivity;

public class MyMethodsAttend {
static Connection con=null;
static PreparedStatement psmt=null;
static PreparedStatement psmt1=null;
static ResultSet rs=null;
static ResultSet rs1=null;    
   
  public ArrayList scheduleData(int stssn,int essn,String etype,String clas){
            try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
    ArrayList ar1=new ArrayList();        
       String qr1="select * from examdates where startssn="+stssn+" and endssn="+essn+" and examtype='"+etype+"' and class='"+clas+"'";
     try{
      psmt=con.prepareStatement(qr1);
      rs=psmt.executeQuery();
      while(rs.next()){
       JavaBean jb=new JavaBean();   
       jb.setId(rs.getString("id"));
       jb.setFrom(rs.getInt("startssn"));
       jb.setTo(rs.getInt("endssn")); 
       jb.setExtype(rs.getString("examtype"));           
       jb.setClas(rs.getString("class"));                                  
       jb.setSub(rs.getString("subject"));
       jb.setDate(rs.getString("dated"));
       jb.setTime(rs.getString("times"));  
       ar1.add(jb);
      }              
     }
     catch(SQLException se){
     System.out.println(se.getMessage());              
     }  
        finally{
       try{
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }  
    return ar1;   
  }  
   
    public ArrayList retriveAllClass(){
              try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
    ArrayList ar1=new ArrayList();        
       String qr1="select class from classes";
     try{
      psmt=con.prepareStatement(qr1);
      rs=psmt.executeQuery();
      while(rs.next()){  
       ar1.add(rs.getString("class"));
      }              
     }
     catch(SQLException se){
     System.out.println(se.getMessage());              
     }    
        finally{
       try{
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }  
    return ar1;   
  } 
    
    public ArrayList retriveClassesId(){
              try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }            
       ArrayList ar1=new ArrayList();        
       String qr1="select cid,class from classes";
     try{
      psmt=con.prepareStatement(qr1);
      rs=psmt.executeQuery();
      while(rs.next()){ 
       JavaBean jb=new JavaBean();    
       jb.setId(rs.getString("cid"));   
       jb.setClas(rs.getString("class"));
       ar1.add(jb);
      }              
     }
     catch(SQLException se){
     System.out.println(se.getMessage());              
     }    
        finally{
       try{
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }  
    return ar1;   
  }
    
    public ArrayList selectStudents(int stssn,int endssn,String clas){
              try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
    ArrayList ar1=new ArrayList();      
    ArrayList ar2=new ArrayList();
       String qr1="select studname from oldstudregis where classes='"+clas+"' and syear='"+stssn+"' and eyear='"+endssn+"' and studname not in (select studname from studclasssection where class='"+clas+"' and syear='"+stssn+"' and eyear='"+endssn+"') order by studname";
       try{
      psmt1=con.prepareStatement(qr1);
      rs1=psmt1.executeQuery();
      while(rs1.next()){
      ar1.add(rs1.getString("studname"));
      }
      Object name[]=ar1.toArray();  
      Arrays.sort(name);
      for(int i=0;i<name.length;i++){
       ar2.add(name[i]);    
      }
     }
     catch(SQLException se){
     System.out.println(se.getMessage());              
     } 
        finally{
       try{
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }  
    return ar2;   
  } 
    
     public ArrayList selectStudSec(int stssn,String clas,String sec,String dt){
               try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
      ArrayList ar1=new ArrayList();      
      String qr1="select sname from studacaddetail where classes='"+clas+"' and section='"+sec+"' and syear='"+stssn+"' and sname not in (select studname from studdailyattend where class='"+clas+"' and section='"+sec+"' and froms='"+stssn+"' and str_to_date(dated,'%d/%m/%Y')=str_to_date('"+dt+"','%d/%m/%Y')) order by sname";
     try{
      psmt1=con.prepareStatement(qr1);
      rs1=psmt1.executeQuery();
      while(rs1.next()){
      ar1.add(rs1.getString("sname"));
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
       catch(SQLException se){}
      }
     return ar1;   
  }
     
     public ArrayList gtSubject(int frm,int to,String clas){
               try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
      ArrayList ar=new ArrayList();   
         String qr1="select subjects from coursetable where class='"+clas+"' and froms="+frm+" and tos="+to;
     try{
      psmt1=con.prepareStatement(qr1);
      rs1=psmt1.executeQuery();
      while(rs1.next()){
      ar.add(rs1.getString("subjects"));
      }
     }
     catch(SQLException se){
     System.out.println(se.getMessage());              
     } 
        finally{
       try{
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }    
      return ar;
     }
     
     public ArrayList gtStudName(int frm,int to,String clas,String sub,String extype){
                 try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
       ArrayList ar=new ArrayList();   
       String qr1="select studname from studclasssection where class='"+clas+"' and froms="+frm+" and tos="+to+" and studname not in (select studname from studentmarks where class='"+clas+"' and froms="+frm+" and tos="+to+" and subjects='"+sub+"' and examtype='"+extype+"')";
      try{
      psmt1=con.prepareStatement(qr1);
      rs1=psmt1.executeQuery();
      while(rs1.next()){
      ar.add(rs1.getString("studname"));
      }
     }
     catch(SQLException se){
     System.out.println(se.getMessage());              
     } 
        finally{
       try{
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }  
      return ar;
     }
    
     public ArrayList gtAllStudName(int frm,int to,String clas){
                    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
       ArrayList ar=new ArrayList(); 
       String qr1="select studname from studclasssection where class='"+clas+"' and froms="+frm+" and tos="+to;
      try{
      psmt1=con.prepareStatement(qr1);
      rs1=psmt1.executeQuery();
      while(rs1.next()){
      ar.add(rs1.getString("studname"));
      }
     }
     catch(SQLException se){
     System.out.println(se.getMessage());              
     }  
        finally{
       try{
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }  
      return ar;
     }
       
      public double gtStudMarks(int frm,int to,String clas,String etype,String name,String sub){
                try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
      double mk=0.0;         
      String qr1="select marks from studentmarks where studname='"+name+"' and subjects='"+sub+"' and class='"+clas+"' and froms="+frm+" and tos="+to+" and examtype='"+etype+"'";
      try{
      psmt1=con.prepareStatement(qr1);
      rs1=psmt1.executeQuery();
      if(rs1.next()){
      mk=rs1.getDouble("marks");      
      }
     }
     catch(SQLException se){
     System.out.println(se.getMessage());              
     } 
      finally{
       try{
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }
     return mk;
     }   
      
      public HashMap months(){          
       HashMap hm=new HashMap();
       Integer in1=new Integer(1); 
       hm.put(in1,"January");
       Integer in2=new Integer(2);
       hm.put(in2,"February");
       Integer in3=new Integer(3);
       hm.put(in3,"March");
       Integer in4=new Integer(4);
       hm.put(in4,"April");
       Integer in5=new Integer(5);
       hm.put(in5,"May");
       Integer in6=new Integer(6);
       hm.put(in6,"June");
       Integer in7=new Integer(7);
       hm.put(in7,"July");
       Integer in8=new Integer(8);
       hm.put(in8,"August");
       Integer in9=new Integer(9);
       hm.put(in9,"September");
       Integer in10=new Integer(10);
       hm.put(in10,"October");
       Integer in11=new Integer(11);
       hm.put(in11,"November");
       Integer in12=new Integer(12);
       hm.put(in12,"December");          
       return hm;   
      }
}
