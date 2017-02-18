package ActionClass;
import EO.SchoolEO;
import java.sql.*;
import Beans.*;
import java.util.*;

public class DataObj {
Connection con=null;
PreparedStatement psmt=null;
PreparedStatement psmt1=null;
ResultSet rs=null;
ResultSet rs1=null;

public int addFine(SchoolEO seo)
{
    int count=0;
    try{
        Dataconnectivity dc=new Dataconnectivity();
        con=dc.Dataconnect();
    }
    catch(Exception e){} 
 try{
//     String qr="select count(*) as cn from latefine_onfee where session=? and session_sem=?";
     String qr="select count(*) as cn from latefine_onfee where degree=?";
     psmt1=con.prepareStatement(qr);
     psmt1.setString(1, seo.getDegree());
//     psmt1.setString(1, seo.getSession());
//     psmt1.setString(2, seo.getSession_sem());
     rs1=psmt1.executeQuery();
     if(rs1.next())
     {
         count=rs1.getInt("cn");
     }
     if(count==0){
     String sq="insert into latefine_onfee(degree,semester,last_date,fine_per_day,max_fine,session,session_sem,min_fine)values(?,?,?,?,?,?,?,?)";
     psmt=con.prepareStatement(sq);
     psmt.setString(1,seo.getDegree());
     psmt.setString(2,seo.getSemester());
     psmt.setString(3,seo.getLastdate());
     psmt.setDouble(4,seo.getPfine());
     psmt.setDouble(5,seo.getMax_fine());
     psmt.setString(6, seo.getSession());
     psmt.setString(7, seo.getSession_sem());
     psmt.setDouble(8,seo.getMin_fine());
     psmt.executeUpdate();
     }
 }catch(Exception se){}
 finally{
    try{
    if(psmt!=null){psmt.close();}
    if(psmt1!=null){psmt1.close();}
    if(rs1!=null){rs1.close();}
    if(con!=null){con.close();}
    }catch(SQLException e){}
    }
 return count;
}
public ArrayList getFine()
{
    ArrayList al=new ArrayList();
    
    try{
        Dataconnectivity dc=new Dataconnectivity();
        con=dc.Dataconnect();
    }
    catch(Exception e){} 
 try{
     String sq="select * from latefine_onfee";
//     System.out.println(sq);
     psmt=con.prepareStatement(sq);
     rs=psmt.executeQuery();
     while(rs.next())
     {
         SchoolEO se=new SchoolEO();
         se.setDegree(rs.getString("degree"));
         se.setSemester(rs.getString("semester"));
         se.setSession(rs.getString("session"));
         se.setSession_sem(rs.getString("session_sem"));
         se.setLastdate(rs.getString("last_date"));
         se.setPfine(rs.getDouble("fine_per_day"));
         se.setMax_fine(rs.getDouble("max_fine"));
         se.setMin_fine(rs.getDouble("min_fine"));
         se.setMin_fine(rs.getDouble("min_fine"));
         se.setRowid(rs.getInt("rwid"));
         al.add(se);
     }
     
 }catch(Exception e){}
 finally{
    try{
    if(psmt!=null){psmt.close();}
    if(con!=null){con.close();}
    }catch(SQLException e){}
    }
 return al;
}

public void del_FineDetails(int rwid)
{
    ArrayList al=new ArrayList();
    
    try{
        Dataconnectivity dc=new Dataconnectivity();
        con=dc.Dataconnect();
    }
    catch(Exception e){} 
 try{
//     String sq="delete from latefine_onfee where degree='"+seo.getDegree()+"' and semester='"+seo.getSemester()+"'";
     String sq="delete from latefine_onfee where rwid=?";
     psmt=con.prepareStatement(sq);
     psmt.setInt(1, rwid);
     psmt.executeUpdate();
     
 }catch(Exception e){}
 finally{
    try{
    if(psmt!=null){psmt.close();}
    if(con!=null){con.close();}
    }catch(SQLException e){}
    }
}

public ArrayList getPertFine(SchoolEO seo)
{
    ArrayList al= new ArrayList();
    
    try{
        Dataconnectivity dc=new Dataconnectivity();
        con=dc.Dataconnect();
    }
    catch(Exception e){} 
    
//    String sqr="select * from latefine_onfee where degree='"+seo.getDegree()+"' and semester='"+seo.getSemester()+"'";
//    String sqr="select * from latefine_onfee where session='"+seo.getSession()+"' and session_sem='"+seo.getSession_sem()+"'";
    String sqr="select * from latefine_onfee where rwid="+seo.getRowid();
    
        try{
           psmt=con.prepareStatement(sqr);
     rs=psmt.executeQuery();
     while(rs.next())
     {
         seo.setDegree(rs.getString("degree"));
         seo.setSemester(rs.getString("semester"));
         seo.setSession(rs.getString("session"));
         seo.setSession_sem(rs.getString("session_sem"));
         seo.setLastdate(rs.getString("last_date"));
         seo.setPfine(rs.getDouble("fine_per_day"));
         seo.setMax_fine(rs.getDouble("max_fine"));
         seo.setMin_fine(rs.getInt("min_fine"));
         seo.setRowid(rs.getInt("rwid"));
         al.add(seo);
     }
    }catch(Exception e){}
        finally{
    try{
    if(psmt!=null){psmt.close();}
    if(con!=null){con.close();}
    }catch(SQLException e){}
    }
    return al;
}

public void updatePertFine(SchoolEO seo)
{
    ArrayList al=new ArrayList();
    
    try{
        Dataconnectivity dc=new Dataconnectivity();
        con=dc.Dataconnect();
    }
    catch(Exception e){} 
 try{
//     String sq="update latefine_onfee set last_date='"+seo.getLastdate()+"',fine_per_day='"+seo.getPfine()+"',max_fine='"+seo.getMax_fine()+"'"
//             + " where degree='"+seo.getDegree()+"' and semester='"+seo.getSemester()+"'";
//     String sq="update latefine_onfee set last_date='"+seo.getLastdate()+"',fine_per_day='"+seo.getPfine()+"',max_fine='"+seo.getMax_fine()+"'"
//             + " where session='"+seo.getSession()+"' and session_sem='"+seo.getSession_sem()+"'";
     
     String sq="update latefine_onfee set last_date='"+seo.getLastdate()+"',fine_per_day='"+seo.getPfine()+"',max_fine='"+seo.getMax_fine()+"'"
             + ",min_fine='"+seo.getMin_fine()+"' where rwid="+seo.getRowid();
//     System.out.println(sq);
     psmt=con.prepareStatement(sq);
     psmt.executeUpdate();
     
 }catch(Exception e){}
 finally{
    try{
    if(psmt!=null){psmt.close();}
    if(con!=null){con.close();}
    }catch(SQLException e){}
    }
}

public int upCcData(CcBean cb){
 int cn=0;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){} 
 try{
 String qr1="update cc_data set name=?,fname=?,from_sesn=?,to_sesn=?,classes=? where adminno='"+cb.getAdminNo()+"'";    
 psmt=con.prepareStatement(qr1);    
 psmt.setString(1,cb.getName());
 psmt.setString(2,cb.getFname());
 psmt.setString(3,cb.getFrom());
 psmt.setString(4,cb.getTo());
 psmt.setString(5,cb.getClasses());
 psmt.executeUpdate();
 }catch(SQLException se){cn=1;}
 return cn;
}

