package joni.java.javaproject.Models;

import java.util.concurrent.atomic.AtomicInteger;

public class Student {

    private static AtomicInteger ID_GENERATOR = new AtomicInteger(0);
    private long studentId;
    private String firstName;
    private String lastName;
   

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = ID_GENERATOR.getAndIncrement();
    }


    public long getId() {
        return this.studentId;
    }

    public long setId() {
        return this.studentId;
    }


    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return this.lastName + " " + this.firstName;
    }


   

}
