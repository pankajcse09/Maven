/*
 * Examroom_teacher_Action.java
 *
 * Created on February 11, 2009, 3:51 PM
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
import Assign_courses.Teacher_list;
import Assign_courses.class_tab_bean;
/**
 *
 * @author arjun
 * @version
 */

public class Examroom_teacher_Action extends Action {
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    boolean tr=false;
     private String teach_id="";
     private String session="";
   
    private String dates="";
    private String from_time="";
    private String to_time="";
    private String room="";
   
   
    class_tab_bean ct= new class_tab_bean();
    Teacher_list th=new Teacher_list();
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        PrintWriter out=response.getWriter();
        teach_id=request.getParameter("teach_id");       
        session=request.getParameter("session");     
        dates=request.getParameter("dates");   
        from_time= request.getParameter("from_time");
        to_time=request.getParameter("to_time"); 
        room=request.getParameter("room");
        
         ct.setTeach_id(teach_id);
         ct.setSession(session);
         ct.setDates(dates);
         ct.setRoom(room);
         ct.setFrom_time(from_time);
         ct.setTo_time(to_time);
        try {            
            tr=th.insert_examroom(ct);
        } catch (SQLException ex) {
           out.println(ex.getMessage());
        }        
        if(tr==true)
        {
        
        out.println("true");
        }
        if(tr==false)
        {
        
        out.println("false");
        }
         
        return mapping.findForward(SUCCESS);
        
    }
}
