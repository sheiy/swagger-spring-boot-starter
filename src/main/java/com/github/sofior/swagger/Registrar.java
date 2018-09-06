package com.github.sofior.swagger;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sofior
 * @date 2018/9/7 00:55
 */
public class Registrar implements ImportBeanDefinitionRegistrar, BeanFactoryAware {

    private ConfigurableListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        if (beanFactory instanceof ConfigurableListableBeanFactory) {
            this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
        }
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        if (this.beanFactory == null) {
            return;
        }
        SwaggerProperties swaggerProperties = this.beanFactory.getBean(SwaggerProperties.class);

        swaggerProperties.getDockets().forEach((docketName, docketProperties) -> {
            List<Predicate<RequestHandler>> packages = new ArrayList<>(docketProperties.getBasePackages().length);
            for (String basePackage : docketProperties.getBasePackages()) {
                packages.add(RequestHandlerSelectors.basePackage(basePackage));
            }
            //noinspection unchecked
            Docket docket = new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(Predicates.or(packages.toArray(new Predicate[0])))
                    .paths(PathSelectors.any())
                    .build()
                    .apiInfo(apiInfo(docketProperties));

            BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(Docket.class);
            builder.addConstructorArgValue(docketProperties.getType());
            builder.addPropertyValue("apiSelector",docket.)

            beanDefinitionRegistry.registerBeanDefinition(docketName,);


        });

    }

    private ApiInfo apiInfo(DocketProperties properties) {
        Contact contact = new Contact(properties.getContactName(), properties.getContactUrl(), properties.getContactEmail());
        return new ApiInfo(properties.getTitle(), properties.getDescription(), properties.getVersion(), properties.getTermsOfServiceUrl(),
                contact, properties.getLicense(), properties.getLicenseUrl(), new ArrayList<>());
    }
}
