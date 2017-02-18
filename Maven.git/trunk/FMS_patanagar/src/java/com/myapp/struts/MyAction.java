package com.myapp.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;
import java.io.*;
import java.util.*;

public class MyAction extends DispatchAction{
    /* forward name="success" path="" */
    private final static String SUCCESS = "success";    
    
      public ActionForward compAirAction(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        PrintWriter out=response.getWriter(); 
        String dat=(String)request.getParameter("dated");
        String compname=(String)request.getParameter("compname"); 
        String zone=(String)request.getParameter("zone");
        double wt15=0.0;
        double adwt5=0.0;
        double nondoc=0.0;
        try{
        wt15=Double.parseDouble(request.getParameter("wt1_5").toString());
        adwt5=Double.parseDouble(request.getParameter("adwt5").toString());
        nondoc=Double.parseDouble(request.getParameter("nondoc").toString());  
        }
        catch(Exception e){}
        JavaBean jb=new JavaBean();
        jb.setDated(dat);
        jb.setCompname(compname);
        jb.setZone(zone);
        jb.setWt1_5(wt15);
        jb.setAdwt5(adwt5);
        jb.setNondoc(nondoc);
        DataObject dt=new DataObject();
        int b=dt.compAirCargo(jb);
        request.setAttribute("jbean",jb);
        if(b==0){
        request.setAttribute("msg","Data Submitted");
        }
        else{
        request.setAttribute("msg","Data Already Exists");    
        }
        return mapping.findForward(SUCCESS);   
      }    
      public ActionForward compTarrifAction(ActionMapping mapping,ActionForm form,
      HttpServletRequest request, HttpServletResponse response)
      throws Exception{
        PrintWriter out=response.getWriter(); 
        String dat=(String)request.getParameter("dated");
        String compname=(String)request.getParameter("compname"); 
        String zone=(String)request.getParameter("zone");
        double wt15=0.0;
        double adwt5=0.0;
        double nondoc=0.0;
        try{
        wt15=Double.parseDouble(request.getParameter("wt1_5").toString());
        adwt5=Double.parseDouble(request.getParameter("adwt5").toString());
        nondoc=Double.parseDouble(request.getParameter("nondoc").toString());  
        }
        catch(Exception e){}
        JavaBean jb=new JavaBean();
        jb.setDated(dat);
        jb.setCompname(compname);
        jb.setZone(zone);
        jb.setWt1_5(wt15);
        jb.setAdwt5(adwt5);
        jb.setNondoc(nondoc);
        DataObject dt=new DataObject();
        int b=dt.compTarrif(jb);
        request.setAttribute("jbean",jb);
        if(b==0){
        request.setAttribute("msg","Data Submitted");
        }
        else{
        request.setAttribute("msg","Data Already Exists");    
        }
        return mapping.findForward(SUCCESS);    
      }    
        public ActionForward chequeDetailsAction(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        PrintWriter out=response.getWriter();
        String cname=request.getParameter("compname");
        String dat=request.getParameter("dated");  
        String chqno=request.getParameter("chequeno"); 
        String bnknm=request.getParameter("bankname");
        double amt=Double.parseDouble(request.getParameter("amount").toString()); 
        JavaBean jb=new JavaBean();
        jb.setCompname(cname);
        jb.setDated(dat);
        jb.setChequeno(chqno);
        jb.setBankname(bnknm);
        jb.setAmount(amt);                
        DataObject dt=new DataObject();
        boolean b=dt.chequeDetails(jb);
        if(b==true){
        request.setAttribute("msg","Data Submitted");
        }
        return mapping.findForward(SUCCESS);
        }    
           
        public ActionForward enterAllExpenses(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        DynaActionForm dynaform=(DynaActionForm)form;
        PrintWriter out=response.getWriter();
        String dat=(String)request.getParameter("dated");
        String det=dynaform.get("details").toString();      
        double amt=Double.parseDouble(dynaform.get("amount").toString());       
        String empn=dynaform.get("empname").toString(); 
        JavaBean jb=new JavaBean();
        jb.setDated(dat);
        jb.setDetails(det);
        jb.setAmount(amt);
        jb.setEmpname(empn);       
        DataObject dt=new DataObject();
        boolean b=dt.allExpense(jb);
        if(b==true){
            request.setAttribute("datee",dat);
            request.setAttribute("dete",det);
            request.setAttribute("amtt",new Double(amt));
            request.setAttribute("empname",empn);
        request.setAttribute("msg","Data Submitted");
        }
        return mapping.findForward(SUCCESS);
        }
    
        public ActionForward enterFuelExpenses(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        DynaActionForm dynaform=(DynaActionForm)form;
        PrintWriter out=response.getWriter();
        String dat=(String)request.getParameter("dated");
        String vno=dynaform.get("vehicleno").toString();      
        double stkm=Double.parseDouble(dynaform.get("startkm").toString());      
        double endkm=Double.parseDouble(dynaform.get("endkm").toString());    
        double totkm=Double.parseDouble(dynaform.get("totalkm").toString());      
        double fuelamt=Double.parseDouble(dynaform.get("fuelofamt").toString()); 
        JavaBean jb=new JavaBean();
        jb.setDated(dat);
        jb.setVehno(vno);
        jb.setStartkm(stkm);
        jb.setEndkm(endkm);
        jb.setTotalkm(totkm);
        jb.setFuelamt(fuelamt);
        DataObject dt=new DataObject();
        boolean b=dt.fuelExpense(jb);
        if(b==true){
        request.setAttribute("msg","Data Submitted");
        }
        return mapping.findForward(SUCCESS);
        }      
      
       public ActionForward updateStatus(ActionMapping mapping,ActionForm form,
         HttpServletRequest request, HttpServletResponse response)
         throws Exception{        
        PrintWriter out=response.getWriter();         
        String st="";
        String st1=""; 
        String p="1";        
        if(request.getParameter("pr")!=null){
        p=(String)request.getParameter("pr");
        } 
        if(request.getParameter("id")!=null){
        st=(String)request.getParameter("id");
        }       
        if(request.getParameter("status")!=null){
        st1=(String)request.getParameter("status");
        }       
        DataObject dt=new DataObject();
        boolean bn=dt.cheque(st,st1);    
        HashMap hm=(HashMap)dt.chequeStatus(p);  
        request.setAttribute("hmap",hm); 
        request.setAttribute("msg","Updated");       
        return mapping.findForward(SUCCESS); 
        }        
    
