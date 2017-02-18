/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pant.common;

import EO.CollegeBean;
import EO.HostelBean;
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
public class UtilityDB {
    Connection con=null;
    PreparedStatement ps=null; 
    PreparedStatement ps1=null;
    ResultSet rs=null;
    ResultSet rs1=null;
    ResultSet rs2=null;
    
    public int addNewBeniDetails(SchoolEO se)
    {
        int cn=0;
      try{        
       DataConnection dc1=new DataConnection();
       con=(Connection)dc1.Dataconnect();
        }
      catch(Exception e){} 
        try{
            String st="select count(*) as cn from new_beni";
            ps=con.prepareStatement(st);
            rs=ps.executeQuery();
            if(rs.next())
            {
                if(rs.getInt("cn")==0)
                {
                    ArrayList heads=se.getDataArray();
                    HashMap hm=se.getDataMap();
                    String qr="insert into new_beni(heads,amount) values(?,?)";
                    ps1=con.prepareStatement(qr);
                    for(int i=0;i<6;i++)
                        {
                            ps1.setString(1, heads.get(i).toString());
                            ps1.setDouble(2, Double.parseDouble(hm.get(heads.get(i)).toString()));
                            ps1.addBatch();
                        }
                    ps1.executeBatch();
                }
                else{
                    cn=1;
                }
            }
        }catch(Exception e){} 
        finally
        {
          try{
            if(rs!=null){rs.close();}           
            if(ps!=null){ps.close();}       
            if(rs1!=null){rs1.close();}           
            if(ps1!=null){ps1.close();} 
            if(con!=null){con.close();}  
        }   
       catch(SQLException s){}
        }
        return cn;
    }
    
