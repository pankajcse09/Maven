

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

public class DispSrFee extends Action {
    
    Connection cn=null;
    Statement stmt=null;
    Statement stmt3=null;
    Statement stmt5=null;
    PreparedStatement pstmt=null;
    PreparedStatement pstmt1=null;
    PreparedStatement pstmt2=null;
    ResultSet rs1=null;
    ResultSet rs=null;
    ResultSet rs2=null;
    ResultSet rs3=null;
    ResultSet rs4=null;
    ResultSet rs5=null;
    
    private final static String SUCCESS = "success";
    
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
    
    String Syear="";
    int Eyear=0;
    String month="";
    String status="";
    String sesdate="";
    String head="";
    String lastdate="";
    String cs="";
    String fee="";
    String fe="";
    String tdate="";
    String fsubdate="";
    String Cyear="";
    String StYear="";
    String EdYear="";
    String st="";
    String st1="";
    
   
    double tution=0.0;
    double finestatus=0.0;
    double headfee=0.0;
    double amountpaid=0.0;
    double eamount=0.0;
    double pamount=0.0;
    double Totalfee=0.0;
    int nom=0;
    String st2="";
    double ampaid=0.0;
    double lastrec=0.0;
    double lastrecfine=0.0;
    double bouncepaying=0.0;
    double bouncepfine=0.0;
    double blastrecfine=0.0;
   // double lastrecfine=0.0;
    double due=0.0;
    double bdue=0.0;
    double dueamount=0.0;
    double total=0.0;
    double typefee=0.0;
    double TCFee=0.0;
    double conc=0.0;
    double totconc=0.0;
    double monhf=0.0;
   
        
          SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
          SimpleDateFormat sdf1=new SimpleDateFormat("MMMMMMMMMMMM");
          SimpleDateFormat sdfd=new SimpleDateFormat("dd");
          
          PrintWriter out= response.getWriter();
       
          SchoolEO seo=new SchoolEO();
          ArrayList arr=new ArrayList();
          datediff dd=new datediff();    
          
    ArrayList monarr=new ArrayList();
    monarr.add("July");
    monarr.add("August");
    monarr.add("September");
    monarr.add("October");
    monarr.add("November");
    monarr.add("December");
    monarr.add("January");
    monarr.add("February");
    monarr.add("March");
    monarr.add("April");
    monarr.add("May");
    monarr.add("June");
              
        
        
