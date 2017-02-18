/*
 * dateDiff.java
 *
 * Created on April 26, 2008, 11:52 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package schedule;

import java.util.*;
/** DateDiff -- compute the difference between two dates.
 */
class dateDiff
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