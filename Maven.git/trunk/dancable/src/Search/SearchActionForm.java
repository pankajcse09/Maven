/*
 * SearchActionForm.java
 *
 * Created on January 1, 2006, 2:02 AM
 */

package Search;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author user
 * @version
 */

public class SearchActionForm extends org.apache.struts.action.ActionForm {
    
    private String name;
    
    private String code;  
    
     private int id=0;
     
     
    private int number;
    
    /**
     * @return
     */
    public String getName() {
        return name;
    }
    
    /**
     * @param string
     */
    public void setName(String string) {
        name = string;
    }
    
    /**
     * @return
     */
    public int getNumber() {
        return number;
    }
    
    /**
     * @param i
     */
    public void setNumber(int i) {
        number = i;
    }
    
    /**
     *
     */
    public SearchActionForm() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getName() == null || getName().length() < 1) {
            errors.add("name", new ActionMessage("error.searchname.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
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
