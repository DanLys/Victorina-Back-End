package org.victorina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * Created by Danil Lyskin at 15:01 05.02.2021
 */

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class VictorinaApplication {

    public static void main(String[] args) {
        SpringApplication.run(VictorinaApplication.class, args);
    }
}

