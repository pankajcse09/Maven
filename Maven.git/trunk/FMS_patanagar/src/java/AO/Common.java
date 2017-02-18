
package AO;

import java.util.*;
import java.io.*;
import javax.servlet.http.*;


public class Common {
    
    /** Creates a new instance of encrypt */
   public String encrypt(String strdata){
		//System.out.print("Original data: "+strdata);
		strdata = jumbleData(strdata);
		strdata = encodeData(strdata);
		//System.out.println(", Encoded data: "+strdata);
		return strdata;
	}


	public String decrypt(String strdata){
		//System.out.print("Encoded data: "+strdata);
		strdata = decodeData(strdata);
		strdata = unJumbleData(strdata);
		//System.out.println(", Original data: "+strdata);
		return strdata;
	}


	public static void main(String argv[]){
		Common objcom = new Common();
		String strnewdata = objcom.encrypt("password");
		String strolddata = objcom.decrypt(strnewdata);
		//String d=RoundAmt(54.839,2);
		System.out.println("old"+strnewdata);
                System.out.println("old"+strolddata);


	}


	public String jumbleData(String strdata){

		Hashtable hstjmbdata = new Hashtable();
		StringBuffer strnewdata = new StringBuffer("");

		hstjmbdata.put("0", "a");
		hstjmbdata.put("1", "4");
		hstjmbdata.put("2", "A");
		hstjmbdata.put("3", "j");
		hstjmbdata.put("4", "C");
		hstjmbdata.put("5", "x");
		hstjmbdata.put("6", "I");
		hstjmbdata.put("7", "b");
		hstjmbdata.put("8", "F");
		hstjmbdata.put("9", "S");
		hstjmbdata.put("a", "K");
		hstjmbdata.put("b", "k");
		hstjmbdata.put("c", "M");
		hstjmbdata.put("d", "Q");
		hstjmbdata.put("e", "3");
		hstjmbdata.put("f", "q");
		hstjmbdata.put("g", "V");
		hstjmbdata.put("h", "l");
		hstjmbdata.put("i", "D");
		hstjmbdata.put("j", "W");
		hstjmbdata.put("k", "c");
		hstjmbdata.put("l", "9");
		hstjmbdata.put("m", "w");
		hstjmbdata.put("n", "R");
		hstjmbdata.put("o", "m");
		hstjmbdata.put("p", "N");
		hstjmbdata.put("q", "y");
		hstjmbdata.put("r", "J");
		hstjmbdata.put("s", "2");
		hstjmbdata.put("t", "n");
		hstjmbdata.put("u", "X");
		hstjmbdata.put("v", "E");
		hstjmbdata.put("w", "t");
		hstjmbdata.put("x", "Y");
		hstjmbdata.put("y", "5");
		hstjmbdata.put("z", "d");
		hstjmbdata.put("A", "Z");
		hstjmbdata.put("B", "6");
		hstjmbdata.put("C", "G");
		hstjmbdata.put("D", "h");
		hstjmbdata.put("E", "u");
		hstjmbdata.put("F", "1");
		hstjmbdata.put("G", "O");
		hstjmbdata.put("H", "e");
		hstjmbdata.put("I", "T");
		hstjmbdata.put("J", "r");
		hstjmbdata.put("K", "v");
		hstjmbdata.put("L", "o");
		hstjmbdata.put("M", "U");
		hstjmbdata.put("N", "7");
		hstjmbdata.put("O", "p");
		hstjmbdata.put("P", "L");
		hstjmbdata.put("Q", "f");
		hstjmbdata.put("R", "H");
		hstjmbdata.put("S", "z");
		hstjmbdata.put("T", "s");
		hstjmbdata.put("U", "B");
		hstjmbdata.put("V", "8");
		hstjmbdata.put("W", "g");
		hstjmbdata.put("X", "P");
		hstjmbdata.put("Y", "0");
		hstjmbdata.put("Z", "i");


		for (int icount=0; icount<strdata.length(); icount++){
			String strchar = ""+(strdata.charAt(icount));
			strnewdata = strnewdata.append(hstjmbdata.get(strchar));
		}

		strdata = strnewdata.toString();
		return strdata;
	}


