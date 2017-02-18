/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reports;

import EO.SchoolEO;
import Fee.FeeMath;
import com.myapp.struts.Dataconnectivity;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author kapil
 */
public class StudentLadder extends DispatchAction {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";

    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction1, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     */
    public ActionForward genStudentLadder(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String session=request.getParameter("session");
        String stud_id=request.getParameter("stud_id");
        SchoolEO seo=new SchoolEO();
        seo.setSession(session);
        seo.setStud_id(stud_id);
        
        ArrayList headscat_count=new ArrayList();
        ToDB tdb=new ToDB();
        
                
        seo=tdb.getStudentDetails(seo);
        if(seo.getSname()!=null&&!seo.getSname().equals("")){
            FeeMath fm=new FeeMath();
        Connection con=null;
        try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  }catch(Exception e){}
            Double advance= fm.foodAdvance(seo.getStud_id(), "continue", con);
            headscat_count=tdb.fee_Heads_byCat(seo);
            seo=tdb.retFeeHeadsOfSTudentFee(seo);
            ArrayList seoList=tdb.retFeeOfSTudentHeadwise(seo);
            seo=tdb.getStudentMonthlyFoodDetails(seo);
            if(advance==null){
                advance= tdb.singleFieldValueFromStud_fee_detail(seo.getStud_id(), "field10", con);
            }
            request.setAttribute("seoList", seoList);
            request.setAttribute("advance", advance);
        }
        request.setAttribute("headscat_count", headscat_count);
        request.setAttribute("jbean", seo);
        return mapping.findForward(SUCCESS);
    }

    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction2, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     */
    public ActionForward noduesedstudent(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String session=request.getParameter("session");
        String session_sem=request.getParameter("session_sem");
        String degree=request.getParameter("degree");
        SchoolEO seo=new SchoolEO();
        seo.setSession(session);
        seo.setSession_sem(session_sem);
        seo.setDegree(degree);
        
        ArrayList list=new ArrayList();
        ToDB tdb=new ToDB();
        list=tdb.noduesedStudentList(seo);
        request.setAttribute("list", list);
        request.setAttribute("jbean", seo);
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward ne(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {  
        HttpSession htsession=request.getSession(false);

        String par_dt1="";
        if(request.getParameter("dated1")!=null)
        {
            par_dt1=(String)request.getParameter("dated1");
        }
        java.util.Date currentDate=new java.util.Date();
        if(!par_dt1.equals("")){
            SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
            currentDate=sdf.parse(par_dt1);
        }        
        ArrayList list=new ArrayList();
        ToDB tdb=new ToDB();
        list=tdb.noduesedStudentListForRegistrar(currentDate);
        String filename=tdb.getExcelFilenameOfNodues(currentDate);
        request.setAttribute("list", list);
        request.setAttribute("filename", filename);
        request.setAttribute("date1", par_dt1);
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward neList(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {  
        HttpSession htsession=request.getSession(false);
    if(htsession.getAttribute("loginid")==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
    }
        String par_dt1="";
        if(request.getParameter("dated1")!=null)
        {
            par_dt1=(String)request.getParameter("dated1");
        }
        java.util.Date currentDate=new java.util.Date();
        if(!par_dt1.equals("")){
            SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
            currentDate=sdf.parse(par_dt1);
        }        
        ArrayList list=new ArrayList();
        ToDB tdb=new ToDB();
        list=tdb.noduesedStudentListForRegistrar(currentDate);
        String filename=tdb.getExcelFilenameOfNodues(currentDate);
        request.setAttribute("list", list);
        request.setAttribute("filename", filename);
        request.setAttribute("date1", par_dt1);
        return mapping.findForward(SUCCESS);
    }
}
