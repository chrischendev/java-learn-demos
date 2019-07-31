package com.chris.java8.framework.lombok;

import lombok.Builder;
import lombok.NonNull;

/**
 * create by: Chris Chan
 * create on: 2019/7/31 8:26
 * use for:
 */
@Builder
public class User1 {
    @NonNull String name;
    @NonNull int age;
    public String address;
    String info;
    String password;
}
