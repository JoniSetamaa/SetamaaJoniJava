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
   

    
    

}
