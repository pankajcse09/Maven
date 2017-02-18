/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reports;

import Beans.JavaBean;
import EO.ReportsEO;
import EO.SchoolEO;
import com.myapp.struts.DataConnection;
import com.myapp.struts.Dataconnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author kapil
 */
public class ToDB {
    static Connection con=null;
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
    
    public ToDB()
    {
        try{        
       DataConnection dc1=new DataConnection();
       con=(Connection)dc1.Dataconnect();
        }
      catch(Exception e){}    
    }
    public ArrayList fee_Heads_byCat(SchoolEO seo){
//      try{        
//          DataConnection dc1=new DataConnection();
//          con=(Connection)dc1.Dataconnect();
//         }
//      catch(Exception e){} 
        String qr1="";
        
        qr1="select count(heads) as cnt,heads_cat from feeheads group by heads_cat order by heads_cat desc";
/*
        if(seo.getStud_type().equals("Hosteller")){
//      qr6="select distinct heads from feeheads where head_type<>'TREASURY'";
          qr1="select count(heads) as cnt,heads_cat from feeheads group by heads_cat order by heads_cat desc";
       }
      else
      {
          qr1="select count(heads) as cnt,heads_cat from feeheads where stud_type='Day Scholar' group by heads_cat order by heads_cat desc";
       }
       
       */
      ArrayList ar=new ArrayList();
      JavaBean jb=null;
      try{
       psmt1=con.prepareStatement(qr1);
       rs1=psmt1.executeQuery();
       while(rs1.next()){
           jb=new JavaBean();
           jb.setCount(rs1.getInt("cnt"));
           jb.setHeads_cat(rs1.getString("heads_cat"));
       ar.add(jb);    
       }
       }catch(SQLException se){System.out.println("hiii "+se.getMessage());}
      return ar;
    }

//  Used in StudentLadder    
public SchoolEO retFeeHeadsOfSTudentFee(SchoolEO seo)
{
    Connection con=null;
     ArrayList ar=new ArrayList();
     ArrayList ar1=new ArrayList();
     ArrayList ar3=new ArrayList();
     HashMap hm=new HashMap();
     
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
  
  try
  {
      String qr6="";
      String qr="";
  /*
   * if(seo.getStud_type().equals("Hosteller")){
//      qr6="select distinct heads from feeheads where head_type<>'TREASURY'";
          qr6="select distinct heads, heads_cat,field_name from feeheads order by heads_cat desc";
          qr="select distinct heads_cat from feeheads order by heads_cat desc";
      }
      else
      {
          qr6="select distinct heads, heads_cat,field_name from feeheads where stud_type='Day Scholar' order by heads_cat desc";
          qr="select distinct heads_cat from feeheads where stud_type='Day Scholar' order by heads_cat desc";
      }
      */
      qr6="select distinct heads, heads_cat,field_name from feeheads order by heads_cat desc";
          qr="select distinct heads_cat from feeheads order by heads_cat desc";
//      System.out.println("query1: "+qr6);
      psmt5=con.prepareStatement(qr6);
      rs5=psmt5.executeQuery(); 
      while(rs5.next()){
          ar1.add(rs5.getString("field_name"));
        ar.add(rs5.getString("heads"));
        hm.put(rs5.getString("heads"), rs5.getString("field_name"));
      }
      
      
       psmt=con.prepareStatement(qr);
      rs=psmt.executeQuery(); 
      while(rs.next()){
          ar3.add(rs.getString("heads_cat"));
        }
      seo.setDataArray1(ar1);
      seo.setDataArray(ar);
      seo.setDataArray3(ar3);
      seo.setDataMap(hm);
  }catch(Exception e){}
  finally{
       try{
         if(rs!=null){rs.close();}           
         if(psmt!=null){psmt.close();}       
         if(rs5!=null){rs5.close();}           
         if(psmt5!=null){psmt5.close();} 
      if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      } 
  return seo;
}    

//  Used in StudentLadder 
public ArrayList retFeeOfSTudentHeadwise(SchoolEO seo)
{
    Connection con=null;
     
     ArrayList ar=seo.getDataArray();
     ArrayList ar1=seo.getDataArray1();
     ArrayList fee;
     HashMap feemap;
     SchoolEO se;
     ArrayList seoList=new ArrayList();
     int count=0;
     
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
  
  try
  {
   /*   
      StringBuffer sb=new StringBuffer("select self_finance_fee");
      for(int i=0;i<ar1.size();i++)
      {
        sb=sb.append(",");
        sb=sb.append(ar1.get(i).toString());
      }
      sb=sb.append(" from stud_fee_detail where stud_id='"+seo.getStud_id()+"' and session='"+seo.getSession()+"'");
      */
      String sb="select * from stud_fee_detail where stud_id='"+seo.getStud_id()+"' and session='"+seo.getSession()+"'";
//      System.out.println("query1: "+sb.toString());
      psmt5=con.prepareStatement(sb);
      rs5=psmt5.executeQuery(); 
      while(rs5.next()){
          se=new SchoolEO();
          fee=new ArrayList();
          feemap=new HashMap();
          fee.add(rs5.getString("self_finance_fee"));
          feemap.put("self_finance_fee", rs5.getString("self_finance_fee"));
          for(int i=0;i<ar1.size();i++)
        {
            fee.add(rs5.getString(ar1.get(i).toString()));
            feemap.put(ar.get(i),rs5.getString(ar1.get(i).toString()));
//            System.out.println(feemap.get(ar.get(i)));
        }
          se.setBankname(rs5.getString("subm_bank"));
          se.setSubm_date(rs5.getDate("submission_date"));
          count=count+1;
          se.setCounter(count);
          se.setDataArray2(fee);
          se.setDataMap2(feemap);
          seoList.add(se);
          count=0;
      }
      
     
  }catch(Exception e){}
  finally{
       try{
         if(rs!=null){rs.close();}           
         if(psmt!=null){psmt.close();}       
         if(rs5!=null){rs5.close();}           
         if(psmt5!=null){psmt5.close();} 
      if(con!=null){con.close();}  
       }   
       catch(SQLException sExc){}
      } 
  return seoList;
}   

public SchoolEO getStudentDetails(SchoolEO seo)
{
    Connection con=null;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
  
  try
  {
      String qr="select * from studentregis where stud_id='"+seo.getStud_id()+"'";
      psmt=con.prepareStatement(qr);
      rs=psmt.executeQuery();
      if(rs.next())
      {
          seo.setSname(rs.getString("studname"));
          seo.setFname(rs.getString("fname"));
          seo.setDegree(rs.getString("degree"));
          seo.setBatch(rs.getString("batch"));
          seo.setStud_type(rs.getString("stud_type"));
          seo.setCounter(1);
      }
      else{
          seo.setCounter(0);
      }
  }catch(Exception e){System.out.println("Ex: "+e.getMessage());}
  finally{
       try{
         if(rs!=null){rs.close();}           
         if(psmt!=null){psmt.close();}       
         if(con!=null){con.close();}  
       }   
       catch(SQLException see){}
      } 
  return seo;
}

public SchoolEO getStudentDetails(String stud_id,String session)
{
    SchoolEO seo=new SchoolEO();
    Connection con=null;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
  
  try
  {
      String qr="select * from studentregis where stud_id='"+stud_id+"' and session='"+session+"'";
//      System.out.println(qr);
      psmt=con.prepareStatement(qr);
      rs=psmt.executeQuery();
      if(rs.next())
      {
          seo.setSname(rs.getString("studname"));
          seo.setFname(rs.getString("fname"));
          seo.setDegree(rs.getString("degree"));
          seo.setBatch(rs.getString("batch"));
          seo.setStud_type(rs.getString("stud_type"));
          seo.setCounter(1);
      }
      else{
          seo.setCounter(0);
      }
  }catch(Exception e){System.out.println("Ex: "+e.getMessage());}
  finally{
       try{
         if(rs!=null){rs.close();}           
         if(psmt!=null){psmt.close();}       
         if(con!=null){con.close();}  
       }   
       catch(SQLException see){}
      } 
  return seo;
}

public SchoolEO getStudentMonthlyFoodDetails(SchoolEO seo)
{
    Connection con=null;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
//  System.out.println("con: "+con);
  }catch(Exception e){}
  ArrayList food=new ArrayList();
  HashMap foodmap=new HashMap();
  HashMap datemap=new HashMap();
  try
  {
      String qr="select * from monthly_food where stud_id='"+seo.getStud_id()+"' and session='"+seo.getSession()+"'";
      psmt=con.prepareStatement(qr);
      rs=psmt.executeQuery();
      while(rs.next())
      {
        foodmap.put(rs.getString("month"), rs.getDouble("food_amount")); 
        datemap.put(rs.getString("month"), rs.getTimestamp("subm_date")); 
      }
  }catch(Exception e){System.out.println("Ex ToDB- getStudentMonthlyFoodDetails method : "+e.getMessage());}
  finally{
       try{
         if(rs!=null){rs.close();}           
         if(psmt!=null){psmt.close();}       
         if(con!=null){con.close();}  
       }   
       catch(SQLException see){}
      } 
  seo.setDataMap1(foodmap);
  seo.setDataMap3(datemap);
  return seo;
}

public ArrayList noduesedStudentList(SchoolEO seo){
    Connection con=null;
      try{        
          DataConnection dc1=new DataConnection();
          con=(Connection)dc1.Dataconnect();
         }
      catch(Exception e){} 
      SchoolEO se=null;
        String qr1="select sb.stud_id,sb.sname,sb.classes,sb.fee_total,lf.fine,sb.semester from sub_feedata sb left join latefine_onfeeprocess lf on "
                + "sb.stud_id=lf.stud_id where sb.nodues=? and sb.classes=? and sb.session=? and sb.session_sem=?";
        
      ArrayList ar=new ArrayList();
      try{
       psmt1=con.prepareStatement(qr1);
       psmt1.setString(1, "Done");
       psmt1.setString(2, seo.getDegree());
       psmt1.setString(3, seo.getSession());
       psmt1.setString(4, seo.getSession_sem());
       rs1=psmt1.executeQuery();
       while(rs1.next()){
           se=new SchoolEO();
           se.setStud_id(rs1.getString("stud_id"));
           se.setSname(rs1.getString("sname"));
           se.setDegree(rs1.getString("classes"));
           se.setSemester(rs1.getString("semester"));
           se.setFeeTotal(rs1.getDouble("fee_total"));
           if(rs1.getString("fine")!=null)
                se.setFine(rs1.getDouble("fine"));
       ar.add(se);    
       }
       }catch(SQLException s){System.out.println("hiii "+s.getMessage());}
      finally
      {
          try{
              if(rs1!=null){rs1.close();}
              if(psmt1!=null){psmt1.close();}
              if(con!=null){con.close();}
           }catch(Exception e){} 
      }
      return ar;
    }

public ArrayList transferedStudentList(String session,String degree){
    Connection con=null;
      try{        
          DataConnection dc1=new DataConnection();
          con=(Connection)dc1.Dataconnect();
         }
      catch(Exception e){} 
      ReportsEO re=null;
        String qr1="";
        if(!degree.equals("ALL"))
            qr1="select studname,fname,srnum,degree,transfer_to, ts.stud_id from transfered_student ts join studentregis st on ts.stud_id=st.stud_id"
                    + " where st.degree='"+degree+"' and ts.session='"+session+"'";
        else
            qr1="select studname,fname,srnum,degree,transfer_to, ts.stud_id from transfered_student ts join studentregis st on ts.stud_id=st.stud_id"
                    + " where ts.session='"+session+"'";
        
      ArrayList ar=new ArrayList();
      try{
       psmt1=con.prepareStatement(qr1);
       rs1=psmt1.executeQuery();
       while(rs1.next()){
           re=new ReportsEO();
           re.setStud_id(rs1.getString("stud_id"));
           re.setSname(rs1.getString("studname"));
           re.setDegree(rs1.getString("degree"));
           re.setFname(rs1.getString("fname"));
           re.setSrnum(rs1.getString("srnum"));
           re.setTransfered_to(rs1.getString("transfer_to"));
         ar.add(re);    
       }
       }catch(SQLException s){System.out.println("hiii "+s.getMessage());}
      finally
      {
          try{
              if(rs1!=null){rs1.close();}
              if(psmt1!=null){psmt1.close();}
              if(con!=null){con.close();}
           }catch(Exception e){} 
      }
      return ar;
    }

public ArrayList noduesStudentWithReason1(ReportsEO reo){
    Connection con=null;
      try{        
          DataConnection dc1=new DataConnection();
          con=(Connection)dc1.Dataconnect();
         }
      catch(Exception e){} 
      ReportsEO re=null;
        String qr1="";
        if(!reo.getReason().equals("")&&reo.getStatus().equals(""))
            qr1="select nsa.stud_id,batch,studname,fname,srnum,degree,amount,reason,nsa.status  from noduesed_student_amount nsa join studentregis st"
                    + " on nsa.stud_id=st.stud_id where st.degree='"+reo.getDegree()+"' and nsa.session_sem='"+reo.getSession_sem()+"'"
                    + " and nsa.session='"+reo.getSession()+"' and nsa.reason='"+reo.getReason()+"'";
        else if(reo.getReason().equals("")&&!reo.getStatus().equals(""))
            qr1="select nsa.stud_id,batch,studname,fname,srnum,degree,amount,reason,nsa.status  from noduesed_student_amount nsa join studentregis st"
                    + " on nsa.stud_id=st.stud_id where st.degree='"+reo.getDegree()+"' and nsa.session_sem='"+reo.getSession_sem()+"'"
                    + " and nsa.session='"+reo.getSession()+"' and nsa.status='"+reo.getStatus()+"'";
        else if(!reo.getReason().equals("")&&!reo.getStatus().equals(""))
            qr1="select nsa.stud_id,batch,studname,fname,srnum,degree,amount,reason,nsa.status  from noduesed_student_amount nsa join studentregis st"
                    + " on nsa.stud_id=st.stud_id where st.degree='"+reo.getDegree()+"' and nsa.session_sem='"+reo.getSession_sem()+"'"
                    + " and nsa.session='"+reo.getSession()+"' and nsa.reason='"+reo.getReason()+"' and nsa.status='"+reo.getStatus()+"'";
        else
            qr1="select nsa.stud_id,batch,studname,fname,srnum,degree,amount,reason,nsa.status  from noduesed_student_amount nsa join studentregis st"
                    + " on nsa.stud_id=st.stud_id where st.degree='"+reo.getDegree()+"' and nsa.session_sem='"+reo.getSession_sem()+"'"
                    + " and nsa.session='"+reo.getSession()+"'";
        
//        System.out.println(qr1);
        
      ArrayList ar=new ArrayList();
      try{
       psmt1=con.prepareStatement(qr1);
       rs1=psmt1.executeQuery();
       while(rs1.next()){
           re=new ReportsEO();
           re.setStud_id(rs1.getString("stud_id"));
           re.setSname(rs1.getString("studname"));
           re.setDegree(rs1.getString("degree"));
           re.setFname(rs1.getString("fname"));
           re.setSrnum(rs1.getString("srnum"));
           re.setAmount(rs1.getDouble("amount"));
           re.setBatch(rs1.getString("batch"));
           re.setReason(rs1.getString("reason"));
           re.setStatus(rs1.getString("status"));
         ar.add(re);    
       }
       }catch(SQLException s){System.out.println("hiii "+s.getMessage());}
      finally
      {
          try{
              if(rs1!=null){rs1.close();}
              if(psmt1!=null){psmt1.close();}
              if(con!=null){con.close();}
           }catch(Exception e){} 
      }
      return ar;
    }

public ArrayList noduesStudentWithReason2(ReportsEO reo){
    Connection con=null;
      try{        
          DataConnection dc1=new DataConnection();
          con=(Connection)dc1.Dataconnect();
         }
      catch(Exception e){} 
      ReportsEO re=null;
        String qr1="";
        if(!reo.getReason().equals("")&&reo.getStatus().equals(""))
            qr1="select nsa.stud_id,batch,studname,fname,srnum,degree,amount,reason,nsa.status  from noduesed_student_amount nsa join studentregis st"
                    + " on nsa.stud_id=st.stud_id where nsa.session_sem='"+reo.getSession_sem()+"' and nsa.session='"+reo.getSession()+"' and nsa.reason='"+reo.getReason()+"'";
        else if(reo.getReason().equals("")&&!reo.getStatus().equals(""))
            qr1="select nsa.stud_id,batch,studname,fname,srnum,degree,amount,reason,nsa.status  from noduesed_student_amount nsa join studentregis st"
                    + " on nsa.stud_id=st.stud_id where nsa.session_sem='"+reo.getSession_sem()+"' and nsa.session='"+reo.getSession()+"' and nsa.status='"+reo.getStatus()+"'";
        else if(!reo.getReason().equals("")&&!reo.getStatus().equals(""))
            qr1="select nsa.stud_id,batch,studname,fname,srnum,degree,amount,reason,nsa.status  from noduesed_student_amount nsa join studentregis st"
                    + " on nsa.stud_id=st.stud_id where nsa.session_sem='"+reo.getSession_sem()+"' and nsa.session='"+reo.getSession()+"' and nsa.reason='"+reo.getReason()+"'"
                    + " and nsa.status='"+reo.getStatus()+"'";
        else
            qr1="select nsa.stud_id,batch,studname,fname,srnum,degree,amount,reason,nsa.status  from noduesed_student_amount nsa join studentregis st"
                    + " on nsa.stud_id=st.stud_id where nsa.session_sem='"+reo.getSession_sem()+"' and nsa.session='"+reo.getSession()+"'";
                    
      ArrayList ar=new ArrayList();
      try{
       psmt1=con.prepareStatement(qr1);
       rs1=psmt1.executeQuery();
       while(rs1.next()){
           re=new ReportsEO();
           re.setStud_id(rs1.getString("stud_id"));
           re.setSname(rs1.getString("studname"));
           re.setDegree(rs1.getString("degree"));
           re.setFname(rs1.getString("fname"));
           re.setSrnum(rs1.getString("srnum"));
           re.setAmount(rs1.getDouble("amount"));
           re.setBatch(rs1.getString("batch"));
           re.setReason(rs1.getString("reason"));
           re.setStatus(rs1.getString("status"));
         ar.add(re);    
       }
       }catch(SQLException s){System.out.println("hiii "+s.getMessage());}
      finally
      {
          try{
              if(rs1!=null){rs1.close();}
              if(psmt1!=null){psmt1.close();}
              if(con!=null){con.close();}
           }catch(Exception e){} 
      }
      return ar;
    }

public ArrayList noduesedStudentListForRegistrar(java.util.Date date){
    Connection con=null;
      try{        
          DataConnection dc1=new DataConnection();
          con=(Connection)dc1.Dataconnect();
         }
      catch(Exception e){} 
      SchoolEO se=null;
        String qr1="select * from nodues_semester where DATE_FORMAT(nodues_date,'%Y-%m-%d')=?";
        
      ArrayList ar=new ArrayList();
      try{
       psmt1=con.prepareStatement(qr1);
      psmt1.setDate(1, new java.sql.Date(date.getTime()));
       rs1=psmt1.executeQuery();
       while(rs1.next()){
           se=new SchoolEO();
           se.setStud_id(rs1.getString("stud_id"));
           se.setSession(rs1.getString("session"));
           se.setSession_sem(rs1.getString("session_sem"));
           se.setBatch(rs1.getString("batch"));
           se.setDate(rs1.getDate("nodues_date"));
           se.setLoginName(rs1.getString("nodues_by"));
           se.setFeeTotal(rs1.getDouble("total_amount"));
           se.setDegree(rs1.getString("degree"));
           se.setSname(rs1.getString("sname"));
           se.setTransaction_id(rs1.getString("transaction_id"));
           se.setMobile(rs1.getString("contact"));
       ar.add(se);    
       }
       }catch(SQLException s){System.out.println("hiii "+s.getMessage());}
      finally
      {
          try{
              if(rs1!=null){rs1.close();}
              if(psmt1!=null){psmt1.close();}
              if(con!=null){con.close();}
           }catch(Exception e){} 
      }
      return ar;
    }

public String getExcelFilenameOfNodues(java.util.Date date){
    String filename="";
    Connection con=null;
      try{        
          DataConnection dc1=new DataConnection();
          con=(Connection)dc1.Dataconnect();
         }
      catch(Exception e){} 
      SchoolEO se=null;
        String qr1="select * from noduesed_excels where date=?";
      try{
       psmt1=con.prepareStatement(qr1);
      psmt1.setDate(1, new java.sql.Date(date.getTime()));
       rs1=psmt1.executeQuery();
       if(rs1.next()){
           filename=rs1.getString("filename");
       }
       }catch(SQLException s){System.out.println("hiii "+s.getMessage());}
      finally
      {
          try{
              if(rs1!=null){rs1.close();}
              if(psmt1!=null){psmt1.close();}
              if(con!=null){con.close();}
           }catch(Exception e){} 
      }
    return filename;
}

public Double singleFieldValueFromStud_fee_detail(String stud_id,String fieldname,Connection con){
    Double amount=null;
    try{ 
        String qr1="select rwid, "+fieldname+" from stud_fee_detail where stud_id=? order by rwid";
        psmt=con.prepareStatement(qr1);
        psmt.setString(1, stud_id);
        rs=psmt.executeQuery();
        if(rs.next()){
            amount=rs.getDouble(fieldname);
        }
        }catch(Exception e){System.out.println("Exc ToDB- singleFieldValueFromStud_fee_detail method: "+e.getMessage());}
       finally{
      try{
          if(rs!=null){rs.close();}
          if(psmt!=null){psmt.close();}          
       }   
      catch(SQLException se){}
    }    
    return amount;
}

public static void main(String ar[])
{
    System.out.println( Math.round(20.50 ) );
}
    
}
