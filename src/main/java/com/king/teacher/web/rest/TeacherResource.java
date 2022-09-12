package com.king.teacher.web.rest;

import com.king.teacher.service.TeacherService;
import com.king.teacher.service.dto.AddTeacherAndStudentDTO;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teachers")
public class TeacherResource {

    private final Logger log = LoggerFactory.getLogger(TeacherResource.class);
    private final TeacherService teacherService;

    public TeacherResource(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    /**
     * used to add teacher
     * @param addTeacherDTO
     */
    @PostMapping("")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void addTeacher(@Valid @RequestBody AddTeacherAndStudentDTO addTeacherDTO) {
        this.teacherService.addTeacher(addTeacherDTO);
    }
}