       public ActionForward updateChequeStatus(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        PrintWriter out=response.getWriter();
        JavaBean jb=new JavaBean();
        String p="1";
        if(request.getParameter("pr")!=null){
        p=(String)request.getParameter("pr");
        }
        DataObject dt=new DataObject();
        HashMap hm=(HashMap)dt.chequeStatus(p);
        request.setAttribute("hmap",hm);
        return mapping.findForward(SUCCESS); 
        }
     /////////////////////////////////////////////////////////////////////////////////////////////     
       public ActionForward cupdateSurface1(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
         PrintWriter out=response.getWriter();
         String p=""; 
         p=(String)request.getParameter("pr");         
         HashMap hm=new HashMap();         
         DataObject dt=new DataObject();        
         hm=(HashMap)dt.compSurface1(p);           
         request.setAttribute("hmap",hm);           
         return mapping.findForward(SUCCESS);  
    }
       public ActionForward cupdateSurface2(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        PrintWriter out=response.getWriter();
        JavaBean jb=new JavaBean();
        DataObject dt=new DataObject();
        String id=(String)request.getParameter("pid");        
        ArrayList ar=dt.compSurface2(id);         
        request.setAttribute("arr",ar);              
        return mapping.findForward(SUCCESS);
    }
         public ActionForward cupdateSurface3(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        DynaActionForm dynaform=(DynaActionForm)form;
        PrintWriter out=response.getWriter();
        String p=(String)request.getParameter("pr");       
        String id1=(String)request.getParameter("pid");
        String dat=(String)request.getParameter("dated");
        String cname=(String)request.getParameter("cname");
        String zone=(String)request.getParameter("zone");
        double wt1=Double.parseDouble(request.getParameter("wt15").toString());
        double wt2=Double.parseDouble(request.getParameter("wt525").toString());
        double wt3=Double.parseDouble(request.getParameter("wt2550").toString());   
        double wt4=Double.parseDouble(request.getParameter("wt50100").toString()); 
        double wt5=Double.parseDouble(request.getParameter("above100").toString()); 
        
        JavaBean jb=new JavaBean();
        jb.setId(id1);
        jb.setDated(dat);
        jb.setCompname(cname);
        jb.setZone(zone);
        jb.setWt15(wt1);
        jb.setWt525(wt2);
        jb.setWt2550(wt3);
        jb.setWt50100(wt4);
        jb.setAbove100(wt5);               
         HashMap hm=new HashMap();         
         DataObject dt=new DataObject();            
        boolean b=dt.compSurface3(jb);  
        hm=(HashMap)dt.compSurface1(p); 
        request.setAttribute("hmap",hm); 
        if(b==true){
        request.setAttribute("msg","Data Updated");
        }
        return mapping.findForward("success");
    }
               public ActionForward delCompSurfaceCargo(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        PrintWriter out=response.getWriter();
        JavaBean jb=new JavaBean();
        HashMap hm=new HashMap(); 
        DataObject dt=new DataObject();
        String id=(String)request.getParameter("pid");   
        String p=(String)request.getParameter("pr");       
        boolean bn=dt.deleteCompSurface(id);
        hm=(HashMap)dt.compSurface1(p);           
        request.setAttribute("hmap",hm);         
        if(bn==true){
        request.setAttribute("msg","Deleted");    
        }
        return mapping.findForward(SUCCESS);
      }        
       
     ///////////////////////////////////////////////////////////////////////////////////////////  
       public ActionForward cupdateAir1(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
         PrintWriter out=response.getWriter();
         String p=request.getParameter("pr");          
         HashMap hm=new HashMap();         
         DataObject dt=new DataObject();        
         hm=(HashMap)dt.compAir1(p);   
         request.setAttribute("hmap",hm);           
         return mapping.findForward(SUCCESS); 
    }
       public ActionForward cupdateAir2(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        PrintWriter out=response.getWriter(); 
        DataObject dt=new DataObject();
        String p=(String)request.getParameter("pr");
        String id=(String)request.getParameter("pid");
        JavaBean jb=(JavaBean)dt.compAir2(id);        
        request.setAttribute("jbean",jb);              
        return mapping.findForward(SUCCESS);
    }
       public ActionForward cupdateAir3(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        DynaActionForm dynaform=(DynaActionForm)form;
        PrintWriter out=response.getWriter();
        String p=(String)request.getParameter("pr");
        String id1=(String)request.getParameter("pid");
        String dat=(String)request.getParameter("dated");
        String cname=(String)request.getParameter("cname");
        String zone=(String)request.getParameter("zone");
        double wt15=0.0;
        double adwt5=0.0;
        double nondoc=0.0;     
        
        try{
        wt15=Double.parseDouble(request.getParameter("wt1_5").toString());
        adwt5=Double.parseDouble(request.getParameter("adwt5").toString());
        nondoc=Double.parseDouble(request.getParameter("nondoc").toString());
        }catch(Exception e){}
        
        JavaBean jb=new JavaBean();
        jb.setId(id1);
        jb.setDated(dat);
        jb.setCompname(cname);
        jb.setZone(zone);
        jb.setWt1_5(wt15);
        jb.setAdwt5(adwt5);
        jb.setNondoc(nondoc);
            
        HashMap hm=new HashMap();
        DataObject dt=new DataObject();
        boolean b=dt.compAir3(jb);  
        hm=(HashMap)dt.compAir1(p); 
        request.setAttribute("hmap",hm); 
        if(b==true){
        request.setAttribute("msg","Data Updated");
        }
        return mapping.findForward("success");
         }  
              public ActionForward delCompAirCargo(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        PrintWriter out=response.getWriter();
        JavaBean jb=new JavaBean();
        HashMap hm=new HashMap(); 
        DataObject dt=new DataObject();         
        String id=(String)request.getParameter("pid");   
        String p=(String)request.getParameter("pr"); 
        boolean bn=dt.deleteCompAir(id);                        
        hm=(HashMap)dt.compAir1(p);           
        request.setAttribute("hmap",hm);      
        if(bn==true){
        request.setAttribute("msg","Deleted");    
        }
        return mapping.findForward(SUCCESS);
      }       
       
     //////////////////////////////////////////////////////////////////////////////////////////   
      public ActionForward cupdateTarrif1(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
         PrintWriter out=response.getWriter();
         String p=request.getParameter("pr");            
         HashMap hm=new HashMap();         
         DataObject dt=new DataObject();        
         hm=(HashMap)dt.compTarrif1(p);           
         request.setAttribute("hmap",hm);           
         return mapping.findForward(SUCCESS); 
    }   
    
      public ActionForward cupdateTarrif2(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        PrintWriter out=response.getWriter();
        DataObject dt=new DataObject();
        String id=(String)request.getParameter("pid");
        JavaBean jb=(JavaBean)dt.compTarrif2(id);        
        request.setAttribute("jbean",jb);              
        return mapping.findForward(SUCCESS);
    }
    
