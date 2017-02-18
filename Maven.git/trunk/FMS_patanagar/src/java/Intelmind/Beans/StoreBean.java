package Intelmind.Beans;

public class StoreBean {
    
    /** Creates a new instance of StoreBean */
    public StoreBean(){
    }
    
    private String locCode="";
    private String name="";

    public String getLocCode() {
        return locCode;
    }

    public void setLocCode(String locCode) {
        this.locCode = locCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public StoreBean removeNull(StoreBean sb){
    if(sb.getLocCode()==null || sb.getLocCode().equals("null")){sb.setLocCode("");}   
    if(sb.getName()==null || sb.getName().equals("null")){sb.setName("");}        
    return sb;    
    }
    
}
