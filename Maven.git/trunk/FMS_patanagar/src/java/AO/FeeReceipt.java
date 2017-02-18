
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

public class FeeReceipt extends Action {
    
    PreparedStatement pstmt=null;
    Statement stmt=null;
    ResultSet rs=null;
    ResultSet rs1=null;
    
    private final static String SUCCESS = "success";
    
    
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Connection cn=null;
        
        String st1="";
        String st2="";
        double headfee=0.0;
        double hfeetot=0.0;
        HashMap hm1=new HashMap();
        
        PrintWriter out= response.getWriter();
        
        SimpleDateFormat sdf2=new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf1=new SimpleDateFormat("MMMMMMMMMMMM");
        SimpleDateFormat sdf=new SimpleDateFormat("MM");
        datediff dd=new datediff();
        
        int srnum=Integer.parseInt(request.getParameter("srnum").toString());
        double feebc=Double.parseDouble(request.getParameter("feebc").toString());
        String todate=request.getParameter("todate");
        String fromdate=request.getParameter("fromdate");
        
       
        try {
            DataConnection dc=new DataConnection();
            cn=(Connection)dc.Dataconnect();
        }catch(Exception e) {
        }
        
        SchoolEO seo=new SchoolEO();
        ArrayList arr=new ArrayList();
        ArrayList array=new ArrayList();
    
        try
        {
        String byr="Select class,section,studentname,fsubdate,eamount,pamount,syear,eyear,concamt,conchead,amountpaid,paying,bankname,dnum from feerecord where srnum='"+srnum+"' and todate='"+todate+"' and fromdate='"+fromdate+"' ";
        out.println(byr);
        stmt=cn.createStatement();
        rs=stmt.executeQuery(byr);
        if(rs.next()) 
        {
                seo.setSrnum(rs.getString("srnum"));
                seo.setSname(rs.getString("sname"));
                seo.setClasses(rs.getString("class"));
                seo.setSection(rs.getString("section"));
                seo.setClasses(rs.getString("fsubdate"));
                seo.setClasses(rs.getString("eamount"));
                seo.setClasses(rs.getString("pamount"));
                seo.setClasses(rs.getString("syear"));
                seo.setClasses(rs.getString("eyear"));
                seo.setClasses(rs.getString("concamt"));
                seo.setEyear(rs.getString("conchead"));
                seo.setClasses(rs.getString("amountpaid"));
                seo.setClasses(rs.getString("paying"));
                seo.setClasses(rs.getString("bankname"));
                seo.setClasses(rs.getString("dnum"));
        }
        
         String fh="Select heads from feeheads";
              stmt=cn.createStatement();
              rs=stmt.executeQuery(fh);   
              while(rs.next())
              {
                 SchoolEO seo1=new SchoolEO();
                 seo1.setHeads(rs.getString("heads")); 
                 array.add(seo1); 
              }
            
            HashSet hst1=new HashSet();
            HashMap hst2=new HashMap();
            
            java.util.Date sdt1=sdf2.parse(request.getParameter("fromdate"));
            java.util.Date tdt1=sdf2.parse(request.getParameter("todate"));
            ArrayList ddw=new ArrayList();
            ddw=(ArrayList)dd.getDatesBetween(sdt1,tdt1);
            for(int i=0;i<ddw.size();i++){
                java.util.Date dt=(java.util.Date)ddw.get(i);
                st1=sdf1.format(dt);
                st2=sdf.format(dt);
                hst1.add(st1);
                hst2.put(st1,st2);
            }
            String pk1="";
            
            Iterator ir1=(Iterator)hst1.iterator();
          
            for(int i=0;i<array.size();i++)
            {
            while(ir1.hasNext()) {
                pk1=(String)ir1.next();
               // String pk2=(String)hst2.get(pk1);
                
           String fhv="Select fees from feechartdyna where month='"+pk1+"' and heads='"+array.get(i)+"'";
              pstmt=cn.prepareStatement(fhv);
              rs1=pstmt.executeQuery();  
              if(rs1.next())
              {
                headfee=rs1.getDouble("fees");                 
              }  
             hfeetot=headfee+hfeetot;               
            }
            hm1.put(array.get(i),new Double(hfeetot));
            }
            
            request.setAttribute("arry",array);
            request.setAttribute("hmap",hm1);
            
        
            
            
            
            
            
            
            
            
            
            
            
            
            
            
     /*       
            
            
            String sq="insert into feerecord(srnum,studentname,class,amountpaid,dnum,ddate,bankname,fsubdate,todate,fromdate,eamount,pamount,Syear,Eyear,totfine,chkamount,paying,feestatus,pfine,mfine,section,sfeebook,mnt,head,concamt)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pstmt=cn.prepareStatement(sq);
            pstmt.setInt(1,srnum1);
            pstmt.setString(2,sname1);
            pstmt.setString(3,classes1);
            pstmt.setDouble(4,fee1);
            pstmt.setString(5,dnum1);
            pstmt.setString(6,ddate1);
            pstmt.setString(7,bankname1);
            pstmt.setString(8,feesubdate1);
            pstmt.setString(9,todate1);
            pstmt.setString(10,fromdate1);
            pstmt.setDouble(11,eamount1);
            pstmt.setDouble(12,pamount1);
            pstmt.setString(13,Syear1);
            pstmt.setString(14,Eyear1);
            pstmt.setDouble(15,totfine1);
            pstmt.setDouble(16,damount1);
            pstmt.setDouble(17,paying1);
            pstmt.setString(18,feestatus);
            pstmt.setDouble(19,pfine1);
            pstmt.setDouble(20,curfine1);
            pstmt.setString(21,section1);
            pstmt.setString(22,sfeebook1);
            pstmt.setString(23,mn1);
            pstmt.setString(24,conchead1);
            pstmt.setDouble(25,concamt1);
            
            pstmt.executeUpdate();
            pstmt=null;
            
         */
            
//            String sub=new String("fee is entered");
//            request.setAttribute("sub",sub);
//        //    RequestDispatcher  rd1  =request.getRequestDispatcher("/sfdisp.do");
//              RequestDispatcher  rd1  =request.getRequestDispatcher("/frec.do");
//            rd1.forward(request,response);
//            
        }catch(SQLException e){}
        
        
        
        try {
            if(rs!=null) {
                rs.close();}
            if(pstmt!=null) {
                pstmt.close();}
            if(stmt!=null) {
                stmt.close();}
            if(cn!=null) {
                cn.close();
            }
        }catch(Exception e){}

        
        return mapping.findForward("");
        
    }
}
