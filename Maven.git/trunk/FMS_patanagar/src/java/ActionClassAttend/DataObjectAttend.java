package ActionClassAttend;

import java.sql.*;
import Beans.JavaBean;
import java.util.*;
import com.myapp.struts.Dataconnectivity;

public class DataObjectAttend {
static Connection con=null;
static PreparedStatement psmt=null;
static ResultSet rs=null;
    
   public ArrayList studentName(JavaBean jb){
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }  
  String qr1="";
  int syr=jb.getFrom();
  int eyr=jb.getTo();     
  String mon=jb.getMonth();
  String clas=jb.getClas();
  ArrayList ar=new ArrayList();
  if(!clas.equals("All")){
  qr1="select regisnum,studname,classes from oldstudregis where classes='"+clas+"' and syear='"+syr+"' and eyear='"+eyr+"' and regisnum in (select regisnum from feemonthrec where class='"+clas+"' and syear='"+syr+"' and eyear='"+eyr+"' and "+mon+"='notpaid')";
  }
  else{
  qr1="select regisnum,studname,classes from oldstudregis where syear='"+syr+"' and eyear='"+eyr+"' and regisnum in (select regisnum from feemonthrec where syear='"+syr+"' and eyear='"+eyr+"' and "+mon+"='notpaid')";    
  }
  try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  while(rs.next()){
  JavaBean jb1=new JavaBean();   
  jb1.setRegisno(rs.getString("regisnum"));    
  jb1.setStudname(rs.getString("studname"));  
  jb1.setClas(rs.getString("classes"));         
  ar.add(jb1);
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

        public boolean deleteClassData(String pr){
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }    
        JavaBean jb1=new JavaBean();
        String qr1="delete from classes where cid="+pr; 
  try{
  psmt=con.prepareStatement(qr1);
  psmt.executeUpdate();
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
   return true;     
    }   
    
        public boolean delSchedData(String pr){
               try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }    
        JavaBean jb1=new JavaBean();
        String qr1="delete from examdates where id="+pr; 
  try{
  psmt=con.prepareStatement(qr1);
  psmt.executeUpdate();
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
   return true;     
    }
    
    public ArrayList displayHolidayData(String yr){
               try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
        ArrayList ar=new ArrayList();
         String qr1="select id,dated,holiday from holidays where date_format(str_to_date(dated,'%d/%m/%Y'),'%Y')='"+yr+"'"; 
  try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  while(rs.next()){
  JavaBean jb1=new JavaBean();   
  jb1.setId(rs.getString("id"));    
  jb1.setDated(rs.getString("dated"));  
  jb1.setHoliday(rs.getString("holiday")); 

  ar.add(jb1);
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
    
       public ArrayList expenses(String dt1,String dt2){  
                  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
  ArrayList ar=new ArrayList();
  String qr1="select id,dated,detail,amount,empname,receiptno,paymentmode,chequeno from all_expenses where str_to_date(dated,'%d/%m/%Y') between str_to_date('"+dt1+"','%d/%m/%Y') and str_to_date('"+dt2+"','%d/%m/%Y')";
  try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  while(rs.next()){
  JavaBean jb1=new JavaBean();   
  jb1.setId(rs.getString("id"));    
  jb1.setDated(rs.getString("dated"));  
  jb1.setDetails(rs.getString("detail")); 
  jb1.setAmount(rs.getDouble("amount"));
  jb1.setEmpname(rs.getString("empname"));
  jb1.setRecptno(rs.getString("receiptno"));
  jb1.setPaymode(rs.getString("paymentmode"));
  jb1.setChequeno(rs.getString("chequeno"));
  ar.add(jb1);
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
      /////////////////////////////////////////////////////////////////////////////////////  
   public ArrayList allExpUpdate1(){         
        try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }      
  ArrayList ar=new ArrayList();
  String qr1="select id,dated,detail,amount,empname,receiptno,paymentmode,chequeno from all_expenses";
  try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  while(rs.next()){
  JavaBean jb1=new JavaBean();   
  jb1.setId(rs.getString("id"));    
  jb1.setDated(rs.getString("dated"));  
  jb1.setDetails(rs.getString("detail")); 
  jb1.setAmount(rs.getDouble("amount"));
  jb1.setEmpname(rs.getString("empname"));
  jb1.setRecptno(rs.getString("receiptno"));
  jb1.setPaymode(rs.getString("paymentmode"));
  jb1.setChequeno(rs.getString("chequeno"));
  ar.add(jb1);
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
   public ArrayList allExpUpdate2(String id1){
         try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }     
   String id=id1;
   ArrayList ar=new ArrayList();
  String qr1="select id,dated,detail,amount,empname,receiptno,paymentmode,chequeno from all_expenses where id="+id;
  try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  while(rs.next()){
  JavaBean jb1=new JavaBean();   
   jb1.setId(rs.getString("id"));    
  jb1.setDated(rs.getString("dated"));  
  jb1.setDetails(rs.getString("detail")); 
  jb1.setAmount(rs.getDouble("amount"));
  jb1.setEmpname(rs.getString("empname"));
  jb1.setRecptno(rs.getString("receiptno"));
  jb1.setPaymode(rs.getString("paymentmode"));
  jb1.setChequeno(rs.getString("chequeno"));
  ar.add(jb1);
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
   
   public boolean allExpUpdate3(JavaBean jb1){  
        try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }      
  String id1=jb1.getId();   
  String dt=jb1.getDated();
  String det=jb1.getDetails();  
  double amt=jb1.getAmount();
  String ename=jb1.getEmpname();
  String recptno=jb1.getRecptno();
  String paymode=jb1.getPaymode();
  String chqno=jb1.getChequeno();        
  String qr1="update all_expenses set dated=?,detail=?,amount=?,empname=?,receiptno=?,paymentmode=?,chequeno=? where id="+id1;
  try{
  psmt=con.prepareStatement(qr1);
  psmt.setString(1,dt);    
  psmt.setString(2,det);
  psmt.setDouble(3,amt);
  psmt.setString(4,ename);
  psmt.setString(5,recptno);
  psmt.setString(6,paymode);
  psmt.setString(7,chqno);
  psmt.executeUpdate();
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
  return true;
  }     
  ///////////////////////////////////////////////////////////////////////////////////// 
    
     public boolean allExpense(JavaBean jb1){  
                try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
  String dt=jb1.getDated();
  String det=jb1.getDetails();
  double amt=jb1.getAmount();
  String empn=jb1.getEmpname();
  String recptno=jb1.getRecptno();
  String paymode=jb1.getPaymode();
  String chqno=jb1.getChequeno();       
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }  
  String qr1="insert into all_expenses(dated,detail,amount,empname,receiptno,paymentmode,chequeno)values(?,?,?,?,?,?,?)";
  try{
  psmt=con.prepareStatement(qr1);
  psmt.setString(1,dt);   
  psmt.setString(2,det); 
  psmt.setDouble(3,amt);
  psmt.setString(4,empn); 
  psmt.setString(5,recptno); 
  psmt.setString(6,paymode); 
  psmt.setString(7,chqno); 
  psmt.executeUpdate();
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
  return true;    
  }
 public boolean schedExam(JavaBean jb){
            try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  } 
  String qr1="insert into examdates(startssn,endssn,examtype,class,subject,dated,times)values(?,?,?,?,?,?,?)";   
  try{
   psmt=con.prepareStatement(qr1);   
   psmt.setInt(1,jb.getFrom());
   psmt.setInt(2,jb.getTo());
   psmt.setString(3,jb.getExtype());
   psmt.setString(4,jb.getClas());
   psmt.setString(5,jb.getSub());
   psmt.setString(6,jb.getDate());
   psmt.setString(7,jb.getTime());
   psmt.executeUpdate();
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
  return true;    
 }    
 
  public boolean classData(JavaBean jb){ 
         try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }    
  String qr1="insert into classes(class)values(?)";   
  try{
   psmt=con.prepareStatement(qr1);   
   psmt.setString(1,jb.getClas());
   psmt.executeUpdate();
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
  return true;    
 } 
   public int checkClassData(JavaBean jb){ 
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }    
  int count=0; 
  String qr1="select count(*) as cnt from classes where class='"+jb.getClas()+"'";   
  try{
   psmt=con.prepareStatement(qr1);  
   rs=psmt.executeQuery();
   if(rs.next()){
   count=rs.getInt("cnt");
   }
   psmt.executeUpdate();
  }
  catch(SQLException se){
   System.out.println(se.getMessage());   
  }  
    finally{
       try{
         if(rs!=null){rs.close();}  
         if(psmt!=null){psmt.close();}  
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }
  return count;    
 } 
  
    public boolean holidayData(JavaBean jb){ 
           try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }    
  String qr1="insert into holidays(dated,holiday)values(?,?)";   
  try{
   psmt=con.prepareStatement(qr1);   
   psmt.setString(1,jb.getDated());
   psmt.setString(2,jb.getHoliday());
   psmt.executeUpdate();
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
  return true;    
 } 
  
  public boolean sectionData(JavaBean jb,ArrayList ar1,ArrayList ar2){ 
         try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }    
  String qr1="insert into studclasssection(froms,studname,class,section,tos)values(?,?,?,?,?)";   
  try{  
  for(int i=0;i<ar1.size();i++){      
   psmt=con.prepareStatement(qr1);   
   psmt.setInt(1,jb.getFrom());   
   psmt.setString(2,ar1.get(i).toString());
   psmt.setString(3,jb.getClas());
   psmt.setString(4,ar2.get(i).toString());
   psmt.setInt(5,jb.getTo());
   psmt.executeUpdate();  
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
  return true;    
 } 
  
    public boolean subjectData(JavaBean jb){ 
           try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }    
  String qr1="insert into coursetable(froms,tos,class,subjects)values(?,?,?,?)";    
  try{     
   psmt=con.prepareStatement(qr1);   
   psmt.setInt(1,jb.getFrom());
   psmt.setInt(2,jb.getTo());
   psmt.setString(3,jb.getClas());
   psmt.setString(4,jb.getSub());
   psmt.executeUpdate();
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
  return true;    
 }
    
   public boolean studMarksData(JavaBean jb,String[]ar1,String[]ar2){
          try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }    
  String qr1="insert into studentmarks(froms,tos,class,subjects,examtype,studname,marks)values(?,?,?,?,?,?,?)";    
  try{ 
  for(int i=0;i<ar1.length;i++){
   if(!ar1[i].equals("") && ar1[i]!=null && !ar2[i].equals("") && ar2[i]!=null){       
   psmt=con.prepareStatement(qr1);   
   psmt.setInt(1,jb.getFrom());
   psmt.setInt(2,jb.getTo());
   psmt.setString(3,jb.getClas());
   psmt.setString(4,jb.getSub());
   psmt.setString(5,jb.getExtype());
   psmt.setString(6,ar1[i]);
   psmt.setDouble(7,Double.parseDouble(ar2[i]));
   psmt.executeUpdate();   
   }
   else{continue;}
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
  return true;    
 }    
  
   public boolean dailyAttendData(JavaBean jb,ArrayList ar1,ArrayList ar2){ 
          try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }    
  String qr1="insert into studdailyattend(froms,class,section,studname,status,dated,tos)values(?,?,?,?,?,?,?)";   
  try{ 
  for(int i=0;i<ar1.size();i++){       
   psmt=con.prepareStatement(qr1);   
   psmt.setInt(1,jb.getFrom());   
   psmt.setString(2,jb.getClas());
   psmt.setString(3,jb.getSection());
   psmt.setString(4,ar1.get(i).toString());  
   psmt.setString(5,ar2.get(i).toString());
   psmt.setString(6,jb.getDate());
   psmt.setInt(7,jb.getTo());
   psmt.executeUpdate();
   }     
   }
    catch(SQLException se){
   System.out.println(se.getMessage());   
    }
  finally{
          try
           {
             if(rs!=null)
             {rs.close();}  
             if(psmt!=null)
             {psmt.close();}           
             if(con!=null)
             {
               con.close();
             }
           }catch(SQLException e){}
  }
    
  return true;    
 }
}
