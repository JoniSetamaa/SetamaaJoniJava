package joni.java.javaproject;

import java.util.List;
import joni.java.javaproject.Models.Course;
import joni.java.javaproject.Models.Student;

public interface ICourseService {
     
    List<Student> getStudents();
    List<Course> getCOurses();
    Student getStudentById(long studentId);
    Course getCourseById(long courseId);
    List<Course> getCoursesOfStudent(long studentId);
    boolean addStudentToCourse(long studentId, long courseId);
}
