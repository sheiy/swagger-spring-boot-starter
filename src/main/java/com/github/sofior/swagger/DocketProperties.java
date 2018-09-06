package com.github.sofior.swagger;

import springfox.documentation.spi.DocumentationType;

/**
 * @author sofior
 * @date 2018/9/7 01:21
 */
public class DocketProperties {

    private DocumentationType type;

    private String[] basePackages;

    private String title="Api Documentation";

    private String description="Api Documentation";

    private String termsOfServiceUrl="urn:tos";

    private String version="1.0";

    private String license="Apache 2.0";

    private String licenseUrl="http://www.apache.org/licenses/LICENSE-2.0";

    private String contactName="";

    private String contactUrl="";

    private String contactEmail="";

    public DocumentationType getType() {
        return type;
    }

    public void setType(DocumentationType type) {
        this.type = type;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getLicenseUrl() {
        return licenseUrl;
    }

    public void setLicenseUrl(String licenseUrl) {
        this.licenseUrl = licenseUrl;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactUrl() {
        return contactUrl;
    }

    public void setContactUrl(String contactUrl) {
        this.contactUrl = contactUrl;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTermsOfServiceUrl() {
        return termsOfServiceUrl;
    }

    public void setTermsOfServiceUrl(String termsOfServiceUrl) {
        this.termsOfServiceUrl = termsOfServiceUrl;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String[] getBasePackages() {
        return basePackages;
    }

    public void setBasePackages(String[] basePackages) {
        this.basePackages = basePackages;
    }
}
