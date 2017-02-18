package ActionClass;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import Beans.JavaBean;
import java.util.*;
import EO.SchoolEO;
import Beans.*;
/**
 *
 * @author kanchan
 */
public class MyAc extends DispatchAction {
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "success"; 
    
    public ActionForward lateFeeDetail(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    
        double pfine=0;
        double maxfine=0;
        double minfine=0;
        
        String degree=(String)request.getParameter("degree");
//        String sem=(String)request.getParameter("semester");
//        String session=request.getParameter("session");
//        String session_sem=request.getParameter("session_sem");
        String last_date=(String)request.getParameter("l_date");
        try{
        pfine=Double.parseDouble((String)request.getParameter("pday_fine"));
        maxfine=Double.parseDouble((String)request.getParameter("max_fine"));
        minfine=Double.parseDouble((String)request.getParameter("min_fine"));
        }catch(Exception e){}
        ArrayList BranchList=new ArrayList();
        JavaBean jb=new JavaBean();   
        SchoolEO seo=new SchoolEO();
        DataObj fun=new DataObj();
        
        seo.setDegree(degree);
//        seo.setSemester(sem);
//        seo.setSession(session);
//        seo.setSession_sem(session_sem);
        seo.setPfine(pfine);
        seo.setMax_fine(maxfine);
        seo.setMin_fine(minfine);
        seo.setLastdate(last_date);
        
        int count=0;
        count=fun.addFine(seo);   
        if(count==0)  
            request.setAttribute("msg","Data Successfully Entered.");
        else
            request.setAttribute("msg","Data is already stored. Please goto Edit Last Date Fee Submission.");
        return mapping.findForward(SUCCESS);        
        }
    
    public ActionForward get_lastdates(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    
//        String degree=(String)request.getParameter("degree");
//        String sem=(String)request.getParameter("semester");
        
        ArrayList fine_detail=new ArrayList();
        JavaBean jb=new JavaBean();   
//        SchoolEO seo=new SchoolEO();
        DataObj fun=new DataObj();
        
//        seo.setDegree(degree);
//        seo.setSemester(sem);
        
        fine_detail=fun.getFine();   
        request.setAttribute("fine",fine_detail);
        return mapping.findForward(SUCCESS);        
        }
    
