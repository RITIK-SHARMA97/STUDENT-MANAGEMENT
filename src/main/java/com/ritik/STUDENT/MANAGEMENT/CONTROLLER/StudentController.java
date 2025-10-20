package com.ritik.STUDENT.MANAGEMENT.CONTROLLER;

import com.ritik.STUDENT.MANAGEMENT.DTO.StudentDto;
import com.ritik.STUDENT.MANAGEMENT.ENTITY.STUDENT;
import com.ritik.STUDENT.MANAGEMENT.REPOSITORY.StudentRepository;
import com.ritik.STUDENT.MANAGEMENT.SERVICE.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class  StudentController {
    private final StudentService studentService;




    @GetMapping("/students")
    public List<StudentDto> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public StudentDto getStudentById(@PathVariable Long id){
       return studentService.getStudentById(id);
    }

}
