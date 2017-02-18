/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fee;

import ActionClass.DataObj;
import ActionClass.FeeMethod;
import ActionClass.MyMeth;
import EO.SchoolEO;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author kapil
 */
public class View_EditFee extends DispatchAction {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";

    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction1, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     */
public ActionForward updCounsFeeDt(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrintWriter out=response.getWriter();
        
        MyMeth mm=new MyMeth();
        ArrayList al=new ArrayList();
     SchoolEO seo=new SchoolEO();
         SchoolEO seo1=new SchoolEO();
         SchoolEO seo2=new SchoolEO();
         String session="";
         String session_sem="";
        String regno="";
         int n=0;
        int rows=0;
        
        if(request.getParameter("session")!=null)
        {
            session=(String)request.getParameter("session");
        }
        if(request.getParameter("session_sem")!=null)
        {
            session_sem=(String)request.getParameter("session_sem");
        }
        if(request.getParameter("srnum")!=null)
        {
            regno=(String)request.getParameter("srnum");
        }
        try
        {
             if(request.getParameter("rows")!=null)
             {
                 rows=Integer.parseInt(request.getParameter("rows").toString());
             }
        }catch(Exception e){}
        
        ArrayList ar=new ArrayList();
        ArrayList ar1=new ArrayList();
        ArrayList ar2=new ArrayList();
        ArrayList ar3=new ArrayList();
        ArrayList ar4=new ArrayList();
        
        int k=0;
        double am=0.0;
     for(int i=0;i<rows;i++)
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
                     catch(Exception eee)
                     {
                         request.setAttribute("msg", "wrong amount entered. Please entered only number in amount"); 
                          return mapping.findForward(SUCCESS);
                     }
                 }
                 else
                 {
                     ar3.add(am);
                 }
               }catch(Exception e){e.getMessage();
             ar3.add(am);
             }
             try
             {
                   if(request.getParameter("rwid_"+k)!=null&&!request.getParameter("rwid_"+k).equals(""))
                 {
                    ar4.add(Long.parseLong(request.getParameter("rwid_"+k).toString())); 
                 }
             }catch(Exception e1){e1.getMessage();}
           }
//     out.println(ar4.get(0)+"..."+ar4.get(1));
        seo.setSession(session);
        seo.setSession_sem(session_sem);
        seo.setRegistNo(regno);
        seo.setCounter(rows);
//        out.println(seo.getCounter());
        seo.setDataArray(ar);
        seo.setDataArray1(ar1);
        seo.setDataArray2(ar2);
        seo.setDataArray3(ar3);
        seo.setDataArray4(ar4);
        seo.setStatus("updating");
        
        String dd_no=mm.checkDraftNumInTable("stud_draft", seo);  
      if(!dd_no.equals("")){
            request.setAttribute("edit", "edit");
            request.setAttribute("chk","chk");
            request.setAttribute("msg1", "Advance amount can not be submitted. Duplicate DD number : "+dd_no);
            //return mapping.findForward(SUCCESS); 
      }
      else{
        UpdateFee upd=new UpdateFee();
        upd.updateAdvDraft(seo);
        request.setAttribute("msg", "Record is Updated");
        request.setAttribute("view", "view");
      }
        seo1=(SchoolEO)mm.retstudData(seo);
        al=(ArrayList)mm.retCounsFee(seo);
        System.out.println("size: "+al.size());
        request.setAttribute("jbean",seo1);
        request.setAttribute("list",al);
        return mapping.findForward(SUCCESS);
//         return mapping.findForward("");
    }
    
