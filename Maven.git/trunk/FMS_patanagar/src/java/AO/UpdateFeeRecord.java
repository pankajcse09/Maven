

package AO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
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
 * @author Sonal
 * @version
 */

public class UpdateFeeRecord extends Action {
    
    Connection cn=null;
    PreparedStatement pstmt=null;
    PreparedStatement pstmt1=null;
    PreparedStatement pstmt4=null;
    Statement stmt1=null; 
    Statement stmt3=null;
    Statement stmt5=null;
    ResultSet rs=null;
    ResultSet rs1=null;
    String feestatus="bounced";
    double dedfee=0.0;
    String st1="";
    private final static String SUCCESS = "success";
    
    
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         PrintWriter out= response.getWriter();
         
         SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
         SimpleDateFormat sdf1=new SimpleDateFormat("MMMMMMMMMMMM");
         datediff dd=new datediff();    
        
         try
       {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
        
             String srn=request.getParameter("srno");   
             if(srn==null)
             {
               
             String sub=new String("Plz enter the record");

                request.setAttribute("sub",sub);
                RequestDispatcher  rd1  =request.getRequestDispatcher("/fee/chkbounce.jsp"); 
                rd1.forward(request,response);   
                
           }
       
           else
           {
         ArrayList arr=new ArrayList();
        String chknum=request.getParameter("chknum");
        String[] srno=(String[])request.getParameterValues("srnum");
        String srnum=request.getParameter("srnum").toString();
        String todate=request.getParameter("todate");
        String fromdate=request.getParameter("fromdate");
        String dnum=request.getParameter("dnum");
        String ddate=request.getParameter("ddate");
        String bankname=request.getParameter("bankname");
        String cdate=request.getParameter("cdate");
        String Syear=request.getParameter("Syear");
        String Eyear=request.getParameter("Eyear");
      
        double fee=Double.parseDouble(request.getParameter("fee").toString());
        double tfee=Double.parseDouble(request.getParameter("tfee").toString());
        double remain=Double.parseDouble(request.getParameter("remain").toString());
        double deduct=Double.parseDouble(request.getParameter("deduct").toString());
        double chkamount=Double.parseDouble(request.getParameter("damount").toString());
        double penalty=Double.parseDouble(request.getParameter("penalty").toString()); 
        double pamt=0.0;
        
        double dedfee1=fee-deduct;
        if(dedfee1<=0)
        {
            dedfee=0;
        }
        else
        {
            dedfee=dedfee1;
        }
         try
       {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
        
        try{
            
             HashSet hst1=new HashSet(); 
       
           java.util.Date sdt1=sdf.parse(request.getParameter("fromdate"));
           java.util.Date tdt1=sdf.parse(request.getParameter("todate"));
           ArrayList ddw=new ArrayList();
           ddw=(ArrayList)dd.getDatesBetween(sdt1,tdt1);
           for(int i=0;i<ddw.size();i++){
           java.util.Date dt=(java.util.Date)ddw.get(i);    
           st1=sdf1.format(dt);           
           hst1.add(st1);
           }  
            String pk1="";
          
              Iterator ir1=(Iterator)hst1.iterator(); 
            while(ir1.hasNext()){
              pk1=(String)ir1.next(); 
               
         for(int i=0;i<srno.length;i++){      
         String sql1="update feemonthrec set "+pk1+"='notpaid' where srnum='"+srno[i]+"' and (Syear='"+request.getParameter("Syear")+"' or Eyear='"+request.getParameter("Syear")+"')";
         stmt1=cn.createStatement();
         stmt1.executeUpdate(sql1);
         
          String sql3="delete from feedetailreport where srnum='"+srno[i]+"' and (Syear='"+request.getParameter("Syear")+"' or Eyear='"+request.getParameter("Syear")+"') and month='"+pk1+"'";
         stmt3=cn.createStatement();
         stmt3.executeUpdate(sql3);
         
         String sql4="delete from feereceipt where srnum='"+srno[i]+"' and (Syear='"+request.getParameter("Syear")+"' or Eyear='"+request.getParameter("Syear")+"') and todate='"+fromdate+"'";
         stmt5=cn.createStatement();
         stmt5.executeUpdate(sql4);
         
          String fhv="Select pamount from feerecord where dnum='"+chknum+"' and srnum='"+srno[i]+"' and (Syear='"+request.getParameter("Syear")+"' or Eyear='"+request.getParameter("Syear")+"')";
            
           pstmt1=cn.prepareStatement(fhv);
              rs1=pstmt1.executeQuery();  
              if(rs1.next())
              {
                double pmt=rs1.getDouble("pamount"); 
                pamt=pmt+penalty;
              }
              
          String sqlf="update feerecord set pamount='"+pamt+"' where dnum='"+chknum+"' and srnum='"+srno[i]+"' and (Syear='"+request.getParameter("Syear")+"' or Eyear='"+request.getParameter("Syear")+"') ";
        
          pstmt4=cn.prepareStatement(sqlf);
          pstmt4.executeUpdate(); 
         
         }
            }  
              
           //   String arrs[]=("
 
      String inst="insert into bounchkdetail(srnum,dnum,ddate,bankname,damount,canceldate,todate,fromdate)values(?,?,?,?,?,?,?,?)";        
         out.println(inst);
            pstmt=cn.prepareStatement(inst);
            pstmt.setString(1,srnum);
            pstmt.setString(2,dnum);
            pstmt.setString(3,ddate);
            pstmt.setString(4,bankname);
            pstmt.setDouble(5,chkamount);
            pstmt.setString(6,cdate);
            pstmt.setString(7,todate);
            pstmt.setString(8,fromdate);
                
          pstmt.executeUpdate(); 
        pstmt=null;  
        
            
   String sql1="update feerecord set amountpaid='"+dedfee+"',paying='"+remain+"',ddate='',bankname='',chkamount='0',feestatus='"+feestatus+"' where dnum='"+chknum+"' ";
          pstmt=cn.prepareStatement(sql1);
          pstmt.executeUpdate(); 
     
           String sub=new String("Check has been cancelled and the fee record is updated");
           request.setAttribute("sub",sub);
           RequestDispatcher  rd1  =request.getRequestDispatcher("/fee/chkbounce.jsp"); 
           rd1.forward(request,response);          
       
        }
        catch(SQLException y)
        {
            y.printStackTrace();
        }
           }
        
        try
           {
            if(pstmt!=null)
             {pstmt.close();}
             if(cn!=null)
             {
               cn.close();
             }
           }catch(SQLException e){}
    
        
        return mapping.findForward("");
        
    }
}
