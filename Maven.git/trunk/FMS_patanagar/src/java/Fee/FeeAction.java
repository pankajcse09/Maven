/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fee;

import ActionClass.DataObj;
import ActionClass.MyMeth;
import EO.SchoolEO;
import Reports.Reports_DB;
import Reports.ToDB;
import User_Role.User_role_bean;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.myapp.struts.Dataconnectivity;
import com.myapp.struts.Degree;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.upload.FormFile;

/**
 *
 * @author kapil
 */
public class FeeAction extends DispatchAction {
private static Logger logger=Logger.getLogger(FeeAction.class.getName());
    /* forward name="success" path="" */
    private final static String SUCCESS = "success";

    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction1, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     */
public ActionForward retFeeDetail(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession htsession=request.getSession(false);
        if(htsession.getAttribute("loginid") ==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
        }
        FeeMath fm=new FeeMath();
         ArrayList DegreeList=new ArrayList();
         MyMeth fun=new MyMeth();
        Degree dg=new Degree();
        String session=request.getParameter("session");
        String session_sem=request.getParameter("session_sem");
        String regno=request.getParameter("regist_no");
        String deg=request.getParameter("degree");
        SchoolEO seo=new SchoolEO();   
        SchoolEO seo1=new SchoolEO();   
        MyMeth mm=new MyMeth();
        seo.setSession(session);
        seo.setSession_sem(session_sem);
        seo.setRegistNo(regno);  
        seo.setDegree(deg);
      seo1=(SchoolEO)mm.retstudData(seo);
        if(!seo1.getSname().equals("")){
        seo=(SchoolEO)fm.retFeeRecData(seo); 
        
//        if(seo.getDataArray5().size()==0&&seo.getDataArray7().size()==0)
//{
//    request.setAttribute("message","Counselling Fee is not submitted");
//}
   
        if(seo.getFeeReceipt()==0){
        seo.setFeeReceipt(fm.genFeeRecptNo());    
        }
        request.setAttribute("jbean",seo);
       }
        else{
            request.setAttribute("msg","Student record is not found.");
        }
        DegreeList=(ArrayList)fun.Degree_list();
        request.setAttribute("degreelist",DegreeList); 
        return mapping.findForward(SUCCESS);
    }
    
public ActionForward retChangeFeeDetail(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession htsession=request.getSession(false);
        if(htsession.getAttribute("loginid") ==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
        }
        FeeMath fm=new FeeMath();
         ArrayList DegreeList=new ArrayList();
         MyMeth fun=new MyMeth();
        Degree dg=new Degree();
        String session=request.getParameter("session");
        String session_sem=request.getParameter("session_sem");
        String regno=request.getParameter("regist_no");
        String deg=request.getParameter("degree");
        String stud_type=request.getParameter("stud_type");
        SchoolEO seo=new SchoolEO();   
        seo.setSession(session);
        seo.setSession_sem(session_sem);
        seo.setRegistNo(regno);  
        seo.setDegree(deg);
        seo.setStud_type(stud_type);
      
        seo=(SchoolEO)fm.retChangeFeeRecData(seo);  
   
        if(seo.getFeeReceipt()==0){
        seo.setFeeReceipt(fm.genFeeRecptNo());    
        }
         DegreeList=(ArrayList)fun.Degree_list();
        
         request.setAttribute("degreelist",DegreeList); 
        request.setAttribute("jbean",seo);
        return mapping.findForward(SUCCESS);
      
    }
    
public ActionForward subStudentFeeData(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession htsession=request.getSession(false);
        if(htsession.getAttribute("loginid") ==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
        }
       PrintWriter out=response.getWriter();        
        FeeMath fm=new FeeMath();  
        ArrayList DegreeList=new ArrayList();
         MyMeth fun=new MyMeth();
        String session=request.getParameter("session");
        String session_sem=request.getParameter("session_sem");
        String regno=request.getParameter("regist_no");
        String sname=request.getParameter("sname");
        String fname=request.getParameter("fname");
        String type=request.getParameter("type");
//        String sem=request.getParameter("classes");
        String sem=request.getParameter("semester");
        String gender=request.getParameter("gender");
        String stud_type=request.getParameter("stud_type");
         String degree=request.getParameter("degree");
        String branch=request.getParameter("branch");
        String l_date=request.getParameter("l_date");
        String fee_rcpt=request.getParameter("fee_rcpt");
        String icar=request.getParameter("icar");
        String gate=request.getParameter("gate");
        String college=request.getParameter("college");
        
        String batch=session.substring(0, session.indexOf("-"));
            
        int size=0;
        long fee_rc=0;
        
        try{
            fee_rc=Long.parseLong(fee_rcpt);
        }catch(Exception e){}
       
        
        ArrayList al=new ArrayList();
        double d[]= new double[4];
        double dd=0;
        try{
       
         if(request.getParameter("sz")!=null)
         {
            size=Integer.parseInt(request.getParameter("sz").toString());
         }
        
        }catch(Exception e){}
    
        SchoolEO seo=new SchoolEO();   
        SchoolEO seo2=new SchoolEO();
        
        seo.setSession(session);
        seo.setSession_sem(session_sem);
        seo.setRegistNo(regno); 
        seo.setSname(sname);
        seo.setFname(fname);
        seo.setDegree(degree);
        seo.setBranch(branch);
        seo.setSemester(sem);
        seo.setGender(gender);
        seo.setFeeReceipt(fee_rc);
        seo.setLastdate(l_date);
        seo.setStud_type(stud_type);
        seo.setIcar(icar);
        seo.setGate(gate);
        seo.setBatch(batch);
        seo.setCollege(college);
        
        ArrayList ar=new ArrayList();
        ArrayList ar1=new ArrayList();
        ArrayList ar2=new ArrayList();
        ArrayList ar3=new ArrayList();
        ArrayList ar4=new ArrayList();
        ArrayList ar5=new ArrayList();
        HashMap hm1=new HashMap();
        String param="";
        
       
        double am=0.0;
        double fee_total=0.0;
        double adv=0.0;
        double icar_am=0.0;
        int l=0;
        try{
           for(int i=0;i<size;i++)
             {
            l=l+1;
            ar.add(request.getParameter("dd"+l));
             ar1.add(request.getParameter("dddate"+l));
             ar2.add(request.getParameter("bnk"+l));
             ar4.add(request.getParameter("feeType"+l));
             ar5.add(request.getParameter("rowid"+l));
             try{
                 if(request.getParameter("damnt"+l)!=null&&!request.getParameter("damnt"+l).equals(""))
                 {
                    ar3.add(Double.parseDouble(request.getParameter("damnt"+l).toString())); 
                 }
                 else
                 {
                     ar3.add(am);
                 }
                 
             }catch(Exception e){e.getMessage();
             ar3.add(am);
             }
         }
             
           
            if(request.getParameter("fee_total")!=null&&!request.getParameter("fee_total").equals(""))
            {
                fee_total=Double.parseDouble(request.getParameter("fee_total").toString());
//                seo.setFeeTotal(fee_total);
            }
        }catch(NumberFormatException e){e.getMessage();}
        
        try{
            if(request.getParameter("adv")!=null&&!request.getParameter("adv").equals(""))
            {
                adv=Double.parseDouble(request.getParameter("adv").toString());
            }
            if(request.getParameter("icar_am")!=null&&!request.getParameter("icar_am").equals(""))
            {
                icar_am=Double.parseDouble(request.getParameter("icar_am").toString());
            }
        }catch(NumberFormatException e){e.getMessage();}
        adv=adv+icar_am;
        seo.setAdvance(adv);
        
        int k=0;
        double sum_fee_draft=0;
        double fee_draft=0;
        for(int i=0;i<3;i++)
        {
            k=i+2;
            if(request.getParameter("dd_"+k)!=null&&!request.getParameter("dd_"+k).equals(""))
            {
             ar.add(request.getParameter("dd_"+k));
             ar1.add(request.getParameter("dddate_"+k));
             ar2.add(request.getParameter("bnk_"+k));
             ar4.add(request.getParameter("feeType_"+k));
             ar5.add(request.getParameter("rowid_"+k));
             try{
                 if(request.getParameter("damnt_"+k)!=null&&!request.getParameter("damnt_"+k).equals(""))
                 {
                     try{
                         fee_draft=Double.parseDouble(request.getParameter("damnt_"+k));
                    ar3.add(fee_draft); 
                    sum_fee_draft=sum_fee_draft+fee_draft;
                     }catch(Exception ee)
                     {
                      try{  
                            seo2=(SchoolEO)fm.retFeeRecData(seo);  
                            }catch(NullPointerException ne){}
            
                            DegreeList=(ArrayList)fun.Degree_list();
        
                            request.setAttribute("degreelist",DegreeList); 
                            request.setAttribute("jbean",seo2);
                            request.setAttribute("msg","wrong amount entered. Please do not enter any character as amount"); 
                            return mapping.findForward("exist");}
                 }
                 else
                 {
                     ar3.add(am);
                 }
                 
             }catch(Exception e){
             ar3.add(am);
             }
            }
            
            
//             out.print(" ,one:- "+ar.size());
//            out.print(" ,one:- "+ar.get(i));
//                out.print(" ,two:- "+ar1.get(i));
//                out.print(" ,three:- "+ar2.get(i));
//                out.print(" ,four:- "+ar3.get(i));
//                out.print(" ,five:- "+ar4.get(i));
//                out.print(" ,six:- "+ar5.get(i));
//                out.print("<br>");
        }
        
        
        seo.setAdjustment(sum_fee_draft-fee_total);
        fee_total=fee_total+adv;
        seo.setFeeTotal(fee_total);
        seo.setDataArray(ar);
        seo.setDataArray1(ar1);
        seo.setDataArray2(ar2);
        seo.setDataArray3(ar3);
        seo.setDataArray4(ar4);
        seo.setDataArray5(ar5);
        
        MyMeth mm=new MyMeth();
        SchoolEO seo1=new SchoolEO(); 
          
       

       java.util.Date depoDate = new java.util.Date();
       java.sql.Date depositeDate = new java.sql.Date(depoDate.getTime());
        
       int bn=0;
       Connection con=null;
        try{
            Dataconnectivity dc=new Dataconnectivity();
            con=(Connection)dc.Dataconnect();
            con.setAutoCommit(false);
        }catch(Exception e){} 
       try{
            if(fee_total!=0.0){
                bn=fm.subEnrolledData(seo,depositeDate,con);
            }else{
                bn=-2;    
            }        
//       out.println(bn);
         if(bn==0){
             String dd_no=mm.checkDraftNumInTable("stud_fee_draft", seo);  
                if(!dd_no.equals("")){
                     try{  
                         seo2=(SchoolEO)fm.retFeeRecData(seo);  
                     }catch(NullPointerException ne){}
                     DegreeList=(ArrayList)fun.Degree_list();
                     request.setAttribute("degreelist",DegreeList); 
                     request.setAttribute("jbean",seo2);
                     request.setAttribute("msg", "Fee can not be submitted. Duplicate DD number : "+dd_no);
                     return mapping.findForward("exist");
                }
             SchoolEO se=fm.retFeeHeadwiseFromStruc(seo);
             fm.subFeeHeadwise(seo, se,con);
            DegreeList=(ArrayList)fun.Degree_list();
            request.setAttribute("degreelist",DegreeList); 
            con.commit();
            con.close();
            try{
                seo1=fm.retFeeRecData(seo);
                al=fm.getStudentFeeDetail(seo);
            }catch(NullPointerException ne){}
            request.setAttribute("list", al);
            request.setAttribute("jbean",seo1);
            request.setAttribute("msg","Fee Details Submitted. Please take a printout.");
            logger.log(Level.INFO, "first year fee submitted using fee draft of "+seo.getRegistNo());
            return mapping.findForward(SUCCESS);
//         return mapping.findForward("");
        }
         else if(bn==-1){
             try{  
                    seo2=(SchoolEO)fm.retFeeRecData(seo);  
                }catch(NullPointerException ne){}
            DegreeList=(ArrayList)fun.Degree_list();
            request.setAttribute("degreelist",DegreeList); 
            request.setAttribute("jbean",seo2);
            request.setAttribute("msg","Some error occured"); 
            con.rollback();
            logger.log(Level.SEVERE, "Connection Rollback in enrolling from subEnrolledData method for "+seo.getRegistNo());
            return mapping.findForward("exist");
         }
        else{
            try{  
                seo2=(SchoolEO)fm.retFeeRecData(seo);  
            }catch(NullPointerException ne){}
            DegreeList=(ArrayList)fun.Degree_list();
            request.setAttribute("degreelist",DegreeList); 
            request.setAttribute("jbean",seo2);
            request.setAttribute("msg","Fee Allready Submitted"); 
            return mapping.findForward("exist");
       }
       }catch(Exception e){ 
           try{  
                seo2=(SchoolEO)fm.retFeeRecData(seo);  
            }catch(NullPointerException ne){}
            DegreeList=(ArrayList)fun.Degree_list();
            request.setAttribute("degreelist",DegreeList); 
            request.setAttribute("jbean",seo2);
            request.setAttribute("msg","Some Error Occured");
            con.rollback();
            logger.log(Level.SEVERE, "Connection Rollback in submiting fee of "+seo.getRegistNo(),e);
            return mapping.findForward("exist");
//          return mapping.findForward("");
       }
//        return mapping.findForward("");
    }    

public ActionForward retFeeData(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
     HttpSession htsession=request.getSession(false);
        if(htsession.getAttribute("loginid") ==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
        }   
        PrintWriter out=response.getWriter();        
        MyMeth mm=new MyMeth();
        ArrayList al=new ArrayList();
        ArrayList al1=new ArrayList();
        String ssn=request.getParameter("session");
        String srnum=request.getParameter("regist_no");
        
        SchoolEO seo=new SchoolEO();   
        SchoolEO seo1=new SchoolEO();  
        SchoolEO seo2=new SchoolEO();  
        seo.setSession(ssn);
        seo.setRegistNo(srnum);
        seo.setSrnum(srnum);
        
        
        UpdateFee upd=new UpdateFee();
         DataObj dob=new DataObj();
 ArrayList bnklist=new ArrayList();

   seo1=(SchoolEO)mm.retstudData(seo);
        al=(ArrayList)mm.retCounsFee(seo);
      al1=(ArrayList)upd.getStudProgDraft(seo);
       bnklist=dob.retBankName();
//      System.out.println("hiiiiHeloo11 "+al.size());
    
          request.setAttribute("list",al);
        request.setAttribute("jbean",seo1);
        request.setAttribute("bnklist",bnklist);
        request.setAttribute("list1",al1);
        request.setAttribute("edit","edit");
        return mapping.findForward(SUCCESS);
      
    }

