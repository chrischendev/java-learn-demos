package com.chris.java8.tech.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

/**
 * create by: Chris Chan
 * create on: 2019/6/7 6:37
 * use for: Java8中时间的处理方式
 */
public class DataTimeTest {
    public static void main(String[] args) {
        test4();
    }

    /**
     * 其他用法
     */
    private static void test4() {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        LocalDate today = LocalDate.now();

        System.out.println(now.getLong(ChronoField.MINUTE_OF_DAY));
        System.out.println(now.getLong(ChronoField.MINUTE_OF_HOUR));
        System.out.println(now.getDayOfMonth());
        System.out.println(today.isLeapYear());//是不是闰年
        System.out.println(now.atZone(ZoneId.systemDefault()).toInstant().plusMillis(TimeUnit.HOURS.toMillis(8)).toEpochMilli());//毫秒数
        System.out.println(now.toInstant(ZoneOffset.of("+8")).toEpochMilli());//毫秒数
    }

    /**
     * 其他用法
     */
    private static void test3() {
        LocalDateTime myBirthday = LocalDateTime.of(1978, 7, 28, 12, 0, 0);
        LocalDateTime loveBirthday = LocalDateTime.of(1981, Month.FEBRUARY, 21, 12, 0, 0);

        System.out.println(myBirthday);
        System.out.println(loveBirthday);
        System.out.println(loveBirthday.isBefore(myBirthday));
        System.out.println(loveBirthday.isAfter(myBirthday));
        System.out.println(ChronoUnit.YEARS.between(myBirthday, loveBirthday));
        System.out.println(ChronoUnit.MONTHS.between(myBirthday, loveBirthday));
        System.out.println(ChronoUnit.DAYS.between(myBirthday, loveBirthday));
        System.out.println(ChronoUnit.HOURS.between(myBirthday, loveBirthday));
        System.out.println(ChronoUnit.MINUTES.between(myBirthday, loveBirthday));
        System.out.println(ChronoUnit.SECONDS.between(myBirthday, loveBirthday));
        System.out.println(ChronoUnit.MILLIS.between(myBirthday, loveBirthday));

    }

    /**
     * 格式化
     */
    private static void test2() {
        DateTimeFormatter fmt1 = DateTimeFormatter.BASIC_ISO_DATE;
        DateTimeFormatter fmt2 = DateTimeFormatter.ISO_DATE;
        DateTimeFormatter fmt3 = DateTimeFormatter.ISO_TIME;
        DateTimeFormatter fmt4 = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter fmt5 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        DateTimeFormatter fmt6 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDateTime now = LocalDateTime.now();
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        System.out.println(fmt1.format(now));
        System.out.println(fmt2.format(date));
        System.out.println(fmt3.format(time));
        System.out.println(fmt4.format(now));
        System.out.println(fmt5.format(now));
        System.out.println("解析时间: " + LocalDate.parse("1978-07-28", fmt6).getYear());

        System.out.println();
        System.out.println("另一种格式化方式");

        System.out.println(now.format(fmt1));
        System.out.println(date.format(fmt2));
        System.out.println(time.format(fmt3));
        System.out.println(now.format(fmt4));
        System.out.println(now.format(fmt5));
    }

    /**
     * 日期 时间 完整时间
     */
    private static void test1() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.toString());

        LocalDate date = LocalDate.now();
        System.out.println(date.toString());

        LocalTime time = LocalTime.now();
        System.out.println(time.toString());
    }
}
