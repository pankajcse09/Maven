/*
 * item_list.java
 *
 * Created on August 25, 2008, 11:46 PM
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
public class item_list {
    
    /** Creates a new instance of item_list */
    public item_list() {
    }
    private int unit=0;
    private String color="";
     private Timestamp t;
 private int list_id=0;
 private String brand="";

 private String rule="";
 private int create_id =0;
  private int maincat_id =0;
  private int cat_id =0;
  private int subcat_id =0;
  private int item_id=0;
  private int size=0;
  private String cond="";
  private String cond1="";
 
 
    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Timestamp getT() {
        return t;
    }

    public void setT(Timestamp t) {
        this.t = t;
    }

    public int getList_id() {
        return list_id;
    }

    public void setList_id(int list_id) {
        this.list_id = list_id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public int getCreate_id() {
        return create_id;
    }

    public void setCreate_id(int create_id) {
        this.create_id = create_id;
    }

    public int getMaincat_id() {
        return maincat_id;
    }

    public void setMaincat_id(int maincat_id) {
        this.maincat_id = maincat_id;
    }

    public int getCat_id() {
        return cat_id;
    }

    public void setCat_id(int cat_id) {
        this.cat_id = cat_id;
    }

    public int getSubcat_id() {
        return subcat_id;
    }

    public void setSubcat_id(int subcat_id) {
        this.subcat_id = subcat_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
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

   
    
    
}
