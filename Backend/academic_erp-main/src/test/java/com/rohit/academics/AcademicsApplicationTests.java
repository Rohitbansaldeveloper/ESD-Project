package com.rohit.academics;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.MOCK,
    properties = {
        "spring.main.allow-bean-definition-overriding=true",
        "spring.jpa.hibernate.ddl-auto=create-drop"
    }
)
@ActiveProfiles("test")
class AcademicsApplicationTests {

    @MockBean
    private ClientRegistrationRepository clientRegistrationRepository;

    @Test
    void contextLoads() {
        // Test that the application context loads successfully
    }
}
