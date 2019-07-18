package com.chris.java8.tech.stringjoiner;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * @author chrischan
 * create on 2019\7\18 0018 15:06
 * use for:
 */
public class StringJoinerTest {
    public static void main(String[] args) {
        test02();
    }

    private static void test03() {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");

        stringJoiner.add("北京").add("上海").add("天津");
        System.out.println(stringJoiner.toString());
    }

    /**
     * 这个属于String
     */
    private static void test02() {
        String names[] = {"陈凯利", "孙菲菲", "姚诗涵"};
        String join = String.join("-", Arrays.asList(names));
        System.out.println(join);
    }

    private static void test01() {
        StringJoiner stringJoiner = new StringJoiner("");

        stringJoiner.add("北京").add("上海").add("天津");
        System.out.println(stringJoiner.toString());

    }
}
