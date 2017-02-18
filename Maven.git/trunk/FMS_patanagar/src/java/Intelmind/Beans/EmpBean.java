package Intelmind.Beans;

public class EmpBean{
        private String pname="";       
	private String pdate=""; 
        private String pfile=""; 
        
	private String emp_id="";   
        private String empName=""; 
	private String emp_f_name="";    
	private String emp_m_name="";    
	private String emp_l_name="";    
	private String org_id="";       
	private String level_id="";      
	private String dept_id="";       
	private String dob="";          
	private String dojoin="";       
	private String address_1="";      
	private String address_2="";     
	private String city="";          
	private String state="";          
	private String nationality="";
        private String status_allocation="";  
        private String visadetail="";          
        private String civilid="";          
        private String reg_exp="";          
        private String pass_no="";          
        private String date_of_issue="";         
        private String date_of_exp="";          
        private String other="";    
        private String expalert="";
        private String visaissue="";
        private String dlnno="";
        private String  dlissue="";
        private String dlexp="";
        private String civilidexp="";
        private String passportissue="";   

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmp_f_name() {
        return emp_f_name;
    }

    public void setEmp_f_name(String emp_f_name) {
        this.emp_f_name = emp_f_name;
    }

    public String getEmp_m_name() {
        return emp_m_name;
    }

    public void setEmp_m_name(String emp_m_name) {
        this.emp_m_name = emp_m_name;
    }

    public String getEmp_l_name() {
        return emp_l_name;
    }

    public void setEmp_l_name(String emp_l_name) {
        this.emp_l_name = emp_l_name;
    }

    public String getOrg_id() {
        return org_id;
    }

    public void setOrg_id(String org_id) {
        this.org_id = org_id;
    }

    public String getLevel_id() {
        return level_id;
    }

    public void setLevel_id(String level_id) {
        this.level_id = level_id;
    }

    public String getDept_id() {
        return dept_id;
    }

