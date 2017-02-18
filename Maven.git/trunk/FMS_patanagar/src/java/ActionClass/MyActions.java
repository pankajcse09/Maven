package ActionClass;

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
import User_Role.UserRoleDB;
/**
 *
 * @author kanchan
 */
public class MyActions extends DispatchAction{
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "success"; 
    
       public ActionForward logout(ActionMapping mapping, ActionForm form,
       HttpServletRequest request, HttpServletResponse response)
       throws Exception {
        HttpSession session=request.getSession();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        session.removeAttribute("loginid");
        session.removeAttribute("password");
        session.removeAttribute("userrole");
        session.removeAttribute("user_auth");
        session.removeAttribute("name");
        session.invalidate();             
        return mapping.findForward(SUCCESS);    
       }
   
         public ActionForward authenticate(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int bn=0;
        HttpSession session=(HttpSession)request.getSession();
        //session.setMaxInactiveInterval(30);
        JavaBean1 jb=new JavaBean1();
        PrintWriter out=response.getWriter();  
        String mp="";
        String role="";
        String loginid=(String)request.getParameter("loginid");
        String passwd=(String)request.getParameter("password");             
        jb.setLoginid(loginid);
        jb.setPassword(passwd);     
        LoginDataObject dob=new LoginDataObject();   
        try{
        bn=dob.authenticateData(jb);          
        }catch(Exception e){}
        request.setAttribute("jbean",jb);          
             if(bn==1){          
                 UserRoleDB urd=new UserRoleDB();
             role=dob.userRole(jb);   
             jb=dob.eDetailFromUsername(loginid);
             int adminregis =jb.getAdminregis();
             session.setAttribute("loginid",loginid);
                session.setAttribute("password",passwd);
                session.setAttribute("userrole", role);
                session.setAttribute("user_auth", urd.selUserRoleAuth(role));
                session.setAttribute("name", jb.getName());
                session.setAttribute("loginfor", jb.getLoginFor());
if(jb.getLoginFor().equals("hostel")){
    String hostel_name=dob.retHostelNameForHostelLogin(jb.getLoginForName());
    session.setAttribute("hostel_name", hostel_name);
    session.setAttribute("hostel_code", jb.getLoginForName());
    if(adminregis==1)
             {
                mp="HostelPasswordChange";
             }
             else
             {
                mp="HostelMainPage";  
             }
}
else{
             if(adminregis==1)
             {
                mp="success2";
             }
             else
             {
                mp="success1";  
             }
}

//            if(role.equals("feeadmin")){mp="success1";}
//            else{
//             request.setAttribute("msg","enter the correct Username and Password");    
//             mp="failure";
//             }           
             }else{
             mp="failure";
             request.setAttribute("msg","enter the correct Username and Password");                  
             } 
    
        return mapping.findForward(mp); 
    }
   
        public ActionForward registUserAction1(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int bn=0;
   
        JBeanEmp jb=new JBeanEmp();
        PrintWriter out=response.getWriter();
        String empid=(String)request.getParameter("empid");        
        String loginid=(String)request.getParameter("loginid");        
        String passw=(String)request.getParameter("password");
        String question=(String)request.getParameter("question");
        String answer=(String)request.getParameter("answer");  
        String role=(String)request.getParameter("role");  
        String empname=(String)request.getParameter("empname");
        String design=(String)request.getParameter("designation");        
        String gender=(String)request.getParameter("gender");
        String dob=(String)request.getParameter("dob");
        String pob=(String)request.getParameter("pob");
        String present=(String)request.getParameter("present");
        String permanent=(String)request.getParameter("permanent");
        String nation=(String)request.getParameter("nationality");
        String fname=(String)request.getParameter("fname");
        String foccup=(String)request.getParameter("occupation");
        String marital=(String)request.getParameter("marital");
               
        jb.setEmpId(empid);
        jb.setLoginId(loginid);
        jb.setPassword(passw);
        jb.setQuestion(question);
        jb.setAnswer(answer);
        jb.setRole(role);
        
        jb.setEmpName(empname);
        jb.setDesignation(design);
        jb.setGender(gender);
        jb.setDob(dob);
        jb.setPob(pob);
        jb.setPresent(present);
        jb.setPermanent(permanent);
        jb.setNationality(nation);
        jb.setFname(fname);
        jb.setFoccupation(foccup);
        jb.setMstatus(marital);   
        
        String status="";
        LoginDataObject dobj=new LoginDataObject();        
        bn=dobj.registUserData1(jb);   
        request.setAttribute("jbean",jb); 
        if(bn==0){
        request.setAttribute("msg","Data Submitted"); 
        status="success";
        }
        else{
        request.setAttribute("msg","Employee ID or Login ID Already Exists");   
        status="failure";
        }
        return mapping.findForward(status);       
        } 
        
