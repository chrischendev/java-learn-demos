package com.chris.java8.tech.collection.linkedlist;

import com.google.gson.Gson;

import java.util.LinkedList;

/**
 * create by: Chris Chan
 * create on: 2019/8/26 10:20
 * use for:
 */
public class LinkedListTest {
    public static void main(String[] args) {
        testLinkedList();
    }

    private static void testLinkedList() {
        //LinkedList就是一个队列
        LinkedList<String> linkedList=new LinkedList<>();
        linkedList.add("元素1");//在尾部添加 队列操作
        linkedList.add("元素2");
        linkedList.add("元素3");
        linkedList.add("元素4");
        linkedList.push("元素5");//在头部添加 栈操作
        linkedList.push("元素6");

        System.out.println(new Gson().toJson(linkedList));

        System.out.println(linkedList.poll());
        System.out.println(linkedList.poll());
        System.out.println(linkedList.poll());
        System.out.println(linkedList.poll());
        System.out.println(linkedList.poll());
    }
}
