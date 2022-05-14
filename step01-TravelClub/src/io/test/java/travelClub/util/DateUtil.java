package io.test.java.travelClub.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author kwon-yongho
 */
public class DateUtil {

    public static String today(String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format((Calendar.getInstance().getTime()));
    }

    public static String today() {
        return today("yyyy.MM.dd");
    }
}
