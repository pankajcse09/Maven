/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main_category;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mc_operat.Mc_funct;

import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.upload.FormFile;

/**
 *
 * @author kapil
 */
public class Categories extends DispatchAction {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";

    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction1, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     */
    public ActionForward mainCategories(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         String mc="";
        if(request.getParameter("mc")!=null)
        {
            mc=(String)request.getParameter("mc");
        }
        
        
        Mc_funct mcfun=new  Mc_funct();
        ArrayList mclist=new ArrayList();
        
        mclist=mcfun.sel_main_cat();
        
        request.setAttribute("mc",mc);
        request.setAttribute("mclist",mclist);
        return mapping.findForward(SUCCESS);
    }

    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction2, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     */
public ActionForward categories(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrintWriter out=response.getWriter();
        ArrayList mclist=new ArrayList();
        ArrayList catlist=new ArrayList();
        ArrayList subcatlist=new ArrayList();
         Mc_funct mcfun=new  Mc_funct();
         String mc="";
        if(request.getParameter("mc")!=null)
        {
            mc=(String)request.getParameter("mc");
        }
        
        String cat="";
        String catname="";
        int cat_id=0;
        try{
        if(request.getParameter("cat")!=null&&!request.getParameter("cat").equals(""))
        {
            cat=(String)request.getParameter("cat");
        }
//        System.out.println(cat.substring(0,cat.indexOf('/')));
        catname=cat.substring(0,cat.indexOf('/'));
        cat_id=Integer.parseInt(cat.substring(cat.indexOf('/')+1));
        
        subcatlist=mcfun.sel_sub_cat(cat_id);
        }catch(Exception e)
        {
//            System.out.println("hello: "+e.getMessage());
        }
        
        mclist=mcfun.sel_main_cat();
        catlist=mcfun.sel_cat(mc);
//        System.out.println("Query: "+mc);
        request.setAttribute("mc",mc);
        request.setAttribute("cat",cat);
        request.setAttribute("catname",catname);
        request.setAttribute("mclist",mclist);
        request.setAttribute("catlist",catlist);
        request.setAttribute("subcatlist",subcatlist);
        
        return mapping.findForward(SUCCESS);
//        return mapping.findForward("");
    }
public ActionForward main_categories(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrintWriter out=response.getWriter();
        ArrayList mclist=new ArrayList();
        ArrayList catlist=new ArrayList();
        ArrayList subcatlist=new ArrayList();
         Mc_funct mcfun=new  Mc_funct();
         String mc="";
        if(request.getParameter("mc")!=null)
        {
            mc=(String)request.getParameter("mc");
        }
        
        String cat="";
        String catname="";
        int cat_id=0;
        try{
        if(request.getParameter("cat")!=null&&!request.getParameter("cat").equals(""))
        {
            cat=(String)request.getParameter("cat");
        }
//        System.out.println(cat.substring(0,cat.indexOf('/')));
        catname=cat.substring(0,cat.indexOf('/'));
        cat_id=Integer.parseInt(cat.substring(cat.indexOf('/')+1));
        
        subcatlist=mcfun.sel_sub_cat(cat_id);
        }catch(Exception e){
            //System.out.println("hello: "+e.getMessage());
        }
        
        mclist=mcfun.sel_main_cat();
        catlist=mcfun.sel_catByType(mc);
        
        request.setAttribute("mc",mc);
        request.setAttribute("cat",cat);
        request.setAttribute("catname",catname);
        request.setAttribute("mclist",mclist);
        request.setAttribute("catlist",catlist);
        request.setAttribute("subcatlist",subcatlist);
        
        return mapping.findForward(SUCCESS);
//        return mapping.findForward("");
    }

public ActionForward subcategories(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrintWriter out=response.getWriter();
        ArrayList mclist=new ArrayList();
        ArrayList catlist=new ArrayList();
        ArrayList subcatlist=new ArrayList();
         Mc_funct mcfun=new  Mc_funct();
         String mc="";
        if(request.getParameter("mc")!=null)
        {
            mc=(String)request.getParameter("mc");
        }
        
        String cat="";
        String catname="";
        int cat_id=0;
        try{
        if(request.getParameter("cat")!=null&&!request.getParameter("cat").equals(""))
        {
            cat=(String)request.getParameter("cat");
        }
//        out.println(cat.substring(0,cat.indexOf('/')));
        catname=cat.substring(0,cat.indexOf('/'));
        cat_id=Integer.parseInt(cat.substring(cat.indexOf('/')+1));
        
        subcatlist=mcfun.sel_sub_cat(cat_id);
        }catch(Exception e){System.out.println("hello: "+e.getMessage());}
//        System.out.println(getServlet().getServletContext().getRealPath("music_image/"));
        mclist=mcfun.sel_main_cat();
        catlist=mcfun.sel_cat(mc);
        
        request.setAttribute("mc",mc);
        request.setAttribute("cat",cat);
        request.setAttribute("catname",catname);
        request.setAttribute("mclist",mclist);
        request.setAttribute("catlist",catlist);
        request.setAttribute("subcatlist",subcatlist);
        
        return mapping.findForward(SUCCESS);
//        return mapping.findForward("");
    }
public ActionForward sub_categories(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrintWriter out=response.getWriter();
        ArrayList mclist=new ArrayList();
        ArrayList catlist=new ArrayList();
        ArrayList subcatlist=new ArrayList();
         Mc_funct mcfun=new  Mc_funct();
         String mc="";
        if(request.getParameter("mc")!=null)
        {
            mc=(String)request.getParameter("mc");
        }
        
        String cat="";
        String catname="";
        int cat_id=0;
        try{
        if(request.getParameter("cat")!=null&&!request.getParameter("cat").equals(""))
        {
            cat=(String)request.getParameter("cat");
        }
//        out.println(cat.substring(0,cat.indexOf('/')));
        catname=cat.substring(0,cat.indexOf('/'));
        cat_id=Integer.parseInt(cat.substring(cat.indexOf('/')+1));
        
        subcatlist=mcfun.sel_sub_cat(cat_id);
        }catch(Exception e){System.out.println("hello: "+e.getMessage());}
//        System.out.println(getServlet().getServletContext().getRealPath("music_image/"));
        mclist=mcfun.sel_main_cat();
        catlist=mcfun.sel_catByType(mc);
        
        request.setAttribute("mc",mc);
        request.setAttribute("cat",cat);
        request.setAttribute("catname",catname);
        request.setAttribute("mclist",mclist);
        request.setAttribute("catlist",catlist);
        request.setAttribute("subcatlist",subcatlist);
        
        return mapping.findForward(SUCCESS);
//        return mapping.findForward("");
    }

public ActionForward addAttribute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        PrintWriter out=response.getWriter();
        String mc=request.getParameter("mainCat");
     SimpleDateFormat sdf=new SimpleDateFormat("HHmmss");
     java.util.Date dt=new java.util.Date();
        Catitem_Actionform fd =(Catitem_Actionform)form;
        item_bean be=new item_bean();
         ArrayList myFiles =(ArrayList)fd.getUploads();
//        out.println("Array Size: "+myFiles.size());
         