	public String unJumbleData(String strdata){

		Hashtable hstujmbdata = new Hashtable();
		StringBuffer strnewdata = new StringBuffer("");

		hstujmbdata.put("a", "0");
		hstujmbdata.put("4", "1");
		hstujmbdata.put("A", "2");
		hstujmbdata.put("j", "3");
		hstujmbdata.put("C", "4");
		hstujmbdata.put("x", "5");
		hstujmbdata.put("I", "6");
		hstujmbdata.put("b", "7");
		hstujmbdata.put("F", "8");
		hstujmbdata.put("S", "9");
		hstujmbdata.put("K", "a");
		hstujmbdata.put("k", "b");
		hstujmbdata.put("M", "c");
		hstujmbdata.put("Q", "d");
		hstujmbdata.put("3", "e");
		hstujmbdata.put("q", "f");
		hstujmbdata.put("V", "g");
		hstujmbdata.put("l", "h");
		hstujmbdata.put("D", "i");
		hstujmbdata.put("W", "j");
		hstujmbdata.put("c", "k");
		hstujmbdata.put("9", "l");
		hstujmbdata.put("w", "m");
		hstujmbdata.put("R", "n");
		hstujmbdata.put("m", "o");
		hstujmbdata.put("N", "p");
		hstujmbdata.put("y", "q");
		hstujmbdata.put("J", "r");
		hstujmbdata.put("2", "s");
		hstujmbdata.put("n", "t");
		hstujmbdata.put("X", "u");
		hstujmbdata.put("E", "v");
		hstujmbdata.put("t", "w");
		hstujmbdata.put("Y", "x");
		hstujmbdata.put("5", "y");
		hstujmbdata.put("d", "z");
		hstujmbdata.put("Z", "A");
		hstujmbdata.put("6", "B");
		hstujmbdata.put("G", "C");
		hstujmbdata.put("h", "D");
		hstujmbdata.put("u", "E");
		hstujmbdata.put("1", "F");
		hstujmbdata.put("O", "G");
		hstujmbdata.put("e", "H");
		hstujmbdata.put("T", "I");
		hstujmbdata.put("r", "J");
		hstujmbdata.put("v", "K");
		hstujmbdata.put("o", "L");
		hstujmbdata.put("U", "M");
		hstujmbdata.put("7", "N");
		hstujmbdata.put("p", "O");
		hstujmbdata.put("L", "P");
		hstujmbdata.put("f", "Q");
		hstujmbdata.put("H", "R");
		hstujmbdata.put("z", "S");
		hstujmbdata.put("s", "T");
		hstujmbdata.put("B", "U");
		hstujmbdata.put("8", "V");
		hstujmbdata.put("g", "W");
		hstujmbdata.put("P", "X");
		hstujmbdata.put("0", "Y");
		hstujmbdata.put("i", "Z");


		for (int icount=0; icount<strdata.length(); icount++){
			String strchar = ""+(strdata.charAt(icount));
			strnewdata = strnewdata.append(hstujmbdata.get(strchar));
		}

		strdata = strnewdata.toString();
		return strdata;
	}


