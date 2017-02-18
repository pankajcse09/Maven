package Intelmind.Display;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;
import java.io.*;
import java.util.*;
import Intelmind.Beans.*;

public class DisplayAction extends DispatchAction{
    /* forward name="success" path="" */
    private final static String SUCCESS = "success"; 
    
          public ActionForward upCardStatusAct2(ActionMapping mapping,ActionForm form,
         HttpServletRequest request, HttpServletResponse response)
         throws Exception{   
         String rid=request.getParameter("rid");
         String dat=request.getParameter("dated");
         EquipBean eb=new EquipBean();
         eb.setRowId(rid);
         eb.setDated(dat);
         DisplayData dobj=new DisplayData();
         eb=(EquipBean)dobj.dispOperDataSing(eb);  
         request.setAttribute("ebean",eb); 
         return mapping.findForward(SUCCESS); 
         }
    
         public ActionForward upCardStatusAct(ActionMapping mapping,ActionForm form,
         HttpServletRequest request, HttpServletResponse response)
         throws Exception{   
         String rid=request.getParameter("rid");
         String dat=request.getParameter("dated");
         String wrk_hrs=request.getParameter("work_hrs");
         String ovt_hrs=request.getParameter("over_hrs");
         String comments=request.getParameter("comments");
         EquipBean eb=new EquipBean();
         eb.setRowId(rid);
         eb.setDated(dat);
         eb.setWorkingHrs(wrk_hrs);
         eb.setOvertimeHrs(ovt_hrs);
         eb.setComments(comments);
         DisplayData dobj=new DisplayData();
         int bn=dobj.upCardStatusData(eb);
         ArrayList ar=(ArrayList)dobj.dispOperData(eb);  
         eb.setDataArray(ar);
         if(bn==-1){
         request.setAttribute("msg","Data Error");                
         }else{
         request.setAttribute("msg","Data Updated");     
         }
         request.setAttribute("ebean",eb); 
         return mapping.findForward(SUCCESS); 
    } 
    
         public ActionForward upWorkCardAct(ActionMapping mapping,ActionForm form,
         HttpServletRequest request, HttpServletResponse response)
         throws Exception{   
         String dat=request.getParameter("dated");
         EquipBean eb=new EquipBean();
         eb.setDated(dat);
         DisplayData dobj=new DisplayData();
         ArrayList ar=(ArrayList)dobj.dispOperData(eb);  
         eb.setDataArray(ar);
         request.setAttribute("ebean",eb); 
         return mapping.findForward(SUCCESS); 
    } 
    
       public ActionForward projectWiseAct(ActionMapping mapping,ActionForm form,
       HttpServletRequest request, HttpServletResponse response)
       throws Exception{
        EquipBean eb=new EquipBean();    
        String proj=request.getParameter("project");   
        eb.setProjectName(proj);
        DisplayData dobj=new DisplayData();        
        ArrayList ar=(ArrayList)dobj.dispProjectWiseData(proj);  
        eb.setDataArray(ar);
        request.setAttribute("ebean",eb);
        return mapping.findForward(SUCCESS);
        } 
    
