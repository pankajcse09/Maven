package ActionClass;

import java.util.*;
import Beans.JavaBean;
import java.sql.*;
import EO.*;
import java.text.*;
import java.io.*;
import Beans.*;

public class MyMeth {

PreparedStatement psmt=null;
PreparedStatement psmt1=null;
PreparedStatement psmt2=null;
PreparedStatement psmt3=null;
PreparedStatement psmt4=null;
PreparedStatement psmt5=null;
ResultSet rs=null;
ResultSet rs1=null;    
ResultSet rs2=null;
ResultSet rs3=null;
ResultSet rs4=null;
ResultSet rs5=null;

public double retTotalFee(SchoolEO seo,SchoolEO seo2){
     double feetot=0.0;
     int count=0;
     String feetyp="";  
     Connection con=null;
     try{
     Dataconnectivity dc=new Dataconnectivity();
     con=(Connection)dc.Dataconnect();
     }catch(Exception e){}
     try{
      String qr1="select fee_total from sub_feedata where session='"+seo.getSession()+"' and regist_no='"+seo2.getSrnum()+"'";   
      psmt=con.prepareStatement(qr1);
      rs=psmt.executeQuery();
      if(rs.next()){         
      feetot=rs.getDouble("fee_total"); 
      } 
      }catch(SQLException se){}     
     return feetot;
}

public SchoolEO registStudList(SchoolEO seo2){
 Connection con=null;
 try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
 ArrayList ar=new ArrayList();
 try{
 String qr1="select * from studentregis where session='"+seo2.getSession()+"'";
 psmt1=con.prepareStatement(qr1);
 rs1=psmt1.executeQuery();
 while(rs1.next()){
 SchoolEO seo=new SchoolEO();   
 seo.setSession(rs.getString("session"));
 seo.setRegistNo(rs.getString("srnum"));
 seo.setSname(rs.getString("sname"));
 seo.setDob(rs.getString("dob"));
 seo.setGender(rs.getString("gender"));
 seo.setNationality(rs.getString("nationality"));
 seo.setFname(rs.getString("fname"));
 seo.setMname(rs.getString("mname"));
 seo.setAddress(rs.getString("paddress"));
 seo.setPhone(rs.getString("pphone"));
 seo.setMobile(rs.getString("pmobile"));
 seo.setSeekadd(rs.getString("seekadd"));
 seo.setCategory(rs.getString("category"));
 seo.setYearRegist(rs.getString("year_regist"));
 seo.setClassRegist(rs.getString("class_regist"));
 seo.setStandard(rs.getString("standard"));
 seo.setEnrolNo(rs.getString("enroll_stud"));
 seo.setAdminType(rs.getString("admin_type"));
 seo.setHighSchool(rs.getDouble("highper"));
 seo.setHighMm(rs.getDouble("high_max_marks"));
 seo.setHighObt(rs.getDouble("high_obt_marks"));
 seo.setIntermediate(rs.getDouble("interper"));
 seo.setInterMm(rs.getDouble("inter_max_marks"));
 seo.setInterObt(rs.getDouble("inter_obt_marks")); 
 seo.setHighBoard(rs.getString("high_board"));
 seo.setInterBoard(rs.getString("inter_board"));
 seo.setDomicile(rs.getString("domicile"));
 ar.add(seo);
 } 
 }catch(Exception se){}
 seo2.setDataArray(ar);
 return seo2;
}

public void retrivePic(SchoolEO seo,String path){ 
 Connection con=null;
 try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}    
int returnValue = 0;
InputStream in = null;
OutputStream os = null;
Blob blob = null; 
 try{
 String qry= "select pic from studentregis where srnum='"+seo.getRegistNo()+"' and session='"+seo.getSession()+"'";        
//cn.setAutoCommit(false);
psmt=con.prepareStatement(qry);
rs=psmt.executeQuery();
int i=1;
if(rs.next()){
String len1 = rs.getString("pic");
int len = len1.length();
byte b[] = new byte[len];
in = rs.getBinaryStream("pic");
int index = in.read(b, 0, len);
OutputStream outImej = new FileOutputStream(path);       
while (index != -1){
outImej.write(b, 0, index);
index = in.read(b, 0, len);
}
outImej.flush();
outImej.close();
i++;
}else{
returnValue = 1;
}  
}catch(Exception e){}
return ;   
}

public ArrayList subList(SchoolEO seo){ 
       Connection con=null;
       ArrayList ar=new ArrayList();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}
       String type="";
       String qr1="select subject from class_sub where class like '"+seo.getSeekadd()+"'";
     try{
      psmt=con.prepareStatement(qr1);
      rs=psmt.executeQuery();
      while(rs.next()){
      ar.add(rs.getString("subject"));
      }              
     }
     catch(SQLException se){ }  
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

public int addSubData(SchoolEO seo){ 
       Connection con=null;
       ArrayList ar=(ArrayList)seo.getDataArray();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}
       int count=0;
       String type="";
       String qr1="select count(*) as cnt from class_sub where class=? and subject=?";
       String qr2="insert into class_sub(class,subject,practical)values(?,?,?)"; 
     try{
      psmt=con.prepareStatement(qr1);
      for(int i=0;i<ar.size();i++){
      psmt.setString(1,ar.get(i).toString());
      psmt.setString(2,seo.getSubject());
      rs=psmt.executeQuery();
      rs.next();
      count=rs.getInt("cnt");       
      if(count==0){
      psmt2=con.prepareStatement(qr2);
      psmt2.setString(1,ar.get(i).toString());
      psmt2.setString(2,seo.getSubject());
      psmt2.setString(3,seo.getPractical());
      psmt2.executeUpdate();
      }
      }
      }
      catch(SQLException se){}  
        finally{
       try{
         if(rs!=null){rs.close();}   
         if(psmt!=null){psmt.close();} 
         if(psmt2!=null){psmt2.close();} 
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      } 
     return count;   
}


public int addSub_Semester(SchoolEO seo)throws SQLException{ 
       Connection con=null;
       ArrayList ar=(ArrayList)seo.getDataArray();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}
       int count=0;
       String type="";
       String qr1="select count(*) as cnt from semester_sub where sub_code=?";
       String qr2="insert into semester_sub(degree,branch,semester,sub_code,sub_name,prac)values(?,?,?,?,?,?)"; 
     try{
      psmt=con.prepareStatement(qr1);
      
      
      psmt.setString(1,seo.getSub_code());
      rs=psmt.executeQuery();
      rs.next();
      count=rs.getInt("cnt");       
      if(count==0){
      psmt2=con.prepareStatement(qr2);
      psmt2.setString(1,seo.getDegree());
      psmt2.setString(2,seo.getBranch());
      psmt2.setString(3,seo.getSemester());
      psmt2.setString(4,seo.getSub_code());
      psmt2.setString(5,seo.getSub_name());
       psmt2.setString(6,seo.getPrac());
     
      
      psmt2.executeUpdate();
      }
      
      }
      catch(SQLException se){}  
        finally{
       try{
         if(rs!=null){rs.close();}   
         if(psmt!=null){psmt.close();} 
         if(psmt2!=null){psmt2.close();} 
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      } 
     return count;   
}

public SchoolEO retEnrolledData(SchoolEO seo){ 
       Connection con=null;
       ArrayList ar=new ArrayList();
         ArrayList sub=new ArrayList();
       HashMap hm=new HashMap();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}
       
           String qr7="select subject from stud_subject where session='"+seo.getSession()+"' and admin_no='"+seo.getRegistNo()+"'";
              try{
      psmt5=con.prepareStatement(qr7);
      rs5=psmt5.executeQuery(); 
      while(rs5.next()){
     sub.add(rs5.getString("subject"));    
      }
      seo.setSub(sub);
              }
       catch(SQLException se){
    
     }
       int count=0;
       String type="";
       String qr1="select sf.classes as cls,sf.type as typ,sf.sname as snm,sf.fee_receipt as fee_receipt,sr.fname as fnm,sr.dob as dob,sr.pmobile as pmobile from sub_feedata sf join studentregis sr on sf.regist_no=sr.srnum where sf.session='"+seo.getSession()+"' and sf.regist_no='"+seo.getRegistNo()+"'";
     try{
      psmt=con.prepareStatement(qr1);
      rs=psmt.executeQuery();
      if(rs.next()){
      //seo.setEnrolNo(rs.getString("en"));
      seo.setClasses(rs.getString("cls"));
      seo.setType(rs.getString("typ"));
      seo.setSname(rs.getString("snm"));
      seo.setFname(rs.getString("fnm"));
      seo.setDob(rs.getString("dob"));   
      seo.setMobile(rs.getString("pmobile"));
      seo.setFeeReceipt(rs.getLong("fee_receipt"));
      }else{
      String qr2="select sf.classes as cls,sf.type as typ,sf.sname as snm,sf.fee_receipt as fee_receipt,sr.fname as fnm,sr.dob as dob,sr.pmobile as pmobile from sub_feedata sf join oldregis sr on sf.regist_no=sr.srnum where sf.session='"+seo.getSession()+"' and sf.regist_no='"+seo.getRegistNo()+"'";
      psmt2=con.prepareStatement(qr2);
      rs2=psmt2.executeQuery();
      if(rs2.next()){
      //seo.setEnrolNo(rs2.getString("en"));
      seo.setClasses(rs2.getString("cls"));
      seo.setType(rs2.getString("typ"));
      seo.setSname(rs2.getString("snm"));
      seo.setFname(rs2.getString("fnm"));
      seo.setDob(rs2.getString("dob"));   
      seo.setMobile(rs2.getString("pmobile"));
      seo.setFeeReceipt(rs2.getLong("fee_receipt"));
      }
      } 
      }
      catch(SQLException se){}  
       finally{
       try{
         if(rs!=null){rs.close();}   
         if(rs2!=null){rs2.close();}   
            if(rs5!=null){rs5.close();}   
         if(psmt!=null){psmt.close();} 
         if(psmt2!=null){psmt2.close();} 
         if(psmt5!=null){psmt5.close();} 
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      } 
     return seo;   
}








