/*
 * Degree.java
 *
 * Created on February 28, 2013, 2:59 PM
 */

package com.myapp.struts;

 import ActionClass.DataObj;
import ActionClass.MyMeth;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.actions.DispatchAction;
import pant.common.UtilityDB;
/**
 *
 * @author user
 * @version
 */

public class Degree extends DispatchAction {

    
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
    public ActionForward Branchpage(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        UtilityDB udb=new UtilityDB();
         ArrayList DegreeList=new ArrayList();
         JavaBean jb=new JavaBean();   
         MyMeth fun=new MyMeth();
         DegreeList=(ArrayList)fun.Degree_list();
        ArrayList list=udb.collegeList();
        request.setAttribute("list", list);
         request.setAttribute("degreelist",DegreeList);  
            
        return mapping.findForward(SUCCESS);
        
    }
    
    public ActionForward addDegree(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        UtilityDB udb=new UtilityDB();
         ArrayList DegreeList=new ArrayList();
         JavaBean jb=new JavaBean();   
         MyMeth fun=new MyMeth();
         String degree="";
         String degcode="";
         String college_code=request.getParameter("college");
         if(request.getParameter("degree")!=null)
         {
             degree=(String)request.getParameter("degree");
         }
         if(request.getParameter("degcode")!=null)
         {
             degcode=(String)request.getParameter("degcode");
         }
         String self=request.getParameter("self");
         int cn=fun.chkDegree(degree, degcode);
         if(cn==0){
            fun.Add_Degree(degree,degcode,self,college_code);
         }
         else{
             request.setAttribute("msg","Degree "+degree+" or code "+degcode+" is already present.");  
         }
         DegreeList=(ArrayList)fun.Degree_list();
        ArrayList list=udb.collegeList();
        request.setAttribute("list", list);
         request.setAttribute("degreelist",DegreeList);  
            
        return mapping.findForward(SUCCESS);
        
    }
    
   public ActionForward deldegree(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
         ArrayList DegreeList=new ArrayList();
         JavaBean jb=new JavaBean();   
         MyMeth fun=new MyMeth();
         int id=0;
         if(request.getParameter("id")!=null)
         {
             try{
             id=Integer.parseInt(request.getParameter("id").toString());
             }catch(NumberFormatException e){e.getMessage();}
         }
         
         DegreeList=(ArrayList)fun.del_Degree(id);
         
         //DegreeList=(ArrayList)fun.Degree_list();
        
         request.setAttribute("degreelist",DegreeList);  
            
        return mapping.findForward(SUCCESS);
        
    }  
    
}