 public ActionForward updStudentFeeRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
      HttpSession htsession=request.getSession(false);
        if(htsession.getAttribute("loginid") ==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
        }  
       PrintWriter out=response.getWriter();        
        FeeMath fm=new FeeMath();  
        ArrayList DegreeList=new ArrayList();
         MyMeth fun=new MyMeth();
          MyMeth mm=new MyMeth();
        String ssn=request.getParameter("session");
        String regno=request.getParameter("regist_no");
         String sname=request.getParameter("sname");
        String fee_rcpt=request.getParameter("fee_rcpt");
        String stud_id=request.getParameter("stud_id");
        int size=0;
        long fee_rc=0;
        
        try{
            fee_rc=Long.parseLong(fee_rcpt);
        }catch(Exception e){}
       
        
        ArrayList al=new ArrayList();
        ArrayList al1=new ArrayList();
        SchoolEO seo=new SchoolEO(); 
        SchoolEO seo1=new SchoolEO();   
        seo.setSession(ssn);
        seo.setRegistNo(regno); 
        seo.setSrnum(regno);
        seo.setSname(sname);
        seo.setFeeReceipt(fee_rc);
        seo.setStud_id(stud_id);
        
//        out.print(" ,two:- "+seo.getSession());
//                out.print(" ,three:- "+seo.getRegistNo());
//                out.print(" ,three:- "+seo.getSrnum());
//                out.print(" ,four:- "+seo.getSname());
//                out.print(" ,five:- "+seo.getFeeReceipt());
//                out.print(" ,six:- "+seo.getStud_id());
        
        ArrayList ar=new ArrayList();
        ArrayList ar1=new ArrayList();
        ArrayList ar2=new ArrayList();
        ArrayList ar3=new ArrayList();
        ArrayList ar4=new ArrayList();
        ArrayList ar5=new ArrayList();
        HashMap hm1=new HashMap();
        String param="";
        double am=0.0;
        double fee_total=0.0;
        
       int k=0;
                for(int i=0;i<3;i++)
        {
            k=i+2;
          if(request.getParameter("dd_"+k)!=null&&!request.getParameter("dd_"+k).equals(""))
            {
             ar.add(request.getParameter("dd_"+k));
             ar1.add(request.getParameter("dddate_"+k));
             ar2.add(request.getParameter("bnk_"+k));
             ar4.add(request.getParameter("feeType_"+k));
             ar5.add(request.getParameter("rowid_"+k));
             try{
                 if(request.getParameter("damnt_"+k)!=null&&!request.getParameter("damnt_"+k).equals(""))
                 {
                     try{
                         fee_total=fee_total+Double.parseDouble(request.getParameter("damnt_"+k).toString());
                    ar3.add(Double.parseDouble(request.getParameter("damnt_"+k).toString())); 
                     }catch(Exception ee)
                     {
                         DegreeList=(ArrayList)fun.Degree_list();
        
         request.setAttribute("degreelist",DegreeList); 
                         request.setAttribute("msg","wrong amount entered. Please do not enter any character as amount"); 
                            return mapping.findForward("exist");}
                 }
                 else
                 {
                     ar3.add(am);
                 }
                 
             }catch(Exception e){
             ar3.add(am);
             }
             
//             out.print(" ,one:- "+ar.size());
//            out.print(" ,one:- "+ar.get(i));
//                out.print(" ,two:- "+ar1.get(i));
//                out.print(" ,three:- "+ar2.get(i));
//                out.print(" ,four:- "+ar3.get(i));
//                out.print(" ,five:- "+ar4.get(i));
//                out.print(" ,six:- "+ar5.get(i));
//                out.print("<br>");
            }

        }

        seo.setDataArray(ar);
        seo.setDataArray1(ar1);
        seo.setDataArray2(ar2);
        seo.setDataArray3(ar3);
        seo.setDataArray4(ar4);
        seo.setDataArray5(ar5);
        
java.util.Date depoDate = new java.util.Date();
java.sql.Date depositeDate = new java.sql.Date(depoDate.getTime());
        
UpdateFee upd=new UpdateFee();
upd.insertProgDraft(seo, depositeDate, fee_total);



         DataObj dob=new DataObj();
 ArrayList bnklist=new ArrayList();

   seo1=(SchoolEO)mm.retstudData(seo);
        al=(ArrayList)mm.retCounsFee(seo);
      al1=(ArrayList)upd.getStudProgDraft(seo);
       bnklist=dob.retBankName();
//      System.out.println("hiiiiHeloo11 "+al.size());
    
          request.setAttribute("list",al);
        request.setAttribute("jbean",seo1);
        request.setAttribute("bnklist",bnklist);
        request.setAttribute("list1",al1);
        request.setAttribute("edit","done");
        request.setAttribute("msg","All changes are successfuly made.");
        return mapping.findForward(SUCCESS);
       
//        return mapping.findForward("");
    }
    
public ActionForward submit_food_b(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
       HttpSession htsession=request.getSession(false);
        if(htsession.getAttribute("loginid") ==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
        }
        String session=request.getParameter("session");
        String month=request.getParameter("month");
        String stud_id=request.getParameter("stud_id");
        String dobill=request.getParameter("date1");
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        SchoolEO seo=new SchoolEO();
        seo.setSession(session);
        seo.setMonth(month);
        seo.setStud_id(stud_id);
        seo.setDate(sdf.parse(dobill));
        FeeMath fm=new FeeMath();
        int cn=fm.checkStudentFdBillOnMonth(seo);
        if(cn==0){
        double famount=0.0;
        try{
            if(request.getParameter("famount")!=null)
            {
                famount=Double.parseDouble(request.getParameter("famount"));
            }
        }catch(NumberFormatException e)
        {
            request.setAttribute("jbean", seo);
            request.setAttribute("msg", "Please enter amount as numeric value.");
            return mapping.findForward(SUCCESS);
        }
        seo.setMonthlyFood(famount);
        SchoolEO seo1=fm.getStudentDetails(seo);
        if(!seo1.getSname().equals("")){
            seo.setBatch(seo1.getBatch());
            fm.subMonthlyFoodAmount(seo);
            request.setAttribute("msg", "Food amount "+seo.getMonthlyFood()+" is stored for the month "+seo.getMonth()+".");
        }
        else{
            request.setAttribute("msg", "Student record is not found.");
        }
        request.setAttribute("jbean", seo);
        }
        else{
           request.setAttribute("msg", "Student food bill is already present for the month "+seo.getMonth()); 
        }
        return mapping.findForward(SUCCESS);
    }

public ActionForward retSubmited_food_b(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
      HttpSession htsession=request.getSession(false);
        if(htsession.getAttribute("loginid") ==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
        }  
        String session=request.getParameter("session");
        String month=request.getParameter("month");
        String stud_id=request.getParameter("stud_id");
        
        SchoolEO seo=new SchoolEO();
        SchoolEO seo2=new SchoolEO();
        seo.setSession(session);
        seo.setMonth(month);
        seo.setStud_id(stud_id);
        
        FeeMath fm=new FeeMath();
        int cn=fm.checkStudentFdBillOnMonth(seo);
        if(cn!=0){
        SchoolEO seo1=fm.getStudentDetails(seo);
        if(!seo1.getSname().equals("")){
            seo.setBatch(seo1.getBatch());
            seo2=fm.retMonthlyFoodBillForEditing(seo);
        }
        else{
            request.setAttribute("msg", "Student record is not found.");
        }
        request.setAttribute("jbean", seo2);
        }
        else{
           request.setAttribute("msg", "Student food bill is not present for the student id "+seo.getStud_id()+" and the month "+seo.getMonth()); 
        }
        return mapping.findForward(SUCCESS);
    }

