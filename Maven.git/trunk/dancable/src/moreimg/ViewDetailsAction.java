/*
 * ViewDetailsAction.java
 *
 * Created on June 2, 2010, 5:59 PM
 */

package moreimg;

import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.actions.DispatchAction;
/**
 *
 * @author arjun
 * @version
 */

public class ViewDetailsAction extends DispatchAction {
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    
    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    
     public ActionForward Search_item(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ArrayList contentlist=new ArrayList();
        PrintWriter out=response.getWriter();  
         ArrayList homelist =new ArrayList();
        ArrayList qualitylist=new ArrayList();
        ArrayList discountlist=new ArrayList();
        ArrayList searchlist=new ArrayList();
        function_int_foodmart fd=new function_int_foodmart();
        homelist=(ArrayList)fd.select_content("home");
       qualitylist=(ArrayList)fd.select_quality("quality");
        discountlist=(ArrayList)fd.select_discount_item();
        
        img_bean be=new img_bean();
        int id=0;
        String search="";
        try {
            
            id=Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();           
            
        }
        search=request.getParameter("search");
        function_int_foodmart fc=new function_int_foodmart();
       searchlist=(ArrayList)fc.search_item(search,id);
      // contentlist=(ArrayList)fc.select_content_detail(id);
       
     //  request.setAttribute("contentlist",contentlist);
        
        
          request.setAttribute("homelist",homelist);
        request.setAttribute("qualitylist",qualitylist);
       request.setAttribute("discountlist",discountlist);
       request.setAttribute("searchlist",searchlist);
        return mapping.findForward(SUCCESS);
        
    }
     
     public ActionForward Content_Detail_Data(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ArrayList contentlist=new ArrayList();
        PrintWriter out=response.getWriter();  
        img_bean be=new img_bean();
        int id=0;
        try {
            
            id=Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();           
            
        }
        
        function_int_foodmart fc=new function_int_foodmart();
        
       contentlist=(ArrayList)fc.select_content_detail(id);
       
       request.setAttribute("contentlist",contentlist);
        
        
        
        return mapping.findForward(SUCCESS);
        
    }
    
    
    
    public ActionForward Content_More_Data(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ArrayList contentlist=new ArrayList();
        PrintWriter out=response.getWriter();  
        img_bean be=new img_bean();
        int id=0;
        try {
            
            id=Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();           
            
        }      
        
        function_int_foodmart fc=new function_int_foodmart();        
       contentlist=(ArrayList)fc.select_content_detail(id);       
       request.setAttribute("contentlist",contentlist);
        
       request.setAttribute("contentid",new Integer(id).toString());
     
        
        return mapping.findForward(SUCCESS);
        
    }
    
    
    
    
      public ActionForward update_last_content(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
          String home="home";
             
        ArrayList homelist =new ArrayList();
        ArrayList qualitylist=new ArrayList();
        ArrayList discountlist=new ArrayList();
        ArrayList contentlist=new ArrayList();
        PrintWriter out=response.getWriter();  
        img_bean be=new img_bean();
        int id=0;
        String pagename="";
        String desc="";
        try {
            
            id=Integer.parseInt(request.getParameter("headid"));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();           
            
        }
      desc=(String)request.getParameter("desc");
        pagename=(String)request.getParameter("pagename");   
        
        be.setHead_id(id);
        be.setDesc(desc);
        be.setPage_name(pagename);
        function_int_foodmart fc=new function_int_foodmart();
        
        fc.update_last_content(be);    
     
        homelist=(ArrayList)fc.select_content(pagename);
       
        
        request.setAttribute("homelist",homelist);
       
       if(pagename.equals("home")){
        return mapping.findForward(home);
       }
       if(pagename.equals("quality")){
        return mapping.findForward(home);
       }
       
        return mapping.findForward(SUCCESS);
        
    }
      
      
      
      
       public ActionForward update_descdetail_content(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
          String home="home";
             
        ArrayList homelist =new ArrayList();
        ArrayList qualitylist=new ArrayList();
        ArrayList discountlist=new ArrayList();
        ArrayList contentlist=new ArrayList();
        PrintWriter out=response.getWriter();  
        img_bean be=new img_bean();
        int id=0;
        String pagename="";
        String desc="";
        try {
            
            id=Integer.parseInt(request.getParameter("headid"));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();           
            
        }
      desc=(String)request.getParameter("desc");
        pagename=(String)request.getParameter("pagename");   
        
        be.setHead_id(id);
        be.setDesc(desc);
        be.setPage_name(pagename);
        function_int_foodmart fc=new function_int_foodmart();
        
        fc.update_descdetail_content(be);    
     
        homelist=(ArrayList)fc.select_content(pagename);
       
        
        request.setAttribute("homelist",homelist);
       
       if(pagename.equals("home")){
        return mapping.findForward(home);
       }
       if(pagename.equals("quality")){
        return mapping.findForward(home);
       }
       
        return mapping.findForward(SUCCESS);
        
    }
      
      
      
      
     public ActionForward Edit_Head_Content(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ArrayList contentlist=new ArrayList();
        PrintWriter out=response.getWriter();  
        img_bean be=new img_bean();
        int id=0;
        try {
            
            id=Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();           
            
        }
        out.println(id);
        function_int_foodmart fc=new function_int_foodmart();
        
   be=(img_bean)fc.select_head_detail(id);
       
       request.setAttribute("contentlist",be);
        
        out.println("contentlist"+be);
        
        return mapping.findForward(SUCCESS);
        
    }
    
    
     public ActionForward Edit_Desc_Content(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ArrayList contentlist=new ArrayList();
        PrintWriter out=response.getWriter();  
        img_bean be=new img_bean();
        int id=0;
        try {
            
            id=Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();           
            
        }
        
        function_int_foodmart fc=new function_int_foodmart();
        
      be=(img_bean)fc.select_desc_detail(id);
       
       request.setAttribute("contentlist",be);        
        return mapping.findForward("desc");
        
    }
    