         String filename="";
        String Samplefilename="";
        String title="";
        int subcat_id=0;
StringBuffer sb;
SecureRandom random = new SecureRandom();        
       FormFile myFile;
        File f;
   for(int j=0;j<myFiles.size();j++){ 
   if(myFiles.get(j)!=null){ 
      sb=new StringBuffer("");
       sb=sdf.format(dt, sb, new FieldPosition(sb.length()));
       sb=sb.append(new BigInteger(130, random).toString(32));
       
      myFile =(FormFile)myFiles.get(j) ; 
       String contentType = myFile.getContentType();
       try{
           filename    = myFile.getFileName();
     if(!filename.equals("")&&filename!=null){
        byte[] fileData    = myFile.getFileData();
        filename=sb.toString()+"_"+filename;
      sb=null;
        
           String dir=getServlet().getServletContext().getRealPath("music_image/"+filename);
           f = new File(dir);
        try{
        InputStream stream =myFile.getInputStream();
      OutputStream bos = new FileOutputStream(f);
       
        int bytesRead = 0;
byte[] buffer = new byte[5000 * 1024];
while ((bytesRead = stream.read(buffer, 0, buffer.length)) != -1) {
bos.write(buffer, 0, bytesRead);
bos.close();

stream.close();
}
        }catch(FileNotFoundException fnfe)
{
                out.println("Ex: "+fnfe.getMessage());  
                   myFile.destroy();
              }
     }
           }catch(Exception ee){}

        }
        }
    myFiles.clear();
    myFiles =(ArrayList)fd.getSamples();
    
