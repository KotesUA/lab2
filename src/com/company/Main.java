package com.company;
import com.google.gson.*;
public class Main {

    public static void main(String[] args) {
        //create new Person object
        Person p = new Person("Name", 45, "male");

        //this is a path to our file
        String path = "C:\\Users\\Kotes\\Desktop\\java_labs_kotes\\lab2\\result.txt";

        //here we serialise our Person object
        p.ToJson(path);

        //here we deserialise our Person object
        Person p1 = p.FromJson(path);

        System.out.println(p.equals(p1));
    }
}
