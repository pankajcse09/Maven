package com.myapp.struts;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.DynaActionForm;
import java.io.*;
import java.util.*;

public class MyAction2 extends DispatchAction{  
    private final static String SUCCESS = "success"; 
    
       public ActionForward upToPayCodAction(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
            String id1="";
            String dt1="";
            String dt2="";
            JavaBean jb=new JavaBean();  
        DynaActionForm dynaform=(DynaActionForm)form;
        PrintWriter out=response.getWriter(); 
           if(request.getParameter("id")!=null){
            id1=(String)request.getParameter("id");    
            }  
        String p=(String)request.getParameter("pr");
        if(request.getParameter("dated1")!=null){dt1=(String)request.getParameter("dated1");}
        if(request.getParameter("dated2")!=null){dt2=(String)request.getParameter("dated2");}
        String by=request.getParameter("by").toString();         
        String pname=request.getParameter("partyname").toString();         
        double wt=Double.parseDouble(request.getParameter("weight").toString());            
        String dest=request.getParameter("dest").toString(); 
        String zone=request.getParameter("zone").toString(); 
        double topay=Double.parseDouble(request.getParameter("topay").toString()); 
        double cod=Double.parseDouble(request.getParameter("cod").toString()); 
        String recptno=request.getParameter("recptno").toString(); 
        double collctn=Double.parseDouble(request.getParameter("collection").toString()); 
        jb.setId(id1);
        jb.setBy(by);
        jb.setPartyname(pname);
        jb.setWeight(wt);   
        jb.setDest(dest);
        jb.setZone(zone);
        jb.setTopay(topay);
        jb.setCod(cod);
        jb.setRecptno(recptno);
        jb.setCollection(collctn);   
        DataObject2 dt=new DataObject2();             
        boolean bn=dt.updateToPayData(jb);
        MyMethods mm=new MyMethods();
        HashMap hm=(HashMap)mm.toPayCodData(p,dt1,dt2);
        request.setAttribute("hmap",hm);
        hm.put("dated1",dt1);
        hm.put("dated2",dt2);
        request.setAttribute("msg","Data Updated");
        return mapping.findForward(SUCCESS);
    }
       
          public ActionForward delToPayCodAction(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
            String id1="";
            String dt1="";
            String dt2="";
            JavaBean jb=new JavaBean();        
           PrintWriter out=response.getWriter(); 
            if(request.getParameter("dated1")!=null){
            dt1=(String)request.getParameter("dated1");    
            }
            if(request.getParameter("dated2")!=null){
            dt2=(String)request.getParameter("dated2");    
            }
           if(request.getParameter("id")!=null){
            id1=(String)request.getParameter("id");    
            }                      
        jb.setId(id1);        
        DataObject2 dt=new DataObject2();             
        int cn=dt.deleteToPayData(jb);
        out.println(cn);
        request.setAttribute("dated1",dt1);
        request.setAttribute("dated2",dt2);
        request.setAttribute("msg","Data Updated");
        return mapping.findForward(SUCCESS);
    } 
    
