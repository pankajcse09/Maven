/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reports;

import EO.ReportsEO;
import EO.SchoolEO;
import Fee.FeeMath;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
public class AmountReports extends DispatchAction {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";

    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction1, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     */
    public ActionForward retDateWiseAmount(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        ArrayList al=new ArrayList();
        HashMap hm=new HashMap();
        Reports_DB rdb=new Reports_DB();
        
        String par_dt1="";
        String par_dt2="";
        String dt1="";
        String dt2="";
        double total=0.0;
        if(request.getParameter("dated1")!=null)
        {
            par_dt1=(String)request.getParameter("dated1");
        }
        if(request.getParameter("dated2")!=null)
        {
            par_dt2=(String)request.getParameter("dated2");
        }
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sde=new SimpleDateFormat("yyyy-MM-dd");
        
        java.util.Date pdt1=null;
        java.util.Date d1=null;
        java.sql.Date prt_date1=null;
        java.util.Date pdt2=null;
        java.util.Date d2=null;
        java.sql.Date prt_date2=null;
         try{
            pdt1=sdf.parse(par_dt1);
            pdt2=sdf.parse(par_dt2);
        }catch(ParseException e){e.getMessage();}
        try{
            dt1=sde.format(pdt1);
            d1=sde.parse(dt1);
            prt_date1=new java.sql.Date(d1.getTime());
            
            dt2=sde.format(pdt2);
            d2=sde.parse(dt2);
            prt_date2=new java.sql.Date(d2.getTime());
        }catch(Exception e){System.out.println(e.getMessage());}
        
        al=rdb.amountOnDate(prt_date1,prt_date2);
        total=rdb.getSumOnDate(prt_date1,prt_date2);
        
         request.setAttribute("list", al);
          request.setAttribute("total", Double.toString(total));
        request.setAttribute("date1", par_dt1);
        request.setAttribute("date2", par_dt2);
        return mapping.findForward(SUCCESS);
    }
    
        public ActionForward retDateWiseAdv(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        ArrayList al=new ArrayList();
        HashMap hm=new HashMap();
        Reports_DB rdb=new Reports_DB();
        
        String par_dt1="";
        String par_dt2="";
        String dt1="";
        String dt2="";
        double total=0.0;
        if(request.getParameter("dated1")!=null)
        {
            par_dt1=(String)request.getParameter("dated1");
        }
        if(request.getParameter("dated2")!=null)
        {
            par_dt2=(String)request.getParameter("dated2");
        }
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sde=new SimpleDateFormat("yyyy-MM-dd");
        
        java.util.Date pdt1=null;
        java.util.Date d1=null;
        java.sql.Date prt_date1=null;
        java.util.Date pdt2=null;
        java.util.Date d2=null;
        java.sql.Date prt_date2=null;
         try{
            pdt1=sdf.parse(par_dt1);
            pdt2=sdf.parse(par_dt2);
        }catch(ParseException e){e.getMessage();}
        try{
            dt1=sde.format(pdt1);
            d1=sde.parse(dt1);
            prt_date1=new java.sql.Date(d1.getTime());
            
            dt2=sde.format(pdt2);
            d2=sde.parse(dt2);
            prt_date2=new java.sql.Date(d2.getTime());
        }catch(Exception e){System.out.println(e.getMessage());}
        
        al=rdb.advanceOnDate(prt_date1,prt_date2);
        total=rdb.getSumAdvOnDate(prt_date1,prt_date2);
        
        request.setAttribute("list", al);
          request.setAttribute("total", Double.toString(total));
        request.setAttribute("date1", par_dt1);
        request.setAttribute("date2", par_dt2);
        return mapping.findForward(SUCCESS);
    }

