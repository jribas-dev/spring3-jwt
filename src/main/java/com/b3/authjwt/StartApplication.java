package com.b3.authjwt;

import com.b3.authjwt.entity.UserInfo;
import com.b3.authjwt.repository.UserInfoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StartApplication implements CommandLineRunner {
    private final UserInfoRepository repository;

    @Transactional
    @Override
    public void run(String... args) {
        Optional<UserInfo> adminFound = repository.findByName("admin");
        if(adminFound.isEmpty()){
            UserInfo user = new UserInfo();
            user.setName("admin");
            user.setEmail("admin@gmail.com");
            user.setPassword("$2y$10$O6oG46vicky8YVuhHtheL.ZyFXE1Z2dSs20Skh2KABlLF67JfqNWK"); // master123
            user.setRoles("ROLE_ADMIN");
            repository.save(user);
        }

        Optional<UserInfo> userFound = repository.findByName("user");
        if(userFound.isEmpty()){
            UserInfo user = new UserInfo();
            user.setName("user");
            user.setEmail("user@gmail.com");
            user.setPassword("$2y$10$yMkwkKMYQuAzQ1WkEGz4vuOUknlK6Yb3b1HrEKnT3gCZ6V5x0C6OC"); // user123
            user.setRoles("ROLE_USER");
            repository.save(user);
        }
    }
}
