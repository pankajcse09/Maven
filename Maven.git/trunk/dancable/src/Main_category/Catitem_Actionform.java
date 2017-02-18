/*
 * NewStrutsActionForm.java
 *
 * Created on May 8, 2008, 11:48 AM
 */

package Main_category;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author piyushrastogi
 * @version
 */

public class Catitem_Actionform extends org.apache.struts.action.ActionForm {
    
    /**
     * @return
     */
   
    public Catitem_Actionform() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
     
    private ArrayList uploads= new ArrayList();     
    private ArrayList samples= new ArrayList();
 
      private String unit="";
    private String status="";
    private String brand="";
    private String prod_id="";
    private double price=0.0;
    private String size="";    
    private int subcat_id=0;
    private String filename="";  
      private String detail="";
      private double marketprice=0.0;
        private double discount=0.0;
          private String discountdetail="";
     private String mainCat="";
     private String catName="";
     private String related_items="";


    public ArrayList getUploads() { return this.uploads; } 

public void setUploads(int index, FormFile formFile){ 
   this.getUploads().add(formFile); 
} 

public ArrayList getSamples() { return this.samples; } 

public void setSamples(int index, FormFile formFile){ 
   this.samples.add(formFile); 
}

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProd_id() {
        return prod_id;
    }

    public void setProd_id(String prod_id) {
        this.prod_id = prod_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
public int getSubcat_id() {
        return subcat_id;
    }
    public void setSubcat_id(int subcat_id) {
        this.subcat_id = subcat_id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public double getMarketprice() {
        return marketprice;
    }

    public void setMarketprice(double marketprice) {
        this.marketprice = marketprice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDiscountdetail() {
        return discountdetail;
    }

    public void setDiscountdetail(String discountdetail) {
        this.discountdetail = discountdetail;
    }

    /**
     * @return the mainCat
     */
    public String getMainCat() {
        return mainCat;
    }

    /**
     * @param mainCat the mainCat to set
     */
    public void setMainCat(String mainCat) {
        this.mainCat = mainCat;
    }

    /**
     * @return the catName
     */
    public String getCatName() {
        return catName;
    }

    /**
     * @param catName the catName to set
     */
    public void setCatName(String catName) {
        this.catName = catName;
    }

    /**
     * @return the related_items
     */
    public String getRelated_items() {
        return related_items;
    }

    /**
     * @param related_items the related_items to set
     */
    public void setRelated_items(String related_items) {
        this.related_items = related_items;
    }

   

       
   
}
