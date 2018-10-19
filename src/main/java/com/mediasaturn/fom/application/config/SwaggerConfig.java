package com.mediasaturn.fom.application.config;

import io.vavr.collection.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket availabilityApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                   .protocols(List.of("http", "https").toJavaSet())
                   .globalOperationParameters( List.of(new ParameterBuilder()
                                                           .name("X-Country")
                                                           .description("Country ISO2")
                                                           .modelRef(new ModelRef("string"))
                                                           .parameterType("header")
                                                           .required(true)
                                                           .build())
                                                   .toJavaList()
                   ).select()
                   .apis(RequestHandlerSelectors.any())
                   .paths(regex("/reser.*|/canc.*"))
                   .build();
    }
}
