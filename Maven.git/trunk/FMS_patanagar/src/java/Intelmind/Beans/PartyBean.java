/*
 * PartyBean.java
 *
 * Created on October 20, 2009, 12:47 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Intelmind.Beans;

/**
 *
 * @author Intelmind
 */
public class PartyBean {
    
    /** Creates a new instance of PartyBean */
    public PartyBean(){
    }
    
    private String partyCode="";
    private String name="";
    private String arabicName="";
    private String shortName="";
    private String category="";
    private String contact="";
    private String address="";        
    private String email="";
    private String telephone="";
    private String mobile="";
    private String fax="";
    private String pager="";        
    private String remarks="";       

    public String getPartyCode() {
        return partyCode;
    }

    public void setPartyCode(String partyCode) {
        this.partyCode = partyCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArabicName() {
        return arabicName;
    }

    public void setArabicName(String arabicName) {
        this.arabicName = arabicName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPager() {
        return pager;
    }

    public void setPager(String pager) {
        this.pager = pager;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
    public PartyBean removeNull(PartyBean pb){
    if(pb.getAddress()==null || pb.getAddress().equals("null")){pb.setAddress("");}   
    if(pb.getArabicName()==null || pb.getArabicName().equals("null")){pb.setArabicName("");}        
    if(pb.getCategory()==null || pb.getCategory().equals("null")){pb.setCategory("");}        
    if(pb.getContact()==null || pb.getContact().equals("null")){pb.setContact("");}        
    if(pb.getEmail()==null || pb.getEmail().equals("null")){pb.setEmail("");}        
    if(pb.getFax()==null || pb.getFax().equals("null")){pb.setFax("");}        
    if(pb.getMobile()==null || pb.getMobile().equals("null")){pb.setMobile("");} 
    if(pb.getName()==null || pb.getName().equals("null")){pb.setName("");}        
    if(pb.getPager()==null || pb.getPager().equals("null")){pb.setPager("");}        
    if(pb.getPartyCode()==null || pb.getPartyCode().equals("null")){pb.setPartyCode("");}        
    if(pb.getRemarks()==null || pb.getRemarks().equals("null")){pb.setRemarks("");}        
    if(pb.getShortName()==null || pb.getShortName().equals("null")){pb.setShortName("");}        
    if(pb.getTelephone()==null || pb.getTelephone().equals("null")){pb.setTelephone("");}        
    return pb;    
    }
}
