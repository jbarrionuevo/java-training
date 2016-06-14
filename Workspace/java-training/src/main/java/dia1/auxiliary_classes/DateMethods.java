package dia1.auxiliary_classes;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;

public class DateMethods {
	public static int differenceBetweenDates(Date d1, Date d2){
		DateTime startDate = new DateTime(d1);
	    DateTime endDate = new DateTime(d2);
		Days d = Days.daysBetween(startDate, endDate);
	    return d.getDays();
	}
}
