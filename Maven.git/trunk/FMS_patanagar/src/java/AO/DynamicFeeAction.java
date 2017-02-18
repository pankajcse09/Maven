package AO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import java.io.PrintWriter;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import java.util.*;
import ActionClass.*;
import EO.SchoolEO;
import com.myapp.struts.DataConnection;
import java.sql.*;
import Beans.*;
import Fee.UpdateFee;
import Reports.Reports_DB;
import java.text.SimpleDateFormat;

public class DynamicFeeAction extends DispatchAction{
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "success";   
    Connection cn=null;
    PreparedStatement psmt=null;
    PreparedStatement psmt1=null;    
    PreparedStatement psmt2=null;
    PreparedStatement psmt3=null;
    ResultSet rs=null;
    ResultSet rs1=null;    
    ResultSet rs2=null;
    ResultSet rs3=null;
    
      public ActionForward delStudRecAct(ActionMapping mapping,ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception{
        int count=0;  
        SchoolEO seo=new SchoolEO();
        String srnum=request.getParameter("srnum");
        String sesn=request.getParameter("session");
        String cl=request.getParameter("cls");
        seo.setSrnum(srnum);
        seo.setSession(sesn);
        seo.setClasses(cl);
            try{        
            DataConnection dc1=new DataConnection();
            cn=(Connection)dc1.Dataconnect();  
            cn.setAutoCommit(false);
            }catch(Exception e){}
            String qr1="delete from studentregis where session='"+seo.getSession()+"' and srnum='"+seo.getSrnum()+"'";
//            String qr2="delete from oldregis where session='"+seo.getSession()+"' and srnum='"+seo.getSrnum()+"'";
            String qr3="delete from stud_subject where session='"+seo.getSession()+"' and admin_no='"+seo.getSrnum()+"'";             
            try{
            psmt1=cn.prepareStatement(qr1); 
            psmt1.executeUpdate();     
//            psmt2=cn.prepareStatement(qr2); 
//            psmt2.executeUpdate();  
            psmt3=cn.prepareStatement(qr3); 
            psmt3.executeUpdate(); 
            cn.commit();      
            count=1;
            }catch(SQLException se){
            cn.rollback();
            count=-1;
            }
           finally{
           try{
           if(psmt1!=null){psmt1.close();}    
//           if(psmt2!=null){psmt2.close();}
           if(psmt3!=null){psmt3.close();}
           if(cn!=null){cn.close();}
           }catch(SQLException se){}   
           }   
           RequestDispatcher rd=(RequestDispatcher)request.getRequestDispatcher("/listofstud.do?session="+seo.getSession()+"&classes="+seo.getClasses()+"&count="+count);
           rd.include(request,response);
           return mapping.findForward(SUCCESS);   
           }
    
      public ActionForward editClassSubAct(ActionMapping mapping,ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception{
        PrintWriter out=response.getWriter();
        SchoolEO seo=new SchoolEO();
        String srnum=request.getParameter("srnum");
        String sesn=request.getParameter("session");
        String cls=request.getParameter("seekadd");
        String gend=request.getParameter("gender");
        String[]sub=(String[])request.getParameterValues("sub"); 
        seo.setSrnum(srnum);
        seo.setSession(sesn);
        seo.setClasses(cls);    
        seo.setGender(gend);
        int count=0;
            try{        
            DataConnection dc1=new DataConnection();
            cn=(Connection)dc1.Dataconnect();  
            cn.setAutoCommit(false);
            }catch(Exception e){}
            String qr1="update studentregis set seekadd='"+cls+"' where srnum='"+srnum+"' and session='"+sesn+"'";   
            String qr2="delete from stud_subject where session='"+sesn+"' and admin_no='"+srnum+"'";             
            String qr3="insert into stud_subject(session,admin_no,classes,subject)values(?,?,?,?)";
            try{
            psmt1=cn.prepareStatement(qr1); 
            psmt1.executeUpdate();   
            psmt3=cn.prepareStatement(qr2); 
            psmt3.executeUpdate();
            psmt2=cn.prepareStatement(qr3); 
            for(int i=0;i<sub.length;i++){            
            psmt2.setString(1,sesn);
            psmt2.setString(2,srnum);
            psmt2.setString(3,cls);
            psmt2.setString(4,sub[i]);            
            psmt2.addBatch();
            }
            psmt2.executeBatch();
            cn.commit();
            MyMeth mm=new MyMeth();
            count=mm.upStudFeeData(cn,seo);
            if(count!=-1){
            cn.commit();
            }
           }catch(SQLException se){
           cn.rollback();
           }
           finally{
           try{
           if(psmt2!=null){psmt2.close();}
           if(cn!=null){cn.close();}
           }catch(SQLException se){}   
           }
           if(count==-1){
           request.setAttribute("msg","Database Error");   
           }else{
           if(count==0){
           request.setAttribute("msg","Fee Not Submitted");
           }else{
           request.setAttribute("msg","Subject and Class Updated");                
           }
           }
           return mapping.findForward(SUCCESS);   
           }
            
    public ActionForward totalHeadFee(ActionMapping mapping,ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception{
        PrintWriter out=response.getWriter();        
        MyMeth mm=new MyMeth();    
        Reports_DB rdb=new Reports_DB();
        String ssn=request.getParameter("session");
        String hd=request.getParameter("heads"); 
        String hd_cat=request.getParameter("heads_cat"); 
        String ssn_sem=request.getParameter("session_sem"); 
        String bank=request.getParameter("bank");
        String fld="";
        String head="";
        
            fld=hd.substring(hd.indexOf("/")+1, hd.length());
            head=hd.substring(0, hd.indexOf("/"));
       
//        System.out.println("kapil: "+head);
//        System.out.println("Saini: "+fld);
            
        SchoolEO seo=new SchoolEO(); 
        seo.setSession(ssn);
        seo.setHeads(head);  
        seo.setField(fld);
        seo.setSession_sem(ssn_sem);
        seo.setHeads_cat(hd_cat);
        if(seo.getHeads().equals("ALL"))
        {
            seo=mm.retFieldnameOfFeeHeads(seo);
//            seo=rdb.retTransfer_fund(seo);
//            System.out.print("kp: "+seo.getDataMap4());
        }
        else
        {
            ArrayList al=new ArrayList();
            HashMap hm=new HashMap();
            al.add(fld);
            hm.put(fld, head);
            seo.setDataArray(al);
            seo.setDataMap(hm);
        }
        seo=(SchoolEO)mm.retHeadFee(seo);   
        mm.retFeeHeadwiseFromStud_feeDetais(seo);
        request.setAttribute("jbean",seo);
        request.setAttribute("hd",hd);
//        out.print(seo.getDataMap2());
//        return mapping.findForward("");
        return mapping.findForward(SUCCESS);
       }      
    
    public ActionForward totalHeadCatFee(ActionMapping mapping,ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception{
        PrintWriter out=response.getWriter();        
        MyMeth mm=new MyMeth();    
        Reports_DB rdb=new Reports_DB();
        String ssn=request.getParameter("session");
        String hd_cat=request.getParameter("heads_cat"); 
        String ssn_sem=request.getParameter("session_sem"); 
        
//        String head="";
//        head=hd_cat.substring(hd_cat.indexOf("/")+1, hd_cat.length());
//        String hd_cats=hd_cat.substring(0, hd_cat.indexOf("/"));
            
        SchoolEO seo=new SchoolEO(); 
        seo.setSession(ssn);        
//        seo.setHeads(head);  
        
        seo.setSession_sem(ssn_sem);
        seo.setHeads_cat(hd_cat);
//        seo.setHeads_cat(hd_cats);
        if(!hd_cat.equals("MEDICALAIM PREMIUM")){
            seo=mm.retFieldnameOfFeeHeads(seo);
            seo=rdb.retTransfer_fund(seo);
//            System.out.print("kp: "+seo.getDataMap4());
        seo=(SchoolEO)mm.retHeadFee(seo);   
        mm.retFeeHeadwiseFromStud_feeDetais(seo);
        seo.setHeads_cat(hd_cat);
        request.setAttribute("hd_cat",hd_cat);
//        request.setAttribute("hd_categ",hd_cat);
        }
        else{
            ArrayList al=new ArrayList();
            HashMap hm=new HashMap();
            al.add("field30");
            hm.put("field30", hd_cat);
            seo.setDataArray(al);
            seo.setDataMap(hm);
            
            ArrayList ar2=new ArrayList();
            ArrayList ar3=new ArrayList();
            HashMap hm2=new HashMap();
            ar3.add("MEDICALAIM PREMIUM");
            hm2.put("MEDICALAIM PREMIUM", "UNIVERSITY DUES");
            ar2.add("UNIVERSITY DUES");
            
            seo.setDataArray3(ar3);
            seo.setDataMap2(hm2);
            seo.setDataArray2(ar2);
            seo.setHeads_cat("UNIVERSITY DUES");
            seo=rdb.retTransfer_fund(seo);
            seo.setHeads_cat(hd_cat);
            seo=(SchoolEO)mm.retHeadFee(seo);   
            mm.retFeeHeadwiseFromStud_feeDetais(seo);
            
            request.setAttribute("hd_cat",hd_cat);
            request.setAttribute("hd_categ","UNIVERSITY DUES");
        }
        
        request.setAttribute("jbean",seo);
        
//        out.print(seo.getDataMap2());
//        return mapping.findForward("");
        return mapping.findForward(SUCCESS);
       }      
    
       public ActionForward addSubAct(ActionMapping mapping,ActionForm form,
       HttpServletRequest request, HttpServletResponse response)
       throws Exception{
        PrintWriter out=response.getWriter();        
        MyMeth mm=new MyMeth();   
        
        String cls[]=(String[])request.getParameterValues("classes");
        String sub=request.getParameter("sub");     
        String prac=request.getParameter("prac");   
        try{
        ArrayList ar=new ArrayList();
        for(int i=0;i<cls.length;i++){
        ar.add(cls[i]);    
        }
        
        SchoolEO seo=new SchoolEO();                        
        seo.setDataArray(ar);
        seo.setSubject(sub);
        seo.setPractical(prac);
        
        int bn=mm.addSubData(seo);   
        if(bn==0){
        request.setAttribute("msg","Data Submitted");
        }else{
        request.setAttribute("msg","Data Already Exists");   
        }           
        request.setAttribute("jbean",seo);
        }catch(NullPointerException ne){}
        return mapping.findForward(SUCCESS);
       }
    
        public ActionForward addSub_Semester(ActionMapping mapping,ActionForm form,
       HttpServletRequest request, HttpServletResponse response)
       throws Exception{
        PrintWriter out=response.getWriter();        
        MyMeth mm=new MyMeth();   
        
         
        String degree=request.getParameter("degree");   
         String branch=request.getParameter("branch");   
       String semester=request.getParameter("duration");   
       String sub_code=request.getParameter("sub_code");   
       String sub_name=request.getParameter("sub_name");   
       String prac=request.getParameter("prac");   
      
        
        SchoolEO seo=new SchoolEO();                        
        seo.setDegree(degree);
        seo.setBranch(branch);
         seo.setSemester(semester);
         seo.setSub_code(sub_code);
        seo.setSub_name(sub_name);
        seo.setPrac(prac);
       
       
        
        int bn=mm.addSub_Semester(seo);   
        if(bn==0){
        request.setAttribute("msg","Data Submitted");
        }else{
        request.setAttribute("msg","Data Already Exists");   
        }           
        request.setAttribute("jbean",seo);
        
        return mapping.findForward(SUCCESS);
        
        
       
}
           public ActionForward retIdCardAct(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        PrintWriter out=response.getWriter();        
        MyMeth mm=new MyMeth();     
        String ssn=request.getParameter("ssn");
        String rn=request.getParameter("rn"); 
            
        SchoolEO seo=new SchoolEO(); 
        seo.setSession(ssn);
        seo.setRegistNo(rn);
                  
        try{
        seo=(SchoolEO)mm.retEnrolledData(seo);  
        }catch(NullPointerException ne){}      
        request.setAttribute("jbean",seo);
        return mapping.findForward(SUCCESS);
       }
    
         public ActionForward genIdCard(ActionMapping mapping,ActionForm form,
         HttpServletRequest request, HttpServletResponse response)
         throws Exception{
//        PrintWriter out=response.getWriter();        
        MyMeth mm=new MyMeth();     
        String ssn=request.getParameter("session");
        String rno=request.getParameter("regist_no"); 
        String sname=request.getParameter("sname"); 
        String clas=request.getParameter("classes"); 
        String type=request.getParameter("type"); 
        String gender=request.getParameter("gender"); 
        long frecpt=0;
        double feetot=0.0;
        try{
         feetot=Double.parseDouble(request.getParameter("feetotal")); 
         }catch(NumberFormatException ex){} 
         try{
         frecpt=Long.parseLong(request.getParameter("freceipt")); 
         }catch(NumberFormatException ex){} 
        
        SchoolEO seo=new SchoolEO(); 
        seo.setSession(ssn);
        seo.setRegistNo(rno);
        seo.setSname(sname);
        seo.setClasses(clas);
        seo.setType(type);
        seo.setGender(gender);
        seo.setFeeTotal(feetot);
        seo.setFeeReceipt(frecpt);
                
        int bn=0;
        if(feetot!=0.0){
        bn=mm.subEnrolledData(seo);  
        }else{
        bn=-2;    
        }
        try{  
        seo=(SchoolEO)mm.retFeeReceiptData(seo);  
        }catch(NullPointerException ne){}
        
        if(bn==0){
        request.setAttribute("msg","Data Submitted");
        }else{
        if(bn==-2){
        request.setAttribute("msg","No Fee to Submit");  
        }else{
        request.setAttribute("msg","Data Already Exists");   
        }
        }           
        request.setAttribute("jbean",seo);
        return mapping.findForward(SUCCESS);
       }
     
         public ActionForward retFeeReceiptAct(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
//        PrintWriter out=response.getWriter();        
        MyMeth mm=new MyMeth();     
        String ssn=request.getParameter("session");
        String regno=request.getParameter("regist_no");
        SchoolEO seo=new SchoolEO();   
        seo.setSession(ssn);
        seo.setRegistNo(regno);            
      
        seo=(SchoolEO)mm.retFeeReceiptData(seo);  
   
        if(seo.getFeeReceipt()==0){
        seo.setFeeReceipt(mm.genFeeReceiptNo());    
        }
        request.setAttribute("jbean",seo);
        return mapping.findForward(SUCCESS);
       }
         
      
         
         public ActionForward subStudentFee(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
       PrintWriter out=response.getWriter();        
        MyMeth mm=new MyMeth();     
        String ssn=request.getParameter("session");
        String regno=request.getParameter("regist_no");
        String sname=request.getParameter("sname");
        String fname=request.getParameter("fname");
        String type=request.getParameter("type");
        String sem=request.getParameter("classes");
        String gender=request.getParameter("gender");
        
         String degree=request.getParameter("degree");
        String branch=request.getParameter("branch");
        String l_date=request.getParameter("l_date");
        
        double feetotal=0.0;
        double fine=0.0;
        double sem_totfee=0.0;
        long fee_rcpt=0;
        double max_fine=0;
        try{
            if(request.getParameter("freceipt")!=null)
            {
                fee_rcpt=Long.parseLong(request.getParameter("freceipt").toString());
            }
            if(request.getParameter("feetotal")!=null)
            {
                feetotal=Double.parseDouble(request.getParameter("feetotal"));
            }
            if(request.getParameter("fine")!=null)
            {
                fine=Double.parseDouble(request.getParameter("fine"));
            }
            if(request.getParameter("sem_totfee")!=null)
            {
                sem_totfee=Double.parseDouble(request.getParameter("sem_totfee"));
            }
            if(request.getParameter("m_fine")!=null)
            {
                max_fine=Double.parseDouble(request.getParameter("m_fine"));
            }
        }
        catch(Exception ee){}
        
        ArrayList al=new ArrayList();
        double d[]= new double[4];
        double dd=0;
        try{
        for(int k=0;k<4;k++)
        {
         if(request.getParameter("fee"+Integer.toString(k))!=null)
         {
             d[k]=Double.parseDouble(request.getParameter("fee"+Integer.toString(k)));
             al.add(d[k]);
             dd=dd+(Double)al.get(k);
         }
        }
        }catch(Exception e){}
    
        SchoolEO seo=new SchoolEO();   
        seo.setSession(ssn);
        seo.setRegistNo(regno); 
        seo.setSname(sname);
        seo.setFname(fname);
        seo.setDegree(degree);
        seo.setBranch(branch);
        seo.setSemester(sem);
        seo.setGender(gender);
        seo.setFeeReceipt(fee_rcpt);
        seo.setFeeTotal(feetotal);
        seo.setFine(fine);
        seo.setTotalFee(sem_totfee);
        seo.setLastdate(l_date);
        seo.setMax_fine(max_fine);
        
        ArrayList ar1=new ArrayList();
        ArrayList ar2=new ArrayList();
        HashMap hm1=new HashMap();
        String param="";
        Enumeration en=(Enumeration)request.getParameterNames();
        while(en.hasMoreElements())
        {
            param=(String)en.nextElement();
            try{
                if(param.substring(0,2).equals("hd"))
                    ar1.add(param);
            }catch(StringIndexOutOfBoundsException e){}
        }
        for(int i=0;i<ar1.size();i++)
        {
             ar2.add(request.getParameter("hd_"+i));
            hm1.put(request.getParameter("hd_"+i),request.getParameter("fee"+i));
        }
  
        int cnt;
       int bn=0;
        if(feetotal!=0.0){
        bn=mm.subEnrolledData(seo);  
        }else{
        bn=-2;    
        }
        
        //cnt=mm.Submit_fee_data(seo, al);
        cnt=mm.Submit_stud_fee(seo, ar2, hm1);
//   
//        if(seo.getFeeReceipt()==0){
//        seo.setFeeReceipt(mm.genFeeReceiptNo());    
//        }
        //request.setAttribute("jbean",seo);
         SchoolEO seo1=new SchoolEO(); 
          SchoolEO seo2=new SchoolEO(); 
         if(cnt==0&&bn==0){
            try{
            seo2=mm.Get_Submit_fee_data(seo);
            }catch(NullPointerException ne){}
            
            request.setAttribute("jbean",seo2);
            request.setAttribute("msg","Fee Details Submitted. Please take a printout.");
        return mapping.findForward(SUCCESS);
        }
        else{
            try{  
        seo1=(SchoolEO)mm.retFeeReceiptData(seo);  
        }catch(NullPointerException ne){}
             request.setAttribute("jbean",seo1);
            request.setAttribute("msg","Fee Allready Submitted"); 
         return mapping.findForward("exist");
       }
   }
         
         public ActionForward getdetails(ActionMapping mapping, ActionForm form,
       HttpServletRequest request, HttpServletResponse response)
       throws Exception {
             MyMeth mm=new MyMeth(); 
              PrintWriter out=response.getWriter();
        String ssn=request.getParameter("session");
        String regno=request.getParameter("regist_no");
        SchoolEO seo=new SchoolEO();   
        seo.setSession(ssn);
        seo.setRegistNo(regno);            
             SchoolEO seo2=new SchoolEO(); 
             try{ 
            seo2=mm.Get_Submit_fee_data(seo);
            }catch(NullPointerException ne){}
             
             ArrayList dtal=seo2.getDataArray2();
             HashMap hmm=(HashMap)seo2.getDataMap();
            
            if(seo2.getCounter()!=0){
            request.setAttribute("jbean",seo2);
            request.setAttribute("msg","Please take a printout.");
              return mapping.findForward(SUCCESS);
            }
            else{
                request.setAttribute("msg","Please Submit The Fee To Generate The Fee Receipt.");
              return mapping.findForward(SUCCESS);
            }
         }
        
       public ActionForward defineConAct(ActionMapping mapping, ActionForm form,
       HttpServletRequest request, HttpServletResponse response)
       throws Exception {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String ssn=(String)request.getParameter("session");           
        return mapping.findForward(SUCCESS);    
       }      
       
        public ActionForward dataByEnrolNo(ActionMapping mapping,ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception{
        MyMeth mm=new MyMeth();     
        String enr=request.getParameter("adminno"); 
        CcBean cb=new CcBean();
        cb.setAdminNo(enr);
        cb=(CcBean)mm.studCcData(cb);         
        request.setAttribute("jbean",cb);
        return mapping.findForward(SUCCESS);
       } 
        
        public ActionForward tcDataByEnrolNo(ActionMapping mapping,ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception{
        MyMeth mm=new MyMeth();     
        String enr=request.getParameter("adminno"); 
        TcBean tb=new TcBean();
        tb.setAdminNo(enr);
        tb=(TcBean)mm.studTcData(tb);         
        request.setAttribute("jbean",tb);
        return mapping.findForward(SUCCESS);
       } 
        
        public ActionForward addCounterAct(ActionMapping mapping,ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception{
        MyMeth mm=new MyMeth();     
        String enr=request.getParameter("eno");
        TcBean tb=new TcBean();
        tb.setAdminNo(enr);
        tb=(TcBean)mm.studTcData(tb);
        if(!tb.getAdminNo().equals("") && !tb.getName().equals("")){
        int count=mm.addCounterData(tb); 
        }        
        
        request.setAttribute("jbean",tb);
        return mapping.findForward(SUCCESS);
       } 
        
             public ActionForward retClassSubAct(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
//        PrintWriter out=response.getWriter();        
        MyMeth mm=new MyMeth();     
        String cls=request.getParameter("classes");   
        SchoolEO seo=new SchoolEO();   
        seo.setClasses(cls);
         
        ArrayList ar=(ArrayList)mm.retClassSubData(seo);  
   
        request.setAttribute("arr",ar);
        request.setAttribute("seo",seo);
        return mapping.findForward(SUCCESS);
       }
 
   public ActionForward retCounsDetail(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        PrintWriter out=response.getWriter();        
        MyMeth mm=new MyMeth();     
        ArrayList al=new ArrayList();
        String session=request.getParameter("session");
        String session_sem=request.getParameter("session_sem");
        String regno=request.getParameter("regist_no");
        SchoolEO seo=new SchoolEO();   
        SchoolEO seo1=new SchoolEO();  
        SchoolEO seo2=new SchoolEO();  
        seo.setSession(session);
        seo.setSession_sem(session_sem);
        seo.setRegistNo(regno);
        long rcpt_no=0;
      
        seo1=(SchoolEO)mm.retstudData(seo);
        seo1.setSession_sem(session_sem);
        if(!seo1.getSname().equals("")){
//        out.println(seo.getRegistNo());
        al=(ArrayList)mm.retCounsFee(seo);
        rcpt_no=mm.genReceiptNo();
//        out.println(seo.getSession());
//        out.println(al);
        request.setAttribute("jbean",seo1);
        request.setAttribute("list",al);
        request.setAttribute("rcno", Long.toString(rcpt_no));
        request.setAttribute("chk","chk");
        }
        else{
            request.setAttribute("msg1","Student record is not found.");
        }
        return mapping.findForward(SUCCESS);
//        return mapping.findForward("");
       }  
   
   public ActionForward entCounsFee(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        PrintWriter out=response.getWriter();    
        ArrayList al=new ArrayList();
        MyMeth mm=new MyMeth();     
        String session="";
        String session_sem="";
        String regno="";
        String bnkname="";
        String bnkbranch="";
        String ddno="";
        String sname="";
        String fname="";
        String dob="";
        String gender="";
        double ddamnt=0;
        String dddate="";
        long rcptno=0;
        
        
        if(request.getParameter("session")!=null)
        {
            session=(String)request.getParameter("session");
        }
        if(request.getParameter("session_sem")!=null)
        {
            session_sem=(String)request.getParameter("session_sem");
        }
        if(request.getParameter("regist_no")!=null)
        {
            regno=(String)request.getParameter("regist_no");
        }
       
        if(request.getParameter("sname")!=null)
        {
            sname=(String)request.getParameter("sname");
        }
        if(request.getParameter("fname")!=null)
        {
            fname=(String)request.getParameter("fname");
        }
        if(request.getParameter("dob")!=null)
        {
            dob=(String)request.getParameter("dob");
        }
        if(request.getParameter("gender")!=null)
        {
            gender=(String)request.getParameter("gender");
        }
        try{
        if(request.getParameter("rcptno")!=null)
        {
            rcptno=Long.parseLong(request.getParameter("rcptno").toString());
        }
        }catch(Exception e){}
        
        String batch=session.substring(0, session.indexOf("-"));
        SchoolEO seo=new SchoolEO();
         SchoolEO seo1=new SchoolEO();
         SchoolEO seo2=new SchoolEO();
         int n=0;
        seo.setSession(session);
        seo.setSession_sem(session_sem);
        seo.setRegistNo(regno);
        seo.setSname(sname);
        seo.setFname(fname);
        seo.setDob(dob);
        seo.setFeeReceipt(rcptno);
        seo.setGender(gender);
        seo.setBatch(batch);
        
        ArrayList ar=new ArrayList();
        ArrayList ar1=new ArrayList();
        ArrayList ar2=new ArrayList();
        ArrayList ar3=new ArrayList();
        
        int k=0;
        double am=0.0;
     for(int i=0;i<2;i++)
        {
            k=i+1;
            
             ar.add(request.getParameter("dd_"+k));
             ar1.add(request.getParameter("dddate_"+k));
             ar2.add(request.getParameter("bnk_"+k));
             try{
                 if(request.getParameter("damnt_"+k)!=null&&!request.getParameter("damnt_"+k).equals(""))
                 {
                     try{
                    ar3.add(Double.parseDouble(request.getParameter("damnt_"+k).toString())); 
                     }
                     catch(Exception ee)
                     {
                         long rcpt_no=0;
                        seo2=(SchoolEO)mm.retstudData(seo);
//        out.println(seo.getRegistNo());
                    
                    rcpt_no=mm.genReceiptNo();
                    al=(ArrayList)mm.retCounsFee(seo);
                    request.setAttribute("list",al);
                         request.setAttribute("jbean",seo2);
                         request.setAttribute("rcno", Long.toString(rcpt_no));
                         request.setAttribute("chk","chk");
                         request.setAttribute("msg1", "Wrong amount entered. please do not enter any character as amount");
                          return mapping.findForward("error"); 
                     }
                 }
                 else
                 {
                     ar3.add(am);
                 }
                 
             }catch(Exception e){e.getMessage();
             ar3.add(am);
             }
         }
        seo.setDataArray(ar);
        seo.setDataArray1(ar1);
        seo.setDataArray2(ar2);
        seo.setDataArray3(ar3);
        
      String dd_no=mm.checkDraftNumInTable("stud_draft", seo);  
      if(!dd_no.equals("")){
            long rcpt_no=0;
            seo2=(SchoolEO)mm.retstudData(seo);
            rcpt_no=mm.genReceiptNo();
            al=(ArrayList)mm.retCounsFee(seo);
            request.setAttribute("list",al);
            request.setAttribute("jbean",seo2);
            request.setAttribute("rcno", Long.toString(rcpt_no));
            request.setAttribute("chk","chk");
            request.setAttribute("msg1", "Advance amount can not be submitted. Duplicate DD number : "+dd_no);
            return mapping.findForward("error"); 
      }else{
            java.util.Date depoDate = new java.util.Date();
            java.sql.Date depositeDate = new java.sql.Date(depoDate.getTime());
   
            n=mm.entryCounFee(seo, depositeDate);
//        if(n==1)
//        {
//            request.setAttribute("msg", "counselling fee allready received!");
//        }
//        else
//        {
          request.setAttribute("msg", "counselling fee submitted!");  
//        }
        seo1=(SchoolEO)mm.retstudData(seo);
        al=(ArrayList)mm.retCounsFee(seo);
        
        request.setAttribute("jbean",seo1);
        request.setAttribute("list",al);
      }   
        request.setAttribute("chk","chk");
        return mapping.findForward(SUCCESS);
//        return mapping.findForward("");
       }
   
   
  public ActionForward refCounsFee(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
       PrintWriter out=response.getWriter();        
        MyMeth mm=new MyMeth();
        ArrayList al=new ArrayList();
        String session=request.getParameter("session");
        String session_sem=request.getParameter("session_sem");
        String srnum=request.getParameter("srnum");
        String sname=request.getParameter("sname");
        SchoolEO seo=new SchoolEO();   
        SchoolEO seo1=new SchoolEO();  
        
        seo.setSession(session);
        seo.setSession_sem(session_sem);
        seo.setRegistNo(srnum);
        seo.setSname(sname);
        
        long return_no=0;
      
        return_no=mm.refundAmount(seo);
        seo1=(SchoolEO)mm.retstudData(seo);
        al=(ArrayList)mm.retRefundedFeeDetail(seo);
//        out.println("size: "+al.size());
        seo1.setSession_sem(session_sem);
        request.setAttribute("jbean",seo1);
        request.setAttribute("list",al);
        request.setAttribute("rtn",Long.toString(return_no));
        request.setAttribute("chk","chk");
        if(return_no==0){
             request.setAttribute("msg","Counselling Fee Already Refunded");
             return mapping.findForward("failure");
        }
        else{
             return mapping.findForward(SUCCESS);
        }
//         return mapping.findForward("");
       }
    public ActionForward retCounsFeeRc(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
       PrintWriter out=response.getWriter();        
        MyMeth mm=new MyMeth();
        ArrayList al=new ArrayList();
        String session=request.getParameter("session");
        String session_sem=request.getParameter("session_sem");
        String srnum=request.getParameter("srnum");
        String sname=request.getParameter("sname");
        SchoolEO seo=new SchoolEO();   
        SchoolEO seo1=new SchoolEO();  
        SchoolEO seo2=new SchoolEO();  
        seo.setSession(session);
        seo.setSession_sem(session_sem);
        seo.setRegistNo(srnum);
        seo.setSname(sname);
        
       
       UpdateFee upd=new UpdateFee();
       seo1=(SchoolEO)mm.retstudData(seo);
       if(!seo1.getSname().equals("")){
       int n=0;
        n=upd.chkAdvDraft(seo);
       //out.println("count: "+n);
     if(n!=0){
        al=(ArrayList)mm.retCounsFee(seo);
//      out.println("size: "+al.size());
        request.setAttribute("jbean",seo1);
        request.setAttribute("list",al);
            
        }
        else
        {
            request.setAttribute("msg", "Draft Record is not found in the session "+seo.getSession()+"-"+seo.getSession_sem()+
                    " for roll no. "+seo.getRegistNo());
        }
       }
       else{
           request.setAttribute("msg", "Student record is not found.");
       }
      request.setAttribute("edit", "edit");
        request.setAttribute("chk","chk");
        
             return mapping.findForward(SUCCESS);
//         return mapping.findForward("");
       }
  
  public ActionForward fund_transfer(ActionMapping mapping,ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception{
        PrintWriter out=response.getWriter();        
        MyMeth mm=new MyMeth();    
        Reports_DB rdb=new Reports_DB();
        String ssn=request.getParameter("session");
        
        String hd_cat=request.getParameter("heads_cat"); 
        String ssn_sem=request.getParameter("session_sem"); 
        
        String head="ALL";
            
        SchoolEO seo=new SchoolEO(); 
        seo.setSession(ssn);
        seo.setHeads(head);  
        
        seo.setSession_sem(ssn_sem);
        seo.setHeads_cat(hd_cat);
        try{
            double am=Double.parseDouble(request.getParameter("amount"));
            seo.setTransfered_fund(am);
        }catch(Exception e){}
        
        if(!hd_cat.equals("MEDICALAIM PREMIUM"))
        {
            rdb.transfer_fund(seo);
            seo=mm.retFieldnameOfFeeHeads(seo);
            seo=rdb.retTransfer_fund(seo);
            seo=(SchoolEO)mm.retHeadFee(seo);   
            mm.retFeeHeadwiseFromStud_feeDetais(seo);
            
            request.setAttribute("hd_cat",hd_cat);
        }
        else{
            seo.setHeads("MEDICALAIM PREMIUM");
            seo.setHeads_cat("UNIVERSITY DUES");
            
            rdb.transfer_fund(seo);
            
            ArrayList al=new ArrayList();
            HashMap hm=new HashMap();
            al.add("field30");
            hm.put("field30", hd_cat);
            seo.setDataArray(al);
            seo.setDataMap(hm);
            
            ArrayList ar2=new ArrayList();
            ArrayList ar3=new ArrayList();
            HashMap hm2=new HashMap();
            ar3.add("MEDICALAIM PREMIUM");
            hm2.put("MEDICALAIM PREMIUM", "UNIVERSITY DUES");
            ar2.add("UNIVERSITY DUES");
            
            seo.setDataArray3(ar3);
            seo.setDataMap2(hm2);
            seo.setDataArray2(ar2);
            
            seo=rdb.retTransfer_fund(seo);
            seo.setHeads_cat(hd_cat);
            seo=(SchoolEO)mm.retHeadFee(seo);   
            mm.retFeeHeadwiseFromStud_feeDetais(seo);
            
            
            request.setAttribute("hd_cat",hd_cat);
            request.setAttribute("hd_categ","UNIVERSITY DUES");
        }
        request.setAttribute("jbean",seo);
        
//        out.print(seo.getDataMap2());
//        return mapping.findForward("");
        return mapping.findForward(SUCCESS);
       }      
             
}