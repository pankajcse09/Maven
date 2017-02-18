/*
 * Exam_schedule_Action.java
 *
 * Created on February 12, 2009, 6:12 PM
 */

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

public class Exam_schedule_Action extends Action {
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    String exam_type="";
    String classes="";
    String sect="";
    String session="";
    String sub="";
    String dt="";
    String time_from="";
    String time_to="";
    class_tab_bean cb=new class_tab_bean();
    Teacher_list th=new Teacher_list();
    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        PrintWriter out=response.getWriter();
        exam_type=(String)request.getParameter("examtype");
 classes=(String)request.getParameter("class"); 
 sect=(String)request.getParameter("sec");
 session=(String)request.getParameter("session");
  sub=(String)request.getParameter("subject");  
  dt=(String)request.getParameter("dates"); 
  time_from=(String)request.getParameter("from_time");
  time_to=(String)request.getParameter("to_time");
  
  cb.setExam_type(exam_type);
  cb.setClasses(classes);
  cb.setSec(sect);
  cb.setSession(session);
  cb.setSubject(sub);
  cb.setDates(dt);
  cb.setFrom_time(time_from);
  cb.setTo_time(time_to);
  
         try{            
            th.insert_exam_sched(cb);
            } 
        catch (SQLException ex) {
        out.println(ex.getMessage());
            }
  
        return mapping.findForward(SUCCESS);
        
    }
}
