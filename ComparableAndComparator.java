package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Comparator;

public class ComparableAndComparator {


    public static void main(String[] args)
    {
        List<Student> list= Arrays.asList(new Student("sandeep",24,80),
                new Student("Pradeep",30,90),
                new Student("Nikhil",65,99),
                new Student("Sharief",55,97),
                new Student("Avinash",35,96));
        Comparator<Student> comp=new SortByAge();
        Collections.sort(list,comp);
        System.out.println(list);

        //Comparing based on score and using lambda inplace of comparator interface

        Collections.sort(list,(s1,s2)->((s1.getScore()>s2.getScore())?-1:1));

        System.out.println(list);

        //Sorting based on name and using comprable interface 

        Collections.sort(list);

        System.out.println(list);

    }
}

public class SortByAge implements Comparator<Student>
{
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.getAge()>o2.getAge())
            return 1;
        else
            return -1;
    }
}

public class Student implements Comparable<Student>
{
    private String name;
    private int age;
    private int score;

    @Override
    public int compareTo(Student o)
    {
        if(o.getName().compareTo(this.getName())>0) {
            return -1;
        } else
            return 1;
    }

    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public Student() {
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

