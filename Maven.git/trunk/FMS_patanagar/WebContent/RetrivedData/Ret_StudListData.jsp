<%@page contentType="text/xml"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.util.*"%>
<%@page import="com.myapp.struts.DataConnection"%>
<%@page import="AO.*,EO.*"%>
<% 
    response.setHeader("Cache-Control","no-cache");
    response.setContentType("text/html");
    
    Connection con=null;
    PreparedStatement psmt1=null;
    ResultSet rs=null;    
    ArrayList ar=new ArrayList();
    try{
    DataConnection dc=new DataConnection();
    con=(Connection)dc.Dataconnect();
    }catch(Exception e){}    
    String by=request.getParameter("by");
    String cls=request.getParameter("cls");
    String ssn=request.getParameter("ssn");
    String dby=request.getParameter("dby");
    SchoolEO seo2=new SchoolEO();  
    seo2.setSession(ssn);
    seo2.setClasses(cls);    
    if(by.equals("GENDER")){by="gender";}
    if(by.equals("CATEGORY")){by="category";}
    if(by.equals("SUBJECT")){by="subject";}   
    seo2.setBy(by);
    seo2.setDataBy(dby);
    
    //////////////////////////////////////////////
    
    String qr="";
    if(by.equals("subject")){
    qr="select * from studentregis where session='"+ssn+"' and seekadd='"+cls+"' and srnum in (select admin_no from stud_subject where session='"+ssn+"' and classes='"+cls+"' and subject='"+dby+"')";    
    }else{
    qr="select * from studentregis where session='"+ssn+"' and seekadd='"+cls+"' and "+by+"='"+dby+"'";  
    }
    psmt1=con.prepareStatement(qr);
    rs=psmt1.executeQuery();
    while(rs.next()){   
    SchoolEO seo=new SchoolEO();    
    seo.setSession(rs.getString("session"));
 seo.setRegistNo(rs.getString("srnum"));
 seo.setSname(rs.getString("studname"));
 seo.setDob(rs.getString("dob"));
 seo.setGender(rs.getString("gender"));
 seo.setNationality(rs.getString("nationality"));
 seo.setFname(rs.getString("fname"));
 seo.setMname(rs.getString("mname"));
 seo.setAddress(rs.getString("paddress"));
 seo.setPhone(rs.getString("pphone"));
 seo.setMobile(rs.getString("pmobile"));
 seo.setSeekadd(rs.getString("seekadd"));
 seo.setCategory(rs.getString("category"));
 seo.setYearRegist(rs.getString("year_regist"));
 seo.setClassRegist(rs.getString("class_regist"));
 seo.setStandard(rs.getString("standard"));
 seo.setEnrolNo(rs.getString("enroll_no"));
 seo.setAdminType(rs.getString("admin_type"));
 seo.setHighSchool(rs.getDouble("highper"));
 seo.setHighMm(rs.getDouble("high_max_marks"));
 seo.setHighObt(rs.getDouble("high_obt_marks"));
 seo.setIntermediate(rs.getDouble("interper"));
 seo.setInterMm(rs.getDouble("inter_max_marks"));
 seo.setInterObt(rs.getDouble("inter_obt_marks")); 
 seo.setHighBoard(rs.getString("high_board"));
 seo.setInterBoard(rs.getString("inter_board"));
 seo.setDomicile(rs.getString("domicile"));
 ar.add(seo);
  } 
 
%>












