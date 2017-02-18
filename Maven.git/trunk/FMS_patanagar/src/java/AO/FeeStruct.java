
package AO;

import EO.SchoolEO;
import com.myapp.struts.DataConnection;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.*;

public class FeeStruct extends Action
{

    Connection cn=null;
    PreparedStatement pstmt1=null;
    PreparedStatement pstmt=null;
    PreparedStatement psmt2=null;
    PreparedStatement psmt3=null;
    ResultSet rs1=null;
    Statement stmt=null;
    Statement stmt1=null;
    Statement stmt2=null;
    ResultSet rs=null;
    ResultSet rs2=null;
    ResultSet rs3=null;
    int count;
    int cnt;
    int i;
    String cls1;
    String in1;
    String ext1;
    String emp1;
    String classes;
    private static final String SUCCESS = "success";

     public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        PrintWriter out = response.getWriter();
        ArrayList arr = new ArrayList();
        ArrayList ar1 = new ArrayList();       
        HashMap hm2=new HashMap();
        try
        {
            DataConnection dc1 = new DataConnection();
            cn = dc1.Dataconnect();
        }
        catch(Exception e) { }
        SchoolEO seo = new SchoolEO();
        String dispfee = request.getParameter("dispfee");
      
        out.println(dispfee);
        if(dispfee != null)
        {
            try
            {
                String qr = "Select distinct class from classes";
                psmt3=cn.prepareStatement(qr);
                rs3=psmt3.executeQuery(qr);
                while(rs3.next()){
                ar1.add(rs3.getString("class"));                
                }  
                out.println(ar1);
                seo.setClassList(ar1);
                for(int i=0;i<ar1.size();i++){  
                    HashMap hm1=new HashMap(); 
                    String qry = "Select * from feestructdyna where classes='"+ar1.get(i)+"'";                    
                    psmt2=cn.prepareStatement(qry);
                    rs1=psmt2.executeQuery();                
                    while(rs1.next()){                        
                    hm1.put(rs1.getString("month"),new Double(rs1.getDouble("totalfee")));                            
                    }
                    hm2.put(ar1.get(i),hm1);     
                    out.println(hm1);                    
                }
                out.println(hm2);
                seo.setClassFee(hm2);
                request.setAttribute("sbean", seo);
            }
            catch(SQLException e){
            e.printStackTrace();
            }
            }
            return mapping.findForward("success");
        
     }
  
}