	public String encodeData(String strdata){

		Hashtable hstencdata = new Hashtable();
		StringBuffer strnewdata = new StringBuffer("");

		hstencdata.put("0", "!?");
		hstencdata.put("1", "!@");
		hstencdata.put("2", "!#");
		hstencdata.put("3", "!$");
		hstencdata.put("4", "!%");
		hstencdata.put("5", "!:");
		hstencdata.put("6", "!(");
		hstencdata.put("7", "!)");
		hstencdata.put("8", "!=");
		hstencdata.put("9", "!|");
		hstencdata.put("a", "`<");
		hstencdata.put("b", "`>");
		hstencdata.put("c", "`?");
		hstencdata.put("d", "`~");
		hstencdata.put("e", "`{");
		hstencdata.put("f", "`]");
		hstencdata.put("g", "`}");
		hstencdata.put("h", "`[");
		hstencdata.put("i", "`^");
		hstencdata.put("j", "`!");
		hstencdata.put("k", "@`");
		hstencdata.put("l", "@~");
		hstencdata.put("m", "@#");
		hstencdata.put("n", "@$");
		hstencdata.put("o", "@%");
		hstencdata.put("p", "@^");
		hstencdata.put("q", "@!");
		hstencdata.put("r", "@(");
		hstencdata.put("s", "@|");
		hstencdata.put("t", "@]");
		hstencdata.put("u", "^`");
		hstencdata.put("v", "^~");
		hstencdata.put("w", "^!");
		hstencdata.put("x", "^@");
		hstencdata.put("y", "^#");
		hstencdata.put("z", "^(");
		hstencdata.put("A", "^)");
		hstencdata.put("B", "^=");
		hstencdata.put("C", "^|");
		hstencdata.put("D", "^?");
		hstencdata.put("E", ":`");
		hstencdata.put("F", ":~");
		hstencdata.put("G", ":!");
		hstencdata.put("H", ":<");
		hstencdata.put("I", ":?");
		hstencdata.put("J", ":^");
		hstencdata.put("K", ":@");
		hstencdata.put("L", ":#");
		hstencdata.put("M", ":%");
		hstencdata.put("N", ":[");
		hstencdata.put("O", ":=");
		hstencdata.put("P", "|`");
		hstencdata.put("Q", "|~");
		hstencdata.put("R", "|:");
		hstencdata.put("S", "|<");
		hstencdata.put("T", "|?");
		hstencdata.put("U", "|@");
		hstencdata.put("V", "|#");
		hstencdata.put("W", "|%");
		hstencdata.put("X", "|,");
		hstencdata.put("Y", "|$");
		hstencdata.put("Z", "|{");


		for (int icount=0; icount<strdata.length(); icount++){
			String strchar = ""+(strdata.charAt(icount));
			strnewdata = strnewdata.append(hstencdata.get(strchar));
		}

		strdata = strnewdata.toString();
		return strdata;
	}


	public String decodeData(String strdata){

		Hashtable hstdecdata = new Hashtable();
		StringBuffer strnewdata = new StringBuffer("");

		hstdecdata.put("!?", "0");
		hstdecdata.put("!@", "1");
		hstdecdata.put("!#", "2");
		hstdecdata.put("!$", "3");
		hstdecdata.put("!%", "4");
		hstdecdata.put("!:", "5");
		hstdecdata.put("!(", "6");
		hstdecdata.put("!)", "7");
		hstdecdata.put("!=", "8");
		hstdecdata.put("!|", "9");
		hstdecdata.put("`<", "a");
		hstdecdata.put("`>", "b");
		hstdecdata.put("`?", "c");
		hstdecdata.put("`~", "d");
		hstdecdata.put("`{", "e");
		hstdecdata.put("`]", "f");
		hstdecdata.put("`}", "g");
		hstdecdata.put("`[", "h");
		hstdecdata.put("`^", "i");
		hstdecdata.put("`!", "j");
		hstdecdata.put("@`", "k");
		hstdecdata.put("@~", "l");
		hstdecdata.put("@#", "m");
		hstdecdata.put("@$", "n");
		hstdecdata.put("@%", "o");
		hstdecdata.put("@^", "p");
		hstdecdata.put("@!", "q");
		hstdecdata.put("@(", "r");
		hstdecdata.put("@|", "s");
		hstdecdata.put("@]", "t");
		hstdecdata.put("^`", "u");
		hstdecdata.put("^~", "v");
		hstdecdata.put("^!", "w");
		hstdecdata.put("^@", "x");
		hstdecdata.put("^#", "y");
		hstdecdata.put("^(", "z");
		hstdecdata.put("^)", "A");
		hstdecdata.put("^=", "B");
		hstdecdata.put("^|", "C");
		hstdecdata.put("^?", "D");
		hstdecdata.put(":`", "E");
		hstdecdata.put(":~", "F");
		hstdecdata.put(":!", "G");
		hstdecdata.put(":<", "H");
		hstdecdata.put(":?", "I");
		hstdecdata.put(":^", "J");
		hstdecdata.put(":@", "K");
		hstdecdata.put(":#", "L");
		hstdecdata.put(":%", "M");
		hstdecdata.put(":[", "N");
		hstdecdata.put(":=", "O");
		hstdecdata.put("|`", "P");
		hstdecdata.put("|~", "Q");
		hstdecdata.put("|:", "R");
		hstdecdata.put("|<", "S");
		hstdecdata.put("|?", "T");
		hstdecdata.put("|@", "U");
		hstdecdata.put("|#", "V");
		hstdecdata.put("|%", "W");
		hstdecdata.put("|,", "X");
		hstdecdata.put("|$", "Y");
		hstdecdata.put("|{", "Z");


		int intdataln = strdata.length();
		int icount=0;
		while (icount<intdataln) {
			String strchar = strdata.substring(icount, icount+2);
			strnewdata = strnewdata.append(hstdecdata.get(strchar));
			icount = icount + 2;
		}

		strdata = strnewdata.toString();
		return strdata;
	}

