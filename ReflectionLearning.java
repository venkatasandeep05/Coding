package org.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class ReflectionLearning
{
    public static void main( String[] args ) throws Exception {
        Student student=new Student("Sandeep",101);

        Field[] fields= student.getClass().getDeclaredFields();

        //Modifying the value of name which is having private and final using Reflection
        for(Field x:fields)
        {
            if(x.getName().equals("name")) {
                x.setAccessible(true);
                x.set(student, "Praveen");
            }
        }
        // Name got changes to Praveen using Reflection
        System.out.println(student.getName());

        //Modifying the value of rollno which is a private variable using reflection
        for(Field x:fields)
        {
            if(x.getName().equals("rollno")) {
                x.setAccessible(true);
                x.set(student,102);
            }
        }
        //Roll no got changes to 102
        System.out.println(student.getRollno());

        //Modifying the value of private and static variable
        Field f=Student.class.getDeclaredField("course");
        f.setAccessible(true);
        f.set(f,"JAVA");

        //Course Name changed after using reflection
        System.out.println(Student.getCourse());

        Constructor<Student> constructor=Student.class.getDeclaredConstructor(String.class,Integer.class);
        constructor.setAccessible(true);
        Student s1=constructor.newInstance("Pradeep",104);

        //new Instance of class is created using private constructor using reflection
        System.out.println(student.hashCode()+" & "+s1.hashCode());

        //accessing private method using reflection

        Method[] methods=student.getClass().getDeclaredMethods();

        for(Method x:methods)
        {
            if(x.getName().equals("thisIsPrivateMethod"))
            {
                x.setAccessible(true);
                x.invoke(student);
            }
        }

        //Invoking static and private method of student class

        Method m=Student.class.getDeclaredMethod("thisIsPrivateAndStaticMethod");
        m.setAccessible(true);
        m.invoke(Student.class);

    }
}

public class Student
{

    private final String name;

    private Integer rollno;

    private static String course="DBMS";

    public Student(String name, Integer rollno) {
        this.name = name;
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public Integer getRollno() {
        return rollno;
    }

    public static String getCourse() {
        return course;
    }

    private void thisIsPrivateMethod()
    {
        System.out.println("Hello this is private method it can only be invoked from outside of this class only using reflection");
    }

    private static void thisIsPrivateAndStaticMethod()
    {
        System.out.println("Hello this is private and static method of Student class");
    }
}
