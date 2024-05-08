package com.banco.crudspring.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ApplicationDates {

    public static final Timestamp DEFAULT_EXPIRY_TIMESTAMP;

    private ApplicationDates() {
    }

    public static Date sumaDias(Date date, Integer dias){
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.DATE, dias);
        return cal.getTime();
    }
    public static Timestamp getDBTimestamp() {
        return new Timestamp((new Date()).getTime());
    }

    static {
        try {
            SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd");
            Date a = fd.parse("2999-12-31");
            DEFAULT_EXPIRY_TIMESTAMP = new Timestamp(a.getTime());
        } catch (ParseException var2) {
            throw new RuntimeException(var2);
        }
    }

    public static Date timestampToDate(Timestamp fecha){
        Date date = java.sql.Date.valueOf(fecha.toLocalDateTime().toLocalDate());
        return date;
    }
}