public int upTcData(TcBean tb){
int cn=0;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){} 
 try{
 String qr1="update tc_data set name=?,fname=?,dob=?,clg_ent_year=?,study_year=?,study_month=?,lastedu_class=?,result=?,migrat_reason=?,enrolno=? where adminno='"+tb.getAdminNo()+"'";      
  psmt=con.prepareStatement(qr1);    
  psmt.setString(1,tb.getName());
  psmt.setString(2,tb.getFname());
  psmt.setString(3,tb.getDob());
  psmt.setString(4,tb.getEntYear());
  psmt.setInt(5,tb.getStudYear());
  psmt.setInt(6,tb.getStudMonth());
  psmt.setString(7,tb.getLastClass());
  psmt.setString(8,tb.getResult());
  psmt.setString(9,tb.getMigrReason());
  psmt.setString(10,tb.getEnrolNo());
  psmt.executeUpdate();
 }catch(SQLException se){cn=1;}
 return cn;
}

public int subCcData(CcBean cb){
 int cn=0;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){} 
 try{
 String qr1="insert into cc_data(adminno,name,fname,from_sesn,to_sesn,classes)values(?,?,?,?,?,?)";    
 psmt=con.prepareStatement(qr1);    
 psmt.setString(1,cb.getAdminNo());
 psmt.setString(2,cb.getName());
 psmt.setString(3,cb.getFname());
 psmt.setString(4,cb.getFrom());
 psmt.setString(5,cb.getTo());
 psmt.setString(6,cb.getClasses());
 psmt.executeUpdate();
 }catch(SQLException se){cn=1;}
 return cn;
}

