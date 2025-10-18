package com.ritik.STUDENT.MANAGEMENT.REPOSITORY;

import com.ritik.STUDENT.MANAGEMENT.ENTITY.STUDENT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<STUDENT,Long> {
}
