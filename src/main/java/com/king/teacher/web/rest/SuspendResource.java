package com.king.teacher.web.rest;

import com.king.teacher.service.RegisterService;
import com.king.teacher.service.SuspendService;
import com.king.teacher.service.TeacherService;
import com.king.teacher.service.dto.FindCommonStudentDTO;
import com.king.teacher.service.dto.SuspendDTO;
import java.util.Set;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/suspend")
public class SuspendResource {

    private final Logger log = LoggerFactory.getLogger(SuspendResource.class);
    private final SuspendService suspendService;

    public SuspendResource(SuspendService suspendService) {
        this.suspendService = suspendService;
    }

    /**
     * used to add teacher
     *
     * @param suspendDTO
     * @return
     */
    @PostMapping("")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void suspendStudent(@Valid @RequestBody SuspendDTO suspendDTO) {
        this.suspendService.addSuspend(suspendDTO);
    }
}
