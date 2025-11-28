package com.rohit.academics.service;

import com.rohit.academics.dto.CreateDomainRequest;
import com.rohit.academics.entity.Domain;
import com.rohit.academics.repo.DomainRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DomainService {

    private final DomainRepo domainrepo;

    public DomainService(DomainRepo domainRepo) {
        this.domainrepo = domainRepo;
    }

    public String createDomain(CreateDomainRequest request) {
        try {
            Domain domain = Domain.builder()
                    .program(request.program())
                    .capacity(request.capacity())
                    .qualification(request.qualification())
                    .batch(request.batch())
                    .build();
            domainrepo.save(domain);
            return "Domain created successfully with ID: " + domain.getDomain_id();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create domain: " + e.getMessage(), e);
        }
    }

    public String modifyDomain(int domainId, CreateDomainRequest request) {
        try {
            Domain existingDomain = domainrepo.findById(domainId)
                    .orElseThrow(() -> new IllegalArgumentException("Domain with ID " + domainId + " not found"));

            if (request.program() != null) {
                existingDomain.setProgram(request.program());
            }
            if (request.batch() != null) {
                existingDomain.setBatch(request.batch());
            }
            if (request.capacity() != -1) {
                existingDomain.setCapacity(request.capacity());
            }
            if (request.qualification() != null) {
                existingDomain.setQualification(request.qualification());
            }

            domainrepo.save(existingDomain);
            return "Domain updated successfully with ID: " + existingDomain.getDomain_id();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid domain update request: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("Failed to update domain: " + e.getMessage(), e);
        }
    }

    public Domain getDomain(int domainId) {
        try {
            return domainrepo.findById(domainId)
                    .orElseThrow(() -> new IllegalArgumentException("Domain with ID " + domainId + " not found"));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error retrieving domain: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred: " + e.getMessage(), e);
        }
    }

    public List<Domain> getAllDomains() {
        try {
            return domainrepo.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve all domains: " + e.getMessage(), e);
        }
    }

    public String deleteDomain(int domainId){
        try {
            domainrepo.deleteById(domainId);
            return "domain deleted successfully with ID: " + domainId;
        } catch (Exception e) {
            throw new IllegalArgumentException("Domain with ID " + domainId + " not found");
        }
    }
}
