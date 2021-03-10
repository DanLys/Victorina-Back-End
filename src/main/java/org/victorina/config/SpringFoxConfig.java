package org.victorina.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * Created by Danil Lyskin at 22:08 10.03.2021
 */
@Configuration
@EnableSwagger2WebMvc
@Import(SpringDataRestConfiguration.class)
public class SpringFoxConfig {

    public static final String TASK = "Task";
    public static final String TASK_ANSWERS = "Task answers";
    public static final String TASK_PREVIEW = "Task preview";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/**"))
                .apis(RequestHandlerSelectors.basePackage("org.victorina.data_entities"))
                .build()
                .groupName("api")
                .tags(new Tag(TASK, "Task controller"))
                .tags(new Tag(TASK_ANSWERS, "Task answers controller"))
                .tags(new Tag(TASK_PREVIEW, "Task preview controller"))
                .useDefaultResponseMessages(false);
    }
}
