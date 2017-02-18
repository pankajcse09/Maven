
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

public class InsertTransFee extends Action {
    
    Connection cn=null;
    PreparedStatement pstmt=null;
    Statement stmt=null;
    Statement stmt1=null;
    Statement stmt2=null;
    ResultSet rs2=null;
    ResultSet rs=null;
    ResultSet rs1=null;
    String feestatus="paid";
    String st="";
    int nom=0;
    int num=0;
    String todate="";
    String fromdate="";
    String st1="";
    String st2="";
    String regnum="";
    String Syear="";
    String Eyear="";
    String finestatus="";
    String exemptby="NotExempted";
    int rid=0;
    
    private final static String SUCCESS = "success";
    
    
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrintWriter out= response.getWriter();
       
         SimpleDateFormat sdf2=new SimpleDateFormat("dd/MM/yyyy");
         SimpleDateFormat sdf1=new SimpleDateFormat("MMMMMMMMMMMM");
         SimpleDateFormat sdf=new SimpleDateFormat("MM");
         datediff dd=new datediff();    
       
         int fee1= Integer.parseInt(request.getParameter("tcfee"));   
         String sname1=request.getParameter("sname");
         String sesdate=request.getParameter("sesdate");
         String classes1=request.getParameter("classes");
         int curfine1= Integer.parseInt(request.getParameter("curfine"));   
         int pfine1= Integer.parseInt(request.getParameter("pfine"));    
         
         String feesubdate1=request.getParameter("feesubdate");   
         java.util.Date fsb=sdf2.parse(feesubdate1);  
         String mn1=sdf.format(fsb);
         
         String todate1=(String)request.getParameter("tdate");           
         String fromdate1=request.getParameter("fdate");             
         String Eyear1=request.getParameter("Eyear");               
         int srnum1=Integer.parseInt(request.getParameter("srnum").toString());             
         String Syear1=request.getParameter("Syear");               
         String dnum1=request.getParameter("dnum");                 
         String ddate1=request.getParameter("ddate");              
         String bankname1=request.getParameter("bankname");         
         String section1=request.getParameter("section"); 
         String route1=request.getParameter("route"); 
         String tripnum1=request.getParameter("tripnum"); 
         String buscode1=request.getParameter("buscode"); 
         String tfeebook1=request.getParameter("tfeebook"); 
         
         int eamount1= Integer.parseInt(request.getParameter("finalEamount"));     
         int pamount1= Integer.parseInt(request.getParameter("finalDamount")); 
         int damount1= Integer.parseInt(request.getParameter("damount"));   
         int paying1= Integer.parseInt(request.getParameter("paid")); 
         int nom1= Integer.parseInt(request.getParameter("nom"));   
       
