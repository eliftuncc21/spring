package org.example.controller.impl;

import org.example.controller.IStudentController;
import org.example.entities.Student;
import org.example.services.IStudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/rest/api/student")
public class StudentControllerImpl implements IStudentController {

     @Autowired
     private IStudentServices studentServices;

    @PostMapping(path = "/save")
    @Override
    public Student saveStudent(@RequestBody Student student) {
        return studentServices.saveStudent(student);
    }

    @GetMapping(path = "/list")
    @Override
    public List<Student> getStudent() {
        return studentServices.getStudent();
    }

    @GetMapping(path = "/list/{id}")
    @Override
    public Student getStudentById(@PathVariable(name = "id", required = true) Integer id) {
        return studentServices.getStudentById(id);
    }

    @DeleteMapping(path = "/delete-student/{id}")
    @Override
    public void deleteStudent(@PathVariable(name = "id", required = true) Integer id) {
        studentServices.deleteStudent(id);
    }

    @PutMapping(path = "update/{id}")
    @Override
    public Student updatedStudent(@PathVariable(name = "id", required = true) Integer id,@RequestBody Student student) {
        return studentServices.updateStudent(id, student);
    }
}
