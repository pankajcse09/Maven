/*
 * item_bean.java
 *
 * Created on May 13, 2010, 5:30 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Main_category;

import java.util.ArrayList;

/**
 *
 * @author arjun
 */
public class item_bean implements java.io.Serializable{
    
    /** Creates a new instance of item_bean */
    public item_bean() {
    }
    private ArrayList dataArray=new ArrayList();
     private ArrayList dataArray1=new ArrayList();
    private String subcat_name="";
    
    private int cart_id=0;
    
    private int quantity=0;
    private double subtotal=0.0;
     private double total=0.0;
     private double catsubtotal=0.0;
     private double cattotal=0.0;
     private double subdowntotal=0.0;
     private double downtotal=0.0;
     private double catprice=0.0;
     private String username="";
     private String category="";
     private String user_id="";
   
    private String unit="";
    private String status="";
    private String type="";
    private String brand="";
    private String prod_id="";
    private double price=0.0;
    private double cat_price=0.0;
    private String size="";    
    private int subcat_id=0;
    private int cat_id=0;
    private String filename="";
    private String sampleTitle="";
    private String sampleFileName="";
    private String audioFileName="";
    private String title="";
    private String promo_code="";
     private String order_id="";
     private String invoice_no="";
     private java.util.Date invoice_date=null;
    private String detail="";
    
      private double marketprice=0.0;
      private double downprice=0.0;
        private double discount=0.0;
        private double promo_value=0.0;
         private double ship_charge=0.0;
        
        
        private java.util.Date cartdate=null;
         private java.util.Date order_date=null;
          private  String discountdetail="";
          
    private int item_id=0;
    private int rwid=0;
     private long rowid=0;

 
  private String ship_f_name="";
  private String ship_l_name="";
  private String ship_street="";
  private String ship_city="";
  private String ship_state="";
  private String ship_zip="";
  private String ship_country="";
  private String ship_phone="";
  private String ship_a_phone="";
  private String ship_method="";
  
  private String bill_f_name="";
  private String bill_l_name="";
  private String bill_street="";
  private String bill_city="";
  private String bill_state="";
  private String bill_state2="";
  private String bill_zip="";
  private String bill_country="";
  private String bill_country2="";
  private String bill_phone="";
  private String bill_a_phone="";
  private String bill_method="";
  
 private String trans_id="";
 private int availability=0;
 
 private String kind="";
 private String shipmentTo="";
 private String related_items="";
 private String cover_content="";
 private int count=0;
 
 public double getPromo_value(){
     return promo_value;
 }
 public void setPromo_value(double promo_value){
     this.promo_value=promo_value;
 }
 
 public String getPromo_code(){
     return promo_code;
 }
 public void setPromo_code(String promo_code){
     this.promo_code=promo_code;
 }
 
 public int getAvailability(){
     return availability;
 }
 public void setAvailability(int availability){
     this.availability=availability;
 }
 
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSubcat_name() {
        return subcat_name;
    }

    public void setSubcat_name(String subcat_name) {
        this.subcat_name = subcat_name;
    }

    public java.util.Date getCartdate() {
        return cartdate;
    }

