///*

// * Dispregforfee.java
// *
// * Created on August 22, 2008, 4:57 PM
// */
//

//package AO;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.apache.struts.action.Action;
//import org.apache.struts.action.ActionForm;
//import org.apache.struts.action.ActionMapping;
//import org.apache.struts.action.ActionForward;
//import org.apache.struts.action.DynaActionForm;
//import com.myapp.struts.DataConnection;
//import java.sql.*;
//import java.util.*;
//import AO.datediff.*;
//import EO.SchoolEO;
//import java.io.PrintWriter;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.http.HttpSession;
//import java.lang.NullPointerException;
//import java.text.SimpleDateFormat;
///**
// *
// * @author sonal
// * @version
// */
//
//public class DispTransFee extends Action {
//    
//    Connection cn=null;
//    Statement stmt=null;
//    Statement stmt3=null;
//    Statement stmt5=null;
//    PreparedStatement pstmt=null;
//    PreparedStatement pstmt1=null;
//    ResultSet rs1=null;
//    ResultSet rs=null;
//    ResultSet rs2=null;
//    ResultSet rs3=null;
//    ResultSet rs5=null;
//    
//    String Syear="";
//    int Eyear=0;
//    String month="";
//    String status="";
//    String sesdate="";
//    String lastdate="";
//    String cs="";
//    String fee="";
//    String fe="";
//    String tdate="";
//    String fsubdate="";
//    int tution=0;
//    String Cyear="";
//    String StYear="";
//    String EdYear="";
//    String st="";
//    String st1="";
//            
//    int finestatus=0;
//    int amountpaid=0;
//    int eamount=0;
//    int pamount=0;
//    int Totalfee=0;
//    int nom=0;
//    int ampaid=0;
//    int lastrec=0;
//    int lastrecfine=0;
//    int due=0;
//    int bdue=0;
//    int dueamount=0;
//    int total=0;
//    int busfee=0;
//    int bfee=0;
//  //  int fee1=0;  
//       
//    private final static String SUCCESS = "success";
//    
//    public ActionForward execute(ActionMapping mapping, ActionForm  form,
//            HttpServletRequest request, HttpServletResponse response)
//            throws Exception {
//        
//          SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
//          SimpleDateFormat sdf1=new SimpleDateFormat("MMMMMMMMMMMM");
//          SimpleDateFormat sdfd=new SimpleDateFormat("dd");
//          
//          PrintWriter out= response.getWriter();
//        //  GregorianCalendar calendar=Calendar.getInstance();
//        //  out.println("Hello"+calendar.get(Calendar.APRIL));
//          SchoolEO seo=new SchoolEO();
//          ArrayList arr=new ArrayList();
//          datediff dd=new datediff();          
//        
//          try
//       {
//           DataConnection dc=new DataConnection();
//           cn=(Connection)dc.Dataconnect();
//          }catch(Exception e)
//          {}
//  
// /******************************Displaying Detail of fees and student*************************/
//          
//          String disp=request.getParameter("dis"); out.println(disp);
//       
//          if(disp!=null)
//          {
//          try
//          {
//           String srnum=request.getParameter("srnum1"); out.println(srnum);
//           String tfeebook=request.getParameter("tfeebook"); out.println(srnum);
//           String feesubdate=request.getParameter("feesubdate");  out.println(feesubdate);
//           java.util.Date fcurdate=sdf.parse(feesubdate); 
//           String pday1=sdfd.format(fcurdate); 
//           int pday=Integer.parseInt(pday1);  
//            
//    String sql1="select year(current_date) as year ,DATE_FORMAT(current_date,'%M') as month";
//       
//             stmt=cn.createStatement();
//             rs2=stmt.executeQuery(sql1);
//          
//        rs2.next();
//         
//                 Syear=(String)rs2.getString("year");  
//                 month=(String)rs2.getString("month"); 
//               
//             stmt=null;
//             rs2=null;
//        String gety="select Syear,Eyear from oldstudregis where (srnum='"+srnum+"' or tfeebook='"+tfeebook+"')";
//         out.println("gety"+gety);
//             stmt=cn.createStatement();
//             rs2=stmt.executeQuery(gety);
//             rs2.next();
//              StYear=rs2.getString("Syear");   
//              EdYear=rs2.getString("Eyear");   
//        
//             stmt=null;
//             rs2=null;
//             
//             if(StYear.equals(Syear) || EdYear.equals(Syear))
//             {
//              out.println("hello");   
//           HashSet hs=new HashSet();   
//           
//           String fromdate=request.getParameter("fromdate");   
//           java.util.Date dt1=sdf.parse(fromdate);
//           String todate=request.getParameter("todate");   
//           java.util.Date dt2=sdf.parse(todate);
//           ArrayList dd1=new ArrayList();
//           dd1=(ArrayList)dd.getDatesBetween(dt1,dt2);
//           for(int i=0;i<dd1.size();i++){
//           java.util.Date dt=(java.util.Date)dd1.get(i);    
//           Integer in=new Integer(dt.getMonth());           
//           hs.add(in);
//           }               
//           int nom=hs.size();  
//          out.println("nom"+nom);
//   
//           String getclreg="select syear,eyear,srnum,sname,classes,section,concession,head,route,buscode,tripnum,transfeebook from studacaddetail where (Syear='"+Syear+"' or Eyear='"+Syear+"') and (srnum='"+srnum+"' or transfeebook='"+tfeebook+"')";
//            out.println("getclreg"+getclreg);
//           pstmt=cn.prepareStatement(getclreg);
//            rs=pstmt.executeQuery();
//       
//           while(rs.next())
//           {
//                seo.setSrnum(rs.getString("srnum"));
//                seo.setSname(rs.getString("sname"));
//                seo.setClasses(rs.getString("classes"));
//                seo.setEyear(rs.getString("eyear"));
//                seo.setSyear(rs.getString("syear"));
//                seo.setSection(rs.getString("section"));
//                seo.setConcession(rs.getDouble("concession"));
//                seo.setRoute(rs.getString("route"));
//                seo.setBuscode(rs.getString("buscode"));
//                seo.setTripnum(rs.getString("tripnum"));
//                seo.setHeads(rs.getString("head"));
//                seo.setTfeebooknum(rs.getString("transfeebook"));
//           }   
//            
//          arr.add(seo);
// out.println(arr);
// pstmt=null;
// rs=null;
//            
// /**********************************Calculating Submitted Fee*********************************/
//     ////////////////finding months////////////////// 
//        HashSet hst=new HashSet(); 
//          
//           java.util.Date dt4=sdf.parse(fromdate);
//           java.util.Date dt5=sdf.parse(todate);
//           ArrayList dd8=new ArrayList();
//           dd8=(ArrayList)dd.getDatesBetween(dt4,dt5);
//           for(int i=0;i<dd8.size();i++){
//           java.util.Date dts=(java.util.Date)dd8.get(i);    
//           st=sdf1.format(dts);           
//           hst.add(st);           
//           }  
//           String pk="";
//           Iterator ir=(Iterator)hst.iterator(); 
//             int Totalfee=0;
//             int fe1=0;
//            while(ir.hasNext()){
//            pk=(String)ir.next();    
//          out.println("hi");
//    String am="select busfee from transportfee where route='"+seo.getRoute()+"'"; 
//    out.println("amr"+am);
//             pstmt=cn.prepareStatement(am);
//             rs=pstmt.executeQuery();
//   
//        rs.next();
//        fe1=rs.getInt("busfee"); 
//    
//         Totalfee= Totalfee+fe1;       
//  
//    String amtf="select busfee from transportfee where route='"+seo.getRoute()+"'"; 
//    out.println("amr"+amtf);
//             pstmt1=cn.prepareStatement(amtf);
//             rs1=pstmt1.executeQuery();
//             rs1.next();
//        bfee=rs1.getInt("busfee"); 
//     
//        }
//   
//  if(seo.getConcession().equals("NoConcession"))
//  {
//      busfee=bfee*nom;
//  }else if(seo.getConcession().equals("SchoolWard"))
//  {
//       busfee=0;        
//  }else if(seo.getConcession().equals("Sibling"))
//  {
//      busfee=bfee*nom;  
//                
//  }  
//          pstmt=null;
//          rs=null;
//          pstmt1=null;
//          rs1=null;
//          
//             
//          
///******************************Calculating Last Record Of fees************************************/
//                
//     String ss="Select sesdate from oldstudregis where (Syear='"+Syear+"' or Eyear='"+Syear+"') and (srnum='"+srnum+"' or tfeebook='"+tfeebook+"')";
//         out.println(ss);
//             stmt3=cn.createStatement();
//             rs3=stmt3.executeQuery(ss);
//    
//        while(rs3.next())
//        { 
//          sesdate=(String)rs3.getString("sesdate");    out.println(sesdate);
//        }
//            HashSet hs1=new HashSet();  
//           java.util.Date sdt=sdf.parse(sesdate);
//           java.util.Date tdt=sdf.parse(todate);
//           ArrayList cd=new ArrayList();
//           cd=(ArrayList)dd.getDatesBetween(sdt,tdt);
//           for(int k=0;k<cd.size();k++){
//           java.util.Date dte=(java.util.Date)cd.get(k);    
//           Integer ine=new Integer(dte.getMonth());           
//           hs1.add(ine);
//           }               
//           int nomn=hs1.size();    out.println("ses"+nomn);
//           
//          ///////////////cal lastrec///////////// 
//            HashSet hst1=new HashSet(); 
//        
//           java.util.Date sdt1=sdf.parse(sesdate);
//           java.util.Date tdt1=sdf.parse(todate);
//           ArrayList ddw=new ArrayList();
//           ddw=(ArrayList)dd.getDatesBetween(sdt1,tdt1);
//           for(int i=0;i<ddw.size();i++){
//           java.util.Date dt=(java.util.Date)ddw.get(i);    
//           st1=sdf1.format(dt);           
//           hst1.add(st1);
//           }  String pk1="";
//           int fe2=0; 
//           int lastrec=0;
//              Iterator ir1=(Iterator)hst1.iterator(); 
//            while(ir1.hasNext()){
//              pk1=(String)ir1.next();   
//           
//    String am1="select busfee from transportfee where route='"+seo.getRoute()+"'"; 
//    out.println("am1"+am1);
//             pstmt=cn.prepareStatement(am1);
//             rs=pstmt.executeQuery();
//   
//       while(rs.next())
//       {  //out.println("hello");
//        fe2=rs.getInt("busfee"); 
//       
//         lastrec=lastrec+fe2;   out.println("lastrec"+lastrec);
//       //  int lastrec= Integer.parseInt(fee);  out.println("NEWtfee"+Totalfee);   
//       }
//       }
//         //  int lastrec=nomn*fee1;    //out.println("lastrec"+lastrec);
//
// stmt3=null;
// rs3=null;
// pstmt=null;
// rs=null;
// 
///**************************************Calculating Fine for current month*************************************/
//     String fn="Select lastdate,fine from finestructure ";
//
//             stmt3=cn.createStatement();
//             rs3=stmt3.executeQuery(fn);
//    
//        rs3.next();
//        
//               lastdate=rs3.getString("lastdate"); out.println(lastdate);
//               finestatus=rs3.getInt("fine");       out.println(finestatus);
//             int lstdate= Integer.parseInt(lastdate);    out.println(lstdate);
//             
//      stmt3=null;
//      rs3=null;
//  
///********Calculating total fine  till the current date and checking status of draft************/   
//    
//    String amo="Select eamount,pamount,amountpaid from transfeerecord where (Syear='"+Syear+"' or Eyear='"+Syear+"') and (srnum='"+srnum+"' or tfeebook='"+tfeebook+"') order by rowid desc ";
//         out.println("amo"+amo);
//             stmt3=cn.createStatement();
//             rs3=stmt3.executeQuery(amo);
//    
//       if(rs3.next()==false)
//        {
//                 eamount=0; out.println(eamount);
//                 pamount=0;     out.println("pamount"+pamount);
//                 amountpaid=0;
//        }
//       else
//        { 
//               eamount=rs3.getInt("eamount");    out.println("eamount"+eamount);
//               pamount=rs3.getInt("pamount");      out.println("pamount"+pamount);
//                
//        }
//     
//             stmt3=null;
//             rs3=null;
//       String tfn="Select todate from transfeerecord where (Syear='"+Syear+"' or Eyear='"+Syear+"') and (srnum='"+srnum+"' or tfeebook='"+tfeebook+"') order by rowid desc  ";
//       out.println("tfn"+tfn);
//             stmt3=cn.createStatement();
//             rs3=stmt3.executeQuery(tfn);
//    
//         if(rs3.next()==false)
//     {
//         lastrecfine=0;
//        
//         fsubdate="No Fee Submitted for the current session";
//            out.println("fsubdate"+fsubdate);
//     }
//    
//            else
//               {
//                  fsubdate=rs3.getString("todate");  out.println("fsubdate"+fsubdate);
//                   
//               HashSet hs2=new HashSet();  
//           java.util.Date fsubdt=sdf.parse(fsubdate);
//          // java.util.Date cdt=sdf.parse(cdate);
//           ArrayList fsd=new ArrayList();
//           fsd=(ArrayList)dd.getDatesBetween(fsubdt,fcurdate);
//           for(int j=0;j<fsd.size();j++){
//           java.util.Date fsdt=(java.util.Date)fsd.get(j);    
//           Integer infs=new Integer(fsdt.getMonth());           
//           hs2.add(infs);
//           }               
//           int fmon=hs2.size()-2;     
//          // int dam=hs2.size();  
//           
//           if(fmon<=0)
//           {
//              lastrecfine=0;   out.println("lastrecfine"+lastrecfine);
//              
//          } 
//           else
//           {
//               lastrecfine=fmon*finestatus;    out.println("lastrecfine"+lastrecfine);
//               
//            }
//            }
//           stmt3=null;
//          rs3=null;
//          pstmt=null;
//          rs=null;
//          
//  
// /*******************Calculating total amount paid till the current date******************/   
//         
//     String cam="Select todate from transfeerecord where (Syear='"+Syear+"' or Eyear='"+Syear+"') and (srnum='"+srnum+"' or tfeebook='"+tfeebook+"') order by rowid desc  ";
//     out.println("cam"+cam);
//             stmt3=cn.createStatement();
//             rs3=stmt3.executeQuery(cam); 
//      
//     if(rs3.next()==false)
//     {
//         tdate="00/00/0000";
//          out.println("tdate"+tdate);
//     }
//           else
//               {
//                     tdate=rs3.getString("todate");  
//               }
//              
//           ///////////////cal amppaid///////////// 
//            HashSet hst2=new HashSet(); 
//           
//           java.util.Date todt=sdf.parse(tdate);
//           ArrayList ddw1=new ArrayList();
//           ddw1=(ArrayList)dd.getDatesBetween(sdt,todt);
//           for(int i=0;i<ddw1.size();i++){
//           java.util.Date dt=(java.util.Date)ddw1.get(i);    
//           st1=sdf1.format(dt);           
//           hst2.add(st1);
//           } String pk4="";
//           int fe5=0;
//            int ampaid=0;
//           Iterator ir2=(Iterator)hst2.iterator(); 
//           while(ir2.hasNext()){
//            pk4=(String)ir2.next();       
//    String am2="select busfee from transportfee where route='"+seo.getRoute()+"'"; 
//    out.println("am2"+am2);
//             pstmt=cn.prepareStatement(am2);
//             rs=pstmt.executeQuery();
//   
//        rs.next();
//        fe5=rs.getInt("busfee"); 
//        //   int fe1= (fe);   out.println("NEWfe1"+fe1);
//         ampaid=ampaid+fe5;  out.println("ampaid"+ampaid);
//       //  int ampaid= Integer.parseInt(fee);  out.println("NEWtfee"+Totalfee);   
//        }
//           
//           // int ampaid=tmon*fee1;  
//            int total1=lastrec-ampaid;    
//              if(total1<=0)
//              {
//              total =0;    out.println("total"+total);
//              }
//              else
//              {
//                  total=total1;     out.println("total"+total);
//              }
//  stmt3=null;
//  rs3=null;   
// 
//           
//
// pstmt=null;
// rs=null;
// 
///***********************************Forwarding Data*****************************************/    
// 
//          request.setAttribute("array",arr);
//          request.setAttribute("month",month);
//          request.setAttribute("fee",fee);
//          request.setAttribute("feesubdate",feesubdate);
//          request.setAttribute("fsubdate",fsubdate);
//          request.setAttribute("Totalfee",new Integer(Totalfee));
//          request.setAttribute("busfee",new Integer(busfee));
//          request.setAttribute("eamount",new Integer(eamount));
//          request.setAttribute("pamount",new Integer(pamount));
//          request.setAttribute("total",new Integer(total));
//          request.setAttribute("lstdate",new Integer(lstdate));
//          request.setAttribute("pday",new Integer(pday));
//          request.setAttribute("finestatus",new Integer(finestatus));
//          request.setAttribute("lastrecfine",new Integer(lastrecfine));
//          request.setAttribute("nom",new Integer(nom));
//         
//          request.setAttribute("sesdate",sesdate);
//        }
//             else
//             {
//            out.println("no fee");
//                   String sub=new String("Plz enter the date with in session period ");
//
//                       request.setAttribute("sub",sub);
//                       RequestDispatcher  rd2  =request.getRequestDispatcher("/fee/SubSchoolFee.jsp"); 
//                       rd2.forward(request,response); 
//             }
//          }catch(SQLException ee)
//          {
//           //  out.println(ee);
//                ee.getStackTrace();
//            }
//          }
//          
////           try
////           {
////             if(stmt!=null)
////             {stmt.close();}
////             if(pstmt!=null)
////             {pstmt.close();}
////              if(stmt3!=null)
////             {stmt3.close();}
////             if(stmt5!=null)
////             {stmt5.close();}
////             if(rs!=null)
////             {rs.close();}
////             if(rs2!=null)
////             {rs2.close();}
////              if(rs3!=null)
////             {rs3.close();}
////             if(rs5!=null)
////             {rs5.close();}
////              if(cn!=null)
////             {
////                 cn.close();
////             }
// 
////           }catch(SQLException e){} 
////          }
//           
//                    // return mapping.findForward("");
//                      return mapping.findForward("success");
//          
//    }
//}
