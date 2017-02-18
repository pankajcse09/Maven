/*
 * FeeMethod.java
 *
 * Created on April 22, 2009, 5:32 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package ActionClass;

import com.myapp.struts.DataConnection;
import java.sql.*;
import java.util.*;
import Beans.JavaBean;
import EO.SchoolEO;
public class FeeMethod {
    
    /**
     * Creates a new instance of FeeMethod
     */    
    static Connection con=null;
    PreparedStatement psmt1=null;  
    PreparedStatement psmt2=null;   
    PreparedStatement psmt3=null; 
    ResultSet rs1=null;
    ResultSet rs2=null;
    ResultSet rs3=null;
    
     public FeeMethod() {
     try{        
       DataConnection dc1=new DataConnection();
       con=(Connection)dc1.Dataconnect();
        }
      catch(Exception e){}    
     }
    
    public ArrayList feeHeads(){
//      try{        
//          DataConnection dc1=new DataConnection();
//          con=(Connection)dc1.Dataconnect();
//         }
//      catch(Exception e){}   
      ArrayList ar=new ArrayList();
      String qr1="select distinct heads from feeheads";
      try{
       psmt1=con.prepareStatement(qr1);
       rs1=psmt1.executeQuery();
       while(rs1.next()){
       ar.add(rs1.getString("heads"));    
       }
       }catch(SQLException se){}
      return ar;
    }
    
    public ArrayList fee_Heads(String stud_type){
//      try{        
//          DataConnection dc1=new DataConnection();
//          con=(Connection)dc1.Dataconnect();
//         }
//      catch(Exception e){} 
        String qr1="";
      ArrayList ar=new ArrayList();
      if(stud_type.equals("Day Scholar")){
          qr1="select distinct heads from feeheads where stud_type='"+stud_type+"' order by fee_type";
      }
      else if(stud_type.equals("Hosteller")){
      qr1="select distinct heads from feeheads order by fee_type";
      }
      try{
       psmt1=con.prepareStatement(qr1);
       rs1=psmt1.executeQuery();
       while(rs1.next()){
       ar.add(rs1.getString("heads"));    
       }
       }catch(SQLException se){System.out.println("hiii "+se.getMessage());}
      
      
      return ar;
    }
    
    public ArrayList feeTypes(String stud_type)
    {
        String qr1="";
        int cn=0;
        JavaBean jb=null;
      ArrayList ar=new ArrayList();
      if(stud_type.equals("Day Scholar")){
          qr1="select count(fee_type) as cnt, fee_type as feetype from feeheads where stud_type='"+stud_type+"' group by fee_type";
      }
      else{
      qr1="select count(fee_type) as cnt, fee_type as feetype from feeheads group by fee_type;";
      }
      try{
       psmt1=con.prepareStatement(qr1);
       rs1=psmt1.executeQuery();
       while(rs1.next()){
           jb=new JavaBean();
           jb.setCount(rs1.getInt("cnt"));
           jb.setFeeType(rs1.getString("feetype"));
       ar.add(jb);
       }
       }catch(SQLException se){System.out.println("hello "+se.getMessage());}
      
      
      return ar;
    }
    
    
    public ArrayList allClasses(){
//      try{        
//          DataConnection dc1=new DataConnection();
//          con=(Connection)dc1.Dataconnect();
//         }
//      catch(Exception e){}   
      ArrayList ar=new ArrayList();
//      String qr1="select distinct class from classes";
       String qr1="select distinct degree from suraj_degree";       //kapil
      try{
       psmt1=con.prepareStatement(qr1);
       rs1=psmt1.executeQuery();
       while(rs1.next()){
       ar.add(rs1.getString("degree"));    
       }
       }catch(SQLException se){}
      return ar;
    }
    
    public ArrayList typeByClass(Object cls){
//      try{        
//          DataConnection dc1=new DataConnection();
//          con=(Connection)dc1.Dataconnect();
//         }
//      catch(Exception e){}   
      ArrayList ar=new ArrayList();
      String qr1="select distinct type from coursetype where class='"+cls+"'";
      try{
       psmt1=con.prepareStatement(qr1);
       rs1=psmt1.executeQuery();
       while(rs1.next()){
       ar.add(rs1.getString("type"));    
       }
       }catch(SQLException se){}
      return ar;
    }  
    
    //public String retriveFees(Object cls,Object tp,Object hd,String gn,String ssn,String deg,String branch){
public String retriveFees(Object cls,Object hd,String gn,String ssn){
    //      try{        
//          DataConnection dc1=new DataConnection();
//          con=(Connection)dc1.Dataconnect();
//         }
//      catch(Exception e){}    
      String fee="";
      //String qr1="select fee from feechartdynam where session='"+ssn+"' and classes='"+cls+"' and type='"+tp+"' and heads='"+hd+"' and (gender='"+gn+"' or gender='COMMON')";
// kapil     String qr1="select fee from suraj_feechartdynam where session='"+ssn+"' and classes='"+cls+"' and degree='"+deg+"' and branch='"+branch+"' and heads='"+hd+"' and (gender='"+gn+"' or gender='COMMON')";
      String qr1="select fee from suraj_feechartdynam where session='"+ssn+"' and degree='"+cls+"' and heads='"+hd+"' and (gender='"+gn+"' or gender='COMMON')";
      try{
       psmt1=con.prepareStatement(qr1);
       rs1=psmt1.executeQuery();
       while(rs1.next()){
       fee=rs1.getString("fee");    
       }
       }
      catch(SQLException se){}
      return fee;
    }
    
    //public String retTotalFees(Object cls,Object tp,String gn,String ssn,String deg,String branch){
