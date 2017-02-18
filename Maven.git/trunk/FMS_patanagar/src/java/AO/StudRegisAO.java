package AO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import com.myapp.struts.Dataconnectivity;
import java.sql.*;
import EO.SchoolEO;
import java.io.*;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

public class StudRegisAO extends Action {
    
    Connection cn=null;
    PreparedStatement pstmt1=null;
    PreparedStatement pstmt=null;
    PreparedStatement psmt2=null;
    ResultSet rs1=null;
    Statement stmt=null;
    Statement stmt1=null;
    ResultSet rs=null;
    ResultSet rs2=null;
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
          ArrayList reg_dtl=new ArrayList();
            SchoolEO seo=new SchoolEO();
          
          try{
          Dataconnectivity dc1=new Dataconnectivity();
          cn=(Connection)dc1.Dataconnect(); 
          cn.setAutoCommit(false);
          }catch(Exception e){}
          
       try{                      
              String fn="";
//            FileInputStream fin=null;
//            FileInputStream fin1=null;
//            FileInputStream fin2=null;
//            File imgfile=null;
            int duration=0;
            String Eyear="";
            double imgsize=0.0;
            double tfee=0.0;
//         String img5= request.getParameter("pic");   
//         if(img5.equals("")){
//           fn="NoImage";
//           imgsize=0.0;
//         }else{
//         try{  
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
//         }
       
//        if(imgsize>100000){
//           String existnum=new String("Image Size Should not be greater than 100 KB");
//              request.setAttribute("existnum",existnum);
//                       RequestDispatcher  rd1  =request.getRequestDispatcher("/StudentRegis.jsp"); 
//                       rd1.forward(request,response); 
//       }else{       
            String sesn=request.getParameter("session"); 
            String sno=request.getParameter("srnum"); 
            String Syear=request.getParameter("Syear"); 
            int Syr=Integer.parseInt(request.getParameter("Syear").toString());
            Eyear=request.getParameter("Eyear");  
            String sesdate=request.getParameter("sesdate");  
//            int srnum =Integer.parseInt(request.getParameter("srnum").toString());
//            int srnum1=srnum+1;
            String deg=(String)request.getParameter("degree");
            String branch=(String)request.getParameter("branch");
            String sname=request.getParameter("sname");  
            String gender=request.getParameter("gender");  
            String dob=request.getParameter("dob");          
            String mname=request.getParameter("mname");
            String moccup=(String)request.getParameter("moccup");
            String fname=request.getParameter("fname"); 
            String foccup=(String)request.getParameter("foccup");
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
            String blood_grp=(String)request.getParameter("bld_grp");
            String marital_status=(String)request.getParameter("marital");
            String facility=(String)request.getParameter("facility");
            String standard=request.getParameter("standard"); 
            //String type=request.getParameter("type"); 
            String admTyp=request.getParameter("admin_type"); 
            String domic=request.getParameter("domicile"); 
            String sub[]=(String[])request.getParameterValues("sub");
            
            String highins=(String)request.getParameter("highins");
            String interins=(String)request.getParameter("interins");
            String previns=(String)request.getParameter("previns");
             String hboard=request.getParameter("highboard");
        String iboard=request.getParameter("interboard");  
        String pboard=request.getParameter("prevboard");
            String highyr=(String)request.getParameter("highyr");
            String interyr=(String)request.getParameter("interyr");
            String prevyr=(String)request.getParameter("prevyr");
            
            String ai_rank=(String)request.getParameter("airank");
            String ca_rank=(String)request.getParameter("catrank");
            String ca_mon_year=(String)request.getParameter("ca_mon_year");
            String ma_rank=(String)request.getParameter("matrank");
            String ma_mon_year=(String)request.getParameter("ma_mon_year");
            
            double reg_fee=0.0;
            double highmm=0.0;
            double highobt=0.0;
            double highper=0.0;
            double intermm=0.0;
            double interobt=0.0;             
            double interper=0.0;   
            double prevmm=0.0;
            double prevobt=0.0;
            double prevper=0.0;
        
        try{
        reg_fee=Double.parseDouble(request.getParameter("regis_fee"));
        }catch(NumberFormatException ne){}    
            
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
        highper=Double.parseDouble(request.getParameter("highper"));
        }catch(NumberFormatException ne){}        
        try{
        interper=Double.parseDouble(request.getParameter("interper"));
        }catch(NumberFormatException ne){}    
            
        try{
        prevmm=Double.parseDouble(request.getParameter("prevmm"));
        }catch(NumberFormatException ne){}           
        try{
        prevobt=Double.parseDouble(request.getParameter("prevobt"));
        }catch(NumberFormatException ne){}  
        try{
        prevper=Double.parseDouble(request.getParameter("prevper"));
        }catch(NumberFormatException ne){}
            
        out.println(reg_fee);
    
            String typ="";            
            int cnt=0;
                      
