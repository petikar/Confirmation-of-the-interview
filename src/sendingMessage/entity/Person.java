package sendingMessage.entity;

import sendingMessage.database.DeleteFromDB;
import sendingMessage.database.GetList;

import java.util.ArrayList;


public class Person {

    int id;
    String name;
    String phoneNumber;
    String date;
    String type;

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Person(int id, String name, String phoneNumber, String type, String date) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.type = type;
        this.date = date;
        System.out.println("Person " + id + ", name = " + name + " phone number = " + phoneNumber + " type = " + type + " date = " + date);
    }

    public Person() {
    }

    public static ArrayList<Person> listInterviewsForDate(String date) {
        ArrayList<Person> personArrayList = GetList.listInterviewsForDate(date);
        return personArrayList;
    }

    public void deleteToDatabase(Person person) {
        int id = person.id;
        DeleteFromDB.deleteToDatabase(id);
    }

    @Override
    public String toString() {
        String toString = "name= " + name + "; phoneNumber = " + phoneNumber + "; type = " + type + "; date = " + date + " ";
        return toString;
    }


}
