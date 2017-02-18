
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

public class DisplayFeestruct extends Action
{

   Connection cn;
    PreparedStatement pstmt1;
    PreparedStatement pstmt;
    ResultSet rs1;
    Statement stmt;
    Statement stmt1;
    Statement stmt2;
    ResultSet rs;
    ResultSet rs2;
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
                String qr = "Select class from feestructure";
                out.println(qr);
                stmt = cn.createStatement();
                rs = stmt.executeQuery(qr);
                rs.next();
                classes = rs.getString("class");
                if(classes != null)
                {
                    String qry = "Select * from feestructure";
                    out.println(qry);
                    stmt1 = cn.createStatement();
                    SchoolEO seo;
                    for(rs1 = stmt1.executeQuery(qry); rs1.next(); arr.add(seo))
                    {
                        seo = new SchoolEO();
                        seo.setClasses(rs1.getString("class"));
                        seo.setApr(rs1.getInt("April"));
                        seo.setMay(rs1.getInt("May"));
                        seo.setJune(rs1.getInt("June"));
                        seo.setJuly(rs1.getInt("July"));
                        seo.setAugust(rs1.getInt("August"));
                        seo.setSept(rs1.getInt("September"));
                        seo.setOct(rs1.getInt("October"));
                        seo.setNov(rs1.getInt("November"));
                        seo.setDec(rs1.getInt("December"));
                        seo.setJan(rs1.getInt("January"));
                        seo.setFeb(rs1.getInt("February"));
                        seo.setMar(rs1.getInt("March"));
                        seo.setRowid(rs1.getInt("rowid"));
                    }

                    request.setAttribute("array", arr);
                }
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
            }
            return mapping.findForward("success");
        
     }
  
}