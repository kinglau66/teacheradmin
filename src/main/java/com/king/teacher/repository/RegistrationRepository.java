package com.king.teacher.repository;

import com.king.teacher.domain.Registration;
import com.king.teacher.domain.Teacher;
import com.king.teacher.domain.User;
import io.micrometer.core.instrument.Tags;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the {@link User} entity.
 */
@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    List<Registration> findByTeacher_EmailIn(List<String> email);

    @Query(value = "select r.student.email from Registration r where r.teacher.email in :emails")
    Set<String> findStudentByTeacher_EmailIn(@Param("emails") List<String> email);
}