          public ActionForward registUserAction2(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int bn=0;
        int count=0; 
        String status="";
        LoginDataObject dobj=new LoginDataObject(); 
        JBeanEmp jb=new JBeanEmp();
        PrintWriter out=response.getWriter();        
        String empid="";
        if(request.getParameter("empid")!=null){
        empid=(String)request.getParameter("empid");  
        }
        count=dobj.checkLoginn(empid);
        if(count!=0){
        String high=(String)request.getParameter("high");
        String high1=(String)request.getParameter("high1");
        String high2=(String)request.getParameter("high2");
        String high3=(String)request.getParameter("high3");
        String high4=(String)request.getParameter("high4");
        String high5=(String)request.getParameter("high5");
        
        String inter=(String)request.getParameter("inter");
        String inter1=(String)request.getParameter("inter1");
        String inter2=(String)request.getParameter("inter2");
        String inter3=(String)request.getParameter("inter3");
        String inter4=(String)request.getParameter("inter4");
        String inter5=(String)request.getParameter("inter5");
        
        String grad=(String)request.getParameter("grad");
        String grad1=(String)request.getParameter("grad1");
        String grad2=(String)request.getParameter("grad2");
        String grad3=(String)request.getParameter("grad3");
        String grad4=(String)request.getParameter("grad4");
        String grad5=(String)request.getParameter("grad5");  
        
        String pg=(String)request.getParameter("pg");
        String pg1=(String)request.getParameter("pg1");
        String pg2=(String)request.getParameter("pg2");
        String pg3=(String)request.getParameter("pg3");
        String pg4=(String)request.getParameter("pg4");
        String pg5=(String)request.getParameter("pg5");
        
        String bed=(String)request.getParameter("bed");
        String bed1=(String)request.getParameter("bed1");
        String bed2=(String)request.getParameter("bed2");
        String bed3=(String)request.getParameter("bed3");
        String bed4=(String)request.getParameter("bed4");
        String bed5=(String)request.getParameter("bed5");
        
        String other=(String)request.getParameter("other");
        String other1=(String)request.getParameter("other1");
        String other2=(String)request.getParameter("other2");
        String other3=(String)request.getParameter("other3");
        String other4=(String)request.getParameter("other4");
        String other5=(String)request.getParameter("other5");
              
        jb.setEmpId(empid);
                 
        if(request.getParameter("high")!=null && request.getParameter("high1")!=null && request.getParameter("high2")!=null && request.getParameter("high3")!=null && request.getParameter("high4")!=null && request.getParameter("high5")!=null){
        jb.setHigh(high);
        jb.setHigh1(high1);
        jb.setHigh2(high2);
        jb.setHigh3(high3);
        jb.setHigh4(high4);
        jb.setHigh5(high5);
        }
        if(request.getParameter("inter")!=null && request.getParameter("inter1")!=null && request.getParameter("inter2")!=null && request.getParameter("inter3")!=null && request.getParameter("inter4")!=null && request.getParameter("inter5")!=null){
        jb.setInter(inter);
        jb.setInter1(inter1);
        jb.setInter2(inter2);
        jb.setInter3(inter3);
        jb.setInter4(inter4);
        jb.setInter5(inter5);
        }
         if(request.getParameter("grad")!=null && request.getParameter("grad1")!=null && request.getParameter("grad2")!=null && request.getParameter("grad3")!=null && request.getParameter("grad4")!=null && request.getParameter("grad5")!=null){
        jb.setGrad(grad);
        jb.setGrad1(grad1);
        jb.setGrad2(grad2);
        jb.setGrad3(grad3);
        jb.setGrad4(grad4);    
        jb.setGrad5(grad5);
        }
         if(request.getParameter("pg")!=null && request.getParameter("pg1")!=null && request.getParameter("pg2")!=null && request.getParameter("pg3")!=null && request.getParameter("pg4")!=null && request.getParameter("pg5")!=null){
         jb.setPg(pg); 
         jb.setPg1(pg1);
         jb.setPg2(pg2);
         jb.setPg3(pg3);
         jb.setPg4(pg4);
         jb.setPg5(pg5);
        }
        if(request.getParameter("bed")!=null && request.getParameter("bed1")!=null && request.getParameter("bed2")!=null && request.getParameter("bed3")!=null && request.getParameter("bed4")!=null && request.getParameter("bed5")!=null){
        jb.setBed(bed);
        jb.setBed1(bed1);
        jb.setBed2(bed2);
        jb.setBed3(bed3);
        jb.setBed4(bed4);
        jb.setBed5(bed5);
        }  
        if(request.getParameter("other")!=null && request.getParameter("other1")!=null && request.getParameter("other2")!=null && request.getParameter("other3")!=null && request.getParameter("other4")!=null && request.getParameter("other5")!=null){
        jb.setOther(other);
        jb.setOther1(other1);
        jb.setOther2(other2);
        jb.setOther3(other3);
        jb.setOther4(other4);
        jb.setOther5(other5);       
        }         
               
        bn=dobj.registUserData2(jb);   
        request.setAttribute("jbean",jb); 
        if(bn==0){
        request.setAttribute("msg","Data Submitted");    
        }
        else{
        request.setAttribute("msg","Login ID Already Exists");        
        }
        status="success";
        }
        else{
        request.setAttribute("msg","No Such ID Exists");     
        status="failure";    
        }
        return mapping.findForward(status);        
        } 
          
