 /*
 * Im_ResumeUtilty.java
 *
 * Created on June 24, 2008, 11:37 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

 package com.myapp.struts;
import Feedback.feedbean;
import career.careerbean;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.io.*;
import java.sql.Blob;

import java.sql.Timestamp;
/**
 *
 * @author Rock
 */
public class Im_ResumeUtilty {
    private int noOfRecords;
    /** Creates a new instance of Im_ResumeUtilty */
    public Im_ResumeUtilty() {
    }
    
      public  static boolean prod_detpdf_db(String filename,int pro_id,String pdf_txt) throws SQLException
    {
        
        
        
         
    Connection conn = null;
    PreparedStatement ps = null;
    PreparedStatement ps1 = null;
    ResultSet rs = null;
    ResultSet rs1 = null;
    Common_data getdataus = null;
    
    
    
  
     
   try{
     
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
       
      
  
        
         
         Timestamp timestamp=new Timestamp(System.currentTimeMillis());
       
       
          
    String sqlString ="insert into pdf_proj_detail(pdf_file,proj_id,pdf_txt)values(?,?,?)";
   
    
    ps = conn.prepareStatement(sqlString);
        


ps.setString(1,filename);
ps.setInt(2,pro_id);
ps.setString(3,pdf_txt);




ps.executeUpdate();
ps.close();




  
     }
   finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( ps != null ) {

        ps.close();
      }

      if ( conn != null ) {

        conn.close();
      }
        
}
    return true;
    }  
    
    
    
    
    
    
    
       public  static boolean pdf_db(String filename,String hm,String pdf_txt) throws SQLException
    {
        
        
        
         
    Connection conn = null;
    PreparedStatement ps = null;
    PreparedStatement ps1 = null;
    ResultSet rs = null;
    ResultSet rs1 = null;
    Common_data getdataus = null;
    
    
    
  
     
   try{
     
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
       
      
  
        
         
         Timestamp timestamp=new Timestamp(System.currentTimeMillis());
       
       
          
    String sqlString ="insert into pdf_imd(pdf_timestamp,pdf_name,page,pdf_txt)values(?,?,?,?)";
   // String sqlString ="insert into mp3_images(id,df)values(?,?)";
    
    ps = conn.prepareStatement(sqlString);
        

ps.setTimestamp(1,timestamp);
ps.setString(2,filename);
ps.setString(3,hm);
ps.setString(4,pdf_txt);


//FileInputStream fis = new FileInputStream(dbfile.getInputStream()); 
//ps.setBinaryStream(2, st);
ps.executeUpdate();
ps.close();




  
     }
    finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( ps != null ) {

        ps.close();
      }

      if ( conn != null ) {

        conn.close();
      }
        
}
    return true;
    }  
    
 public  ArrayList view_Feedback(int offset,int noOfRecords)throws Exception 
    {
        Connection conn2 = null;
    PreparedStatement pstmt2 = null;
    ResultSet rs2 = null;
    Common_data getdataus = null;
    ArrayList feedback_List=new ArrayList();
   //Common_data da=null;
    
    
    
       try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn2=(Connection)cour_con.Dataconnect();

      String st2="select SQL_CALC_FOUND_ROWS * from imd_fed order by fed_timestamp desc limit " +offset +"," + noOfRecords;
       pstmt2=conn2.prepareStatement(st2);
       rs2=pstmt2.executeQuery();
        
      //System.out.println(rs);
       
       while(rs2.next())
       {
          // Aboutusform frm=new Aboutusform();
             //System.out.println(rs.getString("about_us"));
       feedbean res= new feedbean();
         
       res.setId(rs2.getInt("fed_id"));
       res.setSub(rs2.getString("fed_sub"));
    res.setMsg(rs2.getString("fed_msg"));
    res.setFilename(rs2.getString("fed_filename"));
    res.setName(rs2.getString("name"));
    res.setEmailid(rs2.getString("email"));
    res.setContactno(rs2.getString("contactno"));
    res.setAddress(rs2.getString("address"));
    
    res.setEmailRegisDate(new java.util.Date(rs2.getTimestamp("fed_timestamp").getTime()));
    
    feedback_List.add(res);
         
          
       }
       rs2.close();
 
    rs2 = pstmt2.executeQuery("SELECT FOUND_ROWS()");
    if(rs2.next())
        this.noOfRecords = rs2.getInt(1);    
        
          }catch(Exception e){}
     finally {

      if ( rs2 != null ) {

        rs2.close();
      }

      if ( pstmt2 != null ) {

        pstmt2.close();
      }

      if ( conn2 != null ) {

        conn2.close();
      }
        
}
     return feedback_List;
   } 
    
    
    public  ArrayList view_career()throws Exception 
    
   {
        Connection conn2 = null;
    PreparedStatement pstmt2 = null;
    ResultSet rs2 = null;
    Common_data getdataus = null;
    ArrayList feedback_List=new ArrayList();
   //Common_data da=null;
    
    
    
       try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn2=(Connection)cour_con.Dataconnect();

      String st2="select * from imd_career";
       pstmt2=conn2.prepareStatement(st2);
       rs2=pstmt2.executeQuery();
        
    System.out.println("rs2"+rs2);
       
       while(rs2.next())
       {
          // Aboutusform frm=new Aboutusform();
             //System.out.println(rs.getString("about_us"));
       feedbean res= new feedbean();
         
     res.setId(rs2.getInt("fed_id"));
      res.setSub(rs2.getString("fed_sub"));
    res.setMsg(rs2.getString("fed_msg"));
    res.setFilename(rs2.getString("fed_filename"));
   res.setName(rs2.getString("name"));
   res.setEmailid(rs2.getString("email"));
    res.setContactno(rs2.getString("contactno"));
    res.setAddress(rs2.getString("address"));
   
    
    
    
                 
                 
           feedback_List.add(res);
         
          
       }
          }catch(Exception e){}
     finally {

      if ( rs2 != null ) {

        rs2.close();
      }

      if ( pstmt2 != null ) {

        pstmt2.close();
      }

      if ( conn2 != null ) {

        conn2.close();
      }
        
}
     return feedback_List;
   } 
    
     public  ArrayList view_member()throws Exception 
    
   {
        Connection conn2 = null;
    PreparedStatement pstmt2 = null;
    ResultSet rs2 = null;
    Common_data getdataus = null;
    ArrayList feedback_List=new ArrayList();
   //Common_data da=null;
    
    
    
       try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn2=(Connection)cour_con.Dataconnect();

      String st2="select * from imd_member";
       pstmt2=conn2.prepareStatement(st2);
       rs2=pstmt2.executeQuery();
        
    System.out.println("rs2"+rs2);
       
       while(rs2.next())
       {
          // Aboutusform frm=new Aboutusform();
             //System.out.println(rs.getString("about_us"));
       feedbean res= new feedbean();
         
     res.setId(rs2.getInt("fed_id"));
      res.setSub(rs2.getString("occupation"));
   
   res.setName(rs2.getString("name"));
   res.setEmailid(rs2.getString("email"));
    res.setContactno(rs2.getString("contactno"));
    res.setAddress(rs2.getString("address"));
    res.setDob(rs2.getString("dob"));
   
    
    
    
                 
                 
           feedback_List.add(res);
         
          
       }
          }catch(Exception e){}
     finally {

      if ( rs2 != null ) {

        rs2.close();
      }

      if ( pstmt2 != null ) {

        pstmt2.close();
      }

      if ( conn2 != null ) {

        conn2.close();
      }
        
}
     return feedback_List;
   } 
    
     public  static boolean fed_db(String filename,feedbean fb) throws SQLException
    {
        
        
        
         
    Connection conn = null;
    PreparedStatement ps = null;
    PreparedStatement ps1 = null;
    ResultSet rs = null;
    ResultSet rs1 = null;
    Common_data getdataus = null;
    
    
    
     //int ct=0;
     
   try{
     
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
       
      
  
        
         
         Timestamp timestamp=new Timestamp(System.currentTimeMillis());
       
       
          
    String sqlString ="insert into imd_fed(fed_timestamp,fed_filename,fed_sub,fed_msg,name,contactno,email,address)values(?,?,?,?,?,?,?,?)";
   // String sqlString ="insert into mp3_images(id,df)values(?,?)";
    
    ps = conn.prepareStatement(sqlString);
    
        

ps.setTimestamp(1,timestamp);
ps.setString(2,filename);
ps.setString(3,fb.getSub());
ps.setString(4,fb.getMsg());

ps.setString(5,fb.getName());
ps.setString(6,fb.getContactno());
ps.setString(7,fb.getEmailid());
ps.setString(8,fb.getAddress());




//FileInputStream fis = new FileInputStream(dbfile.getInputStream()); 
//ps.setBinaryStream(2, st);
ps.executeUpdate();
ps.close();




  
     }catch(Exception e)
     {
     //out.println(e.getMessage());
     }
     finally {

     

      if ( ps != null ) {

        ps.close();
      }

      if ( conn != null ) {

        conn.close();
      }
        
}
    return true;
    }  
     
     
     
        public  static boolean memberform_db(feedbean fb) throws SQLException
    {
        
        
        
         
    Connection conn = null;
    PreparedStatement ps = null;
    PreparedStatement ps1 = null;
    ResultSet rs = null;
    ResultSet rs1 = null;
    Common_data getdataus = null;
    
    
    
     //int ct=0;
     
   try{
     
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
       
      
  
        
         
         Timestamp timestamp=new Timestamp(System.currentTimeMillis());
       
       
          
    String sqlString ="insert into imd_member(fed_timestamp,occupation,name,contactno,email,address,dob)values(?,?,?,?,?,?,?)";
   // String sqlString ="insert into mp3_images(id,df)values(?,?)";
    
    ps = conn.prepareStatement(sqlString);
    
        

ps.setTimestamp(1,timestamp);

ps.setString(2,fb.getSub());


ps.setString(3,fb.getName());
ps.setString(4,fb.getContactno());
ps.setString(5,fb.getEmailid());
ps.setString(6,fb.getAddress());
ps.setString(7,fb.getDob());



//FileInputStream fis = new FileInputStream(dbfile.getInputStream()); 
//ps.setBinaryStream(2, st);
ps.executeUpdate();
ps.close();




  
     }catch(Exception e)
     {
     //out.println(e.getMessage());
     }
     finally {

     

      if ( ps != null ) {

        ps.close();
      }

      if ( conn != null ) {

        conn.close();
      }
        
}
    return true;
    }  
     
    
    public  static boolean fed_db_career(String filename,careerbean fb) throws SQLException
    {
        
        
        
         
    Connection conn = null;
    PreparedStatement ps = null;
    PreparedStatement ps1 = null;
    ResultSet rs = null;
    ResultSet rs1 = null;
    Common_data getdataus = null;
    
    
    
     //int ct=0;
     
   try{
     
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
       
      
  
        
         
         Timestamp timestamp=new Timestamp(System.currentTimeMillis());
       
       
          
    String sqlString ="insert into imd_career(fed_timestamp,fed_filename,fed_msg,name,contactno,email,address)values(?,?,?,?,?,?,?)";
   // String sqlString ="insert into mp3_images(id,df)values(?,?)";
    
    ps = conn.prepareStatement(sqlString);
    
        

ps.setTimestamp(1,timestamp);
ps.setString(2,filename);

ps.setString(3,fb.getMsg());

ps.setString(4,fb.getName());
ps.setString(5,fb.getContactno());
ps.setString(6,fb.getEmailid());
ps.setString(7,fb.getAddress());




//FileInputStream fis = new FileInputStream(dbfile.getInputStream()); 
//ps.setBinaryStream(2, st);
ps.executeUpdate();
ps.close();




  
     }catch(Exception e)
     {
     //out.println(e.getMessage());
     }
     finally {

     

      if ( ps != null ) {

        ps.close();
      }

      if ( conn != null ) {

        conn.close();
      }
        
}
    return true;
    }  
     
    
     public  ArrayList  status_Resume()throws Exception 
    
   {
        Connection conn2 = null;
    PreparedStatement pstmt2 = null;
    ResultSet rs2 = null;
    Common_data getdataus = null;
    ArrayList resume_List=new ArrayList();
   //Common_data da=null;
    
    
    
       try{
       
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn2=(Connection)cour_con.Dataconnect();

      String st2="select time_stamp,count(res_id) as sno,res_id  from im_resume group by res_id,time_stamp";
       pstmt2=conn2.prepareStatement(st2);
       rs2=pstmt2.executeQuery();
        
      //System.out.println(rs);
       
       while(rs2.next())
       {
          // Aboutusform frm=new Aboutusform();
             //System.out.println(rs.getString("about_us"));
         Im_Res_DataHold  res= new Im_Res_DataHold();
         
        res.setNo(rs2.getInt("res_id"));
        res.setTi(rs2.getTimestamp("time_stamp"));
          
                
                 
                 
             resume_List.add(res);
         
          
       }
          }catch(Exception e){}
    
     finally {

      if ( rs2 != null ) {

        rs2.close();
      }

      if ( pstmt2 != null ) {

        pstmt2.close();
      }

      if ( conn2 != null ) {

        conn2.close();
      }
        
}
    
     return resume_List;
   } 
    
    
    
    
    public  static boolean res_db(String filename) throws SQLException
    {
        
        
        
         
    Connection conn = null;
    PreparedStatement ps = null;
    PreparedStatement ps1 = null;
    ResultSet rs = null;
    ResultSet rs1 = null;
    Common_data getdataus = null;
    
    
    
     //int ct=0;
     
   try{
     
           Dataconnectivity cour_con=new  Dataconnectivity();
    conn=(Connection)cour_con.Dataconnect();
       
      
  
        
         
         Timestamp timestamp=new Timestamp(System.currentTimeMillis());
       
       
          
    String sqlString ="insert into im_resume(time_stamp,name)values(?,?)";
   // String sqlString ="insert into mp3_images(id,df)values(?,?)";
    
    ps = conn.prepareStatement(sqlString);
        

ps.setTimestamp(1,timestamp);
ps.setString(2,filename);

//FileInputStream fis = new FileInputStream(dbfile.getInputStream()); 
//ps.setBinaryStream(2, st);
ps.executeUpdate();
ps.close();




  
     }catch(Exception e)
     {
     //out.println(e.getMessage());
     }
     finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( ps != null ) {

        ps.close();
      }

      if ( conn != null ) {

        conn.close();
      }
        
}
    return true;
    }  
     
public int getNoOfRecords() {
        return noOfRecords;
    }    
    
    
    
    
     public static void main(String args[])
     {
    Im_ResumeUtilty  a= new Im_ResumeUtilty();
        try {
            ArrayList aa=new ArrayList();
           aa=(ArrayList) a.view_career();
           System.out.println(aa);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
           //a.cust_Reg(g);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
     
    // a.chk_Available(2,1);
     
     }
    
    
    
    
}
