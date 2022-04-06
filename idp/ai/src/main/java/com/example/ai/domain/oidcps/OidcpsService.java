package com.example.ai.domain.oidcps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OidcpsService {

    private static final String CLIENT_ID = "ai-app";
    private static final String CLIENT_SECRET = "/auth/realms";
    private static final String CLIENT_NAME = "/auth/realms";
    private static final String PROVIDER = "/auth/realms";
    private static final String SCOPE = "/auth/realms";
    private static final String REDIRECT_URI_TEMPLATE = "/auth/realms";
    private static final String CLIENT_AUTHENTICATION_METHOD = "/auth/realms";
    private static final String AUTHORIZATION_GRANT_TYPE = "/auth/realms";
    private static final String USER_NAME_ATTRIVUTE = "/auth/realms";

    private static final String REALMS_URI = "/auth/realms";
    private static final String REALM = "/auth/realms";
    private static final String OPIDC_PROTOCOL = "/protocol/openid-connect";

    private static final String AUTHORIZATION_URI = REALMS_URI + REALM + OPIDC_PROTOCOL + "/auth";
    private static final String TOKEN_URI = REALMS_URI + REALM + OPIDC_PROTOCOL + "/token";
    private static final String USERINFO_URI = REALMS_URI + REALM + OPIDC_PROTOCOL + "/userinfo";
    private static final String JWKSET_URI = REALMS_URI + REALM + OPIDC_PROTOCOL + "/certs";

    @Autowired
    private OidcpsMapper oidcpsMapper;

    // public Oidcps createOidcps(Long tenantId)

    public OidcpsDto getOidcps(Long tenantId) {
        Oidcps oidcps = oidcpsMapper.findByTenantId(tenantId);
        OidcpsDto dto = new OidcpsDto();
        dto.setId(oidcps.getId());
        dto.setTenantId(oidcps.getTenantId());
        dto.setClientId(oidcps.getClientId());
        dto.setClientSecret(oidcps.getClientSecret());
        dto.setClientName(oidcps.getClientName());
        dto.setProvider(oidcps.getProvider());
        dto.setScope(oidcps.getScope());
        dto.setRedirectUriTemplate(oidcps.getRedirectUriTemplate());
        dto.setClientAuthenticationMethod(oidcps.getClientAuthenticationMethod());
        dto.setAuthorizationGrantType(oidcps.getAuthorizationGrantType());
        dto.setAuthorizationDomain(oidcps.getAuthorizationDomain());
        dto.setUserNameAttribute(oidcps.getUserNameAttribute());
        dto.setAuthorizationUri(oidcps.getAuthorizationDomain() + AUTHORIZATION_URI);
        dto.setTokenUri(oidcps.getAuthorizationDomain() + TOKEN_URI);
        dto.setUserInfoUri(oidcps.getAuthorizationDomain() + USERINFO_URI);
        dto.setJwkSetUri(oidcps.getAuthorizationDomain() + JWKSET_URI);

        return dto;
    }

}