            public ActionForward registUserAction3(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int bn=0;
        int count=0;
        String status="";
        LoginDataObject dobj=new LoginDataObject();  
        JBeanEmp jb=new JBeanEmp();
        PrintWriter out=response.getWriter();
        String empid="";
        if(request.getParameter("empid")!=null){
        empid=(String)request.getParameter("empid");  
        }
        count=dobj.checkLoginn(empid);
        if(count!=0){             
        String employer1=(String)request.getParameter("employer1");
        String employer2=(String)request.getParameter("employer2");
        String employer3=(String)request.getParameter("employer3");
        String employer4=(String)request.getParameter("employer4");
        
        String empdesg1=(String)request.getParameter("empdesg1");
        String empdesg2=(String)request.getParameter("empdesg2");
        String empdesg3=(String)request.getParameter("empdesg3");
        String empdesg4=(String)request.getParameter("empdesg4");
        
        String from1=(String)request.getParameter("from1");
        String from2=(String)request.getParameter("from2");
        String from3=(String)request.getParameter("from3");
        String from4=(String)request.getParameter("from4");
        
        String to1=(String)request.getParameter("to1");
        String to2=(String)request.getParameter("to2");
        String to3=(String)request.getParameter("to3");
        String to4=(String)request.getParameter("to4");
        
        String eng=(String)request.getParameter("eng");
        String engr=(String)request.getParameter("engr");
        String engw=(String)request.getParameter("engw");
        String engs=(String)request.getParameter("engs");
        
        String hindi=(String)request.getParameter("hindi");
        String hindir=(String)request.getParameter("hindir");
        String hindiw=(String)request.getParameter("hindiw");
        String hindis=(String)request.getParameter("hindis");
        
        String otherlan=(String)request.getParameter("otherlang");
        String otherlanr=(String)request.getParameter("otherlangr");
        String otherlanw=(String)request.getParameter("otherlangw");
        String otherlans=(String)request.getParameter("otherlangs");
              
        jb.setEmpId(empid);
                             
        if(employer1!=null && empdesg1!=null && from1!=null && to1!=null){
        jb.setEmployer1(employer1);         
        jb.setEmpdegn1(empdesg1);
        jb.setPeriodfrm1(from1);
        jb.setPeriodto1(to1);
        }
         if(employer2!=null && empdesg2!=null && from2!=null && to2!=null){
        jb.setEmployer2(employer2);
        jb.setEmpdegn2(empdesg2);
        jb.setPeriodfrm2(from2);
        jb.setPeriodto2(to2);
        }
         if(employer3!=null && empdesg3!=null && from3!=null && to3!=null ){
        jb.setEmployer3(employer3);
        jb.setEmpdegn3(empdesg3);
        jb.setPeriodfrm3(from3);
        jb.setPeriodto3(to3);
        }
         if(employer4!=null && empdesg4!=null && from4!=null && to4!=null){
        jb.setEmployer4(employer4);
        jb.setEmpdegn4(empdesg4);
        jb.setPeriodfrm4(from4);
        jb.setPeriodto4(to4);
        }
           
         if(eng!=null && engr!=null && engw!=null && engs!=null){
         jb.setEng(eng);
         jb.setEngr(engr);
         jb.setEngw(engw);
         jb.setEngs(engs);
         }
           
        if(hindi!=null && hindir!=null && hindiw!=null && hindis!=null){
        jb.setHindi(hindi);   
        jb.setHindir(hindir);
        jb.setHindiw(hindiw);
        jb.setHindis(hindis);
        }
        if(otherlan!=null && otherlanr!=null && otherlanw!=null && otherlans!=null){
        jb.setOtherlan(otherlan);
        jb.setOtherlanr(otherlanr);
        jb.setOtherlanw(otherlanw);
        jb.setOtherlans(otherlans);
        }                   
              
        bn=dobj.registUserData3(jb);   
        request.setAttribute("jbean",jb); 
        if(bn==0){
        request.setAttribute("msg","Data Submitted");    
        }
        else{
        request.setAttribute("msg","Login ID Already Exists");        
        }
          status="success";
        }
        else{
        request.setAttribute("msg","No Such ID Exists");     
        status="failure";    
        }
        return mapping.findForward(status);       
        } 
            
               public ActionForward registUserAction4(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int bn=0;
        int count=0;
        String status="";
        LoginDataObject dobj=new LoginDataObject();
        JBeanEmp jb=new JBeanEmp();
        PrintWriter out=response.getWriter();
        String empid="";
        if(request.getParameter("empid")!=null){
        empid=(String)request.getParameter("empid");  
        }
        count=dobj.checkLoginn(empid);
        if(count!=0){ 
        String games=(String)request.getParameter("games");
        String games1=(String)request.getParameter("games1");
        String games2=(String)request.getParameter("games2");
        String games3=(String)request.getParameter("games3");
        
        String lc=(String)request.getParameter("lc");
        String lc1=(String)request.getParameter("lc1");
        String lc2=(String)request.getParameter("lc2");
        String lc3=(String)request.getParameter("lc3");
        
        String ref1=(String)request.getParameter("refer1");
        String ref2=(String)request.getParameter("refer2");
        String ref3=(String)request.getParameter("refer3");   
        
        jb.setEmpId(empid);                  
      
         if(games!=null && games1!=null && games2!=null && games3!=null){
        jb.setGames(games);
        jb.setGames1(games1);
        jb.setGames2(games2);
        jb.setGames3(games3);
        }
        if(lc!=null && lc1!=null && lc2!=null && lc3!=null){
        jb.setLc(lc); 
        jb.setLc1(lc1); 
        jb.setLc2(lc2); 
        jb.setLc3(lc3); 
        }          
       
         jb.setRefer1(ref1);       
        
         jb.setRefer2(ref2);    
      
         jb.setRefer3(ref3);   
                  
        bn=dobj.registUserData4(jb);   
        request.setAttribute("jbean",jb); 
        if(bn==0){
        request.setAttribute("msg","Data Submitted");         
        }
        else{
        request.setAttribute("msg","Login ID Already Exists");          
        }
           status="success";
        }
        else{
        request.setAttribute("msg","No Such ID Exists");     
        status="failure";    
        }
        return mapping.findForward(status);        
        } 
        
