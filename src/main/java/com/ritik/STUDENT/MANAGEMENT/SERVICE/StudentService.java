package com.ritik.STUDENT.MANAGEMENT.SERVICE;

import com.ritik.STUDENT.MANAGEMENT.DTO.AddStudentRequestsDto;
import com.ritik.STUDENT.MANAGEMENT.DTO.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);

    StudentDto createNewStudent(AddStudentRequestsDto addStudentRequestsDto);

    void deleteStudentById(Long id);
}
