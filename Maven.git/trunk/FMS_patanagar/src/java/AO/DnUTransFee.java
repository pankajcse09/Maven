
package AO;

import EO.SchoolEO;
import com.myapp.struts.DataConnection;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.*;

public class DnUTransFee extends Action
{

    Connection cn;
    ResultSet rs1;
    Statement stmt;
    Statement stmt1;
    ResultSet rs;
  
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
        try
        {
            DataConnection dc1 = new DataConnection();
            cn = dc1.Dataconnect();
        }
        catch(Exception e) { }
        String dispfee = request.getParameter("dispfee");
      
        out.println(dispfee);
        if(dispfee != null)
        {
            try
            {
//                String qr = "Select * from transportfee";
//                out.println(qr);
//                stmt = cn.createStatement();
//                rs = stmt.executeQuery(qr);
//                if(rs.next()==false)
//                {
//               String msg=new String("No Record");
//
//               request.setAttribute("msg",msg);
//               RequestDispatcher  rd1  =request.getRequestDispatcher("dutf.do?dispfee=dispfee"); 
//               rd1.forward(request,response);        
//                }
//                else
//                {
                    String qry = "Select * from transportfee";
                    out.println(qry);
                    stmt1 = cn.createStatement();
                    rs1=stmt1.executeQuery(qry);
                   while(rs1.next())
                   {
                       SchoolEO seo = new SchoolEO();
                        seo.setRoute(rs1.getString("route"));
                        seo.setBusfee(rs1.getDouble("busfee"));
                        seo.setRowid(rs1.getInt("rowid"));
                        
                        arr.add(seo);
                   }
                          
                    request.setAttribute("array", arr);
                
               // }
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
            }
            return mapping.findForward("success");
        
     }
  
}