package AO;

import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.myapp.struts.DataConnection;
import java.sql.*;
import java.util.*;
import AO.datediff.*;
import EO.SchoolEO;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import java.text.SimpleDateFormat;
import schedule.*;

public class UpdateMethods {
    
    PreparedStatement psmt1=null;
    PreparedStatement psmt5=null;
    PreparedStatement psmt6=null;    
    PreparedStatement psmt7=null;   

    public UpdateMethods(){}
  
    public int updateAll(JavaBeanExam jb){    
          Connection con=null;
          try{
           DataConnection dc=new DataConnection();
           con=(Connection)dc.Dataconnect();
          }
          catch(Exception e){}          
          int count=0;          
          String qr1="update entermarks set section='"+jb.getSection()+"' where srno='"+jb.getStudId()+"' and sessions='"+jb.getSessions()+"' and classes='"+jb.getClasses()+"'";
          String qr5="update studdailyattend set section='"+jb.getSection()+"' where srno='"+jb.getStudId()+"' and froms=substring('"+jb.getSessions()+"',1,4) and tos=substring('"+jb.getSessions()+"',6,4) and class='"+jb.getClasses()+"'";
          String qr6="update examattendence set section='"+jb.getSection()+"' where srnum='"+jb.getStudId()+"' and sessions='"+jb.getSessions()+"' and classes='"+jb.getClasses()+"'";          
          String qr7="update student_subject set sec='"+jb.getSection()+"' where srnum='"+jb.getStudId()+"' and session='"+jb.getSessions()+"' and class='"+jb.getClasses()+"'";          
          try{           
          psmt1=con.prepareStatement(qr1);           
          psmt1.executeUpdate();  
          psmt5=con.prepareStatement(qr5); 
          psmt5.executeUpdate();
          psmt6=con.prepareStatement(qr6); 
          psmt6.executeUpdate();
          psmt7=con.prepareStatement(qr7); 
          psmt7.executeUpdate();
          }
          catch(SQLException se){count=-1;}
          finally{
          try{    
          if(psmt1!=null){psmt1.close();}
          if(psmt5!=null){psmt5.close();}
          if(psmt6!=null){psmt6.close();}
          if(psmt7!=null){psmt7.close();}
          if(con!=null){con.close();}
          }
          catch(SQLException se){}
          }          
         return count; 
    }  
    
}
