package com.rohit.academics.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int user_id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    // Default constructor
    public User() {
    }

    // All-args constructor
    public User(int user_id, String name, String email, String password, String role) {
        this.user_id = user_id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Getters and Setters
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Builder pattern implementation
    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public static class UserBuilder {
        private int user_id;
        private String name;
        private String email;
        private String password;
        private String role;

        public UserBuilder user_id(int user_id) {
            this.user_id = user_id;
            return this;
        }

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder role(String role) {
            this.role = role;
            return this;
        }

        public User build() {
            User user = new User();
            user.setUser_id(this.user_id);
            user.setName(this.name);
            user.setEmail(this.email);
            user.setPassword(this.password);
            user.setRole(this.role);
            return user;
        }
    }
}
