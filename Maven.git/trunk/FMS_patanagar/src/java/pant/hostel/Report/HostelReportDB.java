/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pant.hostel.Report;

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
public class HostelReportDB {
    Connection con=null;
    PreparedStatement ps=null; 
    PreparedStatement ps1=null;
    ResultSet rs=null;
    ResultSet rs1=null;
    ResultSet rs2=null;
    private int noOfRecords;
    
    public int getNoOfRecords() {
        return noOfRecords;
    }

    public ArrayList foodBillReport(String session,String month, String hostel_code, int offset, int noOfRecords){
        ArrayList list=new ArrayList();
       SchoolEO seo;
       HostelBean hb;
        try{
            Dataconnectivity dc=new Dataconnectivity();
            con=(Connection)dc.Dataconnect();
        }catch(Exception e){}
        try{
            String qr="";
            if(month.equals("ALL")&&hostel_code.equals("ALL")){
                qr="select SQL_CALC_FOUND_ROWS mf.food_amount,mf.month,mf.stud_id,mf.session,mf.bill_gen_date,mf.batch,st.studname,st.degree,st.hostel_code,"
                        + "hst.hostel_name from monthly_food mf left join studentregis st on mf.stud_id=st.stud_id left join hostel hst on "
                        + "st.hostel_code=hst.code where mf.session='"+session+"' limit " +offset +"," + noOfRecords;
            }
            else if(month.equals("ALL")){
                qr="select SQL_CALC_FOUND_ROWS mf.food_amount,mf.month,mf.stud_id,mf.session,mf.bill_gen_date,mf.batch,st.studname,st.degree,st.hostel_code,"
                        + "hst.hostel_name from monthly_food mf left join studentregis st on mf.stud_id=st.stud_id left join hostel hst on "
                        + "st.hostel_code=hst.code where mf.session='"+session+"' and st.hostel_code='"+hostel_code+"' limit " +offset +"," + noOfRecords;
            }
            else if(hostel_code.equals("ALL")){
                qr="select SQL_CALC_FOUND_ROWS mf.food_amount,mf.month,mf.stud_id,mf.session,mf.bill_gen_date,mf.batch,st.studname,st.degree,st.hostel_code,"
                        + "hst.hostel_name from monthly_food mf left join studentregis st on mf.stud_id=st.stud_id left join hostel hst on "
                        + "st.hostel_code=hst.code where mf.session='"+session+"' and mf.month='"+month+"' limit " +offset +"," + noOfRecords;
            }
            else{
                qr="select SQL_CALC_FOUND_ROWS mf.food_amount,mf.month,mf.stud_id,mf.session,mf.bill_gen_date,mf.batch,st.studname,st.degree,st.hostel_code,"
                        + "hst.hostel_name from monthly_food mf left join studentregis st on mf.stud_id=st.stud_id left join hostel hst on "
                        + "st.hostel_code=hst.code where mf.session='"+session+"' and st.hostel_code='"+hostel_code+"' and mf.month='"+month+"' limit " +offset +"," + noOfRecords;
            }
            //System.out.println("query: "+qr);
            ps=con.prepareStatement(qr);
            rs=ps.executeQuery();
            while(rs.next()){
                seo=new SchoolEO();
                seo.setSession(rs.getString("session"));
                seo.setStud_id(rs.getString("stud_id"));
                seo.setSname(rs.getString("studname"));
                seo.setBatch(rs.getString("batch"));
                seo.setDegree(rs.getString("degree"));
                seo.setMonth(rs.getString("month"));
                seo.setMonthlyFood(rs.getDouble("food_amount"));
                seo.setDate(rs.getDate("bill_gen_date"));
                
                hb=new HostelBean();
                hb.setHostelCode(rs.getString("hostel_code"));
                hb.setHostelName(rs.getString("hostel_name"));
                seo.setHostelBean(hb);
                
                list.add(seo);
            }
            rs.close();
            rs = ps.executeQuery("SELECT FOUND_ROWS()");
            if(rs.next())
                this.noOfRecords = rs.getInt(1); 
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
