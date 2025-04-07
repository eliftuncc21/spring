package org.example.repository;

import org.example.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "select * from student where first_name = 'Elif' ", nativeQuery = true)
    List<Student> findAllStudents();

    @Query(value = "from Student where id = :id ", nativeQuery = false)
    Optional<Student> findStudentById(Integer id);
}
