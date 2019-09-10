package com.chris.java8.tech.stack;

import com.google.gson.Gson;

import java.util.Stack;

/**
 * create by: Chris Chan
 * create on: 2019/8/26 10:55
 * use for:
 */
public class StackTest {
    private static Gson gson = new Gson();

    public static void main(String[] args) {
        test01();
    }

    private static void test01() {
        Stack<String> stack = new Stack<>();

        stack.push("消息01"); //入栈
        stack.push("消息02");
        stack.push("消息03");
        stack.push("消息04");
        stack.push("消息05");

        System.out.println(gson.toJson(stack));
        System.out.println(stack.get(0));
        System.out.println(stack.pop()); //出栈 后进先出
        System.out.println(gson.toJson(stack));
    }
}
