package com.example.ai.controller;

import com.example.ai.domain.tenant.CreateTenant;
import com.example.ai.domain.tenant.Tenant;
import com.example.ai.domain.tenant.TenantService;
import com.example.ai.domain.users.Users;
import com.example.ai.domain.users.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class AuthController {

    @Autowired
    private TenantService tenantService;

    @Autowired
    private UsersService usersService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String singup(Model model) {
        model.addAttribute("form", new CreateTenant());

        return "signup";
    }

    @PostMapping("/signup")
    public String singup(CreateTenant createTenant) {
        Tenant tenant = tenantService.createTenant(createTenant.getName());
        Users users = usersService.createAdminUser(tenant);
        return "redirect:/login";
    }
}
