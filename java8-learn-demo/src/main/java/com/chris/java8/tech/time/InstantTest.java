package com.chris.java8.tech.time;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

/**
 * create by: Chris Chan
 * create on: 2019/6/7 7:17
 * use for: 关于Instant的测试练习
 */
public class InstantTest {
    public static void main(String[] args) {
        test2();
    }

    private static void test2() {
        DateTimeFormatter fmt=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Instant now=Instant.now().plusMillis(TimeUnit.HOURS.toMillis(8));
        Instant now1=Instant.now().plus(8, ChronoUnit.HOURS);

        System.out.println(now1);
        System.out.println(now1.getEpochSecond());
        System.out.println(now1.toEpochMilli());

    }

    private static void test1() {
        Instant now=Instant.now();

        System.out.println(now);
    }
}
