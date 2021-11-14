package joni.java.javaproject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import joni.java.javaproject.Models.Course;
import joni.java.javaproject.Models.OnlineCourse;
import joni.java.javaproject.Models.Student;
import joni.java.javaproject.Models.Data;

@RestController
public class CourseController {

    CourseService courseService = new CourseService();
    
    @GetMapping("students")
    public List<Student> getStudents() {
         return courseService.getStudents();
     }

    @GetMapping("courses")
     public List<Course> getCourses() {
        return courseService.getCourses();
     }

    @GetMapping(value ="/onlinecourses") 
     public List<String> getOnlineCourse() {
         List<Course> courses = courseService.getCourses();
         List<String> onlineCourses = new ArrayList<>();

         for (Course course : courses) {
             if(course instanceof OnlineCourse) {
                 onlineCourses.add(course.getCourseName());
             }
        }

         return onlineCourses;
     }

    @GetMapping("/students/{id}")
     public String getStudent( @PathVariable("id") Long studentId) {
         Student student = courseService.getStudentById(studentId);
         List<Course> courses = courseService.getCoursesOfStudent(studentId);
         String courseNames = courses.stream()
                .map(Course::getCourseName)
                .collect(Collectors.joining("\n"));
         
         return student.toString() + "\n" + courseNames;
     }

    @GetMapping("/courses/{id}")
     public String getCourse( @PathVariable("id") Long courseid){
         Course course = courseService.getCourseById(courseid);
         List<Student> students = course.getStudents().stream().toList();
         String names = students.stream()
                 .map(Student::toString)
                 .collect(Collectors.joining("\n"));
 
         return course.getCourseName() + "\n" + names;
     }

      @ResponseBody @PostMapping("/add")
     public String addStudentToCourse(@RequestBody Data data) {
         if (courseService.addStudentToCourse(data.getSid(), data.getCid())) {
             return courseService.getStudentById(data.getSid()).toString() + " added to course " + courseService.getCourseById(data.getCid()).getCourseName();
         } else {
             return "Unable to add the student to course.";
         }
     }

}