       public ActionForward cupdateTarrif3(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        DynaActionForm dynaform=(DynaActionForm)form;
        PrintWriter out=response.getWriter();
        String p=(String)request.getParameter("pr"); 
        String id1=(String)request.getParameter("pid");
        String dat=(String)request.getParameter("dated");
        String cname=(String)request.getParameter("cname");
        String zone=(String)request.getParameter("zone");        
        double wt15=0.0;
        double adwt5=0.0;
        double nondoc=0.0;     
        
        try{
        wt15=Double.parseDouble(request.getParameter("wt1_5").toString());
        adwt5=Double.parseDouble(request.getParameter("adwt5").toString());
        nondoc=Double.parseDouble(request.getParameter("nondoc").toString());
        }catch(Exception e){}
        
        JavaBean jb=new JavaBean();
        jb.setId(id1);
        jb.setDated(dat);
        jb.setCompname(cname);
        jb.setZone(zone);
        jb.setWt1_5(wt15);
        jb.setAdwt5(adwt5);
        jb.setNondoc(nondoc);
        
        HashMap hm=new HashMap(); 
        DataObject dt=new DataObject();
        boolean b=dt.compTarrif3(jb);                         
        hm=(HashMap)dt.compTarrif1(p);           
        request.setAttribute("hmap",hm); 
        if(b==true){
        request.setAttribute("msg","Data Updated");
        }
        return mapping.findForward("success");
    }    
           public ActionForward delCompTarrifRate(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        PrintWriter out=response.getWriter();
        JavaBean jb=new JavaBean();
        HashMap hm=new HashMap(); 
        DataObject dt=new DataObject();
        String p=(String)request.getParameter("pr"); 
        String id=request.getParameter("pid");        
        boolean bn=dt.deleteCompTarrif(id);
        hm=(HashMap)dt.compTarrif1(p);           
        request.setAttribute("hmap",hm);     
        if(bn==true){
        request.setAttribute("msg","Deleted");    
        }
        return mapping.findForward(SUCCESS);
      } 
       
    ////////////////////////////////////////////////////////////////////////////////////////   
       
     public ActionForward updateTarrifAction(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        PrintWriter out=response.getWriter();
        JavaBean jb=new JavaBean();
        DataObject dt=new DataObject();
        ArrayList ar=dt.getBusRate();
        request.setAttribute("arr",ar);
        return mapping.findForward(SUCCESS);
    }   
    
      public ActionForward show(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        PrintWriter out=response.getWriter();
        JavaBean jb=new JavaBean();
        DataObject dt=new DataObject();
        String id=request.getParameter("pr");
        ArrayList ar=dt.getData(id);
        request.setAttribute("arr",ar);              
        return mapping.findForward(SUCCESS);
    }
    
       public ActionForward updateData(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        DynaActionForm dynaform=(DynaActionForm)form;
        PrintWriter out=response.getWriter();
        String id1=(String)request.getParameter("pr");
        String dat=(String)request.getParameter("dated");
        String zone=(String)request.getParameter("zone");
        double wt100=Double.parseDouble(request.getParameter("wt100").toString());
        double wt250=Double.parseDouble(request.getParameter("wt250").toString());
        double wt500=Double.parseDouble(request.getParameter("wt500").toString());
        double adwt=Double.parseDouble(request.getParameter("adwt500").toString());       
        
        JavaBean jb=new JavaBean();
        jb.setId(id1);
        jb.setDated(dat);
        jb.setZone(zone);
        jb.setWt100(wt100);
        jb.setWt250(wt250);
        jb.setWt500(wt500);
        jb.setAdwt500(adwt);
        DataObject dt=new DataObject();
        boolean b=dt.updateBusRate(jb);  
        ArrayList ar=dt.getBusRate();
        request.setAttribute("arr",ar);
        if(b==true){
        request.setAttribute("msg","Data Updated");
        }
        return mapping.findForward("success");
    }   
       
      ////////////////////////////////////////////////////////////////////////////////////// 
       public ActionForward updateAir1(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        PrintWriter out=response.getWriter();
        JavaBean jb=new JavaBean();
        DataObject dt=new DataObject();
        ArrayList ar=dt.airCargo();
        request.setAttribute("arr",ar);
        return mapping.findForward(SUCCESS);
    }
       public ActionForward showAir(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        PrintWriter out=response.getWriter();
        JavaBean jb=new JavaBean();
        DataObject dt=new DataObject();
        String id=request.getParameter("pr");
        ArrayList ar=dt.showAirData(id);
        request.setAttribute("arr",ar);              
        return mapping.findForward(SUCCESS);
      }
            public ActionForward delAirCargo(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        PrintWriter out=response.getWriter();
        JavaBean jb=new JavaBean();
        DataObject dt=new DataObject();
        String id=request.getParameter("pr");        
        boolean bn=dt.deleteAirData(id);
        ArrayList ar=dt.showAirData(id);
        request.setAttribute("arr",ar);     
        if(bn==true){
        request.setAttribute("msg","Deleted");    
        }
        return mapping.findForward(SUCCESS);
      }
        public ActionForward delTarrifRate(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        PrintWriter out=response.getWriter();
        JavaBean jb=new JavaBean();
        DataObject dt=new DataObject();
        String id=request.getParameter("pr");        
        boolean bn=dt.deleteTarrifData(id);
        ArrayList ar=dt.getData(id);
        request.setAttribute("arr",ar);     
        if(bn==true){
        request.setAttribute("msg","Deleted");    
        }
        return mapping.findForward(SUCCESS);
      }    
            
           public ActionForward delSurfaceCargo(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        PrintWriter out=response.getWriter();
        JavaBean jb=new JavaBean();
        DataObject dt=new DataObject();
        String id=request.getParameter("pr");        
        boolean bn=dt.deleteSurfaceData(id);
        ArrayList ar=dt.showSurfaceData(id);
        request.setAttribute("arr",ar);     
        if(bn==true){
        request.setAttribute("msg","Deleted");    
        }
        return mapping.findForward(SUCCESS);
      }           
       
