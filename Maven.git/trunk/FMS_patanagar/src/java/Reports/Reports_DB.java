/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reports;

import EO.ReportsEO;
import EO.SchoolEO;
import com.myapp.struts.Dataconnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author kapil
 */
public class Reports_DB {
        Connection conn=null;
    PreparedStatement pstm=null;
    PreparedStatement pstm1=null;
    ResultSet rs=null;
    ResultSet rs1=null;
    private int noOfRecords;
    public ArrayList amountOnDate(java.sql.Date dt1, java.sql.Date dt2)
    {
        ArrayList al=new ArrayList();
        HashMap hm=new HashMap();
        SchoolEO seo=null;
        //CustomerBean cb=null;
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        
        try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=(Connection)dc.Dataconnect();
        }catch(Exception e){}
        try{
//            String qr="select * from stud_fee_draft where deposite_date=?";
            String qr="select * from stud_fee_draft where deposite_date BETWEEN ? and ? and type=? order by receipt_no";
//            System.out.println("Saini: "+qr);
            pstm=conn.prepareStatement(qr);
            pstm.setDate(1, dt1);
            pstm.setDate(2, dt2);
            pstm.setString(3, "addmission fee");
            rs=pstm.executeQuery();
            while(rs.next())
            {
              seo=new SchoolEO();
              seo.setSname(rs.getString("sname"));
              seo.setSrnum(rs.getString("srnum"));
              seo.setDdno(rs.getString("draft_no"));
              seo.setBankname(rs.getString("bank_name"));
              seo.setDdate(rs.getString("date"));
              seo.setDdamount(rs.getDouble("amount"));
              seo.setStud_id(rs.getString("stud_id"));
              seo.setDeposite_date(rs.getDate("deposite_date"));
              seo.setDegree(rs.getString("degree"));
              al.add(seo);
            }
         }catch(Exception e){}
        finally{
            try{
                if(rs!=null){rs.close();}
                if(pstm!=null){pstm.close();}
                if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
        
        return al;
    }
    
public ArrayList advanceOnDate(java.sql.Date dt1,java.sql.Date dt2)
    {
        ArrayList al=new ArrayList();
        HashMap hm=new HashMap();
        SchoolEO seo=null;
        //CustomerBean cb=null;
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        
        try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=(Connection)dc.Dataconnect();
        }catch(Exception e){}
        try{
            String qr="select * from stud_draft where deposite_date BETWEEN ? and ? and status=? order by receipt_no";
            pstm=conn.prepareStatement(qr);
            pstm.setDate(1, dt1);
            pstm.setDate(2, dt2);
            pstm.setString(3, "paid");
            rs=pstm.executeQuery();
            while(rs.next())
            {
              seo=new SchoolEO();
              seo.setSname(rs.getString("sname"));
              seo.setSrnum(rs.getString("srnum"));
              seo.setDdno(rs.getString("draft_no"));
              seo.setBankname(rs.getString("bank_name"));
              seo.setDdate(rs.getString("date"));
              seo.setDdamount(rs.getDouble("amount"));
              seo.setStud_id(rs.getString("stud_id"));
              seo.setDeposite_date(rs.getDate("deposite_date"));
              al.add(seo);
            }
            
           
            
        }catch(Exception e){}
        finally{
            try{
                if(rs!=null){rs.close();}
                if(pstm!=null){pstm.close();}
                if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
        
        return al;
    }    
    
    
public ArrayList retRefundDetail(String session,int offset,int noOfRecords)
    {
        ArrayList al=new ArrayList();
        ReportsEO reo=null;
        //CustomerBean cb=null;
       
        
        try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=(Connection)dc.Dataconnect();
        }catch(Exception e){}
        try{
//            String qr="select * from stud_draft where status=?";
            String qr="select SQL_CALC_FOUND_ROWS * from stud_draft where status=? and session=? limit " +offset +"," + noOfRecords;
            pstm=conn.prepareStatement(qr);
            pstm.setString(1, "refunded");
            pstm.setString(2, session);
            rs=pstm.executeQuery();
            while(rs.next())
            {
              reo=new ReportsEO();
              reo.setSname(rs.getString("sname"));
              reo.setSrnum(rs.getString("srnum"));
              reo.setNumber(rs.getString("draft_no"));
              reo.setBank(rs.getString("bank_name"));
              reo.setDate(rs.getString("date"));
              reo.setAmount(rs.getDouble("amount"));
              al.add(reo);
            }
            
            rs.close();
 
    rs = pstm.executeQuery("SELECT FOUND_ROWS()");
    if(rs.next())
        this.noOfRecords = rs.getInt(1);   
            
         }catch(Exception e){}
        finally{
            try{
                if(rs!=null){rs.close();}
                if(pstm!=null){pstm.close();}
                if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
        
        return al;
    }

public ArrayList retAllReceivedAmount(ReportsEO reo1,String date_field,int offset,int noOfRecords)
    {
        ArrayList al=new ArrayList();
        ReportsEO reo=null;
        //CustomerBean cb=null;
       
        
        try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=(Connection)dc.Dataconnect();
        }catch(Exception e){}
        try{
            String qr="";
//            String qr="select * from stud_draft where status=?";
//            if(!ssnm.equals("Both")){
//                qr="select SQL_CALC_FOUND_ROWS sf.batch,sf.stud_id,sf.sname,sf.classes,sf.fee_total,lf.fine,sf.deposit_date from sub_feedata sf"
//                    + " left join latefine_onfeeprocess lf on (sf.stud_id=lf.stud_id and sf.session=lf.session and sf.session_sem=lf.session_sem)"
//                    + " where sf.session='"+session+"' and sf.session_sem='"+ssnm+"' limit " +offset +"," + noOfRecords;
//            }
//            else{
//                qr="select SQL_CALC_FOUND_ROWS sf.batch,sf.stud_id,sf.sname,sf.classes,sf.fee_total,lf.fine,sf.deposit_date from sub_feedata sf"
//                    + " left join latefine_onfeeprocess lf on (sf.stud_id=lf.stud_id and sf.session=lf.session)"
//                    + " where sf.session='"+session+"' limit " +offset +"," + noOfRecords;
//            }
//            System.out.println("Ex: ");
            
            
//            if(!reo1.getSession_sem().equals("Both")&&!reo1.getBank().equals("ALL")) {
//                qr="select SQL_CALC_FOUND_ROWS * from (select sf.session,sf.session_sem,sf.batch,sf.stud_id,sf.sname,sf.classes as degree,"
//                        + "sum(case when lf.fine is not null then (sf.fee_total+sf.adjstDraftTtAndFeeTt+lf.fine) else (sf.fee_total+sf.adjstDraftTtAndFeeTt) end) as fee_total,sf.deposit_date as dep_date,"
//                        + "subm_bank as bank from sub_feedata sf left join latefine_onfeeprocess lf "
//                        + "on (sf.stud_id=lf.stud_id and sf.session_sem=lf.session_sem and sf.session=lf.session and sf.subm_bank=lf.bank) "
//                        + "group by sf.stud_id "
//                        + "union "
////                        + "select session,session_sem,batch,stud_id,sname,degree as degree,amount as fee_total,deposite_date as dep_date,bank_name as bank"
//                        + "select session,session_sem,batch,stud_id,sname,degree as degree,amount as fee_total,"+date_field+" as dep_date,bank_name as bank"
//                        + " from stud_fee_draft where status='paid') as u where dep_date between ? and ? and session_sem='"+reo1.getSession_sem()+"' "
//                        + "and session=? and bank='"+reo1.getBank()+"' order by dep_date desc limit " +offset +"," + noOfRecords;
//            }
//            else if(reo1.getSession_sem().equals("Both")&&!reo1.getBank().equals("ALL")){
//                qr="select SQL_CALC_FOUND_ROWS * from (select sf.session,sf.session_sem,sf.batch,sf.stud_id,sf.sname,sf.classes as degree,"
//                        + "sum(case when lf.fine is not null then (sf.fee_total+sf.adjstDraftTtAndFeeTt+lf.fine) else (sf.fee_total+sf.adjstDraftTtAndFeeTt) end) as fee_total,sf.deposit_date as dep_date,"
//                        + "subm_bank as bank from sub_feedata sf left join latefine_onfeeprocess lf "
//                        + "on (sf.stud_id=lf.stud_id and sf.session_sem=lf.session_sem and sf.session=lf.session and sf.subm_bank=lf.bank) "
//                        + "group by sf.stud_id "
//                        + "union "
////                        + "select session,session_sem,batch,stud_id,sname,degree as degree,amount as fee_total,deposite_date as dep_date,bank_name as bank"
//                        + "select session,session_sem,batch,stud_id,sname,degree as degree,amount as fee_total,"+date_field+" as dep_date,bank_name as bank"
//                        + " from stud_fee_draft where status='paid') as u where dep_date between ? and ? and session=? "
//                        + "and bank='"+reo1.getBank()+"' order by dep_date desc limit " +offset +"," + noOfRecords;
//            }
//            else if(!reo1.getSession_sem().equals("Both")&&reo1.getBank().equals("ALL"))
//            {
//                qr="select SQL_CALC_FOUND_ROWS * from (select sf.session,sf.session_sem,sf.batch,sf.stud_id,sf.sname,sf.classes as degree,"
//                        + "sum(case when lf.fine is not null then (sf.fee_total+sf.adjstDraftTtAndFeeTt+lf.fine) else (sf.fee_total+sf.adjstDraftTtAndFeeTt) end) as fee_total,sf.deposit_date as dep_date,"
//                        + "subm_bank as bank from sub_feedata sf left join latefine_onfeeprocess lf "
//                        + "on (sf.stud_id=lf.stud_id and sf.session_sem=lf.session_sem and sf.session=lf.session) group by sf.stud_id "
//                        + "union "
////                        + "select session,session_sem,batch,stud_id,sname,degree as degree,amount as fee_total,deposite_date as dep_date,bank_name as bank"
//                        + "select session,session_sem,batch,stud_id,sname,degree as degree,amount as fee_total,"+date_field+" as dep_date,bank_name as bank"
//                        + " from stud_fee_draft where status='paid') as u where dep_date between ? and ? and session_sem='"+reo1.getSession_sem()+"' "
//                        + "and session=? and bank<>'' order by dep_date desc limit " +offset +"," + noOfRecords;
//            }
//            else{
//                qr="select SQL_CALC_FOUND_ROWS * from (select sf.session,sf.session_sem,sf.batch,sf.stud_id,sf.sname,sf.classes as degree,"
//                        + "sum(case when lf.fine is not null then (sf.fee_total+sf.adjstDraftTtAndFeeTt+lf.fine) else (sf.fee_total+sf.adjstDraftTtAndFeeTt) end) as fee_total,sf.deposit_date as dep_date,"
//                        + "subm_bank as bank from sub_feedata sf left join latefine_onfeeprocess lf "
//                        + "on (sf.stud_id=lf.stud_id and sf.session_sem=lf.session_sem and sf.session=lf.session) group by sf.stud_id "
//                        + "union "
////                        + "select session,session_sem,batch,stud_id,sname,degree as degree,amount as fee_total,deposite_date as dep_date,bank_name as bank"
//                        + "select session,session_sem,batch,stud_id,sname,degree as degree,amount as fee_total,"+date_field+" as dep_date,bank_name as bank"
//                        + " from stud_fee_draft where status='paid') as u where dep_date between ? and ? and session=? "
//                        + "and bank<>'' order by dep_date desc limit " +offset +"," + noOfRecords;
//            }
            
            
       if(!reo1.getSession_sem().equals("Both")&&!reo1.getBank().equals("ALL")) {
          qr="select SQL_CALC_FOUND_ROWS * from (select session,session_sem,batch,sname,classes as degree,stud_id,sum(fee_total+adjstDraftTtAndFeeTt)"
             + " as fee_total,deposit_date as dep_date,subm_bank as bank,subm_bank as sub_bnk from sub_feedata group by stud_id,deposit_date,subm_bank "
             + "union select lf.session,lf.session_sem,sf.batch,sf.studname as sname,sf.degree as degree,lf.stud_id,sum(lf.fine) as fee_total,fine_dep_date as "
             + "dep_date,bank,bank as sub_bnk from latefine_onfeeprocess lf left join studentregis sf on lf.stud_id=sf.stud_id where lf.fine<>0 and "
             + "lf.session='"+reo1.getSession()+"' and lf.session_sem='"+reo1.getSession_sem()+"' group by lf.stud_id,fine_dep_date,bank "
             + "union select session,session_sem,batch,sname,degree as degree,stud_id,amount as fee_total,"+date_field+" as dep_date,processed_in "
             + "as bank,bank_name as sub_bnk from stud_fee_draft where status='paid' "
             + "union select session,session_sem,batch,sname,degree as degree,stud_id,amount as fee_total,deposite_date as dep_date,bank_name "
             + "as bank,bank_name as sub_bnk from noduesed_student_draft "
             + "union select session,session_sem,batch,sname,degree,stud_id,amount as fee_total,deposit_date as dep_date,bank,bank as sub_bnk from "
             + "stud_other_inst where transfered='No') as u where dep_date between ? and ?and session_sem='"+reo1.getSession_sem()+"'"
             + " and session=? and bank='"+reo1.getBank()+"' order by dep_date desc limit " +offset +"," + noOfRecords;
//                System.out.println("qr1: "+qr);
          }
       else if(reo1.getSession_sem().equals("Both")&&!reo1.getBank().equals("ALL")){
           qr="select SQL_CALC_FOUND_ROWS * from (select session,session_sem,batch,sname,classes as degree,stud_id,sum(fee_total+adjstDraftTtAndFeeTt)"
               + " as fee_total,deposit_date as dep_date,subm_bank as bank,subm_bank as sub_bnk from sub_feedata group by stud_id,deposit_date,subm_bank "
               + "union select lf.session,lf.session_sem,sf.batch,sf.studname as sname,sf.degree as degree,lf.stud_id,sum(lf.fine) as fee_total,fine_dep_date as "
               + "dep_date,bank,bank as sub_bnk from latefine_onfeeprocess lf left join studentregis sf on lf.stud_id=sf.stud_id where lf.fine<>0 and "
               + "lf.session='"+reo1.getSession()+"' group by lf.stud_id,fine_dep_date,bank "
               + "union select session,session_sem,batch,sname,degree as degree,stud_id,amount as fee_total,"+date_field+" as dep_date,processed_in "
               + "as bank,bank_name as sub_bnk from stud_fee_draft where status='paid' "
               + "union select session,session_sem,batch,sname,degree as degree,stud_id,amount as fee_total,deposite_date as dep_date,bank_name "
               + "as bank,bank_name as sub_bnk from noduesed_student_draft "
               + "union select session,session_sem,batch,sname,degree,stud_id,amount as fee_total,deposit_date as dep_date,bank,bank as sub_bnk from "
               + "stud_other_inst where transfered='No') as u where dep_date between ? and ? and session=? and bank='"+reo1.getBank()+"'"
               + " order by dep_date desc limit " +offset +"," + noOfRecords;
//               System.out.println("qr2: "+qr);
           }
       else if(!reo1.getSession_sem().equals("Both")&&reo1.getBank().equals("ALL")){
           qr="select SQL_CALC_FOUND_ROWS * from (select session,session_sem,batch,sname,classes as degree,stud_id,sum(fee_total+adjstDraftTtAndFeeTt)"
               + " as fee_total,deposit_date as dep_date,subm_bank as bank,subm_bank as sub_bnk from sub_feedata group by stud_id,deposit_date,subm_bank "
               + "union select lf.session,lf.session_sem,sf.batch,sf.studname as sname,sf.degree as degree,lf.stud_id,sum(lf.fine) as fee_total,fine_dep_date as "
               + "dep_date,bank,bank as sub_bnk_bnk from latefine_onfeeprocess lf left join studentregis sf on lf.stud_id=sf.stud_id where lf.fine<>0 and "
               + "lf.session='"+reo1.getSession()+"' and lf.session_sem='"+reo1.getSession_sem()+"' group by lf.stud_id,fine_dep_date,bank "
               + "union select session,session_sem,batch,sname,degree as degree,stud_id,amount as fee_total,"+date_field+" as dep_date,processed_in "
               + "as bank,bank_name as sub_bnk from stud_fee_draft where status='paid' "
               + "union select session,session_sem,batch,sname,degree as degree,stud_id,amount as fee_total,deposite_date as dep_date,bank_name "
               + "as bank,bank_name as sub_bnk from noduesed_student_draft "
               + "union select session,session_sem,batch,sname,degree,stud_id,amount as fee_total,deposit_date as dep_date,bank,bank as sub_bnk from "
               + "stud_other_inst where transfered='No') as u where dep_date between ? and ? and session_sem='"+reo1.getSession_sem()+"'"
               + " and session=? and bank<>'' order by dep_date desc limit " +offset +"," + noOfRecords;
//                System.out.println("qr3: "+qr);
            }
        else{
             qr="select SQL_CALC_FOUND_ROWS * from (select session,session_sem,batch,sname,classes as degree,stud_id,sum(fee_total+adjstDraftTtAndFeeTt)"
                 + " as fee_total,deposit_date as dep_date,subm_bank as bank,subm_bank as sub_bnk from sub_feedata group by stud_id,deposit_date,subm_bank "
                 + "union select lf.session,lf.session_sem,sf.batch,sf.studname as sname,sf.degree as degree,lf.stud_id,sum(lf.fine) as fee_total,fine_dep_date as "
                 + "dep_date,bank,bank as sub_bnk from latefine_onfeeprocess lf left join studentregis sf on lf.stud_id=sf.stud_id where lf.fine<>0 and "
                 + "lf.session='"+reo1.getSession()+"' group by lf.stud_id,fine_dep_date,bank "
                 + "union select session,session_sem,batch,sname,degree as degree,stud_id,amount as fee_total,"+date_field+" as dep_date,processed_in "
                 + "as bank,bank_name as sub_bnk from stud_fee_draft where status='paid' "
                 + "union select session,session_sem,batch,sname,degree as degree,stud_id,amount as fee_total,deposite_date as dep_date,bank_name "
                 + "as bank,bank_name as sub_bnk from noduesed_student_draft "
                 + "union select session,session_sem,batch,sname,degree,stud_id,amount as fee_total,deposit_date as dep_date,bank,bank as sub_bnk "
                  + "from stud_other_inst where transfered='No') as u where dep_date between ? and ? and session=? and bank<>'' "
                 + "order by dep_date desc limit " +offset +"," + noOfRecords;
//                System.out.println("qr4: "+qr);
             }
            
//            where type='addmission fee'
//            System.out.println(qr);
            pstm=conn.prepareStatement(qr);
            pstm.setDate(1, new java.sql.Date(reo1.getDate1().getTime()));
            pstm.setDate(2, new java.sql.Date(reo1.getDate2().getTime()));
            pstm.setString(3, reo1.getSession());
//            System.out.println(pstm.);
            rs=pstm.executeQuery();
            while(rs.next())
            {
              reo=new ReportsEO();
              reo.setBatch(rs.getString("batch"));
              reo.setStud_id(rs.getString("stud_id"));
              reo.setSname(rs.getString("sname"));
              reo.setDegree(rs.getString("degree"));
              reo.setAmount(rs.getDouble("fee_total"));
//              reo.setBank(rs.getString("bank"));
              reo.setBank(rs.getString("sub_bnk"));
              reo.setDate1(rs.getDate("dep_date"));
              al.add(reo);
            }
            
            rs.close();
 
    rs = pstm.executeQuery("SELECT FOUND_ROWS()");
    if(rs.next())
        this.noOfRecords = rs.getInt(1);   
            
         }catch(Exception e){System.out.println("Ex: "+e.getMessage());}
        finally{
            try{
                if(rs!=null){rs.close();}
                if(pstm!=null){pstm.close();}
                if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
        
        return al;
    }
    
    public ArrayList retReceivedDetail()
    {
        ArrayList al=new ArrayList();
        HashMap hm=new HashMap();
        SchoolEO seo=null;
        //CustomerBean cb=null;
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        
        try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=(Connection)dc.Dataconnect();
        }catch(Exception e){}
        try{
//            String qr="select * from stud_fee_draft where status=?";
            String qr="select * from stud_fee_draft order by receipt_no";
            pstm=conn.prepareStatement(qr);
//            pstm.setString(1, "refunded");
            rs=pstm.executeQuery();
            while(rs.next())
            {
              seo=new SchoolEO();
              seo.setSname(rs.getString("sname"));
              seo.setSrnum(rs.getString("srnum"));
              seo.setDdno(rs.getString("draft_no"));
              seo.setBankname(rs.getString("bank_name"));
              seo.setDdate(rs.getString("date"));
              seo.setDdamount(rs.getDouble("amount"));
              seo.setStud_id(rs.getString("stud_id"));
              seo.setDeposite_date(rs.getDate("deposite_date"));
              seo.setDegree(rs.getString("degree"));
              al.add(seo);
            }
            
         }catch(Exception e){}
        finally{
            try{
                if(rs!=null){rs.close();}
                if(pstm!=null){pstm.close();}
                if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
        
        return al;
    }
    
public double getSumOnDate(java.sql.Date dt1, java.sql.Date dt2)
    {
        double sum=0.0;
        try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=(Connection)dc.Dataconnect();
        }catch(Exception e){}
        
        try{
           String qr1="select sum(amount) as sum from stud_fee_draft where deposite_date BETWEEN ? and ? and type=?";
            pstm=conn.prepareStatement(qr1);
            pstm.setDate(1, dt1);
            pstm.setDate(2, dt2);
            pstm.setString(3, "addmission fee");
            rs=pstm.executeQuery();
            if(rs.next())
            {
              sum=rs.getDouble("sum");
            }
          }catch(Exception e){}
        finally{
            try{
                if(rs!=null){rs.close();}
                if(pstm!=null){pstm.close();}
                if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
        
        return sum;
    }

public double getSumAdvOnDate(java.sql.Date dt1,java.sql.Date dt2)
    {
        double sum=0.0;
        try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=(Connection)dc.Dataconnect();
        }catch(Exception e){}
        
        try{
           String qr1="select sum(amount) as sum from stud_draft where deposite_date BETWEEN ? and ? and status=?";
            pstm=conn.prepareStatement(qr1);
            pstm.setDate(1, dt1);
            pstm.setDate(2, dt2);
            pstm.setString(3, "paid");
            rs=pstm.executeQuery();
            if(rs.next())
            {
              sum=rs.getDouble("sum");
            }
          }catch(Exception e){}
        finally{
            try{
                if(rs!=null){rs.close();}
                if(pstm!=null){pstm.close();}
                if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
        
        return sum;
    }
    
 public double getTotalReceived()
    {
        double sum=0.0;
        try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=(Connection)dc.Dataconnect();
        }catch(Exception e){}
        
        try{
           String qr1="select sum(amount) as sum from stud_fee_draft";
            pstm=conn.prepareStatement(qr1);
            
            rs=pstm.executeQuery();
            if(rs.next())
            {
              sum=rs.getDouble("sum");
            }
          }catch(Exception e){}
        finally{
            try{
                if(rs!=null){rs.close();}
                if(pstm!=null){pstm.close();}
                if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
        
        return sum;
    } 
 
 public double getTotalRefunded(String session)
    {
        double sum=0.0;
        try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=(Connection)dc.Dataconnect();
        }catch(Exception e){}
        
        try{
           String qr1="select sum(amount) as sum from stud_draft where status=? and session=?";
            pstm=conn.prepareStatement(qr1);
            pstm.setString(1, "refunded");
            pstm.setString(2, session);
            rs=pstm.executeQuery();
            if(rs.next())
            {
              sum=rs.getDouble("sum");
            }
          }catch(Exception e){}
        finally{
            try{
                if(rs!=null){rs.close();}
                if(pstm!=null){pstm.close();}
                if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
        
        return sum;
    }
 
 public ArrayList advanceBankWiseOnDate(ReportsEO reo1,String date_field,int offset,int noOfRecords)
    {
        ArrayList al=new ArrayList();
       ReportsEO reo=null;
        //CustomerBean cb=null;
        
        try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=(Connection)dc.Dataconnect();
        }catch(Exception e){}
        try{
//            String qr="select * from stud_draft where deposite_date BETWEEN ? and ? and bank_name=? and status=? order by receipt_no";
            
//            String qr="";
//            if(!reo1.getBank().equals("ALL")){
//                qr="select SQL_CALC_FOUND_ROWS * from stud_draft where session=? and deposite_date BETWEEN ? and ? and status=?"
//                        + " and bank_name='"+reo1.getBank()+"' order by receipt_no desc limit " +offset +"," + noOfRecords;
//            }
//            else{
//                qr="select SQL_CALC_FOUND_ROWS * from stud_draft where session=? and deposite_date BETWEEN ? and ? and status=?"
//                    + " order by receipt_no desc limit " +offset +"," + noOfRecords;
//            }
            
            String qr="";
            if(!reo1.getBank().equals("ALL")){
                qr="select SQL_CALC_FOUND_ROWS * from stud_draft where session=? and "+date_field+" BETWEEN ? and ? and status=?"
                        + " and bank_name='"+reo1.getBank()+"' order by receipt_no desc limit " +offset +"," + noOfRecords;
            }
            else{
                qr="select SQL_CALC_FOUND_ROWS * from stud_draft where session=? and "+date_field+" BETWEEN ? and ? and status=?"
                    + " order by receipt_no desc limit " +offset +"," + noOfRecords;
            }
            pstm=conn.prepareStatement(qr);
            pstm.setString(1, reo1.getSession());
            pstm.setDate(2, new java.sql.Date(reo1.getDate1().getTime()));
            pstm.setDate(3, new java.sql.Date(reo1.getDate2().getTime()));
//            pstm.setString(3, bnk);
            pstm.setString(4, "paid");
            rs=pstm.executeQuery();
            while(rs.next())
            {
              reo=new ReportsEO();
              reo.setSname(rs.getString("sname"));
              reo.setSrnum(rs.getString("srnum"));
              reo.setNumber(rs.getString("draft_no"));
              reo.setBank(rs.getString("bank_name"));
              reo.setDate(rs.getString("date"));
              reo.setAmount(rs.getDouble("amount"));
              reo.setStud_id(rs.getString("Stud_id"));
              reo.setDate1(rs.getDate("deposite_date"));
              reo.setDate2(rs.getDate("draft_proc_date"));
              al.add(reo);
            }
            
           rs.close();
 
    rs = pstm.executeQuery("SELECT FOUND_ROWS()");
    if(rs.next())
        this.noOfRecords = rs.getInt(1);   
            
        }catch(Exception e){}
        finally{
            try{
                if(rs!=null){rs.close();}
                if(pstm!=null){pstm.close();}
                if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
        
        return al;
    }
 
 public double getSumAdvBankWiseOnDate(ReportsEO reo,String date_field)
    {
        double sum=0.0;
        try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=(Connection)dc.Dataconnect();
        }catch(Exception e){}
        
        try{
//           String qr1="select sum(amount) as sum from stud_draft where deposite_date BETWEEN ? and ? and bank_name=? and status=?";
            String qr1="";
//           if(!reo.getBank().equals("ALL"))
//             qr1="select sum(amount) as sum from stud_draft where session=? and deposite_date BETWEEN ? and ? and status=? and bank_name='"+reo.getBank()+"'";
//           else
//               qr1="select sum(amount) as sum from stud_draft where session=? and deposite_date BETWEEN ? and ? and status=?";
            
           if(!reo.getBank().equals("ALL"))
             qr1="select sum(amount) as sum from stud_draft where session=? and "+date_field+" BETWEEN ? and ? and status=? and bank_name='"+reo.getBank()+"'";
           else
               qr1="select sum(amount) as sum from stud_draft where session=? and "+date_field+" BETWEEN ? and ? and status=?";
            pstm=conn.prepareStatement(qr1);
            pstm.setString(1, reo.getSession());
            pstm.setDate(2, new java.sql.Date(reo.getDate1().getTime()));
            pstm.setDate(3, new java.sql.Date(reo.getDate2().getTime()));
//            pstm.setString(3, bnk);
            pstm.setString(4, "paid");
            rs=pstm.executeQuery();
            if(rs.next())
            {
              sum=rs.getDouble("sum");
            }
          }catch(Exception e){}
        finally{
            try{
                if(rs!=null){rs.close();}
                if(pstm!=null){pstm.close();}
                if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
        
        return sum;
    }
 
 
  public ArrayList amountBankWiseOnDate(ReportsEO reo1,String date_field,int offset,int noOfRecords)
    {
        ArrayList al=new ArrayList();
        HashMap hm=new HashMap();
        ReportsEO reo=null;
        //CustomerBean cb=null;
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        
        try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=(Connection)dc.Dataconnect();
        }catch(Exception e){}
        try{
//            String qr="";
//            if(!reo1.getBank().equals("ALL")){
//                qr="select SQL_CALC_FOUND_ROWS * from stud_fee_draft where session=? and deposite_date BETWEEN ? and ? and type=?"
//                        + " and bank_name='"+reo1.getBank()+"' order by receipt_no desc limit " +offset +"," + noOfRecords;
//            }
//            else{
//                qr="select SQL_CALC_FOUND_ROWS * from stud_fee_draft where session=? and deposite_date BETWEEN ? and ? and type=?"
//                    + " order by receipt_no desc limit " +offset +"," + noOfRecords;
//            }
            
            String qr="";
            if(!reo1.getBank().equals("ALL")){
                qr="select SQL_CALC_FOUND_ROWS * from stud_fee_draft where session=? and "+date_field+" BETWEEN ? and ? and type=?"
                        + " and bank_name='"+reo1.getBank()+"' order by receipt_no desc limit " +offset +"," + noOfRecords;
            }
            else{
                qr="select SQL_CALC_FOUND_ROWS * from stud_fee_draft where session=? and "+date_field+" BETWEEN ? and ? and type=?"
                    + " order by receipt_no desc limit " +offset +"," + noOfRecords;
            }
//            System.out.println("kapil: "+qr);
            pstm=conn.prepareStatement(qr);
            pstm.setString(1, reo1.getSession());
            pstm.setDate(2, new java.sql.Date(reo1.getDate1().getTime()));
            pstm.setDate(3, new java.sql.Date(reo1.getDate2().getTime()));
////            pstm.setString(3, bnk);
            pstm.setString(4, "addmission fee");
            rs=pstm.executeQuery();
            while(rs.next())
            {
              reo=new ReportsEO();
              reo.setSname(rs.getString("sname"));
              reo.setSrnum(rs.getString("srnum"));
              reo.setNumber(rs.getString("draft_no"));
              reo.setBank(rs.getString("bank_name"));
              reo.setDate(rs.getString("date"));
              reo.setAmount(rs.getDouble("amount"));
              reo.setStud_id(rs.getString("Stud_id"));
              reo.setDate1(rs.getDate("deposite_date"));
              reo.setDegree(rs.getString("degree"));
              reo.setDate2(rs.getDate("draft_proc_date"));
              al.add(reo);
            }
            
          rs.close();
 
    rs = pstm.executeQuery("SELECT FOUND_ROWS()");
    if(rs.next())
        this.noOfRecords = rs.getInt(1);   
     }catch(Exception e){}
        finally{
            try{
                if(rs!=null){rs.close();}
                if(pstm!=null){pstm.close();}
                if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
        
        return al;
    }
  
  public double getSumAmntBankWiseOnDate(ReportsEO reo,String date_field)
    {
        double sum=0.0;
        try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=(Connection)dc.Dataconnect();
        }catch(Exception e){}
        
        try{
           String qr1="";
//           if(!reo.getBank().equals("ALL"))
//             qr1="select sum(amount) as sum from stud_fee_draft where session=? and deposite_date BETWEEN ? and ? and type=? and bank_name='"+reo.getBank()+"'";
//           else
//               qr1="select sum(amount) as sum from stud_fee_draft where session=? and deposite_date BETWEEN ? and ? and type=?";

//           String qr1="select SQL_CALC_FOUND_ROWS sum(amount) as sum from stud_fee_draft where deposite_date BETWEEN ? and ? and bank_name=? and type=?"
//                   + " limit " +offset +"," + noOfRecords;
           
           if(!reo.getBank().equals("ALL"))
             qr1="select sum(amount) as sum from stud_fee_draft where session=? and "+date_field+" BETWEEN ? and ? and type=? and bank_name='"+reo.getBank()+"'";
           else
               qr1="select sum(amount) as sum from stud_fee_draft where session=? and "+date_field+" BETWEEN ? and ? and type=?";
            pstm=conn.prepareStatement(qr1);
            pstm.setString(1, reo.getSession());
            pstm.setDate(2, new java.sql.Date(reo.getDate1().getTime()));
            pstm.setDate(3, new java.sql.Date(reo.getDate2().getTime()));
////            pstm.setString(3, bnk);
            pstm.setString(4, "addmission fee");
            rs=pstm.executeQuery();
            if(rs.next())
            {
              sum=rs.getDouble("sum");
            }
          }catch(Exception e){}
        finally{
            try{
                if(rs!=null){rs.close();}
                if(pstm!=null){pstm.close();}
                if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
        
        return sum;
    } 
  
public int checkAdvDraft(String bnk,String session)
{
    int cnt=0;
    try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=(Connection)dc.Dataconnect();
        }catch(Exception e){}
        
        try{
            String qr="select count(*) as cnt from stud_draft where session=? and bank_name=? and status=? and updation=?";
            pstm1=conn.prepareStatement(qr);
            pstm1.setString(1, session);
            pstm1.setString(2, bnk);
            pstm1.setString(3, "paid");
             pstm1.setString(4, "unchecked");
             rs1=pstm1.executeQuery();
            if(rs1.next()){
                cnt=rs1.getInt("cnt");
            }
            
            
        }catch(Exception e){System.out.println("kapil "+e.getMessage());}
        finally{
            try
            {
                if(rs!=null){rs.close();}
                if(pstm!=null){pstm.close();}
                if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
    
    return cnt;
}

public ArrayList getAdvDraft(String bnk,String session)
{
    ArrayList al=new ArrayList();
    ReportsEO reo=null;
    int cnt=0;
    try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=(Connection)dc.Dataconnect();
        }catch(Exception e){}
        
        try{
            
            
            String str="select srnum,sname,stud_id,draft_no,bank_name,date,amount,rwid from stud_draft where session=? and bank_name=? and status=?"
                    + " and updation=? order by receipt_no limit 0, 20";
            pstm=conn.prepareStatement(str);
            pstm.setString(1, session);
            pstm.setString(2, bnk);
            pstm.setString(3, "paid");
             pstm.setString(4, "unchecked");
            rs=pstm.executeQuery();
          
         while(rs.next()){
             reo=new ReportsEO();
              reo.setSname(rs.getString("sname"));
              reo.setSrnum(rs.getString("srnum"));
              reo.setNumber(rs.getString("draft_no"));
              reo.setBank(rs.getString("bank_name"));
              reo.setDate(rs.getString("date"));
              reo.setAmount(rs.getDouble("amount"));
              reo.setStud_id(rs.getString("Stud_id"));
              reo.setRwid(rs.getLong("rwid"));
              al.add(reo);
//              rs.next();
         }
     }catch(Exception e){System.out.println("kapil "+e.getMessage());}
        finally{
            try
            {
                if(rs!=null){rs.close();}
                if(pstm!=null){pstm.close();}
                if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
    
    return al;
}

public void upAdvDraft(ReportsEO reo1, ArrayList al)
{
    ReportsEO reo=null;
    try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=(Connection)dc.Dataconnect();
        }catch(Exception e){}
        
        try{
            String str="update stud_draft set updation=?,slot=?,updation_date=? where rwid=?";
            pstm=conn.prepareStatement(str);
             for(int i=0;i<al.size();i++){
               reo=(ReportsEO)al.get(i);
               pstm.setString(1, "checked");
               pstm.setInt(2, reo1.getNum());
               pstm.setDate(3, new java.sql.Date(reo1.getDate1().getTime()));
               pstm.setLong(4, reo.getRwid());
               pstm.addBatch();
              }
           pstm.executeBatch();
         }catch(Exception e){System.out.println("kapil "+e.getMessage());}
        finally{
            try
            {
                if(rs!=null){rs.close();}
                if(pstm!=null){pstm.close();}
                if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
  }

public void upAdvDraftInFeeDraft(ReportsEO reo1, ArrayList al)
{
    ReportsEO reo=null;
    try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=(Connection)dc.Dataconnect();
        }catch(Exception e){}
        
        try{
            String str="update stud_fee_draft set updation=?,slot=?,updation_date=? where bank_name=? and type=? and session=? and draft_no=?";
            pstm=conn.prepareStatement(str);
             for(int i=0;i<al.size();i++){
               reo=(ReportsEO)al.get(i);
               pstm.setString(1, "checked");
               pstm.setInt(2, reo1.getNum());
               pstm.setDate(3, new java.sql.Date(reo1.getDate1().getTime()));
               pstm.setString(4, reo1.getBank());
               pstm.setString(5, "counselling");
               pstm.setString(6, reo1.getSession());
               pstm.setString(7, reo.getNumber());
               pstm.addBatch();
              }
           pstm.executeBatch();
         }catch(Exception e){System.out.println("kapil "+e.getMessage());}
        finally{
            try
            {
                if(rs!=null){rs.close();}
                if(pstm!=null){pstm.close();}
                if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
  }

public int checkFeeDraft(String bnk,String session)
{
    int cnt=0;
    try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=(Connection)dc.Dataconnect();
        }catch(Exception e){}
        
        try{
            String qr="select count(*) as cnt from stud_fee_draft where session=? and bank_name=? and status=? and updation=? and type=?";
            pstm1=conn.prepareStatement(qr);
            pstm1.setString(1, session);
            pstm1.setString(2, bnk);
            pstm1.setString(3, "paid");
             pstm1.setString(4, "unchecked");
             pstm1.setString(5, "addmission fee");
            rs1=pstm1.executeQuery();
            if(rs1.next()){
                cnt=rs1.getInt("cnt");
            }
            
        }catch(Exception e){System.out.println("kapil "+e.getMessage());}
        finally{
            try
            {
                if(rs!=null){rs.close();}
                if(pstm!=null){pstm.close();}
                if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
    
    return cnt;
}

public ArrayList getAmntDraft(String bnk,String session)
{
    ArrayList al=new ArrayList();
    ReportsEO reo=null;
    try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=(Connection)dc.Dataconnect();
        }catch(Exception e){}
        
        try{
            
            
            String str="select srnum,sname,stud_id,draft_no,bank_name,date,amount,rwid from stud_fee_draft where session=? and bank_name=? and status=?"
                    + " and updation=? and type=? order by receipt_no limit 0,20";
            pstm=conn.prepareStatement(str);
            pstm.setString(1, session);
            pstm.setString(2, bnk);
            pstm.setString(3, "paid");
             pstm.setString(4, "unchecked");
             pstm.setString(5, "addmission fee");
            rs=pstm.executeQuery();
          
    // rs.absolute(cn);
     
         while(rs.next()){
             reo=new ReportsEO();
              reo.setSname(rs.getString("sname"));
              reo.setSrnum(rs.getString("srnum"));
              reo.setNumber(rs.getString("draft_no"));
              reo.setBank(rs.getString("bank_name"));
              reo.setDate(rs.getString("date"));
              reo.setAmount(rs.getDouble("amount"));
              reo.setStud_id(rs.getString("Stud_id"));
              reo.setRwid(rs.getLong("rwid"));
              al.add(reo);
         }
            
        }catch(Exception e){System.out.println("kapil "+e.getMessage());}
        finally{
            try
            {
                if(rs!=null){rs.close();}
                 if(rs1!=null){rs1.close();}
                if(pstm!=null){pstm.close();}
                if(pstm1!=null){pstm1.close();}
                if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
    
    return al;
}

public void upAmntDraft(ReportsEO reo1, ArrayList al)
{
    ReportsEO reo=null;
    
    try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=(Connection)dc.Dataconnect();
        }catch(Exception e){}
        
        try{
            String str="update stud_fee_draft set updation=?,slot=?,updation_date=? where rwid=?";
            pstm=conn.prepareStatement(str);
             for(int i=0;i<al.size();i++){
                 reo=(ReportsEO)al.get(i);
                 pstm.setString(1, "checked");
                 pstm.setInt(2, reo1.getNum());
                 pstm.setDate(3, new java.sql.Date(reo1.getDate1().getTime()));
                 pstm.setLong(4, reo.getRwid());
                 pstm.addBatch();
              }
           pstm.executeBatch();
         }catch(Exception e){System.out.println("kapil "+e.getMessage());}
        finally{
            try
            {
                if(rs!=null){rs.close();}
                if(pstm!=null){pstm.close();}
                if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
  }

public int foundMaxSlot(String session,String bank,String table)
{
    int slot=0;
    try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=(Connection)dc.Dataconnect();
        }catch(Exception e){}
        
        try{
            String qr="";
            if(table.equals("stud_fee_draft")) 
                qr="select max(slot) as mx from "+table+" where session=? and bank_name=? and type='addmission fee'";
            else
                qr="select max(slot) as mx from "+table+" where session=? and bank_name=?";
            pstm1=conn.prepareStatement(qr);
            pstm1.setString(1, session);
            pstm1.setString(2, bank);
            rs1=pstm1.executeQuery();
            if(rs1.next()){
                if(rs1.getString("mx")!=null)
                    slot=rs1.getInt("mx");
            }
            slot=slot+1;
        }catch(Exception e){System.out.println("kapil "+e.getMessage());}
        finally{
            try
            {
                if(rs!=null){rs.close();}
                if(pstm!=null){pstm.close();}
                if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
    return slot;
}

public ArrayList getDraftFromTable(ReportsEO reo1,int slot,String table,String flag,int offset,int noOfRecords)
{
    ArrayList al=new ArrayList();
    ReportsEO reo=null;
    try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=(Connection)dc.Dataconnect();
        }catch(Exception e){}
        
        try{
            String str="";
            StringBuffer sb=new StringBuffer("");
            sb=sb.append("select SQL_CALC_FOUND_ROWS srnum,sname,stud_id,draft_no,processed_in,date,amount,rwid,draft_proc_date from "+table+" where");
            sb=sb.append(" session=? and bank_name=? and status=? and updation='checked'");
            if(table.equals("stud_fee_draft"))
                sb=sb.append(" and type='addmission fee'");
            if(slot!=0&&reo1.getDraft_no().equals("")){
                sb=sb.append(" and slot='"+slot+"'");
                sb=sb.append(" order by receipt_no");
            }
            else if(!reo1.getDraft_no().equals("")){
                sb=sb.append(" and draft_no='"+reo1.getDraft_no()+"'");
            }
            else if(flag.equals("beforeupdate")){
                sb=sb.append(" and draft_proc_date is null order by receipt_no limit " +offset +"," + noOfRecords);
            }
            else
                sb=sb.append(" order by receipt_no limit " +offset +"," + noOfRecords);
                        
//            System.out.println("Query: "+sb); 
            pstm=conn.prepareStatement(sb.toString());
            pstm.setString(1, reo1.getSession());
            pstm.setString(2, reo1.getBank());
            pstm.setString(3, "paid");
            rs=pstm.executeQuery();
          
    // rs.absolute(cn);
            while(rs.next()){
              reo=new ReportsEO();
              reo.setSname(rs.getString("sname"));
              reo.setSrnum(rs.getString("srnum"));
              reo.setNumber(rs.getString("draft_no"));
              reo.setBank(rs.getString("processed_in"));
              reo.setDate(rs.getString("date"));
              reo.setAmount(rs.getDouble("amount"));
              reo.setStud_id(rs.getString("Stud_id"));
              reo.setRwid(rs.getLong("rwid"));
              reo.setDate1(rs.getDate("draft_proc_date"));
                
              al.add(reo);
         }
            rs.close();
 
    rs = pstm.executeQuery("SELECT FOUND_ROWS()");
    if(rs.next())
        this.noOfRecords = rs.getInt(1);  
        }catch(Exception e){System.out.println("kapil "+e.getMessage());}
        finally{
            try
            {
                if(rs!=null){rs.close();}
                 if(rs1!=null){rs1.close();}
                if(pstm!=null){pstm.close();}
                if(pstm1!=null){pstm1.close();}
                if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
    return al;
}

public void upDraftProcessingDate(ReportsEO reo1, ArrayList al,String table)
{
    ReportsEO reo=null;
    
    try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=(Connection)dc.Dataconnect();
        }catch(Exception e){}
        
        try{
            String str="update "+table+" set draft_proc_date=?,processed_in=? where rwid=?";
            pstm=conn.prepareStatement(str);
             for(int i=0;i<al.size();i++){
                 reo=(ReportsEO)al.get(i);
                 pstm.setDate(1, new java.sql.Date(reo1.getDate1().getTime()));
                 pstm.setString(2, reo1.getBank());
                 pstm.setLong(3, reo.getRwid());
                 pstm.addBatch();
              }
           pstm.executeBatch();
         }catch(Exception e){System.out.println("kapil "+e.getMessage());}
        finally{
            try
            {
                if(rs!=null){rs.close();}
                if(pstm!=null){pstm.close();}
                if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
  }

public void upDraftProcessingDate(ArrayList draftlist, ReportsEO reo1,String table,String dr_bank)
{
    ReportsEO reo=null;
    
    try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=(Connection)dc.Dataconnect();
        }catch(Exception e){}
        
        try{
            String str="update "+table+" set draft_proc_date=?,processed_in=? where draft_no=? and session=? and bank_name=?";
            pstm=conn.prepareStatement(str);
             for(int i=0;i<draftlist.size();i++){
                 pstm.setDate(1, new java.sql.Date(reo1.getDate1().getTime()));
                 pstm.setString(2, reo1.getBank());
                 pstm.setString(3, draftlist.get(i).toString());
                 pstm.setString(4, reo1.getSession());
                 pstm.setString(5, dr_bank);
                 pstm.addBatch();
              }
           pstm.executeBatch();
         }catch(Exception e){System.out.println("kapil "+e.getMessage());}
        finally{
            try
            {
                if(rs!=null){rs.close();}
                if(pstm!=null){pstm.close();}
                if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
  }


//public double get20AdvSum(java.sql.Date dt1,java.sql.Date dt2,String bnk)
//    {
//        double sum=0.0;
//        try{
//            Dataconnectivity dc=new Dataconnectivity();
//            conn=(Connection)dc.Dataconnect();
//        }catch(Exception e){}
//        
//        try{
//           String qr1="select sum(amount) as sum from stud_draft where bank_name=?, status=? and updation!=?";
//            pstm.setString(1, bnk);
//            pstm.setString(2, "paid");
//             pstm.setString(3, "checked");
//            rs=pstm.executeQuery();
//            if(rs.next())
//            {
//              sum=rs.getDouble("sum");
//            }
//          }catch(Exception e){}
//        finally{
//            try{
//                if(rs!=null){rs.close();}
//                if(pstm!=null){pstm.close();}
//                if(conn!=null){conn.close();}
//            }catch(Exception e){}
//        }
//        
//        return sum;
//    }
//    

public void transfer_fund(SchoolEO seo)
{
    try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=(Connection)dc.Dataconnect();
        }catch(Exception e){}
        
        try{
            String str="insert into fund_transfer(session,session_sem,funds,amount,transfer_date,head) values(?,?,?,?,?,?)";
            pstm=conn.prepareStatement(str);
            pstm.setString(1, seo.getSession());
            pstm.setString(2, seo.getSession_sem());
            pstm.setString(3, seo.getHeads_cat());
//             pstm.setDouble(4, seo.getTotalFee());
            pstm.setDouble(4, seo.getTransfered_fund());
             pstm.setTimestamp(5, new Timestamp(new java.util.Date().getTime()));
             pstm.setString(6, seo.getHeads());
           int i=pstm.executeUpdate();
//           System.out.println("kalil "+i);
         }catch(Exception e){System.out.println("kalil "+e.getMessage());}
        finally{
            try
            {
                if(rs!=null){rs.close();}
                if(pstm!=null){pstm.close();}
                if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
  }

public SchoolEO retTransfer_fund(SchoolEO seo)
{
//    HashMap ftrn=new HashMap();
    ArrayList al=new ArrayList();
    SchoolEO se=null;
    try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=(Connection)dc.Dataconnect();
        }catch(Exception e){}
        
        try{
//           String qr1="select * from fund_transfer where session='"+seo.getSession()+"' and session_sem='"+seo.getSession_sem()+"'";
            String qr1="select * from fund_transfer where funds='"+seo.getHeads_cat()+"' and session='"+seo.getSession()+"' and session_sem='"+seo.getSession_sem()+"'";
//           System.out.println(qr1);
            pstm=conn.prepareStatement(qr1);
//            pstm.setString(1, seo.getSession());
//            pstm.setString(2, seo.getSession_sem());
            rs=pstm.executeQuery();
            while(rs.next())
            {
//              ftrn.put(rs.getString("funds"), rs.getDouble("amount"));
                se=new SchoolEO();
                se.setHeads_cat(rs.getString("funds"));
                se.setTransfered_fund(rs.getDouble("amount"));
                se.setDeposite_date(rs.getTimestamp("transfer_date"));
                al.add(se);
            }
//            seo.setDataMap4(ftrn);
            seo.setDataArray9(al);
          }catch(Exception e){}
        finally{
            try{
                if(rs!=null){rs.close();}
                if(pstm!=null){pstm.close();}
                if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
    return seo;
}

public double retTotal_SelfFinAmount(ReportsEO reo)
{
//    HashMap ftrn=new HashMap();
    double total_selfF=0;
    try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=(Connection)dc.Dataconnect();
        }catch(Exception e){}
        
        try{
            String qr1="select sum(self_finance_fee) as amount from stud_fee_detail where degree='"+reo.getDegree()+"' and session='"+reo.getSession()+"' and session_sem='"+reo.getSession_sem()+"'";
//           System.out.println(qr1);
            pstm=conn.prepareStatement(qr1);
//            pstm.setString(1, seo.getSession());
//            pstm.setString(2, seo.getSession_sem());
            rs=pstm.executeQuery();
            if(rs.next())
            {
                total_selfF=rs.getDouble("amount");
            }

          }catch(Exception e){}
        finally{
            try{
                if(rs!=null){rs.close();}
                if(pstm!=null){pstm.close();}
                if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
    return total_selfF;
}

public ArrayList retTransfered_SelfFinAmount(ReportsEO reo)
{
//    HashMap ftrn=new HashMap();
    ArrayList al=new ArrayList();
    ReportsEO re=null;
    try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=(Connection)dc.Dataconnect();
        }catch(Exception e){}
        
        try{
            String qr1="select * from self_finan_amount_transfer where degree='"+reo.getDegree()+"' and session='"+reo.getSession()+"' and session_sem='"+reo.getSession_sem()+"'";
//           System.out.println(qr1);
            pstm=conn.prepareStatement(qr1);
//            pstm.setString(1, seo.getSession());
//            pstm.setString(2, seo.getSession_sem());
            rs=pstm.executeQuery();
            while(rs.next())
            {
                re=new ReportsEO();
                re.setDegree(rs.getString("degree"));
                re.setTransfered_fund(rs.getDouble("amount"));
                re.setDate1(rs.getTimestamp("transfer_date"));
                al.add(re);
            }

          }catch(Exception e){}
        finally{
            try{
                if(rs!=null){rs.close();}
                if(pstm!=null){pstm.close();}
                if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
    return al;
}

public void selfFinAmount_transfer(ReportsEO reo)
{
    try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=(Connection)dc.Dataconnect();
        }catch(Exception e){}
        
        try{
            String str="insert into self_finan_amount_transfer(session,session_sem,degree,amount,transfer_date) values(?,?,?,?,?)";
            pstm=conn.prepareStatement(str);
            pstm.setString(1, reo.getSession());
            pstm.setString(2, reo.getSession_sem());
            pstm.setString(3, reo.getDegree());
            pstm.setDouble(4, reo.getTransfered_fund());
             pstm.setTimestamp(5, new Timestamp(new java.util.Date().getTime()));
           int i=pstm.executeUpdate();
         }catch(Exception e){System.out.println("kalil "+e.getMessage());}
        finally{
            try
            {
                if(rs!=null){rs.close();}
                if(pstm!=null){pstm.close();}
                if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
  }

public ArrayList retLateFineReceived(ReportsEO reo1)
    {
        ArrayList al=new ArrayList();
        ReportsEO reo=null;
        //CustomerBean cb=null;
       
        
        try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=(Connection)dc.Dataconnect();
        }catch(Exception e){}
        try{
            String qr="";
            if(!reo1.getSession_sem().equals("Both")&&!reo1.getBank().equals("ALL")) {
                qr="select lf.stud_id,sr.studname,sr.batch,sr.degree,lf.fine,lf.fine_dep_date,lf.bank from latefine_onfeeprocess lf left join studentregis"
                        + " sr on lf.stud_id=sr.stud_id where lf.session_sem='"+reo1.getSession_sem()+"' and lf.session='"+reo1.getSession()+"'"
                        + " and lf.bank='"+reo1.getBank()+"' and fine<>0 order by fine_dep_date desc";
            }
            else if(reo1.getSession_sem().equals("Both")&&!reo1.getBank().equals("ALL")){
                qr="select lf.stud_id,sr.studname,sr.batch,sr.degree,lf.fine,lf.fine_dep_date,lf.bank from latefine_onfeeprocess lf left join studentregis"
                        + " sr on lf.stud_id=sr.stud_id where lf.session='"+reo1.getSession()+"' and lf.bank='"+reo1.getBank()+"' and fine<>0 order by "
                        + "fine_dep_date desc";
               }
            else if(!reo1.getSession_sem().equals("Both")&&reo1.getBank().equals("ALL"))
            {
                qr="select lf.stud_id,sr.studname,sr.batch,sr.degree,lf.fine,lf.fine_dep_date,lf.bank from latefine_onfeeprocess lf left join studentregis"
                        + " sr on lf.stud_id=sr.stud_id where lf.session_sem='"+reo1.getSession_sem()+"' and lf.session='"+reo1.getSession()+"' "
                        + "and fine<>0 order by fine_dep_date desc";
            }
            else{
                qr="select lf.stud_id,sr.studname,sr.batch,sr.degree,lf.fine,lf.fine_dep_date,lf.bank from latefine_onfeeprocess lf left join studentregis"
                        + " sr on lf.stud_id=sr.stud_id where lf.session='"+reo1.getSession()+"' and fine<>0 order by fine_dep_date desc";
            }
            
            pstm=conn.prepareStatement(qr);
            rs=pstm.executeQuery();
            while(rs.next())
            {
              reo=new ReportsEO();
              reo.setBatch(rs.getString("batch"));
              reo.setStud_id(rs.getString("stud_id"));
              reo.setSname(rs.getString("studname"));
              reo.setDegree(rs.getString("degree"));
              reo.setFine(rs.getDouble("fine"));
              reo.setBank(rs.getString("bank"));
              reo.setDate1(rs.getDate("fine_dep_date"));
              al.add(reo);
            }
             
            
         }catch(Exception e){System.out.println("Ex: "+e.getMessage());}
        finally{
            try{
                if(rs!=null){rs.close();}
                if(pstm!=null){pstm.close();}
                if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
        
        return al;
    }

public HashMap allReceivedAmountInBanks(ReportsEO reo1,ArrayList banklist,String date_field,String bank_field)
    {
        
        ReportsEO reo=null;
        HashMap hm=new HashMap();
        
        java.sql.Date date1=new java.sql.Date(reo1.getDate1().getTime());
        java.sql.Date date2=new java.sql.Date(reo1.getDate2().getTime());
        
        try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=(Connection)dc.Dataconnect();
        }catch(Exception e){}
        try{
            String qr="";
//            System.out.println("banklist size: "+banklist.size());
            for(int i=0;i<banklist.size();i++){
//                ArrayList al=new ArrayList();
                HashMap hm1=new HashMap();
//                if(!reo1.getSession_sem().equals("Both")) {
//                    qr="select sum(fee_total) as total,bank,dep_date from (select session,session_sem,sum(fee_total+adjstDraftTtAndFeeTt) as fee_total,"
//                        + "deposit_date as dep_date,subm_bank as bank from sub_feedata group by subm_bank,deposit_date "
//                        + "union select session,session_sem,sum(fine) as fee_total,fine_dep_date as dep_date,bank from latefine_onfeeprocess where "
//                        + "fine<>0 group by bank,fine_dep_date "
//                        + "union select session,session_sem,sum(amount) as fee_total,"+date_field+" as dep_date,processed_in as bank from stud_fee_draft "
//                        + "where status='paid' group by processed_in,"+date_field+" "
//                        + "union select session,session_sem,sum(amount) as fee_total,deposite_date as dep_date,bank_name as bank from "
//                        + "noduesed_student_draft group by bank_name,deposite_date "
//                        + "union select session,session_sem,sum(amount) as fee_total,deposit_date as dep_date,bank from stud_other_inst where "
//                        + "transfered='No' group by bank,deposit_date) as u where dep_date between '"+date1+"' and '"+date2+"' and "
//                        + "session_sem='"+reo1.getSession_sem()+"' and session='"+reo1.getSession()+"' and bank='"+banklist.get(i).toString()+"' group by bank, dep_date order by dep_date";
//                    System.out.println("qr1: "+qr);
//                }
//                else if(reo1.getSession_sem().equals("Both")){
//                    qr="select sum(fee_total) as total,bank,dep_date from (select session,session_sem,sum(fee_total+adjstDraftTtAndFeeTt) as fee_total,"
//                        + "deposit_date as dep_date,subm_bank as bank from sub_feedata group by subm_bank,deposit_date "
//                        + "union select session,session_sem,sum(fine) as fee_total,fine_dep_date as dep_date,bank from latefine_onfeeprocess where "
//                        + "fine<>0 group by bank,fine_dep_date "
//                        + "union select session,session_sem,sum(amount) as fee_total,"+date_field+" as dep_date,processed_in as bank from stud_fee_draft "
//                        + "where status='paid' group by processed_in,"+date_field+" "
//                        + "union select session,session_sem,sum(amount) as fee_total,deposite_date as dep_date,bank_name as bank from "
//                        + "noduesed_student_draft group by bank_name,deposite_date "
//                        + "union select session,session_sem,sum(amount) as fee_total,deposit_date as dep_date,bank from stud_other_inst where "
//                        + "transfered='No' group by bank,deposit_date) as u where dep_date between ? and ? and session=? and bank=? "
//                        + "group by bank, dep_date order by dep_date";
//                    System.out.println("qr2: "+qr);
//                }
                
if(!reo1.getSession_sem().equals("Both")) {
    qr="select sum(fee_total) as total,bank,dep_date from (select session,session_sem,sum(fee_total+adjstDraftTtAndFeeTt) as fee_total,deposit_date as "
       + "dep_date,subm_bank as bank from sub_feedata where deposit_date between '"+date1+"' and '"+date2+"' and session_sem='"+reo1.getSession_sem()+"' "
       + "and session='"+reo1.getSession()+"' and subm_bank='"+banklist.get(i).toString()+"' group by deposit_date "
       + "union select session,session_sem,sum(fine) as fee_total,fine_dep_date as dep_date,bank from latefine_onfeeprocess where fine_dep_date between "
       + "'"+date1+"' and '"+date2+"' and session_sem='"+reo1.getSession_sem()+"' and session='"+reo1.getSession()+"' and bank='"+banklist.get(i).toString()+"' and fine<>0 group by fine_dep_date "
       + "union select session,session_sem,sum(amount) as fee_total,"+date_field+" as dep_date,"+bank_field+" as bank from stud_fee_draft where "
       + "status='paid' and "+date_field+" between '"+date1+"' and '"+date2+"' and session_sem='"+reo1.getSession_sem()+"' and "
       + "session='"+reo1.getSession()+"' and "+bank_field+"='"+banklist.get(i).toString()+"' group by "+date_field+" "    
       + "union select session,session_sem,sum(amount) as fee_total,deposite_date as dep_date,bank_name as bank from noduesed_student_draft where "
       + "deposite_date between '"+date1+"' and '"+date2+"' and session_sem='"+reo1.getSession_sem()+"' and session='"+reo1.getSession()+"' and bank_name='"+banklist.get(i).toString()+"' group by deposite_date "
       + "union select session,session_sem,sum(amount) as fee_total,deposit_date as dep_date,bank from stud_other_inst where transfered='No' and "
       + "deposit_date between '"+date1+"' and '"+date2+"' and session_sem='"+reo1.getSession_sem()+"' and session='"+reo1.getSession()+"' and "
       + "bank='"+banklist.get(i).toString()+"' group by deposit_date) as u group by bank, dep_date order by dep_date";
//                    System.out.println("qr1: "+qr); 
  }
else if(reo1.getSession_sem().equals("Both")){
   qr="select sum(fee_total) as total,bank,dep_date from (select session,session_sem,sum(fee_total+adjstDraftTtAndFeeTt) as fee_total,deposit_date as "
       + "dep_date,subm_bank as bank from sub_feedata where deposit_date between '"+date1+"' and '"+date2+"' and session='"+reo1.getSession()+"' "
       + "and subm_bank='"+banklist.get(i).toString()+"' group by deposit_date "
       + "union select session,session_sem,sum(fine) as fee_total,fine_dep_date as dep_date,bank from latefine_onfeeprocess where fine_dep_date between "
       + "'"+date1+"' and '"+date2+"' and session='"+reo1.getSession()+"' and bank='"+banklist.get(i).toString()+"' and fine<>0 group by fine_dep_date "
       + "union select session,session_sem,sum(amount) as fee_total,"+date_field+" as dep_date,"+bank_field+" as bank from stud_fee_draft where "
       + "status='paid' and "+date_field+" between '"+date1+"' and '"+date2+"' and session='"+reo1.getSession()+"' and "+bank_field+"='"+banklist.get(i).toString()+"' group by "+date_field+" "    
       + "union select session,session_sem,sum(amount) as fee_total,deposite_date as dep_date,bank_name as bank from noduesed_student_draft where "
       + "deposite_date between '"+date1+"' and '"+date2+"' and session='"+reo1.getSession()+"' and bank_name='"+banklist.get(i).toString()+"' group by deposite_date "
       + "union select session,session_sem,sum(amount) as fee_total,deposit_date as dep_date,bank from stud_other_inst where transfered='No' and "
       + "deposit_date between '"+date1+"' and '"+date2+"' and session='"+reo1.getSession()+"' and "
       + "bank='"+banklist.get(i).toString()+"' group by deposit_date) as u group by bank, dep_date order by dep_date";
//                    System.out.println("qr2: "+qr);
}
                
// Another way from query...... by kapil
//                        select sum(fee_total) as total,bank,dep_date from (select session,session_sem,sum(fee_total+adjstDraftTtAndFeeTt) as fee_total,deposit_date 
//as dep_date,subm_bank as bank from sub_feedata where deposit_date between '2014-07-13' and '2014-09-01' and session='2014-2015' and subm_bank='PNB' group by subm_bank,deposit_date union select laf.session,laf.session_sem,sum(laf.fine) as fee_total,laf.fine_dep_date
// as dep_date,laf.bank from latefine_onfeeprocess laf left join sub_feedata suf on laf.stud_id=suf.stud_id where laf.fine<>0 and fine_dep_date between '2014-07-13' and '2014-09-01' and laf.session='2014-2015' and laf.bank='PNB' group by laf.bank,laf.fine_dep_date 
//union select session,session_sem,sum(amount) as fee_total,deposite_date as dep_date,bank_name as bank from stud_fee_draft where status='paid' and deposite_date between '2014-07-13' and '2014-09-01' and session='2014-2015' and bank_name='PNB' group by bank_name,deposite_date) 
//as u group by bank, dep_date order by dep_date.

// System.out.println("qr2: "+qr);           
                pstm=conn.prepareStatement(qr);
//                pstm.setDate(1, date1);
//                pstm.setDate(2, date2);
//                pstm.setString(3, reo1.getSession());
//                pstm.setString(4, banklist.get(i).toString());
//            System.out.println(pstm.);
                rs=pstm.executeQuery();
                while(rs.next())
                {
//                    reo=new ReportsEO();
//                    reo.setAmount(rs.getDouble("total"));
//                    reo.setBank(rs.getString("bank"));
//                    reo.setDate1(rs.getDate("dep_date"));
                    hm1.put(rs.getDate("dep_date"),rs.getDouble("total"));
                } 
            hm.put(banklist.get(i), hm1);
            if(rs!=null){rs.close();}
           }   
         }catch(Exception e){System.out.println("Ex: "+e.getMessage());}
        finally{
            try{
                if(rs!=null){rs.close();}
                if(pstm!=null){pstm.close();}
                if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
        
        return hm;
    }    

public ArrayList otherCollegeStudent(int offset,int noOfRecords,String trans)
{
    Connection con=null;
  ArrayList list=new ArrayList();
  ReportsEO reo=null;
  try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
       try{   
           String qr1="";
           if(trans.equals("Both")){
                qr1="select SQL_CALC_FOUND_ROWS * from stud_other_inst order by transfered,deposit_date desc limit " +offset +"," + noOfRecords;
           }else{
               qr1="select SQL_CALC_FOUND_ROWS * from stud_other_inst where transfered='"+trans+"' order by transfered,deposit_date "
                       + "desc limit " +offset +"," + noOfRecords;
           }
            pstm=con.prepareStatement(qr1);
            rs=pstm.executeQuery();
            while(rs.next())
            {
                reo=new ReportsEO();
                reo.setSession(rs.getString("session"));
                reo.setSession_sem(rs.getString("session_sem"));
                reo.setStud_id(rs.getString("stud_id"));
                reo.setDegree(rs.getString("degree"));
                reo.setSname(rs.getString("sname"));
                reo.setAmount(rs.getDouble("amount"));
                reo.setDate1(rs.getDate("deposit_date"));
                reo.setBank(rs.getString("bank"));
                reo.setNumber(rs.getString("receipt_no"));
                reo.setStatus(rs.getString("transfered"));
                reo.setDate2(rs.getDate("transfered_date"));
                reo.setRwid(rs.getInt("rid"));
                reo.setTransfered_to(rs.getString("transfered_to"));
                list.add(reo);
            }
            
    rs.close();
    rs = pstm.executeQuery("SELECT FOUND_ROWS()");
    if(rs.next())
        this.noOfRecords = rs.getInt(1);
        
     }catch(Exception e){System.out.println("Exc: "+e.getMessage());}
       finally{
      try{
          if(rs!=null){rs.close();}
          if(pstm!=null){pstm.close();} 
          if(con!=null){con.close();}
       }   
      catch(SQLException se){}
     }
    return list;
}

public ReportsEO getOtherCollegeStudent(int rid)
{
    ReportsEO reo=new ReportsEO();
    
    try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=(Connection)dc.Dataconnect();
        }catch(Exception e){}
        
        try{
            String str="select * from stud_other_inst where rid=?";
            pstm=conn.prepareStatement(str);
            pstm.setInt(1, rid);
            rs=pstm.executeQuery();
            if(rs.next())
            {
                reo=new ReportsEO();
                reo.setSession(rs.getString("session"));
                reo.setSession_sem(rs.getString("session_sem"));
                reo.setStud_id(rs.getString("stud_id"));
                reo.setDegree(rs.getString("degree"));
                reo.setSname(rs.getString("sname"));
                reo.setAmount(rs.getDouble("amount"));
                reo.setDate1(rs.getDate("deposit_date"));
                reo.setBank(rs.getString("bank"));
                reo.setNumber(rs.getString("receipt_no"));
                reo.setStatus(rs.getString("transfered"));
                reo.setDate2(rs.getDate("transfered_date"));
                reo.setRwid(rs.getInt("rid"));
                reo.setTransfered_to(rs.getString("transfered_to"));
            }
         }catch(Exception e){System.out.println("kapil "+e.getMessage());}
        finally{
            try
            {
                if(rs!=null){rs.close();}
                if(pstm!=null){pstm.close();}
                if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
        return reo;
  }


public void upOtherCollegeStudent(int rid,String trans_to)
{
    ReportsEO reo=null;
    
    try{
            Dataconnectivity dc=new Dataconnectivity();
            conn=(Connection)dc.Dataconnect();
        }catch(Exception e){}
        
        try{
            String str="update stud_other_inst set transfered_date=?, transfered=?, transfered_to=? where rid=?";
            pstm=conn.prepareStatement(str);
            pstm.setDate(1, new java.sql.Date(new java.util.Date().getTime()));
            pstm.setString(2, "Yes");
            pstm.setString(3, trans_to);
            pstm.setInt(4, rid);
            pstm.executeUpdate();
         }catch(Exception e){System.out.println("kapil "+e.getMessage());}
        finally{
            try
            {
                if(rs!=null){rs.close();}
                if(pstm!=null){pstm.close();}
                if(conn!=null){conn.close();}
            }catch(Exception e){}
        }
  }

public int getNoOfRecords() {
        return noOfRecords;
    }

}