public ActionForward getStudentId(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrintWriter out=response.getWriter();
        SchoolEO seo=new SchoolEO();
         SchoolEO seo1=new SchoolEO();
        String ssn="";
        String regno="";
        int rows=0;
        
        if(request.getParameter("session")!=null)
        {
            ssn=(String)request.getParameter("session");
        }
        if(request.getParameter("srnum")!=null)
        {
            regno=(String)request.getParameter("srnum");
        }
        seo.setSession(ssn);
        seo.setSrnum(regno);
//        out.println(seo.getSession()+""+seo.getSrnum());
         UpdateFee upd=new UpdateFee();
       seo1=upd.getStud_Id(seo);
       
       if(seo1.getStud_id()!=null)
       {
        request.setAttribute("jbean1",seo1);
        request.setAttribute("edit", "edit");
       }
       else
       {
            request.setAttribute("msg", "Student Id is not entered");
       }
        return mapping.findForward(SUCCESS);
//        return mapping.findForward("");
    }

 
public ActionForward updateStudentId(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrintWriter out=response.getWriter();
        SchoolEO seo=new SchoolEO();
         SchoolEO seo1=new SchoolEO();
        String ssn="";
        String regno="";
        String stud_id="";
        int row=0;
        
        if(request.getParameter("session")!=null)
        {
            ssn=(String)request.getParameter("session");
        }
        if(request.getParameter("srnum")!=null)
        {
            regno=(String)request.getParameter("srnum");
        }
        if(request.getParameter("stud_id")!=null)
        {
            stud_id=(String)request.getParameter("stud_id");
        }
        try
        {
            if(request.getAttribute("rowid")!=null)
            {
                row=Integer.parseInt(request.getAttribute("rowid").toString());
            }
        }catch(Exception e){System.out.println("kkkkkkk");}
        
        String old_stud_id=request.getParameter("old_stud_id");
        seo.setSession(ssn);
        seo.setSrnum(regno);
        //seo.setRowid(row);
        seo.setStud_id(stud_id);
//        out.println(stud_id);
//        out.println(row);
        
         UpdateFee upd=new UpdateFee();
       
            upd.updateStud_Id(seo,old_stud_id);
            seo1=upd.getStud_Id(seo);
        
        request.setAttribute("jbean1",seo1);
        request.setAttribute("view", "view");
        request.setAttribute("msg", "Student Id is updated");
        return mapping.findForward(SUCCESS);
//         return mapping.findForward("");
    }
 

public ActionForward getStudentDetail(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrintWriter out=response.getWriter();
        SchoolEO seo=new SchoolEO();
         SchoolEO seo1=null;
        String ssn="";
//        String regno="";
        String stud_id="";
        int rows=0;
        
        if(request.getParameter("session")!=null)
        {
            ssn=(String)request.getParameter("session");
        }
//        if(request.getParameter("regist_no")!=null)
//        {
//            regno=(String)request.getParameter("regist_no");
//        }
        if(request.getParameter("stud_id")!=null)
        {
            stud_id=(String)request.getParameter("stud_id");
        }
        seo.setSession(ssn);
//        seo.setSrnum(regno);
        seo.setStud_id(stud_id);
         ArrayList DegreeList=new ArrayList();
         MyMeth fun=new MyMeth();
         DegreeList=(ArrayList)fun.Degree_list();
        
           
//        out.println(seo.getSession()+""+seo.getSrnum());
         UpdateFee upd=new UpdateFee();
       seo1=upd.getStud_Dt(seo);
//       out.println("HHH3: "+seo1);
       if(seo1!=null)
       {
        request.setAttribute("jbean1",seo1);
        request.setAttribute("degreelist",DegreeList);
        request.setAttribute("chk", "edit");
       }
       else
       {
            request.setAttribute("msg", "Student Details is not found");
       }
        return mapping.findForward(SUCCESS);
//        return mapping.findForward("");
    }
 