    public void setDept_id(String dept_id) {
        this.dept_id = dept_id;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDojoin() {
        return dojoin;
    }

    public void setDojoin(String dojoin) {
        this.dojoin = dojoin;
    }

    public String getAddress_1() {
        return address_1;
    }

    public void setAddress_1(String address_1) {
        this.address_1 = address_1;
    }

    public String getAddress_2() {
        return address_2;
    }

    public void setAddress_2(String address_2) {
        this.address_2 = address_2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getStatus_allocation() {
        return status_allocation;
    }

    public void setStatus_allocation(String status_allocation) {
        this.status_allocation = status_allocation;
    }

    public String getVisadetail() {
        return visadetail;
    }

    public void setVisadetail(String visadetail) {
        this.visadetail = visadetail;
    }

    public String getCivilid() {
        return civilid;
    }

    public void setCivilid(String civilid) {
        this.civilid = civilid;
    }

    public String getReg_exp() {
        return reg_exp;
    }

    public void setReg_exp(String reg_exp) {
        this.reg_exp = reg_exp;
    }

    public String getPass_no() {
        return pass_no;
    }

    public void setPass_no(String pass_no) {
        this.pass_no = pass_no;
    }

    public String getDate_of_issue() {
        return date_of_issue;
    }

    public void setDate_of_issue(String date_of_issue) {
        this.date_of_issue = date_of_issue;
    }

    public String getDate_of_exp() {
        return date_of_exp;
    }

    public void setDate_of_exp(String date_of_exp) {
        this.date_of_exp = date_of_exp;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getExpalert() {
        return expalert;
    }

    public void setExpalert(String expalert) {
        this.expalert = expalert;
    }

    public String getVisaissue() {
        return visaissue;
    }

    public void setVisaissue(String visaissue) {
        this.visaissue = visaissue;
    }

    public String getDlnno() {
        return dlnno;
    }

    public void setDlnno(String dlnno) {
        this.dlnno = dlnno;
    }

    public String getDlissue() {
        return dlissue;
    }

    public void setDlissue(String dlissue) {
        this.dlissue = dlissue;
    }

    public String getDlexp() {
        return dlexp;
    }

    public void setDlexp(String dlexp) {
        this.dlexp = dlexp;
    }

    public String getCivilidexp() {
        return civilidexp;
    }

    public void setCivilidexp(String civilidexp) {
        this.civilidexp = civilidexp;
    }

    public String getPassportissue() {
        return passportissue;
    }

    public void setPassportissue(String passportissue) {
        this.passportissue = passportissue;
    }
    
    public EmpBean removeNull(EmpBean eb){
    if(eb.getAddress_1()==null || eb.getAddress_1().equals("null")){eb.setAddress_1("");}   
    if(eb.getAddress_2()==null || eb.getAddress_2().equals("null")){eb.setAddress_2("");}   
    if(eb.getCity()==null || eb.getCity().equals("null")){eb.setCity("");}  
    if(eb.getCivilid()==null || eb.getCivilid().equals("null")){eb.setCivilid("");}  
    if(eb.getCivilidexp()==null || eb.getCivilidexp().equals("null")){eb.setCivilidexp("");}  
    if(eb.getDate_of_exp()==null || eb.getDate_of_exp().equals("null")){eb.setDate_of_exp("");}  
    if(eb.getDate_of_issue()==null || eb.getDate_of_issue().equals("null")){eb.setDate_of_issue("");}  
    if(eb.getDept_id()==null || eb.getDept_id().equals("null")){eb.setDept_id("");}  
    if(eb.getDlexp()==null || eb.getDlexp().equals("null")){eb.setDlexp("");}  
    if(eb.getDlissue()==null || eb.getDlissue().equals("null")){eb.setDlissue("");}  
    if(eb.getDlnno()==null || eb.getDlnno().equals("null")){eb.setDlnno("");}  
    if(eb.getDob()==null || eb.getDob().equals("null")){eb.setDob("");}  
    if(eb.getDojoin()==null || eb.getDojoin().equals("null")){eb.setDojoin("");}  
    if(eb.getEmpName()==null || eb.getEmpName().equals("null")){eb.setEmpName("");}  
    if(eb.getEmp_f_name()==null || eb.getEmp_f_name().equals("null")){eb.setEmp_f_name("");}  
    if(eb.getEmp_id()==null || eb.getEmp_id().equals("null")){eb.setEmp_id("");}  
    if(eb.getEmp_l_name()==null || eb.getEmp_l_name().equals("null")){eb.setEmp_l_name("");}  
    if(eb.getEmp_m_name()==null || eb.getEmp_m_name().equals("null")){eb.setEmp_m_name("");}  
    if(eb.getExpalert()==null || eb.getExpalert().equals("null")){eb.setExpalert("");}  
    if(eb.getLevel_id()==null || eb.getLevel_id().equals("null")){eb.setLevel_id("");}  
    if(eb.getNationality()==null || eb.getNationality().equals("null")){eb.setNationality("");}  
    if(eb.getOrg_id()==null || eb.getOrg_id().equals("null")){eb.setOrg_id("");}      
    if(eb.getOther()==null || eb.getOther().equals("null")){eb.setOther("");}  
    if(eb.getPass_no()==null || eb.getPass_no().equals("null")){eb.setPass_no("");}  
    if(eb.getPassportissue()==null || eb.getPassportissue().equals("null")){eb.setPassportissue("");}  
    if(eb.getReg_exp()==null || eb.getReg_exp().equals("null")){eb.setReg_exp("");}  
    if(eb.getState()==null || eb.getState().equals("null")){eb.setState("");}  
    if(eb.getStatus_allocation()==null || eb.getStatus_allocation().equals("null")){eb.setStatus_allocation("");}  
    if(eb.getVisadetail()==null || eb.getVisadetail().equals("null")){eb.setVisadetail("");}  
    if(eb.getVisaissue()==null || eb.getVisaissue().equals("null")){eb.setVisaissue("");}  
    
    return eb;    
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPdate() {
        return pdate;
    }

    public void setPdate(String pdate) {
        this.pdate = pdate;
    }

    public String getPfile() {
        return pfile;
    }

    public void setPfile(String pfile) {
        this.pfile = pfile;
    }
        
}
