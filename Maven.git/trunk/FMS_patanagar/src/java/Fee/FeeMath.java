/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fee;

import java.util.*;
import Beans.JavaBean;
import java.sql.*;
import EO.*;
import java.text.*;
import java.io.*;
import Beans.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.myapp.struts.Dataconnectivity;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.struts.upload.FormFile;
import pant.common.CommonFunctionality;
import schedule.DataObjectFee;

/**
 *
 * @author kapil
 */
public class FeeMath {
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

public SchoolEO retFeeRecData(SchoolEO seo){ 
       Connection con=null;
       PreparedStatement pss=null;
       ResultSet rss=null;
       ArrayList ar=new ArrayList();
        ArrayList ar1=new ArrayList();
        ArrayList ar2=new ArrayList();
         ArrayList sub=new ArrayList();
       HashMap hm=new HashMap();
        HashMap hm1=new HashMap();
         HashMap hm2=new HashMap();
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
//      qr3="select studname,gender,seekadd,fname,degree,branch,stud_type from studentregis where session='"+seo.getSession()+"' and srnum='"+seo.getRegistNo()+"'";
      qr3="select studname,gender,seekadd,fname,stud_type,category,icar,gate,semester,batch from studentregis where session='"+seo.getSession()+"' and srnum='"+seo.getRegistNo()+"'";  
//      System.out.println(qr3);
      psmt1=con.prepareStatement(qr3);
      rs1=psmt1.executeQuery();  
      if(rs1.next()){
      seo.setSname(rs1.getString("studname"));
      seo.setGender(rs1.getString("gender"));
      seo.setClasses(rs1.getString("seekadd")); 
      seo.setFname(rs1.getString("fname"));
//      seo.setDegree(rs1.getString("degree"));
//      seo.setBranch(rs1.getString("branch"));
      seo.setStud_type(rs1.getString("stud_type"));
      seo.setCategory(rs1.getString("category"));
      seo.setIcar(rs1.getString("icar"));
      seo.setGate(rs1.getString("gate"));
      if(rs1.getString("semester")!=null)
      {
          seo.setSemester(rs1.getString("semester"));
      }
      else
       seo.setSemester("0");
      seo.setBatch(rs1.getString("batch"));
      }else{
      qr3="select studname,gender,seekadd,fname,category,semester,batch from oldregis where session='"+seo.getSession()+"' and srnum='"+seo.getRegistNo()+"'";  
      psmt1=con.prepareStatement(qr3);
      rs1=psmt1.executeQuery(); 
      if(rs1.next()){
      seo.setSname(rs1.getString("studname"));
      seo.setGender(rs1.getString("gender"));
      seo.setClasses(rs1.getString("seekadd")); 
      seo.setFname(rs1.getString("fname"));
      seo.setCategory(rs1.getString("category"));
      if(rs1.getString("semester")!=null)
      {
          seo.setSemester(rs1.getString("semester"));
      }
      else
       seo.setSemester("1");
      seo.setBatch(rs1.getString("batch"));
      }
      } 
      
      
//      String subm_time="";
//      String sst="select last_date, fine_per_day, max_fine from latefine_onfee where degree='"+seo.getDegree()+"' and semester='"+seo.getClasses()+"'";
//      pst=con.prepareStatement(sst);
//      rst=pst.executeQuery();
//      if(rst.next())
//      {
//          subm_time=rst.getString("last_date");
//          seo.setLastdate(subm_time);
//          seo.setPfine(rst.getDouble("fine_per_day"));
//          seo.setMax_fine(rst.getDouble("max_fine"));
//          
//      }
//      SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
//      java.util.Date dt=null;
//      try{
//      dt=(java.util.Date)sdf.parse(subm_time);
//     
//      java.util.Date dt1=new java.util.Date();
//      int days=(int)((dt1.getTime()-dt.getTime())/(1000 * 60 * 60 * 24));
//      if(days<0){
//      seo.setTot_days(0); 
//      }
//      else
//      {
//          seo.setTot_days(days);
//      }
//       }catch(Exception eee){ System.out.println("parse "+eee.getMessage());}
      
      
//      String qr2="select count(*) as cnt from class_sub where class='"+seo.getClasses()+"' and practical='YES' and subject in (select subject from stud_subject where session='"+seo.getSession()+"' and classes='"+seo.getClasses()+"' and admin_no='"+seo.getRegistNo()+"')";  
//      psmt2=con.prepareStatement(qr2);
//      rs2=psmt2.executeQuery();
//      if(rs2.next()){
//      count=rs2.getInt("cnt");  
//      }      
//      if(count==0){feetyp="NON PRAC";}
//      if(count==1){feetyp="ONE PRAC";}
//      if(count==2){feetyp="TWO PRAC";}
//      if(count==3){feetyp="THREE PRAC";}
//      seo.setType(feetyp);
      
      
//      String qr5="select distinct heads from feeheads where head_type='TREASURY'";
//      psmt4=con.prepareStatement(qr5);
//      rs4=psmt4.executeQuery();
//      while(rs4.next()){
//      ar.add(rs4.getString("heads"));    
//      }
      
      String qr6="";
      if(seo.getStud_type()!=null){
      if(seo.getStud_type().equals("Day Scholar")){
//      qr6="select distinct heads from feeheads where head_type<>'TREASURY'";
//          qr6="select distinct heads, heads_cat from feeheads order by heads_cat";
          qr6="select distinct heads, heads_cat from feeheads where stud_type='Day Scholar' order by heads_cat";
      }
      else
      {
//          qr6="select distinct heads, heads_cat from feeheads where stud_type='Day Scholar' order by heads_cat";
          qr6="select distinct heads, heads_cat from feeheads order by heads_cat";
          seo.setStud_type("Hosteller");
      }
      }
      else
      {
//         qr6="select distinct heads, heads_cat from feeheads where stud_type='Day Scholar' order by heads_cat";
         qr6="select distinct heads, heads_cat from feeheads order by heads_cat";
         seo.setStud_type("Hosteller");
      }
      psmt5=con.prepareStatement(qr6);
      rs5=psmt5.executeQuery(); 
      while(rs5.next()){
      ar.add(rs5.getString("heads"));
      hm1.put(rs5.getString("heads"), rs5.getString("heads_cat"));
      }
      
      
//      for(int i=0;i<2;i++){System.out.println("check: "+hm1.get("GAMES FEE"));}
      String qry="select distinct heads_cat from feeheads order by heads_cat";
      psmt6=con.prepareStatement(qry);
      rs6=psmt6.executeQuery(); 
      while(rs6.next()){
      ar1.add(rs6.getString("heads_cat"));
      }
//       System.out.println("check: "+ar.size());
       String qry1="";
       if(seo.getStud_type()!=null){
       if(seo.getStud_type().equals("Hosteller")){
//      qr6="select distinct heads from feeheads where head_type<>'TREASURY'";
          qry1="select count(distinct heads) as cnt, heads_cat from feeheads group by heads_cat";
      }
      else
      {
          qry1="select count(distinct heads) as cnt, heads_cat from feeheads where stud_type='Day Scholar' group by heads_cat";
      }
       }
       else
       {
        qry1="select count(distinct heads) as cnt, heads_cat from feeheads where stud_type='Day Scholar' group by heads_cat";   
       }
       psmt6=con.prepareStatement(qry1);
      rs6=psmt6.executeQuery(); 
      while(rs6.next()){
          ar2.add(rs6.getInt("cnt"));
      hm2.put(rs6.getString("heads_cat"), rs6.getInt("cnt"));
      }
//      System.out.println("check1: "+ar1.size());
//        System.out.println("check2: "+ar2.size());
      
      ArrayList al=new ArrayList();
      ArrayList al1=new ArrayList();
      ArrayList al2=new ArrayList();
      ArrayList al3=new ArrayList();
      ArrayList al4=new ArrayList();
      ArrayList al5=new ArrayList();
      String qry2="select bank_name, draft_no, date, amount, type, rwid from stud_draft where session=? and session_sem=? and srnum=? and status=? and type=?";
      psmt6=con.prepareStatement(qry2);
      psmt6.setString(1, seo.getSession());
      psmt6.setString(2, seo.getSession_sem());
      psmt6.setString(3, seo.getRegistNo());
      psmt6.setString(4, "paid");
      psmt6.setString(5, "counselling");
      rs6=psmt6.executeQuery(); 
      while(rs6.next()){
          al.add(rs6.getString("bank_name"));
          al1.add(rs6.getString("draft_no"));
          al2.add(rs6.getString("date"));
          al3.add(rs6.getDouble("amount"));
          al4.add(rs6.getString("type"));
          al5.add(rs6.getLong("rwid"));
      }
      seo.setDataArray4(al);
      seo.setDataArray5(al1);
      seo.setDataArray6(al2);
      seo.setDataArray7(al3);
      seo.setDataArray8(al4);
      seo.setDataArray9(al5);
      
      String batch=seo.getSession().substring(0, seo.getSession().indexOf("-"));
      String qry3="select fee from finan_programme where prog=? and batch=?";
      psmt5=con.prepareStatement(qry3);
      psmt5.setString(1, seo.getDegree());
      psmt5.setString(2, batch);
      rs5=psmt5.executeQuery();
      if(rs5.next())
      {
          seo.setPamount(rs5.getDouble("fee"));
      }
   
      //String qr="select * from feechartdynam where heads=? and session='"+seo.getSession()+"' and classes='"+seo.getClasses()+"' and (gender='"+seo.getGender()+"' or gender='COMMON') and type='"+seo.getType()+"' order by heads";    
       String qr1="select * from suraj_feechartdynam where heads=? and session='"+seo.getSession()+"' and degree='"+seo.getDegree()+"' "
               + "and (gender='"+seo.getGender()+"' or gender='COMMON') order by heads"; 
      psmt=con.prepareStatement(qr1);        
//      System.out.println("check "+seo.getStud_type());
      if(seo.getStud_type().equalsIgnoreCase("Staff")){
      for(int j=0;j<ar.size();j++){
          hm.put(ar.get(j),"0");
      }
      if(hm.containsKey("TUITION FEE"))
           {  
               psmt.setString(1,"TUITION FEE");
               rs=psmt.executeQuery(); 
               if(rs.next())
               {
                   hm.remove("TUITION FEE");
                   hm.put("TUITION FEE",Math.round(rs.getDouble("fee")/2));
                   feetot=feetot+Math.round(rs.getDouble("fee")/2);
               }
           }
      if(hm.containsKey("LAB FEE"))
      {
          psmt.setString(1,"LAB FEE");
               rs=psmt.executeQuery(); 
               if(rs.next())
               {
                   hm.remove("LAB FEE");
                   hm.put("LAB FEE",Math.round(rs.getDouble("fee")));
                   feetot=feetot+Math.round(rs.getDouble("fee"));
               }
      }
    }
      else{
          for(int j=0;j<ar.size();j++){
            psmt.setString(1,ar.get(j).toString());
            rs=psmt.executeQuery();  
            if(rs.next()){
                hm.put(ar.get(j),rs.getString("fee"));
                feetot=feetot+rs.getDouble("fee");
//          System.out.println("check "+(i+1)+": "+ar1.size());
            }
        }         
      }
      seo.setDataArray2(ar);
//      System.out.println("helloooo "+seo.getDataArray2().size());
      seo.setDataArray(ar1);
       seo.setDataArray1(ar2);
      seo.setDataMap(hm);
      seo.setDataMap1(hm1);
      seo.setDataMap2(hm2);
      seo.setFeeTotal(feetot);
      seo.setDataArray3(this.bankList());
//      System.out.println("good "+seo.getDataArray3().size());
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
         if(rs6!=null){rs6.close();} 
         if(rst!=null){rst.close();} 
         if(rss!=null){rss.close();}
          if(pss!=null){pss.close();}
         if(pst!=null){pst.close();}
         if(psmt3!=null){psmt3.close();}          
         if(psmt2!=null){psmt2.close();} 
         if(psmt!=null){psmt.close();} 
         if(psmt4!=null){psmt4.close();} 
         if(psmt5!=null){psmt5.close();}
          if(psmt6!=null){psmt6.close();}
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      } 
      
      seo.setCounter(cn);
     return seo;   
}


public SchoolEO retChangeFeeRecData(SchoolEO seo){ 
       Connection con=null;
       PreparedStatement pss=null;
       ResultSet rss=null;
       ArrayList ar=new ArrayList();
        ArrayList ar1=new ArrayList();
        ArrayList ar2=new ArrayList();
         ArrayList sub=new ArrayList();
       HashMap hm=new HashMap();
        HashMap hm1=new HashMap();
         HashMap hm2=new HashMap();
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
//      qr3="select studname,gender,seekadd,fname,degree,branch,stud_type from studentregis where session='"+seo.getSession()+"' and srnum='"+seo.getRegistNo()+"'";
      qr3="select studname,gender,seekadd,fname,category,icar,gate,semester,batch from studentregis where session='"+seo.getSession()+"' and srnum='"+seo.getRegistNo()+"'";  
      psmt1=con.prepareStatement(qr3);
      rs1=psmt1.executeQuery();  
      if(rs1.next()){
      seo.setSname(rs1.getString("studname"));
      seo.setGender(rs1.getString("gender"));
      seo.setClasses(rs1.getString("seekadd")); 
      seo.setFname(rs1.getString("fname"));
//      seo.setDegree(rs1.getString("degree"));
//      seo.setBranch(rs1.getString("branch"));
      seo.setCategory(rs1.getString("category"));
      seo.setIcar(rs1.getString("icar"));
      seo.setGate(rs1.getString("gate"));
      if(rs1.getString("semester")!=null)
      {
          seo.setSemester(rs1.getString("semester"));
      }
      else
       seo.setSemester("0");
      seo.setBatch(rs1.getString("batch"));

      }else{
      qr3="select studname,gender,seekadd,fname,category,semester,batch from oldregis where session='"+seo.getSession()+"' and srnum='"+seo.getRegistNo()+"'";  
      psmt1=con.prepareStatement(qr3);
      rs1=psmt1.executeQuery(); 
      if(rs1.next()){
      seo.setSname(rs1.getString("studname"));
      seo.setGender(rs1.getString("gender"));
      seo.setClasses(rs1.getString("seekadd")); 
      seo.setFname(rs1.getString("fname"));
      seo.setCategory(rs1.getString("category"));
      if(rs1.getString("semester")!=null)
      {
          seo.setSemester(rs1.getString("semester"));
      }
      else
       seo.setSemester("0");
      seo.setBatch(rs1.getString("batch"));
      }
      } 
      
      
//      String subm_time="";
//      String sst="select last_date, fine_per_day, max_fine from latefine_onfee where degree='"+seo.getDegree()+"' and semester='"+seo.getClasses()+"'";
//      pst=con.prepareStatement(sst);
//      rst=pst.executeQuery();
//      if(rst.next())
//      {
//          subm_time=rst.getString("last_date");
//          seo.setLastdate(subm_time);
//          seo.setPfine(rst.getDouble("fine_per_day"));
//          seo.setMax_fine(rst.getDouble("max_fine"));
//          
//      }
//      SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
//      java.util.Date dt=null;
//      try{
//      dt=(java.util.Date)sdf.parse(subm_time);
//     
//      java.util.Date dt1=new java.util.Date();
//      int days=(int)((dt1.getTime()-dt.getTime())/(1000 * 60 * 60 * 24));
//      if(days<0){
//      seo.setTot_days(0); 
//      }
//      else
//      {
//          seo.setTot_days(days);
//      }
//       }catch(Exception eee){ System.out.println("parse "+eee.getMessage());}
//      
//      
//      String qr2="select count(*) as cnt from class_sub where class='"+seo.getClasses()+"' and practical='YES' and subject in (select subject from stud_subject where session='"+seo.getSession()+"' and classes='"+seo.getClasses()+"' and admin_no='"+seo.getRegistNo()+"')";  
//      psmt2=con.prepareStatement(qr2);
//      rs2=psmt2.executeQuery();
//      if(rs2.next()){
//      count=rs2.getInt("cnt");  
//      }      
//      if(count==0){feetyp="NON PRAC";}
//      if(count==1){feetyp="ONE PRAC";}
//      if(count==2){feetyp="TWO PRAC";}
//      if(count==3){feetyp="THREE PRAC";}
//      seo.setType(feetyp);
      
      
//      String qr5="select distinct heads from feeheads where head_type='TREASURY'";
//      psmt4=con.prepareStatement(qr5);
//      rs4=psmt4.executeQuery();
//      while(rs4.next()){
//      ar.add(rs4.getString("heads"));    
//      }
      
      String qr6="";
      if(seo.getStud_type().equals("Hosteller")){
//      qr6="select distinct heads from feeheads where head_type<>'TREASURY'";
          qr6="select distinct heads, heads_cat from feeheads order by heads_cat";
      }
      else
      {
          qr6="select distinct heads, heads_cat from feeheads where stud_type='Day Scholar' order by heads_cat";
      }
      psmt5=con.prepareStatement(qr6);
      rs5=psmt5.executeQuery(); 
      while(rs5.next()){
      ar.add(rs5.getString("heads"));
      hm1.put(rs5.getString("heads"), rs5.getString("heads_cat"));
      }
//      for(int i=0;i<2;i++){System.out.println("check: "+hm1.get("GAMES FEE"));}
      String qry="select distinct heads_cat from feeheads order by heads_cat";
      psmt6=con.prepareStatement(qry);
      rs6=psmt6.executeQuery(); 
      while(rs6.next()){
      ar1.add(rs6.getString("heads_cat"));
      }
//       System.out.println("check: "+ar.size());
       String qry1="";
       if(seo.getStud_type().equals("Hosteller")){
//      qr6="select distinct heads from feeheads where head_type<>'TREASURY'";
          qry1="select count(distinct heads) as cnt, heads_cat from feeheads group by heads_cat";
      }
      else
      {
          qry1="select count(distinct heads) as cnt, heads_cat from feeheads where stud_type='Day Scholar' group by heads_cat";
      }
       psmt6=con.prepareStatement(qry1);
      rs6=psmt6.executeQuery(); 
      while(rs6.next()){
          ar2.add(rs6.getInt("cnt"));
      hm2.put(rs6.getString("heads_cat"), rs6.getInt("cnt"));
      }
//      System.out.println("check1: "+ar1.size());
//        System.out.println("check2: "+ar2.size());
      ArrayList al=new ArrayList();
      ArrayList al1=new ArrayList();
      ArrayList al2=new ArrayList();
      ArrayList al3=new ArrayList();
      ArrayList al4=new ArrayList();
      ArrayList al5=new ArrayList();
      String qry2="select bank_name, draft_no, date, amount, type, rwid from stud_draft where session=? and session_sem=? and srnum=? and status=? and type=?";
      psmt6=con.prepareStatement(qry2);
      psmt6.setString(1, seo.getSession());
      psmt6.setString(2, seo.getSession_sem());
      psmt6.setString(3, seo.getRegistNo());
      psmt6.setString(4, "paid");
      psmt6.setString(5, "counselling");
      rs6=psmt6.executeQuery(); 
      while(rs6.next()){
          al.add(rs6.getString("bank_name"));
          al1.add(rs6.getString("draft_no"));
          al2.add(rs6.getString("date"));
          al3.add(rs6.getDouble("amount"));
           al4.add(rs6.getString("type"));
           al5.add(rs6.getLong("rwid"));
          
      }
      seo.setDataArray4(al);
      seo.setDataArray5(al1);
      seo.setDataArray6(al2);
      seo.setDataArray7(al3);
      seo.setDataArray8(al4);
      seo.setDataArray9(al5);
      
      String batch=seo.getSession().substring(0, seo.getSession().indexOf("-"));
      String qry3="select fee from finan_programme where prog=? and batch=?";
      psmt5=con.prepareStatement(qry3);
      psmt5.setString(1, seo.getDegree());
      psmt5.setString(2, batch);
      rs5=psmt5.executeQuery();
      if(rs5.next())
      {
          seo.setPamount(rs5.getDouble("fee"));
      }
   
      //String qr="select * from feechartdynam where heads=? and session='"+seo.getSession()+"' and classes='"+seo.getClasses()+"' and (gender='"+seo.getGender()+"' or gender='COMMON') and type='"+seo.getType()+"' order by heads";    
       String qr1="select * from suraj_feechartdynam where heads=? and session='"+seo.getSession()+"' and degree='"+seo.getDegree()+"' and (gender='"+seo.getGender()+"' or gender='COMMON') order by heads"; 
      
      
      
      psmt=con.prepareStatement(qr1);        
//      for(int i=0;i<ar.size();i++){
//      psmt.setString(1,ar.get(i).toString());
//      rs=psmt.executeQuery();  
//      if(rs.next()){
//      hm.put(ar.get(i),rs.getString("fee"));
//      
//      feetot=feetot+rs.getDouble("fee");
//      }         
//      }
      
      if(seo.getStud_type().equalsIgnoreCase("Staff")){
      for(int j=0;j<ar.size();j++){
          hm.put(ar.get(j),"0");
      }
      if(hm.containsKey("TUITION FEE"))
           {  
               psmt.setString(1,"TUITION FEE");
               rs=psmt.executeQuery(); 
               if(rs.next())
               {
                   hm.remove("TUITION FEE");
                   hm.put("TUITION FEE",Math.round(rs.getDouble("fee")/2));
                   feetot=feetot+Math.round(rs.getDouble("fee")/2);
               }
           }
      if(hm.containsKey("LAB FEE"))
      {
          psmt.setString(1,"LAB FEE");
               rs=psmt.executeQuery(); 
               if(rs.next())
               {
                   hm.remove("LAB FEE");
                   hm.put("LAB FEE",Math.round(rs.getDouble("fee")));
                   feetot=feetot+Math.round(rs.getDouble("fee"));
               }
      }
    }
      else{
          for(int j=0;j<ar.size();j++){
            psmt.setString(1,ar.get(j).toString());
            rs=psmt.executeQuery();  
            if(rs.next()){
                hm.put(ar.get(j),rs.getString("fee"));
                feetot=feetot+rs.getDouble("fee");
//          System.out.println("check "+(i+1)+": "+ar1.size());
            }
        }         
      }
      seo.setDataArray2(ar);
//      System.out.println("helloooo "+seo.getDataArray2().size());
      seo.setDataArray(ar1);
       seo.setDataArray1(ar2);
      seo.setDataMap(hm);
      seo.setDataMap1(hm1);
      seo.setDataMap2(hm2);
      seo.setFeeTotal(feetot);
      seo.setDataArray3(this.bankList());
//      System.out.println("good "+seo.getDataArray3().size());
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
         if(rs6!=null){rs6.close();} 
         if(rst!=null){rst.close();} 
         if(rss!=null){rss.close();}
          if(pss!=null){pss.close();}
         if(pst!=null){pst.close();}
         if(psmt3!=null){psmt3.close();}          
         if(psmt2!=null){psmt2.close();} 
         if(psmt!=null){psmt.close();} 
         if(psmt4!=null){psmt4.close();} 
         if(psmt5!=null){psmt5.close();}
          if(psmt6!=null){psmt6.close();}
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      } 
      
      seo.setCounter(cn);
     return seo;   
}

public int subEnrolledData(SchoolEO seo, java.sql.Date depositeDate,Connection conSave){ 
//  SimpleDateFormat sdf=new SimpleDateFormat("yy");  
//  java.util.Date dat=new java.util.Date();  
  Connection con=null;
  ArrayList al=new ArrayList();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  //con.setAutoCommit(false); 
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
            int sem=Integer.parseInt(seo.getSemester())+1;
            String qr2="insert into sub_feedata(session,regist_no,sname,classes,type,gender,fee_total,enroll_no,fee_receipt,semester,batch,session_sem,"
                    + "subm_bank,deposit_date,advance,adjstDraftTtAndFeeTt) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";        
            psmt2=conSave.prepareStatement(qr2);
            psmt2.setString(1,seo.getSession());
            psmt2.setString(2,seo.getRegistNo());
            psmt2.setString(3,seo.getSname());
            psmt2.setString(4,seo.getDegree());
            psmt2.setString(5,seo.getType());
            psmt2.setString(6,seo.getGender());
            psmt2.setDouble(7,seo.getFeeTotal());
            psmt2.setString(8,seo.getEnrolNo());
            psmt2.setLong(9,seo.getFeeReceipt());
            psmt2.setString(10,Integer.toString(sem));
            psmt2.setString(11,seo.getBatch());
            psmt2.setString(12,seo.getSession_sem());
            psmt2.setString(13,seo.getBankname());
            psmt2.setDate(14, new java.sql.Date(new java.util.Date().getTime()));
            psmt2.setDouble(15,seo.getAdvance());
            psmt2.setDouble(16, seo.getAdjustment());
            psmt2.executeUpdate();      

            String qr4="update studentregis set enroll_no=?, degree=?, stud_type=?, icar=?, gate=?, semester=?,college=? where session='"+seo.getSession()+"'"
                    + " and srnum='"+seo.getRegistNo()+"'";
            psmt4=conSave.prepareStatement(qr4);
            psmt4.setString(1,seo.getEnrolNo());
            psmt4.setString(2,seo.getDegree());
            psmt4.setString(3,seo.getStud_type());
             psmt4.setString(4,seo.getIcar());
              psmt4.setString(5,seo.getGate());

              psmt4.setString(6, Integer.toString(sem));
              psmt4.setString(7, seo.getCollege());
            psmt4.executeUpdate();


      //      long rcpt=0;
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
            ArrayList ar4=new ArrayList();
            ArrayList ar5=new ArrayList();
            ar=seo.getDataArray();
            ar1=seo.getDataArray1();
            ar2=seo.getDataArray2();
            ar3=seo.getDataArray3();
            ar4=seo.getDataArray4();
            ar5=seo.getDataArray5();
            String qr6="insert into stud_fee_draft(session,srnum,draft_no,date,bank_name,amount,status,type,sname,deposite_date,receipt_no,"
                    + "Stud_draft_rwid,updation,degree,semester,batch,session_sem) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
             psmt6=conSave.prepareStatement(qr6);
             for(int i=0;i<5;i++)
             {
               if(i<ar.size()){
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
                      psmt6.setString(14, seo.getDegree());
                      psmt6.setString(15, Integer.toString(sem));
                      psmt6.setString(16, seo.getBatch());
                      psmt6.setString(17, seo.getSession_sem());
                     psmt6.addBatch();
               }
             }
             psmt6.executeBatch();
             //con.commit();

      }
       }
       catch(SQLException se){
            System.out.println("helloooo: "+se.getMessage());
            count=-1;
       }  
       finally{
       try{
         if(rs!=null){rs.close();}   
         if(rs3!=null){rs3.close();} 
         if(psmt!=null){psmt.close();} 
         if(psmt2!=null){psmt2.close();} 
         if(psmt3!=null){psmt3.close();} 
         if(psmt4!=null){psmt4.close();} 
         if(psmt6!=null){psmt6.close();} 
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      } 
     return count;   
}