public int subEnrolledData(SchoolEO seo){ 
//  SimpleDateFormat sdf=new SimpleDateFormat("yy");  
//  java.util.Date dat=new java.util.Date();  
  Connection con=null;
  ArrayList ar=new ArrayList();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  con.setAutoCommit(false); 
  }catch(Exception e){}
       int count=0;
       String type="";
       String qr1="select count(*) as cnt from sub_feedata where session='"+seo.getSession()+"' and regist_no='"+seo.getRegistNo()+"'";
       String qr5="select enroll_no from oldregis where session='"+seo.getSession()+"' and srnum='"+seo.getRegistNo()+"'";
       String qr3="select max(rid) as mrid from sub_feedata where session='"+seo.getSession()+"'";
      try{         
      psmt=con.prepareStatement(qr1);
      rs=psmt.executeQuery();
      rs.next();
      count=rs.getInt("cnt");   
      if(count==0){      
      psmt5=con.prepareStatement(qr5);
      rs5=psmt5.executeQuery();
      if(rs5.next()){
      seo.setEnrolNo(rs5.getString("enroll_no"));    
      }else{
      psmt3=con.prepareStatement(qr3);
      rs3=psmt3.executeQuery();
      long mrid=0;
      if(rs3.next()){
      mrid=rs3.getLong("mrid");
      }
      mrid++; 
      String enrno=genEnrolNo(seo,mrid);
      seo.setEnrolNo(enrno);  
      }
      String qr2="insert into sub_feedata(session,regist_no,sname,classes,type,gender,fee_total,enroll_no,fee_receipt,batch,session_sem) "
              + "values(?,?,?,?,?,?,?,?,?,?,?)";        
      psmt2=con.prepareStatement(qr2);
      psmt2.setString(1,seo.getSession());
      psmt2.setString(2,seo.getRegistNo());
      psmt2.setString(3,seo.getSname());
      psmt2.setString(4,seo.getClasses());
      psmt2.setString(5,seo.getType());
      psmt2.setString(6,seo.getGender());
      psmt2.setDouble(7,seo.getFeeTotal());
      psmt2.setString(8,seo.getEnrolNo());
      psmt2.setLong(9,seo.getFeeReceipt());
      psmt2.setString(10,seo.getBatch());
      psmt2.setString(11,seo.getSession_sem());
      psmt2.executeUpdate();      
      String qr4="update studentregis set enroll_no=? where session='"+seo.getSession()+"' and srnum='"+seo.getRegistNo()+"'";
      psmt4=con.prepareStatement(qr4);
      psmt4.setString(1,seo.getEnrolNo());
      psmt4.executeUpdate();
      con.commit();
       }
       }
       catch(SQLException se){
       try{    
       con.rollback();
       }catch(SQLException se2){}
       }  
       finally{
       try{
         if(rs!=null){rs.close();}   
         if(rs3!=null){rs3.close();} 
         if(psmt!=null){psmt.close();} 
         if(psmt2!=null){psmt2.close();} 
         if(psmt3!=null){psmt3.close();} 
         if(psmt4!=null){psmt4.close();} 
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      } 
     return count;   
}

public SchoolEO retFeeHeadData(SchoolEO seo){ 
       Connection con=null;
       ArrayList ar=new ArrayList();
       HashMap hm=new HashMap();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}
       int count=0;
       String type="";
       //String qr1="select * from feechartdynam where session='"+seo.getSession()+"' and classes='"+seo.getClasses()+"' and gender='"+seo.getGender()+"' and type='"+seo.getType()+"'";
//        String qr1="select * suraj_from feechartdynam where session='"+seo.getSession()+"' and classes='"+seo.getClasses()+"' degree='"+seo.getDegree()+"' branch='"+seo.getBranch()+"' and gender='"+seo.getGender()+"' and type='"+seo.getType()+"'";   by kapil
       String qr1="select * from suraj_feechartdynam where session='"+seo.getSession()+"' and degree='"+seo.getDegree()+"'";
     try{
      psmt=con.prepareStatement(qr1);
      rs=psmt.executeQuery();
      while(rs.next()){
      ar.add(rs.getString("heads"));
      hm.put(rs.getString("heads"),rs.getString("fee"));
      } 
      seo.setDataArray2(ar);
      seo.setDataMap(hm);
      }
      catch(SQLException se){}  
        finally{
       try{
         if(rs!=null){rs.close();}   
         if(psmt!=null){psmt.close();} 
         if(psmt2!=null){psmt2.close();} 
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      } 
     return seo;   
}
public SchoolEO retCourseFeeHeadData(SchoolEO seo){ 
       Connection con=null;
       ArrayList ar=new ArrayList();
       HashMap hm=new HashMap();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}
       int count=0;
       String type="";
//      String qr1="select * from suraj_feechartdynam where session='"+seo.getSession()+"' and degree='"+seo.getDegree()+"' and branch='"+seo.getBranch()+"'"
//              + " and duration='"+seo.getDuration()+"' and gender='"+seo.getGender()+"' and type='"+seo.getType()+"'";
       String qr1="select distinct heads,fee from suraj_feechartdynam where session='"+seo.getSession()+"' and degree='"+seo.getDegree()+"'";
     try{
      psmt=con.prepareStatement(qr1);
      rs=psmt.executeQuery();
      while(rs.next()){
      ar.add(rs.getString("heads"));
      hm.put(rs.getString("heads"),rs.getString("fee"));
      } 
      seo.setDataArray2(ar);
      seo.setDataMap(hm);
//      System.out.println(seo.getDataArray2());
//      System.out.println(seo.getDataMap());
      }
      catch(SQLException se){}  
        finally{
       try{
         if(rs!=null){rs.close();}   
         if(psmt!=null){psmt.close();} 
         if(psmt2!=null){psmt2.close();} 
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      } 
     return seo;   
}

public int subClassTypeData(SchoolEO seo){ 
       Connection con=null;
       ArrayList ar=new ArrayList();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}
       int count=0;
       String type="";
       String qr1="select count(*) as cnt from coursetype where class='"+seo.getClasses()+"' and type='"+seo.getType()+"'";
     try{
      psmt=con.prepareStatement(qr1);
      rs=psmt.executeQuery();
      rs.next();
      count=rs.getInt("cnt");
      String qr2="insert into coursetype(class,type)values(?,?)";  
      if(count==0){
      psmt2=con.prepareStatement(qr2);
      psmt2.setString(1,seo.getClasses());
      psmt2.setString(2,seo.getType());
      psmt2.executeUpdate();
      }
      }
      catch(SQLException se){}  
        finally{
       try{
         if(rs!=null){rs.close();}   
         if(psmt!=null){psmt.close();} 
         if(psmt2!=null){psmt2.close();} 
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      } 
     return count;   
}

public int subFeeData(SchoolEO seo,ArrayList ar,HashMap hm){ 
       Connection con=null;
       try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}
       int count=0;
       String type="";
       //String qr1="select count(*) as cnt from feechartdynam where session='"+seo.getSession()+" and classes='"+seo.getSeekadd()+"' and type='"+seo.getType()+"' and head='"++"'";
       
     try{
         String qr1="select count(*) as cnt from suraj_feechartdynam where session='"+seo.getSession()+"' and degree='"+seo.getDegree()+"'";
         System.out.println(qr1);
       psmt1=con.prepareStatement(qr1);
       rs=psmt1.executeQuery();
       if(rs.next())
           count=rs.getInt("cnt");
       if(count==0){
      String qr2="insert into suraj_feechartdynam(session,classes,type,heads,fee,gender,degree,branch,duration)values(?,?,?,?,?,?,?,?,?)";    
      psmt=con.prepareStatement(qr2);
      for(int i=0;i<ar.size();i++){
      psmt.setString(1,seo.getSession());    
      psmt.setString(2,seo.getSeekadd());
      psmt.setString(3,seo.getType());
      psmt.setString(4,ar.get(i).toString());
      psmt.setDouble(5,Double.parseDouble(hm.get(ar.get(i)).toString()));
      psmt.setString(6,seo.getGender());
      psmt.setString(7,seo.getDegree());
      psmt.setString(8,seo.getBranch());
      psmt.setString(9,seo.getDuration());
      psmt.addBatch();
      }
      psmt.executeBatch();
       }
      }
     catch(SQLException se){
         //se.printStackTrace();
         count=-1;
     }  
     catch(NumberFormatException ne){
         //ne.printStackTrace();
         count=-1;
     }    
       finally{
       try{
       if(psmt!=null){psmt.close();}  
       if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      } 
     return count;   
}

public int editFeeData(SchoolEO seo,ArrayList ar,HashMap hm){ 
       Connection con=null;
       try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}
       int count=0;
       String type="";
       //String qr1="select count(*) as cnt from feechartdynam where session='"+seo.getSession()+" and classes='"+seo.getSeekadd()+"' and type='"+seo.getType()+"' and head='"++"'";
     try{
      String qr2="";   
      for(int i=0;i<ar.size();i++){   
      //qr2="update feechartdynam set fee=? where session='"+seo.getSession()+"' and classes='"+seo.getClasses()+"' and type='"+seo.getType()+"' and gender='"+seo.getGender()+"' and heads='"+ar.get(i)+"'";    
//      qr2="update suraj_feechartdynam set fee=? where session='"+seo.getSession()+"' and classes='"+seo.getClasses()+"' and degree='"+seo.getDegree()+"' and branch='"+seo.getBranch()+"' and type='"+seo.getType()+"' and gender='"+seo.getGender()+"' and heads='"+ar.get(i)+"'";  by kapil
          qr2="update suraj_feechartdynam set fee=? where session='"+seo.getSession()+"' and degree='"+seo.getDegree()+"' and heads='"+ar.get(i)+"'";    
      psmt=con.prepareStatement(qr2);      
      psmt.setDouble(1,Double.parseDouble(hm.get(ar.get(i)).toString()));
      psmt.executeUpdate();
      }
      }
     catch(SQLException se){count=-1;}  
     catch(NumberFormatException ne){count=-1;}    
       finally{
       try{
       if(psmt!=null){psmt.close();}  
       if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      } 
     return count;   
}

public ArrayList typeString(SchoolEO seo){ 
       Connection con=null;
       ArrayList ar=new ArrayList();
            try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}
       String type="";
       String qr1="select type from coursetype where class='"+seo.getSeekadd()+"'";
     try{
      psmt=con.prepareStatement(qr1);
      rs=psmt.executeQuery();
      while(rs.next()){
      ar.add(rs.getString("type"));
      }              
     }
     catch(SQLException se){ }  
        finally{
       try{
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      } 
     return ar;   
}
   
