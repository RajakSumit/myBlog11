package com.myBlog;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestClass1 {

    public static void main(String[] args) {

        List<String> Names = Arrays.asList("Amit", "Sumit", "Rahul", "Arbaaz", "Romit", "Deepak", "Rohit");
        List<String> data1 = Names.stream().filter(s -> s.startsWith("S")).collect(Collectors.toList());
        List<String> data2 = Names.stream().filter(s -> s.endsWith("t")).collect(Collectors.toList());
        System.out.println(data1);
        System.out.println(data2);


    }


}
