package com.rohit.academics.controller;

import com.rohit.academics.entity.Domain;
import com.rohit.academics.dto.CreateDomainRequest;
import com.rohit.academics.service.DomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/domain")
@CrossOrigin
public class DomainController {
    private final DomainService domainservice;

    public DomainController(DomainService domainservice) {
        this.domainservice = domainservice;
    }

    @PostMapping("/createdomain")
    public ResponseEntity<String> createDomain(@RequestBody CreateDomainRequest request) {
        try {
            return ResponseEntity.ok(domainservice.createDomain(request));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error creating domain: " + e.getMessage());
        }
    }

    @PutMapping("/modify/{domainId}")
    public ResponseEntity<String> modifyDomain(
            @PathVariable int domainId,
            @RequestBody CreateDomainRequest request) {
        try {
            return ResponseEntity.ok(domainservice.modifyDomain(domainId, request));
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error modifying domain: " + e.getMessage());
        }
    }

    @GetMapping("/{domainId}")
    public ResponseEntity<Domain> getDomain(@PathVariable int domainId) {
        try {
            Domain domain = domainservice.getDomain(domainId);
            return ResponseEntity.ok(domain);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(null); // Not found
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null); // Internal server error
        }
    }

    @GetMapping
    public ResponseEntity<List<Domain>> getDomains() {
        try {
            List<Domain> domains = domainservice.getAllDomains();
            return ResponseEntity.ok(domains);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @DeleteMapping("/{domainId}")
    public ResponseEntity<String>deleteDomain(@PathVariable int domainId){
        try{
            String op=domainservice.deleteDomain(domainId);
            return ResponseEntity.ok(op);
        }
        catch(Exception e){
            return ResponseEntity.status(404).body(null);
        }
    }
}



