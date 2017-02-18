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
import java.io.*;
import AO.datediff.*;
import EO.SchoolEO;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.lang.NullPointerException;
import java.text.SimpleDateFormat;

public class DnUStudRecord extends Action {
    
    Connection cn=null;
    Statement stmt1=null;
    Statement stmt3=null;  
    PreparedStatement pst=null;
    PreparedStatement psmt2=null;
    PreparedStatement psmt3=null;
    ResultSet rs3=null;
    ResultSet rs4=null;
    ResultSet rs5=null;
    
   private final static String SUCCESS = "success";
    
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
          //PrintWriter out=response.getWriter();
          ArrayList arr=new ArrayList();          
          try{
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e){}  
 /******************************Displaying Detail of fees *************************/ 
          String disp=request.getParameter("disp");
          if(disp!=null){
           try{  
           String srnum=request.getParameter("srnum");      
           String sesn=request.getParameter("session"); 
            String sr="";
//           FileInputStream inspic=null;
        // String eyear=request.getParameter("eyear");    
        EO.SchoolEO gt=new EO.SchoolEO();
        String qry="select * from studentregis where srnum='"+srnum+"' and session='"+sesn+"'";        
        stmt3=cn.createStatement();
          rs3=stmt3.executeQuery(qry);  
          if(rs3.next()){  
          gt.setSession(rs3.getString("session"));    
          gt.setSrnum(rs3.getString("srnum"));   
          gt.setSname(rs3.getString("studname"));
          gt.setDob(rs3.getString("dob"));
          gt.setGender(rs3.getString("gender")); 
          gt.setNationality(rs3.getString("nationality"));
          gt.setFname(rs3.getString("fname"));
          gt.setMname(rs3.getString("mname")); 
          gt.setAddress(rs3.getString("paddress"));
          gt.setRnum(rs3.getString("pphone"));
          gt.setMobile(rs3.getString("pmobile"));
          gt.setSeekadd(rs3.getString("seekadd"));
          gt.setYearRegist(rs3.getString("year_regist"));
          gt.setClassRegist(rs3.getString("class_regist"));  
          gt.setStandard(rs3.getString("standard"));
          //gt.setType(rs3.getString("type"));
          gt.setCategory(rs3.getString("category"));
          gt.setAdminType(rs3.getString("admin_type"));
          gt.setDomicile(rs3.getString("domicile"));
          gt.setHighSchool(rs3.getDouble("highper"));
          gt.setIntermediate(rs3.getDouble("interper"));
          gt.setHighMm(rs3.getDouble("high_max_marks"));
          gt.setHighObt(rs3.getDouble("high_obt_marks"));  
          gt.setInterMm(rs3.getDouble("inter_max_marks"));      
          gt.setInterObt(rs3.getDouble("inter_obt_marks")); 
          gt.setHighBoard(rs3.getString("high_board"));
          gt.setInterBoard(rs3.getString("inter_board"));
          gt.setPrevBoard(rs3.getString("prev_board"));
          }else{
          String qr2="select * from oldregis where srnum='"+srnum+"' and session='"+sesn+"'";       
          stmt3=cn.createStatement();
          rs3=stmt3.executeQuery(qr2);  
          if(rs3.next()){    
          gt.setSession(rs3.getString("session"));    
          gt.setSrnum(rs3.getString("srnum"));
          gt.setSname(rs3.getString("studname"));
          gt.setDob(rs3.getString("dob"));
          gt.setGender(rs3.getString("gender"));
          gt.setNationality(rs3.getString("nationality"));
          gt.setFname(rs3.getString("fname"));
          gt.setMname(rs3.getString("mname"));
          gt.setAddress(rs3.getString("paddress"));
          gt.setRnum(rs3.getString("pphone"));
          gt.setMobile(rs3.getString("pmobile"));
          gt.setSeekadd(rs3.getString("seekadd"));
          gt.setYearRegist(rs3.getString("year_regist"));
          gt.setClassRegist(rs3.getString("class_regist"));          
          gt.setStandard(rs3.getString("standard"));
          //gt.setType(rs3.getString("type"));
          gt.setCategory(rs3.getString("category"));
          gt.setAdminType(rs3.getString("admin_type"));
          gt.setDomicile(rs3.getString("domicile"));
          gt.setPrevMm(rs3.getDouble("prev_max_marks"));
          gt.setPrevObt(rs3.getDouble("prev_obt_marks"));
          gt.setPpercent(rs3.getDouble("prevper"));
          gt.setPrevBoard(rs3.getString("prev_board"));
          }
          }   
          sr=gt.getSrnum(); 
          request.setAttribute("arr",gt);
          request.setAttribute("sr",sr);
          request.setAttribute("session",sesn);    
          
          //////////////////////////////   
//try{
//int returnValue = 0;
//InputStream in = null;
//OutputStream os = null;
//Blob blob = null;
////String path2=request.getContextPath()+("/image")+"/pic.jpg";
//String path=request.getRealPath("/image")+"\\pic.jpg"; 
// String query=""; 
// if(gt.getHighMm()!=0 && gt.getInterMm()!=0){
// query="select pic from studentregis where srnum='"+srnum+"' and session='"+sesn+"'";      
// }else{
// query="select pic from oldregis where srnum='"+srnum+"' and session='"+sesn+"'";     
// }
////cn.setAutoCommit(false);
//Statement stmt = cn.createStatement();
//ResultSet rs = stmt.executeQuery(query);
//int i=1;
//if(rs.next()){
//String len1 = rs.getString("pic");
//int len = len1.length();
//byte [] b = new byte[len];
//in = rs.getBinaryStream("pic");
//int index = in.read(b, 0, len);
//OutputStream outImej = new FileOutputStream(path);       
//while (index != -1){
//outImej.write(b, 0, index);
//index = in.read(b, 0, len);
//}
//outImej.close();
//i++;
//}else{
//returnValue = 1;
//}
//}
//catch(Exception e){} 
         ///////////////////////////////             
          }catch(SQLException ee){}          
             try{
             if(rs3!=null)
             {rs3.close();}
             if(stmt3!=null)
             {stmt3.close();}
             if(cn!=null){cn.close();}
           }catch(SQLException e){}          
             return mapping.findForward("success");
             }
 /***********************************Insert Data*****************************************/          
     ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
           String enter=request.getParameter("enter");
          if(enter!=null){
          try{
           String sesn=request.getParameter("session"); 
           String srnum=request.getParameter("srnum"); 
           String sname=request.getParameter("sname");
           String gender=request.getParameter("gender"); 
           String dob=request.getParameter("dob");
           String nationality=request.getParameter("nationality"); 
           String fname=request.getParameter("fname"); 
           String mname=request.getParameter("mname");
           String padd=request.getParameter("padd"); 
           String pnum=request.getParameter("pnum"); 
           String pmobile=request.getParameter("pmobile"); 
           String seekadd=request.getParameter("seekadd");        
           String yrr=request.getParameter("year_regist");
           String cr=request.getParameter("class_regist");      
           String stand=request.getParameter("standard");
           //String typ=request.getParameter("type");
           String cat=request.getParameter("category");
           String admTyp=request.getParameter("admin_type"); 
//         String img5=request.getParameter("pic");
           String domcil=request.getParameter("domicile");          
           
            double highmm=0.0;
            double highobt=0.0;
            double intermm=0.0;
            double interobt=0.0;            
            double hsp=0.0;
            double inp=0.0;
            String hboard="";
            String iboard=""; 
            double prevmm=0.0;
            double prevobt=0.0;
            double prevp=0.0;
            String pboard=""; 
   
        try{
        highmm=Double.parseDouble(request.getParameter("highmm"));
        }catch(NumberFormatException ne){}  
            
        try{
        highobt=Double.parseDouble(request.getParameter("highobt"));
        }catch(NumberFormatException ne){}            
            
        try{
        intermm=Double.parseDouble(request.getParameter("intermm"));
        }catch(NumberFormatException ne){}     
        
        try{
        interobt=Double.parseDouble(request.getParameter("interobt"));
        }catch(NumberFormatException ne){}    
            
          try{
          hsp=Double.parseDouble(request.getParameter("highper"));
          }catch(NumberFormatException ne){}          
          try{
          inp=Double.parseDouble(request.getParameter("interper"));
          }catch(NumberFormatException ne){}   
   
        try{
        prevmm=Double.parseDouble(request.getParameter("prevmm"));
        }catch(NumberFormatException ne){}              
        try{
        prevobt=Double.parseDouble(request.getParameter("prevobt"));
        }catch(NumberFormatException ne){}              
         try{
         prevp=Double.parseDouble(request.getParameter("prevper"));
         }catch(NumberFormatException ne){}    
      
         hboard=request.getParameter("highboard"); 
         iboard=request.getParameter("interboard"); 
         pboard=request.getParameter("prevboard");    
//         double imgsize=0.0;  
       String qr1="select count(srnum) as cnt from studentregis where srnum='"+srnum+"' and session='"+sesn+"'";
       String qr2="select count(srnum) as cnt from oldregis where srnum='"+srnum+"' and session='"+sesn+"'";
       psmt2=cn.prepareStatement(qr1);
       rs4=psmt2.executeQuery();
       rs4.next();       
if(rs4.getInt("cnt")>0){      
//if(img5.equals("")){
//  imgsize=0.0;  
  String sql1="update studentregis set studname='"+sname+"',gender='"+gender+"',dob='"+dob+"',nationality='"+nationality+"',fname='"+fname+"',mname='"+mname+"',paddress='"+padd+"',pphone='"+pnum+"',pmobile='"+pmobile+"',seekadd='"+seekadd+"',year_regist='"+yrr+"',class_regist='"+cr+"',standard='"+stand+"',category='"+cat+"',highper="+hsp+",interper="+inp+",admin_type='"+admTyp+"',high_max_marks="+highmm+",high_obt_marks="+highobt+",inter_max_marks="+intermm+",inter_obt_marks="+interobt+",prev_mm='"+prevmm+"',prev_obt='"+prevobt+"',prev_per='"+prevp+"',domicile='"+domcil+"',high_board='"+hboard+"',inter_board='"+iboard+"',prev_board='"+pboard+"' where srnum='"+srnum+"' and session='"+sesn+"'";
  stmt1=cn.createStatement();
  stmt1.executeUpdate(sql1);
//}else{                    
//       String img1=request.getParameter("pic");
//       int a=img1.length();
//       int b=img1.lastIndexOf("\\"); 
//       String path=request.getParameter("pic"); 
//       String f1=img1.substring(b+1,a);           
//       StringBuffer sb=new StringBuffer();
//       File imgfile = new File(path);
//       imgsize=imgfile.length();
//       FileInputStream fin1 = new FileInputStream(imgfile);  
//       if(imgsize>100000){
//         String sub=new String("Image Size Should not be greater than 100 KB");
//         request.setAttribute("sub",sub);
//         RequestDispatcher rd1=request.getRequestDispatcher("dsrec.do?disp=disp&srnum="+srnum+"&session="+sesn); 
//         rd1.forward(request,response); 
//         }else{
//   String qry="update studentregis set pic=? where srnum='"+srnum+"' and session='"+sesn+"'";
//   pst=cn.prepareStatement(qry);
//   pst.setBinaryStream(1,fin1,(int)imgfile.length());
//   pst.executeUpdate();
//String sq2="update studentregis set studname='"+sname+"',gender='"+gender+"',dob='"+dob+"',nationality='"+nationality+"',fname='"+fname+"',mname='"+mname+"',paddress='"+padd+"',pphone='"+pnum+"',pmobile='"+pmobile+"',seekadd='"+seekadd+"',year_regist='"+yrr+"',class_regist='"+cr+"',standard='"+stand+"',category='"+cat+"',highper="+hsp+",interper="+inp+",admin_type='"+admTyp+"',high_max_marks="+highmm+",high_obt_marks="+highobt+",inter_max_marks="+intermm+",inter_obt_marks="+interobt+",domicile='"+domcil+"',high_board='"+hboard+"',inter_board='"+iboard+"' where srnum='"+srnum+"' and session='"+sesn+"'";    
//stmt1=cn.createStatement();
//stmt1.executeUpdate(sq2);
//}}
}
    psmt3=cn.prepareStatement(qr2);
    rs5=psmt3.executeQuery(); 
    rs5.next();
    if(rs5.getInt("cnt")>0){             
//if(img5.equals("")){
//  imgsize=0.0;  
  String sql1="update oldregis set studname='"+sname+"',gender='"+gender+"',dob='"+dob+"',nationality='"+nationality+"',fname='"+fname+"',mname='"+mname+"',paddress='"+padd+"',pphone='"+pnum+"',pmobile='"+pmobile+"',seekadd='"+seekadd+"',year_regist='"+yrr+"',class_regist='"+cr+"',standard='"+stand+"',category='"+cat+"',admin_type='"+admTyp+"',domicile='"+domcil+"',high_max_marks="+highmm+",high_obt_marks="+highobt+",inter_max_marks="+intermm+",inter_obt_marks="+interobt+",prevper="+prevp+",prev_max_marks="+prevmm+",prev_obt_marks="+prevobt+",high_board='"+hboard+"',inter_board='"+iboard+"',prev_board='"+pboard+"' where srnum='"+srnum+"' and session='"+sesn+"'";
  stmt1=cn.createStatement();
  stmt1.executeUpdate(sql1);
//}else{                    
//       String img1=request.getParameter("pic");
//       int a=img1.length();
//       int b=img1.lastIndexOf("\\"); 
//       String path=request.getParameter("pic"); 
//       String f1=img1.substring(b+1,a);           
//       StringBuffer sb=new StringBuffer();
//       File imgfile = new File(path);
//       imgsize=imgfile.length();
//       FileInputStream fin1 = new FileInputStream(imgfile);  
//       if(imgsize>100000){
//         String sub=new String("Image Size Should not be greater than 100 KB");
//         request.setAttribute("sub",sub);
//         RequestDispatcher rd1=request.getRequestDispatcher("dsrec.do?disp=disp&srnum="+srnum+"&session="+sesn); 
//         rd1.forward(request,response); 
//         }else{
//   String qry="update oldregis set pic=? where srnum='"+srnum+"' and session='"+sesn+"'";
//   pst=cn.prepareStatement(qry);
//   pst.setBinaryStream(1,fin1,(int)imgfile.length());
//   pst.executeUpdate();
//String sq2="update oldregis set studname='"+sname+"',gender='"+gender+"',dob='"+dob+"',nationality='"+nationality+"',fname='"+fname+"',mname='"+mname+"',paddress='"+padd+"',pphone='"+pnum+"',pmobile='"+pmobile+"',seekadd='"+seekadd+"',year_regist='"+yrr+"',class_regist='"+cr+"',standard='"+stand+"',category='"+cat+"',admin_type='"+admTyp+"',domicile='"+domcil+"',prevper="+prevp+",prev_max_marks="+prevmm+",prev_obt_marks="+prevobt+" where srnum='"+srnum+"' and session='"+sesn+"'";    
//stmt1=cn.createStatement();
//stmt1.executeUpdate(sq2);
//}}             
}
String sub=new String(srnum+" record is updated");
request.setAttribute("sub",sub);
         RequestDispatcher rd1=request.getRequestDispatcher("/displistofstud.jsp"); 
         rd1.forward(request,response); 
         RequestDispatcher rd2=request.getRequestDispatcher("dsrec.do?disp=disp&srnum="+srnum+"&syear="+sesn); 
         rd2.forward(request,response);             
         }catch(SQLException ee){}          
          try{
             if(rs3!=null){rs3.close();}
             if(stmt3!=null){stmt3.close();}
             if(pst!=null){pst.close();}
             if(stmt1!=null){stmt1.close();}
             if(cn!=null){cn.close();}
           }catch(SQLException e){}        
           }          
          return mapping.findForward(SUCCESS);       
    }
}
