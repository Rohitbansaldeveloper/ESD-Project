package com.rohit.academics.dto;

public record LoginResponse(int userId, String email, String role, String name,String jwt) { }