public ActionForward updateSubmited_food_b(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
      HttpSession htsession=request.getSession(false);
        if(htsession.getAttribute("loginid") ==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
        }  
        String session=request.getParameter("session");
        String month=request.getParameter("month");
        String stud_id=request.getParameter("stud_id");
        String dobill=request.getParameter("date1");
        String rid=request.getParameter("rid");
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        SchoolEO seo=new SchoolEO();
        SchoolEO seo2=new SchoolEO();
        seo.setSession(session);
        seo.setMonth(month);
        seo.setStud_id(stud_id);
        seo.setRwid(Long.parseLong(rid));
        FeeMath fm=new FeeMath();
        try{
        seo.setDate(sdf.parse(dobill));
        }catch(Exception e){
            seo2=fm.retMonthlyFoodBillForEditing(seo);
            request.setAttribute("msg", "Please enter date in the dd/mm/yyyy format only.");
            request.setAttribute("jbean", seo2);
            return mapping.findForward(SUCCESS);
        }
        
        int cn=fm.checkStudentFdBillOnMonth(seo);
        if(cn!=0){
        double famount=0.0;
        try{
            if(request.getParameter("famount")!=null)
            {
                famount=Double.parseDouble(request.getParameter("famount"));
            }
        }catch(NumberFormatException e)
        {
            seo2=fm.retMonthlyFoodBillForEditing(seo);
            request.setAttribute("jbean", seo2);
            request.setAttribute("msg", "Please enter amount as numeric value.");
            return mapping.findForward(SUCCESS);
        }
        seo.setMonthlyFood(famount);
        SchoolEO seo1=fm.getStudentDetails(seo);
        if(!seo1.getSname().equals("")){
            
            fm.updateMonthlyFoodBillOfEditing(seo);
            request.setAttribute("msg", "Food amount details is updated for the student id "+seo.getStud_id()+" and the month "+seo.getMonth()+".");
        }
        else{
            request.setAttribute("msg", "Student record is not found.");
        }
        seo2=fm.retMonthlyFoodBillForEditing(seo);
        request.setAttribute("jbean", seo2);
        }
        else{
           request.setAttribute("msg", "Student food bill is not present for the student id "+seo.getStud_id()+" and the month "+seo.getMonth()); 
        }
        return mapping.findForward(SUCCESS);
    }


    public ActionForward fine(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
      HttpSession htsession=request.getSession(false);
        if(htsession.getAttribute("loginid") ==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
        }  
        String session=request.getParameter("session");
        String stud_id=request.getParameter("stud_id");
        String submit_type=request.getParameter("submit");
        SchoolEO seo=new SchoolEO();
        seo.setSession(session);
        seo.setStud_id(stud_id);
        
        FeeMath fm=new FeeMath();
        ArrayList finelist=new ArrayList();
        
        SchoolEO seo1=fm.getStudentDetails(seo);
        seo1.setSession(seo.getSession());
        seo.setBatch(seo1.getBatch());
        
        if(submit_type.equals("Submit"))
        {
        double famount=0.0;
        try{
            if(request.getParameter("famount")!=null)
            {
                famount=Double.parseDouble(request.getParameter("famount"));
            }
        }catch(NumberFormatException e)
        {
            request.setAttribute("jbean", seo);
            request.setAttribute("msg", "Please enter amount as numeric value.");
            return mapping.findForward(SUCCESS);
        }
        seo.setFine(famount);
        fm.subFineAmount(seo);
        request.setAttribute("msg", "Fine amount "+seo.getFine()+" is added.");
        }
        
        finelist=fm.retStudentFine(seo);
       
        request.setAttribute("jbean", seo1);
        request.setAttribute("finelist", finelist);
        return mapping.findForward(SUCCESS);
    }
    
public ActionForward feeprocessing(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
   HttpSession htsession=request.getSession(false);
        if(htsession.getAttribute("loginid") ==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
        }     
        PrintWriter out=response.getWriter();
        String session=request.getParameter("session");
        String stud_id=request.getParameter("stud_id");
//        String session_sem=request.getParameter("session_sem");
        String bank=request.getParameter("bnk_name");
//        String tran_id=request.getParameter("tran_id");
        String submit=request.getParameter("submit");
        String dep_date=request.getParameter("date1");
        SchoolEO seo=new SchoolEO();
        seo.setStud_id(stud_id);
        
        FeeMath fm=new FeeMath();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sde=new SimpleDateFormat("dd-MM-yyyy");
        
        Calendar cal = Calendar.getInstance();  
            java.util.Date current=cal.getTime();
            
            cal.set(cal.DATE, 1);
            cal.set(cal.MONTH, 4);
            java.util.Date d1=cal.getTime();
            
            cal.set(cal.DATE, 30);
            cal.set(cal.MONTH, 8);
            java.util.Date d2=cal.getTime();
            
            cal.set(cal.DATE, 1);
            cal.set(cal.MONTH, 10);
            java.util.Date d3=cal.getTime();
            
            cal.set(cal.DATE, 30);
            cal.set(cal.MONTH, 2);
            cal.set(cal.YEAR, cal.get(cal.YEAR)+1);
            java.util.Date d4=cal.getTime();
            
            String session_sem="";
            if(current.after(d1) && current.before(d2))
            {
                session_sem="I";
            }
            else if(current.compareTo(d3) >= 0 && current.compareTo(d4) <= 0)
            {
                session_sem="II";
            }
            
        SchoolEO seo1=fm.getStudentDetails(seo);
        seo1.setSession(session);
        seo1.setSession_sem(session_sem);
        seo1.setBankname(bank);
//        seo1.setTransaction_id(tran_id);
        int cn=0;
        if(submit.equals("Process")){
            seo1.setDeposite_date(sde.parse(sde.format(sdf.parse(dep_date))));
            seo1.setFeeReceipt(fm.genFeeRecptNo());
            seo1=fm.retStudFeeFromStruc(seo1);
            seo=seo1;
//          out.println(seo1.getDataMap());
//          out.println("<br>");
//          out.println(seo1.getFeeTotal());
            cn=fm.checkSubmited_feeData(seo1);
//            System.out.println(cn);
        Connection con=null;
        try{
            Dataconnectivity dc=new Dataconnectivity();
            con=(Connection)dc.Dataconnect();
            con.setAutoCommit(false);
        }catch(Exception e){} 
            if(cn==0){
                try{
                    fm.submit_feeData(seo1,con);
                    fm.subFeeHeadwise(seo, seo1,con);
                    con.commit();
                    seo1=fm.calFineOnLateFeeSubm(seo1);
                    request.setAttribute("msg", "Fee processing is done.");
                    if(seo1.getTot_days()>0)
                        request.setAttribute("msg1", "Fee is submitted after the date "+seo1.getLastdate()+". Please scroll down and click on generate"
                                + " link to generate the slip of late fee submission fine or process the fine to provide the nodues.");
                    
                }catch(Exception e){
                    con.rollback();
                    logger.log(Level.SEVERE, "Error in fee processing od old student of student id"+seo1.getStud_id(), e);
                }
            }
            else if(cn==1)
            {
                seo1=fm.calFineOnLateFeeSubm(seo1);
                request.setAttribute("msg", "Fee is already processed.");
                if(seo1.getTot_days()>0)
                    request.setAttribute("msg1", "Fee is submitted after the date "+seo1.getLastdate()+". Please scroll down and click on generate"
                            + " link to generate the slip of late fee submission fine or process the fine to provide the nodues.");
            }
            else
            {
                request.setAttribute("msg", "Fee is already processed.");
                request.setAttribute("msg1", "No dues has been given.");
            }
            seo1.setCounter(cn);
            seo1=fm.retStudScrollFromFeeDetails(seo1);
        }
        else{
            cn=fm.checkSubmited_feeData(seo1);
            if(cn==0){
                seo1.setCounter(2);
                request.setAttribute("msg", "Fee is not processed. Please process the fee to give the nodues.");
            }
            else if(cn==1)
            {
                seo1=fm.calFineOnLateFeeSubm(seo1);
                seo1.setCounter(cn);
                seo1=fm.retStudScrollFromFeeDetails(seo1);
                request.setAttribute("msg", "Fee is already processed.");
                if(seo1.getTot_days()>0)
                {request.setAttribute("msg1", "Fee is submitted after the date "+seo1.getLastdate()+". Please Scroll down and click on generate link to generate"
                        + " the slip of late fee submission fine or process the fine to provide the nodues.");}
            }
            else
            {
                seo1.setCounter(cn);
                seo1=fm.retStudScrollFromFeeDetails(seo1);
                request.setAttribute("msg", "Fee is already processed.");
                request.setAttribute("msg1", "No dues has been given.");
            }
        }
        ArrayList al=fm.bankList();
         request.setAttribute("bnklist", al);
         
        request.setAttribute("jbean", seo1);
        
//        return mapping.findForward("");
        return mapping.findForward(SUCCESS);
    }
    
