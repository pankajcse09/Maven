
package AO;
public class Round{    
    /** Creates a new instance of Round */
    public Round() {
    }      
     public double roundoff(double d){       
     Double net1= new Double(d);      
     //System.out.println(net1.valueOf());
     Double net  =new Double(Math.rint(Double.parseDouble(net1.toString())*100.0)/100); 
     double dbvalue= net.doubleValue();     
     return dbvalue;
   }  
    
   public String real(String st){   
    String re="";
    int in=st.indexOf(".");
    re=st.substring(0,in);
    return re;   
   }  
   public String fraction(String st){
   String fr="";
   int in=st.indexOf(".");
   int in2=st.length();
   fr=st.substring(in+1,in2);
   return fr;    
   }
}
   