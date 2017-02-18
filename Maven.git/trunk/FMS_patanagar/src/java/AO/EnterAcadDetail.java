

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

public class EnterAcadDetail extends Action {
    
    Connection cn=null;
    Statement stmt3=null;
    Statement stmt=null;
    PreparedStatement pstmt=null;
    PreparedStatement pstmt1=null;
    ResultSet rs=null;
    ResultSet rs3=null;
   
    
    private final static String SUCCESS = "success";
    
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
          PrintWriter out= response.getWriter();
          EO.SchoolEO gt=new EO.SchoolEO();
          ArrayList arr=new ArrayList();
         
        
          try
       {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
  
 /******************************Displaying Employee Profile *************************/
          String disp=request.getParameter("display");  out.println(disp);
         
          if(disp!=null)
          {
        try
        {
           String srnum=request.getParameter("srnum"); out.println(srnum);
           String syear=request.getParameter("syear");
           String eyear=request.getParameter("eyear");
          
   String qry="Select st.srnum,st.studname,st.dob,st.doj,st.gender,st.syear,st.eyear,os.classes,os.section from studentregis st inner join oldstudregis os on st.srnum=os.srnum where os.srnum='"+srnum+"' and os.syear='"+syear+"' and os.eyear='"+eyear+"'";
         out.println(qry);
             stmt3=cn.createStatement();
             rs3=stmt3.executeQuery(qry);
             if(rs3.next()==false)
             {
                 String sub=new String(""+srnum+" detail is not available");
                 request.setAttribute("sub",sub);
                 RequestDispatcher  rd1  =request.getRequestDispatcher("/fee/StudAcademicDet.jsp"); 
                 rd1.forward(request,response);  
             }
             else
             {
     
          gt.setSname(rs3.getString("studname"));
          gt.setSrnum(rs3.getString("srnum"));
          gt.setDob(rs3.getString("dob"));
          gt.setDoj(rs3.getString("doj"));
          gt.setGender(rs3.getString("gender"));
          gt.setSyear(rs3.getString("syear"));
          gt.setEyear(rs3.getString("eyear"));
          gt.setClasses(rs3.getString("classes"));
          gt.setSection(rs3.getString("section"));
        
          arr.add(gt);
          out.print(arr);
             }
        request.setAttribute("arr",arr);
        }catch(SQLException ee)
        {
            ee.getStackTrace();
         }    
        
         return mapping.findForward("success");
          }   
/******************************Displaying  Profile *************************/
          
          try
          {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
          String update=request.getParameter("uprofile");out.println(update);
          try
          {
          
          if(update!=null)
          {  out.println("tfg");
             int srnum=Integer.parseInt(request.getParameter("srnum").toString()); 
             String syear=request.getParameter("syear");   
             String eyear=request.getParameter("eyear");  
             String sname=request.getParameter("sname");  
             String dob=request.getParameter("dob");   
             String doj=request.getParameter("doj");
             String gender=request.getParameter("gender");  
             String classes=request.getParameter("classes");  
             String section=request.getParameter("section");  
             String house=request.getParameter("house"); 
             String route=request.getParameter("route");  
             String buscode=request.getParameter("buscode");   
             String tripnum=request.getParameter("tripnum");   
             double concession=Double.parseDouble(request.getParameter("concession").toString());  
             String head=request.getParameter("head");  
             String feebooknum="NotIssued";
             String transfeebook="NotIssued";
             
           String sql="select srnum from studacaddetail where srnum='"+srnum+"' and syear='"+syear+"' and eyear='"+eyear+"'";
            stmt=cn.createStatement();
            rs=stmt.executeQuery(sql);
            if(rs.next()==true)
            {
               String sub=new String(""+srnum+" detail is already entered");
               request.setAttribute("sub",sub);
      RequestDispatcher rd2 =request.getRequestDispatcher("/fee/StudAcademicDet.jsp"); 
      rd2.forward(request,response);  
            }
            else
            {
                         
            String qry="insert into studacaddetail(srnum,syear,eyear,sname,dob,doj,gender,classes,section,house,route,buscode,tripnum,concession,feebooknum,transfeebook,head)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            out.println(qry);
            pstmt=cn.prepareStatement(qry); 
            pstmt.setInt(1,srnum);
            pstmt.setString(2,syear);
            pstmt.setString(3,eyear);
            pstmt.setString(4,sname);
            pstmt.setString(5,dob);
            pstmt.setString(6,doj);
            pstmt.setString(7,gender);
            pstmt.setString(8,classes);
            pstmt.setString(9,section);
            pstmt.setString(10,house);
            pstmt.setString(11,route);
            pstmt.setString(12,buscode);
            pstmt.setString(13,tripnum);
            pstmt.setDouble(14,concession);
            pstmt.setString(15,feebooknum);
            pstmt.setString(16,transfeebook);
            pstmt.setString(17,head);
                       
            pstmt.executeUpdate();
            
             String sql2="insert into feemonthrec(srnum,Syear,Eyear,January,February,March,April,May,June,July,August,September,October,November,December,class,section)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
             out.println(sql2);
            pstmt1=cn.prepareStatement(sql2); 
            pstmt1.setInt(1,srnum);
            pstmt1.setString(2,syear);
            pstmt1.setString(3,eyear);
            pstmt1.setString(4,"notpaid");
            pstmt1.setString(5,"notpaid");
            pstmt1.setString(6,"notpaid");
            pstmt1.setString(7,"notpaid");
            pstmt1.setString(8,"notpaid");
            pstmt1.setString(9,"notpaid");
            pstmt1.setString(10,"notpaid");
            pstmt1.setString(11,"notpaid");
            pstmt1.setString(12,"notpaid");
            pstmt1.setString(13,"notpaid");
            pstmt1.setString(14,"notpaid");
            pstmt1.setString(15,"notpaid");
            pstmt1.setString(16,classes);
            pstmt1.setString(17,section);
           
          pstmt1.executeUpdate();
          pstmt1=null;
          
            String sql4="insert into transfeemonthrec(srnum,Syear,Eyear,January,February,March,April,May,June,July,August,September,October,November,December,class,section)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
             
            pstmt1=cn.prepareStatement(sql4); 
            pstmt1.setInt(1,srnum);
            pstmt1.setString(2,syear);
            pstmt1.setString(3,eyear);
            pstmt1.setString(4,"notpaid");
            pstmt1.setString(5,"notpaid");
            pstmt1.setString(6,"notpaid");
            pstmt1.setString(7,"notpaid");
            pstmt1.setString(8,"notpaid");
            pstmt1.setString(9,"notpaid");
            pstmt1.setString(10,"notpaid");
            pstmt1.setString(11,"notpaid");
            pstmt1.setString(12,"notpaid");
            pstmt1.setString(13,"notpaid");
            pstmt1.setString(14,"notpaid");
            pstmt1.setString(15,"notpaid");
            pstmt1.setString(16,classes);
            pstmt1.setString(17,section);
           
          pstmt1.executeUpdate();
        pstmt1=null;
                 String sub=new String(""+srnum+" detail is entered");
                 request.setAttribute("sub",sub);
      RequestDispatcher rd2 =request.getRequestDispatcher("/fee/StudAcademicDet.jsp"); 
      rd2.forward(request,response); 

          }
      }
           }catch(Exception p)
          {p.printStackTrace();}
          
             try
           {
             if(pstmt!=null)
             {pstmt.close();}
              if(stmt3!=null)
             {stmt3.close();}
             if(rs!=null)
             {rs.close();}
              if(rs3!=null)
             {rs3.close();}
              if(cn!=null)
             {
                 cn.close();
             }
           }catch(SQLException e){}
         
                 return mapping.findForward("");
             
            }
}
