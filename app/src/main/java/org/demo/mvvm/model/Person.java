package org.demo.mvvm.model;

/**
 * create by TIAN FENG on 2020/3/10
 */
public class Person {

    public String name;

    public Person(String s) {
        name = s;
    }

    @Override
    public String toString() {
        return "Person{" + '\'' +
                "name='" + name + '\'' +
                '}';
    }
}