            public ActionForward reportData(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{    
         String mp="success";
         ArrayList ar=new ArrayList();       
         try{
         String strar[]=(String[])request.getParameterValues("column");         
         for(int i=0;i<strar.length;i++){
         ar.add(strar[i]);    
         }    
         }catch(Exception e){mp="failure";}
         request.setAttribute("arr",ar);           
         return mapping.findForward(mp); 
         } 
    
      public ActionForward dispOperMonthlyAct(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{   
        PrintWriter out=response.getWriter();          
        String year=request.getParameter("year");
        String month=request.getParameter("month");
        String oper=request.getParameter("operator");  
         EquipBean eb=new EquipBean();
         eb.setYear(year);
         eb.setMonth(month);
         eb.setOperator(oper);
         DisplayData dobj=new DisplayData();
         ArrayList ar=(ArrayList)dobj.dispOperMonthlyData(eb);  
         request.setAttribute("eqbean",eb); 
         request.setAttribute("dataarr",ar);           
         return mapping.findForward(SUCCESS); 
    } 
    
//    public ActionForward docList(ActionMapping mapping,ActionForm form,
//            HttpServletRequest request, HttpServletResponse response)
//            throws Exception{    
//         String eqid=request.getParameter("eqid");  
//         DisplayData dobj=new DisplayData();
//         ArrayList ar=(ArrayList)dobj.dispDocListData(eqid);  
//         if(ar.size()==0){
//         request.setAttribute("msg","No Document Available for Equip ID "+eqid);    
//         }else{
//         request.setAttribute("msg","Available Document List for Equip ID "+eqid);     
//         }         
//         request.setAttribute("dataarr",ar);           
//         return mapping.findForward(SUCCESS); 
//    } 
    
        public ActionForward equipListAct2(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
    
         String p=request.getParameter("pr");            
         DisplayData dobj=new DisplayData();
         HashMap hm=(HashMap)dobj.dispEquipListData2(p);  
         request.setAttribute("hmap",hm);           
         return mapping.findForward(SUCCESS); 
    } 
            
        public ActionForward equipListAct(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        DisplayData dobj=new DisplayData();
        ArrayList ar=(ArrayList)dobj.dispEquipListData();  
        request.setAttribute("dataarr",ar);
        return mapping.findForward(SUCCESS);
        }         
    
        public ActionForward dispServiceAct(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        DisplayData dobj=new DisplayData();
        ArrayList ar=(ArrayList)dobj.dispServiceData();  
        request.setAttribute("dataarr",ar);
        return mapping.findForward(SUCCESS);
        }
    
        public ActionForward dispRepairAct(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        DisplayData dobj=new DisplayData();
        ArrayList ar=(ArrayList)dobj.dispRepairData();  
        request.setAttribute("dataarr",ar);
        return mapping.findForward(SUCCESS);
        }
        
        public ActionForward dispDefectAct(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        DisplayData dobj=new DisplayData();
        ArrayList ar=(ArrayList)dobj.dispDefectData();  
        request.setAttribute("dataarr",ar);
        return mapping.findForward(SUCCESS);
        }
            
        public ActionForward dispEquipTypeAct(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        DisplayData dobj=new DisplayData();
        ArrayList ar=(ArrayList)dobj.dispEquipTypeData();  
        request.setAttribute("dataarr",ar);
        return mapping.findForward(SUCCESS);
        }      
    
       public ActionForward dispCategoryAct(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        DisplayData dobj=new DisplayData();
        ArrayList ar=(ArrayList)dobj.dispCategoryData();  
        request.setAttribute("dataarr",ar);
        return mapping.findForward(SUCCESS);
        }

     public ActionForward dispPartiesAct(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{        
        DisplayData dobj=new DisplayData();
        ArrayList ar=(ArrayList)dobj.dispPartiesData(); 
        request.setAttribute("dataarr",ar);
        return mapping.findForward(SUCCESS);
        }  
     
     public ActionForward dispLocAct(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        DisplayData dobj=new DisplayData();
        ArrayList ar=(ArrayList)dobj.dispLocData();  
        request.setAttribute("dataarr",ar);
        return mapping.findForward(SUCCESS);
        } 
       
     public ActionForward dispEquipsAct(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        DisplayData dobj=new DisplayData();  
        ArrayList ar=(ArrayList)dobj.dispEquipsData();
        request.setAttribute("dataarr",ar);
        return mapping.findForward(SUCCESS);
        } 
     
       public ActionForward dispEquipDetAct(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        String by=request.getParameter("by");
        String databy=request.getParameter("data_by");
        DisplayData dobj=new DisplayData();        
        EquipBean eb=(EquipBean)dobj.dispEquipDetData(by,databy);   
        if(!eb.getEquipId().equals("")){
        request.setAttribute("ebean",eb);   
        }else{
        request.setAttribute("msg","No Such Equipment ID"); 
        }
        return mapping.findForward(SUCCESS);
        }       
       
       public ActionForward dispJcardDetAct(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        HashMap hm=new HashMap();
        String jobcard=request.getParameter("jobcard");
        JobCardBean jcb=new JobCardBean();
        ProcessBean pb=new ProcessBean();
        jcb.setJobCard(jobcard);
        pb.setJobCard(jobcard);
        DisplayData dobj=new DisplayData();
        try{
        jcb=(JobCardBean)dobj.dispJcardDetData(jcb);   
        }catch(NullPointerException e){request.setAttribute("msg","No Such JobCard");}
        try{
        pb=(ProcessBean)dobj.dispProcessDetData(pb);   
        }catch(NullPointerException e){}
        hm.put("jobcardb",jcb);
        hm.put("processb",pb);
        if(!jcb.getJobCard().equals("")){
        request.setAttribute("hmap",hm); 
        }else{
        request.setAttribute("msg","No Such JobCard"); 
        }        
        return mapping.findForward(SUCCESS);
        } 
       
            public ActionForward dispEquipOperAct(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        String by=request.getParameter("by");
        String databy=request.getParameter("data_by");   
        EquipBean eb=new EquipBean();        
        eb.setBy(by);
        eb.setDataBy(databy);
        DisplayData dobj=new DisplayData();
        ArrayList ar=(ArrayList)dobj.dispEquipOperData(by,databy);   
        eb.setDataArray(ar);
        request.setAttribute("ebean",eb);
        return mapping.findForward(SUCCESS);
        } 
           
         public ActionForward dispEquipJobcardAct(ActionMapping mapping,ActionForm form,
         HttpServletRequest request, HttpServletResponse response)
         throws Exception{
        String by=request.getParameter("by");
        String databy=request.getParameter("data_by");
        DisplayData dobj=new DisplayData();
        ArrayList ar=(ArrayList)dobj.dispEquipJobcardData(by,databy);   
        if(ar.size()==0){
        request.setAttribute("msg","No Jobcard Available");    
        }
        request.setAttribute("dataarr",ar);
        request.setAttribute("by",by);
        request.setAttribute("databy",databy);
        return mapping.findForward(SUCCESS);
        }
       
          public ActionForward retEquipDetAct(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String equipid=request.getParameter("equipid");
        DisplayData dobj=new DisplayData();
        EquipBean eb=(EquipBean)dobj.retEquipDetData(equipid);  
        request.setAttribute("ebean",eb);
        return mapping.findForward(SUCCESS);
        }  
          
           public ActionForward retProjectDetAct(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{        
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String pname=request.getParameter("pname");
        DisplayData dobj=new DisplayData();
        ProjectBean pb=(ProjectBean)dobj.retProjectDetData(pname);  
        request.setAttribute("pbean",pb);
        return mapping.findForward(SUCCESS);
        } 
           
         public ActionForward retEmpDetAct(ActionMapping mapping,ActionForm form,
         HttpServletRequest request, HttpServletResponse response)
         throws Exception{        
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String eid=request.getParameter("eid");
        DisplayData dobj=new DisplayData();
        EmpBean eb=(EmpBean)dobj.retEmpDetData(eid);  
        request.setAttribute("ebean",eb);
        return mapping.findForward(SUCCESS);
        }         
                
         public ActionForward empDocLinksAct(ActionMapping mapping,ActionForm form,
         HttpServletRequest request, HttpServletResponse response)
         throws Exception{        
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String eid=request.getParameter("eid");
        DisplayData dobj=new DisplayData();
        ArrayList ar=(ArrayList)dobj.empDocLinksData(eid);  
        request.setAttribute("arr",ar);
        return mapping.findForward(SUCCESS);
        }
         
         public ActionForward retEmpNameAct(ActionMapping mapping,ActionForm form,
         HttpServletRequest request, HttpServletResponse response)
         throws Exception{        
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String jcard=request.getParameter("jobcard");
        String dt=request.getParameter("dated");
        String eid=request.getParameter("emp_code");
        DisplayData dobj=new DisplayData();
        JobCardBean jb=new JobCardBean();
        jb.setJobCard(jcard);        
        jb.setDated(dt);
        jb.setOperator(eid);         
        EmpBean eb=(EmpBean)dobj.retEmpDetData(eid);  
        jb.setOperTitle(eb.getEmpName());
        request.setAttribute("jbean",jb);
        return mapping.findForward(SUCCESS);
        }
         
         public ActionForward retMaterListAct(ActionMapping mapping,ActionForm form,
         HttpServletRequest request, HttpServletResponse response)
         throws Exception{        
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out=response.getWriter();
        String jcard=request.getParameter("jobcard");
        String dt=request.getParameter("dated");
        DisplayData dobj=new DisplayData();
        ProcessBean pb=new ProcessBean();
        pb.setJobCard(jcard);
        pb.setDated(dt);
        pb=(ProcessBean)dobj.retMaterListData(pb);  
        request.setAttribute("pbean",pb);
        return mapping.findForward(SUCCESS);
        }
         
         public ActionForward dispInspectionAct(ActionMapping mapping,ActionForm form,
         HttpServletRequest request, HttpServletResponse response)
         throws Exception{   
         PrintWriter out=response.getWriter();           
         String plateno=request.getParameter("plate_no");
         int mon=0;
         try{
         mon=Integer.parseInt(request.getParameter("month"));
         }catch(NumberFormatException ex){}
         String yr=request.getParameter("year");
         ProcessBean pb=new ProcessBean();
         pb.setPlateNo(plateno);
         pb.setMonth(mon);
         pb.setYear(yr);
         DisplayData dobj=new DisplayData();
         ProcessBean pb2=(ProcessBean)dobj.dispInspectionData(pb); 
         request.setAttribute("pbean",pb2); 
         return mapping.findForward(SUCCESS); 
    }    
         
         public ActionForward dispInspectDetAct(ActionMapping mapping,ActionForm form,
         HttpServletRequest request, HttpServletResponse response)
         throws Exception{   
         PrintWriter out=response.getWriter();  
         String dated=request.getParameter("dt");
         String plateno=request.getParameter("pn");
         ProcessBean pb=new ProcessBean();
         pb.setInspectDate(dated);
         pb.setPlateNo(plateno);
         DisplayData dobj=new DisplayData();
         ProcessBean pb2=(ProcessBean)dobj.dispInspectDetData(pb); 
         request.setAttribute("pbean",pb2); 
         return mapping.findForward(SUCCESS); 
    }
         
         public ActionForward dispMonInspectAct(ActionMapping mapping,ActionForm form,
         HttpServletRequest request, HttpServletResponse response)
         throws Exception{   
         PrintWriter out=response.getWriter();  
         String plateno=request.getParameter("plate_no");
         String yr=request.getParameter("year");
         ProcessBean pb=new ProcessBean();
         pb.setPlateNo(plateno);
         pb.setYear(yr);
         DisplayData dobj=new DisplayData();
         ProcessBean pb2=(ProcessBean)dobj.dispMonInspectData(pb); 
         request.setAttribute("pbean",pb2); 
         return mapping.findForward(SUCCESS); 
    }    
         
         public ActionForward dispMonInspectDetAct(ActionMapping mapping,ActionForm form,
         HttpServletRequest request, HttpServletResponse response)
         throws Exception{   
         PrintWriter out=response.getWriter();  
         String monyr=request.getParameter("dt");
         String plateno=request.getParameter("pn");
         ProcessBean pb=new ProcessBean();
         pb.setMonthYear(monyr);
         pb.setPlateNo(plateno);
         DisplayData dobj=new DisplayData();
         ProcessBean pb2=(ProcessBean)dobj.dispMonInspectDetData(pb); 
         request.setAttribute("pbean",pb2); 
         return mapping.findForward(SUCCESS); 
    }
         
}     