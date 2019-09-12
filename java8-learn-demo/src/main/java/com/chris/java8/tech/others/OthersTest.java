package com.chris.java8.tech.others;

/**
 * create by: Chris Chan
 * create on: 2019/9/11 4:11
 * use for:
 */
public class OthersTest {
    public static void main(String[] args) {
        test01();
    }

    private static void test01() {
        B b=new B();
        System.out.println(b.age);
        System.out.println(A.age);
    }
}


interface A{
    int age = 0;
}

class B implements A{
    public B() {
    }
}