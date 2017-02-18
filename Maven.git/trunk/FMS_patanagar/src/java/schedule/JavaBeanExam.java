package schedule;

/**
 *
 * @author Administrator
 */
import java.util.*;

public class JavaBeanExam {
    
    /** Creates a new instance of JavaBeanExam */
    public JavaBeanExam() {
    }
    
    private String headAc="";
    private String headType="";
    private String feeType="";
    private String rowid="";
    private String sessions="";
    private String classes="";
    private String section="";
    private String examType="";
    private String subject="";
    private String exam="";
    private String studId="";
    private String marks="";
    private String feeHead="";
    private String degree="";
private String branch="";

private String duration="";

private String semester="";
    private ArrayList rowidList=new ArrayList(); 
    private ArrayList subList=new ArrayList();
    private ArrayList studList=new ArrayList();
    private HashMap marksList=new HashMap(); 
    private HashMap marksType=new HashMap(); 
    private HashMap studListMap=new HashMap(); 
    private ArrayList studAttend=new ArrayList();
    
    private String heads_cat="";
    private String stud_type="";
    
        public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getSessions() {
        return sessions;
    }

    public void setSessions(String sessions) {
        this.sessions = sessions;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public ArrayList getStudList() {
        return studList;
    }

    public void setStudList(ArrayList studList) {
        this.studList = studList;
    }  

    public ArrayList getSubList() {
        return subList;
    }

    public void setSubList(ArrayList subList) {
        this.subList = subList;
    }

    public HashMap getMarksType() {
        return marksType;
    }

    public void setMarksType(HashMap marksType) {
        this.marksType = marksType;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public HashMap getMarksList() {
        return marksList;
    }

    public void setMarksList(HashMap marksList) {
        this.marksList = marksList;
    }

    public String getRowid() {
        return rowid;
    }

    public void setRowid(String rowid) {
        this.rowid = rowid;
    }

    public ArrayList getRowidList() {
        return rowidList;
    }

    public void setRowidList(ArrayList rowidList) {
        this.rowidList = rowidList;
    }

    public HashMap getStudListMap() {
        return studListMap;
    }

    public void setStudListMap(HashMap studListMap) {
        this.studListMap = studListMap;
    }

    public String getStudId() {
        return studId;
    }

    public void setStudId(String studId) {
        this.studId = studId;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public ArrayList getStudAttend() {
        return studAttend;
    }

    public void setStudAttend(ArrayList studAttend) {
        this.studAttend = studAttend;
    }

    public String getFeeHead() {
        return feeHead;
    }

    public void setFeeHead(String feeHead) {
        this.feeHead = feeHead;
    }

    public String getHeadType() {
        return headType;
    }

    public void setHeadType(String headType) {
        this.headType = headType;
    }
    
    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public String getHeadAc() {
        return headAc;
    }

    public void setHeadAc(String headAc) {
        if(headAc==null || headAc.equals("null")){headAc="";}
        this.headAc = headAc;
    }

    /**
     * @return the heads_cat
     */
    public String getHeads_cat() {
        return heads_cat;
    }

    /**
     * @param heads_cat the heads_cat to set
     */
    public void setHeads_cat(String heads_cat) {
        this.heads_cat = heads_cat;
    }

    /**
     * @return the stud_type
     */
    public String getStud_type() {
        return stud_type;
    }

    /**
     * @param stud_type the stud_type to set
     */
    public void setStud_type(String stud_type) {
        this.stud_type = stud_type;
    }
    
}
