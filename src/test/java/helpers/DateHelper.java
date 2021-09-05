package helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {
    public static final DateFormat defaultDateFormat = new SimpleDateFormat("dd MMMM, yyyy");

    public static String addDaysToDate(Date originalDate, int toAdd, int timeUnit, DateFormat dateFormat) throws Exception {

        // convert date to calendar
        Calendar c = Calendar.getInstance();
        c.setTime(originalDate);
        c.add(timeUnit, toAdd);

        // convert calendar to date
        Date currentDatePlusOne = c.getTime();
        return dateFormat.format(currentDatePlusOne);
    }

    public static String addDaysToDate(Date originalDate, int toAdd, int timeUnit) throws Exception {
        return addDaysToDate(originalDate, toAdd, timeUnit, defaultDateFormat);
    }

    public static String addDaysToDate(int toAdd, int timeUnit) throws Exception {
        return addDaysToDate(new Date(), toAdd, timeUnit, defaultDateFormat);
    }
}
