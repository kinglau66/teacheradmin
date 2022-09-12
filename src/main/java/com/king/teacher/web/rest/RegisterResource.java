package com.king.teacher.web.rest;

import com.king.teacher.service.RegisterService;
import com.king.teacher.service.TeacherService;
import com.king.teacher.service.dto.AddTeacherAndStudentDTO;
import com.king.teacher.service.dto.RegisterDTO;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/register")
public class RegisterResource {

    private final Logger log = LoggerFactory.getLogger(RegisterResource.class);
    private final TeacherService teacherService;
    private final RegisterService registerService;

    public RegisterResource(TeacherService teacherService, RegisterService registerService) {
        this.teacherService = teacherService;
        this.registerService = registerService;
    }

    /**
     * used to add teacher
     * @param addTeacherDTO
     */
    @PostMapping("")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addRegisters(@Valid @RequestBody RegisterDTO registerDTO) {
        this.registerService.addRegistration(registerDTO);
    }
}
