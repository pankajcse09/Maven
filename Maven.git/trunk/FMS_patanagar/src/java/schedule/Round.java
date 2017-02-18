package schedule;

public class Round{    
    /** Creates a new instance of Round */
    public Round() {
    }      
     public double roundoff(double d){       
     Double net1= new Double(d);      
     //System.out.println(net1.valueOf());
     Double net  =new Double(Math.rint(Double.parseDouble(net1.toString())*1000.0)/1000); 
     double dbvalue= net.doubleValue() ;     
     return dbvalue;
   }  
    
}
