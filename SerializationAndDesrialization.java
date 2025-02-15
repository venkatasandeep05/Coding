package org.example;

import java.io.*;

public class SerializationAndDesrialization
{
    public static void main(String[] args)
    {
        Student s1=new Student();
        s1.id=5;
        s1.name="New York";

        String fileName="D:\\coding\\TestFile.txt";
        // Serializing Student object s1
        try
        {

            FileOutputStream fileInputStream=new FileOutputStream(fileName);
            ObjectOutputStream outputStream=new ObjectOutputStream(fileInputStream);
            outputStream.writeObject(s1);
            fileInputStream.close();
            outputStream.close();
        }
        catch(Exception e)
        {
            e.getStackTrace();
        }

        // Deserializing Student Object s1 to s2
        Student s2=null;
        try
        {

            FileInputStream fileInputStream=new FileInputStream(fileName);
            ObjectInputStream inputStream=new ObjectInputStream(fileInputStream);
            s2=(Student) inputStream.readObject();
            fileInputStream.close();
            fileInputStream.close();
            System.out.println(s2.id + s2.name);
        }
        catch(Exception e)
        {
            e.getStackTrace();
        }
    }
}

class Student implements Serializable
{
    private static final long serialVersionUID=123456789L;
    int id;
    String name;
}
