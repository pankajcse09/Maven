
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

public class updatefeechart extends Action {
    
    Connection cn=null;
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
             
            int cid=0;
            
    private final static String SUCCESS = "success"; 

    
      public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try{
         SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
         PrintWriter out= response.getWriter();
         
         
/********************************* Insert Fee Chart****************************************/
     
      try{        
            DataConnection dc1=new DataConnection();
            cn=(Connection)dc1.Dataconnect();
      }
      catch(Exception e){}
          
       //String sub=request.getParameter("sub");  
       String month=request.getParameter("month");   
      //String sessdate=request.getParameter("session");       
       
       //if(sub!=null){    
             String qry="Select count(*) as cid from classes";
             out.println(qry);
             stmt=cn.createStatement();
             rs=stmt.executeQuery(qry);
             rs.next();
             int cid=rs.getInt("cid");           
                  
          HashMap hm=new HashMap();   
          ArrayList cls=new ArrayList();
               
          String[] heads=(String[])request.getParameterValues("heads");
        
          for(int j=0;j<cid;j++){
          cls.add(request.getParameter("classes"+j));
          for(int i=0;i<heads.length;i++){      
          hm.put(heads[i]+"_"+request.getParameter("classes"+j),request.getParameter("classes"+j+"_"+heads[i]));
          }
          }           
   try
   {       
   String de="delete from feechartdyna where month='"+month+"'";      
   psmt3=cn.prepareStatement(de);                      
   psmt3.executeUpdate();  
   String de2="delete from feestructdyna where month='"+month+"'"; 
   psmt2=cn.prepareStatement(de2);                      
   psmt2.executeUpdate();   
   String qr1="insert into feestructdyna(classes,month,totalfee)values(?,?,?)"; 
   String sq="insert into feechartdyna(classes,month,heads,fees)values(?,?,?,?)";  
  //   String sq="insert into feechart(class)values(?)";        
        for(int m=0;m<cid;m++){  
        double total=0.0; 
        for(int i=0;i<heads.length;i++){  
              pstmt=cn.prepareStatement(sq); 
              pstmt.setString(1,cls.get(m).toString());  
              pstmt.setString(2,month);
              pstmt.setString(3,heads[i]);  
              pstmt.setString(4,hm.get(heads[i]+"_"+cls.get(m)).toString());              
              pstmt.executeUpdate();
                 try {
             total=total+Double.parseDouble(hm.get(heads[i]+"_"+cls.get(m)).toString());
             } catch(NumberFormatException ex){}
           }
          psmt2=cn.prepareStatement(qr1);
          psmt2.setString(1,cls.get(m).toString());  
          psmt2.setString(2,month);
          psmt2.setDouble(3,total);                      
          psmt2.executeUpdate();   
         }       
         request.setAttribute("msg","Fee chart is defined");
           }
        catch(SQLException e){request.setAttribute("msg","Data Already Exists");}
       //    }
       //}  
       try
           {
             if(rs!=null){rs.close();}
              if(rs1!=null){rs1.close();}
             if(stmt!=null){stmt.close();}
             if(stmt1!=null){stmt1.close();}
              if(psmt2!=null){psmt2.close();}
             if(psmt3!=null){psmt3.close();}
             if(pstmt!=null){pstmt.close();}         
              if(cn!=null){cn.close();}   
           }catch(SQLException e){}         
         }
      catch(Exception e){}      
   return mapping.findForward("success");            
}
}
