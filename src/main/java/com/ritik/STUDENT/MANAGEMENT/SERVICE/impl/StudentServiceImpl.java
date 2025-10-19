package com.ritik.STUDENT.MANAGEMENT.SERVICE.impl;

import com.ritik.STUDENT.MANAGEMENT.DTO.StudentDto;
import com.ritik.STUDENT.MANAGEMENT.ENTITY.STUDENT;
import com.ritik.STUDENT.MANAGEMENT.REPOSITORY.StudentRepository;
import com.ritik.STUDENT.MANAGEMENT.SERVICE.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    @Override
    public List<StudentDto> getAllStudents() {
        List<STUDENT> students =studentRepository.findAll();
        return students
                .stream().map(student -> new StudentDto(student.getId(),student.getName(),student.getEmail())).toList();
    }
}
