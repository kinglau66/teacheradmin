package com.king.teacher.service;

import com.king.teacher.IntegrationTest;
import com.king.teacher.repository.TeacherRepository;
import com.king.teacher.service.dto.AddTeacherAndStudentDTO;
import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import static org.junit.jupiter.api.Assertions.*;

@IntegrationTest
class TeacherServiceTest {


    @Autowired
    private TeacherService teacherService;
    @Autowired
    private TeacherRepository teacherRepository;


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addTeacher() {
        AddTeacherAndStudentDTO dto = new AddTeacherAndStudentDTO();
        String email = "test@test.com";
        dto.setEmail(email);
        dto.setName("tester1");
        teacherService.addTeacher(dto);
        assertSame("tester1", teacherRepository.findByEmail(email).get().getName());
        AddTeacherAndStudentDTO dto1 = new AddTeacherAndStudentDTO();
        dto1.setEmail("test@test.com");
        dto1.setName("same name with tester 1");
        // unable to save two record with same email
        assertThrows(DataIntegrityViolationException.class, ()->teacherService.addTeacher(dto));
    }
}
