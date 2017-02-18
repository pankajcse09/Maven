
package AO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import com.myapp.struts.DataConnection;
import java.sql.*;
import java.util.*;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
/**
 *
 * @author sonal
 * @version
 */

public class FeeStr extends Action {
    
   Connection cn=null;
    PreparedStatement pstmt1=null;
    PreparedStatement pstmt=null;
    ResultSet rs1=null;
    Statement stmt=null;
    ResultSet rs=null;
    int count=0;
    int i=0;
    String cls1="";
    String in1="";
    String ext1="";
    String emp1="";
    
    private final static String SUCCESS = "success";
    
   
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         PrintWriter out= response.getWriter();
          ArrayList cls=new ArrayList();
          ArrayList in=new ArrayList();
          ArrayList ext=new ArrayList();
          ArrayList emp=new ArrayList();
        
         
            for(int i=0;i<14;i++){
          cls.add(request.getParameter("classes"+i));
          in.add(request.getParameter("infee"+i));
          ext.add(request.getParameter("extfee"+i));
          emp.add(request.getParameter("empkidfee"+i));
         
          }
       
      try{        
            DataConnection dc1=new DataConnection();
            cn=(Connection)dc1.Dataconnect();
      }
      catch(Exception e){}
          out.println(cn);
           String sq="insert into feestructure(class,internalfee,externalfee,empkidfee)values(?,?,?,?)";  
    out.println(sq);
    try{                 
     
    for(int m=0;m<cls.size();m++){         
          
            pstmt=cn.prepareStatement(sq); 
            pstmt.setString(1,cls.get(m).toString()); 
            pstmt.setString(2,in.get(m).toString());
            pstmt.setString(3,ext.get(m).toString());
            pstmt.setString(4,emp.get(m).toString());
            
            pstmt.executeUpdate();
    }
           
            
          String msg=new String("Fee Structure is defined");

                       request.setAttribute("msg",msg);
                       RequestDispatcher  rd1  =request.getRequestDispatcher("/fee/FeeStructure.jsp"); 
                       rd1.forward(request,response);          
             
           }
        catch(SQLException e)
        {
         out.println(e.getMessage());
        } 
    
          try
           {
              if(rs!=null)
             {rs.close();}
              if(rs1!=null)
             {rs1.close();}
             if(stmt!=null)
             {stmt.close();}
              if(pstmt!=null)
             {pstmt.close();}
             if(pstmt1!=null)
             {pstmt1.close();}
             if(cn!=null)
             {
                 cn.close();
             }
           }catch(SQLException e){}
    
   return mapping.findForward("success");   
   
}
    
    }