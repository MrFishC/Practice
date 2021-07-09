package com.code.a05_java_demo;

import com.code.a05_java_demo.generic.Person;

public class MyClass {

    //泛型方法1
    public <T> String getName(Person<T> t){
        return "";
    }

    //泛型方法2
    public <E> void setAge(E e){

    }

}