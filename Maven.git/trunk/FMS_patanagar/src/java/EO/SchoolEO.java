package EO;

import java.util.*;
import java.io.*;

public class SchoolEO {
    
     private ArrayList dataArray=new ArrayList();
     private ArrayList dataArray1=new ArrayList();
     private ArrayList dataArray2=new ArrayList();
     private ArrayList dataArray3=new ArrayList();
     private ArrayList dataArray4=new ArrayList();
     private ArrayList dataArray5=new ArrayList();
     private ArrayList dataArray6=new ArrayList();
     private ArrayList dataArray7=new ArrayList();
     private ArrayList dataArray8=new ArrayList();
     private ArrayList dataArray9=new ArrayList();
     private ArrayList sub=new ArrayList();
  
     private HashMap dataMap=new HashMap(); 
     private HashMap dataMap1=new HashMap();
     private HashMap dataMap2=new HashMap();
     private HashMap dataMap3=new HashMap();
     private HashMap dataMap4=new HashMap();
     private String duration="";
     private  String degree="";
     private String branch="";
     private String sub_code="";
     private String stud_type="";
     private String sub_name="";
     private String semester="";
     private String prac="";
     private long feeReceipt=0;
     private int counter=0;
     private int tot_days=0;
     private String stream="";
     private String by="";
     private String dataBy="";
     private String domicile="";
     private String practical="";
     private String adminType="";
     private String enrolNo="";
     private String rollNo="";
     private String registNo="";
     private String category="";
     private String yearRegist="";
     private String classRegist="";
     private String standard="";
     private String type="";
     private String syear="";
     private String eyear="";
     private String sesDate="";
     private double highSchool=0.0;
     private double intermediate=0.0;
     private double feeTotal=0.0;
     private double highMm=0.0;
     private double highObt=0.0;
     private double interMm=0.0;
     private double interObt=0.0;
     private String highBoard="";
     private String interBoard="";
     private double prevMm=0.0;
     private double prevObt=0.0;
     private String prevBoard="";
     
     private String facility="";
     private double regist_fee=0.0;
     private String phone="";
     private String srnum="";
     private String recnum="";
     private String sname="";
     private String gender="";  
     private String fname="";
     private String mname="";
     private String dob="";
     private String address="";
     private String rnum="";
     private String mobile="";
     private String seekadd="";
     private String pclass="";
     private String pschool="";
     private String report="";
     private String payment="";
     private String dname="";
     private String ddate="";
     private String bankname="";
     private String fax="";
     private String classes="";
     private String status="";
     private String admstatus="";
     private double tfee=0;
     private int rowid=0; 
     private long rwid=0;
     private int fpstatus=0; 
     private double amountpaid=0; 
     private String paid="";
     private String todate="";
     private String fromdate="";  
     private String lastdate="";  
     private String feesubdate=""; 
     private String section=""; 
     private String dateofadd=""; 
     private String awards=""; 
     private String Position=""; 
     private String conducton=""; 
     private String empname=""; 
     private String doj=""; 
     private String desig=""; 
     private String qualif=""; 
     private String subject=""; 
     private String msg=""; 
     private String session="";
     private String sib="";
     private double concession=0.0;
     private String buscode="";
     private String tripnum="";
     private String mtongue="";
     private String nationality="";
     private String fedu="";
     private String medu="";
     private String fprof="";
     private String mprof="";
     private double ppercent=0.0;
     private String gname="";
     private String gadd="";
     private String gphone="";
     private String transmode="";
     private String sibname1="";
     private String sibclass1="";
     private String sibyear1="";
     private String sibname2="";
     private String sibclass2="";
     private String sibyear2="";
     private String sibname3="";
     private String sibclass3="";
     private String sibyear3="";
     private String house="";
     private String sfeebooknum="";
     private String tfeebooknum="";
     private String heads="";
     private String ddno="";
     private String stud_id="";
     private String icar="";
     private String gate="";
     private String gen_rank="";

