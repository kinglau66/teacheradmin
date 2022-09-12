package com.king.teacher.web.rest;

import com.king.teacher.repository.RegistrationRepository;
import com.king.teacher.service.RegisterService;
import com.king.teacher.service.TeacherService;
import com.king.teacher.service.dto.FindCommonStudentDTO;
import java.util.Set;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/commonstudents")
public class CommonStudentResource {

    private final Logger log = LoggerFactory.getLogger(CommonStudentResource.class);
    private final TeacherService teacherService;
    private final RegisterService registerService;

    public CommonStudentResource(TeacherService teacherService, RegisterService registerService) {
        this.teacherService = teacherService;
        this.registerService = registerService;
    }

    /**
     * used to add teacher
     *
     * @param addTeacherDTO
     * @return
     */
    @GetMapping("")
    public FindCommonStudentDTO findCommonStudents(@Valid @RequestParam("teacher") @NotEmpty Set<@Email String> teachers) {
        return this.registerService.getFindCommonStudentDTO(teachers);
    }
}
