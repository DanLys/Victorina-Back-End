package org.victorina;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.victorina.data_entities.task.Task;
import org.victorina.data_entities.task_answers.TaskAnswers;
import org.victorina.dto.TaskAnswersDTO;
import org.victorina.dto.TaskDTO;

import java.util.Set;

/**
 * Created by Danil Lyskin at 15:01 05.02.2021
 */

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class VictorinaApplication {

    public static void main(String[] args) {
        SpringApplication.run(VictorinaApplication.class, args);
    }
}
