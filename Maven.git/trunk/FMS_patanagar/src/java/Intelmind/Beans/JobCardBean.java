/*
 * StoreBean.java
 *
 * Created on October 20, 2009, 12:55 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Intelmind.Beans;

/**
 *
 * @author Intelmind
 */
public class JobCardBean {
    
    /** Creates a new instance of StoreBean */
    public JobCardBean(){
    }
    
    private String dated="";
    private String doc="";
    private String jobCard="";
    private String dateIn="";
    private String typeIE="";
    private String gatePass="";
    private String timeIn="";
    private String servType="";
    private String location="";
    private String equipId="";
    private String plateNo="";
    private String equipType="";
    private String project="";
    private String operator="";
    private String servLevel="";
    private String operTitle="";
    private String kmHm="";
    private String preventMain="";
    private String closedStatus="";
    private String closedDate="";
    private String dateOut="";
    private String timeOut="";
    private String idleActive="";
    private String downTime="";
    private String nxtServAfter="";
    private String nxtServDue="";
    private String nxtServType="";
    private String prevServType1="";
    private String prevServType2="";
    private String prevServType3="";
    private String servLoc="";
    private String remarks="";    

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getJobCard() {
        return jobCard;
    }

    public void setJobCard(String jobCard) {
        this.jobCard = jobCard;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getTypeIE() {
        return typeIE;
    }

    public void setTypeIE(String typeIE) {
        this.typeIE = typeIE;
    }

    public String getGatePass() {
        return gatePass;
    }

    public void setGatePass(String gatePass) {
        this.gatePass = gatePass;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(String timeIn) {
        this.timeIn = timeIn;
    }

    public String getServType() {
        return servType;
    }

    public void setServType(String servType) {
        this.servType = servType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEquipId() {
        return equipId;
    }

    public void setEquipId(String equipId) {
        this.equipId = equipId;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getEquipType() {
        return equipType;
    }

    public void setEquipType(String equipType) {
        this.equipType = equipType;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getServLevel() {
        return servLevel;
    }

    public void setServLevel(String servLevel) {
        this.servLevel = servLevel;
    }

    public String getOperTitle() {
        return operTitle;
    }

    public void setOperTitle(String operTitle) {
        this.operTitle = operTitle;
    }

    public String getKmHm() {
        return kmHm;
    }

    public void setKmHm(String kmHm) {
        this.kmHm = kmHm;
    }

    public String getPreventMain() {
        return preventMain;
    }

    public void setPreventMain(String preventMain) {
        this.preventMain = preventMain;
    }

    public String getClosedStatus() {
        return closedStatus;
    }

    public void setClosedStatus(String closedStatus) {
        this.closedStatus = closedStatus;
    }

    public String getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(String closedDate) {
        this.closedDate = closedDate;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public String getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(String timeOut) {
        this.timeOut = timeOut;
    }

    public String getIdleActive() {
        return idleActive;
    }

    public void setIdleActive(String idleActive) {
        this.idleActive = idleActive;
    }

    public String getDownTime() {
        return downTime;
    }

    public void setDownTime(String downTime) {
        this.downTime = downTime;
    }

    public String getNxtServAfter() {
        return nxtServAfter;
    }

    public void setNxtServAfter(String nxtServAfter) {
        this.nxtServAfter = nxtServAfter;
    }

    public String getNxtServDue() {
        return nxtServDue;
    }

    public void setNxtServDue(String nxtServDue) {
        this.nxtServDue = nxtServDue;
    }

    public String getNxtServType() {
        return nxtServType;
    }

    public void setNxtServType(String nxtServType) {
        this.nxtServType = nxtServType;
    }

    public String getPrevServType1() {
        return prevServType1;
    }

    public void setPrevServType1(String prevServType1) {
        this.prevServType1 = prevServType1;
    }

    public String getPrevServType2() {
        return prevServType2;
    }

    public void setPrevServType2(String prevServType2) {
        this.prevServType2 = prevServType2;
    }

    public String getPrevServType3() {
        return prevServType3;
    }

    public void setPrevServType3(String prevServType3) {
        this.prevServType3 = prevServType3;
    }

    public String getServLoc() {
        return servLoc;
    }

    public void setServLoc(String servLoc) {
        this.servLoc = servLoc;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
    public String getDated() {
    return dated;
    }

    public void setDated(String dated) {
        if(dated==null || dated.equals("null")){dated="";}  
        this.dated = dated;
    }
    
    public JobCardBean removeNull(JobCardBean jcb){
    if(jcb.getClosedDate()==null || jcb.getClosedDate().equals("null")){jcb.setClosedDate("");}   
    if(jcb.getClosedStatus()==null || jcb.getClosedStatus().equals("null")){jcb.setClosedStatus("");}   
    if(jcb.getDateIn()==null || jcb.getDateIn().equals("null")){jcb.setDateIn("");} 
    if(jcb.getDateOut()==null || jcb.getDateOut().equals("null")){jcb.setDateOut("");} 
    if(jcb.getDoc()==null || jcb.getDoc().equals("null")){jcb.setDoc("");} 
    if(jcb.getDownTime()==null || jcb.getDownTime().equals("null")){jcb.setDownTime("");} 
    if(jcb.getEquipId()==null || jcb.getEquipId().equals("null")){jcb.setEquipId("");}     
    if(jcb.getEquipType()==null || jcb.getEquipType().equals("null")){jcb.setEquipType("");} 
    if(jcb.getGatePass()==null || jcb.getGatePass().equals("null")){jcb.setGatePass("");} 
    if(jcb.getIdleActive()==null || jcb.getIdleActive().equals("null")){jcb.setIdleActive("");} 
    if(jcb.getJobCard()==null || jcb.getJobCard().equals("null")){jcb.setJobCard("");} 
    if(jcb.getKmHm()==null || jcb.getKmHm().equals("null")){jcb.setKmHm("");} 
    if(jcb.getLocation()==null || jcb.getLocation().equals("null")){jcb.setLocation("");} 
    if(jcb.getNxtServAfter()==null || jcb.getNxtServAfter().equals("null")){jcb.setNxtServAfter("");} 
    if(jcb.getNxtServDue()==null || jcb.getNxtServDue().equals("null")){jcb.setNxtServDue("");} 
    if(jcb.getNxtServType()==null || jcb.getNxtServType().equals("null")){jcb.setNxtServType("");}     
    if(jcb.getOperTitle()==null || jcb.getOperTitle().equals("null")){jcb.setOperTitle("");} 
    if(jcb.getOperator()==null || jcb.getOperator().equals("null")){jcb.setOperator("");} 
    if(jcb.getPlateNo()==null || jcb.getPlateNo().equals("null")){jcb.setPlateNo("");} 
    if(jcb.getPrevServType1()==null || jcb.getPrevServType1().equals("null")){jcb.setPrevServType1("");} 
    if(jcb.getPrevServType2()==null || jcb.getPrevServType2().equals("null")){jcb.setPrevServType2("");} 
    if(jcb.getPrevServType3()==null || jcb.getPrevServType3().equals("null")){jcb.setPrevServType3("");} 
    if(jcb.getPreventMain()==null || jcb.getPreventMain().equals("null")){jcb.setPreventMain("");}     
    if(jcb.getProject()==null || jcb.getProject().equals("null")){jcb.setProject("");} 
    if(jcb.getRemarks()==null || jcb.getRemarks().equals("null")){jcb.setRemarks("");} 
    if(jcb.getServLevel()==null || jcb.getServLevel().equals("null")){jcb.setServLevel("");} 
    if(jcb.getServLoc()==null || jcb.getServLoc().equals("null")){jcb.setServLoc("");} 
    if(jcb.getServType()==null || jcb.getServType().equals("null")){jcb.setServType("");} 
    if(jcb.getTimeIn()==null || jcb.getTimeIn().equals("null")){jcb.setTimeIn("");} 
    if(jcb.getTimeOut()==null || jcb.getTimeOut().equals("null")){jcb.setTimeOut("");} 
    if(jcb.getTypeIE()==null || jcb.getTypeIE().equals("null")){jcb.setTypeIE("");} 
    return jcb;    
    }   
}
