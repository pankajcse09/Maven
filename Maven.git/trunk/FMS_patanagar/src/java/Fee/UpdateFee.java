/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fee;

import EO.SchoolEO;
import com.myapp.struts.Dataconnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author kapil
 */
public class UpdateFee {
        PreparedStatement psmt=null;
PreparedStatement psmt1=null;
PreparedStatement psmt2=null;
PreparedStatement psmt3=null;
PreparedStatement psmt4=null;
PreparedStatement psmt5=null;
PreparedStatement psmt6=null;
ResultSet rs=null;
ResultSet rs1=null;    
ResultSet rs2=null;
ResultSet rs3=null;
ResultSet rs4=null;
ResultSet rs5=null;
ResultSet rs6=null;
    
public int chkAdvDraft(SchoolEO seo)
{
    int cnt=0;
    Connection con=null;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
    
    try
    {
        String qr="select count(*) as cnt from stud_draft where session=? and session_sem=? and srnum=? and status='paid'";
        psmt=con.prepareStatement(qr);
        psmt.setString(1, seo.getSession());
        psmt.setString(2, seo.getSession_sem());
        psmt.setString(3, seo.getRegistNo());
        rs=psmt.executeQuery();
        if(rs.next())
        {
            cnt=rs.getInt("cnt");
        }
    }catch(Exception e){}
    finally{
     try{
     if(rs!=null){rs.close();}
     if(psmt!=null){psmt.close();}
     if(con!=null){con.close();}
     }catch(Exception e){}
     }
    
    return cnt;
}

public void updateAdvDraft(SchoolEO seo)
{
    int cnt=0;
    Connection con=null;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
    
       ArrayList ar=new ArrayList();
      ArrayList ar1=new ArrayList();
      ArrayList ar2=new ArrayList();
      ArrayList ar3=new ArrayList();
      ArrayList ar4=new ArrayList();
      ar=seo.getDataArray();
      ar1=seo.getDataArray1();
      ar2=seo.getDataArray2();
      ar3=seo.getDataArray3();
      ar4=seo.getDataArray4();
    try
    {
        String qr="update stud_draft set bank_name=?, draft_no=?, date=?, amount=?, session_sem=? where session=? and srnum=? and rwid=?";
        psmt=con.prepareStatement(qr);
        for(int i=0;i<seo.getCounter();i++)
        {
         psmt.setString(1, ar2.get(i).toString());
        psmt.setString(2, ar.get(i).toString());
        psmt.setString(3, ar1.get(i).toString());
        psmt.setDouble(4, Double.parseDouble(ar3.get(i).toString()));
        psmt.setString(5, seo.getSession_sem());
        psmt.setString(6, seo.getSession());
        psmt.setString(7, seo.getRegistNo());
        psmt.setLong(8, Long.parseLong(ar4.get(i).toString()));
        psmt.addBatch();
        }
        psmt.executeBatch();
        
        String qr1="update stud_fee_draft set bank_name=?, draft_no=?, date=?, amount=?, session_sem=? where session=? and srnum=? and Stud_draft_rwid=?";
        psmt1=con.prepareStatement(qr1);
        for(int i=0;i<seo.getCounter();i++)
        {
         psmt1.setString(1, ar2.get(i).toString());
        psmt1.setString(2, ar.get(i).toString());
        psmt1.setString(3, ar1.get(i).toString());
        psmt1.setDouble(4, Double.parseDouble(ar3.get(i).toString()));
        psmt.setString(5, seo.getSession_sem());
        psmt.setString(6, seo.getSession());
        psmt1.setString(7, seo.getRegistNo());
         psmt1.setLong(8, Long.parseLong(ar4.get(i).toString()));
        psmt1.addBatch();
        }
        psmt1.executeBatch();
        
    }catch(Exception e){}
    finally{
     try{
     if(rs!=null){rs.close();}
     if(psmt!=null){psmt.close();}
     if(psmt1!=null){psmt1.close();}
     if(con!=null){con.close();}
     }catch(Exception e){}
     }
 }

public SchoolEO getStud_Id(SchoolEO seo)
{
    Connection con=null;
    SchoolEO seo1=new SchoolEO();
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
    
    try
    {
        String qr="select session, srnum, studname, fname, stud_id, rowid from studentregis where session=? and srnum=?";
        psmt=con.prepareStatement(qr);
        psmt.setString(1, seo.getSession());
        psmt.setString(2, seo.getSrnum());
        rs=psmt.executeQuery();
        if(rs.next())
        {
            seo1.setSession(rs.getString("session"));
            seo1.setSrnum(rs.getString("srnum"));
            seo1.setSname(rs.getString("studname"));
            seo1.setFname(rs.getString("fname"));
            seo1.setStud_id(rs.getString("stud_id"));
            seo1.setRowid(rs.getInt("rowid"));
        }
        
    }catch(Exception e){}
    finally{
     try{
     if(rs!=null){rs.close();}
     if(psmt!=null){psmt.close();}
     if(con!=null){con.close();}
     }catch(Exception e){}
     }
    return seo1;
 }

public void updateStud_Id(SchoolEO seo,String old_id)
{
    int cnt=0;
    Connection con=null;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
    
       
    try
    {
//        String qr="update stud_draft set stud_id=? where session=? and srnum=?";
//        String qr1="update stud_fee_draft set stud_id=? where session=? and srnum=?";
//        String qr2="update sub_feedata set stud_id=? where session=? and regist_no=?";
//        String qr3="update studentregis set stud_id=? where session=? and srnum=?";
        
        String qr="update stud_draft set stud_id=? where stud_id=?";
        String qr1="update stud_fee_draft set stud_id=? where stud_id=?";
        String qr2="update sub_feedata set stud_id=? where stud_id=?";
        String qr3="update studentregis set stud_id=? where stud_id=?";
        String qr4="update stud_fee_detail set stud_id=? where stud_id=?";
        
        psmt=con.prepareStatement(qr);
        psmt.setString(1, seo.getStud_id());
        psmt.setString(2, old_id);
//         psmt.setString(2, seo.getSession());
//        psmt.setString(3, seo.getSrnum());
        psmt.executeUpdate();
        
        psmt1=con.prepareStatement(qr1);
        psmt1.setString(1, seo.getStud_id());
        psmt1.setString(2, old_id);
//         psmt1.setString(2, seo.getSession());
//        psmt1.setString(3, seo.getSrnum());
        psmt1.executeUpdate();
        
        psmt2=con.prepareStatement(qr2);
       psmt2.setString(1, seo.getStud_id());
       psmt2.setString(2, old_id);
//       psmt2.setString(2, seo.getSession());
//        psmt2.setString(3, seo.getSrnum());
        psmt2.executeUpdate();
        
        psmt3=con.prepareStatement(qr3);
        psmt3.setString(1, seo.getStud_id());
        psmt3.setString(2, old_id);
//         psmt3.setString(2, seo.getSession());
//        psmt3.setString(3, seo.getSrnum());
//        psmt3.setInt(4, seo.getRowid());
        psmt3.executeUpdate();
        
        psmt4=con.prepareStatement(qr4);
        psmt4.setString(1, seo.getStud_id());
        psmt4.setString(2, old_id);
        psmt4.executeUpdate();
        
    }catch(Exception e){}
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
     if(con!=null){con.close();}
     }catch(Exception e){}
     }
 }

