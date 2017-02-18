package ActionClass;

/**
 *
 * @author kanchan
 */
public class JavaBean1 {
    
    /** Creates a new instance of JavaBean1 */
    public JavaBean1() {       
    }
   private String id=""; 
   private String name="";  
   private String loginid="";
   private String password="";
   private String secretques="";
   private String secretans="";  
   private String role="";
   private String userType="";
   private String status="";
   private String homeaddress="";
   private String homeaddress2="";
   private String city ="";
   private String  state ="";
   private String pincode ="";
   private String country="";
   private String telno="";
   private String mobileno="";
   private int adminregis =0;
   private long rid=0;
   private String loginFor="";
   private String loginForName="";

   public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecretques() {
        return secretques;
    }

    public void setSecretques(String secretques) {
        this.secretques = secretques;
    }

    public String getSecretans() {
        return secretans;
    }

    public void setSecretans(String secretans) {
        this.secretans = secretans;
    }    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the homeaddress
     */
    public String getHomeaddress() {
        return homeaddress;
    }

    /**
     * @param homeaddress the homeaddress to set
     */
    public void setHomeaddress(String homeaddress) {
        this.homeaddress = homeaddress;
    }

    /**
     * @return the homeaddress2
     */
    public String getHomeaddress2() {
        return homeaddress2;
    }

    /**
     * @param homeaddress2 the homeaddress2 to set
     */
    public void setHomeaddress2(String homeaddress2) {
        this.homeaddress2 = homeaddress2;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the pincode
     */
    public String getPincode() {
        return pincode;
    }

    /**
     * @param pincode the pincode to set
     */
    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the telno
     */
    public String getTelno() {
        return telno;
    }

    /**
     * @param telno the telno to set
     */
    public void setTelno(String telno) {
        this.telno = telno;
    }

    /**
     * @return the mobileno
     */
    public String getMobileno() {
        return mobileno;
    }

    /**
     * @param mobileno the mobileno to set
     */
    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    /**
     * @return the rid
     */
    public long getRid() {
        return rid;
    }

    /**
     * @param rid the rid to set
     */
    public void setRid(long rid) {
        this.rid = rid;
    }

    public int getAdminregis() {
        return adminregis;
    }

    public void setAdminregis(int adminregis) {
        this.adminregis = adminregis;
    }

    /**
     * @return the loginFor
     */
    public String getLoginFor() {
        return loginFor;
    }

    /**
     * @param loginFor the loginFor to set
     */
    public void setLoginFor(String loginFor) {
        this.loginFor = loginFor;
    }

    /**
     * @return the lofingForName
     */
    public String getLoginForName() {
        return loginForName;
    }

    /**
     * @param lofingForName the lofingForName to set
     */
    public void setLoginForName(String loginForName) {
        this.loginForName = loginForName;
    }

    
}
