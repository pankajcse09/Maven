/*
 * Search_bean.java
 *
 * Created on November 19, 2012, 2:55 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Search;

/**
 *
 * @author user
 */
public class Search_bean {
    
    /** Creates a new instance of Search_bean */
    public Search_bean() {
    }
     private String name;
    
    private String code;    
    
    private int id=0;
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
