package com.nishanth.Student;

import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentById(student.getId());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("Id taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        boolean exists = studentRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Student with ID "+id+"Not found");
        }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(long id, String email) {
        Student student = studentRepository.findStudentById(id).orElseThrow(()->new IllegalStateException("Student with id"+id+"does not exist"));
       if(email!=null&&email.length()>0&&!Objects.equals(student.getEmail(),email)){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
       }

    }
}
