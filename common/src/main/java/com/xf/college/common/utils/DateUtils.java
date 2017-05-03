/*
 * Copyright 2014 NAVER Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xf.college.common.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public final class DateUtils {

    private static final ThreadLocal<DateFormat> CACHE = new ThreadLocal<DateFormat>() {
        @SuppressWarnings("unused")
        private final String name = DateUtils.class.getName();

        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat(FORMAT);
        }
    };

    public static final String FORMAT = "yyyy-MM-dd HH:mm:ss SSS";
    public static final String DAY_FORMAT = "yyyy-MM-dd";

    private DateUtils() {
    }

    public static String longToDateStr(long date) {
        final DateFormat dateFormat = CACHE.get();
        return dateFormat.format(date);
    }

    public static String longToDateStr(long date, String fmt) {
        String pattern = (fmt == null) ? FORMAT : fmt;
        final SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(new Date(date));
    }
    public static String formatDate(Date date,String fmt) {
         String pattern = (fmt == null) ? FORMAT : fmt;
         final SimpleDateFormat format = new SimpleDateFormat(pattern);
         return format.format(date);
    }

    public static long timestampToMidNight(long timestamp) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date(timestamp));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTime().getTime();
    }
    @Deprecated
    public static LocalDate ofLocalDte (Long timeStamp) {
        if (timeStamp==null) {
            return LocalDate.now();
        }
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(timeStamp), TimeZone
                .getDefault().toZoneId()).toLocalDate();
    }
    public static LocalDate ofLocalDte (Date date) {
        if (date==null) {
            return LocalDate.now();
        }
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

}
