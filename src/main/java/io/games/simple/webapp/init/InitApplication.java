package io.games.simple.webapp.init;

import io.games.simple.webapp.entity.UserEntity;
import io.games.simple.webapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class InitApplication implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired UserService userService;
    @Autowired PasswordEncoder passwordEncoder;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("Init app");
        if (isDatabaseFresh()) {
            logger.info("Database fresh, initialization started");
            initDatabase();
            logger.info("DATABASE INITIALIZED");
        } else {
            logger.info("Database have data. Initializing not executed.");
        }
    }

    private void initDatabase(){
        addUsers();
    }

    private void addUsers() {
        userService.save(UserEntity.builder()
                .email("admin@poczta.pl").password(passwordEncoder.encode("admin"))
                .build());
        userService.save(UserEntity.builder()
                .email("tomek@poczta.pl").password(passwordEncoder.encode("tomek"))
                .build());
    }

    private boolean isDatabaseFresh(){
        return userService.count() == 0;
    }

}
