package com.github.sofior.swagger;

import org.springframework.boot.context.properties.ConfigurationProperties;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author : sofior
 * @date : 2018/7/21 下午 11:52
 */
@ConfigurationProperties(prefix = SwaggerProperties.SWAGGER_PREFIX)
public class SwaggerProperties {

    public static final String SWAGGER_PREFIX = "swagger";

    private Map<String,DocketProperties> dockets;

    public Map<String, DocketProperties> getDockets() {
        return dockets;
    }

    public void setDockets(Map<String, DocketProperties> dockets) {
        this.dockets = dockets;
    }
}
