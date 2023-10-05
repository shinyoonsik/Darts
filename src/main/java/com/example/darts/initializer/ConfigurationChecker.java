package com.example.darts.initializer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ConfigurationChecker implements CommandLineRunner {

    private final Environment env;

    @Override
    public void run(String... args) throws Exception {
        String property = env.getProperty("spring.profiles.active");
        log.info("current-profile: {}",property);
    }
}