         public ActionForward Edit_HeadDetail_Content(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ArrayList contentlist=new ArrayList();
        PrintWriter out=response.getWriter();  
        img_bean be=new img_bean();
        int id=0;
        try {
            
            id=Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();           
            
        }
        out.println(id);
        function_int_foodmart fc=new function_int_foodmart();
        
   be=(img_bean)fc.select_head_more(id);
       
       request.setAttribute("contentlist",be);
        
        out.println("contentlist"+be);
        
        return mapping.findForward(SUCCESS);
        
    }
  
    
   
           public ActionForward Edit_DescDetail_Content(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ArrayList contentlist=new ArrayList();
        PrintWriter out=response.getWriter();  
        img_bean be=new img_bean();
        int id=0;
        try {
            
            id=Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();           
            
        }
        
        function_int_foodmart fc=new function_int_foodmart();
        
      be=(img_bean)fc.select_desc_more(id);
       
       request.setAttribute("contentlist",be);        
        return mapping.findForward(SUCCESS);
        
    }
     
         
       public ActionForward update_content(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
          String home="home";
            String aboutus="aboutus";
           String organizedby="organizedby";
            
        ArrayList homelist =new ArrayList();
        ArrayList qualitylist=new ArrayList();
        ArrayList discountlist=new ArrayList();
        ArrayList contentlist=new ArrayList();
        PrintWriter out=response.getWriter();  
        img_bean be=new img_bean();
        int id=0;
        String pagename="";
        String head="";
        try {
            
            id=Integer.parseInt(request.getParameter("headid"));
            out.println("headid"+id);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();           
            
        }
        head=(String)request.getParameter("head");
        pagename=(String)request.getParameter("pagename");   
        
        be.setHead_id(id);
        be.setHead(head);
        be.setPage_name(pagename);
        
        function_int_foodmart fc=new function_int_foodmart();        
        fc.update_head_content(be);    
     
     homelist=(ArrayList)fc.select_content_edit("home");
        qualitylist=(ArrayList)fc.select_quality_edit("quality");
          discountlist=(ArrayList)fc.select_discount_item();
       // out.println(homelist);
        
        request.setAttribute("homelist",homelist);
        request.setAttribute("qualitylist",qualitylist);
       request.setAttribute("discountlist",discountlist);
       if(pagename.equals("home")){
     return mapping.findForward(home);
       //  return mapping.findForward("");
       }
       
        if(pagename.equals("quality")){
       return mapping.findForward(home);
      //  return mapping.findForward("");
       }
       
        if(pagename.equals("aboutus")){
        return mapping.findForward(aboutus);
       }
        if(pagename.equals("organizedby")){
        return mapping.findForward(organizedby);
       }
        return mapping.findForward(SUCCESS);
        
    }
    
    
       public ActionForward update_desc_content(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
          String home="home";
             
        ArrayList homelist =new ArrayList();
        ArrayList qualitylist=new ArrayList();
        ArrayList discountlist=new ArrayList();
        ArrayList contentlist=new ArrayList();
        PrintWriter out=response.getWriter();  
        img_bean be=new img_bean();
        int id=0;
        String pagename="";
        String desc="";
        try {
            
            id=Integer.parseInt(request.getParameter("headid"));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();           
            
        }
      desc=(String)request.getParameter("desc");
        pagename=(String)request.getParameter("pagename");   
        
        be.setHead_id(id);
        be.setDesc(desc);
        be.setPage_name(pagename);
        function_int_foodmart fc=new function_int_foodmart();
        
        fc.update_desc_content(be);    
     
        homelist=(ArrayList)fc.select_content("home");
        qualitylist=(ArrayList)fc.select_quality("quality");
               discountlist=(ArrayList)fc.select_discount_item();
       // out.println(homelist);
        
        request.setAttribute("homelist",homelist);
        request.setAttribute("qualitylist",qualitylist);
       request.setAttribute("discountlist",discountlist);
       if(pagename.equals("home")){
        return mapping.findForward(home);
       }
       if(pagename.equals("quality")){
        return mapping.findForward(home);
       }
       
        return mapping.findForward(SUCCESS);
        
    }
    
