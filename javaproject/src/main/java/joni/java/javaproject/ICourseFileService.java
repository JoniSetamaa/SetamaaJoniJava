package joni.java.javaproject;

import java.io.FileNotFoundException;
import java.util.List;
import joni.java.javaproject.Models.Course;
import joni.java.javaproject.Models.Student;

public interface ICourseFileService {
    
    // Reads list of students from txt.file
    List<Student> readStudentsFromFile(String filePath) throws FileNotFoundException;

    // Reads list of courses from txt.file
    List<Course> readCoursesFromFile(String filePath) throws FileNotFoundException;
}
