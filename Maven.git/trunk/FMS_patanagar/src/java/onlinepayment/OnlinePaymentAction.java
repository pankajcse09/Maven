/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinepayment;

import ActionClass.MyMeth;
import EO.SchoolEO;
import Fee.FeeMath;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import pant.common.CommonFunctionality;

/**
 *
 * @author kapil
 */
public class OnlinePaymentAction extends DispatchAction {
private static Logger logger=Logger.getLogger(OnlinePaymentAction.class.getName());
    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    public ActionForward chk_payment(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
      
        PrintWriter out=response.getWriter();
        WindowCreattionDB windowCreattionDB=new WindowCreattionDB();
        FeeMath fm=new FeeMath();
        String session=request.getParameter("session");
        String stud_id=request.getParameter("stud_id");
        
            Calendar cal = Calendar.getInstance();  
            java.util.Date current=cal.getTime();
            
          //  For I session sem
            cal.set(cal.DATE, 1);
            cal.set(cal.MONTH, 4);
            java.util.Date d1=cal.getTime();
            
            cal.set(cal.DATE, 30);
            cal.set(cal.MONTH, 7);
            java.util.Date d2=cal.getTime();
            
            cal.set(cal.DATE, 1);
            cal.set(cal.MONTH, 10);
            java.util.Date d3=cal.getTime();
            
            cal.set(cal.DATE, 30);
            cal.set(cal.MONTH, 1);
            cal.set(cal.YEAR, cal.get(cal.YEAR)+1);
            java.util.Date d4=cal.getTime();
            
//System.out.println("d1: "+d1);
//System.out.println("d2: "+d2);
//System.out.println("d3: "+d3);
//System.out.println("d4: "+d4);       
try{
            String session_sem="";
            if(current.after(d1) && current.before(d2))
            {
                session_sem="I";
            }
            else if(current.compareTo(d3) >= 0 && current.compareTo(d4) <= 0)
            {
                session_sem="II";
            }
//            else{
//                request.setAttribute("msg", "It's too late. You can not pay your fee from here, please contact in the comptroller office to submit your fee.");
//                return mapping.findForward(SUCCESS);
//            }
            
//session_sem="I";
            String temp_session=session;
            String temp_ssn_sem=session_sem;
//       System.out.println("Session sem: "+session_sem);
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
        
//        String session_sem="I";
        String prev_session="";
        SchoolEO seo1=fm.getStudentDetails(seo);
        java.util.Date curDate=new java.util.Date();
        OnlinePaymentWindow onlinePaymentWindow=windowCreattionDB.getOnlinePaymentWindow(session, seo1.getDegree(), session_sem);
        if(onlinePaymentWindow!=null&&(curDate.compareTo(onlinePaymentWindow.getFrom()) >= 0 && curDate.compareTo(onlinePaymentWindow.getTo()) <= 0))
        {
        if(session_sem.equals("I")){
            String f=temp_session.substring(0, temp_session.indexOf("-"));
                String l=temp_session.substring(temp_session.indexOf("-")+1, temp_session.length());
                prev_session=(Integer.parseInt(f)-1)+"-"+(Integer.parseInt(l)-1);
            temp_ssn_sem="II";
        }
        else{
            prev_session=session;
            temp_ssn_sem="I";
        }
        seo1.setSession(session);
        seo1.setSession_sem(session_sem);
        seo1.setBankname(bank);
//        seo1.setTransaction_id(tran_id);
        int cn=0;
        PaymentDB pdb=new PaymentDB();
            cn=pdb.checkSubmited_feeData1(seo1);
            if(cn==0){
                int c=0;
                seo1.setSession(prev_session);
                seo1.setSession_sem(temp_ssn_sem);
                c=pdb.checkSubmited_feeData1(seo1);
                if(c==0){
                    seo1.setSession(session);
                    seo1.setSession_sem(session_sem);
                    seo1.setCounter(3);
                    request.setAttribute("msg", "Your total fee can not be calculated because your previous fee details is not found. Please get your fee"
                            + "scroll from the university and submit your fee in the bank.");
                }
                else{
                    seo1.setCounter(2);
    //                seo1=pdb.retStudScrollFrom_stud_fee_detailForOnline(seo1); // this is used to get the fee details for online payment from stud_fee_detail table
             //  #######    now this block code is used to fetch the fee details for online payment from stud_fee_detail_excel table ######         
                    seo1.setDeposite_date(new java.util.Date());
                    seo1.setSession(session);
                    seo1.setSession_sem(session_sem);
                    pdb.calFineOnLateFeeSubmForOnline(seo1);
                    if(seo1.getTot_days()>0)
                              {
                                  double fine=0;
                                  if(seo1.getTot_days()==1)
                                      fine=seo1.getMin_fine();
                                  else{ 
                                      fine=seo1.getMin_fine()+(seo1.getTot_days()-1)*seo1.getPfine();
                                      if(fine>seo1.getMax_fine())
                                          fine=seo1.getMax_fine();
                                    }
                        seo1.setFine(fine);
                    }
                    seo1=fm.ret_stud_fee_detail_excel(seo1);
                    seo1.setDataArray(seo1.getDataArray2());
                    seo1.setDataMap(seo1.getDataMap1());
             //  #######    block code end     ######            
                    
                 /*   this is used to get the fee details for online payment from stud_fee_detail table
                   seo1.setSession(session);
                    seo1.setSession_sem(session_sem);
                    */
                    if(seo1.getCounter()==-10){
                        request.setAttribute("msg", "Some error found in student batch "+seo1.getBatch()+". Please contact to vendor.");
                        seo1=null;
                    }
                    if(seo1.getCounter()==-9){
                        request.setAttribute("msg", "Some error occured in fetching the annual head's fee for student id "+seo1.getStud_id()+". Please contact to vendor.");
                        seo1=null;
                    }
                }
            }
            else
            {
                seo1.setSession(session);
                seo1.setSession_sem(session_sem);
                seo1.setCounter(cn);
                seo1=fm.retStudScrollFrom_stud_fee_detail(seo1);
                //list=fm.retMoreStudScrollFrom_stud_fee_detail(seo1);
                request.setAttribute("msg", "Fee is already processed.");
            }
         request.setAttribute("jbean", seo1);
        request.setAttribute("list", list);
        }
        else
            request.setAttribute("msg", "Online payment windows is not open. please try after some time.");
        }
        else
            request.setAttribute("msg", "Student details is not found in our record.");
        }catch(Exception e){
            request.setAttribute("msg", "Some error occured in calculating your total fee. Please contact in comptroller office.");
        }
//        return mapping.findForward("");
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward checkDate(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    HttpSession htsession=request.getSession();
    if(htsession.getAttribute("seobean")==null){
        request.setAttribute("msg","Please try again!!!");  
        return mapping.findForward("failed");
    }
    SchoolEO seo=(SchoolEO)htsession.getAttribute("seobean");   

    java.util.Date curDate=new java.util.Date();
    WindowCreattionDB windowCreattionDB=new WindowCreattionDB();
        OnlinePaymentWindow onlinePaymentWindow=windowCreattionDB.getOnlinePaymentWindow(seo.getSession(), seo.getDegree(), seo.getSession_sem());
        if(onlinePaymentWindow!=null&&(curDate.compareTo(onlinePaymentWindow.getFrom()) >= 0 && curDate.compareTo(onlinePaymentWindow.getTo()) <= 0))
        {
            return mapping.findForward(SUCCESS);
        }
        else{
            request.setAttribute("msg", "Online payment windows is not open. please try after some time.");
            return mapping.findForward("failed");
        }
//        return mapping.findForward("");
    }

