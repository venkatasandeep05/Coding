package org.example;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class App 
{
    public static void getSingleton()
    {
        System.out.println("Singleton hashcode which is created using Executer service "+SingletonEntity.getInstance().hashCode());
    }
    public static void main( String[] args ) throws Exception
    {

        //Let us try to break Singleton using multiple threads
        ExecutorService executorService= Executors.newFixedThreadPool(4);
        executorService.submit(App::getSingleton);
        executorService.submit(App::getSingleton);
        executorService.shutdown();

        //Let us create two instances of SingletonEntity and if they are equal

        SingletonEntity s1=SingletonEntity.getInstance();
        SingletonEntity s2=SingletonEntity.getInstance();

        System.out.println(s1==s2);

        // Let us use cloneable interface and try to break singleton by creating 2 different objects

        SingletonEntity s3= (SingletonEntity) s1.clone();
        System.out.println(s1==s3);   // even using cloneble we got same instance between we have overridden the clone() method

//        Let us try to break Singleton using Reflection
        Constructor<SingletonEntity> constructor=SingletonEntity.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        try
        {
            SingletonEntity s4 = constructor.newInstance();
            System.out.println(s1 == s4);
        }
        catch (Exception e)
        {
            //it throws an exception . but this works if class is eagerly loaded in lazy loading it may not work all the time
            System.out.println("New Instance of Singleton class is not created");
        }

        //Let us try to break Singleton using serialization and de-serialzation
        SingletonEntity s5=SingletonEntity.getInstance();

        FileOutputStream fileOutputStream=new FileOutputStream("D:\\temp.txt");
        ObjectOutputStream outputStream=new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(s5); // Serializing the object and storing in a file

        FileInputStream fileInputStream=new FileInputStream("D:\\temp.txt");
        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
        SingletonEntity s6= (SingletonEntity) objectInputStream.readObject();

        System.out.println("Before serialization "+s5.hashCode()+" After serialization "+s6.hashCode());



    }
}

public class SingletonEntity implements Cloneable, Serializable
{
    private static volatile SingletonEntity singletonEntity=null;

    private SingletonEntity() {
        if(singletonEntity!=null)
            throw new RuntimeException("Cannot create a new instance for singleton since one more instance already exists");
        System.out.println("Singleton Constructor");
    }
    public static SingletonEntity getInstance()  // remove synchronized keywords to break singleton
    {

            if (singletonEntity == null) { //check1
                synchronized (SingletonEntity.class) {
                    if (singletonEntity==null)   //check2 -- double check locking
                    singletonEntity = new SingletonEntity();
                }
            }
        return singletonEntity;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

//        return super.clone();  Instead of calling super class if we return our own instance new object is not created even using cloneable
        return singletonEntity;
    }

    private Object readResolve() throws ObjectStreamException
    {
        return getInstance();
    }
}
