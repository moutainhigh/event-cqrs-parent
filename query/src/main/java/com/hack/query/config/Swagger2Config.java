package com.hack.query.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

@Configuration
@EnableSwagger2WebFlux
public class Swagger2Config {
    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(swaggerApiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.hack.query"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo swaggerApiInfo() {
        return new ApiInfoBuilder().title("webflux-swagger2 API doc")
                .description("how to use this")
                .termsOfServiceUrl("https://github.com/Gsealy")
                .contact(new Contact("Lmax", "", "[email protected]"))
                .version("1.0")
                .build();
    }
}