public ActionForward updateStudDetail(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrintWriter out=response.getWriter();
        SchoolEO seo=new SchoolEO();
         SchoolEO seo1=null;
        String ssn="";
        
        String stud_id="";
        String degree="";
        String stud_type="";
        String icar="";
        String gate="NO";
        String prev_degree="";
        int row=0;
        
        if(request.getParameter("session")!=null)
        {
            ssn=(String)request.getParameter("session");
        }
        if(request.getParameter("stud_id")!=null)
        {
            stud_id=(String)request.getParameter("stud_id");
        }
        if(request.getParameter("degree")!=null)
        {
            degree=(String)request.getParameter("degree");
        }
        if(request.getParameter("stud_type")!=null)
        {
            stud_type=(String)request.getParameter("stud_type");
        }
        if(request.getParameter("icar")!=null)
        {
            icar=(String)request.getParameter("icar");
        }
        if(request.getParameter("gate")!=null)
        {
            gate=(String)request.getParameter("gate");
        }
        if(request.getParameter("prev_degree")!=null)
        {
            prev_degree=(String)request.getParameter("prev_degree");
        }
        String prv_stud_type="";
        if(request.getParameter("prev_stud_type")!=null)
        {
            prv_stud_type=(String)request.getParameter("prev_stud_type");
        }
        
        UpdateFee upd=new UpdateFee();
        
        seo.setSession(ssn);
        seo.setStud_id(stud_id);
        seo=upd.getStud_Dt(seo);
        
        String icar_o=seo.getIcar();
        seo.setDegree(degree);
        seo.setStud_type(stud_type);
        seo.setIcar(icar);
        seo.setGate(gate);
        
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
            seo.setSession_sem(session_sem);
        
        
        double adjustment=0;
        double nowSubmitFee=0;
        try{
            if(request.getParameter("adjustment")!=null)
                adjustment=Double.parseDouble(request.getParameter("adjustment"));
            if(request.getParameter("npfee")!=null)
                nowSubmitFee=Double.parseDouble(request.getParameter("npfee"));
        }catch(Exception e){}
        
     if(adjustment>0){
         seo.setFeeReceipt(upd.returnFeeReceipt(seo));
        ArrayList ar=new ArrayList();
        ArrayList ar1=new ArrayList();
        ArrayList ar2=new ArrayList();
        ArrayList ar3=new ArrayList();
        
        int k=0;
        double am=0.0;
        double sum_fee_draft=0;
        double fee_draft=0;
     for(int i=0;i<2;i++)
        {
            k=i+1;
            if(request.getParameter("dd_"+k)!=null&&!request.getParameter("dd_"+k).equals(""))
            {
             ar.add(request.getParameter("dd_"+k));
             ar1.add(request.getParameter("dddate_"+k));
             ar2.add(request.getParameter("bnk_"+k));
             try{
                 if(request.getParameter("damnt_"+k)!=null&&!request.getParameter("damnt_"+k).equals(""))
                 {
                     try{
                         fee_draft=Double.parseDouble(request.getParameter("damnt_"+k));
                    ar3.add(fee_draft); 
                    sum_fee_draft=sum_fee_draft+fee_draft;
                   }
                     catch(Exception ee){}
                 }
                 else
                 {
                     ar3.add(am);
                 }
                 
             }catch(Exception e){e.getMessage();
             ar3.add(am);
             }
           }
        }
        seo.setDataArray(ar);
        seo.setDataArray1(ar1);
        seo.setDataArray2(ar2);
        seo.setDataArray3(ar3);
        
        FeeMath fm=new FeeMath();
        FeeMethod fm1=new FeeMethod();
        seo1=fm.retFeeHeadwiseFromStruc(seo);
        seo.setPamount(fm1.financialProgrammeFee(seo));
        HashMap<String,String> hm=fm.retFeeHeads();
        
        upd.updateStud_fee_detailHeadsZero(seo, hm);
        upd.insertAdjustmentInStud_fee_draft(seo);
        upd.updateStud_fee_detail(seo, seo1);
        upd.insertDetailsOfChange(seo, prev_degree, sum_fee_draft,prv_stud_type,icar_o);
//        if(icar_o!=null&&icar_o.equals("YES"))
//                nowSubmitFee=nowSubmitFee-2000;
//        double adv=upd.feeSubmittedAdvAmount(seo);
//        seo.setFeeTotal(nowSubmitFee-adv);
        seo.setFeeTotal(nowSubmitFee+seo.getPamount());
        upd.updateSub_feedata(seo);
       }
       else if(adjustment<0)
       {
            FeeMath fm=new FeeMath();
            FeeMethod fm1=new FeeMethod();
            seo1=fm.retFeeHeadwiseFromStruc(seo);
            seo.setPamount(fm1.financialProgrammeFee(seo));
            
            HashMap<String,String> hm=fm.retFeeHeads();
        
            upd.updateStud_fee_detailHeadsZero(seo, hm);
            upd.updateStud_fee_detail(seo, seo1);
            upd.insertDetailsOfChange(seo, prev_degree, adjustment,prv_stud_type,icar_o);
//            if(icar_o!=null&&icar_o.equals("YES"))
//                nowSubmitFee=nowSubmitFee-2000;
//            double adv=upd.feeSubmittedAdvAmount(seo);
//            seo.setFeeTotal(nowSubmitFee-adv);
            seo.setFeeTotal(nowSubmitFee+seo.getPamount());
            upd.updateSub_feedata(seo);
       }
        
         
       
            upd.updateStud_Dt(seo);
            seo1=upd.getStud_Dt(seo);
        
        request.setAttribute("jbean1",seo1);
        request.setAttribute("chk", "view");
        request.setAttribute("msg", "Student Detail is updated");
        return mapping.findForward(SUCCESS);
//         return mapping.findForward("");
    }
  
