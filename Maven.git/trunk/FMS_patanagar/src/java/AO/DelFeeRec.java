   /*
 * UpdateFeeRecord.java
 *
 * Created on June 9, 2008, 4:52 PM
 */
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

public class DelFeeRec extends Action {
    
    Connection cn=null;
    PreparedStatement pstmt=null;
    PreparedStatement pstmt1=null;
    PreparedStatement pstmt4=null;
    Statement stmt1=null; 
    Statement stmt3=null;
    Statement stmt5=null;
    ResultSet rs=null;
    ResultSet rs3=null;
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
         
/*********************************Disply Fee Record*************************************/     
         
        String disp=request.getParameter("disp"); 
       try
          {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
          if(disp!=null)
          {
          try
          {
           String srnum=request.getParameter("srnum"); 
           ArrayList arr=new ArrayList();
        
      
       String tfn="Select * from feerecord where srnum='"+srnum+"' order by rowid desc";
             stmt3=cn.createStatement(); 
             rs3=stmt3.executeQuery(tfn);
             
    
       if(rs3.next())
       {
                 EO.SchoolEO seo=new EO.SchoolEO();
                  
                  seo.setSrnum(rs3.getString("srnum"));
                  seo.setSname(rs3.getString("studentname"));
                  seo.setClasses(rs3.getString("class"));
                  seo.setStatus(rs3.getString("feestatus"));
                  seo.setFee(rs3.getDouble("amountpaid"));
                  seo.setDname(rs3.getString("dnum"));
                  seo.setDdate(rs3.getString("ddate"));
                  seo.setBankname(rs3.getString("bankname"));
                  seo.setFeesubdate(rs3.getString("fsubdate"));
                  seo.setEamount(rs3.getDouble("eamount"));
                  seo.setPamount(rs3.getDouble("pamount"));
                  seo.setSyear(rs3.getString("Syear"));
                  seo.setEyear(rs3.getString("Eyear"));
                  seo.setTodate(rs3.getString("todate"));
                  seo.setFromdate(rs3.getString("fromdate"));
                  seo.setCurfine(rs3.getDouble("totfine"));
                  seo.setPaying(rs3.getDouble("paying"));
                  seo.setChkamount(rs3.getDouble("chkamount"));
                  seo.setSection(rs3.getString("section"));
                  seo.setRowid(rs3.getInt("rowid"));
             arr.add(seo);
       } 
      
          request.setAttribute("arr",arr);
        
        
if(arr.size()==0)
{
              String msg="There is no record";
              request.setAttribute("msg",msg);
      RequestDispatcher  rd2  =request.getRequestDispatcher("/fee/delfeerec.jsp"); 
      rd2.forward(request,response); 
}
else
{
      RequestDispatcher  rd2  =request.getRequestDispatcher("/fee/delfeerec.jsp"); 
      rd2.forward(request,response);         
}

          }catch(Exception ee)
          {
         
                ee.getStackTrace();
            }
          
          try
           {
              if(rs3!=null)
             {rs3.close();}
              if(stmt3!=null)
             {stmt3.close();}
              if(cn!=null)
             {
                 cn.close();
             }
           }catch(Exception e){}
     
          
        return mapping.findForward("success");
        
      }
        
         
 /************************************Delete Fee Record*********************************/        
         
         
         String delf=request.getParameter("delf");
         
         if(delf!=null)
         {
                 
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
                RequestDispatcher  rd1  =request.getRequestDispatcher("/fee/delfeerec.jsp"); 
                rd1.forward(request,response);   
                
           }
       
           else
           {
         ArrayList arr=new ArrayList();
        String chknum=request.getParameter("chknum");
        String srnum=request.getParameter("srnum").toString();  
        String todate=request.getParameter("todate"); 
        String fromdate=request.getParameter("fromdate");
        String dnum=request.getParameter("dnum"); 
        String ddate=request.getParameter("ddate");  
        String bankname=request.getParameter("bankname");  
        String cdate=request.getParameter("cdate"); 
        String Syear=request.getParameter("Syear");  
        String Eyear=request.getParameter("Eyear");  
        String rid=request.getParameter("rid");  
      
        double fee=Double.parseDouble(request.getParameter("fee").toString());  
        double tfee=Double.parseDouble(request.getParameter("tfee").toString());  
        double chkamount=Double.parseDouble(request.getParameter("damount").toString()); 
        double pamt=0.0;
        
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
               
           
         String sql1="update feemonthrec set "+pk1+"='notpaid' where srnum='"+srnum+"' and (Syear='"+request.getParameter("Syear")+"' or Eyear='"+request.getParameter("Syear")+"')";
         stmt1=cn.createStatement();
         stmt1.executeUpdate(sql1);
         
          String sql3="delete from feedetailreport where srnum='"+srnum+"' and (Syear='"+request.getParameter("Syear")+"' or Eyear='"+request.getParameter("Syear")+"') and month='"+pk1+"'";
         stmt3=cn.createStatement();
         stmt3.executeUpdate(sql3);
         
         String sql4="delete from feereceipt where srnum='"+srnum+"' and (Syear='"+request.getParameter("Syear")+"' or Eyear='"+request.getParameter("Syear")+"') and todate='"+todate+"'";
         stmt5=cn.createStatement();
         stmt5.executeUpdate(sql4);
         
         String sqlw="delete from finerecord where srnum='"+srnum+"' and (Syear='"+request.getParameter("Syear")+"' or Eyear='"+request.getParameter("Syear")+"') and todate='"+todate+"'";
         Statement stmt4=cn.createStatement();
         stmt4.executeUpdate(sqlw);
         
         String sqlk="delete from feerecord where rowid='"+rid+"'";
       Statement stmt6=cn.createStatement();
         stmt6.executeUpdate(sqlk);
         
         
            }  
              
      
           String sub=new String(""+srnum+" fee record is deleted ");
           request.setAttribute("sub",sub);
           RequestDispatcher  rd1  =request.getRequestDispatcher("/fee/delfeerec.jsp"); 
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
         }
        return mapping.findForward("");
        
    }
}
