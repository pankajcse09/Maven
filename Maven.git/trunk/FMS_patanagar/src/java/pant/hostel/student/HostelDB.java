/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pant.hostel.student;

import EO.HostelBean;
import EO.SchoolEO;
import com.myapp.struts.Dataconnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author kapil
 */
public class HostelDB {
    Connection con=null;
    PreparedStatement ps=null; 
    PreparedStatement ps1=null;
    ResultSet rs=null;
    ResultSet rs1=null;
    ResultSet rs2=null;
    
 public SchoolEO getStudentRegisDetail(String stud_id)
 {
    SchoolEO seo=null;
    try{
        Dataconnectivity dc=new Dataconnectivity();
        con=(Connection)dc.Dataconnect();
    }catch(Exception e){}
  
  try
  {
      String qr="select * from studentregis st left join hostel hs on st.hostel_code=hs.code where stud_id='"+stud_id+"'";
//      System.out.println(qr);
      ps=con.prepareStatement(qr);
      rs=ps.executeQuery();
      if(rs.next())
      {
          seo=new SchoolEO();
          seo.setStud_id(rs.getString("stud_id"));
          seo.setBatch(rs.getString("batch"));
          seo.setSname(rs.getString("studname"));
          seo.setFname(rs.getString("fname"));
          seo.setDegree(rs.getString("degree"));
          seo.setStud_type(rs.getString("stud_type"));
          seo.setNewBeni(rs.getString("new_beni"));          
          seo.setGender(rs.getString("gender"));
          seo.setCollege(rs.getString("college"));
          seo.setReg(rs.getString("registration"));
          seo.setDate(rs.getDate("regist_date"));
          seo.setSrnum(rs.getString("srnum"));
          seo.setStud_type(rs.getString("stud_type"));
          seo.setGate(rs.getString("gate"));
          seo.setFprof(rs.getString("foccup"));
          seo.setCategory(rs.getString("category"));
          seo.setIcar(rs.getString("icar"));
          seo.setRwid(rs.getLong("rowid"));
         HostelBean hostelBean=new HostelBean();
         hostelBean.setHostelCode(rs.getString("hostel_code"));
         hostelBean.setHostelName(rs.getString("hostel_name"));
         seo.setHostelBean(hostelBean);
      }
  }catch(Exception e){System.out.println("Ex: "+e.getMessage());}
  finally{
       try{
         if(rs!=null){rs.close();}           
         if(ps!=null){ps.close();}       
         if(con!=null){con.close();}  
       }   
       catch(SQLException see){}
      } 
  return seo;
}

 public int updateHostelInRegisTable(String stud_id,String hostel_code){
     int n=0;
     try{
        Dataconnectivity dc=new Dataconnectivity();
        con=(Connection)dc.Dataconnect();
    }catch(Exception e){}
  
  try
  {
      String qr="update studentregis set hostel_code=? where stud_id=?";
      ps=con.prepareStatement(qr);
      ps.setString(1, hostel_code);
      ps.setString(2, stud_id);
      n=ps.executeUpdate();  
  }catch(Exception e){System.out.println("Ex: "+e.getMessage());}
  finally{
       try{
         if(rs!=null){rs.close();}           
         if(ps!=null){ps.close();}       
         if(con!=null){con.close();}  
       }   
       catch(SQLException see){}
      } 
     return n;
 }
 
 public HostelBean hostelByCode(String code){
        HostelBean hb=new HostelBean();
        try{        
       Dataconnectivity dc=new Dataconnectivity();
       con=(Connection)dc.Dataconnect();
        }
      catch(Exception e){} 
        try{
            String st="select * from hostel where code=?";
            ps=con.prepareStatement(st);
            ps.setString(1, code);
            rs=ps.executeQuery();
            while(rs.next())
            {
                hb.setRid(rs.getInt("rid"));
                hb.setHostelName(rs.getString("hostel_name"));
                hb.setHostelCode(rs.getString("code"));
            }
         }catch(Exception e){} 
        finally
        {
          try{
            if(rs!=null){rs.close();}           
            if(ps!=null){ps.close();}       
            if(con!=null){con.close();}  
        }   
       catch(SQLException s){}
        }
        return hb;
    }
 
 public ArrayList StudentPostedFoodBill(String session,String stud_id){
        ArrayList list=new ArrayList();
       SchoolEO seo;
       HostelBean hb;
        try{
            Dataconnectivity dc=new Dataconnectivity();
            con=(Connection)dc.Dataconnect();
        }catch(Exception e){}
        try{
            String qr="select mf.rwid, mf.food_amount,mf.month, mf.bill_gen_date,mf.subm_date,mf.session from monthly_food mf where mf.stud_id=? and mf.session=?";
            ps=con.prepareStatement(qr);
            ps.setString(1, stud_id);
            ps.setString(2, session);
            rs=ps.executeQuery();
            while(rs.next()){
                seo=new SchoolEO();
                seo.setRwid(rs.getLong("rwid"));
                seo.setMonth(rs.getString("month"));
                seo.setMonthlyFood(rs.getDouble("food_amount"));
                seo.setDate(rs.getDate("bill_gen_date"));
                seo.setSubm_date(rs.getDate("subm_date"));
                list.add(seo);
            }
         }catch(Exception e){System.out.println("Ex: "+e.getMessage());}
        finally{
            try{
                if(rs!=null){rs.close();}           
                if(ps!=null){ps.close();}       
                if(con!=null){con.close();}  
                }   
            catch(SQLException see){}
        } 
        return list;
    }
}
