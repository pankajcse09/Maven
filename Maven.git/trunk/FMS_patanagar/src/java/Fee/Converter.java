/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Fee;

import java.math.BigDecimal;

/**
 *
 * @author kapil
 */
public class Converter {
    private double getPlace( String number ){
 switch( number.length() ){
case 1:
return DefinePlace.UNITS;
case 2:
return DefinePlace.TENS;
case 3:
return DefinePlace.HUNDREDS;
case 4:
return DefinePlace.THOUSANDS;
case 5:
return DefinePlace.TENTHOUSANDS;
case 6:
return DefinePlace.LAKHS;
case 7:
return DefinePlace.TENLAKHS;
case 8:
return DefinePlace.CRORES;
case 9:
return DefinePlace.TENCRORES;
}//switch
return 0.0;
}// getPlace

private String getWord( int number ){
switch( number ){
case 1:
return "One";
case 2:
return "Two";
case 3:
return "Three";
case 4:
return "Four";
case 5:
return "Five";
case 6:
return "Six";
case 7:
return "Seven";
case 8:
return "Eight";
case 9:
return "Nine";
case 0:
return "Zero";
case 10:
return "Ten";
case 11:
return "Eleven";
case 12:
return "Tweleve";
case 13:
return "Thirteen";
case 14:
return "Forteen";
case 15:
return "Fifteen";
case 16:
return "Sixteen";
case 17:
return "Seventeen";
case 18:
return "Eighteen";
case 19:
return "Ninteen";
case 20:
return "Twenty";
case 30:
return "Thirty";
case 40:
return "Forty";
case 50:
return "Fifty";
case 60:
return "Sixty";
case 70:
return "Seventy";
case 80:
return "Eighty";
case 90:
return "Ninty";
case 100:
return "Hundred";
} //switch
return "";
} //getWord


private String cleanNumber( String number ){
String cleanedNumber = "";

cleanedNumber = number.replace( '.', ' ' ).replaceAll( " ", "" );
cleanedNumber = cleanedNumber.replace( ',', ' ' ).replaceAll( " ", "" );
if( cleanedNumber.startsWith( "0" ) )
cleanedNumber = cleanedNumber.replaceFirst( "0", "" );

return cleanedNumber;
} //cleanNumber


public String convertNumber(String number ){
number = cleanNumber( number );
double num = 0.0;
try{
num = Double.parseDouble( number );
}catch( Exception e ){
return "";
} //catch

String returnValue = "";
while( num > 0 ){
number = "" + (int)num;
double place = getPlace(number);
if( place == DefinePlace.TENS || place == DefinePlace.TENTHOUSANDS || place == DefinePlace.TENLAKHS || place == DefinePlace.TENCRORES ){
int subNum = Integer.parseInt( number.charAt(0) + "" + number.charAt(1) );

if( subNum >= 21 && (subNum%10) != 0 ){
returnValue += getWord( Integer.parseInt( "" + number.charAt(0) ) * 10 ) + " " + getWord( subNum%10 ) ;
} //if
else{
returnValue += getWord(subNum);
}//else

if( place == DefinePlace.TENS ){
num = 0;
}//if
else if( place == DefinePlace.TENTHOUSANDS ){
num -= subNum * DefinePlace.THOUSANDS;
returnValue += " Thousands ";
}//if
else if( place == DefinePlace.TENLAKHS ){
num -= subNum * DefinePlace.LAKHS;
returnValue += " Lakhs ";
}//if
else if( place == DefinePlace.TENCRORES ){
num -= subNum * DefinePlace.CRORES;
returnValue += " Crores ";
}//if
}//if
else{
int subNum = Integer.parseInt( "" + number.charAt(0) );

returnValue += getWord( subNum );
if( place == DefinePlace.UNITS ){
num = 0;
}//if
else if( place == DefinePlace.HUNDREDS ){
num -= subNum * DefinePlace.HUNDREDS;
returnValue += " Hundred ";
}//if
else if( place == DefinePlace.THOUSANDS ){
num -= subNum * DefinePlace.THOUSANDS;
returnValue += " Thousand ";
}//if
else if( place == DefinePlace.LAKHS ){
num -= subNum * DefinePlace.LAKHS;
returnValue += " Lakh ";
}//if
else if( place == DefinePlace.CRORES ){
num -= subNum * DefinePlace.CRORES;
returnValue += " Crore ";
}//if
}//else
}//while
return returnValue;
}//convert number


public BigDecimal yes(Double n)
{
    String h= n.toString();
    BigDecimal d= new BigDecimal(h);
    
    return d;
}


public static void main( String args[] ){
Converter cv = new Converter();




    double num;
   double iPart;
  double fPart;

    // Get user input
    num = 2.32;
    iPart =  num;
    fPart = (int)num - (int)num;
 
   
    //BigDecimal zz= cv.yes(z); 
    //System.out.println("Integer part = " + iPart);
    //System.out.println("Fractional part = " + Math.ceil(fPart));

//Converter cn= new Converter();
//double i= 12131.99;
//Double k= new Double(i); 
//calculation_1 c= new calculation_1();
//int real= Integer.parseInt(c.realPart(k.toString()));
//int frc=Integer.parseInt(c.fraction(k.toString()));
//
//System.out.println(cn.convertNumber(new Integer(real).toString()));
//System.out.println("fraction"+cn.convertNumber(new Integer(frc).toString()));

 //cn.convertNumber(new Integer(real).toString());
// cn.convertNumber(new Integer(frc).toString());
 
  
/* 
Double k= new Double(i); 
System.out.println("Max Exponent."+k.toString());



int j= k.intValue();

Integer l= new Integer(j);

double b= l.doubleValue();

double m= i-b;

Double o= new Double(m);
int n= o.intValue();

System.out.println(m);
 Integer x= new Integer(n);
 
//String dd= l.toString();


//cv.cleanNumber(dd);
 
 
 //System.out.println("Convert"+cv.convertNumber(k.toString()));
  System.out.println("INT Value."+cv.convertNumber(l.toString()));
  System.out.println("Fraction."+cv.convertNumber(x.toString()));
*/
 }//main

}

class DefinePlace{
public static final double UNITS = 1;
public static final double TENS = 10 * UNITS;
public static final double HUNDREDS = 10 * TENS;
public static final double THOUSANDS = 10 * HUNDREDS;
public static final double TENTHOUSANDS = 10 * THOUSANDS;
public static final double LAKHS = 10 * TENTHOUSANDS;
public static final double TENLAKHS = 10 * LAKHS;
public static final double CRORES = 10 * TENLAKHS;
public static final double TENCRORES = 10 * CRORES;
} //class