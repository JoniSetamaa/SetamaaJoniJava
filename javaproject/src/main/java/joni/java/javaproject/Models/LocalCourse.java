package joni.java.javaproject.Models;

import java.util.List;

public class LocalCourse extends Course {

    private String ClassRoom;
    private int CourseSize = 25;
    
    public LocalCourse(String CourseName, String TeacherName, List<Student> Students, String ClassRoom) {
        this.CourseName = CourseName;
        this.TeacherName = TeacherName;
        this.Students = Students;
        this.ClassRoom = ClassRoom;
    }

    public String getClassRoom() {
        return this.ClassRoom;
    }

    public void setClassRoom(String ClassRoom) {
        this.ClassRoom = ClassRoom;
    }

    public int getCourseSize() {
        return this.CourseSize;
    }

    public void setCourseSize(int CourseSize) {
        this.CourseSize = CourseSize;
    }

    public LocalCourse(String ClassRoom, int CourseSize) {
        this.ClassRoom = ClassRoom;
        this.CourseSize = CourseSize;
    }
    
    
    
}
