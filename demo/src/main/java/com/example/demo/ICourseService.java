package com.example.demo;

import java.util.List;

import com.example.demo.Models.Course;
import com.example.demo.Models.Student;


public interface ICourseService {
    
    // Gets list of students 
    List<Student> getStudents();

    // Gets list of courses
    List<Course> getCourses();

    // Gets student by ID. Returns null if student not found.
    Student getStudentById(long studentId);

    // Gets course by ID. Returns null if corse not found.
    Course getCourseById(long courseId);

    // Gets list of courses that the student is registered in 
    List<Course> getCoursesOfStudent(long studentId);

    // Registers the student in the course. Return true if the registration was successful.
    boolean addStudentToCourse(long studentId, long courseId);
}
