package org.example.controller;

import org.example.dto.student.StudentRequestDto;
import org.example.dto.student.StudentResponseDto;
import java.util.List;

public interface IStudentController {
    StudentResponseDto saveStudent(StudentRequestDto studentRequestDto);
    List<StudentResponseDto> getStudent();
    StudentResponseDto getStudentById(Integer id);
    void deleteStudent(Integer id);
    StudentResponseDto updatedStudent(Integer id, StudentRequestDto studentRequestDto);
}
