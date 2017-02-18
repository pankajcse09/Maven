
package AO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import com.myapp.struts.DataConnection;
import java.util.*;
import AO.datediff.*;
import EO.SchoolEO;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.text.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.lang.NullPointerException;
import java.text.SimpleDateFormat;


/**
 *
 * @author Sonal
 * @version
 */

public class ChkFeeClassWise extends Action {
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    
        Connection cn=null; 
        PreparedStatement pstmt=null;
        Statement stmt=null;
        Statement stmt1=null;
        Statement stmt2=null;
        ResultSet rs=null;
        ResultSet rs1=null;
        ResultSet rs2=null;
        String Syear="";
        Date ed=null;
        String regisnum="";
           
        ArrayList arr=new ArrayList();

  public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrintWriter out= response.getWriter();
        HttpSession session=request.getSession();
             
        SimpleDateFormat sd=new SimpleDateFormat("dd/MM/yyyy");         
        Date udate=new Date();    
        String st=sd.format(udate); 
         Date ud=sd.parse(st);  out.println("ud"+ud);
      //   Date dd=ud.getDate();
        String todate;
          SchoolEO seo=null;
        ArrayList arr=new ArrayList(); 
    
          try
          {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
         String cls=request.getParameter("cls");
         String dispcls=request.getParameter("dispcls");
         
         if(dispcls!=null)
         {
      
      try
       {
               
         String sql1="select year(current_date) as year";
         stmt=cn.createStatement();
         rs=stmt.executeQuery(sql1);
         rs.next();
          Syear=(String)rs.getString("year");   
          stmt=null;
          rs=null;
         
           
            String qry="select regisnum from feerecord WHERE class='"+cls+"' and (Syear='"+Syear+"' or Eyear='"+Syear+"')order by todate desc ";
          out.println(qry);
           stmt2=cn.createStatement();
           rs2=stmt2.executeQuery(qry);
           while(rs2.next())
           {
               regisnum=rs2.getString("regisnum"); out.println(regisnum);
          
           String sql="select todate from feerecord WHERE regisnum='"+regisnum+"' ";
           out.println(sql);
           stmt=cn.createStatement();
           rs=stmt.executeQuery(sql);
           rs.next();
           
            ed=sd.parse(rs.getString("todate"));    out.println("ed"+ed);
            if((ed.before(ud)))
            {
           String sqly="select regisnum,studentname,status,class,section,todate from feerecord where regisnum='"+regisnum+"' order by todate desc";
           out.println("sqly"+sqly);
           stmt1=cn.createStatement();
           rs1=stmt1.executeQuery(sqly);
           rs1.next();
           
               seo=new SchoolEO();
             //   seo.setRegisnum(rs1.getString("regisnum"));
                seo.setSname(rs1.getString("studentname"));
                seo.setStatus(rs1.getString("status"));
                seo.setClasses(rs1.getString("class"));
                seo.setSection(rs1.getString("section"));
                seo.setTodate(rs1.getString("todate"));
               
                arr.add(seo);
                out.println(arr);
        
           request.setAttribute("arr",arr);
            
            }
             else
                   
               {
                out.println("hello");
//                    RequestDispatcher  rd =request.getRequestDispatcher("/chkfeeclasswise.jsp"); 
//                    rd.forward(request,response); 
//                  
               }
          
           }
          
               
               
      }catch(SQLException e)
      {}
         }
      
      
        return mapping.findForward("success");
        
    }
}