     private double net=0;
     private double eamount=0;
     private double pamount=0;
     private double curfine=0;
     private double pfine=0;
     private double fine=0;
     private double max_fine=0;
     private double due=0;
     private double fee=0;
     private double finalfee=0;
     private double paying=0;
     private double finalEamount=0;
     private double finalPamount=0;
     private double chkamount=0;
     private double remain=0;
     private double apr=0;
     private double may=0;
     private double june=0;
     private double july=0;
     private double august=0;
     private double sept=0;
     private double oct=0;
     private double nov=0;
     private double dec=0;
     private double jan=0;
     private double feb=0;
     private double mar=0;
     private double indvchkamount=0;
     private String month="";
     private String route="";
     private double busfee=0.0;   
     private double totalFee=0.0;
     private double ddamount=0.0;
     private ArrayList classList=new ArrayList();
     private ArrayList feeList=new ArrayList();
     private HashMap classFee=new HashMap();
     private InputStream pic;
     
     // By Kapil
     private String field="";
     private java.util.Date deposite_date=new java.util.Date();
     private double monthlyFood=0.0;
     private String batch="";
     private String filename="";
     private String newBeni="";
     private String heads_cat="";
     private String session_sem="";
     private String transaction_id="";
     private double foodadvance=0.0;
     private double cautionMoney=0.0;
     private String reason="";
     private String college="";
     private double min_fine=0.0;
     private double transfered_fund=0;
     private String reg="";
     private java.util.Date date=new java.util.Date();
     private java.util.Date Subm_date=new java.util.Date();
     private String course_id="";
     private double advance=0;
     private double adjustment=0;
     private String loginName="";
     private HostelBean hostelBean;
     
     
     public long getRwid()
     {
         return rwid;
     }
     public void setRwid(long rwid)
     {
       this.rwid=rwid;  
     }
     
     
      public String getGen_rank()
     {
         return gen_rank;
     }
     public void setGen_rank(String gen_rank)
     {
         this.gen_rank=gen_rank;
     }
     
     
     public String getIcar()
     {
         return icar;
     }
     public void setIcar(String icar)
     {
         this.icar=icar;
     }
     
     public String getGate()
     {
         return gate;
     }
     public void setGate(String gate)
     {
         this.gate=gate;
     }
     
     public String getStud_id()
     {
         return stud_id;
     }
     public void setStud_id(String stud_id)
     {
         this.stud_id=stud_id;
     }
     
     public String getStud_type()
     {
         return stud_type;
     }
     public void setStud_type(String stud_type)
     {
         this.stud_type=stud_type;
     }
     
     public double getDdamount()
     {
         return ddamount;
     }
     public void setDdamount(double ddamount)
     {
         this.ddamount=ddamount;
     }
     
     public String getDdno()
     {
         return ddno;
     }
     public void setDdno(String ddno)
     {
         this.ddno=ddno;
     }
     
     public int getTot_days()
     {
         return tot_days;
     }
     public void setTot_days(int tot_days){
         this.tot_days=tot_days;
     }
     
     public double getMax_fine()
     {
         return max_fine;
     }
     public void setMax_fine(double max_fine)
     {
         this.max_fine=max_fine;
     }
     
     public String getFacility()
     {
         return facility;
     }
     public void setFacility(String facility){
         this.facility=facility;
     }
     
     public double getRegist_fee()
     {
         return regist_fee;
     }
     public void setRegist_fee(double regist_fee){
         this.regist_fee=regist_fee;
     }

    public String getRecnum() {
        return recnum;
    }

