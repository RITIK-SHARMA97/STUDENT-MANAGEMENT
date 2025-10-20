package com.ritik.STUDENT.MANAGEMENT.SERVICE;

import com.ritik.STUDENT.MANAGEMENT.DTO.AddStudentRequestsDto;
import com.ritik.STUDENT.MANAGEMENT.DTO.StudentDto;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);

    StudentDto createNewStudent(AddStudentRequestsDto addStudentRequestsDto);

    void deleteStudentById(Long id);

    StudentDto updateStudent(Long id, AddStudentRequestsDto addStudentRequestsDto);

    StudentDto updatePartialStudent(Long id, Map<String, Object> updates);
}
