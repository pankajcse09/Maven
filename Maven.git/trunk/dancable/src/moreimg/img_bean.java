/*
 * img_bean.java
 *
 * Created on May 12, 2010, 12:23 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package moreimg;

/**
 *
 * @author arjun
 */
public class img_bean implements java.io.Serializable{
    
    /** Creates a new instance of img_bean */
    public img_bean() {
    }
    private int page_id=0;
    private String page_name="";
    
    private String head="";
    private String desc="";
    private String filename="";   
    private String sampleTitle="";
    private String sampleFileName="";
    private String unit="";
    private String status="";
    private String brand="";
    private String prod_id="";
    private double price=0.0;
    private String size="";    
    private int subcat_id=0;
    private String date="";
     private String detail="";
     private double marketprice=0.0;
     private double discount=0.0;
     private String discountdetail="";   
     
     private int detail_id=0;
     
     private int head_id=0;

    public int getPage_id() {
        return page_id;
    }

    public void setPage_id(int page_id) {
        this.page_id = page_id;
    }

    public String getPage_name() {
        return page_name;
    }

    public void setPage_name(String page_name) {
        this.page_name = page_name;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getHead_id() {
        return head_id;
    }

    public void setHead_id(int head_id) {
        this.head_id = head_id;
    }

    public int getDetail_id() {
        return detail_id;
    }

    public void setDetail_id(int detail_id) {
        this.detail_id = detail_id;
    }

    /**
     * @return the sampleFileName
     */
    public String getSampleFileName() {
        return sampleFileName;
    }

    /**
     * @param sampleFileName the sampleFileName to set
     */
    public void setSampleFileName(String sampleFileName) {
        this.sampleFileName = sampleFileName;
    }

    /**
     * @return the sampleTitle
     */
    public String getSampleTitle() {
        return sampleTitle;
    }

    /**
     * @param sampleTitle the sampleTitle to set
     */
    public void setSampleTitle(String sampleTitle) {
        this.sampleTitle = sampleTitle;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
}