        public ActionForward upCompToPayCodAction(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
            String id1="";
            String dt1="";
            String dt2="";
            JavaBean jb=new JavaBean();        
           PrintWriter out=response.getWriter(); 
            if(request.getParameter("dated1")!=null){
            dt1=(String)request.getParameter("dated1");    
            }
            if(request.getParameter("dated2")!=null){
            dt2=(String)request.getParameter("dated2");    
            }
           if(request.getParameter("id")!=null){
            id1=(String)request.getParameter("id");    
            }                      
        String by=request.getParameter("by").toString(); 
        String cname=request.getParameter("compname").toString();
        String pname=request.getParameter("partyname").toString();         
        double wt=Double.parseDouble(request.getParameter("weight").toString());            
        String dest=request.getParameter("dest").toString(); 
        String zone=request.getParameter("zone").toString(); 
        double topay=Double.parseDouble(request.getParameter("topay").toString()); 
        double cod=Double.parseDouble(request.getParameter("cod").toString()); 
        String recptno=request.getParameter("recptno").toString(); 
        double collctn=Double.parseDouble(request.getParameter("collection").toString()); 
        jb.setId(id1);
        jb.setBy(by);
        jb.setCompname(cname);
        jb.setPartyname(pname);
        jb.setWeight(wt);   
        jb.setDest(dest);
        jb.setZone(zone);
        jb.setTopay(topay);
        jb.setCod(cod);
        jb.setRecptno(recptno);
        jb.setCollection(collctn);   
        DataObject2 dt=new DataObject2();             
        boolean bn=dt.updateCompToPayData(jb);
        request.setAttribute("dated1",dt1);
        request.setAttribute("dated2",dt2);
        request.setAttribute("msg","Data Updated");
        return mapping.findForward(SUCCESS);
    }    
        
          public ActionForward delCompToPayCodAction(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
            String id1="";
            String dt1="";
            String dt2="";
            JavaBean jb=new JavaBean();        
           PrintWriter out=response.getWriter(); 
            if(request.getParameter("dated1")!=null){
            dt1=(String)request.getParameter("dated1");    
            }
            if(request.getParameter("dated2")!=null){
            dt2=(String)request.getParameter("dated2");    
            }
           if(request.getParameter("id")!=null){
            id1=(String)request.getParameter("id");    
            }                      
        jb.setId(id1);        
        DataObject2 dt=new DataObject2();             
        int cn=dt.deleteCompToPayData(jb);
        out.println(cn);
        request.setAttribute("dated1",dt1);
        request.setAttribute("dated2",dt2);
        request.setAttribute("msg","Data Updated");
        return mapping.findForward(SUCCESS);
    } 
        
