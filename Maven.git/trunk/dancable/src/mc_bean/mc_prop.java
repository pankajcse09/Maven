/*
 * mc_prop.java
 *
 * Created on August 8, 2008, 2:25 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mc_bean;
import java.sql.Timestamp;
/**
 *
 * @author arjun
 */
public class mc_prop {
    
    /** Creates a new instance of mc_prop */
    public mc_prop() {
    }
    private String  status="";
   private  String mc="";
 private  String act="";
 private  int mc_id=0;
 private  int c_id=0;
 private  String cat="";
 private  String sub_cat="";
 private  int subcat_id=0;
  private  String brand="";
  private  String prod_id="";
   private  int size=0;
  private Timestamp t;
    private Timestamp mt;
    private String detail="";
      private double marketprice=0.0;
        private double discount=0.0;
        
          private String discountdetail="";
          
          private String unit="";
          
          
          
  private String filename="";
  private String sampleFileName="";
  private String title="";
   private  int item_id=0;
    private String cond="";
  private String cond1="";
  private double price=0.0;
  private double down_price=0.0;
  private String promo="";
  private double promo_discount=0.0;
  private String promo_discountdetail="";
  private String p_code="";
  private String related_items="";
  private String cover_content="";
  
    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public int getMc_id() {
        return mc_id;
    }

    public void setMc_id(int mc_id) {
        this.mc_id = mc_id;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getSub_cat() {
        return sub_cat;
    }

    public void setSub_cat(String sub_cat) {
        this.sub_cat = sub_cat;
    }

    public int getSubcat_id() {
        return subcat_id;
    }

    public void setSubcat_id(int subcat_id) {
        this.subcat_id = subcat_id;
    }

    

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Timestamp getT() {
        return t;
    }

    public void setT(Timestamp t) {
        this.t = t;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getCond() {
        return cond;
    }

    public void setCond(String cond) {
        this.cond = cond;
    }

    public String getCond1() {
        return cond1;
    }

    public void setCond1(String cond1) {
        this.cond1 = cond1;
    }

    public Timestamp getMt() {
        return mt;
    }

    public void setMt(Timestamp mt) {
        this.mt = mt;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getProd_id() {
        return prod_id;
    }

    public void setProd_id(String prod_id) {
        this.prod_id = prod_id;
    }

    /**
     * @return the sampleFile
     */
    public String getSampleFileName() {
        return sampleFileName;
    }

    /**
     * @param sampleFile the sampleFile to set
     */
    public void setSampleFileName(String sampleFileName) {
        this.sampleFileName = sampleFileName;
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
     * @return the promo
     */
    public String getPromo() {
        return promo;
    }

    /**
     * @param promo the promo to set
     */
    public void setPromo(String promo) {
        this.promo = promo;
    }

    /**
     * @return the promo_discount
     */
    public double getPromo_discount() {
        return promo_discount;
    }

    /**
     * @param promo_discount the promo_discount to set
     */
    public void setPromo_discount(double promo_discount) {
        this.promo_discount = promo_discount;
    }

    /**
     * @return the promo_discountdetail
     */
    public String getPromo_discountdetail() {
        return promo_discountdetail;
    }

    /**
     * @param promo_discountdetail the promo_discountdetail to set
     */
    public void setPromo_discountdetail(String promo_discountdetail) {
        this.promo_discountdetail = promo_discountdetail;
    }

    /**
     * @return the p_code
     */
    public String getP_code() {
        return p_code;
    }

    /**
     * @param p_code the p_code to set
     */
    public void setP_code(String p_code) {
        this.p_code = p_code;
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

    /**
     * @return the cover_content
     */
    public String getCover_content() {
        return cover_content;
    }

    /**
     * @param cover_content the cover_content to set
     */
    public void setCover_content(String cover_content) {
        this.cover_content = cover_content;
    }

    public double getDown_price() {
        return down_price;
    }

    public void setDown_price(double down_price) {
        this.down_price = down_price;
    }
    
}