public ActionForward Fee_Processing(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    HttpSession htsession=request.getSession(false);
    if(htsession.getAttribute("loginid")==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
    }
        PrintWriter out=response.getWriter();
        FeeMath fm=new FeeMath();
        String session=request.getParameter("session");
        String stud_id=request.getParameter("stud_id");
        String table="studentregis";
        int cnt=fm.checkStudent_in(table, stud_id);
        if(cnt!=0){
            ArrayList list=new ArrayList();
//        String session_sem=request.getParameter("session_sem");
        String bank=request.getParameter("bnk_name");
//        String tran_id=request.getParameter("tran_id");
        String submit=request.getParameter("submit");
        String dep_date=request.getParameter("date1");
        SchoolEO seo=new SchoolEO();
        seo.setStud_id(stud_id);
        
        
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sde=new SimpleDateFormat("dd-MM-yyyy");
        
        String session_sem=request.getParameter("session_sem");
        SchoolEO seo1=fm.getStudentDetails(seo);
        seo1.setSession(session);
        seo1.setSession_sem(session_sem);
        seo1.setBankname(bank);
//        seo1.setTransaction_id(tran_id);
        int cn=0;
        if(submit.equals("Process")){
            seo1.setDeposite_date(sde.parse(sde.format(sdf.parse(dep_date))));
            seo1.setFeeReceipt(fm.genFeeRecptNo());
            seo1=fm.ret_stud_fee_detail_excel(seo1);
            if(seo1.getDataMap().size()>0){
            seo=seo1;
            cn=fm.checkSubmited_feeData(seo1);
//            System.out.println("FeeTotal: "+seo1.getFeeTotal());
        Connection con=null;
        try{
            Dataconnectivity dc=new Dataconnectivity();
            con=(Connection)dc.Dataconnect();
            con.setAutoCommit(false);
        }catch(Exception e){} 
            if(cn==0){
                int nn=fm.subFeeHeadwise(seo, seo1,con);
                if(nn==1){
                    try{
                        fm.submitfeeData(seo1,con);
                        fm.deleteLongRow(seo.getRwid(), "stud_fee_detail_excel", "rwid", con);
                        con.commit();
                        seo1=fm.calFineOnLateFeeSubm(seo1);
                        request.setAttribute("msg", "Fee processing is done.");
                        if(seo1.getTot_days()>0)
                            request.setAttribute("msg1", "Fee is submitted after the date "+seo1.getLastdate()+". Please scroll down and click on generate"
                                    + " link to generate the slip of late fee submission fine or process the fine to provide the nodues.");
                        
                    }catch(Exception e){
                        ArrayList al=fm.bankList();
                        request.setAttribute("bnklist", al);
                        request.setAttribute("jbean", seo1);
                        request.setAttribute("msg", "Fee can not be processed for this student. Please try again or contact with the vendor.");
                        con.rollback();
                        logger.log(Level.SEVERE, "Error in fee processing old student of student id"+seo1.getStud_id(), e);
                    }
                }
                else
                {
                    ArrayList al=fm.bankList();
                    request.setAttribute("bnklist", al);
                    request.setAttribute("jbean", seo1);
                    con.rollback();
                    logger.log(Level.SEVERE, "Error in Fee_Processing old student of student id"+seo1.getStud_id());
                    request.setAttribute("msg", "Fee can not be processed for this student. Please contact with the vendor.");
                    return mapping.findForward(SUCCESS);
                }
            }
            else if(cn==1)
            {
                seo1=fm.calFineOnLateFeeSubm(seo1);
                request.setAttribute("msg", "Fee is already processed.");
                if(seo1.getTot_days()>0)
                    request.setAttribute("msg1", "Fee is submitted after the date "+seo1.getLastdate()+". Please scroll down and click on generate"
                            + " link to generate the slip of late fee submission fine or process the fine to provide the nodues.");
            }
            else
            {
                seo1=fm.retStudTotFine(seo1);
                request.setAttribute("msg", "Fee is already processed.");
                request.setAttribute("msg1", "No dues has been given.");
            }
            seo1.setCounter(cn);
//            seo1=fm.retStudScrollFrom_stud_fee_detail(seo1);
            list=fm.retMoreStudScrollFrom_stud_fee_detail(seo1);
            }
            else{
                seo1.setCounter(2);
               request.setAttribute("msg", "Student fee is not found for session "+seo1.getSession()+"-"+seo1.getSession_sem()); 
            }
        }
        else{
            cn=fm.checkSubmited_feeData(seo1);
//            System.out.println(cn);
            if(cn==0){
                seo1.setCounter(2);
                request.setAttribute("msg", "Fee is not processed. Please process the fee to give the nodues.");
            }
            else if(cn==1)
            {
                seo1=fm.calFineOnLateFeeSubm(seo1);
                seo1.setCounter(cn);
//                seo1=fm.retStudScrollFrom_stud_fee_detail(seo1);
                list=fm.retMoreStudScrollFrom_stud_fee_detail(seo1);
                request.setAttribute("msg", "Fee is already processed.");
                if(seo1.getTot_days()>0)
                {request.setAttribute("msg1", "Fee is submitted after the date "+seo1.getLastdate()+". Please Scroll down and click on generate link to generate"
                        + " the slip of late fee submission fine or process the fine to provide the nodues.");}
            }
            else
            {
                seo1.setCounter(cn);
//                seo1=fm.retStudScrollFrom_stud_fee_detail(seo1);
                seo1=fm.retStudTotFine(seo1);
                list=fm.retMoreStudScrollFrom_stud_fee_detail(seo1);
                request.setAttribute("msg", "Fee is already processed.");
                request.setAttribute("msg1", "No dues has been given.");
            }
        }
        ArrayList al=fm.bankList();
        request.setAttribute("bnklist", al);
        request.setAttribute("jbean", seo1);
        request.setAttribute("list", list);
        }
        else
            request.setAttribute("msg", "Student details is not found in our record.");
//        return mapping.findForward("");
        return mapping.findForward(SUCCESS);
    }
    
public ActionForward ManualFee_Processing(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    HttpSession htsession=request.getSession(false);
    if(htsession.getAttribute("loginid") ==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
    }
        PrintWriter out=response.getWriter();
        FeeMath fm=new FeeMath();
        String session=request.getParameter("session");
        String stud_id=request.getParameter("stud_id");
        String table="studentregis";
        int cnt=fm.checkStudent_in(table, stud_id);
        if(cnt!=0){
//        String session_sem=request.getParameter("session_sem");
        String bank=request.getParameter("bnk_name");
//        String tran_id=request.getParameter("tran_id");
        String submit=request.getParameter("submit");
        String dep_date=request.getParameter("date1");
        SchoolEO seo=new SchoolEO();
        seo.setStud_id(stud_id);
        
        
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sde=new SimpleDateFormat("dd-MM-yyyy");
        String session_sem=request.getParameter("session_sem");
        
        SchoolEO seo1=fm.getStudentDetails(seo);
        seo1.setSession(session);
        seo1.setSession_sem(session_sem);
        seo1.setBankname(bank);
//        seo1.setTransaction_id(tran_id);
        int cn=0;
        if(submit.equals("Submit")||submit.equals("Update")){
            ArrayList ar1=new ArrayList();
        ArrayList ar2=new ArrayList();
        HashMap hm1=new HashMap();
          double fftot=0;
        Enumeration en=(Enumeration)request.getParameterNames();
        String param="";
        while(en.hasMoreElements()){
        param=(String)en.nextElement(); 
        try{
        if(param.substring(0,3).equals("fee")){
        ar1.add(param);
        }    
        }catch(StringIndexOutOfBoundsException e){}
        }
        String s="";
        for(int i=0;i<ar1.size();i++){
            if(request.getParameter("fee"+i)!=null&&!request.getParameter("fee"+i).equals(""))
            {
                ar2.add(request.getParameter("fd"+i));
                hm1.put(request.getParameter("fd"+i),request.getParameter("fee"+i));
                fftot=fftot+Double.parseDouble(request.getParameter("fee"+i));
            }
        }
//        out.println(hm1);
            seo1.setDeposite_date(sde.parse(sde.format(sdf.parse(dep_date))));
            seo1.setFeeReceipt(fm.genFeeRecptNo());
            try{
            seo1.setPamount(Double.parseDouble(request.getParameter("p_fee")));
            seo1.setEamount(Double.parseDouble(request.getParameter("ex_fee")));
            seo1.setFine(Double.parseDouble(request.getParameter("fine")));
            }catch(Exception e){}
            seo1.setFeeTotal(fftot+seo1.getPamount()+seo1.getEamount());
        seo=seo1;   
        seo1.setDataArray(ar2);
        seo1.setDataMap(hm1);
            
//            System.out.println(cn);
        Connection con=null;
        try{
            Dataconnectivity dc=new Dataconnectivity();
            con=(Connection)dc.Dataconnect();
            con.setAutoCommit(false);
        }catch(Exception e){} 
        try{
            if(submit.equals("Submit")){
                cn=fm.checkSubmited_feeData1(seo1);
                if(cn!=0){
                    String sem=fm.retColumnVal("studentregis", "semester", seo);
                    int ssm=Integer.parseInt(sem)-1;
                    seo.setSemester(Integer.toString(ssm));
                }
                int nn=fm.subFeeHeadwise(seo, seo1,con);
                if(nn==1){
                    seo1.setStatus("manual");
                    fm.submitfeeData(seo1,con);
                    request.setAttribute("msg", "Fee detail is stored.");
                }
                else
                {
                    ArrayList al=fm.bankList();
                    request.setAttribute("bnklist", al);
                    request.setAttribute("jbean", seo1);
                    request.setAttribute("msg", "Fee can not be processed for this student. Please contact with the vendor.");
                    return mapping.findForward(SUCCESS);
                }
            }
            else{
                int n=fm.updateStud_fee_detail(seo, seo1,con);
                if(n==1)
                {
                    fm.updateSud_feedata(seo);
                    request.setAttribute("msg", "Fee detail is updated.");
                }
                else
                    {
                    ArrayList al=fm.bankList();
                    request.setAttribute("bnklist", al);
                    request.setAttribute("jbean", seo1);
                    request.setAttribute("msg", "Fee can not be update for this student. Please contact with the vendor.");
                    return mapping.findForward(SUCCESS);
                }
            }
            con.commit();
        }catch(Exception e){
            ArrayList al=fm.bankList();
            request.setAttribute("bnklist", al);
            request.setAttribute("jbean", seo1);
            request.setAttribute("msg", "Fee can not be processed for this student. Please contact with the vendor.");
            con.rollback();
            logger.log(Level.SEVERE, "Connection Rollback in manual entry/update for student id "+seo1.getStud_id(), e);
        }
            cn=fm.checkSubmited_feeData1(seo1);
            if(cn==-10){
                ArrayList list=fm.retMoreStudScrollFrom_stud_fee_detail(seo1);
                request.setAttribute("list", list);
                seo1=fm.retStudTotFine(seo1);
                request.setAttribute("jbean", seo1);
                return mapping.findForward("more_result");
            }
            
            seo1.setCounter(cn);
            seo1=fm.retStudScrollFrom_stud_fee_detail(seo1);
        }
        else{
            cn=fm.checkSubmited_feeData1(seo1);
            if(cn==0){
                seo1.setCounter(2);
                request.setAttribute("msg", "Fee details is not found for "+seo1.getSession()+"-"+seo1.getSession_sem()+". Please Manually proccess fee for this student.");
                HashMap<String,String> hm=fm.retFeeHeads();
                request.setAttribute("fields_head", hm);
            }
            else if(cn!=-10)
            {
                seo1.setCounter(cn);
                seo1=fm.retStudScrollFrom_stud_fee_detail(seo1);
                request.setAttribute("msg", "Fee is already processed. Now you can make changes.");
            }
            else{
                ArrayList list=fm.retMoreStudScrollFrom_stud_fee_detail(seo1);
                request.setAttribute("list", list);
                seo1=fm.retStudTotFine(seo1);
                request.setAttribute("jbean", seo1);
                return mapping.findForward("more_result");
//                return mapping.findForward("");
            }
          }
            ArrayList al=fm.bankList();
            request.setAttribute("bnklist", al);
            request.setAttribute("jbean", seo1);
        }
        else
            request.setAttribute("msg", "Student details is not found in our record.");
//        return mapping.findForward("");
        return mapping.findForward(SUCCESS);
    }

