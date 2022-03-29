package com.example.rp1.domain.users;

import java.util.List;

import javax.transaction.Transactional;

import com.example.rp1.domain.departments.Departments;
import com.example.rp1.domain.tenant.Tenant;

import org.aspectj.apache.bcel.classfile.Module.Uses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    private static final String INITIAL_PASSWORD = "initpassword";
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
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
        return usersRepository.save(adminUser);
    }

    @Transactional
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
        return usersRepository.save(user);
    }

    @Transactional
    public List<Users> getAllUsers(Integer tenantId) {
        List<Users> users = usersRepository.findByTenantId(tenantId);
        return users;
    }

}
