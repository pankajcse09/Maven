/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionClass;

import EO.SchoolEO;
import Fee.FeeMath;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author kapil
 */
public class Student_Id extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrintWriter out=response.getWriter();
        SchoolEO seo=new SchoolEO();
        DataObj doj=new DataObj();
        String session=""; 
        String session_sem="";
        String regno="";
        int rows=0;
        ArrayList al=new ArrayList();
        if(request.getParameter("session")!=null)
        {
            session=(String)request.getParameter("session");
        }
        if(request.getParameter("session_sem")!=null)
        {
            session_sem=(String)request.getParameter("session_sem");
        }
        if(request.getParameter("regist_no")!=null)
        {
            regno=(String)request.getParameter("regist_no");
        }
        String stud_id=(String)request.getParameter("stud_id");
        seo.setSession(session);
        seo.setSession_sem(session_sem);
        seo.setSrnum(regno);
        seo.setStud_id(stud_id);
        //System.out.println(seo.getSession()+" "+seo.getSrnum()+" "+seo.getSession_sem()+" "+seo.getStud_id());
     FeeMath fm=new FeeMath();
     int cn=doj.checkStudId(seo);
       //System.out.println("sname: "+seo1.getSname());
     
     
     if(cn==-4){
           request.setAttribute("msg", "Student details is not found.");
       }
     else{
         SchoolEO seo1=fm.retstudData(regno, session);
         seo1.setSession_sem(session_sem);
         seo1.setCounter(cn);
        if(cn==0)
            {
                request.setAttribute("msg", "No fee record is found!");
            }
        else if(cn>=0){
            int cnt=doj.enterStudentId(seo);
            if(cnt>=1)
                request.setAttribute("msg", "Student Id is added!");
            else if(cnt==-3)
                request.setAttribute("msg", "Rollback. Please try again!");
            else
                request.setAttribute("msg", "Please try again!");
            al=doj.getDraftList(seo);
            request.setAttribute("list",al);
            
       }
       else if(cn==-2){
           request.setAttribute("msg", "Student Id is already present to this student.");
       }
     }
        
        return mapping.findForward(SUCCESS);
//         return mapping.findForward("");
    }
}
