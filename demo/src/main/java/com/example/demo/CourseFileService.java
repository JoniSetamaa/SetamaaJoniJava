package com.example.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.demo.Models.Course;
import com.example.demo.Models.LocalCourse;
import com.example.demo.Models.OnlineCourse;
import com.example.demo.Models.Student;


public class CourseFileService implements ICourseFileService {

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
    