package ActionClassAttend;

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
/**
 *
 * @author kanchan
 */
public class MyActionsAttend extends DispatchAction {
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "success"; 
    
       public ActionForward studName(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        PrintWriter out=response.getWriter();
        JavaBean jb=new JavaBean();
        DataObjectAttend dt=new DataObjectAttend();
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
            PrintWriter out=response.getWriter();   
        String pr=(String)request.getParameter("para"); 
        DataObjectAttend dob=new DataObjectAttend();        
        boolean bn=dob.deleteClassData(pr); 
        if(bn==true){
        request.setAttribute("msg","Deleted");
        }
        return mapping.findForward(SUCCESS);        
        }
    
            public ActionForward delSchedAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
            PrintWriter out=response.getWriter();   
        int frm=Integer.parseInt(request.getParameter("from").toString()); 
        int to=Integer.parseInt(request.getParameter("to").toString()); 
        String etype=request.getParameter("extype").toString(); 
        String clas=request.getParameter("class").toString(); 
        String pr=request.getParameter("para").toString();    
        DataObjectAttend dob=new DataObjectAttend();        
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
        PrintWriter out=response.getWriter();
        ArrayList ar=new ArrayList();        
        String yr=request.getParameter("years").toString();
        DataObjectAttend dob=new DataObjectAttend();        
        ar=(ArrayList)dob.displayHolidayData(yr); 
        request.setAttribute("year",yr);
        request.setAttribute("arr",ar);
        return mapping.findForward(SUCCESS);        
    }
        
       public ActionForward holidayAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        JavaBean jb=new JavaBean();
        PrintWriter out=response.getWriter();
        String dt=request.getParameter("dated").toString();
        String hd=request.getParameter("holiday").toString();
        jb.setDated(dt);
        jb.setHoliday(hd);
        DataObjectAttend dob=new DataObjectAttend();        
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
       PrintWriter out=response.getWriter();
       ArrayList ar=new ArrayList();          
       String dat1=(String)request.getParameter("dated1");
       String dat2=(String)request.getParameter("dated2");       
       DataObjectAttend dt=new DataObjectAttend();
       ar=(ArrayList)dt.expenses(dat1,dat2);            
       request.setAttribute("arr",ar);
       request.setAttribute("from_to",dat1+"-"+dat2);
       return mapping.findForward(SUCCESS);
    }
        ///////////////////////////////////////////////////////////////////////////////////////////  
       public ActionForward updateAllExp1(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        PrintWriter out=response.getWriter();
        JavaBean jb=new JavaBean();
        DataObjectAttend dt=new DataObjectAttend();
        ArrayList ar=(ArrayList)dt.allExpUpdate1();
        request.setAttribute("arr",ar);
        return mapping.findForward(SUCCESS);
    }
       public ActionForward updateAllExp2(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        PrintWriter out=response.getWriter();
        JavaBean jb=new JavaBean();
        DataObjectAttend dt=new DataObjectAttend();
        String id=request.getParameter("pr");
        ArrayList ar=(ArrayList)dt.allExpUpdate2(id);        
        request.setAttribute("arr",ar);              
        return mapping.findForward(SUCCESS);
    }
       public ActionForward updateAllExp3(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        DynaActionForm dynaform=(DynaActionForm)form;
        PrintWriter out=response.getWriter();
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
        DataObjectAttend dt=new DataObjectAttend();
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
        PrintWriter out=response.getWriter();
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
        DataObjectAttend dt=new DataObjectAttend();
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
        PrintWriter out=response.getWriter();
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
        DataObjectAttend dob=new DataObjectAttend();        
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
//        DataObjectAttend dob=new DataObjectAttend();        
//        boolean bn=dob.classData(jb);   
//        request.setAttribute("jbean",jb);
//        if(bn==true){
//        request.setAttribute("msg","Data Submitted");    
//        }
//        return mapping.findForward(SUCCESS);        
//    }
    
        public ActionForward classAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String str="";  
        int c=0;
        JavaBean jb=new JavaBean();
        PrintWriter out=response.getWriter();
        DynaActionForm dynaform=(DynaActionForm)form;
        jb.setClas(dynaform.get("class").toString());
        DataObjectAttend dob=new DataObjectAttend();  
        try{
        c=dob.checkClassData(jb);
        }
        catch(NullPointerException ne){out.print(ne.getMessage());}
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
        
             public ActionForward sectionAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        JavaBean jb=new JavaBean();
        PrintWriter out=response.getWriter();
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
        DataObjectAttend dob=new DataObjectAttend();        
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
        PrintWriter out=response.getWriter();
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
        DataObjectAttend dob=new DataObjectAttend();        
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
        PrintWriter out=response.getWriter();
        try{
        jb.setFrom(Integer.parseInt(request.getParameter("from").toString()));
        jb.setTo(Integer.parseInt(request.getParameter("to").toString()));
        jb.setClas(request.getParameter("class").toString());
        jb.setSub(request.getParameter("sub").toString());            
        DataObjectAttend dob=new DataObjectAttend();        
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
        PrintWriter out=response.getWriter();
        try{
        jb.setFrom(Integer.parseInt(request.getParameter("from").toString()));
        jb.setTo(Integer.parseInt(request.getParameter("to").toString()));
        jb.setClas(request.getParameter("class").toString());
        jb.setSub(request.getParameter("sub").toString());  
        jb.setExtype(request.getParameter("extype").toString());
  
        String sname[]=(String[])request.getParameterValues("studname");
        String marks[]=(String[])request.getParameterValues("marks");     
      
        DataObjectAttend dob=new DataObjectAttend();        
        bn=dob.studMarksData(jb,sname,marks);   
        request.setAttribute("jbean",jb);
        }
        catch(NullPointerException ne){}
        if(bn==true){
        request.setAttribute("msg","Data Submitted");    
        }
        return mapping.findForward(SUCCESS);        
    }
        
                
}