package com.king.teacher.web.rest;

import com.king.teacher.service.StudentService;
import com.king.teacher.service.dto.AddTeacherAndStudentDTO;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentResource {

    private final Logger log = LoggerFactory.getLogger(StudentResource.class);
    private final StudentService studentService;

    public StudentResource(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * used to add teacher
     * @param addTeacherDTO
     */
    @PostMapping("")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addTeacher(@Valid @RequestBody AddTeacherAndStudentDTO addTeacherDTO) {
        this.studentService.addStudent(addTeacherDTO);
    }
}
