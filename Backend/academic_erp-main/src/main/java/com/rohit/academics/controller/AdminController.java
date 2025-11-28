package com.rohit.academics.controller;

import com.rohit.academics.dto.CreateUserRequest;
import com.rohit.academics.dto.LoginRequest;
import com.rohit.academics.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin
public class AdminController {
    private final AdminService adminservice;

    public AdminController(AdminService adminService) {
        this.adminservice = adminService;
    }

    @PostMapping("auth/admin/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequest request){
        return ResponseEntity.ok(adminservice.login(request));
    }

    @PostMapping("create-user")
    public ResponseEntity<String> createUser(@RequestBody @Valid CreateUserRequest request) {
        String response = adminservice.createUser(request);
        return ResponseEntity.ok(response);
    }
}
