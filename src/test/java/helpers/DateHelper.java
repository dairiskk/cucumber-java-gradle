package helpers;

import java.lang.invoke.StringConcatFactory;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateHelper {
    public static final DateFormat defaultDateFormat = new SimpleDateFormat("dd MMMM, yyyy");

    public static Date addDaysToDate(Date originalDate, int toAdd, int timeUnit, DateFormat dateFormat) throws Exception {

        // convert date to calendar
        Calendar c = Calendar.getInstance();
        c.setTime(originalDate);
        c.add(timeUnit, toAdd);

        // convert calendar to date
        Date currentDatePlusOne = c.getTime();
        return currentDatePlusOne;
    }

    public static Date addDaysToDate(Date originalDate, int toAdd, int timeUnit) throws Exception {
        return addDaysToDate(originalDate, toAdd, timeUnit, defaultDateFormat);
    }

    public static Date addDaysToDate(int toAdd, int timeUnit) throws Exception {
        return addDaysToDate(new Date(), toAdd, timeUnit, defaultDateFormat);
    }

    public static long dateToMilliSeconds(String myDate, String dateFormat) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = sdf.parse(myDate);
        return date.getTime();
    }

    public static String getPartOfDate(Date date, int partToGet){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return String.valueOf(calendar.get(partToGet));
    }
}
