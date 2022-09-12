package com.king.teacher.service.mapper;

import com.king.teacher.domain.Student;
import com.king.teacher.domain.Teacher;
import com.king.teacher.repository.RegistrationRepository;
import com.king.teacher.service.dto.AddTeacherAndStudentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = { RegistrationRepository.class })
public interface RegistrationMapper {}
