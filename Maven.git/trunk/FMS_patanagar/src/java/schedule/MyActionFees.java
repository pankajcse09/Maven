package schedule;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import java.util.*;
import ActionClass.*;
/**
 *
 * @author kanchan
 */
public class MyActionFees extends DispatchAction{
    
       /* forward name="success" path="" */
           private final static String SUCCESS = "success"; 
    
            public ActionForward subFeeHeadAct(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         
        JavaBeanExam jb=new JavaBeanExam();
        PrintWriter out=response.getWriter();
        String exam="";
//        String sesn=(String)request.getParameter("sessions");        
//        String clas=(String)request.getParameter("classes"); 
        String fee_type="";
        String head="";
        String htype="";
        String heads_cat="";
        String stud_type="";
//        String session="";
//        if(request.getParameter("session")!=null)
//        {
//            session=(String)request.getParameter("session");
//        }
        if(request.getParameter("fee_type")!=null)
        {
            fee_type=(String)request.getParameter("fee_type");
        }
        if(request.getParameter("feehead")!=null)
        {
            head=(String)request.getParameter("feehead");
        }
        if(request.getParameter("head_type")!=null)
        {
            htype=(String)request.getParameter("head_type");
        }
        if(request.getParameter("dues_type")!=null)
        {
            heads_cat=(String)request.getParameter("dues_type");
        }
        if(request.getParameter("stud_type")!=null)
        {
            stud_type=(String)request.getParameter("stud_type");
        }
        
        String hac=request.getParameter("head_ac"); 
//        jb.setSessions(sesn);
//        jb.setClasses(clas);   
        jb.setFeeHead(head.toUpperCase());
        jb.setHeadType(htype);
        jb.setFeeType(fee_type);
        jb.setHeadAc(hac);
        jb.setHeads_cat(heads_cat);
        jb.setStud_type(stud_type);
//        jb.setSessions(session);
              
        DataObjectFee dobj=new DataObjectFee();        
        int bn=dobj.submitFeeHeads(jb); 
        if(bn==0){
        request.setAttribute("msg","Data Submitted");   
        }
        else{
        if(bn==-1){
        request.setAttribute("msg","DataBase Error");   
        }    
        else{
        request.setAttribute("msg","Data Already Exists");     
        }
        }
        
        MyMeth fn=new MyMeth();
         ArrayList DegreeList=new ArrayList();
         DegreeList=(ArrayList)fn.Degree_list();
         
         request.setAttribute("degreelist",DegreeList);        
        request.setAttribute("jbean",jb);      
        return mapping.findForward(SUCCESS);       
        } 
              
             public ActionForward submitMarksAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {         
        JavaBeanExam jb=new JavaBeanExam();
        PrintWriter out=response.getWriter();
        int bn=0;
        String exam="";
        String sesn=(String)request.getParameter("sessions");        
        String clas=(String)request.getParameter("classes");  
        String sec=(String)request.getParameter("section");
        String exmtyp=(String)request.getParameter("examtype");    
        String sub=(String)request.getParameter("subject");
        if(request.getParameter("exam")!=null){
        exam=(String)request.getParameter("exam");
        }  
        else{
        exam="unittest";    
        }
        jb.setSessions(sesn);
        jb.setClasses(clas);
        jb.setSection(sec);
        jb.setExamType(exmtyp);        
        jb.setSubject(sub);
        jb.setExam(exam);    
        
        String pn="";
        ArrayList ar2=new ArrayList();
        ArrayList ar3=new ArrayList();
        ArrayList ar4=new ArrayList();
        HashMap hm2=new HashMap();    
        Enumeration en=(Enumeration)request.getParameterNames();        
        while(en.hasMoreElements()){
        pn=(String)en.nextElement();
        if(pn.substring(0,3).equals("srn") || pn.substring(0,3).equals("the") || pn.substring(0,3).equals("pra") || pn.substring(0,3).equals("mcq") || pn.substring(0,3).equals("uni")){   
        if(pn.substring(0,3).equals("srn")){
        ar2.add(pn);    
        }
        if(pn.substring(0,3).equals("the")){
        ar3.add(pn);     
        }
        if(pn.substring(0,3).equals("pra")){
        ar3.add(pn);     
        }
        if(pn.substring(0,3).equals("mcq")){
        ar3.add(pn);     
        }
        if(pn.substring(0,3).equals("uni")){
        ar3.add(pn);     
        }
        }
        else{continue;}
        }
        for(int i=0;i<ar2.size();i++){
        ar4.add(request.getParameter(ar2.get(i).toString()));    
        hm2.put(request.getParameter(ar2.get(i).toString()),request.getParameter(ar3.get(i).toString()));
        }
        jb.setStudList(ar4);
        jb.setMarksList(hm2);
        DataObject1 dataobj=new DataObject1();          
        bn=dataobj.submitMarks(jb);
        JavaBeanExam jb1=(JavaBeanExam)dataobj.retriveSubjects(jb); 
        jb1.setSubject(sub);    
        jb1.setExam(exam);
        ArrayList ar=(ArrayList)dataobj.allStudList(jb);
        HashMap hm=(HashMap)dataobj.marksType(jb);
        jb1.setStudList(ar);
        jb1.setMarksType(hm);
        request.setAttribute("jbean",jb1);    
        request.setAttribute("msg","Data Submitted");
        return mapping.findForward(SUCCESS);    
        }         
   }