public ActionForward updateStudDetail1(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrintWriter out=response.getWriter();
        SchoolEO seo=new SchoolEO();
         SchoolEO seo1=null;
        String ssn="";
        
        String stud_id="";
        String degree="";
        String stud_type="";
        String icar="";
        String gate="NO";
        int row=0;
        
        if(request.getParameter("session")!=null)
        {
            ssn=(String)request.getParameter("session");
        }
        if(request.getParameter("stud_id")!=null)
        {
            stud_id=(String)request.getParameter("stud_id");
        }
        if(request.getParameter("degree")!=null)
        {
            degree=(String)request.getParameter("degree");
        }
        if(request.getParameter("stud_type")!=null)
        {
            stud_type=(String)request.getParameter("stud_type");
        }
        if(request.getParameter("icar")!=null)
        {
            icar=(String)request.getParameter("icar");
        }
        if(request.getParameter("gate")!=null)
        {
            gate=(String)request.getParameter("gate");
        }
        
        UpdateFee upd=new UpdateFee();
        
        seo.setSession(ssn);
        seo.setStud_id(stud_id);
        seo=upd.getStud_Dt(seo);
        
        seo.setDegree(degree);
        seo.setStud_type(stud_type);
        seo.setIcar(icar);
        seo.setGate(gate);
        
        FeeMath fm=new FeeMath();
            FeeMethod fm1=new FeeMethod();
            seo1=fm.retFeeHeadwiseFromStruc(seo);
            seo.setPamount(fm1.financialProgrammeFee(seo));
            upd.updateStud_fee_detail(seo, seo1);
            
      
        
         
       
            upd.updateStud_Dt(seo);
            seo1=upd.getStud_Dt(seo);
        
        request.setAttribute("jbean1",seo1);
        request.setAttribute("chk", "view");
        request.setAttribute("msg", "Student Detail is updated");
        return mapping.findForward(SUCCESS);
//         return mapping.findForward("");
    }
   
