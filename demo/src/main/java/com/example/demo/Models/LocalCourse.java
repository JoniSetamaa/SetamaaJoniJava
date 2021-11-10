package com.example.demo.Models;

import java.util.List;

public class LocalCourse extends Course {

    private String classRoom;
    
    public LocalCourse(String courseName, String teacherName, List<Student> students, String classRoom) {
        super(courseName, teacherName, students);
        this.classRoom = classRoom;
    }

    public String getClassRoom() {
        return this.classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }
    
    @Override
    public boolean addStudentToCourse(Student student) {
        if(this.getStudents().size() < 25) {
            return super.addStudentToCourse(student);
        }
        else {
            System.out.println("Cannot add new student to this course. The course is full!");
            return false;
        }
    }
    
    @Override
    public String toString() {
        return super.getCourseName()+" - "+super.getTeacherName()+" - "+this.getClassRoom();
    }
}
