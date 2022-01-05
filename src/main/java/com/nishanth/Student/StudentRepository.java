package com.nishanth.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //responsible for data Access
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s from Student s where s.id=?1")
    Optional<Student> findStudentById(long id);
    Optional<Student> findStudentByEmail(String email);

}
