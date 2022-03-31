package com.example.rp1.domain.departments;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DepartmentsMapper {

    @Select("SELECT * FROM Departments WHERE tenant_id = #{tenantId}")
    public List<Departments> findByTenantId(@Param("tenantId") Long tenantId);

    @Select("SELECT * FROM Departments WHERE id = #{id} AND tenant_id = #{tenantId}")
    public Departments findById(@Param("id") Long id, @Param("tenantId") Long tenantId);

    @Insert("INSERT INTO Departments (code, name, tenant_id) VALUES (#{code}, #{name}, #{tenantId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void save(Departments departments);

    @Update("UPDATE Departments SET code = #{code}, name = #{name}  WHERE id = #{id} AND tenant_id = #{tenantId}")
    public void update(Departments departments);

    @Delete("DELETE FROM Departments WHERE id = #{id} AND tenant_id = #{tenantId}")
    public boolean delete(@Param("id") Long id, @Param("tenantId") Long tenantId);

}
