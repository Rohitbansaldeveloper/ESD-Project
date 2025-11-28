package com.rohit.academics.repo;

import com.rohit.academics.entity.Domain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomainRepo extends JpaRepository<Domain, Integer> {

}
