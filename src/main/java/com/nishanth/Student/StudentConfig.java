package com.nishanth.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            Student nishanth = new Student(1,"nish",21,"nish@google.com");
            Student vishu = new Student(2,"vishu",22,"vishu@google.com");

            studentRepository.saveAll(List.of(nishanth,vishu));

        };
    }
}
