/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinepayment;

import EO.SchoolEO;
import Fee.FeeMath;
import com.myapp.struts.Dataconnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import pant.common.CommonFunctionality;

/**
 *
 * @author kapil
 */
public class PaymentDB {
    
PreparedStatement psmt=null;
PreparedStatement psmt1=null;
PreparedStatement psmt5=null;
ResultSet rs=null;
ResultSet rs1=null;    
ResultSet rs5=null; 
private static Logger logger=Logger.getLogger(PaymentDB.class.getName());
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
//       System.out.println(qr1);
      psmt=con.prepareStatement(qr1);
      rs=psmt.executeQuery();
      if(rs.next())
        count=rs.getInt("cnt"); 
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


public SchoolEO retStudScrollFrom_stud_fee_detailForOnline(SchoolEO seo)
{
    CommonFunctionality cFun=new CommonFunctionality();
        Connection con=null;
        ArrayList ar=new ArrayList();
        ArrayList fields=new ArrayList();
        HashMap hm=new HashMap();
//        HashMap hm1=new HashMap();
        HashMap hm2=new HashMap(); 
        HashMap headsfield=new HashMap();
   
  ArrayList annualHeads=new ArrayList(); 
  ArrayList annualfields=new ArrayList();
  HashMap annualHeadsMap=new HashMap();       
         try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
         try{
       String qr6="";
  // here seo.getSession_sem().equals("II") - we are looking for previous submitted fee for current means I.   
       if(seo.getSession_sem().equals("II")){
      if(seo.getStud_type().equals("Hosteller")){
          qr6="select distinct heads, heads_cat,field_name,fee_type from feeheads where fee_type<>'Once At Admission' order by heads_cat desc";
      }
      else
      {
          qr6="select distinct heads, heads_cat,field_name,fee_type from feeheads where stud_type='Day Scholar' and fee_type<>'Once At Admission' order by heads_cat desc";
      }
  }
      else{
          if(seo.getStud_type().equals("Hosteller")){
          qr6="select distinct heads, heads_cat,field_name,fee_type from feeheads where fee_type ='Semester Fee' order by heads_cat desc";
      }
      else
      {
          qr6="select distinct heads, heads_cat,field_name,fee_type from feeheads where stud_type='Day Scholar' and fee_type='Semester Fee' order by heads_cat desc";
      }
    }
//       System.out.println("qr6: "+qr6);
      psmt5=con.prepareStatement(qr6);
      rs5=psmt5.executeQuery(); 
      while(rs5.next()){
        ar.add(rs5.getString("heads"));
        fields.add(rs5.getString("field_name"));
        headsfield.put(rs5.getString("field_name"), rs5.getString("heads"));
//        hm1.put(rs5.getString("heads"), rs5.getString("heads_cat"));
        if(rs5.getString("fee_type").equals("Annual Fee"))
        {
            annualfields.add(rs5.getString("field_name"));
            annualHeads.add(rs5.getString("heads"));
            annualHeadsMap.put(rs5.getString("field_name"), rs5.getString("heads"));
        }
      }
      
      String qr1="select * from stud_fee_detail where stud_id='"+seo.getStud_id()+"' and session='"+seo.getSession()+"' and session_sem='"+seo.getSession_sem()+"'"; 
//      System.out.println("query:"+qr1);
      double feetot=0.0;
      int ch=0;
      psmt=con.prepareStatement(qr1); 
      rs=psmt.executeQuery();  
      if(rs.next()){
          seo.setBankname(rs.getString("subm_bank"));
          for(int j=0;j<fields.size();j++){
             /* if(fields.get(j).toString().equals("field18")){
                  double fdbill=retTotalMonthlyFoodBill(seo.getStud_id())-15000;
                hm.put(headsfield.get(fields.get(j)),Double.toString(fdbill));
                hm2.put(fields.get(j), Double.toString(fdbill));
                feetot=feetot+fdbill;
              }*/
        //  ############      field10==FOOD ADVANCE, field18==MONTHLY FOOD BILL    #########
              if(fields.get(j).toString().equals("field18")||fields.get(j).toString().equals("field10")){
//                  double fdbill=retTotalMonthlyFoodBill(seo.getStud_id())-15000;
//                hm.put(headsfield.get(fields.get(j)),Double.toString(fdbill));
//                hm2.put(fields.get(j), Double.toString(fdbill));
//                feetot=feetot+fdbill;
                  hm.put(ar.get(j), "0");
                  hm2.put(fields.get(j), "0");
              }
              else{
               //   hm.put(headsfield.get(fields.get(j)),rs.getString(fields.get(j).toString()));
          // above commented line is same as given below.   
                  hm.put(ar.get(j), rs.getString(fields.get(j).toString()));
                  hm2.put(fields.get(j),rs.getString(fields.get(j).toString()));
                feetot=feetot+rs.getDouble(fields.get(j).toString());
              }
//          System.out.println("check :"+hm);
            }
         }
      FeeMath fm=new FeeMath();
      
  // here seo.getSession_sem().equals("II") - we are looking for previous submitted fee for current means I.       
      if(seo.getSession_sem().equals("II")){
          
          String studFirstSession=cFun.getSessionFromBatch(seo.getBatch());
          if(studFirstSession==null){
              seo.setCounter(-10);
              return seo;
          }
          SchoolEO seoCheck=new SchoolEO();
          seoCheck.setStud_id(seo.getStud_id());
          seoCheck.setSession(studFirstSession);
          seoCheck.setSession_sem("I");
          int n=checkSubmited_feeData1(seoCheck);   // check first submitted fee
          if(n!=0){         // check first submitted fee  :    found
              HashMap feeStudMap=cFun.retFeeDataFromFee_Student_Detail(seoCheck.getSession(),seoCheck.getSession_sem(),seoCheck.getStud_id(),annualHeads,annualfields,con);
              for(int i=0;i<annualHeads.size();i++){
                        if(feeStudMap.containsKey(annualHeads.get(i)))
                          hm.put(annualHeads.get(i), feeStudMap.get(annualHeads.get(i)));
                          hm2.put(annualfields.get(i), feeStudMap.get(annualHeads.get(i)));
                        feetot=feetot+cFun.getDoubleFormString(feeStudMap.get(annualHeads.get(i)).toString());
                        }
          }
          else if(n==0){         // check first submitted fee  :  not  found
              // check fee in fee structure for the first session of student
              n=cFun.checkFeeDataInFeeStructure(studFirstSession,seo.getDegree(),con);
              if(n==0){     // check fee in fee structure for the first session of student:   not found
                  // check fee in fee structure for the last session of student
                  n=cFun.checkFeeDataInFeeStructure(seo.getSession(),seo.getDegree(),con);
                  if(n==0){     // check fee in fee structure for the last session of student:  not found
                      seo.setCounter(-9);   // can not show the annual fee for the student.
                      return seo;
                  }
                  else{     // check fee in fee structure for the last session of student:    found
                        HashMap feeStrMap=cFun.retFeeDataFromFeeStructure(seo.getSession(),seo.getDegree(),con);
                        for(int i=0;i<annualHeads.size();i++){
                        if(feeStrMap.containsKey(annualHeads.get(i)))
                            hm.put(annualHeads.get(i), feeStrMap.get(annualHeads.get(i)));
                            hm2.put(annualfields.get(i), feeStrMap.get(annualHeads.get(i)));
                            feetot=feetot+cFun.getDoubleFormString(feeStrMap.get(annualHeads.get(i)).toString());
                        }
                  }
              }
              else{             // check fee in fee structure for the first session of student:   found
                  HashMap feeStrMap=cFun.retFeeDataFromFeeStructure(studFirstSession,seo.getDegree(),con);
                  for(int i=0;i<annualHeads.size();i++){
                      if(feeStrMap.containsKey(annualHeads.get(i)))
                            hm.put(annualHeads.get(i), feeStrMap.get(annualHeads.get(i)));
                            hm2.put(annualfields.get(i), feeStrMap.get(annualHeads.get(i)));
                            feetot=feetot+cFun.getDoubleFormString(feeStrMap.get(annualHeads.get(i)).toString());                         
                  }
              }
          }
          
            double fdbill=0;
            hm.put(headsfield.get("field10"),Double.toString(0));    //food advance will be zero at I sem for old student.
            hm2.put("field10", Double.toString(0));
            if(cFun.getStringFromString(seo.getStud_type()).equals("Hosteller")){
            //    food bill adjustment
                  Double advance= fm.foodAdvance(seo.getStud_id(), "unprocess", con);
                  fdbill=retTotalMonthlyFoodBill(seo.getStud_id());
                  if(advance!=null){
                      fdbill=fdbill-advance;
                  }
                  else{
                      fdbill=fdbill-15000;
                  }
                  feetot=feetot+fdbill;
              }
              hm.put(headsfield.get("field18"),Double.toString(fdbill));
              hm2.put("field18", Double.toString(fdbill));
        }
      else{
          double fdAdv=0;
          if(cFun.getStringFromString(seo.getStud_type()).equals("Hosteller")){
            Double advance= fm.foodAdvance(seo.getStud_id(), "processed", con);
            
            if(advance!=null){
                      fdAdv=advance;
                  }
                  else{
                      fdAdv=15000;
                  }
            }
            hm.put(headsfield.get("field10"),Double.toString(fdAdv));    //food advance will not be zero at II sem for old student, zero for day scholar.
            hm2.put("field10", Double.toString(fdAdv));

            hm.put(headsfield.get("field18"),Double.toString(0));    //food bill will be zero at II sem for old student.
            hm2.put("field18", Double.toString(0));
          
      }
// here session_sem II is for I 
if(seo.getSession_sem().equals("II")){
      String qr="select fee from finan_programme where batch=? and prog=?";
      psmt1=con.prepareStatement(qr);
      psmt1.setString(1, seo.getBatch());
      psmt1.setString(2, seo.getDegree());
      rs1=psmt1.executeQuery();
      if(rs1.next()){
           seo.setPamount(rs1.getDouble("fee"));
           feetot=feetot+seo.getPamount()+seo.getEamount();
      }
}
      seo.setDeposite_date(new java.util.Date());
      this.calFineOnLateFeeSubmForOnline(seo);
      if(seo.getTot_days()>0)
                {
                    double fine=0;
                    if(seo.getTot_days()==1)
                        fine=seo.getMin_fine();
                    else{ 
                        fine=seo.getMin_fine()+(seo.getTot_days()-1)*seo.getPfine();
                        if(fine>seo.getMax_fine())
                            fine=seo.getMax_fine();
                      }
          seo.setFine(fine);
//          System.out.println("fine: "+fine);
      }
//System.out.println("check :"+hm);
      seo.setDataArray(ar);      
//    System.out.println("check :"+seo.getDataArray());  
      seo.setDataArray1(fields);
      seo.setDataMap(hm);
      seo.setDataMap2(hm2);
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

// testing method can be using 
public SchoolEO retSubmittedStudScrollFrom_stud_fee_detail(SchoolEO seo)
{
        Connection con=null;
   ArrayList ar=new ArrayList();
       ArrayList fields=new ArrayList();
       HashMap hm=new HashMap();
        HashMap hm1=new HashMap();
        HashMap hm2=new HashMap(); 
         HashMap headsfield=new HashMap();
         
         try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
         try{
       String qr6="";   
       if(seo.getSession_sem().equals("I")){
      if(seo.getStud_type().equals("Hosteller")){
          qr6="select distinct heads, heads_cat,field_name from feeheads where fee_type<>'Once At Admission' order by heads_cat desc";
      }
      else
      {
          qr6="select distinct heads, heads_cat,field_name from feeheads where stud_type='Day Scholar' and fee_type<>'Once At Admission' order by heads_cat desc";
      }
  }
      else{
          if(seo.getStud_type().equals("Hosteller")){
          qr6="select distinct heads, heads_cat,field_name from feeheads where fee_type ='Semester Fee' order by heads_cat desc";
      }
      else
      {
          qr6="select distinct heads, heads_cat,field_name from feeheads where stud_type='Day Scholar' and fee_type='Semester Fee' order by heads_cat desc";
      }
    }
//       System.out.println("qr6 2: "+qr6);
      psmt5=con.prepareStatement(qr6);
      rs5=psmt5.executeQuery(); 
      while(rs5.next()){
      ar.add(rs5.getString("heads"));
      fields.add(rs5.getString("field_name"));
      headsfield.put(rs5.getString("field_name"), rs5.getString("heads"));
      hm1.put(rs5.getString("heads"), rs5.getString("heads_cat"));
      }
      
      String qr1="select * from stud_fee_detail where stud_id='"+seo.getStud_id()+"' and session='"+seo.getSession()+"' and session_sem='"+seo.getSession_sem()+"'"; 
//      System.out.println("query:"+qr1);
      double feetot=0.0;
      int ch=0;
      psmt=con.prepareStatement(qr1); 
      rs=psmt.executeQuery();  
      if(rs.next()){
          seo.setPamount(rs1.getDouble("fee"));
          feetot=feetot+seo.getPamount()+seo.getEamount();
          seo.setBankname(rs.getString("subm_bank"));
          seo.setDeposite_date(rs.getDate("submission_date"));
          for(int j=0;j<fields.size();j++){
              if(fields.get(j).toString().equals("field18")){
                  double fdbill=retTotalMonthlyFoodBill(seo.getStud_id())-15000;
                hm.put(headsfield.get(fields.get(j)),Double.toString(fdbill));
                hm2.put(fields.get(j), Double.toString(fdbill));
                feetot=feetot+fdbill;
              }
              else{
                  hm.put(headsfield.get(fields.get(j)),rs.getString(fields.get(j).toString()));
                  hm2.put(fields.get(j),rs.getString(fields.get(j).toString()));
                feetot=feetot+rs.getDouble(fields.get(j).toString());
              }
//          System.out.println("check :"+hm);
            }
         }
      
      FeeMath fm=new FeeMath();
            double fine=fm.retStudentLateFine(seo);
          seo.setFine(fine);
//          System.out.println("fine: "+fine);
      
//System.out.println("check :"+hm);
      seo.setDataArray(ar);      
      seo.setDataArray1(fields);
      seo.setDataMap(hm);
      seo.setDataMap2(hm2);
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

public Double retTotalMonthlyFoodBill(String stud_id)
{
    Connection con=null;
    ResultSet rs=null;
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

public SchoolEO calFineOnLateFeeSubmForOnline(SchoolEO seo)
{
    Connection con=null;
  ArrayList al=new ArrayList();
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
       int count=0;
       try{

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

            java.util.Date current_date=new java.util.Date();
            SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date last_date=null;
            try{
                last_date=(java.util.Date)sdf.parse(seo.getLastdate());
     
                java.util.Date dep_date=current_date;
                int days=(int)((dep_date.getTime()-last_date.getTime())/(1000 * 60 * 60 * 24));
                if(days<0){
                    seo.setTot_days(0); 
                }
                else
                {
                    seo.setTot_days(days);
                }
            }catch(Exception eee){ System.out.println("parse: "+eee.getMessage());}
        
//     System.out.println("Total Days: "+seo.getTot_days()); 
            
           
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


public int studentFeeSubmission(SchoolEO seo, ServletContext servletContext)
{
    int n=0;
    logger.log(Level.INFO, "Saving fee details after online fee response fro student "+seo.getStud_id());
   int cn=checkSubmited_feeData1(seo);
if(cn==0){
   Connection con=null;
     ArrayList ar=seo.getDataArray();
     HashMap hm=seo.getDataMap();  
     
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}  
  try
  {
      SimpleDateFormat sde=new SimpleDateFormat("dd-MM-yyyy");
      SimpleDateFormat sdf1=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
      java.util.Date curDate=new java.util.Date();
        String cDate=sde.format(curDate);
        String nDate=sdf1.format(curDate);
      String filename="NoduesList-"+seo.getSession()+"-"+seo.getSession_sem()+"_"+cDate+".xls";
      String file=servletContext.getRealPath("/noduesed_excel")+"/"+filename;
      
      logger.log(Level.INFO, "making auto commit connection false.");
      con.setAutoCommit(false);
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
      psmt=con.prepareStatement(sb.toString());
      psmt.setString(1, seo.getSession());
      psmt.setString(2, seo.getRegistNo());
      psmt.setString(3, Integer.toString(ssn));
      psmt.setDate(4, new java.sql.Date(seo.getDeposite_date().getTime()));
      psmt.setString(5, seo.getDegree());
      psmt.setDouble(6, seo.getPamount());
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
      logger.log(Level.INFO, "inserted into stud_fee_detail."+n);
      
      if(n>0){
            n=submitStudentFeeData(seo,con);
            logger.log(Level.INFO, "insert check into stud_feedata."+n);
            if(n>0){
                CommonFunctionality cFun=new CommonFunctionality();
                FeeMath fm=new FeeMath();
                fm.updateNoduesIn_feeData(seo,con);
                fm.insertStudentNoduesSemwise(seo,con);
                fm.insertSemStudRegis(seo,con);
                fm.writeNodusedStudentToExcelFile(file,seo,nDate,filename,con);
                if(seo.getFine()>0){
                    n=latefineprocess(seo,new java.util.Date(),con);
                    logger.log(Level.INFO, "insert late fine."+n);
                }
                if(n>0&&cFun.getStringFromString(seo.getStud_type()).equals("Hosteller")){
                    updateFoodAdvance(seo.getStud_id(),con);
                    logger.log(Level.INFO, "updating food advance."+n);
                    if(hm.containsKey("field10")&&hm.get("field")!=null){
                        double adv=Double.parseDouble(hm.get("field10").toString());
                        if(adv>0){
                            n=storeFoodAdvance(seo,adv,con);
                            logger.log(Level.INFO, "inserting food advance."+n);
                         }
                     }
                }
            }
        }
      if(n>0){
        con.commit();
        logger.log(Level.INFO, "Connection committed.");
        logger.log(Level.INFO, "Saved fee details after online fee response for student "+seo.getStud_id());
      }
      else
      {
          try{
            con.rollback();
            logger.log(Level.SEVERE, "Connection Rollback.");
        }catch(Exception ee){}
      }
      return n;

  }catch(Exception e){
      System.out.println("Ex: "+e.getMessage());
      try{
        con.rollback();
        logger.log(Level.SEVERE, "Connection Rollback.",e);
      }catch(Exception ee){}
      n=0;
  }
  finally{
       try{
         if(rs!=null){rs.close();}           
         if(psmt!=null){psmt.close();}       
         if(con!=null){con.close();}  
       }   
       catch(SQLException see){}
      }
}
else{
    n=200;
}
  return n;
}


public int submitStudentFeeData(SchoolEO seo,Connection con)throws Exception
{
    CommonFunctionality cFun=new CommonFunctionality();
  ArrayList al=new ArrayList();
       String type="";      
           int ssn=Integer.parseInt(seo.getSemester())+1;
       try{
          String qr2="insert into sub_feedata(session,regist_no,sname,classes,type,gender,fee_total,enroll_no,fee_receipt,semester,batch,"
                  + "session_sem,deposit_date,stud_id,transaction_id,subm_bank,fine,data_entry_time) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";     
      psmt=con.prepareStatement(qr2);
      psmt.setString(1,seo.getSession());
      psmt.setString(2,seo.getRegistNo());
      psmt.setString(3,seo.getSname());
      psmt.setString(4,seo.getDegree());
      psmt.setString(5,seo.getType());
      psmt.setString(6,seo.getGender());
      psmt.setDouble(7,seo.getFeeTotal());
      psmt.setString(8,seo.getEnrolNo());
      psmt.setLong(9,seo.getFeeReceipt());
      psmt.setString(10,Integer.toString(ssn));
      psmt.setString(11,seo.getBatch());
      psmt.setString(12,seo.getSession_sem());
      psmt.setDate(13, new java.sql.Date(seo.getDeposite_date().getTime()));
      psmt.setString(14,seo.getStud_id());
      psmt.setString(15,seo.getTransaction_id());
      psmt.setString(16,seo.getBankname());
      psmt.setDouble(17,seo.getFine());
      psmt.setTimestamp(18, new java.sql.Timestamp(new java.util.Date().getTime()));
      int n=psmt.executeUpdate();   
      if(n>0){
      String qr3="update studentregis set semester=? where stud_id=? and batch=?";
      psmt1=con.prepareStatement(qr3);
      int sem=Integer.parseInt(seo.getSemester())+1;
//      System.out.println("kapil: "+sem);
      psmt1.setString(1, Integer.toString(sem));
      psmt1.setString(2, seo.getStud_id());
      psmt1.setString(3, seo.getBatch());
      psmt1.executeUpdate();
      
//      String qr4="update finerecord set status=? where stud_id=? and session=? and status=?";
//      psmt5=con.prepareStatement(qr4);
//      psmt5.setString(1, "Paid");
//      psmt5.setString(2, seo.getStud_id());
//      psmt5.setString(3, seo.getSession());
//      psmt5.setString(4, "Unpaid");
//      psmt5.executeUpdate();
      
//      String qr1="update monthly_food set food_bill=? where stud_id=? and session=? and food_bill=?";
      if(cFun.getStringFromString(seo.getStud_type()).equals("Hosteller")){
        String qr1="update monthly_food set food_bill=? where stud_id=? and food_bill=?";
        psmt5=con.prepareStatement(qr1);
        psmt5.setString(1, "Processed");
        psmt5.setString(2, seo.getStud_id());
  //      psmt5.setString(3, seo.getSession());
        psmt5.setString(3, "Unprocess");
        n=psmt5.executeUpdate();
        logger.log(Level.INFO, "updating monthly food bill status."+n);
      }
      }
       
      return n;
          
       }   
      catch(SQLException se){
          logger.log(Level.SEVERE,"", se);
        return 0;
      }
       finally{
           if(rs!=null){rs.close();}
          if(rs1!=null){rs1.close();}
          if(psmt1!=null){psmt1.close();} 
          if(psmt!=null){psmt.close();}          
         if(psmt5!=null){psmt5.close();} 
       }
      
 }

public int latefineprocess(SchoolEO seo,java.util.Date dt,Connection con)throws Exception
{
  ArrayList al=new ArrayList();
       
try{
        String qr4="insert into latefine_onfeeprocess(session,session_sem,stud_id,fine,last_date,deposit_date,bank,receipt,fine_dep_date)"
                + " values(?,?,?,?,?,?,?,?,?)";
        psmt=con.prepareStatement(qr4);
        psmt.setString(1, seo.getSession());
        psmt.setString(2, seo.getSession_sem());
        psmt.setString(3, seo.getStud_id());
        psmt.setDouble(4, seo.getFine());
        psmt.setString(5, seo.getLastdate());
        psmt.setDate(6, new java.sql.Date(seo.getDeposite_date().getTime()));
        psmt.setString(7, seo.getBankname());
        psmt.setInt(8, (int)seo.getFeeReceipt());
        psmt.setDate(9, new java.sql.Date(dt.getTime()));
        int n=psmt.executeUpdate();
      


      return n;
                   
       }   
      catch(SQLException se){
          return 0;
      }
finally{
    if(psmt!=null){psmt.close();}   
}
     
}

public void updateFoodAdvance(String stud_id,Connection con)throws Exception
{
    try{
    String qr1="update stud_foodadvance set status=? where stud_id=? and status=?";    
      psmt5=con.prepareStatement(qr1);
      psmt5.setString(1, "processed");
      psmt5.setString(2, stud_id);
//      psmt5.setString(3, seo.getSession());
      psmt5.setString(3, "unprocess");
      psmt5.executeUpdate();  
    }
    catch(Exception e){}
    finally{
        if(psmt5!=null){psmt5.close();}  
    }
}

public int storeFoodAdvance(SchoolEO seo, double adv, Connection con)throws Exception
{
    try{
    String qr="insert into stud_foodadvance(session,session_sem,stud_id,amount,date,status) values(?,?,?,?,?,?)";
      psmt=con.prepareStatement(qr);
        psmt.setString(1, seo.getSession());
        psmt.setString(2, seo.getSession_sem());
        psmt.setString(3, seo.getStud_id());
        psmt.setDouble(4, adv);
        psmt.setTimestamp(5, new java.sql.Timestamp(seo.getDeposite_date().getTime()));
        psmt.setString(6, "unprocess");
      int n=psmt.executeUpdate();
    return n;
    }catch(Exception e){
        return 0;
    }
    finally{
        if(psmt!=null){psmt.close();}  
    }
}

public int storeStudOnlinepayDetails(PaymentDetailBean paymentDetailBean)throws Exception
{
    try{
        Dataconnectivity dc=new Dataconnectivity();
        Connection con=(Connection)dc.Dataconnect();
    String qr="insert into stud_onlinepay_details(session,session_sem,stud_id,amount,date,gateway_status,tridby_gateway,transaction_id,payee_name,email"
            + ",mobile,app_status) values(?,?,?,?,?,?,?,?,?,?,?,?)";
      psmt=con.prepareStatement(qr);
        psmt.setString(1, paymentDetailBean.getSession());
        psmt.setString(2, paymentDetailBean.getSession_sem());
        psmt.setString(3, paymentDetailBean.getStud_id());
        psmt.setDouble(4, paymentDetailBean.getAmount());
        psmt.setTimestamp(5, new java.sql.Timestamp(paymentDetailBean.getDate().getTime()));
        psmt.setString(6, paymentDetailBean.getGatewayStatus());
        psmt.setString(7, paymentDetailBean.getTrIdByGateway());
        psmt.setString(8, paymentDetailBean.getTransactionId());
        psmt.setString(9, paymentDetailBean.getPayeeName());
        psmt.setString(10, paymentDetailBean.getEmail());
        psmt.setString(11, paymentDetailBean.getMobile());
        psmt.setString(12, paymentDetailBean.getAppStatus());
      int n=psmt.executeUpdate();
    return n;
    }catch(Exception e){
        e.printStackTrace();
        return 0;
    }
    finally{
        if(psmt!=null){psmt.close();}  
    }
}

}
