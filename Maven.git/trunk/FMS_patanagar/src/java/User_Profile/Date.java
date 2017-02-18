

package User_Profile;
import java.util.*;
import java.sql.*;

public class Date
{
	/**
	 * protected calendar member.
	 * */
	GregorianCalendar calendar = new GregorianCalendar();
	
	/**
	 * Default constructor:<br>
	 * Initializes Date to current time.<br>
	*/
	public Date()
	{
		this(System.currentTimeMillis());
	}
	
	public Date(java.util.Calendar c)
	{
		calendar = (GregorianCalendar)c;
	}
	
	/**
	 * Initializes Date to specified time in milliseconds, it should be long.
	 * */
	public Date(long nMilliSeconds)
	{
		calendar.setTime(new java.util.Date(nMilliSeconds));
	}
	
	/**
	 * Initialize directly from java.util.Date, no worries just type in and you get it.
	 * */
	public Date(java.util.Date date)
	{
		this(date.getTime());
	}
	
	
	

	public Date(java.sql.Date date)
	{
		this(date.getTime());
	}
	
	public int getDay()
	{
         return calendar.get(Calendar.DAY_OF_MONTH);
	}
	
	
   public int getMonth()
	{
		return calendar.get(Calendar.MONTH)+1;
	}
	

	
 public int getYear()
	{
		return calendar.get(Calendar.YEAR);
	}
	
	public int getHours()
	{
		return calendar.get(Calendar.HOUR_OF_DAY);
	}
	
	public int getMinutes()
	{
		return calendar.get(Calendar.MINUTE);
	}
	
	
	public int getSeconds()
	{
		return calendar.get(Calendar.SECOND);
	}
	
	
	public int getWeekDay()
	{
		return calendar.get(Calendar.DAY_OF_WEEK);
	}
	
	public static String days[] = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
	public static String months[] = {"January","February","March","April","May","June","July","August","September","October","November","December"};
	
	
	public static String getWeekDay(int nDay)
	{
		return days[nDay-1];
	}
	
	public static String getMonthName(int nMonth)
	{
		return months[nMonth-1];
	}
	
	public String getLongDate()
	{
		String date;
		date = getWeekDay(getWeekDay());
		date += "    " + String.valueOf(getMonth());
		date += "/";
		date += String.valueOf(getDay());
		date += "/";
		date += String.valueOf(getYear());
		date += " ";
		date += String.valueOf(getHours());
		date += ":";
		date += String.valueOf(getMinutes());
		return date;
	}
	
	public String getCurrentLongDate()
	{
		String date;
		
		calendar.setTime(new java.util.Date(System.currentTimeMillis()));
		
		date = String.valueOf(getMonth());
		date += "/";
		date += String.valueOf(getDay());
		date += "/";
		date += String.valueOf(getYear());
		date += " ";
		date += String.valueOf(getHours());
		date += ":";
		date += String.valueOf(getMinutes());
		date += ":";
		date += String.valueOf(getSeconds());
		date += "  ";
		return date;
	}
	
	
	public void set(int nYear,int nMonth,int nDay,int nHour,int nMin,int nSec)
	{
		calendar.clear();
		calendar.set(nYear,nMonth,nDay,nHour,nMin,nSec);
	}
	
	public String getShortDate()
	{
		String date;
		date = String.valueOf(getMonth()) + "/";
		date += String.valueOf(getDay()) + "/";
		date += String.valueOf(getYear());
		return date;
	}
	
	public String getWeekDayString()
	{
		return getWeekDay(getWeekDay());
	}
	
	public String getShortWeekDay()
	{
		return getWeekDayString().substring(0,3);
	}
		
	public long getMilliSeconds()
	{
		return calendar.getTime().getTime();
	}
	
	public static String getSQLDate(Timestamp ts)
	{
		Date d = new Date(ts.getTime());
		String text;
		text = String.valueOf(d.getMonth());
		text += "/" + String.valueOf(d.getDay());
		text += "/" + String.valueOf(d.getYear());
		text += " " + String.valueOf(d.getHours());
		text += ":" + String.valueOf(d.getMinutes());
		text += ":" + String.valueOf(d.getSeconds());
		return text;
	}
	
	public static Timestamp getDate(javax.servlet.http.HttpServletRequest request,String name)
	{
		String text,param = request.getParameter(name+"_Year");
		if(param==null)
			throw new NullPointerException(name+"_Year parameter not in request");
		text = param;
		param = request.getParameter(name+"_Month");
		if(param==null)
			throw new NullPointerException(name+"_Month parameter not in request");
		text +="-" +  param;
		param = request.getParameter(name+"_Day");
		if(param==null)
			throw new NullPointerException(name+"_Day parameter not in request");
		text +="-" +  param;
		text += " 00:00:00.00000000";
		return Timestamp.valueOf(text);
	}

	public static Timestamp getTimestamp(javax.servlet.http.HttpServletRequest request,String name)
	{
		String text,param = request.getParameter(name+"_Year");
		if(param==null)
			throw new NullPointerException(name+"_Year parameter not in request");
		text = param;
		param = request.getParameter(name+"_Month");
		if(param==null)
			throw new NullPointerException(name+"_Month parameter not in request");
		text +="-" +  param;
		param = request.getParameter(name+"_Day");
		if(param==null)
			throw new NullPointerException(name+"_Day parameter not in request");
		text +="-" +  param;
		param = request.getParameter(name+"_Hour");
		if(param==null)
			throw new NullPointerException(name+"_Hour parameter not in request");
		text +=" " +  param;
		param = request.getParameter(name+"_Min");
		if(param==null)
			throw new NullPointerException(name+"_Min parameter not in request");
		text +=":" +  param;
		text += ":00.00000000";
		return Timestamp.valueOf(text);
	}






}
