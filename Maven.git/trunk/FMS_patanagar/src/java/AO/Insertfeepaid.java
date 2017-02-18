
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

public class Insertfeepaid extends Action {
    
    
    PreparedStatement pstmt=null;
    PreparedStatement pstmt4=null;
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
    String regnum="";
    String Syear="";
    String Eyear="";
    String finestatus="";
    String latefee="";
    String exemptby="NotExempted";
    int rid=0;
    String st2="";
    
    private final static String SUCCESS = "success";
    
    
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Connection cn=null;
        PrintWriter out= response.getWriter();
        try{
            
        
        SimpleDateFormat sdf2=new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf1=new SimpleDateFormat("MMMMMMMMMMMM");
        SimpleDateFormat sdf=new SimpleDateFormat("MM");
        datediff dd=new datediff();
     
         try {
            DataConnection dc=new DataConnection();
            cn=(Connection)dc.Dataconnect();
        }catch(Exception e) {
        }
        
      int srn=Integer.parseInt(request.getParameter("srnum").toString()); 
          
       String sqlv="select year(current_date) as year";
       stmt=cn.createStatement();
       rs2=stmt.executeQuery(sqlv);
       String Syear2="";
       if(rs2.next()){
       Syear2=(String)rs2.getString("year");  
       }        
        java.util.Date tdtc=sdf2.parse(request.getParameter("tdate"));
        String stm=sdf1.format(tdtc);
      
        String by="Select "+stm+" from feemonthrec where (Syear='"+Syear2+"' or Eyear='"+Syear2+"') and srnum='"+srn+"' ";
     
        stmt=cn.createStatement();
           rs1=stmt.executeQuery(by); 
           String feemon="";
           if(rs1.next()){
           feemon=rs1.getString(stm);  
           }
           feemon=feemon.trim();
           if(feemon.equals("paid"))
           {  
               
             String sub=new String(" "+srn+" fee is already entered till "+stm);

                   request.setAttribute("sub",sub);
                   RequestDispatcher  rd2  =request.getRequestDispatcher("/fee/SubSchoolFee.jsp"); 
                   rd2.forward(request,response); 
               }
           
               else
               {
             stmt=null;
             rs2=null;
  
        double fee1= Double.parseDouble(request.getParameter("tcfee"));
        double feebc1= Double.parseDouble(request.getParameter("tfee"));
        String sname1=request.getParameter("sname");
        String sesdate1=request.getParameter("sesdate");
        String classes1=request.getParameter("classes");
        double curfine1= Double.parseDouble(request.getParameter("curfine"));
        double pfine1= Double.parseDouble(request.getParameter("pfine"));
        
        String feesubdate1=request.getParameter("feesubdate");
        java.util.Date fsb=sdf2.parse(feesubdate1);
        String mn1=sdf.format(fsb);
      
        String todate1=(String)request.getParameter("tdate");
        java.util.Date tm1=sdf2.parse(request.getParameter("tdate"));
        String tmon1=sdf1.format(tm1);
        String fromdate1=request.getParameter("fdate");
        java.util.Date fm1=sdf2.parse(request.getParameter("fdate"));
        String fmon1=sdf1.format(fm1);
        String Eyear1=request.getParameter("Eyear");
        String conchead1=request.getParameter("head");
        double concamt1= Double.parseDouble(request.getParameter("concamt"));
        int srnum1=Integer.parseInt(request.getParameter("srnum").toString());
        String Syear1=request.getParameter("Syear");
        String dnum1=request.getParameter("dnum");
        String ddate1=request.getParameter("ddate");
        String bankname1=request.getParameter("bankname");
        String section1=request.getParameter("section");
        String sfeebook1=request.getParameter("sfeebook");
        double eamount1= Double.parseDouble(request.getParameter("finalEamount"));
        double pamount1= Double.parseDouble(request.getParameter("finalDamount"));
        double damount1= Double.parseDouble(request.getParameter("damount"));
        double paying1= Double.parseDouble(request.getParameter("paid"));
        int nom1= Integer.parseInt(request.getParameter("nom"));
        
        
        double totfine1=curfine1+pfine1;
        if(pamount1==0) {
            finestatus="NoDues";
            
        }else {
            finestatus="DueNotpaid";
            
        }
        
                
        
        String byr="Select srnum from feerecord where (Syear='"+Syear1+"' or Eyear='"+Syear1+"') and srnum='"+srnum1+"' ";
       
        stmt=cn.createStatement();
        rs1=stmt.executeQuery(byr);
        if(rs1.next()==false) {
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
            
            while(ir1.hasNext()) {
                pk1=(String)ir1.next();
                String pk2=(String)hst2.get(pk1);
                
                
                String sql1="update feemonthrec set "+pk1+"='paid' where srnum='"+request.getParameter("srnum")+"' and (Syear='"+request.getParameter("Syear")+"' or Eyear='"+request.getParameter("Syear")+"')";
                
                stmt1=cn.createStatement();
                stmt1.executeUpdate(sql1);
                
            }
            
             String bpy="Select fromdate,dnum from feerecord where (Syear='"+Syear1+"' or Eyear='"+Syear1+"') and srnum='"+srnum1+"' and feestatus='bounced' order by str_to_date(todate,'%d/%m/%Y') desc  ";
             Statement stmt8=cn.createStatement();
             ResultSet rs8=stmt8.executeQuery(bpy);        
            if(rs8.next()==false)
            {
            
            String sqf="insert into feedetailreport(srnum,sname,classes,section,month,amount,fsubdate,syear,eyear,mnt,conchead,concamt)(select srnum,sname,classes,section,month,amount,fsubdate,syear,eyear,mnt,conchead,concamt from tempfee)";
            pstmt=cn.prepareStatement(sqf);
            pstmt.executeUpdate();
            pstmt=null;
            
            String sq="insert into feerecord(srnum,studentname,class,amountpaid,dnum,ddate,bankname,fsubdate,todate,fromdate,eamount,pamount,Syear,Eyear,totfine,chkamount,paying,feestatus,pfine,mfine,section,sfeebook,mnt,conchead,concamt)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            
            String fsq="insert into finerecord(srnum,fsubdate,todate,fromdate,Syear,Eyear,due,status,exemptby,classes,section,sname,mnt)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pstmt=cn.prepareStatement(fsq);
            pstmt.setInt(1,srnum1);
            pstmt.setString(2,feesubdate1);
            pstmt.setString(3,todate1);
            pstmt.setString(4,fromdate1);
            pstmt.setString(5,Syear1);
            pstmt.setString(6,Eyear1);
            pstmt.setDouble(7,pamount1);
            pstmt.setString(8,finestatus);
            pstmt.setString(9,exemptby);
            pstmt.setString(10,classes1);
            pstmt.setString(11,section1);
            pstmt.setString(12,sname1);
            pstmt.setString(13,mn1);
            
            pstmt.executeUpdate();
            pstmt=null;
            
            String del="delete from tempfee";
            stmt=cn.createStatement();
            stmt.executeUpdate(del);
            stmt=null;
            
            
/********************************Prepare Receipt************************************/
        
        String st4="";
        double headfee=0.0;
        double hfeetot=0.0;
        int rnum1=0;
        int rnum=0;
        HashMap hm1=new HashMap();
        ArrayList array=new ArrayList();
        
          String fhs="Select rnum from setrnum";
              stmt=cn.createStatement();  
              rs=stmt.executeQuery(fhs);  
              if(rs.next()){
              rnum=rs.getInt("rnum");
              }
              rnum1=rnum+1;
            
       String fh="Select heads from feeheads";
              stmt=cn.createStatement();
              rs=stmt.executeQuery(fh);   
              while(rs.next())
              {
                 SchoolEO seo1=new SchoolEO();
                 //seo1.setHeads(rs.getString("heads")); 
                 array.add(rs.getString("heads")); 
              }
            
            HashSet hst=new HashSet();
           
            java.util.Date sdt=sdf2.parse(request.getParameter("fdate"));
            java.util.Date tdt=sdf2.parse(request.getParameter("tdate"));
            ArrayList ddj=new ArrayList();
            ddj=(ArrayList)dd.getDatesBetween(sdt,tdt);
            for(int i=0;i<ddj.size();i++){
                java.util.Date dt=(java.util.Date)ddj.get(i);
                st4=sdf1.format(dt);
                hst.add(st4);
               
            }
            String pk="";
            
            for(int i=0;i<array.size();i++)
            {
                   hfeetot=0.0;
           Iterator ir=(Iterator)hst.iterator();
            while(ir.hasNext()) {
                headfee=0.0;
                pk=(String)ir.next();               // String pk2=(String)hst2.get(pk1);
                
           String fhv="Select fees from feechartdyna where month='"+pk+"' and heads='"+array.get(i)+"' and classes='"+classes1+"'";     
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
            request.setAttribute("tmon",tmon1);
            request.setAttribute("fmon",fmon1);
            request.setAttribute("syear",Syear1);
            request.setAttribute("eyear",Eyear1);
            request.setAttribute("sname",sname1);
            request.setAttribute("classes",classes1);
            request.setAttribute("feesubdate",feesubdate1);
            request.setAttribute("sec",section1);
            request.setAttribute("rnum",new Integer(rnum));
            request.setAttribute("fee",new Double(fee1));
            request.setAttribute("feebc",new Double(feebc1));
            request.setAttribute("eamount",new Double(eamount1));
            request.setAttribute("pamount",new Double(pamount1));
            request.setAttribute("paying",new Double(paying1));
          
  String fsh="insert into feereceipt(srnum,feebc,feeac,rnum,todate,fromdate,Syear,Eyear,head,headfee,conchead,concamt,classes,section,eamount,pamount,sname,fsubdate,paying)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
   
     for(int j=0;j<array.size();j++)
     {
             
     pstmt=cn.prepareStatement(fsh);
                pstmt.setInt(1,srnum1);
                pstmt.setDouble(2,feebc1);
                pstmt.setDouble(3,fee1);
                pstmt.setInt(4,rnum);
                pstmt.setString(5,todate1);
                pstmt.setString(6,fromdate1);
                pstmt.setString(7,Syear1);
                pstmt.setString(8,Eyear1);
                pstmt.setString(9,array.get(j).toString());
                pstmt.setDouble(10,Double.parseDouble(hm1.get(array.get(j)).toString()));
                pstmt.setString(11,conchead1);
                pstmt.setDouble(12,concamt1);
                pstmt.setString(13,classes1);
                pstmt.setString(14,section1);
                pstmt.setDouble(15,eamount1);
                pstmt.setDouble(16,pamount1);
                pstmt.setString(17,sname1);
                pstmt.setString(18,feesubdate1);
                pstmt.setDouble(19,paying1);
                
                pstmt.executeUpdate();
               
     }    
     
      String sqlset="update setrnum set rnum='"+rnum1+"'";
          
         stmt1=cn.createStatement();
         stmt1.executeUpdate(sqlset);  
     
            }
             
            else   //chk bounce cond
            {  
           String bouncefdate=rs8.getString("fromdate");  
            String bdnum=rs8.getString("dnum"); 
            if(bouncefdate.equals(fromdate1))
            {
                
             String bnc="delete from feerecord where dnum='"+bdnum+"' and srnum='"+srnum1+"'"; 
             pstmt=cn.prepareStatement(bnc);             
             pstmt.executeUpdate();
             pstmt=null;  
                 
              String sqf="insert into feedetailreport(srnum,sname,classes,section,month,amount,fsubdate,syear,eyear,mnt,conchead,concamt)(select srnum,sname,classes,section,month,amount,fsubdate,syear,eyear,mnt,conchead,concamt from tempfee)";
            pstmt=cn.prepareStatement(sqf);
            pstmt.executeUpdate();
            pstmt=null;
            
            String sq="insert into feerecord(srnum,studentname,class,amountpaid,dnum,ddate,bankname,fsubdate,todate,fromdate,eamount,pamount,Syear,Eyear,totfine,chkamount,paying,feestatus,pfine,mfine,section,sfeebook,mnt,conchead,concamt)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            
            String fsq="insert into finerecord(srnum,fsubdate,todate,fromdate,Syear,Eyear,due,status,exemptby,classes,section,sname,mnt)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pstmt=cn.prepareStatement(fsq);
            pstmt.setInt(1,srnum1);
            pstmt.setString(2,feesubdate1);
            pstmt.setString(3,todate1);
            pstmt.setString(4,fromdate1);
            pstmt.setString(5,Syear1);
            pstmt.setString(6,Eyear1);
            pstmt.setDouble(7,pamount1);
            pstmt.setString(8,finestatus);
            pstmt.setString(9,exemptby);
            pstmt.setString(10,classes1);
            pstmt.setString(11,section1);
            pstmt.setString(12,sname1);
            pstmt.setString(13,mn1);
            
            pstmt.executeUpdate();
            pstmt=null;
            
            String del="delete from tempfee";
            stmt=cn.createStatement();
            stmt.executeUpdate(del);
            stmt=null;
            
            
/********************************Prepare Receipt************************************/
        
        String st4="";
        double headfee=0.0;
        double hfeetot=0.0;
        int rnum1=0;
        int rnum=0;
        HashMap hm1=new HashMap();
        ArrayList array=new ArrayList();
        
          String fhs="Select rnum from setrnum";
              stmt=cn.createStatement();  
              rs=stmt.executeQuery(fhs);  
              rs.next();
              rnum=rs.getInt("rnum");
              rnum1=rnum+1;
            
       String fh="Select heads from feeheads";
              stmt=cn.createStatement();
              rs=stmt.executeQuery(fh);   
              while(rs.next())
              {
                 SchoolEO seo1=new SchoolEO();
                 //seo1.setHeads(rs.getString("heads")); 
                 array.add(rs.getString("heads")); 
              }
            
            HashSet hst=new HashSet();
           
            java.util.Date sdt=sdf2.parse(request.getParameter("fdate"));
            java.util.Date tdt=sdf2.parse(request.getParameter("tdate"));
            ArrayList ddj=new ArrayList();
            ddj=(ArrayList)dd.getDatesBetween(sdt,tdt);
            for(int i=0;i<ddj.size();i++){
                java.util.Date dt=(java.util.Date)ddj.get(i);
                st4=sdf1.format(dt);
                hst.add(st4);
               
            }
            String pk="";
            
            for(int i=0;i<array.size();i++)
            {
                   hfeetot=0.0;
           Iterator ir=(Iterator)hst.iterator();
            while(ir.hasNext()) {
                headfee=0.0;
                pk=(String)ir.next();               // String pk2=(String)hst2.get(pk1);
                
           String fhv="Select fees from feechartdyna where month='"+pk+"' and heads='"+array.get(i)+"' and classes='"+classes1+"'";
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
            request.setAttribute("tmon",tmon1);
            request.setAttribute("fmon",fmon1);
            request.setAttribute("syear",Syear1);
            request.setAttribute("eyear",Eyear1);
            request.setAttribute("sname",sname1);
            request.setAttribute("classes",classes1);
            request.setAttribute("feesubdate",feesubdate1);
            request.setAttribute("sec",section1);
            request.setAttribute("rnum",new Integer(rnum));
            request.setAttribute("fee",new Double(fee1));
            request.setAttribute("feebc",new Double(feebc1));
            request.setAttribute("eamount",new Double(eamount1));
            request.setAttribute("pamount",new Double(pamount1));
            request.setAttribute("paying",new Double(paying1));
          
  String fsh="insert into feereceipt(srnum,feebc,feeac,rnum,todate,fromdate,Syear,Eyear,head,headfee,conchead,concamt,classes,section,eamount,pamount,sname,fsubdate,paying)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
   
     for(int j=0;j<array.size();j++)
     {
             
     pstmt=cn.prepareStatement(fsh);
                pstmt.setInt(1,srnum1);
                pstmt.setDouble(2,feebc1);
                pstmt.setDouble(3,fee1);
                pstmt.setInt(4,rnum);
                pstmt.setString(5,todate1);
                pstmt.setString(6,fromdate1);
                pstmt.setString(7,Syear1);
                pstmt.setString(8,Eyear1);
                pstmt.setString(9,array.get(j).toString());
                pstmt.setDouble(10,Double.parseDouble(hm1.get(array.get(j)).toString()));
                pstmt.setString(11,conchead1);
                pstmt.setDouble(12,concamt1);
                pstmt.setString(13,classes1);
                pstmt.setString(14,section1);
                pstmt.setDouble(15,eamount1);
                pstmt.setDouble(16,pamount1);
                pstmt.setString(17,sname1);
                pstmt.setString(18,feesubdate1);
                pstmt.setDouble(19,paying1);
                
                pstmt.executeUpdate();
               
     }    
     
      String sqlset="update setrnum set rnum='"+rnum1+"'";
          
         stmt1=cn.createStatement();
         stmt1.executeUpdate(sqlset);       
                 
            }
     
        
              
/**********************************************************************************/            
            
//            String sub=new String(" "+srnum1+" fee is entered");
//            request.setAttribute("sub",sub);
//            RequestDispatcher  rd1  =request.getRequestDispatcher("/sfdisp.do");
//          //    RequestDispatcher  rd1  =request.getRequestDispatcher("/frec.do?srnum="+srnum1+"&fromdate="+fromdate1+"&feebc="+feebc1+"&todate="+todate1);
//       //     RequestDispatcher  rd1  =request.getRequestDispatcher("/frec.do");
//            rd1.forward(request,response);
        }
        }   
       
        else {
            
            double fee= Double.parseDouble(request.getParameter("tcfee"));
            double feebc= Double.parseDouble(request.getParameter("tfee"));
            String sname=request.getParameter("sname");
            String sesdate=request.getParameter("sesdate");
            String classes=request.getParameter("classes");
            double curfine= Double.parseDouble(request.getParameter("curfine"));
            double pfine= Double.parseDouble(request.getParameter("pfine"));
            String feesubdate=request.getParameter("feesubdate");
            java.util.Date fsbd=sdf2.parse(feesubdate);
            String mn=sdf.format(fsbd);
            
            double tfee= Double.parseDouble(request.getParameter("tfee"));
            String todate=(String)request.getParameter("tdate");
            java.util.Date tm=sdf2.parse(request.getParameter("tdate"));
            String tmon=sdf1.format(tm);
            String fromdate=request.getParameter("fdate");
            java.util.Date fm=sdf2.parse(request.getParameter("fdate"));
            String fmon=sdf1.format(fm);
            String Eyear=request.getParameter("Eyear");
            int srnum=Integer.parseInt(request.getParameter("srnum").toString());
            String conchead=request.getParameter("head");
            double concamt= Double.parseDouble(request.getParameter("concamt"));
            String Syear=request.getParameter("Syear");
            String dnum=request.getParameter("dnum");
            String ddate=request.getParameter("ddate");
            String bankname=request.getParameter("bankname");
            String section=request.getParameter("section");
            String sfeebook=request.getParameter("sfeebook");
            double eamount= Double.parseDouble(request.getParameter("finalEamount"));
            double pamount= Double.parseDouble(request.getParameter("finalDamount"));
            double damount= Double.parseDouble(request.getParameter("damount"));
            double paying= Double.parseDouble(request.getParameter("paid"));
            int nom= Integer.parseInt(request.getParameter("nom"));
            
            double totfine=curfine+pfine;
            
            if(pamount==0) {
                finestatus="NoDues";

                String sqw="select rowid,status from finerecord where srnum='"+srnum+"' order by rowid desc";
                stmt2=cn.createStatement();
                rs2=stmt2.executeQuery(sqw);
                if(rs2.next())
                {
                  int rid=rs2.getInt("rowid");
                }
                String sta=rs2.getString("status");
                if(sta.equals("DueNotpaid")) {
                    String sql1="update finerecord set status='Paid' where rowid='"+rid+"'";
                    stmt1=cn.createStatement();
                    stmt1.executeUpdate(sql1);
                }
            } else {
                finestatus="DueNotpaid";
            }
            
            try {
                DataConnection dc=new DataConnection();
                cn=(Connection)dc.Dataconnect();
            }catch(Exception e) {
            }
            
            try {
                
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
                
                while(ir1.hasNext()) {
                    pk1=(String)ir1.next();
                    String pk2=(String)hst2.get(pk1);
                    
                    String sql1="update feemonthrec set "+pk1+"='paid' where srnum='"+request.getParameter("srnum")+"' and (Syear='"+request.getParameter("Syear")+"' or Eyear='"+request.getParameter("Syear")+"')";
                    stmt1=cn.createStatement();
                    stmt1.executeUpdate(sql1);
                    
                }
           //////chk bounce cond /////     
           String bpy="Select fromdate,dnum from feerecord where (Syear='"+Syear1+"' or Eyear='"+Syear1+"') and srnum='"+srnum+"' and feestatus='bounced' order by str_to_date(todate,'%d/%m/%Y') desc  ";
            Statement stmt8=cn.createStatement();
            ResultSet rs8=stmt8.executeQuery(bpy);        
            if(rs8.next()==false)
            {
            
                String sqf="insert into feedetailreport(srnum,sname,classes,section,month,amount,fsubdate,syear,eyear,mnt,conchead,concamt)(select srnum,sname,classes,section,month,amount,fsubdate,syear,eyear,mnt,conchead,concamt from tempfee)";
                pstmt=cn.prepareStatement(sqf);
                pstmt.executeUpdate();
                pstmt=null;
                
                String sq="insert into feerecord(srnum,studentname,class,amountpaid,dnum,ddate,bankname,fsubdate,todate,fromdate,eamount,pamount,Syear,Eyear,totfine,chkamount,paying,feestatus,pfine,mfine,section,sfeebook,mnt,conchead,concamt)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                pstmt=cn.prepareStatement(sq);
                pstmt.setInt(1,srnum);
                pstmt.setString(2,sname);
                pstmt.setString(3,classes);
                pstmt.setDouble(4,fee);
                pstmt.setString(5,dnum);
                pstmt.setString(6,ddate);
                pstmt.setString(7,bankname);
                pstmt.setString(8,feesubdate);
                pstmt.setString(9,todate);
                pstmt.setString(10,fromdate);
                pstmt.setDouble(11,eamount);
                pstmt.setDouble(12,pamount);
                pstmt.setString(13,Syear);
                pstmt.setString(14,Eyear);
                pstmt.setDouble(15,totfine);
                pstmt.setDouble(16,damount);
                pstmt.setDouble(17,paying);
                pstmt.setString(18,feestatus);
                pstmt.setDouble(19,pfine);
                pstmt.setDouble(20,curfine);
                pstmt.setString(21,section);
                pstmt.setString(22,sfeebook);
                pstmt.setString(23,mn1);
                pstmt.setString(24,conchead);
                pstmt.setDouble(25,concamt);
                
                pstmt.executeUpdate();
                pstmt=null;
                
                
                String fsq="insert into finerecord(srnum,fsubdate,todate,fromdate,Syear,Eyear,due,status,exemptby,classes,section,sname,mnt)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
                pstmt=cn.prepareStatement(fsq);
                pstmt.setInt(1,srnum);
                pstmt.setString(2,feesubdate);
                pstmt.setString(3,todate);
                pstmt.setString(4,fromdate);
                pstmt.setString(5,Syear);
                pstmt.setString(6,Eyear);
                pstmt.setDouble(7,pamount);
                pstmt.setString(8,finestatus);
                pstmt.setString(9,exemptby);
                pstmt.setString(10,classes1);
                pstmt.setString(11,section);
                pstmt.setString(12,sname1);
                pstmt.setString(13,mn);
                
                pstmt.executeUpdate();
                pstmt=null;
                
                String del="delete from tempfee";
                stmt=cn.createStatement();
                stmt.executeUpdate(del);
                stmt=null;

     /****************************Prepare Receipt***********************************/
        String st4="";
        double headfee=0.0;
        double hfeetot=0.0;
        int rnum1=0;
        int rnum=0;
        HashMap hm1=new HashMap();
        ArrayList array=new ArrayList();
        
        String fhs="Select rnum from setrnum";
      
              stmt=cn.createStatement();  
              rs=stmt.executeQuery(fhs);  
             rs.next();
             rnum=rs.getInt("rnum");
             rnum1=rnum+1;
            
            
       String fh="Select heads from feeheads";
              stmt=cn.createStatement();  
              rs=stmt.executeQuery(fh);  
              while(rs.next()) 
              {
                 SchoolEO seo1=new SchoolEO();
               //  seo1.setHeads(rs.getString("heads")); 
                 array.add(rs.getString("heads")); 
              }  
            
            HashSet hst=new HashSet();
           
            java.util.Date sdt=sdf2.parse(request.getParameter("fdate"));
            java.util.Date tdt=sdf2.parse(request.getParameter("tdate"));
            ArrayList ddj=new ArrayList();
            ddj=(ArrayList)dd.getDatesBetween(sdt,tdt);
            for(int i=0;i<ddj.size();i++){
                java.util.Date dt=(java.util.Date)ddj.get(i);
                st4=sdf1.format(dt);
                hst.add(st4);
               
            }
            String pk="";
            
            for(int i=0;i<array.size();i++)
            {
                hfeetot=0.0;
            Iterator ir=(Iterator)hst.iterator();
            while(ir.hasNext()) {
                headfee=0.0;
                pk=(String)ir.next();
               // String pk2=(String)hst2.get(pk1);
                
           String fhv="Select fees from feechartdyna where month='"+pk+"' and heads='"+array.get(i)+"' and classes='"+classes+"'";
             
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
            request.setAttribute("tmon",tmon);
            request.setAttribute("fmon",fmon);
            request.setAttribute("syear",Syear);
            request.setAttribute("eyear",Eyear);
            request.setAttribute("sname",sname);
            request.setAttribute("classes",classes);
            request.setAttribute("feesubdate",feesubdate);
            request.setAttribute("sec",section);
            request.setAttribute("rnum",new Integer(rnum));
            request.setAttribute("fee",new Double(fee));
            request.setAttribute("feebc",new Double(feebc));
            request.setAttribute("eamount",new Double(eamount));
            request.setAttribute("pamount",new Double(pamount));
            request.setAttribute("paying",new Double(paying1));
            
 /***************************Submit Receipt******************************************/ 

     
     String fsh="insert into feereceipt(srnum,feebc,feeac,rnum,todate,fromdate,Syear,Eyear,head,headfee,conchead,concamt,classes,section,eamount,pamount,sname,fsubdate,paying)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
   
     for(int j=0;j<array.size();j++)
     {
             
     pstmt=cn.prepareStatement(fsh);
                pstmt.setInt(1,srnum);
                pstmt.setDouble(2,feebc);
                pstmt.setDouble(3,fee);
                pstmt.setInt(4,rnum);
                pstmt.setString(5,todate);
                pstmt.setString(6,fromdate);
                pstmt.setString(7,Syear);
                pstmt.setString(8,Eyear);
                pstmt.setString(9,array.get(j).toString());
                pstmt.setDouble(10,Double.parseDouble(hm1.get(array.get(j)).toString()));
                pstmt.setString(11,conchead);
                pstmt.setDouble(12,concamt);
                pstmt.setString(13,classes);
                pstmt.setString(14,section);
                pstmt.setDouble(15,eamount);
                pstmt.setDouble(16,pamount);
                pstmt.setString(17,sname);
                pstmt.setString(18,feesubdate);
                pstmt.setDouble(19,paying1);
                
                pstmt.executeUpdate();
           
     }    
     
            
     String sqlset="update setrnum set rnum='"+rnum1+"'";
          
         stmt1=cn.createStatement();
         stmt1.executeUpdate(sqlset);    
         
            }
             
            else
            {
              
            String bouncefdate=rs8.getString("fromdate"); 
            String bdnum=rs8.getString("dnum");
            if(bouncefdate.equals(fromdate))
            {
                
             String bnc="delete from feerecord where dnum='"+bdnum+"' and srnum='"+srnum+"'"; 
             pstmt=cn.prepareStatement(bnc);             
             pstmt.executeUpdate();
             pstmt=null;       
                 
                 
                String sqf="insert into feedetailreport(srnum,sname,classes,section,month,amount,fsubdate,syear,eyear,mnt,conchead,concamt)(select srnum,sname,classes,section,month,amount,fsubdate,syear,eyear,mnt,conchead,concamt from tempfee)";
                pstmt=cn.prepareStatement(sqf);
                pstmt.executeUpdate();
                pstmt=null;
                
                String sq="insert into feerecord(srnum,studentname,class,amountpaid,dnum,ddate,bankname,fsubdate,todate,fromdate,eamount,pamount,Syear,Eyear,totfine,chkamount,paying,feestatus,pfine,mfine,section,sfeebook,mnt,conchead,concamt)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                pstmt=cn.prepareStatement(sq);
                pstmt.setInt(1,srnum);
                pstmt.setString(2,sname);
                pstmt.setString(3,classes);
                pstmt.setDouble(4,fee);
                pstmt.setString(5,dnum);
                pstmt.setString(6,ddate);
                pstmt.setString(7,bankname);
                pstmt.setString(8,feesubdate);
                pstmt.setString(9,todate);
                pstmt.setString(10,fromdate);
                pstmt.setDouble(11,eamount);
                pstmt.setDouble(12,pamount);
                pstmt.setString(13,Syear);
                pstmt.setString(14,Eyear);
                pstmt.setDouble(15,totfine);
                pstmt.setDouble(16,damount);
                pstmt.setDouble(17,paying);
                pstmt.setString(18,feestatus);
                pstmt.setDouble(19,pfine);
                pstmt.setDouble(20,curfine);
                pstmt.setString(21,section);
                pstmt.setString(22,sfeebook);
                pstmt.setString(23,mn1);
                pstmt.setString(24,conchead);
                pstmt.setDouble(25,concamt);
                
                pstmt.executeUpdate();
                pstmt=null;
                
                
                String fsq="insert into finerecord(srnum,fsubdate,todate,fromdate,Syear,Eyear,due,status,exemptby,classes,section,sname,mnt)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
                pstmt=cn.prepareStatement(fsq);
                pstmt.setInt(1,srnum);
                pstmt.setString(2,feesubdate);
                pstmt.setString(3,todate);
                pstmt.setString(4,fromdate);
                pstmt.setString(5,Syear);
                pstmt.setString(6,Eyear);
                pstmt.setDouble(7,pamount);
                pstmt.setString(8,finestatus);
                pstmt.setString(9,exemptby);
                pstmt.setString(10,classes1);
                pstmt.setString(11,section);
                pstmt.setString(12,sname1);
                pstmt.setString(13,mn);
                
                pstmt.executeUpdate();
                pstmt=null;
                
                String del="delete from tempfee";
                stmt=cn.createStatement();
                stmt.executeUpdate(del);
                stmt=null;

     /****************************Prepare Receipt***********************************/
        String st4="";
        double headfee=0.0;
        double hfeetot=0.0;
        int rnum1=0;
        int rnum=0;
        HashMap hm1=new HashMap();
        ArrayList array=new ArrayList();
        
        String fhs="Select rnum from setrnum";
      
              stmt=cn.createStatement();  
              rs=stmt.executeQuery(fhs);  
             rs.next();
             rnum=rs.getInt("rnum");
             rnum1=rnum+1;
            
            
       String fh="Select heads from feeheads";
              stmt=cn.createStatement();  
              rs=stmt.executeQuery(fh);  
              while(rs.next()) 
              {
                 SchoolEO seo1=new SchoolEO();
               //  seo1.setHeads(rs.getString("heads")); 
                 array.add(rs.getString("heads")); 
              }  
            
            HashSet hst=new HashSet();
           
            java.util.Date sdt=sdf2.parse(request.getParameter("fdate"));
            java.util.Date tdt=sdf2.parse(request.getParameter("tdate"));
            ArrayList ddj=new ArrayList();
            ddj=(ArrayList)dd.getDatesBetween(sdt,tdt);
            for(int i=0;i<ddj.size();i++){
                java.util.Date dt=(java.util.Date)ddj.get(i);
                st4=sdf1.format(dt);
                hst.add(st4);
               
            }
            String pk="";
            
            for(int i=0;i<array.size();i++)
            {
                hfeetot=0.0;
            Iterator ir=(Iterator)hst.iterator();
            while(ir.hasNext()) {
                headfee=0.0;
                pk=(String)ir.next();
               // String pk2=(String)hst2.get(pk1);
                
           String fhv="Select fees from feechartdyna where month='"+pk+"' and heads='"+array.get(i)+"' and classes='"+classes+"'";
             
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
            request.setAttribute("tmon",tmon);
            request.setAttribute("fmon",fmon);
            request.setAttribute("syear",Syear);
            request.setAttribute("eyear",Eyear);
            request.setAttribute("sname",sname);
            request.setAttribute("classes",classes);
            request.setAttribute("feesubdate",feesubdate);
            request.setAttribute("sec",section);
            request.setAttribute("rnum",new Integer(rnum));
            request.setAttribute("fee",new Double(fee));
            request.setAttribute("feebc",new Double(feebc));
            request.setAttribute("eamount",new Double(eamount));
            request.setAttribute("pamount",new Double(pamount));
            request.setAttribute("paying",new Double(paying1));
            
 /***************************Submit Receipt******************************************/ 

     
     String fsh="insert into feereceipt(srnum,feebc,feeac,rnum,todate,fromdate,Syear,Eyear,head,headfee,conchead,concamt,classes,section,eamount,pamount,sname,fsubdate,paying)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
   
     for(int j=0;j<array.size();j++)
     {
             
     pstmt=cn.prepareStatement(fsh);
                pstmt.setInt(1,srnum);
                pstmt.setDouble(2,feebc);
                pstmt.setDouble(3,fee);
                pstmt.setInt(4,rnum);
                pstmt.setString(5,todate);
                pstmt.setString(6,fromdate);
                pstmt.setString(7,Syear);
                pstmt.setString(8,Eyear);
                pstmt.setString(9,array.get(j).toString());
                pstmt.setDouble(10,Double.parseDouble(hm1.get(array.get(j)).toString()));
                pstmt.setString(11,conchead);
                pstmt.setDouble(12,concamt);
                pstmt.setString(13,classes);
                pstmt.setString(14,section);
                pstmt.setDouble(15,eamount);
                pstmt.setDouble(16,pamount);
                pstmt.setString(17,sname);
                pstmt.setString(18,feesubdate);
                pstmt.setDouble(19,paying1);
                
                pstmt.executeUpdate();
           
     }    
     
            
     String sqlset="update setrnum set rnum='"+rnum1+"'";
          
         stmt1=cn.createStatement();
         stmt1.executeUpdate(sqlset);    
               
             
             
            }    
            }
      
/**********************************************************************************/  
               
                
            }catch(Exception e) {
            }
            
        }
       } 
        
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
        }catch(SQLException e){}

              
         }catch(Exception e){out.println(e.getMessage());}

        return mapping.findForward("success");
        
    }
}
