package Intelmind.Beans;

/**
 *
 * @author arjun
 */
public class DynaBean {
    
    /** Creates a new instance of DynaBean */
    public DynaBean() {
    }
    private String table="";
    private String column="";

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }
        
}
