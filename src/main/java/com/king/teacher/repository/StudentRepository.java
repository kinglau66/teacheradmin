package com.king.teacher.repository;

import com.king.teacher.domain.Student;
import com.king.teacher.domain.Teacher;
import com.king.teacher.domain.User;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the {@link User} entity.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByEmail(String email);
    List<Student> findByEmailIn(Set<String> email);
}