public SchoolEO getStud_Dt(SchoolEO seo)
{
    Connection con=null;
    SchoolEO seo1=null;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
    
    try
    {
//        String qr="select session, srnum, studname, fname, stud_id, rowid,degree,stud_type,icar,gate from studentregis where session=? and srnum=?";
        String qr="select session,srnum,studname,fname,stud_id,rowid,degree,stud_type,icar,gate,semester,batch from studentregis "
                + "where session=? and stud_id=?";
        psmt=con.prepareStatement(qr);
        psmt.setString(1, seo.getSession());
//        psmt.setString(2, seo.getSrnum());
        psmt.setString(2, seo.getStud_id());
//        System.out.println("Kapil: ");
        rs=psmt.executeQuery();
        if(rs.next())
        {
            seo1=new SchoolEO();
            seo1.setSession(rs.getString("session"));
            seo1.setSrnum(rs.getString("srnum"));
            seo1.setSname(rs.getString("studname"));
            seo1.setFname(rs.getString("fname"));
            seo1.setStud_id(rs.getString("stud_id"));
            seo1.setRowid(rs.getInt("rowid"));
            seo1.setDegree(rs.getString("degree"));
            seo1.setStud_type(rs.getString("stud_type"));
            seo1.setIcar(rs.getString("icar"));
            seo1.setGate(rs.getString("gate"));
            seo1.setSemester(rs.getString("semester"));
            seo1.setBatch(rs.getString("batch"));
        }
        
    }catch(Exception e){System.out.println("hello: "+e.getMessage());}
    finally{
     try{
     if(rs!=null){rs.close();}
     if(psmt!=null){psmt.close();}
     if(con!=null){con.close();}
     }catch(Exception e){}
     }
    return seo1;
 }

