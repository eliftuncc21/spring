package org.example.controller.impl;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.controller.IStudentController;
import org.example.dto.student.StudentRequestDto;
import org.example.dto.student.StudentResponseDto;
import org.example.services.IStudentServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rest/api/student")
@RequiredArgsConstructor
public class StudentControllerImpl implements IStudentController {

    private final IStudentServices studentServices;

    @PostMapping(path = "/save")
    @Override
    public StudentResponseDto saveStudent(@RequestBody @Valid StudentRequestDto studentRequestDto) {
        return studentServices.saveStudent(studentRequestDto);
    }

    @GetMapping(path = "/list")
    @Override
    public List<StudentResponseDto> getStudent() {
        return studentServices.getStudent();
    }

    @GetMapping(path = "/list/{id}")
    @Override
    public StudentResponseDto getStudentById(@PathVariable(name = "id", required = true) Integer id) {
        return studentServices.getStudentById(id);
    }

    @DeleteMapping(path = "/delete-student/{id}")
    @Override
    public void deleteStudent(@PathVariable(name = "id", required = true) Integer id) {
        studentServices.deleteStudent(id);
    }

    @PutMapping(path = "update/{id}")
    @Override
    public StudentResponseDto updatedStudent(@PathVariable(name = "id", required = true) Integer id, @RequestBody StudentRequestDto studentRequestDto) {
        return studentServices.updateStudent(id, studentRequestDto);
    }
}
