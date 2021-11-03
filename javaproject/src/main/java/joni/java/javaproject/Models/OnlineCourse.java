package joni.java.javaproject.Models;

import java.util.List;

public class OnlineCourse extends Course {

    private String URL;

    public String getURL() {
        return this.URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public OnlineCourse(String courseName, String teacherName, List<Student> students, String url ) {
        this.CourseName = courseName;
        this.TeacherName = teacherName;
        this.Students = students;
        this.URL = url;
    }
    
    @Override
    public String toString() {
        return CourseName+" - "+TeacherName+" - "+URL;
    }
    
}
