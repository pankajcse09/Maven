/*
 * Delete.java
 *
 * Created on January 12, 2011, 10:49 PM
 */

   package com.myapp.struts;


 import Delete_content.Delete_Function;
import java.io.File;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import moreimg.function_int_foodmart;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.actions.DispatchAction;
import streams.ToDBFile;

/**
 *
 * @author intelmind
 * @version
 */

 public class Delete extends DispatchAction {
    
    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    
  
    public ActionForward DeleteContent(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         String id=(String)request.getParameter("id");
         String page_name=(String)request.getParameter("pagename");
         ArrayList homelist=new ArrayList();
         boolean tr=false;
         Delete_Function df=new Delete_Function();
          tr= df.del_content(Integer.parseInt(id));
           function_int_foodmart fd=new function_int_foodmart(); 
          homelist=(ArrayList)fd.select_content(page_name);  
           request.setAttribute("homelist",homelist);
          request.setAttribute("pagename",page_name);
        
        
        return mapping.findForward(SUCCESS);
        
    }
    
    
    
     public ActionForward DeleteContent_ReadMore(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
           int id=0;
        try {
            
            id=Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();           
            
        }     
          int contentid=0;
        try {
            
           contentid=Integer.parseInt(request.getParameter("contentid"));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();           
            
        }     
         ArrayList contentlist=new ArrayList();
         boolean tr=false;
         Delete_Function df=new Delete_Function();
         tr=df.del_Read_More(id);       
     function_int_foodmart fc=new function_int_foodmart();        
       contentlist=(ArrayList)fc.select_content_detail(contentid);       
       request.setAttribute("contentlist",contentlist);
         
          if(tr==true)
          {
           return mapping.findForward(SUCCESS);
          }
        
        return mapping.findForward(SUCCESS);
        
    }
    
public ActionForward delMore_itemimage(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         String id=(String)request.getParameter("id");
         int galid=0;
        int scid=0;
        try {
            
            galid=Integer.parseInt((String)request.getParameter("galid"));
            scid=Integer.parseInt((String)request.getParameter("scid"));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
         ArrayList images=new ArrayList();
         boolean tr=false;
         Delete_Function df=new Delete_Function();
         Im_Proj_DataUtility im=new Im_Proj_DataUtility();
         ToDBFile tdb=new ToDBFile();
         String filename=tdb.retMoreImagefilename(Integer.parseInt(id));
         try{
         File f=new File(getServlet().getServletContext().getRealPath("/moremusic_images/"+filename));
         f.delete();
         }catch(Exception ee){
             request.setAttribute("msg","There is some error occured in deleting file.");
         images=(ArrayList)im.gal_ItemImage(galid,scid);
         request.setAttribute("images",images);
         return mapping.findForward(SUCCESS);
         }
          tr= df.del_moreImg(Integer.parseInt(id));
           
        images=(ArrayList)im.gal_ItemImage(galid,scid);
        
        request.setAttribute("msg","file deleted.");
        request.setAttribute("images",images);
        return mapping.findForward(SUCCESS);
        
    }    
    
    
 public ActionForward delMore_itemsample(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         String id=(String)request.getParameter("id");
         int galid=0;
        try {
            
            galid=Integer.parseInt((String)request.getParameter("galid"));
         } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
         ArrayList audios=new ArrayList();
         boolean tr=false;
         Delete_Function df=new Delete_Function();
         ToDBFile tdb=new ToDBFile();
         String filename=tdb.retMoreAudiofilename(Integer.parseInt(id));
         try{
         File f=new File(getServlet().getServletContext().getRealPath("/moremusic_samples/"+filename));
         f.delete();
         }catch(Exception ee){
             request.setAttribute("msg","There is some error occured in deleting audio file.");
         audios=(ArrayList)tdb.gal_ItemAudioSapmle(galid);
         request.setAttribute("audios",audios);
         return mapping.findForward(SUCCESS);
         }
          tr= df.del_moreSample(Integer.parseInt(id));
           
        audios=(ArrayList)tdb.gal_ItemAudioSapmle(galid);
        
        request.setAttribute("msg","Audio file deleted.");
        request.setAttribute("audios",audios);
        return mapping.findForward(SUCCESS);
        
    }    

public ActionForward removeEvd_audio(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
            int strmAt=Integer.parseInt(request.getParameter("v").toString());
            String strmAtDate="";
            if(request.getParameter("strmAtDate")!=null)
            {
                strmAtDate=(String)request.getParameter("strmAtDate");
            }
            Delete_Function df=new Delete_Function();
            ToDBFile tdb=new ToDBFile();
            ArrayList strmlistAtDate=new ArrayList();
            
            String filename=tdb.retEvdAudiofilename(strmAt);
    try{
         File f=new File(getServlet().getServletContext().getRealPath("/everyday_stream/"+filename));
         f.delete();
         }catch(Exception ee){
             request.setAttribute("msg","There is some error occured in deleting audio file.");
                if(!strmAtDate.equals(""))
                    {
                        strmlistAtDate=tdb.gat_everyDayAudioOnDate(strmAtDate, "evdstrm");
                        request.setAttribute("listAtDate",strmlistAtDate);
                    }
                request.setAttribute("strmAtDate",strmAtDate);
                return mapping.findForward(SUCCESS);
         }
    
    boolean tr=false;
    tr= df.del_EvdAudio(strmAt);
    if(!strmAtDate.equals(""))
       {
             strmlistAtDate=tdb.gat_everyDayAudioOnDate(strmAtDate, "evdstrm");
                request.setAttribute("listAtDate",strmlistAtDate);
      }
    request.setAttribute("strmAtDate",strmAtDate);
    return mapping.findForward(SUCCESS);
 }       
    
public ActionForward delDwn_itemFile(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    String tp="";
            if(request.getParameter("tp")!=null)
            {
                tp=(String)request.getParameter("tp");
            }
         String id=(String)request.getParameter("id");
         int galid=0;
        try {
            
            galid=Integer.parseInt((String)request.getParameter("galid"));
         } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
         ArrayList audios=new ArrayList();
         ArrayList filelist=null;
         boolean tr=false;
         Delete_Function df=new Delete_Function();
         ToDBFile tdb=new ToDBFile();
         String filename=tdb.retDwnAudiofilename(Long.parseLong(id));
//         System.out.println("Kapil: "+filename);
         try{
         File f=new File(getServlet().getServletContext().getRealPath("/downloadaudio/"+filename));
//         System.out.println("saini: "+f.getAbsolutePath());
         f.delete();
         }catch(Exception ee){
             request.setAttribute("msg","There is some error occured in deleting audio file.");
         audios=(ArrayList)tdb.get_ItemAudioFileToDownload(galid);
         filelist=audios;
         request.setAttribute("audios",audios);
         request.setAttribute("tp",tp);
            request.setAttribute("filelist",filelist);
         return mapping.findForward(SUCCESS);
         }
         
         String tablename="audiofordwnd";
          tr= df.del_File(Long.parseLong(id),tablename);
           
        audios=(ArrayList)tdb.get_ItemAudioFileToDownload(galid);
        filelist=audios;
        request.setAttribute("tp",tp);
            request.setAttribute("filelist",filelist);
        request.setAttribute("msg","file deleted.");
        request.setAttribute("audios",audios);
        return mapping.findForward(SUCCESS);
        
    }    
public ActionForward delWrtn_itemsample(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
            String tp="";
            if(request.getParameter("tp")!=null)
            {
                tp=(String)request.getParameter("tp");
            }
         String id=(String)request.getParameter("id");
         int galid=0;
        try {
            
            galid=Integer.parseInt((String)request.getParameter("galid"));
         } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
         
         ArrayList filelist=new ArrayList();
         boolean tr=false;
         Delete_Function df=new Delete_Function();
         ToDBFile tdb=new ToDBFile();
         String filename=tdb.retWrtnSamplefilename(Long.parseLong(id));
         
         try{
         File f=new File(getServlet().getServletContext().getRealPath("/moremusic_samples/"+filename));
         f.delete();
         }catch(Exception ee){
             request.setAttribute("msg","There is some error occured in deleting audio file.");
          
             filelist=(ArrayList)tdb.get_ItemWrtnSapmle(galid);
            request.setAttribute("tp",tp);
            request.setAttribute("filelist",filelist);
            
           return mapping.findForward(SUCCESS);
         }
          String tablename="written_sample";
         tr= df.del_File(Long.parseLong(id),tablename);
         filelist=(ArrayList)tdb.get_ItemWrtnSapmle(galid);
            request.setAttribute("tp",tp);
            request.setAttribute("filelist",filelist);
        
        request.setAttribute("msg","file deleted.");
        return mapping.findForward(SUCCESS);
        
    }    
    
public ActionForward delcontentFile(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    String filename=(String)request.getParameter("fl");
            
         String id=(String)request.getParameter("id");
         int galid=0;
        try {
            
            galid=Integer.parseInt(id);
         } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
         ArrayList filelist=new ArrayList();
         
         boolean tr=false;
         Delete_Function df=new Delete_Function();
         ToDBFile tdb=new ToDBFile();
         
//         System.out.println("Kapil: "+filename);
         try{
         File f=new File(getServlet().getServletContext().getRealPath("/music_image/"+filename));
//         System.out.println("saini: "+f.getAbsolutePath());
         f.delete();
         }catch(Exception ee){
             request.setAttribute("msg","There is some error occured in deleting audio file.");
         filelist=(ArrayList)tdb.get_contentfile(galid);
         request.setAttribute("filelist",filelist);
         return mapping.findForward(SUCCESS);
         }
         
         tr= df.del_ContentFile(galid);
           
        filelist=(ArrayList)tdb.get_contentfile(galid);
        
        request.setAttribute("filelist",filelist);
        request.setAttribute("msg","file deleted.");
        return mapping.findForward(SUCCESS);
        
    }    
    
}
