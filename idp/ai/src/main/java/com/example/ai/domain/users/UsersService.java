package com.example.ai.domain.users;

import java.util.List;

import com.example.ai.domain.tenant.Tenant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private static final String INITIAL_PASSWORD = "initpassword";
    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Users createAdminUser(Tenant tenant) {
        Users adminUser = new Users();
        adminUser.setCode("0000");
        adminUser.setEmail("admin@" + tenant.getName());
        adminUser.setPassword(passwordEncoder.encode("adminpassword"));
        adminUser.setFirstName("admin");
        adminUser.setLastName("admin");
        adminUser.setFirstNameKana("アドミン");
        adminUser.setLastNameKana("アドミン");
        adminUser.setTenantId(tenant.getId());
        usersMapper.save(adminUser);
        return adminUser;
    }

    public Users createUser(String code, String email, String firstName, String lastName, String firstNameKana,
            String lastNameKana, Long dno1, Long dno2, Long dno3, Long tenantId) {
        Users user = new Users();
        user.setCode(code);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(INITIAL_PASSWORD));
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setFirstNameKana(firstNameKana);
        user.setLastNameKana(lastNameKana);
        if (dno1 != 0)
            user.setDno1(dno1);
        if (dno2 != 0)
            user.setDno2(dno2);
        if (dno3 != 0)
            user.setDno3(dno3);
        user.setTenantId(tenantId);
        usersMapper.save(user);
        return user;
    }

    public List<Users> getAllUsers(Long tenantId) {
        List<Users> users = usersMapper.findByTenantId(tenantId);
        return users;
    }

    public Users getUser(Long id, Long tenantId) {
        Users users = usersMapper.findById(id, tenantId);
        return users;
    }

    public LoginUserDto getLoginUser(Long id, Long tenantId) {
        LoginUserResult user = usersMapper.findLongiUser(id, tenantId);
        LoginUserDto loginUserDto = new LoginUserDto();
        loginUserDto.setId(user.getId());
        loginUserDto.setCode(user.getCode());
        loginUserDto.setEmail(user.getEmail());
        loginUserDto.setFirstName(user.getFirstName());
        loginUserDto.setLastName(user.getLastName());
        loginUserDto.setFirstNameKana(user.getFirstNameKana());
        loginUserDto.setLastNameKana(user.getLastNameKana());
        loginUserDto.setDepartmentName1(user.getDepartmentName1());
        loginUserDto.setDepartmentName2(user.getDepartmentName2());
        loginUserDto.setDepartmentName3(user.getDepartmentName3());
        loginUserDto.setTenantName(user.getTenantName());

        return loginUserDto;

    }

    public Users updateUsers(Long id, String code, String email, String firstName, String lastName,
            String firstNameKana, String lastNameKana, Long dno1, Long dno2, Long dno3, Long tenantId) {
        Users users = new Users();
        users.setId(id);
        users.setCode(code);
        users.setEmail(email);
        users.setFirstName(firstName);
        users.setLastName(lastName);
        users.setFirstNameKana(firstNameKana);
        users.setLastNameKana(lastNameKana);
        users.setDno1(dno1);
        users.setDno2(dno2);
        users.setDno3(dno3);
        if (dno1 == 0)
            users.setDno1(null);
        if (dno2 == 0)
            users.setDno2(null);
        if (dno3 == 0)
            users.setDno3(null);
        users.setTenantId(tenantId);
        usersMapper.update(users);
        return users;
    }

    public boolean deleteUsers(Long id, Long tenantId) {
        return usersMapper.delete(id, tenantId);
    }

}