    public ActionForward totalReceived(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ArrayList al=new ArrayList();
        HashMap hm=new HashMap();
        Reports_DB rdb=new Reports_DB();
         double total=0.0;
         
         al=rdb.retReceivedDetail();
         total=rdb.getTotalReceived();
         
         request.setAttribute("list", al);
        request.setAttribute("total", Double.toString(total));
        return mapping.findForward(SUCCESS);
    }
    
public ActionForward totalRefund(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ArrayList al=new ArrayList();
        HashMap hm=new HashMap();
        Reports_DB rdb=new Reports_DB();
         double total=0.0;
         String session=request.getParameter("session");
         
         int page = 1;
        int recordsPerPage = 50;
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
        int offset=(page-1)*recordsPerPage;
        
          al=rdb.retRefundDetail(session,offset,recordsPerPage);
         total=rdb.getTotalRefunded(session);
         
         int noOfRecords = rdb.getNoOfRecords();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        
         request.setAttribute("offset", Integer.toString(offset));
         request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
         request.setAttribute("list", al);
        request.setAttribute("total", Double.toString(total));
        return mapping.findForward(SUCCESS);
    }    

public ActionForward allreceived(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrintWriter out=response.getWriter();
        ArrayList al=new ArrayList();
        Reports_DB rdb=new Reports_DB();
        ReportsEO reo=new ReportsEO();
         
        String session=request.getParameter("session");
        String session_sem=request.getParameter("ssnm");
        String bank=request.getParameter("bank");
        
        String date_field="";
        String kinds=request.getParameter("kinds");
        if(kinds.equals("Processing"))
            date_field="draft_proc_date";
        else
            date_field="deposite_date";
        
        String par_dt1="";
        String par_dt2="";
        String dt1="";
        String dt2="";
        
        if(request.getParameter("d1")!=null)
        {
            par_dt1=(String)request.getParameter("d1");
        }
        if(request.getParameter("d2")!=null)
        {
            par_dt2=(String)request.getParameter("d2");
        }
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sde=new SimpleDateFormat("yyyy-MM-dd");
        
        java.util.Date pdt1=null;
        java.util.Date d1=null;
        
        java.util.Date pdt2=null;
        java.util.Date d2=null;
        
         try{
            pdt1=sdf.parse(par_dt1);
            pdt2=sdf.parse(par_dt2);
        }catch(ParseException e){e.getMessage();}
        try{
            dt1=sde.format(pdt1);
            d1=sde.parse(dt1);
            
            dt2=sde.format(pdt2);
            d2=sde.parse(dt2);
            
        }catch(Exception e){System.out.println(e.getMessage());}
         
        reo.setSession(session);
        reo.setSession_sem(session_sem);
        reo.setBank(bank);
        reo.setDate1(d1);
        reo.setDate2(d2);
        
         int page = 1;
        int recordsPerPage = 50;
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
        int offset=(page-1)*recordsPerPage;
        
          al=rdb.retAllReceivedAmount(reo,date_field,offset,recordsPerPage);
//        System.out.println("Size: "+al.size());
         
         int noOfRecords = rdb.getNoOfRecords();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        
        ArrayList al1=new ArrayList();
        FeeMath fm=new FeeMath();
        al1=fm.bankList();
        
        request.setAttribute("offset", Integer.toString(offset));
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        request.setAttribute("list", al);
        request.setAttribute("date1", par_dt1);
        request.setAttribute("date2", par_dt2);
        request.setAttribute("bnk", bank);
        request.setAttribute("bnklist", al1);
        request.setAttribute("kinds", kinds);
        return mapping.findForward(SUCCESS);
    }    

public ActionForward allbankamount(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrintWriter out=response.getWriter();
        Reports_DB rdb=new Reports_DB();
        ReportsEO reo=new ReportsEO();
         
        String session=request.getParameter("session");
        String session_sem=request.getParameter("ssnm");
        String bank=request.getParameter("bank");
        
        String date_field="";
        String bank_field="";
        String kinds=request.getParameter("kinds");
//        System.out.println("Kinds: "+kinds);
        if(kinds.equals("Processing")){
            date_field="draft_proc_date";
            bank_field="processed_in";
        }
        else{
            date_field="deposite_date";
            bank_field="bank_name";
        }
        String par_dt1="";
        String par_dt2="";
        String dt1="";
        String dt2="";
        
        if(request.getParameter("d1")!=null)
        {
            par_dt1=(String)request.getParameter("d1");
        }
        if(request.getParameter("d2")!=null)
        {
            par_dt2=(String)request.getParameter("d2");
        }
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sde=new SimpleDateFormat("yyyy-MM-dd");
        
        java.util.Date pdt1=null;
        java.util.Date d1=null;
        
        java.util.Date pdt2=null;
        java.util.Date d2=null;
        
         try{
            pdt1=sdf.parse(par_dt1);
            pdt2=sdf.parse(par_dt2);
        }catch(ParseException e){e.getMessage();}
        try{
            dt1=sde.format(pdt1);
            d1=sde.parse(dt1);
            
            dt2=sde.format(pdt2);
            d2=sde.parse(dt2);
            
        }catch(Exception e){System.out.println(e.getMessage());}
         
        reo.setSession(session);
        reo.setSession_sem(session_sem);
        reo.setBank(bank);
        reo.setDate1(d1);
        reo.setDate2(d2);
        
//        out.println("d1: "+d1.getTime());
//        out.println("d2: "+d2.getTime());
        
        int daysdiff=0;
        daysdiff =(int)( (d2.getTime() - d1.getTime()) / (24 * 60 * 60 * 1000)+1);
//out.println("diff: "+daysdiff);
        ArrayList al1=new ArrayList();
        FeeMath fm=new FeeMath();
        al1=fm.bankList();
        request.setAttribute("bnklist", al1);
        HashMap hm=new HashMap();
        if(reo.getBank().equals("ALL")){
            hm=rdb.allReceivedAmountInBanks(reo,al1,date_field,bank_field);
            request.setAttribute("ambnklist", al1);
        }
        else{
            ArrayList aa=new ArrayList();
            aa.add(reo.getBank());
            hm=rdb.allReceivedAmountInBanks(reo,aa,date_field,bank_field);
            request.setAttribute("ambnklist", aa);
        }
//        System.out.println("Size: "+al.size());
//         HashMap hm1=(HashMap)hm.get("PNB");
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(d1);
//        out.println(hm1);
//        out.println("<br>");
//        out.println("time: "+cal.getTime());
//        out.println("<br>");
//        out.println("Contains Key: "+hm1.containsKey(cal.getTime()));
//        cal.add(Calendar.DATE, 2);
//        out.println("<br>");
//        out.println("time1: "+cal.getTime());
//        out.println("<br>");
//        out.println("Contains Key: "+hm1.containsKey(cal.getTime()));
        request.setAttribute("map", hm);
        request.setAttribute("date1", par_dt1);
        request.setAttribute("date2", par_dt2);
        request.setAttribute("bnk", bank);
        request.setAttribute("kinds", kinds);
        request.setAttribute("days", Integer.toString(daysdiff));
        return mapping.findForward(SUCCESS);
//        return mapping.findForward("");
    }    

public ActionForward bankList(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ArrayList al=new ArrayList();
        FeeMath fm=new FeeMath();
         al=fm.bankList();
         request.setAttribute("bnklist", al);
       
        return mapping.findForward(SUCCESS);
    }

public ActionForward retBankWiseAdv(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        ArrayList al=new ArrayList();
        ArrayList al1=new ArrayList();
        FeeMath fm=new FeeMath();
        HashMap hm=new HashMap();
        Reports_DB rdb=new Reports_DB();
        
        String bnk_name="";
        String par_dt1="";
        String par_dt2="";
        String dt1="";
        String dt2="";
        double total=0.0;
        String date_field="";
        String kinds=request.getParameter("kinds");
        if(kinds.equals("Processing"))
            date_field="draft_proc_date";
        else
            date_field="deposite_date";
        
        if(request.getParameter("bnk_name")!=null)
        {
            bnk_name=(String)request.getParameter("bnk_name");
        }
        
         if(request.getParameter("dated1")!=null)
        {
            par_dt1=(String)request.getParameter("dated1");
        }
        if(request.getParameter("dated2")!=null)
        {
            par_dt2=(String)request.getParameter("dated2");
        }
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sde=new SimpleDateFormat("yyyy-MM-dd");
        
        java.util.Date pdt1=null;
        java.util.Date d1=null;
       
        java.util.Date pdt2=null;
        java.util.Date d2=null;
        
         try{
            pdt1=sdf.parse(par_dt1);
            pdt2=sdf.parse(par_dt2);
        }catch(ParseException e){e.getMessage();}
        try{
            dt1=sde.format(pdt1);
            d1=sde.parse(dt1);
            
            
            dt2=sde.format(pdt2);
            d2=sde.parse(dt2);
            
        }catch(Exception e){System.out.println(e.getMessage());}
        
        String session=request.getParameter("session");
        ReportsEO reo=new ReportsEO();
        reo.setSession(session);
        
        reo.setBank(bnk_name);
        reo.setDate1(d1);
        reo.setDate2(d2);
        
        int page = 1;
        int recordsPerPage = 50;
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
        int offset=(page-1)*recordsPerPage;
        
        al=rdb.advanceBankWiseOnDate(reo,date_field,offset,recordsPerPage);
        total=rdb.getSumAdvBankWiseOnDate(reo,date_field);
        
         int noOfRecords = rdb.getNoOfRecords();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        
         al1=fm.bankList();
        
         request.setAttribute("offset", Integer.toString(offset));
         request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
         request.setAttribute("list", al);
           request.setAttribute("bnk", bnk_name);
        request.setAttribute("bnklist", al1);
          request.setAttribute("total", Double.toString(total));
        request.setAttribute("date1", par_dt1);
        request.setAttribute("date2", par_dt2);
        request.setAttribute("kinds", kinds);
        return mapping.findForward(SUCCESS);
    }

public ActionForward retBankwise_amnt(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
//        PrintWriter out=response.getWriter();
        ArrayList al=new ArrayList();
        ArrayList al1=new ArrayList();
        FeeMath fm=new FeeMath();
        HashMap hm=new HashMap();
        Reports_DB rdb=new Reports_DB();
        
        String bnk_name="";
        String par_dt1="";
        String par_dt2="";
        String dt1="";
        String dt2="";
        double total=0.0;
        String date_field="";
        String kinds=request.getParameter("kinds");
        if(kinds.equals("Processing"))
            date_field="draft_proc_date";
        else
            date_field="deposite_date";
        
        if(request.getParameter("bnk_name")!=null)
        {
            bnk_name=(String)request.getParameter("bnk_name");
        }
        
         if(request.getParameter("dated1")!=null)
        {
            par_dt1=(String)request.getParameter("dated1");
        }
        if(request.getParameter("dated2")!=null)
        {
            par_dt2=(String)request.getParameter("dated2");
        }
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sde=new SimpleDateFormat("yyyy-MM-dd");
        
        java.util.Date pdt1=null;
        java.util.Date d1=null;
        
        java.util.Date pdt2=null;
        java.util.Date d2=null;
        
         try{
            pdt1=sdf.parse(par_dt1);
            pdt2=sdf.parse(par_dt2);
        }catch(ParseException e){e.getMessage();}
        try{
            dt1=sde.format(pdt1);
            d1=sde.parse(dt1);
           
            
            dt2=sde.format(pdt2);
            d2=sde.parse(dt2);
            
        }catch(Exception e){System.out.println("kapil: "+e.getMessage());}
        
        String session=request.getParameter("session");
        ReportsEO reo=new ReportsEO();
        reo.setSession(session);
        
        reo.setBank(bnk_name);
        reo.setDate1(d1);
        reo.setDate2(d2);
        
        int page = 1;
        int recordsPerPage = 50;
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
        int offset=(page-1)*recordsPerPage;
        
        al=rdb.amountBankWiseOnDate(reo,date_field,offset,recordsPerPage);
        total=rdb.getSumAmntBankWiseOnDate(reo,date_field);
        
        int noOfRecords = rdb.getNoOfRecords();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        
         al1=fm.bankList();
        
         request.setAttribute("offset", Integer.toString(offset));
         request.setAttribute("noOfPages", noOfPages);
         request.setAttribute("currentPage", page);
         request.setAttribute("list", al);
         request.setAttribute("bnk", bnk_name);
        request.setAttribute("bnklist", al1);
          request.setAttribute("total", Double.toString(total));
        request.setAttribute("date1", par_dt1);
        request.setAttribute("date2", par_dt2);
        request.setAttribute("kinds", kinds);
        return mapping.findForward(SUCCESS);
//        return mapping.findForward("");
    }

public ActionForward checkAdvDraft(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
     PrintWriter out=response.getWriter();
     
        ArrayList al=new ArrayList();
        ArrayList al1=new ArrayList();
        FeeMath fm=new FeeMath();
        
        int cnt=0;
        String bnk="";
        if(request.getParameter("bnk_name")!=null);
        {
            bnk=(String)request.getParameter("bnk_name");
        }
        String session=request.getParameter("session");
         
        Reports_DB rdb=new Reports_DB();
         double total=0.0;
         cnt=rdb.checkAdvDraft(bnk, session);
         if(cnt!=0){
             String table="stud_draft";
             int slot=rdb.foundMaxSlot(session, bnk, table);
             al=rdb.getAdvDraft(bnk,session);
             request.setAttribute("list", al);
             request.setAttribute("slot", Integer.toString(slot));
         }
        else{
             request.setAttribute("msg", "No record found or all record is updated.");
         }
         al1=fm.bankList();
        request.setAttribute("bnklist", al1);
        request.setAttribute("bnk", bnk);
        return mapping.findForward(SUCCESS);
//          return mapping.findForward("");
    }

public ActionForward updAdvDr(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    PrintWriter out=response.getWriter();
        ArrayList al=new ArrayList();
        ArrayList al1=new ArrayList();
        ReportsEO reo=null;
        FeeMath fm=new FeeMath();
        
        String bnk="";
        int sz=0;
        if(request.getParameter("bnk_name")!=null);
        {
            bnk=(String)request.getParameter("bnk_name");
        }
        if(request.getParameter("sz")!=null);
        {
            try{
                sz=Integer.parseInt(request.getParameter("sz"));
            }catch(Exception e){}
        }
        int slot=0;
        if(request.getParameter("slot")!=null);
        {
            try{
                slot=Integer.parseInt(request.getParameter("slot"));
            }catch(Exception e){}
        }
        String session =request.getParameter("session");
        Date up_dt=new Date();
//        out.println("Size: "+sz);
        for(int i=0;i<sz;i++)
        {
            try{
                if(request.getParameter("rwid_"+i)!=null);
                     {
                         reo=new ReportsEO();
                         reo.setRwid(Long.parseLong(request.getParameter("rwid_"+i).toString()));
                         reo.setNumber(request.getParameter("draft"+i));
                         al.add(reo);
                     }
            }catch(Exception e){}
//            out.println(" "+seo.getRwid()+", ");
        }
       ReportsEO reo1=new ReportsEO();
       reo1.setSession(session);
       reo1.setDate1(up_dt);
       reo1.setNum(slot);
       reo1.setBank(bnk);
       
        Reports_DB rdb=new Reports_DB();
        rdb.upAdvDraft(reo1,al);
        rdb.upAdvDraftInFeeDraft(reo1, al);
        al1=fm.bankList();
        
        request.setAttribute("bnklist", al1);
        request.setAttribute("bnk", bnk);
        request.setAttribute("msg", sz+" Draft is updated for bank "+bnk+" session "+session+" with the slot "+slot);
        return mapping.findForward(SUCCESS);
//        return mapping.findForward("");
}

public ActionForward checkAmntDraft(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    PrintWriter out=response.getWriter();
        ArrayList al=new ArrayList();
        ArrayList al1=new ArrayList();
        
        FeeMath fm=new FeeMath();
        
        int cnt=0;
        String bnk="";
        if(request.getParameter("bnk_name")!=null);
        {
            bnk=(String)request.getParameter("bnk_name");
        }
        String session=request.getParameter("session");
        Reports_DB rdb=new Reports_DB();
         double total=0.0;
         cnt=rdb.checkFeeDraft(bnk, session);
         if(cnt!=0){
             String table="stud_fee_draft";
             int slot=rdb.foundMaxSlot(session, bnk, table);
             al=rdb.getAmntDraft(bnk,session);
             request.setAttribute("list", al);
             request.setAttribute("slot", Integer.toString(slot));
         }
         else{
             request.setAttribute("msg", "No record found or all record is updated.");
         }
         al1=fm.bankList();
         
        request.setAttribute("bnklist", al1);
        request.setAttribute("bnk", bnk);
        return mapping.findForward(SUCCESS);
//        return mapping.findForward("");
    }


public ActionForward updAmntDr(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    PrintWriter out=response.getWriter();
        ArrayList al=new ArrayList();
        ArrayList al1=new ArrayList();
        ReportsEO reo=null;
        FeeMath fm=new FeeMath();
        
        String bnk="";
        int sz=0;
        if(request.getParameter("bnk_name")!=null);
        {
            bnk=(String)request.getParameter("bnk_name");
        }
        if(request.getParameter("sz")!=null);
        {
            try{
                sz=Integer.parseInt(request.getParameter("sz").toString());
            }catch(Exception e){}
        }
        int slot=0;
        if(request.getParameter("slot")!=null);
        {
            try{
                slot=Integer.parseInt(request.getParameter("slot"));
            }catch(Exception e){}
        }
        String session =request.getParameter("session");
        Date up_dt=new Date();
//        out.println("Size: "+sz);
        for(int i=0;i<sz;i++)
        {
            try{
                if(request.getParameter("rwid_"+i)!=null);
                     {
                         reo=new ReportsEO();
                         reo.setRwid(Long.parseLong(request.getParameter("rwid_"+i).toString()));
                         al.add(reo);
                     }
            }catch(Exception e){}
//            out.println(" "+seo.getRwid()+", ");
        }
       ReportsEO reo1=new ReportsEO();
       reo1.setSession(session);
       reo1.setDate1(up_dt);
       reo1.setNum(slot);
       reo1.setBank(bnk);
       
        Reports_DB rdb=new Reports_DB();
        rdb.upAmntDraft(reo1,al);
        al1=fm.bankList();
        
        request.setAttribute("bnklist", al1);
        request.setAttribute("bnk", bnk);
        request.setAttribute("msg", sz+" Draft is updated for bank "+bnk+" session "+session+" with the slot "+slot);
        return mapping.findForward(SUCCESS);
//        return mapping.findForward("");
}

public ActionForward lfine_received(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    PrintWriter out=response.getWriter();
        ArrayList al=new ArrayList();
        Reports_DB rdb=new Reports_DB();
        ReportsEO reo=new ReportsEO();
         
         String session=request.getParameter("session");
         String session_sem=request.getParameter("ssnm");
         String bank=request.getParameter("bank");
         
        
        reo.setSession(session);
        reo.setSession_sem(session_sem);
        reo.setBank(bank);
        
         
          al=rdb.retLateFineReceived(reo);
//        System.out.println("Size: "+al.size());
         
         
         request.setAttribute("list", al);
         
        request.setAttribute("bnk", bank);
        
        
        return mapping.findForward(SUCCESS);
    }    

public ActionForward dateForDraft(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    PrintWriter out=response.getWriter();
        ArrayList al=new ArrayList();
        Reports_DB rdb=new Reports_DB();
        ReportsEO reo=new ReportsEO();
         
         String session=request.getParameter("session");
         String bank=request.getParameter("bnk_name");
         String draft=request.getParameter("draft");
         int slot=0;
         String draftno="";
         try{
         if(request.getParameter("slot")!=null)
             slot=Integer.parseInt(request.getParameter("slot"));
         }catch(Exception e){}
         if(request.getParameter("draftno")!=null)
             draftno=request.getParameter("draftno");
         
         
         ArrayList al1=new ArrayList();
         FeeMath fm=new FeeMath();
         al1=fm.bankList();
         request.setAttribute("bnklist", al1);
         
         String table="";
         if(draft.equals("Advance"))
            table="stud_draft";
         else if(draft.equals("Fee"))
             table="stud_fee_draft";
         else{
             request.setAttribute("msg", "Please do not change the value of draft types.");
             return mapping.findForward(SUCCESS);
         }
        
        reo.setSession(session);
        reo.setBank(bank);
        reo.setDraft_no(draftno);
        
        int page = 1;
        int recordsPerPage = 20;
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
        int offset=(page-1)*recordsPerPage;
        
        al=rdb.getDraftFromTable(reo, slot, table,"beforeupdate",offset,recordsPerPage);
        
        int noOfRecords = rdb.getNoOfRecords();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        
        if(al.size()==0)
            request.setAttribute("msg", "No record found.");
        
        request.setAttribute("offset", Integer.toString(offset));
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        request.setAttribute("list", al);
        request.setAttribute("bnk", bank);
        request.setAttribute("draft", draft);
        return mapping.findForward(SUCCESS);
    }    

public ActionForward updDraft(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    PrintWriter out=response.getWriter();
        ArrayList al=new ArrayList();
        ArrayList al1=new ArrayList();
        ArrayList draftlist=new ArrayList();
        ReportsEO reo=null;
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        
        String bnk=request.getParameter("bnk_name");
        String session =request.getParameter("session");
        String draft=request.getParameter("draft");
        String draftno=request.getParameter("draftno");
        String date=request.getParameter("date1");
        String processing_bank=request.getParameter("proc_bank");
//        System.out.println("Draft No: "+draftno);
        int sz=0;
        if(request.getParameter("sz")!=null);
        {
            try{
                sz=Integer.parseInt(request.getParameter("sz").toString());
            }catch(Exception e){}
        }
        int slot=0;
        if(request.getParameter("slot")!=null);
        {
            try{
                slot=Integer.parseInt(request.getParameter("slot"));
            }catch(Exception e){}
        }
        
        FeeMath fm=new FeeMath();
        al1=fm.bankList();
        request.setAttribute("bnklist", al1);
        
        ReportsEO reo1=new ReportsEO();
        reo1.setSession(session);
        reo1.setBank(processing_bank);
        reo1.setDraft_no(draftno);
        reo1.setDate1(sdf.parse(date));
        String table="";
         if(draft.equals("Advance"))
            table="stud_draft";
         else if(draft.equals("Fee"))
             table="stud_fee_draft";
         
//        out.println("Size: "+sz);
        for(int i=0;i<sz;i++)
        {
            try{
                if(request.getParameter("rwid_"+i)!=null);
                     {
                         reo=new ReportsEO();
                         reo.setRwid(Long.parseLong(request.getParameter("rwid_"+i).toString()));
                         al.add(reo);
                     }
            }catch(Exception e){}
             if(request.getParameter("draftno_"+i)!=null);
                {
                   draftlist.add(request.getParameter("draftno_"+i));
                }
        }
       
        int page = 1;
        int recordsPerPage = 20;
        if(request.getParameter("pg") != null)
            page = Integer.parseInt(request.getParameter("pg"));
        int offset=(page-1)*recordsPerPage;
        
//        System.out.println("page: "+page);
        
        Reports_DB rdb=new Reports_DB();
        rdb.upDraftProcessingDate(reo1,al,table);
        if(draft.equals("Advance"))
            rdb.upDraftProcessingDate(draftlist, reo1, "stud_fee_draft",bnk);
        
        reo1.setBank(bnk);
        ArrayList ar=rdb.getDraftFromTable(reo1, slot, table,"afterupdate",offset,recordsPerPage);
        
        int noOfRecords = rdb.getNoOfRecords();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        
        request.setAttribute("offset", Integer.toString(offset));
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        request.setAttribute("bnk", bnk);
        request.setAttribute("list", ar);
        request.setAttribute("draft", draft);
        request.setAttribute("msg", sz+" Draft Processing Date is updated for bank "+bnk+" session "+session);
        return mapping.findForward(SUCCESS);
//        return mapping.findForward("");
}

public ActionForward retSelfFinanAmount(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        ArrayList al=new ArrayList();
        
        Reports_DB rdb=new Reports_DB();
        
        String session=request.getParameter("session");
        String session_sem=request.getParameter("session_sem");
        String degree=request.getParameter("degree");
        
        ReportsEO reo=new ReportsEO();
        reo.setSession(session);
        reo.setDegree(degree);
        reo.setSession_sem(session_sem);
        double total_selfF=rdb.retTotal_SelfFinAmount(reo);
        al=rdb.retTransfered_SelfFinAmount(reo);
        
        request.setAttribute("list", al);
        request.setAttribute("total_selfF", Double.toString(total_selfF));
        request.setAttribute("jbean", reo);
        return mapping.findForward(SUCCESS);
    }

public ActionForward selfFinanAmountTransfer(ActionMapping mapping,ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception{
//        PrintWriter out=response.getWriter();        
        ArrayList al=new ArrayList();
        Reports_DB rdb=new Reports_DB();
        String session=request.getParameter("session");
        String session_sem=request.getParameter("session_sem");
        String degree=request.getParameter("degree");
        
        ReportsEO reo=new ReportsEO();
        reo.setSession(session);
        reo.setDegree(degree);
        reo.setSession_sem(session_sem);
        try{
            double am=Double.parseDouble(request.getParameter("amount"));
            reo.setTransfered_fund(am);
        }catch(Exception e){
            double total_selfF=rdb.retTotal_SelfFinAmount(reo);
            al=rdb.retTransfered_SelfFinAmount(reo);
        
            request.setAttribute("list", al);
            request.setAttribute("total_selfF", Double.toString(total_selfF));
            request.setAttribute("jbean", reo);
            request.setAttribute("msg", "Please do not enter any character as amount");
            return mapping.findForward(SUCCESS);
        }
        
       rdb.selfFinAmount_transfer(reo);
       double total_selfF=rdb.retTotal_SelfFinAmount(reo);
       al=rdb.retTransfered_SelfFinAmount(reo);
        
       request.setAttribute("list", al);
       request.setAttribute("total_selfF", Double.toString(total_selfF));
       request.setAttribute("jbean", reo);
       request.setAttribute("msg", reo.getTransfered_fund()+" amount is transfered to "+reo.getDegree());; 
//        out.print(seo.getDataMap2());
//        return mapping.findForward("");
        return mapping.findForward(SUCCESS);
       }      
             
}