    public ActionForward del_lastdate(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {           
        ArrayList fine_detail=new ArrayList();
        DataObj fun=new DataObj();
        
        int rwid=0;
        try{
            rwid=Integer.parseInt(request.getParameter("id"));
        }catch(Exception e){}
        fun.del_FineDetails(rwid);
        fine_detail=fun.getFine();   
        request.setAttribute("fine",fine_detail);
        return mapping.findForward(SUCCESS);        
        }
    
    public ActionForward get_lastdate(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    
//        String degree=(String)request.getParameter("degree");
//        String sem=(String)request.getParameter("semester");
//        String session=request.getParameter("session");
//        String session_sem=request.getParameter("ssnm");
        
        ArrayList fine_detail=new ArrayList();
        ArrayList pert_fine=new ArrayList();
        JavaBean jb=new JavaBean();   
        SchoolEO seo=new SchoolEO();
        DataObj fun=new DataObj();
        try
        {
            seo.setRowid(Integer.parseInt(request.getParameter("id")));
        }catch(Exception e){}
        
//        seo.setDegree(degree);
//        seo.setSemester(sem);
//        seo.setSession(session);
//        seo.setSession_sem(session_sem);
        
        pert_fine=fun.getPertFine(seo);
       
//        pert_fine=fun.getFine();
        fine_detail=fun.getFine();   
        request.setAttribute("fine",fine_detail);
        request.setAttribute("pertfine",pert_fine);
        return mapping.findForward(SUCCESS);        
        }
    public ActionForward updateFine(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    
        double pfine=0;
        double maxfine=0;
        double minfine=0;
        int rw=0;
        
//        String degree=(String)request.getParameter("degree");
//        String sem=(String)request.getParameter("semester");
//        String session=request.getParameter("session");
//        String session_sem=request.getParameter("session_sem");
        String last_date=request.getParameter("l_date");
        try{
        pfine=Double.parseDouble(request.getParameter("pday_fine"));
        maxfine=Double.parseDouble(request.getParameter("max_fine"));
        minfine=Double.parseDouble(request.getParameter("min_fine"));
        rw=Integer.parseInt(request.getParameter("id"));
        }catch(Exception e){}
        
        ArrayList fine_detail=new ArrayList();
        ArrayList pert_fine=new ArrayList();
        JavaBean jb=new JavaBean();   
        SchoolEO seo=new SchoolEO();
        DataObj fun=new DataObj();
        
//        seo.setDegree(degree);
//        seo.setSemester(sem);
//        seo.setSession(session);
//        seo.setSession_sem(session_sem);
        seo.setPfine(pfine);
        seo.setMax_fine(maxfine);
        seo.setMin_fine(minfine);
        seo.setLastdate(last_date);
        seo.setRowid(rw);
        
        fun.updatePertFine(seo);
        fine_detail=fun.getFine();   
        request.setAttribute("fine",fine_detail);
        return mapping.findForward(SUCCESS);        
        }
    
    public ActionForward retBranch(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    
        String degree=(String)request.getParameter("degree"); 
        ArrayList BranchList=new ArrayList();
        JavaBean jb=new JavaBean();   
        DataObj fun=new DataObj();
        BranchList=(ArrayList)fun.getBranch(degree);    
        jb.setDegree(degree);
        request.setAttribute("branchlist",BranchList);  
        request.setAttribute("degreebean",jb);
        return mapping.findForward(SUCCESS);        
        
        }
    
    public ActionForward Ra(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    
        String degree=(String)request.getParameter("degree"); 
        ArrayList BranchList=new ArrayList();
        JavaBean jb=new JavaBean();   
        DataObj fun=new DataObj();
        BranchList=(ArrayList)fun.getBranch(degree);    
        jb.setDegree(degree);
        request.setAttribute("branchlist",BranchList);  
        request.setAttribute("degreebean",jb);
        return mapping.findForward(SUCCESS);        
        
        }
    
    public ActionForward rtBran(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    
        String degree=(String)request.getParameter("degree");
        String ses=(String)request.getParameter("session");
        String sno=(String)request.getParameter("srnum");
        ArrayList BranchList=new ArrayList();
        JavaBean jb=new JavaBean();   
        DataObj fun=new DataObj();
        BranchList=(ArrayList)fun.getBranch(degree);    
        jb.setDegree(degree);
        request.setAttribute("branchlist",BranchList);  
        request.setAttribute("degreebean",jb);
        request.setAttribute("obtain",degree);
         request.setAttribute("session",ses);
          request.setAttribute("ser_num",sno);
        return mapping.findForward(SUCCESS);        
        
        }
    
     public ActionForward Rb(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    
        String degree=(String)request.getParameter("degree"); 
        String sess=(String)request.getParameter("session");
        String branch=(String)request.getParameter("branch"); 
        String semester=(String)request.getParameter("semester"); 
         SchoolEO be=new SchoolEO();
         be.setDegree(degree);
        be.setBranch(branch);
        be.setSemester(semester);
      
       
        ArrayList SubList=new ArrayList();
        JavaBean jb=new JavaBean();   
        DataObj fun=new DataObj();
        SubList=(ArrayList)fun.getSubjectList(be);    
        jb.setDegree(degree);
        jb.setBranch(branch);
        jb.setSemester(semester);
        request.setAttribute("sublist",SubList); 
         request.setAttribute("session",sess);
        request.setAttribute("jb",jb);  
       
        return mapping.findForward(SUCCESS);        
        
        }
  
   public ActionForward Rc(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
       PrintWriter out=response.getWriter();
    
        String degree=(String)request.getParameter("degree");
        String sess=(String)request.getParameter("session");
        String stud_type=(String)request.getParameter("stud_type");
        ArrayList BranchList=new ArrayList();
        JavaBean jb=new JavaBean();   
        DataObj fun=new DataObj();
        BranchList=(ArrayList)fun.getBranch(degree);    
        jb.setDegree(degree);
        
          MyMeth fn=new MyMeth();
         ArrayList DegreeList=new ArrayList();
         DegreeList=(ArrayList)fn.Degree_list();
         
         request.setAttribute("degreelist",DegreeList); 
        request.setAttribute("branchlist",BranchList);  
        request.setAttribute("degreebean",jb);
        request.setAttribute("session",sess);
        request.setAttribute("stud_type",stud_type);
        request.setAttribute("select","select");
        return mapping.findForward(SUCCESS);        
        
        }
    
     
     public ActionForward Rd(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    
        String degree=(String)request.getParameter("degree"); 
        String sess=(String)request.getParameter("session");
        ArrayList BranchList=new ArrayList();
        JavaBean jb=new JavaBean();   
        DataObj fun=new DataObj();
        BranchList=(ArrayList)fun.getBranch(degree);    
        jb.setDegree(degree);
        
        MyMeth fn=new MyMeth();
         ArrayList DegreeList=new ArrayList();
         DegreeList=(ArrayList)fn.Degree_list();
         
         request.setAttribute("degreelist",DegreeList); 
        request.setAttribute("branchlist",BranchList);  
        request.setAttribute("degreebean",jb);
         request.setAttribute("session",sess);
        return mapping.findForward(SUCCESS);        
        
        }
    
     
      public ActionForward Re(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    
        String degree=(String)request.getParameter("degree"); 
        String sess=(String)request.getParameter("session");
        ArrayList BranchList=new ArrayList();
        JavaBean jb=new JavaBean();   
        DataObj fun=new DataObj();
        BranchList=(ArrayList)fun.getBranch(degree);    
        jb.setDegree(degree);
        request.setAttribute("branchlist",BranchList);  
        request.setAttribute("degreebean",jb);
         request.setAttribute("session",sess);
        return mapping.findForward(SUCCESS);        
        
        }
    
    public ActionForward ccUpAct(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception{
        int bn=0;
        CcBean cb=new CcBean();
        try{
        cb.setAdminNo(request.getParameter("adminno"));
        cb.setName(request.getParameter("name"));
        cb.setClasses(request.getParameter("classes"));
        cb.setFname(request.getParameter("fname"));
        cb.setFrom(request.getParameter("from"));
        cb.setTo(request.getParameter("to"));
      
        DataObj dob=new DataObj(); 
        bn=dob.upCcData(cb);   
        request.setAttribute("cbean",cb);
        }
        catch(Exception e){bn=1;}
        if(bn==0){
        request.setAttribute("msg","Data Updated");    
        }else{
        request.setAttribute("msg","Data Error");      
        }
        return mapping.findForward(SUCCESS);        
    }
    
        public ActionForward tcUpAct(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        int bn=0;
        TcBean tb=new TcBean();      
        try{
        tb.setAdminNo(request.getParameter("adminno"));
        tb.setName(request.getParameter("name"));       
        tb.setFname(request.getParameter("fname"));
        tb.setDob(request.getParameter("dob"));
        tb.setEntYear(request.getParameter("en_year"));                
        tb.setStudMonth(Integer.parseInt(request.getParameter("stud_year")));
        tb.setStudYear(Integer.parseInt(request.getParameter("stud_month")));
        tb.setLastClass(request.getParameter("last_educ"));   
        tb.setResult(request.getParameter("result"));
        tb.setMigrReason(request.getParameter("migr_reason"));  
        tb.setEnrolNo(request.getParameter("enrolno"));
        
        DataObj dob=new DataObj();        
        bn=dob.upTcData(tb);   
        request.setAttribute("tbean",tb);
        }
        catch(Exception e){bn=1;}
        if(bn==0){
        request.setAttribute("msg","Data Updated");    
        }else{
        request.setAttribute("msg","Data Error");      
        }
        return mapping.findForward(SUCCESS);        
    }
    
        public ActionForward ccEntryAct(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception{
        int bn=0;
        CcBean cb=new CcBean();
        try{
        cb.setAdminNo(request.getParameter("adminno"));
        cb.setName(request.getParameter("name"));
        cb.setClasses(request.getParameter("classes"));
        cb.setFname(request.getParameter("fname"));
        cb.setFrom(request.getParameter("from"));
        cb.setTo(request.getParameter("to"));
      
        DataObj dob=new DataObj(); 
        bn=dob.subCcData(cb);   
        request.setAttribute("cbean",cb);
        }
        catch(Exception e){bn=1;}
        if(bn==0){
        request.setAttribute("msg","Data Submitted");    
        }else{
        request.setAttribute("msg","Data Already Exists or Some Error");      
        }
        return mapping.findForward(SUCCESS);        
    }
    
        public ActionForward tcEntryAct(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        int bn=0;
        TcBean tb=new TcBean();      
        try{
        tb.setAdminNo(request.getParameter("adminno"));
        tb.setName(request.getParameter("name"));       
        tb.setFname(request.getParameter("fname"));
          tb.setMname(request.getParameter("mname"));
        tb.setDob(request.getParameter("dob"));
        tb.setEntYear(request.getParameter("en_year"));                
        tb.setStudMonth(Integer.parseInt(request.getParameter("stud_year")));
        tb.setStudYear(Integer.parseInt(request.getParameter("stud_month")));
        tb.setLastClass(request.getParameter("last_educ"));   
        tb.setResult(request.getParameter("result"));
        tb.setMigrReason(request.getParameter("migr_reason"));  
        tb.setEnrolNo(request.getParameter("enrolno"));
        DataObj dob=new DataObj();        
        bn=dob.subTcData(tb);   
        request.setAttribute("tbean",tb);
        }
        catch(Exception e){bn=1;}
        if(bn==0){
        request.setAttribute("msg","Data Submitted");    
        }else{
        request.setAttribute("msg","Data Already Exists or Some Error");      
        }
        return mapping.findForward(SUCCESS);        
    }
    
        public ActionForward meritAct(ActionMapping mapping,ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception{
        MyMeth mm=new MyMeth();     
        String ssn=request.getParameter("session");
        String classes=request.getParameter("classes");
        String type=request.getParameter("type");  
        String gender=request.getParameter("gender");
            
        SchoolEO seo=new SchoolEO();   
        seo.setSession(ssn);
        seo.setClasses(classes);
        seo.setSeekadd(classes);
        seo.setType(type);      
        seo.setGender(gender);
        
        SchoolEO seo2=(SchoolEO)mm.retFeeHeadData(seo);     
        ArrayList ar=(ArrayList)mm.typeString(seo); 
        seo2.setDataArray(ar);
        request.setAttribute("jbean",seo2);
        return mapping.findForward(SUCCESS);
       }
    
            public ActionForward retFeeAct(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
           
        MyMeth mm=new MyMeth();     
        String ssn=request.getParameter("session");
        String classes=request.getParameter("classes");
        
        String degree=request.getParameter("degree");
       String branch=request.getParameter("branch");
       String duration=request.getParameter("duration");
       String type=request.getParameter("type");  
        String gender=request.getParameter("gender");
            
        SchoolEO seo=new SchoolEO();   
        seo.setSession(ssn);
        seo.setClasses(classes);
        seo.setSeekadd(classes);
        seo.setType(type);      
        seo.setGender(gender);
        
        SchoolEO seo2=(SchoolEO)mm.retFeeHeadData(seo);     
        ArrayList ar=(ArrayList)mm.typeString(seo); 
        seo2.setDataArray(ar);
        request.setAttribute("jbean",seo2);
        return mapping.findForward(SUCCESS);
       }
    
             public ActionForward retFeeCourses(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
           
        MyMeth mm=new MyMeth(); 
        ArrayList BranchList=new ArrayList();
          DataObj fun=new DataObj();
           
        String ssn=request.getParameter("session");
//         String type=request.getParameter("type");  
//        String gender=request.getParameter("gender");
       
        String degree=request.getParameter("degree");
//       String branch=request.getParameter("branch");
//       String duration=request.getParameter("duration");
       
       JavaBean jb=new JavaBean();
        jb.setDegree(degree);
            
        SchoolEO seo=new SchoolEO();   
        seo.setSession(ssn);
       // seo.setClasses(classes);
       // seo.setSeekadd(classes);
//        seo.setType(type);      
//        seo.setGender(gender);
        seo.setDegree(degree);
//        seo.setBranch(branch);
//        seo.setDuration(duration);
        
        SchoolEO seo2=(SchoolEO)mm.retCourseFeeHeadData(seo);     
        ArrayList ar=(ArrayList)mm.typeString(seo); 
        seo2.setDataArray(ar);
//        BranchList=(ArrayList)fun.getBranch(degree);
        request.setAttribute("jbean",seo2);
//        request.setAttribute("branchlist",BranchList);
         request.setAttribute("degreebean",jb);
//         request.setAttribute("branch",branch);
//         request.setAttribute("duration",duration);
         
         ArrayList DegreeList=new ArrayList();
         DegreeList=(ArrayList)mm.Degree_list();
        
         request.setAttribute("degreelist",DegreeList);  
        return mapping.findForward(SUCCESS);
       }
    
            
            
            public ActionForward subClassType(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
      
        MyMeth mm=new MyMeth();     
        String classes=request.getParameter("classes");
        String type=request.getParameter("type");                          
        SchoolEO seo=new SchoolEO();                        
        seo.setClasses(classes);
        seo.setType(type);
                
        int bn=mm.subClassTypeData(seo);   
        if(bn==0){
        request.setAttribute("msg","Data Submitted");
        }else{
        request.setAttribute("msg","Data Already Exists");   
        }           
        request.setAttribute("jbean",seo);
        return mapping.findForward(SUCCESS);
       }
    
            public ActionForward subClassFee(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
            MyMeth mm=new MyMeth();
            String session=request.getParameter("session");
            String classes=request.getParameter("duration");
            String type=request.getParameter("type");
            String gender=request.getParameter("gender");        
            String degree=request.getParameter("degree");
            String branch=request.getParameter("branch");
            String duration=request.getParameter("duration");
       
        
        
        
        SchoolEO seo=new SchoolEO();                        
        seo.setSession(session);
        seo.setSeekadd(classes);
        seo.setType(type);
        seo.setGender(gender);
        seo.setDegree(degree);
        seo.setBranch(branch);
        seo.setDuration(duration);
        ArrayList ar1=new ArrayList();
        ArrayList ar2=new ArrayList();
        HashMap hm1=new HashMap();
          
        Enumeration en=(Enumeration)request.getParameterNames();
        String param="";
        while(en.hasMoreElements()){
        param=(String)en.nextElement(); 
        try{
        if(param.substring(0,2).equals("hd")){
        ar1.add(param);
        }    
        }catch(StringIndexOutOfBoundsException e){}
        }
       
        for(int i=0;i<ar1.size();i++){
        ar2.add(request.getParameter("hd_"+i));
        hm1.put(request.getParameter("hd_"+i),request.getParameter("fe_"+i));
        }        
        int bn=mm.subFeeData(seo,ar2,hm1);   
        ArrayList ar=(ArrayList)mm.typeString(seo);   
        seo.setDataArray(ar);
        if(bn==0){
        request.setAttribute("msg","Data Submitted");
        }else if(bn==-1){
            request.setAttribute("msg","Failed. Please try again later.");   
        }  
        else{
            request.setAttribute("msg","Data Already Exists");   
        }
        request.setAttribute("jbean",seo);
        return mapping.findForward(SUCCESS);
       } 
            
            public ActionForward editClassFee(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
      
                PrintWriter out=response.getWriter();
        MyMeth mm=new MyMeth();
        String session=request.getParameter("session");
        //String classes=request.getParameter("classes");
//        String classes=request.getParameter("duration");
//        String type=request.getParameter("type");
//        String gender=request.getParameter("gender");
         String degree=request.getParameter("degree");
//       String branch=request.getParameter("branch");
       
     
                          
        SchoolEO seo=new SchoolEO();                        
        seo.setSession(session);
//        seo.setClasses(classes);
//        seo.setSeekadd(classes);
//        seo.setType(type);
//        seo.setGender(gender);
        seo.setDegree(degree);
//        seo.setBranch(branch);
        
//          out.println(seo.getSession()+seo.getClasses()+seo.getBranch());
        
        ArrayList ar1=new ArrayList();
        ArrayList ar2=new ArrayList();
        HashMap hm1=new HashMap();
          
        Enumeration en=(Enumeration)request.getParameterNames();
        String param="";
        while(en.hasMoreElements()){
        param=(String)en.nextElement(); 
        try{
        if(param.substring(0,2).equals("hd")){
        ar1.add(param);
        }    
        }catch(StringIndexOutOfBoundsException e){}
        }
       
        for(int i=0;i<ar1.size();i++){
        ar2.add(request.getParameter("hd_"+i));
        hm1.put(request.getParameter("hd_"+i),request.getParameter("fe_"+i));
        }        
        int bn=mm.editFeeData(seo,ar2,hm1);  
        
        SchoolEO seo2=(SchoolEO)mm.retFeeHeadData(seo);     
        ArrayList ar=(ArrayList)mm.typeString(seo); 
        seo2.setDataArray(ar);
        
        if(bn==0){
        request.setAttribute("msg","Data Updated");
        }else{
        request.setAttribute("msg","Data Error");   
        }  
        ArrayList DegreeList=new ArrayList();
         DegreeList=(ArrayList)mm.Degree_list();
        
JavaBean jb=new JavaBean();
        jb.setDegree(degree);
request.setAttribute("degreebean",jb); 
         request.setAttribute("degreelist",DegreeList);  
        request.setAttribute("jbean",seo2);
       return mapping.findForward(SUCCESS);
         //return mapping.findForward("");
       }        
            
        public ActionForward typeAction3(ActionMapping mapping,ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception{
  
        SchoolEO seo=new SchoolEO();        
        
        String srnum=request.getParameter("srnum");
        String session=request.getParameter("session");
        String cls=request.getParameter("seekadd");
        String sname=request.getParameter("sname");
        String gend=request.getParameter("gender");
        
        seo.setSrnum(srnum);
        seo.setSession(session);
        seo.setSeekadd(cls);
        seo.setSname(sname);
        seo.setGender(gend);
        
        MyMeth mm=new MyMeth();             
        ArrayList ar=(ArrayList)mm.subList(seo);   
        seo.setDataArray(ar);
        
        request.setAttribute("jbean",seo);
        return mapping.findForward(SUCCESS);
        }     
    
        public ActionForward typeAction2(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{

        SchoolEO seo=new SchoolEO();
        MyMeth mm=new MyMeth();
        
        String session=request.getParameter("session");
        String classes=request.getParameter("classes");
                  
        seo.setSession(session);
        seo.setSeekadd(classes);
                     
        ArrayList ar=(ArrayList)mm.typeString(seo);   
        seo.setDataArray(ar);
        
        request.setAttribute("jbean",seo);
        return mapping.findForward(SUCCESS);
       }
        
        public ActionForward typeAction(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
     
        SchoolEO seo=new SchoolEO();
        MyMeth mm=new MyMeth();
        String sesn=request.getParameter("session");
        String Syear=request.getParameter("Syear");
        String Eyear=request.getParameter("Eyear");
        String sesdate=request.getParameter("sesdate");
        String srnum=request.getParameter("srnum");
        String sname=request.getParameter("sname");
        String gender=request.getParameter("gender");
        String mname=request.getParameter("mname");
        String fname=request.getParameter("fname");
        String category=request.getParameter("category");
        String ye_regis=request.getParameter("year_regist");
        String class_regis=request.getParameter("class_regist");
        String standard=request.getParameter("standard");
        String cls=request.getParameter("seekadd");    
               
        seo.setSession(sesn);
        seo.setSyear(Syear);
        seo.setEyear(Eyear);
        seo.setSesDate(sesdate);
        seo.setSrnum(srnum);
        seo.setSname(sname);
        seo.setGender(gender);
        seo.setMname(mname);
        seo.setFname(fname);
        seo.setCategory(category);
        seo.setYearRegist(ye_regis);
        seo.setClassRegist(class_regis);
        seo.setStandard(standard);
        seo.setSeekadd(cls);
                   
        ArrayList ar=(ArrayList)mm.subList(seo);   
        seo.setDataArray(ar);
        
        request.setAttribute("jbean",seo);
        return mapping.findForward("success");
      }
        
            public ActionForward typeUpAction(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
  
        SchoolEO seo=new SchoolEO();
        MyMeth mm=new MyMeth();
        String Syear=request.getParameter("Syear");
        String Eyear=request.getParameter("Eyear");
        String sesdate=request.getParameter("sesdate");
        
          seo.setSession(request.getParameter("session"));    
          seo.setSrnum(request.getParameter("srnum"));
          seo.setSeekadd(request.getParameter("seekadd")); 
          seo.setSname(request.getParameter("sname"));
          seo.setGender(request.getParameter("gender"));
          seo.setFname(request.getParameter("fname"));
          seo.setYearRegist(request.getParameter("year_regist"));
          seo.setClassRegist(request.getParameter("class_regist"));          
          seo.setStandard(request.getParameter("standard"));
          seo.setType(request.getParameter("type"));
          seo.setCategory(request.getParameter("category"));             
          seo.setDob(request.getParameter("dob"));          
          seo.setNationality(request.getParameter("nationality"));
          seo.setMname(request.getParameter("mname"));
          seo.setAddress(request.getParameter("padd"));
          seo.setRnum(request.getParameter("pnum"));
          seo.setMobile(request.getParameter("pmobile"));  
          seo.setAdminType(request.getParameter("admin_type"));          
                    
        seo.setSyear(Syear);
        seo.setEyear(Eyear);
        seo.setSesDate(sesdate);
                        
        ArrayList ar=(ArrayList)mm.typeString(seo);   
        seo.setDataArray(ar);
        
        request.setAttribute("arr",seo);
        return mapping.findForward(SUCCESS);
      }
    
       public ActionForward studName(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
  
        JavaBean jb=new JavaBean();
        DataObj dt=new DataObj();
        int syr=Integer.parseInt(request.getParameter("syear").toString());
        int eyr=Integer.parseInt(request.getParameter("eyear").toString());
        String month=(String)request.getParameter("months");
        String clas=(String)request.getParameter("classes");
        jb.setFrom(syr);
        jb.setTo(eyr);
        jb.setMonth(month);
        jb.setClas(clas);
        ArrayList ar=(ArrayList)dt.studentName(jb);          
        request.setAttribute("arr",ar);   
        request.setAttribute("jbean",jb);         
        return mapping.findForward(SUCCESS);
     }
    
          public ActionForward deleteClassAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    
        String pr=(String)request.getParameter("para"); 
        DataObj dob=new DataObj();        
        boolean bn=dob.deleteClassData(pr); 
        if(bn==true){
        request.setAttribute("msg","Deleted");
        }
        return mapping.findForward(SUCCESS);        
        }
    
          
          public ActionForward deleteBranchAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    
        String pr=(String)request.getParameter("para"); 
        DataObj dob=new DataObj();        
        boolean bn=dob.deleteBranchData(pr); 
        if(bn==true){
        request.setAttribute("msg","Deleted");
        }
        return mapping.findForward(SUCCESS);        
        }
    
          
          
            public ActionForward delSchedAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
       
        int frm=Integer.parseInt(request.getParameter("from").toString()); 
        int to=Integer.parseInt(request.getParameter("to").toString()); 
        String etype=request.getParameter("extype").toString(); 
        String clas=request.getParameter("class").toString(); 
        String pr=request.getParameter("para").toString();    
        DataObj dob=new DataObj();        
        boolean bn=dob.delSchedData(pr); 
        if(bn==true){
        request.setAttribute("msg","Deleted");
        }
        return mapping.findForward(SUCCESS);        
        }
        
         public ActionForward displayHolidayAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        JavaBean jb=new JavaBean();

        ArrayList ar=new ArrayList();        
        String yr=request.getParameter("years").toString();
        DataObj dob=new DataObj();        
        ar=(ArrayList)dob.displayHolidayData(yr); 
        request.setAttribute("year",yr);
        request.setAttribute("arr",ar);
        return mapping.findForward(SUCCESS);        
    }
        
       public ActionForward holidayAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        JavaBean jb=new JavaBean();

        String dt=request.getParameter("dated").toString();
        String hd=request.getParameter("holiday").toString();
        jb.setDated(dt);
        jb.setHoliday(hd);
        DataObj dob=new DataObj();        
        boolean bn=dob.holidayData(jb);   
        request.setAttribute("jbean",jb);
        if(bn==true){
        request.setAttribute("msg","Data Submitted");    
        }
        return mapping.findForward(SUCCESS);        
    }
     public ActionForward report1(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
  
       ArrayList ar=new ArrayList();          
       String dat1=(String)request.getParameter("dated1");
       String dat2=(String)request.getParameter("dated2");       
       DataObj dt=new DataObj();
       ar=(ArrayList)dt.expenses(dat1,dat2);            
       request.setAttribute("arr",ar);
       request.setAttribute("from_to",dat1+"-"+dat2);
       return mapping.findForward(SUCCESS);
    }
        ///////////////////////////////////////////////////////////////////////////////////////////  
       public ActionForward updateAllExp1(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
    
        JavaBean jb=new JavaBean();
        DataObj dt=new DataObj();
        ArrayList ar=(ArrayList)dt.allExpUpdate1();
        request.setAttribute("arr",ar);
        return mapping.findForward(SUCCESS);
    }
       public ActionForward updateAllExp2(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
  
        JavaBean jb=new JavaBean();
        DataObj dt=new DataObj();
        String id=request.getParameter("pr");
        ArrayList ar=(ArrayList)dt.allExpUpdate2(id);        
        request.setAttribute("arr",ar);              
        return mapping.findForward(SUCCESS);
    }
       public ActionForward updateAllExp3(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        DynaActionForm dynaform=(DynaActionForm)form;
 
        String id1=(String)request.getParameter("pr");
        String dat=(String)request.getParameter("dated");
        String det=(String)request.getParameter("detail");
        double amt=Double.parseDouble(request.getParameter("amount").toString());
        String ename=(String)request.getParameter("ename");    
        String recptno=(String)request.getParameter("recptno");
        String paymode=(String)request.getParameter("paymode");
        String chqno="";
        if(request.getParameter("chequeno")!=null && !request.getParameter("chequeno").toString().equals("NOT REQUIRED")){
        chqno=(String)request.getParameter("chequeno");
        }
        else{
        chqno="NOT REQUIRED";   
        }
        JavaBean jb=new JavaBean();
        jb.setId(id1);
        jb.setDated(dat);
        jb.setDetails(det);
        jb.setAmount(amt);
        jb.setEmpname(ename);    
        jb.setRecptno(recptno);
        jb.setPaymode(paymode);
        jb.setChequeno(chqno);
        DataObj dt=new DataObj();
        boolean b=dt.allExpUpdate3(jb);  
        ArrayList ar=(ArrayList)dt.allExpUpdate1();
        request.setAttribute("arr",ar);
        if(b==true){
        request.setAttribute("msg","Data Updated");
        }
        return mapping.findForward("success");
         }    
      ///////////////////////////////////////////////////////////////////////////////////////////  
      public ActionForward enterAllExpenses(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        DynaActionForm dynaform=(DynaActionForm)form;

        String dat=(String)request.getParameter("dated");
        String det=dynaform.get("details").toString();      
        double amt=Double.parseDouble(dynaform.get("amount").toString());       
        String empn=dynaform.get("empname").toString();
        String recptno=dynaform.getString("recptno");
        String paymode=dynaform.getString("paymode");
        String chqno="";        
        if(request.getParameter("chequeno")!=null){
        chqno=(String)request.getParameter("chequeno");
        }
        else{
        chqno="NOT REQUIRED";    
        }       
        JavaBean jb=new JavaBean(); 
        jb.setDated(dat);
        jb.setDetails(det);
        jb.setAmount(amt);
        jb.setEmpname(empn); 
        jb.setRecptno(recptno);
        jb.setPaymode(paymode);
        jb.setChequeno(chqno);
        DataObj dt=new DataObj();
        boolean b=dt.allExpense(jb);
        if(b==true){
        request.setAttribute("msg","Data Submitted");
        }
        return mapping.findForward(SUCCESS);
        }
    public ActionForward scheduleExam(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        JavaBean jb=new JavaBean();
 
        DynaActionForm dynaform=(DynaActionForm)form;
        jb.setFrom(Integer.parseInt(dynaform.get("from").toString()));
        jb.setTo(Integer.parseInt(dynaform.get("to").toString()));
        jb.setExtype(dynaform.get("extype").toString());
        jb.setClas(dynaform.get("class").toString());
        jb.setSub(dynaform.get("sub").toString());
        jb.setDate(request.getParameter("dated").toString());
        String hour=request.getParameter("hour").toString();
        String min=request.getParameter("min").toString();
        String ap=request.getParameter("ampm").toString();
        jb.setTime(hour+":"+min+":"+ap);  
        DataObj dob=new DataObj();        
        boolean bn=dob.schedExam(jb);   
        request.setAttribute("jbean",jb);
        if(bn==true){
        request.setAttribute("msg","Data Submitted");    
        }
        return mapping.findForward(SUCCESS);
        
    }
    
//         public ActionForward deleteClassAction(ActionMapping mapping, ActionForm form,
//            HttpServletRequest request, HttpServletResponse response)
//            throws Exception {
//        JavaBean jb=new JavaBean();
//        PrintWriter out=response.getWriter();
//        DynaActionForm dynaform=(DynaActionForm)form;
//        jb.setClas(dynaform.get("class").toString());
//        DataObject dob=new DataObject();        
//        boolean bn=dob.classData(jb);   
//        request.setAttribute("jbean",jb);
//        if(bn==true){
//        request.setAttribute("msg","Data Submitted");    
//        }
//        return mapping.findForward(SUCCESS);        
//    }
    
       public ActionForward classAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        String str="";  
        int c=0;
        JavaBean jb=new JavaBean();
         ArrayList DegreeList=new ArrayList();
        DynaActionForm dynaform=(DynaActionForm)form;
        jb.setClas(dynaform.get("class").toString());    
        jb.setStream(dynaform.get("stream").toString());
        DataObj dob=new DataObj();  
        try{
        c=dob.checkClassData(jb);
        }
        catch(NullPointerException ne){}
        MyMeth fun=new MyMeth();
         DegreeList=(ArrayList)fun.Degree_list();
        
         request.setAttribute("degreelist",DegreeList);  
        
        if(c==0){
        boolean bn=dob.classData(jb);   
        request.setAttribute("jbean",jb);
        if(bn==true){
        request.setAttribute("msg","Data Submitted");    
        }
        str="success";
        }
        else{
         request.setAttribute("msg","Class Already Exists");    
         str="failure";    
        }
        return mapping.findForward(str);        
    }
        
       
        public ActionForward branchAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
            PrintWriter out=response.getWriter();
        String str="";  
        int c=0;
        JavaBean jb=new JavaBean();
        ArrayList DegreeList=new ArrayList();
 MyMeth fun=new MyMeth();
        DynaActionForm dynaform=(DynaActionForm)form;
        jb.setClas(dynaform.get("degree").toString());    
        jb.setStream(dynaform.get("branch").toString());
        jb.setDuration(dynaform.get("duration").toString());
        DataObj dob=new DataObj();  
        try{
        c=dob.checkBranchData(jb);
        }
        catch(NullPointerException ne){}
        if(c==0){
            //out.println(jb.getClas());
        boolean bn=dob.branchData(jb);   
        request.setAttribute("jbean",jb);
        if(bn==true){
        request.setAttribute("msg","Data Submitted");    
        }
        str="success";
 //str="";   
        }
        else{
         request.setAttribute("msg","Class Already Exists");    
         str="failure";    
        }
        