 for(int j=0;j<myFiles.size();j++){ 
   if(myFiles.get(j)!=null){ 
      sb=new StringBuffer("");
       sb=sdf.format(dt, sb, new FieldPosition(sb.length()));
       sb=sb.append(new BigInteger(130, random).toString(32));
       
      myFile =(FormFile)myFiles.get(j) ; 
       String contentType = myFile.getContentType();
       try{
           Samplefilename= myFile.getFileName();
     if(!Samplefilename.equals("")&&Samplefilename!=null){
        byte[] fileData    = myFile.getFileData();
        
        
        try
        {
        title=Samplefilename.substring(0, Samplefilename.lastIndexOf('.'));
        }catch(Exception eee){}
        Samplefilename=sb.toString()+"_"+Samplefilename;
      sb=null;
           String dir=getServlet().getServletContext().getRealPath("audio_sample/"+Samplefilename);
           f = new File(dir);
        try{
        InputStream stream =myFile.getInputStream();
      OutputStream bos = new FileOutputStream(f);
       
        int bytesRead = 0;
byte[] buffer = new byte[5000 * 1024];
while ((bytesRead = stream.read(buffer, 0, buffer.length)) != -1) {
bos.write(buffer, 0, bytesRead);
bos.close();

stream.close();
}
        }catch(FileNotFoundException fnfe)
{
                out.println("Ex: "+fnfe.getMessage());  
                   myFile.destroy();
              }
       }
           }catch(Exception ee){}

        }
        }
 myFiles.clear();
 
        be.setBrand(fd.getBrand());
        be.setFilename(filename);
        be.setSampleTitle(title);
        be.setSampleFileName(Samplefilename);
        be.setPrice(fd.getPrice());
        be.setProd_id(fd.getProd_id());
        be.setSize(fd.getSize());
        be.setType("new");
        be.setStatus(fd.getStatus());
        be.setSubcat_id(fd.getSubcat_id());
        be.setMarketprice(fd.getMarketprice());
        be.setDiscount(fd.getDiscount());
        be.setDiscountdetail(fd.getDiscountdetail());
        be.setDetail(fd.getDetail());
        be.setUnit(fd.getUnit());
        be.setRelated_items(fd.getRelated_items());
//        out.println(fd.getSubcat_id());
        
        Mc_funct add_attr=new Mc_funct(); 
//       add_attr.add_newRelease(be);
        add_attr.add_attrib(be);
       
       ArrayList mclist=new ArrayList();
       ArrayList catlist=new ArrayList();
       mclist=add_attr.sel_main_cat();
       catlist=add_attr.sel_catByType(mc);
        request.setAttribute("catlist",catlist);
       request.setAttribute("mclist",mclist);
       request.setAttribute("mc",fd.getMainCat());
       request.setAttribute("catname",fd.getCatName());
        return mapping.findForward(SUCCESS);
//        return mapping.findForward("");
    }
    
}