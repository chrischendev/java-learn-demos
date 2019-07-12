package com.chris.java8.tech.stream;

import com.chris.java8.utils.GsonUtils;
import com.google.gson.Gson;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * create by: Chris Chan
 * create on: 2019/6/11 21:06
 * use for:
 */
public class StreamTest {
    public static void main(String[] args) {
        test9();
    }

    /**
     * 去重
     */
    private static void test9() {
        List<UserModel> userModelList = new ArrayList<>();
        userModelList.add(new UserModel(1, "kaly", 12));
        userModelList.add(new UserModel(1, "kaly chen", 42));
        UserModel chris = new UserModel(2, "chris", 12);
        userModelList.add(chris);
        userModelList.add(chris);
        userModelList.add(new UserModel(2, "chris", 12));
        userModelList.add(new UserModel(3, "chris chen", 12));
        userModelList.add(new UserModel(4, "chenfabao", 12));
        userModelList.add(new UserModel(5, "fabio", 12));
        userModelList.add(new UserModel(6, "will chan", 12));

        //直接去重
        System.out.println("直接去重");
        List<UserModel> userModelList1 = userModelList.stream().distinct().collect(Collectors.toList());
        userModelList1.stream().forEach(userModel -> System.out.println(GsonUtils.gson.toJson(userModel)));

        System.out.println("据其中一个字段id去重");
        //根据其中一个字段id去重
        List<UserModel> userModelList2 = userModelList.stream().filter(distinctByKey(userModel -> userModel.getId())).collect(Collectors.toList());
        userModelList2.stream().forEach(userModel -> System.out.println(GsonUtils.gson.toJson(userModel)));

        System.out.println("据其中一个字段id去重");
        //据其中一个字段name去重
        ArrayList<UserModel> userModels = userModelList.stream().collect(Collectors.collectingAndThen(
                Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(UserModel::getName))), ArrayList::new));
        userModels.stream().forEach(userModel -> System.out.println(GsonUtils.gson.toJson(userModel)));
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        System.out.println("这个函数将应用到每一个item");
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
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
        Stream.of(names).forEach(name -> System.out.println(name));
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
