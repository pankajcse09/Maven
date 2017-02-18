package schedule;

import java.sql.*;
import java.util.*;
import com.myapp.struts.Dataconnectivity;
import ActionClass.*;

public class DataObject1{
    
static Connection con=null;
static PreparedStatement psmt=null;
static PreparedStatement psmt1=null;
static PreparedStatement psmt2=null;
static PreparedStatement psmt3=null;
static PreparedStatement psmt4=null;
static PreparedStatement psmt5=null;
static PreparedStatement psmt6=null;
static PreparedStatement psmt7=null;
static ResultSet rs=null;
static ResultSet rs1=null;
static ResultSet rs2=null;
static ResultSet rs3=null;
static ResultSet rs4=null;
static ResultSet rs5=null;
static ResultSet rs6=null;
static ResultSet rs7=null;

  public JavaBean1 editRegistData(String id){  
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }  
   String dcpass="";
   Common cmn=new Common();
   JavaBean1 jb=new JavaBean1();   
   String qr1="select id,name,loginid,password,secretques,secretans from registrationtable where loginid='"+id+"'";   
   try{
        psmt=con.prepareStatement(qr1);  
        rs=psmt.executeQuery();
        if(rs.next()){            
        jb.setId(rs.getString("id"));
        jb.setName(rs.getString("name"));        
        jb.setLoginid(rs.getString("loginid"));
        dcpass=cmn.decrypt(rs.getString("password"));
        jb.setPassword(dcpass);        
        jb.setSecretques(rs.getString("secretques"));
        jb.setSecretans(rs.getString("secretans"));
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
   return jb;    
   } 
  
  public int authenticateData(JavaBean1 jb){
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  } 
  int count=0;
  Common comLogin = new Common(); 
  String role=jb.getRole();
  String usnme=jb.getLoginid();
  String passwd=jb.getPassword();
         usnme=usnme.trim();
         passwd = passwd.trim();           
        String qu="select * from registrationtable";        
        try{
       psmt=con.prepareStatement(qu);     
       rs=psmt.executeQuery();      
              while(rs.next()){  
                                String drole=(String)rs.getString("userrole");
                                String  duname=(String)rs.getString("loginid");
                                duname=duname.trim();
                                String  apasswd=(String)rs.getString("password");
                                apasswd=apasswd.trim();
                                String dpasswd = (String)comLogin.decrypt(apasswd);
                                dpasswd=dpasswd.trim();                 
                                if(duname.equals(usnme) && dpasswd.equals(passwd) && drole.equals(role)){
                                            count=1;
                                             break;
                                            }                                
                              }   
          }
     
     catch(SQLException e){}
     finally { 
                  try{ 
                   if(rs!=null){rs.close(); }
                   if(psmt!=null){psmt.close();}
                   if(con!=null){con.close();}                                     
                    }
                  catch(SQLException e){}                  
             }  
    return count;
    }
  
