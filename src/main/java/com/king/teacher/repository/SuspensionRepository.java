package com.king.teacher.repository;

import com.king.teacher.domain.Suspension;
import com.king.teacher.domain.Teacher;
import com.king.teacher.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the {@link User} entity.
 */
@Repository
public interface SuspensionRepository extends JpaRepository<Suspension, Long> {}
