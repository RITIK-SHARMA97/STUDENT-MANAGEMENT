package com.ritik.STUDENT.MANAGEMENT.CONTROLLER;

import com.ritik.STUDENT.MANAGEMENT.DTO.AddStudentRequestsDto;
import com.ritik.STUDENT.MANAGEMENT.DTO.StudentDto;
import com.ritik.STUDENT.MANAGEMENT.ENTITY.STUDENT;
import com.ritik.STUDENT.MANAGEMENT.REPOSITORY.StudentRepository;
import com.ritik.STUDENT.MANAGEMENT.SERVICE.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")

public class  StudentController {
    private final StudentService studentService;




    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents(){
//        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
    return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id){
       return ResponseEntity.ok( studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<StudentDto>  createNewStudent(@RequestBody AddStudentRequestsDto addStudentRequestsDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestsDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAllStudents(@PathVariable Long id){
      studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

}
