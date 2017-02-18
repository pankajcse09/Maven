

package AO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import com.myapp.struts.DataConnection;
import java.sql.*;
import java.util.*;
import AO.datediff.*;
import EO.SchoolEO;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.lang.NullPointerException;
import java.text.SimpleDateFormat;
/**
 *
 * @author sonal
 * @version
 */

public class DispFeeRecord extends Action {
    
  
    Statement stmt3=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    ResultSet rs3=null;
    
    String Syear="";
    String status="";
    String sesdate="";
    String studname="";
    String classes="";
    String todate="";
    String st="";
    double amount=0.0;
    double fine=0.0;
    
    private final static String SUCCESS = "success";
    
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         Connection cn=null;
         SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
         SimpleDateFormat sdf1=new SimpleDateFormat("MMMMMMMMMMMM");
         datediff dd=new datediff();    
          
          PrintWriter out= response.getWriter();
          EO.SchoolEO gt=new EO.SchoolEO();
          ArrayList arr=new ArrayList();
          ArrayList mon=new ArrayList();
         // HashSet hs=new HashSet();   
        
          try
       {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
  
 /******************************Displaying Detail of fees *************************/
        try
        {
           String srnum=request.getParameter("srnum"); 
           String Syear=request.getParameter("Syear");   
           String Eyear=request.getParameter("Eyear");    

       String ss="Select sesdate from oldstudregis where (Syear='"+Syear+"' or Eyear='"+Syear+"') and srnum='"+srnum+"'";
           out.println("ss"+ss); 
             stmt3=cn.createStatement();
             rs3=stmt3.executeQuery(ss);
          rs3.next();
          sesdate=(String)rs3.getString("sesdate");  
         
          
       String qry="Select todate,srnum,studentname,class,section,Syear,Eyear from feerecord where (Syear='"+Syear+"' or Eyear='"+Syear+"') and srnum='"+srnum+"' and feestatus='paid' order by rowid desc";
        out.println("qry"+qry);   
            Statement stmt4=cn.createStatement();
            ResultSet rs4=stmt4.executeQuery(qry);
             if(rs4.next()==false)
             {
                 String sub=new String(""+srnum+" Registration number does not exist");
                 request.setAttribute("sub",sub);
                 RequestDispatcher  rd1  =request.getRequestDispatcher("/fee/dispfeerecord.jsp"); 
                 rd1.forward(request,response);  
             }
             else
             {
          
          todate=(String)rs4.getString("todate"); 
          gt.setSrnum(rs4.getString("srnum"));
          gt.setSname(rs4.getString("studentname"));
          gt.setClasses(rs4.getString("class"));
          gt.setSyear(rs4.getString("Syear"));
          gt.setEyear(rs4.getString("Eyear"));
          gt.setSection(rs4.getString("section"));
                   
          arr.add(gt);
          out.println("arr"+arr);
          String sm="select sum(amountpaid)as amount ,sum(totfine) as fine from feerecord where (Syear='"+Syear+"' or Eyear='"+Syear+"') and srnum='"+srnum+"' and feestatus='paid'";
            out.println(sm);
            pstmt=cn.prepareStatement(sm);
            rs=pstmt.executeQuery();
            rs.next();
            
             amount=rs.getDouble("amount"); out.println(amount);
             fine=rs.getDouble("fine");  out.println("fine"+fine);
    
           
             SchoolEO seo=null;
      String smg="select month,fsubdate from feedetailreport where (Syear='"+Syear+"' or Eyear='"+Syear+"') and srnum='"+srnum+"'";
        
           PreparedStatement pstmt2=cn.prepareStatement(smg);
            ResultSet rsd=pstmt2.executeQuery();
           while(rsd.next())
           {
            seo=new SchoolEO();
             seo.setMonth(rsd.getString("month"));
             seo.setFeesubdate(rsd.getString("fsubdate"));
            mon.add(seo);
           } 
           
//           java.util.Date dt1=sdf.parse(sesdate); out.println("dt1"+dt1);
//           java.util.Date dt2=sdf.parse(todate);  out.println("dt2"+dt2);
//           ArrayList dd1=new ArrayList();
//           dd1=(ArrayList)dd.getDatesBetween(dt1,dt2);
//           for(int i=0;i<dd1.size();i++){
//           java.util.Date dt=(java.util.Date)dd1.get(i);    
//           st=sdf1.format(dt);           
//           hs.add(st);
//         out.println("fdhgf"+hs); 
  //         }              
//             Iterator ir=(Iterator)hs.iterator(); 
//             while(ir.hasNext()){
//           
//           }
            
       }     
/***********************************Forwarding Data*****************************************/    
          request.setAttribute("arr",arr);
          request.setAttribute("amount",new Double(amount));
          request.setAttribute("fine",new Double(fine));
          request.setAttribute("mon",mon);
          //request.setAttribute("hs",hs);
             
           
            
          }catch(SQLException ee)
          {
          
                ee.getStackTrace();
            }
          
             try
           {
             if(rs!=null)
             {rs.close();}
              if(rs3!=null)
             {rs3.close();}
             if(pstmt!=null)
             {pstmt.close();}
              if(stmt3!=null)
             {stmt3.close();}
              if(cn!=null)
             {
                 cn.close();
             }
           }catch(SQLException e){}
         
                 return mapping.findForward("success");
             
        
    }
}
