package Assign_courses;

import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import Assign_courses.class_tab_bean;
import Assign_courses.Teacher_list;
/**
 *
 * @author arjun
 * @version
 */

public class Class_table_Action extends Action {
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
     private String teach_id="";
    private String classes="";
    private String session="";
    private String subject="";
    private String day="";
    private String from_time="";
    private String to_time="";
    private int class_tab_id=0;
    private String sec="";
     private String period="";
    class_tab_bean ct= new class_tab_bean();
    Teacher_list th=new Teacher_list();
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrintWriter out=response.getWriter();
        teach_id=(String)request.getParameter("teach");       
        classes=(String)request.getParameter("class");       
        session=(String)request.getParameter("session");       
        subject=(String)request.getParameter("subject");     
        day=(String)request.getParameter("day");     
        from_time=(String)request.getParameter("from_time");      
        to_time=(String)request.getParameter("to_time");      
        sec=(String)request.getParameter("sec");      
         period=(String)request.getParameter("period");
        ct.setTeach_id(teach_id);
        ct.setClasses(classes) ;
         ct.setSession(session);
         ct.setSubject(subject);
         ct.setDay(day);
         ct.setFrom_time(from_time);
         ct.setTo_time(to_time);
         ct.setSec(sec);
         ct.setPeriod(period);
         th.insert_classtab(ct);    
        
        return mapping.findForward(SUCCESS);
        
    }
}
