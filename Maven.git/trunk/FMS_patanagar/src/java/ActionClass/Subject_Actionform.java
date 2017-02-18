/*
 * Subject_Actionform.java
 *
 * Created on February 26, 2013, 3:50 PM
 */

package ActionClass;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author user
 * @version
 */

public class Subject_Actionform extends org.apache.struts.action.ActionForm {
    
    private String name;
    
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
    public Subject_Actionform() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getName() == null || getName().length() < 1) {
            errors.add("name", new ActionMessage("error.name.required"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }
}
