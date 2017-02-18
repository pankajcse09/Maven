/*
 * StoreBean.java
 *
 * Created on October 20, 2009, 12:55 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Intelmind.Beans;

/**
 *
 * @author Intelmind
 */
public class CategoryBean {
    
    /** Creates a new instance of StoreBean */
    public CategoryBean(){
    }
    
    private String catCode="";
    private String catName="";

    public String getCatCode() {
        return catCode;
    }

    public void setCatCode(String catCode) {
        this.catCode = catCode;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
    
    public CategoryBean removeNull(CategoryBean cb){
    if(cb.getCatCode()==null || cb.getCatCode().equals("null")){cb.setCatCode("");}   
    if(cb.getCatName()==null || cb.getCatName().equals("null")){cb.setCatName("");}        
    return cb;    
    }
    
}
