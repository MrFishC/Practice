package com.code.a05_java_demo.generic;

import javafx.util.Pair;

/**
 * @创建者 Jack
 * @创建时间 2021/7/5 18:17
 * @描述 泛型类
 */
public class Person<T> {
    private T first;
    private T second;

    public Person() {
    }

    public Person(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }

}
