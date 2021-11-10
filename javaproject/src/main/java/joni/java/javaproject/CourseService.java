package joni.java.javaproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import joni.java.javaproject.Models.Course;
import joni.java.javaproject.Models.OnlineCourse;
import joni.java.javaproject.Models.Student;

@RestController
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

    @ResponseBody @GetMapping("onlinecourses") 
    public String getOnlineCourse() {
        String onlineCourseData = "";
        for (Course course : courses) {
            if(course instanceof OnlineCourse)
                onlineCourseData += "<p>"+course.getCourseName()+"</p>";
        }
        return onlineCourseData;
    }

    @ResponseBody @GetMapping("students/{id}")
    public String getStudent( @PathVariable String studentid) {
        long studentId = Long.parseLong(studentid);
        Student student = getStudentById(studentId);
        String stData = "<h1>"+student.toString()+"</h1>";
        List<Course> courses = getCoursesOfStudent(studentId);
        for (Course course : courses) {
            stData += "<h2>"+course.getCourseName()+"</h2>";
        }
        return stData;
    }

    @ResponseBody @GetMapping("courses/{id}")
    public String getCourseInfo( @PathVariable String courseid){
        long id = Long.parseLong(courseid);
        Course course = getCourseById(id);
        String courseData = "<h1>"+course.getCourseName()+"</h1>";
        List<Student> students = course.getStudents();

        if(students != null && students.size() > 0)
            for (Student student : students) {
                courseData += "<h2>"+student.toString()+"</h2>";
            }
        return courseData;
    }

    @ResponseBody @PostMapping("add")
    public String addStudentToCourse(@RequestBody addData adddata){
        boolean added = addStudentToCourse(adddata.sid, adddata.cid);     
        if(added){
            Student st = getStudentById(adddata.sid);
            return st.getFirstName()+" "+st.getLastName()+" --> "+getCourseById(adddata.cid).getCourseName();
        }else{
            return "An error no one was added to the course ";
        }
    }
}