package com.rohit.academics.service;

import com.rohit.academics.dto.LoginResponse;
import com.rohit.academics.entity.User;
import com.rohit.academics.dto.CreateUserRequest;
import com.rohit.academics.dto.LoginRequest;
import com.rohit.academics.helper.EncryptionService;
import com.rohit.academics.helper.JWTHelper;
import org.springframework.stereotype.Service;
import com.rohit.academics.repo.CustomerRepo;

import java.util.Optional;

@Service
public class AdminService {

    private final CustomerRepo customerRepo;
    private final EncryptionService encryptionService;
    private final JWTHelper jwtHelper;

    public AdminService(CustomerRepo customerRepo,
            EncryptionService encryptionService,
            JWTHelper jwtHelper) {
        this.customerRepo = customerRepo;
        this.encryptionService = encryptionService;
        this.jwtHelper = jwtHelper;
    }

    public LoginResponse login(LoginRequest request) {
        java.util.Optional<User> userOptional = customerRepo.findByEmail(request.email());
        System.out.println("Login attempt for: " + request.email());
        if (userOptional.isEmpty()) {
            System.out.println("User not found: " + request.email());
            throw new IllegalArgumentException("User not found");
        }

        User user = userOptional.get();
        System.out.println("User found: " + user.getEmail() + ", Role: " + user.getRole());
        if (!"admin".equals(user.getRole())) {
            System.out.println("Role mismatch. Expected admin, got: " + user.getRole());
            throw new IllegalArgumentException("Only Admin can Login");
        }

        if (!encryptionService.validates(request.password(), user.getPassword())) {
            System.out.println("Password mismatch for: " + request.email());
            throw new IllegalArgumentException("Wrong Password or Email");
        }

        String token = jwtHelper.generateToken(user.getEmail());
        return new LoginResponse(user.getUser_id(), user.getEmail(), user.getRole(), user.getName(), token);
    }

    public String createUser(CreateUserRequest request) {
        User user = User.builder()
                .name(request.name())
                .email(request.email())
                .password(encryptionService.encode(request.password()))
                .role(request.role())
                .build();
        customerRepo.save(user);
        return "User Created Successfully";
    }

    private User getUser(String email) {
        return customerRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