public ActionForward getStudentProgDraft(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
       PrintWriter out=response.getWriter();        
        FeeMath fm=new FeeMath();  
        ArrayList al=new ArrayList();
        ArrayList al1=new ArrayList();
         MyMeth fun=new MyMeth();
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
        if(request.getParameter("srnum")!=null)
        {
            regno=(String)request.getParameter("srnum");
        }
        seo.setSession(session);
        seo.setSession_sem(session_sem);
        seo.setSrnum(regno);
//        out.println(seo.getSession()+""+seo.getSrnum());
         UpdateFee upd=new UpdateFee();
         DataObj dob=new DataObj();
         ArrayList bnklist=new ArrayList();

       SchoolEO seo1=upd.getStud_Id(seo);
       if(!seo1.getSname().equals("")){
       al=upd.getStudProgDraft(seo);
//        seo1=fm.retFeeRecData(seo);
        al1=upd.getStudFeeDetail(seo);
       bnklist=dob.retBankName();
//        out.println(al.size());
      
        request.setAttribute("list",al);
//        request.setAttribute("jbean",seo1);
        request.setAttribute("bnklist",bnklist);
        request.setAttribute("list1",al1);
        request.setAttribute("edit", "edit");
       
       }
       else{
           request.setAttribute("msg", "Student details is not found.");
       }
        return mapping.findForward(SUCCESS);
//        return mapping.findForward("");
    }
 
 
public ActionForward updateStuProgDraft(ActionMapping mapping, ActionForm form,
             HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrintWriter out=response.getWriter();
        String session="";
        String session_sem="";
        String or_session_sem="";
        String regno="";
        int row=0;
        
        if(request.getParameter("session")!=null)
        {
            session=(String)request.getParameter("session");
        }
        if(request.getParameter("session_sem")!=null)
        {
            session_sem=(String)request.getParameter("session_sem");
        }
        if(request.getParameter("or_session_sem")!=null)
        {
            or_session_sem=(String)request.getParameter("or_session_sem");
        }
        if(request.getParameter("srnum")!=null)
        {
            regno=(String)request.getParameter("srnum");
        }
        try
        {
             if(request.getParameter("row")!=null)
             {
                 row=Integer.parseInt(request.getParameter("row").toString());
             }
        }catch(Exception e){}        
        
        ArrayList ar=new ArrayList();
        ArrayList ar1=new ArrayList();
        ArrayList ar2=new ArrayList();
        ArrayList ar3=new ArrayList();
        ArrayList ar4=new ArrayList();
        
        int k=0;
        double am=0.0;
     for(int i=0;i<row;i++)
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
                     catch(Exception eee)
                     {
                      request.setAttribute("msg", "Wrong amount entered. Please do not enter any character as amount");
                        return mapping.findForward(SUCCESS);   
                     }
                 }
                 else
                 {
                     ar3.add(am);
                 }
              }catch(Exception e){e.getMessage();
             ar3.add(am);
             }
             try
             {
                   if(request.getParameter("rwid_"+k)!=null&&!request.getParameter("rwid_"+k).equals(""))
                 {
                    ar4.add(Long.parseLong(request.getParameter("rwid_"+k).toString())); 
                 }
             }catch(Exception e1){e1.getMessage();}
           }
//     out.println(ar4.get(0)+"..."+ar4.get(1));
     
     
     MyMeth mm=new MyMeth();
        ArrayList al=new ArrayList();
        ArrayList al1=new ArrayList();
     SchoolEO seo=new SchoolEO();
         SchoolEO seo1=new SchoolEO();
         SchoolEO seo2=new SchoolEO();
         int n=0;
        seo.setSession(session);
        seo.setSession_sem(session_sem);
        seo.setRegistNo(regno);
         seo.setSrnum(regno);
        seo.setCounter(row);
        //out.println(seo.getCounter());
       
        seo.setDataArray(ar);
        seo.setDataArray1(ar1);
        seo.setDataArray2(ar2);
        seo.setDataArray3(ar3);
         seo.setDataArray4(ar4);
        
        UpdateFee upd=new UpdateFee();
       try{
        upd.updateProgDraft(seo,or_session_sem);
        request.setAttribute("msg", "Record is Updated");
       }
       catch(Exception e){
           request.setAttribute("msg", "Updation failed. Please try again!!!");
       }
        ArrayList bnklist=new ArrayList();
        DataObj dob=new DataObj();
        
       al=upd.getStudProgDraft(seo);
