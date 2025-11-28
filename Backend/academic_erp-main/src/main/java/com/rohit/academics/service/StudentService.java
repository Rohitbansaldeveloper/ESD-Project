package com.rohit.academics.service;

import com.rohit.academics.entity.Student;
import com.rohit.academics.repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class StudentService {
    public final StudentRepo studentRepo;
    public List<Student> getStudentsByDomain(int domainId) {
        try {
            return studentRepo.findByDomain(domainId);
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve students for domain ID: " + domainId, e);
        }
    }
}
