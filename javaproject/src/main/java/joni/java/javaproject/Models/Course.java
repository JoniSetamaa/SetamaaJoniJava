package joni.java.javaproject.Models;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Course {

    private static AtomicInteger ID_GENERATOR = new AtomicInteger(0);
    private long id;
    protected String courseName;
    protected String teacherName;
    protected List<Student> students;


    public Course(String courseName, String teacherName, List<Student> students) {
        this.courseName = courseName;
        this.teacherName = teacherName;
        this.students = students;
        this.id = ID_GENERATOR.getAndIncrement();
    }

    public long getid() {
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

    public boolean addStudentToCourse(Student student) {
        if(this.students.contains(student)) {
            System.out.println("Cannot add student. Student exists on the course");
            return false;
        } else {
            this.students.add(student);
            System.out.println("Student " + student.getFirstName() + " " + student.getLastName() + " was added to the course " + getCourseName());
            return true;
        }
    }

    public void removeStudent(Student student) {
        if(this.students.contains(student)) {
            this.students.remove(student);
            System.out.println("Student " + student.getFirstName() + " " + student.getLastName() + " was removed from the course.");
        } else {
            System.out.println("Student " + student.getFirstName() + " " + student.getLastName() + " not found.");
        }
        
    }

    @Override
    public String toString() {
        return courseName + " - " + teacherName;
    }

}