package joni.java.javaproject.Models;

import java.util.List;

public class LocalCourse extends Course {

    private String classRoom;
    private final int maxCLassRoomCabacity = 25;
    
    public LocalCourse(String courseName, String teacherName, List<Student> students, String classRoom) {
        super(courseName, teacherName, students);
        this.classRoom = classRoom;
    }

    public String getClassRoom() {
        return this.classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }
    
    @Override
    public boolean addStudentToCourse(Student student) {
        if(this.getStudents().size() < maxCLassRoomCabacity) {
            return super.addStudentToCourse(student);
        }
        else {
            System.out.println("This class is full, cannot add the student");
            return false;
        }
    }
    
    @Override
    public String toString() {
        return super.toString() + " - " + classRoom;
    }
}
