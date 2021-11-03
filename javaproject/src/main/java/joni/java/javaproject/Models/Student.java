package joni.java.javaproject.Models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String FirstName;
    private String LastName;
    static int NextID;

    public long getID() {
        return this.id;
    }

    public void setID(long ID) {
        this.id = ID;
    }

    public String getFirstName() {
        return this.FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return this.LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    @Override
    public String toString() {
        return FirstName+" "+LastName;
    }

    public Student(String FirstName, String LastName) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        id = NextID;
        NextID++;
    }

}