public ArrayList scheduleData(int stssn,int essn,String etype,String clas){
      Connection con=null;
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
     catch(SQLException se){}  
        finally{
       try{
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }  
    return ar1;   
  }  
   
public ArrayList retriveAllClass(){
        Connection con=null;
              try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
    ArrayList ar1=new ArrayList();        
       String qr1="select distinct class from classes";
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
        Connection con=null;
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
    //   jb.setType(rs.getString("type"));
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



    
public ArrayList retriveBranchesId(){
        Connection con=null;
              try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }            
       ArrayList ar1=new ArrayList();        
       String qr1="select id,branch,duration from branch";
     try{
      psmt=con.prepareStatement(qr1);
      rs=psmt.executeQuery();
      while(rs.next()){ 
       JavaBean jb=new JavaBean();    
       jb.setId(rs.getString("id"));   
       jb.setClas(rs.getString("branch"));
       jb.setDuration(rs.getString("duration"));
    //   jb.setType(rs.getString("type"));
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


  
public ArrayList Degree_list(){
        Connection con=null;
              try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }            
       ArrayList ar1=new ArrayList();        
     try{
      String qr1="select sd.code,sd.rwid,sd.degree,sd.self_f_prog,sd.college_code,c.college_name from suraj_degree sd left join college c on sd.college_code=c.code";
      psmt=con.prepareStatement(qr1);
      rs=psmt.executeQuery();
      while(rs.next()){ 
       JavaBean jb=new JavaBean();    
       jb.setDegcode(rs.getString("code"));
       jb.setRwid(rs.getInt("rwid"));
       jb.setDegree(rs.getString("degree"));
       jb.setType(rs.getString("self_f_prog"));
       jb.setCollegeCode(rs.getString("college_code"));
       jb.setCollege(rs.getString("college_name"));
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

public int chkDegree(String degree,String code){
    int cn=0;
    Connection con=null;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}     
    try{
         String qr1="select count(*) as cn from suraj_degree where degree='"+degree+"' or code='"+code+"'";
      psmt=con.prepareStatement(qr1);
      rs=psmt.executeQuery();
      if(rs.next()){ 
       cn=rs.getInt("cn");
      }              
     }
     catch(SQLException se){}    
        finally{
       try{
            if(psmt!=null){psmt.close();}
             if(rs!=null){rs.close();}
            if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }  
    return cn;
}

public void Add_Degree(String degree, String code,String self,String college_code){
        Connection con=null;
        
              try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }            
      try{
          String qr="insert into suraj_degree(degree,code,self_f_prog,college_code)values(?,?,?,?)";
          psmt1=con.prepareStatement(qr);
          psmt1.setString(1, degree);
          psmt1.setString(2, code);
          psmt1.setString(3, self);
          psmt1.setString(4, college_code);
          psmt1.executeUpdate();
      }catch(Exception e){System.out.println("check ex: "+e.getMessage()); }    
      finally{
       try{
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }  
     
  }

public ArrayList retAllDegree(){
    ArrayList ar1=new ArrayList();
    Connection con=null;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}  
    try{
         String qr1="select sd.code,sd.rwid,sd.degree,sd.self_f_prog,sd.college_code,c.college_name from suraj_degree sd left join college c on sd.college_code=c.code";
      psmt=con.prepareStatement(qr1);
      rs=psmt.executeQuery();
      while(rs.next()){ 
       JavaBean jb=new JavaBean();    
       jb.setDegcode(rs.getString("code"));
       jb.setRwid(rs.getInt("rwid"));
       jb.setDegree(rs.getString("degree"));
       jb.setType(rs.getString("self_f_prog"));
       jb.setCollegeCode(rs.getString("college_code"));
       jb.setCollege(rs.getString("college_name"));
       ar1.add(jb);
      }              
     }
     catch(SQLException se){}
    finally{
       try{
            if(psmt!=null){psmt.close();}
             if(rs!=null){rs.close();}
            if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }  
    return ar1;
}
public ArrayList del_Degree(int id){
        Connection con=null;
        ArrayList ar1=new ArrayList();
              try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
//  System.out.println(e.getMessage());    
  }            
      try{
          String qr="delete from suraj_degree where rwid=?";
          psmt1=con.prepareStatement(qr);
          psmt1.setInt(1, id);
          psmt1.executeUpdate();
      }catch(Exception e){
  System.out.println(e.getMessage());    
  }         
       
     try{
         String qr1="select * from suraj_degree";
      psmt=con.prepareStatement(qr1);
      rs=psmt.executeQuery();
      while(rs.next()){ 
       JavaBean jb=new JavaBean();    
       jb.setDegcode(rs.getString("code"));
       jb.setRwid(rs.getInt("rwid"));
       jb.setDegree(rs.getString("degree"));
    //   jb.setType(rs.getString("type"));
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

public String college_Degree(String deg){
        Connection con=null;
        String college="";
              try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
//  System.out.println(e.getMessage());    
  }            
      try{
          String qr="select college from suraj_degree where degree=?";
          psmt1=con.prepareStatement(qr);
          psmt1.setString(1, deg);
          rs=psmt1.executeQuery();
          if(rs.next())
              college=rs.getString("college");         
      }catch(Exception e){
  System.out.println(e.getMessage());    
  }   
        finally{
       try{
           if(psmt1!=null){psmt1.close();}  
           if(rs!=null){rs.close();}  
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }  
     return college;
  }

public ArrayList selectStudents(int stssn,int endssn,String clas){
  Connection con=null;
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
    
public ArrayList selectStudSec(int stssn,String clas,String sec){
         Connection con=null;
               try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
      ArrayList ar1=new ArrayList();      
      String qr1="select studname from studclasssection where class='"+clas+"' and section='"+sec+"' and froms='"+stssn+"' and studname not in (select studname from studdailyattend where class='"+clas+"' and section='"+sec+"' and froms='"+stssn+"') order by studname";
     try{
      psmt1=con.prepareStatement(qr1);
      rs1=psmt1.executeQuery();
      while(rs1.next()){
      ar1.add(rs1.getString("studname"));
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
     
public ArrayList gtSubject(int frm,int to,String clas){
         Connection con=null;
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
           Connection con=null;
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
              Connection con=null;
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
          Connection con=null;
          try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}
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
      
public SchoolEO retFeeReceiptData(SchoolEO seo){ 
       Connection con=null;
       PreparedStatement pss=null;
       ResultSet rss=null;
       ArrayList ar=new ArrayList();
         ArrayList sub=new ArrayList();
       HashMap hm=new HashMap();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
      int count=0;
      int cn=0;
      String feetyp="";  
      double feetot=0.0;
      PreparedStatement pst=null;
      ResultSet rst=null;
      
      
      
      try{
//          String st="select COUNT(*) as cnt from  stud_fee_details where session='"+seo.getSession()+"' and srnum='"+seo.getRegistNo()+"'";
//          pss=con.prepareStatement(st);
//          rss=pss.executeQuery();
//          if(rss.next())
//          {
//              cn=rss.getInt("cnt");
//          }
//          
//          if(cn==0){
      String qr4="select fee_receipt from sub_feedata where session='"+seo.getSession()+"' and regist_no='"+seo.getRegistNo()+"'";
      psmt3=con.prepareStatement(qr4);
      rs3=psmt3.executeQuery();  
      if(rs3.next()){ 
      seo.setFeeReceipt(rs3.getLong("fee_receipt"));    
      }
      String qr3="";      
      qr3="select studname,gender,seekadd,fname,degree,branch,stud_type from studentregis where session='"+seo.getSession()+"' and srnum='"+seo.getRegistNo()+"'";  
      psmt1=con.prepareStatement(qr3);
      rs1=psmt1.executeQuery();  
      if(rs1.next()){
      seo.setSname(rs1.getString("studname"));
      seo.setGender(rs1.getString("gender"));
      seo.setClasses(rs1.getString("seekadd")); 
      seo.setFname(rs1.getString("fname"));
      seo.setDegree(rs1.getString("degree"));
      seo.setBranch(rs1.getString("branch"));
      seo.setStud_type(rs1.getString("stud_type"));
      }else{
      qr3="select studname,gender,seekadd,fname from oldregis where session='"+seo.getSession()+"' and srnum='"+seo.getRegistNo()+"'";  
      psmt1=con.prepareStatement(qr3);
      rs1=psmt1.executeQuery(); 
      if(rs1.next()){
      seo.setSname(rs1.getString("studname"));
      seo.setGender(rs1.getString("gender"));
      seo.setClasses(rs1.getString("seekadd")); 
      seo.setFname(rs1.getString("fname"));
      
      }
      } 
      
      
      String subm_time="";
      String sst="select last_date, fine_per_day, max_fine from latefine_onfee where degree='"+seo.getDegree()+"' and semester='"+seo.getClasses()+"'";
      pst=con.prepareStatement(sst);
      rst=pst.executeQuery();
      if(rst.next())
      {
          subm_time=rst.getString("last_date");
          seo.setLastdate(subm_time);
          seo.setPfine(rst.getDouble("fine_per_day"));
          seo.setMax_fine(rst.getDouble("max_fine"));
          
      }
      SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
      java.util.Date dt=null;
      try{
      dt=(java.util.Date)sdf.parse(subm_time);
     
      java.util.Date dt1=new java.util.Date();
      int days=(int)((dt1.getTime()-dt.getTime())/(1000 * 60 * 60 * 24));
      if(days<0){
      seo.setTot_days(0); 
      }
      else
      {
          seo.setTot_days(days);
      }
       }catch(Exception eee){ System.out.println("parse "+eee.getMessage());}
      
      
      String qr2="select count(*) as cnt from class_sub where class='"+seo.getClasses()+"' and practical='YES' and subject in (select subject from stud_subject where session='"+seo.getSession()+"' and classes='"+seo.getClasses()+"' and admin_no='"+seo.getRegistNo()+"')";  
      psmt2=con.prepareStatement(qr2);
      rs2=psmt2.executeQuery();
      if(rs2.next()){
      count=rs2.getInt("cnt");  
      }      
      if(count==0){feetyp="NON PRAC";}
      if(count==1){feetyp="ONE PRAC";}
      if(count==2){feetyp="TWO PRAC";}
      if(count==3){feetyp="THREE PRAC";}
      seo.setType(feetyp);
//      String qr5="select distinct heads from feeheads where head_type='TREASURY'";
//      psmt4=con.prepareStatement(qr5);
//      rs4=psmt4.executeQuery();
//      while(rs4.next()){
//      ar.add(rs4.getString("heads"));    
//      }
      
      String qr6="";
      if(seo.getStud_type().equals("Hosteller")){
//      qr6="select distinct heads from feeheads where head_type<>'TREASURY'";
          qr6="select distinct heads from feeheads";
      }
      else
      {
          qr6="select distinct heads from feeheads where stud_type='Day Scholar'";
      }
      psmt5=con.prepareStatement(qr6);
      rs5=psmt5.executeQuery(); 
      while(rs5.next()){
      ar.add(rs5.getString("heads"));    
      }
      
   
      //String qr="select * from feechartdynam where heads=? and session='"+seo.getSession()+"' and classes='"+seo.getClasses()+"' and (gender='"+seo.getGender()+"' or gender='COMMON') and type='"+seo.getType()+"' order by heads";    
       String qr1="select * from suraj_feechartdynam where heads=? and session='"+seo.getSession()+"' and classes='"+seo.getClasses()+"' and degree='"+seo.getDegree()+"' and branch='"+seo.getBranch()+"' and (gender='"+seo.getGender()+"' or gender='COMMON') order by heads"; 
      
      
      
      psmt=con.prepareStatement(qr1);        
      for(int i=0;i<ar.size();i++){
      psmt.setString(1,ar.get(i).toString());
      rs=psmt.executeQuery();  
      if(rs.next()){
      hm.put(ar.get(i),rs.getString("fee"));
      
      feetot=feetot+rs.getDouble("fee");
      }         
      }
      seo.setDataArray2(ar);
      seo.setDataMap(hm);
      seo.setFeeTotal(feetot);
      }
      //}
      catch(SQLException se){}  
       finally{
       try{
         if(rs3!=null){rs3.close();}           
         if(rs2!=null){rs2.close();} 
         if(rs!=null){rs.close();}  
         if(rs4!=null){rs4.close();}  
         if(rs5!=null){rs5.close();}  
         if(rst!=null){rst.close();} 
         if(rss!=null){rss.close();}
          if(pss!=null){pss.close();}
         if(pst!=null){pst.close();}
         if(psmt3!=null){psmt3.close();}          
         if(psmt2!=null){psmt2.close();} 
         if(psmt!=null){psmt.close();} 
         if(psmt4!=null){psmt4.close();} 
         if(psmt5!=null){psmt5.close();} 
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      } 
      
      seo.setCounter(cn);
     return seo;   
}

public int Submit_fee_data(SchoolEO seo, ArrayList allist){ 
    int cn =0;
    SchoolEO se=new SchoolEO();
    Connection conn=null;
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date dt=new java.util.Date();
    String stime=sdf.format(dt);
    System.out.println(allist.get(0));
    
    try{
        Dataconnectivity dc=new Dataconnectivity();
        conn=dc.Dataconnect();
    }
    catch(Exception e){ System.out.println("Some error in database connection!");}
    
    String st="select COUNT(*) as cnt from  stud_fee_details where session='"+seo.getSession()+"' and srnum='"+seo.getRegistNo()+"'";
    try{
        psmt=conn.prepareStatement(st);
        rs=psmt.executeQuery();
        while(rs.next())
        {
           cn=rs.getInt("cnt"); 
        }
    }catch(Exception e){}
    
    if(cn==0){
        String Str="insert into stud_fee_details(session,srnum,sname,fname,gender,degree,branch,semester,fee_receipt,prospec_fee,reg_fee,lib_fee,academic_fee,late_fine,submission_date,submitted_fee,sem_fee)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
         try{
             psmt1=conn.prepareStatement(Str);
            psmt1.setString(1,seo.getSession());
            psmt1.setString(2,seo.getRegistNo());
            psmt1.setString(3,seo.getSname());
            psmt1.setString(4,seo.getFname());
            psmt1.setString(5,seo.getGender());
            psmt1.setString(6,seo.getDegree());
            psmt1.setString(7,seo.getBranch());
            psmt1.setString(8,seo.getSemester());
            psmt1.setLong(9,seo.getFeeReceipt());
            psmt1.setDouble(10,(Double)allist.get(0));
            psmt1.setDouble(11,(Double)allist.get(1));
            psmt1.setDouble(12,(Double)allist.get(2));
            psmt1.setDouble(13,(Double)allist.get(3));
            psmt1.setDouble(14,seo.getFine());
            psmt1.setString(15,stime);
             psmt1.setDouble(16,seo.getFeeTotal());
              psmt1.setDouble(17,seo.getTotalFee());
              
            
            psmt1.executeUpdate();
         }catch(Exception ee){System.out.println("Submission failed! Please try again.");}
         finally{
             try{
             if(rs!=null){
                 rs.close();
             }
             if(psmt!=null){
                 psmt.close();
             }
             if(psmt1!=null){
                 psmt1.close();
             }
             if(conn!=null){
                 conn.close();
             }
             }catch(Exception eee){}
         }
    }
    return cn;
}

public int Submit_stud_fee(SchoolEO seo, ArrayList allist, HashMap hm){ 
    int cn =0;
    SchoolEO se=new SchoolEO();
    Connection conn=null;
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    java.util.Date dt=new java.util.Date();
    String stime=sdf.format(dt);
    //System.out.println(allist.get(0));
    
    try{
        Dataconnectivity dc=new Dataconnectivity();
        conn=dc.Dataconnect();
    }
    catch(Exception e){ System.out.println("Some error in database connection!");}
    
    String st="select COUNT(*) as cnt from  stud_fee_details where session='"+seo.getSession()+"' and srnum='"+seo.getRegistNo()+"'";
    try{
        psmt=conn.prepareStatement(st);
        rs=psmt.executeQuery();
        while(rs.next())
        {
           cn=rs.getInt("cnt"); 
        }
    }catch(Exception e){ System.out.println(e);}
   
    if(cn==0){
        //String Str="insert into stud_fee_details(session,srnum,sname,fname,gender,degree,branch,semester,fee_receipt,prospec_fee,reg_fee,lib_fee,academic_fee,late_fine,submission_date,submitted_fee,sem_fee)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String Str="insert into stud_fee_details(session,srnum,sname,fname,gender,degree,branch,semester,fee_receipt,heads,fee,late_fine,submission_date,submitted_fee,sem_fee,fine_limit,last_subm_date)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
             psmt1=conn.prepareStatement(Str);
             for(int i=0;i<allist.size();i++){
            psmt1.setString(1,seo.getSession());
            psmt1.setString(2,seo.getRegistNo());
            psmt1.setString(3,seo.getSname());
            psmt1.setString(4,seo.getFname());
            psmt1.setString(5,seo.getGender());
            psmt1.setString(6,seo.getDegree());
            psmt1.setString(7,seo.getBranch());
            psmt1.setString(8,seo.getSemester());
            psmt1.setLong(9,seo.getFeeReceipt());
           psmt1.setString(10,allist.get(i).toString());
          
            psmt1.setDouble(11,Double.parseDouble(hm.get(allist.get(i)).toString()));
             //System.out.println("....Please try again...."+allist.size()+", "+hm.size());
            psmt1.setDouble(12,seo.getFine());
            psmt1.setString(13,stime);
             psmt1.setDouble(14,seo.getFeeTotal());
              psmt1.setDouble(15,seo.getTotalFee());
              psmt1.setDouble(16,seo.getMax_fine());
               psmt1.setString(17,seo.getLastdate());
              psmt1.addBatch();
             }
            psmt1.executeBatch();
         }catch(Exception ee){System.out.println(ee);}
         finally{
             try{
             if(rs!=null){
                 rs.close();
             }
             if(psmt!=null){
                 psmt.close();
             }
             if(psmt1!=null){
                 psmt1.close();
             }
             if(conn!=null){
                 conn.close();
             }
             }catch(Exception eee){}
         }
    }
    return cn;
}

public SchoolEO Get_Submit_fee_data(SchoolEO seo){ 
    
    SchoolEO se=new SchoolEO();
    Connection conn=null;
//    SimpleDateFormat sdf=new SimpleDateFormat();
//    java.util.Date dt=new java.util.Date();
//    String stime=sdf.format(dt);
    ArrayList al=new ArrayList();
    ArrayList ar=new ArrayList();
    HashMap hm=new HashMap();
    int cntr=0;
    
    try{
        Dataconnectivity dc=new Dataconnectivity();
        conn=dc.Dataconnect();
    }
    catch(Exception e){ System.out.println("Some error in database connection!");}
    
    String qr1="select COUNT(*) as cnt from stud_fee_details where session='"+seo.getSession()+"' and srnum='"+seo.getRegistNo()+"'";
    try{
        psmt1=conn.prepareStatement(qr1);
      rs1=psmt1.executeQuery();
      if(rs1.next())
      {
         cntr=rs1.getInt("cnt"); 
      }
    }catch(Exception ee){System.out.println("Error Occured..!");}
    
    
   String subm_time="";
      String last_date="";
    if(cntr!=0){ 
        
//       String qr5="select distinct heads from feeheads where head_type='TREASURY'";
//       try{
//          
//      psmt4=conn.prepareStatement(qr5);
//      rs4=psmt4.executeQuery();
//      while(rs4.next()){
//      ar.add(rs4.getString("heads"));    
//      }
//      //se.setDataArray2(ar);
//       }catch(Exception ee){System.out.println("Error Occured!");}
     
    String st="select * from  stud_fee_details where session='"+seo.getSession()+"' and srnum='"+seo.getRegistNo()+"'";
    try{
        psmt=conn.prepareStatement(st);
        rs=psmt.executeQuery();
        while(rs.next())
        {
           
            se.setSession(rs.getString("session"));
            se.setRegistNo(rs.getString("srnum"));
            se.setSname(rs.getString("sname"));
            se.setGender(rs.getString("gender"));
            se.setFname(rs.getString("fname"));
            se.setDegree(rs.getString("degree"));
            se.setBranch(rs.getString("branch"));   
            se.setSemester(rs.getString("semester"));
            se.setFeeReceipt(rs.getLong("fee_receipt"));
//            al.add(rs.getDouble("prospec_fee"));
//            al.add(rs.getDouble("reg_fee"));
//            al.add(rs.getDouble("lib_fee"));
//            al.add(rs.getDouble("academic_fee"));
//            se.setFeeList(al);
            se.setFine(rs.getDouble("late_fine"));
            se.setFeeTotal(rs.getDouble("submitted_fee"));
            se.setTotalFee(rs.getDouble("sem_fee"));
            
            subm_time=rs.getString("submission_date"); 
            se.setDateofadd(subm_time);
            
            se.setMax_fine(rs.getDouble("fine_limit"));
            last_date=rs.getString("last_subm_date");
            se.setLastdate(last_date);
            
        }
    }catch(Exception eee){}
    
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
      java.util.Date dt=null;
      java.util.Date dt1=null;
      try{
      dt=(java.util.Date)sdf.parse(subm_time);
     //System.out.println("hello..");
      dt1=sdf.parse(last_date);
      }catch(ParseException pe){}
      int days=(int)((dt.getTime()-dt1.getTime())/(1000 * 60 * 60 * 24));
      if(days<0)
      {
      se.setTot_days(0); 
      }
      else
      {
        se.setTot_days(days);  
      }
    
    ArrayList arl=new ArrayList();
    String sttt1="select heads from  stud_fee_details where session='"+seo.getSession()+"' and srnum='"+seo.getRegistNo()+"'";
    try{
         psmt4=conn.prepareStatement(sttt1);
        rs4=psmt4.executeQuery();
        while(rs4.next())
        {
            arl.add(rs4.getString("heads"));
        }
        String sttt="select * from  stud_fee_details where heads=? and session='"+seo.getSession()+"' and srnum='"+seo.getRegistNo()+"' order by heads";
        psmt=conn.prepareStatement(sttt);
        for(int i=0;i<arl.size();i++){
            psmt.setString(1,arl.get(i).toString());
            rs=psmt.executeQuery();  
            if(rs.next()){
                
                hm.put(arl.get(i),rs.getString("fee"));  
                    }  
            System.out.println(hm.get(arl.get(i)));
            }
         System.out.println("...hii.."+hm.size()+": "+arl.size());
        se.setDataArray2(arl);
        se.setDataMap(hm);
        
    }catch(Exception eee){System.out.println(eee);}
    finally{
             try{
             if(rs!=null){ rs.close();}
              if(rs1!=null){ rs1.close();}
              if(rs2!=null){ rs2.close();}
              if(rs3!=null){ rs3.close();}
              if(rs4!=null){rs4.close();}
             if(psmt!=null){psmt.close(); }
             if(psmt1!=null){psmt1.close(); }
              if(psmt2!=null){psmt2.close(); }
               if(psmt3!=null){psmt3.close(); }
             if(psmt4!=null){psmt4.close();}
             if(conn!=null){conn.close(); }
             }catch(Exception e1){}
         }
    }
    se.setCounter(cntr);
    return se;
}

public ArrayList studData(SchoolEO seo){
  Connection con=null;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}
    ArrayList ar=new ArrayList(); 
    if(seo.getBy().equals("CATEGORY")){
    ar.add("GENERAL");
    ar.add("SC");
    ar.add("ST");
    ar.add("OBC");
    }
    if(seo.getBy().equals("GENDER")){
    ar.add("MALE");
    ar.add("FEMALE");
    }   
    if(seo.getBy().equals("SUBJECT")){
    String qr="";   
    if(seo.getClasses().equals("ALL")){    
    qr="select distinct subject from class_sub";    
    }else{
    qr="select distinct subject from class_sub where class='"+seo.getClasses()+"'";      
    }
    try{
    psmt1=con.prepareStatement(qr);
    rs1=psmt1.executeQuery();
    while(rs1.next()){   
    ar.add(rs1.getString("subject"));    
    }
    }catch(SQLException se){}
     finally{
       try{
         if(rs1!=null){rs1.close();}  
         if(psmt1!=null){psmt1.close();}  
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }  
     }   
      return ar;
     }
     
public ArrayList studListData(SchoolEO seo2){
  Connection con=null;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}  
  String by="";
  if(seo2.getBy().equals("CATEGORY")){by="category";}
  if(seo2.getBy().equals("GENDER")){by="gender";}
  if(seo2.getBy().equals("SUBJECT")){by="subject";}
    ArrayList ar=new ArrayList(); 
    String qr="";
    if(seo2.getBy().equals("SUBJECT")){
    qr="select * from studentregis where session='"+seo2.getSession()+"' and seekadd='"+seo2.getClasses()+"' and srnum in (select admin_no from stud_subject where session='"+seo2.getSession()+"' and classes='"+seo2.getClasses()+"' and subject='"+seo2.getDataBy()+"') ORDER BY SUBSTR(srnum,1,1),CONVERT(SUBSTR(srnum,INSTR(srnum,'-')+1),UNSIGNED)";
    }else{
    if(seo2.getDataBy().equals("ALL")){
    qr="select * from studentregis where session='"+seo2.getSession()+"' and seekadd='"+seo2.getClasses()+"' ORDER BY SUBSTR(srnum,1,1),CONVERT(SUBSTR(srnum,INSTR(srnum,'-')+1),UNSIGNED)";
    }else{    
    qr="select * from studentregis where session='"+seo2.getSession()+"' and seekadd='"+seo2.getClasses()+"' and "+by+"='"+seo2.getDataBy()+"' ORDER BY SUBSTR(srnum,1,1),CONVERT(SUBSTR(srnum,INSTR(srnum,'-')+1),UNSIGNED)";
    }}
    try{
    psmt1=con.prepareStatement(qr);
    rs=psmt1.executeQuery();
    while(rs.next()){   
    SchoolEO seo=new SchoolEO();    
 seo.setSession(rs.getString("session"));
 seo.setRegistNo(rs.getString("srnum"));
 seo.setSname(rs.getString("studname"));
 seo.setDob(rs.getString("dob"));
 seo.setGender(rs.getString("gender"));
 seo.setNationality(rs.getString("nationality"));
 seo.setFname(rs.getString("fname"));
 seo.setMname(rs.getString("mname"));
 seo.setAddress(rs.getString("paddress"));
 seo.setPhone(rs.getString("pphone"));
 seo.setMobile(rs.getString("pmobile"));
 seo.setSeekadd(rs.getString("seekadd"));
 seo.setCategory(rs.getString("category"));
 seo.setYearRegist(rs.getString("year_regist"));
 seo.setClassRegist(rs.getString("class_regist"));
 seo.setStandard(rs.getString("standard"));
 seo.setEnrolNo(rs.getString("enroll_no"));
 seo.setAdminType(rs.getString("admin_type"));
 seo.setHighSchool(rs.getDouble("highper"));
 seo.setHighMm(rs.getDouble("high_max_marks"));
 seo.setHighObt(rs.getDouble("high_obt_marks"));
 seo.setIntermediate(rs.getDouble("interper"));
 seo.setInterMm(rs.getDouble("inter_max_marks"));
 seo.setInterObt(rs.getDouble("inter_obt_marks")); 
 seo.setHighBoard(rs.getString("high_board"));
 seo.setInterBoard(rs.getString("inter_board"));
 seo.setDomicile(rs.getString("domicile"));
 ar.add(seo);
 } 
}catch(SQLException se){}    
     finally{
       try{
         if(rs!=null){rs.close();}  
         if(psmt1!=null){psmt1.close();}  
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }    
     return ar;
     }     

public ArrayList studListData3(SchoolEO seo2){
  Connection con=null;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}  
  String by="";
  if(seo2.getBy().equals("CATEGORY")){by="category";}
  if(seo2.getBy().equals("GENDER")){by="gender";}
  if(seo2.getBy().equals("SUBJECT")){by="subject";}
    ArrayList ar=new ArrayList(); 
    String qr="";
    if(seo2.getBy().equals("SUBJECT")){
    qr="select srnum,enroll_no,studname,gender,dob,fname,mname,category,seekadd,domicile,admin_type from studentregis where session='"+seo2.getSession()+"' and seekadd='"+seo2.getClasses()+"' and srnum in (select admin_no from stud_subject where session='"+seo2.getSession()+"' and classes='"+seo2.getClasses()+"' and subject='"+seo2.getDataBy()+"') union " +
       "select srnum,enroll_no,studname,gender,dob,fname,mname,category,seekadd,domicile,admin_type from oldregis where session='"+seo2.getSession()+"' and seekadd='"+seo2.getClasses()+"' and srnum in (select admin_no from stud_subject where session='"+seo2.getSession()+"' and classes='"+seo2.getClasses()+"' and subject='"+seo2.getDataBy()+"') ORDER BY SUBSTR(srnum,1,1),CONVERT(SUBSTR(srnum,INSTR(srnum,'-')+1),UNSIGNED)";    
    }else{
    if(seo2.getDataBy().equals("ALL")){
    qr="select srnum,enroll_no,studname,gender,dob,fname,mname,category,seekadd,domicile,admin_type from studentregis where session='"+seo2.getSession()+"' and seekadd='"+seo2.getClasses()+"' union " +
       "select srnum,enroll_no,studname,gender,dob,fname,mname,category,seekadd,domicile,admin_type from oldregis where session='"+seo2.getSession()+"' and seekadd='"+seo2.getClasses()+"' ORDER BY SUBSTR(srnum,1,1),CONVERT(SUBSTR(srnum,INSTR(srnum,'-')+1),UNSIGNED)";      
    }else{    
    qr="select srnum,enroll_no,studname,gender,dob,fname,mname,category,seekadd,domicile,admin_type from studentregis where session='"+seo2.getSession()+"' and seekadd='"+seo2.getClasses()+"' and "+by+"='"+seo2.getDataBy()+"' union " +
       "select srnum,enroll_no,studname,gender,dob,fname,mname,category,seekadd,domicile,admin_type from oldregis where session='"+seo2.getSession()+"' and seekadd='"+seo2.getClasses()+"' and "+by+"='"+seo2.getDataBy()+"' ORDER BY SUBSTR(srnum,1,1),CONVERT(SUBSTR(srnum,INSTR(srnum,'-')+1),UNSIGNED)";  
    }}
    try{
    psmt1=con.prepareStatement(qr);
    rs=psmt1.executeQuery();
    while(rs.next()){   
    SchoolEO seo=new SchoolEO();    
//seo.setSession(rs.getString("session"));
 seo.setRegistNo(rs.getString("srnum"));
 seo.setSname(rs.getString("studname"));
 seo.setDob(rs.getString("dob"));
 seo.setGender(rs.getString("gender"));
 seo.setFname(rs.getString("fname"));
 seo.setMname(rs.getString("mname"));
 seo.setSeekadd(rs.getString("seekadd"));
 seo.setCategory(rs.getString("category"));
 seo.setEnrolNo(rs.getString("enroll_no"));
 seo.setAdminType(rs.getString("admin_type"));
 seo.setDomicile(rs.getString("domicile"));
 ar.add(seo);
 } 
}catch(SQLException se){}    
     finally{
       try{
         if(rs!=null){rs.close();}  
         if(psmt1!=null){psmt1.close();}  
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }    
     return ar;
     } 

public CcBean studCcData(CcBean cb){
  Connection con=null;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}   
    String qr="select * from cc_data where adminno='"+cb.getAdminNo()+"'";  
    try{
    psmt1=con.prepareStatement(qr);
    rs=psmt1.executeQuery();
    if(rs.next()){       
    cb.setAdminNo(rs.getString("adminno"));
    cb.setFname(rs.getString("fname")); 
    cb.setName(rs.getString("name"));
    cb.setClasses(rs.getString("classes"));
    cb.setRid(rs.getLong("rid"));
    cb.setFrom(rs.getString("from_sesn"));
    cb.setTo(rs.getString("to_sesn"));
    
    } 
}catch(SQLException se){}    
     finally{
       try{
         if(rs!=null){rs.close();}  
         if(psmt1!=null){psmt1.close();}  
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }    
     return cb;
     }  

public TcBean studTcData(TcBean tb){
  Connection con=null;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}   
    String qr="select * from tc_data where adminno='"+tb.getAdminNo()+"'";  
    try{
    psmt1=con.prepareStatement(qr);
    rs=psmt1.executeQuery();
    while(rs.next()){       
    tb.setAdminNo(rs.getString("adminno")); 
    tb.setDob(rs.getString("dob"));
    tb.setEntYear(rs.getString("clg_ent_year"));
    tb.setFname(rs.getString("fname"));
    tb.setMname(rs.getString("mname"));
    tb.setLastClass(rs.getString("lastedu_class"));
    tb.setMigrReason(rs.getString("migrat_reason"));
    tb.setName(rs.getString("name"));
    tb.setResult(rs.getString("result"));
    tb.setRid(rs.getLong("rid"));
    tb.setStudMonth(rs.getInt("study_year"));
    tb.setStudYear(rs.getInt("study_month"));
    tb.setEnrolNo(rs.getString("enrolno"));
    } 
}catch(SQLException se){}    
     finally{
       try{
         if(rs!=null){rs.close();}  
         if(psmt1!=null){psmt1.close();}  
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }    
     return tb;
     }  

public SchoolEO retHeadFee(SchoolEO seo){ 
  Connection con=null;
  ArrayList fields=seo.getDataArray();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}
       double fee=0.0;
       
       String qr2="";      
       StringBuffer sb=new StringBuffer();
       sb=sb.append("select sum(");
       for(int i=0;i<fields.size();i++)
       {
           sb=sb.append(fields.get(i).toString());
           if(i!=(fields.size()-1))
               sb=sb.append("+");
       }
       sb=sb.append(") as fee from stud_fee_detail where session='"+seo.getSession()+"'");
       if(!seo.getSession_sem().equals("Both"))
           sb=sb.append(" and session_sem='"+seo.getSession_sem()+"'");
       sb=sb.append(" and student_transfer ='NO'");
       
       sb=sb.append("union select sum(");
       for(int i=0;i<fields.size();i++)
       {
           sb=sb.append(fields.get(i).toString());
           if(i!=(fields.size()-1))
               sb=sb.append("+");
       }
       sb=sb.append(") as fee from noduesed_student_amount where session='"+seo.getSession()+"'");
       if(!seo.getSession_sem().equals("Both"))
           sb=sb.append(" and session_sem='"+seo.getSession_sem()+"'");
      try{
         qr2=sb.toString();
//         System.out.println("qr1: "+qr2);
      psmt2=con.prepareStatement(qr2);
      rs2=psmt2.executeQuery();
      while(rs2.next()){
      fee=fee+rs2.getDouble("fee");     
    }
      DecimalFormat df = new DecimalFormat("0.00");
//System.out.println("first tot: "+df.format(fee));      
 if((seo.getHeads_cat().equals("UNIVERSITY DUES")||seo.getHeads_cat().equals("ANY"))&&seo.getField().equals(""))
   {     
      if(!seo.getSession_sem().equals("Both"))
          qr2="select sum(self_finance_fee) as self,sum(extra) as extra,sum(adjstDraftTtAndFeeTt) as adjstDraftTtAndFeeTt from stud_fee_detail"
                  + " where session='"+seo.getSession()+"' and session_sem='"+seo.getSession_sem()+"' and student_transfer ='NO'";
      else
          qr2="select sum(self_finance_fee) as self,sum(extra) as extra,sum(adjstDraftTtAndFeeTt) as adjstDraftTtAndFeeTt from stud_fee_detail"
                  + " where session='"+seo.getSession()+"' and student_transfer ='NO'";
//      System.out.println("qr2: "+qr2);
      psmt=con.prepareStatement(qr2);
      rs=psmt.executeQuery();
      if(rs.next())
          fee=fee+rs.getDouble("self")+rs.getDouble("extra")+rs.getDouble("adjstDraftTtAndFeeTt");
      rs.close();
//System.out.println("second tot: "+df.format(fee));            
      
      if(!seo.getSession_sem().equals("Both"))
          qr2="select sum(amount) as amount from sponsored_student where session='"+seo.getSession()+"' and session_sem='"+seo.getSession_sem()+"'";
      else
          qr2="select sum(amount) as amount from sponsored_student where session='"+seo.getSession()+"'";
      psmt=con.prepareStatement(qr2);
      rs=psmt.executeQuery();
      if(rs.next())
          fee=fee+rs.getDouble("amount");
      rs.close();
//System.out.println("Third tot: "+df.format(fee));            
      
      if(!seo.getSession_sem().equals("Both"))
          qr2="select sum(fine) as fine from latefine_onfeeprocess where session='"+seo.getSession()+"' and session_sem='"+seo.getSession_sem()+"'";
      else
          qr2="select sum(fine) as fine from latefine_onfeeprocess where session='"+seo.getSession()+"'";
      psmt=con.prepareStatement(qr2);
      rs=psmt.executeQuery();
      if(rs.next())
          fee=fee+rs.getDouble("fine");
//System.out.println("fourth tot: "+df.format(fee));  
      rs.close();            
      
      if(!seo.getSession_sem().equals("Both"))
          qr2="select sum(amount) as fine from stud_other_inst where session='"+seo.getSession()+"' and session_sem='"+seo.getSession_sem()+"'"
                  + " and transfered='NO'";
      else
          qr2="select sum(amount) as fine from stud_other_inst where session='"+seo.getSession()+"' and transfered='NO'";
      psmt=con.prepareStatement(qr2);
      rs=psmt.executeQuery();
      if(rs.next())
          fee=fee+rs.getDouble("fine");
   }       
      seo.setFeeTotal(fee);
      }
      catch(SQLException se){}  
        finally{
       try{
         if(rs!=null){rs.close();}   
         if(psmt!=null){psmt.close();} 
         if(rs2!=null){rs2.close();} 
         if(psmt2!=null){psmt2.close();} 
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      } 
     return seo;   
}

public String genEnrolNo(SchoolEO seo,long no){     
     String enr="";
     int cod=genClassCode(seo);
     enr=cod+"/"+seo.getSession()+"/"+seo.getClasses()+"/"+no;
     return enr;   
}

public int genClassCode(SchoolEO seo){  
  int cod=0;  
  Connection con=null;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}       
    String strm="";
    String qr="select stream from classes where class='"+seo.getClasses()+"'";  
    try{
    psmt1=con.prepareStatement(qr);
    rs1=psmt1.executeQuery();
    if(rs1.next()){
    strm=rs1.getString("stream"); 
    seo.setStream(strm);
    }
    }catch(SQLException se){}
    finally{
    try{
    if(rs1!=null){rs1.close();}
    if(psmt1!=null){psmt1.close();}
    }catch(SQLException se){} 
    }
     if(seo.getStream().equals("ART")){cod=1;}
     if(seo.getStream().equals("COMMERCE")){cod=2;}
     if(seo.getStream().equals("SCIENCE")){cod=3;}
     if(seo.getStream().equals("OTHERS")){cod=4;}
     if(seo.getStream().equals("")){cod=4;}
     return cod;   
}

public ArrayList studList(SchoolEO seo){
  Connection con=null;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}  
    ArrayList ar=new ArrayList(); 
    String qr="select srnum,studname,gender from studentregis where session='"+seo.getSession()+"' and seekadd='"+seo.getClasses()+"' union select srnum,studname,gender from oldregis where session='"+seo.getSession()+"' and seekadd='"+seo.getClasses()+"'";    
    try{
    psmt1=con.prepareStatement(qr);
    rs1=psmt1.executeQuery();
    while(rs1.next()){ 
    SchoolEO seo2=new SchoolEO();    
    seo2.setSrnum(rs1.getString("srnum")); 
    seo2.setSname(rs1.getString("studname"));   
    seo2.setGender(rs1.getString("gender"));
    ar.add(seo2);
    }
    }catch(SQLException se){}
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

public ArrayList retStudSub(SchoolEO seo,Object obj){
  Connection con=null;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}
    ArrayList ar=new ArrayList(); 
    String qr="select * from stud_subject where session='"+seo.getSession()+"' and classes='"+seo.getClasses()+"' and admin_no='"+obj+"'";    
    try{
    psmt1=con.prepareStatement(qr);
    rs1=psmt1.executeQuery();
    while(rs1.next()){   
    ar.add(rs1.getString("subject"));       
    }
    }catch(SQLException se){}
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

public int addCounterData(TcBean tb){
  int count=1;
  Connection con=null;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}   
    String qr="select counter as cnt from tc_counter where adminno='"+tb.getAdminNo()+"'";  
    String qr1="insert into tc_counter(enroll_no,counter,adminno)values(?,?,?)"; 
    String qr2="update tc_counter set counter=? where adminno='"+tb.getAdminNo()+"'"; 
    try{
    psmt1=con.prepareStatement(qr);
    rs=psmt1.executeQuery();
    int cn=0;
    if(rs.next()){    
    cn=rs.getInt("cnt");
    }
    if(cn!=0){
    count=count+cn;    
    }
    if(cn==0){
    psmt2=con.prepareStatement(qr1);
    psmt2.setString(1,tb.getAdminNo());
    psmt2.setInt(2,count);
    psmt2.setString(3,tb.getAdminNo());
    psmt2.executeUpdate();
    }else{
    psmt2=con.prepareStatement(qr2);
    psmt2.setInt(1,count);
    psmt2.executeUpdate();
    }
}catch(SQLException se){}    
     finally{
       try{
         if(rs!=null){rs.close();}        
         if(psmt1!=null){psmt1.close();} 
         if(psmt2!=null){psmt2.close();}  
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }    
     return count;
     }  

public int retCounter(TcBean tb){
  int count=0;  
  Connection con=null;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}   
    String qr="select counter from tc_counter where adminno='"+tb.getAdminNo()+"'";  
    try{
    psmt1=con.prepareStatement(qr);
    rs=psmt1.executeQuery();    
    if(rs.next()){    
    count=rs.getInt("counter");
    }
}catch(SQLException se){}    
     finally{
       try{
         if(rs!=null){rs.close();}        
         if(psmt1!=null){psmt1.close();} 
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }    
     return count;
     } 

public long genFeeReceiptNo(){
  long recpt=1;  
  Connection con=null;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}   
    String qr="select max(fee_receipt) as fee_receipt from sub_feedata";  
    try{
    psmt1=con.prepareStatement(qr);
    rs=psmt1.executeQuery();    
    if(rs.next()){    
    recpt=rs.getInt("fee_receipt");
    recpt++;
    }
}catch(SQLException se){}    
     finally{
       try{
         if(rs!=null){rs.close();}        
         if(psmt1!=null){psmt1.close();} 
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }    
     return recpt;
     } 

public int upStudFeeData(Connection con,SchoolEO seo){ 
//  SimpleDateFormat sdf=new SimpleDateFormat("yy");  
//  java.util.Date dat=new java.util.Date();  
  ArrayList ar=new ArrayList();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
      int count=0;
      int count2=0;
      String type="";
      double feetot=0.0;
      String qr1="select count(*) as cnt from sub_feedata where session='"+seo.getSession()+"' and regist_no='"+seo.getSrnum()+"'";
      try{         
      psmt=con.prepareStatement(qr1);
      rs=psmt.executeQuery();
      rs.next();
      count=rs.getInt("cnt");   
      if(count!=0){
          
      String feetyp="";
      String qr3="select count(*) as cnt from class_sub where class='"+seo.getClasses()+"' and practical='YES' and subject in (select subject from stud_subject where session='"+seo.getSession()+"' and classes='"+seo.getClasses()+"' and admin_no='"+seo.getSrnum()+"')";  
      psmt3=con.prepareStatement(qr3);
      rs3=psmt3.executeQuery();
      rs3.next();
      count2=rs3.getInt("cnt");   
      if(count2==0){feetyp="NON PRAC";}
      if(count2==1){feetyp="ONE PRAC";}
      if(count2==2){feetyp="TWO PRAC";}
      if(count2==3){feetyp="THREE PRAC";}
      seo.setType(feetyp);   
      
      String qr4="select sum(fee) as total from feechartdynam where session='"+seo.getSession()+"' and classes='"+seo.getClasses()+"' and (gender='"+seo.getGender()+"' or gender='COMMON') and type='"+seo.getType()+"' order by heads";    
      psmt4=con.prepareStatement(qr4);
      rs4=psmt4.executeQuery();
      if(rs4.next()){
      feetot=rs4.getDouble("total");
      }
      
      String qr2="update sub_feedata set classes=?,type=?,fee_total=? where session='"+seo.getSession()+"' and regist_no='"+seo.getSrnum()+"'";        
      psmt2=con.prepareStatement(qr2);
      psmt2.setString(1,seo.getClasses());
      psmt2.setString(2,seo.getType());
      psmt2.setDouble(3,feetot);
      psmt2.executeUpdate();     
       
      }
       }catch(SQLException se){count=-1;}  
       finally{
       try{
         if(rs!=null){rs.close();}   
         if(rs3!=null){rs3.close();}          
         if(rs4!=null){rs4.close();} 
         if(psmt2!=null){psmt2.close();} 
         if(psmt3!=null){psmt3.close();} 
         if(psmt4!=null){psmt4.close();} 
         }   
       catch(SQLException se){}
      } 
     return count;   
}

public String retAcNo(Object hd){ 
  String hdac="";  
  Connection con=null;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}
       int count=0;
       String type="";
       String qr1="select head_ac from feeheads where heads='"+hd+"'";
     try{
      psmt=con.prepareStatement(qr1);
      rs=psmt.executeQuery();
      if(rs.next()){
      hdac=rs.getString("head_ac");
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
     return hdac;   
}

public ArrayList retClassSubData(SchoolEO seo){
        Connection con=null;
              try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}
    ArrayList ar1=new ArrayList();        
       String qr1="select class,subject,practical from class_sub where class='"+seo.getClasses()+"'";
      try{
      psmt=con.prepareStatement(qr1);
      rs=psmt.executeQuery();
      while(rs.next()){  
       SchoolEO seo2=new SchoolEO();   
       seo2.setClasses(rs.getString("class"));
       seo2.setSubject(rs.getString("subject"));
       seo2.setPractical(rs.getString("practical"));
       ar1.add(seo2);
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
    return ar1;   
  }

public SchoolEO retstudData(SchoolEO seo){ 
    SchoolEO seo1=new SchoolEO();
       Connection con=null;
       PreparedStatement pss=null;
       ResultSet rss=null;
       ArrayList ar=new ArrayList();
       ArrayList bank=new ArrayList();
         ArrayList sub=new ArrayList();
       HashMap hm=new HashMap();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
  
  try{
      String qr="select session,srnum,studname,dob,gender,fname,category,degree,stud_id from studentregis where srnum=? and session=?";
      psmt=con.prepareStatement(qr);
      psmt.setString(1, seo.getRegistNo());
      psmt.setString(2, seo.getSession());
      rs=psmt.executeQuery();
      while(rs.next())
      {
          seo1.setSession(rs.getString("session"));
          seo1.setSrnum(rs.getString("srnum"));
          seo1.setSname(rs.getString("studname"));
          seo1.setDob(rs.getString("dob"));
          seo1.setGender(rs.getString("gender"));
          seo1.setFname(rs.getString("fname"));
          seo1.setCategory(rs.getString("category"));
          seo1.setDegree(rs.getString("degree"));
          seo1.setStud_id(rs.getString("stud_id"));
      }
      
      String qr1="select * from bank";
      psmt1=con.prepareStatement(qr1);
      rs1=psmt1.executeQuery();
      while(rs1.next())
      {
        bank.add(rs1.getString("bank_name"));
      }
      seo1.setDataArray(bank);
  }catch(SQLException se){}    
        finally{
       try{
         if(rs!=null){rs.close();}
         if(rs1!=null){rs1.close();}
         if(psmt!=null){psmt.close();} 
         if(psmt1!=null){psmt1.close();} 
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }  
  
  return seo1;
}

public int entryCounFee(SchoolEO seo,java.sql.Date depositeDate)
{
     
    int i=0;
    Connection con=null;
      try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
      
      try
      {
         String qr="select count(*) as cnt from stud_draft where session=? and srnum=?";
         psmt1=con.prepareStatement(qr);
         psmt1.setString(1, seo.getSession());
         psmt1.setString(2, seo.getRegistNo());
         rs1=psmt1.executeQuery();
         if(rs1.next())
         {
             i=rs1.getInt("cnt");
             
         }
//         if(i!=0)
//         {
//             i=1;
//         }
//         else{
         
//         long rcpt=0;
//         String str="select max(receipt_no) as rcpt from stud_draft";
//           psmt2=con.prepareStatement(str);
//           rs2=psmt2.executeQuery();
//           if(rs2.next())
//           {
//            rcpt=rs2.getLong("rcpt");  
//            rcpt=rcpt+1;
//           }
         
         ArrayList ar=new ArrayList();
      ArrayList ar1=new ArrayList();
      ArrayList ar2=new ArrayList();
      ArrayList ar3=new ArrayList();
      ar=seo.getDataArray();
      ar1=seo.getDataArray1();
      ar2=seo.getDataArray2();
      ar3=seo.getDataArray3();
        String qr1="insert into stud_draft(srnum,session,draft_no,date,bank_name,amount,deposite_date,receipt_no,status,type,sname,updation,batch,session_sem)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
       psmt=con.prepareStatement(qr1);
        for(int j=0;j<2;j++)
       {
          
           if(Double.parseDouble(ar3.get(j).toString())!=0.0)
           {
               psmt.setString(1, seo.getRegistNo());
               psmt.setString(2, seo.getSession());
               psmt.setString(3, ar.get(j).toString());
               psmt.setString(4, ar1.get(j).toString());
               psmt.setString(5, ar2.get(j).toString());
               psmt.setDouble(6, Double.parseDouble(ar3.get(j).toString()));
               psmt.setDate(7, depositeDate);
               psmt.setLong(8, seo.getFeeReceipt());
               psmt.setString(9, "paid");
               psmt.setString(10, "counselling");
               psmt.setString(11, seo.getSname());
               psmt.setString(12, "unchecked");
               psmt.setString(13, seo.getBatch());
               psmt.setString(14, seo.getSession_sem());
               psmt.addBatch();
           }
       }
       psmt.executeBatch();
//      }
}catch(SQLException se){System.out.println("hiiii: "+se.getMessage());}    
        finally{
       try{
         if(rs!=null){rs.close();}
         if(rs1!=null){rs1.close();}
          if(rs2!=null){rs2.close();}
         if(psmt!=null){psmt.close();} 
         if(psmt1!=null){psmt1.close();} 
         if(psmt2!=null){psmt2.close();} 
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){System.out.println("hello: "+se.getMessage());}
      }  
    return i;
}

public ArrayList retCounsFee(SchoolEO seo)
{
    ArrayList al=new ArrayList();
    SchoolEO seo1=null;
    Connection con=null;
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
      try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
      
      try
      {
        String qr="select * from stud_draft where session=? and session_sem=? and srnum=? and status=?";
        psmt=con.prepareStatement(qr);
        psmt.setString(1,seo.getSession());
        psmt.setString(2,seo.getSession_sem());
        psmt.setString(3, seo.getRegistNo());
        psmt.setString(4, "paid");
        rs=psmt.executeQuery();
        while(rs.next())
        {
            seo1=new SchoolEO();
            seo1.setSession(rs.getString("session"));
            seo1.setSession_sem(rs.getString("session_sem"));
            seo1.setRwid(rs.getLong("rwid"));
            seo1.setSrnum(rs.getString("srnum"));
            seo1.setBankname(rs.getString("bank_name"));
            seo1.setDdate(rs.getString("date"));
            seo1.setDdno(rs.getString("draft_no"));
            seo1.setDdamount(rs.getDouble("amount"));
            seo1.setStatus(rs.getString("status"));
            seo1.setFeeReceipt(rs.getLong("receipt_no"));
               if(rs.getDate("deposite_date")!=null&&!rs.getDate("deposite_date").equals("")){
                 seo1.setDateofadd(sdf.format(rs.getDate("deposite_date")));  
               }
//               System.out.println("hiiiiHeloo "+seo1.getDateofadd());
             al.add(seo1);
        }
//       System.out.println("hiiiiHeloo "+al.size());
      }catch(SQLException se){}    
        finally{
       try{
         if(rs!=null){rs.close();}
         if(rs1!=null){rs1.close();}
         if(psmt!=null){psmt.close();} 
         if(psmt1!=null){psmt1.close();} 
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }
      
   return al; 
}


public ArrayList retRefundedFeeDetail(SchoolEO seo)
{
    ArrayList al=new ArrayList();
    SchoolEO seo1=null;
    Connection con=null;
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
      try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
      
      try
      {
        String qr="select * from stud_draft where session=? and srnum=?";
        psmt=con.prepareStatement(qr);
        psmt.setString(1,seo.getSession());
        psmt.setString(2, seo.getRegistNo());
        rs=psmt.executeQuery();
        while(rs.next())
        {
             seo1=new SchoolEO();
             seo1.setRwid(rs.getLong("rwid"));
            seo1.setSrnum(rs.getString("srnum"));
            seo1.setBankname(rs.getString("bank_name"));
            seo1.setDdate(rs.getString("date"));
            seo1.setDdno(rs.getString("draft_no"));
            seo1.setDdamount(rs.getDouble("amount"));
            seo1.setStatus(rs.getString("status"));
            seo1.setFeeReceipt(rs.getLong("receipt_no"));
               if(rs.getDate("deposite_date")!=null&&!rs.getDate("deposite_date").equals("")){
                 seo1.setDateofadd(sdf.format(rs.getDate("deposite_date")));  
               }
//               System.out.println("hiiiiHeloo "+seo1.getDateofadd());
             al.add(seo1);
        }
       
      }catch(SQLException se){}    
        finally{
       try{
         if(rs!=null){rs.close();}
         if(rs1!=null){rs1.close();}
         if(psmt!=null){psmt.close();} 
         if(psmt1!=null){psmt1.close();} 
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }
      
   return al; 
}

public long refundAmount(SchoolEO seo)
{
    long rtn=0;
    int cn=0;
    Connection con=null;
    try{
        Dataconnectivity dc=new Dataconnectivity();
        con=dc.Dataconnect();
    }catch(Exception e){}
    
    try{
        
        String qry="select count(*) as cnt from stud_draft where session=? and session_sem=? and srnum=? and status=?";
        psmt2=con.prepareStatement(qry);
        psmt2.setString(1, seo.getSession());
        psmt2.setString(2, seo.getSession_sem());
        psmt2.setString(3, seo.getRegistNo());
        psmt2.setString(4, "paid");
        rs2=psmt2.executeQuery();
        if(rs2.next())
        {
          cn=rs2.getInt("cnt");  
        }
        if(cn!=0){
        String qr1="select max(return_no) as rtn from stud_draft";
        psmt1=con.prepareStatement(qr1);
        rs1=psmt1.executeQuery();
        if(rs1.next())
        {
            if(rs1.getString("rtn")!=null)
            {
                rtn=Long.parseLong(rs1.getString("rtn"))+1;
            }
            else
            {
                rtn=rtn+1;
            }
        }
        
        
        String qr="update stud_draft set status=?, return_no=? where session=? and session_sem=? and srnum=? and status=?";
        psmt=con.prepareStatement(qr);
        psmt.setString(1, "refunded");
        psmt.setLong(2, rtn);
        psmt.setString(3, seo.getSession());
        psmt.setString(4, seo.getSession_sem());
        psmt.setString(5, seo.getRegistNo());
        psmt.setString(6, "paid");
        psmt.executeUpdate();
        
        }
        else
        {
            rtn=0;
        }
        
        
    }catch(Exception e){ System.out.println("Helllooo "+e.getMessage());}
    finally{
       try{
         if(rs!=null){rs.close();}
         if(rs1!=null){rs1.close();}
         if(psmt!=null){psmt.close();} 
         if(psmt1!=null){psmt1.close();} 
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }
    return rtn;
}

public long genReceiptNo(){
    long rcpt=0;
    Connection con=null;
    try{
        Dataconnectivity dc=new Dataconnectivity();
        con=dc.Dataconnect();
    }catch(Exception e){}
    try{
      String qr="select max(receipt_no) as rcno from stud_draft"; 
      psmt=con.prepareStatement(qr);
      rs=psmt.executeQuery();
      if(rs.next()){
          rcpt=rs.getLong("rcno")+1;
      }
    }catch(Exception e){}
    finally{
        try{
            if(rs!=null){rs.close();}
            if(psmt!=null){psmt.close();}
            if(con!=null){con.close();}
        }catch(Exception ee){}
    } 
    return rcpt;
}

public SchoolEO retFieldnameOfFeeHeads(SchoolEO seo)
{
    ArrayList ar=new ArrayList();
    ArrayList ar1=new ArrayList();
    ArrayList ar2=new ArrayList();
    ArrayList ar3=new ArrayList();
    HashMap hm=new HashMap();
    HashMap hm1=new HashMap();
    HashMap hm2=new HashMap();
    Connection con=null;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
    
    try{
        String qr="";
        if(seo.getHeads_cat().equals("ANY"))
            qr="select heads,field_name,heads_cat from feeheads order by heads_cat desc";
        else
            qr="select heads,field_name,heads_cat from feeheads where heads_cat='"+seo.getHeads_cat()+"'";
        
//        System.out.println("qr: "+qr);
        psmt=con.prepareStatement(qr);
        rs=psmt.executeQuery();
        while(rs.next())
        {
            ar.add(rs.getString("field_name"));
            ar3.add(rs.getString("heads"));
            hm.put(rs.getString("field_name"), rs.getString("heads"));
            hm2.put(rs.getString("heads"), rs.getString("heads_cat"));
        }
        
        String qry1="select count(distinct heads) as cnt, heads_cat from feeheads group by heads_cat order by heads_cat desc";
       psmt1=con.prepareStatement(qry1);
      rs1=psmt1.executeQuery(); 
      while(rs1.next()){
          ar1.add(rs1.getInt("cnt"));
          ar2.add(rs1.getString("heads_cat"));
      hm1.put(rs1.getString("heads_cat"), rs1.getInt("cnt"));
      }
      if(seo.getHeads_cat().equals("UNIVERSITY DUES")||seo.getHeads_cat().equals("ANY"))
      {
        ar3.add("PROGRAMME FEE");
        ar3.add("INSTITUTION FEE");
        ar3.add("EXTRA");
        hm2.put("PROGRAMME FEE", "UNIVERSITY DUES");
        hm2.put("INSTITUTION FEE", "UNIVERSITY DUES");
        hm2.put("EXTRA", "UNIVERSITY DUES");      
      }
        seo.setDataArray(ar);
        seo.setDataArray1(ar1);
        seo.setDataArray2(ar2);
        seo.setDataArray3(ar3);
        seo.setDataMap(hm);
        seo.setDataMap1(hm1);
        seo.setDataMap2(hm2);
//       System.out.println(hm1);
    }catch(Exception e){}
    finally{
       try{
         if(rs!=null){rs.close();}
         if(rs1!=null){rs1.close();}
         if(psmt!=null){psmt.close();} 
         if(psmt1!=null){psmt1.close();} 
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }
    
    return seo;
}

public SchoolEO retFeeHeadwiseFromStud_feeDetais(SchoolEO seo)
{
    HashMap hm=seo.getDataMap();
    HashMap hm3=new HashMap();
    Connection con=null;
  ArrayList fields=seo.getDataArray();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}
       double fee=0.0;
       
       String qr2="";      
       StringBuffer sb=new StringBuffer();
       sb=sb.append("select ");
       for(int i=0;i<fields.size();i++)
       {
           sb=sb.append("sum("+fields.get(i).toString()+") as "+fields.get(i).toString());
           if(i!=(fields.size()-1))
               sb=sb.append(",");
       }
       sb=sb.append(" from(");
       sb=sb.append("select ");
       for(int i=0;i<fields.size();i++)
       {
           sb=sb.append("sum("+fields.get(i).toString()+") as "+fields.get(i).toString());
           if(i!=(fields.size()-1))
               sb=sb.append(",");
       }
       sb=sb.append(" from stud_fee_detail where session='"+seo.getSession()+"'");
       if(!seo.getSession_sem().equals("Both"))
           sb=sb.append(" and session_sem='"+seo.getSession_sem()+"'");
       sb=sb.append(" and student_transfer ='NO'");
       
       sb=sb.append(" union select ");
       for(int i=0;i<fields.size();i++)
       {
           sb=sb.append("sum("+fields.get(i).toString()+") as "+fields.get(i).toString());
           if(i!=(fields.size()-1))
               sb=sb.append(",");
       }
       sb=sb.append(" from noduesed_student_amount where session='"+seo.getSession()+"'");
       if(!seo.getSession_sem().equals("Both"))
           sb=sb.append(" and session_sem='"+seo.getSession_sem()+"'");
       
       sb=sb.append(") as u");
      try{
         qr2=sb.toString();
//         System.out.println("headwise1: "+qr2);
      psmt2=con.prepareStatement(qr2);
      rs2=psmt2.executeQuery();
      if(rs2.next()){
          for(int i=0;i<fields.size();i++)
            {
                if(rs2.getString(fields.get(i).toString())!=null)
                    hm3.put(hm.get(fields.get(i)), rs2.getString(fields.get(i).toString()));
            }
      }
//System.out.println("headwise map1: "+hm3);      
 if((seo.getHeads_cat().equals("UNIVERSITY DUES")||seo.getHeads_cat().equals("ANY"))&&seo.getField().equals(""))
   {  
       double ex=0;
      if(!seo.getSession_sem().equals("Both"))
          qr2="select sum(self_finance_fee) as self,sum(extra) as extra,sum(adjstDraftTtAndFeeTt) as adjstDraftTtAndFeeTt from stud_fee_detail"
                  + " where session='"+seo.getSession()+"' and session_sem='"+seo.getSession_sem()+"' and student_transfer ='NO'";
      else
          qr2="select sum(self_finance_fee) as self,sum(extra) as extra,sum(adjstDraftTtAndFeeTt) as adjstDraftTtAndFeeTt from stud_fee_detail"
                  + " where session='"+seo.getSession()+"' and student_transfer ='NO'";
//      System.out.println("headwise2: "+qr2);
      psmt=con.prepareStatement(qr2);
      rs=psmt.executeQuery();
      if(rs.next()){
          hm3.put("PROGRAMME FEE", rs.getDouble("self"));
          ex=rs.getDouble("extra")+rs.getDouble("adjstDraftTtAndFeeTt");
      }
      rs.close();
      
      
      if(!seo.getSession_sem().equals("Both"))
          qr2="select sum(amount) as amount from sponsored_student where session='"+seo.getSession()+"' and session_sem='"+seo.getSession_sem()+"'";
      else
          qr2="select sum(amount) as amount from sponsored_student where session='"+seo.getSession()+"'";
      psmt=con.prepareStatement(qr2);
      rs=psmt.executeQuery();
      if(rs.next())
          hm3.put("INSTITUTION FEE", rs.getDouble("amount"));
      rs.close();
      
      
      if(!seo.getSession_sem().equals("Both"))
          qr2="select sum(fine) as fine from latefine_onfeeprocess where session='"+seo.getSession()+"' and session_sem='"+seo.getSession_sem()+"'";
      else
          qr2="select sum(fine) as fine from latefine_onfeeprocess where session='"+seo.getSession()+"'";
      psmt=con.prepareStatement(qr2);
      rs=psmt.executeQuery();
      if(rs.next())
          ex=ex+rs.getDouble("fine");
      
      if(!seo.getSession_sem().equals("Both"))
          qr2="select sum(amount) as amount from stud_other_inst where session='"+seo.getSession()+"' and session_sem='"+seo.getSession_sem()+"'"
                  + " and transfered='NO'";
      else
          qr2="select sum(amount) as amount from stud_other_inst where session='"+seo.getSession()+"' and transfered='NO'";
      psmt=con.prepareStatement(qr2);
      rs=psmt.executeQuery();
      if(rs.next())
          hm3.put("EXTRA", rs.getDouble("amount")+ex);
   }  
      seo.setDataMap3(hm3);
      }
      catch(SQLException se){}  
        finally{
       try{
         if(rs!=null){rs.close();}   
         if(psmt!=null){psmt.close();} 
         if(rs2!=null){rs2.close();} 
         if(psmt2!=null){psmt2.close();} 
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      } 
     return seo;   
}
//public void upPicFile(SchoolEO seo){
//    
//}
public String checkDraftNumInTable(String table,SchoolEO seo){
    String ddno="";
    Connection con=null;
    ArrayList ddlist=seo.getDataArray();
    ArrayList ddbnklist=seo.getDataArray2();
    try{
        Dataconnectivity dc=new Dataconnectivity();
        con=dc.Dataconnect();
    }catch(Exception e){}
    try{
      StringBuffer sb=new StringBuffer();
      sb=sb.append("select count(draft_no) as cnt from ");
      sb=sb.append(table);
      sb=sb.append(" where session=? and session_sem=? and draft_no=? and bank_name=?");
      if(seo.getStatus().equals("updating")){
          sb=sb.append(" and rwid<> ?");
      }
      ArrayList ar4=seo.getDataArray4();
      for(int i=0;i<ddlist.size();i++){
//        String qr="select count(draft_no) as cnt from "+table+" where session='"+seo.getSession()+"' and session_sem='"+seo.getSession_sem()+"' "
//                + "and draft_no='"+ddlist.get(i)+"' and bank_name='"+ddbnklist.get(i)+"'";
        psmt=con.prepareStatement(sb.toString());
        psmt.setString(1, seo.getSession());
        psmt.setString(2, seo.getSession_sem());
        psmt.setString(3, (String)ddlist.get(i));
        psmt.setString(4, (String)ddbnklist.get(i));
        if(seo.getStatus().equals("updating")){
          psmt.setLong(5, Long.parseLong(ar4.get(i).toString()));
      }
        rs=psmt.executeQuery();
        if(rs.next()){
          if(rs.getInt("cnt")!=0){
              ddno=ddlist.get(i).toString();
              break;
          }
        }
      }
    }catch(Exception e){}
    finally{
        try{
            if(rs!=null){rs.close();}
            if(psmt!=null){psmt.close();}
            if(con!=null){con.close();}
        }catch(Exception ee){}
    } 
    return ddno;
    
}
public static void main(String a[]){
//      MyMeth mm=new MyMeth();
//      SchoolEO seo=new SchoolEO();
//      System.out.println("RCNO: "+mm.genReceiptNo());
    
    String str="01010101011011101";
    char[] ch=str.toCharArray();
    int zeroCount=0;
    int oneCount=0;
    int zero=0;
    int one=0;
//    for(int i=0;i<ch.length;i++){
//        if(i!=ch.length){
        for(int j=0;j<ch.length;j++){
            if(ch[j]=='0'){
                System.out.println("zero: "+zero);
                if(one>=1){
                      oneCount=oneCount+1;
                      one=0;
                  }
                zero=zero+1;
            }
            else{
           //     System.out.println("zero: "+zero);
                if(zero>=1){
                    zeroCount=zeroCount+1;
                    zero=0;
                }
              if(ch[j]=='1'){
                    one=one+1;
                }  
              
              
               
            }
            
        }
        if(ch[ch.length-1]=='0'){
                zeroCount=zeroCount+1;
            }
            else
                oneCount=oneCount+1;
//        }
//    }
    System.out.println("zeroCount: "+zeroCount);
    System.out.println("oneCount: "+oneCount);
  }
}