public String genEnrolNo(SchoolEO seo,long no){     
     String enr="";
     String cod=genClassCode(seo);
     enr=cod+"/"+seo.getSession()+"/"+seo.getDegree()+"/"+no;
     return enr;   
}

public String genClassCode(SchoolEO seo){  
  String cod="";  
  Connection con=null;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){}       
    String strm="";
    String qr="select code from suraj_degree where degree='"+seo.getDegree()+"'";  
    try{
    psmt1=con.prepareStatement(qr);
    rs1=psmt1.executeQuery();
    if(rs1.next()){
    cod=rs1.getString("code"); 
    
    }
    }catch(SQLException se){}
    finally{
    try{
    if(rs1!=null){rs1.close();}
    if(psmt1!=null){psmt1.close();}
    }catch(SQLException se){} 
    }
     
     return cod;   
}



public long genFeeRecptNo(){
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

public ArrayList bankList()
{
    ArrayList bank=new ArrayList();
    Connection con=null;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }
  catch(Exception e){} 
   try{ 
   String qr1="select * from bank";
//   System.out.println(qr1);
      psmt=con.prepareStatement(qr1);
      rs=psmt.executeQuery();
      while(rs.next())
      {
        bank.add(rs.getString("bank_name"));
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
    
    return bank;
}

public ArrayList getStudentFeeDetail(SchoolEO seo)
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
       String qr5="select srnum,studname,fname,gender,degree,stud_type,category,gen_rank,batch,semester from studentregis where session=? and srnum=?";
     psmt5=con.prepareStatement(qr5);
     psmt5.setString(1, seo.getSession());
    psmt5.setString(2, seo.getRegistNo());
     rs=psmt5.executeQuery();
     if(rs.next()){
         seo1.setSrnum(rs.getString("srnum"));
         seo1.setSname(rs.getString("studname"));
         seo1.setFname(rs.getString("fname")); 
         seo1.setGender(rs.getString("gender"));
//         seo1.setStud_id(rs.getString("stud_id"));
         seo1.setDegree(rs.getString("degree"));
         seo1.setStud_type(rs.getString("stud_type"));
         seo1.setCategory(rs.getString("category"));
         seo1.setGen_rank(rs.getString("gen_rank"));
         seo1.setBatch(rs.getString("batch"));
         seo1.setSemester(rs.getString("semester"));
//         System.out.println("hello.......");
     }
       
   String qr6="select draft_no,date,bank_name,amount,type from stud_fee_draft where session=? and session_sem=? and srnum=?";     
   psmt=con.prepareStatement(qr6);
   psmt.setString(1, seo.getSession());
   psmt.setString(2, seo.getSession_sem());
   psmt.setString(3, seo.getRegistNo());
   rs1=psmt.executeQuery();
   while(rs1.next()){
//       System.out.println("hello: "+seo1.getStud_id());
       ar.add(rs1.getString("draft_no"));
       ar1.add(rs1.getString("date"));
       ar2.add(rs1.getString("bank_name"));
       ar3.add(rs1.getDouble("amount"));
       ar4.add(rs1.getString("type"));
//       System.out.println("KAPIL: ");
   }
   seo1.setDataArray(ar);
   seo1.setDataArray1(ar1);
   seo1.setDataArray2(ar2);
   seo1.setDataArray3(ar3);
   seo1.setDataArray4(ar4);
   al.add(seo1);
   }catch(SQLException se){
       System.out.println("Error in getting submitted fee drafts details: "+se.getMessage());
   }    
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


public SchoolEO genFeeScroll(SchoolEO seo){ 
       Connection con=null;
       PreparedStatement pss=null;
       ResultSet rss=null;
       ArrayList ar=new ArrayList();
        ArrayList ar1=new ArrayList();
        ArrayList ar2=new ArrayList();
         ArrayList sub=new ArrayList();
       HashMap hm=new HashMap();
        HashMap hm1=new HashMap();
         HashMap hm2=new HashMap();
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
      String qr4="select fee_receipt from sub_feedata where session=? and session_sem=? and stud_id=?";
      psmt3=con.prepareStatement(qr4);
      psmt3.setString(1, seo.getSession());
      psmt3.setString(2, seo.getSession_sem());
      psmt3.setString(3, seo.getStud_id());
      rs3=psmt3.executeQuery();  
      if(rs3.next()){ 
      seo.setFeeReceipt(rs3.getLong("fee_receipt"));    
      }
      String qr3="";      
//      qr3="select studname,gender,seekadd,fname,degree,branch,stud_type from studentregis where session='"+seo.getSession()+"' and srnum='"+seo.getRegistNo()+"'";
      qr3="select srnum,studname,gender,seekadd,fname,stud_type,category,icar,gate,stud_id,semester,batch from studentregis where stud_id='"+seo.getStud_id()+"' order by rowid desc";
      psmt1=con.prepareStatement(qr3);
      rs1=psmt1.executeQuery();  
      if(rs1.next()){
          seo.setRegistNo(rs1.getString("srnum"));
      seo.setSname(rs1.getString("studname"));
      seo.setGender(rs1.getString("gender"));
      seo.setClasses(rs1.getString("seekadd")); 
      seo.setFname(rs1.getString("fname"));
//      seo.setDegree(rs1.getString("degree"));
//      seo.setBranch(rs1.getString("branch"));
      seo.setStud_type(rs1.getString("stud_type"));
      seo.setCategory(rs1.getString("category"));
      seo.setIcar(rs1.getString("icar"));
       seo.setStud_id(rs1.getString("stud_id"));
      seo.setGate(rs1.getString("gate"));
      seo.setSemester(rs1.getString("semester"));
      seo.setBatch(rs1.getString("batch"));
      }else{
      qr3="select srnum,studname,gender,seekadd,fname,stud_type,category,icar,gate,stud_id,semester,batch from oldregis where stud_id='"+seo.getStud_id()+"'";
      psmt1=con.prepareStatement(qr3);
      rs1=psmt1.executeQuery(); 
      if(rs1.next()){
          seo.setRegistNo(rs1.getString("srnum"));
      seo.setSname(rs1.getString("studname"));
      seo.setGender(rs1.getString("gender"));
      seo.setClasses(rs1.getString("seekadd")); 
      seo.setFname(rs1.getString("fname"));
      seo.setStud_type(rs1.getString("stud_type"));
      seo.setCategory(rs1.getString("category"));
      seo.setIcar(rs1.getString("icar"));
       seo.setStud_id(rs1.getString("stud_id"));
      seo.setGate(rs1.getString("gate"));
      seo.setSemester(rs1.getString("semester"));
      seo.setBatch(rs1.getString("batch"));
      }
      } 
      
//      
//      String subm_time="";
//      String sst="select last_date, fine_per_day, max_fine from latefine_onfee where degree='"+seo.getDegree()+"' and semester='"+seo.getClasses()+"'";
//      pst=con.prepareStatement(sst);
//      rst=pst.executeQuery();
//      if(rst.next())
//      {
//          subm_time=rst.getString("last_date");
//          seo.setLastdate(subm_time);
//          seo.setPfine(rst.getDouble("fine_per_day"));
//          seo.setMax_fine(rst.getDouble("max_fine"));
//          
//      }
//      SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
//      java.util.Date dt=null;
//      try{
//      dt=(java.util.Date)sdf.parse(subm_time);
//     
//      java.util.Date dt1=new java.util.Date();
//      int days=(int)((dt1.getTime()-dt.getTime())/(1000 * 60 * 60 * 24));
//      if(days<0){
//      seo.setTot_days(0); 
//      }
//      else
//      {
//          seo.setTot_days(days);
//      }
//       }catch(Exception eee){ System.out.println("parse "+eee.getMessage());}
//      
      
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
      ArrayList fields=new ArrayList();
      String qr6="";
      
      if(seo.getStud_type().equals("Hosteller")){
//      qr6="select distinct heads from feeheads where head_type<>'TREASURY'";
          qr6="select distinct heads, heads_cat,field_name from feeheads order by heads_cat";
      }
      else
      {
          qr6="select distinct heads, heads_cat,field_name from feeheads where stud_type='Day Scholar' order by heads_cat";
//          seo.setStud_type("Day Scholar");
      }
//      System.out.println("qr6: "+qr6);
      psmt5=con.prepareStatement(qr6);
      rs5=psmt5.executeQuery(); 
      while(rs5.next()){
      ar.add(rs5.getString("heads"));
      fields.add(rs5.getString("field_name"));
      hm1.put(rs5.getString("heads"), rs5.getString("heads_cat"));
      }
//      for(int i=0;i<2;i++){System.out.println("check: "+hm1.get("GAMES FEE"));}
      String qry="select distinct heads_cat from feeheads order by heads_cat";
      psmt6=con.prepareStatement(qry);
      rs6=psmt6.executeQuery(); 
      while(rs6.next()){
      ar1.add(rs6.getString("heads_cat"));
      }
       
       String qry1="";
       
       if(seo.getStud_type().equals("Hosteller")){
//      qr6="select distinct heads from feeheads where head_type<>'TREASURY'";
          qry1="select count(distinct heads) as cnt, heads_cat from feeheads group by heads_cat";
          
      }
      else
      {
          qry1="select count(distinct heads) as cnt, heads_cat from feeheads where stud_type='Day Scholar' group by heads_cat";
      }
       
       
       psmt6=con.prepareStatement(qry1);
      rs6=psmt6.executeQuery(); 
      while(rs6.next()){
          ar2.add(rs6.getInt("cnt"));
      hm2.put(rs6.getString("heads_cat"), rs6.getInt("cnt"));
      }
//      System.out.println("check1: "+ar1.size());
//        System.out.println("check2: "+ar2.size());
      
      ArrayList al=new ArrayList();
      ArrayList al1=new ArrayList();
      ArrayList al2=new ArrayList();
      ArrayList al3=new ArrayList();
      ArrayList al4=new ArrayList();
      String qry2="select bank_name, draft_no, date, amount, type from stud_draft where session=? and session_sem=? and srnum=? and status='paid'";
      psmt6=con.prepareStatement(qry2);
      psmt6.setString(1, seo.getSession());
      psmt6.setString(2, seo.getSession_sem());
      psmt6.setString(3, seo.getRegistNo());
     
      rs6=psmt6.executeQuery(); 
      while(rs6.next()){
          al.add(rs6.getString("bank_name"));
          al1.add(rs6.getString("draft_no"));
          al2.add(rs6.getString("date"));
          al3.add(rs6.getDouble("amount"));
          al4.add(rs6.getString("type"));
          
      }
      seo.setDataArray4(al);
      seo.setDataArray5(al1);
      seo.setDataArray6(al2);
      seo.setDataArray7(al3);
      seo.setDataArray8(al4);
      
      String batch=seo.getSession().substring(0, seo.getSession().indexOf("-"));
      String qry3="select fee from finan_programme where prog=? and batch=?";
      psmt5=con.prepareStatement(qry3);
      psmt5.setString(1, seo.getDegree());
      psmt5.setString(2, batch);
      rs5=psmt5.executeQuery();
      if(rs5.next())
      {
          seo.setPamount(rs5.getDouble("fee"));
      }
   
      //String qr="select * from feechartdynam where heads=? and session='"+seo.getSession()+"' and classes='"+seo.getClasses()+"' and (gender='"+seo.getGender()+"' or gender='COMMON') and type='"+seo.getType()+"' order by heads";    
//       String qr1="select * from suraj_feechartdynam where heads=? and session='"+seo.getSession()+"' and degree='"+seo.getDegree()+"' and (gender='"+seo.getGender()+"' or gender='COMMON') order by heads"; 
//      
//      psmt=con.prepareStatement(qr1);        
//      for(int i=0;i<ar.size();i++){
//      psmt.setString(1,ar.get(i).toString());
//      rs=psmt.executeQuery();  
//      if(rs.next()){
//          
//      hm.put(ar.get(i),rs.getString("fee"));
//      
//      feetot=feetot+rs.getDouble("fee");
////      System.out.println("check "+(i+1)+": "+ar1.size());
//      }         
//      }
      
      String qr1="select * from stud_fee_detail where stud_id='"+seo.getStud_id()+"' and session='"+seo.getSession()+"' and session_sem='"+seo.getSession_sem()+"' order by rwid desc";
  //    System.out.println(qr1);
      psmt=con.prepareStatement(qr1);  
      rs=psmt.executeQuery();  
      if(rs.next())
      {
          seo.setDeposite_date(rs.getDate("submission_date"));
          seo.setSemester(rs.getString("semester"));
          for(int i=0;i<ar.size();i++){
              hm.put(ar.get(i),rs.getString(fields.get(i).toString()));
              feetot=feetot+rs.getDouble(fields.get(i).toString());
          }
      }
      seo.setDataArray2(ar);
//      System.out.println("helloooo "+hm);
      seo.setDataArray(ar1);
       seo.setDataArray1(ar2);
      seo.setDataMap(hm);
      seo.setDataMap1(hm1);
      seo.setDataMap2(hm2);
      seo.setFeeTotal(feetot);
      seo.setDataArray3(this.bankList());
//      System.out.println("good "+seo.getDataArray3().size());
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
         if(rs6!=null){rs6.close();} 
         if(rst!=null){rst.close();} 
         if(rss!=null){rss.close();}
          if(pss!=null){pss.close();}
         if(pst!=null){pst.close();}
         if(psmt3!=null){psmt3.close();}          
         if(psmt2!=null){psmt2.close();} 
         if(psmt!=null){psmt.close();} 
         if(psmt4!=null){psmt4.close();} 
         if(psmt5!=null){psmt5.close();}
          if(psmt6!=null){psmt6.close();}
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      } 
      
      seo.setCounter(cn);
     return seo;   
}

public ArrayList retStud_fee_draft(SchoolEO seo)
{
    Connection con=null;
    ReportsEO reo=null;
    ArrayList al=new ArrayList();
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
    
    try{
        String st="select bank_name,draft_no,date,amount from stud_fee_draft where stud_id=? and session=? and session_sem=? and srnum=? and type='addmission fee'";
//        System.out.println(st);
                psmt=con.prepareStatement(st);
                psmt.setString(1, seo.getStud_id());
                psmt.setString(2, seo.getSession());
                psmt.setString(3, seo.getSession_sem());
                psmt.setString(4, seo.getRegistNo());
                rs=psmt.executeQuery();
                while(rs.next())
                {
                    reo=new ReportsEO();
                    reo.setDraft_no(rs.getString("draft_no"));
                    reo.setDate(rs.getString("date"));
                    reo.setBank(rs.getString("bank_name"));
                    reo.setAmount(rs.getDouble("amount"));
                    al.add(reo);
                }
    }catch(Exception e){}
    return al;
}

public ArrayList retStud_fee_draftALL(SchoolEO seo)
{
    Connection con=null;
    ReportsEO reo=null;
    ArrayList al=new ArrayList();
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
    
    try{
        String st="select bank_name,draft_no,date,amount from stud_fee_draft where stud_id='"+seo.getStud_id()+"' and session='"+seo.getSession()+"'";
//        System.out.println(st);
                psmt=con.prepareStatement(st);
                rs=psmt.executeQuery();
                while(rs.next())
                {
                    reo=new ReportsEO();
                    reo.setDraft_no(rs.getString("draft_no"));
                    reo.setDate(rs.getString("date"));
                    reo.setBank(rs.getString("bank_name"));
                    reo.setAmount(rs.getDouble("amount"));
                    al.add(reo);
                }
    }catch(Exception e){}
    return al;
}

public ArrayList retDistBatch(String degree)
{
    ArrayList al=new ArrayList();
    Connection con=null;
       
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
      try{
          String qr="select distinct batch from stud_fee_detail where degree='"+degree+"' order by batch desc";
//          String qr="select distinct batch from stud_fee_detail_excel";
          psmt=con.prepareStatement(qr);
          rs=psmt.executeQuery();
          while(rs.next())
              al.add(rs.getString("batch"));
      }catch(SQLException se){System.out.println("Ex: "+se.getMessage());}  
       finally{
       try{
           if(rs!=null){rs.close();}   
         if(psmt!=null){psmt.close();}          
        }   
       catch(SQLException se){}
      } 
    return al;
}

