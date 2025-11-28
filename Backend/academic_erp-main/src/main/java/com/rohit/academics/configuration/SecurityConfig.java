package com.rohit.academics.configuration;

import com.rohit.academics.helper.RequestInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

@Configuration
public class SecurityConfig implements WebMvcConfigurer {

    private final RequestInterceptor requestInterceptor;

    public SecurityConfig(RequestInterceptor requestInterceptor) {
        this.requestInterceptor = requestInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // registry.addInterceptor(requestInterceptor)
        // .addPathPatterns("/**")
        // .excludePathPatterns("/api/v1/auth/**", "/api/v1/create-user");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
