package com.flyin.example.service;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author 王军
 * @description
 * @date 2022/1/7 14:53
 */
public class PredicateConsumerUtil {

    public static <T> T successRun(T data, Predicate<T> predicate, Consumer<T> consumer) {
        if (predicate.test(data)) {
            consumer.accept(data);
        }
        return data;
    }

    public static <T> T run(T data, Predicate<T> predicate, Consumer<T> successRun,Consumer<T> failureRun) {
        if (predicate.test(data)) {
            successRun.accept(data);
        } else {
            failureRun.accept(data);
        }
        return data;
    }
}