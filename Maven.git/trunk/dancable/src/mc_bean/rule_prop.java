/*
 * rule_prop.java
 *
 * Created on August 28, 2008, 3:21 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mc_bean;

/**
 *
 * @author arjun
 */
public class rule_prop {
    
    /** Creates a new instance of rule_prop */
    public rule_prop() {
    }
   private String rule="";
    private String subcat="";
private int suc_cat_id=0;

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getSubcat() {
        return subcat;
    }

    public void setSubcat(String subcat) {
        this.subcat = subcat;
    }

    public int getSuc_cat_id() {
        return suc_cat_id;
    }

    public void setSuc_cat_id(int suc_cat_id) {
        this.suc_cat_id = suc_cat_id;
    }
}
