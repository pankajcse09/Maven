/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Transport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import java.util.*;
import java.io.*;

/**
 *
 * @author kapil
 */
public class Transport_Route extends DispatchAction {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";

    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction1, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     */
    
    public ActionForward trnsRt(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ArrayList al=new ArrayList();
        
        route_database rdb=new route_database();
        al=rdb.get_temp_route();
        request.setAttribute("rt_list",al);
        
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward adding_rt(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ArrayList al=new ArrayList();
        Rt_bean rtb=new Rt_bean();
        String rt="";
        String pl="";
        double fr=0.0;
        
        if(request.getParameter("route")!=null){
            rt=(String)request.getParameter("route");
        }
        if(request.getParameter("place")!=null){
         pl=(String)request.getParameter("place");   
        }
        try{
            if(request.getParameter("fare")!=null){
                fr=Double.parseDouble(request.getParameter("fare").toString());
            }
        }catch(NumberFormatException e){System.out.println(e);}
        
        rtb.setFare(fr);
        rtb.setRoute(rt);
        rtb.setPlace(pl);
        
        route_database rdb=new route_database();
        al=rdb.add_temp_route(rtb);
        request.setAttribute("rt_list",al);
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward add_rt(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ArrayList al=new ArrayList();
        
        route_database rdb=new route_database();
        rdb.add_into_route();
        request.setAttribute("added","Route details are added.");
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward editTrp(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ArrayList al=new ArrayList();
        int id=0;
        try{
            if(request.getParameter("id")!=null)
            {
                id=Integer.parseInt(request.getParameter("id").toString());
            }
        }catch(NumberFormatException e){System.out.println(e);}
        
        route_database rdb=new route_database();
        al=rdb.get_from_route();
        request.setAttribute("rt_list",al);
        request.setAttribute("id",id);
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward del_rt(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ArrayList al=new ArrayList();
        int id=0;
        try{
            if(request.getParameter("id")!=null)
            {
                id=Integer.parseInt(request.getParameter("id").toString());
            }
        }catch(NumberFormatException e){System.out.println(e);}
        
        route_database rdb=new route_database();
        al=rdb.del_route_byId(id);
        request.setAttribute("rt_list",al);
        return mapping.findForward(SUCCESS);
    }
    
    public ActionForward update_rt(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ArrayList al=new ArrayList();
        PrintWriter out=response.getWriter();
        Rt_bean rtb=new Rt_bean();
        String rt="";
        String pl="";
        double fr=0.0;
        int id=0;
        
        if(request.getParameter("route")!=null){
            rt=(String)request.getParameter("route");
        }
        if(request.getParameter("place")!=null){
         pl=(String)request.getParameter("place");   
        }
        try{
            if(request.getParameter("fare")!=null){
                fr=Double.parseDouble(request.getParameter("fare").toString());
            }
            if(request.getParameter("id")!=null)
            {
                id=Integer.parseInt(request.getParameter("id").toString());
            }
        }catch(NumberFormatException e){System.out.println(e);}
        out.println("id"+id);
        
        rtb.setFare(fr);
        rtb.setRoute(rt);
        rtb.setPlace(pl);
        rtb.setId(id);
        
        route_database rdb=new route_database();
        al=rdb.updating_rt(rtb);
         
        request.setAttribute("rt_list",al);
        request.setAttribute("msg","Data Successfuly Updated.");
        return mapping.findForward(SUCCESS);
        //return mapping.findForward("");
    }

    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction2, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     */
    
}
