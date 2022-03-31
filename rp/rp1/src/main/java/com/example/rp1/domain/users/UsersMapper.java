package com.example.rp1.domain.users;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UsersMapper {

    @Select("SELECT * FROM Users WHERE email = #{email} ")
    public Users findByEmail(@Param("email") String email);

    @Select("SELECT u.id ,u.code ,u.email, u.password ,u.first_name ,u.last_name ,u.first_name_kana ,u.last_name_kana ,d1.name as departmentName1,d2.name as departmentName2,d3.name as departmentName3,t.name as tenantName, u.tenant_id FROM Users u  LEFT JOIN Departments d1 on u.dno1 = d1.id LEFT JOIN Departments d2 on u.dno2 = d2.id  LEFT JOIN Departments d3 on u.dno3 = d3.id INNER JOIN Tenant t on u.tenant_id  = t.id   WHERE u.id = #{id} AND t.id = #{tenantId}")
    public LoginUserResult findLongiUser(@Param("id") Long id, @Param("tenantId") Long tenantId);

    @Select("SELECT * FROM Users WHERE id = #{id} AND tenant_id = #{tenantId}")
    public Users findById(@Param("id") Long id, @Param("tenantId") Long tenantId);

    @Select("SELECT * FROM Users WHERE tenant_id = #{tenantId}")
    public List<Users> findByTenantId(@Param("tenantId") Long tenantId);

    @Insert("INSERT INTO Users (code, email, password, first_name, last_name, first_name_kana, last_name_kana, tenant_id, dno1, dno2, dno3) VALUES (#{code}, #{email}, #{password}, #{firstName}, #{lastName}, #{firstNameKana}, #{lastNameKana}, #{tenantId}, #{dno1}, #{dno2}, #{dno3})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void save(Users users);

    @Update("UPDATE Users SET code = #{code},email = #{email},first_name = #{firstName},last_name = #{lastName},first_name_kana = #{firstNameKana},last_name_kana = #{lastNameKana},dno1 = #{dno1},dno2 = #{dno2},dno3 = #{dno3} WHERE id = #{id} AND tenant_id = #{tenantId}")
    public void update(Users users);

    @Delete("DELETE FROM Users WHERE id = #{id} AND tenant_id = #{tenantId}")
    public boolean delete(@Param("id") Long id, @Param("tenantId") Long tenantId);
}
