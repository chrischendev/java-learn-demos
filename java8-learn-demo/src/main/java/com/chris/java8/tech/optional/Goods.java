package com.chris.java8.tech.optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author chrischan
 * create on 2019\7\18 0018 9:18
 * use for:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods implements Serializable {
    private Car car;
    private List<Car> carList;
}
