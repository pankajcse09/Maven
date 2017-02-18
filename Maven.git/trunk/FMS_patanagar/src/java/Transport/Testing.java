/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Transport;

import EO.SchoolEO;
import Fee.FeeMath;
import com.myapp.struts.Dataconnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import pant.common.CommonFunctionality;

/**
 *
 * @author kapil
 */
public class Testing {
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
FeeMath feeMath=new FeeMath();
public ArrayList genFeeScrollProgwise(SchoolEO seo, SchoolEO seo1, String sessionForLastFee, String lastSessionSem)
{
    CommonFunctionality cFun=new CommonFunctionality();
    //SchoolEO seo1=new SchoolEO();
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
    String str1="select * from new_beni";
    
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
          int n=feeMath.checkSubmited_feeData1(seoCheck);   // check first submitted fee
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
                Double advance= feeMath.foodAdvance(seo1.getStud_id(), "unprocess", con);
                fdbill=feeMath.retTotalMonthlyFoodBill(seo1.getStud_id());
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
String      qr="select fee from finan_programme where batch=? and prog=?";
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
                Double advance= feeMath.foodAdvance(seo1.getStud_id(), "processed", con);

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
      
      
System.out.println("hm: "+hm);
System.out.println("hm1: "+hm1);
System.out.println("Total: "+feetot);
            
      seo1.setDataArray2(ar);
//      System.out.println("helloooo "+seo1.getDataArray2().size());
//      System.out.println(seo1.getDataArray2());
      seo1.setDataMap(hm);
//      System.out.println(seo1.getDataMap());
      seo1.setFeeTotal(feetot-seo1.getPamount());
      //seo1.setDataArray3(this.bankList());  
      
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

public static void main(String... s){
    SchoolEO seo=new SchoolEO();
    seo.setSession("2015-2016");
    seo.setSession_sem("I");
    seo.setBatch("2014");
    seo.setDegree("B.Sc. Ag.");
    
    SchoolEO seoStud=new SchoolEO();
    
    seoStud.setBatch("2012");
    seoStud.setDegree("B.Sc. Ag.");
    seoStud.setStud_id("43751");
    seoStud.setNewBeni("NO");
    seoStud.setStud_type("Hosteller");
    
    Testing testing=new Testing();
    testing.genFeeScrollProgwise(seo, seoStud, "2014-2015", "II");
}
}
