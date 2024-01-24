package com.myBlog;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestClass2 {

    public static void main(String[] args) {

//        Examples on .Sorted() method
//
//        to sort them in descending order.


//        List<Integer> numbers = Arrays.asList(1, 5, 8, 9, 5, 2, 2, 3, 4);
//        List<Integer> newNumbers = numbers.stream().sorted((a,b)->b.compareTo(a)).collect(Collectors.toList());
//        System.out.println("Given List:"+numbers);
//        System.out.println("New Numbers:"+newNumbers);


//        List<Employee> employees = Arrays.asList(
//                new Employee("sumit", 30, "banglore"),
//                new Employee("aman", 35, "banglore"),
//                new Employee("sonu", 30, "bandel"),
//                new Employee("prince", 25, "kolkata"),
//                new Employee("john", 31, "kolkata"),
//                new Employee("sumit", 30, "banglore")
//        );
//
//        List<Employee> emps = employees.stream().filter(emp -> emp.getAge() > 30).collect(Collectors.toList());
//
//        for (Employee e : emps){
//            System.out.println(e.getName());
//            System.out.println(e.getCity());
//            System.out.println(e.getAge());
//
//        }

        
//            find the letters which contains letter "h"
        List<String> names = Arrays.asList("aman", "raj", "rahul");
        List<String> newnames = names.stream().filter(nme -> nme.contains("h")).collect(Collectors.toList());
        System.out.println(newnames);


    }
}