       DegreeList=(ArrayList)fun.Degree_list();
        request.setAttribute("degreelist",DegreeList);  
        return mapping.findForward(str);        
    }
        
      
       
   public ActionForward sectionAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        JavaBean jb=new JavaBean();

        int frm=0;
        int to=0;
        String cls="";
        ArrayList ar1=new ArrayList();
        ArrayList ar2=new ArrayList();
        ArrayList ar3=new ArrayList();
        ArrayList ar4=new ArrayList();
        try{
        frm=Integer.parseInt(request.getParameter("from").toString());
        to=Integer.parseInt(request.getParameter("to").toString());
        }
        catch(NullPointerException np){}
        catch(NumberFormatException ne){}
        cls=request.getParameter("class").toString();       
        Enumeration enu=request.getParameterNames();
        while(enu.hasMoreElements()){
         String param=(String)enu.nextElement();  
         try{
         if(param.substring(0,3).equals("stu")){
           ar1.add(param);    
         }
          if(param.substring(0,3).equals("sec")){
           ar2.add(param);  
         } 
         }
         catch(StringIndexOutOfBoundsException soe){}
        }
        for(int i=0;i<ar1.size();i++){
        ar3.add(request.getParameter("stu"+i));    
        }
         for(int j=0;j<ar2.size();j++){
         ar4.add(request.getParameter("sec"+j));    
        }
        jb.setFrom(frm);
        jb.setTo(to);
        jb.setClas(cls);        
        DataObj dob=new DataObj();        
        boolean bn=dob.sectionData(jb,ar3,ar4);   
        if(bn==true){
        request.setAttribute("msg","Data Submitted");    
        }
        return mapping.findForward(SUCCESS);        
    }
             
        public ActionForward dailyAttendence(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        JavaBean jb=new JavaBean();

        int frm=0;
        int to=0;
        String cls="";
        String sec="";
        String dat="";
        ArrayList ar1=new ArrayList();
        ArrayList ar2=new ArrayList();
        ArrayList ar3=new ArrayList();
        ArrayList ar4=new ArrayList();       
        try{
        frm=Integer.parseInt(request.getParameter("from").toString());
        to=Integer.parseInt(request.getParameter("to").toString());
        }
        catch(NumberFormatException ne){}
        cls=request.getParameter("class").toString();    
        sec=request.getParameter("section").toString(); 
        dat=request.getParameter("dated").toString();       
         jb.setFrom(frm);
         jb.setTo(to);
         jb.setClas(cls);   
         jb.setSection(sec);
         jb.setDate(dat);
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
        DataObj dob=new DataObj();        
        boolean bn=dob.dailyAttendData(jb,ar3,ar4);   
        if(bn==true){
        request.setAttribute("msg","Data Submitted");    
        }
        return mapping.findForward(SUCCESS);        
    }
          public ActionForward subject(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        boolean bn=false;
        JavaBean jb=new JavaBean();
    
        try{
        jb.setFrom(Integer.parseInt(request.getParameter("from").toString()));
        jb.setTo(Integer.parseInt(request.getParameter("to").toString()));
        jb.setClas(request.getParameter("class").toString());
        jb.setSub(request.getParameter("sub").toString());            
        DataObj dob=new DataObj();        
        bn=dob.subjectData(jb);   
        request.setAttribute("jbean",jb);
        }
        catch(NullPointerException ne){}
        if(bn==true){
        request.setAttribute("msg","Data Submitted");    
        }
        return mapping.findForward(SUCCESS);        
    }    
          
        public ActionForward entMarks(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        boolean bn=false;
        JavaBean jb=new JavaBean();   
        try{
        jb.setFrom(Integer.parseInt(request.getParameter("from").toString()));
        jb.setTo(Integer.parseInt(request.getParameter("to").toString()));
        jb.setClas(request.getParameter("class").toString());
        jb.setSub(request.getParameter("sub").toString());  
        jb.setExtype(request.getParameter("extype").toString());
  
        String sname[]=(String[])request.getParameterValues("studname");
        String marks[]=(String[])request.getParameterValues("marks");     
      
        DataObj dob=new DataObj();        
        bn=dob.studMarksData(jb,sname,marks);   
        request.setAttribute("jbean",jb);
        }
        catch(NullPointerException ne){}
        if(bn==true){
        request.setAttribute("msg","Data Submitted");    
        }
        return mapping.findForward(SUCCESS);        
    }
        
        public ActionForward retByData(ActionMapping mapping,ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception{
           
        MyMeth mm=new MyMeth();     
        String ssn=request.getParameter("session");
        String cls=request.getParameter("cls");
        String by=request.getParameter("by");  
            
        SchoolEO seo=new SchoolEO();   
        seo.setSession(ssn);
        seo.setClasses(cls);
        seo.setBy(by);
        
        ArrayList ar=(ArrayList)mm.studData(seo); 
        seo.setDataArray(ar);
        request.setAttribute("jbean",seo);
        return mapping.findForward(SUCCESS);
       }
        
        public ActionForward studListAct(ActionMapping mapping,ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception{
         
        MyMeth mm=new MyMeth();     
        String ssn=request.getParameter("session");
        String cls=request.getParameter("cls");
        String by=request.getParameter("by");  
        String dby=request.getParameter("databy");            
        SchoolEO seo=new SchoolEO();   
        seo.setSession(ssn);
        seo.setClasses(cls);
        seo.setBy(by);
        seo.setDataBy(dby);
        ArrayList ar=(ArrayList)mm.studData(seo); 
        seo.setDataArray(ar);
        ArrayList ar2=(ArrayList)mm.studListData3(seo); 
        seo.setDataArray2(ar2);
        request.setAttribute("jbean",seo);
        return mapping.findForward(SUCCESS);
        }  
        
        public ActionForward studListAct2(ActionMapping mapping,ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception{           
        MyMeth mm=new MyMeth(); 
        SchoolEO seo=new SchoolEO();         
        String cls=request.getParameter("classes");
        String ssn=request.getParameter("session");        
        seo.setClasses(cls);
        seo.setSession(ssn);           
        ArrayList ar=(ArrayList)mm.studList(seo);         
        seo.setDataArray(ar);
        request.setAttribute("jbean",seo);
        return mapping.findForward(SUCCESS);
        }
        
  public ActionForward bankAct(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception{
      ArrayList al=new ArrayList();
        int bn=0;
        SchoolEO seo=new SchoolEO();
        DataObj dob=new DataObj(); 
        try{
            if(request.getParameter("bnk")!=null){
        seo.setBankname(request.getParameter("bnk"));
        
      
        
        dob.enterBankName(seo);   
        request.setAttribute("msg","Data Submitted"); 
            }
            al=dob.retBankName();
             request.setAttribute("list",al); 
        }
        catch(Exception e){bn=1;}
        
        return mapping.findForward(SUCCESS);        
    }
  
  public ActionForward delbn(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception{
      ArrayList al=new ArrayList();
        int id=0;
        SchoolEO seo=new SchoolEO();
        DataObj dob=new DataObj(); 
        try{
            if(request.getParameter("id")!=null){
                id=Integer.parseInt(request.getParameter("id").toString());
        
      
        
        dob.deleteRowFromDynTable(id,"bank");   
        }
            al=dob.retBankName();
             request.setAttribute("list",al); 
        }
        catch(Exception e){}
        
        return mapping.findForward(SUCCESS);        
    }      
  
  public ActionForward programme_fee(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception{
      ArrayList al=new ArrayList();
      ArrayList degreelist=new ArrayList();
        SchoolEO seo=new SchoolEO();
        DataObj dob=new DataObj(); 
        try{
            if(request.getParameter("submit")!=null){
                seo.setBatch(request.getParameter("batch"));
                seo.setDegree(request.getParameter("degree"));
                seo.setPamount(Double.parseDouble(request.getParameter("amount")));
                int cn=dob.checkProgrammeFee(seo);
                if(cn==0){
                    dob.enterProgrammeFee(seo);   
                    request.setAttribute("msg","Data Submitted"); 
                }
                else
                    request.setAttribute("msg","data is already present for batch "+seo.getBatch()+" and degree "+seo.getDegree()); 
            }
            al=dob.retProgrammeFee();
            degreelist=dob.getFinancialDegree();
             request.setAttribute("list",al); 
             request.setAttribute("degreelist",degreelist); 
        }
        catch(Exception e){}
        
        return mapping.findForward(SUCCESS);        
    }
  
  public ActionForward delProgFee(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception{
      ArrayList al=new ArrayList();
      ArrayList degreelist=new ArrayList();
        int id=0;
        SchoolEO seo=new SchoolEO();
        DataObj dob=new DataObj(); 
        try{
            if(request.getParameter("id")!=null){
                id=Integer.parseInt(request.getParameter("id").toString());
        
      
        
        dob.deleteRowFromDynTable(id,"finan_programme");   
        }
            al=dob.retProgrammeFee();
            degreelist=dob.getDegree();
             request.setAttribute("list",al); 
             request.setAttribute("degreelist",degreelist);  
        }
        catch(Exception e){}
        
        return mapping.findForward(SUCCESS);        
    }      
  
}