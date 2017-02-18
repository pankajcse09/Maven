package ActionClass;
/**
 *
 * @author Administrator
 */
import java.util.*;

public class JBeanEmp {    
    /** Creates a new instance of JavaBeanEmp */
    public JBeanEmp() {
    }  
    private String role="";
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
    private String pob="";
    private String nationality="";
    private String present="";
    private String permanent="";
    private String fname="";
    private String foccupation="";
    private String mstatus="";
    
    private String high="";
    private String high1="";
    private String high2="";
    private String high3="";
    private String high4="";
    private String high5="";
    
    private String inter="";
    private String inter1="";
    private String inter2="";
    private String inter3="";
    private String inter4="";
    private String inter5="";
    
    private String grad="";
    private String grad1="";
    private String grad2="";
    private String grad3="";
    private String grad4="";
    private String grad5="";
    
    private String pg="";
    private String pg1="";
    private String pg2="";
    private String pg3="";
    private String pg4="";
    private String pg5="";
    
    private String bed="";
    private String bed1="";
    private String bed2="";
    private String bed3="";
    private String bed4="";
    private String bed5="";
    
    private String other="";
    private String other1="";
    private String other2="";
    private String other3="";
    private String other4="";
    private String other5="";
    
    private String employer1="";
    private String employer2="";
    private String employer3="";
    private String employer4="";
       
    private String empdegn1="";
    private String empdegn2="";
    private String empdegn3="";
    private String empdegn4="";
       
    private String periodfrm1="";
    private String periodfrm2="";
    private String periodfrm3="";
    private String periodfrm4="";
    
    private String periodto1="";
    private String periodto2="";
    private String periodto3="";
    private String periodto4="";
    
    private String eng="";
    private String engr="";
    private String engw="";
    private String engs="";
    
    private String hindi="";  
    private String hindir=""; 
    private String hindiw=""; 
    private String hindis=""; 
    
    private String otherlan=""; 
    private String otherlanr=""; 
    private String otherlanw=""; 
    private String otherlans=""; 
    
    private String games=""; 
    private String games1="";
    private String games2="";
    private String games3="";
    
    private String lc="";
    private String lc1="";
    private String lc2="";
    private String lc3="";
    
    private String refer1="";
    private String refer2="";
    private String refer3="";  
    
    private ArrayList rowid=new ArrayList();
    private ArrayList examPassed=new ArrayList();
    private HashMap boardUnv=new HashMap();
    private HashMap subOffered=new HashMap();
    private HashMap examYear=new HashMap();
    private HashMap examPercent=new HashMap();
    private HashMap examRemark=new HashMap();
    
    private HashMap employer=new HashMap();
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
    
    private long rid=0;
    
    
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

    public String getPob() {
        return pob;
    }

