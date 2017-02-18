package AO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import com.myapp.struts.DataConnection;
import java.sql.*;
import java.io.*;
import java.lang.NullPointerException;
/**
 *
 * @author sonal
 * @version
 */

public class OldStudRegisAO extends Action {
    
    Connection cn=null;
    PreparedStatement pstmt1=null;
    PreparedStatement pstmt=null;
    PreparedStatement psmt2=null;
    Statement stmt4=null;
    ResultSet rs4=null;  
    ResultSet rs1=null;
    Statement stmt=null;
    Statement stmt1=null;
    ResultSet rs=null;
    int count=0;
    int Syr=0;
    int Eyr=0;
    String Styear="";
    String Syear="";
    
    String Sadmstatus="New Admission";
    String Oadmstatus="Studying";
    String sfeebook="NotIssued";
    String tfeebook="NotIssued";
        
    private final static String SUCCESS = "success";
   
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
          PrintWriter out= response.getWriter();        
       try{        
            DataConnection dc1=new DataConnection();
            cn=(Connection)dc1.Dataconnect();            
            String fn="";
//            FileInputStream fin=null;
//            FileInputStream fin1=null;
//            FileInputStream fin2=null;
//            File imgfile=null;
            int duration=0;
            String Eyear="";
            double imgsize=0.0;
            double tfee=0.0;
//       String img5= request.getParameter("pic");   
//       if(img5.equals("")){
//           fn="NoImage";
//           imgsize=0.0;
//         }
//         else{
//        try{  
//        String img1= request.getParameter("pic");  
//        int a=img1.length();
//        int b=img1.lastIndexOf("\\"); 
//        String path=request.getParameter("pic"); 
//        
//       String f1=img1.substring(b+1,a);           
//       StringBuffer sb=new StringBuffer();
//       imgfile = new File(path);
//       imgsize=imgfile.length();
//       fin = new FileInputStream(imgfile);   
//       fin1 = new FileInputStream(imgfile);   
//       fin2 = new FileInputStream(imgfile);  
//         }catch(Exception e){}
         //}       
//         if(imgsize>100000){
//           String existnum=new String("Image Size Should not be greater than 100 KB");
//           request.setAttribute("existnum",existnum);
//           RequestDispatcher  rd1  =request.getRequestDispatcher("/StudentRegis.jsp"); 
//           rd1.forward(request,response); 
//       }
//       else{     
            //String enroll=request.getParameter("enrol_no"); 
            String sesn=request.getParameter("session"); 
            String sno=request.getParameter("srnum"); 
            String Syear=request.getParameter("Syear"); 
            int Syr=Integer.parseInt(request.getParameter("Syear").toString());
            Eyear=request.getParameter("Eyear");  
            String sesdate=request.getParameter("sesdate");  
//            int srnum =Integer.parseInt(request.getParameter("srnum").toString());
//            int srnum1=srnum+1;
            String sname=request.getParameter("sname");  
            String gender=request.getParameter("gender");  
            String dob=request.getParameter("dob");          
            String mname=request.getParameter("mname"); 
            String fname=request.getParameter("fname");            
            String cat=request.getParameter("category");
            String ye_regis=request.getParameter("ye_regis");
            String cls_regis=request.getParameter("class_regis");            
            String padd=request.getParameter("padd");  
            String pnum=request.getParameter("pnum");  
            String pmobile=request.getParameter("pmobile");  
            String seekadd=request.getParameter("seekadd");  
            String category=request.getParameter("category"); 
            String year_regist=request.getParameter("year_regist"); 
            String class_regist=request.getParameter("class_regist"); 
            String nationality=request.getParameter("nationality");
            String standard=request.getParameter("standard"); 
            //String type=request.getParameter("type"); 
            String admTyp=request.getParameter("admin_type"); 
            String domic=request.getParameter("domicile"); 
            String sub[]=(String[])request.getParameterValues("sub");
            String pboard=request.getParameter("prevboard"); 

            double prevmm=0.0;
            double prevobt=0.0;         
            double prevper=0.0;
                  
        try{
        prevmm=Double.parseDouble(request.getParameter("prevmm"));
        }catch(NumberFormatException ne){}  
            
        try{
        prevobt=Double.parseDouble(request.getParameter("prevobt"));
        }catch(NumberFormatException ne){}  
            
        try{
        prevper=Double.parseDouble(request.getParameter("prevper"));
        }catch(NumberFormatException ne){}        
    
           String existnum="";  
           String sq="select count(*) as cnt from oldregis where srnum='"+sno+"' and session='"+sesn+"'";
           Statement stmt4=cn.createStatement();
           ResultSet rs4=stmt4.executeQuery(sq);                                  
           rs4.next();
           int count=rs4.getInt("cnt");                 
           if(count==0){
            String sql1="insert into oldregis(srnum,studname,dob,gender,nationality,fname,mname,paddress,pphone,pmobile,seekadd,sesdate,syear,eyear,prevper,category,year_regist,class_regist,standard,domicile,session,admin_type,prev_max_marks,prev_obt_marks,prev_board)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pstmt=cn.prepareStatement(sql1); 
            pstmt.setString(1,sno);
            pstmt.setString(2,sname);
            pstmt.setString(3,dob);
            pstmt.setString(4,gender);
            pstmt.setString(5,nationality);
            pstmt.setString(6,fname);
            pstmt.setString(7,mname);
            pstmt.setString(8,padd);
            pstmt.setString(9,pnum);
            pstmt.setString(10,pmobile);
            pstmt.setString(11,seekadd);
            pstmt.setString(12,sesdate);
            pstmt.setString(13,Syear);
            pstmt.setString(14,Eyear);
            pstmt.setDouble(15,prevper);
            pstmt.setString(16,category);
            pstmt.setString(17,year_regist);
            pstmt.setString(18,class_regist);
            pstmt.setString(19,standard);
            pstmt.setString(20,domic);
            pstmt.setString(21,sesn);
            pstmt.setString(22,admTyp);
            pstmt.setDouble(23,prevmm);
            pstmt.setDouble(24,prevobt);
            pstmt.setString(25,pboard);    
//            if(img5.equals("")){
//            pstmt.setString(26,fn);
//            }
//            else{
//            pstmt.setBinaryStream(26,fin,(int)imgfile.length());
//            }                     
            pstmt.executeUpdate();
            
            String qr3="insert into stud_subject(session,admin_no,subject,classes)values(?,?,?,?)";
            psmt2=cn.prepareStatement(qr3); 
            for(int i=0;i<sub.length;i++){            
            psmt2.setString(1,sesn);
            psmt2.setString(2,sno);
            psmt2.setString(3,sub[i]);
            psmt2.setString(4,seekadd);
            psmt2.executeUpdate();
            }
                
//         String sqlset="update setsrnum set srnum='"+srnum1+"'";
//         stmt1=cn.createStatement();
//         stmt1.executeUpdate(sqlset);
//         
//          String msg=new String(" "+srnum+" is Registered");
//
//                       request.setAttribute("msg",msg);
//                       RequestDispatcher  rd1  =request.getRequestDispatcher("/StudentRegis.jsp"); 
//                       rd1.forward(request,response); 
            existnum=new String(sno+" is Registered");
             }else{
                  existnum=new String(sno+" Registration No. already Exist");
                  }   
                       request.setAttribute("msg",existnum);
                       RequestDispatcher rd1=request.getRequestDispatcher("/OldStudentRegis.jsp"); 
                       rd1.forward(request,response);                         
       // }          
       // }
       }catch(SQLException e){}
  finally{
         try{
             if(rs4!=null){rs4.close();} 
             if(stmt4!=null){stmt4.close();} 
             if(pstmt!=null){pstmt.close();}                 
             if(cn!=null){cn.close();}
            }catch(SQLException e){}
           }    
    return mapping.findForward("success");
}     
}