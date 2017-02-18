 <%@page import="java.sql.Connection"%>
<%@page import="com.myapp.struts.Dataconnectivity"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%PreparedStatement ps=null;
 PreparedStatement ps1=null;
 ResultSet rs=null;
 ResultSet rs1=null;
 Connection con=null;
 int cnt=0;
 String stud_id="";
 if(request.getParameter("stud_id")!=null){
     stud_id=request.getParameter("stud_id");
 }
 try{
        Dataconnectivity dc=new Dataconnectivity();
        con=(Connection)dc.Dataconnect();
        String query="select batch,degree,studname from studentregis where stud_id=?";
        ps=con.prepareStatement(query);
        ps.setString(1, stud_id);
        rs=ps.executeQuery();
        if(rs.next()){
            StringBuffer sb=new StringBuffer();
            sb=sb.append("This Id ");
            sb=sb.append(stud_id);
            sb=sb.append(" is already alloted to Student- ");
            sb=sb.append(rs.getString("studname"));
            sb=sb.append(", batch- ");
            sb=sb.append(rs.getString("batch"));
            sb=sb.append(", degree- ");
            sb=sb.append(rs.getString("degree"));
            sb=sb.append("\n\n");
            sb=sb.append("Press Ok to enter the same Student Id.");
            sb=sb.append("\n");
            sb=sb.append("Press Cancel to enter other Student Id.");
            out.println(sb);
        }
        else
            out.print("0");
  }
  catch(Exception e){
      out.print("-1");
  } 
 finally{
     if(rs!=null)rs.close();
     if(ps!=null)ps.close();
     if(con!=null)con.close();
 }
    %>