public String retTotalFees(Object cls,ArrayList al,String gn,String ssn){
    Connection conn=null;
      try{        
          DataConnection dc1=new DataConnection();
          conn=(Connection)dc1.Dataconnect();
         }
      catch(Exception e){}    
    String total="";
    double tt=0;
    double tot=0;
    try{
      //String qr1="select sum(fee) as total from suraj_feechartdynam where session='"+ssn+"' and classes='"+cls+"' and type='"+tp+"' and degree='"+deg+"' and branch='"+branch+"' and (gender='"+gn+"' or gender='COMMON')";
    for(int i=0;i<al.size();i++)
    {
// kapil    String qr1="select fee from suraj_feechartdynam where session='"+ssn+"' and degree='"+cls+"' and degree='"+deg+"' and branch='"+branch+"' and heads='"+al.get(i)+"' and (gender='"+gn+"' or gender='COMMON')";
      String qr1="select fee from suraj_feechartdynam where session='"+ssn+"' and degree='"+cls+"' and heads='"+al.get(i)+"' and (gender='"+gn+"' or gender='COMMON')";
//      System.out.println(qr1);
       psmt1=conn.prepareStatement(qr1);
       rs1=psmt1.executeQuery();
       if(rs1.next()){
       tot=rs1.getDouble("fee"); 
       tt=tt+tot;
       }
        
        rs1.close();
    }
    total=Double.toString(tt);
   // System.out.println("total "+cls+": "+total);
      if(total==null || total.equals("null")){
      total="";    
      }
      }
      catch(SQLException se){}
     finally{
          try{
              if(rs1!=null){rs1.close();}
              if(psmt1!=null){psmt1.close();}
              if(conn!=null){conn.close();}
          }catch(Exception e){}
      }
      return total;
    }

public String retStaffTotalFees(Object cls,ArrayList al,String gn,String ssn){
    Connection conn=null;
      try{        
          DataConnection dc1=new DataConnection();
          conn=(Connection)dc1.Dataconnect();
         }
      catch(Exception e){}    
    String total="";
    double tt=0;
    double tot=0;
    try{
      //String qr1="select sum(fee) as total from suraj_feechartdynam where session='"+ssn+"' and classes='"+cls+"' and type='"+tp+"' and degree='"+deg+"' and branch='"+branch+"' and (gender='"+gn+"' or gender='COMMON')";
    for(int i=0;i<al.size();i++)
    {
// kapil    String qr1="select fee from suraj_feechartdynam where session='"+ssn+"' and degree='"+cls+"' and degree='"+deg+"' and branch='"+branch+"' and heads='"+al.get(i)+"' and (gender='"+gn+"' or gender='COMMON')";
      String qr1="select fee from suraj_feechartdynam where session='"+ssn+"' and degree='"+cls+"' and heads='"+al.get(i)+"' and (gender='"+gn+"' or gender='COMMON')";
//      System.out.println(qr1);
       psmt1=conn.prepareStatement(qr1);
       rs1=psmt1.executeQuery();
       if(rs1.next()){
           if(al.get(i).toString().equals("TUITION FEE"))   
                tot=Math.round(rs1.getDouble("fee")/2);
           else
               tot=rs1.getDouble("fee");
       }
        tt=tt+tot;
        rs1.close();
    }
    total=Double.toString(tt);
      if(total==null || total.equals("null")){
      total="";    
      }
      }
      catch(SQLException se){}
     finally{
          try{
              if(rs1!=null){rs1.close();}
              if(psmt1!=null){psmt1.close();}
              if(conn!=null){conn.close();}
          }catch(Exception e){}
      }
      return total;
    }

public double financialProgrammeFee(SchoolEO seo)
{
    Connection conn=null;
      try{        
          DataConnection dc1=new DataConnection();
          conn=(Connection)dc1.Dataconnect();
         }
      catch(Exception e){}    
    
    double tt=0;
    
     String batch=seo.getSession().substring(0, seo.getSession().indexOf("-"));
      String qr1="select fee from finan_programme where prog=? and batch=?";
      try{
       psmt1=conn.prepareStatement(qr1);
       psmt1.setString(1, seo.getDegree());
       psmt1.setString(2, batch);
       rs1=psmt1.executeQuery();
       if(rs1.next()){
       tt=rs1.getDouble("fee");    
       }
      }
      catch(SQLException se){}
     finally{
          try{
              if(rs1!=null){rs1.close();}
              if(psmt1!=null){psmt1.close();}
              if(conn!=null){conn.close();}
          }catch(Exception e){}
      }
    return tt;
}
    
    public void closeCon(){
    try{    
    if(con!=null){con.close();}
    }catch(Exception e){}
    }
    
}
