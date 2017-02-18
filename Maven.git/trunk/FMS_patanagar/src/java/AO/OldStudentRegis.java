
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
import java.io.PrintWriter;
import EO.SchoolEO;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.lang.NullPointerException;
/**
 *
 * @author sonal
 * @version
 */

public class OldStudentRegis extends Action {
    
    Connection cn=null;
    PreparedStatement pstmt1=null;
    PreparedStatement pstmt=null;
    ResultSet rs1=null;
    Statement stmt=null;
    ResultSet rs=null;
    int count=0;
        
    private final static String SUCCESS = "success";
    
  
    
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
          PrintWriter out= response.getWriter();
          SchoolEO seo=new SchoolEO();
          DynaActionForm df=(DynaActionForm)form;
         ArrayList arr=new ArrayList();
         
 /*******************************Displaying student record*******************************/
         
         String disprec=request.getParameter("disprec");  out.println(disprec);
         if(disprec!=null)
         {
       
       try{
        
            DataConnection dc1=new DataConnection();
            cn=(Connection)dc1.Dataconnect();
            
             String regisnum=(String)request.getParameter("regisnumber");  out.println(regisnum);
              regisnum=regisnum.trim();
//                
//                String Syear=(String) request.getParameter("Syear"); 
//                String Eyear=(String)request.getParameter("Eyear"); 
//                String sesdate=(String)request.getParameter("sesdate"); 
             
            String sql="select regisnum,studname,classes,status,gender,dob,fname,mname,address,rphone,mobile,fax,section from oldstudregis where regisnum='"+regisnum+"' order by sesdate desc";
            out.println(sql);
            stmt=cn.createStatement();
            rs=stmt.executeQuery(sql);

//            if(rs.next()==false)
//            {
//                String sub=new String(""+regisnum+" does not exist");
//
//                  request.setAttribute("sub",sub);
//                  RequestDispatcher  rd1  =request.getRequestDispatcher("/OldStudRegis.jsp"); 
//                  rd1.forward(request,response);  
//            }
//            else
//            {
            rs.next();
                 //  seo.setRegisnum(rs.getString("regisnum"));
                   seo.setSname(rs.getString("studname"));
                   seo.setClasses(rs.getString("classes"));
                   seo.setStatus(rs.getString("status"));
                   seo.setGender(rs.getString("gender"));
                   seo.setDob(rs.getString("dob"));
                   seo.setFname(rs.getString("fname"));
                   seo.setMname(rs.getString("mname"));
                   seo.setAddress(rs.getString("address"));
                   seo.setRnum(rs.getString("rphone"));
                   seo.setMobile(rs.getString("mobile"));
                   seo.setFax(rs.getString("fax"));
                   seo.setSection(rs.getString("section"));
               arr.add(seo);  
               out.println(arr);
//            }     
              request.setAttribute("arr",arr);
       
         }catch(SQLException e)
         {e.printStackTrace();}
        
        return mapping.findForward("success");
     }
         
/*******************************Insert into oldregis*********************************/
         
     String insrec=request.getParameter("insrec");
     if(insrec!=null)
     {
         
        String regisnum=request.getParameter("regisnum"); out.println(regisnum);
              regisnum=regisnum.trim();
        String Syear=(String)request.getParameter("Syear"); 
        String Eyear=(String)request.getParameter("Eyear"); 
        String sesdate=(String)request.getParameter("sesdate"); 
        String section=(String)request.getParameter("section"); 
     try
     {
        String sql="select regisnum,Syear,Eyear from oldstudregis where Syear='"+Syear+"' and Eyear='"+Eyear+"'";

            stmt=cn.createStatement();
            rs=stmt.executeQuery(sql);

             while(rs.next())
             {     
             count=0;
              
                   
                   String rnum=(String)rs.getString("regisnum");
                   rnum=rnum.trim();
                   String Syr=rs.getString("Syear");
                   String Eyr=rs.getString("Eyear");
                 
                if(rnum.equals(regisnum) && Syr.equals(Syear) && Eyr.equals(Eyear))
                    {
                       String existnum=new String(" "+regisnum+" Registration Number already exist");

                       request.setAttribute("existnum",existnum);
                       RequestDispatcher  rd1  =request.getRequestDispatcher("/fee/OldStudRegis.jsp"); 
                       rd1.forward(request,response); 

                    count=1;
                     break; 

                  }
            }

         if(count==0)
         {     

            String sql1="insert into oldstudregis(regisnum,studname,gender,dob,fname,mname,address,rphone,mobile,fax,status,classes,Syear,Eyear,sesdate,section)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
             out.println(sql1);
            pstmt=cn.prepareStatement(sql1); 
            pstmt.setString(1,(String)df.get("regisnum"));
            pstmt.setString(2,(String)df.get("sname"));
            pstmt.setString(3,(String)df.get("gender"));
            pstmt.setString(4,(String)df.get("dob"));
            pstmt.setString(5,(String)df.get("fname"));
            pstmt.setString(6,(String)df.get("mname"));
            pstmt.setString(7,(String)df.get("address"));
            pstmt.setString(8,(String)df.get("rnum"));
            pstmt.setString(9,(String)df.get("mobile"));
            pstmt.setString(10,(String)df.get("fax"));
            pstmt.setString(11,(String)df.get("status"));
            pstmt.setString(12,(String)df.get("classes"));
            pstmt.setString(13,Syear);
            pstmt.setString(14,Eyear);
            pstmt.setString(15,sesdate);
            pstmt.setString(16,section);
           
          
          pstmt.executeUpdate();
         
          String msg=new String(" "+df.get("regisnum")+" is Registered");

                       request.setAttribute("msg",msg);
                       RequestDispatcher  rd1  =request.getRequestDispatcher("/fee/OldStudRegis.jsp"); 
                       rd1.forward(request,response); 
             }
            
        }
        catch(SQLException e)
        {out.println(e.getMessage());}
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
  