public int subTcData(TcBean tb){
int cn=0;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){} 
 try{
 String qr1="insert into tc_data(adminno,name,fname,dob,clg_ent_year,study_year,study_month,lastedu_class,result,migrat_reason,enrolno,mname)values(?,?,?,?,?,?,?,?,?,?,?,?)";      
  psmt=con.prepareStatement(qr1);    
  psmt.setString(1,tb.getAdminNo());
  psmt.setString(2,tb.getName());
  psmt.setString(3,tb.getFname());
  psmt.setString(4,tb.getDob());
  psmt.setString(5,tb.getEntYear());
  psmt.setInt(6,tb.getStudYear());
  psmt.setInt(7,tb.getStudMonth());
  psmt.setString(8,tb.getLastClass());
  psmt.setString(9,tb.getResult());
  psmt.setString(10,tb.getMigrReason());
  psmt.setString(11,tb.getEnrolNo());
    psmt.setString(12,tb.getMname());
  psmt.executeUpdate();
 }catch(SQLException se){cn=1;}
 return cn;
}
    
  public ArrayList studentName(JavaBean jb){
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}  
  String qr1="";
  int syr=jb.getFrom();
  int eyr=jb.getTo();     
  String mon=jb.getMonth();
  String clas=jb.getClas();
  ArrayList ar=new ArrayList();
  if(!clas.equals("All")){
  qr1="select regisnum,studname,classes from oldstudregis where classes='"+clas+"' and syear='"+syr+"' and eyear='"+eyr+"' and regisnum in (select regisnum from feemonthrec where class='"+clas+"' and syear='"+syr+"' and eyear='"+eyr+"' and "+mon+"='notpaid')";
  }else{
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
  catch(Exception e){}    
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
  
    public boolean deleteBranchData(String pr){
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}    
        JavaBean jb1=new JavaBean();
        String qr1="delete from branch where id="+pr; 
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
  
  
  
   public ArrayList getBranch(String degree){
               try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
        ArrayList ar=new ArrayList();
         String qr1="select branch from branch where degree='"+degree+"'"; 
  try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  while(rs.next()){
  JavaBean jb1=new JavaBean();   
 jb1.setBranch(rs.getString("branch"));

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
 
  
   public ArrayList getSubjectList(SchoolEO jb){
               try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
        ArrayList ar=new ArrayList();
         String qr1="select sub_code,sub_name,prac from semester_sub where degree='"+jb.getDegree()+"' and branch='"+jb.getBranch()+"' and semester='"+jb.getSemester()+"'"; 
  try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  while(rs.next()){
  SchoolEO be=new SchoolEO();   
 be.setSub_code(rs.getString("sub_code"));
be.setSub_name(rs.getString("sub_name"));
be.setPrac(rs.getString("prac"));
  ar.add(be);
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
  catch(SQLException se){} 
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
  catch(Exception e){}    
  String qr1="insert into classes(class,stream)values(?,?)";   
  try{
   psmt=con.prepareStatement(qr1);   
   psmt.setString(1,jb.getClas());
   psmt.setString(2,jb.getStream());
  // psmt.setString(2,jb.getType());
   psmt.executeUpdate();
  }
  catch(SQLException se){}  
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
  catch(Exception e){}    
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
  catch(SQLException se){}  
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
  
  public boolean branchData(JavaBean jb){ 
         try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}    
  String qr1="insert into branch(degree,branch,duration)values(?,?,?)";   
  try{
   psmt=con.prepareStatement(qr1);   
   psmt.setString(1,jb.getClas());
   psmt.setString(2,jb.getStream());
   psmt.setString(3,jb.getDuration());
  // psmt.setString(2,jb.getType());
   psmt.executeUpdate();
  }
  catch(SQLException se){}  
    finally{
       try{
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }
  return true;    
 } 
   public int checkBranchData(JavaBean jb){ 
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}    
  int count=0; 
  String qr1="select count(*) as cnt from branch where branch='"+jb.getStream()+"' and degree='"+jb.getClas()+"'";   
  try{
   psmt=con.prepareStatement(qr1);  
   rs=psmt.executeQuery();
   if(rs.next()){
   count=rs.getInt("cnt");
   }
   psmt.executeUpdate();
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
   
public void enterBankName(SchoolEO seo){
 int cn=0;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){} 
 try{
 String qr1="insert into bank(bank_name)values(?)";    
 psmt=con.prepareStatement(qr1);    
 psmt.setString(1, seo.getBankname());
 psmt.executeUpdate();
 }catch(SQLException se){cn=1;}
 finally{
     try{
     if(rs!=null){rs.close();}
     if(psmt!=null){psmt.close();}
     if(con!=null){con.close();}
     }catch(Exception e){}
     }
 }
 



public ArrayList retBankName(){
    ArrayList al=new ArrayList();
 int cn=0;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){} 
 try{
 String qr1="select * from bank";    
 psmt=con.prepareStatement(qr1);    
 rs=psmt.executeQuery();
 while(rs.next())
 {
     SchoolEO seo=new SchoolEO();
     seo.setRowid(rs.getInt("rwid"));
     seo.setBankname(rs.getString("bank_name"));
     al.add(seo);
 }
 
 }catch(SQLException se){cn=1;}
 finally{
     try{
     if(rs!=null){rs.close();}
     if(psmt!=null){psmt.close();}
     if(con!=null){con.close();}
     }catch(Exception e){}
     }
 return al;
}

public void deleteRowFromDynTable(int id,String table){
    ArrayList al=new ArrayList();
 int cn=0;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){} 
 try{
 String qr1="delete from "+table+" where rwid=?";    
 psmt=con.prepareStatement(qr1);   
 psmt.setInt(1, id);
 psmt.executeUpdate();
 }catch(SQLException se){cn=1;}
 finally{
     try{
     if(rs!=null){rs.close();}
     if(psmt!=null){psmt.close();}
     if(con!=null){con.close();}
     }catch(Exception e){}
     }
}


public int enterStudentId(SchoolEO seo)
{
int cn=1;
  
    PreparedStatement psmt=null;
 PreparedStatement psmt1=null;
 PreparedStatement psmt2=null;
 PreparedStatement psmt3=null;
 PreparedStatement psmt4=null;
 PreparedStatement psmt5=null;
 PreparedStatement psmt6=null;
 PreparedStatement psmt7=null;
 ResultSet rs=null;
ResultSet rs1=null;
ResultSet rs2=null;
ResultSet rs3=null;
    int cnt=0;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  con.setAutoCommit(false);
  }
  catch(Exception e){} 
    try
    {
     String qr1="update sub_feedata set stud_id=? where session=? and regist_no=? and session_sem=?";
     psmt1=con.prepareStatement(qr1);
     psmt1.setString(1, seo.getStud_id());
     psmt1.setString(2, seo.getSession());
     psmt1.setString(3, seo.getSrnum());
     psmt1.setString(4, seo.getSession_sem());
     psmt1.executeUpdate();
     
     String qr2="update stud_fee_draft set stud_id=? where session=? and srnum=? and session_sem=?";
     psmt2=con.prepareStatement(qr2);
     psmt2.setString(1, seo.getStud_id());
     psmt2.setString(2, seo.getSession());
     psmt2.setString(3, seo.getSrnum());
     psmt2.setString(4, seo.getSession_sem());
     psmt2.executeUpdate();
     
     String qr3="update stud_draft set stud_id=? where session=? and srnum=? and session_sem=?";
     psmt3=con.prepareStatement(qr3);
     psmt3.setString(1, seo.getStud_id());
     psmt3.setString(2, seo.getSession());
     psmt3.setString(3, seo.getSrnum());
     psmt3.setString(4, seo.getSession_sem());
     psmt3.executeUpdate();
     
     String qr4="update studentregis set stud_id=? where session=? and srnum=?";
     psmt4=con.prepareStatement(qr4);
     psmt4.setString(1, seo.getStud_id());
     psmt4.setString(2, seo.getSession());
     psmt4.setString(3, seo.getSrnum());
     psmt4.executeUpdate();
     
     String qr7="update stud_fee_detail set stud_id=? where session=? and srnum=? and session_sem=?";
     psmt4=con.prepareStatement(qr7);
     psmt4.setString(1, seo.getStud_id());
     psmt4.setString(2, seo.getSession());
     psmt4.setString(3, seo.getSrnum());
     psmt4.setString(4, seo.getSession_sem());
     cn=psmt4.executeUpdate();
     
     
        con.commit();
    }catch(Exception e)
    {
        System.out.println("Error in providing student id "+e.getMessage());
       try{    
       con.rollback();
       cnt=-3;
       }catch(SQLException se2){} 
    }
    finally{
        try{
          if(rs!=null){rs.close();} 
          if(rs1!=null){rs1.close();}
          if(rs2!=null){rs2.close();}
          if(rs3!=null){rs3.close();}
          if(psmt!=null){psmt.close();} 
          if(psmt1!=null){psmt1.close();} 
          if(psmt2!=null){psmt2.close();} 
          if(psmt3!=null){psmt3.close();} 
          if(psmt4!=null){psmt4.close();} 
          if(psmt5!=null){psmt5.close();} 
          if(psmt6!=null){psmt6.close();} 
          if(psmt7!=null){psmt7.close();} 
          if(con!=null){con.close();}
        }catch(Exception e){}
    }
    
    return cn;
}

// By Kapil
public int checkStudId(SchoolEO seo)
{
    PreparedStatement psmt=null;
 PreparedStatement psmt6=null;
 ResultSet rs1=null;
ResultSet rs2=null;
    int cnt=-3;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){} 
    try
    {
        
        String qry="select stud_id,session from studentregis where session=? and srnum=?";
        psmt6=con.prepareStatement(qry);
        psmt6.setString(1, seo.getSession());
        psmt6.setString(2, seo.getSrnum());
        rs2=psmt6.executeQuery();
        if(rs2.next())
        {
           if(rs2.getString("stud_id")!=null&&!rs2.getString("stud_id").equals("")) 
           {
               cnt=-2;
           }
        else
        {
            String qr="select count(*) as cnt from sub_feedata where session=? and session_sem=? and regist_no=? group by regist_no";
            psmt=con.prepareStatement(qr);   
            psmt.setString(1, seo.getSession());
            psmt.setString(2, seo.getSession_sem());
            psmt.setString(3, seo.getSrnum());
            rs=psmt.executeQuery();
            if(rs.next()){
               cnt=rs.getInt("cnt"); 
            }
            else
            {
                cnt=0;
            }
        }
      }
        else{
            cnt=-4;
        }
    }catch(Exception e)
    {
      }
    finally{
        try{
          if(rs1!=null){rs1.close();}
          if(rs2!=null){rs2.close();}
          if(psmt!=null){psmt.close();} 
          if(psmt6!=null){psmt6.close();} 
          if(con!=null){con.close();}
        }catch(Exception e){}
    }
    
    return cnt;
}

public ArrayList getDraftList(SchoolEO seo1)
{
    ArrayList al=new ArrayList();
    ArrayList ar=new ArrayList();
    ArrayList ar1=new ArrayList();
    ArrayList ar2=new ArrayList();
    ArrayList ar3=new ArrayList();
    ArrayList ar4=new ArrayList();
  

 PreparedStatement psmt7=null;
ResultSet rs3=null;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){} 
    try
    {
String qr6="select draft_no,date,bank_name,amount,type,degree from stud_fee_draft where session=? and session_sem=? and srnum=?";     
   psmt7=con.prepareStatement(qr6);
   psmt7.setString(1, seo1.getSession());
   psmt7.setString(2, seo1.getSession_sem());
   psmt7.setString(3, seo1.getSrnum());
   //System.out.println(seo1.getSession()+" "+seo1.getSrnum()+" "+seo1.getSession_sem());
   rs3=psmt7.executeQuery();
   while(rs3.next()){
       //System.out.println("hello: "+seo1.getStud_id());
       ar.add(rs3.getString("draft_no"));
       ar1.add(rs3.getString("date"));
       ar2.add(rs3.getString("bank_name"));
       ar3.add(rs3.getDouble("amount"));
       ar4.add(rs3.getString("type"));
       seo1.setDegree(rs3.getString("degree"));
   }
   seo1.setDataArray(ar);
   seo1.setDataArray1(ar1);
   seo1.setDataArray2(ar2);
   seo1.setDataArray3(ar3);
   seo1.setDataArray4(ar4);
 al.add(seo1);
 //System.out.println("checking db class size: "+al.size());
    }catch(Exception e)
    {
        System.out.println("error in fetching draft data using DataObj "+e.getMessage());
    }
    finally{
        try{
          if(rs3!=null){rs3.close();}
          if(psmt7!=null){psmt7.close();} 
          if(con!=null){con.close();}
        }catch(Exception e){}
    }
    
    return al;
}

