/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pant.hostel.student;

import EO.SchoolEO;
import Fee.FeeMath;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 *
 * @author kapil
 */
public class HostelStudent extends DispatchAction {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    HostelDB hdb=new HostelDB();
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
   public ActionForward checkStudent(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String stud_id=request.getParameter("stud_id");
        SchoolEO seo=hdb.getStudentRegisDetail(stud_id);
        request.setAttribute("jbean", seo);
        if(seo==null)
            request.setAttribute("msg", "Student is not found at student id <b>"+stud_id+"</b> in our database.");
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward assignHostel(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session=request.getSession(false);
        if(session.getAttribute("loginid") ==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
        }
        String stud_id=request.getParameter("stud_id");
        String hostel_code="";
        if(session.getAttribute("hostel_code")!=null)
            hostel_code=(String)session.getAttribute("hostel_code");
        else
            hostel_code=request.getParameter("hcode");
        int n=hdb.updateHostelInRegisTable(stud_id, hostel_code);
        SchoolEO seo=hdb.getStudentRegisDetail(stud_id);
        request.setAttribute("jbean", seo);
        if(n==0)
            request.setAttribute("msg", "some error occured. please try again!!!");
        else
           request.setAttribute("msg", "Hostel is assigned."); 
        return mapping.findForward(SUCCESS);
    }
    
  public ActionForward studentFoodBill(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String stud_id=request.getParameter("stud_id");
        String session=request.getParameter("session");
        SchoolEO seo=hdb.getStudentRegisDetail(stud_id);
        seo.setSession(session);
        request.setAttribute("jbean", seo);
        if(seo==null)
            request.setAttribute("msg", "Student is not found at student id <b>"+stud_id+"</b> in our database.");
        ArrayList al=hdb.StudentPostedFoodBill(session, stud_id);
        request.setAttribute("list", al);
        return mapping.findForward(SUCCESS);
    }  
  
  public ActionForward deleteMonthlyFood(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String stud_id=request.getParameter("stud_id");
        String session=request.getParameter("session");
        String id=request.getParameter("id");
        Long rwid=0l;
        try{
            rwid=Long.parseLong(id);
            FeeMath fm=new FeeMath();
            int isDel=fm.deleteLongRow(rwid, "monthly_food", "rwid");
            if(isDel==1)
                request.setAttribute("msg", "Deleted successfully.");
        }catch(Exception e){
            request.setAttribute("msg", "Error in deleting.");
        }
        SchoolEO seo=hdb.getStudentRegisDetail(stud_id);
        seo.setSession(session);
        request.setAttribute("jbean", seo);
        if(seo==null)
            request.setAttribute("msg", "Student is not found at student id <b>"+stud_id+"</b> in our database.");
        ArrayList al=hdb.StudentPostedFoodBill(session, stud_id);
        request.setAttribute("list", al);
        return mapping.findForward(SUCCESS);
    }  
}
