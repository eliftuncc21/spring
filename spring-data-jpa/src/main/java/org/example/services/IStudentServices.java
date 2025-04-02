package org.example.services;

import org.example.entities.Student;
import java.util.List;
import java.util.Optional;

public interface IStudentServices {
    public Student saveStudent(Student student);
    public List<Student> getStudent();
    public Student getStudentById(Integer id);
    public void deleteStudent(Integer id);
    public Student updateStudent(Integer id, Student student);
}
