package org.example.services.impl;

import org.example.entities.Student;
import org.example.repository.StudentRepository;
import org.example.services.IStudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServicesImpl implements IStudentServices {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Integer id) {
        Optional<Student> optional = studentRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public void deleteStudent(Integer id) {
        Student student = getStudentById(id);
        if(student != null){
            studentRepository.delete(student);
        }
    }

    @Override
    public Student updateStudent(Integer id, Student student) {
        Student dbStudent = getStudentById(id);
        if (dbStudent != null) {
            dbStudent.setFirstName(student.getFirstName());
            dbStudent.setLastName(student.getLastName());
            dbStudent.setBirth_of_date(student.getBirth_of_date());

            return studentRepository.save(dbStudent);
        }
        return null;
    }
}