//        seo1=fm.retFeeRecData(seo);
        al1=upd.getStudFeeDetail(seo);
       bnklist=dob.retBankName();
//        out.println(".."+seo.getSession()+".."+seo.getSrnum());
      
        request.setAttribute("list",al);
//        request.setAttribute("jbean",seo1);
        request.setAttribute("bnklist",bnklist);
        request.setAttribute("list1",al1);
        
        
            
//            request.setAttribute("view", "view");
        
        //out.close();
        return mapping.findForward(SUCCESS);
//         return mapping.findForward("");
    }


    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction2, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     */
    public ActionForward checkAmount(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrintWriter out=response.getWriter();
        SchoolEO seo=new SchoolEO();
         SchoolEO seo1=null;
        String ssn="";
        String stud_id="";
        int rows=0;
        
        if(request.getParameter("session")!=null)
        {
            ssn=(String)request.getParameter("session");
        }
        if(request.getParameter("stud_id")!=null)
        {
            stud_id=(String)request.getParameter("stud_id");
        }
        String prev_degree=request.getParameter("prev_degree");
        String changeToDegree=request.getParameter("degree");
        
        seo.setSession(ssn);
        seo.setStud_id(stud_id);
        seo.setDegree(changeToDegree);
        seo.setStud_type(request.getParameter("stud_type"));
        
         ArrayList DegreeList=new ArrayList();
         MyMeth fun=new MyMeth();
         DegreeList=(ArrayList)fun.Degree_list();
        

         UpdateFee upd=new UpdateFee();
         seo1=upd.getStud_Dt(seo);

       if(seo1!=null)
       {
           FeeMath fm1=new FeeMath();
           String prv_stud_type=seo1.getStud_type();
           seo1.setStud_type(seo.getStud_type());
        request.setAttribute("jbean1",seo1);
        request.setAttribute("degreelist",DegreeList);
        request.setAttribute("chk", "edit");
        if(!prev_degree.equals(seo.getDegree())&&prv_stud_type.equals(seo.getStud_type()))
        { 
            FeeMethod fm=new FeeMethod();
            ArrayList ar3=null;
            String nowSubmitFee="0";
            if(seo.getStud_type().equalsIgnoreCase("Staff")){
                ar3=new ArrayList();
                ar3.add("TUITION FEE");
                ar3.add("LAB FEE");
                nowSubmitFee=fm.retStaffTotalFees(seo.getDegree(), ar3, "MALE", seo.getSession());
            }
            else
            {
                ar3=(ArrayList)fm.fee_Heads(seo.getStud_type()); 
                nowSubmitFee=fm.retTotalFees(seo.getDegree(), ar3, "MALE", seo.getSession());
            }
//            out.println(ar3);
//            out.println("<br> nowSubmitFee: "+nowSubmitFee);
            double submittedFee=upd.feeSubmittedAmount(seo);
//            double adv=upd.feeSubmittedAdvAmount(seo);
            double self_finan_fee=fm.financialProgrammeFee(seo);
//            if(seo1.getIcar()!=null&&seo1.getIcar().equals("YES"))
//                submittedFee=submittedFee+2000;
            request.setAttribute("changeToDegree", changeToDegree);
//            request.setAttribute("submittedFee", Double.toString(submittedFee+adv));
            request.setAttribute("submittedFee", Double.toString(submittedFee));
            request.setAttribute("nowSubmitFee", nowSubmitFee);
            request.setAttribute("self_finan_fee", Double.toString(self_finan_fee));
            request.setAttribute("prv_stud_type", prv_stud_type);
            ArrayList ddlist=fm1.retStud_fee_draftALL(seo);
            request.setAttribute("ddlist",ddlist);
        }
        if(prev_degree.equals(seo.getDegree())&&!prv_stud_type.equals(seo.getStud_type()))
        {
            FeeMethod fm=new FeeMethod();
            ArrayList ar3=null;
            String nowSubmitFee="0";
            if(seo.getStud_type().equalsIgnoreCase("Staff")){
                ar3=new ArrayList();
                ar3.add("TUITION FEE");
                ar3.add("LAB FEE");
                nowSubmitFee=fm.retStaffTotalFees(seo.getDegree(), ar3, "MALE", seo.getSession());
            }
            else
            {
                ar3=(ArrayList)fm.fee_Heads(seo.getStud_type()); 
                nowSubmitFee=fm.retTotalFees(seo.getDegree(), ar3, "MALE", seo.getSession());
            }
//            out.println(ar3);
//            out.println("<br> nowSubmitFee: "+nowSubmitFee);
            double submittedFee=upd.feeSubmittedAmount(seo);
//            double adv=upd.feeSubmittedAdvAmount(seo);
            double self_finan_fee=fm.financialProgrammeFee(seo);
//            if(seo1.getIcar()!=null&&seo1.getIcar().equals("YES"))
//                submittedFee=submittedFee+2000;
            request.setAttribute("changeToDegree", changeToDegree);
//            request.setAttribute("submittedFee", Double.toString(submittedFee+adv));
            request.setAttribute("submittedFee", Double.toString(submittedFee));
            request.setAttribute("nowSubmitFee", nowSubmitFee);
            request.setAttribute("self_finan_fee", Double.toString(self_finan_fee));
            request.setAttribute("prv_stud_type", prv_stud_type);
            ArrayList ddlist=fm1.retStud_fee_draftALL(seo);
            request.setAttribute("ddlist",ddlist);
        }
        if(!prev_degree.equals(seo.getDegree())&&!prv_stud_type.equals(seo.getStud_type()))
        {
            FeeMethod fm=new FeeMethod();
            ArrayList ar3=null;
            String nowSubmitFee="0";
            if(seo.getStud_type().equalsIgnoreCase("Staff")){
                ar3=new ArrayList();
                ar3.add("TUITION FEE");
                ar3.add("LAB FEE");
                nowSubmitFee=fm.retStaffTotalFees(seo.getDegree(), ar3, "MALE", seo.getSession());
            }
            else
            {
                ar3=(ArrayList)fm.fee_Heads(seo.getStud_type()); 
                nowSubmitFee=fm.retTotalFees(seo.getDegree(), ar3, "MALE", seo.getSession());
            }
//            out.println(ar3);
//            out.println("<br> nowSubmitFee: "+nowSubmitFee);
            double submittedFee=upd.feeSubmittedAmount(seo);
//            double adv=upd.feeSubmittedAdvAmount(seo);
            double self_finan_fee=fm.financialProgrammeFee(seo);
//            if(seo1.getIcar()!=null&&seo1.getIcar().equals("YES"))
//                submittedFee=submittedFee+2000;
            request.setAttribute("changeToDegree", changeToDegree);
//            request.setAttribute("submittedFee", Double.toString(submittedFee+adv));
            request.setAttribute("submittedFee", Double.toString(submittedFee));
            request.setAttribute("nowSubmitFee", nowSubmitFee);
            request.setAttribute("self_finan_fee", Double.toString(self_finan_fee));
            request.setAttribute("prv_stud_type", prv_stud_type);
            ArrayList ddlist=fm1.retStud_fee_draftALL(seo);
            request.setAttribute("ddlist",ddlist);
        }
       }
       else
       {
            request.setAttribute("msg", "Student Details is not found");
       }
        return mapping.findForward(SUCCESS);
//        return mapping.findForward("");
    }
}