    public ActionForward report1(ActionMapping mapping,ActionForm form,
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
    
       public ActionForward report2(ActionMapping mapping,ActionForm form,
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
       
       public ActionForward report3(ActionMapping mapping,ActionForm form,
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
        String d=(String)dt.totalCash(dt1,dt2);
        HashMap hm=(HashMap)dt.cashReport(p,dt1,dt2);
        hm.put("dated1",dt1);
        hm.put("dated2",dt2);
        hm.put("total",d);
        request.setAttribute("hmap",hm);
        return mapping.findForward(SUCCESS);        
    } 
     
     public ActionForward subConsign(ActionMapping mapping,ActionForm form,
     HttpServletRequest request, HttpServletResponse response)
     throws Exception{
       PrintWriter out=response.getWriter();
       ArrayList ar=new ArrayList();     
       JavaBean jb=new JavaBean();
       String dat1=(String)request.getParameter("dated");
       //int av=Integer.parseInt(request.getParameter("available").toString()); 
       //int na=Integer.parseInt(request.getParameter("newadded").toString());
       //int total=Integer.parseInt(request.getParameter("total").toString());
       //String series=(String)request.getParameter("series");
       long fromno=0;
       long tono=0;
        try{
            fromno=Long.parseLong(request.getParameter("consignfrom").toString());       
            tono=Long.parseLong(request.getParameter("consignto").toString());
            } 
        catch(NumberFormatException ex) {}
       jb.setDated(dat1);  
       //jb.setSeries(series);
       jb.setFromno(fromno);
       jb.setTono(tono);       
       DataObject2 dt=new DataObject2();
       int bn=dt.consignSubmit(jb);     
       if(bn==0){
       request.setAttribute("msg","Data Submitted");
       }
       else{
       if(bn==-1){    
       request.setAttribute("msg","Database Error");    
       }else{
       request.setAttribute("msg","Consignment Already Exist");    
       }       
       }
       request.setAttribute("jbean",jb);
       return mapping.findForward(SUCCESS);
    }   
     
       public ActionForward subAirwaySeries(ActionMapping mapping,ActionForm form,
     HttpServletRequest request, HttpServletResponse response)
     throws Exception{
       PrintWriter out=response.getWriter();
       ArrayList ar=new ArrayList();     
       JavaBean jb=new JavaBean();
       String dat1=(String)request.getParameter("dated");
       //int av=Integer.parseInt(request.getParameter("available").toString()); 
       //int na=Integer.parseInt(request.getParameter("newadded").toString());
       //int total=Integer.parseInt(request.getParameter("total").toString());
       //String series=(String)request.getParameter("series");
       long fromno=0;
       long tono=0;
        try{
            fromno=Long.parseLong(request.getParameter("seriesfrom").toString());       
            tono=Long.parseLong(request.getParameter("seriesto").toString());
            } 
        catch(NumberFormatException ex) {}
       jb.setDated(dat1);  
       //jb.setSeries(series);
       jb.setFromno(fromno);
       jb.setTono(tono);       
       DataObject2 dt=new DataObject2();
       int bn=dt.airwaySeriesSubmit(jb);     
       if(bn==0){
       request.setAttribute("msg","Data Submitted");
       }
       else{
       if(bn==-1){    
       request.setAttribute("msg","Database Error");    
       }else{
       request.setAttribute("msg","Airway Series Already Exist");    
       }       
       }
       request.setAttribute("jbean",jb);
       return mapping.findForward(SUCCESS);
    } 
     
      public ActionForward issuedConsign(ActionMapping mapping,ActionForm form,
     HttpServletRequest request, HttpServletResponse response)
     throws Exception{
       PrintWriter out=response.getWriter();       
       JavaBean jb=new JavaBean();
       MyMethods mm=new MyMethods();       
       String dat1=(String)request.getParameter("dated");
       //int av=Integer.parseInt(request.getParameter("available").toString()); 
       String ename=request.getParameter("ename").toString();
       //int na=Integer.parseInt(request.getParameter("newadded").toString());
       //int total=Integer.parseInt(request.getParameter("total").toString());   
       long fromno=Long.parseLong(request.getParameter("consignfrom").toString());
       long tono=Long.parseLong(request.getParameter("consignto").toString());
       long ton=Long.parseLong(request.getParameter("conto").toString());
       jb.setDated(dat1);
       //jb.setNewconsign(na);
       //jb.setTotconsign(total);
       jb.setEmpname(ename);
       jb.setFromno(fromno);
       jb.setTono(tono);
       DataObject2 dt=new DataObject2();
       boolean bn=dt.consignIssued(jb,ton); 
        ArrayList ar=(ArrayList)mm.fromNo();
        HashMap hm=new HashMap();
        hm.put("ename",ename);
        //hm.put("fromno",new Long(fromno).toString());
        //hm.put("tono",new Long(tono).toString());
        hm.put("arr",ar);
        request.setAttribute("hmap",hm);
       if(bn==true){
       request.setAttribute("msg","Data Submitted");
       }
       return mapping.findForward(SUCCESS);
    } 
      
         public ActionForward consignReport(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        PrintWriter out=response.getWriter();
        JavaBean jb=new JavaBean();
        String dt1="";
        String dt2="";
        String p=(String)request.getParameter("pr");
        DataObject2 dt=new DataObject2();
        HashMap hm=(HashMap)dt.consignData(p);
        request.setAttribute("hmap",hm);
        return mapping.findForward(SUCCESS);      
    }    
         
       public ActionForward allConsignReport(ActionMapping mapping,ActionForm form,
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
        HashMap hm=(HashMap)dt.allConsignData(p,dt1,dt2);
        hm.put("dated1",dt1);
        hm.put("dated2",dt2);
        request.setAttribute("hmap",hm);
        return mapping.findForward(SUCCESS);  
    } 
         
      public ActionForward issuedConsignReport(ActionMapping mapping,ActionForm form,
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
        HashMap hm=(HashMap)dt.issuedConsignData(p,dt1,dt2);
        hm.put("dated1",dt1);
        hm.put("dated2",dt2);
        request.setAttribute("hmap",hm);
        return mapping.findForward(SUCCESS);  
    }     
         
         public ActionForward subCompPayment(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
       PrintWriter out=response.getWriter();
       ArrayList ar=new ArrayList();   
       JavaBean2 jb=new JavaBean2();
       String dat1=request.getParameter("dated1");
       String dat2=request.getParameter("dated2");
       String dat=request.getParameter("dated");
       String cname=request.getParameter("compname");
       String amtdat=request.getParameter("paidtill");
       double topay=Double.parseDouble(request.getParameter("amttopay").toString());
       double btopay=Double.parseDouble(request.getParameter("baltopay").toString());
//     double tds=Double.parseDouble(request.getParameter("tds").toString());
       double amtpd=Double.parseDouble(request.getParameter("paidamt").toString());
       double baddb=Double.parseDouble(request.getParameter("baddebth").toString());
       double bal=Double.parseDouble(request.getParameter("balance").toString());
       String reason=request.getParameter("reason");        
       jb.setDated(dat);
       jb.setCompname(cname);
       jb.setAmtdat(amtdat);
       jb.setAmttopay(topay);
       jb.setBaltopay(btopay);
       jb.setAmtpaid(amtpd);
       jb.setBaddebth(baddb);
       jb.setBalance(bal);
       jb.setReason(reason);       
       DataObject2 dt=new DataObject2();    
       boolean bn=dt.paymentDetails(jb,dat1,dat2);
       if(bn==true){
       request.setAttribute("msg","Data Submitted");
       }
       return mapping.findForward(SUCCESS);
    }
         
       public ActionForward trackReport(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
       PrintWriter out=response.getWriter();       
       String cno=request.getParameter("cnno");  
       MyMethods mm=new MyMethods(); 
       DataObject2 dt=new DataObject2();
       JavaBean jb=(JavaBean)dt.trackData(cno);  
       JavaBean cb=(JavaBean)mm.compData(jb);      
       request.setAttribute("jbean",jb);
       request.setAttribute("cbean",cb);
       return mapping.findForward(SUCCESS);
    }  
     
       public ActionForward trackConsign(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
       PrintWriter out=response.getWriter();
       ArrayList ar=new ArrayList();          
       String cno=request.getParameter("cnno");
       DataObject2 dt=new DataObject2();
       ar=(ArrayList)dt.trackConsignNo(cno);    
       if(ar.size()>0){
       request.setAttribute("arr",ar);
       }
       else{
        request.setAttribute("msg","There is No Such Issued Consignment Number ("+cno+")");    
       }
       return mapping.findForward(SUCCESS);
    }  
       
           public ActionForward updateTax(ActionMapping mapping,ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
       PrintWriter out=response.getWriter();           
       double st=Double.parseDouble(request.getParameter("stax").toString());
       DataObject2 dt=new DataObject2();
       boolean bn=dt.upTax(st); 
       if(bn==true){
       request.setAttribute("msg","Updated");
       }
       return mapping.findForward(SUCCESS);
    }     
  
       public ActionForward addCompany(ActionMapping mapping,ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception{
       PrintWriter out=response.getWriter();  
       String result="";
       String custno=request.getParameter("cust_no");
       String cname=request.getParameter("compname");
       String cadd1=request.getParameter("compadd1");
       String city=request.getParameter("city");
       String state=request.getParameter("state");
       String country=request.getParameter("country");
       String zipcode=request.getParameter("zipcode");   
       String cphno1=request.getParameter("phno1");
       String cphno2=request.getParameter("phno2");
       String actype=request.getParameter("actype");
       JavaBean jb=new JavaBean();
       jb.setCustomerNo(custno);
       jb.setCompname(cname);
       jb.setCompadd(cadd1);
       jb.setCity(city);     
       jb.setState(state);
       jb.setCountry(country);
       jb.setZipcode(zipcode);
       jb.setPhno1(cphno1);
       jb.setPhno2(cphno2);   
       jb.setActype(actype);
       DataObject2 dt=new DataObject2();
       int in=dt.addComp(jb); 
       if(in==0){
       request.setAttribute("msg","Company Added");       
       }
       else{
       request.setAttribute("msg","Company or Customer No. Already Exists");        
       }
       return mapping.findForward(SUCCESS);
    }
       
      public ActionForward updateCompany(ActionMapping mapping,ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception{
         PrintWriter out=response.getWriter(); 
         String p="";
         p=(String)request.getParameter("pr");
         HashMap hm=new HashMap();
         boolean bn=false;
         DataObject2 dt=new DataObject2();        
         hm=(HashMap)dt.updateCompDetails(p); 
         request.setAttribute("hmap",hm);          
         return mapping.findForward(SUCCESS); 
    }   
      
        public ActionForward updateCompany2(ActionMapping mapping,ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception{
       PrintWriter out=response.getWriter();     
       String pr=(String)request.getParameter("para");
       DataObject2 dt=new DataObject2();
       JavaBean jb=(JavaBean)dt.updateCompDetails2(pr); 
       request.setAttribute("jbean",jb);
       return mapping.findForward(SUCCESS);
    }     
        public ActionForward deleteCompany(ActionMapping mapping,ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception{
       PrintWriter out=response.getWriter();           
       ArrayList ar=new ArrayList();
       String p="";
       HashMap hm=new HashMap();
       p=(String)request.getParameter("pr");
       String pr=(String)request.getParameter("para");
       DataObject2 dt=new DataObject2();
       boolean bn=dt.deleteCompDetails(pr); 
       hm=(HashMap)dt.updateCompDetails(p); 
       request.setAttribute("hmap",hm);
       if(bn==true){
       request.setAttribute("msg","Deleted");
       }
       return mapping.findForward(SUCCESS);
    } 
      
        public ActionForward updateCompany3(ActionMapping mapping,ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception{
       PrintWriter out=response.getWriter();       
       String id=request.getParameter("id");
       String custno=request.getParameter("cust_no");
       String cname=request.getParameter("compname");
       String cadd1=request.getParameter("compadd1");
       String city=request.getParameter("city");
       String state=request.getParameter("state");
       String country=request.getParameter("country");
       String zip=request.getParameter("zipcode");
       String cphno1=request.getParameter("phno1");
       String cphno2=request.getParameter("phno2");
       String actype=request.getParameter("actype");
       JavaBean jb=new JavaBean();
       jb.setId(id);
       jb.setCustomerNo(custno);
       jb.setCompname(cname);
       jb.setCompadd(cadd1);
       jb.setCity(city);
       jb.setState(state);
       jb.setCountry(country);
       jb.setZipcode(zip);
       jb.setPhno1(cphno1);
       jb.setPhno2(cphno2);
       jb.setActype(actype);
       DataObject2 dt=new DataObject2();
       boolean bn=dt.updateComp(jb); 
       JavaBean jb1=(JavaBean)dt.updateCompDetails2(id);       
       request.setAttribute("jbean",jb);
       HashMap hm=(HashMap)dt.updateCompDetails("1"); 
       request.setAttribute("hmap",hm); 
       if(bn==true){
       request.setAttribute("msg","Data Updated");
       }
       return mapping.findForward(SUCCESS);
    }      
              
       public ActionForward compPayDet1(ActionMapping mapping,ActionForm form,
       HttpServletRequest request, HttpServletResponse response)
       throws Exception{
       PrintWriter out=response.getWriter(); 
       ArrayList ar=new ArrayList();
       MyMethods mm=new MyMethods(); 
       String dt1=(String)request.getParameter("dated1");
       String dt2=(String)request.getParameter("dated2");
       String cname=(String)request.getParameter("compname"); 
       JavaBean jb1=new JavaBean();
       JavaBean jb=new JavaBean();
       jb.setCompname(cname);
       DataObject2 dt=new DataObject2();
       jb1=(JavaBean)dt.generateBill(jb,dt1,dt2);  
      // mm.generateExcelSheet(jb,dt1,dt2);
       request.setAttribute("dated1",dt1);
       request.setAttribute("dated2",dt2);
       request.setAttribute("arr",jb1);
       return mapping.findForward(SUCCESS);
    }  
       
       public ActionForward allPayDetailAct(ActionMapping mapping,ActionForm form,
       HttpServletRequest request, HttpServletResponse response)
       throws Exception{
       PrintWriter out=response.getWriter();  
       MyMethods mm=new MyMethods(); 
       String dt1=(String)request.getParameter("dated1");
       String dt2=(String)request.getParameter("dated2");
      // ArrayList ar=(ArrayList)mm.allSalesData(dt1,dt2);      
       request.setAttribute("dated1",dt1);
       request.setAttribute("dated2",dt2);
       //request.setAttribute("arr",ar);
       return mapping.findForward(SUCCESS);
    }  
       
         public ActionForward addZonesAct(ActionMapping mapping,ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception{
       PrintWriter out=response.getWriter();  
       String zone=request.getParameter("zone");
       JavaBean jb=new JavaBean();
       jb.setZone(zone);
       DataObject2 dt=new DataObject2();
       int in=dt.addZonesData(jb); 
       if(in==0){
       request.setAttribute("msg","Zone Added");       
       }
       else{
       request.setAttribute("msg","Zone Already Exists");        
       }
       return mapping.findForward(SUCCESS);
    }   
         
        public ActionForward dispZonesAct(ActionMapping mapping,ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception{
       PrintWriter out=response.getWriter();      
       DataObject2 dt=new DataObject2();
       ArrayList ar=(ArrayList)dt.dispZonesData(); 
       request.setAttribute("arr",ar);
       return mapping.findForward(SUCCESS);
      }  
        
         public ActionForward delZoneAct(ActionMapping mapping,ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception{
       PrintWriter out=response.getWriter();      
       DataObject2 dt=new DataObject2();
       String rid=request.getParameter("rid");
       int bn=dt.delZoneData(rid); 
       ArrayList ar=(ArrayList)dt.dispZonesData(); 
       request.setAttribute("arr",ar);
       if(bn==0){
       request.setAttribute("msg","Data Deleted");
       }else{
       request.setAttribute("msg","Database Error");    
       }
       return mapping.findForward(SUCCESS);
    }    
         
      public ActionForward addModeAct(ActionMapping mapping,ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception{
       PrintWriter out=response.getWriter();  
       String mod=request.getParameter("mode");
       JavaBean jb=new JavaBean();
       jb.setMode(mod);
       DataObject2 dt=new DataObject2();
       int in=dt.addModeData(jb); 
       if(in==0){
       request.setAttribute("msg","Mode Added");       
       }
       else{
       request.setAttribute("msg","Mode Already Exists");        
       }
       return mapping.findForward(SUCCESS);
    }      
      
         public ActionForward insertCourierId(ActionMapping mapping,ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception{
       PrintWriter out=response.getWriter();  
       String emp=request.getParameter("empname");
       String courierid=request.getParameter("courierid");
       JavaBean jb=new JavaBean();
       jb.setEmpname(emp);
       jb.setCourierId(courierid);
       DataObject2 dt=new DataObject2();
       int in=dt.courierIdData(jb); 
       if(in==0){
       request.setAttribute("msg","CourierId Added");       
       }
       else{
       request.setAttribute("msg","CourierId Already Exists");        
       }
       return mapping.findForward(SUCCESS);
    } 
        
}
