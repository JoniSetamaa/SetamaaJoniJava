package com.example.demo.Models;

import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Course {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    protected String courseName;
    protected String teacherName;
    protected List<Student> students;


    public Course(String courseName, String teacherName, List<Student> students) {
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.students = students;
    }

    public long getid() {
        return this.id;
    }

    public long setid() {
        return this.id;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String CourseName) {
        this.courseName = CourseName;
    }

    public String getTeacherName() {
        return this.teacherName;
    }

    public void setTeacherName(String TeacherName) {
        this.teacherName = TeacherName;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public void setStudents(List<Student> Students) {
        this.students = Students;
    }

    public boolean addStudentToCourse(Student Student) {
        if(this.students.contains(Student)) {
            System.out.println("Student is already part of this course");
            return false;
        }
        else {
            this.students.add(Student);
            return true;
        }
    }

    public void removeStudent(Student Student) {
        if(this.students.contains(Student)) {
            this.students.remove(Student);
        }
        System.out.println("Student not found!");
    }

}