   public ActionForward update_head_more(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
          String home="home";
            String aboutus="aboutus";
           String organizedby="organizedby";
            
        ArrayList homelist =new ArrayList();
        ArrayList qualitylist=new ArrayList();
        ArrayList discountlist=new ArrayList();
        ArrayList contentlist=new ArrayList();
        PrintWriter out=response.getWriter();  
        img_bean be=new img_bean();
        int id=0;
        String pagename="";
        String head="";
        try {
            
            id=Integer.parseInt(request.getParameter("headid"));
            out.println("headid"+id);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();           
            
        }
        head=(String)request.getParameter("head");
        pagename=(String)request.getParameter("pagename");   
        
        be.setHead_id(id);
        be.setHead(head);
        be.setPage_name(pagename);
        
        function_int_foodmart fc=new function_int_foodmart();        
        fc.update_head_more(be);    
     
     homelist=(ArrayList)fc.select_content_edit("home");
        qualitylist=(ArrayList)fc.select_quality_edit("quality");
          discountlist=(ArrayList)fc.select_discount_item();
       // out.println(homelist);
        
        request.setAttribute("homelist",homelist);
        request.setAttribute("qualitylist",qualitylist);
       request.setAttribute("discountlist",discountlist);
       if(pagename.equals("home")){
     return mapping.findForward(home);
       //  return mapping.findForward("");
       }
       
        if(pagename.equals("quality")){
       return mapping.findForward(home);
      //  return mapping.findForward("");
       }
       
        if(pagename.equals("aboutus")){
        return mapping.findForward(aboutus);
       }
        if(pagename.equals("organizedby")){
        return mapping.findForward(organizedby);
       }
        return mapping.findForward(SUCCESS);
        
    }
    
      public ActionForward update_desc_more(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
          String home="home";
             
        ArrayList homelist =new ArrayList();
        ArrayList qualitylist=new ArrayList();
        ArrayList discountlist=new ArrayList();
        ArrayList contentlist=new ArrayList();
        PrintWriter out=response.getWriter();  
        img_bean be=new img_bean();
        int id=0;
        String pagename="";
        String desc="";
        try {
            
            id=Integer.parseInt(request.getParameter("headid"));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();           
            
        }
      desc=(String)request.getParameter("desc");
        pagename=(String)request.getParameter("pagename");   
        
        be.setHead_id(id);
        be.setDesc(desc);
        be.setPage_name(pagename);
        function_int_foodmart fc=new function_int_foodmart();
        
        fc.update_desc_more(be);    
     
        homelist=(ArrayList)fc.select_content("home");
        qualitylist=(ArrayList)fc.select_quality("quality");
               discountlist=(ArrayList)fc.select_discount_item();
       // out.println(homelist);
        
        request.setAttribute("homelist",homelist);
        request.setAttribute("qualitylist",qualitylist);
       request.setAttribute("discountlist",discountlist);
       if(pagename.equals("home")){
        return mapping.findForward(home);
       }
       if(pagename.equals("quality")){
        return mapping.findForward(home);
       }
       
        return mapping.findForward(SUCCESS);
        
    }
      
      
      
}
