package com.github.sofior.swagger;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xlz
 */
@Configuration
@EnableSwagger2
@EnableConfigurationProperties(SwaggerProperties.class)
public class SwaggerAutoConfiguration {

    private final SwaggerProperties properties;

    public SwaggerAutoConfiguration(SwaggerProperties properties) {
        this.properties = properties;
    }

    @Bean
    public Docket createRestApi() {
        List<Predicate<RequestHandler>> packages = new ArrayList<>(properties.getBasePackages().length);
        for (String basePackage : properties.getBasePackages()) {
            packages.add(RequestHandlerSelectors.basePackage(basePackage));
        }
        //noinspection unchecked
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(Predicates.or(packages.toArray(new Predicate[0])))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact(properties.getContactName(), properties.getContactUrl(), properties.getContactEmail());
        return new ApiInfo(properties.getTitle(), properties.getDescription(), properties.getVersion(), properties.getTermsOfServiceUrl(),
                contact, properties.getLicense(), properties.getLicenseUrl(), new ArrayList<>());
    }
}
