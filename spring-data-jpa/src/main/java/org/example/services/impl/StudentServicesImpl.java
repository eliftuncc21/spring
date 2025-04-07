package org.example.services.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.course.CourseResponseDto;
import org.example.dto.student.StudentRequestDto;
import org.example.dto.student.StudentResponseDto;
import org.example.entities.Course;
import org.example.entities.Student;
import org.example.repository.StudentRepository;
import org.example.services.IStudentServices;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServicesImpl implements IStudentServices {

    private final StudentRepository studentRepository;

    @Override
    public StudentResponseDto saveStudent(StudentRequestDto studentRequestDto) {
        StudentResponseDto response = new StudentResponseDto();
        Student student = new Student();
        BeanUtils.copyProperties(studentRequestDto, student);
        Student dbStudent = studentRepository.save(student);
        BeanUtils.copyProperties(dbStudent, response);
        return response;
    }

    @Override
    public List<StudentResponseDto> getStudent() {
        List<StudentResponseDto> dtoList = new ArrayList<>();
        List<Student> studentList = studentRepository.findAllStudents();
        for(Student student : studentList){
            StudentResponseDto studentResponseDto = new StudentResponseDto();
            BeanUtils.copyProperties(student, studentResponseDto);
            dtoList.add(studentResponseDto);
        }
        return dtoList;
    }

    @Override
    public StudentResponseDto getStudentById(Integer id) {
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        Optional<Student> optional = studentRepository.findStudentById(id);
        if(optional.isEmpty()) {
            return null;
        }
        Student student = optional.get();
        BeanUtils.copyProperties(student, studentResponseDto);
        for(Course course : student.getCourse()){
            CourseResponseDto courseResponseDto = new CourseResponseDto();
            BeanUtils.copyProperties(course, courseResponseDto);
            studentResponseDto.getCourses().add(courseResponseDto);
        }

        return studentResponseDto;
    }

    @Override
    public void deleteStudent(Integer id) {
        Optional<Student> optional = studentRepository.findById(id);
        if(optional.isPresent()){
            studentRepository.delete(optional.get());
        }
    }

    @Override
    public StudentResponseDto updateStudent(Integer id, StudentRequestDto studentRequestDto) {
        Optional<Student> optional = studentRepository.findById(id);
        if (optional.isPresent()){
            StudentResponseDto studentResponseDto = new StudentResponseDto();
            Student dbStudent = optional.get();
            dbStudent.setFirstName(studentRequestDto.getFirstName());
            dbStudent.setLastName(studentRequestDto.getLastName());
            dbStudent.setBirth_of_date(studentRequestDto.getBirth_of_date());

            Student updatedStudent = studentRepository.save(dbStudent);
            BeanUtils.copyProperties(updatedStudent, studentResponseDto);
            return studentResponseDto;
        }else {
            return null;
        }
    }
}
