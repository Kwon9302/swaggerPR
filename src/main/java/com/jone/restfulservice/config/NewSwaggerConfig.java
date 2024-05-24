package com.jone.restfulservice.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition (
        info = @Info(title="Myrestful Service APi",
                     description = "Springboot Restful API입니당",
                     version="v1.0.0")
)
@RequiredArgsConstructor
public class
NewSwaggerConfig {
    @Bean
    public GroupedOpenApi customTestAPI(){
        String[] paths = {"/users/**", "/admin/**"};
        return GroupedOpenApi.builder()
                .group("일반 사용자와 관리자를 위한 User 도메인에대한 api")
                .pathsToMatch(paths)
                .build();
    }

}
