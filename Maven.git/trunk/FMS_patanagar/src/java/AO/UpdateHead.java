package AO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import java.text.SimpleDateFormat;
import com.myapp.struts.DataConnection;
import java.sql.*;
import java.util.*;
import EO.SchoolEO;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
/**
 *
 * @author sonal
 * @version
 */

public class UpdateHead extends Action {
    
           
            Statement stmt1=null;
            Statement stmt=null;
            ResultSet rs=null;
            ResultSet rs1=null;
            
            
    private final static String SUCCESS = "success";
    
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         Connection cn=null;
          
        PrintWriter out= response.getWriter();
        
        try{
          DataConnection dc1=new DataConnection();
            cn=(Connection)dc1.Dataconnect();

            }
               catch(Exception e){
             
            }
   
      
        String head=request.getParameter("heads"); 
        String htype=request.getParameter("head_type"); 
        String hac=request.getParameter("head_ac"); 
        int rowid=Integer.parseInt(request.getParameter("rowid")); 
     
         try{         
         String sql1="update feeheads set heads='"+head+"',head_type='"+htype+"',head_ac='"+hac+"' where rowid='"+rowid+"'";
        
         stmt1=cn.createStatement();
         stmt1.executeUpdate(sql1);
         
           String mess=("Head "+head+" is Updated!");
           request.setAttribute("mess",mess);
          
           RequestDispatcher rd=request.getRequestDispatcher("/DynamicFees/DisplayHeads.jsp");
           rd.forward(request,response);
           }catch(SQLException e){out.println("error");}           
            try{
            if(rs!=null)
             {rs.close();}
            if(rs1!=null)
             {rs1.close();}
            if(stmt!=null)
             {stmt.close();}
            if(stmt1!=null)
             {stmt1.close();}
            if(cn!=null)
             {cn.close();}
           }catch(SQLException e){}
            
        return mapping.findForward(SUCCESS);
        
    }
}
