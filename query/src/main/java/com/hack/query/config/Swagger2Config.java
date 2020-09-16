package com.hack.query.config;

import org.springframework.context.annotation.Configuration;

@Configuration //标记配置类

public class Swagger2Config {
//    private final TypeResolver resolver;
//
//    @Autowired
//    public Swagger2Config(TypeResolver resolver) {
//        this.resolver = resolver;
//    }
//
//    @Autowired
//    public SwaggerConfig(TypeResolver resolver) {
//        this.resolver = resolver;
//    }
//
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .produces(Collections.singleton("application/json"))
//                .consumes(Collections.singleton("application/json"))
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.hack.query"))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(apiInfo()).alternateTypeRules(
//                        new RecursiveAlternateTypeRule(resolver,
//                                Arrays.asList(
//                                        AlternateTypeRules.newRule(
//                                                resolver.resolve(Mono.class, WildcardType.class),
//                                                resolver.resolve(WildcardType.class)),
//                                        AlternateTypeRules.newRule(
//                                                resolver.resolve(ResponseEntity.class, WildcardType.class),
//                                                resolver.resolve(WildcardType.class))
//                                )))
//                .alternateTypeRules(new RecursiveAlternateTypeRule(resolver,
//                        Arrays.asList(
//                                AlternateTypeRules.newRule(
//                                        resolver.resolve(Flux.class, WildcardType.class),
//                                        resolver.resolve(List.class, WildcardType.class)),
//                                AlternateTypeRules.newRule(
//                                        resolver.resolve(ResponseEntity.class, WildcardType.class),
//                                        resolver.resolve(WildcardType.class))
//                        ))
//                );
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("Example")
//                .description("Example API")
//                .termsOfServiceUrl("")
//                .version("0.0.1-SNAPSHOT")
//                .build();
//    }
}
