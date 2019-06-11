package com.chris.java8.tech.stream;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * create by: Chris Chan
 * create on: 2019/6/11 21:06
 * use for:
 */
public class StreamTest {
    public static void main(String[] args) {
        test3();
    }

    private static void test8() {
        Stream.generate(() -> new UserModel(1, "姓名", 25, 4)).limit(10).forEach(userModel -> System.out.println(new Gson().toJson(userModel)));
    }

    /**
     * 排序
     */
    private static void test7() {
        getList().stream().sorted((o1, o2) -> o1.getAge() - o2.getAge() == 0 ? 0 : (o1.getAge() - o2.getAge()) / Math.abs(o1.getAge() - o2.getAge())).forEach(userModel -> System.out.println(new Gson().toJson(userModel)));
    }

    /**
     * 包含
     */
    private static void test6() {
        System.out.println(getList().stream().allMatch(userModel -> userModel.getAge() > 30));
    }

    /**
     * 并行流
     */
    private static void test5() {
        getList().parallelStream().forEach(userModel -> System.out.println(new Gson().toJson(userModel)));
    }

    /**
     * 聚合
     */
    private static void test4() {
        System.out.println(getList().stream().count());
        System.out.println(getList().stream().findFirst().get().getName());
        getList().stream().limit(10).forEach(userModel -> System.out.println(userModel.getName()));
        getList().stream().distinct().forEach(userModel -> System.out.println(userModel.getName()));
        System.out.println(new Gson().toJson(getList().stream().min((o1, o2) -> o1.getAge() - o2.getAge() == 0 ? 0 : (o1.getAge() - o2.getAge()) / Math.abs(o1.getAge() - o2.getAge())).get()));
    }

    /**
     * 数组转流
     */
    private static void test3() {
        String[] names = {"kaly", "chris", "fabio", "will"};
        //Arrays.stream(names).forEach(name -> System.out.println(name));
        Stream.of(names).forEach(name-> System.out.println(name));
    }

    /**
     * 过滤
     */
    private static void test2() {
        getList().stream().filter(userModel -> userModel.getId() > 10).forEach(userModel -> System.out.println(new Gson().toJson(userModel)));
    }

    /**
     * 简单遍历
     */
    private static void test1() {
        getList().stream().forEach(userModel -> System.out.println(new Gson().toJson(userModel)));
    }

    /**
     * 获取集合
     *
     * @return
     */
    private static List<UserModel> getList() {
        List<UserModel> userModelList = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            userModelList.add(new UserModel(i, "姓名" + i, new Random().nextInt(30) + 20, new Random().nextInt(9) + 1));
        }
        return userModelList;
    }
}