public void updateStud_Dt(SchoolEO seo)
{
    int cnt=0;
    Connection con=null;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
    
       
    try
    {
//        String qr2="update sub_feedata set classes=? where session=? and regist_no=?";
//        String qr3="update studentregis set degree=?,stud_type=?,icar=?,gate=? where session=? and srnum=?";
        String qr1="update stud_fee_detail set degree=? where stud_id=? and session=?";
        String qr2="update sub_feedata set classes=? where session=? and stud_id=?";
        String qr3="update studentregis set degree=?,stud_type=?,icar=?,gate=? where session=? and stud_id=?";
        String qr4="update stud_fee_draft set degree=? where stud_id=? and session=?";
        
        psmt1=con.prepareStatement(qr1);
        psmt1.setString(1, seo.getDegree());
        psmt1.setString(2, seo.getStud_id());
        psmt1.setString(3, seo.getSession());
        psmt1.executeUpdate();
        
        psmt2=con.prepareStatement(qr2);
       psmt2.setString(1, seo.getDegree());
       psmt2.setString(2, seo.getSession());
//        psmt2.setString(3, seo.getSrnum());
       psmt2.setString(3, seo.getStud_id());
        psmt2.executeUpdate();
        
        psmt3=con.prepareStatement(qr3);
        psmt3.setString(1, seo.getDegree());
        psmt3.setString(2, seo.getStud_type());
        psmt3.setString(3, seo.getIcar());
        psmt3.setString(4, seo.getGate());
         psmt3.setString(5, seo.getSession());
//        psmt3.setString(6, seo.getSrnum());
         psmt3.setString(6, seo.getStud_id());
//        psmt3.setInt(4, seo.getRowid());
        psmt3.executeUpdate();
        
        
        psmt1=con.prepareStatement(qr4);
        psmt1.setString(1, seo.getDegree());
        psmt1.setString(2, seo.getStud_id());
        psmt1.setString(3, seo.getSession());
        psmt1.executeUpdate();
        
    }catch(Exception e){System.out.println("hello: "+e.getMessage());}
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
     if(con!=null){con.close();}
     }catch(Exception e){}
     }
 }