public ArrayList getDegree(){
               try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
        ArrayList ar=new ArrayList();
         String qr1="select degree from suraj_degree"; 
  try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  while(rs.next()){
  JavaBean jb1=new JavaBean();   
 jb1.setDegree(rs.getString("degree"));

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
public ArrayList getFinancialDegree(){
               try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
        ArrayList ar=new ArrayList();
         String qr1="select degree from suraj_degree where self_f_prog='Yes'"; 
  try{
  psmt=con.prepareStatement(qr1);
  rs=psmt.executeQuery();
  while(rs.next()){
  JavaBean jb1=new JavaBean();   
 jb1.setDegree(rs.getString("degree"));

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

public int checkProgrammeFee(SchoolEO seo){
    int cn=0;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){} 
 try{
 String qr1="select count(*) as cn from finan_programme where batch=? and prog=?";    
 psmt=con.prepareStatement(qr1);    
 psmt.setString(1, seo.getBatch());
 psmt.setString(2, seo.getDegree());
 rs=psmt.executeQuery();
 if(rs.next())
     cn=rs.getInt("cn");
 }catch(SQLException se){cn=-1;}
 finally{
     try{
     if(rs!=null){rs.close();}
     if(psmt!=null){psmt.close();}
     if(con!=null){con.close();}
     }catch(Exception e){}
     }
    return cn;
}
public void enterProgrammeFee(SchoolEO seo){
 int cn=0;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){} 
 try{
 String qr1="insert into finan_programme(batch,prog,fee)values(?,?,?)";    
 psmt=con.prepareStatement(qr1);    
 psmt.setString(1, seo.getBatch());
 psmt.setString(2, seo.getDegree());
 psmt.setDouble(3, seo.getPamount());
 psmt.executeUpdate();
 }catch(SQLException se){cn=1;}
 finally{
     try{
     if(rs!=null){rs.close();}
     if(psmt!=null){psmt.close();}
     if(con!=null){con.close();}
     }catch(Exception e){}
     }
 }

public ArrayList retProgrammeFee(){
    ArrayList al=new ArrayList();
 int cn=0;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){} 
 try{
 String qr1="select * from finan_programme";    
 psmt=con.prepareStatement(qr1);    
 rs=psmt.executeQuery();
 while(rs.next())
 {
     SchoolEO seo=new SchoolEO();
     seo.setRowid(rs.getInt("rwid"));
     seo.setBatch(rs.getString("batch"));
     seo.setDegree(rs.getString("prog"));
     seo.setPamount(rs.getDouble("fee"));
     al.add(seo);
 }
 
 }catch(SQLException se){cn=1;}
 finally{
     try{
     if(rs!=null){rs.close();}
     if(psmt!=null){psmt.close();}
     if(con!=null){con.close();}
     }catch(Exception e){}
     }
 return al;
}
 
}
