package com.chris.algorithm;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 18:25
 * Use for:
 */
public class Alg20190606 {
    public static void main(String[] args) {
        test1();
    }

    /**
     * 题目：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
     * 这是一个菲波拉契数列问题
     */
    private static void test1() {
        int f1 = 1, f2 = 1, f;
        int M = 30;
        System.out.println(2);
        System.out.println(2);
        for (int i = 3; i < M; i++) {
            f = f2;
            f2 = f1 + f2;
            f1 = f;
            System.out.println(f2);
        }
    }
}
