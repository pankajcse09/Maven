/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package User_Role;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
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
public class UserRoleAction extends DispatchAction {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";

    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction1, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     */
    public ActionForward save_Rule(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         PrintWriter out=response.getWriter();
    
         
   String ur_read[]=new String[4];
   String ur_delete[]=new String[4];
   String ur_update[]=new String[4];
   String ur_create[]=new String[4];
   String ur_level[]=new String[4];
       
       
       ur_level[0]=request.getParameter("level1");
       ur_level[1]=request.getParameter("level2");
       ur_level[2]=request.getParameter("level3");
       ur_level[3]=request.getParameter("level4");
       
       ur_create[0]=request.getParameter("create1");
       ur_create[1]=request.getParameter("create2");
       ur_create[2]=request.getParameter("create3");
       ur_create[3]=request.getParameter("create4");
       
       
        ur_read[0]=request.getParameter("view1");
         ur_read[1]=request.getParameter("view2");
          ur_read[2]=request.getParameter("view3");
         ur_read[3]=request.getParameter("view4");
         
         
         ur_delete[0]=request.getParameter("delete1");         
          ur_delete[1]=request.getParameter("delete2");
         ur_delete[2]=request.getParameter("delete3");
         ur_delete[3]=request.getParameter("delete4");
        
         
           ur_update[0]=request.getParameter("update1");         
          ur_update[1]=request.getParameter("update2");
         ur_update[2]=request.getParameter("update3");
         ur_update[3]=request.getParameter("update4");
        
         
        HashMap role=new HashMap();       
        List list=new ArrayList();
          User_role_bean user_rolen=new User_role_bean();
          
      for(int i=0;i<4;i++){
            User_role_bean user_role=new User_role_bean();
            user_role.setUr_level(ur_level[i]);
            user_role.setUr_create(ur_create[i]);
            user_role.setUr_delete(ur_delete[i]);
            user_role.setUr_update(ur_update[i]);
            user_role.setUr_read(ur_read[i]);          
            role.put("ur_level"+i,user_role);
            list.add("ur_level"+i);
      }
                int cnt=0;          
     
       
         List design_list=new ArrayList();
       UserRoleDB fun=new UserRoleDB();
     cnt=fun.checkRoleTable();
     if(cnt==0){
       fun.save_Rules(list,role);
       request.setAttribute("msg","User roles created successfully!") ;
     }
    else{
     request.setAttribute("msg","User roles already created. You can view or updated now") ;
    }
   return mapping.findForward(SUCCESS);
}
        

public ActionForward view_Role(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         PrintWriter out=response.getWriter();      
       User_role_bean rolebean=new User_role_bean();       
        HashMap role=new HashMap();       
        List rolelist=new ArrayList();                          
       UserRoleDB fun=new UserRoleDB();   
       rolelist=(List)fun.getRole();
        request.setAttribute("rolelist",rolelist) ;
  
          //  return mapping.findForward("");
      return mapping.findForward(SUCCESS);
        }
       
        public ActionForward update_role(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         PrintWriter out=response.getWriter();      
       User_role_bean rolebean=new User_role_bean();       
        HashMap role=new HashMap();       
        List rolelist=new ArrayList();                          
       UserRoleDB fun=new UserRoleDB();    
       rolelist=(List)fun.getRole();
        request.setAttribute("rolelist",rolelist) ;
  
          //  return mapping.findForward("");
      return mapping.findForward(SUCCESS);
        }

public ActionForward update_User_Roles_Save(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         PrintWriter out=response.getWriter();      
       
        HashMap role=new HashMap();       
        List rolelist=new ArrayList();   
        ArrayList  lengthlist=new ArrayList();    
        List  idlist=new ArrayList();   
        Enumeration en=(Enumeration)request.getParameterNames();     
        ArrayList cart_list=new ArrayList();
        while(en.hasMoreElements()){
         String pname=(String)en.nextElement();
         if(pname.substring(0,2).equals("id")){
        lengthlist.add(pname);
         }
        }
        for(int i=0;i<lengthlist.size();i++){
         User_role_bean rolebean=new User_role_bean();       
       if(request.getParameter("id"+i)!=null || !request.getParameter("id"+i).equals("")){
                String roleid=(String)request.getParameter("id"+i);
       idlist.add(request.getParameter("id"+i));    
       rolebean.setUr_create((String)request.getParameter("create"+i));
       rolebean.setUr_delete((String)request.getParameter("delete"+i));
     
       rolebean.setUr_read((String)request.getParameter("view"+i));
       rolebean.setUr_update((String)request.getParameter("update"+i));
       rolebean.setId(Integer.parseInt((String)(request.getParameter("id"+i))));    

            role.put(roleid,rolebean) ;
        }
      }
    UserRoleDB fun=new UserRoleDB();    
     fun.update_Role_Save(idlist,role);
   rolelist=(List)fun.getRole();
        request.setAttribute("rolelist",rolelist) ;
        request.setAttribute("msg","User roles are updated successfully!") ;
//         return mapping.findForward("");
      return mapping.findForward(SUCCESS);
        }
       
}
