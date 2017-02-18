

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
import java.io.PrintWriter;
import EO.SchoolEO;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.lang.NullPointerException;
/**
 *
 * @author sonal
 * @version
 */

public class UpdateStudRegisRecord extends Action {
    
    Connection cn=null;
    PreparedStatement pstmt1=null;
    PreparedStatement pstmt2=null;
    PreparedStatement pstmt=null;
    Statement stmt=null;

  
    ResultSet rs=null;
    int count=0;
    
        
    private final static String SUCCESS = "success";
    
  
    
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
          PrintWriter out= response.getWriter();
          SchoolEO seo=new SchoolEO();
          DynaActionForm df=(DynaActionForm)form;
         ArrayList arr=new ArrayList();
         
 /*******************************Displaying student record*******************************/
         
          try
       {
           DataConnection dc=new DataConnection();
           cn=(Connection)dc.Dataconnect();
          }catch(Exception e)
          {}
       
 
         
         String st1="";
         int in1=0;
         int in2=0;
         String sfeebook="NotIssued";
         String tfeebook="NotIssued";
         ArrayList ar1=new ArrayList();
         ArrayList ar2=new ArrayList();
         ArrayList ar3=new ArrayList();
         ArrayList ar4=new ArrayList();
         EO.SchoolEO gt=new EO.SchoolEO();
       
    
            String ss="";
            String re="";
            DataConnection dc1=new DataConnection();
            cn=(Connection)dc1.Dataconnect(); 
            String cls=(String)request.getParameter("cls");   
            String classes=(String)request.getParameter("classes");   
            String Snyear=(String)request.getParameter("Syear"); 
            String Enyear=(String)request.getParameter("Eyear");  
            String sesdate=(String)request.getParameter("sesdate");     
            String PSyear=(String)request.getParameter("PSyear");      
            String PEyear=(String)request.getParameter("PEyear");      
            
            String sq="select srnum from oldstudregis  where (Syear='"+Snyear+"' and Eyear='"+Enyear+"') and classes='"+classes+"'";

            stmt=cn.createStatement();
            rs=stmt.executeQuery(sq);
            if(rs.next()==true)
            {
               
             String sub=new String("Record is already updated");

                request.setAttribute("sub",sub);
                RequestDispatcher  rd1  =request.getRequestDispatcher("/fee/updatestudregisrecord.jsp"); 
                rd1.forward(request,response);   
             } 
      
