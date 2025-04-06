package org.example.services;

import org.example.dto.student.DtoStudent;
import org.example.dto.student.DtoStudentIU;

import java.util.List;

public interface IStudentServices {
    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);
    public List<DtoStudent> getStudent();
    public DtoStudent getStudentById(Integer id);
    public void deleteStudent(Integer id);
    public DtoStudent updateStudent(Integer id, DtoStudentIU dtoStudentIU);
}
