package com.sahil.Public.Road.Transparency.Accountability.System.config;

import com.sahil.Public.Road.Transparency.Accountability.System.entity.User;
import com.sahil.Public.Road.Transparency.Accountability.System.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.time.LocalDateTime;

@Configuration
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            User admin = User.builder()
                    .username("Sahil Malaiya")
                    .password(passwordEncoder.encode("Sahil@123"))
                    .fullName("System Administrator")
                    .email("sahilmalaiya-admin@road.gov.in")
                    .role("ROLE_ADMIN")
                    .createdAt(LocalDateTime.now())
                    .build();

            userRepository.save(admin);
            System.out.println("Default admin user created: username=Sahil Malaiya, password=Sahil@123");
        } else {
            System.out.println("Admin user already exists, skipping data load...");
        }
    }
}
