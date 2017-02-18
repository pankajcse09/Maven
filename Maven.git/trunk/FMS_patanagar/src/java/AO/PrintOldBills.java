

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
public class PrintOldBills extends Action {
    
    Connection cn=null;
    Statement stmt=null;
    Statement stmt1=null;
    Statement stmt2=null;
    
    ResultSet rs=null;
    ResultSet rs1=null;
    ResultSet rs2=null;
   
    private final static String SUCCESS = "success";
    
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
          PrintWriter out= response.getWriter();
          EO.SchoolEO gt=new EO.SchoolEO();
          ArrayList arr=new ArrayList();
          
        SimpleDateFormat sdf2=new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf1=new SimpleDateFormat("MMMMMMMMMMMM");
        SimpleDateFormat sdf=new SimpleDateFormat("MM");
        datediff dd=new datediff();
        
          String snum="";
          String rnum="";
          String syear="";
          String eyear="";
          String fsub="";
          double paying=0.0;
          String cls="";
          String sec="";
          String sname="";
          String todate="";
          String fromdate="";
          String tmon="";
          String fmon="";
          String msg="";
          double headfee=0.0;
        
          try
         {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
  
 /******************************Displaying Customer Detail *************************/
        try
        {  
          String disp=request.getParameter("disp"); 
          if(disp!=null)
          {
           
           String srnum=request.getParameter("srnum"); 
            String fsubdate=request.getParameter("fsubdate"); 
      String qry2="Select count(*) as cnt from feereceipt where srnum='"+srnum+"' and fsubdate='"+fsubdate+"'";    
      out.println(qry2);
      stmt1=cn.createStatement();
       rs1=stmt1.executeQuery(qry2);
     rs1.next();
     int cnt=rs1.getInt("cnt");  out.println("cnt"+cnt);
     if(cnt==0){
     msg=new String(" "+srnum+"receipt does not exist on "+fsubdate+"");
          request.setAttribute("msg",msg);
          RequestDispatcher  rd1  =request.getRequestDispatcher("/fee/printoldbills.jsp"); 
          rd1.forward(request,response);   
     }
     else{   
          
         SchoolEO st=null;
         HashMap hm1=new HashMap();
     String qry3="Select srnum,todate,fromdate,rnum,Syear,Eyear,head,headfee,classes,section,sname,paying,fsubdate from feereceipt where srnum='"+srnum+"' and fsubdate='"+fsubdate+"'";
     out.println(qry3);
     stmt2=cn.createStatement();
     rs2=stmt2.executeQuery(qry3);
     
    while(rs2.next())
    {
       st=new EO.SchoolEO();
       st.setSrnum(rs2.getString("srnum"));         
       st.setRnum(rs2.getString("rnum"));     
       st.setSyear(rs2.getString("syear"));          
       st.setEyear(rs2.getString("eyear"));           
       st.setClasses(rs2.getString("classes"));    
       st.setSection(rs2.getString("section"));  
       st.setTodate(rs2.getString("todate")); 
       st.setFromdate(rs2.getString("fromdate")); 
       st.setSname(rs2.getString("sname"));    
       st.setHeads(rs2.getString("head"));    
       st.setFee(rs2.getDouble("headfee"));    
       st.setPaying(rs2.getDouble("paying"));    
       st.setFeesubdate(rs2.getString("fsubdate"));    
        arr.add(st);  
        snum=st.getSrnum();
        rnum=st.getRnum();
        syear=st.getSyear();
        eyear=st.getEyear();
        cls=st.getClasses();
        sec=st.getSection();
        sname=st.getSname();
        paying=st.getPaying();
        fsub=st.getFeesubdate();
        todate=st.getTodate();
        java.util.Date tm1=sdf2.parse(todate);
        tmon=sdf1.format(tm1);
        fromdate=st.getFromdate();
        java.util.Date fm1=sdf2.parse(fromdate);
        fmon=sdf1.format(fm1);
        
    }
     
     ArrayList array=new ArrayList();
              String fh="Select heads from feeheads";
              stmt=cn.createStatement();
              rs=stmt.executeQuery(fh);   
              while(rs.next())
              {
                 SchoolEO seo1=new SchoolEO();
                 //seo1.setHeads(rs.getString("heads")); 
                 array.add(rs.getString("heads")); 
              }
            
       
            for(int i=0;i<array.size();i++)
            {    
           String fhv="Select fees from feechartdyna where heads='"+array.get(i)+"' and classes='"+cls+"'";
    
              PreparedStatement pstmt=cn.prepareStatement(fhv);
              ResultSet rs3=pstmt.executeQuery();  
              if(rs3.next())
              {
                headfee=rs3.getDouble("fees");
                    
              }  
               hm1.put(array.get(i),new Double(headfee)); 
            }
              
        request.setAttribute("arr",array);
        request.setAttribute("hmap",hm1);
        request.setAttribute("srnum",snum);
        request.setAttribute("rnum",rnum);
        request.setAttribute("Syear",syear);
        request.setAttribute("Eyear",eyear);
        request.setAttribute("classes",cls);
        request.setAttribute("section",sec);
        request.setAttribute("sname",sname);
        request.setAttribute("paying",new Double(paying));
        request.setAttribute("fsubdate",fsub);
        request.setAttribute("tmon",tmon);
        request.setAttribute("fmon",fmon);
       
     }
        }
        }catch(SQLException ee)
        {
            ee.getStackTrace();
         }    
        
  
    /****************************************************************************************/        
//             try
//           {
//              if(stmt!=null)
//             {stmt.close();}
//              if(stmt1!=null)
//             {stmt1.close();}
//              if(stmt2!=null)
//             {stmt2.close();}
//            
//              if(rs!=null)
//             {rs.close();}
//              if(rs1!=null)
//             {rs1.close();}
//              if(rs2!=null)
//             {rs2.close();}
//             
//              if(cn!=null)
//             {cn.close();
//             }
//           }catch(SQLException e){}
         
      return mapping.findForward("success");
            
    }
}