         int totfine1=curfine1+pfine1;
           if(pamount1==0)
         {
             finestatus="NoDues";
         }else
         {
            finestatus="DueNotpaid";
         }
             
        
          try
          {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
    
          String byr="Select srnum from transfeerecord where (Syear='"+Syear1+"' or Eyear='"+Syear1+"') and (srnum='"+srnum1+"' or tfeebook='"+tfeebook1+"') ";
          
           stmt=cn.createStatement();
           rs1=stmt.executeQuery(byr); 
          if(rs1.next()==false)
          {   HashSet hst1=new HashSet(); 
               HashMap hst2=new HashMap(); 
               
           java.util.Date sdt1=sdf2.parse(request.getParameter("fdate"));
           java.util.Date tdt1=sdf2.parse(request.getParameter("tdate"));
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
//               Iterator ir2=(Iterator)hst2.iterator(); 
           // for(int y=0;y<hst1.size();y++)
                    while(ir1.hasNext()) 
        {
              pk1=(String)ir1.next(); //  out.println("pk1"+pk1);
             String pk2=(String)hst2.get(pk1); 
                      
        String sql1="update transfeemonthrec set "+pk1+"='paid' where srnum='"+request.getParameter("srnum")+"' and (Syear='"+request.getParameter("Syear")+"' or Eyear='"+request.getParameter("Syear")+"')";
          out.println(sql1);
         
         stmt1=cn.createStatement();
         stmt1.executeUpdate(sql1);    
               
         int subfee=fee1/nom1;
          String sqf="insert into transfeedetailreport(srnum,sname,classes,section,month,amount,fsubdate,buscode,route,tripnum,syear,eyear,mnt)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";  
          
            pstmt=cn.prepareStatement(sqf); 
            pstmt.setInt(1,srnum1);
            pstmt.setString(2,sname1);
            pstmt.setString(3,classes1);
            pstmt.setString(4,section1);
            pstmt.setString(5,pk1);
            pstmt.setInt(6,subfee);
            pstmt.setString(7,feesubdate1);
            pstmt.setString(8,buscode1);
            pstmt.setString(9,route1);
            pstmt.setString(10,tripnum1);
            pstmt.setString(11,Syear1);
            pstmt.setString(12,Eyear1);
            pstmt.setString(13,pk2);
            pstmt.executeUpdate();   
            pstmt=null;
           }
    
            String sq="insert into transfeerecord(srnum,studentname,class,amountpaid,dnum,ddate,bankname,fsubdate,todate,fromdate,eamount,pamount,Syear,Eyear,totfine,chkamount,paying,feestatus,pfine,mfine,section,buscode,route,tripnum,mnt)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";  
            out.println(sq);
            pstmt=cn.prepareStatement(sq); 
            pstmt.setInt(1,srnum1);
            pstmt.setString(2,sname1);
            pstmt.setString(3,classes1);
            pstmt.setInt(4,fee1);
            pstmt.setString(5,dnum1);
            pstmt.setString(6,ddate1);
            pstmt.setString(7,bankname1);
            pstmt.setString(8,feesubdate1);
            pstmt.setString(9,todate1);
            pstmt.setString(10,fromdate1);
            pstmt.setInt(11,eamount1);
            pstmt.setInt(12,pamount1);
            pstmt.setString(13,Syear1);
            pstmt.setString(14,Eyear1);
            pstmt.setInt(15,totfine1);
            pstmt.setInt(16,damount1);
            pstmt.setInt(17,paying1);
            pstmt.setString(18,feestatus);
            pstmt.setInt(19,pfine1);
            pstmt.setInt(20,curfine1);
            pstmt.setString(21,section1);
            pstmt.setString(22,buscode1);
            pstmt.setString(23,route1);
            pstmt.setString(24,tripnum1);
            pstmt.setString(25,mn1);
                      
          pstmt.executeUpdate();   
          pstmt=null;
         
          String fsq="insert into transfinerecord(srnum,fsubdate,todate,fromdate,Syear,Eyear,due,status,exemptby,classes,section,sname,buscode,route,tripnum,mnt)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";  
        
            pstmt=cn.prepareStatement(fsq); 
            pstmt.setInt(1,srnum1);
            pstmt.setString(2,feesubdate1);
            pstmt.setString(3,todate1);
            pstmt.setString(4,fromdate1);
            pstmt.setString(5,Syear1);
            pstmt.setString(6,Eyear1);
            pstmt.setInt(7,pamount1);
            pstmt.setString(8,finestatus);
            pstmt.setString(9,exemptby);
            pstmt.setString(10,classes1);
            pstmt.setString(11,section1);
            pstmt.setString(12,sname1);
            pstmt.setString(13,buscode1);
            pstmt.setString(14,route1);
            pstmt.setString(15,tripnum1);
            pstmt.setString(16,mn1);
           
            pstmt.executeUpdate();   
          pstmt=null;
           
                   
            String sub=new String(" "+srnum1+" fee is entered");

                       request.setAttribute("sub",sub);
                       RequestDispatcher  rd1  =request.getRequestDispatcher("/tfdisp.do"); 
                       rd1.forward(request,response); 
            }
                 
          else
          {
 
         java.util.Date tdt=sdf2.parse(request.getParameter("tdate"));
         String st=sdf1.format(tdt);
        // out.println("DateSonal"+st);
              
         String by="Select "+st+" from transfeemonthrec where (Syear='"+Syear1+"' or Eyear='"+Syear1+"') and srnum='"+srnum1+"' ";
           out.println(by);
           stmt=cn.createStatement();
           rs1=stmt.executeQuery(by); 
           rs1.next();
           String feemon=rs1.getString(""+st+"");  out.println("feemon22"+feemon);
           feemon=feemon.trim();
           if(feemon.equals("paid"))
           {
             String sub=new String(" "+srnum1+" fee is already entered");

                    request.setAttribute("sub",sub);
                    RequestDispatcher  rd1  =request.getRequestDispatcher("/sfdisp.do"); 
                    rd1.forward(request,response); 
               }
               else
               {
          int fee= Integer.parseInt(request.getParameter("tcfee"));   
         int curfine= Integer.parseInt(request.getParameter("curfine"));
         int pfine= Integer.parseInt(request.getParameter("pfine"));
         
         String feesubdate=request.getParameter("feesubdate");
         java.util.Date fsbd=sdf2.parse(feesubdate);
         String mn=sdf.format(fsbd);  
         
         String todate=(String)request.getParameter("tdate");  out.println("todate"+todate);
         String fromdate=(String)request.getParameter("fdate");   out.println("fromdate"+fromdate);
         String Eyear=request.getParameter("Eyear"); 
         int srnum=Integer.parseInt(request.getParameter("srnum").toString()); 
         String Syear=request.getParameter("Syear"); 
         String dnum=request.getParameter("dnum"); 
         String ddate=request.getParameter("ddate"); 
         String bankname=request.getParameter("bankname");
         String section=request.getParameter("section");
         int eamount= Integer.parseInt(request.getParameter("finalEamount"));  
         int pamount= Integer.parseInt(request.getParameter("finalDamount"));
         int damount= Integer.parseInt(request.getParameter("damount"));   
         int paying= Integer.parseInt(request.getParameter("paid")); 
         int nom= Integer.parseInt(request.getParameter("nom"));  
         String route=request.getParameter("route"); 
         String tripnum=request.getParameter("tripnum"); 
         String buscode=request.getParameter("buscode"); 
         String tfeebook=request.getParameter("tfeebook"); 
       
         int totfine=curfine+pfine;
         
          if(pamount==0)
         {
             finestatus="NoDues";

          String sqw="select rowid,status from transfinerecord where srnum='"+srnum+"' order by rowid desc";
             stmt2=cn.createStatement();
             rs2=stmt2.executeQuery(sqw);
             rs2.next();
              int rid=rs2.getInt("rowid");
             String sta=rs2.getString("status");
             if(sta.equals("DueNotpaid"))
             {
        String sql1="update transfinerecord set status='Paid' where rowid='"+rid+"'";
         out.println(sql1);
         stmt1=cn.createStatement();
         stmt1.executeUpdate(sql1);
             }
         }else
         {
            finestatus="DueNotpaid";
         }
         
         try
          {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
                          
      try
       {
              HashSet hst1=new HashSet(); 
               HashMap hst2=new HashMap(); 
               
           java.util.Date sdt1=sdf2.parse(request.getParameter("fdate"));
           java.util.Date tdt1=sdf2.parse(request.getParameter("tdate"));
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

                    while(ir1.hasNext()) 
        {
              pk1=(String)ir1.next(); 
             String pk2=(String)hst2.get(pk1); 
               
         String sql1="update transfeemonthrec set "+pk1+"='paid' where srnum='"+request.getParameter("srnum")+"' and (Syear='"+request.getParameter("Syear")+"' or Eyear='"+request.getParameter("Syear")+"')";
          out.println(sql1);
         
         stmt1=cn.createStatement();
         stmt1.executeUpdate(sql1);    
         
         int subfee=fee/nom;
         
           String sqf="insert into transfeedetailreport(srnum,sname,classes,section,month,amount,fsubdate,buscode,route,tripnum,syear,eyear,mnt)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";  
          
            pstmt=cn.prepareStatement(sqf); 
            pstmt.setInt(1,srnum);
            pstmt.setString(2,sname1);
            pstmt.setString(3,classes1);
            pstmt.setString(4,section);
            pstmt.setString(5,pk1);
            pstmt.setInt(6,subfee);
            pstmt.setString(7,feesubdate);
            pstmt.setString(8,buscode);
            pstmt.setString(9,route);
            pstmt.setString(10,tripnum);
            pstmt.setString(11,Syear);
            pstmt.setString(12,Eyear);
            pstmt.setString(13,pk2);
            pstmt.executeUpdate();   
            pstmt=null;
           }
    
            String sq="insert into transfeerecord(srnum,studentname,class,amountpaid,dnum,ddate,bankname,fsubdate,todate,fromdate,eamount,pamount,Syear,Eyear,totfine,chkamount,paying,feestatus,pfine,mfine,section,buscode,route,tripnum,tfeebook,mnt)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";  
            out.println(sq);
            pstmt=cn.prepareStatement(sq); 
            pstmt.setInt(1,srnum);
            pstmt.setString(2,sname1);
            pstmt.setString(3,classes1);
            pstmt.setInt(4,fee);
            pstmt.setString(5,dnum);
            pstmt.setString(6,ddate);
            pstmt.setString(7,bankname);
            pstmt.setString(8,feesubdate);
            pstmt.setString(9,todate);
            pstmt.setString(10,fromdate);
            pstmt.setInt(11,eamount);
            pstmt.setInt(12,pamount);
            pstmt.setString(13,Syear);
            pstmt.setString(14,Eyear);
            pstmt.setInt(15,totfine);
            pstmt.setInt(16,damount);
            pstmt.setInt(17,paying);
            pstmt.setString(18,feestatus);
            pstmt.setInt(19,pfine);
            pstmt.setInt(20,curfine);
            pstmt.setString(21,section);
            pstmt.setString(22,buscode);
            pstmt.setString(23,route);
            pstmt.setString(24,tripnum);
            pstmt.setString(25,tfeebook);
            pstmt.setString(26,mn);
                      
          pstmt.executeUpdate();   
          pstmt=null;
         
          String fsq="insert into transfinerecord(srnum,fsubdate,todate,fromdate,Syear,Eyear,due,status,exemptby,classes,section,sname,buscode,route,tripnum,mnt)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";  
        
            pstmt=cn.prepareStatement(fsq); 
            pstmt.setInt(1,srnum);
            pstmt.setString(2,feesubdate);
            pstmt.setString(3,todate);
            pstmt.setString(4,fromdate);
            pstmt.setString(5,Syear);
            pstmt.setString(6,Eyear);
            pstmt.setInt(7,pamount);
            pstmt.setString(8,finestatus);
            pstmt.setString(9,exemptby);
            pstmt.setString(10,classes1);
            pstmt.setString(11,section);
            pstmt.setString(12,sname1);
            pstmt.setString(13,buscode);
            pstmt.setString(14,route);
            pstmt.setString(15,tripnum);
            pstmt.setString(16,mn);
           
            pstmt.executeUpdate();   
          pstmt=null;
           
                   
        String sub=new String(" "+srnum+" fee is entered");

                       request.setAttribute("sub",sub);
                       RequestDispatcher  rd1  =request.getRequestDispatcher("/tfdisp.do"); 
                       rd1.forward(request,response); 
           
        
         }catch(Exception e)
          {} 
                       
               }
            
           try
           {
              if(rs!=null)
             {rs.close();}
             if(pstmt!=null)
             {pstmt.close();}
              if(stmt!=null)
             {stmt.close();}
             if(cn!=null)
             {
                 cn.close();
             }
           }catch(SQLException e){}
          }
               
         return mapping.findForward("");
        
    }
}
       
                       
 