package com.chris.java8.queue;

import com.google.gson.Gson;

import java.util.ArrayDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * create by: Chris Chan
 * create on: 2019/8/26 0:35
 * use for:
 */
public class QueueTest {
    private static Gson gson = new Gson();

    public static void main(String[] args) throws Exception {
        testLinkedBlockingDeque();
    }

    private static void testLinkedBlockingDeque() throws InterruptedException {
        LinkedBlockingDeque<String> linkedBlockingDeque = new LinkedBlockingDeque<>();

        linkedBlockingDeque.add("消息01"); //添加到尾部
        linkedBlockingDeque.add("消息02");
        linkedBlockingDeque.add("消息03");
        linkedBlockingDeque.put("消息04"); //添加到尾部
        linkedBlockingDeque.push("消息05"); //入栈

        System.out.println(gson.toJson(linkedBlockingDeque));

        System.out.println(linkedBlockingDeque.poll()); //出栈

        System.out.println(gson.toJson(linkedBlockingDeque));

        System.out.println(linkedBlockingDeque.pop()); //出栈

        System.out.println(gson.toJson(linkedBlockingDeque));
    }

    private static void testArrayDeque() {
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.add("消息01"); //添加到尾部
        arrayDeque.add("消息02");
        arrayDeque.add("消息03");
        arrayDeque.push("消息04"); //添加到头部

        System.out.println(gson.toJson(arrayDeque));

        System.out.println(arrayDeque.poll()); //出栈

        System.out.println(gson.toJson(arrayDeque));
    }
}
