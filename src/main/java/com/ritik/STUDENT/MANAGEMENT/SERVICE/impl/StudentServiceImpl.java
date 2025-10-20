package com.ritik.STUDENT.MANAGEMENT.SERVICE.impl;

import com.ritik.STUDENT.MANAGEMENT.DTO.AddStudentRequestsDto;
import com.ritik.STUDENT.MANAGEMENT.DTO.StudentDto;
import com.ritik.STUDENT.MANAGEMENT.ENTITY.STUDENT;
import com.ritik.STUDENT.MANAGEMENT.REPOSITORY.StudentRepository;
import com.ritik.STUDENT.MANAGEMENT.SERVICE.StudentService;
import com.ritik.STUDENT.MANAGEMENT.StudentManagementApplication;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<StudentDto> getAllStudents() {
        List<STUDENT> students =studentRepository.findAll();
        return students
                .stream().map(student ->  modelMapper.map(student,StudentDto.class)).toList();
    }

    @Override
    public StudentDto getStudentById(Long id) {
        STUDENT student = studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException(("student not found with ID" +id)));
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public StudentDto createNewStudent(AddStudentRequestsDto addStudentRequestsDto) {
        STUDENT newStudent = modelMapper.map(addStudentRequestsDto,STUDENT.class);
        STUDENT student =studentRepository.save(newStudent);
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student does not exists by id" + id);
        }
        studentRepository.deleteById(id);

    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentRequestsDto addStudentRequestsDto) {
        STUDENT student = studentRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException(("student not found with ID" +id)));
    modelMapper.map(addStudentRequestsDto,student);
    student=studentRepository.save(student);
    return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public StudentDto updatePartialStudent(Long id, Map<String, Object> updates) {
        STUDENT student = studentRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("student not found with ID" +id));
        updates.forEach((field,value) ->{
            switch (field) {
                case "name":student.setName((String) value);
                break;
                case "email":student.setEmail((String) value);
                break;
                default :
                    throw new IllegalArgumentException(("Field is not supported"));
            }
        });
       STUDENT savedstudent=studentRepository.save(student);
        return modelMapper.map(savedstudent,StudentDto.class);
    }
}