public ActionForward moreMaualFee(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    HttpSession htsession=request.getSession(false);
    if(htsession.getAttribute("loginid") ==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
    }
        PrintWriter out=response.getWriter();
        FeeMath fm=new FeeMath();
        String session=request.getParameter("session");
        String stud_id=request.getParameter("stud_id");
        String session_sem=request.getParameter("session_sem");
        String table="studentregis";
        int cnt=fm.checkStudent_in(table, stud_id);
        if(cnt!=0){
            SchoolEO seo=new SchoolEO();
            seo.setStud_id(stud_id);
            
            SchoolEO seo1=fm.getStudentDetails(seo);
            seo1.setSession(session);
            seo1.setSession_sem(session_sem);
        
            HashMap<String,String> hm=fm.retFeeHeads();
            request.setAttribute("fields_head", hm);
          
            ArrayList al=fm.bankList();
            request.setAttribute("bnklist", al);
            request.setAttribute("jbean", seo1);
            request.setAttribute("msg", "Add more fee details for this student.");
        }
        else
            request.setAttribute("msg", "Student details is not found in our record.");
//        return mapping.findForward("");
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward noduesProcessing(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession htsession=request.getSession(false);
    if(htsession.getAttribute("loginid")==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
    }
        PrintWriter out=response.getWriter();
        String session=request.getParameter("session");
        String stud_id=request.getParameter("stud_id");
        String session_sem=request.getParameter("session_sem");
        
        SchoolEO seo=new SchoolEO();
        seo.setStud_id(stud_id);
        
        Connection con=null;
    try{
  Dataconnectivity dc=new Dataconnectivity();
  con=(Connection)dc.Dataconnect();
  con.setAutoCommit(false);
  }catch(Exception e){}  
    try{
        FeeMath fm=new FeeMath();
        //SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sde=new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat sdf1=new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
            
        seo=fm.getStudentDetails(seo);
        seo.setSession(session);
        seo.setSession_sem(session_sem);
        double total_amount=0;
        if(htsession.getAttribute("total_amount")!=null){
            total_amount=Double.parseDouble(htsession.getAttribute("total_amount").toString());
            htsession.removeAttribute("total_amount");
        }
        seo.setFeeTotal(total_amount);
        seo.setLoginName(htsession.getAttribute("name").toString());
        
        java.util.Date curDate=new java.util.Date();
        String cDate=sde.format(curDate);
        String nDate=sdf1.format(curDate);
        
        String filename="NoduesList-"+seo.getSession()+"-"+seo.getSession_sem()+"_"+cDate+".xls";
        String file=getServlet().getServletContext().getRealPath("/noduesed_excel")+"/"+filename;
        fm.updateNoduesIn_feeData(seo,con);
        fm.insertStudentNoduesSemwise(seo,con);
        fm.insertSemStudRegis(seo,con);
        fm.writeNodusedStudentToExcelFile(file,seo,nDate,filename,con);
        
        con.commit();
        logger.log(Level.INFO, "Connection committed.");
        logger.log(Level.INFO, "No dues is given to student "+seo.getStud_id());
        
        seo.setCounter(2);
        ArrayList al=fm.bankList();
         request.setAttribute("bnklist", al);
//         seo=fm.retStudScrollFromFeeDetails(seo);         original using structure
//         seo=fm.retStudScrollFrom_stud_fee_detail(seo);         // due to excel processing
         ArrayList list=fm.retMoreStudScrollFrom_stud_fee_detail(seo);
                request.setAttribute("list", list);
                seo=fm.retStudTotFine(seo);
        request.setAttribute("jbean", seo);
        request.setAttribute("msg1", "No dues is given.");
        
// for new student
        double tt=fm.retTotalSubmitted(stud_id, session,session_sem);
        request.setAttribute("tt",Double.toString(tt)); 
    }catch(Exception e){
        con.rollback();
        logger.log(Level.SEVERE, "Connection Rollback in giving nodues to "+seo.getStud_id(),e);
    }
//        return mapping.findForward("");
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward lateFineProcessing(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession htsession=request.getSession(false);
    if(htsession.getAttribute("loginid")==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
    }
        PrintWriter out=response.getWriter();
        String session=request.getParameter("session");
        String stud_id=request.getParameter("stud_id");
        String session_sem=request.getParameter("session_sem");
        String bank=request.getParameter("bank");
        String date2=request.getParameter("date2");
        String pr=request.getParameter("fine");
        
SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
       
java.util.Date dt=sdf.parse(date2);
        int receipt=0;
        double fine=0;
        try{
            fine=Double.parseDouble(request.getParameter("latefine"));
        }catch(NumberFormatException n){}
        try{
            receipt=Integer.parseInt(request.getParameter("receipt"));
        }catch(NumberFormatException n){}
        SchoolEO seo=new SchoolEO();
        seo.setStud_id(stud_id);
        
        FeeMath fm=new FeeMath();
        SimpleDateFormat sde=new SimpleDateFormat("yyyy-MM-dd");
        
        seo=fm.getStudentDetails(seo);
        
        seo.setSession(session);
        seo.setSession_sem(session_sem);
        seo.setDeposite_date(sde.parse(request.getParameter("deposit_date")));
        seo.setFine(fine);
        seo.setFeeReceipt(receipt);
        seo.setLastdate(request.getParameter("last_date"));
        seo.setBankname(bank);
        if(!pr.equals("Update")){
            fm.latefineprocess(seo,dt);
            ArrayList al=fm.bankList();
         request.setAttribute("bnklist", al);
//         seo=fm.retStudScrollFromFeeDetails(seo);        original using structure
//         seo=fm.retStudScrollFrom_stud_fee_detail(seo);
        ArrayList list=fm.retMoreStudScrollFrom_stud_fee_detail(seo);
        request.setAttribute("list", list);
        seo=fm.retStudTotFine(seo);
        request.setAttribute("jbean", seo);
        request.setAttribute("msg1", "Fine on late fee sumission is processed. Now click on No Dues to provide no dues.");
        }
        else
        {
            int rid=0;
            try{
                rid=Integer.parseInt(request.getParameter("rid"));
            }catch(Exception e){}
            seo.setRowid(rid);
            seo.setDate(dt);
            fm.updateFine_data(seo);
            request.setAttribute("msg1", "Fine on late fee sumission is processed.");
            seo=fm.fineReturn(seo);
        if(seo.getCounter()==0)
            seo=fm.calFineOnLateFeeSubm(seo);
        request.setAttribute("jbean", seo);
            
        }
        
        
//        return mapping.findForward("");
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward checkNoduesProcess(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
     HttpSession htsession=request.getSession(false);
        if(htsession.getAttribute("loginid") ==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
        }   
        PrintWriter out=response.getWriter();
        String session=request.getParameter("session");
        String stud_id=request.getParameter("stud_id");
        String session_sem=request.getParameter("session_sem");
        SchoolEO seo=new SchoolEO();
        seo.setStud_id(stud_id);
        
        FeeMath fm=new FeeMath();
        
        seo=fm.getStudentDetails(seo);
        seo.setSession(session);
        seo.setSession_sem(session_sem);
        if(seo.getSname().equals("")){
            request.setAttribute("jbean", seo);
            request.setAttribute("msg", "Student details is not found for student id "+seo.getStud_id());
            return mapping.findForward(SUCCESS);
        }
        seo.setReason("Degree Complete");
        if(request.getParameter("reason")!=null)
            seo.setReason(request.getParameter("reason"));
        
        seo=fm.selDistinctHeads(seo);
        String table="noduesed_student_amount";
        int cn=fm.checkStudent_in(table,seo.getStud_id());
        if(cn!=0)
        {
            seo=fm.noduesedStudent(seo);
        }
        else
        {
            if(seo.getReason().equals("Degree Complete")){
                seo=fm.selLastFeeFromStud_fee_detailForDegreeCmplt(seo);
//              System.out.println(seo.getDataMap1());
                seo.setMonthlyFood(fm.retTotalMonthlyFoodBill(seo.getStud_id()));
            
//              seo.setFoodadvance(fm.retFeeOfHeadsFromStruc(seo,"FOOD ADVANCE"));
//              seo.setCautionMoney(fm.retFeeOfHeadsFromStruc(seo,"CAUTION MONEY"));
            
//              seo.setFoodadvance(fm.retFeeOfHeadsFromStruc(seo.getStud_id(),"field10"));
//              seo.setCautionMoney(fm.retFeeOfHeadsFromStruc(seo.getStud_id(),"field34"));
                HashMap hm1=seo.getDataMap1();
                if(hm1.containsKey("MONTHLY FOOD BILL")){
                    hm1.remove("MONTHLY FOOD BILL");
                    hm1.put("MONTHLY FOOD BILL", seo.getMonthlyFood());
                }
            }
            else if(seo.getReason().equals("Before Registration"))  
            {
                seo=fm.selLastFeeFromStud_fee_detail(seo);
            }
            else if(seo.getReason().equals("After Registration"))  
            {
                seo=fm.selLastFeeFromStud_fee_detailForAfterRegis(seo);
                seo.setMonthlyFood(fm.retTotalMonthlyFoodBill(seo.getStud_id()));
                
                HashMap hm1=seo.getDataMap1();
                if(hm1.containsKey("MONTHLY FOOD BILL")){
                    hm1.remove("MONTHLY FOOD BILL");
                    hm1.put("MONTHLY FOOD BILL", seo.getMonthlyFood());
                }
//               System.out.println(seo.getDataMap1()); 
                if(seo.getCounter()!=-1){
                int months=0;
                java.util.Date dt1=new java.util.Date();
//              System.out.println("current date: "+dt1);

   int days=(int)((dt1.getTime()-seo.getDate().getTime())/(1000 * 60 * 60 * 24));
   months=days/30+1;
//   System.out.println("months: "+months);
   double adjamnt=0;
                if(hm1.containsKey("HOSTEL MAINTENANCE FEE")){
                    adjamnt=Double.parseDouble(hm1.get("HOSTEL MAINTENANCE FEE").toString());
                    adjamnt=adjamnt-(months*(Math.round(adjamnt/12)));
                    hm1.remove("HOSTEL MAINTENANCE FEE");
                    hm1.put("HOSTEL MAINTENANCE FEE", adjamnt);
                }
                if(hm1.containsKey("ELECTRIC CHARGES")){
                    adjamnt=Double.parseDouble(hm1.get("ELECTRIC CHARGES").toString());
                    adjamnt=adjamnt-(months*(Math.round(adjamnt/6)));
                    hm1.remove("ELECTRIC CHARGES");
                    hm1.put("ELECTRIC CHARGES", adjamnt);
                }
                if(hm1.containsKey("WATER CHARGES")){
                    adjamnt=Double.parseDouble(hm1.get("WATER CHARGES").toString());
                    adjamnt=adjamnt-(months*(Math.round(adjamnt/6)));
                    hm1.remove("WATER CHARGES");
                    hm1.put("WATER CHARGES", adjamnt);
                }
                if(hm1.containsKey("FAN CHARGES")){
                    adjamnt=Double.parseDouble(hm1.get("FAN CHARGES").toString());
                    adjamnt=adjamnt-(months*(Math.round(adjamnt/6)));
                    hm1.remove("FAN CHARGES");
                    hm1.put("FAN CHARGES", adjamnt);
                }
                if(hm1.containsKey("ROOM RENT")){
                    adjamnt=Double.parseDouble(hm1.get("ROOM RENT").toString());
                    adjamnt=adjamnt-(months*(Math.round(adjamnt/6)));
                    hm1.remove("ROOM RENT");
                    hm1.put("ROOM RENT", adjamnt);
                }
              }  
//                System.out.println(seo.getDataMap1());
            }
        }
        

        request.setAttribute("jbean", seo);
        
//        return mapping.findForward("");
        return mapping.findForward(SUCCESS);
    }
    
public ActionForward studentnodues(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    HttpSession htsession=request.getSession(false);
        if(htsession.getAttribute("loginid") ==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
        }    
        PrintWriter out=response.getWriter();
        String session=request.getParameter("session");
        String stud_id=request.getParameter("stud_id");
        
            
            String session_sem=request.getParameter("session_sem");
            
        SchoolEO seo=new SchoolEO();
        seo.setStud_id(stud_id);
        
        FeeMath fm=new FeeMath();
        
        seo=fm.getStudentDetails(seo);
        seo.setSession(session);
        seo.setSession_sem(session_sem);
        
        String status=request.getParameter("nod");
        double amnt=0;
        try{
        if(request.getParameter("ttamnt")!=null)
        {
            amnt=Double.parseDouble(request.getParameter("ttamnt"));
        }
        }catch(Exception e){}
        seo.setTfee(amnt);
        seo.setStatus(status);
        
        ArrayList ar1=new ArrayList();
        ArrayList ar2=new ArrayList();
        HashMap hm1=new HashMap();
          
        Enumeration en=(Enumeration)request.getParameterNames();
        String param="";
        while(en.hasMoreElements()){
        param=(String)en.nextElement(); 
        try{
        if(param.substring(0,3).equals("fee")){
        ar1.add(param);
        }    
        }catch(StringIndexOutOfBoundsException e){}
        }
        String s="";
        for(int i=0;i<ar1.size();i++){
            if(request.getParameter("fee"+i)!=null&&!request.getParameter("fee"+i).equals("0")&&!request.getParameter("fee"+i).equals("0.0"))
            {
                ar2.add(request.getParameter("field"+i));
                s="-"+request.getParameter("fee"+i);
                hm1.put(request.getParameter("field"+i),s);
            }
        }
        if(hm1.containsKey("field18")){
            double mf=Double.parseDouble(hm1.get("field18").toString());
            mf=Math.abs(mf);
//            System.out.println(mf);
            hm1.remove("field18");
            hm1.put("field18", mf);
        }
//        System.out.println(hm1);
        String reason="";
        if(request.getParameter("other")!=null&&!request.getParameter("other").equals(""))
        {
            reason=request.getParameter("other");
        }
        else{
            reason=request.getParameter("reason");
        }
        seo.setReason(reason);
        
        

        ArrayList al=new ArrayList();
        ArrayList al1=new ArrayList();
        ArrayList al2=new ArrayList();
        ArrayList al3=new ArrayList();

        double am=0.0;

             al.add(request.getParameter("dd_1"));
             al1.add(request.getParameter("dddate_1"));
             al2.add(request.getParameter("bnk_1"));
             try{
                 if(request.getParameter("damnt_1")!=null&&!request.getParameter("damnt_1").equals(""))
                 {
                     try{
                        am=Double.parseDouble(request.getParameter("damnt_1").toString());
                        if(seo.getStatus().equals("refund")){
                            am=-am;
                        }
                        al3.add(am);
                     }
                     catch(Exception ee){}
                 }
                 else
                 {
                     al3.add(am);
                 }
                 
             }catch(Exception e){
             al3.add(am);
             }

        seo.setDataArray(al);
        seo.setDataArray1(al1);
        seo.setDataArray2(al2);
        seo.setDataArray3(al3);
        seo.setBankname(request.getParameter("bnk_1"));
        fm.insertInNoduesedStudent(seo, ar2, hm1);
        fm.draftReceivedForNodues(seo);
        fm.updateMonthlyFoodBill(seo);
        
        
        seo=fm.selDistinctHeads(seo);
        seo=fm.noduesedStudent(seo);
        request.setAttribute("jbean", seo);
        request.setAttribute("msg", "Nodues process has been completed.");
//        return mapping.findForward("");
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward noduesReceipt(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
     HttpSession htsession=request.getSession(false);
        if(htsession.getAttribute("loginid") ==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
        }   
        PrintWriter out=response.getWriter();
        String stud_id=request.getParameter("stud_id");
        SchoolEO seo=new SchoolEO();
        seo.setStud_id(stud_id);
        FeeMath fm=new FeeMath();
        seo=fm.getStudentDetails(seo);
        seo=fm.noduesedStudent(seo);
        seo=fm.retDraftReceivedForNodues(seo);
        
        
        request.setAttribute("jbean", seo);
//        return mapping.findForward("");
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward delScroll(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    HttpSession htsession=request.getSession(false);
        if(htsession.getAttribute("loginid") ==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
        }    
        String ses=request.getParameter("session");
        String ssn_sm=request.getParameter("session_sem");
        String degree=request.getParameter("deg");
        int id=0;
        try{
            if(request.getParameter("id")!=null)
                id=Integer.parseInt(request.getParameter("id"));
        }catch(Exception e){}
//        String stud_type=request.getParameter("stud_type");
        SchoolEO seo=new SchoolEO(); 
        
        seo.setSession(ses);
        seo.setSession_sem(ssn_sm);
        seo.setDegree(degree);
        
        
        MyMeth fun=new MyMeth();
        ArrayList DegreeList=new ArrayList();
        DegreeList=(ArrayList)fun.Degree_list();
        request.setAttribute("degreelist",DegreeList);
        
        ArrayList scrollList=new ArrayList();
        ScrollPdf sp=new ScrollPdf();
        DataObj dob=new DataObj(); 
        String filename=sp.retIndvPdfScroll(id);
        
        try{
            String file=getServlet().getServletContext().getRealPath("/ScrollInPDF")+"/"+filename;
            File f=new File(file);
            boolean b=f.delete();
            if(b=true)
                dob.deleteRowFromDynTable(id,"generated_pdf");  
        }catch(Exception e){}
        
        
        scrollList=sp.retGeneratedScrollPdf(seo);
            
        
     request.setAttribute("msg","Fee scroll is deleted");  
     request.setAttribute("scrollList",scrollList);     
     request.setAttribute("jbean",seo);    
            return mapping.findForward(SUCCESS);
//         return mapping.findForward("");
      
    }    

    public ActionForward enSpStudent(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    HttpSession htsession=request.getSession(false);
        if(htsession.getAttribute("loginid") ==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
        }    
        String ses=request.getParameter("session");
        String session_sem=request.getParameter("session_sem");
        String stud_id=request.getParameter("stud_id");
        String bnk_name=request.getParameter("bnk_name");
        String date1=request.getParameter("date1");
        String rec="";
        if(request.getParameter("receipt_no")!=null){
            rec=request.getParameter("receipt_no");
        }
        double amount=0;
        try{
            if(request.getParameter("amount")!=null)
                amount=Double.parseDouble(request.getParameter("amount"));
        }catch(Exception e){}
//        String stud_type=request.getParameter("stud_type");
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        SchoolEO seo=new SchoolEO(); 
        seo.setSession(ses);
        seo.setSession_sem(session_sem);
        seo.setStud_id(stud_id);
        seo.setAmountpaid(amount);
        seo.setBankname(bnk_name);
        seo.setRecnum(rec);
        seo.setDate(sdf.parse(date1));
        
        FeeMath fm=new FeeMath();
        ArrayList list=new ArrayList();
        fm.subSponsoredAmount(seo);
        seo=fm.getStudentDetails(seo);
        list=fm.retSponsoredAmount(seo.getStud_id());
            
        
     request.setAttribute("msg","Amount is stored.");  
     request.setAttribute("list",list);   
     request.setAttribute("jbean",seo);    
            return mapping.findForward(SUCCESS);
//         return mapping.findForward("");
    }    
    
    public ActionForward student_transfer(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    HttpSession htsession=request.getSession(false);
        if(htsession.getAttribute("loginid") ==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
        }
        String ses=request.getParameter("session");
        String stud_id=request.getParameter("stud_id");
        String tranf=request.getParameter("tf");
//        String stud_type=request.getParameter("stud_type");
        SchoolEO seo=new SchoolEO(); 
        seo.setSession(ses);
        seo.setStud_id(stud_id);
        seo.setReason(tranf);
        
        
        FeeMath fm=new FeeMath();
        String table="transfered_student";
        int cntranf=fm.checkStudent_in(table,seo.getStud_id());
        if(cntranf==0){
            table="sub_feedata";
        int count = fm.checkStudent_in(table,seo.getStud_id());
        if(count==1)
        {
            int cn=fm.insertTransferStudent(seo);
            if(cn!=0)
            {
                fm.updationForStudentTransfer(seo.getStud_id());
                seo=fm.retTransferedStudent(seo.getStud_id());
                request.setAttribute("msg","Student is Transfered.");  
            }
        }
        else if(count==0)
            request.setAttribute("msg","Student fee is not submitted.");  
        else
            request.setAttribute("msg","This student is in "+count+" semester. So this student can not be transfered."); 
      }
      else
         request.setAttribute("msg","This Student is already Transfered.");   
        
        seo=fm.retTransferedStudent(seo.getStud_id());
        request.setAttribute("jbean",seo);    
            return mapping.findForward(SUCCESS);
//         return mapping.findForward("");
      
    }    

public ActionForward genFeeScrol(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
      HttpSession htsession=request.getSession(false);
        if(htsession.getAttribute("loginid") ==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
        }  
        FeeMath mm=new FeeMath();
        PrintWriter out=response.getWriter();
         ArrayList DegreeList=new ArrayList();
         MyMeth fun=new MyMeth();
        Degree dg=new Degree();
        String session=request.getParameter("ssn");
        String session_sem=request.getParameter("ssem");
        String regno=request.getParameter("rn");
        String deg=request.getParameter("degree");
        String stud_id=request.getParameter("stud_id");
        
//        String stud_type=request.getParameter("stud_type");
        SchoolEO seo=new SchoolEO(); 
        seo.setSession(session);
        seo.setRegistNo(regno);  
        seo.setDegree(deg);
        seo.setStud_id(stud_id);
        seo.setSession_sem(session_sem);
//        seo.setStud_type(stud_type);
      
        seo=(SchoolEO)mm.genFeeScroll(seo); 
 
        
         DegreeList=(ArrayList)fun.Degree_list();
        
         ArrayList ddlist=mm.retStud_fee_draft(seo);
         request.setAttribute("degreelist",DegreeList);
         request.setAttribute("ddlist",ddlist);
        request.setAttribute("jbean",seo);
        return mapping.findForward(SUCCESS);
//         return mapping.findForward("");
      
    }
    
public ActionForward gen_studFeeScroll(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
      HttpSession htsession=request.getSession(false);
        if(htsession.getAttribute("loginid") ==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
        }  
        FeeMath fm=new FeeMath();
        PrintWriter out=response.getWriter();
         ArrayList DegreeList=new ArrayList();
         MyMeth fun=new MyMeth();
        Degree dg=new Degree();
        String ssn=request.getParameter("session");
        String stud_id=request.getParameter("stud_id");
        
        
//        String stud_type=request.getParameter("stud_type");
        SchoolEO seo=new SchoolEO(); 
        SchoolEO seo1=new SchoolEO(); 
        seo.setSession(ssn);
        seo.setStud_id(stud_id);
        
        seo=fm.getDetailForFeeScroll(seo);
       
//        System.out.println("Counter: "+seo.getCounter());
      if(seo.getCounter()!=0){
//          Calendar cal = Calendar.getInstance();  
//            java.util.Date current=cal.getTime();
//            
//            cal.set(cal.DATE, 1);
//            cal.set(cal.MONTH, 4);
//            java.util.Date d1=cal.getTime();
//            
//            cal.set(cal.DATE, 30);
//            cal.set(cal.MONTH, 8);
//            java.util.Date d2=cal.getTime();
//            
//            cal.set(cal.DATE, 1);
//            cal.set(cal.MONTH, 10);
//            java.util.Date d3=cal.getTime();
//            
//            cal.set(cal.DATE, 28);
//            cal.set(cal.MONTH, 1);
//            cal.set(cal.YEAR, cal.get(cal.YEAR)+1);
//            java.util.Date d4=cal.getTime();
//            
//            String session_sem="";
//            if(current.after(d1) && current.before(d2))
//            {
//                session_sem="I";
//            }
//            else if(current.compareTo(d3) >= 0 && current.compareTo(d4) <= 0)
//            {
//                session_sem="II";
//            }
          String session_sem=request.getParameter("session_sem");
            seo.setSession_sem(session_sem);
        seo=(SchoolEO)fm.genFeeScroll(seo); 
        DegreeList=(ArrayList)fun.Degree_list();
        ArrayList ddlist=fm.retStud_fee_draft(seo);
         request.setAttribute("degreelist",DegreeList);
         request.setAttribute("ddlist",ddlist);
        request.setAttribute("jbean",seo);
        return mapping.findForward(SUCCESS);
      }
 else
      {
          request.setAttribute("msg", "Student Id is not found. Please first enter student id.");
          return mapping.findForward("error");
      }
          
//        return mapping.findForward(SUCCESS);
//         return mapping.findForward("");
      
    }    

public ActionForward gen_CmnFeeScroll(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
     HttpSession htsession=request.getSession(false);
        if(htsession.getAttribute("loginid") ==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
            }   
        FeeMath fm=new FeeMath();
        PrintWriter out=response.getWriter();
        String degree=request.getParameter("degree");
        String ses=request.getParameter("session");
        String session_sem=request.getParameter("session_sem");

        SchoolEO seo=new SchoolEO(); 
        seo.setDegree(degree);
        seo.setSession(ses);
        seo.setSession_sem(session_sem);
        seo.setSemester(session_sem);
        
        Dataconnectivity dc=new Dataconnectivity();
        Connection con=(Connection)dc.Dataconnect();
        con.setAutoCommit(false);
            
        try{
        boolean bn=fm.checkDetailsInSub_FeedataTable(seo);
        if(bn!=true){
            String ssn="";
            String ssn_sm="";
            if(seo.getSession_sem().equals("I")){
                ssn_sm="II";
                ssn=(Integer.parseInt(seo.getSession().substring(0,seo.getSession().lastIndexOf("-")))-1)+"-"+(Integer.parseInt(seo.getSession().substring(seo.getSession().lastIndexOf("-")+1,seo.getSession().length()))-1);
            }
            else{
                ssn_sm="I";
                ssn=seo.getSession();
            }
        ArrayList scrollList=new ArrayList();
        ArrayList batchlist=fm.retDistBatch(seo.getDegree());
        //System.out.println(batchlist.size()+" "+batchlist);
        ScrollPdf sp=new ScrollPdf();
        String msg="";
        String generatedPdfs="";
        for(int l=0;l<batchlist.size();l++){  
          seo.setBatch((String)batchlist.get(l));
          //System.out.println("batch: "+seo.getBatch());
          //seo.setBatch("2014");
        String filename=seo.getDegree()+"_"+seo.getBatch()+"_"+seo.getSession()+"_"+seo.getSession_sem()+".pdf";
        String file=getServlet().getServletContext().getRealPath("/ScrollInPDF")+"/"+filename;
        seo.setFilename(filename);
        
        
       
        bn=sp.checkPdf(seo);
        if(bn==true)
        {
            //scrollList=sp.retGeneratedScrollPdf(seo);
             msg=msg+"<li>You have already generated fee scroll for degree <i>"+seo.getDegree()+"</i> and batch <i>"+seo.getBatch()+"</i>"
                    + "( <i>"+seo.getSession()+"- "+seo.getSession_sem()+"</i> )</li>";
        }
        else{
      
          GenerateScrollPDF gsp=new GenerateScrollPDF();
           ArrayList list=new ArrayList();
          bn=fm.checkDetailsInExcelTable(seo);
          if(bn!=true){
            list=fm.genFeeScrollProgwise(seo,ssn,ssn_sm,con);
          }else{
              list=fm.genFeeScrollProgwiseForStoredDataInExcelTable(seo);
          }
//        System.out.println("list: "+list);
          if(list.size()>0){
      Document document = new Document();
      document.setPageSize(PageSize.A4.rotate());
      document.setMargins(0f, 0f, 0f, 0f);
      PdfWriter.getInstance(document, new FileOutputStream(file));
      document.open();
      gsp.addMetaData(document);
//      addTitlePage(document);
      gsp.addContent(document,list,seo);
      document.close();
      
      
      sp.addScrollPdfDetails(seo,con);
//      out.close();
      generatedPdfs=generatedPdfs+"<li>Fee scroll is generated for degree <i>"+seo.getDegree()+"</i> and batch <i>"+seo.getBatch()+"</i> "
                    + "( <i>"+seo.getSession()+"- "+seo.getSession_sem()+"</i> )</li>";
//    request.setAttribute("generated",msg);  
//    request.setAttribute("pdf",filename);
    //scrollList=sp.retGeneratedScrollPdf(seo);
          }
          else{
              generatedPdfs=generatedPdfs+"<li>No reocrd found for degree <i>"+seo.getDegree()+"</i> and batch <i>"+seo.getBatch()+"</i> "
                    + "( <i>"+seo.getSession()+"- "+seo.getSession_sem()+"</i> )</li>";
          }
        }       
     }
        con.commit();
        scrollList=sp.retGeneratedScrollPdf(seo);
        request.setAttribute("scrollList",scrollList);     
        request.setAttribute("jbean",seo);
        request.setAttribute("msg",msg); 
        request.setAttribute("generatedPdfs",generatedPdfs); 
        }else{
            request.setAttribute("err","You can not generate the scroll pdf for the degree "+seo.getDegree()+" and session "+seo.getSession()+"-"+seo.getSession_sem()+" because scroll has already generated and fee of the students have been processed.");
        }
        }catch(Exception e){
            e.printStackTrace();
            con.rollback();
            System.out.println("Connection is rollback when generating pdf scroll for students in FeeAction.gen_CmnFeeScroll(........) method");
            request.setAttribute("err","Some error occured in generating pdf. Please contact vendor.");
        }
        finally{
            try{
                if(con!=null) con.close();
            }catch(Exception e){}
        }
        MyMeth fun=new MyMeth();
        ArrayList DegreeList=new ArrayList();
        DegreeList=(ArrayList)fun.Degree_list();
        request.setAttribute("degreelist",DegreeList);
        
            return mapping.findForward(SUCCESS);
//         return mapping.findForward("");
    }        
    
    // Fee scroll using excel
    
    public ActionForward gen_CmnFeeScrollUsingExcel(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
       HttpSession htsession=request.getSession(false);
        if(htsession.getAttribute("loginid") ==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
        } 
        UploadFileForm uf=(UploadFileForm)form;
        
        FeeMath fm=new FeeMath();
        PrintWriter out=response.getWriter();
         
        
//        String stud_type=request.getParameter("stud_type");
        SchoolEO seo=new SchoolEO(); 
//        seo.setBatch(uf.getBatch());
        seo.setDegree(uf.getDegree());
        seo.setSession(uf.getSession());
        FormFile myFile =uf.getUploads1();
        
        
        Calendar cal = Calendar.getInstance();  
            java.util.Date current=cal.getTime();
            
            cal.set(cal.DATE, 1);
            cal.set(cal.MONTH, 4);
            java.util.Date d1=cal.getTime();
            
            cal.set(cal.DATE, 30);
            cal.set(cal.MONTH, 8);
            java.util.Date d2=cal.getTime();
            
            cal.set(cal.DATE, 1);
            cal.set(cal.MONTH, 10);
            java.util.Date d3=cal.getTime();
            
            cal.set(cal.DATE, 28);
            cal.set(cal.MONTH, 1);
            cal.set(cal.YEAR, cal.get(cal.YEAR)+1);
            java.util.Date d4=cal.getTime();
            
            String session_sem="";
            if(current.after(d1) && current.before(d2))
            {
                session_sem="I";
            }
            else if(current.compareTo(d3) >= 0 && current.compareTo(d4) <= 0)
            {
                session_sem="II";
            }
            //session_sem="II";
            seo.setSession_sem(session_sem);
            seo.setSemester(session_sem);
       Dataconnectivity dc=new Dataconnectivity();
        Connection con=(Connection)dc.Dataconnect();
        con.setAutoCommit(false);     
            boolean stchk=false;
    String fname=   myFile.getFileName();     
    if(myFile.getFileSize()!=0)
        {
         boolean chk=fm.checkExcel(fname);
         if(chk==false){
        byte[] fileData    = myFile.getFileData();
       
       InputStream st= myFile.getInputStream();
       fm.readExcelForScroll(seo, myFile);
       fm.addScrollExcelDetails(seo,fname);
       String dir=getServlet().getServletContext().getRealPath("/excel_files/"+fname);   //"/myfiledata";
   
       File f = new File(dir);        
        try{
        InputStream stream =myFile.getInputStream();
        OutputStream bos = new FileOutputStream(f);
        int bytesRead = 0;
byte[] buffer = new byte[5000 * 1024];
while ((bytesRead = stream.read(buffer, 0, buffer.length)) != -1) {
bos.write(buffer, 0, bytesRead);
bos.close();

stream.close();
}
           
            
}
catch(FileNotFoundException fnfe){}
  catch (IOException ioe) {}
       
  
       
       
    myFile.destroy();
    
    
    
   ArrayList batchlist=fm.retDistinctBatch(seo.getDegree());
    System.out.println("Size: "+batchlist.size());        
            try {
      for(int l=0;l<batchlist.size();l++){  
          seo.setBatch(batchlist.get(l).toString());
          System.out.println("Batch: "+seo.getBatch());    
          stchk=fm.checkStudentRegisOnBatch(seo);
       if(stchk==true){
        String filename=seo.getDegree()+"_"+seo.getBatch()+"_"+seo.getSession()+"_"+seo.getSemester()+".pdf";
        String file=getServlet().getServletContext().getRealPath("/ScrollInPDF")+"/"+filename;
        seo.setFilename(filename);
        
        ScrollPdf sp=new ScrollPdf();
        boolean bn=sp.checkPdf(seo);
        ArrayList scrollList=new ArrayList();
        
        if(bn==true)
        {
            scrollList=sp.retGeneratedScrollPdf(seo);
            String msg="You have already generated fee scroll for batch <i>"+seo.getBatch()+"</i> and degree <i>"+seo.getDegree()+"</i> "
                    + "( <i>"+seo.getSession()+"- "+seo.getSemester()+"</i> )";
           request.setAttribute("msg",msg); 
        }
        else{
      
          GenerateScrollPDF gsp=new GenerateScrollPDF();
        ArrayList list=fm.genFeeScrollProgwiseFromExcelData(seo);
      Document document = new Document();
      document.setPageSize(PageSize.A4.rotate());
      document.setMargins(0f, 0f, 0f, 0f);
//      Document document = new Document(PageSize.A4.rotate());
      PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream(file));
//      writer.addViewerPreference(PdfName.PRINTSCALING, PdfName.NONE);
      document.open();
      gsp.addMetaData(document);
//      addTitlePage(document);
//      System.out.println("list: "+list);
      gsp.addContent(document,list,seo);
      document.close();
      
      
      sp.addScrollPdfDetails(seo,con);
//      out.close();
      String msg="Fee scroll is generated for batch <i>"+seo.getBatch()+"</i> and degree <i>"+seo.getDegree()+"</i> "
                    + "( <i>"+seo.getSession()+"- "+seo.getSemester()+"</i> )";
    request.setAttribute("generated",msg);  
    request.setAttribute("pdf",filename);
    
        }
     
    
    request.setAttribute("scrollList",scrollList);     
    request.setAttribute("jbean",seo); 
    }else{
           request.setAttribute("err","There are no students in the database for batch <i>"+seo.getBatch()+"</i> and degree <i>"+seo.getDegree()+"</i>.");
           request.setAttribute("jbean",seo); 
       }
        }
    con.commit();
    } catch (Exception e) {
        System.out.println("Exc: "+e.getMessage());
        try{
            con.rollback();
        }catch(Exception ee){}
      e.printStackTrace();
      request.setAttribute("err","Some error occured in generating pdf. Please contact vendor.");
      //break;
    }
      finally{
            try{
                if(con!=null) con.close();
            }catch(Exception e){}
        }   
        }else{
        String msg="you have already uploaded this file <i>"+fname+"</i>. Now enter on the click button to generate pdf scroll for this excel sheet.";
        request.setAttribute("jbean",seo); 
        request.setAttribute("msg1",msg);
    }
        }
    MyMeth fun=new MyMeth();
        ArrayList DegreeList=new ArrayList();
        DegreeList=(ArrayList)fun.Degree_list();
        request.setAttribute("degreelist",DegreeList);
            return mapping.findForward(SUCCESS);
//         return mapping.findForward("");
      
    }    
// end for excel working
   public ActionForward newAdminNodues(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
      HttpSession htsession=request.getSession(false);
        if(htsession.getAttribute("loginid") ==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
        }  
        SchoolEO seo=new SchoolEO();
        String session=request.getParameter("session");
        String stud_id=request.getParameter("stud_id");
        String session_sem=request.getParameter("session_sem");
        seo.setSession(session);
        seo.setStud_id(stud_id);
       seo.setSession_sem(session_sem);
        ToDB tdb=new ToDB();
        // get student details with session
        seo=tdb.getStudentDetails(seo.getStud_id(),seo.getSession());
        seo.setSession(session);
        seo.setStud_id(stud_id);
       seo.setSession_sem(session_sem);
        if(seo.getCounter()!=0){
         FeeMath fm=new FeeMath();
         int cn=fm.checkSubmited_feeData(seo);
         seo.setCounter(cn);
//         System.out.println("counter: "+cn);
         if(cn!=0){
        double tt=fm.retTotalSubmitted(stud_id, session,session_sem);
    request.setAttribute("jbean",seo); 
    request.setAttribute("tt",Double.toString(tt)); 
    if(cn==2)
        request.setAttribute("msg","No dues has been given to this student id "+stud_id); 
        }
         else if(cn==0){
             request.setAttribute("msg","Fee details is not found for the student id "+stud_id+" session "+seo.getSession()+"-"+seo.getSession_sem()); 
         }
        }
        else
            request.setAttribute("msg","Student Details is not found for this student id "+stud_id+" and for the session "+session); 
   
            return mapping.findForward(SUCCESS);
//         return mapping.findForward("");
      
    }    

  public ActionForward finePr(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
      HttpSession htsession=request.getSession(false);
        if(htsession.getAttribute("loginid") ==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
        }  
        SchoolEO seo=new SchoolEO();
        String session=request.getParameter("session");
        String stud_id=request.getParameter("stud_id");
        String session_sem=request.getParameter("ses");
        FeeMath fm=new FeeMath();
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sde=new SimpleDateFormat("dd-MM-yyyy");
        seo.setStud_id(stud_id);
        seo=fm.getStudentDetails(seo);
        seo.setSession_sem(session_sem);
        seo.setSession(session);
        seo=fm.fineReturn(seo);
        if(seo.getCounter()==0)
            seo=fm.calFineOnLateFeeSubm(seo);
        request.setAttribute("jbean", seo);
            return mapping.findForward(SUCCESS);
//         return mapping.findForward("");
      
    }    
   
public ActionForward othercollegestud(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
   HttpSession htsession=request.getSession(false);
        if(htsession.getAttribute("loginid") ==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
        } 
    FeeMath fm=new FeeMath();
    Reports_DB rdb=new Reports_DB();        
        
        String type=request.getParameter("type");
    if(type.equals("Submit")){    
        SchoolEO seo=new SchoolEO();
        String session=request.getParameter("session");
        String stud_id=request.getParameter("stud_id");
        String session_sem=request.getParameter("session_sem");
        String bank=request.getParameter("bnk_name");
        String date1=request.getParameter("date1");
        String amount=request.getParameter("amount");
        String sname="";
        String degree="";
        String receipt="";
        if(request.getParameter("sname")!=null)
            sname=request.getParameter("sname");
        if(request.getParameter("degree")!=null)
            degree=request.getParameter("degree");
        if(request.getParameter("receipt_no")!=null)
            receipt=request.getParameter("receipt_no");
        
        
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sde=new SimpleDateFormat("dd-MM-yyyy");
        seo.setStud_id(stud_id);
        seo.setSession_sem(session_sem);
        seo.setSession(session);
        seo.setSname(sname);
        seo.setDegree(degree);
        seo.setBankname(bank);
        seo.setRecnum(receipt);
        seo.setDeposite_date(sdf.parse(date1));
        seo.setTotalFee(Double.parseDouble(amount));
        fm.insertIn_stud_other_inst(seo);
    }
    
    String trans="Both";
    if(request.getParameter("trans")!=null)
        trans=request.getParameter("trans");
    int page = 1;
    int recordsPerPage = 50;
    if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
    int offset=(page-1)*recordsPerPage;
        
    ArrayList list=rdb.otherCollegeStudent(offset,recordsPerPage,trans);
        
    int noOfRecords = rdb.getNoOfRecords();
    int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        
    request.setAttribute("offset", Integer.toString(offset));
    request.setAttribute("noOfPages", noOfPages);
    request.setAttribute("currentPage", page);
    request.setAttribute("list", list);
    request.setAttribute("trans", trans);
    return mapping.findForward(SUCCESS);
//    return mapping.findForward("");
      
    }    
       
public ActionForward tranfserStudAm(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    HttpSession htsession=request.getSession(false);
        if(htsession.getAttribute("loginid") ==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
        }
    FeeMath fm=new FeeMath();
    Reports_DB rdb=new Reports_DB();        
    PrintWriter out=response.getWriter();
    int rid=0;
    try{
        rid=Integer.parseInt(request.getParameter("rid"));
    }catch(NumberFormatException nf){
        out.println("Please do not make any change in the url link");
        return mapping.findForward("");
    }
    String trans=request.getParameter("trans");
    String trans_to=request.getParameter("trans_to");
    rdb.upOtherCollegeStudent(rid,trans_to);
    int page = 1;
    int recordsPerPage = 50;
    if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
    int offset=(page-1)*recordsPerPage;
        
    ArrayList list=rdb.otherCollegeStudent(offset,recordsPerPage,trans);
        
    int noOfRecords = rdb.getNoOfRecords();
    int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        
    request.setAttribute("offset", Integer.toString(offset));
    request.setAttribute("noOfPages", noOfPages);
    request.setAttribute("currentPage", page);
    request.setAttribute("list", list);
    request.setAttribute("trans", trans);
    return mapping.findForward(SUCCESS);
//    return mapping.findForward("");
      
    }   

public ActionForward feeManipulationPdf(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    HttpSession htsession=request.getSession(false);
    if(htsession.getAttribute("loginid") ==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
    }
    User_role_bean urb=(User_role_bean)htsession.getAttribute("user_auth");
            String chk="yes";
            if(urb.getUr_update().equals(chk)){
        PrintWriter out=response.getWriter();
        FeeMath fm=new FeeMath();
        String session=request.getParameter("session");
        String stud_id=request.getParameter("stud_id");
        String table="studentregis";
        int cnt=fm.checkStudent_in(table, stud_id);
        if(cnt!=0){
        String submit=request.getParameter("submit");
        SchoolEO seo=new SchoolEO();
        seo.setStud_id(stud_id);
        

        String session_sem=request.getParameter("session_sem");
        
        SchoolEO seo1=fm.getStudentDetails(seo);
        seo1.setSession(session);
        seo1.setSession_sem(session_sem);
//        seo1.setTransaction_id(tran_id);
        int cn=0;
        if(submit.equals("Update")){            
            ArrayList ar1=new ArrayList();
        ArrayList ar2=new ArrayList();
        HashMap hm1=new HashMap();
          double fftot=0;
        Enumeration en=(Enumeration)request.getParameterNames();
        String param="";
        while(en.hasMoreElements()){
        param=(String)en.nextElement(); 
        try{
        if(param.substring(0,3).equals("fee")){
        ar1.add(param);
        }    
        }catch(StringIndexOutOfBoundsException e){}
        }
 
        for(int i=0;i<ar1.size();i++){
            if(request.getParameter("fee"+i)!=null&&!request.getParameter("fee"+i).equals(""))
            {
                ar2.add(request.getParameter("fd"+i));
                hm1.put(request.getParameter("fd"+i),request.getParameter("fee"+i));
                fftot=fftot+Double.parseDouble(request.getParameter("fee"+i));
            }
        }
            try{
            seo1.setPamount(Double.parseDouble(request.getParameter("p_fee")));
            seo1.setEamount(Double.parseDouble(request.getParameter("ex_fee")));
            }catch(Exception e){}
            seo1.setFeeTotal(fftot+seo1.getPamount()+seo1.getEamount());
        seo=seo1;   
        seo1.setDataArray(ar2);
        seo1.setDataMap(hm1);
            
//            System.out.println(cn);
            
                int n=fm.updateStud_fee_detailExcel(seo, seo1);
                if(n==1)
                {
                    fm.updateSud_feedata(seo);
                    ScrollPdf scrollPdf=new ScrollPdf();
                    String filename=seo.getDegree()+"_"+seo.getBatch()+"_"+seo.getSession()+"_"+seo.getSession_sem()+".pdf";
                    //System.out.println("filename: "+filename);
                    scrollPdf.delPdf(filename);
                    request.setAttribute("msg", "Fee detail is updated.");
                }
                else
                    {
                    ArrayList al=fm.bankList();
                    request.setAttribute("bnklist", al);
                    request.setAttribute("jbean", seo1);
                    request.setAttribute("msg", "Fee can not be update for this student. Please contact with the vendor.");
                    return mapping.findForward(SUCCESS);
                }
            
            
           
            seo1=fm.ret_stud_fee_detail_excel(seo1);
        }
        else{
            seo1=fm.ret_stud_fee_detail_excel(seo1);
            if(seo1.getDataMap().size()==0)
                request.setAttribute("msg", "Once you create pdf for this student, you can manipulate fee for pdf.");
          }

            request.setAttribute("jbean", seo1);
        }
        else
            request.setAttribute("msg", "Student details is not found in our record.");
       }
        else
             request.setAttribute("msg", "You are not authorized to access this page.");   
    return mapping.findForward(SUCCESS);
//    return mapping.findForward("");
      
    }   

public ActionForward checkStudentDetail(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    //   PrintWriter out=response.getWriter();        
        ArrayList al1=new ArrayList();
        SchoolEO seo=new SchoolEO();
        String session=""; 
        String session_sem="";
        String regno="";
        int rows=0;
        
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
        seo.setSession(session);
        seo.setSession_sem(session_sem);
        seo.setSrnum(regno);
        //System.out.println(seo.getSession()+""+seo.getSrnum());
     DataObj doj=new DataObj();
     FeeMath fm=new FeeMath();
     int cn=doj.checkStudId(seo);
       //System.out.println("sname: "+seo1.getSname());
     
     
     if(cn==-4){
           request.setAttribute("msg", "Student details is not found.");
       }
     else{
         SchoolEO seo1=fm.retstudData(regno, session);
         seo1.setSession_sem(session_sem);
         seo1.setCounter(cn);
        if(cn==0)
            {
                request.setAttribute("msg", "No fee record is found!");
            }
        else if(cn>=0){
            al1=doj.getDraftList(seo1);
            request.setAttribute("list",al1);
            request.setAttribute("edit", "edit");
       }
       else if(cn==-2){
            al1=doj.getDraftList(seo1);
            request.setAttribute("list",al1);
           request.setAttribute("msg", "Student Id is already present to this student.");
       }
     }
        return mapping.findForward(SUCCESS);
//        return mapping.findForward("");
    }


               
}
