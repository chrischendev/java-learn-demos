package com.chris.java8.tech.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author chrischan
 * create on 2019\7\18 0018 9:06
 * use for:
 */
public class OptionalTest {
    public static void main(String[] args) {
        test4();
    }

    private static void test5() {
        /*
        从Optional中取值，有可能为空
         */
        User user=null;
        Optional<User> optionalUser = Optional.ofNullable(user);
        optionalUser.ifPresent(user1 -> System.out.println(user1.getName()));
        //System.out.println(user1.getName());
    }

    private static void test4() {
        /*
        将对象用Optional包裹，如果对象或者子对象为空则不执行
         */
        Car audi = new Car("Audi", 300000);
        Car jili = new Car("Jili", 300000);
        Car changan = new Car("Changan", 300000);
        List<Car> carList=new ArrayList<>();
        carList.add(changan);
        carList.add(jili);
        User user = new User("Chris", 42, new Goods(audi,carList));
        Optional<User> optional = Optional.ofNullable(user);
        String carName = optional.map(User::getGoods)
                .map(Goods::getCarList)
                .map(cars -> cars.get(1))
                .map(Car::getName)
                .filter(carName1->carName1.length()>4)
                .orElse("bulck");
        System.out.println(carName);
    }

    private static void test3() {
        /*
        将对象用Optional包裹，如果对象或者子对象为空则不执行，或者用默认值替代
         */
        User user = new User(null, 42, null);
        String name = Optional.ofNullable(user)
                .map(User::getName)
                .orElse("kaly");
        System.out.println(name);
    }

    private static void test2() {
                /*
        将对象用optional包裹之后，不为空则执行，为空则抛NPE
         */
        String str = null;
        Optional.of(str).ifPresent(s -> {
            System.out.println(s + " end.");
        });
    }

    private static void test1() {
        /*
        将对象用optional包裹之后，不为空则执行，为空则忽略
         */
        String str = "test";
        Optional.ofNullable(str).ifPresent(s -> {
            System.out.println(s + " end.");
        });
    }
}