public ArrayList getStudProgDraft(SchoolEO seo)
{
    int cnt=0;
    Connection con=null;
    SchoolEO seo1=new SchoolEO();
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
    
       ArrayList ar=new ArrayList();
      
    try{ 
       String qr5="select session,srnum,studname,fname,gender,degree,stud_type,category from studentregis where session=? and srnum=?";
     psmt5=con.prepareStatement(qr5);
     psmt5.setString(1, seo.getSession());    
    psmt5.setString(2, seo.getSrnum());
     rs=psmt5.executeQuery();
     if(rs.next()){
         seo1.setSession(rs.getString("session"));
       seo1.setSrnum(rs.getString("srnum"));
         seo1.setSname(rs.getString("studname"));
         seo1.setFname(rs.getString("fname")); 
         seo1.setGender(rs.getString("gender"));
//         seo1.setStud_id(rs.getString("stud_id"));
         seo1.setDegree(rs.getString("degree"));
         seo1.setStud_type(rs.getString("stud_type"));
         seo1.setCategory(rs.getString("category"));
//         System.out.println("hello.......");
     }
     ar.add(seo1);
       
   String qr6="select rwid,draft_no,date,bank_name,amount,type,receipt_no from stud_fee_draft where session=? and session_sem=? and srnum=? and type=?";     
   psmt=con.prepareStatement(qr6);
   psmt.setString(1, seo.getSession());
   psmt.setString(2, seo.getSession_sem());
   psmt.setString(3, seo.getSrnum());
   psmt.setString(4, "addmission fee");
   rs1=psmt.executeQuery();
   while(rs1.next()){
//       System.out.println("hello: "+seo1.getStud_id());
       seo1=new SchoolEO();
       seo1.setSession_sem(seo.getSession_sem());
       seo1.setRwid(rs1.getLong("rwid"));
       seo1.setDdno(rs1.getString("draft_no"));
       seo1.setDdate(rs1.getString("date"));
       seo1.setBankname(rs1.getString("bank_name"));
       seo1.setDdamount(rs1.getDouble("amount"));
       seo1.setFeeReceipt(rs1.getLong("receipt_no"));
//       System.out.println("KAPIL: ");
       ar.add(seo1);
   }
   
   
   }catch(SQLException se){}    
        finally{
       try{
         if(rs!=null){rs.close();}
         if(rs1!=null){rs1.close();}
         if(psmt!=null){psmt.close();} 
         if(psmt5!=null){psmt5.close();} 
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }  
    return ar;
 }

public ArrayList getStudPrDraft(SchoolEO seo)
{
    int cnt=0;
    Connection con=null;
    SchoolEO seo1=new SchoolEO();
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
    
       ArrayList ar=new ArrayList();
      
    try{ 
       String qr5="select session,srnum,studname,fname,gender,degree,stud_type,category from studentregis where session=? and srnum=?";
     psmt5=con.prepareStatement(qr5);
     psmt5.setString(1, seo.getSession());
    psmt5.setString(2, seo.getSrnum());
     rs=psmt5.executeQuery();
     if(rs.next()){
         seo1.setSession(rs.getString("session"));
       seo1.setSrnum(rs.getString("srnum"));
         seo1.setSname(rs.getString("studname"));
         seo1.setFname(rs.getString("fname")); 
         seo1.setGender(rs.getString("gender"));
//         seo1.setStud_id(rs.getString("stud_id"));
         seo1.setDegree(rs.getString("degree"));
         seo1.setStud_type(rs.getString("stud_type"));
         seo1.setCategory(rs.getString("category"));
         System.out.println("hello.......");
     }
     ar.add(seo1);
       
   String qr6="select rwid,draft_no,date,bank_name,amount,type,receipt_no from stud_fee_draft where session=? and srnum=?";     
   psmt=con.prepareStatement(qr6);
   psmt.setString(1, seo.getSession());
   psmt.setString(2, seo.getSrnum());
   
   rs1=psmt.executeQuery();
   while(rs1.next()){
//       System.out.println("hello: "+seo1.getStud_id());
       seo1=new SchoolEO();
       seo1.setRwid(rs1.getLong("rwid"));
       seo1.setDdno(rs1.getString("draft_no"));
       seo1.setDdate(rs1.getString("date"));
       seo1.setBankname(rs1.getString("bank_name"));
       seo1.setDdamount(rs1.getDouble("amount"));
       seo1.setFeeReceipt(rs1.getLong("receipt_no"));
//       System.out.println("KAPIL: ");
       ar.add(seo1);
   }
   
   
   }catch(SQLException se){}    
        finally{
       try{
         if(rs!=null){rs.close();}
         if(rs1!=null){rs1.close();}
         if(psmt!=null){psmt.close();} 
         if(psmt5!=null){psmt5.close();} 
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }  
    return ar;
 }

public ArrayList getStudFeeDetail(SchoolEO seo)
{
    ArrayList ar=new ArrayList();
    ArrayList ar1=new ArrayList();
    ArrayList ar2=new ArrayList();
    ArrayList ar3=new ArrayList();
    ArrayList ar4=new ArrayList();
    ArrayList al=new ArrayList();
    SchoolEO seo1=new SchoolEO();
    Connection con=null;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){} 
   try{ 
       String qr5="select session,srnum,studname,fname,gender,degree,stud_type,category from studentregis where session=? and srnum=?";
     psmt5=con.prepareStatement(qr5);
     psmt5.setString(1, seo.getSession());
    psmt5.setString(2, seo.getSrnum());
     rs=psmt5.executeQuery();
     if(rs.next()){
          seo1.setSession(rs.getString("session"));
         seo1.setSrnum(rs.getString("srnum"));
         seo1.setSname(rs.getString("studname"));
         seo1.setFname(rs.getString("fname")); 
         seo1.setGender(rs.getString("gender"));
//         seo1.setStud_id(rs.getString("stud_id"));
         seo1.setDegree(rs.getString("degree"));
         seo1.setStud_type(rs.getString("stud_type"));
         seo1.setCategory(rs.getString("category"));
//         System.out.println("hello.......");
     }
       
   String qr6="select draft_no,date,bank_name,amount,type,receipt_no from stud_fee_draft where session=? and session_sem=? and srnum=?";     
   psmt=con.prepareStatement(qr6);
   psmt.setString(1, seo.getSession());
   psmt.setString(2, seo.getSession_sem());
   psmt.setString(3, seo.getSrnum());
   rs1=psmt.executeQuery();
   while(rs1.next()){
//       System.out.println("hello: "+seo1.getStud_id());
       ar.add(rs1.getString("draft_no"));
       ar1.add(rs1.getString("date"));
       ar2.add(rs1.getString("bank_name"));
       ar3.add(rs1.getDouble("amount"));
       ar4.add(rs1.getString("type"));
       seo1.setFeeReceipt(rs1.getLong("receipt_no"));
//       System.out.println("KAPIL: ");
   }
   seo1.setDataArray(ar);
   seo1.setDataArray1(ar1);
   seo1.setDataArray2(ar2);
   seo1.setDataArray3(ar3);
   seo1.setDataArray4(ar4);
   al.add(seo1);
   }catch(SQLException se){}    
        finally{
       try{
         if(rs!=null){rs.close();}
         if(rs1!=null){rs1.close();}
         if(psmt!=null){psmt.close();} 
         if(psmt5!=null){psmt5.close();} 
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      }  
    
    return al;
}

public void updateProgDraft(SchoolEO seo, String or_session_sem) throws Exception
{
    int cnt=0;
    Connection con=null;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  con.setAutoCommit(false);
  }catch(Exception e){}
    
       ArrayList ar=seo.getDataArray();
      ArrayList ar1=seo.getDataArray1();
      ArrayList ar2=seo.getDataArray2();
      ArrayList ar3=seo.getDataArray3();
      ArrayList ar4=seo.getDataArray4();
    try
    {
        String qr="update stud_fee_draft set bank_name=?, draft_no=?, date=?, amount=?, session_sem=? where session=? and srnum=? and rwid=? and type=?";
        psmt=con.prepareStatement(qr);
        for(int i=0;i<seo.getCounter();i++)
        {
            psmt.setString(1, ar2.get(i).toString());
            psmt.setString(2, ar.get(i).toString());
            psmt.setString(3, ar1.get(i).toString());
            psmt.setDouble(4, Double.parseDouble(ar3.get(i).toString()));
            psmt.setString(5, seo.getSession_sem());
            psmt.setString(6, seo.getSession());
            psmt.setString(7, seo.getRegistNo());
            psmt.setLong(8, Long.parseLong(ar4.get(i).toString()));
            psmt.setString(9, "addmission fee");
            psmt.addBatch();
        }
        psmt.executeBatch();
        
        if(psmt!=null){psmt.close();}
        
        qr="update stud_fee_draft set session_sem=? where session=? and session_sem=? and srnum=? and type=?";
        psmt=con.prepareStatement(qr);
        psmt.setString(1, seo.getSession_sem());
        psmt.setString(2, seo.getSession());
        psmt.setString(3, or_session_sem);
        psmt.setString(4, seo.getRegistNo());
        psmt.setString(5, "counselling");
        psmt.executeUpdate();
        
        if(psmt!=null){psmt.close();}
        
        qr="update stud_draft set session_sem=? where session=? and session_sem=? and srnum=?";
        psmt=con.prepareStatement(qr);
        psmt.setString(1, seo.getSession_sem());
        psmt.setString(2, seo.getSession());
        psmt.setString(3, or_session_sem);
        psmt.setString(4, seo.getRegistNo());
        psmt.executeUpdate();
        
        if(psmt!=null){psmt.close();}
        
        qr="update sub_feedata set session_sem=? where session=? and session_sem=? and regist_no=?";
        psmt=con.prepareStatement(qr);
        psmt.setString(1, seo.getSession_sem());
        psmt.setString(2, seo.getSession());
        psmt.setString(3, or_session_sem);
        psmt.setString(4, seo.getRegistNo());
        psmt.executeUpdate();
        
        if(psmt!=null){psmt.close();}
        
        qr="update stud_fee_detail set session_sem=? where session=? and session_sem=? and srnum=?";
        psmt=con.prepareStatement(qr);
        psmt.setString(1, seo.getSession_sem());
        psmt.setString(2, seo.getSession());
        psmt.setString(3, or_session_sem);
        psmt.setString(4, seo.getRegistNo());
        psmt.executeUpdate();
        
        con.commit();
    }catch(Exception e){
        con.rollback();
        throw e;
    }
    finally{
     try{
     if(rs!=null){rs.close();}
     if(psmt!=null){psmt.close();}
     if(con!=null){con.close();}
     }catch(Exception e){}
     }
 }
    
public void insertProgDraft(SchoolEO seo,java.sql.Date depositeDate,double fee_tot)
{
    int cnt=0;
    double total_fee=0.0;
    Connection con=null;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
    
    try
    {
        String qr="select fee_total from sub_feedata where session=? and regist_no=?";
        psmt=con.prepareStatement(qr);
        psmt.setString(1, seo.getSession());
        psmt.setString(2, seo.getRegistNo());
        rs=psmt.executeQuery();
        if(rs.next()){
            total_fee=fee_tot+rs.getDouble("fee_total");
        }
    ArrayList ar=new ArrayList();
      ArrayList ar1=new ArrayList();
      ArrayList ar2=new ArrayList();
      ArrayList ar3=new ArrayList();
      ArrayList ar4=new ArrayList();
      ArrayList ar5=new ArrayList();
      ar=seo.getDataArray();
      ar1=seo.getDataArray1();
      ar2=seo.getDataArray2();
      ar3=seo.getDataArray3();
      ar4=seo.getDataArray4();
      ar5=seo.getDataArray5();
      String qr6="insert into stud_fee_draft(session,srnum,draft_no,date,bank_name,amount,status,type,sname,deposite_date,receipt_no,Stud_draft_rwid,updation,stud_id)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
       psmt6=con.prepareStatement(qr6);
       for(int i=0;i<4;i++)
       {
         if(i<ar.size()){
//             System.out.println("hello: "+seo.getRegistNo());
             psmt6.setString(1, seo.getSession());
               psmt6.setString(2, seo.getRegistNo());
               psmt6.setString(3, ar.get(i).toString());
               psmt6.setString(4, ar1.get(i).toString());
               psmt6.setString(5, ar2.get(i).toString());
               psmt6.setDouble(6, Double.parseDouble(ar3.get(i).toString()));
//               System.out.println("hello kapil: "+ar.get(i));
               psmt6.setString(7, "paid");
               psmt6.setString(8, ar4.get(i).toString());
                psmt6.setString(9, seo.getSname());
                psmt6.setDate(10, depositeDate);
                psmt6.setLong(11, seo.getFeeReceipt());
                psmt6.setLong(12, Long.parseLong(ar5.get(i).toString()));
                psmt6.setString(13, "unchecked");
                psmt6.setString(14, seo.getStud_id());
               psmt6.addBatch();
         }
       }
       psmt6.executeBatch();
       
       String qr1="update sub_feedata set fee_total=? where session=? and regist_no=?";
       psmt1=con.prepareStatement(qr1);
       psmt1.setDouble(1, total_fee);
        psmt1.setString(2, seo.getSession());
        psmt1.setString(3, seo.getRegistNo());
        psmt1.executeUpdate();
        
    }catch(Exception e){ System.out.println("hello kapil: "+e.getMessage());}
    finally{
     try{
    if(rs!=null){rs.close();}   
         if(rs3!=null){rs3.close();} 
         if(psmt!=null){psmt.close();} 
          if(psmt1!=null){psmt1.close();}
         if(psmt2!=null){psmt2.close();} 
         if(psmt3!=null){psmt3.close();} 
         if(psmt4!=null){psmt4.close();} 
         if(psmt6!=null){psmt6.close();} 
         if(con!=null){con.close();}  
     }catch(Exception e){}
     }
 }

public double feeSubmittedAmount(SchoolEO seo)
{
    double total_fee=0.0;
    Connection con=null;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
    
    try
    {
        String qr="select fee_total from sub_feedata where stud_id=? and session=? and session_sem=?";
//        String qr="select sf.fee_total,sd.amount from sub_feedata as sf join stud_draft as sd on sf.stud_id=sd.stud_id where sf.stud_id=?"
//                + " and sf.session=? and sf.session_sem=?";
        psmt=con.prepareStatement(qr);
        psmt.setString(1, seo.getStud_id());
        psmt.setString(2, seo.getSession());
        psmt.setString(3, "I");
        rs=psmt.executeQuery();
        if(rs.next()){
            total_fee=rs.getDouble("fee_total");
         }
    }catch(Exception e){ System.out.println("hello kapil: "+e.getMessage());}
    finally{
     try{
         if(rs!=null){rs.close();}   
         if(psmt!=null){psmt.close();} 
         if(con!=null){con.close();}  
     }catch(Exception e){}
     }  
    return total_fee;
}
 
public double feeSubmittedAdvAmount(SchoolEO seo)
{
    double adv=0.0;
    Connection con=null;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
    
    try
    {
//        String qr="select fee_total from sub_feedata where stud_id=? and session=? and session_sem=?";
        String qr="select sum(amount) as amount from stud_draft where stud_id=? and session=? and session_sem=?";
        psmt=con.prepareStatement(qr);
        psmt.setString(1, seo.getStud_id());
        psmt.setString(2, seo.getSession());
        psmt.setString(3, "I");
        rs=psmt.executeQuery();
        if(rs.next()){
            if(rs.getString("amount")!=null&&!rs.getString("amount").equals(""))
                adv=rs.getDouble("amount");
        }
    }catch(Exception e){ System.out.println("hello kapil: "+e.getMessage());}
    finally{
     try{
         if(rs!=null){rs.close();}   
         if(psmt!=null){psmt.close();} 
         if(con!=null){con.close();}  
     }catch(Exception e){}
     }  
    return adv;
}
 
public long returnFeeReceipt(SchoolEO seo)
{
    long feereceipt=0;
    Connection con=null;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
    
    try
    {
    String qr4="select fee_receipt from sub_feedata where session='"+seo.getSession()+"' and stud_id='"+seo.getStud_id()+"'";
      psmt=con.prepareStatement(qr4);
      rs=psmt.executeQuery();  
      if(rs.next()){ 
        feereceipt=rs.getLong("fee_receipt");    
      }
    }catch(Exception e){ System.out.println("hello kapil: "+e.getMessage());}
    finally{
     try{
         if(rs!=null){rs.close();}   
         if(psmt!=null){psmt.close();} 
         if(con!=null){con.close();}  
     }catch(Exception e){}
     }  
    return feereceipt;
}

public void updateStud_fee_detail(SchoolEO seo,SchoolEO se)
{
   Connection con=null;
     ArrayList ar=se.getDataArray();
     ArrayList ar1=new ArrayList();
     HashMap hm=se.getDataMap();  
     
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
  
  try
  {
      StringBuffer sb=new StringBuffer();
      sb=sb.append("update stud_fee_detail set self_finance_fee=?");
      for(int i=0;i<ar.size();i++)
      {
          sb=sb.append(",");
          sb=sb.append(ar.get(i).toString());
          sb=sb.append("=?");
      }
      sb=sb.append(" where stud_id=? and session=? and session_sem=?");
      
//      System.out.println(sb.toString());
      psmt=con.prepareStatement(sb.toString());
      psmt.setDouble(1, seo.getPamount());
      
      int j=2;
      for(int i=0;i<ar.size();i++)
      {
          try{
          psmt.setDouble(j, Double.parseDouble(hm.get(ar.get(i)).toString()));
          }catch(Exception ee)
          {
              psmt.setDouble(j, new Double(0));
          }
          j=j+1;
       }
      psmt.setString(j, seo.getStud_id());
      psmt.setString(j+1, seo.getSession());
      psmt.setString(j+2, "I");
      psmt.executeUpdate();
  }catch(Exception e){System.out.println("Ex: "+e.getMessage());}
  finally{
       try{
         if(rs!=null){rs.close();}           
         if(psmt!=null){psmt.close();}       
         if(con!=null){con.close();}  
       }   
       catch(SQLException see){}
      } 
}

public void insertAdjustmentInStud_fee_draft(SchoolEO seo)
{
    Connection con=null;   
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
  
  try
  {
      ArrayList ar=new ArrayList();
      ArrayList ar1=new ArrayList();
      ArrayList ar2=new ArrayList();
      ArrayList ar3=new ArrayList();
      
      ar=seo.getDataArray();
      ar1=seo.getDataArray1();
      ar2=seo.getDataArray2();
      ar3=seo.getDataArray3();
      
      String qr6="insert into stud_fee_draft(session,srnum,draft_no,date,bank_name,amount,status,type,sname,deposite_date,receipt_no,"
              + "Stud_draft_rwid,updation,degree,semester,batch,stud_id,session_sem) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
       psmt=con.prepareStatement(qr6);
       for(int i=0;i<ar.size();i++)
       {
         
             psmt.setString(1, seo.getSession());
               psmt.setString(2, seo.getSrnum());
               psmt.setString(3, ar.get(i).toString());
               psmt.setString(4, ar1.get(i).toString());
               psmt.setString(5, ar2.get(i).toString());
               psmt.setDouble(6, Double.parseDouble(ar3.get(i).toString()));
//               System.out.println("hello kapil: "+ar.get(i));
               psmt.setString(7, "paid");
               psmt.setString(8, "addmission fee");
                psmt.setString(9, seo.getSname());
                psmt.setDate(10, new java.sql.Date(new java.util.Date().getTime()));
                psmt.setLong(11, seo.getFeeReceipt());
                psmt.setLong(12, 0);
                psmt.setString(13, "unchecked");
                psmt.setString(14, seo.getDegree());
                psmt.setString(15, seo.getSemester());
                psmt.setString(16, seo.getBatch());
                psmt.setString(17, seo.getStud_id());
                psmt.setString(18, seo.getSession_sem());
               psmt.addBatch();
         
       }
       psmt.executeBatch();
  }catch(Exception e){System.out.println("Ex: "+e.getMessage());}
  finally{
       try{
         if(rs!=null){rs.close();}           
         if(psmt!=null){psmt.close();}       
         if(con!=null){con.close();}  
       }   
       catch(SQLException see){}
      } 
}

public void insertDetailsOfChange(SchoolEO seo,String prv_degree,double change,String prv_stud_type,String icar_o)
{
    Connection con=null;   
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
  
  try
  {
      String qr6="insert into detailsofchange(session,session_sem,stud_id,prv_degree,nw_degree,stud_type_old,amount,icar_old) values(?,?,?,?,?,?,?,?)";
       psmt=con.prepareStatement(qr6);
       
         
             psmt.setString(1, seo.getSession());
               psmt.setString(2, "I");
               psmt.setString(3, seo.getStud_id());
               psmt.setString(4, prv_degree);
               psmt.setString(5, seo.getDegree());
               psmt.setString(6, prv_stud_type);
//               System.out.println("hello kapil: "+ar.get(i));
               psmt.setDouble(7, change);
               psmt.setString(8, icar_o);
            psmt.executeUpdate();
  }catch(Exception e){System.out.println("Ex: "+e.getMessage());}
  finally{
       try{
         if(rs!=null){rs.close();}           
         if(psmt!=null){psmt.close();}       
         if(con!=null){con.close();}  
       }   
       catch(SQLException see){}
      } 
}

public void updateSub_feedata(SchoolEO seo)
{
   Connection con=null;
     try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
  
  try
  {
      String qr6="update sub_feedata set fee_total=? where stud_id=? and session=? and session_sem=?";
      
      psmt=con.prepareStatement(qr6);
      psmt.setDouble(1, seo.getFeeTotal());
      psmt.setString(2, seo.getStud_id());
      psmt.setString(3, seo.getSession());
      psmt.setString(4, "I");
      psmt.executeUpdate();
  }catch(Exception e){System.out.println("Ex: "+e.getMessage());}
  finally{
       try{
         if(rs!=null){rs.close();}           
         if(psmt!=null){psmt.close();}       
         if(con!=null){con.close();}  
       }   
       catch(SQLException see){}
      } 
}

public void updateStud_fee_detailHeadsZero(SchoolEO seo,HashMap<String,String> hm1)
{
   Connection con=null;
     
     
     
     Iterator<Map.Entry<String,String>> itr=  hm1.entrySet().iterator();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
  
  try
  {
      Map.Entry<String, String> element=null;
      StringBuffer sb=new StringBuffer();
      sb=sb.append("update stud_fee_detail set self_finance_fee=?");
      while(itr.hasNext())
        {
          element = itr.next();
          sb=sb.append(",");
          sb=sb.append(element.getValue());
          sb=sb.append("=?");
        }
      
      sb=sb.append(" where stud_id=? and session=? and session_sem=?");
      
//      System.out.println(sb.toString());
      psmt=con.prepareStatement(sb.toString());
      psmt.setDouble(1, new Double(0));
      
      int j=2;
      for(int i=0;i<hm1.size();i++)
        {
          try{
            psmt.setDouble(j, new Double(0));
          }catch(Exception ee)
          {
              psmt.setDouble(j, new Double(0));
          }
          j=j+1;
       }
      
      psmt.setString(j, seo.getStud_id());
      psmt.setString(j+1, seo.getSession());
      psmt.setString(j+2, "I");
      psmt.executeUpdate();
  }catch(Exception e){System.out.println("Exp: "+e.getMessage());}
  finally{
       try{
         if(rs!=null){rs.close();}           
         if(psmt!=null){psmt.close();}       
         if(con!=null){con.close();}  
       }   
       catch(SQLException see){}
      } 
}

}
