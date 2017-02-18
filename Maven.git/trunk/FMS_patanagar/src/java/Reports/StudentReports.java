/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reports;

import EO.ReportsEO;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 *
 * @author kapil
 */
public class StudentReports extends DispatchAction {

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
    
    public ActionForward trans_stud(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String session=request.getParameter("session");
        String degree=request.getParameter("degree");
        
        ToDB tdb=new ToDB();
        ArrayList al= new ArrayList();
        al=tdb.transferedStudentList(session, degree);
        
        if(al.size()==0)
            request.setAttribute("msg", "Records are not found for");
        else
            request.setAttribute("list", al);
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward Noduesed_Student(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrintWriter out=response.getWriter();
        String session=request.getParameter("session");
        String degree=request.getParameter("degree");
        String session_sem=request.getParameter("session_sem");
        String reason="";
        String status="";
        if(request.getParameter("reason")!=null)
            reason=request.getParameter("reason");
        if(request.getParameter("status")!=null)
            status=request.getParameter("status");
        
        ReportsEO reo=new ReportsEO();
        reo.setDegree(degree);
        reo.setSession(session);
        reo.setSession_sem(session_sem);
        reo.setReason(reason);
        reo.setStatus(status);
        
        ToDB tdb=new ToDB();
        ArrayList al= new ArrayList();
        if(!reo.getDegree().equals("ALL"))
            al=tdb.noduesStudentWithReason1(reo);
        else
            al=tdb.noduesStudentWithReason2(reo);
        
        if(al.size()==0)
            request.setAttribute("msg", "Records are not found for");
        else
            request.setAttribute("list", al);
        return mapping.findForward(SUCCESS);
//        return mapping.findForward("");
    }
}
