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

/**
 *
 * @author kapil
 */
public class StreamBean {
    
    private String filename="";
    private String filename2="";
    private String filename3="";
    private String title="";
    private String title2="";
    private String title3="";
    
    private long rwid=0;
    private int item_id=0;
    private int sc_id=0;
    private String tp="";

    /**
     * @return the filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * @param filename the filename to set
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the rwid
     */
    public long getRwid() {
        return rwid;
    }

    /**
     * @param rwid the rwid to set
     */
    public void setRwid(long rwid) {
        this.rwid = rwid;
    }

    /**
     * @return the item_id
     */
    public int getItem_id() {
        return item_id;
    }

    /**
     * @param item_id the item_id to set
     */
    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    /**
     * @return the sc_id
     */
    public int getSc_id() {
        return sc_id;
    }

    /**
     * @param sc_id the sc_id to set
     */
    public void setSc_id(int sc_id) {
        this.sc_id = sc_id;
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
