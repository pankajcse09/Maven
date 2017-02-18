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
public class ContentFileForm extends org.apache.struts.action.ActionForm {
     private FormFile uploads1;
     private int galid=0;
    private int scid=0;
    public ContentFileForm() {
        super();
        // TODO Auto-generated constructor stub
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
public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        
        if( getUploads1().getFileSize()== 0){
	       errors.add("file1",new ActionMessage("error.music.required"));
	       
	    }
        else if(!"application/pdf".equals(getUploads1().getContentType())){
	        errors.add("file1",new ActionMessage("error.music.pdf.only"));
	    }

    
        return errors;
    }

   
}
