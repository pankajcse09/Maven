/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pant.common;

import EO.CollegeBean;
import EO.HostelBean;
import EO.SchoolEO;
import java.util.ArrayList;
import java.util.HashMap;
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
public class UtilityAction extends DispatchAction {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    UtilityDB udb=new UtilityDB();
    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction1, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     */
    public ActionForward NewBeniDetail(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession htsession=request.getSession(false);
        if(htsession.getAttribute("loginid") ==null){
            RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
            request.setAttribute("sessionExpire", "Your session is expired. Please login again!!!");
            rd1.forward(request,response);
        }
        SchoolEO se=new SchoolEO();
        String type="";
        if(request.getParameter("type")!=null)
        {
            type=(String)request.getParameter("type");
        }
        if(!type.equals(""))
        {
            SchoolEO seo=new SchoolEO();
            ArrayList heads=new ArrayList();
            HashMap hm=new HashMap();
            for(int i=0;i<6;i++)
            {
                heads.add(request.getParameter("hd"+i));
                hm.put(request.getParameter("hd"+i), request.getParameter("amount"+i));
            }
            seo.setDataArray(heads);
            seo.setDataMap(hm);
            if(type.equals("add"))
            {
                int cn=udb.addNewBeniDetails(seo);
                if(cn==0){
                    request.setAttribute("msg", "Data is stored.");
                }
                else{
                    request.setAttribute("msg", "Data is already present. So you can update the exist data.");
                }
            }
            else if(type.equals("update"))
            {
                udb.updateNewBeniDetails(seo);
                request.setAttribute("msg1", "New beni data is updated.");
            }
        }
        se=udb.retNewBeniDetails();
        request.setAttribute("jbean", se);
        return mapping.findForward(SUCCESS);
    }

    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction2, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     */
    public ActionForward addCollege(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession htsession=request.getSession(false);
        if(htsession.getAttribute("loginid") ==null){
            RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
            request.setAttribute("sessionExpire", "Your session is expired. Please login again!!!");
            rd1.forward(request,response);
        }
        String college=request.getParameter("college_name");
        String college_code=request.getParameter("college_code");
        int cn=udb.checkCollOrHos("college", college_code);
        
                if(cn==0){
                    udb.saveCollege(college, college_code);
                    request.setAttribute("msg", "College is stored.");
                }
                else if(cn==1){
                    request.setAttribute("msg", "College code "+college_code+" is already exist in the record.");
                }
                else{
                    request.setAttribute("msg", "Some error occured. Please try again!!!");
                }
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward viewCollege(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession htsession=request.getSession(false);
        if(htsession.getAttribute("loginid") ==null){
            RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
            request.setAttribute("sessionExpire", "Your session is expired. Please login again!!!");
            rd1.forward(request,response);
        }
        ArrayList list=udb.collegeList();
        request.setAttribute("list", list);
        if(request.getParameter("id")!=null){
            int id;
            CollegeBean cb=null;
            try{
                id=Integer.parseInt(request.getParameter("id"));
                cb=udb.collegeById(id);
            }catch(Exception e){
                request.setAttribute("msg", "Something went wrong. Please try again!!!");
            }
            request.setAttribute("collegebean", cb);
        }
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward updateCollege(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession htsession=request.getSession(false);
        if(htsession.getAttribute("loginid") ==null){
            RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
            request.setAttribute("sessionExpire", "Your session is expired. Please login again!!!");
            rd1.forward(request,response);
        }
        String college=request.getParameter("college_name");
        String code=request.getParameter("college_code");
        int rw=0;
        CollegeBean cb=new CollegeBean();
        try{
            cb.setCollegeName(college);
            cb.setCollegeCode(code);
            rw=Integer.parseInt(request.getParameter("id"));
            cb.setRid(rw);
            int cn=udb.checkCollOrHosUpdate("college", code, rw);
            if(cn==0){
                udb.updateCollege(cb);
                request.setAttribute("msg", "data is updated.");
                }
                else if(cn==1){
                    request.setAttribute("msg", "College code "+code+" is already associated with other college.");
                }
                else{
                    request.setAttribute("msg", "Some error occured. Please try again!!!");
                }
        }catch(Exception e){}
        
        ArrayList list=udb.collegeList();
        request.setAttribute("list", list);
        return mapping.findForward(SUCCESS);        
     }
    
    public ActionForward delCollege(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        HttpSession htsession=request.getSession(false);
        if(htsession.getAttribute("loginid") ==null){
            RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
            request.setAttribute("sessionExpire", "Your session is expired. Please login again!!!");
            rd1.forward(request,response);
        }ArrayList fine_detail=new ArrayList();
        int rid=0;
        try{
            rid=Integer.parseInt(request.getParameter("id"));
        }
        catch(Exception e){}     
        udb.delCollegeOrHos("college",rid);
        ArrayList list=udb.collegeList();
        request.setAttribute("list", list);
        return mapping.findForward(SUCCESS);        
        }
    
// Hostel Utility
    public ActionForward addHostel(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession htsession=request.getSession(false);
        if(htsession.getAttribute("loginid") ==null){
            RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
            request.setAttribute("sessionExpire", "Your session is expired. Please login again!!!");
            rd1.forward(request,response);
        }
        String hostel=request.getParameter("hostel_name");
        String hostel_code=request.getParameter("hostel_code");
        int cn=udb.checkCollOrHos("hostel", hostel_code);
        
                if(cn==0){
                    udb.saveHostel(hostel, hostel_code);
                    request.setAttribute("msg", "Hostel is stored.");
                }
                else if(cn==1){
                    request.setAttribute("msg", "Hostel code "+hostel_code+" is already exist in the record.");
                }
                else{
                    request.setAttribute("msg", "Some error occured. Please try again!!!");
                }
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward viewHostel(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession htsession=request.getSession(false);
        if(htsession.getAttribute("loginid") ==null){
            RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
            request.setAttribute("sessionExpire", "Your session is expired. Please login again!!!");
            rd1.forward(request,response);
        }
        ArrayList list=udb.hostelList();
        request.setAttribute("list", list);
        if(request.getParameter("id")!=null){
            int id;
            HostelBean hb=null;
            try{
                id=Integer.parseInt(request.getParameter("id"));
                hb=udb.hostelById(id);
            }catch(Exception e){
                request.setAttribute("msg", "Something went wrong. Please try again!!!");
            }
            request.setAttribute("hostelbean", hb);
        }
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward updateHostel(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession htsession=request.getSession(false);
        if(htsession.getAttribute("loginid") ==null){
            RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
            request.setAttribute("sessionExpire", "Your session is expired. Please login again!!!");
            rd1.forward(request,response);
        }
        String hostel=request.getParameter("hostel_name");
        String code=request.getParameter("hostel_code");
        int rw=0;
        HostelBean hb=new HostelBean();
        try{
            hb.setHostelName(hostel);
            hb.setHostelCode(code);
            rw=Integer.parseInt(request.getParameter("id"));
            hb.setRid(rw);
            int cn=udb.checkCollOrHosUpdate("hostel", code, rw);
            if(cn==0){
                udb.updateHostel(hb);
                request.setAttribute("msg", "data is updated.");
                }
                else if(cn==1){
                    request.setAttribute("msg", "Hostel code "+code+" is already associated with other hostel.");
                }
                else{
                    request.setAttribute("msg", "Some error occured. Please try again!!!");
                }
        }catch(Exception e){}
        
        ArrayList list=udb.hostelList();
        request.setAttribute("list", list);
        return mapping.findForward(SUCCESS);        
     }
    
    public ActionForward delHostel(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        HttpSession htsession=request.getSession(false);
        if(htsession.getAttribute("loginid") ==null){
            RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
            request.setAttribute("sessionExpire", "Your session is expired. Please login again!!!");
            rd1.forward(request,response);
        }
        int rid=0;
        try{
            rid=Integer.parseInt(request.getParameter("id"));
        }
        catch(Exception e){}     
        udb.delCollegeOrHos("hostel",rid);
        ArrayList list=udb.hostelList();
        request.setAttribute("list", list);
        return mapping.findForward(SUCCESS);        
        }
}
