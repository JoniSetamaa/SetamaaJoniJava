package joni.java.javaproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import joni.java.javaproject.Models.Course;
import joni.java.javaproject.Models.LocalCourse;
import joni.java.javaproject.Models.OnlineCourse;
import joni.java.javaproject.Models.Student;

public class CourseFileService implements ICourseFileService {

    public CourseFileService() {
        
    }

    @Override
    public List<Student> readStudentsFromFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        List<Student> studentsFromFile = new ArrayList<>();
        Scanner sc = new Scanner(file);

        while(sc.hasNext()) {
            String[] rowData = sc.nextLine().split(" ");
            studentsFromFile.add(new Student(rowData[0], rowData[1]));
        }
        sc.close();
        return studentsFromFile;
    }

    @Override
    public List<Course> readCoursesFromFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        List<Course> coursesFromFile = new ArrayList<>();
        Scanner sc = new Scanner(file);

        while(sc.hasNext()) {
            String[] rowData = sc.nextLine().split("--");

            if(rowData.length > 3){
            coursesFromFile.add(new OnlineCourse(rowData[0], rowData[1], new ArrayList<>(), rowData[2]));
            }
            else {
                coursesFromFile.add(new LocalCourse(rowData[0], rowData[1], new ArrayList<>(), rowData[2]));
            }
        }
        sc.close();
        return coursesFromFile;
    }
}
    

