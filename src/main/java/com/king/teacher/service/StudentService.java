package com.king.teacher.service;

import com.king.teacher.repository.StudentRepository;
import com.king.teacher.service.dto.AddTeacherAndStudentDTO;
import com.king.teacher.service.mapper.TeacherMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service class for managing users.
 */
@Service
@Transactional
public class StudentService {

    private final Logger log = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository studentRepository;
    private final TeacherMapper teacherMapper;

    public StudentService(StudentRepository studentRepository, TeacherMapper teacherMapper) {
        this.studentRepository = studentRepository;
        this.teacherMapper = teacherMapper;
    }

    public void addStudent(AddTeacherAndStudentDTO addTeacherAndStudentDTO) {
        this.studentRepository.save(this.teacherMapper.addTeacherDTOToStudent(addTeacherAndStudentDTO));
    }
}
