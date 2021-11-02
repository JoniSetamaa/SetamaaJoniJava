package joni.java.javaproject.Models;

public class Student {

    private long ID;
    private String FirstName;
    private String LastName;
    static int NextID;



    public long getID() {
        return this.ID;
    }

    public void setID(long ID) {
        this.ID = ID;
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
    public String toString(){
        return FirstName+" "+LastName;
    }

    public Student(String FirstName, String LastName) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        ID = NextID;
        NextID++;
    }

}
