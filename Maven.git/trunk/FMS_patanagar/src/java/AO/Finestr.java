
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
import EO.SchoolEO;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
/**
 *
 * @author sonal
 * @version
 */

public class Finestr extends Action {
    
   Connection cn=null;
    PreparedStatement pstmt1=null;
    PreparedStatement pstmt=null;
    Statement stmt=null;
    Statement stmt1=null;
    Statement stmt2=null;
    ResultSet rs1=null;
    ResultSet rs2=null;
    ResultSet rs=null;
    String lastdate="";
    int infine=0;
    int extfine=0;
    int empkidfine=0;
    String lsdate="";
    int cnt=0;
    int i=0;
   

       
    private final static String SUCCESS = "success";
    
  
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
      
         PrintWriter out= response.getWriter();
         
/********************************* Display Fine Structure ****************************************/         
         
         ArrayList arr=new ArrayList();
         
       
      try{        
            DataConnection dc1=new DataConnection();
            cn=(Connection)dc1.Dataconnect();
      }
      catch(Exception e){}
       
          String dispfine=request.getParameter("dispfine");  out.println("dispfine");
          if(dispfine!=null)
          {
              try
       {
        
            String qr="Select lastdate from finestructure";
             stmt=cn.createStatement();
             rs=stmt.executeQuery(qr);
             
             rs.next();
             String lsdate=rs.getString("lastdate");  out.println(lsdate);
              

              
             if(lsdate!=null)
             {
             String qry="Select * from finestructure";
             stmt1=cn.createStatement();
             rs1=stmt1.executeQuery(qry);
             
             while(rs1.next())
             {
                SchoolEO seo=new SchoolEO();
                seo.setLastdate(rs1.getString("lastdate"));
                 seo.setFine(rs1.getInt("fine"));
                arr.add(seo);
                 
             }
                 
                  request.setAttribute("array",arr);
                 // request.setAttribute("sesdate",sesdate);
             }
        
              
          }catch(SQLException e)
          {e.printStackTrace();}
               return mapping.findForward("success");   
              }   
          
/********************************* Insert Fine Structure ****************************************/
     
      try{        
            DataConnection dc1=new DataConnection();
            cn=(Connection)dc1.Dataconnect();
      }
      catch(Exception e){}
        
       
       String updatefine=request.getParameter("updatefine");
       
       if(updatefine!=null)
       {
           
         String qr="Select lastdate from finestructure";
             stmt2=cn.createStatement();
             rs2=stmt2.executeQuery(qr);
             
             while(rs2.next())
             {     
             cnt=0;
                       
          
              lsdate=rs2.getString("lastdate");   
              
             if(lsdate!=null)
             { 
       
           String mess=new String("Fine Structure is already defined you can update the record");

                       request.setAttribute("mess",mess);
                       RequestDispatcher  rd1  =request.getRequestDispatcher("finestr.do?dispfine=dispfine"); 
                       rd1.forward(request,response);    
            
          cnt=1;
                     break; 

         }

        }

         if(cnt==0)
         {     
                 try
          {
                lastdate=request.getParameter("lastdate");
                 int fine=Integer.parseInt(request.getParameter("fine").toString());

                 
   String sq="insert into finestructure(lastdate,fine)values(?,?)";  
 
            pstmt=cn.prepareStatement(sq); 
            pstmt.setString(1,lastdate); 
            pstmt.setInt(2,fine);          
            pstmt.executeUpdate();
   
            
          String mess=new String("Fine Structure is defined");

                       request.setAttribute("mess",mess);
                       RequestDispatcher  rd1  =request.getRequestDispatcher("/fee/FineStructure.jsp"); 
                       rd1.forward(request,response);          
             
         }

       
       
        catch(SQLException e)
        {
         out.println(e.getMessage());
        }
        }
      
       }    
    
    try
           {
             if(rs!=null)
             {rs.close();}
              if(rs1!=null)
             {rs1.close();}
             if(rs2!=null)
             {rs2.close();}
             if(stmt!=null)
             {stmt.close();}
             if(stmt1!=null)
             {stmt1.close();}
             if(stmt2!=null)
             {stmt2.close();}
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