package joni.java.javaproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import joni.java.javaproject.Models.Course;
import joni.java.javaproject.Models.Student;

public class CourseService  implements ICourseService{

    List<Student> students = new ArrayList<>();
    List<Course> courses = new ArrayList<>();
    CourseFileService fileService = new CourseFileService();

    public CourseService() {

        try {
            this.students = fileService.readStudentsFromFile("students.txt");
        } catch (Exception e) {
            e.printStackTrace(); 
        }

        try {
            this.courses = fileService.readCoursesFromFile("courses.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override @GetMapping("students")
    public List<Student> getStudents() {
        return students;
    }

    @Override @GetMapping("courses")
    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public Student getStudentById(long studentId) {
        for (Student student : students) {
            if(student.getId()==studentId)
            return student;
        }
        return null;
    }

    @Override
    public Course getCourseById(long courseId) {
        for (Course course : courses) {
            if(course.getid()==courseId)
            return course;
        }
        return null;
    }

    @Override
    public List<Course> getCoursesOfStudent(long studentId) {
        Student student = getStudentById(studentId);
        List<Course> attendedCourses = new ArrayList<Course>();
        for (Course course : courses) {
            if(course.getStudents().contains(student))
            attendedCourses.add(course);
        }
        return attendedCourses;
    }

    @Override
    public boolean addStudentToCourse(long studentId, long courseId) {
        Student student = getStudentById(studentId);
        for (Course course : courses) {
            if(course.getid()==courseId)
            return course.addStudentToCourse(student);
        }
        return false;
    }

}