
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

public class AssignFeeBook extends Action {
    
    Connection cn=null;
    Statement stmt3=null;
    Statement stmt=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    ResultSet rs3=null;
   
    
    private final static String SUCCESS = "success";
    
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
          PrintWriter out= response.getWriter();
          EO.SchoolEO gt=null;
          ArrayList arr=new ArrayList();
         
        
          try
       {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
  
 /******************************Displaying Employee Profile *************************/
          String disp=request.getParameter("display");           
          if(disp!=null)
          {
        try
        {
           String classes=request.getParameter("classes");
           String section=request.getParameter("section"); 
           String syear=request.getParameter("syear"); 
           String eyear=request.getParameter("eyear"); 
          
   String qry="Select srnum,sname,classes,section,route,syear,eyear from studacaddetail where classes='"+classes+"' and section='"+section+"' and syear='"+syear+"' and eyear='"+eyear+"'";

             stmt3=cn.createStatement();
             rs3=stmt3.executeQuery(qry);
//             if(rs3.next()==false)
//             {
//                 String sub=new String("detail is not available for "+syear+"-"+eyear+" session");
//                 request.setAttribute("sub",sub);
//                 RequestDispatcher  rd1  =request.getRequestDispatcher("/assignfeebook.jsp"); 
//                 rd1.forward(request,response);  
//             }
//             else
//             {
     while(rs3.next())
     {
         gt=new EO.SchoolEO();
          gt.setSname(rs3.getString("sname"));
          gt.setSrnum(rs3.getString("srnum"));
          gt.setClasses(rs3.getString("classes"));
          gt.setSection(rs3.getString("section"));
          gt.setRoute(rs3.getString("route"));
          gt.setSyear(rs3.getString("syear"));
          gt.setEyear(rs3.getString("eyear"));
          
          arr.add(gt);
     
             }
          //   }
        request.setAttribute("arr",arr);
        }catch(SQLException ee)
        {
            ee.getStackTrace();
         }    
        
         return mapping.findForward("success");
          }   
/******************************Displaying Employee Profile *************************/
          
          try
          {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
          String update=request.getParameter("uprofile");
      
          try
          {
          
          if(update!=null)
          {  
            String classes=request.getParameter("classes");
            String section=request.getParameter("section"); 
            String syear=request.getParameter("syear");
            String eyear=request.getParameter("eyear"); 
            
            String qry = "Select count(*) as cid from studacaddetail where classes='"+classes+"' and section='"+section+"'";
          
            stmt = cn.createStatement();
            rs = stmt.executeQuery(qry);
            rs.next();
            int cid = rs.getInt("cid");
            stmt = null;
            rs = null;
            ArrayList sr = new ArrayList();
            ArrayList cls = new ArrayList();
            ArrayList sec = new ArrayList();
            ArrayList sfb = new ArrayList();
            ArrayList tfb = new ArrayList();
           
             for(int i = 0; i < cid; i++)
            {
                sr.add(request.getParameter("srnum" + i));
                cls.add(request.getParameter("classes" + i));
                sec.add(request.getParameter("section" + i));
                sfb.add(request.getParameter("sfbnum" + i));
                tfb.add(request.getParameter("tfbnum" + i));
                             
            }
                for(int m = 0; m < cid; m++)
                {   
           String sql1="update studacaddetail set feebooknum='"+(sfb.get(m))+"',transfeebook='"+(tfb.get(m))+"'where srnum='"+(sr.get(m))+"' and classes='"+(cls.get(m))+"' and section='"+(sec.get(m))+"' and syear='"+syear+"' and eyear='"+eyear+"' ";
         
         
          pstmt=cn.prepareStatement(sql1);
          pstmt.executeUpdate(); 
          pstmt=null;
           String sql2="update oldstudregis set sfeebook='"+(sfb.get(m))+"',tfeebook='"+(tfb.get(m))+"'where srnum='"+(sr.get(m))+"' and classes='"+(cls.get(m))+"' and syear='"+syear+"' and eyear='"+eyear+"' ";
       
          pstmt=cn.prepareStatement(sql2);
          pstmt.executeUpdate(); 
          pstmt=null;
                }
         
        sr.clear();
        cls.clear();
        sec.clear();
        sfb.clear();
        tfb.clear();
                 String sub=new String(""+classes+""+section+" book number is entered");
                 request.setAttribute("sub",sub);
      RequestDispatcher rd2 =request.getRequestDispatcher("/fee/assignfeebook.jsp"); 
      rd2.forward(request,response); 
          }
     
           }catch(Exception p)
          {p.printStackTrace();}
          
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
