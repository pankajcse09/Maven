/*
 * Im_Projects_DataHold.java
 *
 * Created on June 12, 2008, 10:44 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.myapp.struts;

/**
 *
 * @author Rock
 */
public class Im_Projects_DataHold {
    
    /** Creates a new instance of Im_Projects_DataHold */
    public Im_Projects_DataHold() {
    }
     private String title;
     private String text;
     private int id=0;
     private String filename="";
     private String isPlaylist="";
     private int f_id=0;
     private String area="";
  private int det_head_id=0;
    private int det_id=0;
    private long rowid=0;
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getF_id() {
        return f_id;
    }

    public void setF_id(int f_id) {
        this.f_id = f_id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getDet_head_id() {
        return det_head_id;
    }

    public void setDet_head_id(int det_head_id) {
        this.det_head_id = det_head_id;
    }

    public int getDet_id() {
        return det_id;
    }

    public void setDet_id(int det_id) {
        this.det_id = det_id;
    }

    /**
     * @return the isPlaylist
     */
    public String getIsPlaylist() {
        return isPlaylist;
    }

    /**
     * @param isPlaylist the isPlaylist to set
     */
    public void setIsPlaylist(String isPlaylist) {
        this.isPlaylist = isPlaylist;
    }

    /**
     * @return the rowid
     */
    public long getRowid() {
        return rowid;
    }

    /**
     * @param rowid the rowid to set
     */
    public void setRowid(long rowid) {
        this.rowid = rowid;
    }

   
    
    
    
}
