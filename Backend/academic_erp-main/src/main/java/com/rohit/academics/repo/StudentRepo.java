package com.rohit.academics.repo;

import com.rohit.academics.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StudentRepo extends JpaRepository<Student, Integer> {
    List<Student> findByDomain(int domainId);
}
