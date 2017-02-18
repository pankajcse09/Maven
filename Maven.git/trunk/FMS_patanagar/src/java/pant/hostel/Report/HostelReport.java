/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pant.hostel.Report;

import EO.HostelBean;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import pant.hostel.student.HostelDB;

/**
 *
 * @author kapil
 */
public class HostelReport extends DispatchAction {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";

    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction1, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     */
    public ActionForward monthlyFoodBill(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession htSession=request.getSession(false);
        if(htSession.getAttribute("loginid") ==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
        }
        String session=request.getParameter("session");
        String month=request.getParameter("month");
        String hostel_code="";
        if(htSession.getAttribute("hostel_code")!=null)
            hostel_code=(String)htSession.getAttribute("hostel_code");
        else
            hostel_code=request.getParameter("hcode");
        
        int page = 1;
        int recordsPerPage = 50;
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
        int offset=(page-1)*recordsPerPage;
        
        HostelReportDB hrdb=new HostelReportDB();
        ArrayList al=hrdb.foodBillReport(session, month, hostel_code, offset, recordsPerPage);
         
        int noOfRecords = hrdb.getNoOfRecords();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
               
        request.setAttribute("offset", Integer.toString(offset));
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        request.setAttribute("list", al);
        request.setAttribute("hostel_code", hostel_code);
        return mapping.findForward(SUCCESS);
    }

    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction2, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     */
    public ActionForward myAction2(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        return mapping.findForward(SUCCESS);
    }
}
