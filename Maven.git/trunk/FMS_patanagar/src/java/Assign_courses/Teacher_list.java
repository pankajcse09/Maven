package Assign_courses;

import java.sql.*;
import java.util.*;
import com.myapp.struts.Dataconnectivity;
import ActionClass.JavaBeanEmp;
import Assign_courses.Course_bean;
import Assign_courses.class_tab_bean;

public class Teacher_list {
    static Connection con=null;
static PreparedStatement pstmt=null;
static PreparedStatement psmt1=null;
static ResultSet rs=null;
static ResultSet rs1=null;

 public void insert_exam_sched(class_tab_bean cb)throws SQLException
    {
        String sql = "insert into exam_schedule(exam_type,class,sec,session,sub,day,time_from,time_to)values(?,?,?,?,?,?,?,?)";
        try
        {
             Dataconnectivity dcc = new Dataconnectivity();
            try {
                con = dcc.Dataconnect();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            pstmt = con.prepareStatement(sql);
           
           
            pstmt.setString(1,cb.getExam_type());
           pstmt.setString(2,cb.getClasses());
           pstmt.setString(3,cb.getSec());
           pstmt.setString(4,cb.getSession());
           pstmt.setString(5,cb.getSubject());
             pstmt.setString(6,cb.getDay());
           pstmt.setString(7,cb.getFrom_time());
           pstmt.setString(8,cb.getTo_time());
          
           
             
             
            pstmt.executeUpdate();
        }
        catch(SQLException ex)
        {
            System.out.print(ex.getMessage());
        }
        
        finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( pstmt != null ) {

        pstmt.close();
      }

      if ( con != null ) {

        con.close();
      }
}
    }
 public boolean insert_studnt_sub(String classes,String ses,String sec,String sub,String std) throws SQLException
    {
        String sql = "insert into student_subject(class,sec,session,subject,student_name)values(?,?,?,?,?)";
        try
        {
             Dataconnectivity dcc = new Dataconnectivity();
            try {
           
                con = dcc.Dataconnect();
            } catch (Exception ex) {
                ex.printStackTrace();
            }           
            pstmt = con.prepareStatement(sql);           
           
                    pstmt.setString(1,classes);
                    pstmt.setString(2,sec);
                    pstmt.setString(3,ses);
                    pstmt.setString(4,sub);
                    pstmt.setString(5,std);                   
                           
            pstmt.executeUpdate();
        }
        
        
        finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( pstmt != null ) {

        pstmt.close();
      }

      if ( con != null ) {

        con.close();
      }
     }
        return true;
    }
 public String inRoman(int in){
     String st=""; 
     switch(in){
     case 1:
     st="I"; 
     break;
     case 2:
     st="II";
     break;
     case 3:
     st="III";
     break;
     case 4:
     st="IV";    
     break;
     case 5:
     st="V";    
     break;
     case 6:
     st="VI";    
     break;
     case 7:
     st="VII";    
     break;
     case 8:
     st="VIII";  
     break;
     case 9:
     st="IX";    
     break;
     case 10:
     st="X";
     break;
     default:
     st="";        
     }
     return st;   
    } 
 public ArrayList select_marks(String srn) throws Exception
 {
 ArrayList link_list= new ArrayList();
 
  try
        {
      String sql ="select marks from unittest where status='ACTIVE' and srno='"+srn+"'";

             Dataconnectivity dcc = new Dataconnectivity();
             con = dcc.Dataconnect();
            pstmt = con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next())
            {
                class_tab_bean rb=new class_tab_bean();
                
             
                //rb.setSrno(rs.getString("srno"));
                rb.setMarks(rs.getString("marks"));
               // rb.setSubject(rs.getString("subject"));
               // rb.setExam_type(rs.getString("examtype"));
              
             // System.out.println(rs.getString("subject"));
              // System.out.println(rs.getString("examtype"));
               System.out.println(rs.getString("marks"));
            link_list.add(rb);
              //System.out.println(link_list.add(rb));
            }
            
            
  }
  catch(SQLException se)
  {
  
  
  }
 
 return link_list;
 } 
 public ArrayList select_examtype(String srn) throws Exception
 {
 ArrayList link_list= new ArrayList();
 
  try
        {
      String sql ="select examtype from unittest where status='ACTIVE' and srno='"+srn+"'";

             Dataconnectivity dcc = new Dataconnectivity();
             con = dcc.Dataconnect();
            pstmt = con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next())
            {
                class_tab_bean rb=new class_tab_bean();
                
             
                //rb.setSrno(rs.getString("srno"));
               // rb.setMarks(rs.getString("marks"));
               // rb.setSubject(rs.getString("subject"));
                rb.setExam_type(rs.getString("examtype"));
              
              //System.out.println(rs.getString("subject"));
               System.out.println(rs.getString("examtype"));
               //System.out.println(rs.getString("marks"));
            link_list.add(rb);
              //System.out.println(link_list.add(rb));
            }
            
            
  }
  catch(SQLException se)
  {
  
  
  }
 
 return link_list;
 } 
 public ArrayList select_sub_(String srn) throws Exception
 {
 ArrayList link_list= new ArrayList();
 
  try
        {
      String sql ="select subject from unittest where status='ACTIVE' and srno='"+srn+"'";

             Dataconnectivity dcc = new Dataconnectivity();
             con = dcc.Dataconnect();
            pstmt = con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next())
            {
                class_tab_bean rb=new class_tab_bean();
                
             
               // rb.setSrno(rs.getString("srno"));
               // rb.setMarks(rs.getString("marks"));
                rb.setSubject(rs.getString("subject"));
               // rb.setExam_type(rs.getString("examtype"));
              
             // System.out.println(rs.getString("subject"));
              // System.out.println(rs.getString("examtype"));
              // System.out.println(rs.getString("marks"));
            link_list.add(rb);
              //System.out.println(link_list.add(rb));
            }
            
            
  }
  catch(SQLException se)
  {
  
  
  }
 
 return link_list;
 } 
 public ArrayList select_sub_marks(String srn) throws Exception
 {
 ArrayList link_list= new ArrayList();
 
  try
        {
      String sql ="select subject,srno,marks,examtype from unittest where status='ACTIVE' and srno='"+srn+"'";

             Dataconnectivity dcc = new Dataconnectivity();
             con = dcc.Dataconnect();
            pstmt = con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next())
            {
                class_tab_bean rb=new class_tab_bean();
                
             
                rb.setSrno(rs.getString("srno"));
                rb.setMarks(rs.getString("marks"));
                rb.setSubject(rs.getString("subject"));
                rb.setExam_type(rs.getString("examtype"));
              
              System.out.println(rs.getString("subject"));
               System.out.println(rs.getString("examtype"));
               System.out.println(rs.getString("marks"));
            link_list.add(rb);
              //System.out.println(link_list.add(rb));
            }
            
            
  }
  catch(SQLException se)
  {
  
  
  }
 
 return link_list;
 }
 public ArrayList _student_name(String ses,String cl,String sec) throws Exception
 {
 ArrayList link_list= new ArrayList();
 
  try
        {
      String sql ="select  student_name from student_subject where session='"+ses+"' and sec='"+sec+"' and class='"+cl+"' group by student_name";
             Dataconnectivity dcc = new Dataconnectivity();
             con = dcc.Dataconnect();
            pstmt = con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next())
            {
                Course_bean rb=new Course_bean();
                rb.setStudent_id(rs.getString("student_name"));
               System.out.println(rs.getString("student_name"));
            link_list.add(rb);
            
            }
            
            
  }
  catch(SQLException se)
  {
  System.out.println(se.getMessage());
  
  }
 
 return link_list;
 } 
 public ArrayList select_unit_test_details() throws Exception
 {
 ArrayList link_list= new ArrayList();
 
  try
        {
      String sql ="select sessions,cm.classes,cm.section,examtype,subject,sname,srno,marks from unittest cm join studacaddetail  ur on cm.srno=ur.srnum where cm.status='ACTIVE' group by srno";

             Dataconnectivity dcc = new Dataconnectivity();
             con = dcc.Dataconnect();
            pstmt = con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next())
            {
                class_tab_bean rb=new class_tab_bean();
                rb.setSession(rs.getString("sessions"));
                rb.setClasses(rs.getString("classes"));
                rb.setSec(rs.getString("section"));
                rb.setExam_type(rs.getString("examtype"));
                rb.setSubject(rs.getString("subject"));
                rb.setStudent_name(rs.getString("sname"));
                rb.setSrno(rs.getString("srno"));
                rb.setMarks(rs.getString("marks"));
                
           System.out.println(rs.getString("marks"));
            link_list.add(rb);
              //System.out.println(link_list.add(rb));
            }
            
            
  }
  catch(SQLException se)
  {
  
  
  }
 
 return link_list;
 } 
 public ArrayList all_student_name(String studnt_id) throws Exception
 {
 ArrayList link_list= new ArrayList();
 
  try
        {
      String sql ="select  * from student_subject where student_name='"+studnt_id+"' ";
             Dataconnectivity dcc = new Dataconnectivity();
             con = dcc.Dataconnect();
            pstmt = con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next())
            {
                Course_bean rb=new Course_bean();
                rb.setStudent_id(rs.getString("student_name"));
                rb.setSec(rs.getString("sec"));
                rb.setSession(rs.getString("session"));
                rb.setSub(rs.getString("subject"));
                rb.setClasses(rs.getString("class"));
                
               System.out.println(rs.getString("student_name"));
            link_list.add(rb);
            
            }
            
            
  }
  catch(SQLException se)
  {
  System.out.println(se.getMessage());
  
  }
 
 return link_list;
 } 
 public ArrayList select_student_name(String ses,String cl) throws Exception
 {
 ArrayList link_list= new ArrayList();
 
  try
        {
      String sql ="select  sname from studacaddetail where syear=substring('"+ses+"',1,4) and eyear=substring('"+ses+"',6,4) and classes='"+cl+"'";
             Dataconnectivity dcc = new Dataconnectivity();
             con = dcc.Dataconnect();
            pstmt = con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next())
            {
                Course_bean rb=new Course_bean();
                rb.setStudent_id(rs.getString("sname"));
               System.out.println(rs.getString("sname"));
            link_list.add(rb);
              System.out.println(link_list.add(rb));
            }          
            
  }
  catch(SQLException se)
  {
  System.out.println(se.getMessage());  
  }
 
 return link_list;
 }
 public boolean insert_examroom(class_tab_bean cb) throws SQLException
    {
        String sql = "insert into room_exam(teach_id,session,time_from,time_to,room,date)values(?,?,?,?,?,?)";
        try
        {
             Dataconnectivity dcc = new Dataconnectivity();
            try {
           
                con = dcc.Dataconnect();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
           
            pstmt = con.prepareStatement(sql);
           
           
            pstmt.setString(1,cb.getTeach_id());
           pstmt.setString(2,cb.getSession());
           pstmt.setString(3,cb.getFrom_time());
           pstmt.setString(4,cb.getTo_time());
           pstmt.setString(5,cb.getRoom());
           pstmt.setString(6,cb.getDates());
          
           
             
             
            pstmt.executeUpdate();
        }
        
        
        finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( pstmt != null ) {

        pstmt.close();
      }

      if ( con != null ) {

        con.close();
      }
}
        return true;
    }
