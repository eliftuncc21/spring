package org.example.services.impl;

import org.example.dto.course.DtoCourse;
import org.example.dto.student.DtoStudent;
import org.example.dto.student.DtoStudentIU;
import org.example.entities.Course;
import org.example.entities.Student;
import org.example.repository.StudentRepository;
import org.example.services.IStudentServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServicesImpl implements IStudentServices {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
        DtoStudent response = new DtoStudent();
        Student student = new Student();
        BeanUtils.copyProperties(dtoStudentIU, student);
        Student dbStudent = studentRepository.save(student);
        BeanUtils.copyProperties(dbStudent, response);
        return response;
    }

    @Override
    public List<DtoStudent> getStudent() {
        List<DtoStudent> dtoList = new ArrayList<>();
        List<Student> studentList = studentRepository.findAllStudents();
        for(Student student : studentList){
            DtoStudent dtoStudent = new DtoStudent();
            BeanUtils.copyProperties(student, dtoStudent);
            dtoList.add(dtoStudent);
        }
        return dtoList;
    }

    @Override
    public DtoStudent getStudentById(Integer id) {
        DtoStudent dtoStudent = new DtoStudent();
        Optional<Student> optional = studentRepository.findStudentById(id);
        if(optional.isEmpty()) {
            return null;
        }
        Student student = optional.get();
        BeanUtils.copyProperties(student, dtoStudent);
        for(Course course : student.getCourse()){
            DtoCourse dtoCourse = new DtoCourse();
            BeanUtils.copyProperties(course, dtoCourse);
            dtoStudent.getCourses().add(dtoCourse);
        }

        return dtoStudent;
    }

    @Override
    public void deleteStudent(Integer id) {
        Optional<Student> optional = studentRepository.findById(id);
        if(optional.isPresent()){
            studentRepository.delete(optional.get());
        }
    }

    @Override
    public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU) {
        Optional<Student> optional = studentRepository.findById(id);
        if (optional.isPresent()){
            DtoStudent dtoStudent = new DtoStudent();
            Student dbStudent = optional.get();
            dbStudent.setFirstName(dtoStudentIU.getFirstName());
            dbStudent.setLastName(dtoStudentIU.getLastName());
            dbStudent.setBirth_of_date(dtoStudentIU.getBirth_of_date());

            Student updatedStudent = studentRepository.save(dbStudent);
            BeanUtils.copyProperties(updatedStudent,dtoStudent);
            return dtoStudent;
        }else {
            return null;
        }
    }
}