              public ActionForward allEmpIdAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ArrayList ar=new ArrayList();   
        JBeanEmp jb=new JBeanEmp();
        PrintWriter out=response.getWriter();          
        LoginDataObject dobj=new LoginDataObject();        
        ar=(ArrayList)dobj.allEmpIdData(); 
        request.setAttribute("arr",ar);  
        return mapping.findForward(SUCCESS);       
        } 
        
        public ActionForward eDetail7(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception {  
        ArrayList ar=new ArrayList();     
        JBeanEmp jb=new JBeanEmp();
        PrintWriter out=response.getWriter();  
        String eid=(String)request.getParameter("empid");
        String status="";
        LoginDataObject dobj=new LoginDataObject();        
        jb=(JBeanEmp)dobj.eDetail7Data(eid); 
        ar=(ArrayList)dobj.allEmpIdData();     
        request.setAttribute("jbean",jb);  
        request.setAttribute("arr",ar);  
        return mapping.findForward(SUCCESS);       
        }     
        
        public ActionForward eDetail1(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception {  
        ArrayList ar=new ArrayList();     
        JBeanEmp jb=new JBeanEmp();
        PrintWriter out=response.getWriter();  
        String eid=(String)request.getParameter("empid");
        String status="";
        LoginDataObject dobj=new LoginDataObject();        
        jb=(JBeanEmp)dobj.eDetail1Data(eid); 
        ar=(ArrayList)dobj.allEmpIdData();     
        request.setAttribute("jbean",jb);  
        request.setAttribute("arr",ar);  
        return mapping.findForward(SUCCESS);       
        }  
          
        public ActionForward eDetail2(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception {  
        ArrayList ar=new ArrayList();     
        JBeanEmp jb=new JBeanEmp();
        PrintWriter out=response.getWriter();  
        String eid=(String)request.getParameter("empid");       
        LoginDataObject dobj=new LoginDataObject();        
        jb=(JBeanEmp)dobj.eDetail2Data(eid); 
        ar=(ArrayList)dobj.allEmpIdData();  
        request.setAttribute("jbean",jb);  
        request.setAttribute("arr",ar);  
        return mapping.findForward(SUCCESS);       
        }     
        
        public ActionForward eDetail3(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception {  
        ArrayList ar=new ArrayList();     
        JBeanEmp jb=new JBeanEmp();
        PrintWriter out=response.getWriter();  
        String eid=(String)request.getParameter("empid");       
        LoginDataObject dobj=new LoginDataObject();        
        jb=(JBeanEmp)dobj.eDetail3Data(eid); 
        ar=(ArrayList)dobj.allEmpIdData();  
        request.setAttribute("jbean",jb);  
        request.setAttribute("arr",ar);  
        return mapping.findForward(SUCCESS);       
        }  
        
         public ActionForward eDetail4(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception {  
        ArrayList ar=new ArrayList();     
        JBeanEmp jb=new JBeanEmp();
        PrintWriter out=response.getWriter();  
        String eid=(String)request.getParameter("empid");       
        LoginDataObject dobj=new LoginDataObject();        
        jb=(JBeanEmp)dobj.eDetail4Data(eid); 
        ar=(ArrayList)dobj.allEmpIdData();  
        request.setAttribute("jbean",jb);  
        request.setAttribute("arr",ar);  
        return mapping.findForward(SUCCESS);       
        }
         
        public ActionForward eDetail5(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception {  
        ArrayList ar=new ArrayList();     
        JBeanEmp jb=new JBeanEmp();
        PrintWriter out=response.getWriter();  
        String eid=(String)request.getParameter("empid");       
        LoginDataObject dobj=new LoginDataObject();        
        jb=(JBeanEmp)dobj.eDetail5Data(eid); 
        ar=(ArrayList)dobj.allEmpIdData();  
        request.setAttribute("jbean",jb);  
        request.setAttribute("arr",ar);  
        return mapping.findForward(SUCCESS);       
        }
          
           public ActionForward eDetail6(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception {  
        ArrayList ar=new ArrayList();     
        JBeanEmp jb=new JBeanEmp();
        PrintWriter out=response.getWriter();  
        String eid=(String)request.getParameter("empid");       
        LoginDataObject dobj=new LoginDataObject();        
        jb=(JBeanEmp)dobj.eDetail6Data(eid); 
        ar=(ArrayList)dobj.allEmpIdData();  
        request.setAttribute("jbean",jb);  
        request.setAttribute("arr",ar);  
        return mapping.findForward(SUCCESS);       
        }
        
          public ActionForward updateEmpAction7(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int bn=0;   
        JBeanEmp jb=new JBeanEmp();
        PrintWriter out=response.getWriter();
        String empid=(String)request.getParameter("empid");        
        String loginid=(String)request.getParameter("loginid");        
        String passw=(String)request.getParameter("password");
        String question=(String)request.getParameter("question");
        String answer=(String)request.getParameter("answer");  
                
        jb.setEmpId(empid);
        jb.setLoginId(loginid);
        jb.setPassword(passw);
        jb.setQuestion(question);
        jb.setAnswer(answer);
             
        String status="";
        LoginDataObject dobj=new LoginDataObject();        
        bn=dobj.updateEmpData7(jb);   
        ArrayList ar=new ArrayList(); 
        ar=(ArrayList)dobj.allEmpIdData(); 
        request.setAttribute("jbean",jb); 
        request.setAttribute("arr",ar); 
        if(bn==1){
        request.setAttribute("msg","Data Updated"); 
        }
        else{
        request.setAttribute("msg","Database Error");     
        }
         return mapping.findForward(SUCCESS);       
        }    
          
           public ActionForward updateEmpAction1(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int bn=0;   
        JBeanEmp jb=new JBeanEmp();
        PrintWriter out=response.getWriter();
        String empid=(String)request.getParameter("empid"); 
        String empname=(String)request.getParameter("empname");
        String design=(String)request.getParameter("designation");        
        String gender=(String)request.getParameter("gender");
        String dob=(String)request.getParameter("dob");
        String pob=(String)request.getParameter("pob");
        String present=(String)request.getParameter("present");
        String permanent=(String)request.getParameter("permanent");
        String nation=(String)request.getParameter("nationality");
        String fname=(String)request.getParameter("fname");
        String foccup=(String)request.getParameter("occupation");
        String marital=(String)request.getParameter("marital");
        
        jb.setEmpId(empid);
        jb.setEmpName(empname);
        jb.setDesignation(design);
        jb.setGender(gender);
        jb.setDob(dob);
        jb.setPob(pob);
        jb.setPresent(present);
        jb.setPermanent(permanent);
        jb.setNationality(nation);
        jb.setFname(fname);
        jb.setFoccupation(foccup);
        jb.setMstatus(marital); 
             
        String status="";
        LoginDataObject dobj=new LoginDataObject();        
        bn=dobj.updateEmpData1(jb);   
        ArrayList ar=new ArrayList(); 
        ar=(ArrayList)dobj.allEmpIdData(); 
        request.setAttribute("jbean",jb); 
        request.setAttribute("arr",ar); 
        if(bn==1){
        request.setAttribute("msg","Data Updated"); 
        }
        else{
        request.setAttribute("msg","Database Error");     
        }
         return mapping.findForward(SUCCESS);       
        } 
           
        public ActionForward updateEmpAction2(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        int bn=0;   
        JBeanEmp jb=new JBeanEmp();
        PrintWriter out=response.getWriter();
        ArrayList ar1=new ArrayList();
        HashMap hm1=new HashMap(); 
        HashMap hm2=new HashMap(); 
        HashMap hm3=new HashMap(); 
        HashMap hm4=new HashMap(); 
        HashMap hm5=new HashMap(); 
        
        String empid=(String)request.getParameter("empid"); 
        
        String[] exampass=(String[])request.getParameterValues("exampass");
        String[] board=(String[])request.getParameterValues("board");
        String[] subject=(String[])request.getParameterValues("subject");
        String[] year=(String[])request.getParameterValues("year");        
        String[] percent=(String[])request.getParameterValues("percent");
        String[] remark=(String[])request.getParameterValues("remark");
        
        jb.setEmpId(empid);
        for(int i=0;i<exampass.length;i++){
        ar1.add(exampass[i]);
        hm1.put(exampass[i],board[i]);
        hm2.put(exampass[i],subject[i]);
        hm3.put(exampass[i],year[i]);
        hm4.put(exampass[i],percent[i]);
        hm5.put(exampass[i],remark[i]);   
        }         
        jb.setExamPassed(ar1);
        jb.setBoardUnv(hm1);
        jb.setSubOffered(hm2);
        jb.setExamYear(hm3);
        jb.setExamPercent(hm4);
        jb.setExamRemark(hm5);
        
        LoginDataObject dobj=new LoginDataObject();        
        bn=dobj.updateEmpData2(jb);  
        ArrayList ar=new ArrayList(); 
        ar=(ArrayList)dobj.allEmpIdData(); 
        request.setAttribute("jbean",jb); 
        request.setAttribute("arr",ar); 
        if(bn==1){
        request.setAttribute("msg","Data Updated"); 
        }
        else{
        request.setAttribute("msg","Database Error");     
        }
         return mapping.findForward(SUCCESS);       
        } 
        
          public ActionForward updateEmpAction3(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        int bn=0;   
        JBeanEmp jb=new JBeanEmp();
        PrintWriter out=response.getWriter();
        ArrayList rid=new ArrayList();
        HashMap hm1=new HashMap();
        HashMap hm2=new HashMap(); 
        HashMap hm3=new HashMap(); 
        HashMap hm4=new HashMap();       
        
        String empid=(String)request.getParameter("empid"); 
        String[] rowid=(String[])request.getParameterValues("rowid");
        String[] employer=(String[])request.getParameterValues("employer");
        String[] empdesg=(String[])request.getParameterValues("empdesg");
        String[] empfrom=(String[])request.getParameterValues("from");
        String[] empto=(String[])request.getParameterValues("to");        
           
        jb.setEmpId(empid);
        for(int i=0;i<rowid.length;i++){
        rid.add(rowid[i]);    
        hm1.put(rowid[i],employer[i]);
        hm2.put(rowid[i],empdesg[i]);
        hm3.put(rowid[i],empfrom[i]);
        hm4.put(rowid[i],empto[i]);
         }     
        jb.setRowid(rid);
        jb.setEmployer(hm1);
        jb.setEmployerDesg(hm2);
        jb.setEmployerFrom(hm3);
        jb.setEmployerTo(hm4);
              
        LoginDataObject dobj=new LoginDataObject();        
        bn=dobj.updateEmpData3(jb);   
        ArrayList ar=new ArrayList(); 
        ar=(ArrayList)dobj.allEmpIdData(); 
        request.setAttribute("jbean",jb); 
        request.setAttribute("arr",ar); 
        if(bn==1){
        request.setAttribute("msg","Data Updated"); 
        }
        else{
        request.setAttribute("msg","Database Error");     
        }
         return mapping.findForward(SUCCESS);       
        } 
          
        public ActionForward updateEmpAction4(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        int bn=0;   
        JBeanEmp jb=new JBeanEmp();
        PrintWriter out=response.getWriter();
        ArrayList ar1=new ArrayList();
        HashMap hm1=new HashMap(); 
        HashMap hm2=new HashMap(); 
        HashMap hm3=new HashMap();       
        
        String empid=(String)request.getParameter("empid");         
        String[] lang=(String[])request.getParameterValues("languages");
        String[] read=(String[])request.getParameterValues("read");
        String[] write=(String[])request.getParameterValues("write");
        String[] speak=(String[])request.getParameterValues("speak");        
           
        jb.setEmpId(empid);
        for(int i=0;i<lang.length;i++){
        ar1.add(lang[i]);
        hm1.put(lang[i],read[i]);
        hm2.put(lang[i],write[i]);
        hm3.put(lang[i],speak[i]);
         }         
        jb.setLanguages(ar1);
        jb.setRead(hm1);
        jb.setWrite(hm2);
        jb.setSpeak(hm3);
              
        LoginDataObject dobj=new LoginDataObject();        
        bn=dobj.updateEmpData4(jb); 
        ArrayList ar=new ArrayList(); 
        ar=(ArrayList)dobj.allEmpIdData(); 
        request.setAttribute("jbean",jb); 
        request.setAttribute("arr",ar); 
        if(bn==1){
        request.setAttribute("msg","Data Updated"); 
        }
        else{
        request.setAttribute("msg","Database Error");     
        }
         return mapping.findForward(SUCCESS);       
        } 
        
         public ActionForward updateEmpAction5(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        int bn=0;   
        JBeanEmp jb=new JBeanEmp();
        PrintWriter out=response.getWriter();
        ArrayList ar1=new ArrayList();
        HashMap hm1=new HashMap(); 
        HashMap hm2=new HashMap(); 
        HashMap hm3=new HashMap();       
        
        String empid=(String)request.getParameter("empid");         
        String[] act=(String[])request.getParameterValues("activity");
        String[] rlevel=(String[])request.getParameterValues("rlevel");
        String[] actyear=(String[])request.getParameterValues("actyear");
        String[] pstood=(String[])request.getParameterValues("pstood");        
           
        jb.setEmpId(empid);
        
        for(int i=0;i<act.length;i++){
        ar1.add(act[i]);
        hm1.put(act[i],rlevel[i]);
        hm2.put(act[i],actyear[i]);
        hm3.put(act[i],pstood[i]);
         }         
        jb.setActivity(ar1);
        jb.setRepresentLevel(hm1);
        jb.setActivityYear(hm2);
        jb.setPositionStood(hm3);
              
        LoginDataObject dobj=new LoginDataObject();        
        bn=dobj.updateEmpData5(jb);  
        ArrayList ar=new ArrayList(); 
        ar=(ArrayList)dobj.allEmpIdData(); 
        request.setAttribute("jbean",jb); 
        request.setAttribute("arr",ar); 
        if(bn==1){
        request.setAttribute("msg","Data Updated"); 
        }
        else{
        request.setAttribute("msg","Database Error");     
        }
         return mapping.findForward(SUCCESS);       
        } 
         
           public ActionForward updateEmpAction6(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        int bn=0;   
        JBeanEmp jb=new JBeanEmp();
        PrintWriter out=response.getWriter();  
        
        String empid=(String)request.getParameter("empid"); 
        
        String ref1=(String)request.getParameter("refer1"); 
        String ref2=(String)request.getParameter("refer2"); 
        String ref3=(String)request.getParameter("refer3"); 
             
        jb.setEmpId(empid);
        
        jb.setRefer1(ref1);        
        jb.setRefer2(ref2);  
        jb.setRefer3(ref3);
        
        LoginDataObject dobj=new LoginDataObject();        
        bn=dobj.updateEmpData6(jb);  
        ArrayList ar=new ArrayList(); 
        ar=(ArrayList)dobj.allEmpIdData(); 
        request.setAttribute("jbean",jb); 
        request.setAttribute("arr",ar); 
        if(bn==1){
        request.setAttribute("msg","Data Updated"); 
        }
        else{
        request.setAttribute("msg","Database Error");     
        }
         return mapping.findForward(SUCCESS);       
        }  
               
//          public ActionForward delLoginAction(ActionMapping mapping, ActionForm form,
//            HttpServletRequest request, HttpServletResponse response)
//            throws Exception {                
//        PrintWriter out=response.getWriter();    
//        ArrayList ar=new ArrayList();
//        boolean bn=false;
//        LoginDataObject dob=new LoginDataObject();        
//        ar=(ArrayList)dob.loginData();           
//        request.setAttribute("arr",ar);        
//        return mapping.findForward(SUCCESS);        
//        }       
//          
//        public ActionForward delLogin(ActionMapping mapping, ActionForm form,
//        HttpServletRequest request, HttpServletResponse response)
//        throws Exception {   
//        boolean bn=false;    
//        PrintWriter out=response.getWriter();    
//        ArrayList ar=new ArrayList();
//        String id=(String)request.getParameter("para");
//        LoginDataObject dob=new LoginDataObject();     
//        bn=dob.delLoginData(id);
//        ar=(ArrayList)dob.loginData();           
//        request.setAttribute("arr",ar);  
//        request.setAttribute("msg","Login ID Deleted");
//        return mapping.findForward(SUCCESS);        
//        }     
        
           
public ActionForward registUserAction_Emp(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        int bn=0;
        String fail = "fail";
        ArrayList userdetail=new ArrayList();
        JavaBean1 jb=new JavaBean1();
        PrintWriter out=response.getWriter();
        String name=(String)request.getParameter("name");
        String loginid=(String)request.getParameter("loginid");
        String passw=(String)request.getParameter("password");
        String secques=(String)request.getParameter("secretques");
        String secans=(String)request.getParameter("secretans");    
        String user_type=(String)request.getParameter("user_type");   
        String homeaddress=(String)request.getParameter("homeaddress");   
        String homeaddress2=(String)request.getParameter("homeaddress2");   
        String city=(String)request.getParameter("city");   
        String state=(String)request.getParameter("state");   
        String pincode=(String)request.getParameter("pincode");   
        String country=(String)request.getParameter("country");   
        String telno=(String)request.getParameter("telno");   
        String mobileno=(String)request.getParameter("mobileno");   
        String loginFor=request.getParameter("login_for");
        
        if(request.getParameter("loginfor_name")!=null){
            jb.setLoginForName(request.getParameter("loginfor_name"));
        }
                     
        jb.setName(name);
        jb.setLoginid(loginid);
        jb.setPassword(passw);
        jb.setSecretques(secques);
        jb.setSecretans(secans);     
        jb.setHomeaddress(homeaddress);
        jb.setHomeaddress2(homeaddress2);
        jb.setCity(city);
        jb.setState(state);
        jb.setPincode(pincode);
        jb.setCountry(country);
        jb.setTelno(telno);
        jb.setMobileno(mobileno);
        jb.setUserType(user_type);
        jb.setLoginFor(loginFor);
        
        LoginDataObject dob=new LoginDataObject();        
        bn=dob.registUserData_Emp(jb);   
        request.setAttribute("jbean",jb);     
        if(bn==0){
          userdetail=dob.select_user();  
            
        request.setAttribute("msg","Data Submitted");
        request.setAttribute("userdetail",userdetail);   
        return mapping.findForward(SUCCESS);     
        }
        else if(bn==-1){
        request.setAttribute("msg","Some problem occured. Please contact with vendor."); 
         return mapping.findForward(fail);   
        }
        else {
        request.setAttribute("msg","Login ID Already Exists"); 
         return mapping.findForward(fail);   
        }
         
        } 

public ActionForward allLoginIdAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ArrayList ar=new ArrayList();   
        PrintWriter out=response.getWriter();          
        LoginDataObject dobj=new LoginDataObject();        
        ar=(ArrayList)dobj.allRegistUserIdData_Emp(); 
        request.setAttribute("arr",ar);  
        return mapping.findForward(SUCCESS);       
        } 
public ActionForward LoginIdEmpAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ArrayList ar=new ArrayList();   
        JavaBean1 jb1=new JavaBean1();
        LoginDataObject dobj=new LoginDataObject();    
        String submit=request.getParameter("submit");
        if(submit.equals("Retrieve")){
        PrintWriter out=response.getWriter(); 
        String loginid=request.getParameter("loginid");
        
        jb1=dobj.eDetailFromUsername(loginid);
        }
        else{
            JavaBean1 jb=new JavaBean1();
        PrintWriter out=response.getWriter();
        String name=(String)request.getParameter("name");
        String loginid=(String)request.getParameter("login_id");
        String passw=(String)request.getParameter("password");
        String secques=(String)request.getParameter("secretques");
        String secans=(String)request.getParameter("secretans");    
        String user_type=(String)request.getParameter("user_type");   
        String homeaddress=(String)request.getParameter("homeaddress");   
           String homeaddress2=(String)request.getParameter("homeaddress2");   
           String city=(String)request.getParameter("city");   
           String state=(String)request.getParameter("state");   
           String pincode=(String)request.getParameter("pincode");   
           String country=(String)request.getParameter("country");   
           String telno=(String)request.getParameter("telno");   
            String mobileno=(String)request.getParameter("mobileno");  
            String rid=request.getParameter("rid");
             
          
        jb.setRid(Long.parseLong(rid));   
        jb.setName(name);
        jb.setLoginid(loginid);
        jb.setPassword(passw);
        jb.setSecretques(secques);
        jb.setSecretans(secans);     
        
        jb.setHomeaddress(homeaddress);
        jb.setHomeaddress2(homeaddress2);
        jb.setCity(city);
        jb.setState(state);
        jb.setPincode(pincode);
        jb.setCountry(country);
        jb.setTelno(telno);
        jb.setMobileno(mobileno);
        jb.setUserType(user_type);
           
        dobj.updateEmpData(jb);
        jb1=dobj.eDetailFromUsername(loginid);
        request.setAttribute("msg","Data is updated.");  
        }
        
        ar=(ArrayList)dobj.allRegistUserIdData_Emp(); 
        request.setAttribute("arr",ar);  
        request.setAttribute("jbean",jb1);
        return mapping.findForward(SUCCESS);       
        } 

public ActionForward EditEmpPro(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ArrayList ar=new ArrayList();   
        JavaBean1 jb1=new JavaBean1();
        LoginDataObject dobj=new LoginDataObject();    
        JavaBean1 jb=new JavaBean1();
        PrintWriter out=response.getWriter();
        String name=(String)request.getParameter("name");
        String loginid=(String)request.getParameter("login_id");
        String secques=(String)request.getParameter("secretques");
        String secans=(String)request.getParameter("secretans");    
        String homeaddress=(String)request.getParameter("homeaddress");   
           String homeaddress2=(String)request.getParameter("homeaddress2");   
           String city=(String)request.getParameter("city");   
           String state=(String)request.getParameter("state");   
           String pincode=(String)request.getParameter("pincode");   
           String country=(String)request.getParameter("country");   
           String telno=(String)request.getParameter("telno");   
            String mobileno=(String)request.getParameter("mobileno");  
            String rid=request.getParameter("rid");
        jb.setRid(Long.parseLong(rid));   
        jb.setName(name);
        jb.setLoginid(loginid);
        jb.setSecretques(secques);
        jb.setSecretans(secans);       
        jb.setHomeaddress(homeaddress);
        jb.setHomeaddress2(homeaddress2);
        jb.setCity(city);
        jb.setState(state);
        jb.setPincode(pincode);
        jb.setCountry(country);
        jb.setTelno(telno);
        jb.setMobileno(mobileno);
           
        int bn=dobj.updateEmpPro(jb);
        System.out.println("update value:"+bn);
        jb1=dobj.eDetailFromUsername(loginid);
        request.setAttribute("msg","Data is updated.");  
        request.setAttribute("jbean",jb1);
        return mapping.findForward(SUCCESS);       
        } 

public ActionForward Edit_user_prof(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ArrayList ar=new ArrayList();   
        JavaBean1 jb1=new JavaBean1();
        LoginDataObject dobj=new LoginDataObject();    
        String loginid=request.getParameter("loginid");
        jb1=dobj.eDetailFromUsername(loginid);   
        ar=(ArrayList)dobj.allRegistUserIdData_Emp(); 
        request.setAttribute("arr",ar);  
        request.setAttribute("jbean",jb1);
        return mapping.findForward(SUCCESS);       
        }   
public ActionForward Edit_user_pass(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    HttpSession session=request.getSession(false);
        String mp="";
        ArrayList ar=new ArrayList();   
        JavaBean1 jb1=new JavaBean1();
        JavaBean1 jb=new JavaBean1();
        LoginDataObject dobj=new LoginDataObject();    
        String loginid= (String)session.getAttribute("loginid");
        String loginfor=(String)session.getAttribute("loginfor");
        String oldpass= request.getParameter("oldpass");
        String newpass= request.getParameter("newpass");
        String cnewpass= request.getParameter("cnewpass");
        jb.setPassword(newpass);
        jb.setLoginid(loginid);
        dobj.updateUserPass(loginid,newpass);
        if(loginfor.equals("hostel"))
        {
            mp="hostelsuccess";
            request.setAttribute("msg","Password successfuly changed.");   
        }else
        {
             mp="success";
             request.setAttribute("msg","Password successfuly changed.");   
        }
        return mapping.findForward(mp);       
        }   
}