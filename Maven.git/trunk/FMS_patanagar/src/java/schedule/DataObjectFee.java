package schedule;

import java.sql.*;
import java.util.*;
import com.myapp.struts.Dataconnectivity;
import ActionClass.*;

public class DataObjectFee{   

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

  public int submitFeeHeads(JavaBeanExam jb){ 
   Connection con=null;    
   try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
//  System.out.println(e.getMessage());    
  } 
   JavaBeanExam jb1=new JavaBeanExam();
   int bn=0;
   int count=0; 
   int n=0;
   String qr2="";
   String qr="";
   try{
   qr="select count(heads)as cnt from feeheads where heads='"+jb.getFeeHead()+"'";
   psmt1=con.prepareStatement(qr);   
   rs1=psmt1.executeQuery();
   rs1.next();
   count=rs1.getInt("cnt");
   if(count==0){
       n=this.getAutoGenerateNumber("setrnum","feeheads_num");
       if(jb.getStud_type().equals("YES")){
   qr2="insert into feeheads(heads,head_type,head_ac,fee_type,heads_cat,stud_type,field_name)values(?,?,?,?,?,?,?)";   
   psmt2=con.prepareStatement(qr2);   
   psmt2.setString(1,jb.getFeeHead()); 
   psmt2.setString(2,jb.getHeadType()); 
   psmt2.setString(3,jb.getHeadAc()); 
   psmt2.setString(4,jb.getFeeType());
   if(!jb.getHeads_cat().equals("none")){
    psmt2.setString(5,jb.getHeads_cat());
   }
   else
       psmt2.setString(5,null);
   psmt2.setString(6,"Day Scholar");
   psmt2.setString(7,"field"+n);
//   psmt2.setString(8,jb.getSessions());
       }
       else{
           qr2="insert into feeheads(heads,head_type,head_ac,fee_type,heads_cat,field_name)values(?,?,?,?,?,?)";   
   psmt2=con.prepareStatement(qr2);   
   psmt2.setString(1,jb.getFeeHead()); 
   psmt2.setString(2,jb.getHeadType()); 
   psmt2.setString(3,jb.getHeadAc()); 
   psmt2.setString(4,jb.getFeeType());
   if(!jb.getHeads_cat().equals("none")){
    psmt2.setString(5,jb.getHeads_cat());
   }
   else
       psmt2.setString(5,null);
   psmt2.setString(6,"field"+n);
//   psmt2.setString(7,jb.getSessions());
       }
   psmt2.executeUpdate();
   
   this.updateAutoGenerateNumber("setrnum","feeheads_num",n);
   this.addFieldInTable("stud_fee_detail","field"+n);
   this.addFieldInTable("noduesed_student_Amount","field"+n);
   this.addFieldInTable("stud_fee_detail_excel","field"+n);
   }
   else{
   bn=count;    
   }
   }   
   catch(SQLException se){bn=-1;}
   finally{
    try{
    if(rs1!=null){rs1.close();}     
    if(psmt1!=null){psmt1.close();}  
    if(psmt2!=null){psmt2.close();}
    if(con!=null){con.close();} 
     }   
    catch(SQLException se){}
    }
  return bn;  
 }  
  
public int getAutoGenerateNumber(String table,String column)
{
    int n=0;
    Connection con=null;    
   try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
  try{
   String qr="select "+column+" from "+table;
   psmt1=con.prepareStatement(qr);   
   rs1=psmt1.executeQuery();
   if(rs1.next())
   {
       if(rs1.getInt(column)!=0)
       {
           n=rs1.getInt(column);
       }
       else
           n=1;
   }
   }   
   catch(SQLException se){}
   finally{
    try{
    if(rs1!=null){rs1.close();}     
    if(psmt1!=null){psmt1.close();}  
    if(psmt2!=null){psmt2.close();}
    if(con!=null){con.close();} 
     }   
    catch(SQLException se){}
    }
    return n;
}

public void updateAutoGenerateNumber(String table,String column,long n)
{
    Connection con=null;    
   try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
  try{
   String qr="update "+table+" set "+column+"=?";
   psmt1=con.prepareStatement(qr);   
   psmt1.setLong(1, n+1);
   psmt1.executeUpdate();
   }   
   catch(SQLException se){}
   finally{
    try{
    if(rs1!=null){rs1.close();}     
    if(psmt1!=null){psmt1.close();}  
    if(psmt2!=null){psmt2.close();}
    if(con!=null){con.close();} 
     }   
    catch(SQLException se){}
    }
}

public void addFieldInTable(String table,String field)
{
    Connection con=null;    
   try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){
  System.out.println(e.getMessage());    
  }
  try{
   String qr="alter table "+table+" add column "+field+" double DEFAULT 0";
    psmt1=con.prepareStatement(qr);   
    psmt1.executeUpdate();
   }   
   catch(SQLException se){}
   finally{
    try{
    if(rs1!=null){rs1.close();}     
    if(psmt1!=null){psmt1.close();}  
    if(psmt2!=null){psmt2.close();}
    if(con!=null){con.close();} 
     }   
    catch(SQLException se){}
    }
}


}
