package org.example;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalClassExample
{
    public static void main( String[] args ) throws Exception
    {
        Optional<Cat> cat=getCat("kinny");
        int x=cat.orElseGet(()->new Cat("UNKNOWN",0)).age;
        Cat cat1=cat.orElseThrow(()->new CatNotPresentExeption("No Cat is named with given name"));
        System.out.println(x);
    }

    private static Optional<Cat> getCat(String name)
    {
        if(name=="kinny")
        return Optional.ofNullable(null);
        else
            return Optional.ofNullable(new Cat(name, 3));
    }
}
