package org.example.controller;

import org.example.entities.Student;
import java.util.List;

public interface IStudentController {
    public Student saveStudent(Student student);
    public List<Student> getStudent();
    public Student getStudentById(Integer id);
    public void deleteStudent(Integer id);
    public Student updatedStudent(Integer id, Student student);
}