           else
           {
          
            Enumeration en=request.getParameterNames();
            String name="";
            while(en.hasMoreElements()){
            try{    
            name=(String)en.nextElement();
            st1=name.substring(0,2);
       
            }
            catch(IndexOutOfBoundsException e){out.println(e.getMessage());}
            if(st1.equals("st")){                
             ar1.add(name);   
            }
            if(st1.equals("re")){
             ar2.add(name);   
            }
            }
            for(int i=0;i<ar2.size();i++){
            re=(String)request.getParameter(ar2.get(i).toString());  
            ar3.add(re);
            ss=(String)request.getParameter(ar1.get(i).toString());             
            ar4.add(ss);            
            } 
            for(int k=0;k<ar2.size();k++){
          
            
            }
            String qr="";
              String gg="";
            try{
            for(int j=0;j<ar3.size();j++){
   
       gg="select os.srnum,os.studname,os.classes,os.syear,os.eyear,os.sesdate,os.admstatus,ac.dob,ac.doj,ac.gender,ac.section,ac.house,ac.route,ac.buscode,ac.tripnum,ac.concession,ac.feebooknum,ac.transfeebook from oldstudregis os inner join studacaddetail ac on os.srnum=ac.srnum where os.srnum='"+ar3.get(j)+"' and os.classes='"+cls+"' and (os.Syear='"+PSyear+"' and os.Eyear='"+PEyear+"')";
      //       gg="select * from oldstudregis where srnum='"+ar3.get(j)+"' and classes='"+cls+"' and (Syear='"+Syear+"' or Eyear='"+Syear+"')";
        
             pstmt=cn.prepareStatement(gg);
              rs=pstmt.executeQuery();
            
              
              while(rs.next())
              {
                 
                  gt.setSrnum(rs.getString("srnum"));
                  gt.setSname(rs.getString("studname"));
                  gt.setClasses(rs.getString("classes"));
                  gt.setSyear(rs.getString("Syear"));
                  gt.setEyear(rs.getString("Eyear"));
                  gt.setSession(rs.getString("sesdate"));              
                  gt.setAdmstatus(rs.getString("admstatus"));
                  gt.setDob(rs.getString("dob"));
                  gt.setDoj(rs.getString("doj"));
                  gt.setGender(rs.getString("gender"));
                  gt.setSection(rs.getString("section"));
                  gt.setHouse(rs.getString("house"));
                  gt.setRoute(rs.getString("route"));
                  gt.setBuscode(rs.getString("buscode"));
                  gt.setTripnum(rs.getString("tripnum"));
                  gt.setConcession(rs.getDouble("concession"));
                  gt.setSfeebooknum(rs.getString("feebooknum"));
                  gt.setTfeebooknum(rs.getString("transfeebook"));
                  
                  arr.add(gt);
                }
             
             
             if(ar4.get(j).toString().equals("pass")){
             
          String sql1="insert into oldstudregis(srnum,studname,classes,Syear,Eyear,sesdate,admstatus,tfeebook,sfeebook)values(?,?,?,?,?,?,?,?,?)";
    
            pstmt1=cn.prepareStatement(sql1); 
            pstmt1.setInt(1,Integer.parseInt(gt.getSrnum().toString()));
            pstmt1.setString(2,gt.getSname());
            pstmt1.setString(3,classes);
            pstmt1.setString(4,Snyear);
            pstmt1.setString(5,Enyear);
            pstmt1.setString(6,sesdate);
            pstmt1.setString(7,gt.getAdmstatus());
            pstmt1.setString(8,tfeebook);
            pstmt1.setString(9,sfeebook);
           
          pstmt1.executeUpdate();
             
              pstmt1=null;
              
            String qry="insert into studacaddetail(srnum,syear,eyear,sname,dob,doj,gender,classes,section,house,route,buscode,tripnum,concession,feebooknum,transfeebook)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
          
            pstmt1=cn.prepareStatement(qry); 
            pstmt1.setInt(1,Integer.parseInt(gt.getSrnum().toString()));
            pstmt1.setString(2,Snyear);
            pstmt1.setString(3,Enyear);
            pstmt1.setString(4,gt.getSname());
            pstmt1.setString(5,gt.getDob());
            pstmt1.setString(6,gt.getDoj());
            pstmt1.setString(7,gt.getGender());
            pstmt1.setString(8,classes);
            pstmt1.setString(9,gt.getSection());
            pstmt1.setString(10,gt.getHouse());
            pstmt1.setString(11,gt.getRoute());
            pstmt1.setString(12,gt.getBuscode());
            pstmt1.setString(13,gt.getTripnum());
            pstmt1.setDouble(14,gt.getConcession());
            pstmt1.setString(15,sfeebook);
            pstmt1.setString(16,tfeebook);
                       
            pstmt1.executeUpdate();
              pstmt1=null;
              
               String sql="insert into feemonthrec(srnum,Syear,Eyear,January,February,March,April,May,June,July,August,September,October,November,December,class,section)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    
            pstmt1=cn.prepareStatement(sql); 
            pstmt1.setInt(1,Integer.parseInt(gt.getSrnum().toString()));
            pstmt1.setString(2,Snyear);
            pstmt1.setString(3,Enyear);
            pstmt1.setString(4,"notpaid");
            pstmt1.setString(5,"notpaid");
            pstmt1.setString(6,"notpaid");
            pstmt1.setString(7,"notpaid");
            pstmt1.setString(8,"notpaid");
            pstmt1.setString(9,"notpaid");
            pstmt1.setString(10,"notpaid");
            pstmt1.setString(11,"notpaid");
            pstmt1.setString(12,"notpaid");
            pstmt1.setString(13,"notpaid");
            pstmt1.setString(14,"notpaid");
            pstmt1.setString(15,"notpaid");
            pstmt1.setString(16,classes);
            pstmt1.setString(17,gt.getSection());
          
          pstmt1.executeUpdate();
          
          
         String sqlr="insert into transfeemonthrec(srnum,Syear,Eyear,January,February,March,April,May,June,July,August,September,October,November,December,class,section)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
            pstmt1=cn.prepareStatement(sqlr); 
            pstmt1.setInt(1,Integer.parseInt(gt.getSrnum().toString()));
            pstmt1.setString(2,Snyear);
            pstmt1.setString(3,Enyear);
            pstmt1.setString(4,"notpaid");
            pstmt1.setString(5,"notpaid");
            pstmt1.setString(6,"notpaid");
            pstmt1.setString(7,"notpaid");
            pstmt1.setString(8,"notpaid");
            pstmt1.setString(9,"notpaid");
            pstmt1.setString(10,"notpaid");
            pstmt1.setString(11,"notpaid");
            pstmt1.setString(12,"notpaid");
            pstmt1.setString(13,"notpaid");
            pstmt1.setString(14,"notpaid");
            pstmt1.setString(15,"notpaid");
            pstmt1.setString(16,classes);
            pstmt1.setString(17,gt.getSection());
          
          pstmt1.executeUpdate();
             }
           
             if(ar4.get(j).toString().equals("fail")){
               
             
           String sql1="insert into oldstudregis(srnum,studname,classes,Syear,Eyear,sesdate,admstatus,tfeebook,sfeebook)values(?,?,?,?,?,?,?,?,?)";
     
            pstmt1=cn.prepareStatement(sql1); 
            pstmt1.setInt(1,Integer.parseInt(gt.getSrnum().toString()));
            pstmt1.setString(2,gt.getSname());
            pstmt1.setString(3,gt.getClasses());
            pstmt1.setString(4,Snyear);
            pstmt1.setString(5,Enyear);
            pstmt1.setString(6,sesdate);
            pstmt1.setString(7,gt.getAdmstatus());
            pstmt1.setString(8,tfeebook);
            pstmt1.setString(9,sfeebook);
           
          pstmt1.executeUpdate();
             
              pstmt1=null;
              
         String qry="insert into studacaddetail(srnum,syear,eyear,sname,dob,doj,gender,classes,section,house,route,buscode,tripnum,concession,feebooknum,transfeebook)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
         
            pstmt1=cn.prepareStatement(qry); 
            pstmt1.setInt(1,Integer.parseInt(gt.getSrnum().toString()));
            pstmt1.setString(2,Snyear);
            pstmt1.setString(3,Enyear);
            pstmt1.setString(4,gt.getSname());
            pstmt1.setString(5,gt.getDob());
            pstmt1.setString(6,gt.getDoj());
            pstmt1.setString(7,gt.getGender());
            pstmt1.setString(8,gt.getClasses());
            pstmt1.setString(9,gt.getSection());
            pstmt1.setString(10,gt.getHouse());
            pstmt1.setString(11,gt.getRoute());
            pstmt1.setString(12,gt.getBuscode());
            pstmt1.setString(13,gt.getTripnum());
            pstmt1.setDouble(14,gt.getConcession());
            pstmt1.setString(15,sfeebook);
            pstmt1.setString(16,tfeebook);
                       
            pstmt1.executeUpdate();
              pstmt1=null;
            
            String sql="insert into feemonthrec(srnum,Syear,Eyear,January,February,March,April,May,June,July,August,September,October,November,December,class,section)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
           
            pstmt2=cn.prepareStatement(sql); 
            pstmt2.setInt(1,Integer.parseInt(gt.getSrnum().toString()));
            pstmt2.setString(2,Snyear);
            pstmt2.setString(3,Enyear);
            pstmt2.setString(4,"notpaid");
            pstmt2.setString(5,"notpaid");
            pstmt2.setString(6,"notpaid");
            pstmt2.setString(7,"notpaid");
            pstmt2.setString(8,"notpaid");
            pstmt2.setString(9,"notpaid");
            pstmt2.setString(10,"notpaid");
            pstmt2.setString(11,"notpaid");
            pstmt2.setString(12,"notpaid");
            pstmt2.setString(13,"notpaid");
            pstmt2.setString(14,"notpaid");
            pstmt2.setString(15,"notpaid");
            pstmt2.setString(16,gt.getClasses());
            pstmt2.setString(17,gt.getSection());
          
          pstmt2.executeUpdate();
          pstmt2=null;
          
           String sqlr="insert into transfeemonthrec(srnum,Syear,Eyear,January,February,March,April,May,June,July,August,September,October,November,December,class,section)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
       
            pstmt2=cn.prepareStatement(sqlr); 
            pstmt2.setInt(1,Integer.parseInt(gt.getSrnum().toString()));
            pstmt2.setString(2,Snyear);
            pstmt2.setString(3,Enyear);
            pstmt2.setString(4,"notpaid");
            pstmt2.setString(5,"notpaid");
            pstmt2.setString(6,"notpaid");
            pstmt2.setString(7,"notpaid");
            pstmt2.setString(8,"notpaid");
            pstmt2.setString(9,"notpaid");
            pstmt2.setString(10,"notpaid");
            pstmt2.setString(11,"notpaid");
            pstmt2.setString(12,"notpaid");
            pstmt2.setString(13,"notpaid");
            pstmt2.setString(14,"notpaid");
            pstmt2.setString(15,"notpaid");
            pstmt2.setString(16,gt.getClasses());
            pstmt2.setString(17,gt.getSection());
          
          pstmt2.executeUpdate();
          pstmt2=null;
             }
               
               if(ar4.get(j).toString().equals("left")){
            
          String sql1="update oldstudregis set admstatus='Left' where srnum='"+gt.getSrnum()+"'";

         
          pstmt2=cn.prepareStatement(sql1);
          pstmt2.executeUpdate(); 
             
             }
            }
           
          String msg=new String("Registered");
                request.setAttribute("msg",msg);
                RequestDispatcher  rd1  =request.getRequestDispatcher("/fee/updatestudregisrecord.jsp"); 
                rd1.forward(request,response); 
             
            
            }
        catch(SQLException e)
        {out.println(e.getMessage());}
           }
     
        try
           {
             if(rs!=null)
             {rs.close();}
             if(pstmt!=null)
             {pstmt.close();}
             if(pstmt1!=null)
             {pstmt1.close();}
             if(pstmt2!=null)
             {pstmt2.close();}
             if(cn!=null)
             {cn.close();}
         }catch(SQLException e){}
    
    return mapping.findForward("success");
}
}    
  