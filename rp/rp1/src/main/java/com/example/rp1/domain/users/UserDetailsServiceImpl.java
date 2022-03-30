package com.example.rp1.domain.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// @Component("UserDetailsServiceImpl")
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersMapper usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users loginUser = usersRepository.findByEmail(username);
        if (loginUser == null)
            throw new UsernameNotFoundException(username + ": Not Found");
        AppUserDetails appUserDetails = new AppUserDetails();
        appUserDetails.setId(loginUser.getId());
        appUserDetails.setEmail(loginUser.getEmail());
        appUserDetails.setPassword(loginUser.getPassword());
        appUserDetails.setCode(loginUser.getCode());
        appUserDetails.setFirstName(loginUser.getFirstName());
        appUserDetails.setLastName(loginUser.getLastName());
        appUserDetails.setTenantId(loginUser.getTenantId());

        return appUserDetails;
    }

}
