package Beans;

/**
 *
 * @author kanchan
 */
public class TcBean {
    
    /**
     * Creates a new instance of TcBean
     */
    public TcBean() {
    }
    
    private long rid=0;
    private String adminNo="";
    private String name="";
    private String fname="";
     private String mname="";
    private String dob="";
    private String entYear="";  
    private int studYear=0;  
    private int studMonth=0;  
    private String lastClass="";  
    private String result="";  
    private String migrReason=""; 
    private String enrolNo="";

    public long getRid() {
        return rid;
    }

    public void setRid(long rid) {
        this.rid = rid;
    }

    public String getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(String adminNo) {
        this.adminNo = adminNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEntYear() {
        return entYear;
    }

    public void setEntYear(String entYear) {
        this.entYear = entYear;
    }

    public int getStudYear() {
        return studYear;
    }

    public void setStudYear(int studYear) {
        this.studYear = studYear;
    }

    public int getStudMonth() {
        return studMonth;
    }

    public void setStudMonth(int studMonth) {
        this.studMonth = studMonth;
    }

    public String getLastClass() {
        return lastClass;
    }

    public void setLastClass(String lastClass) {
        this.lastClass = lastClass;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMigrReason() {
        return migrReason;
    }

    public void setMigrReason(String migrReason) {
        this.migrReason = migrReason;
    }

    public String getEnrolNo() {
        return enrolNo;
    }

    public void setEnrolNo(String enrolNo) {
        this.enrolNo = enrolNo;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }
}
