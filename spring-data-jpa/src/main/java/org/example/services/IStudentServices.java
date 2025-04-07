package org.example.services;

import org.example.dto.student.StudentResponseDto;
import org.example.dto.student.StudentRequestDto;

import java.util.List;

public interface IStudentServices {
    StudentResponseDto saveStudent(StudentRequestDto studentRequestDto);
    List<StudentResponseDto> getStudent();
    StudentResponseDto getStudentById(Integer id);
    void deleteStudent(Integer id);
    StudentResponseDto updateStudent(Integer id, StudentRequestDto studentRequestDto);
}