          try
       {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
          

 /******************************Displaying Detail of fees and student*************************/
          
          String disp=request.getParameter("dis"); 
       
          if(disp!=null)
          {
          try
          {
           String srnum=request.getParameter("srnum"); 
           String sfeebook=request.getParameter("sfeebook"); 
           String feesubdate=request.getParameter("feesubdate");  
           java.util.Date fcurdate=sdf.parse(feesubdate); 
           String pday1=sdfd.format(fcurdate); 
           int pday=Integer.parseInt(pday1);  
   
/***********************Check Is Fee is Submitted or not***********************************/
  
 String sqlv="select year(current_date) as year";
       stmt=cn.createStatement();
       rs2=stmt.executeQuery(sqlv);
       rs2.next();
       String Syear1=(String)rs2.getString("year");  
                
        java.util.Date tdtc=sdf.parse(request.getParameter("todate"));
        String stm=sdf1.format(tdtc);
      
        String by="Select "+stm+" from feemonthrec where (Syear='"+Syear1+"' or Eyear='"+Syear1+"') and srnum='"+srnum+"' ";
           stmt=cn.createStatement();
           rs1=stmt.executeQuery(by); 
           rs1.next();
           String feemon=rs1.getString(""+stm+"");  
           feemon=feemon.trim();
           if(feemon.equals("paid"))
           {  
             String sub=new String(" "+srnum+" fee is already entered till "+stm);

                   request.setAttribute("sub",sub);
                   RequestDispatcher  rd2  =request.getRequestDispatcher("/fee/SubSchoolFee.jsp"); 
                   rd2.forward(request,response); 
               }
           
               else
               {
             
          String ss="Select sesdate from oldstudregis where (Syear='"+Syear1+"' or Eyear='"+Syear1+"') and (srnum='"+srnum+"' or sfeebook='"+sfeebook+"')";
          stmt3=cn.createStatement();
          rs3=stmt3.executeQuery(ss);
    
        if(rs3.next())
        { 
          sesdate=(String)rs3.getString("sesdate"); 
        }
           
            HashSet hstt1=new HashSet(); 
        try{
           java.util.Date sdtt1=sdf.parse(sesdate);
           java.util.Date ffdt1=sdf.parse(request.getParameter("fromdate"));
           String stt1=sdf1.format(ffdt1);   
           int a=monarr.indexOf(stt1)-1;
           String pkk1=monarr.get(a).toString();
           
           
    String byy="Select "+pkk1+" from feemonthrec where (Syear='"+Syear1+"' or Eyear='"+Syear1+"') and srnum='"+srnum+"' ";
    
         Statement stmt6=cn.createStatement();
         ResultSet rs6=stmt6.executeQuery(byy); 
           rs6.next();
           String feemon1=rs6.getString(""+pkk1+""); 
           String feemon2=feemon1.trim();
           if(feemon2.equals("notpaid"))
           {  
             String sub=new String(" "+srnum+" fee not paid before "+stt1);

                   request.setAttribute("sub",sub);
                   RequestDispatcher  rd2  =request.getRequestDispatcher("/fee/SubSchoolFee.jsp"); 
                   rd2.forward(request,response); 
       
       }
            }catch(Exception e)
        {e.getMessage();}
             
             
             
             
             
         /*************************************************************************************/          
    String del="delete from tempfee";
    stmt=cn.createStatement();
    stmt.executeUpdate(del);
    stmt=null;
              
    String sql1="select year(current_date) as year ,DATE_FORMAT(current_date,'%M') as month";
       
             stmt=cn.createStatement();
             rs2=stmt.executeQuery(sql1);
          
        rs2.next();
         
                 Syear=(String)rs2.getString("year");  
                 month=(String)rs2.getString("month"); 
               
             stmt=null;
             rs2=null;
        String gety="select Syear,Eyear from oldstudregis where (srnum='"+srnum+"' or sfeebook='"+sfeebook+"')";
      
             stmt=cn.createStatement();
             rs2=stmt.executeQuery(gety);
             rs2.next();
             StYear=rs2.getString("Syear");   
             EdYear=rs2.getString("Eyear");   
        
             stmt=null;
             rs2=null;
             
             if(StYear.equals(Syear) || EdYear.equals(Syear))
             {
           
           HashSet hs=new HashSet();   
           
           String fromdate=request.getParameter("fromdate");   
           java.util.Date dt1=sdf.parse(fromdate);
           String todate=request.getParameter("todate");   
           java.util.Date dt2=sdf.parse(todate);
           ArrayList dd1=new ArrayList();
           dd1=(ArrayList)dd.getDatesBetween(dt1,dt2);
           for(int i=0;i<dd1.size();i++){
           java.util.Date dt=(java.util.Date)dd1.get(i);    
           Integer in=new Integer(dt.getMonth());           
           hs.add(in);
           }               
           nom=hs.size();  
           
        String getclreg="select syear,eyear,srnum,sname,classes,head,section,concession,feebooknum from studacaddetail where (Syear='"+Syear+"' or Eyear='"+Syear+"') and (srnum='"+srnum+"' or feebooknum='"+sfeebook+"')";
           pstmt=cn.prepareStatement(getclreg);
           rs=pstmt.executeQuery();
       
           while(rs.next())
           {
                seo.setSrnum(rs.getString("srnum"));
                seo.setSname(rs.getString("sname"));
                seo.setClasses(rs.getString("classes"));
                seo.setEyear(rs.getString("eyear"));
                seo.setSyear(rs.getString("syear"));
                seo.setSection(rs.getString("section"));
                seo.setHeads(rs.getString("head"));
                seo.setConcession(rs.getDouble("concession"));
                seo.setSfeebooknum(rs.getString("feebooknum"));                
                conc=seo.getConcession();
                totconc=conc/100;
           }   
            
          arr.add(seo);

 pstmt=null;
 rs=null;
 /**********************************Calculating Submitted Fee*********************************/
     ////////////////finding months////////////////// 
          HashSet hst=new HashSet(); 
          HashMap hst9=new HashMap(); 
          
           java.util.Date dt4=sdf.parse(fromdate);
           java.util.Date dt5=sdf.parse(todate);
           ArrayList dd8=new ArrayList();
           dd8=(ArrayList)dd.getDatesBetween(dt4,dt5);
           for(int i=0;i<dd8.size();i++){
           java.util.Date dts=(java.util.Date)dd8.get(i);    
           st=sdf1.format(dts);   
           st2=sdf1.format(dts);
           hst.add(st);  
           hst9.put(st,st2);
           }  
           String pk="";
           Iterator ir=(Iterator)hst.iterator(); 
              Totalfee=0.0;
             double fe1=0.0;
            while(ir.hasNext()){
            pk=(String)ir.next(); 
            String pk2=(String)hst9.get(pk); 
     
    String am="select totalfee from feestructdyna where classes='"+seo.getClasses()+"' and month='"+pk+"' "; 
             pstmt=cn.prepareStatement(am);
             rs=pstmt.executeQuery();
   
        rs.next();
        fe1=rs.getDouble("totalfee"); 
    
        Totalfee= Totalfee+fe1;         //Total Fees 
      
     
   if(seo.getHeads().equals("NoConcession")){
     headfee=0.0;        
     monhf=0.0;
   }else{         
   if(!seo.getHeads().equals("TotalFee") && !seo.getHeads().equals("NoConcession") )     
   {  
                    
    String amtf="select fees from feechartdyna where classes='"+seo.getClasses()+"' and month='"+pk+"' and heads='"+seo.getHeads()+"' "; 

             pstmt1=cn.prepareStatement(amtf);
             rs1=pstmt1.executeQuery();
             if(rs1.next())
             {
                typefee=rs1.getDouble("fees"); 
                  monhf=Math.ceil(typefee*totconc);
                  headfee=Math.ceil(headfee+(typefee*totconc));  
                 // TCFee=Totalfee-headfee;
              }
   }
   if(seo.getHeads().equals("TotalFee")){
    String amtf="select totalfee from feestructdyna where classes='"+seo.getClasses()+"' and month='"+pk+"'"; 
             pstmt1=cn.prepareStatement(amtf);
             rs1=pstmt1.executeQuery();
             if(rs1.next())
             {
                typefee=rs1.getDouble("totalfee");
                 monhf=Math.ceil(typefee*totconc);
                  headfee=Math.ceil(headfee+(typefee*totconc));  
                 // TCFee=Totalfee-headfee;
              }    
   }
   }

        
  String sqf="insert into tempfee(srnum,sname,classes,section,month,amount,fsubdate,syear,eyear,mnt,conchead,concamt)values(?,?,?,?,?,?,?,?,?,?,?,?)";  
          
            pstmt=cn.prepareStatement(sqf); 
            pstmt.setString(1,seo.getSrnum());
            pstmt.setString(2,seo.getSname());
            pstmt.setString(3,seo.getClasses());
            pstmt.setString(4,seo.getSection());
            pstmt.setString(5,pk);
            pstmt.setDouble(6,fe1);
            pstmt.setString(7,feesubdate);
            pstmt.setString(8,StYear);
            pstmt.setString(9,EdYear);
            pstmt.setString(10,pk2);    
            pstmt.setString(11,seo.getHeads());    
            pstmt.setDouble(12,monhf);    
         pstmt.executeUpdate();   
          pstmt=null;
            } //end while
         
         TCFee=Math.ceil(Totalfee-headfee);  // fee after concession           
       
          pstmt=null;
          rs=null;
          pstmt1=null;
          rs1=null;
/******************************Calculating Last Record Of fees************************************/
                 
     String ssd="Select sesdate from oldstudregis where (Syear='"+Syear+"' or Eyear='"+Syear+"') and (srnum='"+srnum+"' or sfeebook='"+sfeebook+"')";
          stmt3=cn.createStatement();
          rs3=stmt3.executeQuery(ssd);
    
        while(rs3.next())
        { 
          sesdate=(String)rs3.getString("sesdate"); 
        }
           HashSet hs1=new HashSet();  
           java.util.Date sdt=sdf.parse(sesdate);
           java.util.Date tdt=sdf.parse(todate);
           ArrayList cd=new ArrayList();
           cd=(ArrayList)dd.getDatesBetween(sdt,tdt);
           for(int k=0;k<cd.size();k++){
           java.util.Date dte=(java.util.Date)cd.get(k);    
           Integer ine=new Integer(dte.getMonth());           
           hs1.add(ine);
           }               
           int nomn=hs1.size();    
           
       
/**************************************Calculating Fine for current month*************************************/
      String fn="Select lastdate,fine from finestructure ";

             stmt3=cn.createStatement();
             rs3=stmt3.executeQuery(fn);
    
        rs3.next();
        
               lastdate=rs3.getString("lastdate"); 
               finestatus=rs3.getInt("fine");   
             int lstdate= Integer.parseInt(lastdate);   
             
      stmt3=null;
      rs3=null;
      
/********Calculating total fine  till the current date and checking status of draft************/   
  
      
      ////////////////////////////////////////////////////////////////////////////////////
      
       String sts="Select feestatus from feerecord where (Syear='"+Syear+"' or Eyear='"+Syear+"') and srnum='"+srnum+"' order by str_to_date(todate,'%d/%m/%Y') desc  ";
             stmt5=cn.createStatement();
             rs5=stmt5.executeQuery(sts);
                if(rs5.next())
         
            {

//                       RequestDispatcher  rd1  =request.getRequestDispatcher("dpsubmitfee.do"); 
////                       rd1.forward(request,response);  
//            }            
//            else{         
             String feestatus=rs5.getString("feestatus");  
             // fsubdate="No Fee Submitted for the current session";
        if(feestatus.equals("paid"))
        {
                 
      ///////////////////////////////////////////////////////////////////////////////////
      
      
    String amo="Select eamount,pamount,amountpaid from feerecord where (Syear='"+Syear+"' or Eyear='"+Syear+"') and (srnum='"+srnum+"' or sfeebook='"+sfeebook+"') order by rowid desc ";
           stmt3=cn.createStatement();
           rs3=stmt3.executeQuery(amo);
    
       if(rs3.next()==false)
        {
                 eamount=0; 
                 pamount=0;
                 amountpaid=0;
        }
       else
        { 
               eamount=rs3.getDouble("eamount"); 
               pamount=rs3.getDouble("pamount");   
                
        }
     
             stmt3=null;
             rs3=null;
       String tfn="Select todate from feerecord where (Syear='"+Syear+"' or Eyear='"+Syear+"') and (srnum='"+srnum+"' or sfeebook='"+sfeebook+"') order by rowid desc  ";
             stmt3=cn.createStatement();
             rs3=stmt3.executeQuery(tfn);
    
         if(rs3.next()==false)
     {
         lastrecfine=0;
          fsubdate="No Fee Submitted for the current session";
           
     }
    
            else
               {
                  fsubdate=rs3.getString("todate");  
                   
           HashSet hs2=new HashSet();  
           java.util.Date fsubdt=sdf.parse(fsubdate);
          // java.util.Date cdt=sdf.parse(cdate);
           ArrayList fsd=new ArrayList();
           fsd=(ArrayList)dd.getDatesBetween(fsubdt,fcurdate);
           for(int j=0;j<fsd.size();j++){
           java.util.Date fsdt=(java.util.Date)fsd.get(j);    
           Integer infs=new Integer(fsdt.getMonth());           
           hs2.add(infs);
           }               
           int fmon=hs2.size()-2;     
          // int dam=hs2.size();  
           
           if(fmon<=0)
           {
              lastrecfine=0;  
              
          } 
           else
           {
               lastrecfine=fmon*finestatus; 
               
            }
            }
           stmt3=null;
          rs3=null;
          pstmt=null;
          rs=null;
 /*******************Calculating total amount paid till the current date******************/   
         
      String cam="Select todate from feerecord where (Syear='"+Syear+"' or Eyear='"+Syear+"') and (srnum='"+srnum+"' or sfeebook='"+sfeebook+"') order by rowid desc  ";
          stmt3=cn.createStatement();
          rs3=stmt3.executeQuery(cam); 
      
     if(rs3.next()==false)
     {
         tdate="00/00/0000";
        
     }
           else
               {
                     tdate=rs3.getString("todate");  
               }
              
        
 
 ///////////////////////////////////////////////////////////////////////////////////////////////
 
 
         }else if(feestatus.equals("bounced"))
        {
         String bpy="Select paying,pfine from feerecord where (Syear='"+Syear+"' or Eyear='"+Syear+"') and srnum='"+srnum+"' order by str_to_date(todate,'%d/%m/%Y') desc  ";
      
             stmt3=cn.createStatement();
             rs3=stmt3.executeQuery(bpy);        
            rs3.next();
            bouncepaying=rs3.getDouble("paying");  
            bouncepfine=rs3.getDouble("pfine");
  stmt3=null;
  rs3=null;                 
        
    String amo="Select eamount,pamount,amountpaid from feerecord where (Syear='"+Syear+"' or Eyear='"+Syear+"') and srnum='"+srnum+"' order by str_to_date(todate,'%d/%m/%Y') desc ";
            stmt3=cn.createStatement();
             rs3=stmt3.executeQuery(amo);
    
       if(rs3.next()==false)
        {
                 eamount=0;
                 pamount=0;
                 amountpaid=0;
        }
       else
        { 
               eamount=rs3.getDouble("eamount"); 
               pamount=rs3.getDouble("pamount");   
                 
        }
             stmt3=null;
             rs3=null;
                
        String tfn="Select todate from feerecord where (Syear='"+Syear+"' or Eyear='"+Syear+"') and srnum='"+srnum+"' order by str_to_date(todate,'%d/%m/%Y') desc  ";
             stmt3=cn.createStatement();
             rs3=stmt3.executeQuery(tfn);
        
    rs3.next();   
     if(rs3.next()==false)
     {
         lastrecfine=0;
         fsubdate="No Fee Submitted for the current session";
        
     }
               else
               {
          //      rs3.next();
   
             fsubdate=rs3.getString("todate");  
                   
               HashSet hs2=new HashSet();  
           java.util.Date fsubdt=sdf.parse(fsubdate);
          // java.util.Date cdt=sdf.parse(cdate);
           ArrayList fsd=new ArrayList();
           fsd=(ArrayList)dd.getDatesBetween(fsubdt,fcurdate);
           for(int j=0;j<fsd.size();j++){
           java.util.Date fsdt=(java.util.Date)fsd.get(j);    
           Integer infs=new Integer(fsdt.getMonth());           
           hs2.add(infs);
           }               
           int fmon=hs2.size()-2;     
          // int dam=hs2.size();  
           
           if(fmon<=0)
           {
              lastrecfine=0;  
               due=0;        
          } 
           else
           {
               blastrecfine=fmon*finestatus;  
               lastrecfine=blastrecfine-bouncepfine;   
               
            }
            }   
           stmt3=null;
          rs3=null;  
           
 /*******************Calculating total amount paid till the current date******************/   
         
      String cam="Select todate from feerecord where (Syear='"+Syear+"' or Eyear='"+Syear+"') and srnum='"+srnum+"' order by str_to_date(todate,'%d/%m/%Y') desc  ";
   
             stmt3=cn.createStatement();
             rs3=stmt3.executeQuery(cam); 
      
   rs3.next();  
     if(rs3.next()==false)
     {
         tdate="00/00/0000"; 
     }    
     
            else
               {
  
                    tdate=rs3.getString("todate");  
              }
              
            }}
 
 
 
 
 
 
 
 
/***********************************Forwarding Data*****************************************/    
 
          request.setAttribute("array",arr);
          request.setAttribute("month",month);
          request.setAttribute("fee",fee);
          request.setAttribute("feesubdate",feesubdate);
          request.setAttribute("fsubdate",fsubdate);
          request.setAttribute("Totalfee",new Double(Totalfee));
          request.setAttribute("TCFee",new Double(TCFee));
          request.setAttribute("eamount",new Double(eamount));
          request.setAttribute("pamount",new Double(pamount));
       //   request.setAttribute("total",new Double(total));
          request.setAttribute("lstdate",new Double(lstdate));
          request.setAttribute("pday",new Integer(pday));
          request.setAttribute("finestatus",new Double(finestatus));
          request.setAttribute("lastrecfine",new Double(lastrecfine));
          request.setAttribute("nom",new Integer(nom));
          request.setAttribute("sesdate",sesdate);
          request.setAttribute("fromdate",fromdate);
          request.setAttribute("todate",todate);
          request.setAttribute("head",seo.getHeads());
          request.setAttribute("concamt",new Double(headfee));
        }
             else
             {
           
                   String sub=new String("Plz enter the date with in session period ");

                       request.setAttribute("sub",sub);
                       RequestDispatcher  rd2  =request.getRequestDispatcher("/fee/SubSchoolFee.jsp"); 
                       rd2.forward(request,response); 
             }
            }  //chk cond fee
          }catch(SQLException ee)
          {
             ee.getStackTrace();
          }
         
          } 
          
   
                      return mapping.findForward("success");
          
    }
}
