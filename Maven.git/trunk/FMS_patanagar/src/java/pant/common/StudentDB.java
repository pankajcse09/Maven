/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pant.common;

import EO.SchoolEO;
import com.myapp.struts.DataConnection;
import com.myapp.struts.Dataconnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kapil
 */
public class StudentDB {
    Connection con=null;
    PreparedStatement ps=null; 
    PreparedStatement ps1=null;
    ResultSet rs=null;
    ResultSet rs1=null;
    ResultSet rs2=null;
    
    public int checkStudent(String srnum,String stud_id)throws Exception{
        int n=0;
        try{        
       Dataconnectivity dc1=new Dataconnectivity();
       con=(Connection)dc1.Dataconnect();
        }
      catch(Exception e){} 
        try{
            String qr=new String("");
            if(!srnum.equals("")&&stud_id.equals(""))
                qr="select count(*) as cnt from studentregis where srnum='"+srnum+"'";
            else if(srnum.equals("")&&!stud_id.equals(""))
                qr="select count(*) as cnt from studentregis where stud_id='"+stud_id+"'";
            else
                qr="select count(*) as cnt from studentregis where srnum='"+srnum+"' or stud_id='"+stud_id+"'";
//            System.out.println(qr);
            ps=con.prepareStatement(qr);
            rs=ps.executeQuery();
            if(rs.next()){
                n=rs.getInt("cnt");
            }
        }catch(Exception e){} 
        finally
        {
            if(rs!=null){rs.close();}           
            if(ps!=null){ps.close();}       
            if(con!=null){con.close();}  
        }
        return n;
    }
public int registerStudent(SchoolEO seo)throws Exception
    {
        int n=0;
        try{        
       Dataconnectivity dc1=new Dataconnectivity();
       con=(Connection)dc1.Dataconnect();
        }
      catch(Exception e){} 
        try{
           
            String sq="insert into studentregis(session,batch,srnum,stud_id,studname,dob,gender,fname,foccup,category,degree,stud_type,new_beni,"
                    + "registration,noduesCmplt,icar,gate)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            ps=con.prepareStatement(sq); 
            ps.setString(1, seo.getSession()); 
            ps.setString(2, seo.getBatch());
            ps.setString(3, seo.getSrnum());
            ps.setString(4, seo.getStud_id());
            ps.setString(5, seo.getSname());
            ps.setString(6, seo.getDob());
            ps.setString(7, seo.getGender());
            ps.setString(8, seo.getFname());
            ps.setString(9, seo.getFprof());
            ps.setString(10, seo.getCategory());
            ps.setString(11, seo.getDegree());
            ps.setString(12, seo.getStud_type());
            ps.setString(13, seo.getNewBeni());
            ps.setString(14, new String("NO"));
            ps.setString(15, new String("NO"));
            ps.setString(16, seo.getIcar());
            ps.setString(17, seo.getGate());
            n=ps.executeUpdate(); 
        }catch(Exception e){} 
        finally
        {
            if(ps!=null){ps.close();}       
            if(con!=null){con.close();}  
        }
        return n;
    }
    
public int checkAftRegisStudent(String srnum,String stud_id,String batch)throws Exception{
        int n=0;
        try{        
       Dataconnectivity dc1=new Dataconnectivity();
       con=(Connection)dc1.Dataconnect();
        }
      catch(Exception e){} 
        try{
            String qr=new String("");
            if(!srnum.equals("")&&stud_id.equals(""))
                qr="select count(*) as cnt from studentregis where batch='"+batch+"' and srnum='"+srnum+"'";
            else if(srnum.equals("")&&!stud_id.equals(""))
                qr="select count(*) as cnt from studentregis where batch='"+batch+"' and stud_id='"+stud_id+"'";
            else
                qr="select count(*) as cnt from studentregis where batch='"+batch+"' and (srnum='"+srnum+"' or stud_id='"+stud_id+"')";
//            System.out.println(qr);
            ps=con.prepareStatement(qr);
            rs=ps.executeQuery();
            if(rs.next()){
                n=rs.getInt("cnt");
            }
        }catch(Exception e){} 
        finally
        {
            if(rs!=null){rs.close();}           
            if(ps!=null){ps.close();}       
            if(con!=null){con.close();}  
        }
        return n;
    }
    
public SchoolEO getStudentRegisDetail(SchoolEO seo1)
{
    SchoolEO seo=new SchoolEO();
    Connection con=null;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
  
  try
  {
      String qr=new String("");
            if(!seo1.getSrnum().equals("")&&seo1.getStud_id().equals(""))
                qr="select * from studentregis where batch='"+seo1.getBatch()+"' and srnum='"+seo1.getSrnum()+"'";
            else if(seo1.getSrnum().equals("")&&!seo1.getStud_id().equals(""))
                qr="select * from studentregis where batch='"+seo1.getBatch()+"' and stud_id='"+seo1.getStud_id()+"'";
            else
                qr="select * from studentregis where batch='"+seo1.getBatch()+"' and (srnum='"+seo1.getSrnum()+"' or stud_id='"+seo1.getStud_id()+"')";
      
      System.out.println(qr);
      ps=con.prepareStatement(qr);
      rs=ps.executeQuery();
      if(rs.next())
      {
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

public int updateRegisteredStudent(SchoolEO seo)throws Exception
    {
        int n=0;
        try{        
       Dataconnectivity dc1=new Dataconnectivity();
       con=(Connection)dc1.Dataconnect();
        }
      catch(Exception e){} 
        try{
           
            String sq="update studentregis set studname=?,gender=?,fname=?,foccup=?,category=?,degree=?,stud_type=?,new_beni=?,icar=?,gate=? where rowid=?";
            
            ps=con.prepareStatement(sq); 
            ps.setString(1, seo.getSname());            
            ps.setString(2, seo.getGender());
            ps.setString(3, seo.getFname());
            ps.setString(4, seo.getFprof());
            ps.setString(5, seo.getCategory());
            ps.setString(6, seo.getDegree());
            ps.setString(7, seo.getStud_type());
            ps.setString(8, seo.getNewBeni());
            ps.setString(9, seo.getIcar());
            ps.setString(10, seo.getGate());
            ps.setLong(11, seo.getRwid());
            n=ps.executeUpdate(); 
        }catch(Exception e){} 
        finally
        {
            if(ps!=null){ps.close();}       
            if(con!=null){con.close();}  
        }
        return n;
    }

}
