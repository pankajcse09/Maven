package ActionClass;

import java.sql.*;
import java.util.*;
import com.myapp.struts.Dataconnectivity;
import ActionClass.*;

public class LoginDataObject{
    
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
  int count=0;
  Common comLogin = new Common();  
  String usnme=jb.getLoginid();
  String passwd=jb.getPassword();
  String  duname="";
  String  apasswd="";
  String dpasswd ="";
  usnme=usnme.trim();
  passwd = passwd.trim(); 
      
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  
        String qu="select * from loginn";        
        try{
       psmt=con.prepareStatement(qu);     
       rs=psmt.executeQuery();      
              while(rs.next()){  
                                duname=rs.getString("username");
                                duname=duname.trim();
                                apasswd=rs.getString("password");
                                apasswd=apasswd.trim();
                                dpasswd = (String)comLogin.decrypt(apasswd);
                                dpasswd=dpasswd.trim();                                  
                                if(duname.equals(usnme) && dpasswd.equals(passwd)){                                 
                                            count=1;
                                             break;
                                    }                                
                              }   
                        }
     
     catch(SQLException e){}
     }catch(Exception e){count=-1;} 
     finally{ 
                  try{ 
                   if(rs!=null){rs.close(); }
                   if(psmt!=null){psmt.close();}
                   if(con!=null){con.close();}                                     
                    }
                  catch(SQLException e){}                  
             }   
    return count;
    }
 public int authenticateUser(JavaBean1 jb){
  int count=0;
  Common comLogin = new Common();  
  String usnme=jb.getLoginid();
  String passwd=jb.getPassword();
  String  duname="";
  String  apasswd="";
  String dpasswd ="";
  usnme=usnme.trim();
  passwd = passwd.trim(); 
      
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  
        String qu="select * from loginn";        
        try{
       psmt=con.prepareStatement(qu);     
       rs=psmt.executeQuery();      
              while(rs.next()){  
                                duname=rs.getString("username");
                                duname=duname.trim();
                                apasswd=rs.getString("password");
                                apasswd=apasswd.trim();
                                dpasswd = (String)comLogin.decrypt(apasswd);
                                dpasswd=dpasswd.trim();                                  
                                if(duname.equals(usnme) && dpasswd.equals(passwd)){                                 
                                            count=1;
                                             break;
                                    }                    
                              }   
                        }
     
     catch(SQLException e){}
     }catch(Exception e){count=-1;} 
     finally{ 
                  try{ 
                   if(rs!=null){rs.close(); }
                   if(psmt!=null){psmt.close();}
                   if(con!=null){con.close();}                                     
                    }
                  catch(SQLException e){}                  
             }   
    return count;
    }

  
  public int registUserData1(JBeanEmp jb){ 
   try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }  
   Common comLogin = new Common(); 
   int count=0;
   String empid=jb.getEmpId();
   String id=jb.getLoginId();   
   String passwd1=jb.getPassword(); 
   String pass=comLogin.encrypt(passwd1);
   String qr="select count(username) as cnt from loginn where emp_id='"+empid+"' or username='"+id+"'";
   try{
   psmt1=con.prepareStatement(qr);   
   rs1=psmt1.executeQuery();
   rs1.next();
   count=rs1.getInt("cnt");
   }
   catch(SQLException se){}
   finally{
    try{
    if(rs1!=null){rs1.close();}     
    if(psmt1!=null){psmt1.close();}     
     }   
    catch(SQLException se){}
    }     
   String passwd =(String)comLogin.encrypt(passwd1);
   passwd=passwd.trim();  
   String qr1="insert into loginn(emp_id,username,password,secret_question,answer,user_type,role)values(?,?,?,?,?,?,?)"; 
   String qr2="insert into emp_personal_data(emp_id,emp_name,emp_design,emp_dob,emp_gender,emp_mstatus,emp_present,emp_permanent,emp_nationality,emp_fname,emp_occup_fh,emp_pob)values(?,?,?,?,?,?,?,?,?,?,?,?)"; 
   String ss="";
   try{     
   psmt=con.prepareStatement(qr1);  
   psmt2=con.prepareStatement(qr2);
   if(count==0){
   psmt.setString(1,jb.getEmpId());
   psmt.setString(2,jb.getLoginId());
   psmt.setString(3,pass);
   psmt.setString(4,jb.getQuestion());
   psmt.setString(5,jb.getAnswer());
   psmt.setString(6,"e");
   psmt.setString(7,jb.getRole());
   psmt.executeUpdate();   
  
   psmt2.setString(1,jb.getEmpId());
   psmt2.setString(2,jb.getEmpName());
   psmt2.setString(3,jb.getDesignation());
   psmt2.setString(4,jb.getDob());
   psmt2.setString(5,jb.getGender());
   psmt2.setString(6,jb.getMstatus());
   psmt2.setString(7,jb.getPresent());
   psmt2.setString(8,jb.getPermanent());
   psmt2.setString(9,jb.getNationality());
   psmt2.setString(10,jb.getFname());
   psmt2.setString(11,jb.getFoccupation()); 
   psmt2.setString(12,jb.getPob()); 
   psmt2.executeUpdate();  
   }
   }  
   catch(SQLException se){    
   ss=se.getMessage();    
   System.out.println(se.getMessage());   
    } 
      finally{
       try{
         if(psmt!=null){psmt.close();}  
         if(psmt2!=null){psmt2.close();} 
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
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
  public int registUserData3(JBeanEmp jb){ 
   try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }  
    
   int count=0;
   
   String qr4="insert into emp_employer(emp_id,employer_name,employer_desig,emp_from,emp_to)values(?,?,?,?,?)"; 
   String qr5="insert into emp_proficiency(emp_id,language,reading,writing,speaking)values(?,?,?,?,?)"; 
  
   String ss="";
   try{     
   psmt4=con.prepareStatement(qr4);
   psmt5=con.prepareStatement(qr5);

   if(count==0){
  
   psmt4.setString(1,jb.getEmpId());
   psmt4.setString(2,jb.getEmployer1());
   psmt4.setString(3,jb.getEmpdegn1());
   psmt4.setString(4,jb.getPeriodfrm1());
   psmt4.setString(5,jb.getPeriodto1());   
   psmt4.executeUpdate(); 
   
   psmt4.setString(1,jb.getEmpId());
   psmt4.setString(2,jb.getEmployer2());
   psmt4.setString(3,jb.getEmpdegn2());
   psmt4.setString(4,jb.getPeriodfrm2());
   psmt4.setString(5,jb.getPeriodto2());   
   psmt4.executeUpdate();  
   
     psmt4.setString(1,jb.getEmpId());
   psmt4.setString(2,jb.getEmployer3());
   psmt4.setString(3,jb.getEmpdegn3());
   psmt4.setString(4,jb.getPeriodfrm3());
   psmt4.setString(5,jb.getPeriodto3());   
   psmt4.executeUpdate(); 
   
   psmt4.setString(1,jb.getEmpId());
   psmt4.setString(2,jb.getEmployer4());
   psmt4.setString(3,jb.getEmpdegn4());
   psmt4.setString(4,jb.getPeriodfrm4());
   psmt4.setString(5,jb.getPeriodto4());   
   psmt4.executeUpdate();    
        
   psmt5.setString(1,jb.getEmpId());
   psmt5.setString(2,jb.getEng());
   psmt5.setString(3,jb.getEngr());
   psmt5.setString(4,jb.getEngw());
   psmt5.setString(5,jb.getEngs());  
   psmt5.executeUpdate();  
   
   psmt5.setString(1,jb.getEmpId());
   psmt5.setString(2,jb.getHindi());
   psmt5.setString(3,jb.getHindir());
   psmt5.setString(4,jb.getHindiw());
   psmt5.setString(5,jb.getHindis());  
   psmt5.executeUpdate(); 
   
   psmt5.setString(1,jb.getEmpId());
   psmt5.setString(2,jb.getOtherlan());
   psmt5.setString(3,jb.getOtherlanr());
   psmt5.setString(4,jb.getOtherlanw());
   psmt5.setString(5,jb.getOtherlans());  
   psmt5.executeUpdate();   
   
   }
   }  
   catch(SQLException se){    
   ss=se.getMessage();    
   System.out.println(se.getMessage());   
    } 
      finally{
       try{
         if(psmt4!=null){psmt4.close();} 
         if(psmt5!=null){psmt5.close();} 
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }   
  return count;  
 }
  public int registUserData4(JBeanEmp jb){ 
   try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }  
    
   int count=0;
    
   String qr6="insert into emp_extra_curricular(emp_id,activity,represent_level,activity_year,position_stood)values(?,?,?,?,?)"; 
   String qr7="insert into emp_references(emp_id,reference1,reference2,reference3)values(?,?,?,?)"; 
   String ss="";
   try{     
   psmt6=con.prepareStatement(qr6);
   psmt7=con.prepareStatement(qr7);
   if(count==0){
     
   psmt6.setString(1,jb.getEmpId());
   psmt6.setString(2,jb.getGames());
   psmt6.setString(3,jb.getGames1());
   psmt6.setString(4,jb.getGames2());
   psmt6.setString(5,jb.getGames3());  
   psmt6.executeUpdate();  
   
   psmt6.setString(1,jb.getEmpId());
   psmt6.setString(2,jb.getLc());
   psmt6.setString(3,jb.getLc1());
   psmt6.setString(4,jb.getLc2());
   psmt6.setString(5,jb.getLc3());  
   psmt6.executeUpdate();  

   psmt7.setString(1,jb.getEmpId());
   psmt7.setString(2,jb.getRefer1());
   psmt7.setString(3,jb.getRefer2());
   psmt7.setString(4,jb.getRefer3());
   psmt7.executeUpdate(); 
   }
   }  
   catch(SQLException se){    
   ss=se.getMessage();    
   System.out.println(se.getMessage());   
    } 
      finally{
       try{
         if(psmt6!=null){psmt6.close();}  
         if(psmt7!=null){psmt7.close();}  
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }   
  return count;  
 } 
    
  public boolean editUserData(JavaBean1 jb){ 
   try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }    
   String id=jb.getLoginid();   
   String passwd1=jb.getPassword();  
   Common comLogin = new Common();   
   String passwd =(String)comLogin.encrypt(passwd1);
   passwd=passwd.trim();      
   String qr1="update registrationtable set name=?,password=?,secretques=?,secretans=? where loginid='"+id+"'";    
  try{     
   psmt=con.prepareStatement(qr1);     
   psmt.setString(1,jb.getName());  
   psmt.setString(2,passwd);
   psmt.setString(3,jb.getSecretques());
   psmt.setString(4,jb.getSecretans());
   psmt.executeUpdate();  
   }  
   catch(SQLException se){
   System.out.println(se.getMessage());   
    } 
      finally{
       try{
         if(psmt!=null){psmt.close();}  
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }   
  return true;  
 }
    
  public ArrayList loginData(){  
     try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }     
   ArrayList ar=new ArrayList();
   String qr1="select id,name,loginid from registrationtable";   
   try{
        psmt=con.prepareStatement(qr1);  
        rs=psmt.executeQuery();
        while(rs.next()){
        JavaBean1 jb=new JavaBean1();     
        jb.setId(rs.getString("id"));
        jb.setName(rs.getString("name"));
        jb.setLoginid(rs.getString("loginid"));
        ar.add(jb);
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
  
  public boolean delLoginData(String id){  
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }     
  String qr1="delete from registrationtable where id="+id;   
   try{
        psmt=con.prepareStatement(qr1);  
        psmt.executeUpdate();       
      }
   catch(SQLException se){}
   finally{
      try{        
         if(psmt!=null){psmt.close();}  
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}      
   }
   return true;    
   } 
  
   public int checkLoginn(String eid){
    Connection con=null;
PreparedStatement psmt=null;
ResultSet rs=null;

int count=0;
try      
{  
 Dataconnectivity dc=new  Dataconnectivity();
 con=(Connection)dc.Dataconnect();
}
catch(Exception e){}
try{
 String qr="select count(emp_id) as cnt from loginn where emp_id='"+eid+"'";
 psmt=con.prepareStatement(qr);
 rs=psmt.executeQuery();
 rs.next();
 count=rs.getInt("cnt"); 
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

public JBeanEmp eDetail7Data(String eid){   
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }  
  JBeanEmp jb=new JBeanEmp(); 
  Common comLogin = new Common();   
  String qr1="select * from loginn where emp_id='"+eid+"'";   
   try{
        psmt=con.prepareStatement(qr1);  
        rs1=psmt.executeQuery();
        while(rs1.next()){             
        jb.setEmpId(rs1.getString("emp_id"));
        jb.setLoginId(rs1.getString("username"));
        jb.setPassword(comLogin.decrypt(rs1.getString("password")));
        jb.setQuestion(rs1.getString("secret_question"));
        jb.setAnswer(rs1.getString("answer"));
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
   return jb;    
   } 

public JBeanEmp eDetail1Data(String eid){   
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }  
  JBeanEmp jb=new JBeanEmp(); 
  String qr1="select * from emp_personal_data where emp_id='"+eid+"'";   
   try{
        psmt=con.prepareStatement(qr1);  
        rs1=psmt.executeQuery();
        while(rs1.next()){             
        jb.setEmpId(rs1.getString("emp_id"));
        jb.setEmpName(rs1.getString("emp_name"));
        jb.setGender(rs1.getString("emp_gender"));
        jb.setDesignation(rs1.getString("emp_design"));
        jb.setDob(rs1.getString("emp_dob"));
        jb.setPob(rs1.getString("emp_pob"));
        jb.setPresent(rs1.getString("emp_present"));
        jb.setPermanent(rs1.getString("emp_permanent"));
        jb.setNationality(rs1.getString("emp_nationality"));
        jb.setFname(rs1.getString("emp_fname"));
        jb.setFoccupation(rs1.getString("emp_occup_fh"));
        jb.setMstatus(rs1.getString("emp_mstatus"));       
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
   return jb;    
   } 

public JBeanEmp eDetail2Data(String eid){   
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }  
  String ss="";
  JBeanEmp jb=new JBeanEmp(); 
  ArrayList exmpass=new ArrayList();
  HashMap board=new HashMap();
  HashMap subject=new HashMap();
  HashMap year=new HashMap();
  HashMap percent=new HashMap();
  HashMap distinct=new HashMap();
  jb.setEmpId(eid);
  String qr1="select * from emp_education_data where emp_id='"+eid+"'";   
   try{
        psmt=con.prepareStatement(qr1);  
        rs=psmt.executeQuery();        
        while(rs.next()){          
        exmpass.add(rs.getString("emp_exam_passed"));
        board.put(rs.getString("emp_exam_passed"),rs.getString("emp_board_univer"));
        subject.put(rs.getString("emp_exam_passed"),rs.getString("emp_subjects"));
        year.put(rs.getString("emp_exam_passed"),rs.getString("emp_year"));
        percent.put(rs.getString("emp_exam_passed"),rs.getString("emp_percent_mark"));
        distinct.put(rs.getString("emp_exam_passed"),rs.getString("emp_distinction"));       
        }  
       jb.setExamPassed(exmpass);
       jb.setBoardUnv(board);
       jb.setSubOffered(subject);
       jb.setExamYear(year);
       jb.setExamPercent(percent);
       jb.setExamRemark(distinct);
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

public JBeanEmp eDetail3Data(String eid){   
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }  
  String ss="";
  JBeanEmp jb=new JBeanEmp(); 
  ArrayList rid=new ArrayList();
  HashMap empnam=new HashMap();
  HashMap empdesig=new HashMap();
  HashMap empfrom=new HashMap();
  HashMap empto=new HashMap();
  jb.setEmpId(eid);
  String qr1="select * from emp_employer where emp_id='"+eid+"'";   
   try{
        psmt=con.prepareStatement(qr1);  
        rs=psmt.executeQuery();        
        while(rs.next()){           
        rid.add(rs.getString("rowid"));
        empnam.put(rs.getString("rowid"),rs.getString("employer_name"));
        empdesig.put(rs.getString("rowid"),rs.getString("employer_desig"));
        empfrom.put(rs.getString("rowid"),rs.getString("emp_from"));
        empto.put(rs.getString("rowid"),rs.getString("emp_to"));
        }  
       jb.setRowid(rid); 
       jb.setEmployer(empnam);
       jb.setEmployerDesg(empdesig);
       jb.setEmployerFrom(empfrom);
       jb.setEmployerTo(empto);
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

public JBeanEmp eDetail4Data(String eid){   
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }  
  String ss="";
  JBeanEmp jb=new JBeanEmp(); 
  ArrayList lang=new ArrayList();
  HashMap read=new HashMap();
  HashMap write=new HashMap();
  HashMap speak=new HashMap();
  jb.setEmpId(eid);
  String qr1="select * from emp_proficiency where emp_id='"+eid+"'";   
   try{
        psmt=con.prepareStatement(qr1);  
        rs=psmt.executeQuery();        
        while(rs.next()){          
        lang.add(rs.getString("language"));
        read.put(rs.getString("language"),rs.getString("reading"));
        write.put(rs.getString("language"),rs.getString("writing"));
        speak.put(rs.getString("language"),rs.getString("speaking"));
        }  
       jb.setLanguages(lang);
       jb.setRead(read);
       jb.setWrite(write);
       jb.setSpeak(speak);
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

public JBeanEmp eDetail5Data(String eid){   
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }  
  String ss="";
  JBeanEmp jb=new JBeanEmp(); 
  ArrayList activity=new ArrayList();
  HashMap replevel=new HashMap();
  HashMap actyear=new HashMap();
  HashMap pstood=new HashMap();
  jb.setEmpId(eid);
  String qr1="select * from emp_extra_curricular where emp_id='"+eid+"'";   
   try{
        psmt=con.prepareStatement(qr1);  
        rs=psmt.executeQuery();        
        while(rs.next()){          
        activity.add(rs.getString("activity"));
        replevel.put(rs.getString("activity"),rs.getString("represent_level"));
        actyear.put(rs.getString("activity"),rs.getString("activity_year"));
        pstood.put(rs.getString("activity"),rs.getString("position_stood"));
        }  
       jb.setActivity(activity);
       jb.setRepresentLevel(replevel);
       jb.setActivityYear(actyear);
       jb.setPositionStood(pstood);
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

public JBeanEmp eDetail6Data(String eid){   
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }  
   String ss="";
   JBeanEmp jb=new JBeanEmp(); 
   String ref1="";
   String ref2="";
   String ref3="";
  jb.setEmpId(eid);
  String qr1="select * from emp_references where emp_id='"+eid+"'";   
   try{
        psmt=con.prepareStatement(qr1);  
        rs=psmt.executeQuery();        
        if(rs.next()){          
        jb.setRefer1(rs.getString("reference1"));
        jb.setRefer2(rs.getString("reference2"));
        jb.setRefer3(rs.getString("reference3"));      
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

public int updateEmpData7(JBeanEmp jb){ 
  int bn=0;  
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }  
    Common comLogin = new Common(); 
   int count=0;
   String empid=jb.getEmpId();
   String id=jb.getLoginId();   
   String passwd1=jb.getPassword(); 
   String pass=comLogin.encrypt(passwd1);
   String qr1="update loginn set username=?,password=?,secret_question=?,answer=? where emp_id='"+jb.getEmpId()+"'";   
   try{
        psmt=con.prepareStatement(qr1);              
        psmt.setString(1,jb.getLoginId());
        psmt.setString(2,pass);
        psmt.setString(3,jb.getQuestion());
        psmt.setString(4,jb.getAnswer());
        psmt.executeUpdate();     
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
   bn=1;
   return bn;    
   } 

public int updateEmpData1(JBeanEmp jb){ 
  int bn=0;  
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }  
  String qr1="update emp_personal_data set emp_name=?,emp_design=?,emp_dob=?,emp_gender=?,emp_present=?,emp_permanent=?,emp_nationality=?,emp_fname=?,emp_occup_fh=?,emp_mstatus=?,emp_pob=? where emp_id='"+jb.getEmpId()+"'";   
   try{
   psmt2=con.prepareStatement(qr1);              
   psmt2.setString(1,jb.getEmpName());
   psmt2.setString(2,jb.getDesignation());
   psmt2.setString(3,jb.getDob());
   psmt2.setString(4,jb.getGender());   
   psmt2.setString(5,jb.getPresent());
   psmt2.setString(6,jb.getPermanent());
   psmt2.setString(7,jb.getNationality());
   psmt2.setString(8,jb.getFname());
   psmt2.setString(9,jb.getFoccupation()); 
   psmt2.setString(10,jb.getMstatus());        
   psmt2.setString(11,jb.getPob()); 
   psmt2.executeUpdate();  
   }
   catch(SQLException se){}
   finally{
      try{   
         if(psmt!=null){psmt.close();}  
         if(con!=null){con.close();}  
         }   
       catch(SQLException se){}      
     }
   bn=1;
   return bn;    
   } 

public int updateEmpData2(JBeanEmp jb){ 
  int bn=0; 
  ArrayList ar1=new ArrayList(jb.getExamPassed());
  HashMap hm1=new HashMap(jb.getBoardUnv());
  HashMap hm2=new HashMap(jb.getSubOffered());
  HashMap hm3=new HashMap(jb.getExamYear());
  HashMap hm4=new HashMap(jb.getExamPercent());
  HashMap hm5=new HashMap(jb.getExamRemark());
  
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  } 
  String qr1="";
   try{
   for(int i=0;i<ar1.size();i++){    
   qr1="update emp_education_data set emp_board_univer=?,emp_subjects=?,emp_year=?,emp_percent_mark=?,emp_distinction=? where emp_id='"+jb.getEmpId()+"' and emp_exam_passed='"+ar1.get(i)+"'";       
   psmt=con.prepareStatement(qr1);              
   psmt.setString(1,hm1.get(ar1.get(i)).toString());
   psmt.setString(2,hm2.get(ar1.get(i)).toString());
   psmt.setString(3,hm3.get(ar1.get(i)).toString());
   psmt.setString(4,hm4.get(ar1.get(i)).toString());   
   psmt.setString(5,hm5.get(ar1.get(i)).toString());
   psmt.executeUpdate(); 
   }
   }
   catch(SQLException se){}
   finally{
      try{   
         if(psmt!=null){psmt.close();}  
         if(con!=null){con.close();}  
         }   
       catch(SQLException se){}      
     }
   bn=1;
   return bn;    
   } 

public int updateEmpData3(JBeanEmp jb){ 
  int bn=0; 
  ArrayList ar1=new ArrayList(jb.getRowid());
  HashMap hm1=new HashMap(jb.getEmployer());
  HashMap hm2=new HashMap(jb.getEmployerDesg());
  HashMap hm3=new HashMap(jb.getEmployerFrom());
  HashMap hm4=new HashMap(jb.getEmployerTo());
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  } 
  String qr1="";
   try{
   for(int i=0;i<ar1.size();i++){    
   qr1="update emp_employer set employer_name=?,employer_desig=?,emp_from=?,emp_to=? where emp_id='"+jb.getEmpId()+"' and rowid='"+ar1.get(i)+"'";       
   psmt=con.prepareStatement(qr1);
   System.out.println(psmt);
   psmt.setString(1,hm1.get(ar1.get(i)).toString());
   psmt.setString(2,hm2.get(ar1.get(i)).toString());
   psmt.setString(3,hm3.get(ar1.get(i)).toString());
   psmt.setString(4,hm4.get(ar1.get(i)).toString());
   psmt.executeUpdate(); 
   }
   }
   catch(SQLException se){}
   finally{
      try{   
         if(psmt!=null){psmt.close();}  
         if(con!=null){con.close();}  
         }   
       catch(SQLException se){}      
     }
   bn=1;
   return bn;    
   } 

public int updateEmpData4(JBeanEmp jb){ 
  int bn=0; 
  ArrayList ar1=new ArrayList(jb.getLanguages());
  HashMap hm1=new HashMap(jb.getRead());
  HashMap hm2=new HashMap(jb.getWrite());
  HashMap hm3=new HashMap(jb.getSpeak());
 
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  } 
  String qr1="";
   try{
   for(int i=0;i<ar1.size();i++){    
   qr1="update emp_proficiency set reading=?,writing=?,speaking=? where emp_id='"+jb.getEmpId()+"' and language='"+ar1.get(i)+"'";       
   psmt=con.prepareStatement(qr1);              
   psmt.setString(1,hm1.get(ar1.get(i)).toString());
   psmt.setString(2,hm2.get(ar1.get(i)).toString());
   psmt.setString(3,hm3.get(ar1.get(i)).toString());
   psmt.executeUpdate(); 
   }
   }
   catch(SQLException se){}
   finally{
      try{   
         if(psmt!=null){psmt.close();}  
         if(con!=null){con.close();}  
         }   
       catch(SQLException se){}      
     }
   bn=1;
   return bn;    
   } 

public int updateEmpData5(JBeanEmp jb){ 
  int bn=0; 
  ArrayList ar1=new ArrayList(jb.getActivity());
  HashMap hm1=new HashMap(jb.getRepresentLevel());
  HashMap hm2=new HashMap(jb.getActivityYear());
  HashMap hm3=new HashMap(jb.getPositionStood());
 
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  } 
  String qr1="";
   try{
   for(int i=0;i<ar1.size();i++){    
   qr1="update emp_extra_curricular set represent_level=?,activity_year=?,position_stood=? where emp_id='"+jb.getEmpId()+"' and activity='"+ar1.get(i)+"'";       
   psmt=con.prepareStatement(qr1);              
   psmt.setString(1,hm1.get(ar1.get(i)).toString());
   psmt.setString(2,hm2.get(ar1.get(i)).toString());
   psmt.setString(3,hm3.get(ar1.get(i)).toString());
   psmt.executeUpdate(); 
   }
   }
   catch(SQLException se){}
   finally{
      try{   
         if(psmt!=null){psmt.close();}  
         if(con!=null){con.close();}  
         }   
       catch(SQLException se){}      
     }
   bn=1;
   return bn;    
   } 

public int updateEmpData6(JBeanEmp jb){ 
  int bn=0; 
  ArrayList ar1=new ArrayList(jb.getLanguages());
 
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  } 
  String qr1="";
   try{     
   qr1="update emp_references set reference1=?,reference2=?,reference3=? where emp_id='"+jb.getEmpId()+"'";       
   psmt=con.prepareStatement(qr1);              
   psmt.setString(1,jb.getRefer1());
   psmt.setString(2,jb.getRefer2());
   psmt.setString(3,jb.getRefer3());
   psmt.executeUpdate();  
   }
   catch(SQLException se){}
   finally{
      try{   
         if(psmt!=null){psmt.close();}  
         if(con!=null){con.close();}  
         }   
       catch(SQLException se){}      
     }
   bn=1;
   return bn;    
   } 

public void updateUserPass(String loginid,String newpass){ 
  Common comLogin = new Common();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){System.out.println(e.getMessage());} 
   try{     
   String qr1="update loginn set PASSWORD=?,adminregis=? where USERNAME='"+loginid+"'";       
   psmt=con.prepareStatement(qr1);              
   psmt.setString(1, comLogin.encrypt(newpass));
   psmt.setShort(2,Short.valueOf("2"));
   psmt.executeUpdate();  
   }
   catch(SQLException se){}
   finally{
      try{   
         if(psmt!=null){psmt.close();}  
         if(con!=null){con.close();}  
         }   
       catch(SQLException se){}      
     }    
   } 

public String userRole(JavaBean1 jb){
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){} 
  int count=0;
  String role="";
  String usnme=jb.getLoginid();
  
        String qu="select role from loginn where username='"+usnme+"'";        
        try{
       psmt=con.prepareStatement(qu);     
       rs=psmt.executeQuery();      
              while(rs.next()){  
                            role=rs.getString("role");                              
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
    return role;
    }

//public static void main(String a[]){
//JBeanEmp jb=new JBeanEmp();
//LoginDataObject lob=new LoginDataObject();
//jb=lob.updateEmpData3("E2");
//System.out.println(jb);
//System.out.println(jb.getEmployer());
//}


public  ArrayList select_user()throws Exception 
   {
        Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
  JavaBean1 getdataus = null;
    ArrayList cust_list=new ArrayList();
    String pass="";
    Common cmn=new Common();
   //Common_data da=null;
    
    
    
       try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();

      String st="select * from loginn order by rowid desc";
       pstmt=conn.prepareStatement(st);
       rs=pstmt.executeQuery();
        
      //System.out.println(rs);
 JavaBean1 rb= new JavaBean1();
    if(rs.next())
       {
         
        rb.setId(new Integer(rs.getInt("rowid")).toString());
        rb.setLoginid(rs.getString("username"));
        rb.setName(rs.getString("name"));
        pass=cmn.decrypt(rs.getString("password"));
        rb.setPassword(pass);
        rb.setSecretans(rs.getString("SECRET_QUESTION"));
        rb.setSecretques(rs.getString("ANSWER"));
        rb.setUserType(rs.getString("role"));
        rb.setHomeaddress(rs.getString("homeaddress"));
        rb.setHomeaddress2(rs.getString("homeaddress2"));
        rb.setCity(rs.getString("city"));
        rb.setState(rs.getString("state"));
        rb.setPincode(rs.getString("pincode"));
        rb.setCountry(rs.getString("country"));
        rb.setMobileno(rs.getString("mobileno"));
        rb.setTelno(rs.getString("telno"));
        rb.setStatus(rs.getString("status"));
         
      cust_list.add(rb);
         
          
       }
          }catch(Exception e){ System.out.println("kk: "+e.getMessage());}
     return cust_list;
   } 

public int registUserData_Emp(JavaBean1 jb){ 
   try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }  
   int count=0;
   String id=jb.getLoginid();   
   String passwd1=jb.getPassword();  
   String qr="select count(username) as cnt from loginn where username='"+id+"'";
   try{
   psmt1=con.prepareStatement(qr);   
   rs1=psmt1.executeQuery();
   if(rs1.next()){
   count=rs1.getInt("cnt");
   }
   }
   catch(SQLException se){}
   finally{
    try{
    if(rs1!=null){rs1.close();}     
    if(psmt1!=null){psmt1.close();}     
     }   
    catch(SQLException se){}
    }
   if(count==0){
   Common comLogin = new Common();   
   String passwd =(String)comLogin.encrypt(passwd1);
   passwd=passwd.trim();      
   String qr1="insert into loginn(name,username,password,SECRET_QUESTION," +
           "ANSWER,status,role,homeaddress,homeaddress2,city,state,pincode,country,telno,mobileno,USER_TYPE,loginfor,loginfor_name" +
           ")values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";    
  try{     
   psmt=con.prepareStatement(qr1);  
   
   psmt.setString(1,jb.getName());
   psmt.setString(2,jb.getLoginid());
   psmt.setString(3,passwd);
   psmt.setString(4,jb.getSecretques());
   psmt.setString(5,jb.getSecretans());
   psmt.setString(6,"active");
   psmt.setString(7,jb.getUserType());
   psmt.setString(8,jb.getHomeaddress());
   psmt.setString(9,jb.getHomeaddress2());
   psmt.setString(10,jb.getCity());
   psmt.setString(11,jb.getState());
   psmt.setString(12,jb.getPincode());
   psmt.setString(13,jb.getCountry());
   psmt.setString(14,jb.getTelno());
   psmt.setString(15,jb.getMobileno());      
   psmt.setString(16,"e");
   psmt.setString(17, jb.getLoginFor());
   psmt.setString(18, jb.getLoginForName());
   psmt.executeUpdate();
   }
   catch(SQLException se){
       count=-1;
   System.out.println(se.getMessage());   
    } 
      finally{
       try{
         if(psmt!=null){psmt.close();}  
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }   
}
  return count;  
 }

public ArrayList allRegistUserIdData_Emp(){ 
 ArrayList ar=new ArrayList(); 
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }     
  String qr1="select distinct username from loginn";   
   try{
        psmt=con.prepareStatement(qr1);  
        rs1=psmt.executeQuery();
        while(rs1.next()){
        JavaBean1 jb=new JavaBean1();  
//        jb.setEmpId(rs1.getString("emp_id"));
        jb.setLoginid(rs1.getString("username"));
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

public JavaBean1 eDetailFromUsername(String username){   
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }  
  JavaBean1 jb=new JavaBean1(); 
  Common comLogin = new Common();   
  String qr1="select * from loginn where username='"+username+"'";   
   try{
        psmt=con.prepareStatement(qr1);  
        rs1=psmt.executeQuery();
        while(rs1.next()){             
            jb.setRid(rs1.getLong("rowid"));
            jb.setLoginid(rs1.getString("username"));
            jb.setPassword(comLogin.decrypt(rs1.getString("password")));
            jb.setSecretques(rs1.getString("secret_question"));
            jb.setSecretans(rs1.getString("answer"));
            jb.setUserType(rs1.getString("role"));
            jb.setName(rs1.getString("name"));
            jb.setHomeaddress(rs1.getString("homeaddress"));
            jb.setHomeaddress2(rs1.getString("homeaddress2"));
            jb.setCity(rs1.getString("city"));
            jb.setState(rs1.getString("state"));
            jb.setPincode(rs1.getString("pincode"));
            jb.setCountry(rs1.getString("country"));
            jb.setTelno(rs1.getString("telno"));
            jb.setMobileno(rs1.getString("mobileno"));
            jb.setAdminregis(rs1.getInt("adminregis"));
            jb.setLoginFor(rs1.getString("loginfor"));
            jb.setLoginForName(rs1.getString("loginfor_name"));
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
   return jb;    
   } 

public int updateEmpData(JavaBean1 jb){ 
  int bn=0;  
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }  
    Common comLogin = new Common(); 
   int count=0;
   
   String id=jb.getLoginid();   
   String passwd1=jb.getPassword(); 
   String pass=comLogin.encrypt(passwd1);
   String qr1="update loginn set username=?,password=?,secret_question=?,answer=?,name=?,homeaddress=?,homeaddress2=?,city=?,state=?,pincode=?,country=?,"
           + "telno=?,mobileno=?,role=? where rowid="+jb.getRid();   
   try{
        psmt=con.prepareStatement(qr1);              
        psmt.setString(1,jb.getLoginid());
        psmt.setString(2,pass);
        psmt.setString(3,jb.getSecretques());
        psmt.setString(4,jb.getSecretans());
        psmt.setString(5, jb.getName());
        psmt.setString(6,jb.getHomeaddress());
   psmt.setString(7,jb.getHomeaddress2());
   psmt.setString(8,jb.getCity());
   psmt.setString(9,jb.getState());
   psmt.setString(10,jb.getPincode());
   psmt.setString(11,jb.getCountry());
   psmt.setString(12,jb.getTelno());
   psmt.setString(13,jb.getMobileno());  
   psmt.setString(14,jb.getUserType());  
        bn=psmt.executeUpdate();     
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
   //bn=1;
   return bn;    
   } 

    public int updateEmpPro(JavaBean1 jb){ 
  int bn=0;  
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }  
    Common comLogin = new Common(); 
   int count=0;
   
   String id=jb.getLoginid();   

   String qr1="update loginn set username=?,secret_question=?,answer=?,name=?,homeaddress=?,homeaddress2=?,city=?,state=?,pincode=?,country=?,telno=?,mobileno=? where rowid='"+jb.getRid()+"'";   
   try{
        psmt=con.prepareStatement(qr1);              
        psmt.setString(1,jb.getLoginid());
        psmt.setString(2,jb.getSecretques());
        psmt.setString(3,jb.getSecretans());
        psmt.setString(4, jb.getName());
        psmt.setString(5,jb.getHomeaddress());
        psmt.setString(6,jb.getHomeaddress2());
        psmt.setString(7,jb.getCity());
        psmt.setString(8,jb.getState());
        psmt.setString(9,jb.getPincode());
        psmt.setString(10,jb.getCountry());
        psmt.setString(11,jb.getTelno());
        psmt.setString(12,jb.getMobileno());  
        bn=psmt.executeUpdate();     
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
   //bn=1;
   return bn;    
   } 

 public String retHostelNameForHostelLogin(String hostel_code){
     String hname="";
     try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }  
     String qr1="select hostel_name from hostel where code='"+hostel_code+"'";   
   try{
        psmt=con.prepareStatement(qr1);  
        rs1=psmt.executeQuery();
        if(rs1.next()){             
            hname=rs1.getString("hostel_name");
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
     return hname;
 }   


}
