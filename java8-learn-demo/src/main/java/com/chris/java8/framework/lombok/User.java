package com.chris.java8.framework.lombok;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

/**
 * create by: Chris Chan
 * create on: 2019/7/31 8:26
 * use for:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Accessors(fluent = true)
public class User {
    @NonNull String name;
    @NonNull int age;
    public String address;
    String info;
    String password;
}