public ArrayList allClasses(){
    ArrayList ar=new ArrayList();
    try{
    Dataconnectivity dc=new  Dataconnectivity();
    con=(Connection)dc.Dataconnect();
    } 
    catch(Exception e){}
    String qr="select distinct class from classes";
    try{
     pstmt=con.prepareStatement(qr);
     rs=pstmt.executeQuery();
     while(rs.next()){
     ar.add(rs.getString("class"));    
     }     
     }
    catch(SQLException se){}   
    return ar;
    }    
public ArrayList select_courses(String ses,String cl) throws Exception
 {
 ArrayList link_list= new ArrayList();
 
  try
        {
      String sql ="select distinct subject,cid from ex_course_detail where sessions='"+ses+"' and class='"+cl+"' group by subject";
             Dataconnectivity dcc = new Dataconnectivity();
             con = dcc.Dataconnect();
            pstmt = con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next())
            {
                Course_bean rb=new Course_bean();
               rb.setCid(rs.getInt("cid"));
               rb.setSub(rs.getString("subject"));
               System.out.println(rs.getString("subject"));
            link_list.add(rb);
            
            }
            
            
  }
  catch(SQLException se)
  {
  
  
  }
 
 return link_list;
 } 
 public ArrayList select_teach_course() throws Exception
 {
 ArrayList link_list= new ArrayList();
 
  try
        {
      String sql ="select * from class_tab";
             Dataconnectivity dcc = new Dataconnectivity();
             con = dcc.Dataconnect();
            pstmt = con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next())
            {
                class_tab_bean rb=new class_tab_bean();
          rb.setTeach_id(rs.getString("teach_id"));
            link_list.add(rb);
            }
            
            
  }
  catch(SQLException se)
  {
  
  
  }
 
 return link_list;
 }
   public ArrayList select_teach_exam() throws Exception
 {
 ArrayList link_list= new ArrayList();
 
  try
        {
      String sql ="select distinct teach_id from room_exam";
             Dataconnectivity dcc = new Dataconnectivity();
             con = dcc.Dataconnect();
            pstmt = con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next())
            {
                class_tab_bean rb=new class_tab_bean();
          rb.setTeach_id(rs.getString("teach_id"));
            link_list.add(rb);
            }
            
            
  }
  catch(SQLException se){}
 
 return link_list;
 }
  public ArrayList select_teach() throws Exception
 {
 ArrayList link_list= new ArrayList();
 
  try
        {
      String sql ="select * from loginn";
             Dataconnectivity dcc = new Dataconnectivity();
             con = dcc.Dataconnect();
            pstmt = con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next())
            {
                JavaBeanEmp rb=new JavaBeanEmp();
           rb.setProf_id(rs.getInt("rowid"));
           rb.setLoginId(rs.getString("username")) ;
            link_list.add(rb);
            
            }
            
            
  }
  catch(SQLException se)
  {
  
  
  }
 
 return link_list;
 }  
  public double select_exam_detail(String srn,String ses,String test,String classes,String sub) throws Exception
 {
 ArrayList link_list= new ArrayList();
 double mrk=0.0;
  try
        {
      String sql ="select marks from unittest where sessions='"+ses+"' and classes='"+classes+"' and examtype='"+test+"' and subject='"+sub+"' and srno='"+srn+"' and status='ACTIVE'";

            Dataconnectivity dcc = new Dataconnectivity();
            con = dcc.Dataconnect();
            pstmt = con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            try {
            
                if(rs.next()){             
                  mrk=Double.parseDouble(rs.getString("marks"));
                  }
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }                     
  }
  catch(SQLException se){ } 
 return mrk;
 }
  public ArrayList select_theorey(String ses,String classes) throws Exception
 {
 ArrayList link_list= new ArrayList();

  try
        {
      
     // select subject,theory from ex_course_detail where theory!='0' and practical='0' and sessions='2009-2010' and class ='1'
      String sql ="select subject,theory from ex_course_detail where theory<>'0' and practical='0' and sessions='"+ses+"' and class ='"+classes+"'";
             Dataconnectivity dcc = new Dataconnectivity();
             con = dcc.Dataconnect();
            pstmt = con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next())
            {
                class_tab_bean rb=new class_tab_bean();
              
                rb.setSubject(rs.getString("subject"));
                rb.setTheory(rs.getString("theory"));
              
               link_list.add(rb);
               System.out.println(link_list);
               
            }
       
            
  }
  catch(SQLException se)
  {
  
  
  }
 
 return link_list;
 } 
   public ArrayList select_prac(String ses,String classes) throws Exception
 {
 ArrayList link_list= new ArrayList();

  try
        {
      
     // select subject,theory from ex_course_detail where theory!='0' and practical='0' and sessions='2009-2010' and class ='1'
      String sql ="select subject,theory,practical from ex_course_detail where theory<>'0' and practical<>'0' and sessions='"+ses+"' and class ='"+classes+"'";
             Dataconnectivity dcc = new Dataconnectivity();
             con = dcc.Dataconnect();
            pstmt = con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next())
            {
                class_tab_bean rb=new class_tab_bean();
              
                rb.setSubject(rs.getString("subject"));
                rb.setTheory(rs.getString("theory"));
                rb.setPrac(rs.getString("practical"));
              
               link_list.add(rb);
               System.out.println(link_list);
               
            }
       
            
  }
  catch(SQLException se)
  {
  
  
  }
 
 return link_list;
 }  
 public static void main(String args[])
 {
 
 Teacher_list th=new  Teacher_list();
        try {
           // th._student_name("2008-2009","1","A");
            
      //th.select_unit_test_details();
         //  th.select_sub_marks("1237");
          // th.select_examtype("1237");
           // th.select_marks("1237");
           //  th.select_exam_detail("1237","2009-2010","UNIT TEST ONE","1","HINDI");
              th.select_theorey("2009-2010","1");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
 
 }    
 
  public class_tab_bean table_desc(String teacher,String day,String period,String ses) throws Exception
 {
 ArrayList link_list= new ArrayList();
 class_tab_bean rb=new class_tab_bean();
  try
        {
      String sql ="select subject,sec,class from class_tab where teach_id='"+teacher+"' and day='"+day+"' and period='"+period+"' and session='"+ses+"'";
             Dataconnectivity dcc = new Dataconnectivity();
             con = dcc.Dataconnect();
            pstmt = con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next())
            {
                
         // rb.setTeach_id(rs.getString("teach_id"));
          rb.setClasses(rs.getString("class"));
          rb.setSec(rs.getString("sec"));
          rb.setSubject(rs.getString("subject"));
           // link_list.add(rb);
            
            System.out.println(rs.getString("class"));
            System.out.println(rs.getString("sec"));
            System.out.println(rs.getString("subject"));
            }
            
            
  }
  catch(SQLException se)
  {
  
  System.out.println(se.getMessage());
  }
 
 
 return rb;
 }
 
  public class_tab_bean class_table(String session,String classes,String sec,String period,String days) throws Exception
 {
 ArrayList link_list= new ArrayList();
 class_tab_bean rb=new class_tab_bean();
  try
        {
      String sql ="select teach_id,subject from class_tab where session='"+session+"' and class='"+classes+"' and sec='"+sec+"' and period='"+period+"' and day='"+days+"'";
             Dataconnectivity dcc = new Dataconnectivity();
             con = dcc.Dataconnect();
            pstmt = con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next())
            {
                
         // rb.setTeach_id(rs.getString("teach_id"));
         rb.setTeach_id(rs.getString("teach_id"));
          rb.setSubject(rs.getString("subject"));
           // link_list.add(rb);
            
          //  System.out.println(rs.getString("class"));
            //System.out.println(rs.getString("sec"));
            System.out.println(rs.getString("subject"));
            }
            
            
  }
  catch(SQLException se)
  {
  
  System.out.println(se.getMessage());
  }
 
 
 return rb;
 }
  
    public String select_theory_mark(String sub,String srn) throws Exception
 {
String link_list="";
 
  try
        {
      String sql ="select marks,subject from theory where subject='"+sub+"' and srno='"+srn+"'";

             Dataconnectivity dcc = new Dataconnectivity();
             con = dcc.Dataconnect();
            pstmt = con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next())
            {
                class_tab_bean rb=new class_tab_bean();
                
                link_list=rs.getString("marks");
                
          // System.out.println(rs.getString("marks"));
          
            }
            
            
  }
  catch(SQLException se)
  {
  
  
  }
 
 return link_list;
 }
      
   
   
   
   
           
           public String select_pr_mark(String sub,String srn) throws Exception
 {
String link_list="";
 
  try
        {
      String sql ="select marks from practical where subject='"+sub+"' and srno='"+srn+"'";

             Dataconnectivity dcc = new Dataconnectivity();
             con = dcc.Dataconnect();
            pstmt = con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next())
            {
                class_tab_bean rb=new class_tab_bean();
                
                link_list=rs.getString("marks");
                
          // System.out.println(rs.getString("marks"));
          
            }
            
            
  }
  catch(SQLException se)
  {
  
  
  }
 
 return link_list;
 }

 public ArrayList select_day() throws Exception
 {
 ArrayList link_list= new ArrayList();
 
  try
        {
      String sql ="select day from class_tab group by day";
             Dataconnectivity dcc = new Dataconnectivity();
             con = dcc.Dataconnect();
            pstmt = con.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next())
            {
                class_tab_bean rb=new class_tab_bean();
          rb.setDay(rs.getString("day"));
            link_list.add(rb);
            }            
            
  }
  catch(SQLException se)
  {
  
  
  } 
 return link_list;
 }
 
 public void insert_classtab(class_tab_bean cb)throws SQLException
    {
     
      
             Dataconnectivity dcc = new Dataconnectivity();
            try {
                con = dcc.Dataconnect();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        int count=0;
          String session=cb.getSession();
          String period=cb.getPeriod();
          String day=cb.getDay();
          String classes=cb.getClasses();
          String chk="select count(*) as cnt from class_tab where session='"+session+"' and day='"+day+"' and period='"+period+"' and class='"+classes+"'";
        try {
            psmt1=con.prepareStatement(chk);   
            rs1=psmt1.executeQuery();
            rs1.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       count=rs1.getInt("cnt");
     
        String sql = "insert into class_tab(teach_id,class,session,subject,day,sec,period)values(?,?,?,?,?,?,?)";
      
      
         
            pstmt = con.prepareStatement(sql);
     try
        {       
            if(count==0){
                
            pstmt.setString(1,cb.getTeach_id());
           pstmt.setString(2,cb.getClasses());
           pstmt.setString(3,cb.getSession());
           pstmt.setString(4,cb.getSubject());
           pstmt.setString(5,cb.getDay());          
           pstmt.setString(6,cb.getSec());
            pstmt.setString(7,cb.getPeriod());
            pstmt.executeUpdate();
            }
        }
        catch(SQLException ex)
        {
            System.out.print(ex.getMessage());
        }
        
        finally {

      if ( rs != null ) {

        rs.close();
      }

      if ( pstmt != null ) {

        pstmt.close();
      }

      if ( con != null ) {

        con.close();
      }
}
    }
 
 
 
}
