/*
 * get_Gallery.java
 *
 * Created on June 21, 2010, 3:59 PM
 */

  package com.myapp.struts;

import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import moreimg.function_int_foodmart;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
/**
 *
 * @author arjun
 * @version
 */

public class get_Gallery extends Action {
    
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
    public ActionForward execute(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrintWriter out=response.getWriter();
       Im_Proj_DataUtility title_fetch=new Im_Proj_DataUtility();
           Im_Projects_DataHold imag=new Im_Projects_DataHold();
          String pagename="";              
          pagename=(String)request.getParameter("name");
          out.println(pagename);
          ArrayList  li_image= new ArrayList();
          li_image=(ArrayList)title_fetch.gal_view_Image(pagename);
          
           ArrayList homelist =new ArrayList();
          
          function_int_foodmart fd=new function_int_foodmart();
          homelist=(ArrayList)fd.select_content("aboutus");            
          request.setAttribute("homelist",homelist);          
          
          request.setAttribute("li_image",li_image);
          out.println(li_image);
          if(pagename.equals("media"))
          {
              
              return mapping.findForward("media");
          
          
          }
          if(pagename.equals("project"))
          {return mapping.findForward("project");}
           if(pagename.equals("Men_Gallery"))
          {return mapping.findForward("Men_Gallery");}
           if(pagename.equals("Women_Gallery"))
          {return mapping.findForward("Women_Gallery");}
          
         
          return mapping.findForward("");
         
        
    }
}