   public int registUserData2(JBeanEmp jb){ 
   try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }  
   int count=0;
   String qr3="insert into emp_education_data(emp_id,emp_exam_passed,emp_board_univer,emp_subjects,emp_year,emp_percent_mark,emp_distinction)values(?,?,?,?,?,?,?)"; 
   String ss="";
   try{     
   psmt3=con.prepareStatement(qr3);  
   psmt3.setString(1,jb.getEmpId());
   psmt3.setString(2,jb.getHigh());
   psmt3.setString(3,jb.getHigh1());
   psmt3.setString(4,jb.getHigh2());
   psmt3.setString(5,jb.getHigh3());   
   psmt3.setString(6,jb.getHigh4());   
   psmt3.setString(7,jb.getHigh5()); 
   psmt3.executeUpdate(); 
  
   psmt3.setString(1,jb.getEmpId());
   psmt3.setString(2,jb.getInter());
   psmt3.setString(3,jb.getInter1());
   psmt3.setString(4,jb.getInter2());
   psmt3.setString(5,jb.getInter3());   
   psmt3.setString(6,jb.getInter4());   
   psmt3.setString(7,jb.getInter5()); 
   psmt3.executeUpdate(); 

   psmt3.setString(1,jb.getEmpId());
   psmt3.setString(2,jb.getGrad());
   psmt3.setString(3,jb.getGrad1());
   psmt3.setString(4,jb.getGrad2());
   psmt3.setString(5,jb.getGrad3());   
   psmt3.setString(6,jb.getGrad4());   
   psmt3.setString(7,jb.getGrad5()); 
   psmt3.executeUpdate();

   psmt3.setString(1,jb.getEmpId());
   psmt3.setString(2,jb.getPg());
   psmt3.setString(3,jb.getPg1());
   psmt3.setString(4,jb.getPg2());
   psmt3.setString(5,jb.getPg3());   
   psmt3.setString(6,jb.getPg4());   
   psmt3.setString(7,jb.getPg5()); 
   psmt3.executeUpdate(); 

   psmt3.setString(1,jb.getEmpId());
   psmt3.setString(2,jb.getBed());
   psmt3.setString(3,jb.getBed1());
   psmt3.setString(4,jb.getBed2());
   psmt3.setString(5,jb.getBed3());   
   psmt3.setString(6,jb.getBed4());   
   psmt3.setString(7,jb.getBed5()); 
   psmt3.executeUpdate(); 

   psmt3.setString(1,jb.getEmpId());
   psmt3.setString(2,jb.getOther());
   psmt3.setString(3,jb.getOther1());
   psmt3.setString(4,jb.getOther2());
   psmt3.setString(5,jb.getOther3());   
   psmt3.setString(6,jb.getOther4());   
   psmt3.setString(7,jb.getOther5()); 
   psmt3.executeUpdate(); 
   }  
   catch(SQLException se){    
   ss=se.getMessage();    
   System.out.println(se.getMessage());   
    } 
      finally{
       try{
         if(psmt3!=null){psmt3.close();}  
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }   
  return count;  
 }  
  public ArrayList allEmpIdData(){ 
 ArrayList ar=new ArrayList(); 
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }     
  String qr1="select distinct emp_id from loginn";   
   try{
        psmt=con.prepareStatement(qr1);  
        rs1=psmt.executeQuery();
        while(rs1.next()){
        JBeanEmp jb=new JBeanEmp();  
        jb.setEmpId(rs1.getString("emp_id"));
        ar.add(jb);
        }      
      }
   catch(SQLException se){}
   finally{
      try{   
         if(rs1!=null){rs1.close();}  
         if(psmt!=null){psmt.close();}  
         if(con!=null){con.close();}  
         }   
       catch(SQLException se){}      
     }
   return ar;    
   }  

  public JavaBeanExam retriveSubjects(JavaBeanExam jb){ 
   try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }      
   int count=0;
   String sesn=jb.getSessions();
   String clas=jb.getClasses();   
   String sec=jb.getSection();  
   String exmtyp=jb.getExamType(); 
   ArrayList ar=new ArrayList();
   
   String qr="select subject from ex_course_detail where sessions='"+sesn+"' and  class='"+clas+"'";
   try{
   psmt1=con.prepareStatement(qr);   
   rs1=psmt1.executeQuery();
   while(rs1.next()){
   ar.add(rs1.getString("subject"));   
   }
   jb.setSubList(ar);
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
  return jb;  
 }
  
  public ArrayList allStudList(JavaBeanExam jb){ 
   try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }      
   int count=0;
   String sesn=jb.getSessions();
   String clas=jb.getClasses();   
   String sec=jb.getSection();  
   ArrayList ar=new ArrayList();
   
   String qr="select srnum from studacaddetail where syear=substring('"+sesn+"',1,4) and  eyear=substring('"+sesn+"',6,4) and classes='"+clas+"' and  section='"+sec+"'";
   try{
   psmt1=con.prepareStatement(qr);   
   rs1=psmt1.executeQuery();
   while(rs1.next()){
   ar.add(rs1.getString("srnum"));   
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
  return ar;  
 }  
  
  public ArrayList allStudList1(JavaBeanExam jb){ 
   try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }      
   int count=0;
   String sesn=jb.getSessions();
   String clas=jb.getClasses();   
   String sec=jb.getSection();  
   ArrayList ar=new ArrayList();
   String qr="";
        try {  
            if(Integer.parseInt(clas)<9){
            qr="select srnum from studacaddetail where syear=substring('"+sesn+"',1,4) and  eyear=substring('"+sesn+"',6,4) and classes='"+clas+"' and  section='"+sec+"'";
            }
            else{
            qr="select srnum from student_subject where session='"+sesn+"' and class='"+clas+"' and  sec='"+sec+"' and subject='"+jb.getSubject()+"'";
            }
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
   try{
   psmt1=con.prepareStatement(qr);   
   rs1=psmt1.executeQuery();
   while(rs1.next()){
   ar.add(rs1.getString("srnum"));   
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
  return ar;  
 }  
  
  public HashMap marksType(JavaBeanExam jb){ 
   try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }      
   int count=0;
   String sesn=jb.getSessions();
   String clas=jb.getClasses();   
   String sec=jb.getSection();  
   String exam=jb.getExam();
   HashMap hm=new HashMap();   
   String qr="select "+exam+" from ex_course_detail where sessions='"+jb.getSessions()+"' and class='"+jb.getClasses()+"' and  subject='"+jb.getSubject()+"'";
   try{
   psmt1=con.prepareStatement(qr);   
   rs1=psmt1.executeQuery();
   while(rs1.next()){
   hm.put(exam,rs1.getString(exam.toLowerCase()));   
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
  return hm;  
 }  
  
  public int submitMarks(JavaBeanExam jb){ 
   try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }      
   int count=0;
   int bn=0;
   String sesn=jb.getSessions();
   String clas=jb.getClasses();   
   String sec=jb.getSection();  
   String exmtyp=jb.getExamType();
   String sub=jb.getSubject();
   String exam=jb.getExam();
   ArrayList ar=(ArrayList)jb.getStudList();
   HashMap hm=(HashMap)jb.getMarksList();   
   try{
    String qr="insert into "+exam.toLowerCase()+"(sessions,classes,section,examtype,subject,srno,marks,status)values(?,?,?,?,?,?,?,?)"; 
    psmt=con.prepareStatement(qr);
    for(int i=0;i<ar.size();i++){
    psmt.setString(1,sesn);
    psmt.setString(2,clas);
    psmt.setString(3,sec);
    psmt.setString(4,exmtyp);
    psmt.setString(5,sub);
    psmt.setString(6,ar.get(i).toString());
    psmt.setString(7,hm.get(ar.get(i)).toString());
    psmt.setString(8,"ACTIVE");
    psmt.executeUpdate();
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
   bn=1;
  return bn;  
 }  
  
  public JavaBeanExam marksList(JavaBeanExam jb){ 
   try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  } 
   JavaBeanExam jb1=new JavaBeanExam();
   int count=0;
   String sesn=jb.getSessions();
   String clas=jb.getClasses();   
   String sec=jb.getSection();  
   String exmtyp=jb.getExamType();
   String sub=jb.getSubject();
   String exam=jb.getExam();
   ArrayList ar=new ArrayList(); //(ArrayList)jb.getStudList();
   HashMap hm=new HashMap();
   HashMap hm1=new HashMap();
   String qr="";
   try{
  qr="select rowid,srno,marks from "+exam+" where sessions='"+sesn+"' and classes='"+clas+"' and  section='"+sec+"' and examtype='"+exmtyp+"' and subject='"+sub+"' and status='ACTIVE'";
   psmt1=con.prepareStatement(qr);   
   rs1=psmt1.executeQuery();
   while(rs1.next()){
   ar.add(rs1.getString("rowid")); 
   hm.put(rs1.getString("rowid"),rs1.getString("srno")); 
   hm1.put(rs1.getString("rowid"),rs1.getString("marks"));   
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
   jb1.setRowidList(ar);
   jb1.setStudListMap(hm);
   jb1.setMarksList(hm1);
  return jb1;  
 }  
  
  public JavaBeanExam studMarks(JavaBeanExam jb){ 
   try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  } 
   JavaBeanExam jb1=new JavaBeanExam();
   int count=0;
   String exam=jb.getExam();
   ArrayList ar=new ArrayList(); //(ArrayList)jb.getStudList();
   HashMap hm=new HashMap();
   HashMap hm1=new HashMap();
   String qr="";
   try{    
   qr="select srno,marks from "+exam+" where rowid="+jb.getRowid();
   psmt1=con.prepareStatement(qr);   
   rs1=psmt1.executeQuery();
   if(rs1.next()){
   jb1.setStudId(rs1.getString("srno")); 
   jb1.setMarks(rs1.getString("marks"));   
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
  return jb1;  
 }  
  
  public JavaBeanExam updateStudMarks(JavaBeanExam jb){ 
   try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  } 
   int bn=0;
   JavaBeanExam jb1=new JavaBeanExam();
   int count=0;
   String exam=jb.getExam();
   try{    
   String qr="select * from "+exam+" where rowid="+jb.getRowid();   
   psmt1=con.prepareStatement(qr);   
   rs1=psmt1.executeQuery();
   if(rs1.next()){
   jb1.setSessions(rs1.getString("sessions"));
   jb1.setClasses(rs1.getString("classes"));
   jb1.setSection(rs1.getString("section"));
   jb1.setExamType(rs1.getString("examtype"));
   jb1.setSubject(rs1.getString("subject"));
   jb1.setStudId(rs1.getString("srno"));       
   }
   jb1.setExam(exam);
   String qr1="insert into "+exam+"(sessions,classes,section,examtype,subject,srno,marks,status)values(?,?,?,?,?,?,?,?)";   
   psmt2=con.prepareStatement(qr1);   
   psmt2.setString(1,jb1.getSessions());
   psmt2.setString(2,jb1.getClasses());
   psmt2.setString(3,jb1.getSection());
   psmt2.setString(4,jb1.getExamType());
   psmt2.setString(5,jb1.getSubject());
   psmt2.setString(6,jb1.getStudId());
   psmt2.setString(7,jb.getMarks());
   psmt2.setString(8,"ACTIVE");   
   psmt2.executeUpdate();   
   String qr2="update "+exam+" set status=? where rowid="+jb.getRowid();
   psmt3=con.prepareStatement(qr2); 
   psmt3.setString(1,"INACTIVE");
   psmt3.executeUpdate(); 
   }   
   catch(SQLException se){}
   finally{
    try{
    if(rs1!=null){rs1.close();}     
    if(psmt1!=null){psmt1.close();}  
    if(psmt2!=null){psmt2.close();} 
    if(psmt3!=null){psmt3.close();} 
    if(con!=null){con.close();} 
     }   
    catch(SQLException se){}
    }
  return jb1;  
 } 
  
   public int examAttendData(JavaBeanExam jb){ 
          try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  } 
  int bn=1;        
  ArrayList ar1=(ArrayList)jb.getStudList();
  ArrayList ar2=(ArrayList)jb.getStudAttend();
  String qr1="insert into examattendence(sessions,classes,section,subject,srnum,status,examtype)values(?,?,?,?,?,?,?)";   
  try{ 
  for(int i=0;i<ar1.size();i++){       
   psmt=con.prepareStatement(qr1);   
   psmt.setString(1,jb.getSessions());   
   psmt.setString(2,jb.getClasses());
   psmt.setString(3,jb.getSection());
   psmt.setString(4,jb.getSubject());
   psmt.setString(5,ar1.get(i).toString());  
   psmt.setString(6,ar2.get(i).toString());
   psmt.setString(7,jb.getExamType());
   psmt.executeUpdate();
   }     
   }
    catch(SQLException se){bn=0;}
  finally{
          try
           {
             if(psmt!=null){psmt.close();}           
             if(con!=null){con.close();}
           }catch(SQLException e){}
          }
  
  return bn;    
 }
  
}
