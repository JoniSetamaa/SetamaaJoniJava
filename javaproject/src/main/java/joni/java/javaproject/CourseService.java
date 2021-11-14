package joni.java.javaproject;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Student> getStudents() {
        return students;
    }

    @Override
    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public Student getStudentById(long studentId) {
        Student selectedStudent = null;
        for (Student student : students) {
            if (student.getId() == studentId) {
            selectedStudent = student;
        }
    }

    if (selectedStudent == null) {
        System.out.println("Student not found");
    }
        return selectedStudent;
    }

    @Override
    public Course getCourseById(long courseId) {
        Course selectedCourse = null;
        for (Course course : courses) {
            if (course.getid() == courseId) {
                selectedCourse = course;
            }
        }

        if (selectedCourse == null) {
            System.out.println("Course not found");
        }
        return selectedCourse;
    }

    @Override
    public List<Course> getCoursesOfStudent(long studentId) {
        Student student = getStudentById(studentId);
        List<Course> attendedCourses = new ArrayList<>();
        for (Course course : courses) {
            if(course.getStudents().contains(student));
            attendedCourses.add(course);
        }
        return attendedCourses;
    }

    @Override
    public boolean addStudentToCourse(long studentId, long courseId) {
        Student st = getStudentById(studentId);
        for (Course course : courses) {
            if(course.getid()==courseId)
                return course.addStudentToCourse(st);
        }
        return false;
    }
}