    public void setRecnum(String recnum) {
        this.recnum = recnum;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        if(sname==null || sname.equals("null")){sname="";} 
        this.sname = sname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if(gender==null || gender.equals("null")){gender="";} 
        this.gender = gender;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        if(fname==null || fname.equals("null")){fname="";} 
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        if(mname==null || mname.equals("null")){mname="";} 
        this.mname = mname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        if(dob==null || dob.equals("null")){dob="";} 
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRnum() {
        return rnum;
    }

    public void setRnum(String rnum) {
        this.rnum = rnum;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSeekadd() {
        return seekadd;
    }

    public void setSeekadd(String seekadd){
        if(seekadd==null || seekadd.equals("null")){seekadd="";} 
        this.seekadd = seekadd;
    }

    public String getPclass() {
        return pclass;
    }

    public void setPclass(String pclass) {
        this.pclass = pclass;
    }

    public String getPschool() {
        return pschool;
    }

    public void setPschool(String pschool) {
        this.pschool = pschool;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDdate() {
        return ddate;
    }

    public void setDdate(String ddate) {
        this.ddate = ddate;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTfee() {
        return tfee;
    }

    public void setTfee(double tfee) {
        this.tfee = tfee;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public String getTodate() {
        return todate;
    }

    public void setTodate(String todate) {
        this.todate = todate;
    }

    public String getFromdate() {
        return fromdate;
    }

    public void setFromdate(String fromdate) {
        this.fromdate = fromdate;
    }

   
    public int getRowid() {
        return rowid;
    }

    public void setRowid(int rowid) {
        this.rowid = rowid;
    }

    public String getLastdate() {
        return lastdate;
    }

    public void setLastdate(String lastdate) {
        this.lastdate = lastdate;
    }

    public String getEyear() {
        return eyear;
    }

    public void setEyear(String eyear) {
        this.eyear = eyear;
    }

    public String getSyear() {
        return syear;
    }

    public void setSyear(String syear) {
        this.syear = syear;
    }

    public double getAmountpaid() {
        return amountpaid;
    }

    public void setAmountpaid(double amountpaid) {
        this.amountpaid = amountpaid;
    }

    public String getFeesubdate() {
        return feesubdate;
    }

    public void setFeesubdate(String feesubdate) {
        this.feesubdate = feesubdate;
    }

    public double getEamount() {
        return eamount;
    }

    public void setEamount(double eamount) {
        this.eamount = eamount;
    }

    public double getPamount() {
        return pamount;
    }

    public void setPamount(double pamount) {
        this.pamount = pamount;
    }

    public double getCurfine() {
        return curfine;
    }

    public void setCurfine(double curfine) {
        this.curfine = curfine;
    }

    public double getPfine() {
        return pfine;
    }

    public void setPfine(double pfine) {
        this.pfine = pfine;
    }

    public double getDue() {
        return due;
    }

    public void setDue(double due) {
        this.due = due;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public double getFinalfee() {
        return finalfee;
    }

    public void setFinalfee(double finalfee) {
        this.finalfee = finalfee;
    }

    public double getPaying() {
        return paying;
    }

    public void setPaying(double paying) {
        this.paying = paying;
    }

    public double getFinalEamount() {
        return finalEamount;
    }

    public void setFinalEamount(double finalEamount) {
        this.finalEamount = finalEamount;
    }

    public double getFinalPamount() {
        return finalPamount;
    }

    public void setFinalPamount(double finalPamount) {
        this.finalPamount = finalPamount;
    }

    public double getChkamount() {
        return chkamount;
    }

    public void setChkamount(double chkamount) {
        this.chkamount = chkamount;
    }

    public double getRemain() {
        return remain;
    }

    public void setRemain(double remain) {
        this.remain = remain;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getDateofadd() {
        return dateofadd;
    }

    public void setDateofadd(String dateofadd) {
        this.dateofadd = dateofadd;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getConducton() {
        return conducton;
    }

    public void setConducton(String conducton) {
        this.conducton = conducton;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String Position) {
        this.Position = Position;
    }

    public double getIndvchkamount() {
        return indvchkamount;
    }

    public void setIndvchkamount(double indvchkamount) {
        this.indvchkamount = indvchkamount;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getDoj() {
        return doj;
    }

    public void setDoj(String doj) {
        this.doj = doj;
    }

    public String getDesig() {
        return desig;
    }

    public void setDesig(String desig) {
        this.desig = desig;
    }

    public String getQualif() {
        return qualif;
    }

    public void setQualif(String qualif) {
        this.qualif = qualif;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public double getApr() {
        return apr;
    }

    public void setApr(double apr) {
        this.apr = apr;
    }

    public double getMay() {
        return may;
    }

    public void setMay(double may) {
        this.may = may;
    }

    public double getJune() {
        return june;
    }

    public void setJune(double june) {
        this.june = june;
    }

    public double getJuly() {
        return july;
    }

    public void setJuly(double july) {
        this.july = july;
    }

    public double getAugust() {
        return august;
    }

    public void setAugust(double august) {
        this.august = august;
    }

    public double getSept() {
        return sept;
    }

    public void setSept(double sept) {
        this.sept = sept;
    }

    public double getOct() {
        return oct;
    }

    public void setOct(double oct) {
        this.oct = oct;
    }

    public double getNov() {
        return nov;
    }

    public void setNov(double nov) {
        this.nov = nov;
    }

    public double getDec() {
        return dec;
    }

    public void setDec(double dec) {
        this.dec = dec;
    }

    public double getJan() {
        return jan;
    }

    public void setJan(double jan) {
        this.jan = jan;
    }

    public double getFeb() {
        return feb;
    }

    public void setFeb(double feb) {
        this.feb = feb;
    }

    public double getMar() {
        return mar;
    }

    public void setMar(double mar) {
        this.mar = mar;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

  
    public double getNet() {
        return net;
    }

    public void setNet(double net) {
        this.net = net;
    }

    public String getSib() {
        return sib;
    }

    public void setSib(String sib) {
        this.sib = sib;
    }

    public String getAdmstatus() {
        return admstatus;
    }

    public void setAdmstatus(String admstatus) {
        this.admstatus = admstatus;
    }

  
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public double getBusfee() {
        return busfee;
    }

    public void setBusfee(double busfee) {
        this.busfee = busfee;
    }

    public String getSrnum() {
        return srnum;
    }

    public void setSrnum(String srnum) {
        this.srnum = srnum;
    }

     
    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public String getBuscode() {
        return buscode;
    }

    public void setBuscode(String buscode) {
        this.buscode = buscode;
    }

    public String getTripnum() {
        return tripnum;
    }

    public void setTripnum(String tripnum) {
        this.tripnum = tripnum;
    }

    public String getMtongue() {
        return mtongue;
    }

    public void setMtongue(String mtongue) {
        this.mtongue = mtongue;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getFedu() {
        return fedu;
    }

    public void setFedu(String fedu) {
        this.fedu = fedu;
    }

    public String getMedu() {
        return medu;
    }

    public void setMedu(String medu) {
        this.medu = medu;
    }

    public String getFprof() {
        return fprof;
    }

    public void setFprof(String fprof) {
        this.fprof = fprof;
    }

    public String getMprof() {
        return mprof;
    }

    public void setMprof(String mprof) {
        this.mprof = mprof;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGadd() {
        return gadd;
    }

    public void setGadd(String gadd) {
        this.gadd = gadd;
    }

    public String getGphone() {
        return gphone;
    }

    public void setGphone(String gphone) {
        this.gphone = gphone;
    }

    public String getTransmode() {
        return transmode;
    }

    public void setTransmode(String transmode) {
        this.transmode = transmode;
    }

    public String getSibname1() {
        return sibname1;
    }

    public void setSibname1(String sibname1) {
        this.sibname1 = sibname1;
    }

    public String getSibclass1() {
        return sibclass1;
    }

    public void setSibclass1(String sibclass1) {
        this.sibclass1 = sibclass1;
    }

    public String getSibyear1() {
        return sibyear1;
    }

    public void setSibyear1(String sibyear1) {
        this.sibyear1 = sibyear1;
    }

    public String getSibname2() {
        return sibname2;
    }

    public void setSibname2(String sibname2) {
        this.sibname2 = sibname2;
    }

    public String getSibclass2() {
        return sibclass2;
    }

    public void setSibclass2(String sibclass2) {
        this.sibclass2 = sibclass2;
    }

    public String getSibyear2() {
        return sibyear2;
    }

    public void setSibyear2(String sibyear2) {
        this.sibyear2 = sibyear2;
    }

    public String getSibname3() {
        return sibname3;
    }

    public void setSibname3(String sibname3) {
        this.sibname3 = sibname3;
    }

    public String getSibclass3() {
        return sibclass3;
    }

    public void setSibclass3(String sibclass3) {
        this.sibclass3 = sibclass3;
    }

    public String getSibyear3() {
        return sibyear3;
    }

    public void setSibyear3(String sibyear3) {
        this.sibyear3 = sibyear3;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getSfeebooknum() {
        return sfeebooknum;
    }

    public void setSfeebooknum(String sfeebooknum) {
        this.sfeebooknum = sfeebooknum;
    }

    public String getTfeebooknum() {
        return tfeebooknum;
    }

    public void setTfeebooknum(String tfeebooknum) {
        this.tfeebooknum = tfeebooknum;
    }
   
    public String getHeads() {
        return heads;
    }

    public void setHeads(String heads) {
        this.heads = heads;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    public HashMap getClassFee() {
        return classFee;
    }

    public void setClassFee(HashMap classFee) {
        this.classFee = classFee;
    }

    public ArrayList getClassList() {
        return classList;
    }

    public void setClassList(ArrayList classList) {
        this.classList = classList;
    }
    
    public ArrayList getFeeList(){
        return feeList;
    }
    public void setFeeList(ArrayList feeList){
        this.feeList=feeList;
    }

    public double getConcession() {
        return concession;
    }

    public void setConcession(double concession) {
        this.concession = concession;
    }

    public int getFpstatus() {
        return fpstatus;
    }

    public void setFpstatus(int fpstatus) {
        this.fpstatus = fpstatus;
    }

    public InputStream getPic() {
        return pic;
    }

    public void setPic(InputStream pic) {
        this.pic = pic;
    }

    public ArrayList getDataArray() {
        return dataArray;
    }

    public void setDataArray(ArrayList dataArray) {
        this.dataArray = dataArray;
    }
    
    public ArrayList getDataArray1() {
        return dataArray1;
    }

    public void setDataArray1(ArrayList dataArray1) {
        this.dataArray1 = dataArray1;
    }
    
    public ArrayList getDataArray3() {
        return dataArray3;
    }

    public void setDataArray3(ArrayList dataArray3) {
        this.dataArray3 = dataArray3;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getYearRegist() {
        return yearRegist;
    }

    public void setYearRegist(String yearRegist) {
        if(yearRegist==null || yearRegist.equals("null")){yearRegist="";} 
        this.yearRegist = yearRegist;
    }

    public String getClassRegist() {
        return classRegist;
    }

    public void setClassRegist(String classRegist) {
        if(classRegist==null || classRegist.equals("null")){classRegist="";} 
        this.classRegist = classRegist;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        if(standard==null || standard.equals("null")){standard="";} 
        this.standard = standard;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSesDate() {
        return sesDate;
    }

    public void setSesDate(String sesDate) {
        this.sesDate = sesDate;
    }

    public double getHighSchool() {
        return highSchool;
    }

    public void setHighSchool(double highSchool) {
        this.highSchool = highSchool;
    }

    public double getIntermediate() {
        return intermediate;
    }

    public void setIntermediate(double intermediate) {
        this.intermediate = intermediate;
    }

    public HashMap getDataMap() {
        return dataMap;
    }

    public void setDataMap(HashMap dataMap) {
        this.dataMap = dataMap;
    }
    
    public HashMap getDataMap1() {
        return dataMap1;
    }

    public void setDataMap1(HashMap dataMap1) {
        this.dataMap1 = dataMap1;
    }
    
    public HashMap getDataMap2() {
        return dataMap2;
    }

    public void setDataMap2(HashMap dataMap2) {
        this.dataMap2 = dataMap2;
    }

    public ArrayList getDataArray2() {
        return dataArray2;
    }

    public void setDataArray2(ArrayList dataArray2) {
        this.dataArray2 = dataArray2;
    }

    public String getEnrolNo() {
        return enrolNo;
    }

    public void setEnrolNo(String enrolNo){
    if(enrolNo==null || enrolNo.equals("null")){enrolNo="";}    
    this.enrolNo = enrolNo;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        if(rollNo==null || rollNo.equals("null")){rollNo="";}  
        this.rollNo = rollNo;
    }

    public String getRegistNo() {
        return registNo;
    }

    public void setRegistNo(String registNo) {
        if(registNo==null || registNo.equals("null")){registNo="";}  
        this.registNo = registNo;
    }

    public double getFeeTotal() {
        return feeTotal;
    }

    public void setFeeTotal(double feeTotal) {
        this.feeTotal = feeTotal;
    }

    public String getAdminType() {
        return adminType;
    }

    public void setAdminType(String adminType) {
        if(adminType==null || adminType.equals("null")){adminType="";} 
        this.adminType = adminType;
    }

    public double getHighMm() {
        return highMm;
    }

    public void setHighMm(double highMm) {
        this.highMm = highMm;
    }

    public double getHighObt() {
        return highObt;
    }

    public void setHighObt(double highObt) {
        this.highObt = highObt;
    }

    public double getInterMm() {
        return interMm;
    }

    public void setInterMm(double interMm) {
        this.interMm = interMm;
    }

    public double getInterObt() {
        return interObt;
    }

    public void setInterObt(double interObt) {
        this.interObt = interObt;
    }

    public String getPractical() {
        return practical;
    }

    public void setPractical(String practical) {
        this.practical = practical;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDomicile() {
        return domicile;
    }

    public void setDomicile(String domicile) {
        if(domicile==null || domicile.equals("null")){domicile="";} 
        this.domicile = domicile;
    }

    public String getHighBoard() {
        return highBoard;
    }

    public void setHighBoard(String highBoard) {
        this.highBoard = highBoard;
    }

    public String getInterBoard() {
        return interBoard;
    }

    public void setInterBoard(String interBoard) {
        this.interBoard = interBoard;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getDataBy() {
        return dataBy;
    }

    public void setDataBy(String dataBy) {
        this.dataBy = dataBy;
    }

    public double getPrevMm() {
        return prevMm;
    }

    public void setPrevMm(double prevMm) {
        this.prevMm = prevMm;
    }

    public double getPrevObt() {
        return prevObt;
    }

    public void setPrevObt(double prevObt) {
        this.prevObt = prevObt;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public double getPpercent() {
        return ppercent;
    }

    public void setPpercent(double ppercent) {
        this.ppercent = ppercent;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public long getFeeReceipt() {
        return feeReceipt;
    }

    public void setFeeReceipt(long feeReceipt) {
        this.feeReceipt = feeReceipt;
    }

    public String getPrevBoard() {
        return prevBoard;
    }

    public void setPrevBoard(String prevBoard) {
        this.prevBoard = prevBoard;
    }

    public ArrayList getSub() {
        return sub;
    }

    public void setSub(ArrayList sub) {
        this.sub = sub;
    }

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

    public String getSub_code() {
        return sub_code;
    }

    public void setSub_code(String sub_code) {
        this.sub_code = sub_code;
    }

    public String getSub_name() {
        return sub_name;
    }

    public void setSub_name(String sub_name) {
        this.sub_name = sub_name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getPrac() {
        return prac;
    }

    public void setPrac(String prac) {
        this.prac = prac;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    
    public ArrayList getDataArray4() {
        return dataArray4;
    }

    public void setDataArray4(ArrayList dataArray4) {
        this.dataArray4 = dataArray4;
    }
    public ArrayList getDataArray5() {
        return dataArray5;
    }

    public void setDataArray5(ArrayList dataArray5) {
        this.dataArray5 = dataArray5;
    }
    public ArrayList getDataArray6() {
        return dataArray6;
    }

    public void setDataArray6(ArrayList dataArray6) {
        this.dataArray6 = dataArray6;
    }
    public ArrayList getDataArray7() {
        return dataArray7;
    }

    public void setDataArray7(ArrayList dataArray7) {
        this.dataArray7 = dataArray7;
    }
    
    public ArrayList getDataArray8() {
        return dataArray8;
    }

    public void setDataArray8(ArrayList dataArray8) {
        this.dataArray8 = dataArray8;
    }

    public ArrayList getDataArray9() {
        return dataArray9;
    }

    public void setDataArray9(ArrayList dataArray9) {
        this.dataArray9 = dataArray9;
    }

    /**
     * @return the field
     */
    public String getField() {
        return field;
    }

    /**
     * @param field the field to set
     */
    public void setField(String field) {
        this.field = field;
    }

    /**
     * @return the deposite_date
     */
    public java.util.Date getDeposite_date() {
        return deposite_date;
    }

    /**
     * @param deposite_date the deposite_date to set
     */
    public void setDeposite_date(java.util.Date deposite_date) {
        this.deposite_date = deposite_date;
    }

    /**
     * @return the monthlyFood
     */
    public double getMonthlyFood() {
        return monthlyFood;
    }

    /**
     * @param monthlyFood the monthlyFood to set
     */
    public void setMonthlyFood(double monthlyFood) {
        this.monthlyFood = monthlyFood;
    }

    /**
     * @return the batch
     */
    public String getBatch() {
        return batch;
    }

    /**
     * @param batch the batch to set
     */
    public void setBatch(String batch) {
        this.batch = batch;
    }

    /**
     * @return the dataMap3
     */
    public HashMap getDataMap3() {
        return dataMap3;
    }

    /**
     * @param dataMap3 the dataMap3 to set
     */
    public void setDataMap3(HashMap dataMap3) {
        this.dataMap3 = dataMap3;
    }

    /**
     * @return the filename
     */
    public String getFilename() {
        return filename;
    }

    /**
     * @param filename the filename to set
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * @return the newBeni
     */
    public String getNewBeni() {
        return newBeni;
    }

    /**
     * @param newBeni the newBeni to set
     */
    public void setNewBeni(String newBeni) {
        this.newBeni = newBeni;
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
     * @return the session_sem
     */
    public String getSession_sem() {
        return session_sem;
    }

    /**
     * @param session_sem the session_sem to set
     */
    public void setSession_sem(String session_sem) {
        this.session_sem = session_sem;
    }

    /**
     * @return the transaction_id
     */
    public String getTransaction_id() {
        return transaction_id;
    }

    /**
     * @param transaction_id the transaction_id to set
     */
    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    /**
     * @return the foodadvance
     */
    public double getFoodadvance() {
        return foodadvance;
    }

    /**
     * @param foodadvance the foodadvance to set
     */
    public void setFoodadvance(double foodadvance) {
        this.foodadvance = foodadvance;
    }

    /**
     * @return the cautionMoney
     */
    public double getCautionMoney() {
        return cautionMoney;
    }

    /**
     * @param cautionMoney the cautionMoney to set
     */
    public void setCautionMoney(double cautionMoney) {
        this.cautionMoney = cautionMoney;
    }

    /**
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason the reason to set
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * @return the college
     */
    public String getCollege() {
        return college;
    }

    /**
     * @param college the college to set
     */
    public void setCollege(String college) {
        this.college = college;
    }

    /**
     * @return the dataMap4
     */
    public HashMap getDataMap4() {
        return dataMap4;
    }

    /**
     * @param dataMap4 the dataMap4 to set
     */
    public void setDataMap4(HashMap dataMap4) {
        this.dataMap4 = dataMap4;
    }

    /**
     * @return the min_fine
     */
    public double getMin_fine() {
        return min_fine;
    }

    /**
     * @param min_fine the min_fine to set
     */
    public void setMin_fine(double min_fine) {
        this.min_fine = min_fine;
    }

    /**
     * @return the transfered_fund
     */
    public double getTransfered_fund() {
        return transfered_fund;
    }

    /**
     * @param transfered_fund the transfered_fund to set
     */
    public void setTransfered_fund(double transfered_fund) {
        this.transfered_fund = transfered_fund;
    }

    /**
     * @return the reg
     */
    public String getReg() {
        return reg;
    }

    /**
     * @param reg the reg to set
     */
    public void setReg(String reg) {
        this.reg = reg;
    }

    /**
     * @return the date
     */
    public java.util.Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(java.util.Date date) {
        this.date = date;
    }

    /**
     * @return the course_id
     */
    public String getCourse_id() {
        return course_id;
    }

    /**
     * @param course_id the course_id to set
     */
    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    /**
     * @return the advance
     */
    public double getAdvance() {
        return advance;
    }

    /**
     * @param advance the advance to set
     */
    public void setAdvance(double advance) {
        this.advance = advance;
    }

    /**
     * @return the adjustment
     */
    public double getAdjustment() {
        return adjustment;
    }

    /**
     * @param adjustment the adjustment to set
     */
    public void setAdjustment(double adjustment) {
        this.adjustment = adjustment;
    }

    /**
     * @return the loginName
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * @param loginName the loginName to set
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    /**
     * @return the hostelBean
     */
    public HostelBean getHostelBean() {
        return hostelBean;
    }

    /**
     * @param hostelBean the hostelBean to set
     */
    public void setHostelBean(HostelBean hostelBean) {
        this.hostelBean = hostelBean;
    }

    /**
     * @return the Subm_date
     */
    public java.util.Date getSubm_date() {
        return Subm_date;
    }

    /**
     * @param Subm_date the Subm_date to set
     */
    public void setSubm_date(java.util.Date Subm_date) {
        this.Subm_date = Subm_date;
    }

}
