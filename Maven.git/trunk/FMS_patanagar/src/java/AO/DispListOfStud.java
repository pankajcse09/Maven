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

public class DispListOfStud extends Action {
    
    Connection cn=null;
    Statement stmt3=null;
    ResultSet rs3=null;    
    String Syear="";
    String status="";
    int totfine=0;   
    private final static String SUCCESS = "success";
    
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         String cnt="0";
         
          ArrayList arr=new ArrayList();       
           EO.SchoolEO gt=null;        
          try{
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e){}
  
 /******************************Displaying Detail of fees *************************/
       
           String degree=request.getParameter("degree");
           String ret=request.getParameter("ret");
           if(ret.equals("Display")){
//            String branch=request.getParameter("branch");
//           String sesn=request.getParameter("session");   
//           String year=request.getParameter("year");
           String batch=request.getParameter("batch");
           if(request.getParameter("count")!=null){
           cnt=request.getParameter("count"); 
           }
        
           int count=0;
           try{
               String qr="";
               if("ALL".equalsIgnoreCase(batch))
                   qr="select count(*) as cnt from studentregis where degree='"+degree+"'"; 
               else
                qr="select count(*) as cnt from studentregis where batch='"+batch+"' and degree='"+degree+"'";           
         stmt3=cn.createStatement();
         rs3=stmt3.executeQuery(qr);
         if(rs3.next())
             count=rs3.getInt("cnt");
         rs3.close();
           }catch(Exception e){}
        
          
         String qry="";      
// if(cls.equals("All")){               
// qry="select srnum,studname,session,seekadd,gender,fname,category,enroll_no from studentregis where session='"+sesn+"' union select srnum,studname,session,seekadd,gender,fname,category,enroll_no from oldregis where session='"+sesn+"' ORDER BY SUBSTR(srnum,1,1),CONVERT(SUBSTR(srnum,INSTR(srnum,'-')+1),UNSIGNED)"; 
// }else{ 
// qry="select srnum,studname,session,seekadd,gender,fname,category,enroll_no from studentregis where session='"+sesn+"' and seekadd='"+cls+"' union select srnum,studname,session,seekadd,gender,fname,category,enroll_no from oldregis where session='"+sesn+"' and seekadd='"+cls+"' ORDER BY SUBSTR(srnum,1,1),CONVERT(SUBSTR(srnum,INSTR(srnum,'-')+1),UNSIGNED)"; 
// }      
//    qry="select srnum,stud_id,studname,session,seekadd,gender,fname,category,enroll_no,degree,branch,semester from studentregis where session='"+sesn+"' and degree='"+degree+"' "
//            + "union select srnum,stud_id,studname,session,seekadd,gender,fname,category,enroll_no,degree,branch,semester from oldregis where session='"+sesn+"' and degree='"+degree+"'"
//            + " ORDER BY SUBSTR(srnum,1,1),CONVERT(SUBSTR(srnum,INSTR(srnum,'-')+1),UNSIGNED)";     
         

        /*  Create Query and make it comment by kapil
    if(!year.equals("")){
        int sem=2*Integer.parseInt(year);
        qry="select srnum,stud_id,studname,session,seekadd,gender,fname,category,enroll_no,degree,branch,semester from studentregis where"
                + " session='"+sesn+"' and degree='"+degree+"' and (semester='"+(sem-1)+"' or semester='"+sem+"') ORDER BY SUBSTR(srnum,1,1),CONVERT(SUBSTR(srnum,INSTR(srnum,'-')+1),UNSIGNED)"; 
    }
    else{
        qry="select srnum,stud_id,studname,session,seekadd,gender,fname,category,enroll_no,degree,branch,semester from studentregis where"
                + " session='"+sesn+"' and degree='"+degree+"' ORDER BY SUBSTR(srnum,1,1),CONVERT(SUBSTR(srnum,INSTR(srnum,'-')+1),UNSIGNED)";     
    }
    */
          
         
      if(count!=0){  
          try{ 
              if("ALL".equalsIgnoreCase(batch))
                   qry="select srnum,stud_id,studname,session,batch,seekadd,gender,fname,category,enroll_no,degree,branch,semester from studentregis where"
                + " degree='"+degree+"' ORDER BY batch desc,SUBSTR(stud_id,1,1),CONVERT(SUBSTR(stud_id,INSTR(stud_id,'-')+1),UNSIGNED)"; 
               else
                    qry="select srnum,stud_id,studname,session,batch,seekadd,gender,fname,category,enroll_no,degree,branch,semester from studentregis where"
                    + " batch='"+batch+"' and degree='"+degree+"' ORDER BY SUBSTR(stud_id,1,1),CONVERT(SUBSTR(stud_id,INSTR(stud_id,'-')+1),UNSIGNED)";    
//    System.out.println("Query: "+qry);
          stmt3=cn.createStatement();
          rs3=stmt3.executeQuery(qry);  
          while(rs3.next()){
          gt=new EO.SchoolEO();
          gt.setSrnum(rs3.getString("srnum"));
          gt.setStud_id(rs3.getString("stud_id"));
          gt.setSname(rs3.getString("studname").toUpperCase());
          gt.setSession(rs3.getString("session"));
          gt.setClasses(rs3.getString("seekadd"));   
          gt.setBatch(rs3.getString("batch"));
          gt.setGender(rs3.getString("gender"));
          gt.setFname(rs3.getString("fname"));
          gt.setCategory(rs3.getString("category"));
          gt.setEnrolNo(rs3.getString("enroll_no"));
          gt.setBranch(rs3.getString("branch"));
          gt.setDegree(rs3.getString("degree"));
          gt.setSemester(rs3.getString("semester"));
          arr.add(gt);
          }       
        request.setAttribute("arr",arr);          
          }catch(SQLException ee){}          
             try{
             if(rs3!=null){rs3.close();}
             if(stmt3!=null){stmt3.close();}
             if(cn!=null){cn.close();}
           }catch(SQLException e){}  
           if(cnt.equals("0")){
           if(cnt.equals("1")){
           request.setAttribute("msg","Record Deleted");    
           }else{
           if(cnt.equals("-1")){    
           request.setAttribute("msg","Record Not Available or Database Error");   
           }
           }
           }
    }
    else
        request.setAttribute("msg","Record Not Available.");   
      
    return mapping.findForward("success");   
           }
           else{
               String sesn=request.getParameter("session"); 
               SchoolEO seo= new SchoolEO();
               seo.setSession(sesn);
               int count=0;
           if(!"ALL".equalsIgnoreCase(degree)){
               try{
                    String qr="select count(*) as cnt from studentregis where degree='"+degree+"'";
                    stmt3=cn.createStatement();
                    rs3=stmt3.executeQuery(qr);
                    if(rs3.next())
                        count=rs3.getInt("cnt");
                        rs3.close();
                  }catch(Exception e){}
            }
           else
               count=1;
           if(count!=0){  
          try{ 
              String qry="";
//        qry="select srnum,stud_id,studname,session,batch,seekadd,gender,fname,category,enroll_no,degree,branch,semester from studentregis where"
//             + " degree='"+degree+"' and registration='Yes' ORDER BY SUBSTR(stud_id,1,1),CONVERT(SUBSTR(stud_id,INSTR(stud_id,'-')+1),UNSIGNED)"; 
//  commented by kapil   
     if("ALL".equalsIgnoreCase(degree))
      qry="select sst.session_sem,sst.stud_id, str.srnum,str.studname,str.session,str.batch,str.gender,str.fname,str.category,str.enroll_no,str.degree"
              + " from sem_studregis sst left join studentregis str on sst.stud_id=str.stud_id where sst.session='"+sesn+"'"
              + " order by str.degree, sst.session_sem, str.batch desc, sst.stud_id";
     else
         qry="select sst.session_sem,sst.stud_id, str.srnum,str.studname,str.session,str.batch,str.gender,str.fname,str.category,str.enroll_no,str.degree"
              + " from sem_studregis sst left join studentregis str on sst.stud_id=str.stud_id where sst.session='"+sesn+"' and str.degree='"+degree+"'"
                 + " order by str.degree, sst.session_sem, str.batch desc, sst.stud_id";
  // System.out.println("Query: "+qry);
          stmt3=cn.createStatement();
          rs3=stmt3.executeQuery(qry);  
          while(rs3.next()){
          gt=new EO.SchoolEO();
          gt.setSrnum(rs3.getString("srnum"));
          gt.setStud_id(rs3.getString("stud_id"));
          gt.setSname(rs3.getString("studname").toUpperCase());
          gt.setSession(rs3.getString("session"));
          gt.setBatch(rs3.getString("batch"));
          gt.setGender(rs3.getString("gender"));
          gt.setFname(rs3.getString("fname"));
          gt.setCategory(rs3.getString("category"));
          gt.setEnrolNo(rs3.getString("enroll_no"));
          gt.setDegree(rs3.getString("degree"));
          gt.setSession_sem(rs3.getString("session_sem"));
          arr.add(gt);
          }       
        request.setAttribute("arr",arr);          
          }catch(SQLException ee){}          
             try{
             if(rs3!=null){rs3.close();}
             if(stmt3!=null){stmt3.close();}
             if(cn!=null){cn.close();}
           }catch(SQLException e){}  
           if(cnt.equals("0")){
           if(cnt.equals("1")){
           request.setAttribute("msg","Record Deleted");    
           }else{
           if(cnt.equals("-1")){    
           request.setAttribute("msg","Record Not Available or Database Error");   
           }
           }
           }
    }
    else
        request.setAttribute("msg","Record Not Available.");   
          request.setAttribute("jbean", seo);
               return mapping.findForward("show");  
           }
    }
           
}
