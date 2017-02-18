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
import java.util.Calendar;
import java.util.Date;



/**
 *
 * @author kapil
 */
public class ScrollPdf {
    
    public boolean checkPdf(SchoolEO seo)
    {
        boolean bn=false;
        Connection con=null;
       PreparedStatement ps=null;
       ResultSet rs=null;
       try
       {
         Dataconnectivity dc=new Dataconnectivity();
         con=dc.Dataconnect();
       }catch(Exception se){}
       try
       {
         String qr="select * from generated_pdf where pdfname=?";
         ps=con.prepareStatement(qr);
         ps.setString(1, seo.getFilename());
         rs=ps.executeQuery();
         if(rs.next())
         {
             bn=true;
         }
       }catch(Exception se){
           //System.out.println("Ex: "+se.getMessage());
       }
       finally{
           try{
               if(ps!=null){ps.close();}
               if(con!=null){con.close();}
           }catch(Exception e){}
       }
        return bn;
    }
   public void addScrollPdfDetails(SchoolEO seo,Connection con)
   {
       PreparedStatement ps=null;
       
       try
       {
         String qr="insert into generated_pdf(degree,batch,session,session_sem,pdfname) values(?,?,?,?,?)";
         ps=con.prepareStatement(qr);
         ps.setString(1, seo.getDegree());
         ps.setString(2, seo.getBatch());
         ps.setString(3, seo.getSession());
         ps.setString(4, seo.getSemester());
         ps.setString(5, seo.getFilename());
         ps.executeUpdate();
       }catch(Exception se){
           //System.out.println("Ex: "+se.getMessage());
       }
       finally{
           try{
               if(ps!=null){ps.close();}
           }catch(Exception e){}
       }
   }
   
   public ArrayList retGeneratedScrollPdf(SchoolEO seo)
   {
       ArrayList al=new ArrayList();
       Connection con=null;
       PreparedStatement ps=null;
       ResultSet rs=null;
       try
       {
         Dataconnectivity dc=new Dataconnectivity();
         con=dc.Dataconnect();
       }catch(Exception se){}
       try
       {
         String qr="select * from generated_pdf where session=? and session_sem=? and degree=?";
         ps=con.prepareStatement(qr);
         ps.setString(1, seo.getSession());
         ps.setString(2, seo.getSession_sem());
         ps.setString(3, seo.getDegree());
         rs=ps.executeQuery();
         while(rs.next())
         {
             seo=new SchoolEO();
             seo.setRowid(rs.getInt("rwid"));
             seo.setBatch(rs.getString("batch"));
             seo.setSession(rs.getString("session"));
             seo.setSemester(rs.getString("session_sem"));
             seo.setDegree(rs.getString("degree"));
             seo.setFilename(rs.getString("pdfname"));
             
             al.add(seo);
         }
       }catch(Exception se){
           System.out.println("Ex: "+se.getMessage());
       }
       finally{
           try{
               if(ps!=null){ps.close();}
               if(con!=null){con.close();}
           }catch(Exception e){}
       }
       return al;
   }
   
   public String retIndvPdfScroll(int id)
    {
        String filename="";
        Connection con=null;
       PreparedStatement ps=null;
       ResultSet rs=null;
       try
       {
         Dataconnectivity dc=new Dataconnectivity();
         con=dc.Dataconnect();
       }catch(Exception se){}
       try
       {
         String qr="select pdfname from generated_pdf where rwid=?";
         ps=con.prepareStatement(qr);
         ps.setInt(1, id);
         rs=ps.executeQuery();
         if(rs.next())
         {
            filename=rs.getString("pdfname");
         }
       }catch(Exception se){
           //System.out.println("Ex: "+se.getMessage());
       }
       finally{
           try{
               if(ps!=null){ps.close();}
               if(con!=null){con.close();}
           }catch(Exception e){}
       }
        return filename;
    }
   
   public String delPdf(String filename)
    {
        Connection con=null;
       PreparedStatement ps=null;
       ResultSet rs=null;
       try
       {
         Dataconnectivity dc=new Dataconnectivity();
         con=dc.Dataconnect();
       }catch(Exception se){}
       try
       {
         String qr="delete from generated_pdf where pdfname=?";
         ps=con.prepareStatement(qr);
         ps.setString(1, filename);
         ps.executeUpdate();
       }catch(Exception se){
           se.printStackTrace();
       }
       finally{
           try{
               if(ps!=null){ps.close();}
               if(con!=null){con.close();}
           }catch(Exception e){}
       }
        return filename;
    }
   
   public static void main(String arg[])
   {
       SchoolEO seo=new SchoolEO();
//       addScrollPdfDetails(seo);
   }
}
