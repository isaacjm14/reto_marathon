package com.marathon.reto.model.configuration;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.marathon.reto.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .securitySchemes(securitySchemes())
                .tags(new Tag("Reto Marathon", "Contiene los servicios que obtiene la informacion relacionada al reto"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("API de Microservicios de reto marathon").version("1.0.0").build();
    }

    private static List<? extends SecurityScheme> securitySchemes() {
        return Arrays.asList(new ApiKey("Bearer", "Authorization", "header"));
    }

}