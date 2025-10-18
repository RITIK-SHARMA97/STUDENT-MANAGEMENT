package com.ritik.STUDENT.MANAGEMENT.CONTROLLER;

import com.ritik.STUDENT.MANAGEMENT.DTO.StudentDto;
import com.ritik.STUDENT.MANAGEMENT.ENTITY.STUDENT;
import com.ritik.STUDENT.MANAGEMENT.REPOSITORY.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class  StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @GetMapping("/students")
    public List<STUDENT> getStudent(){
        return studentRepository.findAll();
    }

}
