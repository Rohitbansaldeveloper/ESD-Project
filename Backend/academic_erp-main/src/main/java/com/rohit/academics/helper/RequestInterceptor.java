package com.rohit.academics.helper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class RequestInterceptor implements HandlerInterceptor {
    private final JWTHelper jwtHelper;

    public RequestInterceptor(JWTHelper jwtHelper) {
        this.jwtHelper = jwtHelper;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("RequestInterceptor: " + request.getRequestURI());
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        String token = authorizationHeader.substring(7); // Extract token from "Bearer {token}"
        String username = jwtHelper.extractUsername(token);

        if (username == null || !jwtHelper.validateToken(token, username)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        return true;
    }
}
