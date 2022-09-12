package com.king.teacher.service;

import com.king.teacher.domain.Registration;
import com.king.teacher.domain.Teacher;
import com.king.teacher.repository.RegistrationRepository;
import com.king.teacher.repository.StudentRepository;
import com.king.teacher.repository.TeacherRepository;
import com.king.teacher.service.dto.FindCommonStudentDTO;
import com.king.teacher.service.dto.RegisterDTO;
import com.king.teacher.service.mapper.TeacherMapper;
import com.king.teacher.web.rest.errors.BadRequestAlertException;
import com.king.teacher.web.rest.errors.ErrorConstants;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.constraints.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service class for managing users.
 */
@Service
@Transactional
public class RegisterService {

    private final Logger log = LoggerFactory.getLogger(RegisterService.class);

    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;
    private final RegistrationRepository registrationRepository;
    private final TeacherMapper teacherMapper;

    public RegisterService(
        TeacherRepository teacherRepository,
        StudentRepository studentRepository,
        RegistrationRepository registrationRepository,
        TeacherMapper teacherMapper
    ) {
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
        this.registrationRepository = registrationRepository;
        this.teacherMapper = teacherMapper;
    }

    public void addRegistration(RegisterDTO registerDTO) {
        Teacher teacher = teacherRepository
            .findByEmail(registerDTO.getTeacher())
            .orElseThrow(() -> new BadRequestAlertException("missing teacher", Teacher.class.getSimpleName(), ErrorConstants.ERR_VALIDATION)
            );
        List<Registration> registrations = studentRepository
            .findByEmailIn(registerDTO.getStudents())
            .stream()
            .map(item -> Registration.builder().student(item).teacher(teacher).build())
            .collect(Collectors.toList());
        if (registrations.isEmpty()) {
            throw new BadRequestAlertException("missing students", Teacher.class.getSimpleName(), ErrorConstants.ERR_VALIDATION);
        }
        this.registrationRepository.saveAll(registrations);
    }

    public FindCommonStudentDTO getFindCommonStudentDTO(Set<@Email String> teachers) {
        return FindCommonStudentDTO
            .builder()
            .students(this.registrationRepository.findStudentByTeacher_EmailIn(List.copyOf(teachers)))
            .build();
    }
}
