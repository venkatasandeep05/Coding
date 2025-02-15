package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionalProgrammingExample {
    public static void main(String[] args)
    {
        List<Integer> list= Arrays.asList(1,2,5,4,5,6,7);

        list.forEach((a)->System.out.println(a));
        list.stream().filter(a->a%2==0).forEach(System.out::println);

        List<String> courses=Arrays.asList("Spring Boot","Maven","Spring Security","Spring Cloud");

        courses.stream().filter(a->a.contains("Spring")).forEach(System.out::println);

        courses.stream().filter(a->a.length()>=4).forEach(System.out::println);


        list.stream().map(a->a*a).forEach(System.out::println);

        courses.stream().map(a->a.length()).forEach(System.out::println);

        int sum=list.stream().reduce(0,(x,y)->x+y);
        System.out.println(sum);

        System.out.println(list.stream().reduce(0,(x,y)->x));

        System.out.println(list.stream().reduce(Integer.MIN_VALUE,(x,y)->(x<y)?y:x));

        System.out.println(list.stream().map(a->a*a).reduce(0,(x,y)->x+y));

        System.out.println(list.stream().filter(a->a%2!=0).reduce(0,(x,y)->x+y));

        System.out.println(list.stream().distinct().collect(Collectors.toList()));
        System.out.println(list.stream().sorted().collect(Collectors.toList()));
        

    }
}
