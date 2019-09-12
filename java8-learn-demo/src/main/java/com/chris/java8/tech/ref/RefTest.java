package com.chris.java8.tech.ref;

import java.lang.reflect.Type;
import java.util.List;

/**
 * create by: Chris Chan
 * create on: 2019/9/9 0:29
 * use for:
 */
public class RefTest {
    public static void main(String[] args) {
        test01();
    }

    /**
     * 本义是想获取泛型参数。以及修改泛型参数的类型，但是好像不成功
     */
    private static void test01() {
        Class<List> aClass = List.class;

        Type[] genericInterfaces = aClass.getGenericInterfaces();

        System.out.println(genericInterfaces[0].getTypeName());
    }
}