         public ActionForward updateAirData(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        DynaActionForm dynaform=(DynaActionForm)form;
        PrintWriter out=response.getWriter();
        String id1=(String)request.getParameter("pr");
        String dat=(String)request.getParameter("dated");
        String zone=(String)request.getParameter("zone");
        double wt1=Double.parseDouble(request.getParameter("wt15").toString());
        double wt2=Double.parseDouble(request.getParameter("wt525").toString());
        double wt3=Double.parseDouble(request.getParameter("wt2550").toString());   
        double wt4=Double.parseDouble(request.getParameter("wt50100").toString()); 
        double wt5=Double.parseDouble(request.getParameter("above100").toString()); 
        
        JavaBean jb=new JavaBean();
        jb.setId(id1);
        jb.setDated(dat);
        jb.setZone(zone);
        jb.setWt15(wt1);
        jb.setWt525(wt2);
        jb.setWt2550(wt3);
        jb.setWt50100(wt4);
        jb.setAbove100(wt5);
        DataObject dt=new DataObject();
        boolean b=dt.updateAirRate(jb);  
        ArrayList ar=dt.airCargo();
        request.setAttribute("arr",ar);
        if(b==true){
        request.setAttribute("msg","Data Updated");
        }
        return mapping.findForward("success");
    }
    /////////////////////////////////////////////////////////////////////////////////////////     
    /*   public ActionForward updateSurface1(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        PrintWriter out=response.getWriter();
        JavaBean jb=new JavaBean();
        DataObject dt=new DataObject();
        ArrayList ar=dt.surfaceCargo();
        request.setAttribute("arr",ar);
        return mapping.findForward(SUCCESS);
    }
       public ActionForward showSurface(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        PrintWriter out=response.getWriter();
        JavaBean jb=new JavaBean();
        DataObject dt=new DataObject();
        String id=request.getParameter("pr");
        ArrayList ar=dt.showSurfaceData(id);
        request.setAttribute("arr",ar);              
        return mapping.findForward(SUCCESS);
    }
         public ActionForward updateSurfaceData(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        DynaActionForm dynaform=(DynaActionForm)form;
        PrintWriter out=response.getWriter();
        String id1=(String)request.getParameter("pr");
        String dat=(String)request.getParameter("dated");
        String zone=(String)request.getParameter("zone");
        double wt1=Double.parseDouble(request.getParameter("wt15").toString());
        double wt2=Double.parseDouble(request.getParameter("wt525").toString());
        double wt3=Double.parseDouble(request.getParameter("wt2550").toString());   
        double wt4=Double.parseDouble(request.getParameter("wt50100").toString()); 
        double wt5=Double.parseDouble(request.getParameter("above100").toString()); 
        
        JavaBean jb=new JavaBean();
        jb.setId(id1);
        jb.setDated(dat);
        jb.setZone(zone);
        jb.setWt15(wt1);
        jb.setWt525(wt2);
        jb.setWt2550(wt3);
        jb.setWt50100(wt4);
        jb.setAbove100(wt5);
        DataObject dt=new DataObject();
        boolean b=dt.updateSurfaceRate(jb);  
        ArrayList ar=dt.surfaceCargo();
        request.setAttribute("arr",ar);
        if(b==true){
        request.setAttribute("msg","Data Updated");
        }
        return mapping.findForward("success");
    }      
     */  
           public ActionForward delAllExpense(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        PrintWriter out=response.getWriter();
        JavaBean jb=new JavaBean();
        String p=(String)request.getParameter("pr");
        String id=(String)request.getParameter("pid");
        String dt1=(String)request.getParameter("dated1");
        String dt2=(String)request.getParameter("dated2");
        DataObject2 dt=new DataObject2();
        boolean bn=dt.deleteAllExpense(id);
        HashMap hm=(HashMap)dt.allExpUpdate1(p,dt1,dt2);
        hm.put("dated1",dt1);
        hm.put("dated2",dt2);
        request.setAttribute("hmap",hm);
        if(bn==true){
        request.setAttribute("msg","Deleted");
        }
        return mapping.findForward(SUCCESS);
    } 
       public ActionForward updateAllExp1(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        PrintWriter out=response.getWriter();
        JavaBean jb=new JavaBean();
        String dt1="";
        String dt2="";
        if(request.getParameter("dated1")!=null){
        dt1=(String)request.getParameter("dated1");
        }
        if(request.getParameter("dated2")!=null){
        dt2=(String)request.getParameter("dated2");
        }
        String p=(String)request.getParameter("pr");
        DataObject2 dt=new DataObject2();
        HashMap hm=(HashMap)dt.allExpUpdate1(p,dt1,dt2);
        hm.put("dated1",dt1);
        hm.put("dated2",dt2);
        request.setAttribute("hmap",hm);
        return mapping.findForward(SUCCESS);
    }
       
