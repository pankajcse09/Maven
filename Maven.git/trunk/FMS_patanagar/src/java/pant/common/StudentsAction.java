/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pant.common;

import EO.SchoolEO;
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
public class StudentsAction extends DispatchAction {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";

    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction1, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     */
    public ActionForward reg(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession htsession=request.getSession(false);
        if(htsession.getAttribute("loginid") ==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
    }
            String batch=request.getParameter("batch"); 
            String srnum=request.getParameter("srnum"); 
            String stud_id=request.getParameter("stud_id"); 
            String deg=(String)request.getParameter("degree");
            String sname=request.getParameter("sname");  
            String gender=request.getParameter("gender");  
            String dob=request.getParameter("dob");          
            String fname=request.getParameter("fname"); 
            String foccup=(String)request.getParameter("foccup");
            String cat=request.getParameter("category");
            String icar=(String)request.getParameter("icar");
            String gate=request.getParameter("gate");
            String stud_type=(String)request.getParameter("stud_type");
            String new_beni=request.getParameter("new_beni");
            
            String session=new String("");
            try{
                session=batch+"-"+(Integer.parseInt(batch)+1);
             }catch(NumberFormatException e){System.out.println("Ex: "+e.getMessage());}
            
            SchoolEO seo=new SchoolEO();
            seo.setBatch(batch);
            seo.setSession(session);
            seo.setSrnum(srnum);
            seo.setStud_id(stud_id);
            seo.setDegree(deg);
            seo.setSname(sname);
            seo.setGender(gender);
            seo.setDob(dob);
            seo.setFname(fname);
            seo.setFprof(foccup);
            seo.setCategory(cat);
            seo.setIcar(icar);
            seo.setGate(gate);
            seo.setStud_type(stud_type);
            seo.setNewBeni(new_beni);
            
            StudentDB sdb=new StudentDB();
            int n=sdb.checkStudent(srnum, stud_id);
            if(n==0)
            {
                n=sdb.registerStudent(seo);
                if(n!=0)
                    request.setAttribute("msg", "Student detail is stored in our record.");
                else
                    request.setAttribute("msg", "Some error occured in our database.");
            }
            else
                request.setAttribute("msg", "Student already present in our record on roll no. "+srnum+" or student id "+stud_id);
            
        return mapping.findForward(SUCCESS);
    }
    

    public ActionForward retSt(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String batch=request.getParameter("batch");
        String srnum="";
        String stud_id="";
        if(request.getParameter("srnum")!=null){
            srnum=request.getParameter("srnum");
        }
        if(request.getParameter("srnum")!=null){
            stud_id=request.getParameter("stud_id");
        }
        SchoolEO seo=new SchoolEO();
        seo.setBatch(batch);
        seo.setSrnum(srnum);
        seo.setStud_id(stud_id);
        StudentDB sdb=new StudentDB();
        
        int cn=sdb.checkAftRegisStudent(srnum, stud_id,batch);
        if(cn!=0){
        SchoolEO seo1=new SchoolEO();
        seo1=sdb.getStudentRegisDetail(seo);
        request.setAttribute("jbean", seo1);
        }
        else{
          request.setAttribute("msg", "Student record is not found for student id "+seo.getStud_id()+" or rollno "+seo.getSrnum());  
        }
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward updSt(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession htsession=request.getSession(false);
        if(htsession.getAttribute("loginid") ==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
    }
            String batch=request.getParameter("batch"); 
            String srnum=request.getParameter("srnum"); 
            String stud_id=request.getParameter("stud_id"); 
            String deg=(String)request.getParameter("degree");
            String sname=request.getParameter("sname");  
            String gender=request.getParameter("gender");                    
            String fname=request.getParameter("fname"); 
            String foccup=(String)request.getParameter("foccup");
            String cat=request.getParameter("category");
            String icar=(String)request.getParameter("icar");
            String gate=request.getParameter("gate");
            String stud_type=(String)request.getParameter("stud_type");
            String new_beni=request.getParameter("new_beni");
            String rid=request.getParameter("rid");
            String session=new String("");
            try{
                session=batch+"-"+(Integer.parseInt(batch)+1);
             }catch(NumberFormatException e){System.out.println("Ex: "+e.getMessage());}
            
            SchoolEO seo=new SchoolEO();
            seo.setBatch(batch);
            seo.setSession(session);
            seo.setSrnum(srnum);
            seo.setStud_id(stud_id);
            seo.setDegree(deg);
            seo.setSname(sname);
            seo.setGender(gender);
            seo.setFname(fname);
            seo.setFprof(foccup);
            seo.setCategory(cat);
            seo.setIcar(icar);
            seo.setGate(gate);
            seo.setStud_type(stud_type);
            seo.setNewBeni(new_beni);
            seo.setRwid(Long.parseLong(rid));
            
            StudentDB sdb=new StudentDB();
            int n=sdb.updateRegisteredStudent(seo);
                if(n!=0)
                    request.setAttribute("msg", "Student detail is updates in our record.");
                else
                    request.setAttribute("msg", "Some error occured in updation.");
            
          SchoolEO seo1=new SchoolEO();
        seo1=sdb.getStudentRegisDetail(seo);
        request.setAttribute("jbean", seo1);  
        return mapping.findForward(SUCCESS);
    }
    
}
