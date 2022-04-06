package com.example.ai.domain.oidcps;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OidcpsMapper {

    @Select("SELECT * FROM Oidcps WHERE tenant_id = #{tenantId}")
    public Oidcps findByTenantId(@Param("tenantId") Long tenantId);

    @Insert("INSERT INTO Oidcps (tenant_id, client_id, client_secret, client_name, provider, scope, redirect_uri_template, client_authentication_method, authorization_grant_type, authorization_domain, user_name_attribute)VALUES(#{tenantId}, #{clientId}, #{clientSecret}, #{clientName}, #{provider}, #{scope}, #{redirectUriTemplate}, #{clientAuthenticationMethod}, #{authorizationGrantType}, #{authorizationDomain}, #{userNameAttribute})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public Oidcps save(Oidcps oidcps);
}
