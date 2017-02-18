

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

public class DispTransFeeRecord extends Action {
    
    Connection cn=null;
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
    int amount=0;
    int fine=0;
    
    private final static String SUCCESS = "success";
    
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
         SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
         SimpleDateFormat sdf1=new SimpleDateFormat("MMMMMMMMMMMM");
         datediff dd=new datediff();    
          
          PrintWriter out= response.getWriter();
          EO.SchoolEO gt=new EO.SchoolEO();
          ArrayList arr=new ArrayList();
          HashSet hs=new HashSet();   
        
          try
       {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
  
 /******************************Displaying Detail of fees *************************/
        try
        {
           String srnum=request.getParameter("srnum"); out.println(srnum);
           String Syear=request.getParameter("Syear");    out.println(Syear);
           String Eyear=request.getParameter("Eyear");    out.println(Eyear);

       String ss="Select sesdate from oldstudregis where (Syear='"+Syear+"' or Eyear='"+Syear+"') and srnum='"+srnum+"'";
           out.println("ss"+ss); 
             stmt3=cn.createStatement();
             rs3=stmt3.executeQuery(ss);
          rs3.next();
          sesdate=(String)rs3.getString("sesdate");   
          rs3=null;
          stmt3=null;
          
       String qry="Select todate,srnum,studentname,class,Syear,Eyear from transfeerecord where (Syear='"+Syear+"' or Eyear='"+Syear+"') and srnum='"+srnum+"' and feestatus='paid' order by rowid desc";
         
             stmt3=cn.createStatement();
             rs3=stmt3.executeQuery(qry);
             if(rs3.next()==false)
             {
                 String sub=new String(""+srnum+" Scholars number does not exist");
                 request.setAttribute("sub",sub);
                 RequestDispatcher  rd1  =request.getRequestDispatcher("/fee/dispfeerecord.jsp"); 
                 rd1.forward(request,response);  
             }
             else
             {
          
          todate=(String)rs3.getString("todate"); 
          gt.setSrnum(rs3.getString("srnum"));
          gt.setSname(rs3.getString("studentname"));
          gt.setClasses(rs3.getString("class"));
          gt.setSyear(rs3.getString("Syear"));
          gt.setEyear(rs3.getString("Eyear"));
          
          arr.add(gt);
          
          String sm="select sum(amountpaid)as amount from transfeerecord where (Syear='"+Syear+"' or Eyear='"+Syear+"') and srnum='"+srnum+"' and feestatus='paid'";
            
            pstmt=cn.prepareStatement(sm);
            rs=pstmt.executeQuery();
            rs.next();
            
             amount=rs.getInt("amount");
               
           
           java.util.Date dt1=sdf.parse(sesdate);
           java.util.Date dt2=sdf.parse(todate);
           ArrayList dd1=new ArrayList();
           dd1=(ArrayList)dd.getDatesBetween(dt1,dt2);
           for(int i=0;i<dd1.size();i++){
           java.util.Date dt=(java.util.Date)dd1.get(i);    
           st=sdf1.format(dt);           
           hs.add(st);
           }              
//             Iterator ir=(Iterator)hs.iterator(); 
//             while(ir.hasNext()){
//             out.println(st);
           //}
             
       }     
/***********************************Forwarding Data*****************************************/    
          request.setAttribute("arr",arr);
          request.setAttribute("amount",new Integer(amount));
           request.setAttribute("hs",hs);
             
           
            
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
