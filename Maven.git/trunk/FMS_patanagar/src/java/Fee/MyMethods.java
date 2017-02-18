/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fee;

/**
 *
 * @author kapil
 */
public class MyMethods {
        /** Creates a new instance of MyMethods */
      public MyMethods() {} 
    
   public String precesion(String st,int n){
   String pno=st;
   int d=0;
   int in1=0;
   int in2=0;
   String st1="";
   String st2="";
   in1=st.indexOf(".");
   in2=st.length();
   st1=st.substring(0,in1);
   st2="."+st.substring(in1+1,in2);
//   System.out.println("st1: "+st1);
//   System.out.println("st2: "+st2);
   try{
   d=(int)(Double.parseDouble(st2)*pow(10,n));
   }
   catch(NumberFormatException ne){}
   if(d<pow(10,n-1)){
   pno=st;    
   }
   else{
    pno=st1+"."+d;     
   }    
   return pno;    
   }    
 
   public int pow(int no,int p){
   int np=1;    
   for(int i=1;i<=p;i++){
   np=np*no;    
   }    
   return np;
   }
   
   public static void main(String arg[])
   {
//       java.util.Date dt=new java.util.Date();
//       SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss");
//       Calendar cal=Calendar.getInstance();
//       System.out.println("Java Util Date: "+dt);
//       System.out.println("Java Calendar Date: "+Calendar.getInstance().getTime());
//       System.out.println("Java Util Time: "+sdf.format(dt));
//       System.out.println("Java Calendar Hour: "+cal.get(Calendar.HOUR_OF_DAY));
       
       MyMethods mm=new MyMethods();
       Round rnd=new Round();
       Converter cnvrt=new Converter();
       System.out.println("Test: "+mm.precesion(new Double(621.6).toString(),2));
       System.out.println("Round Real: "+rnd.real(mm.precesion(new Double(621.6).toString(),2)));
       System.out.println("Convert To Text: "+cnvrt.convertNumber(rnd.real(mm.precesion(new Double(621.6).toString(),2))));
       
       if(!rnd.fraction(mm.precesion(new Double(621.6).toString(),2).toUpperCase()).equals("0")){
System.out.println("AND "+cnvrt.convertNumber(rnd.fraction(mm.precesion(new Double(621.6).toString(),2))).toUpperCase()+" PAISE");
}
   }
}