            String sql="select count(*) as cnt from studentregis where session='"+sesn+"' and srnum='"+sno+"'";
            stmt=cn.createStatement();
            rs=stmt.executeQuery(sql);
            if(rs.next()){
            cnt=rs.getInt("cnt");  
            }            
            if(cnt==0){          
            String qr="insert into studentregis(srnum,studname,dob,gender,nationality,fname,mname,paddress,pphone,pmobile,seekadd,sesdate,syear,eyear,"
                    + "highper,interper,category,year_regist,class_regist,standard,domicile,session,admin_type,high_max_marks,high_obt_marks,"
                    + "inter_max_marks,inter_obt_marks,high_board,inter_board,prev_mm,prev_obt,prev_per,prev_board,degree,branch,semester,foccup,moccup,"
                    + "blood_grp,marital_status,facility,high_inst,inter_inst,high_year,inter_year,prev_inst,prev_year,aieee_rank,cat_rank,cat_mnth_year,"
                    + "mat_rank,mat_mnth_year,regist_fee)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
                    + "?,?,?,?,?,?,?,?)";
            pstmt=cn.prepareStatement(qr); 
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
            pstmt.setDouble(15,highper);
            pstmt.setDouble(16,interper);
            pstmt.setString(17,category);
            pstmt.setString(18,year_regist);
            pstmt.setString(19,class_regist);
            pstmt.setString(20,standard);
            pstmt.setString(21,domic);
            pstmt.setString(22,sesn);
            pstmt.setString(23,admTyp);
            pstmt.setDouble(24,highmm);
            pstmt.setDouble(25,highobt);
            pstmt.setDouble(26,intermm);
            pstmt.setDouble(27,interobt);
            pstmt.setString(28,hboard);
            pstmt.setString(29,iboard);
            pstmt.setDouble(30,prevmm);
            pstmt.setDouble(31,prevobt);
            pstmt.setDouble(32,prevper);        
            pstmt.setString(33,pboard); 
            pstmt.setString(34,deg); 
            pstmt.setString(35,branch);
             pstmt.setString(36,seekadd);
            pstmt.setString(37,foccup); 
            pstmt.setString(38,moccup); 
            pstmt.setString(39,blood_grp); 
            pstmt.setString(40,marital_status); 
            pstmt.setString(41,facility); 
            pstmt.setString(42,highins); 
            pstmt.setString(43,interins);
            pstmt.setString(44,highyr); 
            pstmt.setString(45,interyr); 
            pstmt.setString(46,previns); 
            pstmt.setString(47,prevyr); 
            pstmt.setString(48,ai_rank); 
            pstmt.setString(49,ca_rank); 
            pstmt.setString(50,ca_mon_year);
            pstmt.setString(51,ma_rank);
            pstmt.setString(52,ma_mon_year);
             pstmt.setDouble(53,reg_fee);
                     
//          if(img5.equals("")){pstmt.setString(33,fn);}
//          else{pstmt.setBinaryStream(33,fin,(int)imgfile.length());}                     
            pstmt.executeUpdate(); 
            
            
               
            
            String strql="select session,srnum,studname,dob,regist_fee,gender,fname,pmobile,category,degree,branch,semester,facility from studentregis where srnum='"+sno+"'";
             pstmt1=cn.prepareStatement(strql); 
              rs1=pstmt1.executeQuery();
               while(rs1.next())
               {
                 seo.setSession(rs1.getString("session"));
                 seo.setSrnum(rs1.getString("srnum"));
                 seo.setSname(rs1.getString("studname"));
                 seo.setDob(rs1.getString("dob"));
                 seo.setRegist_fee(rs1.getDouble("regist_fee"));
                 seo.setGender(rs1.getString("gender"));
                 seo.setFname(rs1.getString("fname"));
                 seo.setPhone(rs1.getString("pmobile"));
                 seo.setCategory(rs1.getString("category"));
                 seo.setDegree(rs1.getString("degree"));
                 seo.setBranch(rs1.getString("branch"));
                 seo.setSemester(rs1.getString("semester"));
                 seo.setFacility(rs1.getString("facility"));
                 
                 reg_dtl.add(seo);
               }
           
            
            
            
            
//            String qr3="insert into stud_subject(session,admin_no,subject,classes)values(?,?,?,?)";
//            psmt2=cn.prepareStatement(qr3); 
//            for(int i=0;i<sub.length;i++){            
//            psmt2.setString(1,sesn);
//            psmt2.setString(2,sno);
//            psmt2.setString(3,sub[i]);
//            psmt2.setString(4,seekadd);
//            psmt2.executeUpdate();            
//            } 
             request.setAttribute("allist",reg_dtl);  
            request.setAttribute("msg",sno+" is Registered");
            }else{
            request.setAttribute("msg",sno+" Already Exists");    
            }
           cn.commit();
            //}
            }catch(SQLException e){
                request.setAttribute("msg","Database Error");  
                cn.rollback();
            }finally{
            try{
             if(rs!=null){rs.close();}
              if(rs1!=null){rs1.close();}
             if(stmt!=null){stmt.close();}
             if(pstmt!=null){pstmt.close();} 
             if(pstmt1!=null){pstmt1.close();}
             if(cn!=null){cn.close();}
             }catch(SQLException e){}
             }    
    return mapping.findForward(SUCCESS);
     //return mapping.findForward("");
}     
}