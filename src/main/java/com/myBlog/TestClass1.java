package com.myBlog;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestClass1 {

    public static void main(String[] args) {

//        int age = 15;
//
//        String status = (age>=20)?"Adult":"Minor";
//
//        System.out.println(status);


//        int [] numbers = {10,20,45,30,88};
//        for ( int num:numbers){
//            String message = (num%2==0)?"Even":"Odd";
//            System.out.println(num+ "is" +message);

//        }


//        String name = "john";
//        String message = (name!=null)?"Hello "+name:"Hello Guest";
//        System.out.println(message);

        // to find square Root of numbers
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
//        List<Integer> squaredNumbers = numbers.stream().map(i -> i * i).collect(Collectors.toList());
//        System.out.println("Original Numbers: " +numbers);
//        System.out.println("Squared Numbers: " +squaredNumbers);


       // to convert each string to uppercase

//        List<String> data = Arrays.asList("aman", "amar", "sumit", "rahul");
//        List<String> newData = data.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
//        System.out.println("Given List:" +data);
//        System.out.println("New List:" +newData);


//        to extract the length of each name

//        List<String> data = Arrays.asList("aman", "amar", "sumit", "rahul");
//        List<Integer> newData = data.stream().map(s -> s.length()).collect(Collectors.toList());
//        System.out.println("Given List:" +data);
//        System.out.println("New List:" +newData);

//        to convert each integer to its corresponding binary representation as a string

//        List<Integer> data = Arrays.asList(1, 2, 5, 66, 77, 4, 5, 6);
//        List<String> newData = data.stream().map(i -> i.toBinaryString(i.intValue())).collect(Collectors.toList());
//        System.out.println("Original Data:" +data);
//        System.out.println("Binary Data:" +newData);


//        List<Login> logins = Arrays.asList(
//                new Login("sumit", "testing"),
//                new Login("rahul", "testing"),
//                new Login("arbaaz", "testing")
//
//        );
//
//        Stream<loginDto> dtos = logins.stream().map(login -> mapToDto(login));
//        System.out.println(dtos);
//
//
//    }
//
//
//   static loginDto mapToDto(Login login){
//
//        loginDto dto = new loginDto();
//        dto.setUserName(login.getUserName());
//        dto.setPassword(login.getPassword());
//        return dto;


        List<Login> logins = Arrays.asList(
                new  Login("Jonathan", "testing"),
                new Login("Sumit", "testing"),
                new Login("Rahul", "testing")
        );

        List<LoginDto> dtos = logins.stream().map(login -> mapToDto(login)).collect(Collectors.toList());
        System.out.println(dtos);


    }

    static LoginDto mapToDto(Login login){
        LoginDto dto = new LoginDto();
        dto.setUserName(login.getUserName());
        dto.setPassword(login.getPassword());

        return dto;

    }












}
