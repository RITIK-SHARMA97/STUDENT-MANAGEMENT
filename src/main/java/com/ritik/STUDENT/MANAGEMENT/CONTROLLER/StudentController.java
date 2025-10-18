package com.ritik.STUDENT.MANAGEMENT.CONTROLLER;

import com.ritik.STUDENT.MANAGEMENT.DTO.StudentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class  StudentController {

    @GetMapping("/students")
    public StudentDto getStudent(){
        return new StudentDto(21L,"Ritik","sharma@gmail.com");
    }

}
