package schedule;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import com.myapp.struts.Dataconnectivity;
import java.sql.SQLException;

public class Add_Degree extends HttpServlet {
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    
    Connection con=null;
    PreparedStatement psmt=null;
    PreparedStatement psmt1=null;
    PreparedStatement psmt2=null;
    ResultSet rs=null;
   ResultSet rs1=null;
    ResultSet rs2=null;
   
    public  void doPost(HttpServletRequest req,HttpServletResponse res)
    throws ServletException, IOException {
         res.setContentType("text/html;charset=UTF-8");
         PrintWriter out = res.getWriter();
         int count=0; 
         String msg="";
         String dname=(String)req.getParameter("degree");
         String alias=(String)req.getParameter("alias");
         String nos=(String)req.getParameter("nos");                 
                   try{
         Dataconnectivity dc=new Dataconnectivity();
         con=(Connection)dc.Dataconnect();
    }
       catch(Exception e)
       {
       out.println("Database Connection Problem");
       }
         
   String qr1="select count(deg_name) as cnt from degree_details where deg_name='"+dname+"'"; 
         try{
 psmt2=con.prepareStatement(qr1);
 rs2=psmt2.executeQuery();
 while(rs2.next()){  
   count=rs2.getInt("cnt");    
 } 
 if(count>0){
   msg="Degree Already Exists";
   out.println(msg);
   req.setAttribute("mms",msg);    
 }
  else  
      {
             String st="select adddegseq.nextval as rn from dual";
             PreparedStatement psmt1=con.prepareStatement(st);
             ResultSet rs1=psmt1.executeQuery();
             rs1.next();
             String rseq=rs1.getString("rn");
             String insert_course="";            
             insert_course="insert into degree_details(deg_name,alias,no_sem,rno)values(?,?,?,?)";
             psmt=con.prepareStatement(insert_course);
             psmt.setString(1,dname);
             psmt.setString(2,alias);
             psmt.setString(3,nos);
             psmt.setString(4,rseq);
             psmt.executeUpdate();                   
           
             msg="Degree has been Added Successfully"; 
             req.setAttribute("mms",msg);              
             }
          RequestDispatcher rd=req.getRequestDispatcher("/AddDegree.jsp");
           rd.forward(req,res);          
         }
        catch(SQLException e)
        {        
       out.println(e.getMessage());
        } 
         finally{             
             try{
               if(rs1!=null){rs1.close();}
               if(rs!=null){rs.close();}
               if(psmt1!=null){psmt1.close();}
               if(psmt!=null){psmt.close();}
               if(con!=null){con.close();}               
             }
             catch(SQLException se){
                 out.println(se.getMessage());
             }
         }          
    
    }
}
