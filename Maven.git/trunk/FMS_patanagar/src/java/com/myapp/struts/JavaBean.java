package com.myapp.struts;
/**
 *
 * @author Intel
 */
import java.util.*;

public class JavaBean {
 private String customerNo="";    
 private String airwayNo="";    
 private String type="";     
 private String table="";    
 private double tds=0.0;   
 private String id="";    
 private String dated="";   
 private String dated1="";
 private String dated2="";
 private String time=""; 
 private int packet=0; 
 private String zone="";
 private double wt100=0.0;
 private double wt250=0.0;
 private double wt500=0.0;
 private double adwt250=0.0; 
 private double adwt500=0.0;  
 private double wt15=0.0;
 private double wt525=0.0;
 private double wt2550=0.0;
 private double wt50100=0.0;
 private double above100=0.0;
 private String cnno="";
 private String by="";
 private String mode="";
 private double weight=0.1;
 private String dest=""; 
 private double amount=0.0;  
 private ArrayList zones=new ArrayList();
 private String vehno="";
 private double startkm=0.0;
 private double endkm=0.0;
 private double totalkm=0.0;
 private double fuelamt=0.0;  
 private String details="";
 private String empname="";
 private String partyname="";
 private double topay=0.0;
 private double cod=0.0;
 private String recptno="";
 private double collection=0.0; 
 private String chequeno="";
 private String bankname="";
 private String compname="";
 private double amtpaid=0.0;
 private double amtbalance=0.0;
 private double amttotal=0.0;
 private String status="";
 private int newconsign=0;
 private int totconsign=0;
 private int issuedconsign=0;
 private double stax=0.0;
 private String series="";
 private long fromno=0;
 private long tono=0;
 private String compadd="";
 private String compadd2="";
 private String phno1="";
 private String phno2="";
 private long billno=0;
 private double fcharge=0.0;
 private double total=0.0;
 private double ndocTotal=0.0;
 ////////////////////////////////////////
 private double wt1_5=0.0;
 private double adwt5=0.0;  
 private double nondoc=0.0;
 private String ndoc="";
 private String address1="";
 private String address2="";
 private String consignee="";
 private String consigner="";
 private String city="";
 private String state="";
 private String country="";
 private String zipcode="";
 private String telephone="";
 private String fax=""; 
 private String courierId="";
 private String actype="";
 private double prepaid=0.0;
 private double balance=0.0;
 private String de_status=""; 
 private String reason=""; 
 private String reportType="";
 private String reportBy="";
 private ArrayList arrayData=new ArrayList();
 private HashMap mapData=new HashMap();
 private ArrayList reportData=new ArrayList();
 
    public double getFcharge() {
    return fcharge;
    }

    public void setFcharge(double fcharge) {
        this.fcharge = fcharge;
    }
 
   public long getBillno() {
    return billno;
    }

    public void setBillno(long billno) {
        this.billno = billno;
    }
 
    public double getStax() {
    return stax;
    }

    public void setStax(double stax) {
        this.stax = stax;
    }
 
    public String getId() {
    return id;
    }
    public void setId(String id) {
        this.id=id;
    }
    
     public String getDated() {
        return dated;
    }
    public void setDated(String dated) {
        this.dated = dated;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }
    
      public double getWt100() {
        return wt100;
    }

    public void setWt100(double wt100) {
        this.wt100 = wt100;
    }

    public double getWt250() {
        return wt250;
    }

    public void setWt250(double wt250) {
        this.wt250 = wt250;
    }

    public double getWt500() {
        return wt500;
    }

    public void setWt500(double wt500) {
        this.wt500 = wt500;
    }
    
    public double getAdwt250() {
        return adwt250;
    }

    public void setAdwt250(double adwt250) {
        this.adwt250 = adwt250;
    } 

    public double getAdwt500() {
        return adwt500;
    }

    public void setAdwt500(double adwt500) {
        this.adwt500 = adwt500;
    }    

    public double getWt15() {
        return wt15;
    }

    public void setWt15(double wt15) {
        this.wt15 = wt15;
    }

    public double getWt525() {
        return wt525;
    }

    public void setWt525(double wt525) {
        this.wt525 = wt525;
    }

    public double getWt2550() {
        return wt2550;
    }

    public void setWt2550(double wt2550) {
        this.wt2550 = wt2550;
    }

    public double getWt50100() {
        return wt50100;
    }

    public void setWt50100(double wt50100) {
        this.wt50100 = wt50100;
    }

    public double getAbove100() {
        return above100;
    }

    public void setAbove100(double above100) {
        this.above100 = above100;
    }

    public String getCnno() {
        return cnno;
    }

