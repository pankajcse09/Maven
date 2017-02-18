package ActionClass;
/**
 *
 * @author Administrator
 */
import java.util.*;

public class JavaBeanEmp {    
    /** Creates a new instance of JavaBeanEmp */
    public JavaBeanEmp() {
    }   
    private int prof_id=0;
    private String empId="";
    private String loginId="";
    private String password="";
    private String rePassword="";
    private String question="";
    private String answer="";
    private String empName="";
    private String designation="";
    private String gender="";
    private String dob="";
    private String nationality="";
    private String present="";
    private String permanent="";
    private String fname="";
    private String foccupation="";
    private String mstatus="";
    private ArrayList examPassed=new ArrayList();
    private HashMap boardUnv=new HashMap();
    private HashMap subOffered=new HashMap();
    private HashMap examYear=new HashMap();
    private HashMap examPercent=new HashMap();
    private HashMap examRemark=new HashMap();
    private ArrayList employer=new ArrayList();
    private HashMap employerDesg=new HashMap();
    private HashMap employerFrom=new HashMap();
    private HashMap employerTo=new HashMap();
    private ArrayList languages=new ArrayList();
    private HashMap read=new HashMap();
    private HashMap write=new HashMap();
    private HashMap speak=new HashMap();
    private ArrayList activity=new ArrayList();
    private HashMap representLevel=new HashMap();
    private HashMap activityYear=new HashMap();
    private HashMap positionStood=new HashMap();
    private String refer1="";
    private String refer2="";
    private String refer3="";

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present;
    }

    public String getPermanent() {
        return permanent;
    }

    public void setPermanent(String permanent) {
        this.permanent = permanent;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFoccupation() {
        return foccupation;
    }

    public void setFoccupation(String foccupation) {
        this.foccupation = foccupation;
    }

    public String getMstatus() {
        return mstatus;
    }

    public void setMstatus(String mstatus) {
        this.mstatus = mstatus;
    }

    public ArrayList getExamPassed() {
        return examPassed;
    }

    public void setExamPassed(ArrayList examPassed) {
        this.examPassed = examPassed;
    }

    public HashMap getBoardUnv() {
        return boardUnv;
    }

    public void setBoardUnv(HashMap boardUnv) {
        this.boardUnv = boardUnv;
    }

    public HashMap getSubOffered() {
        return subOffered;
    }

    public void setSubOffered(HashMap subOffered) {
        this.subOffered = subOffered;
    }

    public HashMap getExamYear() {
        return examYear;
    }

    public void setExamYear(HashMap examYear) {
        this.examYear = examYear;
    }

    public HashMap getExamPercent() {
        return examPercent;
    }

    public void setExamPercent(HashMap examPercent) {
        this.examPercent = examPercent;
    }

    public HashMap getExamRemark() {
        return examRemark;
    }

    public void setExamRemark(HashMap examRemark) {
        this.examRemark = examRemark;
    }

    public ArrayList getEmployer() {
        return employer;
    }

    public void setEmployer(ArrayList employer) {
        this.employer = employer;
    }

    public HashMap getEmployerDesg() {
        return employerDesg;
    }

    public void setEmployerDesg(HashMap employerDesg) {
        this.employerDesg = employerDesg;
    }

    public HashMap getEmployerFrom() {
        return employerFrom;
    }

    public void setEmployerFrom(HashMap employerFrom) {
        this.employerFrom = employerFrom;
    }

    public HashMap getEmployerTo() {
        return employerTo;
    }

    public void setEmployerTo(HashMap employerTo) {
        this.employerTo = employerTo;
    }

    public ArrayList getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList languages) {
        this.languages = languages;
    }

    public HashMap getRead() {
        return read;
    }

    public void setRead(HashMap read) {
        this.read = read;
    }

    public HashMap getWrite() {
        return write;
    }

    public void setWrite(HashMap write) {
        this.write = write;
    }

    public HashMap getSpeak() {
        return speak;
    }

    public void setSpeak(HashMap speak) {
        this.speak = speak;
    }

    public ArrayList getActivity() {
        return activity;
    }

    public void setActivity(ArrayList activity) {
        this.activity = activity;
    }

    public HashMap getRepresentLevel() {
        return representLevel;
    }

    public void setRepresentLevel(HashMap representLevel) {
        this.representLevel = representLevel;
    }

    public HashMap getActivityYear() {
        return activityYear;
    }

    public void setActivityYear(HashMap activityYear) {
        this.activityYear = activityYear;
    }

    public HashMap getPositionStood() {
        return positionStood;
    }

    public void setPositionStood(HashMap positionStood) {
        this.positionStood = positionStood;
    }

    public String getRefer1() {
        return refer1;
    }

    public void setRefer1(String refer1) {
        this.refer1 = refer1;
    }

    public String getRefer2() {
        return refer2;
    }

    public void setRefer2(String refer2) {
        this.refer2 = refer2;
    }

    public String getRefer3() {
        return refer3;
    }

    public void setRefer3(String refer3) {
        this.refer3 = refer3;
    }

    public int getProf_id() {
        return prof_id;
    }

    public void setProf_id(int prof_id) {
        this.prof_id = prof_id;
    }

    
    
}