    public void setPob(String pob) {
        this.pob = pob;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getHigh1() {
        return high1;
    }

    public void setHigh1(String high1) {
        this.high1 = high1;
    }

    public String getHigh2() {
        return high2;
    }

    public void setHigh2(String high2) {
        this.high2 = high2;
    }

    public String getHigh3() {
        return high3;
    }

    public void setHigh3(String high3) {
        this.high3 = high3;
    }

    public String getHigh4() {
        return high4;
    }

    public void setHigh4(String high4) {
        this.high4 = high4;
    }

    public String getHigh5() {
        return high5;
    }

    public void setHigh5(String high5) {
        this.high5 = high5;
    }

    public String getInter() {
        return inter;
    }

    public void setInter(String inter) {
        this.inter = inter;
    }

    public String getInter1() {
        return inter1;
    }

    public void setInter1(String inter1) {
        this.inter1 = inter1;
    }

    public String getInter2() {
        return inter2;
    }

    public void setInter2(String inter2) {
        this.inter2 = inter2;
    }

    public String getInter3() {
        return inter3;
    }

    public void setInter3(String inter3) {
        this.inter3 = inter3;
    }

    public String getInter4() {
        return inter4;
    }

    public void setInter4(String inter4) {
        this.inter4 = inter4;
    }

    public String getInter5() {
        return inter5;
    }

    public void setInter5(String inter5) {
        this.inter5 = inter5;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getGrad1() {
        return grad1;
    }

    public void setGrad1(String grad1) {
        this.grad1 = grad1;
    }

    public String getGrad2() {
        return grad2;
    }

    public void setGrad2(String grad2) {
        this.grad2 = grad2;
    }

    public String getGrad3() {
        return grad3;
    }

    public void setGrad3(String grad3) {
        this.grad3 = grad3;
    }

    public String getGrad4() {
        return grad4;
    }

    public void setGrad4(String grad4) {
        this.grad4 = grad4;
    }

    public String getGrad5() {
        return grad5;
    }

    public void setGrad5(String grad5) {
        this.grad5 = grad5;
    }

    public String getPg() {
        return pg;
    }

    public void setPg(String pg) {
        this.pg = pg;
    }

    public String getPg1() {
        return pg1;
    }

    public void setPg1(String pg1) {
        this.pg1 = pg1;
    }

    public String getPg2() {
        return pg2;
    }

    public void setPg2(String pg2) {
        this.pg2 = pg2;
    }

    public String getPg3() {
        return pg3;
    }

    public void setPg3(String pg3) {
        this.pg3 = pg3;
    }

    public String getPg4() {
        return pg4;
    }

    public void setPg4(String pg4) {
        this.pg4 = pg4;
    }

    public String getPg5() {
        return pg5;
    }

    public void setPg5(String pg5) {
        this.pg5 = pg5;
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public String getBed1() {
        return bed1;
    }

    public void setBed1(String bed1) {
        this.bed1 = bed1;
    }

    public String getBed2() {
        return bed2;
    }

    public void setBed2(String bed2) {
        this.bed2 = bed2;
    }

    public String getBed3() {
        return bed3;
    }

    public void setBed3(String bed3) {
        this.bed3 = bed3;
    }

    public String getBed4() {
        return bed4;
    }

    public void setBed4(String bed4) {
        this.bed4 = bed4;
    }

    public String getBed5() {
        return bed5;
    }

    public void setBed5(String bed5) {
        this.bed5 = bed5;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getOther1() {
        return other1;
    }

    public void setOther1(String other1) {
        this.other1 = other1;
    }

    public String getOther2() {
        return other2;
    }

    public void setOther2(String other2) {
        this.other2 = other2;
    }

    public String getOther3() {
        return other3;
    }

    public void setOther3(String other3) {
        this.other3 = other3;
    }

    public String getOther4() {
        return other4;
    }

    public void setOther4(String other4) {
        this.other4 = other4;
    }

    public String getOther5() {
        return other5;
    }

    public void setOther5(String other5) {
        this.other5 = other5;
    }

    public String getEmployer1() {
        return employer1;
    }

    public void setEmployer1(String employer1) {
        this.employer1 = employer1;
    }

    public String getEmployer2() {
        return employer2;
    }

    public void setEmployer2(String employer2) {
        this.employer2 = employer2;
    }

    public String getEmployer3() {
        return employer3;
    }

    public void setEmployer3(String employer3) {
        this.employer3 = employer3;
    }

    public String getEmployer4() {
        return employer4;
    }

    public void setEmployer4(String employer4) {
        this.employer4 = employer4;
    }

    public String getEmpdegn1() {
        return empdegn1;
    }

    public void setEmpdegn1(String empdegn1) {
        this.empdegn1 = empdegn1;
    }

    public String getEmpdegn2() {
        return empdegn2;
    }

    public void setEmpdegn2(String empdegn2) {
        this.empdegn2 = empdegn2;
    }

    public String getEmpdegn3() {
        return empdegn3;
    }

    public void setEmpdegn3(String empdegn3) {
        this.empdegn3 = empdegn3;
    }

    public String getEmpdegn4() {
        return empdegn4;
    }

    public void setEmpdegn4(String empdegn4) {
        this.empdegn4 = empdegn4;
    }

    public String getPeriodfrm1() {
        return periodfrm1;
    }

    public void setPeriodfrm1(String periodfrm1) {
        this.periodfrm1 = periodfrm1;
    }

    public String getPeriodfrm2() {
        return periodfrm2;
    }

    public void setPeriodfrm2(String periodfrm2) {
        this.periodfrm2 = periodfrm2;
    }

    public String getPeriodfrm3() {
        return periodfrm3;
    }

    public void setPeriodfrm3(String periodfrm3) {
        this.periodfrm3 = periodfrm3;
    }

    public String getPeriodfrm4() {
        return periodfrm4;
    }

    public void setPeriodfrm4(String periodfrm4) {
        this.periodfrm4 = periodfrm4;
    }

    public String getPeriodto1() {
        return periodto1;
    }

    public void setPeriodto1(String periodto1) {
        this.periodto1 = periodto1;
    }

    public String getPeriodto2() {
        return periodto2;
    }

    public void setPeriodto2(String periodto2) {
        this.periodto2 = periodto2;
    }

    public String getPeriodto3() {
        return periodto3;
    }

    public void setPeriodto3(String periodto3) {
        this.periodto3 = periodto3;
    }

    public String getPeriodto4() {
        return periodto4;
    }

    public void setPeriodto4(String periodto4) {
        this.periodto4 = periodto4;
    }

    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }

    public String getEngr() {
        return engr;
    }

    public void setEngr(String engr) {
        this.engr = engr;
    }

    public String getEngw() {
        return engw;
    }

    public void setEngw(String engw) {
        this.engw = engw;
    }

    public String getEngs() {
        return engs;
    }

    public void setEngs(String engs) {
        this.engs = engs;
    }

    public String getHindi() {
        return hindi;
    }

    public void setHindi(String hindi) {
        this.hindi = hindi;
    }

    public String getHindir() {
        return hindir;
    }

    public void setHindir(String hindir) {
        this.hindir = hindir;
    }

    public String getHindiw() {
        return hindiw;
    }

    public void setHindiw(String hindiw) {
        this.hindiw = hindiw;
    }

    public String getHindis() {
        return hindis;
    }

    public void setHindis(String hindis) {
        this.hindis = hindis;
    }

    public String getOtherlan() {
        return otherlan;
    }

    public void setOtherlan(String otherlan) {
        this.otherlan = otherlan;
    }

    public String getOtherlanr() {
        return otherlanr;
    }

    public void setOtherlanr(String otherlanr) {
        this.otherlanr = otherlanr;
    }

    public String getOtherlanw() {
        return otherlanw;
    }

    public void setOtherlanw(String otherlanw) {
        this.otherlanw = otherlanw;
    }

    public String getOtherlans() {
        return otherlans;
    }

    public void setOtherlans(String otherlans) {
        this.otherlans = otherlans;
    }

    public String getGames() {
        return games;
    }

    public void setGames(String games) {
        this.games = games;
    }

    public String getGames1() {
        return games1;
    }

    public void setGames1(String games1) {
        this.games1 = games1;
    }

    public String getGames2() {
        return games2;
    }

    public void setGames2(String games2) {
        this.games2 = games2;
    }

    public String getGames3() {
        return games3;
    }

    public void setGames3(String games3) {
        this.games3 = games3;
    }

    public String getLc() {
        return lc;
    }

    public void setLc(String lc) {
        this.lc = lc;
    }

    public String getLc1() {
        return lc1;
    }

    public void setLc1(String lc1) {
        this.lc1 = lc1;
    }

    public String getLc2() {
        return lc2;
    }

    public void setLc2(String lc2) {
        this.lc2 = lc2;
    }

    public String getLc3() {
        return lc3;
    }

    public void setLc3(String lc3) {
        this.lc3 = lc3;
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
    
      public HashMap getEmployer() {
        return employer;
    }

    public void setEmployer(HashMap employer) {
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

    public ArrayList getRowid() {
        return rowid;
    }

    public void setRowid(ArrayList rowid) {
        this.rowid = rowid;
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

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
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
   
}