    public SchoolEO retNewBeniDetails()
    {
        SchoolEO seo=new SchoolEO();
        ArrayList heads=new ArrayList();
        HashMap hm=new HashMap();
        try{        
       DataConnection dc1=new DataConnection();
       con=(Connection)dc1.Dataconnect();
        }
      catch(Exception e){} 
        try{
            String st="select * from new_beni";
            ps=con.prepareStatement(st);
            rs=ps.executeQuery();
            while(rs.next())
            {
                heads.add(rs.getString("heads"));
                hm.put(rs.getString("heads"), rs.getDouble("amount"));
            }
            seo.setDataArray(heads);
            seo.setDataMap(hm);
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
        return seo;
    }
    
    public void updateNewBeniDetails(SchoolEO se)
    {
        try{        
       DataConnection dc1=new DataConnection();
       con=(Connection)dc1.Dataconnect();
        }
      catch(Exception e){} 
        try{
            ArrayList heads=se.getDataArray();
            HashMap hm=se.getDataMap();
            String qr="update new_beni set amount=? where heads=?";
            ps1=con.prepareStatement(qr);
            for(int i=0;i<6;i++)
               {
                   ps1.setDouble(1, Double.parseDouble(hm.get(heads.get(i)).toString()));
                   ps1.setString(2, heads.get(i).toString());
                   ps1.addBatch();
               }
              ps1.executeBatch();
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
    }
    
    public int checkCollOrHos(String table, String code ){
        int cn=0;
      try{        
       DataConnection dc1=new DataConnection();
       con=(Connection)dc1.Dataconnect();
        }
      catch(Exception e){} 
      try{
            String st="select count(*) as cn from "+table+" where code=?";
            ps=con.prepareStatement(st);
            ps.setString(1, code);
            rs=ps.executeQuery();
            if(rs.next())
            {
                cn=rs.getInt("cn");
            }
      }catch(Exception e){cn=-1;}
      finally
        {
          try{
            if(rs!=null){rs.close();}           
            if(ps!=null){ps.close();}       
            if(con!=null){con.close();}  
        }   
       catch(SQLException s){}
        }
      return cn;
    }
    public void saveCollege(String college,String code)
    {
       try{        
       DataConnection dc1=new DataConnection();
       con=(Connection)dc1.Dataconnect();
        }
      catch(Exception e){} 
        try{
            String qr="insert into college(college_name,code) values(?,?)";
            ps1=con.prepareStatement(qr);
            ps1.setString(1, college);
            ps1.setString(2, code);
            ps1.executeUpdate();
        }catch(Exception e){} 
        finally
        {
          try{
            if(ps1!=null){ps1.close();} 
            if(con!=null){con.close();}  
        }   
       catch(SQLException s){}
        }
    }

    public ArrayList collegeList(){
        ArrayList al=new ArrayList();
        CollegeBean cb;
        try{        
       DataConnection dc1=new DataConnection();
       con=(Connection)dc1.Dataconnect();
        }
      catch(Exception e){} 
        try{
            String st="select * from college";
            ps=con.prepareStatement(st);
            rs=ps.executeQuery();
            while(rs.next())
            {
                cb=new CollegeBean();
                cb.setRid(rs.getInt("rid"));
                cb.setCollegeName(rs.getString("college_name"));
                cb.setCollegeCode(rs.getString("code"));
                al.add(cb);
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
        return al;
    }
    
    public CollegeBean collegeById(int id){
        ArrayList al=new ArrayList();
        CollegeBean cb=new CollegeBean();
        try{        
       DataConnection dc1=new DataConnection();
       con=(Connection)dc1.Dataconnect();
        }
      catch(Exception e){} 
        try{
            String st="select * from college where rid=?";
            ps=con.prepareStatement(st);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while(rs.next())
            {
                cb.setRid(rs.getInt("rid"));
                cb.setCollegeName(rs.getString("college_name"));
                cb.setCollegeCode(rs.getString("code"));
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
        return cb;
    }
 
    public int checkCollOrHosUpdate(String table, String code, int rid ){
        int cn=0;
      try{        
       DataConnection dc1=new DataConnection();
       con=(Connection)dc1.Dataconnect();
        }
      catch(Exception e){} 
      try{
            String st="select count(*) as cn from "+table+" where code=? and rid<>?";
            ps=con.prepareStatement(st);
            ps.setString(1, code);
            ps.setInt(2, rid);
            rs=ps.executeQuery();
            if(rs.next())
            {
                cn=rs.getInt("cn");
            }
      }catch(Exception e){cn=-1;}
      finally
        {
          try{
            if(rs!=null){rs.close();}           
            if(ps!=null){ps.close();}       
            if(con!=null){con.close();}  
        }   
       catch(SQLException s){}
        }
      return cn;
    }
    
    public void updateCollege(CollegeBean cb)
    {
    ArrayList al=new ArrayList();
    
    try{
        Dataconnectivity dc=new Dataconnectivity();
        con=dc.Dataconnect();
    }
    catch(Exception e){} 
 try{

     String sq="update college set college_name=?,code=? where rid=?";
     ps=con.prepareStatement(sq);
     ps.setString(1, cb.getCollegeName());
     ps.setString(2, cb.getCollegeCode());
     ps.setInt(3, cb.getRid());
     ps.executeUpdate();
     
 }catch(Exception e){}
 finally{
    try{
    if(ps!=null){ps.close();}
    if(con!=null){con.close();}
    }catch(SQLException e){}
    }
}
    
public void delCollegeOrHos(String table, int rid)
{
    ArrayList al=new ArrayList();
    
    try{
        Dataconnectivity dc=new Dataconnectivity();
        con=dc.Dataconnect();
    }
    catch(Exception e){} 
 try{
     String sq="delete from "+table+" where rid=?";
     ps=con.prepareStatement(sq);
     ps.setInt(1, rid);
     ps.executeUpdate();
     
 }catch(Exception e){}
 finally{
    try{
    if(ps!=null){ps.close();}
    if(con!=null){con.close();}
    }catch(SQLException e){}
    }
}

// Hostel Utility
public void saveHostel(String hostel,String code)
    {
       try{        
       DataConnection dc1=new DataConnection();
       con=(Connection)dc1.Dataconnect();
        }
      catch(Exception e){} 
        try{
            String qr="insert into hostel(hostel_name,code) values(?,?)";
            ps1=con.prepareStatement(qr);
            ps1.setString(1, hostel);
            ps1.setString(2, code);
            ps1.executeUpdate();
        }catch(Exception e){} 
        finally
        {
          try{
            if(ps1!=null){ps1.close();} 
            if(con!=null){con.close();}  
        }   
       catch(SQLException s){}
        }
    }

    public ArrayList hostelList(){
        ArrayList al=new ArrayList();
        HostelBean hb;
        try{        
       DataConnection dc1=new DataConnection();
       con=(Connection)dc1.Dataconnect();
        }
      catch(Exception e){} 
        try{
            String st="select * from hostel";
            ps=con.prepareStatement(st);
            rs=ps.executeQuery();
            while(rs.next())
            {
                hb=new HostelBean();
                hb.setRid(rs.getInt("rid"));
                hb.setHostelName(rs.getString("hostel_name"));
                hb.setHostelCode(rs.getString("code"));
                al.add(hb);
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
        return al;
    }
    
    public HostelBean hostelById(int id){
        ArrayList al=new ArrayList();
        HostelBean hb=new HostelBean();
        try{        
       DataConnection dc1=new DataConnection();
       con=(Connection)dc1.Dataconnect();
        }
      catch(Exception e){} 
        try{
            String st="select * from hostel where rid=?";
            ps=con.prepareStatement(st);
            ps.setInt(1, id);
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
 public void updateHostel(HostelBean hb)
    {
    ArrayList al=new ArrayList();
    
    try{
        Dataconnectivity dc=new Dataconnectivity();
        con=dc.Dataconnect();
    }
    catch(Exception e){} 
 try{

     String sq="update hostel set hostel_name=?,code=? where rid=?";
     ps=con.prepareStatement(sq);
     ps.setString(1, hb.getHostelName());
     ps.setString(2, hb.getHostelCode());
     ps.setInt(3, hb.getRid());
     ps.executeUpdate();
     
 }catch(Exception e){}
 finally{
    try{
    if(ps!=null){ps.close();}
    if(con!=null){con.close();}
    }catch(SQLException e){}
    }
}
    
}
