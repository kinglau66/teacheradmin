package com.king.teacher.service;

import com.king.teacher.repository.TeacherRepository;
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
public class TeacherService {

    private final Logger log = LoggerFactory.getLogger(TeacherService.class);

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    public TeacherService(TeacherRepository teacherRepository, TeacherMapper teacherMapper) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
    }

    public void addTeacher(AddTeacherAndStudentDTO addTeacherDTO) {
        this.teacherRepository.save(this.teacherMapper.addTeacherDTOToTeacher(addTeacherDTO));
    }
}
