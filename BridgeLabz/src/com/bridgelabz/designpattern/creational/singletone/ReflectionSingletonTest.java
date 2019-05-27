package com.bridgelabz.designpattern.creational.singletone;

import java.lang.reflect.Constructor;

public class ReflectionSingletonTest {
public static void main(String[] args) {
	EagerInitialization instanceOne = EagerInitialization.getInstance();
    EagerInitialization instanceTwo = null;
    try {
        @SuppressWarnings("rawtypes")
		Constructor[] constructors = EagerInitialization.class.getDeclaredConstructors();
        for (@SuppressWarnings("rawtypes") Constructor constructor : constructors) {
            //Below code will destroy the singleton pattern
            constructor.setAccessible(true);
            instanceTwo = (EagerInitialization) constructor.newInstance();
            break;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    instanceOne.message("instanceOne");
    instanceTwo.message("instanceTwo");
    System.out.println(instanceOne.hashCode());
    System.out.println(instanceTwo.hashCode());
}
}