	public String formatAmt(String inamt){
		String strMinus = "";
		String strDot = "";
		if (inamt.charAt(0)=='-')
		{
			strMinus="-";
			inamt = inamt.substring(1);

		}
		if (inamt.indexOf('.') > -1)
		{
			inamt = inamt.substring(0, inamt.indexOf('.'));
			strDot=inamt.substring(inamt.indexOf('.'));
		}
				/***	 - 2 3 0,0 . 0 0
						 0 1 2 3 4 5 6 7       =len=8

						 0 1 2 3
						 - 9 9 7
			    *****/
		int len = inamt.length();
        String outamt = inamt;

		if(len > 3)
		{
			outamt = inamt.substring(0,len - 3)+","+inamt.substring(len-3);
		}
		if(len > 5)
		{
			outamt = outamt.substring(0,len - 5)+","+outamt.substring(len-5);
		}
		if(len > 7)
		{
			outamt = outamt.substring(0,len - 7)+","+outamt.substring(len-7);
		}
		return strMinus+outamt+strDot;
	}

/*This Function Will Input the Double Number and Return the Rounded Double Number upto the precesion value*/
	



    public static String RoundAmt(double inamt,int precision){

		String strAmt = "";
		precision+=1;

		strAmt = String.valueOf(inamt);
		int len = strAmt.length();

		if ((strAmt.indexOf(".")==0) || ((strAmt.length() - strAmt.indexOf(".")) <= precision))
		{
			return ""+inamt;
		}

		strAmt = strAmt.substring(0, strAmt.indexOf(".")+precision+1);
		System.out.println("substringed : "+strAmt);
		int intRound = Integer.valueOf((""+strAmt.charAt(strAmt.length()-1))).intValue() ;
		System.out.println("round : "+intRound);

		strAmt=strAmt.substring(0,strAmt.length()-1);
		if (intRound >= 5)
		{
			double dt=1/(Math.pow(10,precision-1));
			System.out.println("tersting the power :"+dt);
			strAmt=String.valueOf(Double.parseDouble(strAmt) + dt);
			return(strAmt.substring(0,strAmt.indexOf(".")+precision+1));

		}
		else
		{
			return(strAmt.substring(0,strAmt.indexOf(".")+precision));

		}

	}

    
    
 /******* This Function replace all occurances of p_old String to p_new String in p_text String. *******/
    

	public String strReplace(String p_text, String p_old, String p_new){
		String strTemp = "";
		int textlength = p_text.length();
		if (textlength > 0){
			int intp_new_length	= p_new.length();
			int intp_old_length	= p_old.length();
			int intStartIndex	= 0;
			int intEndIndex		= p_text.indexOf(p_old);
			while (intEndIndex != -1){
				intStartIndex	= 0;
				strTemp = p_text.substring(intStartIndex,intEndIndex);
				intStartIndex = intEndIndex + intp_old_length;
				p_text = strTemp + p_new + p_text.substring(intStartIndex);
				intStartIndex = intEndIndex + intp_new_length;
				intEndIndex = p_text.indexOf(p_old, intStartIndex);
			}
		}
		return p_text;
	}

public static String addZeroToCAP(int num)
{
	String strnum = ""+num;
	String outstr = strnum;
	int len = strnum.length();
	if(len<4)
	{
		for (int i=0; i<(4-len); i++)
		{
			outstr =	"0" + outstr;
		}
		return outstr;
	}
	else
		return outstr;
        
}



/******************************************************************
   * this method converts a tokenized string into a ArrayList
   * @param str, String, Input String
   * @param strSeparator, String, string separator
   * @return ArrayList
 ******************************************************************/




static public ArrayList getArrListFromTokenString(String str,String strSeparator)
{
	ArrayList arl = new ArrayList();
	StringTokenizer splitHidStrToken = new StringTokenizer(str,strSeparator);
		while (splitHidStrToken.hasMoreTokens()){
			String splitVal = (String) splitHidStrToken.nextToken();
			arl.add(splitVal);
		}
	return arl;
}

}