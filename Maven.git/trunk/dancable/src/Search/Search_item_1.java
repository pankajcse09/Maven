/*
 * Search_item_1.java
 *
 * Created on January 1, 2012, 3:24 PM
 */

package Search;

import com.myapp.struts.Im_Proj_DataUtility;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import org.apache.commons.beanutils.BeanUtils;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.actions.DispatchAction;
/**
 *
 * @author user
 * @version
 */

public class Search_item_1 extends DispatchAction {
    
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
    public ActionForward Searchitem(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
       throws Exception {
        
        PrintWriter out=response.getWriter();
        //SearchActionForm afb=(SearchActionForm)form;
                Search_bean  bea=new Search_bean();
                Search_bean  dbea=new Search_bean();
                 Search_bean  subbea=new Search_bean();
                  Search_bean  itbea=new Search_bean();
                Search_bean  catbea=new Search_bean();
                Search_bean  subcatbea=new Search_bean();
        	 // BeanUtils.copyProperties(bea,afb);
                
	String recName=(String)request.getParameter("itemsrch");
	bea.setName(recName);
        //out.println(bea.getName());
        //String recname=(String)request.getParameter("name");
	//dbea.setName(recname);
       // ArrayList itemSear=new ArrayList();
       // itemSear.add(dbea);

        String code="";
        String name="";
        
        
        
        
      //  out.println(code);
        Im_Proj_DataUtility im=new Im_Proj_DataUtility();
        int id=0;
        ArrayList catidlist=new ArrayList();
        ArrayList subcatidlist=new ArrayList();
       
         ArrayList itemlist=new ArrayList();
           name=bea.getName();
       // out.println("hi"+name);
            code=bea.getName().trim();
            bea=(Search_bean)im.Searchitem_id(name);
         itemlist.add(bea);
         out.println(itemlist.size());
        itemlist=(ArrayList)im.Searchitem_Code(bea.getId());
       out.println(bea.getId());
        out.println(itemlist.size());
       
           
           
           
         if(itemlist.isEmpty())
        {
               Search_bean sb=new Search_bean();
            code=bea.getName();
            ArrayList ab=new ArrayList();
            ArrayList aba=new ArrayList();
           aba=(ArrayList)im.itemlist(name);
           
           //out.println(itemlist.size());
       
           ab=(ArrayList)im.moreitemlist(name);
             for(int k=0;k<ab.size();k++){
             sb=(Search_bean)ab.get(k);
             aba.add(sb);
             }
         
           itemlist=aba;
           
           }
        
      if(!itemlist.isEmpty()){
         request.setAttribute("itemlist",itemlist);
         //request.setAttribute("name", itemSear);
         request.setAttribute("recName", recName);
      }else{
      request.setAttribute("sear","No Records Found! Enter a new search word.");
      //request.setAttribute("itemSear", itemSear);
      request.setAttribute("recName", recName);
      }
       
         //return mapping.findForward("");
     return mapping.findForward(SUCCESS);
         
    }
    
    public ActionForward  Vlc(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
       throws Exception {
        
        
         //SearchActionForm afb=(SearchActionForm)form;
                Search_bean  bea=new Search_bean();
                 Search_bean  subbea=new Search_bean();
                  Search_bean  itbea=new Search_bean();
                Search_bean  catbea=new Search_bean();
                Search_bean  subcatbea=new Search_bean();
       // BeanUtils.copyProperties(bea,afb);
        String code="";
        String name="";
        
        
        
        PrintWriter out=response.getWriter();
      //  out.println(code);
        Im_Proj_DataUtility im=new Im_Proj_DataUtility();
        int id=0;
        ArrayList catidlist=new ArrayList();
        ArrayList subcatidlist=new ArrayList();
       
         ArrayList itemlist=new ArrayList();
           name=bea.getName();
         out.println(name);
         
        
            code=bea.getName().trim();
            bea=(Search_bean)im.Searchitem_id(code);
         itemlist.add(bea);
       itemlist=(ArrayList)im.Searchitem_Code(bea.getId());
       // out.println("arjun");
        
        
           if(!itemlist.isEmpty())        
         
        {
               Search_bean sb=new Search_bean();
            code=bea.getName();
            ArrayList ab=new ArrayList();
            ArrayList aba=new ArrayList();
           aba=(ArrayList)im.itemlist(code);
           
         //  out.println(itemlist.size());
       
           ab=(ArrayList)im.moreitemlist(code);
             for(int k=0;k<ab.size();k++){
             sb=(Search_bean)ab.get(k);
             aba.add(sb);
             }
         
           itemlist=aba;
           }
        
       
         request.setAttribute("itemlist",itemlist);
        return mapping.findForward("");
     //return mapping.findForward(SUCCESS);
         
    }

}
    