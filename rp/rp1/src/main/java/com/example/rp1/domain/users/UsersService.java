package com.example.rp1.domain.users;

import java.util.List;

import com.example.rp1.domain.tenant.Tenant;

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
            String lastNameKana, Integer dno1, Integer dno2, Integer dno3, Integer tenantId) {
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
            user.setDno1(dno2);
        if (dno3 != 0)
            user.setDno1(dno3);
        user.setTenantId(tenantId);
        usersMapper.save(user);
        return user;
    }

    public List<Users> getAllUsers(Integer tenantId) {
        List<Users> users = usersMapper.findByTenantId(tenantId);
        return users;
    }

    public Users getUser(Integer id, Integer tenantId) {
        Users users = usersMapper.findById(id, tenantId);
        return users;
    }

    public Users updateUsers(Integer id, String code, String email, String firstName, String lastName,
            String firstNameKana, String lastNameKana, Integer dno1, Integer dno2, Integer dno3, Integer tenantId) {
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
        users.setTenantId(tenantId);
        usersMapper.update(users);
        return users;
    }

}
