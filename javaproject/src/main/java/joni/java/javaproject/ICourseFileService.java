package joni.java.javaproject;

import java.io.FileNotFoundException;
import java.util.List;
import joni.java.javaproject.Models.Course;
import joni.java.javaproject.Models.Student;

public interface ICourseFileService {
    
    List<Student> readStudentsFromFile(String filePath) throws FileNotFoundException;
    List<Course> readCoursesFromFile(String filePath) throws FileNotFoundException;
}
