///*
// * FeeStr.java
// *
// * Created on August 22, 2008, 9:47 PM
// */
//
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

public class FeesChart extends Action {    
    
    PreparedStatement pstmt1=null;
    PreparedStatement pstmt=null;
    PreparedStatement psmt2=null;   
    PreparedStatement psmt3=null; 
    Statement stmt=null;
    Statement stmt1=null;
    Statement stmt2=null;
    ResultSet rs=null;
    ResultSet rs1=null;
    ResultSet rs2=null;
    ResultSet rs3=null;
    int count=0;
    int cnt=0;
    int i=0;
    String classes="";     
    private final static String SUCCESS = "success";
    
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         Connection cn=null;
         SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
         PrintWriter out= response.getWriter();
         
/********************************* Display Fee Structure ****************************************/         
         
         ArrayList arr=new ArrayList();
         ArrayList ar1=new ArrayList();
         ArrayList ar2=new ArrayList();
    
      try{        
            DataConnection dc1=new DataConnection();
            cn=(Connection)dc1.Dataconnect();
      }
      catch(Exception e){}
       
          String dispfee=request.getParameter("dispfee"); 
          String month=request.getParameter("month"); 
          String mnt="";
          if(dispfee!=null)
          {
              try
          {    
            
             String qr="Select * from feechart";
             out.println("hello"+qr);
             stmt=cn.createStatement();
             rs=stmt.executeQuery(qr);
             if(rs.next()==false)
             { String msg=new String("Fee chart is not defined");

                request.setAttribute("msg",msg);
                RequestDispatcher  rd1  =request.getRequestDispatcher("/fee/feechart.jsp"); 
                rd1.forward(request,response);          
            
             }
             
             else{
             String qr1="select distinct class from classes where type='BelowGraduate'";
             psmt2=cn.prepareStatement(qr1);
             rs2=psmt2.executeQuery();
             while(rs2.next()){
             ar1.add(rs2.getString("class"));   
             }
             String qr2="select distinct heads from feeheads";   
             psmt3=cn.prepareStatement(qr2);
             rs3=psmt3.executeQuery();
             while(rs3.next()){
             ar2.add(rs3.getString("heads"));     
             }
             for(int i=0;i<ar1.size();i++){   
              for(int j=0;j<ar2.size();j++){                    
              
             String qry="Select fees from feechart where month='"+month+"' and classes='"+ar1.get(i)+"' and heads='"+ar2.get(j)+"'";
             stmt1=cn.createStatement();
             rs1=stmt1.executeQuery(qry);
             
             while(rs1.next())
               { 
                SchoolEO seo=new SchoolEO();
                seo.setClasses(rs1.getString("classes"));                
                seo.setAdmission(rs1.getInt("adm"));
                seo.setTution(rs1.getInt("tution"));
                seo.setWelfare(rs1.getInt("welfare"));
                seo.setGames(rs1.getInt("games"));
                seo.setExam(rs1.getInt("exam"));
                seo.setLib(rs1.getInt("lib"));
                seo.setScience(rs1.getInt("science"));
                seo.setComputer(rs1.getInt("computer"));
                seo.setRowid(rs1.getInt("rowid"));
                seo.setMonth(rs1.getString("month"));
                seo.setRedm(rs1.getInt("redm"));
                seo.setOther(rs1.getInt("other"));
              
                arr.add(seo);
                mnt=seo.getMonth();
               }
              } 
             }
                out.println(arr);
                request.setAttribute("array",arr);    
                request.setAttribute("mnt",mnt); 
            
             }
          
          }catch(SQLException e)
          {e.printStackTrace();}
               return mapping.findForward("success");   
              }   
          

   return mapping.findForward("");   
         
}
      
    }