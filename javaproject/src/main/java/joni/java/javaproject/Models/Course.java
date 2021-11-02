package joni.java.javaproject.Models;

import java.util.List;

public class Course {

    private long CourseID;
    private String CourseName;
    private String TeacherName;
    private List<Student> Students;

    public long getCourseID() {
        return this.CourseID;
    }

    public void setCourseID(long CourseID) {
        this.CourseID = CourseID;
    }

    public String getCourseName() {
        return this.CourseName;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    public String getTeacherName() {
        return this.TeacherName;
    }

    public void setTeacherName(String TeacherName) {
        this.TeacherName = TeacherName;
    }

    public List<Student> getStudents() {
        return this.Students;
    }

    public void setStudents(List<Student> Students) {
        this.Students = Students;
    }

    public boolean addStudentToCourse(Student Student) {
        if(Students.contains(Student)){
            return false;
        }else{
            Students.add(Student);
            return true;
        }
    }

    public void removeStudent(Student Student){
        if(Student.contains(Student)){
            Students.remove(Student);
        }
    }
}