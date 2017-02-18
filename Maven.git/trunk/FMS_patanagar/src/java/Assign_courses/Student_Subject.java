/*
 * Student_Subject.java
 *
 * Created on February 12, 2009, 2:44 PM
 */

package Assign_courses;

import java.io.PrintWriter;
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

public class Student_Subject extends Action {
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
         String classes="";
         String sec="";
         String session="";
         Teacher_list th=new Teacher_list();
        
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrintWriter out=response.getWriter();
        
          classes=request.getParameter("classes");
          sec=request.getParameter("sec");
          session=request.getParameter("session");
        
        out.println(classes);
         out.println(sec);
          out.println(session);
          
           String subject[] = request.getParameterValues("subject");
                  if (subject!= null) 
                     {
                             for (int i = 0; i < subject.length; i++) 
                          {
                            out.println("id" + subject[i]);
                                 
                            
                              
                           }
                     }
          String student[] = request.getParameterValues("student");
                  if (student!= null) 
                     {
                             for (int i = 0; i < student.length; i++) 
                          {
                                 for(int j = 0; j < subject.length; j++)
                                 {
              try {
                    
                 th.insert_studnt_sub(classes,session,sec,subject[j],student[i]);
           } catch (Exception ex) {
                out.println(ex.getMessage());
            }
                              out.println("id" + student[i]);
                                 
                            
                                 }
                           }
                     }
          
        return mapping.findForward(SUCCESS);
        
    }
}
