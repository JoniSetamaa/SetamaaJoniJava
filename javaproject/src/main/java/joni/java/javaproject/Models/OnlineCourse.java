package joni.java.javaproject.Models;

import java.util.List;

public class OnlineCourse extends Course {

    private String courseAddress;

    public OnlineCourse(String courseName, String teacherName, List<Student> students, String courseAddress) {
        super(courseName, teacherName, students);
        this.courseAddress = courseAddress;
    }
    
    public String getCourseAddress() {
        return this.courseAddress;
    }

    public void setCourseAddress(String courseAddress) {
        this.courseAddress = courseAddress;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + courseAddress;
    }   
}