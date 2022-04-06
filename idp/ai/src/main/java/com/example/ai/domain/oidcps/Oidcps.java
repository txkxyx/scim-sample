package com.example.ai.domain.oidcps;

public class Oidcps {
    private Long id;
    private String tenantId;
    private String clientId;
    private String clientSecret;
    private String clientName;
    private String provider;
    private String scope;
    private String redirectUriTemplate;
    private String clientAuthenticationMethod;
    private String authorizationGrantType;
    private String authorizationDomain;
    private String userNameAttribute;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getRedirectUriTemplate() {
        return redirectUriTemplate;
    }

    public void setRedirectUriTemplate(String redirectUriTemplate) {
        this.redirectUriTemplate = redirectUriTemplate;
    }

    public String getClientAuthenticationMethod() {
        return clientAuthenticationMethod;
    }

    public void setClientAuthenticationMethod(String clientAuthenticationMethod) {
        this.clientAuthenticationMethod = clientAuthenticationMethod;
    }

    public String getAuthorizationGrantType() {
        return authorizationGrantType;
    }

    public void setAuthorizationGrantType(String authorizationGrantType) {
        this.authorizationGrantType = authorizationGrantType;
    }

    public String getAuthorizationDomain() {
        return authorizationDomain;
    }

    public void setAuthorizationDomain(String authorizationDomain) {
        this.authorizationDomain = authorizationDomain;
    }

    public String getUserNameAttribute() {
        return userNameAttribute;
    }

    public void setUserNameAttribute(String userNameAttribute) {
        this.userNameAttribute = userNameAttribute;
    }

}
