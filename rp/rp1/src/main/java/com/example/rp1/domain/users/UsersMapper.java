package com.example.rp1.domain.users;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UsersMapper {

    @Select("SELECT * FROM Users WHERE email = #{email}")
    public Users findByEmail(@Param("email") String email);

    @Select("SELECT * FROM Users WHERE id = #{id} AND tenant_id = #{tenantId}")
    public Users findById(@Param("id") Integer id, @Param("tenantId") Integer tenantId);

    @Select("SELECT * FROM Users WHERE tenant_id = #{tenantId}")
    public List<Users> findByTenantId(@Param("tenantId") Integer tenantId);

    @Insert("INSERT INTO Users (code, email, password, first_name, last_name, first_name_kana, last_name_kana, tenant_id, dno1, dno2, dno3) VALUES (#{code}, #{email}, #{password}, #{firstName}, #{lastName}, #{firstNameKana}, #{lastNameKana}, #{tenantId}, #{dno1}, #{dno2}, #{dno3})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void save(Users users);

    @Update("UPDATE Users SET code = #{code},email = #{email},first_name = #{firstName},last_name = #{lastName},first_name_kana = #{firstNameKana},last_name_kana = #{lastNameKana},dno1 = #{dno1},dno2 = #{dno2},dno3 = #{dno3} WHERE id = #{id} AND tenant_id = #{tenantId}")
    public void update(Users users);
}
