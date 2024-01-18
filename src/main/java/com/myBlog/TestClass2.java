package com.myBlog;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestClass2 {

    public static void main(String[] args) {

//        Examples on .Sorted() method

//        to sort them in descending order.


        List<Integer> numbers = Arrays.asList(1, 5, 8, 9, 5, 2, 2, 3, 4);
        List<Integer> newNumbers = numbers.stream().sorted((a,b)->b.compareTo(a)).collect(Collectors.toList());
        System.out.println("Given List:"+numbers);
        System.out.println("New Numbers:"+newNumbers);


    }
}
