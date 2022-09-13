package com.king.teacher.service;

import com.king.teacher.domain.Student;
import com.king.teacher.domain.Teacher;
import com.king.teacher.repository.StudentRepository;
import com.king.teacher.repository.TeacherRepository;
import com.king.teacher.service.dto.SuspendDTO;
import com.king.teacher.web.rest.errors.BadRequestAlertException;
import com.king.teacher.web.rest.errors.ErrorConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service class for managing users.
 */
@Service
@Transactional
public class SuspendService {

    private final Logger log = LoggerFactory.getLogger(SuspendService.class);

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    public SuspendService(StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    public void addSuspend(SuspendDTO suspendDTO) {
        // TODO: if auth exist, uncomment
        //var teacher = teacherRepository.findByEmail(SecurityUtils.getCurrentUserLogin().orElseThrow(()->  new BadRequestAlertException("teacher does not exits", Teacher.class.getSimpleName(), ErrorConstants.ERR_VALIDATION)))
        Student student = studentRepository
            .findByEmail(suspendDTO.getStudent())
            .orElseThrow(() ->
                new BadRequestAlertException("student does not exits", Teacher.class.getSimpleName(), ErrorConstants.ERR_VALIDATION)
            );
        student.setSuspendInd("Y");
        this.studentRepository.save(student);
    }
}
