
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

public class updatefeestr extends Action {
    
            Connection cn=null;
            PreparedStatement pstmt=null;
            Statement stmt1=null;
            Statement stmt=null;
            ResultSet rs=null;
            ResultSet rs1=null;
            
            
    private final static String SUCCESS = "success";
    
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrintWriter out= response.getWriter();
        
        String status=request.getParameter("status");   
       // String sessdate=request.getParameter("session"); 
        
        try{
          DataConnection dc1=new DataConnection();
            cn=(Connection)dc1.Dataconnect();

            }
               catch(Exception e){
             
            }
   
        String qry="Select count(*) as cid from classes ";
             out.println(qry);
             stmt=cn.createStatement();
             rs=stmt.executeQuery(qry);
             rs.next();
             int cid=rs.getInt("cid");
             stmt=null;
             rs=null;
           
          ArrayList cls=new ArrayList();
          ArrayList apr=new ArrayList();
          ArrayList may=new ArrayList();
          ArrayList june=new ArrayList();
          ArrayList july=new ArrayList();
          ArrayList aug=new ArrayList();
          ArrayList sept=new ArrayList();
          ArrayList oct=new ArrayList();
          ArrayList nov=new ArrayList();
          ArrayList dec=new ArrayList();
          ArrayList jan=new ArrayList();
          ArrayList feb=new ArrayList();
          ArrayList mar=new ArrayList();
        
             for(int i=0;i<cid;i++){
          cls.add(request.getParameter("classes"+i));
          apr.add(request.getParameter("april"+i));
          may.add(request.getParameter("may"+i));
          june.add(request.getParameter("june"+i));
          july.add(request.getParameter("july"+i));
          aug.add(request.getParameter("august"+i));
          sept.add(request.getParameter("sep"+i));
          oct.add(request.getParameter("oct"+i));
          nov.add(request.getParameter("nov"+i));
          dec.add(request.getParameter("dec"+i));
          jan.add(request.getParameter("jan"+i));
          feb.add(request.getParameter("feb"+i));
          mar.add(request.getParameter("march"+i));
         
            }
    try
    {    
        String del="delete from feestructure  ";
               pstmt=cn.prepareStatement(del);                      
               pstmt.executeUpdate();
       pstmt=null;
       String sq="insert into feestructure(class,April,May,June,July,August,September,October,November,December,January,February,March)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";  
    out.println(sq);
                
     
    for(int m=0;m<cid;m++){         
          
            pstmt=cn.prepareStatement(sq); 
            pstmt.setString(1,cls.get(m).toString()); 
            pstmt.setInt(2,Integer.parseInt(apr.get(m).toString())); 
            pstmt.setInt(3,Integer.parseInt(may.get(m).toString())); 
            pstmt.setInt(4,Integer.parseInt(june.get(m).toString())); 
            pstmt.setInt(5,Integer.parseInt(july.get(m).toString())); 
            pstmt.setInt(6,Integer.parseInt(aug.get(m).toString())); 
            pstmt.setInt(7,Integer.parseInt(sept.get(m).toString())); 
            pstmt.setInt(8,Integer.parseInt(oct.get(m).toString())); 
            pstmt.setInt(9,Integer.parseInt(nov.get(m).toString())); 
            pstmt.setInt(10,Integer.parseInt(dec.get(m).toString())); 
            pstmt.setInt(11,Integer.parseInt(jan.get(m).toString())); 
            pstmt.setInt(12,Integer.parseInt(feb.get(m).toString())); 
            pstmt.setInt(13,Integer.parseInt(mar.get(m).toString())); 
                     
            pstmt.executeUpdate();
       }
            cls.clear();
            apr.clear();
            may.clear();
            june.clear();
            july.clear();
            aug.clear();
            sept.clear();
            oct.clear();
            nov.clear();
            dec.clear();
            jan.clear();
            feb.clear();
            mar.clear();
          String msg=new String("Fee Structure is Updated");

                       request.setAttribute("msg",msg);
                       RequestDispatcher  rd1  =request.getRequestDispatcher("/dfst.do?dispfee=dispfee"); 
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
             if(stmt1!=null)
             {stmt1.close();}
             if(pstmt!=null)
             {pstmt.close();}
             if(cn!=null)
             {cn.close();}   
           }catch(SQLException e){}  
    
        return mapping.findForward("");
        
    }
}
