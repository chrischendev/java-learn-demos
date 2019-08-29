package com.chris.java8.framework.lombok;

import com.google.gson.Gson;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.logging.Level;

/**
 * create by: Chris Chan
 * create on: 2019/7/31 8:22
 * use for:
 */
@Log
public class LombokTest {
    private static Gson gson = new Gson();

    public static void main(String[] args) {
        test03();
    }

    /**
     * 测试 @Builder
     */
    private static void test03() {
        User1 user1 = User1.builder()
                .name("kaly")
                .age(41)
                .address("上海浦东")
                .info("初来乍到")
                .password("妈咪妈咪哄")
                .build();
        System.out.println(gson.toJson(user1));
        log.log(Level.INFO,"用户 ",gson.toJson(user1));//???
    }

    /**
     * 测试方法流
     */
    private static void test02() {
        User user = new User()
                .name("chris")
                .age(40)
                .address("上海杨浦")
                .info("陕籍沪漂")
                .password("芝麻开门");
        System.out.println(gson.toJson(user));
        System.out.println(user.address);
    }

    /**
     * 测试 @Value
     */
    private static void test01() {
        Student student1 = new Student("kaly", 41, "一班");
        Student student2 = new Student("kaly", 41, "一班");
        Student student3 = student1;

        System.out.println(student1.equals(student2));
        System.out.println(student1 == student2);
        System.out.println(student1 == student3);


    }
}