       public ActionForward updateAllExp2(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        PrintWriter out=response.getWriter();
        JavaBean jb=new JavaBean();
        String dt1="";
        String dt2="";
        if(request.getParameter("dated1")!=null){
        dt1=(String)request.getParameter("dated1");
        }
        if(request.getParameter("dated2")!=null){
        dt2=(String)request.getParameter("dated2");
        }
        DataObject2 dt=new DataObject2();        
        String id=(String)request.getParameter("pid");
        ArrayList ar=(ArrayList)dt.allExpUpdate2(id);              
        request.setAttribute("arr",ar);  
        request.setAttribute("dated1",dt1); 
        request.setAttribute("dated2",dt2); 
        return mapping.findForward(SUCCESS);
    }
       public ActionForward updateAllExp3(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        DynaActionForm dynaform=(DynaActionForm)form;
        PrintWriter out=response.getWriter();
        String dt1="";
        String dt2="";
        if(request.getParameter("dated1")!=null){
        dt1=(String)request.getParameter("dated1");
        }
        if(request.getParameter("dated2")!=null){
        dt2=(String)request.getParameter("dated2");
        }
        String p=(String)request.getParameter("pr");
        String id1=(String)request.getParameter("pid");
        String dat=(String)request.getParameter("dated");
        String det=(String)request.getParameter("detail");
        double amt=Double.parseDouble(request.getParameter("amount").toString());
        String ename=(String)request.getParameter("ename");        
        JavaBean jb=new JavaBean();
        jb.setId(id1);
        jb.setDated(dat);
        jb.setDetails(det);
        jb.setAmount(amt);
        jb.setEmpname(ename);      
        DataObject2 dt=new DataObject2();
        boolean b=dt.allExpUpdate3(jb);  
        HashMap hm=(HashMap)dt.allExpUpdate1(p,dt1,dt2);
        request.setAttribute("hmap",hm);
        hm.put("dated1",dt1);
        hm.put("dated2",dt2);
        if(b==true){
        request.setAttribute("msg","Data Updated");
        }
        return mapping.findForward(SUCCESS);
         }    
       
    
             public ActionForward delFuelExpense(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        PrintWriter out=response.getWriter();        
        String p=(String)request.getParameter("pr");
        String id=(String)request.getParameter("pid");
        String dt1=(String)request.getParameter("dated1");
        String dt2=(String)request.getParameter("dated2");
        DataObject2 dt=new DataObject2();
        boolean bn=dt.deleteFuelExpense(id);       
        HashMap hm=(HashMap)dt.fuelExpUpdate1(p,dt1,dt2);
        hm.put("dated1",dt1);
        hm.put("dated2",dt2);
        request.setAttribute("hmap",hm);
        if(bn==true){
        request.setAttribute("msg","Deleted");
        }
        return mapping.findForward(SUCCESS);
    }       
       public ActionForward updateFuelExp1(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        PrintWriter out=response.getWriter();
        JavaBean jb=new JavaBean();
        String dt1="";
        String dt2="";
        if(request.getParameter("dated1")!=null){
        dt1=(String)request.getParameter("dated1");
        }
        if(request.getParameter("dated2")!=null){
        dt2=(String)request.getParameter("dated2");
        }
        String p=(String)request.getParameter("pr");
        DataObject2 dt=new DataObject2();
        HashMap hm=(HashMap)dt.fuelExpUpdate1(p,dt1,dt2);
        hm.put("dated1",dt1);
        hm.put("dated2",dt2);
        request.setAttribute("hmap",hm);
        return mapping.findForward(SUCCESS);
    }
       public ActionForward updateFuelExp2(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        PrintWriter out=response.getWriter();
        JavaBean jb=new JavaBean();
        String dt1="";
        String dt2="";
        if(request.getParameter("dated1")!=null){
        dt1=(String)request.getParameter("dated1");
        }
        if(request.getParameter("dated2")!=null){
        dt2=(String)request.getParameter("dated2");
        }
        DataObject2 dt=new DataObject2();        
        String id=(String)request.getParameter("pid");
        ArrayList ar=(ArrayList)dt.fuelExpUpdate2(id);              
        request.setAttribute("arr",ar);  
        request.setAttribute("dated1",dt1); 
        request.setAttribute("dated2",dt2); 
        return mapping.findForward(SUCCESS); 
    }
       public ActionForward updateFuelExp3(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        DynaActionForm dynaform=(DynaActionForm)form;
        PrintWriter out=response.getWriter();
        String dt1="";
        String dt2="";
        if(request.getParameter("dated1")!=null){
        dt1=(String)request.getParameter("dated1");
        }
        if(request.getParameter("dated2")!=null){
        dt2=(String)request.getParameter("dated2");
        }
        String p=(String)request.getParameter("pr");
        String id1=(String)request.getParameter("pid");
        String dat=(String)request.getParameter("dated");
        String vehno=(String)request.getParameter("vehno");
        double skm=Double.parseDouble(request.getParameter("startkm").toString());
        double ekm=Double.parseDouble(request.getParameter("endkm").toString());
        double tkm=Double.parseDouble(request.getParameter("totalkm").toString());
        double amt=Double.parseDouble(request.getParameter("amount").toString());              
        JavaBean jb=new JavaBean();
        jb.setId(id1);
        jb.setDated(dat);
        jb.setVehno(vehno);
        jb.setStartkm(skm);
        jb.setEndkm(ekm);
        jb.setTotalkm(tkm);
        jb.setAmount(amt);              
        DataObject2 dt=new DataObject2();
        boolean b=dt.fuelExpUpdate3(jb);        
        HashMap hm=(HashMap)dt.fuelExpUpdate1(p,dt1,dt2);
        request.setAttribute("hmap",hm);
        hm.put("dated1",dt1);
        hm.put("dated2",dt2);
        if(b==true){
        request.setAttribute("msg","Data Updated");
        }
        return mapping.findForward("success");
         }  
      /*//////////////////////////////////////////////////////////////////////////////////////////  
        public ActionForward submitCompAction(ActionMapping mapping,ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception{
        MyMethods mym=new MyMethods();         
        DynaActionForm dynaform=(DynaActionForm)form;
        PrintWriter out=response.getWriter();
        String ndoc=""; 
        double wt=0.0;
        double amt=0.0;  
        String airway=request.getParameter("airway");
        String type=request.getParameter("type");
        String consignee=request.getParameter("consignee");
        String add1=request.getParameter("address1");
        String add2=request.getParameter("address2");
        String city=request.getParameter("city");
        String country=request.getParameter("country");
        String phno=request.getParameter("phno");
        String fax=request.getParameter("faxno");
        String courierid=request.getParameter("courierid");
        String dat=(String)request.getParameter("dated");
        String mod=request.getParameter("mode");
        String cn=(String)request.getParameter("compname");       
        String cnno=(String)request.getParameter("cnno");
        String by=(String)request.getParameter("by");        
        String dest=(String)request.getParameter("dest");
        String zone=(String)request.getParameter("zone");              
        if(request.getParameter("nondoc")!=null){
        ndoc=request.getParameter("nondoc");           
        }        
        try{
        wt=Double.parseDouble(request.getParameter("weight").toString());
        amt=Double.parseDouble(request.getParameter("amount").toString()); 
        }
        catch(Exception e){}
        int b=0;
        JavaBean jb=new JavaBean();
        MyMethods mm=new MyMethods(); 
        jb.setAirwayNo(airway);
        jb.setType(type);
        jb.setConsignee(consignee);
        jb.setAddress1(add1);
        jb.setAddress2(add2);
        jb.setCity(city);
        jb.setCountry(country);
        jb.setTelephone(phno);
        jb.setFax(fax);
        jb.setCourierId(courierid);
        jb.setDated(dat);
        jb.setMode(mod);
        jb.setCompname(cn);
        jb.setCnno(cnno);
        jb.setZone(zone);
        jb.setWeight(wt);
        jb.setBy(by);
        jb.setDest(dest);
        jb.setAmount(amt);
        jb.setNdoc(ndoc);       
        double nondoc=0.0;
        if(jb.getNdoc().equals("nondoc")){
       // nondoc=mm.nonDocAmount(jb);    
        }
        jb.setNondoc(nondoc);        
      //  int num=mym.checkConsign(jb);
      //  if(num==1){
     //   DataObject3 dt3=new DataObject3();
        DataObject dt=new DataObject();
        b=dt.subCompBill(jb);
      //  boolean bn=dt3.updateIssuedBalance(cnno);     
        if(b==0){
        request.setAttribute("msg","Data Submitted");
        }
        else{        
        request.setAttribute("msg","Consignment Number "+jb.getCnno()+" Already Exists");    
        jb.setCnno("");
        }
        }
     //   else{
        request.setAttribute("msg","No Such Issued Consignment No.");    
        }
      //  ArrayList ar2=(ArrayList)mym.compBillList(cn,dat);        
     //   request.setAttribute("compbill",ar2);
      //  request.setAttribute("jbean",jb);
      //  return mapping.findForward(SUCCESS);
  }
           
        public ActionForward cratesAction(ActionMapping mapping,ActionForm form,
        HttpServletRequest request, HttpServletResponse response) throws Exception{
        PrintWriter out=response.getWriter();  
        MyMethods mm=new MyMethods(); 
        String airway=request.getParameter("airway");
        String type=request.getParameter("type");
        String consignee=request.getParameter("consignee");
        String add1=request.getParameter("address1");
        String add2=request.getParameter("address2");
        String city=request.getParameter("city");
        String country=request.getParameter("country");
        String phno=request.getParameter("phno");
        String fax=request.getParameter("faxno");
        String courierid=request.getParameter("courierid");
        String dat=request.getParameter("dated");
        String mod=request.getParameter("mode");
        String cname=request.getParameter("compname");  
        String by=request.getParameter("by");  
        String cno=request.getParameter("cnno");
        String dest=request.getParameter("dest");  
        String zn=request.getParameter("zone"); 
        String ndoc="";       
        if(request.getParameter("nondoc")!=null){
        ndoc=request.getParameter("nondoc");    
        }
        double wt=0.0;
        double nondoc=0.0;
        try{
        wt=Double.parseDouble(request.getParameter("weight").toString());         
        }catch(NumberFormatException ex){}         
        JavaBean jb=new JavaBean();  
        jb.setAirwayNo(airway);
        jb.setType(type);
        jb.setConsignee(consignee);
        jb.setAddress1(add1);
        jb.setAddress2(add2);
        jb.setCity(city);
        jb.setCountry(country);
        jb.setTelephone(phno);
        jb.setFax(fax);
        jb.setCourierId(courierid);
        jb.setDated(dat);
        jb.setMode(mod);
        jb.setCompname(cname);
        jb.setBy(by);
        jb.setCnno(cno);
        jb.setDest(dest);
        jb.setZone(zn);
        jb.setWeight(wt);
        jb.setNdoc(ndoc);             
        JavaBean jb1=new JavaBean();
        DataObject dt=new DataObject();
        int b=mm.checkDestination(dest);
        if(b>0){
        jb1=(JavaBean)dt.crates(jb);       
        }
        else{
        jb.setDest("");
        request.setAttribute("msg","No Such Destination Available");        
        }   
        jb.setZone(jb1.getZone());
        jb.setAmount(jb1.getAmount());
        if(jb.getNdoc().equals("nondoc")){
        nondoc=mm.nonDocAmount(jb);    
        }
        jb.setNondoc(nondoc); 
        request.setAttribute("jbean",jb);
        return mapping.findForward(SUCCESS);
    }  
        
           public ActionForward callZonesAction(ActionMapping mapping,ActionForm form,
           HttpServletRequest request, HttpServletResponse response)
           throws Exception{
        PrintWriter out=response.getWriter();        
        String dat=(String)request.getParameter("dated");
        String cname=(String)request.getParameter("compname");  
        String by=(String)request.getParameter("by");                  
        DataObject dt=new DataObject();
        JavaBean jb2=(JavaBean)dt.callZones(cname,by);  
        jb2.setDated(dat);  
        request.setAttribute("compnm",cname);        
        request.setAttribute("jbean",jb2);
        return mapping.findForward(SUCCESS);
    }        
      ///////////////////////////////////////////////////////////////////////////////////////////   
              public ActionForward ratesAction(ActionMapping mapping,ActionForm form,
          HttpServletRequest request, HttpServletResponse response) throws Exception{
        PrintWriter out=response.getWriter();
        MyMethods mm=new MyMethods(); 
        String dat=(String)request.getParameter("dated");
        String cname=(String)request.getParameter("compname");
        String by=(String)request.getParameter("by");  
        String cno=(String)request.getParameter("cnno");
        String dest=(String)request.getParameter("dest");  
        String zn=(String)request.getParameter("zone"); 
        double wt=Double.parseDouble(request.getParameter("weight").toString());         
        JavaBean jb=new JavaBean();        
        jb.setBy(by);
        jb.setCnno(cno);
        jb.setDest(dest);
        jb.setZone(zn);
        jb.setWeight(wt);
        DataObject dt=new DataObject();
        JavaBean jb2=dt.allZones(by); 
        jb2.setDated(dat); 
        JavaBean jb1=new JavaBean(); 
        int b=mm.checkDestination(dest);
        if(b>0){
        jb1=(JavaBean)dt.rates(by,dest,wt); 
        request.setAttribute("jbean1",jb1);
        }
        else{
         jb.setDest("");
        request.setAttribute("msg","No Such Destination Available");        
        }  
        request.setAttribute("compnm",cname);
        request.setAttribute("jbean",jb2);
        request.setAttribute("jbean1",jb1);
        request.setAttribute("jbean2",jb);
        return mapping.findForward(SUCCESS);
    }  
           
           public ActionForward submitSingleAction(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        DynaActionForm dynaform=(DynaActionForm)form;
        PrintWriter out=response.getWriter();       
        String dat=(String)request.getParameter("dated");
        String cnno=dynaform.get("cnno").toString();
        String by=dynaform.get("by").toString();
        double wt=Double.parseDouble(dynaform.get("weight").toString());
        String dest=dynaform.get("dest").toString();
        String zone=dynaform.get("zone").toString();
        double amt=Double.parseDouble(dynaform.get("amount").toString());          
        JavaBean jb=new JavaBean();        
        jb.setDated(dat);
        jb.setCnno(cnno);
        jb.setZone(zone);
        jb.setWeight(wt);
        jb.setBy(by);
        jb.setDest(dest);
        jb.setAmount(amt);        
        DataObject3 dt3=new DataObject3();
        DataObject dt=new DataObject();
        int b=dt.submitSingle(jb);
        boolean bn=dt3.updateIssuedBalance(cnno);
        if(b==0){
        request.setAttribute("msg","Data Submitted");
        }
        return mapping.findForward(SUCCESS);
        }      
          
        public ActionForward modZones(ActionMapping mapping,ActionForm form,
        HttpServletRequest request, HttpServletResponse response) throws Exception{
        PrintWriter out=response.getWriter();
        String mode=(String)request.getParameter("mode");  
        JavaBean jb=new JavaBean();        
        jb.setBy(mode);
        DataObject dt=new DataObject();
        JavaBean jb2=(JavaBean)dt.allZones(mode); 
        request.setAttribute("jbean",jb);
        request.setAttribute("jbean2",jb2);
        return mapping.findForward(SUCCESS);
    }      
        public ActionForward modZoneRate(ActionMapping mapping,ActionForm form,
        HttpServletRequest request, HttpServletResponse response) throws Exception{
        PrintWriter out=response.getWriter();
        String mode=(String)request.getParameter("mode");  
        String zn=(String)request.getParameter("zone"); 
        double wt=Double.parseDouble(request.getParameter("weight").toString()); 
        JavaBean jb=new JavaBean();        
        jb.setBy(mode);
        jb.setZone(zn);
        jb.setWeight(wt);
        DataObject dt=new DataObject();
        JavaBean jb1=(JavaBean)dt.modrates(mode,zn,wt); 
        request.setAttribute("jbean",jb);
        request.setAttribute("jbean1",jb1);
        return mapping.findForward(SUCCESS);
    }  
     /////////////////////////////////////////////////////////////////////////////////////////////
        
        public ActionForward compModZones(ActionMapping mapping,ActionForm form,
        HttpServletRequest request, HttpServletResponse response) throws Exception{
        PrintWriter out=response.getWriter();
        String cname=(String)request.getParameter("compname");
        String mode=(String)request.getParameter("mode");  
        JavaBean jb=new JavaBean();   
        jb.setCompname(cname);
        jb.setBy(mode);
        DataObject dt=new DataObject();
        JavaBean jb2=(JavaBean)dt.callZones(cname,mode); 
        request.setAttribute("jbean",jb);
        request.setAttribute("jbean2",jb2);
        return mapping.findForward(SUCCESS);
    }      
        
        public ActionForward compModZoneRate(ActionMapping mapping,ActionForm form,
        HttpServletRequest request, HttpServletResponse response) throws Exception{
        PrintWriter out=response.getWriter();      
        String cname=request.getParameter("comp");       
        String mode=request.getParameter("mode");     
        String zn=request.getParameter("zone"); 
        double wt=0.0;
        try {
        wt=Double.parseDouble(request.getParameter("weight").toString());
        } catch(NumberFormatException ex){}
        JavaBean jb=new JavaBean();  
        jb.setCompname(cname);
        jb.setBy(mode);
        jb.setZone(zn);
        jb.setWeight(wt);   
        DataObject dt=new DataObject();
        JavaBean jb1=(JavaBean)dt.cmodrates(jb);     
        request.setAttribute("jbean",jb1);
        return mapping.findForward(SUCCESS);
    } 
        
        public ActionForward allZonesAction(ActionMapping mapping,ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception{
        PrintWriter out=response.getWriter();   
        String dat=(String)request.getParameter("dated");
        String cname=(String)request.getParameter("compname");
        String by=(String)request.getParameter("by");                  
        DataObject dt=new DataObject();
        JavaBean jb2=(JavaBean)dt.allZones(by); 
        jb2.setDated(dat);        
        request.setAttribute("compnm",cname);
        request.setAttribute("jbean",jb2);
        return mapping.findForward(SUCCESS);
    } 
      ///////////////////////////////////////////////////////////////////////////////////////////    
          public ActionForward toPay_CodRates(ActionMapping mapping,ActionForm form,                      
          HttpServletRequest request, HttpServletResponse response) throws Exception{
        PrintWriter out=response.getWriter();
        MyMethods mm=new MyMethods(); 
        String dat=(String)request.getParameter("dated");
        String by=(String)request.getParameter("by");          
        String cno=(String)request.getParameter("cnno");
        String pname="";
        if(request.getParameter("partyname")!=null){
        pname=(String)request.getParameter("partyname");  
        }
        double wt=0.0;
        if(request.getParameter("weight")!=null){
        wt=Double.parseDouble(request.getParameter("weight").toString());  
        }
        String dest="";        
        if(request.getParameter("dest")!=null){
        dest=(String)request.getParameter("dest");
        }
        String zn=""; 
        if(request.getParameter("zone")!=null){
        zn=(String)request.getParameter("zone");    
        }
        JavaBean jb=new JavaBean();        
        jb.setBy(by);
        jb.setCnno(cno);
        jb.setPartyname(pname);
        jb.setDest(dest);
        jb.setWeight(wt);
        int b=mm.checkDestination(dest);        
        DataObject dt1=new DataObject();
        DataObject2 dt=new DataObject2();
        JavaBean jb2=dt.allZonesToPay(by); 
        jb2.setDated(dat); 
        if(b>0){
        JavaBean jb1=dt1.rates(by,dest,wt);     
        request.setAttribute("jbean1",jb1);
        }
        else{
        jb.setDest("");
        request.setAttribute("msg","No Such Destination Available");        
        }
        request.setAttribute("jbean",jb2);        
        request.setAttribute("jbean2",jb);
        return mapping.findForward(SUCCESS);
    }      
            
        public ActionForward toPay_CodZones(ActionMapping mapping,ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception{
        PrintWriter out=response.getWriter();   
        String dat=(String)request.getParameter("dated");
        String by=(String)request.getParameter("by");                  
        DataObject2 dt=new DataObject2();
        JavaBean jb2=(JavaBean)dt.allZonesToPay(by);   
        jb2.setDated(dat); 
        request.setAttribute("jbean",jb2);
        return mapping.findForward(SUCCESS);
    } 
   ///////////////////////////////////////////////////////////////////////////////////////////    
    
     public ActionForward enterToPayCod(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        PrintWriter out=response.getWriter();
        String dat="";
        MyMethods mym=new MyMethods(); 
        if(request.getParameter("dated")!=null){
        dat=(String)request.getParameter("dated");
        }
        String cno="";
        if(request.getParameter("cnno")!=null){
        cno=(String)request.getParameter("cnno"); 
        }
        String by="";
        if(request.getParameter("by")!=null){
        by=(String)request.getParameter("by"); 
        }
        String pname="";
        if(request.getParameter("partyname")!=null){
        pname=(String)request.getParameter("partyname"); 
        }
        double wt=0.0;
        if(request.getParameter("weight")!=null){
        wt=Double.parseDouble(request.getParameter("weight").toString());   
        }
        String dest="";
        if(request.getParameter("dest")!=null){
        dest=(String)request.getParameter("dest"); 
        }
        String zone="";
        if(request.getParameter("zone")!=null){
        zone=(String)request.getParameter("zone"); 
        }
        double topay=0.0;
        if(request.getParameter("topay")!=null){
        topay=Double.parseDouble(request.getParameter("topay").toString()); 
        }
        double cod=0.0;
        if(request.getParameter("cod")!=null){
        cod=Double.parseDouble(request.getParameter("cod").toString()); 
        }
        String recptno="";
        if(request.getParameter("recptno")!=null){
        recptno=(String)request.getParameter("recptno"); 
        }
        double collctn=0.0;
        if(request.getParameter("collection")!=null){
        Double.parseDouble(request.getParameter("collection").toString()); 
        }
        JavaBean jb=new JavaBean();
        jb.setDated(dat);
        jb.setCnno(cno);
        jb.setBy(by);
        jb.setPartyname(pname);
        jb.setWeight(wt);   
        jb.setDest(dest);
        jb.setZone(zone);
        jb.setTopay(topay);
        jb.setAmount(topay);
        jb.setCod(cod);
        jb.setRecptno(recptno);
        jb.setCollection(collctn);
        int num=mym.checkConsign(jb);
        if(num==1){
        DataObject3 dt3=new DataObject3();
        DataObject2 dt2=new DataObject2();
        int b=dt2.toPayCod(jb);
        boolean bn=dt3.updateIssuedBalance(cno);
        if(b==0){
        request.setAttribute("msg","Data Submitted");
        }
        else{
        request.setAttribute("msg","Consignment Number Already Exists");    
        }
        }
        else{
        request.setAttribute("msg","No Such Issued Consignment No.");    
        }
        DataObject dt=new DataObject();
        JavaBean jb2=(JavaBean)dt.allZones(by);
        jb2.setDated(dat); 
        request.setAttribute("jbean",jb2);
        request.setAttribute("jbean2",jb);
        request.setAttribute("jbean1",jb);
        return mapping.findForward(SUCCESS);
        }   
    ////////////////////////////////////////////////////////////////////////////////////// 
//          public ActionForward compSurfaceAction(ActionMapping mapping,ActionForm form,
//            HttpServletRequest request, HttpServletResponse response)
//            throws Exception{
//        PrintWriter out=response.getWriter();  
//        String dat=(String)request.getParameter("dated");
//        String compname=(String)request.getParameter("compname");     
//        String zone=(String)request.getParameter("zone");
//        double wt15=0.0;
//        double wt525=0.0;
//        double wt2550=0.0;
//        double wt50100=0.0;    
//        double above100=0.0;
//        try{
//        wt15=Double.parseDouble(request.getParameter("wt15").toString());
//        wt525=Double.parseDouble(request.getParameter("wt525").toString());
//        wt2550=Double.parseDouble(request.getParameter("wt2550").toString());
//        wt50100=Double.parseDouble(request.getParameter("wt50100").toString());
//        above100=Double.parseDouble(request.getParameter("above100").toString());
//        }
//        catch(Exception e){}
//        JavaBean jb=new JavaBean();
//        jb.setDated(dat);
//        jb.setCompname(compname);
//        jb.setZone(zone);
//        jb.setWt15(wt15);
//        jb.setWt525(wt525);
//        jb.setWt2550(wt2550);
//        jb.setWt50100(wt50100);
//        jb.setAbove100(above100);
//        DataObject dt=new DataObject();
//        int b=dt.compSurfaceCargo(jb);
//        request.setAttribute("jbean",jb);
//        if(b==0){
//        request.setAttribute("msg","Data Submitted");
//        }
//        else{
//        request.setAttribute("msg","Data Already Exists");    
//        }
//        return mapping.findForward(SUCCESS);             
//      }
//          
//            public ActionForward busAction(ActionMapping mapping,ActionForm form,
//            HttpServletRequest request, HttpServletResponse response)
//            throws Exception{
//        DynaActionForm dynaform=(DynaActionForm)form;
//        PrintWriter out=response.getWriter();
//        String dat=(String)request.getParameter("dated");
//        String zone=dynaform.get("zone").toString();
//        double wt100=Double.parseDouble(dynaform.get("wt100").toString());
//        double wt250=Double.parseDouble(dynaform.get("wt250").toString());
//        double wt500=Double.parseDouble(dynaform.get("wt500").toString());
//        double adwt=Double.parseDouble(dynaform.get("adwt500").toString());        
//        JavaBean jb=new JavaBean();
//        jb.setDated(dat);
//        jb.setZone(zone);
//        jb.setWt100(wt100);
//        jb.setWt250(wt250);
//        jb.setWt500(wt500);
//        jb.setAdwt500(adwt);
//        DataObject dt=new DataObject();
//        boolean b=dt.busRate(jb);
//        if(b==true){
//            request.setAttribute("msg","Data Submitted");
//        }
//        return mapping.findForward(SUCCESS);
//    }
//       public ActionForward airCargoAction(ActionMapping mapping,ActionForm form,
//            HttpServletRequest request, HttpServletResponse response)
//            throws Exception{
//        DynaActionForm dynaform=(DynaActionForm)form;
//        PrintWriter out=response.getWriter();
//        String dat=(String)request.getParameter("dated");
//        String zone=dynaform.get("zone").toString();
//        double wt15=Double.parseDouble(dynaform.get("wt15").toString());
//        double wt525=Double.parseDouble(dynaform.get("wt525").toString());
//        double wt2550=Double.parseDouble(dynaform.get("wt2550").toString());
//        double wt50100=Double.parseDouble(dynaform.get("wt50100").toString());
//        double above100=Double.parseDouble(dynaform.get("above100").toString());
//        JavaBean jb=new JavaBean();
//        jb.setDated(dat);
//        jb.setZone(zone);
//        jb.setWt15(wt15);
//        jb.setWt525(wt525);
//        jb.setWt2550(wt2550);
//        jb.setWt50100(wt50100);
//        jb.setAbove100(above100);
//        DataObject dt=new DataObject();
//        boolean b=dt.airCargoRate(jb);
//        if(b==true){
//            request.setAttribute("msg","Data Submitted");
//        }
//        return mapping.findForward(SUCCESS);
//    }
//      public ActionForward surfaceCargoAction(ActionMapping mapping,ActionForm form,
//            HttpServletRequest request, HttpServletResponse response)
//            throws Exception{
//        DynaActionForm dynaform=(DynaActionForm)form;
//        PrintWriter out=response.getWriter();
//        String dat=(String)request.getParameter("dated");
//        String zone=dynaform.get("zone").toString();
//        double wt15=Double.parseDouble(dynaform.get("wt15").toString());
//        double wt525=Double.parseDouble(dynaform.get("wt525").toString());
//        double wt2550=Double.parseDouble(dynaform.get("wt2550").toString());
//        double wt50100=Double.parseDouble(dynaform.get("wt50100").toString());
//        double above100=Double.parseDouble(dynaform.get("above100").toString());
//        JavaBean jb=new JavaBean();
//        jb.setDated(dat);
//        jb.setZone(zone);
//        jb.setWt15(wt15);
//        jb.setWt525(wt525);
//        jb.setWt2550(wt2550);
//        jb.setWt50100(wt50100);
//        jb.setAbove100(above100);
//        DataObject dt=new DataObject();
//        boolean b=dt.surfaceCargoRate(jb);
//        if(b==true){
//            request.setAttribute("msg","Data Submitted");
//        }
//        return mapping.findForward(SUCCESS);
//    } */
}