    public void setCartdate(java.util.Date cartdate) {
        this.cartdate = cartdate;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    

    public String getShip_f_name() {
        return ship_f_name;
    }

    public void setShip_f_name(String ship_f_name) {
        this.ship_f_name = ship_f_name;
    }

    public String getShip_l_name() {
        return ship_l_name;
    }

    public void setShip_l_name(String ship_l_name) {
        this.ship_l_name = ship_l_name;
    }

    public String getShip_street() {
        return ship_street;
    }

    public void setShip_street(String ship_street) {
        this.ship_street = ship_street;
    }

    public String getShip_city() {
        return ship_city;
    }

    public void setShip_city(String ship_city) {
        this.ship_city = ship_city;
    }

    public String getShip_state() {
        return ship_state;
    }

    public void setShip_state(String ship_state) {
        this.ship_state = ship_state;
    }

    public String getShip_zip() {
        return ship_zip;
    }

    public void setShip_zip(String ship_zip) {
        this.ship_zip = ship_zip;
    }

    public String getShip_country() {
        return ship_country;
    }

    public void setShip_country(String ship_country) {
        this.ship_country = ship_country;
    }

    public String getShip_phone() {
        return ship_phone;
    }

    public void setShip_phone(String ship_phone) {
        this.ship_phone = ship_phone;
    }

    public String getShip_a_phone() {
        return ship_a_phone;
    }

    public void setShip_a_phone(String ship_a_phone) {
        this.ship_a_phone = ship_a_phone;
    }

    public String getShip_method() {
        return ship_method;
    }

    public void setShip_method(String ship_method) {
        this.ship_method = ship_method;
    }

    public String getBill_f_name() {
        return bill_f_name;
    }

    public void setBill_f_name(String bill_f_name) {
        this.bill_f_name = bill_f_name;
    }

    public String getBill_l_name() {
        return bill_l_name;
    }

    public void setBill_l_name(String bill_l_name) {
        this.bill_l_name = bill_l_name;
    }

    public String getBill_street() {
        return bill_street;
    }

    public void setBill_street(String bill_street) {
        this.bill_street = bill_street;
    }

    public String getBill_city() {
        return bill_city;
    }

    public void setBill_city(String bill_city) {
        this.bill_city = bill_city;
    }

    public String getBill_state() {
        return bill_state;
    }

    public void setBill_state(String bill_state) {
        this.bill_state = bill_state;
    }

    public String getBill_zip() {
        return bill_zip;
    }

    public void setBill_zip(String bill_zip) {
        this.bill_zip = bill_zip;
    }

    public String getBill_country() {
        return bill_country;
    }

    public void setBill_country(String bill_country) {
        this.bill_country = bill_country;
    }

    public String getBill_phone() {
        return bill_phone;
    }

    public void setBill_phone(String bill_phone) {
        this.bill_phone = bill_phone;
    }

    public String getBill_a_phone() {
        return bill_a_phone;
    }

    public void setBill_a_phone(String bill_a_phone) {
        this.bill_a_phone = bill_a_phone;
    }

    public String getBill_method() {
        return bill_method;
    }

    public void setBill_method(String bill_method) {
        this.bill_method = bill_method;
    }

    public String getTrans_id() {
        return trans_id;
    }

    public void setTrans_id(String trans_id) {
        this.trans_id = trans_id;
    }

    /**
     * @return the dataArray
     */
    public ArrayList getDataArray() {
        return dataArray;
    }

    /**
     * @param dataArray the dataArray to set
     */
    public void setDataArray(ArrayList dataArray) {
        this.dataArray = dataArray;
    }

    /**
     * @return the dataArray1
     */
    public ArrayList getDataArray1() {
        return dataArray1;
    }

    /**
     * @param dataArray1 the dataArray1 to set
     */
    public void setDataArray1(ArrayList dataArray1) {
        this.dataArray1 = dataArray1;
    }

    /**
     * @return the order_date
     */
    public java.util.Date getOrder_date() {
        return order_date;
    }

    /**
     * @param order_date the order_date to set
     */
    public void setOrder_date(java.util.Date order_date) {
        this.order_date = order_date;
    }

    /**
     * @return the ship_charge
     */
    public double getShip_charge() {
        return ship_charge;
    }

    /**
     * @param ship_charge the ship_charge to set
     */
    public void setShip_charge(double ship_charge) {
        this.ship_charge = ship_charge;
    }

    /**
     * @return the order_id
     */
    public String getOrder_id() {
        return order_id;
    }

    /**
     * @param order_id the order_id to set
     */
    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    /**
     * @return the invoice_no
     */
    public String getInvoice_no() {
        return invoice_no;
    }

    /**
     * @param invoice_no the invoice_no to set
     */
    public void setInvoice_no(String invoice_no) {
        this.invoice_no = invoice_no;
    }

    /**
     * @return the user_id
     */
    public String getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    /**
     * @return the sample
     */
    public String getSampleFileName() {
        return sampleFileName;
    }

    /**
     * @param sample the sample to set
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
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the rwid
     */
    public int getRwid() {
        return rwid;
    }

    /**
     * @param rwid the rwid to set
     */
    public void setRwid(int rwid) {
        this.rwid = rwid;
    }

    /**
     * @return the audioFileName
     */
    public String getAudioFileName() {
        return audioFileName;
    }

    /**
     * @param audioFileName the audioFileName to set
     */
    public void setAudioFileName(String audioFileName) {
        this.audioFileName = audioFileName;
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

    /**
     * @return the invoice_date
     */
    public java.util.Date getInvoice_date() {
        return invoice_date;
    }

    /**
     * @param invoice_date the invoice_date to set
     */
    public void setInvoice_date(java.util.Date invoice_date) {
        this.invoice_date = invoice_date;
    }

    /**
     * @return the kind
     */
    public String getKind() {
        return kind;
    }

    /**
     * @param kind the kind to set
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * @return the shipmentTo
     */
    public String getShipmentTo() {
        return shipmentTo;
    }

    /**
     * @param shipmentTo the shipmentTo to set
     */
    public void setShipmentTo(String shipmentTo) {
        this.shipmentTo = shipmentTo;
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
     * @return the cat_id
     */
    public int getCat_id() {
        return cat_id;
    }

    /**
     * @param cat_id the cat_id to set
     */
    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    /**
     * @return the bill_state2
     */
    public String getBill_state2() {
        return bill_state2;
    }

    /**
     * @param bill_state2 the bill_state2 to set
     */
    public void setBill_state2(String bill_state2) {
        this.bill_state2 = bill_state2;
    }

    /**
     * @return the bill_country2
     */
    public String getBill_country2() {
        return bill_country2;
    }

    /**
     * @param bill_country2 the bill_country2 to set
     */
    public void setBill_country2(String bill_country2) {
        this.bill_country2 = bill_country2;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }

    public double getDownprice() {
        return downprice;
    }

    public void setDownprice(double downprice) {
        this.downprice = downprice;
    }

    public double getSubdowntotal() {
        return subdowntotal;
    }

    public void setSubdowntotal(double subdowntotal) {
        this.subdowntotal = subdowntotal;
    }

    public double getDowntotal() {
        return downtotal;
    }

    public void setDowntotal(double downtotal) {
        this.downtotal = downtotal;
    }

    public double getCat_price() {
        return cat_price;
    }

    public void setCat_price(double cat_price) {
        this.cat_price = cat_price;
    }

    /**
     * @return the catprice
     */
    public double getCatprice() {
        return catprice;
    }

    /**
     * @param catprice the catprice to set
     */
    public void setCatprice(double catprice) {
        this.catprice = catprice;
    }

    /**
     * @return the catsubtotal
     */
    public double getCatsubtotal() {
        return catsubtotal;
    }

    /**
     * @param catsubtotal the catsubtotal to set
     */
    public void setCatsubtotal(double catsubtotal) {
        this.catsubtotal = catsubtotal;
    }

    /**
     * @return the cattotal
     */
    public double getCattotal() {
        return cattotal;
    }

    /**
     * @param cattotal the cattotal to set
     */
    public void setCattotal(double cattotal) {
        this.cattotal = cattotal;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }
}