    public void setCnno(String cnno) {
        this.cnno = cnno;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ArrayList getZones() {
        return zones;
    }

    public void setZones(ArrayList zones) {
        this.zones = zones;
    }

    public String getVehno() {
        return vehno;
    }

    public void setVehno(String vehno) {
        this.vehno = vehno;
    }

    public double getStartkm() {
        return startkm;
    }

    public void setStartkm(double startkm) {
        this.startkm = startkm;
    }

    public double getEndkm() {
        return endkm;
    }

    public void setEndkm(double endkm) {
        this.endkm = endkm;
    }

    public double getTotalkm() {
        return totalkm;
    }

    public void setTotalkm(double totalkm) {
        this.totalkm = totalkm;
    }

    public double getFuelamt() {
        return fuelamt;
    }

    public void setFuelamt(double fuelamt) {
        this.fuelamt = fuelamt;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getPartyname() {
        return partyname;
    }

    public void setPartyname(String partyname) {
        this.partyname = partyname;
    }

    public double getTopay() {
        return topay;
    }

    public void setTopay(double topay) {
        this.topay = topay;
    }

    public double getCod() {
        return cod;
    }

    public void setCod(double cod) {
        this.cod = cod;
    }

    public String getRecptno() {
        return recptno;
    }

    public void setRecptno(String recptno) {
        this.recptno = recptno;
    }

    public double getCollection() {
        return collection;
    }

    public void setCollection(double collection) {
        this.collection = collection;
    }

    public String getChequeno() {
        return chequeno;
    }

    public void setChequeno(String chequeno) {
        this.chequeno = chequeno;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getCompname() {
        return compname;
    }

    public void setCompname(String compname) {
        this.compname = compname;
    }

    public double getAmtpaid() {
        return amtpaid;
    }

    public void setAmtpaid(double amtpaid) {
        this.amtpaid = amtpaid;
    }

    public double getAmtbalance() {
        return amtbalance;
    }

    public void setAmtbalance(double amtbalance) {
        this.amtbalance = amtbalance;
    }

    public double getAmttotal() {
        return amttotal;
    }

    public void setAmttotal(double amttotal) {
        this.amttotal = amttotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNewconsign() {
        return newconsign;
    }

    public void setNewconsign(int newconsign) {
        this.newconsign = newconsign;
    }

    public int getTotconsign() {
        return totconsign;
    }

    public void setTotconsign(int totconsign) {
        this.totconsign = totconsign;
    }

    public int getIssuedconsign() {
        return issuedconsign;
    }

    public void setIssuedconsign(int issuedconsign) {
        this.issuedconsign = issuedconsign;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public long getFromno() {
        return fromno;
    }

    public void setFromno(long fromno) {
        this.fromno = fromno;
    }

    public long getTono() {
        return tono;
    }

    public void setTono(long tono) {
        this.tono = tono;
    }

    public String getCompadd() {
        return compadd;
    }

    public void setCompadd(String compadd) {
        this.compadd = compadd;
    }

    public String getPhno1() {
        return phno1;
    }

    public void setPhno1(String phno1) {
        this.phno1 = phno1;
    }

    public String getPhno2() {
        return phno2;
    }

    public void setPhno2(String phno2) {
        this.phno2 = phno2;
    }
       public double getTds() {
        return tds;
    }

    public void setTds(double tds) {
        this.tds = tds;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPacket() {
        return packet;
    }

    public void setPacket(int packet) {
        this.packet = packet;
    }

    public double getWt1_5() {
        return wt1_5;
    }

    public void setWt1_5(double wt1_5) {
        this.wt1_5 = wt1_5;
    }

    public double getAdwt5() {
        return adwt5;
    }

    public void setAdwt5(double adwt5) {
        this.adwt5 = adwt5;
    }

    public double getNondoc() {
        return nondoc;
    }

    public void setNondoc(double nondoc) {
        this.nondoc = nondoc;
    }

    public String getCompadd2() {
        return compadd2;
    }

    public void setCompadd2(String compadd2) {
        this.compadd2 = compadd2;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getNdoc() {
        return ndoc;
    }

    public void setNdoc(String ndoc) {
        this.ndoc = ndoc;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getConsigner() {
        return consigner;
    }

    public void setConsigner(String consigner) {
        this.consigner = consigner;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCourierId() {
        return courierId;
    }

    public void setCourierId(String courierId) {
        this.courierId = courierId;
    }

    public String getActype() {
        return actype;
    }

    public void setActype(String actype) {
        this.actype = actype;
    }

    public double getPrepaid() {
        return prepaid;
    }

    public void setPrepaid(double prepaid) {
        this.prepaid = prepaid;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getDe_status() {
        return de_status;
    }

    public void setDe_status(String de_status) {
        this.de_status = de_status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getReportBy() {
        return reportBy;
    }

    public void setReportBy(String reportBy) {
        this.reportBy = reportBy;
    }

    public ArrayList getArrayData() {
        return arrayData;
    }

    public void setArrayData(ArrayList arrayData) {
        this.arrayData = arrayData;
    }

    public HashMap getMapData() {
        return mapData;
    }

    public void setMapData(HashMap mapData) {
        this.mapData = mapData;
    }

    public ArrayList getReportData() {
        return reportData;
    }

    public void setReportData(ArrayList reportData) {
        this.reportData = reportData;
    }

    public String getDated1() {
        return dated1;
    }

    public void setDated1(String dated1) {
        this.dated1 = dated1;
    }

    public String getDated2() {
        return dated2;
    }

    public void setDated2(String dated2) {
        this.dated2 = dated2;
    }

    public double getNdocTotal() {
        return ndocTotal;
    }

    public void setNdocTotal(double ndocTotal) {
        this.ndocTotal = ndocTotal;
    }

    public String getAirwayNo() {
        return airwayNo;
    }

    public void setAirwayNo(String airwayNo) {
        this.airwayNo = airwayNo;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
