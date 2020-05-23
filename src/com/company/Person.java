package com.company;

import com.google.gson.Gson;

import java.io.*;

public class Person {
    //these are class fields
    private String Name;
    private int Age;
    private String Gender;

    //these are class getters
    public String getName(){return Name;}
    public int getAge(){return Age;}
    public String getGender(){return Gender;}

    //this is constructor
    public Person(String name, int age, String gender){
        this.Name = name;
        this.Age = age;
        this.Gender = gender;
        System.out.println("Person created: " + this.Name + "; " + this.Age + "; " + this.Gender + ";");
    }

    //this is void for serialising to JSON
    public void ToJson(String path)
    {
        Gson gson = new Gson();
        try(FileWriter writer = new FileWriter(path, false))
        {
            String text = gson.toJson(this);    //this serialises class to JSON
            writer.write(text);                     //this writes to file
            writer.flush();                         //actually writes to file from buffer
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());    //writes a message if smth goes wrong
        }
    }

    //this is class constructor for deserialising from JSON
    public Person FromJson(String path){
        Gson gson = new Gson();
        try(FileReader reader = new FileReader(path))
        {
            String line="";
            int c;
            while((c=reader.read())!=-1){
                line+=(char)c;                          //this reads chars from file 1 by 1
            }
            return gson.fromJson(line, Person.class);   //this creates a Person object
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());        //writes a message if smth goes wrong
            return null;
        }
    }

    //we need to compare class objects
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Person other = (Person) obj;
        return Age == other.Age
                && (Name == other.Name || (Name != null && Name.equals(other.getName())))
                && (Gender == other.Gender || (Gender != null && Gender.equals(other.getGender())));
    }

    //we need to be able to get the hashcode to use EqualsVerifier
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((Name == null) ? 0 : Name.hashCode());
        result = prime * result + ((Gender == null) ? 0 : Gender.hashCode());
        result = prime * result + Age;
        return result;
    }
}