package com.example.rp2.domain.tenant;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface TenantMapper {

    @Insert("INSERT INTO Tenant(name) VALUES (#{name})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    public void save(Tenant tenant);

}
