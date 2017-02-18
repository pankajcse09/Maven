/*
 * Copyright 2014 kapil.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package streams;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

/**
 *
 * @author kapil
 */
public class StreamActionForm extends org.apache.struts.action.ActionForm {
    private FormFile uploads1;
    private FormFile uploads2;
    private FormFile uploads3;
    
    private String title1="";
    private String title2="";
    private String title3="";
    private int galid=0;
    private int scid=0;
    private String tp="";
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if(getTp().equals("sm")||getTp().equals("nsm"))
        {
            if (getTitle1() == null || getTitle1().length() < 1) {
            errors.add("name1", new ActionMessage("error.title.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        if( getUploads1().getFileSize()== 0){
	       errors.add("file1",new ActionMessage("error.music.required"));
	       
	    }
        else if(!"application/pdf".equals(getUploads1().getContentType())){
	        errors.add("file1",new ActionMessage("error.music.pdf.only"));
	    }
//        System.out.println("kapil: "+getUploads1().getContentType());
        if( getTitle2().length() > 1&&getUploads2().getFileSize()== 0)
        {
            errors.add("file2",new ActionMessage("error.music.required"));
	  }
        else if((getTitle2() == null || getTitle2().length() < 1)&&getUploads2().getFileSize()!= 0)
        {
            errors.add("name2", new ActionMessage("error.title.required"));
            if(!"application/pdf".equals(getUploads2().getContentType())){
	        errors.add("file2",new ActionMessage("error.music.pdf.only"));
	     }
        }
        if( getTitle3().length() > 1&&getUploads3().getFileSize()== 0)
        {
            errors.add("file3",new ActionMessage("error.music.required"));
	  }
        else if((getTitle3() == null || getTitle3().length() < 1)&&getUploads3().getFileSize()!= 0)
        {
            errors.add("name3", new ActionMessage("error.title.required"));
            if(!"application/pdf".equals(getUploads3().getContentType())){
	        errors.add("file3",new ActionMessage("error.music.pdf.only"));
	    }
        }
  }
   else{
        if (getTitle1() == null || getTitle1().length() < 1) {
            errors.add("name1", new ActionMessage("error.title.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        if( getUploads1().getFileSize()== 0){
	       errors.add("file1",new ActionMessage("error.music.required"));
	       
	    }
//        else if(!"audio/mp3".equals(getUploads1().getContentType())){
//	        errors.add("file1",new ActionMessage("error.music.mp3.only"));
//	    }
//        System.out.println("kapil: "+getUploads1().getContentType());
        if( getTitle2().length() > 1&&getUploads2().getFileSize()== 0)
        {
            errors.add("file2",new ActionMessage("error.music.required"));
	  }
        else if((getTitle2() == null || getTitle2().length() < 1)&&getUploads2().getFileSize()!= 0)
        {
            errors.add("name2", new ActionMessage("error.title.required"));
//            if(!"audio/mp3".equals(getUploads2().getContentType())){
//	        errors.add("file2",new ActionMessage("error.music.mp3.only"));
//	     }
        }
        if( getTitle3().length() > 1&&getUploads3().getFileSize()== 0)
        {
            errors.add("file3",new ActionMessage("error.music.required"));
	  }
        else if((getTitle3() == null || getTitle3().length() < 1)&&getUploads3().getFileSize()!= 0)
        {
            errors.add("name3", new ActionMessage("error.title.required"));
//            if(!"audio/mp3".equals(getUploads3().getContentType())){
//	        errors.add("file3",new ActionMessage("error.music.mp3.only"));
//	    }
        }
    }
        return errors;
    }

    /**
     * @return the uploads1
     */
    public FormFile getUploads1() {
        return uploads1;
    }

    /**
     * @param uploads1 the uploads1 to set
     */
    public void setUploads1(FormFile uploads1) {
        this.uploads1 = uploads1;
    }

    /**
     * @return the uploads2
     */
    public FormFile getUploads2() {
        return uploads2;
    }

    /**
     * @param uploads2 the uploads2 to set
     */
    public void setUploads2(FormFile uploads2) {
        this.uploads2 = uploads2;
    }

    /**
     * @return the uploads3
     */
    public FormFile getUploads3() {
        return uploads3;
    }

    /**
     * @param uploads3 the uploads3 to set
     */
    public void setUploads3(FormFile uploads3) {
        this.uploads3 = uploads3;
    }

    /**
     * @return the title1
     */
    public String getTitle1() {
        return title1;
    }

    /**
     * @param title1 the title1 to set
     */
    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    /**
     * @return the title2
     */
    public String getTitle2() {
        return title2;
    }

    /**
     * @param title2 the title2 to set
     */
    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    /**
     * @return the title3
     */
    public String getTitle3() {
        return title3;
    }

    /**
     * @param title3 the title3 to set
     */
    public void setTitle3(String title3) {
        this.title3 = title3;
    }

    /**
     * @return the galid
     */
    public int getGalid() {
        return galid;
    }

    /**
     * @param galid the galid to set
     */
    public void setGalid(int galid) {
        this.galid = galid;
    }

    /**
     * @return the scid
     */
    public int getScid() {
        return scid;
    }

    /**
     * @param scid the scid to set
     */
    public void setScid(int scid) {
        this.scid = scid;
    }

    /**
     * @return the tp
     */
    public String getTp() {
        return tp;
    }

    /**
     * @param tp the tp to set
     */
    public void setTp(String tp) {
        this.tp = tp;
    }
    
    
}