    public ActionForward showWindowData(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    HttpSession htsession=request.getSession(false);
    if(htsession.getAttribute("loginid")==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
    }
    WindowCreattionDB windowCreattionDB=new WindowCreattionDB();
    List<OnlinePaymentWindow> list=windowCreattionDB.getOnlinePaymentWindowList();
     request.setAttribute("list", list);
     
        MyMeth mm=new MyMeth();
        ArrayList degreeList=(ArrayList)mm.Degree_list();
        request.setAttribute("degreelist",degreeList);  
//        return mapping.findForward("");
        return mapping.findForward(SUCCESS);
    }
    
public ActionForward saveWindowData(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    HttpSession htsession=request.getSession(false);
    if(htsession.getAttribute("loginid")==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
    }
    MyMeth mm=new MyMeth();
    ArrayList degreeList=(ArrayList)mm.Degree_list();
    request.setAttribute("degreelist",degreeList);  
    
    CommonFunctionality cFun=new CommonFunctionality();
    WindowCreattionDB windowCreattionDB=new WindowCreattionDB();
    
      String session=request.getParameter("session");
      String session_sem=request.getParameter("session_sem");
      String degree=request.getParameter("degree");
      String from=request.getParameter("from");
      String to=request.getParameter("to");
      
      session=cFun.getStringFromString(session);
      session_sem=cFun.getStringFromString(session_sem);
      degree=cFun.getStringFromString(degree);
      from=cFun.getStringFromString(from);
      to=cFun.getStringFromString(to);
      if(windowCreattionDB.checkOnlineWindowData(session,degree)==false){
      SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
      java.util.Date fromDate=null;
      java.util.Date toDate=null;
      try{
          fromDate=sdf.parse(from);
          toDate=sdf.parse(to);
      }catch(Exception e){
          List<OnlinePaymentWindow> list=windowCreattionDB.getOnlinePaymentWindowList();
          request.setAttribute("list", list);
          request.setAttribute("msg", "Please do not change in the date format.");
          logger.log(Level.SEVERE,"Exception in parsing from and to date in OnlinePaymentAction at saveWindowData",e);
          return mapping.findForward(SUCCESS);
      }
      String loginName=htsession.getAttribute("name").toString();
      OnlinePaymentWindow onlinePaymentWindow=new OnlinePaymentWindow();
      onlinePaymentWindow.setSession(session);
      onlinePaymentWindow.setSession_sem(session_sem);
      onlinePaymentWindow.setDegree(degree);
      onlinePaymentWindow.setFrom(fromDate);
      onlinePaymentWindow.setTo(toDate);
      onlinePaymentWindow.setCreatedBy(loginName);
      onlinePaymentWindow.setCreatedDate(new java.util.Date());
      
      
      try{
          int cn=windowCreattionDB.saveOnlineWindowData(onlinePaymentWindow);
          if(cn==0){
              request.setAttribute("msg", "data did not store. Please try again after some time.");
          }else{
              request.setAttribute("msg", "data stored.");
          }
      }catch(Exception e){
          
      }
      }
      else
          request.setAttribute("msg", "data is already stored.");
     List<OnlinePaymentWindow> list=windowCreattionDB.getOnlinePaymentWindowList();
     request.setAttribute("list", list);
//        return mapping.findForward("");
        return mapping.findForward(SUCCESS);
    }

public ActionForward windowData(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    HttpSession htsession=request.getSession();
    if(htsession.getAttribute("loginid")==null){
         RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
         rd1.forward(request,response);
    }
    CommonFunctionality cFun=new CommonFunctionality();
   String id=request.getParameter("windowId");
   id=cFun.getStringFromString(id);
   int rowid=cFun.getIntFromString(id);
   WindowCreattionDB windowCreattionDB=new WindowCreattionDB();
   OnlinePaymentWindow onlinePaymentWindow=windowCreattionDB.getOnlinePaymentWindow(rowid);
   if(onlinePaymentWindow!=null){
       MyMeth mm=new MyMeth();
       ArrayList degreeList=(ArrayList)mm.Degree_list();
       request.setAttribute("degreelist",degreeList);  
       request.setAttribute("window", onlinePaymentWindow);
   }
   else{
       request.setAttribute("msg", "No record found!!!");
   }
   
   return mapping.findForward(SUCCESS);
       
//        return mapping.findForward("");
    }

public ActionForward updateWindowData(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    HttpSession htsession=request.getSession(false);
    if(htsession.getAttribute("loginid")==null){
        RequestDispatcher  rd1  =request.getRequestDispatcher("/Logout.do?method=logout"); 
                 rd1.forward(request,response);
    }
    CommonFunctionality cFun=new CommonFunctionality();
   String id=request.getParameter("windowId");
   id=cFun.getStringFromString(id);
   int rowid=cFun.getIntFromString(id);
   
    MyMeth mm=new MyMeth();
    ArrayList degreeList=(ArrayList)mm.Degree_list();
    request.setAttribute("degreelist",degreeList);  
    
    WindowCreattionDB windowCreattionDB=new WindowCreattionDB();
    
      String session=request.getParameter("session");
      String session_sem=request.getParameter("session_sem");
      String degree=request.getParameter("degree");
      String from=request.getParameter("from");
      String to=request.getParameter("to");
      
      session=cFun.getStringFromString(session);
      session_sem=cFun.getStringFromString(session_sem);
      degree=cFun.getStringFromString(degree);
      from=cFun.getStringFromString(from);
      to=cFun.getStringFromString(to);

      SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
      java.util.Date fromDate=null;
      java.util.Date toDate=null;
      try{
          fromDate=sdf.parse(from);
          toDate=sdf.parse(to);
      }catch(Exception e){
          List<OnlinePaymentWindow> list=windowCreattionDB.getOnlinePaymentWindowList();
          request.setAttribute("list", list);
          request.setAttribute("msg", "Please do not change in the date format.");
          logger.log(Level.SEVERE,"Exception in parsing from and to date in OnlinePaymentAction at updateWindowData",e);
          return mapping.findForward(SUCCESS);
      }
      String loginName=htsession.getAttribute("name").toString();
      OnlinePaymentWindow onlinePaymentWindow=new OnlinePaymentWindow();
      onlinePaymentWindow.setRowid(rowid);
      onlinePaymentWindow.setSession(session);
      onlinePaymentWindow.setSession_sem(session_sem);
      onlinePaymentWindow.setDegree(degree);
      onlinePaymentWindow.setFrom(fromDate);
      onlinePaymentWindow.setTo(toDate);
      onlinePaymentWindow.setUpdatedBy(loginName);
      onlinePaymentWindow.setUpdatedDate(new java.util.Date());
      
      
      try{
          int cn=windowCreattionDB.updateOnlineWindowData(onlinePaymentWindow);
          if(cn==0){
              request.setAttribute("msg", "data did not update. Please try again after some time.");
          }else{
              request.setAttribute("msg", "data updated.");
          }
      }catch(Exception e){
          
      }    
     List<OnlinePaymentWindow> list=windowCreattionDB.getOnlinePaymentWindowList();
     request.setAttribute("list", list);
//        return mapping.findForward("");
        return mapping.findForward(SUCCESS);
    }

}
