/*
 * Im_Res_DataHold.java
 *
 * Created on June 27, 2008, 10:05 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

 package com.myapp.struts;
import java.sql.Timestamp;

/**
 *
 * @author piyushrastogi
 */
public class Im_Res_DataHold {
    
    /** Creates a new instance of Im_Res_DataHold */
    public Im_Res_DataHold() {
    }
    
    private int no;
    private Timestamp ti;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Timestamp getTi() {
        return ti;
    }

    public void setTi(Timestamp ti) {
        this.ti = ti;
    }
            
    
    
    
}
