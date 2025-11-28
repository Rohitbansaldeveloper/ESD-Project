package com.rohit.academics.service;

import com.rohit.academics.entity.User;
import com.rohit.academics.repository.UserRepository;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomOidcUserService extends OidcUserService {

    private final UserRepository userRepository;

    public CustomOidcUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {
        OidcUser oidcUser = super.loadUser(userRequest);
        String email = oidcUser.getAttribute("email");

        if (email == null || !email.equals("rohitbansal2113@gmail.com")) {
            throw new OAuth2AuthenticationException("Only rohitbansal2113@gmail.com is allowed.");
        }

        // Check if user exists in database and get the user
        User existingUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new OAuth2AuthenticationException("User not registered. Please sign up first."));

        // Update user's name if it has changed
        existingUser.setName(oidcUser.getAttribute("name"));
        userRepository.save(existingUser);

        return oidcUser;
    }
}