public boolean checkDetailsInSub_FeedataTable(SchoolEO seo){
    boolean bn=false;
    Connection con=null;
       
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
      try{
          String qr="select * from sub_feedata where classes=? and session=? and session_sem=?";
          psmt=con.prepareStatement(qr);
          psmt.setString(1, seo.getDegree());
          psmt.setString(2, seo.getSession());
          psmt.setString(3, seo.getSession_sem());
          rs=psmt.executeQuery();
          if(rs.next())
             bn=true;
      }catch(SQLException se){System.out.println("Ex: "+se.getMessage());}  
       finally{
       try{
           if(rs!=null){rs.close();}   
         if(psmt!=null){psmt.close();}          
        }   
       catch(SQLException se){}
      } 
    return bn;
}
public boolean checkDetailsInExcelTable(SchoolEO seo){
    boolean bn=false;
    Connection con=null;
       
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
      try{
          String qr="select * from stud_fee_detail_excel where degree=? and batch=? and session=? and session_sem=?";
//          String qr="select distinct batch from stud_fee_detail_excel";
          psmt=con.prepareStatement(qr);
          psmt.setString(1, seo.getDegree());
          psmt.setString(2, seo.getBatch());
          psmt.setString(3, seo.getSession());
          psmt.setString(4, seo.getSession_sem());
          rs=psmt.executeQuery();
          if(rs.next())
             bn=true;
      }catch(SQLException se){System.out.println("Ex: "+se.getMessage());}  
       finally{
       try{
           if(rs!=null){rs.close();}   
         if(psmt!=null){psmt.close();}          
        }   
       catch(SQLException se){}
      } 
    return bn;
}
public ArrayList genFeeScrollProgwise_old(SchoolEO seo)
{
    SchoolEO seo1=new SchoolEO();
    ArrayList studlist=new ArrayList();
    ArrayList stud_datalist=new ArrayList();
    ArrayList al=new ArrayList();
     Connection con=null;
       PreparedStatement pss=null;
       ResultSet rss=null;
       
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
      String feetyp="";  
      
      PreparedStatement pst=null;
      ResultSet rst=null;
       
      
      try{
        int counter=0; 
        String qr="select count(stud_id) as cn from oldregis where batch='"+seo.getBatch()+"' and degree='"+seo.getDegree()+"' and stud_id <> 'NULL'";
        psmt1=con.prepareStatement(qr);
        rs=psmt1.executeQuery();
        if(rs.next())
            counter=rs.getInt("cn");
        rs.close();
         
      String qr3=""; 
      if(counter!=0){
      qr3="select studname,gender,fname,stud_type,category,icar,gate,stud_id,degree,semester,batch,new_beni,college from oldregis"
              + " where batch='"+seo.getBatch()+"' and degree='"+seo.getDegree()+"' and stud_id <> 'NULL'"
              + " and stud_id not in (select stud_id from transfered_student)";   
      psmt1=con.prepareStatement(qr3);
      rs1=psmt1.executeQuery(); 
      while(rs1.next()){
          seo1=new SchoolEO();
      seo1.setSname(rs1.getString("studname"));
      seo1.setGender(rs1.getString("gender"));
      seo1.setDegree(rs1.getString("degree"));
      seo1.setSemester(rs1.getString("semester")); 
      seo1.setFname(rs1.getString("fname"));
      seo1.setStud_type(rs1.getString("stud_type"));
      seo1.setCategory(rs1.getString("category"));
      seo1.setIcar(rs1.getString("icar"));
       seo1.setStud_id(rs1.getString("stud_id"));
      seo1.setGate(rs1.getString("gate"));
      seo1.setBatch(rs1.getString("batch"));
      seo1.setNewBeni(rs1.getString("new_beni"));
      seo1.setCollege(rs1.getString("college"));
      studlist.add(seo1);
      }
      }
else{
      //      qr3="select studname,gender,seekadd,fname,degree,branch,stud_type from studentregis where session='"+seo.getSession()+"' and srnum='"+seo.getRegistNo()+"'";
      qr3="select studname,gender,fname,stud_type,category,icar,gate,stud_id,degree,semester,batch,new_beni,college from studentregis"
              + " where batch='"+seo.getBatch()+"' and degree='"+seo.getDegree()+"' and stud_id <> 'NULL' "
              + "and stud_id not in (select stud_id from transfered_student)";  
      psmt1=con.prepareStatement(qr3);
      rs1=psmt1.executeQuery();  
      while(rs1.next()){
          seo1=new SchoolEO();
      seo1.setSname(rs1.getString("studname"));
      seo1.setGender(rs1.getString("gender"));
//      seo.setClasses(rs1.getString("seekadd")); 
      seo1.setFname(rs1.getString("fname"));
      seo1.setDegree(rs1.getString("degree"));
      seo1.setSemester(rs1.getString("semester"));
      seo1.setStud_type(rs1.getString("stud_type"));
      seo1.setCategory(rs1.getString("category"));
      seo1.setIcar(rs1.getString("icar"));
       seo1.setStud_id(rs1.getString("stud_id"));
      seo1.setGate(rs1.getString("gate"));
      seo1.setBatch(rs1.getString("batch"));
      seo1.setNewBeni(rs1.getString("new_beni"));
      seo1.setCollege(rs1.getString("college"));
      studlist.add(seo1);
      }
      } 
//      System.out.println(studlist.size());
     
 for(int i=0;i<studlist.size();i++)
   {
       ArrayList ar=new ArrayList();
       HashMap hm=new HashMap();
        ArrayList staffheads=new ArrayList();
        
       seo1=(SchoolEO)studlist.get(i);
//       System.out.println(seo1);
       int n=Integer.parseInt(seo1.getSemester())+1;
       n=n%2;
       String qr6="";
//       String st="";
      if(n!=0){
      if(seo1.getStud_type().equals("Hosteller")){
//      qr6="select distinct heads from feeheads where head_type<>'TREASURY'";
          qr6="select distinct heads, heads_cat from feeheads where fee_type<>'Once At Admission' order by heads_cat desc";
      }
      else
      {
          qr6="select distinct heads, heads_cat from feeheads where stud_type='Day Scholar' and fee_type<>'Once At Admission' order by heads_cat desc";
//          seo.setStud_type("Day Scholar");
      }
//      if(seo1.getStud_type().equalsIgnoreCase("Staff"))
//      {
//          st="select distinct heads, heads_cat from feeheads where stud_type like '%Staff%' and fee_type<>'Once At Admission' order by heads_cat desc";
//      }
      
    }
      else{
          if(seo1.getStud_type().equals("Hosteller")){
//      qr6="select distinct heads from feeheads where head_type<>'TREASURY'";
          qr6="select distinct heads, heads_cat from feeheads where fee_type ='Semester Fee' order by heads_cat desc";
      }
      else
      {
          qr6="select distinct heads, heads_cat from feeheads where stud_type='Day Scholar' and fee_type='Semester Fee' order by heads_cat desc";
//          seo.setStud_type("Day Scholar");
      }
          
//      if(seo1.getStud_type().equalsIgnoreCase("Staff"))
//      {
//          st="select distinct heads, heads_cat from feeheads where stud_type like '%Staff%' and fee_type='Semester Fee' order by heads_cat desc";
//      }
    }
//      System.out.println("Query6: "+qr6);
//      System.out.println("st: "+st);
      psmt5=con.prepareStatement(qr6);
      rs5=psmt5.executeQuery(); 
      while(rs5.next()){
      ar.add(rs5.getString("heads"));
//      hm1.put(rs5.getString("heads"), rs5.getString("heads_cat"));
      }
      
//      if(seo1.getStud_type().equalsIgnoreCase("staff"))
//      {
//      rs5.close();
//      psmt5=con.prepareStatement(st);
//      rs5=psmt5.executeQuery(); 
//      while(rs5.next()){
//      staffheads.add(rs5.getString("heads"));
//      }
//     }
      

   String qry3="select fee from finan_programme where prog=? and batch=?";
      psmt5=con.prepareStatement(qry3);
      psmt5.setString(1, seo1.getDegree());
      psmt5.setString(2, seo1.getBatch());
      rs5=psmt5.executeQuery();
      if(rs5.next())
      {
          seo1.setPamount(rs5.getDouble("fee"));
      }   
      
   String session="";
   try{
       session=seo1.getBatch()+"-"+(Integer.parseInt(seo.getBatch())+1);
   }catch(Exception e){}
      //String qr="select * from feechartdynam where heads=? and session='"+seo.getSession()+"' and classes='"+seo.getClasses()+"' and (gender='"+seo.getGender()+"' or gender='COMMON') and type='"+seo.getType()+"' order by heads";    
       String qr1="select * from suraj_feechartdynam where heads=? and session='"+session+"' and degree='"+seo1.getDegree()+"' and (gender='"+seo1.getGender()+"' or gender='COMMON') order by heads"; 
      
      double feetot=0.0;
      int ch=0;
      psmt=con.prepareStatement(qr1); 
      if(seo1.getStud_type().equalsIgnoreCase("Staff")){
      for(int j=0;j<ar.size();j++){
//          ch=0;
//          for(int k=0;k<staffheads.size();k++){
//              if(ar.get(j).toString().equals(staffheads.get(k).toString()))
//              {
//                psmt.setString(1,ar.get(j).toString());
//                rs=psmt.executeQuery();  
//                if(rs.next()){
//                    hm.put(ar.get(j),rs.getString("fee"));
//                    feetot=feetot+rs.getDouble("fee");
////                  System.out.println("check "+(i+1)+": "+ar1.size());
//                }
//                ch=ch+1;
//             }
//          } 
//          if(ch==0)
//              hm.put(ar.get(j),"0");
          hm.put(ar.get(j),"0");
      }
      String staffhead[]={"TUITION FEE","LAB FEE"};
        if(hm.containsKey(staffhead[0]))
           {  
               psmt.setString(1,staffhead[0]);
               rs=psmt.executeQuery(); 
               if(rs.next())
               {
                   hm.remove(staffhead[0]);
                   hm.put(staffhead[0],(Math.round(rs.getDouble("fee")/2)));
                   feetot=feetot+(Math.round(rs.getDouble("fee")/2));
               }
           }
        if(hm.containsKey(staffhead[1]))
           {  
               psmt.setString(1,staffhead[1]);
               rs=psmt.executeQuery(); 
               if(rs.next())
               {
                   hm.remove(staffhead[1]);
                   hm.put(staffhead[1],(Math.round(rs.getDouble("fee"))));
                   feetot=feetot+(Math.round(rs.getDouble("fee")));
               }
           }
     }
      else{
          for(int j=0;j<ar.size();j++){
            psmt.setString(1,ar.get(j).toString());
            rs=psmt.executeQuery();  
            if(rs.next()){
                hm.put(ar.get(j),rs.getString("fee"));
                feetot=feetot+rs.getDouble("fee");
//          System.out.println("check "+(i+1)+": "+ar1.size());
            }
        }         
      }
      
      if(!seo1.getStud_type().equals("Day Scholar")&&!seo1.getStud_type().equals("Staff")){
//      String str="select sum(food_amount) as sum from monthly_food where stud_id='"+seo1.getStud_id()+"' and session='"+seo.getSession()+"' and food_bill='Unprocess'";
          String str="select sum(food_amount) as sum from monthly_food where stud_id='"+seo1.getStud_id()+"' and food_bill='Unprocess'";
      rs.close();
      psmt=con.prepareStatement(str);
      rs=psmt.executeQuery();
      if(rs.next())
      {
          if(rs.getString("sum")!=null)
          {
              if(hm.containsKey("MONTHLY FOOD BILL"))
              {
                  feetot=feetot-Double.parseDouble(hm.get("MONTHLY FOOD BILL").toString());
                  hm.remove("MONTHLY FOOD BILL");
                  double mnthfd=rs.getDouble("sum")-Double.parseDouble(hm.get("FOOD ADVANCE").toString());
                  hm.put("MONTHLY FOOD BILL", mnthfd);
                  feetot=feetot+(mnthfd);
              }
          }
          else if(hm.containsKey("MONTHLY FOOD BILL"))
              {
                  feetot=feetot-Double.parseDouble(hm.get("MONTHLY FOOD BILL").toString());
                  double mnthfd=Double.parseDouble(hm.get("MONTHLY FOOD BILL").toString())-Double.parseDouble(hm.get("FOOD ADVANCE").toString());
                  hm.remove("MONTHLY FOOD BILL");
                  hm.put("MONTHLY FOOD BILL", mnthfd);
                  feetot=feetot+(mnthfd);
              }
       }
     }
      
      if(seo1.getNewBeni().equals("YES"))
      {
          rs.close();
          String str="select * from new_beni";
          psmt=con.prepareStatement(str);
            rs=psmt.executeQuery();
            while(rs.next())
            {
                if(hm.containsKey(rs.getString("heads")))
                {
                    feetot=feetot-Double.parseDouble(hm.get(rs.getString("heads")).toString());
                    hm.remove(rs.getString("heads"));
                    hm.put(rs.getString("heads"), rs.getDouble("amount"));
                    feetot=feetot+rs.getDouble("amount");
                 }
              }
      }
//      String st="select sum(due) as fine from finerecord where stud_id='"+seo1.getStud_id()+"' and session='"+seo.getSession()+"' and status='Unpaid'";
//      
//      rs.close();
//      psmt=con.prepareStatement(st);
//      rs=psmt.executeQuery();
//      if(rs.next())
//      {
//          if(rs.getString("fine")!=null)
//          {
//            seo1.setFine(rs.getDouble("fine"));
////            feetot=feetot+seo1.getFine();
//          }
//      }
            
      seo1.setDataArray2(ar);
//      System.out.println("helloooo "+seo1.getDataArray2().size());
//      System.out.println(seo1.getDataArray2());
      seo1.setDataMap(hm);
//      System.out.println(seo1.getDataMap());
      seo1.setFeeTotal(feetot);
      seo1.setDataArray3(this.bankList());  
      
      stud_datalist.add(seo1);
      try{
           if(rs!=null){rs.close();}   
           if(rs1!=null){rs1.close();}    
         if(rs3!=null){rs3.close();}           
         if(rs2!=null){rs2.close();} 
         if(rs!=null){rs.close();}  
         if(rs4!=null){rs4.close();}  
         if(rs5!=null){rs5.close();}  
         if(rs6!=null){rs6.close();} 
         if(rst!=null){rst.close();} 
         if(rss!=null){rss.close();}
          if(pss!=null){pss.close();}
         if(pst!=null){pst.close();}
         if(psmt3!=null){psmt3.close();}          
         if(psmt2!=null){psmt2.close();} 
         if(psmt!=null){psmt.close();} 
         if(psmt4!=null){psmt4.close();} 
         if(psmt5!=null){psmt5.close();}
          if(psmt6!=null){psmt6.close();}
       }   
      catch(SQLException se){}
   }
             
//      System.out.println("good: "+stud_datalist);
      }
      //}
      catch(SQLException se){System.out.println("Ex: "+se.getMessage());}  
       finally{
       try{
           if(rs!=null){rs.close();}   
           if(rs1!=null){rs1.close();}    
         if(rs3!=null){rs3.close();}           
         if(rs2!=null){rs2.close();} 
         if(rs!=null){rs.close();}  
         if(rs4!=null){rs4.close();}  
         if(rs5!=null){rs5.close();}  
         if(rs6!=null){rs6.close();} 
         if(rst!=null){rst.close();} 
         if(rss!=null){rss.close();}
          if(pss!=null){pss.close();}
         if(pst!=null){pst.close();}
         if(psmt3!=null){psmt3.close();}          
         if(psmt2!=null){psmt2.close();} 
         if(psmt!=null){psmt.close();} 
         if(psmt4!=null){psmt4.close();} 
         if(psmt5!=null){psmt5.close();}
          if(psmt6!=null){psmt6.close();}
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      } 
      
     return stud_datalist;
}

public ArrayList genFeeScrollProgwise(SchoolEO seo, String sessionForLastFee, String lastSessionSem, Connection insertingCon)
{
    CommonFunctionality cFun=new CommonFunctionality();
    SchoolEO seo1=new SchoolEO();
    ArrayList studlist=new ArrayList();
    ArrayList stud_datalist=new ArrayList();
    ArrayList al=new ArrayList();
     Connection con=null;
       PreparedStatement pss=null;
       ResultSet rss=null;
       
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
      String feetyp="";  
      
      PreparedStatement pst=null;
      ResultSet rst=null;
      try{
        int counter=0; 
        String qr="select count(stud_id) as cn from oldregis where batch='"+seo.getBatch()+"' and degree='"+seo.getDegree()+"'"
                + " and (stud_id <> 'NULL' or stud_id<>'')";
        psmt1=con.prepareStatement(qr);
        rs=psmt1.executeQuery();
        if(rs.next())
            counter=rs.getInt("cn");
        rs.close();
         
      String qr3=""; 
      if(counter!=0){
      qr3="select studname,gender,fname,stud_type,category,icar,gate,stud_id,degree,semester,batch,new_beni,college from oldregis where "
              + "batch='"+seo.getBatch()+"' and degree='"+seo.getDegree()+"' and stud_id in (select stud_id from stud_fee_detail) and stud_id not in "
              + "(select stud_id from transfered_student) ORDER BY SUBSTR(stud_id,1,1),CONVERT(SUBSTR(stud_id,INSTR(stud_id,'-')+1),UNSIGNED)"; 
      psmt1=con.prepareStatement(qr3);
      rs1=psmt1.executeQuery(); 
      while(rs1.next()){
          seo1=new SchoolEO();
      seo1.setSname(rs1.getString("studname"));
      seo1.setGender(rs1.getString("gender"));
      seo1.setDegree(rs1.getString("degree"));
      seo1.setSemester(rs1.getString("semester")); 
      seo1.setFname(rs1.getString("fname"));
      seo1.setStud_type(rs1.getString("stud_type"));
      seo1.setCategory(rs1.getString("category"));
      seo1.setIcar(rs1.getString("icar"));
       seo1.setStud_id(rs1.getString("stud_id"));
      seo1.setGate(rs1.getString("gate"));
      seo1.setBatch(rs1.getString("batch"));
      seo1.setNewBeni(rs1.getString("new_beni"));
      seo1.setCollege(rs1.getString("college"));
      studlist.add(seo1);
      }
      }
else{
      //      qr3="select studname,gender,seekadd,fname,degree,branch,stud_type from studentregis where session='"+seo.getSession()+"' and srnum='"+seo.getRegistNo()+"'";
      qr3="select studname,gender,fname,stud_type,category,icar,gate,stud_id,degree,semester,batch,new_beni,college from studentregis where "
              + "batch='"+seo.getBatch()+"' and degree='"+seo.getDegree()+"' and stud_id in (select stud_id from stud_fee_detail) and stud_id not in "
              + "(select stud_id from transfered_student) ORDER BY SUBSTR(stud_id,1,1),CONVERT(SUBSTR(stud_id,INSTR(stud_id,'-')+1),UNSIGNED)"; 
      psmt1=con.prepareStatement(qr3);
      rs1=psmt1.executeQuery();  
      while(rs1.next()){
          seo1=new SchoolEO();
      seo1.setSname(rs1.getString("studname"));
      seo1.setGender(rs1.getString("gender"));
//      seo.setClasses(rs1.getString("seekadd")); 
      seo1.setFname(rs1.getString("fname"));
      seo1.setDegree(rs1.getString("degree"));
      seo1.setSemester(rs1.getString("semester"));
      seo1.setStud_type(rs1.getString("stud_type"));
      seo1.setCategory(rs1.getString("category"));
      seo1.setIcar(rs1.getString("icar"));
       seo1.setStud_id(rs1.getString("stud_id"));
      seo1.setGate(rs1.getString("gate"));
      seo1.setBatch(rs1.getString("batch"));
      seo1.setNewBeni(rs1.getString("new_beni"));
      seo1.setCollege(rs1.getString("college"));
      studlist.add(seo1);
      }
      } 
//      System.out.println("studlist"+seo.getBatch()+": "+studlist.size());


    
   // String str="select sum(food_amount) as sum from monthly_food where stud_id=? and food_bill='Unprocess'";
    String str1="select * from new_beni";
    
 for(int i=0;i<studlist.size();i++)
   {
       seo1=(SchoolEO)studlist.get(i);
       ArrayList ar=new ArrayList();
ArrayList fieldlist=new ArrayList();

HashMap headsfield=new HashMap();
ArrayList annualHeads=new ArrayList(); 
  ArrayList annualfields=new ArrayList();
  HashMap annualHeadsMap=new HashMap();  
  
String qr6="";
//System.out.println(seo1.getStud_type());
  if(seo.getSession_sem().equals("I")){
      if(seo1.getStud_type().equals("Hosteller")){
          qr6="select distinct heads, heads_cat,field_name,fee_type from feeheads where fee_type<>'Once At Admission' order by heads_cat desc";
      }
      else
      {
          qr6="select distinct heads, heads_cat,field_name,fee_type from feeheads where stud_type='Day Scholar' and fee_type<>'Once At Admission' order by heads_cat desc";
      }
  }
      else{
          if(seo1.getStud_type().equals("Hosteller")){
          qr6="select distinct heads, heads_cat,field_name,fee_type from feeheads where fee_type ='Semester Fee' order by heads_cat desc";
      }
      else
      {
          qr6="select distinct heads, heads_cat,field_name,fee_type from feeheads where stud_type='Day Scholar' and fee_type='Semester Fee' order by heads_cat desc";
      }
    }
  
  
   psmt5=con.prepareStatement(qr6);
      rs5=psmt5.executeQuery(); 
      while(rs5.next()){
      ar.add(rs5.getString("heads"));
      fieldlist.add(rs5.getString("field_name"));
      headsfield.put(rs5.getString("field_name"), rs5.getString("heads"));
      
      if(rs5.getString("fee_type").equals("Annual Fee"))
        {
            annualfields.add(rs5.getString("field_name"));
            annualHeads.add(rs5.getString("heads"));
            annualHeadsMap.put(rs5.getString("field_name"), rs5.getString("heads"));
        }
      }
      
      try{
          if(rs5!=null)rs5.close();
      }catch(Exception e){}
      
       HashMap hm=new HashMap();
       HashMap hm1=new HashMap();
       
       
       
double feetot=0.0; 
//       qr6="select * from stud_fee_detail_excel where stud_id=? and batch=?";
StringBuffer sb=new StringBuffer();
    sb=sb.append("select self_finance_fee,extra");
    int fieldsize=fieldlist.size();      
    for(int j=0;j<fieldsize;j++){
        sb=sb.append(","+fieldlist.get(j));
    }      
  //  sb=sb.append(" from stud_fee_detail where session='"+sessionForLastFee+"' and session_sem='"+lastSessionSem+"' and stud_id='"+seo1.getStud_id()+"'");
    sb=sb.append(" from stud_fee_detail where session=? and session_sem=? and stud_id=?");
//System.out.println("sb: "+sb);        
//System.out.println("dataToExcelTable: "+dataToExcelTable);
      psmt5=con.prepareStatement(sb.toString());
      psmt5.setString(1, sessionForLastFee);
      psmt5.setString(2, lastSessionSem);
      psmt5.setString(3, seo1.getStud_id());
      rs5=psmt5.executeQuery();
      if(rs5.next())
      {
          seo1.setPamount(rs5.getDouble("self_finance_fee"));
          feetot=feetot+rs5.getDouble("self_finance_fee");
          int sz=fieldlist.size();
          for(int j=0;j<sz;j++)
          {
              if(fieldlist.get(j).toString().equals("field18")||fieldlist.get(j).toString().equals("field10")){
                  hm.put(ar.get(j), "0");
                  hm1.put(fieldlist.get(j), "0");
              }
              else{
               //   hm.put(headsfield.get(fields.get(j)),rs.getString(fieldlist.get(j).toString()));
          // above commented line is same as given below.   
                  hm.put(ar.get(j), rs5.getString(fieldlist.get(j).toString()));
                  hm1.put(fieldlist.get(j), rs5.getString(fieldlist.get(j).toString()));
                feetot=feetot+rs5.getDouble(fieldlist.get(j).toString());
              }
           }
      }   
try{if(rs5!=null)rs5.close();}catch(Exception e){}  
if(hm1.size()>0){
if(cFun.getStringFromString(seo1.getNewBeni()).equals("YES"))
      {
          psmt=con.prepareStatement(str1);
            rs=psmt.executeQuery();
            while(rs.next())
            {
                if(hm.containsKey(rs.getString("heads")))
                {
                    feetot=feetot-Double.parseDouble(hm.get(rs.getString("heads")).toString());
                    //hm.remove(rs.getString("heads"));
                    hm.put(rs.getString("heads"), rs.getDouble("amount"));
                    hm1.put(rs.getString("field_name"), rs.getDouble("amount"));
                    feetot=feetot+rs.getDouble("amount");
                 }
              }
            try{if(rs!=null)rs.close();}catch(Exception e){}   
      }

if(seo.getSession_sem().equals("I")){
          String studFirstSession=cFun.getSessionFromBatch(seo.getBatch());
         // System.out.println("studFirstSession: "+studFirstSession);
//          if(studFirstSession==null){
//              seo.setCounter(-10);
//              return seo;
//          }
          SchoolEO seoCheck=new SchoolEO();
          seoCheck.setStud_id(seo1.getStud_id());
          seoCheck.setSession(studFirstSession);
          seoCheck.setSession_sem("I");
          int n=checkSubmited_feeData1(seoCheck);   // check first submitted fee
          if(n>0){         // check first submitted fee  :    found
              HashMap feeStudMap=cFun.retFeeDataFromFee_Student_Detail(seoCheck.getSession(),seoCheck.getSession_sem(),seoCheck.getStud_id(),annualHeads,annualfields,con);
              //System.out.println("annual feeStudMap "+seoCheck.getStud_id()+": "+feeStudMap);
              for(int j=0;j<annualHeads.size();j++){
                        if(feeStudMap.containsKey(annualHeads.get(j)))
                          hm.put(annualHeads.get(j), feeStudMap.get(annualHeads.get(j)));
                          hm1.put(annualfields.get(j), feeStudMap.get(annualHeads.get(j)));
                        feetot=feetot+cFun.getDoubleFormString(feeStudMap.get(annualHeads.get(j)).toString());
                        }
          }
          else if(n==0){         // check first submitted fee  :  not  found
              // check fee in fee structure for the first session of student
              n=cFun.checkFeeDataInFeeStructure(studFirstSession,seo.getDegree(),con);
              if(n==0){     // check fee in fee structure for the first session of student:   not found
                  // check fee in fee structure for the last session of student
                  n=cFun.checkFeeDataInFeeStructure(seo.getSession(),seo.getDegree(),con);
                  if(n==0){     // check fee in fee structure for the last session of student:  not found
              /*        seo.setCounter(-9);   // can not show the annual fee for the student.
                      return seo;   */
                  }
                  else{     // check fee in fee structure for the last session of student:    found
                        HashMap feeStrMap=cFun.retFeeDataFromFeeStructure(seo.getSession(),seo.getDegree(),con);
                      //  System.out.println("1 annual feeStudMap "+seoCheck.getStud_id()+": "+feeStrMap);
                        for(int j=0;j<annualHeads.size();j++){
                        if(feeStrMap.containsKey(annualHeads.get(j)))
                            hm.put(annualHeads.get(j), feeStrMap.get(annualHeads.get(j)));
                            hm1.put(annualfields.get(j), feeStrMap.get(annualHeads.get(j)));
                            feetot=feetot+cFun.getDoubleFormString(feeStrMap.get(annualHeads.get(j)).toString());
                        }
                  }
              }
              else{             // check fee in fee structure for the first session of student:   found
                  HashMap feeStrMap=cFun.retFeeDataFromFeeStructure(studFirstSession,seo.getDegree(),con);
                //  System.out.println("2 annual feeStudMap "+seoCheck.getStud_id()+": "+feeStrMap);
                  for(int j=0;j<annualHeads.size();j++){
                      if(feeStrMap.containsKey(annualHeads.get(j)))
                            hm.put(annualHeads.get(j), feeStrMap.get(annualHeads.get(j)));
                            hm1.put(annualfields.get(j), feeStrMap.get(annualHeads.get(j)));
                            feetot=feetot+cFun.getDoubleFormString(feeStrMap.get(annualHeads.get(j)).toString());                         
                  }
              }
          }
          double fdbill=0;
          hm.put(headsfield.get("field10"),Double.toString(0));    //food advance will be zero at I sem for old student.
          hm1.put("field10", Double.toString(0));
          if(cFun.getStringFromString(seo1.getStud_type()).equals("Hosteller")){
          //    food bill adjustment
                Double advance= foodAdvance(seo1.getStud_id(), "unprocess", con);
                fdbill=retTotalMonthlyFoodBill(seo1.getStud_id());
               // System.out.println("food bill: "+fdbill);
                if(advance!=null){
                    fdbill=fdbill-advance;
                }
                else{
                    fdbill=fdbill-15000;
                }
                feetot=feetot+fdbill;
          }
                hm.put(headsfield.get("field18"),Double.toString(fdbill));
                hm1.put("field18", Double.toString(fdbill));
                
                
// for self finance fee                
      qr="select fee from finan_programme where batch=? and prog=?";
      psmt1=con.prepareStatement(qr);
      psmt1.setString(1, seo.getBatch());
      psmt1.setString(2, seo.getDegree());
      rs1=psmt1.executeQuery();
      if(rs1.next()){
           seo1.setPamount(rs1.getDouble("fee"));
         feetot=feetot+seo1.getPamount();
      }     
      }
      else{
            double fdAdv=0;
            if(cFun.getStringFromString(seo1.getStud_type()).equals("Hosteller")){
                Double advance= foodAdvance(seo1.getStud_id(), "processed", con);

                if(advance!=null){
                      fdAdv=advance;
                   }
                   else{
                     fdAdv=15000;
                 }
            }
          hm.put(headsfield.get("field10"),Double.toString(fdAdv));    //food advance will not be zero at II sem for old student, zero for day scholar student.
          hm1.put("field10", Double.toString(fdAdv));
          
          hm.put(headsfield.get("field18"),Double.toString(0));    //food bill will be zero at II sem for old student.
          hm1.put("field18", Double.toString(0));
      }

      if(seo1.getStud_type().equals("Day Scholar")||seo1.getStud_type().equals("Staff")){
          hm.put(headsfield.get("field10"),Double.toString(0));    //food advance will be zero for day scholar student.
          hm1.put("field10", Double.toString(0));
     }
      
      
//System.out.println("hm: "+hm);
//System.out.println("hm1: "+hm1);
//System.out.println("Total: "+feetot);
      StringBuffer dataToExcelTable=new StringBuffer();
    dataToExcelTable=dataToExcelTable.append("insert into stud_fee_detail_excel(batch,session,session_sem,stud_id,degree,studname,self_finance_fee,"
            + "total_amount");
    for(int j=0;j<fieldsize;j++){
        dataToExcelTable=dataToExcelTable.append(","+fieldlist.get(j));
    }  
    dataToExcelTable=dataToExcelTable.append(") values(");
    dataToExcelTable=dataToExcelTable.append("?,?,?,?,?,?,?,?");
    for(int j=0;j<fieldsize;j++){
        dataToExcelTable=dataToExcelTable.append(",?");
    } 
    dataToExcelTable=dataToExcelTable.append(")");
 //   System.out.println("inserting into excel data for student "+seo1.getStud_id());
      psmt=insertingCon.prepareStatement(dataToExcelTable.toString());
      psmt.setString(1, seo1.getBatch());
      psmt.setString(2, seo.getSession());
      psmt.setString(3, seo.getSession_sem());
      psmt.setString(4, seo1.getStud_id());
      psmt.setString(5, seo1.getDegree());
      psmt.setString(6, seo1.getSname());
      psmt.setDouble(7, seo1.getPamount());
      psmt.setDouble(8, feetot);
      int gt=9;
      for(int j=0;j<fieldsize;j++){
        psmt.setDouble(gt, Double.parseDouble(hm1.get(fieldlist.get(j)).toString()));
        gt++;
    } 
      psmt.executeUpdate();
            
      seo1.setDataArray2(ar);
//      System.out.println("helloooo "+seo1.getDataArray2().size());
//      System.out.println(seo1.getDataArray2());
      seo1.setDataMap(hm);
//      System.out.println(seo1.getDataMap());
      seo1.setFeeTotal(feetot-seo1.getPamount());
      seo1.setDataArray3(this.bankList());  
      
      stud_datalist.add(seo1);
      try{
           if(rs!=null){rs.close();}   
           if(rs1!=null){rs1.close();}    
         if(rs3!=null){rs3.close();}           
         if(rs2!=null){rs2.close();} 
         if(rs!=null){rs.close();}  
         if(rs4!=null){rs4.close();}  
         if(rs5!=null){rs5.close();}  
         if(rs6!=null){rs6.close();} 
         if(rst!=null){rst.close();} 
         if(rss!=null){rss.close();}
          if(pss!=null){pss.close();}
         if(pst!=null){pst.close();}
         if(psmt3!=null){psmt3.close();}          
         if(psmt2!=null){psmt2.close();} 
         if(psmt!=null){psmt.close();} 
         if(psmt4!=null){psmt4.close();} 
         if(psmt5!=null){psmt5.close();}
          if(psmt6!=null){psmt6.close();}
       }   
      catch(SQLException se){se.printStackTrace();}
   }
   }          
//      System.out.println("good: "+stud_datalist);
      }
      //}
      catch(SQLException se){System.out.println("Ex: "+se.getMessage());}  
       finally{
       try{
           if(rs!=null){rs.close();}   
           if(rs1!=null){rs1.close();}    
         if(rs3!=null){rs3.close();}           
         if(rs2!=null){rs2.close();} 
         if(rs!=null){rs.close();}  
         if(rs4!=null){rs4.close();}  
         if(rs5!=null){rs5.close();}  
         if(rs6!=null){rs6.close();} 
         if(rst!=null){rst.close();} 
         if(rss!=null){rss.close();}
          if(pss!=null){pss.close();}
         if(pst!=null){pst.close();}
         if(psmt3!=null){psmt3.close();}          
         if(psmt2!=null){psmt2.close();} 
         if(psmt!=null){psmt.close();} 
         if(psmt4!=null){psmt4.close();} 
         if(psmt5!=null){psmt5.close();}
          if(psmt6!=null){psmt6.close();}
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      } 
      
     return stud_datalist;
}

public ArrayList genFeeScrollProgwiseForStoredDataInExcelTable(SchoolEO seo)
{
    SchoolEO seo1=new SchoolEO();
    ArrayList studlist=new ArrayList();
    ArrayList stud_datalist=new ArrayList();
    ArrayList al=new ArrayList();
     Connection con=null;
       PreparedStatement pss=null;
       ResultSet rss=null;

  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
      String feetyp="";  
      
      PreparedStatement pst=null;
      ResultSet rst=null;
      try{
        int counter=0; 
        String qr="select count(stud_id) as cn from oldregis where batch='"+seo.getBatch()+"' and degree='"+seo.getDegree()+"'"
                + " and (stud_id <> 'NULL' or stud_id<>'')";
        psmt1=con.prepareStatement(qr);
        rs=psmt1.executeQuery();
        if(rs.next())
            counter=rs.getInt("cn");
        rs.close();
         
      String qr3=""; 
      if(counter!=0){
      qr3="select studname,gender,fname,stud_type,category,icar,gate,stud_id,degree,semester,batch,new_beni,college from oldregis where "
              + "batch='"+seo.getBatch()+"' and degree='"+seo.getDegree()+"' and stud_id in (select stud_id from stud_fee_detail_excel)"; 
      psmt1=con.prepareStatement(qr3);
      rs1=psmt1.executeQuery(); 
      while(rs1.next()){
          seo1=new SchoolEO();
      seo1.setSname(rs1.getString("studname"));
      seo1.setGender(rs1.getString("gender"));
      seo1.setDegree(rs1.getString("degree"));
      seo1.setSemester(rs1.getString("semester")); 
      seo1.setFname(rs1.getString("fname"));
      seo1.setStud_type(rs1.getString("stud_type"));
      seo1.setCategory(rs1.getString("category"));
      seo1.setIcar(rs1.getString("icar"));
       seo1.setStud_id(rs1.getString("stud_id"));
      seo1.setGate(rs1.getString("gate"));
      seo1.setBatch(rs1.getString("batch"));
      seo1.setNewBeni(rs1.getString("new_beni"));
      seo1.setCollege(rs1.getString("college"));
      studlist.add(seo1);
      }
      }
else{
      //      qr3="select studname,gender,seekadd,fname,degree,branch,stud_type from studentregis where session='"+seo.getSession()+"' and srnum='"+seo.getRegistNo()+"'";
      qr3="select studname,gender,fname,stud_type,category,icar,gate,stud_id,degree,semester,batch,new_beni,college from studentregis where "
              + "batch='"+seo.getBatch()+"' and degree='"+seo.getDegree()+"' and stud_id in (select stud_id from stud_fee_detail_excel)"; 
      psmt1=con.prepareStatement(qr3);
      rs1=psmt1.executeQuery();  
      while(rs1.next()){
          seo1=new SchoolEO();
      seo1.setSname(rs1.getString("studname"));
      seo1.setGender(rs1.getString("gender"));
//      seo.setClasses(rs1.getString("seekadd")); 
      seo1.setFname(rs1.getString("fname"));
      seo1.setDegree(rs1.getString("degree"));
      seo1.setSemester(rs1.getString("semester"));
      seo1.setStud_type(rs1.getString("stud_type"));
      seo1.setCategory(rs1.getString("category"));
      seo1.setIcar(rs1.getString("icar"));
       seo1.setStud_id(rs1.getString("stud_id"));
      seo1.setGate(rs1.getString("gate"));
      seo1.setBatch(rs1.getString("batch"));
      seo1.setNewBeni(rs1.getString("new_beni"));
      seo1.setCollege(rs1.getString("college"));
      studlist.add(seo1);
      }
      } 
//      System.out.println("studlist"+seo.getBatch()+": "+studlist.size());
   
    
 for(int i=0;i<studlist.size();i++)
   {
       seo1=(SchoolEO)studlist.get(i);
       ArrayList ar=new ArrayList();
ArrayList fieldlist=new ArrayList();
String qr6="";
//System.out.println(seo1.getStud_type());
   if(seo.getSession_sem().equals("I")){
      if(seo1.getStud_type().equals("Hosteller")){
          qr6="select distinct heads, heads_cat,field_name,fee_type from feeheads where fee_type<>'Once At Admission' order by heads_cat desc";
      }
      else
      {
          qr6="select distinct heads, heads_cat,field_name,fee_type from feeheads where stud_type='Day Scholar' and fee_type<>'Once At Admission' order by heads_cat desc";
      }
  }
      else{
          if(seo1.getStud_type().equals("Hosteller")){
          qr6="select distinct heads, heads_cat,field_name,fee_type from feeheads where fee_type ='Semester Fee' order by heads_cat desc";
      }
      else
      {
          qr6="select distinct heads, heads_cat,field_name,fee_type from feeheads where stud_type='Day Scholar' and fee_type='Semester Fee' order by heads_cat desc";
      }
    }
  
  qr6="select distinct heads, heads_cat,field_name,fee_type from feeheads order by heads_cat desc";
   psmt5=con.prepareStatement(qr6);
      rs5=psmt5.executeQuery(); 
      while(rs5.next()){
      ar.add(rs5.getString("heads"));
      fieldlist.add(rs5.getString("field_name"));
      }
      
      try{
          if(rs5!=null)rs5.close();
      }catch(Exception e){}
      
       HashMap hm=new HashMap();
       HashMap hm1=new HashMap();
       
       

double feetot=0.0; 
//       qr6="select * from stud_fee_detail_excel where stud_id=? and batch=?";
StringBuffer sb=new StringBuffer();
    sb=sb.append("select self_finance_fee,extra");
    int fieldsize=fieldlist.size();      
    for(int j=0;j<fieldsize;j++){
        sb=sb.append(","+fieldlist.get(j));
    }      
    sb=sb.append(" from stud_fee_detail_excel where session=? and session_sem=? and stud_id=?");
//System.out.println("sb: "+sb);        
//System.out.println("dataToExcelTable: "+dataToExcelTable);
      psmt5=con.prepareStatement(sb.toString());
      psmt5.setString(1, seo.getSession());
      psmt5.setString(2, seo.getSession_sem());
      psmt5.setString(3, seo1.getStud_id());
      rs5=psmt5.executeQuery();
      if(rs5.next())
      {
          seo1.setPamount(rs5.getDouble("self_finance_fee"));
          seo1.setEamount(rs5.getDouble("extra"));
          feetot=feetot+seo1.getEamount();
          int sz=fieldlist.size();
          for(int j=0;j<sz;j++)
          {
              hm.put(ar.get(j), rs5.getString(fieldlist.get(j).toString()));
              feetot=feetot+Double.parseDouble(rs5.getString(fieldlist.get(j).toString()));
              hm1.put(fieldlist.get(j), rs5.getString(fieldlist.get(j).toString()));
          }
      }   
try{if(rs5!=null)rs5.close();}catch(Exception e){}   
      seo1.setDataArray2(ar);
//      System.out.println("helloooo "+seo1.getDataArray2().size());
//      System.out.println(seo1.getDataArray2());
      seo1.setDataMap(hm);
//      System.out.println(seo1.getDataMap());
      seo1.setFeeTotal(feetot);
      seo1.setDataArray3(this.bankList());  
      
      stud_datalist.add(seo1);
      try{
           if(rs!=null){rs.close();}   
           if(rs1!=null){rs1.close();}    
         if(rs3!=null){rs3.close();}           
         if(rs2!=null){rs2.close();} 
         if(rs!=null){rs.close();}  
         if(rs4!=null){rs4.close();}  
         if(rs5!=null){rs5.close();}  
         if(rs6!=null){rs6.close();} 
         if(rst!=null){rst.close();} 
         if(rss!=null){rss.close();}
          if(pss!=null){pss.close();}
         if(pst!=null){pst.close();}
         if(psmt3!=null){psmt3.close();}          
         if(psmt2!=null){psmt2.close();} 
         if(psmt!=null){psmt.close();} 
         if(psmt4!=null){psmt4.close();} 
         if(psmt5!=null){psmt5.close();}
          if(psmt6!=null){psmt6.close();}
       }   
      catch(SQLException se){}
   }
           
//      System.out.println("good: "+stud_datalist);
      }
      //}
      catch(SQLException se){System.out.println("Ex: "+se.getMessage());}  
       finally{
       try{
           if(rs!=null){rs.close();}   
           if(rs1!=null){rs1.close();}    
         if(rs3!=null){rs3.close();}           
         if(rs2!=null){rs2.close();} 
         if(rs!=null){rs.close();}  
         if(rs4!=null){rs4.close();}  
         if(rs5!=null){rs5.close();}  
         if(rs6!=null){rs6.close();} 
         if(rst!=null){rst.close();} 
         if(rss!=null){rss.close();}
          if(pss!=null){pss.close();}
         if(pst!=null){pst.close();}
         if(psmt3!=null){psmt3.close();}          
         if(psmt2!=null){psmt2.close();} 
         if(psmt!=null){psmt.close();} 
         if(psmt4!=null){psmt4.close();} 
         if(psmt5!=null){psmt5.close();}
          if(psmt6!=null){psmt6.close();}
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      } 
      
     return stud_datalist;
}

public SchoolEO getDetailForFeeScroll(SchoolEO seo)
{
           Connection con=null;
           int cnt=0;
       
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
  
  try
  {
      String qr1="select count(*) as cnt from studentregis where stud_id=?";
      psmt1=con.prepareStatement(qr1);
  psmt1.setString(1, seo.getStud_id());
//  psmt1.setString(2, seo.getSession());
  rs1=psmt1.executeQuery();
  if(rs1.next())
  {
    cnt=rs1.getInt("cnt");  
  }
  seo.setCounter(cnt);
  if(cnt!=0){
  String qr="select degree,srnum from studentregis where stud_id='"+seo.getStud_id()+"'";
//  String qr="select degree,srnum,icar,gate,semester,batch,stud_type,new_beni from studentregis where stud_id=? and session=?";
  //System.out.println("Query: "+qr);
  psmt=con.prepareStatement(qr);
//  psmt.setString(1, seo.getStud_id());
//  psmt.setString(2, seo.getSession());
  rs=psmt.executeQuery();
  if(rs.next())
  {
      seo.setDegree(rs.getString("degree"));
      seo.setRegistNo(rs.getString("srnum"));
//      seo.setIcar(rs.getString("icar"));
//      seo.setGate(rs.getString("gate"));
//      seo.setSemester(rs.getString("semester"));
//      seo.setBatch(rs.getString("batch"));
//      seo.setStud_type(rs.getString("stud_type"));
//      seo.setNewBeni(rs.getString("new_beni"));
  }
  }
  }catch(Exception e){}
  finally{
       try{
         if(rs!=null){rs.close();}           
         if(psmt!=null){psmt.close();}          
      if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      } 
    
    return seo;
}

public SchoolEO retFeeHeadwiseFromStruc(SchoolEO seo)
{
    Connection con=null;
     ArrayList ar=new ArrayList();
     ArrayList ar1=new ArrayList();
     HashMap hm1=new HashMap();
     HashMap hm=new HashMap();  
     SchoolEO seo1=new SchoolEO();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
  
  try
  {
      String qr6="";
      if(seo.getStud_type().equals("Hosteller")){
      qr6="select distinct heads, heads_cat,field_name from feeheads order by heads_cat";
      }
      else
      {
          qr6="select distinct heads, heads_cat,field_name from feeheads where stud_type='Day Scholar' order by heads_cat";
//          seo.setStud_type("Day Scholar");
      }
//      System.out.println("query1: "+qr6);
      psmt5=con.prepareStatement(qr6);
      rs5=psmt5.executeQuery(); 
      while(rs5.next()){
      ar.add(rs5.getString("heads"));
      ar1.add(rs5.getString("field_name"));
      hm1.put(rs5.getString("heads"), rs5.getString("field_name"));
      }
      rs5.close();
      String qry3="select fee from finan_programme where prog=? and batch=?";
      psmt5=con.prepareStatement(qry3);
      psmt5.setString(1, seo.getDegree());
      psmt5.setString(2, seo.getBatch());
      rs5=psmt5.executeQuery();
      if(rs5.next())
      {
          seo1.setPamount(rs5.getDouble("fee"));
      }


String qr1="select * from suraj_feechartdynam where heads=? and session='"+seo.getSession()+"' and degree='"+seo.getDegree()+"' and (gender='"+seo.getGender()+"' or gender='COMMON') order by heads"; 
 
      psmt=con.prepareStatement(qr1);        
//      for(int i=0;i<ar.size();i++){
//      psmt.setString(1,ar.get(i).toString());
//      rs=psmt.executeQuery();  
//      if(rs.next()){
//      hm.put(ar1.get(i).toString(),rs.getString("fee"));
//      }       
//      }
      
      if(seo.getStud_type().equalsIgnoreCase("Staff")){
      for(int j=0;j<ar.size();j++){
          hm.put(ar1.get(j),"0");
      }
      String staffhead[]={"TUITION FEE","LAB FEE"};
      String staffheadfields[]={hm1.get("TUITION FEE").toString(),hm1.get("LAB FEE").toString()};
      
        if(hm.containsKey(staffheadfields[0]))
           {  
               psmt.setString(1,staffhead[0]);
               rs=psmt.executeQuery(); 
               if(rs.next())
               {
                   hm.remove(staffheadfields[0]);
                   hm.put(staffheadfields[0],Math.round(rs.getDouble("fee")/2));
                }
           }
        if(hm.containsKey(staffheadfields[1]))
           {  
               psmt.setString(1,staffhead[1]);
               rs=psmt.executeQuery(); 
               if(rs.next())
               {
                   hm.remove(staffheadfields[1]);
                   hm.put(staffheadfields[1],Math.round(rs.getDouble("fee")));
                }
           }
      }
      else{
          for(int j=0;j<ar.size();j++){
            psmt.setString(1,ar.get(j).toString());
            rs=psmt.executeQuery();  
            if(rs.next()){
                hm.put(ar1.get(j),rs.getString("fee"));
                
//          System.out.println("check "+(i+1)+": "+ar1.size());
            }
        }         
      }
      seo1.setDataArray(ar1);
      seo1.setDataMap(hm);
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
  return seo1;
}

public int subFeeHeadwise(SchoolEO seo,SchoolEO se, Connection conSave) throws Exception 
{
     ArrayList ar=se.getDataArray();
     HashMap hm=se.getDataMap();  

  int n=0;
  try
  {
//      System.out.println("Kapil: "+seo.getSemester());
      int ssn=Integer.parseInt(seo.getSemester())+1;
//      System.out.println("Kapil: "+n);
      String qr6="";
      StringBuffer sb=new StringBuffer();
      sb=sb.append("insert into stud_fee_detail(session,srnum,semester,submission_date,degree,self_finance_fee,stud_id,batch,session_sem");
      sb=sb.append(",subm_bank,transaction_id,fine,extra,adjstDraftTtAndFeeTt,data_entry_time");
      for(int i=0;i<ar.size();i++)
      {
          sb=sb.append(",");
          sb=sb.append(ar.get(i).toString());
      }
      sb=sb.append(")");
      sb=sb.append(" values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?");
      for(int i=0;i<ar.size();i++)
      {
          sb=sb.append(",?");
      }
      sb=sb.append(")");
//      System.out.println(sb.toString());
      psmt=conSave.prepareStatement(sb.toString());
      psmt.setString(1, seo.getSession());
      psmt.setString(2, seo.getRegistNo());
      psmt.setString(3, Integer.toString(ssn));
      psmt.setDate(4, new java.sql.Date(seo.getDeposite_date().getTime()));
      psmt.setString(5, seo.getDegree());
      psmt.setDouble(6, se.getPamount());
      psmt.setString(7, seo.getStud_id());
      psmt.setString(8, seo.getBatch());
      psmt.setString(9, seo.getSession_sem());
      psmt.setString(10,seo.getBankname());
      psmt.setString(11,seo.getTransaction_id());
//      psmt.setDouble(12, seo.getFine());
      psmt.setDouble(12, 0);
      psmt.setDouble(13, seo.getEamount());
      psmt.setDouble(14, seo.getAdjustment());
      psmt.setTimestamp(15, new java.sql.Timestamp(new java.util.Date().getTime()));
      
      int j=16;
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
      
      n=psmt.executeUpdate();
//      System.out.println("Kapil: "+n);
  }catch(Exception e){System.out.println("Ex: "+e.getMessage());
    throw e;
  }
  finally{
       try{
         if(rs!=null){rs.close();}           
         if(psmt!=null){psmt.close();}       
       }   
       catch(SQLException see){}
      }
  return n;
}


public SchoolEO genCommonFeeScroll(SchoolEO seo){ 
       Connection con=null;
       PreparedStatement pss=null;
       ResultSet rss=null;
       ArrayList ar=new ArrayList();
        ArrayList ar1=new ArrayList();
        ArrayList ar2=new ArrayList();
         ArrayList sub=new ArrayList();
       HashMap hm=new HashMap();
        HashMap hm1=new HashMap();
         HashMap hm2=new HashMap();
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
          
      String qr6="";
      
      if(seo.getStud_type().equals("Hosteller")){
//      qr6="select distinct heads from feeheads where head_type<>'TREASURY'";
          qr6="select distinct heads, heads_cat from feeheads order by heads_cat";
      }
      else
      {
          qr6="select distinct heads, heads_cat from feeheads where stud_type='Day Scholar' order by heads_cat";
//          seo.setStud_type("Day Scholar");
      }
      psmt5=con.prepareStatement(qr6);
      rs5=psmt5.executeQuery(); 
      while(rs5.next()){
      ar.add(rs5.getString("heads"));
      hm1.put(rs5.getString("heads"), rs5.getString("heads_cat"));
      }
//      for(int i=0;i<2;i++){System.out.println("check: "+hm1.get("GAMES FEE"));}
      String qry="select distinct heads_cat from feeheads order by heads_cat";
      psmt6=con.prepareStatement(qry);
      rs6=psmt6.executeQuery(); 
      while(rs6.next()){
      ar1.add(rs6.getString("heads_cat"));
      }
       
       String qry1="";
       
       if(seo.getStud_type().equals("Hosteller")){
//      qr6="select distinct heads from feeheads where head_type<>'TREASURY'";
          qry1="select count(distinct heads) as cnt, heads_cat from feeheads group by heads_cat";
          
      }
      else
      {
          qry1="select count(distinct heads) as cnt, heads_cat from feeheads where stud_type='Day Scholar' group by heads_cat";
      }
       
       
       psmt6=con.prepareStatement(qry1);
      rs6=psmt6.executeQuery(); 
      while(rs6.next()){
          ar2.add(rs6.getInt("cnt"));
      hm2.put(rs6.getString("heads_cat"), rs6.getInt("cnt"));
      }
//      System.out.println("check1: "+ar1.size());
//        System.out.println("check2: "+ar2.size());
      
     
      String qry3="select fee from finan_programme where prog=?";
      psmt5=con.prepareStatement(qry3);
      psmt5.setString(1, seo.getDegree());
      rs5=psmt5.executeQuery();
      if(rs5.next())
      {
          seo.setPamount(rs5.getDouble("fee"));
      }
   
      String qr1="select * from suraj_feechartdynam where heads=? and session='"+seo.getSession()+"' and degree='"+seo.getDegree()+"' "
               + "and (gender='"+seo.getGender()+"' or gender='COMMON') order by heads"; 
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
      seo.setDataArray(ar1);
       seo.setDataArray1(ar2);
      seo.setDataMap(hm);
      seo.setDataMap1(hm1);
      seo.setDataMap2(hm2);
      seo.setFeeTotal(feetot);
      seo.setDataArray3(this.bankList());
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
         if(rs6!=null){rs6.close();} 
         if(rst!=null){rst.close();} 
         if(rss!=null){rss.close();}
          if(pss!=null){pss.close();}
         if(pst!=null){pst.close();}
         if(psmt3!=null){psmt3.close();}          
         if(psmt2!=null){psmt2.close();} 
         if(psmt!=null){psmt.close();} 
         if(psmt4!=null){psmt4.close();} 
         if(psmt5!=null){psmt5.close();}
          if(psmt6!=null){psmt6.close();}
         if(con!=null){con.close();}  
       }   
       catch(SQLException se){}
      } 
      
      seo.setCounter(cn);
     return seo;   
}

public void subMonthlyFoodAmount(SchoolEO seo)
{
   Connection con=null;
     ArrayList ar1=new ArrayList();
      
     
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
  
  try
  {
      String qr6="";
      String sb="insert into monthly_food(session,batch,stud_id,month,food_amount,foodbill_no,subm_date,food_bill,bill_gen_date) values(?,?,?,?,?,?,?,?,?)";
      psmt=con.prepareStatement(sb);
      
      psmt.setString(1, seo.getSession());
      psmt.setString(2, seo.getBatch());
      psmt.setString(3, seo.getStud_id());
      psmt.setString(4, seo.getMonth());
      psmt.setDouble(5, seo.getMonthlyFood());
      psmt.setString(6, "");
      psmt.setTimestamp(7, new Timestamp(new java.util.Date().getTime()));
      psmt.setString(8, "Unprocess");
      psmt.setDate(9, new java.sql.Date(seo.getDate().getTime()));
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

// using student id
public SchoolEO getStudentDetails(SchoolEO seo1)
{
    SchoolEO seo=new SchoolEO();
    Connection con=null;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
  
  try
  {
      String qr="select * from studentregis where stud_id='"+seo1.getStud_id()+"'";
//      System.out.println(qr);
      psmt=con.prepareStatement(qr);
      rs=psmt.executeQuery();
      if(rs.next())
      {
          seo.setStud_id(rs.getString("stud_id"));
          seo.setBatch(rs.getString("batch"));
          seo.setSname(rs.getString("studname"));
          seo.setFname(rs.getString("fname"));
          seo.setDegree(rs.getString("degree"));
          seo.setStud_type(rs.getString("stud_type"));
          seo.setNewBeni(rs.getString("new_beni"));
          if(rs.getString("semester")!=null)
             seo.setSemester(rs.getString("semester"));
          else
             seo.setSemester("0");
          seo.setGender(rs.getString("gender"));
          seo.setCollege(rs.getString("college"));
          seo.setReg(rs.getString("registration"));
          seo.setDate(rs.getDate("regist_date"));
          seo.setRegistNo(rs.getString("srnum"));
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

public void subFineAmount(SchoolEO seo)
{
   Connection con=null;
     ArrayList ar1=new ArrayList();
      
     
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
  
  try
  {
      String qr6="";
      String sb="insert into finerecord(session,batch,stud_id,due,fdate,status) values(?,?,?,?,?,?)";
      psmt=con.prepareStatement(sb);
      
      psmt.setString(1, seo.getSession());
      psmt.setString(2, seo.getBatch());
      psmt.setString(3, seo.getStud_id());
      psmt.setDouble(4, seo.getFine());
      psmt.setDate(5, new java.sql.Date(new java.util.Date().getTime()));
      psmt.setString(6, "Unpaid");
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

public ArrayList retStudentFine(SchoolEO seo1)
{
    ArrayList al=new ArrayList();
    SchoolEO seo=new SchoolEO();
    Connection con=null;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
  
  try
  {
      String qr="select * from finerecord where stud_id='"+seo1.getStud_id()+"' and session='"+seo1.getSession()+"' and status='Unpaid'";
      System.out.println(qr);
      psmt=con.prepareStatement(qr);
      rs=psmt.executeQuery();
      while(rs.next())
      {
          seo=new SchoolEO();
          seo.setBatch(rs.getString("batch"));
          seo.setFine(rs.getDouble("due"));
          seo.setStatus(rs.getString("status"));
          seo.setDeposite_date(rs.getDate("fdate"));
          al.add(seo);
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
  return al;
}

public SchoolEO retStudFeeFromStruc(SchoolEO seo1)
{
    ArrayList ar=new ArrayList();
       HashMap hm=new HashMap();
       ArrayList ar1=new ArrayList();
     HashMap hm1=new HashMap();
       
        PreparedStatement pss=null;
       ResultSet rss=null;
      PreparedStatement pst=null;
      ResultSet rst=null;
      Connection con=null;
       
       
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
       
//       System.out.println(seo1);
  try{
       int n=Integer.parseInt(seo1.getSemester())+1;
       n=n%2;
       String qr6="";

      if(n!=0){
      if(seo1.getStud_type().equals("Hosteller")){
            qr6="select distinct heads, heads_cat,field_name from feeheads where fee_type<>'Once At Admission' order by heads_cat desc";
      }
      else
      {
          qr6="select distinct heads, heads_cat,field_name from feeheads where stud_type='Day Scholar' and fee_type<>'Once At Admission' order by heads_cat desc";
      }
     }
      else{
          if(seo1.getStud_type().equals("Hosteller")){
                qr6="select distinct heads, heads_cat,field_name from feeheads where fee_type ='Semester Fee' order by heads_cat desc";
      }
      else
      {
          qr6="select distinct heads, heads_cat,field_name from feeheads where stud_type='Day Scholar' and fee_type='Semester Fee' order by heads_cat desc";
      }
    }
//      System.out.println("Query6: "+qr6);
//      System.out.println("st: "+st);
      psmt5=con.prepareStatement(qr6);
      rs5=psmt5.executeQuery(); 
      while(rs5.next()){
      ar.add(rs5.getString("heads"));
      ar1.add(rs5.getString("field_name"));
      hm1.put(rs5.getString("heads"), rs5.getString("field_name"));
      }
      
   String qry3="select fee from finan_programme where prog=? and batch=?";
      psmt5=con.prepareStatement(qry3);
      psmt5.setString(1, seo1.getDegree());
      psmt5.setString(2, seo1.getBatch());
      rs5=psmt5.executeQuery();
      if(rs5.next())
      {
          seo1.setPamount(rs5.getDouble("fee"));
      }   
      
   String session="";
   try{
       session=seo1.getBatch()+"-"+(Integer.parseInt(seo1.getBatch())+1);
   }catch(Exception e){}
      String qr1="select * from suraj_feechartdynam where heads=? and session='"+session+"' and degree='"+seo1.getDegree()+"' and (gender='"+seo1.getGender()+"' or gender='COMMON') order by heads"; 
      
      double feetot=0.0;
      int ch=0;
      psmt=con.prepareStatement(qr1); 
      if(seo1.getStud_type().equalsIgnoreCase("Staff")){
      for(int j=0;j<ar.size();j++){
          hm.put(ar1.get(j),"0");
      }
      String staffhead[]={"TUITION FEE","LAB FEE"};
      String staffheadfields[]={hm1.get("TUITION FEE").toString(),hm1.get("LAB FEE").toString()};
        if(hm.containsKey(staffheadfields[0]))
           {  
               psmt.setString(1,staffhead[0]);
               rs=psmt.executeQuery(); 
               if(rs.next())
               {
                   hm.remove(staffheadfields[0]);
                   hm.put(staffheadfields[0],Math.round(rs.getDouble("fee")/2));
                   feetot=feetot+Math.round(rs.getDouble("fee")/2);
               }
           }
        if(hm.containsKey(staffheadfields[1]))
           {  
               psmt.setString(1,staffhead[1]);
               rs=psmt.executeQuery(); 
               if(rs.next())
               {
                   hm.remove(staffheadfields[1]);
                   hm.put(staffheadfields[1],Math.round(rs.getDouble("fee")));
                   feetot=feetot+Math.round(rs.getDouble("fee"));
               }
           }
    }
      else{
          for(int j=0;j<ar.size();j++){
            psmt.setString(1,ar.get(j).toString());
            rs=psmt.executeQuery();  
            if(rs.next()){
                hm.put(ar1.get(j),rs.getString("fee"));
                feetot=feetot+rs.getDouble("fee");
//          System.out.println("check "+(i+1)+": "+ar1.size());
            }
        }         
      }
//      System.out.println("hm: "+hm);
      if(!seo1.getStud_type().equals("Day Scholar")&&!seo1.getStud_type().equals("Staff")){
//      String str="select sum(food_amount) as sum from monthly_food where stud_id='"+seo1.getStud_id()+"' and session='"+seo1.getSession()+"'";
          String str="select sum(food_amount) as sum from monthly_food where stud_id='"+seo1.getStud_id()+"' and food_bill='Unprocess'";
      rs.close();
      psmt=con.prepareStatement(str);
      rs=psmt.executeQuery();
      if(rs.next())
      {
          if(rs.getString("sum")!=null)
          {
              if(hm.containsKey(hm1.get("MONTHLY FOOD BILL").toString()))
              {
                  feetot=feetot-Double.parseDouble(hm.get(hm1.get("MONTHLY FOOD BILL").toString()).toString());
                  hm.remove(hm1.get("MONTHLY FOOD BILL").toString());
                  double mnthfd=rs.getDouble("sum")-Double.parseDouble(hm.get(hm1.get("FOOD ADVANCE").toString()).toString());
                  hm.put(hm1.get("MONTHLY FOOD BILL").toString(), mnthfd);
                  feetot=feetot+(mnthfd);
              }
          }
          else if(hm.containsKey(hm1.get("MONTHLY FOOD BILL").toString()))
              {
                  feetot=feetot-Double.parseDouble(hm.get(hm1.get("MONTHLY FOOD BILL").toString()).toString());
                  double mnthfd=Double.parseDouble(hm.get(hm1.get("MONTHLY FOOD BILL").toString()).toString())-Double.parseDouble(hm.get(hm1.get("FOOD ADVANCE").toString()).toString());
                  hm.remove(hm1.get("MONTHLY FOOD BILL").toString());
                  hm.put(hm1.get("MONTHLY FOOD BILL").toString(), mnthfd);
                  feetot=feetot+(mnthfd);
              }
       }
      }
      
      if(seo1.getNewBeni().equals("YES"))
      {
          rs.close();
          String str="select * from new_beni";
          psmt=con.prepareStatement(str);
            rs=psmt.executeQuery();
            while(rs.next())
            {
                if(hm.containsKey(hm1.get(rs.getString("heads")).toString()))
                {
                    feetot=feetot-Double.parseDouble(hm.get(hm1.get(rs.getString("heads")).toString()).toString());
                    hm.remove(hm1.get(rs.getString("heads")).toString());
                    hm.put(hm1.get(rs.getString("heads")).toString(), rs.getDouble("amount"));
                    feetot=feetot+rs.getDouble("amount");
                 }
              }
      }
      
//      String st="select sum(due) as fine from finerecord where stud_id='"+seo1.getStud_id()+"' and session='"+seo1.getSession()+"' and status='Unpaid'";
//      rs.close();
//      psmt=con.prepareStatement(st);
//      rs=psmt.executeQuery();
//      if(rs.next())
//      {
//          if(rs.getString("fine")!=null)
//          {
//            seo1.setFine(rs.getDouble("fine"));
//          }
//      }
      seo1.setDataArray(ar1);      
      seo1.setDataArray2(ar);
      seo1.setDataMap(hm);
      seo1.setFeeTotal(feetot);
      seo1.setDataArray3(this.bankList());  
      
  }catch(Exception e){System.out.println("Ex: "+e.getMessage());}
      finally{
      try{
           if(rs!=null){rs.close();}   
           if(rs1!=null){rs1.close();}    
         if(rs3!=null){rs3.close();}           
         if(rs2!=null){rs2.close();} 
         if(rs!=null){rs.close();}  
         if(rs4!=null){rs4.close();}  
         if(rs5!=null){rs5.close();}  
         if(rs6!=null){rs6.close();} 
         if(rst!=null){rst.close();} 
         if(rss!=null){rss.close();}
          if(pss!=null){pss.close();}
         if(pst!=null){pst.close();}
         if(psmt3!=null){psmt3.close();}          
         if(psmt2!=null){psmt2.close();} 
         if(psmt!=null){psmt.close();} 
         if(psmt4!=null){psmt4.close();} 
         if(psmt5!=null){psmt5.close();}
          if(psmt6!=null){psmt6.close();}
          if(con!=null){con.close();}
       }   
      catch(SQLException se){}
     }
      return seo1;
}

public SchoolEO ret_stud_fee_detail_excel(SchoolEO seo1)
{
    ArrayList ar=new ArrayList();
       HashMap hm=new HashMap();
       ArrayList ar1=new ArrayList();
     HashMap hm1=new HashMap();    
     ArrayList fields=new ArrayList();
         HashMap headsfield=new HashMap();
         HashMap headsAmount=new HashMap();
      Connection con=null;     
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
       
//       System.out.println(seo1);
  try{
       String qr6="select distinct heads, heads_cat,field_name from feeheads order by heads_cat desc";
      
//      System.out.println("Query6: "+qr6);
//      System.out.println("st: "+st);
      psmt1=con.prepareStatement(qr6);
      rs1=psmt1.executeQuery(); 
      while(rs1.next()){
      ar.add(rs1.getString("heads"));
      ar1.add(rs1.getString("field_name"));
      hm1.put(rs1.getString("heads"), rs1.getString("field_name"));
      headsfield.put(rs1.getString("field_name"), rs1.getString("heads"));
      }
      
      double feetot=0.0;
      double f=0;
String str="select * from stud_fee_detail_excel where stud_id='"+seo1.getStud_id()+"' and session='"+seo1.getSession()+"' and session_sem='"+seo1.getSession_sem()+"'";
//System.out.println("Str: "+str);
      psmt=con.prepareStatement(str);
      rs=psmt.executeQuery();
      if(rs.next())
      {
          seo1.setRwid(rs.getLong("rwid"));
          seo1.setPamount(rs.getDouble("self_finance_fee"));
          seo1.setEamount(rs.getDouble("extra"));
          feetot=feetot+seo1.getPamount()+seo1.getEamount();
          for(int i=0;i<ar1.size();i++)
          {
              f=rs.getDouble(ar1.get(i).toString());
              feetot=feetot+f;
              hm.put(ar1.get(i), f);
              headsAmount.put(headsfield.get(ar1.get(i)),f);
          }
       }

//      System.out.println(hm);      
     
      seo1.setDataArray1(ar1);
      seo1.setDataArray(ar1);      
      seo1.setDataArray2(ar);
      seo1.setDataMap(hm);
      seo1.setDataMap1(headsAmount);
      seo1.setFeeTotal(feetot);
      seo1.setDataArray3(this.bankList());  
      
  }catch(Exception e){System.out.println("Ex: "+e.getMessage());}
      finally{
      try{
           if(rs!=null){rs.close();}   
           if(rs1!=null){rs1.close();}    
         if(psmt1!=null){psmt1.close();}          
         if(psmt!=null){psmt.close();} 
          if(con!=null){con.close();}
       }   
      catch(SQLException se){}
     }
      return seo1;
}

public int updateStud_fee_detailExcel(SchoolEO seo,SchoolEO se)
{
   Connection con=null;
     ArrayList ar=se.getDataArray();
     HashMap hm=se.getDataMap();  
//  System.out.println("Size: "+ar.size());   
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
  int n=0;
  try
  {
      StringBuffer sb=new StringBuffer();
      sb=sb.append("update stud_fee_detail_excel set self_finance_fee=?,extra=?");
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
      psmt.setDouble(2, seo.getEamount());
     int j=3;
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
      psmt.setString(j+2, seo.getSession_sem());
      n=psmt.executeUpdate();
  }catch(Exception e){System.out.println("Ex..: "+e.getMessage());}
  finally{
       try{
         if(rs!=null){rs.close();}           
         if(psmt!=null){psmt.close();}       
         if(con!=null){con.close();}  
       }   
       catch(SQLException see){}
      } 
  return n;
}

public SchoolEO retStudScrollFromFeeDetails(SchoolEO seo)
{
        Connection con=null;
   ArrayList ar=new ArrayList();
       ArrayList fields=new ArrayList();
       HashMap hm=new HashMap();
        HashMap hm1=new HashMap();
         
         HashMap headsfield=new HashMap();
         
         try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
         try{
       String qr6="";

      
      if(seo.getStud_type().equals("Hosteller")){
            qr6="select distinct heads, heads_cat,field_name from feeheads where fee_type<>'Once At Admission' order by heads_cat desc";
      }
      else
      {
          qr6="select distinct heads, heads_cat,field_name from feeheads where stud_type='Day Scholar' and fee_type<>'Once At Admission' order by heads_cat desc";
      }
    
      
//      System.out.println("Query6: "+qr6);
//      System.out.println("st: "+st);
      psmt5=con.prepareStatement(qr6);
      rs5=psmt5.executeQuery(); 
      while(rs5.next()){
      ar.add(rs5.getString("heads"));
      fields.add(rs5.getString("field_name"));
      headsfield.put(rs5.getString("field_name"), rs5.getString("heads"));
      hm1.put(rs5.getString("heads"), rs5.getString("heads_cat"));
//      ar1.add(rs5.getString("field_name"));
//      hm1.put(rs5.getString("heads"), rs5.getString("field_name"));
      }
      
      String qr1="select * from stud_fee_detail where stud_id='"+seo.getStud_id()+"' and session='"+seo.getSession()+"' and session_sem='"+seo.getSession_sem()+"'"; 
      
      double feetot=0.0;
      int ch=0;
      psmt=con.prepareStatement(qr1); 
      rs=psmt.executeQuery();  
      if(rs.next()){
          seo.setDeposite_date(rs.getDate("submission_date"));
          seo.setBankname("subm_bank");
          seo.setPamount(rs.getDouble("self_finance_fee"));
          feetot=feetot+seo.getPamount();
          for(int j=0;j<fields.size();j++){
                hm.put(headsfield.get(fields.get(j)),rs.getString(fields.get(j).toString()));
                feetot=feetot+rs.getDouble(fields.get(j).toString());
//          System.out.println("check "+(i+1)+": "+ar1.size());
            }
         }   
      String qr="select fine,last_date from latefine_onfeeProcess where stud_id='"+seo.getStud_id()+"' and session='"+seo.getSession()+"'"
               + " and session_sem='"+seo.getSession_sem()+"'";
      psmt1=con.prepareStatement(qr);
      rs1=psmt1.executeQuery();
      if(rs1.next())
      {
          seo.setFine(rs1.getDouble("fine"));
          feetot=feetot+rs1.getDouble("fine");
      }
//      System.out.println(feetot);
      seo.setDataArray(ar);      
      seo.setDataArray1(fields);
      seo.setDataMap(hm);
      seo.setFeeTotal(feetot);
       
      
  }catch(Exception e){System.out.println("Ex: "+e.getMessage());}
      finally{
      try{
            if(rs!=null){rs.close();}   
            if(rs1!=null){rs1.close();}  
            if(rs5!=null){rs5.close();}  
            if(psmt!=null){psmt.close();}
            if(psmt1!=null){psmt1.close();} 
            if(psmt5!=null){psmt5.close();}
            if(con!=null){con.close();}
       }   
      catch(SQLException se){}
     }
    return seo;
}

public SchoolEO retStudScrollFrom_stud_fee_detail(SchoolEO seo)
{
        Connection con=null;
   ArrayList ar=new ArrayList();
       ArrayList fields=new ArrayList();
       HashMap hm=new HashMap();
        HashMap hm1=new HashMap();
         
         HashMap headsfield=new HashMap();
         
         try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
         try{
       String qr6="select distinct heads, heads_cat,field_name from feeheads order by heads_cat desc";
      psmt5=con.prepareStatement(qr6);
      rs5=psmt5.executeQuery(); 
      while(rs5.next()){
      ar.add(rs5.getString("heads"));
      fields.add(rs5.getString("field_name"));
      headsfield.put(rs5.getString("field_name"), rs5.getString("heads"));
      hm1.put(rs5.getString("heads"), rs5.getString("heads_cat"));
      }
      
      String qr1="select * from stud_fee_detail where stud_id='"+seo.getStud_id()+"' and session='"+seo.getSession()+"' and session_sem='"+seo.getSession_sem()+"'"; 
      
      double feetot=0.0;
      int ch=0;
      psmt=con.prepareStatement(qr1); 
      rs=psmt.executeQuery();  
      if(rs.next()){
          seo.setDeposite_date(rs.getDate("submission_date"));
          seo.setBankname(rs.getString("subm_bank"));
          seo.setPamount(rs.getDouble("self_finance_fee"));
          seo.setEamount(rs.getDouble("extra"));
          feetot=feetot+seo.getPamount()+seo.getEamount();
          for(int j=0;j<fields.size();j++){
                hm.put(headsfield.get(fields.get(j)),rs.getString(fields.get(j).toString()));
                feetot=feetot+rs.getDouble(fields.get(j).toString());
//          System.out.println("check "+(i+1)+": "+ar1.size());
            }
         }   
      String qr="select fine,last_date from latefine_onfeeProcess where stud_id='"+seo.getStud_id()+"' and session='"+seo.getSession()+"'"
               + " and session_sem='"+seo.getSession_sem()+"'";
//      System.out.println("qry: "+qr);
      psmt1=con.prepareStatement(qr);
      rs1=psmt1.executeQuery();
      if(rs1.next())
      {
          seo.setFine(rs1.getDouble("fine"));
          feetot=feetot+rs1.getDouble("fine");
      }
//      System.out.println(feetot);
      seo.setDataArray(ar);      
      seo.setDataArray1(fields);
      seo.setDataMap(hm);
      seo.setFeeTotal(feetot);
       
      
  }catch(Exception e){System.out.println("Ex: "+e.getMessage());}
      finally{
      try{
            if(rs!=null){rs.close();}   
            if(rs1!=null){rs1.close();}  
            if(rs5!=null){rs5.close();}  
            if(psmt!=null){psmt.close();}
            if(psmt1!=null){psmt1.close();} 
            if(psmt5!=null){psmt5.close();}
            if(con!=null){con.close();}
       }   
      catch(SQLException se){}
     }
    return seo;
}

public ArrayList retMoreStudScrollFrom_stud_fee_detail(SchoolEO seo)
{
    ArrayList al=new ArrayList();
    Connection con=null;
    ArrayList ar=new ArrayList();
    ArrayList fields=new ArrayList();
    
    HashMap hm1=new HashMap();
    HashMap headsfield=new HashMap();
         
         try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
         try{
       String qr6="select distinct heads, heads_cat,field_name from feeheads order by heads_cat desc";
      psmt5=con.prepareStatement(qr6);
      rs5=psmt5.executeQuery(); 
      while(rs5.next()){
      ar.add(rs5.getString("heads"));
      fields.add(rs5.getString("field_name"));
      headsfield.put(rs5.getString("field_name"), rs5.getString("heads"));
      hm1.put(rs5.getString("heads"), rs5.getString("heads_cat"));
      }
      
      String qr1="select * from stud_fee_detail where stud_id='"+seo.getStud_id()+"' and session='"+seo.getSession()+"' and session_sem='"+seo.getSession_sem()+"'"; 
//      System.out.println("ss: "+qr1);
      
     
      psmt=con.prepareStatement(qr1); 
      rs=psmt.executeQuery();  
      while(rs.next()){
          double feetot=0.0;
          SchoolEO seo1=new SchoolEO();
          HashMap hm=new HashMap();
          seo1.setDeposite_date(rs.getDate("submission_date"));
          seo1.setBankname(rs.getString("subm_bank"));
          seo1.setPamount(rs.getDouble("self_finance_fee"));
          seo1.setEamount(rs.getDouble("extra"));
          feetot=feetot+seo1.getPamount()+seo1.getEamount();
          for(int j=0;j<fields.size();j++){
                hm.put(headsfield.get(fields.get(j)),rs.getString(fields.get(j).toString()));
                feetot=feetot+rs.getDouble(fields.get(j).toString());
//          System.out.println("check "+(i+1)+": "+ar1.size());
            }
          seo1.setDataArray(ar);      
          seo1.setDataArray1(fields);
          seo1.setDataMap(hm);
//          System.out.println("kk: "+seo1.getDataMap());
          seo1.setFeeTotal(feetot);
          al.add(seo1);
         }   
    }catch(Exception e){System.out.println("Ex: "+e.getMessage());}
      finally{
      try{
            if(rs!=null){rs.close();}   
            if(rs1!=null){rs1.close();}  
            if(rs5!=null){rs5.close();}  
            if(psmt!=null){psmt.close();}
            if(psmt1!=null){psmt1.close();} 
            if(psmt5!=null){psmt5.close();}
            if(con!=null){con.close();}
       }   
      catch(SQLException se){}
     }
    return al;
}

public SchoolEO retStudTotFine(SchoolEO seo){
    Connection con=null;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
         try{
     
      String qr="select sum(fine) as fine from latefine_onfeeProcess where stud_id='"+seo.getStud_id()+"' and session='"+seo.getSession()+"'"
               + " and session_sem='"+seo.getSession_sem()+"'";
      psmt1=con.prepareStatement(qr);
      rs1=psmt1.executeQuery();
      if(rs1.next())
      {
          seo.setFine(rs1.getDouble("fine"));
       }
    }catch(Exception e){System.out.println("Ex: "+e.getMessage());}
      finally{
      try{
            if(rs!=null){rs.close();}   
            if(rs1!=null){rs1.close();}  
            if(rs5!=null){rs5.close();}  
            if(psmt!=null){psmt.close();}
            if(psmt1!=null){psmt1.close();} 
            if(psmt5!=null){psmt5.close();}
            if(con!=null){con.close();}
       }   
      catch(SQLException se){}
     }
    return seo;
}

public void submit_feeData(SchoolEO seo, Connection conSave) throws Exception
{
       String type="";
       
       try{         
           int ssn=Integer.parseInt(seo.getSemester())+1;
       
          String qr2="insert into sub_feedata(session,regist_no,sname,classes,type,gender,fee_total,enroll_no,fee_receipt,semester,batch,"
                  + "session_sem,deposit_date,stud_id,transaction_id,subm_bank,fine) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";     
      psmt2=conSave.prepareStatement(qr2);
      psmt2.setString(1,seo.getSession());
      psmt2.setString(2,seo.getRegistNo());
      psmt2.setString(3,seo.getSname());
      psmt2.setString(4,seo.getDegree());
      psmt2.setString(5,seo.getType());
      psmt2.setString(6,seo.getGender());
      psmt2.setDouble(7,seo.getFeeTotal()+seo.getPamount());
      psmt2.setString(8,seo.getEnrolNo());
      psmt2.setLong(9,seo.getFeeReceipt());
      psmt2.setString(10,Integer.toString(ssn));
      psmt2.setString(11,seo.getBatch());
      psmt2.setString(12,seo.getSession_sem());
      psmt2.setDate(13, new java.sql.Date(seo.getDeposite_date().getTime()));
      psmt2.setString(14,seo.getStud_id());
      psmt2.setString(15,seo.getTransaction_id());
      psmt2.setString(16,seo.getBankname());
      psmt2.setDouble(17,seo.getFine());
      psmt2.executeUpdate();   
      
      String qr3="update studentregis set semester=? where stud_id=? and batch=?";
      psmt4=conSave.prepareStatement(qr3);
      int sem=Integer.parseInt(seo.getSemester())+1;
//      System.out.println("kapil: "+sem);
      psmt4.setString(1, Integer.toString(sem));
      psmt4.setString(2, seo.getStud_id());
      psmt4.setString(3, seo.getBatch());
      psmt4.executeUpdate();
      
//      String qr4="update finerecord set status=? where stud_id=? and session=? and status=?";
//      psmt3=con.prepareStatement(qr4);
//      psmt3.setString(1, "Paid");
//      psmt3.setString(2, seo.getStud_id());
//      psmt3.setString(3, seo.getSession());
//      psmt3.setString(4, "Unpaid");
//      psmt3.executeUpdate();
      
//      String qr1="update monthly_food set food_bill=? where stud_id=? and session=? and food_bill=?";
      String qr1="update monthly_food set food_bill=? where stud_id=? and food_bill=?";
      psmt1=conSave.prepareStatement(qr1);
      psmt1.setString(1, "Processed");
      psmt1.setString(2, seo.getStud_id());
//      psmt1.setString(3, seo.getSession());
      psmt1.setString(3, "Unprocess");
      psmt1.executeUpdate();
      
       }catch(Exception e){System.out.println("Exc: "+e.getMessage());
        throw e;
       }
       finally{
      try{
          if(rs!=null){rs.close();}
          if(rs1!=null){rs1.close();}
          if(psmt1!=null){psmt1.close();} 
          if(psmt3!=null){psmt3.close();}          
         if(psmt2!=null){psmt2.close();} 
         if(psmt4!=null){psmt4.close();} 
       }   
      catch(SQLException se){}
     }
 }

public void submitfeeData(SchoolEO seo, Connection conSave) throws Exception
{
    CommonFunctionality cFun=new CommonFunctionality();
  ArrayList al=new ArrayList();
       String type="";
       
       try{         
           int ssn=Integer.parseInt(seo.getSemester())+1;
       
          String qr2="insert into sub_feedata(session,regist_no,sname,classes,type,gender,fee_total,enroll_no,fee_receipt,semester,batch,"
                  + "session_sem,deposit_date,stud_id,transaction_id,subm_bank,fine,data_entry_time) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";     
      psmt2=conSave.prepareStatement(qr2);
      psmt2.setString(1,seo.getSession());
      psmt2.setString(2,seo.getRegistNo());
      psmt2.setString(3,seo.getSname());
      psmt2.setString(4,seo.getDegree());
      psmt2.setString(5,seo.getType());
      psmt2.setString(6,seo.getGender());
      psmt2.setDouble(7,seo.getFeeTotal());
      psmt2.setString(8,seo.getEnrolNo());
      psmt2.setLong(9,seo.getFeeReceipt());
      psmt2.setString(10,Integer.toString(ssn));
      psmt2.setString(11,seo.getBatch());
      psmt2.setString(12,seo.getSession_sem());
      psmt2.setDate(13, new java.sql.Date(seo.getDeposite_date().getTime()));
      psmt2.setString(14,seo.getStud_id());
      psmt2.setString(15,seo.getTransaction_id());
      psmt2.setString(16,seo.getBankname());
      psmt2.setDouble(17,seo.getFine());
      psmt2.setTimestamp(18, new java.sql.Timestamp(new java.util.Date().getTime()));
      psmt2.executeUpdate();   
      
      String qr3="update studentregis set semester=? where stud_id=? and batch=?";
      psmt4=conSave.prepareStatement(qr3);
      int sem=Integer.parseInt(seo.getSemester())+1;
//      System.out.println("kapil: "+sem);
      psmt4.setString(1, Integer.toString(sem));
      psmt4.setString(2, seo.getStud_id());
      psmt4.setString(3, seo.getBatch());
      psmt4.executeUpdate();
      
//      String qr4="update finerecord set status=? where stud_id=? and session=? and status=?";
//      psmt3=con.prepareStatement(qr4);
//      psmt3.setString(1, "Paid");
//      psmt3.setString(2, seo.getStud_id());
//      psmt3.setString(3, seo.getSession());
//      psmt3.setString(4, "Unpaid");
//      psmt3.executeUpdate();
      
//      String qr1="update monthly_food set food_bill=? where stud_id=? and session=? and food_bill=?";
        String status=cFun.getStringFromString(seo.getStatus());
        HashMap hm=seo.getDataMap();  
        Double foodBill =cFun.getDoubleFromDouble(Double.parseDouble(hm.get("field18").toString()));
      if(cFun.getStringFromString(seo.getStud_type()).equals("Hosteller")&&(status.equals("")||(status.equals("manual")&&foodBill>0))){
        String qr1="update monthly_food set food_bill=? where stud_id=? and food_bill=?";
        psmt1=conSave.prepareStatement(qr1);
        psmt1.setString(1, "Processed");
        psmt1.setString(2, seo.getStud_id());
  //      psmt1.setString(3, seo.getSession());
        psmt1.setString(3, "Unprocess");
        psmt1.executeUpdate();
      }
       }catch(Exception e){System.out.println("Exc: "+e.getMessage());
        throw e;
       }
       finally{
      try{
          if(rs!=null){rs.close();}
          if(rs1!=null){rs1.close();}
          if(psmt1!=null){psmt1.close();} 
          if(psmt3!=null){psmt3.close();}          
         if(psmt2!=null){psmt2.close();} 
         if(psmt4!=null){psmt4.close();} 
       }   
      catch(SQLException se){}
     }
 }

public int updateStud_fee_detail(SchoolEO seo,SchoolEO se)
{
   Connection con=null;
     ArrayList ar=se.getDataArray();
     HashMap hm=se.getDataMap();  
//  System.out.println("Size: "+ar.size());   
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
  int n=0;
  try
  {
      String bank=this.retBankFromTable("stud_fee_detail", "subm_bank", seo);
      StringBuffer sb=new StringBuffer();
      if(bank.equals("")){
          seo.setBankname("");
      }
      
      sb=sb.append("update stud_fee_detail set self_finance_fee=?,extra=?,subm_bank=?,submission_date=?");
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
      psmt.setDouble(2, seo.getEamount());
      psmt.setString(3, seo.getBankname());
      psmt.setDate(4, new java.sql.Date(seo.getDeposite_date().getTime()));
      int j=5;
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
      psmt.setString(j+2, seo.getSession_sem());
      n=psmt.executeUpdate();
  }catch(Exception e){System.out.println("Ex..: "+e.getMessage());}
  finally{
       try{
         if(rs!=null){rs.close();}           
         if(psmt!=null){psmt.close();}       
         if(con!=null){con.close();}  
       }   
       catch(SQLException see){}
      } 
  return n;
}

public int updateStud_fee_detail(SchoolEO seo,SchoolEO se, Connection conUpdate) throws Exception
{
     ArrayList ar=se.getDataArray();
     HashMap hm=se.getDataMap();  
//  System.out.println("Size: "+ar.size());   
  int n=0;
  try
  {
      String bank=this.retBankFromTable("stud_fee_detail", "subm_bank", seo);
      StringBuffer sb=new StringBuffer();
      if(bank.equals("")){
          seo.setBankname("");
      }
      
      sb=sb.append("update stud_fee_detail set self_finance_fee=?,extra=?,subm_bank=?,submission_date=?");
      for(int i=0;i<ar.size();i++)
      {
          sb=sb.append(",");
          sb=sb.append(ar.get(i).toString());
          sb=sb.append("=?");
      }
      sb=sb.append(" where stud_id=? and session=? and session_sem=?");
      
//      System.out.println(sb.toString());
      psmt=conUpdate.prepareStatement(sb.toString());
      psmt.setDouble(1, seo.getPamount());
      psmt.setDouble(2, seo.getEamount());
      psmt.setString(3, seo.getBankname());
      psmt.setDate(4, new java.sql.Date(seo.getDeposite_date().getTime()));
      int j=5;
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
      psmt.setString(j+2, seo.getSession_sem());
      n=psmt.executeUpdate();
  }catch(Exception e){System.out.println("Ex..: "+e.getMessage());
   throw e;
  }
  finally{
       try{
         if(rs!=null){rs.close();}           
         if(psmt!=null){psmt.close();}        
       }   
       catch(SQLException see){}
      } 
  return n;
}

public void updateSud_feedata(SchoolEO seo)
{
   Connection con=null;
     
     
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
 
  try
  {
      String bank=this.retBankFromTable("sub_feedata", "subm_bank", seo);
      
      if(bank.equals("")){
          seo.setBankname("");
      }
      
      String sb="update sub_feedata set fee_total=?,subm_bank=?,deposit_date=? where stud_id=? and session=? and session_sem=?";
      
        psmt=con.prepareStatement(sb.toString());
      psmt.setDouble(1, seo.getFeeTotal());
      psmt.setString(2, seo.getBankname());
      psmt.setDate(3, new java.sql.Date(seo.getDeposite_date().getTime()));
      psmt.setString(4, seo.getStud_id());
      psmt.setString(5, seo.getSession());
      psmt.setString(6, seo.getSession_sem());
      
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

public void updateSud_feedata(SchoolEO seo, Connection conUpdate) throws Exception
{
  try
  {
      String bank=this.retBankFromTable("sub_feedata", "subm_bank", seo);
      
      if(bank.equals("")){
          seo.setBankname("");
      }
      
      String sb="update sub_feedata set fee_total=?,subm_bank=?,deposit_date=? where stud_id=? and session=? and session_sem=?";
      
        psmt=conUpdate.prepareStatement(sb.toString());
      psmt.setDouble(1, seo.getFeeTotal());
      psmt.setString(2, seo.getBankname());
      psmt.setDate(3, new java.sql.Date(seo.getDeposite_date().getTime()));
      psmt.setString(4, seo.getStud_id());
      psmt.setString(5, seo.getSession());
      psmt.setString(6, seo.getSession_sem());
      
     psmt.executeUpdate();
  }catch(Exception e){System.out.println("Ex: "+e.getMessage());
    throw e;
  }
  finally{
       try{
         if(rs!=null){rs.close();}           
         if(psmt!=null){psmt.close();}        
       }   
       catch(SQLException see){}
      } 
}

public String retBankFromTable(String table,String field,SchoolEO seo){
    String bank="";
    Connection con=null;
  
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
  try{
      String st="select "+field+" from "+table+" where stud_id=? and session_sem=? and session=?";
      psmt3=con.prepareStatement(st);
        psmt3.setString(1, seo.getStud_id());
        psmt3.setString(2, seo.getSession_sem());
        psmt3.setString(3, seo.getSession());
        rs=psmt3.executeQuery();
        if(rs.next()){
            bank=rs.getString(field);
        }
  }catch(Exception e){}
  finally{
      try{
            if(psmt3!=null){psmt3.close();}    
            if(rs!=null){rs.close();}    
            if(con!=null){con.close();}
       }   
      catch(SQLException se){}
     }
    return bank;
}

public void updateNoduesIn_feeData(SchoolEO seo,Connection con)
{
//    Connection con=null;
//  ArrayList al=new ArrayList();
//  try{
//  Dataconnectivity dc=new Dataconnectivity();
//  con=(Connection)dc.Dataconnect();
//  }catch(Exception e){}
//       
       
       try{ 
        String qr4="update sub_feedata set nodues=? where stud_id=? and session=? and session_sem=?";
        psmt3=con.prepareStatement(qr4);
        psmt3.setString(1, "Done");
        psmt3.setString(2, seo.getStud_id());
        psmt3.setString(3, seo.getSession());
        psmt3.setString(4, seo.getSession_sem());
        psmt3.executeUpdate();
        

//        qr4="update studentregis set registration=?,regist_date=? where stud_id=?";
//        psmt3=con.prepareStatement(qr4);
//        psmt3.setString(1, "Yes");
//        psmt3.setDate(2, new java.sql.Date(new java.util.Date().getTime()));
//        psmt3.setString(3, seo.getStud_id());
//        psmt3.executeUpdate();
      
       }catch(Exception e){System.out.println("Exc: "+e.getMessage());}
       finally{
      try{
            if(psmt3!=null){psmt3.close();}          
            //if(con!=null){con.close();}
       }   
      catch(SQLException se){}
     }
}

public void insertStudentNoduesSemwise(SchoolEO seo,Connection con){
//    Connection con=null;     
//  try{
//  Dataconnectivity dc=new Dataconnectivity();
//  con=(Connection)dc.Dataconnect();
//  }catch(Exception e){}
  try
  {
      String sb="insert into nodues_semester(session,session_sem,stud_id,batch,degree,total_amount,nodues_date,nodues_by,transaction_id,"
              + "sname,contact) values(?,?,?,?,?,?,?,?,?,?,?)";
      
        psmt=con.prepareStatement(sb.toString());
        psmt.setString(1, seo.getSession());
        psmt.setString(2, seo.getSession_sem());
        psmt.setString(3, seo.getStud_id());
      psmt.setString(4, seo.getBatch());
      psmt.setString(5, seo.getDegree());
      psmt.setDouble(6, seo.getFeeTotal());
      psmt.setTimestamp(7, new java.sql.Timestamp(new java.util.Date().getTime()));
      psmt.setString(8, seo.getLoginName());
      psmt.setString(9, seo.getTransaction_id());
      psmt.setString(10, seo.getSname());
      psmt.setString(11, seo.getMobile());
     psmt.executeUpdate();
  }catch(Exception e){System.out.println("Ex: "+e.getMessage());}
  finally{
       try{
         if(rs!=null){rs.close();}           
         if(psmt!=null){psmt.close();}       
        // if(con!=null){con.close();}  
       }   
       catch(SQLException see){}
      } 
}
public void insertSemStudRegis(SchoolEO seo,Connection con){
//    Connection con=null;     
//  try{
//  Dataconnectivity dc=new Dataconnectivity();
//  con=(Connection)dc.Dataconnect();
//  }catch(Exception e){}
  try
  {
      String sb="insert into sem_studregis(session,session_sem,stud_id,registration_date,registration,reg_by,batch,degree,sname) values(?,?,?,?,?,?,?,?,?)";
      
        psmt=con.prepareStatement(sb.toString());
        psmt.setString(1, seo.getSession());
        psmt.setString(2, seo.getSession_sem());
        psmt.setString(3, seo.getStud_id());
      psmt.setTimestamp(4, new java.sql.Timestamp(new java.util.Date().getTime()));
      psmt.setString(5, "Done");
      psmt.setString(6, seo.getLoginName());
      psmt.setString(7, seo.getBatch());
      psmt.setString(8, seo.getDegree());
      psmt.setString(9, seo.getSname());
     psmt.executeUpdate();
  }catch(Exception e){System.out.println("Ex: "+e.getMessage());}
  finally{
       try{
         if(rs!=null){rs.close();}           
         if(psmt!=null){psmt.close();}       
         //if(con!=null){con.close();}  
       }   
       catch(SQLException see){}
      } 
}

public void writeNodusedStudentToExcelFile(String fileP,SchoolEO seo,String date,String filename,Connection con) throws Exception{
        Workbook workbook = null;
         
         
         File file=new File(fileP);
        Sheet sheet = null;
         
int rowIndex = 1;
         if(!file.exists()){
             if(filename.endsWith("xls")){
            workbook = new HSSFWorkbook();
        }else{
            throw new Exception("invalid file name, should be xls or xlsx");
        }
             saveNoduesedExcel(filename,con);
             sheet = workbook.createSheet("NoduesList");

             Row row = sheet.createRow(0);
             Cell cell0 = row.createCell(0);
            cell0.setCellValue("Name");
            Cell cell1 = row.createCell(1);
            cell1.setCellValue("ID NO");
//            Cell cell1 = row.createCell(1);
//            cell1.setCellValue("BATCH");
//            Cell cell2 = row.createCell(2);
//            cell2.setCellValue("SESSION");
            Cell cell2 = row.createCell(2);
            cell2.setCellValue("Amount");
            Cell cell3 = row.createCell(3);
            cell3.setCellValue("Nodues Date");
            Cell cell4 = row.createCell(4);
            cell4.setCellValue("Programme");
            Cell cell5 = row.createCell(5);
            cell5.setCellValue("Transaction ID");
            Cell cell6 = row.createCell(6);
            cell6.setCellValue("Contact");
         }
         else{
             FileInputStream fis = new FileInputStream(file);
             workbook = new HSSFWorkbook(fis);
             sheet = workbook.getSheetAt(0);
             rowIndex=sheet.getPhysicalNumberOfRows();
         }
        
            Row row = sheet.createRow(rowIndex);
            Cell cell0 = row.createCell(0);
            cell0.setCellValue(seo.getSname());
            Cell cell1 = row.createCell(1);
            cell1.setCellValue(seo.getStud_id());
//            Cell cell1 = row.createCell(1);
//            cell1.setCellValue(seo.getBatch());
//            Cell cell2 = row.createCell(2);
//            cell2.setCellValue(seo.getSession()+"-"+seo.getSession_sem());
            Cell cell2 = row.createCell(2);
            cell2.setCellValue(seo.getFeeTotal());
            Cell cell3 = row.createCell(3);
            cell3.setCellValue(date);
            Cell cell4 = row.createCell(4);
            cell4.setCellValue(seo.getDegree());
            Cell cell5 = row.createCell(5);
            cell5.setCellValue(seo.getTransaction_id());
            Cell cell6 = row.createCell(6);
            cell6.setCellValue(seo.getMobile());
        
         
        //lets write the excel data to file now
        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);
        fos.close();
    }
public void saveNoduesedExcel(String filename,Connection con){
//    Connection con=null;
//    try{
//  Dataconnectivity dc=new Dataconnectivity();
//  con=(Connection)dc.Dataconnect();
//  }catch(Exception e){}
    try{
        String s="insert into noduesed_excels(filename, date)values(?,?)";
        psmt=con.prepareStatement(s);
        psmt.setString(1, filename);
        psmt.setDate(2, new java.sql.Date(new java.util.Date().getTime()));
        psmt.executeUpdate();
    }catch(Exception e){System.out.println("Exc: "+e.getMessage());}
       finally{
      try{
          if(rs!=null){rs.close();}
          if(rs1!=null){rs1.close();}
          if(psmt!=null){psmt.close();} 
           if(psmt1!=null){psmt1.close();} 
        //if(con!=null){con.close();}
       }   
      catch(SQLException se){}
     }
}    
public int checkSubmited_feeData(SchoolEO seo)
{
    Connection con=null;
  ArrayList al=new ArrayList();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
       int count=0;
       try{         
           
       String qr1="select count(stud_id) as cnt from sub_feedata where stud_id='"+seo.getStud_id()+"' and session='"+seo.getSession()+"'"
               + " and session_sem='"+seo.getSession_sem()+"'";
//       System.out.println(qr1);
      psmt=con.prepareStatement(qr1);
      rs=psmt.executeQuery();
      rs.next();
      count=rs.getInt("cnt"); 
      if(count!=0)
      {
          String qr5="select count(stud_id) as cnt from nodues_semester where stud_id='"+seo.getStud_id()+"' and session='"+seo.getSession()+"'"
               + " and session_sem='"+seo.getSession_sem()+"'";
//          System.out.println(qr5);
          psmt1=con.prepareStatement(qr5);
          rs1=psmt1.executeQuery();
          if(rs1.next())
          {
              if(rs1.getInt("cnt")!=0)
                  count=2;
              else
                  count=1;
          }
      }
       }catch(Exception e){System.out.println("Exc: "+e.getMessage());}
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
       return count;
}
public int checkSubmited_feeData1(SchoolEO seo)
{
    Connection con=null;
  ArrayList al=new ArrayList();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
       int count=0;
       try{         
           
       String qr1="select count(stud_id) as cnt from sub_feedata where stud_id='"+seo.getStud_id()+"' and session='"+seo.getSession()+"'"
               + " and session_sem='"+seo.getSession_sem()+"'";
    //   System.out.println(qr1);
      psmt=con.prepareStatement(qr1);
      rs=psmt.executeQuery();
      rs.next();
      count=rs.getInt("cnt"); 
      if(count!=1&&count!=0)
      {
          count=-10;
      }
       }catch(Exception e){System.out.println("Exc: "+e.getMessage());}
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
       return count;
}

public SchoolEO calFineOnLateFeeSubm(SchoolEO seo)
{
    Connection con=null;
  ArrayList al=new ArrayList();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
       try{
           String qr="select fine,last_date from latefine_onfeeProcess where stud_id='"+seo.getStud_id()+"' and session='"+seo.getSession()+"'"
               + " and session_sem='"+seo.getSession_sem()+"'";
//           System.out.println(qr);
           psmt2=con.prepareStatement(qr);
           rs2=psmt2.executeQuery();
           if(!rs2.next())
           {
//      String sst="select last_date, fine_per_day, max_fine,min_fine from latefine_onfee where session='"+seo.getSession()+"'"
//              + " and session_sem='"+seo.getSession_sem()+"'";
         String sst="select last_date, fine_per_day, max_fine,min_fine from latefine_onfee where degree=?";
      psmt1=con.prepareStatement(sst);
      psmt1.setString(1, seo.getDegree());
      rs1=psmt1.executeQuery();
      if(rs1.next())
      {
          seo.setLastdate(rs1.getString("last_date"));
          seo.setPfine(rs1.getDouble("fine_per_day"));
          seo.setMax_fine(rs1.getDouble("max_fine"));
          seo.setMin_fine(rs1.getDouble("min_fine"));
      }
//       String qr1="select deposit_date from sub_feedata where stud_id='"+seo.getStud_id()+"' and session='"+seo.getSession()+"'"
//               + " and session_sem='"+seo.getSession_sem()+"'";
       String qr1="select deposit_date from sub_feedata where rid = (select max(rid) from sub_feedata where stud_id='"+seo.getStud_id()+"' and "
               + "session='"+seo.getSession()+"' and session_sem='"+seo.getSession_sem()+"')";
//       System.out.println(qr1);
       java.util.Date date=null;
      psmt=con.prepareStatement(qr1);
      rs=psmt.executeQuery();
      if(rs.next())
      {
        if(rs.getDate("deposit_date")!=null)
        {
            seo.setDeposite_date(rs.getDate("deposit_date"));
            date=seo.getDeposite_date();
        }
        else
            date=new java.util.Date();
      }
      else
          date=new java.util.Date();
      SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date last_date=null;
            try{
                last_date=(java.util.Date)sdf.parse(seo.getLastdate());
     
                java.util.Date dep_date=date;
                date=null;
                int days=(int)((dep_date.getTime()-last_date.getTime())/(1000 * 60 * 60 * 24));
                if(days<0){
                    seo.setTot_days(0); 
                }
                else
                {
                    seo.setTot_days(days);
                }
            }catch(Exception eee){ System.out.println("parseing "+eee.getMessage());}
              
//     System.out.println("Total Days: "+seo.getTot_days()); 
           } 
           else{
//               System.out.println(rs2.getDouble("fine"));
               seo.setFine(rs2.getDouble("fine"));
               seo.setLastdate(rs2.getString("last_date"));
           }
      }catch(Exception e){System.out.println("Exc: "+e.getMessage());}
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

public double retStudentLateFine(SchoolEO seo1)
{
    double fine=0;
    Connection con=null;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
  
  try
  {
      String qr="select sum(fine) as fine from latefine_onfeeprocess where stud_id='"+seo1.getStud_id()+"' and session='"+seo1.getSession()+"' and session_sem='"+seo1.getSession_sem()+"'";
      System.out.println("qry: "+qr);
      psmt=con.prepareStatement(qr);
//      psmt.setString(1, seo1.getStud_id());
//      psmt.setString(2, seo1.getSession());
//      psmt.setString(3, seo1.getSession_sem());
      rs=psmt.executeQuery();
      if(rs.next())
      {
          fine=rs.getDouble("fine");
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
  return fine;
}

public void latefineprocess(SchoolEO seo,java.util.Date dt)
{
    Connection con=null;
  ArrayList al=new ArrayList();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
       
       try{ 
        String qr4="insert into latefine_onfeeprocess(session,session_sem,stud_id,fine,last_date,deposit_date,bank,receipt,fine_dep_date)"
                + " values(?,?,?,?,?,?,?,?,?)";
        psmt3=con.prepareStatement(qr4);
        psmt3.setString(1, seo.getSession());
        psmt3.setString(2, seo.getSession_sem());
        psmt3.setString(3, seo.getStud_id());
        psmt3.setDouble(4, seo.getFine());
        psmt3.setString(5, seo.getLastdate());
        psmt3.setDate(6, new java.sql.Date(seo.getDeposite_date().getTime()));
        psmt3.setString(7, seo.getBankname());
        psmt3.setInt(8, (int)seo.getFeeReceipt());
        psmt3.setDate(9, new java.sql.Date(dt.getTime()));
        psmt3.executeUpdate();
      
       }catch(Exception e){System.out.println("Exc: "+e.getMessage());}
       finally{
      try{
            if(psmt3!=null){psmt3.close();}          
            if(con!=null){con.close();}
       }   
      catch(SQLException se){}
     }
}

public SchoolEO noduesedStudent(SchoolEO seo)
{
    Connection con=null;
  ArrayList ar=new ArrayList();
  HashMap hm=new HashMap();
  ArrayList ar1=seo.getDataArray1();
  ArrayList ar5=seo.getDataArray5();
  int sz=ar1.size();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
       try{         
          
          String qr="select * from noduesed_student_amount where stud_id='"+seo.getStud_id()+"'";
//          System.out.println("qr: "+qr);
          psmt1=con.prepareStatement(qr);
          rs1=psmt1.executeQuery();
          while(rs1.next())
          {
              for(int i=0;i<sz;i++)
              {
                hm.put(ar1.get(i).toString(), rs1.getDouble(ar5.get(i).toString()));
              }
              seo.setReason(rs1.getString("reason"));
              seo.setDate(rs1.getDate("ndate"));
              seo.setStatus(rs1.getString("status"));
              seo.setTfee(rs1.getDouble("amount"));
              seo.setSession(rs1.getString("session"));
              seo.setSession_sem(rs1.getString("session_sem"));
          }
          seo.setDataArray(ar1);
          seo.setDataMap(hm);
      }catch(Exception e){System.out.println("Exc: "+e.getMessage());}
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

public SchoolEO selDistinctHeads(SchoolEO seo)
{
    Connection con=null;
  ArrayList ar1=new ArrayList();
  ArrayList ar5=new ArrayList();
  
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
       try{         
           String qr1="select distinct heads,field_name from feeheads";
       psmt=con.prepareStatement(qr1);
      rs=psmt.executeQuery();
      while(rs.next())
       {
           ar1.add(rs.getString("heads"));
           ar5.add(rs.getString("field_name"));
//           hm1.put(rs.getString("heads"), new Integer(0));
       }
      
        seo.setDataArray1(ar1);
        seo.setDataArray5(ar5);
     }catch(Exception e){System.out.println("Exc: "+e.getMessage());}
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

public SchoolEO selLastFeeFromStud_fee_detail(SchoolEO seo)
{
    Connection con=null;
  ArrayList ar1=seo.getDataArray1();
  ArrayList ar5=seo.getDataArray5();
  HashMap hm1=new HashMap();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
       try{         
           
      String sr="select * from stud_fee_detail where rwid=(select max(rwid) from stud_fee_detail where stud_id='"+seo.getStud_id()+"')";
//      System.out.println(sr);
      psmt=con.prepareStatement(sr);
//      psmt.setString(1, seo.getStud_id());
      rs=psmt.executeQuery();
      if(rs.next())
      {
          int sz=ar5.size();
          for(int i=0;i<sz;i++)
          {
              hm1.put(ar1.get(i), rs.getDouble(ar5.get(i).toString()));
          }
      }
      else{
          hm1=this.putZeroAgainstAllHeads(seo);
      }
        
        seo.setDataMap1(hm1);
        
     }catch(Exception e){System.out.println("Exc: "+e.getMessage());}
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

public SchoolEO selLastFeeFromStud_fee_detailForDegreeCmplt(SchoolEO seo)
{
    Connection con=null;
  ArrayList ar1=seo.getDataArray1();
  ArrayList ar5=seo.getDataArray5();
  HashMap hm1=new HashMap();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
       try{         
           
      String sr="select * from stud_fee_detail where rwid=(select max(rwid) from stud_fee_detail where stud_id='"+seo.getStud_id()+"')";
//      System.out.println(sr);
      psmt=con.prepareStatement(sr);
//      psmt.setString(1, seo.getStud_id());
      rs=psmt.executeQuery();
      if(rs.next())
      {
          int sz=ar5.size();
          for(int i=0;i<sz;i++)
          {
              if(ar1.get(i).toString().equals("FOOD ADVANCE"))
                hm1.put(ar1.get(i), rs.getDouble(ar5.get(i).toString()));
              else if(ar1.get(i).toString().equals("CAUTION MONEY"))
                hm1.put(ar1.get(i), rs.getDouble(ar5.get(i).toString()));
              else
                  hm1.put(ar1.get(i), new Double(0));
          }
      }
      else{
          hm1=this.putZeroAgainstAllHeads(seo);
      }
      
//        System.out.println(hm1);
        seo.setDataMap1(hm1);
        
     }catch(Exception e){System.out.println("Exc: "+e.getMessage());}
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

public SchoolEO selLastFeeFromStud_fee_detailForAfterRegis(SchoolEO seo)
{
    Connection con=null;
  ArrayList ar1=seo.getDataArray1();
  ArrayList ar5=seo.getDataArray5();
  HashMap hm1=new HashMap();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
       try{         
           
      String sr="select * from stud_fee_detail where rwid=(select max(rwid) from stud_fee_detail where stud_id='"+seo.getStud_id()+"')";
//      System.out.println(sr);
      psmt=con.prepareStatement(sr);
//      psmt.setString(1, seo.getStud_id());
      rs=psmt.executeQuery();
      if(rs.next())
      {
          
              hm1.put("FOOD ADVANCE", rs.getDouble("field10"));
              ar1.remove("FOOD ADVANCE");
              ar5.remove("field10");
              hm1.put("UTENSIL FEE", rs.getDouble("field11"));
              ar1.remove("UTENSIL FEE");
              ar5.remove("field11");
              hm1.put("FAN CHARGES", rs.getDouble("field12"));
              ar1.remove("FAN CHARGES");
              ar5.remove("field12");
              hm1.put("ROOM RENT", rs.getDouble("field13"));
              ar1.remove("ROOM RENT");
              ar5.remove("field13");
              hm1.put("ELECTRIC CHARGES", rs.getDouble("field15"));
              ar1.remove("ELECTRIC CHARGES");
              ar5.remove("field15");
              hm1.put("WATER CHARGES", rs.getDouble("field16"));
              ar1.remove("WATER CHARGES");
              ar5.remove("field16");
              hm1.put("MONTHLY FOOD BILL", rs.getDouble("field18"));
              ar1.remove("MONTHLY FOOD BILL");
              ar5.remove("field18");
              hm1.put("HOSTEL MAINTENANCE FEE", rs.getDouble("field26"));
              ar1.remove("HOSTEL MAINTENANCE FEE");
              ar5.remove("field26");
              hm1.put("CAUTION MONEY", rs.getDouble("field34"));
              ar1.remove("CAUTION MONEY");
              ar5.remove("field34");    
          
                  int sz=ar1.size();
          for(int i=0;i<sz;i++)
          {
              hm1.put(ar1.get(i), new Double(0));
          }
          ar1.add("FOOD ADVANCE");
          ar1.add("UTENSIL FEE");
          ar1.add("FAN CHARGES");
          ar1.add("ROOM RENT");
          ar1.add("ELECTRIC CHARGES");
          ar1.add("WATER CHARGES");
          ar1.add("MONTHLY FOOD BILL");
          ar1.add("HOSTEL MAINTENANCE FEE");
          ar1.add("CAUTION MONEY");
          
          ar5.add("field10");
          ar5.add("field11");
          ar5.add("field12");
          ar5.add("field13");
          ar5.add("field15");
          ar5.add("field16");
          ar5.add("field18");
          ar5.add("field26");
          ar5.add("field34");
      }
      else{
          hm1=this.putZeroAgainstAllHeads(seo);
          seo.setCounter(-1);
      }
//        System.out.println(hm1);
        seo.setDataMap1(hm1);
        
     }catch(Exception e){System.out.println("Exc: "+e.getMessage());}
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

public HashMap putZeroAgainstAllHeads(SchoolEO seo){
    HashMap hm1=new HashMap();
    ArrayList ar1=seo.getDataArray1();
    int sz=ar1.size();
          for(int i=0;i<sz;i++)
          {
              hm1.put(ar1.get(i), new Double(0));
          }
    return hm1;
}

public void draftReceivedForNodues(SchoolEO seo)
{
     
    Connection con=null;
      try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
      
      try
      {
         DataObjectFee dof=new DataObjectFee();
         long n=dof.getAutoGenerateNumber("setrnum", "nodues_rn");
         
         ArrayList ar=new ArrayList();
      ArrayList ar1=new ArrayList();
      ArrayList ar2=new ArrayList();
      ArrayList ar3=new ArrayList();
      ar=seo.getDataArray();
      ar1=seo.getDataArray1();
      ar2=seo.getDataArray2();
      ar3=seo.getDataArray3();
       String qr6="insert into noduesed_student_draft(session,srnum,draft_no,date,bank_name,amount,status,type,sname,deposite_date,receipt_no,"
              + "updation,degree,semester,batch,session_sem,stud_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
       psmt6=con.prepareStatement(qr6);
       for(int i=0;i<1;i++)
       {
         if(Double.parseDouble(ar3.get(i).toString())!=0.0)
           {
             psmt6.setString(1, seo.getSession());
               psmt6.setString(2, seo.getRegistNo());
               psmt6.setString(3, ar.get(i).toString());
               psmt6.setString(4, ar1.get(i).toString());
               psmt6.setString(5, ar2.get(i).toString());
               psmt6.setDouble(6, Double.parseDouble(ar3.get(i).toString()));
//               System.out.println("hello kapil: "+ar.get(i));
               psmt6.setString(7, "paid");
               psmt6.setString(8, seo.getStatus());
                psmt6.setString(9, seo.getSname());
                psmt6.setDate(10, new java.sql.Date(new java.util.Date().getTime()));
                psmt6.setLong(11, n);
                psmt6.setString(12, "unchecked");
                psmt6.setString(13, seo.getDegree());
                psmt6.setString(14, seo.getSemester());
                psmt6.setString(15, seo.getBatch());
                psmt6.setString(16, seo.getSession_sem());
                psmt6.setString(17, seo.getStud_id());
               psmt6.addBatch();
         }
       }
       psmt6.executeBatch();
       dof.updateAutoGenerateNumber("setrnum", "nodues_rn", n);
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
    
}

public SchoolEO retDraftReceivedForNodues(SchoolEO seo)
{
    SchoolEO seo1;
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    ArrayList al=new ArrayList();
  Connection con=null;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
       try{         
          
          String qr="select bank_name,draft_no,date,amount,deposite_date,type,receipt_no from noduesed_student_draft where stud_id='"+seo.getStud_id()+"'";
//          System.out.println("qr: "+qr);
          psmt1=con.prepareStatement(qr);
          rs=psmt1.executeQuery();
          while(rs.next())
          {
              seo1=new SchoolEO();
            seo1.setBankname(rs.getString("bank_name"));
            seo1.setDdate(rs.getString("date"));
            seo1.setDdno(rs.getString("draft_no"));
            seo1.setDdamount(rs.getDouble("amount"));
            seo1.setType(rs.getString("type"));
            seo1.setFeeReceipt(rs.getLong("receipt_no"));
               if(rs.getDate("deposite_date")!=null&&!rs.getDate("deposite_date").equals("")){
                 seo1.setDateofadd(sdf.format(rs.getDate("deposite_date")));  
               }
//               System.out.println("hiiiiHeloo "+seo1.getDateofadd());
             al.add(seo1);
          }
          seo.setDataArray(al);
          
      }catch(Exception e){System.out.println("Exc: "+e.getMessage());}
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

public ArrayList retMonthlyFoodBill(SchoolEO seo)
{
    Connection con=null;
  ArrayList ar1=new ArrayList();
  SchoolEO seo1=null;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
       try{         
            String qr1="select * from monthly_food where stud_id=? and food_bill=?";
            psmt=con.prepareStatement(qr1);
            psmt.setString(1, seo.getStud_id());
            psmt.setString(2, "Unprocess");
            rs=psmt.executeQuery();
            while(rs.next())
            {
                seo1=new SchoolEO();
                seo1.setMonth(rs.getString("month"));
                seo1.setMonthlyFood(rs.getDouble("food_amount"));
                seo.setDeposite_date(rs.getTimestamp("subm_date"));
                ar1.add(seo1);
            }
        
     }catch(Exception e){System.out.println("Exc: "+e.getMessage());}
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
    return ar1;
}

public Double retTotalMonthlyFoodBill(String stud_id)
{
    Connection con=null;
  double sum=0.0;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
       try{         
            String qr1="select sum(food_amount) as fd from monthly_food where stud_id=? and food_bill=?";
            psmt=con.prepareStatement(qr1);
            psmt.setString(1, stud_id);
            psmt.setString(2, "Unprocess");
            rs=psmt.executeQuery();
            if(rs.next())
            {
                if(rs.getString("fd")!=null)
                    sum=rs.getDouble("fd");
            }
        
     }catch(Exception e){System.out.println("Exc: "+e.getMessage());}
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
    return sum;
}

public Double retFeeOfHeadsFromStruc(String stud_id,String field)
{
    Connection con=null;
  double fadv=0.0;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
       try{         
//           String session=seo.getBatch()+"-"+(Integer.parseInt(seo.getBatch())+1);
           
//            String qr1="select fee from suraj_feechartdynam where heads=? and session=?";
           String qr1="select "+field+" from stud_fee_detail where rwid=(select max(rwid) from stud_fee_detail where stud_id=?)";
            psmt=con.prepareStatement(qr1);
//            psmt.setString(1, head);
//            psmt.setString(2, session);
            psmt.setString(1, stud_id);
            rs=psmt.executeQuery();
            if(rs.next())
            {
                fadv=rs.getDouble(field);
            }
        
     }catch(Exception e){System.out.println("Exc: "+e.getMessage());}
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
    return fadv;
}

public void insertInNoduesedStudent(SchoolEO seo,ArrayList al,HashMap hm)
{
    Connection con=null;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
       
       try{ 
           int sz=al.size();
           StringBuffer sb=new StringBuffer();
           sb=sb.append("insert into noduesed_student_amount(session,session_sem,stud_id,amount,status,reason,ndate,bank");
           for(int i=0;i<sz;i++)
            {
                sb=sb.append(",");
                sb=sb.append(al.get(i).toString());
            }
           sb=sb.append(") values(?,?,?,?,?,?,?,?");
           for(int i=0;i<sz;i++)
            {
                sb=sb.append(",");
                sb=sb.append("?");
            }
           sb=sb.append(")");
//        String qr4="insert into noduesed_student_amount(session,session_sem,stud_id,amount,heads,reason) values(?,?,?,?,?,?)";
//           System.out.println(sb);
        psmt3=con.prepareStatement(sb.toString());
        
        psmt3.setString(1, seo.getSession());
        psmt3.setString(2, seo.getSession_sem());
        psmt3.setString(3, seo.getStud_id());
        psmt3.setDouble(4, seo.getTfee());
        psmt3.setString(5, seo.getStatus());
        psmt3.setString(6, seo.getReason());
        psmt3.setDate(7, new java.sql.Date(new java.util.Date().getTime()));
        psmt3.setString(8, seo.getBankname());
        int j=9;
        for(int i=0;i<sz;i++)
            {
                psmt3.setDouble(j, Double.parseDouble(hm.get(al.get(i).toString()).toString()));
                j=j+1;
            }
        psmt3.executeUpdate();
      
       }catch(Exception e){System.out.println("Excp: "+e.getMessage());}
       finally{
      try{
            if(psmt3!=null){psmt3.close();}          
            if(con!=null){con.close();}
       }   
      catch(SQLException se){}
     }
}

public void updateMonthlyFoodBill(SchoolEO seo)
{
    Connection con=null;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
       
       
       try{ 
        String qr4="update monthly_food set food_bill=? where stud_id=? and food_bill=?";
        psmt3=con.prepareStatement(qr4);
        psmt3.setString(1, "Processed");
        psmt3.setString(2, seo.getStud_id());
        psmt3.setString(3, "Unprocess");
        psmt3.executeUpdate();
      
       }catch(Exception e){System.out.println("Exc: "+e.getMessage());}
       finally{
      try{
            if(psmt3!=null){psmt3.close();}          
            if(con!=null){con.close();}
       }   
      catch(SQLException se){}
     }
}

public void updateFinerecord(SchoolEO seo)
{
    Connection con=null;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
       
       try{ 
        String qr4="update finerecord set status=? where stud_id=? and status=?";
        psmt3=con.prepareStatement(qr4);
        psmt3.setString(1, "Paid");
        psmt3.setString(2, seo.getStud_id());
        psmt3.setString(3, "Unpaid");
        psmt3.executeUpdate();
      
       }catch(Exception e){System.out.println("Exc: "+e.getMessage());}
       finally{
      try{
            if(psmt3!=null){psmt3.close();}          
            if(con!=null){con.close();}
       }   
      catch(SQLException se){}
     }
}

public void subSponsoredAmount(SchoolEO seo)
{
   Connection con=null;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
  
  try
  {
      String sb="insert into sponsored_student(session,session_sem,stud_id,amount,deposit_date,receipt_no,bank) values(?,?,?,?,?,?,?)";
      psmt=con.prepareStatement(sb);
      
      psmt.setString(1, seo.getSession());
      psmt.setString(2, seo.getSession_sem());
      psmt.setString(3, seo.getStud_id());
      psmt.setDouble(4, seo.getAmountpaid());
      psmt.setDate(5, new java.sql.Date(seo.getDate().getTime()));
      psmt.setString(6, seo.getRecnum());
      psmt.setString(7, seo.getBankname());
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

public ArrayList retSponsoredAmount(String stud_id)
{
    Connection con=null;
  ArrayList list=new ArrayList();
  SchoolEO seo=null;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
       try{         
           String qr1="select st.stud_id,st.batch,st.degree,st.fname,st.studname,sp.session,sp.session_sem,sp.amount,sp.deposit_date,sp.bank,"
                   + "sp.receipt_no from studentregis st left join sponsored_student sp on st.stud_id=sp.stud_id where st.stud_id=? "
                   + "order by sp.deposit_date desc";
//           System.out.println("qr1: "+qr1);
            psmt=con.prepareStatement(qr1);
            psmt.setString(1, stud_id);
            rs=psmt.executeQuery();
            while(rs.next())
            {
                seo=new SchoolEO();
                seo.setSession(rs.getString("session"));
                seo.setSession_sem(rs.getString("session_sem"));
                seo.setStud_id(rs.getString("stud_id"));
                seo.setBatch(rs.getString("batch"));
                seo.setDegree(rs.getString("degree"));
                seo.setSname(rs.getString("studname"));
                seo.setFname(rs.getString("fname"));
                seo.setAmountpaid(rs.getDouble("amount"));
                seo.setDeposite_date(rs.getDate("deposit_date"));
                seo.setBankname(rs.getString("bank"));
                seo.setRecnum(rs.getString("receipt_no"));
                list.add(seo);
            }
        
     }catch(Exception e){System.out.println("Exc: "+e.getMessage());}
       finally{
      try{
          if(rs!=null){rs.close();}
          if(psmt!=null){psmt.close();} 
          if(con!=null){con.close();}
       }   
      catch(SQLException se){}
     }
    return list;
}

public int checkStudent_in(String table,String stud_id){
    Connection con=null;
   int cn=0;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
    try{         
           String qr1="select count(stud_id) as cnt from "+table+" where stud_id=?";
//           System.out.println("Query: "+qr1);
            psmt=con.prepareStatement(qr1);
            psmt.setString(1, stud_id);
            rs=psmt.executeQuery();
            if(rs.next())
            {
             cn=rs.getInt("cnt");   
            }
        
     }catch(Exception e){System.out.println("Exc: "+e.getMessage());}
       finally{
      try{
          if(rs!=null){rs.close();}
          if(psmt!=null){psmt.close();} 
          if(con!=null){con.close();}
       }   
      catch(SQLException se){}
     }
    return cn;
}

public int insertTransferStudent(SchoolEO seo)
{
   Connection con=null;
   int cn=0;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
  
  try
  {
      String sb="insert into transfered_student(session,stud_id,transfer_to) values(?,?,?)";
      psmt=con.prepareStatement(sb);
      
      psmt.setString(1, seo.getSession());
      psmt.setString(2, seo.getStud_id());
      psmt.setString(3, seo.getReason());
      cn=psmt.executeUpdate();
      
  }catch(Exception e){System.out.println("Ex: "+e.getMessage());}
  finally{
       try{
         if(rs!=null){rs.close();}           
         if(psmt!=null){psmt.close();}       
         if(con!=null){con.close();}  
       }   
       catch(SQLException see){}
      } 
  return cn;
}

public void updationForStudentTransfer(String stud_id)
{
    Connection con=null;
   int cn=0;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
  
  try
  {
    String qr1="update sub_feedata set student_transfer=? where stud_id=?";
     psmt1=con.prepareStatement(qr1);
     psmt1.setString(1, "Transfered");
     psmt1.setString(2, stud_id);
     psmt1.executeUpdate();
     
     String qr2="update stud_fee_draft set student_transfer=? where stud_id=?";
     psmt2=con.prepareStatement(qr2);
     psmt2.setString(1, "Transfered");
     psmt2.setString(2, stud_id);
     psmt2.executeUpdate();
     
     String qr3="update stud_draft set student_transfer=? where stud_id=?";
     psmt3=con.prepareStatement(qr3);
     psmt3.setString(1, "Transfered");
     psmt3.setString(2, stud_id);
     psmt3.executeUpdate();
     
     String qr7="update stud_fee_detail set student_transfer=? where stud_id=?";
     psmt4=con.prepareStatement(qr7);
     psmt4.setString(1, "Transfered");
     psmt4.setString(2, stud_id);
     psmt4.executeUpdate();
     }catch(Exception e){System.out.println("Ex: "+e.getMessage());}
  finally{
       try{
         if(rs!=null){rs.close();}           
         if(psmt1!=null){psmt1.close();} 
         if(psmt2!=null){psmt2.close();} 
         if(psmt3!=null){psmt3.close();} 
         if(psmt4!=null){psmt4.close();} 
         if(con!=null){con.close();}  
       }   
       catch(SQLException see){}
      } 
}

public SchoolEO retTransferedStudent(String stud_id)
{
    Connection con=null;
  ArrayList list=new ArrayList();
  SchoolEO seo=new SchoolEO();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
       try{         
           String qr1="select st.stud_id,st.batch,st.degree,st.fname,st.studname,ts.session,ts.transfer_to from studentregis st"
                    + " left join transfered_student ts on st.stud_id=ts.stud_id where st.stud_id=?";
            psmt=con.prepareStatement(qr1);
            psmt.setString(1, stud_id);
            rs=psmt.executeQuery();
            if(rs.next())
            {
                seo.setStud_id(rs.getString("stud_id"));
                seo.setBatch(rs.getString("batch"));
                seo.setDegree(rs.getString("degree"));
                seo.setSname(rs.getString("studname"));
                seo.setFname(rs.getString("fname"));
                seo.setSession(rs.getString("session"));
                if(rs.getString("transfer_to")!=null)
                    seo.setReason(rs.getString("transfer_to"));
            }
        
     }catch(Exception e){System.out.println("Exc: "+e.getMessage());}
       finally{
      try{
          if(rs!=null){rs.close();}
          if(psmt!=null){psmt.close();} 
          if(con!=null){con.close();}
       }   
      catch(SQLException se){}
     }
    return seo;
}

public void readExcelForScroll(SchoolEO seo,FormFile file)
{
    try{
        InputStream st= file.getInputStream();
               //Get the workbook instance for XLS file 
HSSFWorkbook workbook = new HSSFWorkbook(st);
 FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
 int nosheets=workbook.getNumberOfSheets();
 HSSFSheet sheet =null;
 for(int m=0;m<nosheets;m++){
//Get first sheet from the workbook
sheet = workbook.getSheetAt(m);

//Get iterator to all the rows in current sheet
Iterator<Row> rowIterator = sheet.iterator();
 
 int k=1;
 ArrayList dblist=new ArrayList();
 ArrayList al=new ArrayList();
 ArrayList flist=null;
 SchoolEO seo1=null;
 Integer in;
 Double foo;
while(rowIterator.hasNext()) {
        Row row = rowIterator.next();
         
     //For each row, iterate through each columns
        Iterator<Cell> cellIterator = row.cellIterator();
        int cells=row.getPhysicalNumberOfCells();
        if(k==1)
            {
                for(int i=0;i<cells;i++){
        if(cellIterator.hasNext()) {
             Cell cell = cellIterator.next();
            switch (evaluator.evaluateInCell(cell).getCellType()) 
                {
                case Cell.CELL_TYPE_STRING:
                   al.add(cell.getStringCellValue());
                    break;
                }
                }
            }
//                System.out.println(al);
         }
        else{
        seo1=new SchoolEO();
        seo1.setSession(seo.getSession());
        seo1.setSession_sem(seo.getSession_sem());
        ArrayList list=new ArrayList();
        flist=new ArrayList();
        for(int i=0;i<cells;i++){
        if(cellIterator.hasNext()) {
             
            Cell cell = cellIterator.next();

               if(i==0){
                switch (evaluator.evaluateInCell(cell).getCellType()) 
                {
                case Cell.CELL_TYPE_NUMERIC:
                    foo=cell.getNumericCellValue();
                    in=foo.intValue();
                    seo1.setBatch(in.toString());
                    break;
                case Cell.CELL_TYPE_STRING:
                    seo1.setBatch(cell.getStringCellValue());
                    break;
               }   
            }   
            else if(i==1)
            {
                switch (evaluator.evaluateInCell(cell).getCellType()) 
                {
                case Cell.CELL_TYPE_NUMERIC:
                    foo=cell.getNumericCellValue();
                    in=foo.intValue();
                    seo1.setStud_id(in.toString());
                    break;
                case Cell.CELL_TYPE_STRING:
                    seo1.setStud_id(cell.getStringCellValue());
                    break;
               }   
            }
            else if(i==2)
            {
                switch (evaluator.evaluateInCell(cell).getCellType()) 
                {
                case Cell.CELL_TYPE_STRING:
                    seo1.setDegree(cell.getStringCellValue());
                    break;
               }   
            }
            else if(i==38)
            {
                switch (evaluator.evaluateInCell(cell).getCellType()) 
                {
                    case Cell.CELL_TYPE_BLANK:
                        seo1.setFee(new Double(0));
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    seo1.setFee(cell.getNumericCellValue());
                    break;
                case Cell.CELL_TYPE_STRING:
                    seo1.setFee(Double.parseDouble(cell.getStringCellValue()));
                    break;
               }   
            }
            else if(i==39)
            {
                switch (evaluator.evaluateInCell(cell).getCellType()) 
                {
                    case Cell.CELL_TYPE_BLANK:
                        seo1.setEamount(new Double(0));
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    seo1.setEamount(cell.getNumericCellValue());
                    break;
                case Cell.CELL_TYPE_STRING:
                    seo1.setEamount(Double.parseDouble(cell.getStringCellValue()));
                    break;
               }   
            }
            else if(i==40)
            {
                switch (evaluator.evaluateInCell(cell).getCellType()) 
                {
                    case Cell.CELL_TYPE_BLANK:
                        seo1.setPamount(new Double(0));
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    seo1.setPamount(cell.getNumericCellValue());
                    break;
                case Cell.CELL_TYPE_STRING:
                    seo1.setPamount(Double.parseDouble(cell.getStringCellValue()));
                    break;
               }   
            }
            else if(i==41)
            {
                switch (evaluator.evaluateInCell(cell).getCellType()) 
                {
                    case Cell.CELL_TYPE_BLANK:
                        seo1.setTotalFee(new Double(0));
                    break;
                    case Cell.CELL_TYPE_NUMERIC:
                       seo1.setTotalFee(cell.getNumericCellValue());
                       break;
                    case Cell.CELL_TYPE_FORMULA:
                       //
                       break;
            }
            }
            else{
            switch (evaluator.evaluateInCell(cell).getCellType()) 
                {
                case Cell.CELL_TYPE_NUMERIC:
                    flist.add(cell.getNumericCellValue());
                    break;
                case Cell.CELL_TYPE_STRING:
                    flist.add(Double.parseDouble(cell.getStringCellValue()));
                    break; 
                case Cell.CELL_TYPE_BLANK:
                    flist.add(new Double(0));
                    break; 
            }
//            System.out.println(flist);
           }
          
          
        }
}
        seo1.setDataArray(flist);
//       System.out.println("List: "+flist);     
       
            dblist.add(seo1);
     
}
        k++;
//        System.out.println("");
    }

ArrayList ar=retfieldsNameForExcel(al);
//System.out.println(ar);
insert_for_excel(ar,dblist);

    }
    }
    catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}
}

public ArrayList retfieldsNameForExcel(ArrayList al)
{
    ArrayList ar=new ArrayList();
    Connection con=null;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
       try{         
           String qr1="select heads,field_name from feeheads where heads=?";
           int sz=al.size();
//           System.out.println("Size Field: "+al.size());
           for(int i=0;i<sz;i++)
           {
            psmt=con.prepareStatement(qr1);
            psmt.setString(1, al.get(i).toString().trim());
            rs=psmt.executeQuery();
            if(rs.next())
            {
                ar.add(rs.getString("field_name"));
            }try{
            rs.close();
            }catch(Exception ee){}
           }
//        System.out.println("Fields: "+ar);
     }catch(Exception e){System.out.println("Exc: "+e.getMessage());}
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

public void insert_for_excel(ArrayList fields,ArrayList dblist)
{
//    System.out.println("Size:"+dblist.size());
    Connection con=null;
     SchoolEO se=null;
     
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
  
  try
  {
      String qr6="";
      StringBuffer sb=new StringBuffer();
      sb=sb.append("insert into stud_fee_detail_excel(session,institu_fee,extra,total_amount,self_finance_fee,stud_id,batch,session_sem,degree");
      for(int i=0;i<fields.size();i++)
      {
          sb=sb.append(",");
          sb=sb.append(fields.get(i).toString());
      }
      sb=sb.append(")");
      sb=sb.append(" values (?,?,?,?,?,?,?,?,?");
      for(int i=0;i<fields.size();i++)
      {
          sb=sb.append(",?");
      }
      sb=sb.append(")");
//System.out.println("Size:"+dblist.size());
for(int i=0;i<dblist.size();i++){
    se=(SchoolEO)dblist.get(i);
      psmt=con.prepareStatement(sb.toString());
      psmt.setString(1, se.getSession());
      psmt.setDouble(2, se.getFee());
      psmt.setDouble(3, se.getEamount());
      psmt.setDouble(4, se.getTotalFee());
      psmt.setDouble(5, se.getPamount());
      psmt.setString(6, se.getStud_id());
      psmt.setString(7, se.getBatch());
      psmt.setString(8, se.getSession_sem());
      psmt.setString(9, se.getDegree());
      
      int j=10;
      ArrayList ar=se.getDataArray();
//      System.out.println("size: "+ar.size());
      for(int k=0;k<ar.size();k++)
      {
          try{
          psmt.setDouble(j, Double.parseDouble(ar.get(k).toString()));
          }catch(Exception ee)
          {
              psmt.setDouble(j, new Double(0));
          }
          j=j+1;
       }
      psmt.executeUpdate();
  }
      
  }catch(Exception e){System.out.println("Kapil Ex: "+e.getMessage());}
  finally{
       try{
         if(rs!=null){rs.close();}           
         if(psmt!=null){psmt.close();}       
         if(con!=null){con.close();}  
       }   
       catch(SQLException see){}
      } 
}

public ArrayList genFeeScrollProgwiseFromExcelData(SchoolEO seo)
{
    SchoolEO seo1=new SchoolEO();
    ArrayList studlist=new ArrayList();
    ArrayList stud_datalist=new ArrayList();
    ArrayList al=new ArrayList();
     Connection con=null;
       PreparedStatement pss=null;
       ResultSet rss=null;
       
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
      String feetyp="";  
      
      PreparedStatement pst=null;
      ResultSet rst=null;
       
      
      try{
        int counter=0; 
        String qr="select count(stud_id) as cn from oldregis where batch='"+seo.getBatch()+"' and degree='"+seo.getDegree()+"' and stud_id <> 'NULL'";
        psmt1=con.prepareStatement(qr);
        rs=psmt1.executeQuery();
        if(rs.next())
            counter=rs.getInt("cn");
        rs.close();
         
      String qr3=""; 
      if(counter!=0){
      qr3="select studname,gender,fname,stud_type,category,icar,gate,stud_id,degree,semester,batch,new_beni,college from oldregis"
              + " where batch='"+seo.getBatch()+"' and degree='"+seo.getDegree()+"' and stud_id <> 'NULL'"
              + " and stud_id not in (select stud_id from transfered_student) ORDER BY SUBSTR(stud_id,1,1),CONVERT(SUBSTR(stud_id,INSTR(stud_id,'-')+1),UNSIGNED)";   
      psmt1=con.prepareStatement(qr3);
      rs1=psmt1.executeQuery(); 
      while(rs1.next()){
          seo1=new SchoolEO();
      seo1.setSname(rs1.getString("studname"));
      seo1.setGender(rs1.getString("gender"));
      seo1.setDegree(rs1.getString("degree"));
      seo1.setSemester(rs1.getString("semester")); 
      seo1.setFname(rs1.getString("fname"));
      seo1.setStud_type(rs1.getString("stud_type"));
      seo1.setCategory(rs1.getString("category"));
      seo1.setIcar(rs1.getString("icar"));
       seo1.setStud_id(rs1.getString("stud_id"));
      seo1.setGate(rs1.getString("gate"));
      seo1.setBatch(rs1.getString("batch"));
      seo1.setNewBeni(rs1.getString("new_beni"));
      seo1.setCollege(rs1.getString("college"));
      studlist.add(seo1);
      }
      }
else{
      //      qr3="select studname,gender,seekadd,fname,degree,branch,stud_type from studentregis where session='"+seo.getSession()+"' and srnum='"+seo.getRegistNo()+"'";
      qr3="select studname,gender,fname,stud_type,category,icar,gate,stud_id,degree,semester,batch,new_beni,college,course_id from studentregis"
              + " where batch='"+seo.getBatch()+"' and degree='"+seo.getDegree()+"' and stud_id <> 'NULL' "
              + "and stud_id not in (select stud_id from transfered_student) ORDER BY SUBSTR(stud_id,1,1),CONVERT(SUBSTR(stud_id,INSTR(stud_id,'-')+1),UNSIGNED)";     
//      System.out.println("query: "+qr3);
      psmt1=con.prepareStatement(qr3);
      rs1=psmt1.executeQuery();  
      while(rs1.next()){
          seo1=new SchoolEO();
      seo1.setSname(rs1.getString("studname"));
      seo1.setGender(rs1.getString("gender"));
//      seo.setClasses(rs1.getString("seekadd")); 
      seo1.setFname(rs1.getString("fname"));
      seo1.setDegree(rs1.getString("degree"));
      seo1.setSemester(rs1.getString("semester"));
      seo1.setStud_type(rs1.getString("stud_type"));
      seo1.setCategory(rs1.getString("category"));
      seo1.setIcar(rs1.getString("icar"));
       seo1.setStud_id(rs1.getString("stud_id"));
      seo1.setGate(rs1.getString("gate"));
      seo1.setBatch(rs1.getString("batch"));
      seo1.setNewBeni(rs1.getString("new_beni"));
      seo1.setCollege(rs1.getString("college"));
      seo1.setCourse_id(rs1.getString("course_id"));
      studlist.add(seo1);
      }
      } 
//      System.out.println(studlist.size());

      
       ArrayList ar=new ArrayList();
       ArrayList ar1=new ArrayList();
       String qr6="select distinct heads, heads_cat,field_name from feeheads order by heads_cat desc";

      psmt2=con.prepareStatement(qr6);
      rs2=psmt2.executeQuery(); 
      while(rs2.next()){
      ar.add(rs2.getString("heads"));
      ar1.add(rs2.getString("field_name"));
      }      
 for(int i=0;i<studlist.size();i++)
   {  
       HashMap hm=new HashMap();
        ArrayList staffheads=new ArrayList();
        
       seo1=(SchoolEO)studlist.get(i);
//       System.out.println(seo1);
//       qr6="select * from stud_fee_detail_excel where stud_id=? and batch=?";
       qr6="select * from stud_fee_detail_excel where stud_id=? and batch=? and session=? and session_sem=?";
       psmt5=con.prepareStatement(qr6);
      psmt5.setString(1, seo1.getStud_id());
      psmt5.setString(2, seo1.getBatch());
      psmt5.setString(3, seo.getSession());
      psmt5.setString(4, seo.getSemester());
      rs5=psmt5.executeQuery();
      if(rs5.next())
      {
          seo1.setPamount(rs5.getDouble("self_finance_fee"));
          seo1.setFee(rs5.getDouble("institu_fee"));
          seo1.setEamount(rs5.getDouble("extra"));
          seo1.setFeeTotal(rs5.getDouble("total_amount")-seo1.getPamount());
          int sz=ar1.size();
          for(int j=0;j<sz;j++)
          {
              hm.put(ar.get(j), rs5.getString(ar1.get(j).toString()));
          }
          
        seo1.setDataArray2(ar);
//      System.out.println("helloooo "+seo1.getDataArray2().size());
//      System.out.println(seo1.getDataArray2());
      seo1.setDataMap(hm);
//      System.out.println(seo1.getDataMap());
      
      seo1.setDataArray3(this.bankList());  
      stud_datalist.add(seo1);
      }   
      


      
      try{
           if(rs!=null){rs.close();}   
           if(rs1!=null){rs1.close();}    
         if(rs3!=null){rs3.close();}           
         if(rs2!=null){rs2.close();} 
         if(rs5!=null){rs5.close();}  
         if(psmt1!=null){psmt1.close();}          
         if(psmt2!=null){psmt2.close();} 
         if(psmt!=null){psmt.close();}  
         if(psmt5!=null){psmt5.close();}
       }   
      catch(SQLException se){}
   }
             
//      System.out.println("good: "+stud_datalist);
      }
      //}
      catch(SQLException se){System.out.println("Saini Ex: "+se.getMessage());}  
       finally{
       try{
           if(rs!=null){rs.close();}   
           if(rs1!=null){rs1.close();}    
         if(rs3!=null){rs3.close();}           
         if(rs2!=null){rs2.close();} 
         if(rs5!=null){rs5.close();}  
         if(psmt1!=null){psmt1.close();}          
         if(psmt2!=null){psmt2.close();} 
         if(psmt!=null){psmt.close();}  
         if(psmt5!=null){psmt5.close();}
       }   
       catch(SQLException se){}
      } 
      
     return stud_datalist;
}

public ArrayList retDistinctBatch(String degree)
{
    ArrayList al=new ArrayList();
    Connection con=null;
       
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
      try{
//          String qr="select distinct batch from stud_fee_detail_excel where degree='"+degree+"'";
          String qr="select distinct batch from stud_fee_detail_excel";
          psmt=con.prepareStatement(qr);
          rs=psmt.executeQuery();
          while(rs.next())
              al.add(rs.getString("batch"));
      }catch(SQLException se){System.out.println("Ex: "+se.getMessage());}  
       finally{
       try{
           if(rs!=null){rs.close();}   
         if(psmt!=null){psmt.close();}          
        }   
       catch(SQLException se){}
      } 
    return al;
}

public boolean checkExcel(String filename)
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
         String qr="select * from excel_files where filename=?";
         ps=con.prepareStatement(qr);
         ps.setString(1, filename);
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
   public void addScrollExcelDetails(SchoolEO seo,String filename)
   {
       Connection con=null;
       PreparedStatement ps=null;
       try
       {
         Dataconnectivity dc=new Dataconnectivity();
         con=dc.Dataconnect();
       }catch(Exception se){}
       
       try
       {
         String qr="insert into excel_files(degree,session,session_sem,filename) values(?,?,?,?)";
         ps=con.prepareStatement(qr);
         ps.setString(1, seo.getDegree());
         ps.setString(2, seo.getSession());
         ps.setString(3, seo.getSession_sem());
         ps.setString(4, filename);
         ps.executeUpdate();
       }catch(Exception se){
           //System.out.println("Ex: "+se.getMessage());
       }
       finally{
           try{
               if(ps!=null){ps.close();}
               if(con!=null){con.close();}
           }catch(Exception e){}
       }
   }

   public boolean checkStudentRegisOnBatch(SchoolEO seo)
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
         String qr="select * from studentregis where batch=? and degree=?";
         ps=con.prepareStatement(qr);
         ps.setString(1, seo.getBatch());
         ps.setString(2, seo.getDegree());
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

   public int deleteLongRow(long rwid,String table,String field)
   {
       Connection con=null;
       PreparedStatement ps=null;
       ResultSet rs=null;
       int i=0;
       try
       {
         Dataconnectivity dc=new Dataconnectivity();
         con=dc.Dataconnect();
       }catch(Exception se){}
       try
       {
         String qr="delete from "+table+" where "+field+"=?";
         //System.out.println(qr);
         ps=con.prepareStatement(qr);
         ps.setLong(1, rwid);
         i=ps.executeUpdate();
       }catch(Exception se){
           System.out.println("Ex: "+se.getMessage());
       }
       finally{
           try{
               if(ps!=null){ps.close();}
               if(con!=null){con.close();}
           }catch(Exception e){}
       }
       return i;
   }
   
   public void deleteLongRow(long rwid,String table,String field, Connection conUpdate)
   {
       PreparedStatement ps=null;
       try
       {
         String qr="delete from "+table+" where "+field+"=?";
//         System.out.println(qr);
         ps=conUpdate.prepareStatement(qr);
         ps.setLong(1, rwid);
         ps.executeUpdate();
       }catch(Exception se){
           System.out.println("Ex: "+se.getMessage());
       }
       finally{
           try{
               if(ps!=null){ps.close();}
           }catch(Exception e){}
       }
   }
   
   
public double retTotalSubmitted(String stud_id,String session,String session_sem)
{
    double tt=0;
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
         String qr="select fee_total from sub_feedata where stud_id=? and session=? and session_sem=?";
         ps=con.prepareStatement(qr);
         ps.setString(1, stud_id);
         ps.setString(2, session);
          ps.setString(3, session_sem);
         rs=ps.executeQuery();
         if(rs.next())
         {
             tt=rs.getDouble("fee_total");
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
    return tt;
}

public HashMap retFeeHeads()
{
    HashMap<String,String> hm=new HashMap<String,String>();
       Connection con=null;
       PreparedStatement ps=null;
       ResultSet rs=null;
       try
       {
         Dataconnectivity dc=new Dataconnectivity();
         con=dc.Dataconnect();
       }catch(Exception se){}
    try{
        String qry="select distinct heads,field_name,heads_cat from feeheads order by heads_cat desc";
      ps=con.prepareStatement(qry);
      rs=ps.executeQuery();   
      while(rs.next()){      
      hm.put(rs.getString("heads"), rs.getString("field_name"));
      } 
    }catch(Exception e){}
    finally{
           try{
               if(ps!=null){ps.close();}
               if(rs!=null){rs.close();}
               if(con!=null){con.close();}
           }catch(Exception e){}
       }
    return hm;
}

public SchoolEO fineReturn(SchoolEO seo)
{
    int counter=0;
    Connection con=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    try
       {
         Dataconnectivity dc=new Dataconnectivity();
         con=dc.Dataconnect();
       }catch(Exception se){}
    try{
        String qr="select * from latefine_onfeeProcess where stud_id='"+seo.getStud_id()+"' and session='"+seo.getSession()+"'"
               + " and session_sem='"+seo.getSession_sem()+"'";
      ps=con.prepareStatement(qr);
      rs=ps.executeQuery();
      if(rs.next())
      {
          seo.setFine(rs.getDouble("fine"));
          seo.setLastdate(rs.getString("last_date"));
          seo.setRowid(rs.getInt("rid"));
          seo.setDate(rs.getDate("fine_dep_date"));
          seo.setBankname(rs.getString("bank"));
          seo.setDeposite_date(rs.getDate("deposit_date"));
          counter=1;
       }
      seo.setCounter(counter);
    }catch(Exception e){}
    finally{
           try{
               if(ps!=null){ps.close();}
               if(rs!=null){rs.close();}
               if(con!=null){con.close();}
           }catch(Exception e){}
       }
    return seo;
}

public void updateFine_data(SchoolEO seo)
{
   Connection con=null;
     
     
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
 
  try
  {
      String sb="update latefine_onfeeprocess set fine=?,bank=?,fine_dep_date=? where rid=?";
      
        psmt=con.prepareStatement(sb.toString());
      psmt.setDouble(1, seo.getFine());
      psmt.setString(2, seo.getBankname());
      psmt.setDate(3, new java.sql.Date(seo.getDate().getTime()));
      psmt.setInt(4, seo.getRowid());
      
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

public String retColumnVal(String table,String column,SchoolEO seo){
    String val="";
    Connection con=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    try
       {
         Dataconnectivity dc=new Dataconnectivity();
         con=dc.Dataconnect();
       }catch(Exception se){}
    try{
        String qr="select "+column+" from "+table+" where stud_id=?";
        ps=con.prepareStatement(qr);
        ps.setString(1, seo.getStud_id());
//        ps.setString(2, seo.getSession());
//        ps.setString(3, seo.getSession_sem());
        rs=ps.executeQuery();
        if(rs.next())
        {
         val=rs.getString(column);
        }
    }catch(Exception e){}
    finally{
           try{
               if(ps!=null){ps.close();}
               if(rs!=null){rs.close();}
               if(con!=null){con.close();}
           }catch(Exception e){}
       }
    return val;
}

public int checkStudentFdBillOnMonth(SchoolEO seo)
    {
        int bn=0;
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
         String qr="select count(*) as cnt from monthly_food where session=? and stud_id=? and month=?";
         ps=con.prepareStatement(qr);
         ps.setString(1, seo.getSession());
         ps.setString(2, seo.getStud_id());
         ps.setString(3, seo.getMonth());
         rs=ps.executeQuery();
         if(rs.next())
         {
             bn=rs.getInt("cnt");
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

public SchoolEO retMonthlyFoodBillForEditing(SchoolEO seo)
{
    Connection con=null;
  ArrayList ar1=new ArrayList();
  SchoolEO seo1=new SchoolEO();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
       try{         
            String qr1="select * from monthly_food where session=? and stud_id=? and month=? and food_bill=?";
            psmt=con.prepareStatement(qr1);
            psmt.setString(1, seo.getSession());
            psmt.setString(2, seo.getStud_id());
            psmt.setString(3, seo.getMonth());
            psmt.setString(4, "Unprocess");
            rs=psmt.executeQuery();
            if(rs.next())
            {
                seo1.setSession(rs.getString("session"));
                seo1.setStud_id(rs.getString("stud_id"));
                seo1.setMonth(rs.getString("month"));
                seo1.setMonthlyFood(rs.getDouble("food_amount"));
                seo1.setDate(rs.getDate("bill_gen_date"));
                seo1.setRwid(rs.getLong("rwid"));
             }
        
     }catch(Exception e){System.out.println("Exc: "+e.getMessage());}
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

public void updateMonthlyFoodBillOfEditing(SchoolEO seo)
{
    Connection con=null;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
       
       
       try{ 
        String qr4="update monthly_food set food_amount=?,month=?,bill_gen_date=? where rwid=?";
        psmt3=con.prepareStatement(qr4);
        psmt3.setDouble(1, seo.getMonthlyFood());
        psmt3.setString(2, seo.getMonth());
        psmt3.setDate(3, new java.sql.Date(seo.getDate().getTime()));
        psmt3.setLong(4, seo.getRwid());
        psmt3.executeUpdate();
      
       }catch(Exception e){System.out.println("Exc: "+e.getMessage());}
       finally{
      try{
            if(psmt3!=null){psmt3.close();}          
            if(con!=null){con.close();}
       }   
      catch(SQLException se){}
     }
}


public void insertIn_stud_other_inst(SchoolEO seo)
{
    Connection con=null;
  ArrayList al=new ArrayList();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
       
       try{ 
        String qr4="insert into stud_other_inst(session,session_sem,stud_id,amount,sname,deposit_date,bank,receipt_no,degree,transfered)"
                + " values(?,?,?,?,?,?,?,?,?,?)";
        psmt3=con.prepareStatement(qr4);
        psmt3.setString(1, seo.getSession());
        psmt3.setString(2, seo.getSession_sem());
        psmt3.setString(3, seo.getStud_id());
        psmt3.setDouble(4, seo.getTotalFee());
        psmt3.setString(5, seo.getSname());
        psmt3.setDate(6, new java.sql.Date(seo.getDeposite_date().getTime()));
        psmt3.setString(7, seo.getBankname());
        psmt3.setString(8, seo.getRecnum());
        psmt3.setString(9, seo.getDegree());
        psmt3.setString(10, "No");
        psmt3.executeUpdate();
      
       }catch(Exception e){System.out.println("Exc: "+e.getMessage());}
       finally{
      try{
            if(psmt3!=null){psmt3.close();}          
            if(con!=null){con.close();}
       }   
      catch(SQLException se){}
     }
}


public ArrayList genFeeScrollRemianIdProgwiseFromExcelData(SchoolEO seo,String[] arId)
{
    SchoolEO seo1=new SchoolEO();
    ArrayList studlist=new ArrayList();
    ArrayList stud_datalist=new ArrayList();
    ArrayList al=new ArrayList();
     Connection con=null;
       PreparedStatement pss=null;
       ResultSet rss=null;
       
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
      String feetyp="";  
      
      PreparedStatement pst=null;
      ResultSet rst=null;
       
      
      try{
      
      String qr3=""; 
      
      StringBuffer sb=new StringBuffer("");
      sb=sb.append("select studname,gender,fname,stud_type,category,icar,gate,stud_id,degree,semester,batch,new_beni,college,course_id from studentregis where stud_id='"+arId[0]+"'");
      int k=2;
      for(int i=1;i<arId.length;i++){
          sb=sb.append(" or stud_id='"+arId[i]+"'");
      }
//      System.out.println("query: "+qr3);
      psmt1=con.prepareStatement(sb.toString());
//      psmt1.setString(1, arId[0]);
//      
//      for(int i=1;i<arId.length;i++){
//          psmt1.setString(k, arId[i]);
//          
//      }
      System.out.println("query: "+sb);
      rs1=psmt1.executeQuery();  
      while(rs1.next()){
          seo1=new SchoolEO();
      seo1.setSname(rs1.getString("studname"));
      seo1.setGender(rs1.getString("gender"));
//      seo.setClasses(rs1.getString("seekadd")); 
      seo1.setFname(rs1.getString("fname"));
      seo1.setDegree(rs1.getString("degree"));
      seo1.setSemester(rs1.getString("semester"));
      seo1.setStud_type(rs1.getString("stud_type"));
      seo1.setCategory(rs1.getString("category"));
      seo1.setIcar(rs1.getString("icar"));
       seo1.setStud_id(rs1.getString("stud_id"));
      seo1.setGate(rs1.getString("gate"));
      seo1.setBatch(rs1.getString("batch"));
      seo1.setNewBeni(rs1.getString("new_beni"));
      seo1.setCollege(rs1.getString("college"));
      seo1.setCourse_id(rs1.getString("course_id"));
      studlist.add(seo1);
      }
     
//      System.out.println(studlist.size());

      
       ArrayList ar=new ArrayList();
       ArrayList ar1=new ArrayList();
       String qr6="select distinct heads, heads_cat,field_name from feeheads order by heads_cat desc";

      psmt2=con.prepareStatement(qr6);
      rs2=psmt2.executeQuery(); 
      while(rs2.next()){
      ar.add(rs2.getString("heads"));
      ar1.add(rs2.getString("field_name"));
      }      
 for(int i=0;i<studlist.size();i++)
   {  
       HashMap hm=new HashMap();
        ArrayList staffheads=new ArrayList();
        
       seo1=(SchoolEO)studlist.get(i);
//       System.out.println(seo1);
//       qr6="select * from stud_fee_detail_excel where stud_id=? and batch=?";
       qr6="select * from stud_fee_detail_excel where stud_id=? and batch=? and session=? and session_sem=?";
       psmt5=con.prepareStatement(qr6);
      psmt5.setString(1, seo1.getStud_id());
      psmt5.setString(2, seo1.getBatch());
      psmt5.setString(3, seo.getSession());
      psmt5.setString(4, seo.getSemester());
      rs5=psmt5.executeQuery();
      if(rs5.next())
      {
          seo1.setPamount(rs5.getDouble("self_finance_fee"));
          seo1.setFee(rs5.getDouble("institu_fee"));
          seo1.setEamount(rs5.getDouble("extra"));
          seo1.setFeeTotal(rs5.getDouble("total_amount")-seo1.getPamount());
          int sz=ar1.size();
          for(int j=0;j<sz;j++)
          {
              hm.put(ar.get(j), rs5.getString(ar1.get(j).toString()));
          }
          
        seo1.setDataArray2(ar);
//      System.out.println("helloooo "+seo1.getDataArray2().size());
//      System.out.println(seo1.getDataArray2());
      seo1.setDataMap(hm);
//      System.out.println(seo1.getDataMap());
      
      seo1.setDataArray3(this.bankList());  
      stud_datalist.add(seo1);
      }   
      


      
      try{
           if(rs!=null){rs.close();}   
           if(rs1!=null){rs1.close();}    
         if(rs3!=null){rs3.close();}           
         if(rs2!=null){rs2.close();} 
         if(rs5!=null){rs5.close();}  
         if(psmt1!=null){psmt1.close();}          
         if(psmt2!=null){psmt2.close();} 
         if(psmt!=null){psmt.close();}  
         if(psmt5!=null){psmt5.close();}
       }   
      catch(SQLException se){}
   }
             
//      System.out.println("good: "+stud_datalist);
      }
      //}
      catch(SQLException se){System.out.println("Saini Ex: "+se.getMessage());}  
       finally{
       try{
           if(rs!=null){rs.close();}   
           if(rs1!=null){rs1.close();}    
         if(rs3!=null){rs3.close();}           
         if(rs2!=null){rs2.close();} 
         if(rs5!=null){rs5.close();}  
         if(psmt1!=null){psmt1.close();}          
         if(psmt2!=null){psmt2.close();} 
         if(psmt!=null){psmt.close();}  
         if(psmt5!=null){psmt5.close();}
       }   
       catch(SQLException se){}
      } 
      
     return stud_datalist;
}

public Double foodAdvance(String stud_id,String status,Connection con){
    Double amount=null;
    try{ 
        String qr1="select amount from stud_foodadvance where stud_id=? and status=? order by rowid desc";
        psmt=con.prepareStatement(qr1);
        psmt.setString(1, stud_id);
        psmt.setString(2, status);
        rs=psmt.executeQuery();
        if(rs.next()){
            amount=rs.getDouble("amount");
        }
        }catch(Exception e){System.out.println("Exc FeeMAth- foodAdvance method: "+e.getMessage());}
       finally{
      try{
          if(rs!=null){rs.close();}
          if(psmt!=null){psmt.close();}          
       }   
      catch(SQLException se){}
    }    
    return amount;
}

public SchoolEO retstudData(String srnum, String session){ 
    SchoolEO seo1=new SchoolEO();
       Connection con=null;
       PreparedStatement pss=null;
       ResultSet rss=null;
       
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
  
  try{
      String qr="select session,srnum,studname,dob,gender,fname,category,degree,stud_id from studentregis where srnum=? and session=?";
      psmt=con.prepareStatement(qr);
      psmt.setString(1, srnum);
      psmt.setString(2, session);
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


public static void main(String ar[])
{
    FeeMath fm=new FeeMath();
//    System.out.println(fm.bankList().size());
    SchoolEO seo=new SchoolEO();
    seo.setSession("2014-2015");
    seo.setSemester("II");
//    seo.setDegree("B.Sc. Ag.");
//    seo.setBatch("2013");
//    seo.setStud_type("Staff");
////    seo.setRegistNo("3314478");
////    seo.setStud_id("44405");
////    SchoolEO se=fm.retFeeHeadwiseFromStruc(seo);
////    fm.subFeeHeadwise(seo, se);
////    fm.genFeeScrollProgwise(seo);
//    
////    int a=100;
////    int b=20;
////    int c=30;
////    System.out.println(se.getDataMap());
//    System.out.println((Integer.parseInt(seo.getSession().substring(0,seo.getSession().lastIndexOf("-")))-1)+"-"+(Integer.parseInt(seo.getSession().substring(seo.getSession().lastIndexOf("-")+1,seo.getSession().length()))-1));
//    
//    Calendar cal = Calendar.getInstance();  
//            java.util.Date current=cal.getTime();
//            
//            cal.set(cal.DATE, 1);
//            cal.set(cal.MONTH, 6);
//            java.util.Date d1=cal.getTime();
//            
//            cal.set(cal.DATE, 30);
//            cal.set(cal.MONTH, 11);
//            java.util.Date d2=cal.getTime();
//            
//            cal.set(cal.DATE, 1);
//            cal.set(cal.MONTH, 0);
//            cal.set(cal.YEAR, cal.get(cal.YEAR)+1);
//            java.util.Date d3=cal.getTime();
//            
//            cal.set(cal.DATE, 30);
//            cal.set(cal.MONTH, 5);
//            //cal.set(cal.YEAR, cal.get(cal.YEAR)+1);
//            java.util.Date d4=cal.getTime();
//            System.out.println("d1: "+d1);
//            System.out.println("d2: "+d2);
//            System.out.println("d3: "+d3);
//            System.out.println("d4: "+d4);
    
    String[] arId={"44535","34485","34386","40195","29916","29957","30150","36835","35421","30966","34594","26058","37139","40050","41781","41373","41585","43633","46002","46011","46080","46097"};
 GenerateScrollPDF gsp=new GenerateScrollPDF();
        ArrayList list=fm.genFeeScrollRemianIdProgwiseFromExcelData(seo,arId);
        System.out.println("size: "+list.size());
      Document document = new Document();
      document.setPageSize(PageSize.A4.rotate());
      document.setMargins(0f, 0f, 0f, 0f);
//      Document document = new Document(PageSize.A4.rotate());
      String file="D:\\kapil\\NetBean 7.2 Projects Code\\FMS_Pantnagar\\build\\web\\ScrollInPDF\\remianingPdfs.pdf";
      System.out.println("FilePath: "+file);
      try{
      PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream(file));
//      writer.addViewerPreference(PdfName.PRINTSCALING, PdfName.NONE);
      document.open();
      gsp.addMetaData(document);
//      addTitlePage(document);
//      System.out.println("list: "+list);
      gsp.addContent(document,list,seo);
      }catch(Exception e){System.out.println("ex: "+e.getMessage());}
      document.close();
      
      ScrollPdf sp=new ScrollPdf();
      seo.setFilename("remaningPdfs.pdf");
////      sp.addScrollPdfDetails(seo);
      System.out.println("pdf file is generated.");
}

}
