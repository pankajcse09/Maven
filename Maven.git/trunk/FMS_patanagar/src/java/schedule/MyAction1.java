package schedule;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import java.util.*;
import ActionClass.*;
/**
 *
 * @author kanchan
 */
public class MyAction1 extends DispatchAction{
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "success"; 
    
          public ActionForward updateMarksAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         
        JavaBeanExam jb=new JavaBeanExam();
        PrintWriter out=response.getWriter();
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
        
        DataObject1 dataobj=new DataObject1();        
        JavaBeanExam jb1=(JavaBeanExam)dataobj.retriveSubjects(jb); 
        jb1.setSubject(sub);    
        jb1.setExam(exam);
        ArrayList ar=(ArrayList)dataobj.allStudList(jb);
        //jb.setStudList(ar);
        JavaBeanExam jb2=(JavaBeanExam)dataobj.marksList(jb);
        ArrayList ar1=(ArrayList)jb2.getRowidList();
        HashMap hm1=(HashMap)jb2.getStudListMap();
        HashMap hm2=(HashMap)jb2.getMarksList();
           
        jb1.setRowidList(ar1);
        jb1.setStudListMap(hm1);
        jb1.setMarksList(hm2);
        HashMap hm=(HashMap)dataobj.marksType(jb);
        //jb1.setStudList(ar);
        jb1.setMarksType(hm);
        request.setAttribute("jbean",jb1);      
        return mapping.findForward(SUCCESS);       
        } 
         
         public ActionForward selectInfoAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         
        JavaBeanExam jb=new JavaBeanExam();
        PrintWriter out=response.getWriter();
        String sesn=(String)request.getParameter("sessions");        
        String clas=(String)request.getParameter("classes");  
        String sec=(String)request.getParameter("section");
        String exmtyp=(String)request.getParameter("examtype");        
              
        jb.setSessions(sesn);
        jb.setClasses(clas);
        jb.setSection(sec);
        jb.setExamType(exmtyp);
           
        DataObject1 dataobj=new DataObject1();        
        JavaBeanExam jb1=(JavaBeanExam)dataobj.retriveSubjects(jb);
        ArrayList ar=(ArrayList)dataobj.allStudList(jb);
        jb1.setStudList(ar);
        request.setAttribute("jbean",jb1);      
        return mapping.findForward(SUCCESS);       
        } 
            
          public ActionForward selectInfoAction1(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         
        JavaBeanExam jb=new JavaBeanExam();
        PrintWriter out=response.getWriter();
        String sesn=(String)request.getParameter("sessions");        
        String clas=(String)request.getParameter("classes");  
        String sec=(String)request.getParameter("section");
        String exmtyp=(String)request.getParameter("examtype");        
              
        jb.setSessions(sesn);
        jb.setClasses(clas);
        jb.setSection(sec);
        jb.setExamType(exmtyp);
           
        DataObject1 dataobj=new DataObject1();        
        JavaBeanExam jb1=(JavaBeanExam)dataobj.retriveSubjects(jb);
        ArrayList ar=(ArrayList)dataobj.allStudList(jb);
        jb1.setStudList(ar);
        request.setAttribute("jbean",jb1);      
        return mapping.findForward(SUCCESS);       
        }  
        
              public ActionForward enterMarksAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         
        JavaBeanExam jb=new JavaBeanExam();
        PrintWriter out=response.getWriter();
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
        
        DataObject1 dataobj=new DataObject1();        
        JavaBeanExam jb1=(JavaBeanExam)dataobj.retriveSubjects(jb); 
        jb1.setSubject(sub);    
        jb1.setExam(exam);
        ArrayList ar=(ArrayList)dataobj.allStudList(jb);
        HashMap hm=(HashMap)dataobj.marksType(jb);
        jb1.setStudList(ar);
        jb1.setMarksType(hm);
        request.setAttribute("jbean",jb1);      
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
             
        public ActionForward selectStudentAction(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception {         
        JavaBeanExam jb=new JavaBeanExam();
        PrintWriter out=response.getWriter();
        String exam=(String)request.getParameter("exam"); 
        String rid=(String)request.getParameter("rid");        
 
        jb.setExam(exam);
        jb.setRowid(rid);
        
        DataObject1 dataobj=new DataObject1();        
        JavaBeanExam jb1=(JavaBeanExam)dataobj.studMarks(jb);            
        jb1.setExam(exam);
        jb1.setRowid(rid);
        request.setAttribute("jbean",jb1);      
        return mapping.findForward(SUCCESS);       
        }
       
            public ActionForward updateMarks(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception {         
        JavaBeanExam jb=new JavaBeanExam();
        PrintWriter out=response.getWriter();
        String exam=(String)request.getParameter("exam"); 
        String rid=(String)request.getParameter("rowid");  
        String srno=(String)request.getParameter("srno"); 
        String marks=(String)request.getParameter("marks"); 
 
        jb.setExam(exam);
        jb.setRowid(rid);
        jb.setStudId(srno);
        jb.setMarks(marks);
            
        DataObject1 dataobj=new DataObject1();        
        JavaBeanExam jb1=dataobj.updateStudMarks(jb);  
        
        JavaBeanExam jb2=(JavaBeanExam)dataobj.retriveSubjects(jb);
        jb1.setSubList(jb2.getSubList());
        ArrayList ar=(ArrayList)dataobj.allStudList(jb);        
        jb1.setStudList(ar);
        request.setAttribute("jbean",jb1);      
        return mapping.findForward(SUCCESS);       
        }    
            
               public ActionForward examAttendence(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        JavaBeanExam jb=new JavaBeanExam();
        PrintWriter out=response.getWriter();
        String ssn="";
        String cls="";
        String sec="";
        String sub="";
        String exmtyp="";
        ArrayList ar1=new ArrayList();
        ArrayList ar2=new ArrayList();
        ArrayList ar3=new ArrayList();
        ArrayList ar4=new ArrayList();       
        ssn=(String)request.getParameter("session");
        cls=(String)request.getParameter("class");    
        sec=(String)request.getParameter("section"); 
        sub=(String)request.getParameter("subject");    
        exmtyp=(String)request.getParameter("examtype"); 
         jb.setSessions(ssn);
         jb.setClasses(cls);   
         jb.setSection(sec);
         jb.setSubject(sub);
         jb.setExamType(exmtyp);
        Enumeration enu=request.getParameterNames();
        while(enu.hasMoreElements()){
         String param=(String)enu.nextElement();  
         try{
         if(param.substring(0,3).equals("stu")){
         ar1.add(param);    
         }
          if(param.substring(0,3).equals("sts")){
           ar2.add(param);  
         } 
         }
         catch(StringIndexOutOfBoundsException soe){}
        }
        for(int i=0;i<ar1.size();i++){
        ar3.add(request.getParameter("stu"+i));    
        }
         for(int j=0;j<ar2.size();j++){
         ar4.add(request.getParameter("sts"+j));    
        }    
        jb.setStudList(ar3);
        jb.setStudAttend(ar4);
 
        DataObject1 dob=new DataObject1();        
        int bn=dob.examAttendData(jb);  
        if(bn==1){
        request.setAttribute("msg","Data Submitted");    
        }
        else{
        request.setAttribute("msg","Data Already Exists");     
        }
        return mapping.findForward(SUCCESS);        
    }
        
}