

package AO;
import java.util.*;
import java.sql.*;
import com.myapp.struts.DataConnection;
import EO.SchoolEO; 
/**
 *
 * @author Sonal
 */
public class Report {
    
    /** Creates a new instance of Report */
    public Report() {
    }
    
    
    
   public ArrayList data(String snno,String syear, String eyear, String month)
   {
       
       
       ArrayList aa= new ArrayList();
       //ArrayList aa= new ArrayList();
       Connection cn=null;
       Statement stmt3=null;
       ResultSet rs3=null;
       
            try
       {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
     
     String qry="select * from feedetailreport where srnum="+snno+" and syear="+syear+" and eyear="+eyear+" and month='"+month+"'";
      System.out.println(qry);
     
     try {
         EO.SchoolEO gt=null;
            stmt3=cn.createStatement();
            rs3=stmt3.executeQuery(qry);  
            while(rs3.next()){
               gt= new SchoolEO(); 
               gt.setMonth(rs3.getString("month"));
               gt.setAmountpaid(rs3.getInt("amount"));
               gt.setFeesubdate(rs3.getString("fsubdate"));
               gt.setSname(rs3.getString("sname"));   
                aa.add(gt);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }  
     
     
       return aa;
   }
    
    
   
   
   public ArrayList sn()
   {
  
       
       
       
   return new ArrayList();
   }
   
   
//    public static void main(String aa[])
//    {
//        Report rr= new Report();
//       ArrayList aa1= rr.data("1235","2009","2010","July");
//       for(int i=0;i<aa1.size();i++)
//       {
//           SchoolEO pp=(SchoolEO)aa1.get(i);
//           
//           System.out.println(pp.getAmountpaid());
//       }
       
        
        
    }

