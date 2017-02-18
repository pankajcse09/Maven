 /*
 * datediff.java
 *
 * Created on September 19, 2008, 5:06 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.myapp.struts;

import java.util.*;
import java.text.*;
/**
 *
 * @author arjun
 */
public class datediff
{

public static ArrayList getDatesBetween(Date fromDate, Date toDate) {
Calendar calendar = Calendar.getInstance();
ArrayList dateList = new ArrayList();
if (fromDate.before(toDate)) {
Date dateCounter = fromDate;
dateList.add(fromDate);
while (dateCounter.before(toDate)) {
calendar.setTime(dateCounter);
int nextDate = calendar.get(Calendar.DATE) + 1;
calendar.set(Calendar.DATE, nextDate);
dateCounter = calendar.getTime();
dateList.add(dateCounter);
}
}else if(!fromDate.before(toDate) && !fromDate.after(toDate)){
dateList.add(fromDate);
}
return dateList;
} 
}