package com.nishanth.Student;


import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents(){

        return studentService.getAllStudent();
    }
    @PostMapping
    public void addNewStudent(@RequestBody Student student){

        studentService.addNewStudent(student);
    }
    @DeleteMapping(path = "{id}")
    public void deleteStudent(@PathVariable("id") long id){
        studentService.deleteStudent(id);
    }
    @PutMapping(path = "{id}")
    public void updateStudent(@PathVariable("id") long id,@RequestParam String email)
    {
        studentService.updateStudent(id,email);
    }
}
