package com.chris.java8.tech.optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author chrischan
 * create on 2019\7\18 0018 9:11
 * use for:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private String name;
    private int age;
    private Goods goods;
}
